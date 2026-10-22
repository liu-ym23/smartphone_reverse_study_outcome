package am3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends e {
    public final int b;
    public final byte[] c;
    public int d;

    @Override // am3.f
    public final void a() {
        this.d = this.b;
    }

    @Override // am3.f
    public final f b() {
        return new b(this);
    }

    @Override // am3.f
    public final boolean d() {
        if ((this.c.length - this.d) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // am3.f
    public final byte readByte() {
        byte[] r0 = this.c;
        int r1 = this.d;
        this.d = r1 + 1;
        return r0[r1];
    }

    public b(b r2) {
        this.d = 0;
        int r0 = r2.d;
        this.b = r0;
        this.c = r2.c;
        this.d = r0;
    }

    @Override // am3.f
    public final void c(long r3) {
        this.d = (int) (((long) this.d) + r3);
    }

    @Override // am3.f
    public final byte[] readByteArray(long r4) {
        int r5 = (int) r4;
        byte[] r6 = new byte[r5];
        System.arraycopy(this.c, this.d, r6, 0, r5);
        this.d += r5;
        return r6;
    }

    @Override // am3.f
    public final String readUtf8(long r6) {
        String r0 = new String(this.c, this.d, (int) r6, e.a);
        this.d = (int) (((long) this.d) + r6);
        return r0;
    }

    @Override // am3.f
    public final void skip(long r3) {
        this.d = (int) (((long) this.d) + r3);
    }

    public b(byte[] r2) {
        this.d = 0;
        this.b = -1;
        this.c = r2;
    }
}
