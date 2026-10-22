package com.lynx.debugrouter;

import android.app.Application;
import com.lynx.debugrouter.base.UIThreadUtils;
import com.lynx.debugrouter.log.LLog;

/* JADX INFO: loaded from: classes32.dex */
public class DebugRouterStateListener implements StateListener {
    private static final String TAG = "DebugRouterStateListener";
    private long mStartTime;

    @Override // com.lynx.debugrouter.StateListener
    public void onClose(int r100, String r101) {
    }

    @Override // com.lynx.debugrouter.StateListener
    public void onError(String r100) {
    }

    @Override // com.lynx.debugrouter.StateListener
    public void onMessage(String r100) {
    }

    public DebugRouterStateListener() {
        this.mStartTime = -1;
    }

    @Override // com.lynx.debugrouter.StateListener
    public void onOpen(ConnectionType r100) {
        LLog.i(TAG, "onOpen: " + r100);
        this.mStartTime = System.nanoTime();
    }

    private void toastUser(int r100, Throwable r101, boolean r102) {
        if (r102 == true) goto L5;
        return;
    L5:
        if (r100 == 0) goto L8;
        LLog.i(TAG, "only toast in first connection when error occurs");
        return;
    L8:
        if (r101 != null) goto L11;
        LLog.w(TAG, "toastUser: t == null");
        return;
    L11:
        final Application r103 = Utils.getApplicationContext();
        if (r103 != null) goto L14;
        return;
    L14:
        String r104 = r101.getMessage();
        if (r104 != null) goto L17;
    L22:
        if (r104 != null) goto L24;
        return;
    L24:
        if (r104.contains("WebSocket opening handshake timed out") == false) goto L26;
    L27:
        UIThreadUtils.runOnUiThreadImmediately(new AnonymousClass2(this, r103));
        return;
    L26:
        if (r104.contains("java.net.SocketTimeoutException") == true) goto L27;
        return;
    L17:
        if (r104.contains("ERR_INTERNET_DISCONNECTED") == false) goto L19;
    L20:
        UIThreadUtils.runOnUiThreadImmediately(new AnonymousClass1(this, r103));
        return;
    L19:
        if (r104.contains("java.net.ConnectException") == false) goto L22;
        goto L20
    }
}
