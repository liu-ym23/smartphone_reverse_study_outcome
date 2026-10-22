package okhttp3;

import javax.annotation.Nullable;
import okio.ByteString;

/* JADX INFO: loaded from: classes6.dex */
public abstract class WebSocketListener {
    public WebSocketListener() {
    }

    public void onClosed(WebSocket r100, int r101, String r102) {
    }

    public void onClosing(WebSocket r100, int r101, String r102) {
    }

    public void onFailure(WebSocket r100, Throwable r101, @Nullable Response r102) {
    }

    public void onMessage(WebSocket r100, String r101) {
    }

    public void onMessage(WebSocket r100, ByteString r101) {
    }

    public void onOpen(WebSocket r100, Response r101) {
    }
}
