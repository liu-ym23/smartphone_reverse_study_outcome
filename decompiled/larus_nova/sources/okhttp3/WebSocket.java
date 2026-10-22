package okhttp3;

import javax.annotation.Nullable;
import okio.ByteString;

/* JADX INFO: loaded from: classes6.dex */
public interface WebSocket {
    void cancel();

    boolean close(int r100, @Nullable String r101);

    long queueSize();

    Request request();

    boolean send(String r100);

    boolean send(ByteString r100);
}
