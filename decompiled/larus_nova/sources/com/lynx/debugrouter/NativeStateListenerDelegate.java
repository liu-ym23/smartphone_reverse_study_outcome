package com.lynx.debugrouter;

import com.lynx.debugrouter.log.LLog;

/* JADX INFO: loaded from: classes32.dex */
public class NativeStateListenerDelegate {
    private static final String TAG = "NativeStateListenerDelegate";
    private StateListener listener;

    public NativeStateListenerDelegate(StateListener r100) {
        this.listener = r100;
    }

    public void onError(String r100) {
        StateListener r101 = this.listener;
        if (r101 == null) goto L6;
        r101.onError(r100);
        return;
    }

    public void onMessage(String r100) {
        StateListener r101 = this.listener;
        if (r101 == null) goto L6;
        r101.onMessage(r100);
        return;
    }

    public void onOpen(String r100) {
        if (this.listener == null) goto L12;
        r100.getClass();
        if (r100.equals("websocket") == false) goto L7;
        this.listener.onOpen(ConnectionType.WebSocket);
        return;
    L7:
        if (r100.equals("usb") == true) goto L9;
        LLog.e(TAG, "unknown type: ".concat(r100));
        return;
    L9:
        this.listener.onOpen(ConnectionType.USB);
        return;
    }

    public void onClose(int r100, String r101) {
        StateListener r102 = this.listener;
        if (r102 == null) goto L6;
        r102.onClose(r100, r101);
        return;
    }
}
