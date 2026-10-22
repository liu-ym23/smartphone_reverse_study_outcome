package com.bytedance.debugrouter.net;

import com.lynx.debugrouter.base.MessageTransceiverStateListener;
import com.lynx.debugrouter.base.NativeMessageTransceiver;
import com.lynx.debugrouter.base.NativeStateListener;

/* JADX INFO: loaded from: classes15.dex */
public class WebSocketNativeClient implements NativeMessageTransceiver, NativeStateListener {
    private static final String TAG = "WebSocketNativeClient";
    private final long mNativeHandle;
    private MessageTransceiverStateListener mStateListener;

    private native boolean nativeConnectWS(long r100, String r101);

    private native long nativeCreateWSClient(long r100, NativeStateListener r101);

    private native void nativeDisconnectWS(long r100);

    private native boolean nativeInitWS(long r100);

    private native void nativeReconnectWS(long r100);

    private native void nativeSend(long r100, String r101);

    private native void nativeWrapAndSend(long r100, String r101, int r102, String r103, int r104, boolean r105);

    @Override // com.lynx.debugrouter.base.MessageTransceiver
    public long queueSize() {
        return 0;
    }

    @Override // com.lynx.debugrouter.base.MessageTransceiver
    public void disconnect() {
        nativeDisconnectWS(this.mNativeHandle);
    }

    public boolean init() {
        return nativeInitWS(this.mNativeHandle);
    }

    @Override // com.lynx.debugrouter.base.NativeStateListener
    public void onClose() {
        MessageTransceiverStateListener r100 = this.mStateListener;
        if (r100 == null) goto L6;
        r100.onClose(this, 0, "");
        return;
    }

    @Override // com.lynx.debugrouter.base.NativeStateListener
    public void onOpen() {
        MessageTransceiverStateListener r100 = this.mStateListener;
        if (r100 == null) goto L6;
        r100.onOpen(this);
        return;
    }

    public WebSocketNativeClient(long r100) {
        this.mNativeHandle = nativeCreateWSClient(r100, this);
    }

    @Override // com.lynx.debugrouter.base.MessageTransceiver
    public boolean connect(String r100) {
        return nativeConnectWS(this.mNativeHandle, r100);
    }

    @Override // com.lynx.debugrouter.base.NativeStateListener
    public void onError(String r100) {
        MessageTransceiverStateListener r101 = this.mStateListener;
        if (r101 == null) goto L6;
        r101.onError(this, new Exception(r100));
        return;
    }

    @Override // com.lynx.debugrouter.base.NativeStateListener
    public void onMessage(String r100) {
        MessageTransceiverStateListener r101 = this.mStateListener;
        if (r101 == null) goto L6;
        r101.onMessage(this, r100);
        return;
    }

    @Override // com.lynx.debugrouter.base.MessageTransceiver
    public void removeStateListener(MessageTransceiverStateListener r100) {
        this.mStateListener = null;
    }

    @Override // com.lynx.debugrouter.base.MessageTransceiver
    public void send(String r100) {
        nativeSend(this.mNativeHandle, r100);
    }

    @Override // com.lynx.debugrouter.base.MessageTransceiver
    public void setStateListener(MessageTransceiverStateListener r100) {
        this.mStateListener = r100;
    }

    @Override // com.lynx.debugrouter.base.NativeMessageTransceiver
    public void wrapAndSend(String r100, int r110, String r111, int r112, boolean r113) {
        nativeWrapAndSend(this.mNativeHandle, r100, r110, r111, r112, r113);
    }
}
