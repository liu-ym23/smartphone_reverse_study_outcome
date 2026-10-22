package com.huawei.nfc.sdk.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes23.dex */
public class HwOpenPayTask {
    private static final String BANK_OPEN_API_PAY_ACTION = "com.huawei.nfc.action.OPEN_AIDL_API_PAY";
    private static final String TAG = "HwOpenPayTask";
    private static final String WALLET_PACKAGE_NAME = "com.huawei.wallet";
    private boolean haveInitService;
    private ICUPOnlinePayCallBackService hwPayCallBackService;
    private final byte[] lock;
    private WeakReference mContext;
    private ServiceConnection mNfcServiceConnection;
    private ICUPOnlinePayService mOpenService;
    private IHwPayResultCallBack payResultCallBack;
    private IHwResultCallBack resultCallBack;

    public interface IHwPayResultCallBack {
        void onError(String r100, String r101);

        void onResult(Bundle r100);
    }

    public interface IHwResultCallBack {
        void onResult(int r100, Bundle r101);
    }

    class MyServiceConnection implements ServiceConnection {
        final /* synthetic */ HwOpenPayTask this$0;

        private MyServiceConnection(HwOpenPayTask r100) {
            this.this$0 = r100;
        }

        public /* synthetic */ MyServiceConnection(HwOpenPayTask r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r100, IBinder r101) {
            byte[] r102 = HwOpenPayTask.access$400(this.this$0);
            monitor-enter(r102);
            HwOpenPayTask.access$702(this.this$0, ICUPOnlinePayService.Stub.asInterface(r101));     // Catch: Throwable -> L7
            HwOpenPayTask.access$400(this.this$0).notifyAll();     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r100) {
            byte[] r101 = HwOpenPayTask.access$400(this.this$0);
            monitor-enter(r101);
            HwOpenPayTask.access$702(this.this$0, null);     // Catch: Throwable -> L7
            HwOpenPayTask.access$400(this.this$0).notifyAll();     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public interface SupportCapacityResult {
        public static final int CAPACITY_RESULT_NOT_SUPPORT = 0;
        public static final int CAPACITY_RESULT_SUPPORT = 1;
    }

    public HwOpenPayTask(Context r100) {
        this.lock = new byte[0];
        this.mNfcServiceConnection = new MyServiceConnection(this, null);
        this.hwPayCallBackService = new AnonymousClass1(this);
        this.mContext = new WeakReference(r100);
    }

    public static /* synthetic */ IHwPayResultCallBack access$100(HwOpenPayTask r100) {
        return r100.payResultCallBack;
    }

    public static /* synthetic */ IHwPayResultCallBack access$102(HwOpenPayTask r100, IHwPayResultCallBack r101) {
        r100.payResultCallBack = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$200(HwOpenPayTask r100) {
        return r100.haveInitService;
    }

    public static /* synthetic */ void access$300(HwOpenPayTask r100) {
        r100.disConnect();
    }

    public static /* synthetic */ byte[] access$400(HwOpenPayTask r100) {
        return r100.lock;
    }

    public static /* synthetic */ IHwResultCallBack access$502(HwOpenPayTask r100, IHwResultCallBack r101) {
        r100.resultCallBack = r101;
        return r101;
    }

    public static /* synthetic */ void access$600(HwOpenPayTask r100) {
        r100.initNfcService();
    }

    public static /* synthetic */ ICUPOnlinePayService access$700(HwOpenPayTask r100) {
        return r100.mOpenService;
    }

    public static /* synthetic */ ICUPOnlinePayService access$702(HwOpenPayTask r100, ICUPOnlinePayService r101) {
        r100.mOpenService = r101;
        return r101;
    }

    public static /* synthetic */ ICUPOnlinePayCallBackService access$800(HwOpenPayTask r100) {
        return r100.hwPayCallBackService;
    }

    public static /* synthetic */ void access$900(HwOpenPayTask r100) {
        r100.failResult();
    }

    private void disConnect() {
        if (this.haveInitService == true) goto L5;
        return;
    L5:
        this.haveInitService = false;
        this.mOpenService = null;
        WeakReference r100 = this.mContext;
        if (r100 != null) goto L8;
        return;
    L8:
        if (this.mNfcServiceConnection == null) goto L17;
        Context r101 = (Context) r100.get();     // Catch: Exception -> L13
        if (r101 == null) goto L18;
        r101.unbindService(this.mNfcServiceConnection);     // Catch: Exception -> L13
        return;
    L18:
        return;
    L19:
        return;
    }

    private void failResult() {
        IHwResultCallBack r100 = this.resultCallBack;
        if (r100 == null) goto L5;
        r100.onResult(0, new Bundle());
    L5:
        IHwPayResultCallBack r101 = this.payResultCallBack;
        if (r101 == null) goto L8;
        r101.onError("003", "WALLET VERSION LOWER");
    L8:
        disConnect();
    }

    private void initNfcService() {
        byte[] r100 = this.lock;
        monitor-enter(r100);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (this.mOpenService != null) goto L18;
        Intent r101 = new Intent(BANK_OPEN_API_PAY_ACTION);     // Catch: Throwable -> L20
        r101.setPackage(WALLET_PACKAGE_NAME);     // Catch: Throwable -> L20
        WeakReference r102 = this.mContext;     // Catch: Throwable -> L20
        if (r102 == null) goto L11;
        Context r103 = (Context) r102.get();     // Catch: Throwable -> L20
        if (r103 == null) goto L11;
        boolean r104 = r103.bindService(r101, this.mNfcServiceConnection, 1);     // Catch: Throwable -> L20
    L12:
        "---bindService---end:".concat(String.valueOf(r104));     // Catch: Throwable -> L20
        if (r104 == true) goto L15;
    L14:
        failResult();     // Catch: Throwable -> L20
        goto L18
    L15:
        this.haveInitService = true;     // Catch: Throwable -> L20
        if (this.mOpenService != null) goto L18;
        this.lock.wait();     // Catch: Exception -> L23 Throwable -> L20
    L11:
        r104 = false;
    L18:
        monitor-exit(r100);     // Catch: Throwable -> L20
    }

    public void getUnionOnlinePayStatus(final IHwPayResultCallBack r100) {
        Runnable r101 = new AnonymousClass3(this, r100);
        Executors.newCachedThreadPool().execute(r101);
    }

    public void supportCapacity(final String r100, final IHwResultCallBack r101) {
        Runnable r102 = new AnonymousClass2(this, r101, r100);
        Executors.newCachedThreadPool().execute(r102);
    }
}
