package okhttp3;

import java.net.Socket;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public interface Connection {
    @Nullable
    j handshake();

    Protocol protocol();

    Route route();

    Socket socket();
}
