package ou7;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes23.dex */
public final class g extends d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i f526790g;

    @Override // ou7.d
    public final f c() throws IOException {
        return new l(this.f526790g, this);
    }

    @Override // ou7.d
    public final e b(long r100) throws IOException {
        return new j(this.f526790g, this, r100);
    }

    public g(boolean r100, i r101) throws IOException {
        this.f526779a = r100;
        this.f526790g = r101;
        ByteBuffer r102 = ByteBuffer.allocate(4);
        if (r100 == false) goto L5;
        ByteOrder r103 = ByteOrder.BIG_ENDIAN;
    L6:
        r102.order(r103);
        r101.c(r102, 16);
        this.f526780b = r101.d(r102, 28);
        this.f526781c = r101.d(r102, 32);
        this.f526782d = r101.c(r102, 42);
        this.f526783e = r101.c(r102, 44);
        this.f526784f = r101.c(r102, 46);
        r101.c(r102, 48);
        r101.c(r102, 50);
        return;
    L5:
        r103 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }

    @Override // ou7.d
    public final c a(long r100, int r110) throws IOException {
        return new a(this.f526790g, this, r100, r110);
    }
}
