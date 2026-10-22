package com.bytedance.bdlocation.scan.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.thread.ThreadLooperManager;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class BluetoothInfoManager {
    private final String TAG;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothScanCallback mBluetoothCallback;
    private volatile BluetoothLeScanner mBluetoothLeScanner;
    private List<BDBleInfo> mBluetoothList;
    private BroadcastReceiver mBluetoothReceiver;
    private Object mBpeaCert;
    private Context mContext;
    private Handler mHandler;
    private volatile boolean mIsRegisterReceiver;
    private BluetoothAdapter.LeScanCallback mLeScanCallback;
    private ScanCallback mScanCallback;
    private int mScanMode;
    private Handler mTimerHandler;

    /* JADX INFO: renamed from: com.bytedance.bdlocation.scan.bluetooth.BluetoothInfoManager$1, reason: invalid class name */
    public class AnonymousClass1 extends ScanCallback {
        final /* synthetic */ BluetoothInfoManager this$0;

        public static /* synthetic */ void a(AnonymousClass1 r0, ScanResult r1) {
            r0.lambda$onScanResult$0(r1);
        }

        public AnonymousClass1(BluetoothInfoManager r1) {
            this.this$0 = r1;
        }

        private /* synthetic */ void lambda$onScanResult$0(ScanResult r5) {
            BluetoothDevice r0 = r5.getDevice();     // Catch: Exception -> L15
            String r1 = BDLocationExtrasService.getBPEAManager().getAddress(r0, BluetoothInfoManager.access$100(this.this$0));     // Catch: Exception -> L15
            BDBleInfo r2 = new BDBleInfo();     // Catch: Exception -> L15
            r2.rssi = r5.getRssi();     // Catch: Exception -> L15
            if (BDLocationConfig.enableBlePassiveName() == false) goto L8;
            ScanRecord r3 = r5.getScanRecord();     // Catch: Exception -> L15
            if (r3 == null) goto L7;
            String r4 = r3.getDeviceName();     // Catch: Exception -> L15
        L9:
            if (r4 == null) goto L11;
            r2.bleName = r4;     // Catch: Exception -> L15
        L11:
            r2.bleMac = r1;     // Catch: Exception -> L15
            r2.timeStamp = System.currentTimeMillis();     // Catch: Exception -> L15
            BluetoothInfoManager.optimizeBeaconData(r2, r5);     // Catch: Exception -> L15
            BluetoothInfoManager.access$200(this.this$0, r2);     // Catch: Exception -> L15
            if (BluetoothInfoManager.access$300(this.this$0) == null) goto L20;
            BluetoothInfoManager.access$300(this.this$0).onScan(r2);     // Catch: Exception -> L15
            return;
        L20:
            return;
        L7:
            r4 = null;
            goto L9
        L8:
            r4 = r0.getName();     // Catch: Exception -> L15
        L15:
            e = move-exception;
            Logger.i("BDShakeCollectManager", "startLeScan onScanResult error:" + e.getMessage());
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onBatchScanResults(List<ScanResult> r1) {
            super.onBatchScanResults(r1);
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int r3) {
            super.onScanFailed(r3);
            Logger.i("BDShakeCollectManager", "startLeScan onScanFailed errorCode:" + r3);
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int r2, final ScanResult r3) {
            super.onScanResult(r2, r3);
            BluetoothInfoManager.access$000(this.this$0).post(new e(this, r3));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.bdlocation.scan.bluetooth.BluetoothInfoManager$2, reason: invalid class name */
    public class AnonymousClass2 implements BluetoothAdapter.LeScanCallback {
        final /* synthetic */ BluetoothInfoManager this$0;

        public static /* synthetic */ void a(AnonymousClass2 r0, BluetoothDevice r1, int r2) {
            r0.lambda$onLeScan$0(r1, r2);
        }

        public AnonymousClass2(BluetoothInfoManager r1) {
            this.this$0 = r1;
        }

        private /* synthetic */ void lambda$onLeScan$0(BluetoothDevice r3, int r4) {
            Logger.d("BDShakeCollectManager", "onLeScan onScanResult");     // Catch: Exception -> L5
            BluetoothInfoManager.access$400(this.this$0, r3, r4);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            Logger.i("BDShakeCollectManager", "startLeScan onLeScan error:" + e.getMessage());
        }

        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(final BluetoothDevice r2, final int r3, byte[] r4) {
            BluetoothInfoManager.access$000(this.this$0).post(new f(this, r2, r3));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.bdlocation.scan.bluetooth.BluetoothInfoManager$3, reason: invalid class name */
    public class AnonymousClass3 extends BroadcastReceiver {
        final /* synthetic */ BluetoothInfoManager this$0;

        public static /* synthetic */ void a(AnonymousClass3 r0, Intent r1) {
            r0.lambda$onReceive$0(r1);
        }

        public AnonymousClass3(BluetoothInfoManager r1) {
            this.this$0 = r1;
        }

        private /* synthetic */ void lambda$onReceive$0(Intent r4) {
            BluetoothDevice r0 = (BluetoothDevice) r4.getParcelableExtra("android.bluetooth.device.extra.DEVICE");     // Catch: Exception -> L4
            short r5 = r4.getShortExtra("android.bluetooth.device.extra.RSSI", Short.MIN_VALUE);     // Catch: Exception -> L4
            BluetoothInfoManager.access$400(this.this$0, r0, r5);     // Catch: Exception -> L4
            return;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r2, final Intent r3) {
            String r4 = r3.getAction();
            if ("android.bluetooth.device.action.FOUND".equals(r4) == false) goto L6;
            Logger.d("BluetoothAdapter BluetoothAdapter.ACTION_FOUND");
            BluetoothInfoManager.access$000(this.this$0).post(new g(this, r3));
            return;
        L6:
            if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(r4) == false) goto L10;
            Logger.d("BluetoothAdapter BluetoothAdapter.ACTION_DISCOVERY_FINISHED");
            return;
        }
    }

    public interface BluetoothScanCallback {
        void onError();

        void onScan(BDBleInfo r1);

        void onSuccess(List<BDBleInfo> r1);
    }

    public static /* synthetic */ void a(BluetoothInfoManager r0) {
        r0.lambda$null$2();
    }

    public static /* synthetic */ void b(BluetoothInfoManager r0) {
        r0.lambda$null$1();
    }

    public static /* synthetic */ void c(BluetoothInfoManager r0, long r1, Object r3) {
        r0.lambda$null$0(r1, r3);
    }

    public static /* synthetic */ void d(BluetoothInfoManager r0, Object r1, BluetoothScanCallback r2, long r3, long r5) {
        r0.lambda$startScan$3(r1, r2, r3, r5);
    }

    private void initScanCallback() {
        this.mScanCallback = new AnonymousClass1(this);
    }

    private /* synthetic */ void lambda$null$1() {
        BluetoothScanCallback r0 = this.mBluetoothCallback;
        if (r0 == null) goto L6;
        r0.onSuccess(this.mBluetoothList);
        return;
    }

    private void stopBleScan() {
        Logger.i("stopBleScan BLE扫描结束------------------");     // Catch: Exception -> L11
        if (this.mBluetoothLeScanner != null) goto L5;
    L7:
        BluetoothAdapter.LeScanCallback r0 = this.mLeScanCallback;     // Catch: Exception -> L11
        if (r0 == null) goto L16;
        INVOKEVIRTUAL_com_bytedance_bdlocation_scan_bluetooth_BluetoothInfoManager_com_obric_performance_power_monitor_bluetooth_BluetoothLancet_stopLeScan(this.mBluetoothAdapter, r0);     // Catch: Exception -> L11
        return;
    L16:
        return;
    L5:
        if (this.mScanCallback == null) goto L7;
        INVOKEVIRTUAL_com_bytedance_bdlocation_scan_bluetooth_BluetoothInfoManager_com_obric_performance_power_monitor_bluetooth_BluetoothLancet_stopScan(this.mBluetoothLeScanner, this.mScanCallback);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        Logger.i("stopBleScan error:" + e.getMessage());
    }

    private void stopBlueScan() {
    L6:
        e = move-exception;
        Logger.i("stopBlueScan error:" + e.getMessage());
        return;
    L3:
        if (this.mBluetoothAdapter.isDiscovering() == false) goto L11;
        Logger.i("stopBlueScan Blue扫描结束------------------");     // Catch: Exception -> L6
        this.mBluetoothAdapter.cancelDiscovery();     // Catch: Exception -> L6
        return;
    }

    public boolean blueToothIsEnabled() {
        return this.mBluetoothAdapter.isEnabled();
    L4:
        e = move-exception;
        Logger.i("blueToothIsEnabled error" + e.getMessage());
        return false;
    }

    public synchronized void stopScan() {
        monitor-enter(this);
        this.mTimerHandler.removeCallbacksAndMessages(null);     // Catch: Throwable -> L8 Exception -> L10
        stopBlueScan();     // Catch: Throwable -> L8 Exception -> L10
        stopBleScan();     // Catch: Throwable -> L8 Exception -> L10
        this.mBluetoothCallback = null;     // Catch: Throwable -> L8 Exception -> L10
        if (this.mIsRegisterReceiver == false) goto L12;
        unRegisterScanReceiver(this.mContext);     // Catch: Throwable -> L8 Exception -> L10
        this.mIsRegisterReceiver = false;     // Catch: Throwable -> L8 Exception -> L10
    L12:
        monitor-exit(this);
        return;
    L10:
        e = move-exception;
        Logger.i("BDShakeCollectManager", "stopBlueScan error" + e.getMessage());     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$null$2() {
        stopBlueScan();
        if (BDLocationConfig.enableBleTruncateOnTimeout() == false) goto L5;
        this.mHandler.removeCallbacksAndMessages(null);
    L5:
        this.mHandler.post(new a(this));
    }

    public List<BDBleInfo> getBlueToothList() {
        return this.mBluetoothList;
    }

    public BluetoothInfoManager(Context r2) {
        this.TAG = "BDShakeCollectManager";
        this.mScanMode = 2;
        this.mIsRegisterReceiver = false;
        this.mBpeaCert = null;
        this.mBluetoothReceiver = new AnonymousClass3(this);
        this.mContext = r2;
        this.mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        this.mBluetoothList = new ArrayList();
        this.mHandler = new Handler(ThreadLooperManager.getBleScanWorker());
        this.mTimerHandler = new Handler(ThreadLooperManager.getBleTimerWorker());
        initScanCallback();
    }

    public static /* synthetic */ Handler access$000(BluetoothInfoManager r0) {
        return r0.mHandler;
    }

    public static /* synthetic */ Object access$100(BluetoothInfoManager r0) {
        return r0.mBpeaCert;
    }

    public static /* synthetic */ BluetoothScanCallback access$300(BluetoothInfoManager r0) {
        return r0.mBluetoothCallback;
    }

    private void addList(BDBleInfo r3) {
        List<BDBleInfo> r0 = this.mBluetoothList;     // Catch: Exception -> L11
        if (r0 == null) goto L10;
        if (r3 != null) goto L7;
        return;
    L7:
        if (r0.contains(r3) == true) goto L17;
        this.mBluetoothList.add(r3);     // Catch: Exception -> L11
        return;
    L17:
        return;
    L10:
        return;
    L11:
        e = move-exception;
        Logger.i("addList error" + e.getMessage());
    }

    private void registerScanReceiver(Context r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (this.mBluetoothReceiver != null) goto L6;
        return;
    L6:
        if (this.mIsRegisterReceiver == true) goto L12;
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.bluetooth.device.action.FOUND");
        r0.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        INVOKEVIRTUAL_com_bytedance_bdlocation_scan_bluetooth_BluetoothInfoManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r3, this.mBluetoothReceiver, r0);
        this.mIsRegisterReceiver = true;
        return;
    }

    private void startBleScan(Object r9) {
        if (this.mBluetoothAdapter.isEnabled() == true) goto L16;
        Logger.i("未开启蓝牙");
        return;
    L16:
    L13:
        e = move-exception;
        Logger.i("BDShakeCollectManager", "startBleCollect error" + e.getMessage());
        return;
    L7:
        if (LocationUtil.checkBackground() == false) goto L9;
        return;
    L9:
        ScanSettings r5 = new ScanSettings.Builder().setScanMode(this.mScanMode).build();     // Catch: Exception -> L13
        this.mBluetoothLeScanner = this.mBluetoothAdapter.getBluetoothLeScanner();     // Catch: Exception -> L13
        if (this.mScanCallback == null) goto L18;
        INVOKEVIRTUAL_com_bytedance_bdlocation_scan_bluetooth_BluetoothInfoManager_com_obric_performance_power_monitor_bluetooth_BluetoothLancet_stopScan(this.mBluetoothLeScanner, this.mScanCallback);     // Catch: Exception -> L13
        Logger.i("BDShakeCollectManager", "startLeScan bluetoothStartScan:");     // Catch: Exception -> L13
        BDLocationExtrasService.getBPEAManager().bluetoothStartScan(this.mBluetoothLeScanner, null, r5, this.mScanCallback, r9);     // Catch: Exception -> L13
        return;
    }

    private void startBlueScan(Object r3) {
    L14:
        Logger.i("startBlueCollect error");
        return;
    L3:
        if (LocationUtil.checkBackground() == false) goto L6;
        return;
    L6:
        if (this.mBluetoothAdapter.isEnabled() == true) goto L10;
        Logger.i("未开启蓝牙");     // Catch: Exception -> L14
        return;
    L10:
        if (this.mBluetoothAdapter.isDiscovering() == false) goto L12;
        this.mBluetoothAdapter.cancelDiscovery();     // Catch: Exception -> L14
    L12:
        BDLocationExtrasService.getBPEAManager().startDiscovery(this.mBluetoothAdapter, r3);     // Catch: Exception -> L14
        Logger.i("BluetoothAdapterstartNormalBlueCollect");     // Catch: Exception -> L14
    }

    private void unRegisterScanReceiver(Context r2) {
        if (this.mIsRegisterReceiver == false) goto L10;
        if (r2 == null) goto L8;
        BroadcastReceiver r0 = this.mBluetoothReceiver;
        if (r0 == null) goto L8;
        INVOKEVIRTUAL_com_bytedance_bdlocation_scan_bluetooth_BluetoothInfoManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(r2, r0);
    L8:
        this.mIsRegisterReceiver = false;
        return;
    }

    public void setScanMode(int r1) {
        this.mScanMode = r1;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void INVOKEVIRTUAL_com_bytedance_bdlocation_scan_bluetooth_BluetoothInfoManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context r1, BroadcastReceiver r2) {
        ReceiverRegisterLancet.loge(r2, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L14;
        r1.unregisterReceiver(r2);
        return;
    L14:
    L8:
        e = move-exception;
        if (r2 == null) goto L11;
        Npth.addTag("unregisterReceiver", r2.toString());
    L11:
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r2, r1) == false) goto L16;
        r1.unregisterReceiver(r2);     // Catch: Exception -> L8
        return;
    }

    public static void INVOKEVIRTUAL_com_bytedance_bdlocation_scan_bluetooth_BluetoothInfoManager_com_obric_performance_power_monitor_bluetooth_BluetoothLancet_stopLeScan(BluetoothAdapter r1, BluetoothAdapter.LeScanCallback r2) {
        if (fna.g.d() == true) goto L6;
        r1.stopLeScan(r2);
        return;
    L6:
        r1.stopLeScan(r2);
        if (r2 == null) goto L9;
        int r3 = r2.hashCode();
    L10:
        ina.a.c(r3);
        return;
    L9:
        r3 = 0;
        goto L10
    }

    public static void INVOKEVIRTUAL_com_bytedance_bdlocation_scan_bluetooth_BluetoothInfoManager_com_obric_performance_power_monitor_bluetooth_BluetoothLancet_stopScan(BluetoothLeScanner r1, ScanCallback r2) {
        if (fna.g.d() == true) goto L6;
        r1.stopScan(r2);
        return;
    L6:
        r1.stopScan(r2);
        if (r2 == null) goto L9;
        int r3 = r2.hashCode();
    L10:
        ina.a.c(r3);
        return;
    L9:
        r3 = 0;
        goto L10
    }

    public static /* synthetic */ void access$200(BluetoothInfoManager r0, BDBleInfo r1) {
        r0.addList(r1);
    }

    private /* synthetic */ void lambda$null$0(long r4, Object r6) {
        stopBleScan();
        if (r4 <= 0) goto L6;
        registerScanReceiver(this.mContext);
        this.mIsRegisterReceiver = true;
        startBlueScan(r6);
        return;
    }

    public static void optimizeBeaconData(BDBleInfo r6, ScanResult r7) {
        if (r7 != null) goto L4;
    L16:
        Logger.i("optimizeBeaconData error");
        return;
    L4:
        if (r7.getScanRecord() == null) goto L16;
        r6.rawData = BluetoothUtil.Bytes2HexString(r7.getScanRecord().getBytes());
        byte[] r8 = r7.getScanRecord().getManufacturerSpecificData(76);
        if (r8 != null) goto L9;
        return;
    L9:
        if (r8.length >= 23) goto L11;
        return;
    L11:
        if (r8[0] != 2) goto L20;
        String r2 = BluetoothUtil.Bytes2HexString(Arrays.copyOfRange(r8, 2, 18));
        if (TextUtils.isEmpty(r2) == true) goto L21;
        String r0 = (((((((r2.substring(0, 8) + "-") + r2.substring(8, 12)) + "-") + r2.substring(12, 16)) + "-") + r2.substring(16, 20)) + "-") + r2.substring(20, 32);
        int r1 = BluetoothUtil.byteToInt(r8[18], r8[19]);
        int r9 = BluetoothUtil.byteToInt(r8[20], r8[21]);
        r6.isBeacon = true;
        r6.major = r1;
        r6.minor = r9;
        r6.beaconUuid = r0;
        return;
    L21:
        return;
    }

    private void setDeviceData(BluetoothDevice r4, int r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        BDBleInfo r0 = new BDBleInfo();
        String r1 = BDLocationExtrasService.getBPEAManager().getAddress(r4, this.mBpeaCert);
        if (BDLocationConfig.enableBlePassiveName() == true) goto L9;
        String r6 = r4.getName();
        if (r6 == null) goto L9;
        r0.bleName = r6;
    L9:
        r0.bleMac = r1;
        r0.rssi = r5;
        r0.timeStamp = System.currentTimeMillis();
        addList(r0);
        BluetoothScanCallback r7 = this.mBluetoothCallback;
        if (r7 == null) goto L13;
        r7.onScan(r0);
        return;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_bytedance_bdlocation_scan_bluetooth_BluetoothInfoManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r8, BroadcastReceiver r9, IntentFilter r10) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r10 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8);     // Catch: Exception -> L36
        int r1 = r0.result;     // Catch: Exception -> L36
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L21;
        if (r1 == 3) goto L19;
        return r8.registerReceiver(r9, r10);
    L19:
        return r0.intent;
    L21:
        return new Intent();
    L23:
        return r8.registerReceiver(r9, r10);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r8.registerReceiver(r9, r10);
    }

    public static /* synthetic */ void access$400(BluetoothInfoManager r0, BluetoothDevice r1, int r2) {
        r0.setDeviceData(r1, r2);
    }

    private /* synthetic */ void lambda$startScan$3(final Object r4, BluetoothScanCallback r5, long r6, final long r8) {
        this.mBpeaCert = r4;     // Catch: Exception -> L20
        if (LocationUtil.checkBackground() == false) goto L7;
        r5.onError();     // Catch: Exception -> L20
        return;
    L7:
        if (this.mBluetoothAdapter.isEnabled() == true) goto L10;
        Logger.i("未开启蓝牙");     // Catch: Exception -> L20
        r5.onError();     // Catch: Exception -> L20
        return;
    L10:
        this.mBluetoothCallback = r5;     // Catch: Exception -> L20
        List<BDBleInfo> r0 = this.mBluetoothList;     // Catch: Exception -> L20
        if (r0 == null) goto L16;
        if (r0.size() <= 0) goto L16;
        this.mBluetoothList.clear();     // Catch: Exception -> L20
    L16:
        if (r6 <= 0) goto L18;
        startBleScan(r4);     // Catch: Exception -> L20
    L18:
        this.mTimerHandler.postDelayed(new c(this, r8, r4), r6);     // Catch: Exception -> L20
        this.mTimerHandler.postDelayed(new d(this), r8 + r6);     // Catch: Exception -> L20
        return;
    L20:
        e = move-exception;
        Logger.i("startScan error" + e.getMessage());
        stopScan();
        r5.onError();
    }

    public synchronized void startScan(final BluetoothScanCallback r12, final long r13, final long r15, final Object r17) {
        monitor-enter(this);
        this.mHandler.removeCallbacksAndMessages(null);     // Catch: Throwable -> L7
        this.mTimerHandler.removeCallbacksAndMessages(null);     // Catch: Throwable -> L7
        this.mHandler.post(new b(this, r17, r12, r15, r13));     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
