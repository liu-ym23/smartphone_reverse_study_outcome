package llc;

import com.ss.ugc.effectplatform.bridge.network.ByteReadStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public final class e implements ByteReadStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f509820a;

    @Override // com.ss.ugc.effectplatform.bridge.network.ByteReadStream
    public final boolean available() {
        if (this.f509820a.available() < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.ugc.effectplatform.bridge.network.ByteReadStream
    public final void close() {
        this.f509820a.close();
    }

    @Override // com.ss.ugc.effectplatform.bridge.network.ByteReadStream
    public final int read() {
        return this.f509820a.read();
    }

    public e(c.a r100) {
        this.f509820a = r100;
    }

    @Override // com.ss.ugc.effectplatform.bridge.network.ByteReadStream
    public final int read(byte[] r100, int r101, int r102) {
        return this.f509820a.read(r100, r101, r102);
    }
}
