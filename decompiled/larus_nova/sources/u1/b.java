package u1;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Build;
import com.bes.bessdk.BesSdkConstants;
import com.bes.bessdk.service.base.BesServiceConfig;
import com.bes.sdk.device.HmDevice;
import com.bes.sdk.message.BaseMessage;
import com.bes.sdk.utils.DeviceProtocol;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.bduploader.BDVideoUploaderBase;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: loaded from: classes39.dex */
public final class b implements z1.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile b f548213e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Context f548214f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static List<BesServiceConfig> f548215g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static List<BluetoothGatt> f548216h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static List<BluetoothGattCharacteristic> f548217i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static List<UUID> f548218j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static List<HmDevice> f548219k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static List<z1.a.InterfaceC8408a> f548220l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static List<byte[]> f548221m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f548222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f548223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Thread f548224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f548225d;

    public class a extends BluetoothGattCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f548226a;

        /* JADX INFO: renamed from: u1.b$a$a, reason: collision with other inner class name */
        public class RunnableC7817a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ BluetoothGatt f548227a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f548228b;

            public final void a() {
                Thread.sleep(10000);     // Catch: InterruptedException -> L7
                b r100 = this.f548228b.f548226a;     // Catch: InterruptedException -> L7
                if (r100.f548223b == true) goto L12;
                r100.p(this.f548227a.getDevice(), false);     // Catch: InterruptedException -> L7
                this.f548228b.f548226a.d(this.f548227a.getDevice());     // Catch: InterruptedException -> L7
                return;
            L12:
                return;
            L7:
                e = move-exception;
                throw new RuntimeException(e);
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC7817a(a r100, BluetoothGatt r101) {
                this.f548228b = r100;
                this.f548227a = r101;
            }
        }

        public a(b r100) {
            this.f548226a = r100;
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public final void onCharacteristicChanged(BluetoothGatt r100, BluetoothGattCharacteristic r101) {
            super.onCharacteristicChanged(r100, r101);
            b r102 = this.f548226a;
            r102.b(r102.f548222a, "onCharacteristicChanged: -----" + y1.a.k(r101.getValue()));
            b r103 = this.f548226a;
            byte[] r104 = r101.getValue();
            BluetoothDevice r105 = r100.getDevice();
            r103.b(r103.f548222a, "notifyReceive: ------" + r105.getAddress());
            BaseMessage r106 = new BaseMessage();
            r106.setPush(true);
            r106.setMsgContent(r104);
            z1.a.InterfaceC8408a r107 = r103.k(r105);
            if (r107 == null) goto L6;
            r107.a(r106);
            return;
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public final void onServicesDiscovered(BluetoothGatt r110, int r111) {
            super.onServicesDiscovered(r110, r111);
            b r100 = this.f548226a;
            boolean r101 = true;
            r100.f548223b = true;
            r100.b(r100.f548222a, "onServicesDiscovered status: -----" + r111);
            boolean r102 = false;
            if (Build.VERSION.SDK_INT >= 26) goto L5;
        L7:
            BesServiceConfig r103 = this.f548226a.l(r110.getDevice());
            if (r111 != 0) goto L29;
            b r112 = this.f548226a;
            UUID r104 = r103.getServiceUUID();
            if (r103.getCharacteristicsTX() != null) goto L12;
            UUID r105 = r103.getCharacteristicsUUID();
        L13:
            BluetoothDevice r106 = r110.getDevice();
            r112.b(r112.f548222a, "setWriteCharacteristic service----- " + r104.toString() + "; characteristic " + r105.toString());
            BluetoothGatt r107 = r112.h(r106);
            if (r107 == null) goto L21;
            BluetoothGattService r108 = r107.getService(r104);
            if (r108 == null) goto L21;
            BluetoothGattCharacteristic r109 = r108.getCharacteristic(r105);
            if (r109 == null) goto L21;
            y1.a.a(b.f548217i, r109, r112.j(r106));
        L23:
            if (r101 == false) goto L29;
            b r113 = this.f548226a;
            BluetoothDevice r114 = r110.getDevice();
            r113.b(r113.f548222a, "requestMtu");
            BluetoothGatt r115 = r113.h(r114);
            if (r115 == null) goto L27;
            r102 = r115.requestMtu(512);
        L27:
            if (r102 == true) goto L31;
            b.c(this.f548226a, r103.getServiceUUID(), r103.getCharacteristicsUUID(), r103.getDescriptorUUID(), r110.getDevice());
            return;
        L31:
            return;
        L21:
            r101 = false;
            goto L23
        L12:
            r105 = r103.getCharacteristicsTX();
        L29:
            this.f548226a.p(r110.getDevice(), false);
            this.f548226a.d(r110.getDevice());
            return;
        L5:
            if (v1.a.a(b.f548214f).isLe2MPhySupported() == false) goto L7;
            r110.setPreferredPhy(2, 2, 0);
            goto L7
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public final void onCharacteristicWrite(BluetoothGatt r100, BluetoothGattCharacteristic r101, int r102) {
            super.onCharacteristicWrite(r100, r101, r102);
            if (this.f548226a.k(r100.getDevice()) == null) goto L10;
            z1.a.InterfaceC8408a r103 = this.f548226a.k(r100.getDevice());
            if (r102 != 0) goto L7;
            int r104 = 667;
        L8:
            r103.b(r104);
            return;
        L7:
            r104 = BDVideoUploaderBase.KeyIsVideoMetaData;
            goto L8
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public final void onConnectionStateChange(BluetoothGatt r100, int r101, int r102) {
            super.onConnectionStateChange(r100, r101, r102);
            y1.a.a(b.f548216h, r100, this.f548226a.j(r100.getDevice()));
            b r103 = this.f548226a;
            r103.b(r103.f548222a, "onConnectionStateChange: --------------" + r100.getDevice().getAddress());
            b r104 = this.f548226a;
            r104.b(r104.f548222a, "onConnectionStateChange status-----" + r101);
            b r105 = this.f548226a;
            r105.b(r105.f548222a, "onConnectionStateChange newState-----" + r102);
            if (Build.VERSION.SDK_INT >= 26) goto L5;
        L7:
            b r106 = this.f548226a;
            r106.b(r106.f548222a, "onConnectionStateChange: -----" + r101);
            this.f548226a.f548223b = false;
            if (r101 != 0) goto L16;
            if (r102 != 2) goto L16;
            if (r100.discoverServices() == false) goto L16;
            if (((Boolean) y1.d.a(b.f548214f, "BES_BLE_OTA_AUTO_TEST", Boolean.FALSE)).booleanValue() == true) goto L15;
            return;
        L15:
            this.f548226a.f548224c = new PthreadThreadV2(new RunnableC7817a(this, r100), "leConnector$1");
            ThreadMethodProxy.start(this.f548226a.f548224c);
            return;
        L16:
            this.f548226a.p(r100.getDevice(), false);
            this.f548226a.d(r100.getDevice());
            return;
        L5:
            if (v1.a.a(b.f548214f).isLe2MPhySupported() == false) goto L7;
            r100.setPreferredPhy(2, 2, 0);
            goto L7
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public final void onDescriptorWrite(BluetoothGatt r100, BluetoothGattDescriptor r101, int r102) {
            super.onDescriptorWrite(r100, r101, r102);
            b r103 = this.f548226a;
            r103.b(r103.f548222a, "onDescriptorWrite: -----" + r100.getDevice().getAddress());
            if (r101.getUuid().equals(this.f548226a.l(r100.getDevice()).getDescriptorUUID()) == false) goto L7;
            if (r102 != 0) goto L7;
            this.f548226a.p(r100.getDevice(), true);
            return;
        L7:
            b r104 = this.f548226a;
            r104.b(r104.f548222a, "onDescriptorWrite wrong: -----" + r102);
            this.f548226a.p(r100.getDevice(), false);
            this.f548226a.d(r100.getDevice());
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public final void onMtuChanged(BluetoothGatt r100, int r101, int r102) {
            super.onMtuChanged(r100, r101, r102);
            b r103 = this.f548226a;
            r103.b(r103.f548222a, "onMtuChanged: -----" + r101 + " status:" + r102);
            b r104 = this.f548226a;
            if (b.c(r104, r104.l(r100.getDevice()).getServiceUUID(), this.f548226a.l(r100.getDevice()).getCharacteristicsUUID(), this.f548226a.l(r100.getDevice()).getDescriptorUUID(), r100.getDevice()) == false) goto L7;
            if (r102 != 0) goto L8;
            this.f548226a.getClass();
            return;
        L8:
            return;
        }
    }

    public b() {
        this.f548222a = b.class.getSimpleName();
        this.f548223b = false;
        this.f548225d = new a(this);
    }

    @Override // z1.a
    public final void a(HmDevice r100) {
        b(this.f548222a, "disconnect: -------");
        d(g(r100));
        p(g(r100), false);
    }

    public final void d(BluetoothDevice r100) {
        b(this.f548222a, "close: ----" + r100.getAddress());
        BluetoothGatt r101 = h(r100);
        if (r101 == null) goto L6;
        r101.disconnect();
        r101.close();
    L6:
        if (((Boolean) y1.d.a(f548214f, "BES_BLE_OTA_AUTO_TEST", Boolean.FALSE)).booleanValue() == false) goto L12;
        z1.a.InterfaceC8408a r102 = k(r100);
        if (r102 == null) goto L10;
        i(r100);
        DeviceProtocol r103 = DeviceProtocol.PROTOCOL_UNKNOWN;
        r102.onStatusChanged(444);
    L10:
        f548215g = new ArrayList();
        f548220l = new ArrayList();
        f548216h = new ArrayList();
        f548217i = new ArrayList();
        f548218j = new ArrayList();
        f548219k = new ArrayList();
        f548221m = new ArrayList();
        return;
    L12:
        y1.a.g(f548215g, j(r100));
        y1.a.g(f548216h, j(r100));
        y1.a.g(f548217i, j(r100));
        y1.a.g(f548218j, j(r100));
        z1.a.InterfaceC8408a r104 = k(r100);
        if (r104 == null) goto L16;
        i(r100);
        DeviceProtocol r105 = DeviceProtocol.PROTOCOL_UNKNOWN;
        r104.onStatusChanged(444);
        return;
    }

    public final BluetoothGattCharacteristic f(BluetoothDevice r100) {
        if (f548217i.size() >= j(r100)) goto L7;
        return null;
    L7:
        return (BluetoothGattCharacteristic) ListProtector.get(f548217i, j(r100));
    }

    public final BluetoothDevice g(HmDevice r100) {
        if (r100.getPreferredProtocol() != DeviceProtocol.PROTOCOL_BLE) goto L5;
        String r101 = r100.getBleAddress();
    L7:
        return v1.a.a(f548214f).getRemoteDevice(r101);
    L5:
        r101 = r100.getDeviceMAC();
        goto L7
    }

    public final BluetoothGatt h(BluetoothDevice r100) {
        if (f548216h.size() >= j(r100)) goto L7;
        return null;
    L7:
        return (BluetoothGatt) ListProtector.get(f548216h, j(r100));
    }

    public final HmDevice i(BluetoothDevice r100) {
        if (f548219k.size() >= j(r100)) goto L7;
        return null;
    L7:
        return (HmDevice) ListProtector.get(f548219k, j(r100));
    }

    public final int j(BluetoothDevice r100) {
        int r101 = 0;
    L4:
        if (r101 >= f548219k.size()) goto L13;
        HmDevice r102 = (HmDevice) ListProtector.get(f548219k, r101);
        if (r102.getPreferredProtocol() != DeviceProtocol.PROTOCOL_BLE) goto L8;
        String r103 = r102.getBleAddress();
    L10:
        if (r103.equals(r100.getAddress()) == true) goto L11;
        r101 = r101 + 1;
        goto L4
    L11:
        return r101;
    L8:
        r103 = r102.getDeviceMAC();
        goto L10
    L13:
        return 10000;
    }

    public final z1.a.InterfaceC8408a k(BluetoothDevice r100) {
        if (f548220l.size() >= j(r100)) goto L7;
        return null;
    L7:
        return (z1.a.InterfaceC8408a) ListProtector.get(f548220l, j(r100));
    }

    public final BesServiceConfig l(BluetoothDevice r100) {
    L8:
        return null;
    L4:
        if (f548215g.size() >= j(r100)) goto L6;
        return null;
    L6:
        return (BesServiceConfig) ListProtector.get(f548215g, j(r100));
    }

    public final BesSdkConstants.BesConnectState m(BesServiceConfig r100) {
        if (r100.getDevice() == null) goto L39;
        if (r100.getServiceUUID() == null) goto L39;
        if (r100.getCharacteristicsUUID() == null) goto L39;
        if (r100.getDescriptorUUID() == null) goto L39;
        BluetoothDevice r101 = g(r100.getDevice());
        BesServiceConfig r102 = l(r101);
        if (o(r100) == true) goto L37;
        if (f(r101) == null) goto L37;
        if (r102 == null) goto L37;
        if (r102.getTotaConnect().booleanValue() == false) goto L24;
        if (((ArrayList) f548221m).size() >= j(r101)) goto L21;
        byte[] r103 = null;
    L22:
        if (r103 == null) goto L37;
    L21:
        r103 = (byte[]) ListProtector.get(f548221m, j(r101));
    L24:
        if (r100.getServiceUUID().toString().equals(r102.getServiceUUID().toString()) == false) goto L32;
        if (r100.getCharacteristicsUUID().toString().equals(r102.getCharacteristicsUUID().toString()) == false) goto L32;
        if (r100.getDescriptorUUID().toString().equals(r102.getDescriptorUUID().toString()) == false) goto L32;
        return BesSdkConstants.BesConnectState.BES_CONNECT;
    L32:
        if (r102.getTotaConnect().booleanValue() == false) goto L35;
        return BesSdkConstants.BesConnectState.BES_CONNECT_TOTA;
    L35:
        return BesSdkConstants.BesConnectState.BES_CONNECT_NOTOTA;
    L37:
        return BesSdkConstants.BesConnectState.BES_NO_CONNECT;
    L39:
        return BesSdkConstants.BesConnectState.BES_CONFIG_ERROR;
    }

    public final boolean o(BesServiceConfig r100) {
        HmDevice r101 = r100.getDevice();
        int r102 = 0;
    L4:
        if (r102 >= f548219k.size()) goto L20;
        HmDevice r103 = (HmDevice) ListProtector.get(f548219k, r102);
        if (r100.getDeviceProtocol() != DeviceProtocol.PROTOCOL_BLE) goto L13;
        if (r101.getBleAddress() == null) goto L13;
        if (r101.getBleAddress().equals(r103.getBleAddress()) == false) goto L13;
        return false;
    L13:
        if (r100.getDeviceProtocol() != DeviceProtocol.PROTOCOL_GATT_BR_EDR) goto L19;
        if (r101.getDeviceMAC() == null) goto L19;
        if (r101.getDeviceMAC().equals(r103.getDeviceMAC()) == false) goto L19;
        return false;
    L19:
        r102 = r102 + 1;
        goto L4
    L20:
        return true;
    }

    public static b n(Context r100, BesServiceConfig r101) {
        if (f548213e == null) goto L5;
    L14:
        if (r100 == null) goto L16;
        f548214f = r100;
    L16:
        if (r101 != null) goto L18;
    L22:
        if (r101 == null) goto L25;
        y1.a.a(f548215g, r101, f548213e.j(f548213e.g(r101.getDevice())));
    L25:
        return f548213e;
    L18:
        if (r101.getDevice() == null) goto L22;
        if (f548213e.o(r101) == false) goto L22;
        List<HmDevice> r102 = f548219k;
        ArrayList r103 = (ArrayList) r102;
        r103.add(r101.getDevice());
        ((ArrayList) f548215g).add(r101);
        ((ArrayList) f548216h).add(null);
        ((ArrayList) f548220l).add(null);
        ((ArrayList) f548217i).add(null);
        ((ArrayList) f548218j).add(null);
        ((ArrayList) f548221m).add(null);
        goto L22
    L5:
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f548213e != null) goto L9;
        f548213e = new b();     // Catch: Throwable -> L11
        f548215g = new ArrayList();     // Catch: Throwable -> L11
        f548220l = new ArrayList();     // Catch: Throwable -> L11
        f548216h = new ArrayList();     // Catch: Throwable -> L11
        f548217i = new ArrayList();     // Catch: Throwable -> L11
        f548218j = new ArrayList();     // Catch: Throwable -> L11
        f548219k = new ArrayList();     // Catch: Throwable -> L11
        f548221m = new ArrayList();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
        goto L14
    }

    public final void b(String r100, String r101) {
        if (f548214f != null) goto L6;
        return;
    }

    public final void e(HmDevice r110, z1.a.InterfaceC8408a r111) {
        if (r110 == null) goto L25;
        if (r111 != null) goto L5;
        return;
    L5:
        if (f548214f == null) goto L27;
        BluetoothDevice r100 = g(r110);
        if (r110.getPreferredProtocol() != DeviceProtocol.PROTOCOL_GATT_BR_EDR) goto L10;
        BluetoothGatt r112 = r100.connectGatt(f548214f, true, this.f548225d, 1);
    L23:
        y1.a.a(f548216h, r112, j(r100));
        y1.a.a(f548220l, r111, j(r100));
        return;
    L10:
        boolean r113 = ((Boolean) y1.d.a(f548214f, "BES_USE_NORMAL_CONNECT", Boolean.FALSE)).booleanValue();
        boolean r101 = ((Boolean) y1.d.a(f548214f, "BES_USE_PHY_2M", Boolean.TRUE)).booleanValue();
        if (r113 == false) goto L13;
        b(this.f548222a, "startConnect: ------useNormalConnect-NO_MASK");
        r112 = r100.connectGatt(f548214f, false, this.f548225d);
        goto L23
    L13:
        int r114 = Build.VERSION.SDK_INT;
        if (r114 >= 26) goto L16;
    L19:
        b(this.f548222a, "startConnect: -------PHY_LE_1M_MASK");
        if (r114 < 23) goto L22;
        r112 = r100.connectGatt(f548214f, false, this.f548225d, 2);
        goto L23
    L22:
        b(this.f548222a, "startConnect: -------NO_MASK");
        r112 = r100.connectGatt(f548214f, false, this.f548225d);
        goto L23
    L16:
        if (v1.a.a(f548214f).isLe2MPhySupported() == false) goto L19;
        if (r101 == false) goto L19;
        r112 = r100.connectGatt(f548214f, false, this.f548225d, 2, 2, null);
        r112.setPreferredPhy(2, 2, 0);
        goto L23
    L27:
        return;
    }

    public final void p(BluetoothDevice r100, boolean r101) {
        b(this.f548222a, "onStatusChanged---" + r100 + "---" + r101);
        z1.a.InterfaceC8408a r102 = k(r100);
        if (r102 == null) goto L9;
        i(r100);
        if (r101 == false) goto L7;
        int r103 = 666;
    L8:
        DeviceProtocol r104 = DeviceProtocol.PROTOCOL_UNKNOWN;
        r102.onStatusChanged(r103);
        goto L9
    L7:
        r103 = 444;
    L9:
        if (r101 == true) goto L12;
        d(r100);
        return;
    }

    public final boolean q(byte[] r100, BluetoothDevice r101) {
        b(this.f548222a, "write: ------" + y1.a.k(r100));
        b(this.f548222a, "write: ------" + r101.getAddress());
        BluetoothGatt r102 = h(r101);
        BluetoothGattCharacteristic r103 = f(r101);
        if (r102 == null) goto L7;
        if (r103 == null) goto L9;
        r103.setValue(r100);
        boolean r104 = r102.writeCharacteristic(r103);
        b(this.f548222a, "write: ---------" + r101.getAddress() + "-----" + r104);
        return r104;
    L9:
        return false;
    L7:
        return false;
    }

    public final boolean r(byte[] r100, BluetoothDevice r101) {
        b(this.f548222a, "write: ------" + y1.a.k(r100));
        BluetoothGatt r102 = h(r101);
        BluetoothGattCharacteristic r103 = f(r101);
        if (r102 == null) goto L7;
        if (r103 == null) goto L9;
        r103.setWriteType(1);
        r103.setValue(r100);
        boolean r104 = r102.writeCharacteristic(r103);
        b(this.f548222a, "write: ---------" + r101.getAddress() + "-----" + r104);
        return r104;
    L9:
        return false;
    L7:
        return false;
    }

    public static boolean c(b r100, UUID r101, UUID r102, UUID r103, BluetoothDevice r104) {
        BluetoothGatt r105 = r100.h(r104);
        if (r105 == null) goto L32;
        BluetoothGattService r106 = r105.getService(r101);
        if (r106 == null) goto L34;
        BluetoothGattCharacteristic r107 = r106.getCharacteristic(r102);
        if (r107 != null) goto L11;
        return false;
    L11:
        if ((r107.getProperties() & 16) != 0) goto L13;
        r100.p(r105.getDevice(), true);
        return true;
    L13:
        BluetoothGattDescriptor r108 = r107.getDescriptor(r103);
        Objects.toString(r108);
        if (r108 != null) goto L17;
        return false;
    L17:
        if (r105.setCharacteristicNotification(r107, true) == true) goto L20;
        return false;
    L20:
        if (r108.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE) == true) goto L28;
        r100.b(r100.f548222a, "gattDescriptor.ENABLE fail: --------");
        Thread.sleep(3000);     // Catch: InterruptedException -> L25
        if (r108.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE) == true) goto L28;
        return false;
    L25:
        e = move-exception;
        throw new RuntimeException(e);
    L28:
        y1.a.a(f548218j, r103, r100.j(r104));
        return r105.writeDescriptor(r108);
    L34:
        return false;
    L32:
        return false;
    }
}
