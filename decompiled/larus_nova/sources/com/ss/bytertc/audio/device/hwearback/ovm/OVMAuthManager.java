package com.ss.bytertc.audio.device.hwearback.ovm;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.realx.base.RXLogging;
import com.ss.bytertc.audio.device.base.ManufacturerChecker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class OVMAuthManager extends Handler {
    private static final int OPEN_DELAY_TIME = 200;
    private static final String TAG = "OVMAuthManager";
    private static final Uri authUri = null;
    private static volatile OVMAuthManager sInstance;
    private List<AuthCallback> listenerList;
    private Messenger mAuthMessenger;
    private int mAuthResultCode;
    private Runnable notifyResultRunnable;

    public interface AuthCallback {
        void onResult(int r100);
    }

    public static class CommonStatusCodes {
        public static final int APP_DISABLE_EXCEPTION = 1011;
        public static final int AUTHCODE_EXPECTED = 1004;
        public static final int AUTHCODE_INVALID = 1007;
        public static final int AUTHCODE_NOT_INIT = -2;
        public static final int AUTHCODE_NOT_SUPPORT = -3;
        public static final int AUTHCODE_NO_PERMISSION = -1;
        public static final int AUTHCODE_RECYCLE = 1006;
        public static final int AUTHENTICATE_FAIL = 1002;
        public static final int AUTHENTICATE_SUCCESS = 1001;
        public static final int CAPABILITY_EXCEPTION = 1008;
        public static final int INTERNAL_EXCEPTION = 1010;
        public static final int STATUS_EXCEPTION = 1009;
        public static final int TIME_EXPIRED = 1003;
        public static final int VERSION_INCOMPATIBLE = 1005;

        public CommonStatusCodes() {
        }
    }

    public static /* synthetic */ void a(OVMAuthManager r100) {
        r100.lambda$new$0();
    }

    private /* synthetic */ void lambda$new$0() {
        monitor-enter(this);
        ArrayList r100 = new ArrayList(this.listenerList);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        Iterator r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((AuthCallback) r101.next()).onResult(this.mAuthResultCode);
        goto L7
    L9:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    static {
        authUri = UriProtector.parse("content://com.oplus.ocs.out.OpenCapabilityThirdProvider/oplus");
    }

    public static OVMAuthManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(OVMAuthManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new OVMAuthManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(OVMAuthManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void notifyResult() {
        if (this.mAuthResultCode == (-2)) goto L6;
        removeCallbacks(this.notifyResultRunnable);
        postDelayed(this.notifyResultRunnable, 200);
        return;
    }

    private OVMAuthManager() {
        super(Looper.getMainLooper());
        this.mAuthResultCode = -2;
        this.mAuthMessenger = new Messenger(this);
        this.listenerList = new ArrayList();
        this.notifyResultRunnable = new a(this);
    }

    public synchronized void addCallback(AuthCallback r100) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.listenerList.contains(r100) == true) goto L6;
        this.listenerList.add(r100);     // Catch: Throwable -> L9
    L6:
        notifyResult();     // Catch: Throwable -> L9
        monitor-exit(this);
    }

    @Override // android.os.Handler
    public void handleMessage(Message r100) {
        super.handleMessage(r100);
        monitor-enter(this);
        Bundle r101 = r100.getData();     // Catch: Throwable -> L12
        if (r101 != null) goto L9;
        RXLogging.e(TAG, "handleMessage get bundle is null");     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L9:
        this.mAuthResultCode = r101.getInt("result_code");     // Catch: Throwable -> L12
        notifyResult();     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public synchronized void removeCallback(AuthCallback r100) {
        monitor-enter(this);
        this.listenerList.remove(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void startAuth(Context r100, String r101) {
        if (ManufacturerChecker.getManufacturerType() != ManufacturerChecker.Type.OP) goto L10;
        Bundle r102 = new Bundle();
        r102.putBinder("callback", this.mAuthMessenger.getBinder());
        this.mAuthResultCode = -2;
        r100.getContentResolver().call(authUri, "auth", r101, r102);     // Catch: RuntimeException -> L7 IllegalArgumentException -> L9
    L16:
        return;
    L9:
        RXLogging.i(TAG, "url is not exist, do not need auth ");
        this.mAuthResultCode = -3;
        notifyResult();
        return;
    L7:
        e = move-exception;
        RXLogging.e(TAG, "auth error " + e.toString());
        this.mAuthResultCode = -1;
        notifyResult();
        return;
    L10:
        RXLogging.e(TAG, "no need to auth");
        this.mAuthResultCode = 1001;
        notifyResult();
    }
}
