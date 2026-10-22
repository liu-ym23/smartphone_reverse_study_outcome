package lk4;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ByteOrder f509562e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f509563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f509564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ByteOrder f509565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f509566d;

    /* JADX INFO: renamed from: lk4.a$a, reason: collision with other inner class name */
    public static class C6703a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f509567a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f509568b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ByteOrder f509569c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f509570d;

        public C6703a() {
            this.f509569c = a.f509562e;
            this.f509570d = 1;
        }
    }

    static {
        f509562e = ByteOrder.BIG_ENDIAN;
    }

    public final byte[] a() {
        byte[] r100 = this.f509564b;
        if (r100 != null) goto L6;
        r100 = new byte[0];
    L6:
        int r101 = r100.length;
        ByteBuffer r102 = ByteBuffer.allocate((this.f509566d + 1) + r101);
        r102.order(this.f509565c);
        r102.put((byte) (this.f509563a & 127));
        int r103 = this.f509566d;
        if (r103 != 1) goto L14;
        if (r101 > 255) goto L12;
        r102.put((byte) r101);
    L21:
        r102.put(r100);
        return r102.array();
    L12:
        throw new IllegalStateException("Value length " + r101 + " exceeds 1 byte limit (255)");
    L14:
        if (r103 == 2) goto L16;
        r102.putInt(r101);
        goto L21
    L16:
        if (r101 > 65535) goto L19;
        r102.putShort((short) r101);
        goto L21
    L19:
        throw new IllegalStateException("Value length " + r101 + " exceeds 2 byte limit (65535)");
    }

    public int getType() {
        return this.f509563a;
    }

    public a(C6703a r100) {
        this.f509563a = r100.f509567a;
        this.f509564b = r100.f509568b;
        this.f509565c = r100.f509569c;
        this.f509566d = r100.f509570d;
    }
}
