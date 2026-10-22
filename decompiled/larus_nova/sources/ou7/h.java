package ou7;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes23.dex */
public final class h extends d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i f526791g;

    @Override // ou7.d
    public final f c() throws IOException {
        return new m(this.f526791g, this);
    }

    @Override // ou7.d
    public final e b(long r100) throws IOException {
        return new k(this.f526791g, this, r100);
    }

    public h(boolean r100, i r101) throws IOException {
        this.f526779a = r100;
        this.f526791g = r101;
        ByteBuffer r102 = ByteBuffer.allocate(8);
        if (r100 == false) goto L5;
        ByteOrder r103 = ByteOrder.BIG_ENDIAN;
    L6:
        r102.order(r103);
        r101.c(r102, 16);
        r101.b(r102, 32, 8);
        this.f526780b = r102.getLong();
        r101.b(r102, 40, 8);
        this.f526781c = r102.getLong();
        this.f526782d = r101.c(r102, 54);
        this.f526783e = r101.c(r102, 56);
        this.f526784f = r101.c(r102, 58);
        r101.c(r102, 60);
        r101.c(r102, 62);
        return;
    L5:
        r103 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }

    @Override // ou7.d
    public final c a(long r100, int r110) throws IOException {
        return new b(this.f526791g, this, r100, r110);
    }
}
