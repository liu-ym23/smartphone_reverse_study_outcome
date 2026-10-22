package ivc;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes42.dex */
public final class a extends ProxySelector {
    @Override // java.net.ProxySelector
    public final void connectFailed(URI r100, SocketAddress r101, IOException r102) {
    }

    public a() {
    }

    @Override // java.net.ProxySelector
    public final List<Proxy> select(URI r100) {
        if (r100 == null) goto L6;
        return Collections.singletonList(Proxy.NO_PROXY);
    L6:
        throw new IllegalArgumentException("uri must not be null");
    }
}
