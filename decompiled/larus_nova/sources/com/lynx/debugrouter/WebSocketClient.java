package com.lynx.debugrouter;

import android.text.TextUtils;
import com.lynx.debugrouter.base.MessageTransceiver;
import com.lynx.debugrouter.base.MessageTransceiverStateListener;
import com.lynx.debugrouter.log.LLog;
import com.ss.bduploader.UploadKeys;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

/* JADX INFO: loaded from: classes32.dex */
public class WebSocketClient extends WebSocketListener implements MessageTransceiver {
    private static final int MAX_LOG_LENGTH = 10240;
    private static final String TAG = "WebSocketClient";
    private OkHttpClient mClient;
    private MessageTransceiverStateListener mStateListener;
    private volatile WebSocket mWebSocket;

    @Override // com.lynx.debugrouter.base.MessageTransceiver
    public void disconnect() {
        if (this.mWebSocket == null) goto L6;
        this.mWebSocket.close(1000, null);
        this.mWebSocket = null;
        return;
    }

    @Override // com.lynx.debugrouter.base.MessageTransceiver
    public long queueSize() {
        if (this.mWebSocket != null) goto L7;
        return 0;
    L7:
        return this.mWebSocket.queueSize();
    }

    public WebSocketClient() {
        OkHttpClient.Builder r100 = new OkHttpClient.Builder();
        TimeUnit r101 = TimeUnit.SECONDS;
        this.mClient = r100.pingInterval(5, r101).connectTimeout(5, r101).readTimeout(30, r101).writeTimeout(30, r101).build();
    }

    @Override // com.lynx.debugrouter.base.MessageTransceiver
    public boolean connect(String r100) {
        LLog.d(TAG, "connect " + r100);
        String r101 = "";
        int r102 = 80;
        URI r103 = new URI(r100);     // Catch: URISyntaxException -> L12
        r101 = r103.getHost();     // Catch: URISyntaxException -> L12
        int r104 = r103.getPort();     // Catch: URISyntaxException -> L12
        if (r104 == (-1)) goto L19;
    L15:
        this.mWebSocket = this.mClient.newWebSocket(new Request.Builder().url(r100).addHeader("Upgrade", "WebSocket").addHeader("Connection", "Upgrade").addHeader("Sec-WebSocket-Key", "J4axdrB5EVmab8YnJ4z3bw==").addHeader("Sec-WebSocket-Version", "13").addHeader("Host", r101 + ":" + r104).build(), this);
        return true;
    L19:
        if (TextUtils.equals(r103.getScheme().toLowerCase(Locale.US), "wss") == false) goto L9;
        r102 = UploadKeys.KeyIsGetVideoMeta;
    L9:
        r104 = r102;
    L10:
        URISyntaxException e100 = e;
    L14:
        e100.printStackTrace();
    L12:
        e = move-exception;
        e100 = e;
        r104 = 80;
        goto L14
    }

    @Override // com.lynx.debugrouter.base.MessageTransceiver
    public void removeStateListener(MessageTransceiverStateListener r100) {
        this.mStateListener = null;
    }

    @Override // com.lynx.debugrouter.base.MessageTransceiver
    public void send(String r100) {
        if (this.mWebSocket == null) goto L15;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.length() >= 10240) goto L8;
        LLog.d(TAG, "send: ".concat(r100));
    L13:
        this.mWebSocket.send(r100);
        return;
    L8:
        int r101 = r100.indexOf(",");
        StringBuilder r102 = new StringBuilder("send: ");
        if (r101 > 0) goto L12;
        r101 = 200;
    L12:
        r102.append(r100.substring(0, r101));
        r102.append("...");
        LLog.d(TAG, r102.toString());
        goto L13
    }

    @Override // com.lynx.debugrouter.base.MessageTransceiver
    public void setStateListener(MessageTransceiverStateListener r100) {
        this.mStateListener = r100;
    }

    @Override // okhttp3.WebSocketListener
    public void onMessage(WebSocket r100, String r101) {
        super.onMessage(r100, r101);
        if (r101.length() >= 10240) goto L5;
        LLog.d(TAG, "onMessage: ".concat(r101));
    L10:
        MessageTransceiverStateListener r102 = this.mStateListener;
        if (r102 == null) goto L14;
        r102.onMessage(this, r101);
        return;
    L14:
        return;
    L5:
        int r103 = r101.indexOf(",");
        StringBuilder r104 = new StringBuilder("onMessage: ");
        if (r103 > 0) goto L9;
        r103 = 200;
    L9:
        r104.append(r101.substring(0, r103));
        r104.append("...");
        LLog.d(TAG, r104.toString());
        goto L10
    }

    @Override // okhttp3.WebSocketListener
    public void onOpen(WebSocket r100, Response r101) {
        super.onOpen(r100, r101);
        LLog.i(TAG, "onOpen");
        MessageTransceiverStateListener r102 = this.mStateListener;
        if (r102 == null) goto L6;
        r102.onOpen(this);
        return;
    }

    @Override // okhttp3.WebSocketListener
    public void onMessage(WebSocket r100, ByteString r101) {
        super.onMessage(r100, r101);
    }

    @Override // okhttp3.WebSocketListener
    public void onClosed(WebSocket r100, int r101, String r102) {
        super.onClosed(r100, r101, r102);
        LLog.i(TAG, "onClosed, code: " + r101 + ", reason: " + r102);
        MessageTransceiverStateListener r103 = this.mStateListener;
        if (r103 == null) goto L6;
        r103.onClose(this, r101, r102);
        return;
    }

    @Override // okhttp3.WebSocketListener
    public void onClosing(WebSocket r100, int r101, String r102) {
        super.onClosing(r100, r101, r102);
        LLog.i(TAG, "onClosing");
    }

    @Override // okhttp3.WebSocketListener
    public void onFailure(WebSocket r100, Throwable r101, Response r102) {
        super.onFailure(r100, r101, r102);
        LLog.i(TAG, "onError: " + r101.toString());
        MessageTransceiverStateListener r103 = this.mStateListener;
        if (r103 == null) goto L6;
        r103.onError(this, r101);
        return;
    }
}
