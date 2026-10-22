package okhttp3.internal.connection;

import java.io.IOException;
import okio.BufferedSink;
import okio.BufferedSource;

/* JADX INFO: loaded from: classes42.dex */
public final class c extends kvc.a.f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ StreamAllocation f523881d;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        StreamAllocation r100 = this.f523881d;
        r100.streamFinished(true, r100.codec(), -1, null);
    }

    public c(BufferedSource r100, BufferedSink r101, StreamAllocation r102) {
        this.f523881d = r102;
        super(r100, r101);
    }
}
