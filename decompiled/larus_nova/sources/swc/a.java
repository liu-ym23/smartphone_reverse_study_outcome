package swc;

import java.io.IOException;
import java.net.ServerSocket;

/* JADX INFO: loaded from: classes42.dex */
public final class a implements vwc.b<ServerSocket, IOException> {
    public a() {
    }

    @Override // vwc.b
    public final ServerSocket create() throws Throwable {
        return new ServerSocket();
    }
}
