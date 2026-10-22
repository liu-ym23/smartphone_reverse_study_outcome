package com.bytedance.forest.model;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class HeapBufferMeta extends com.bytedance.forest.model.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f244249d = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a.C3495a f244250c;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.forest.model.HeapBufferMeta$a$a, reason: collision with other inner class name */
        public static final class C3495a extends ByteArrayOutputStream {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public com.bytedance.forest.utils.e f244251a;

            public final void a() {
                int r100 = ((ByteArrayOutputStream) this).buf.length;
                int r101 = ((ByteArrayOutputStream) this).count;
                if (r101 <= r100) goto L6;
                com.bytedance.forest.utils.c r102 = this.f244251a.f244543g;
                int r103 = HeapBufferMeta.f244249d;
                com.bytedance.forest.utils.c.a(r102, 6, "HeapBufferMeta", "unexpected count is larger than the size of buf, count=" + ((ByteArrayOutputStream) this).count + ", bufSize=" + r100, true, null, null, 48);
                return;
            L6:
                if (r101 >= r100) goto L9;
                com.bytedance.forest.utils.c r104 = this.f244251a.f244543g;
                int r105 = HeapBufferMeta.f244249d;
                com.bytedance.forest.utils.c.a(r104, 3, "HeapBufferMeta", "trim buf from " + r100 + " to " + ((ByteArrayOutputStream) this).count, true, null, null, 48);
                ((ByteArrayOutputStream) this).buf = Arrays.copyOf(((ByteArrayOutputStream) this).buf, ((ByteArrayOutputStream) this).count);
                return;
            }

            public final byte[] b() {
                return ((ByteArrayOutputStream) this).buf;
            }

            public final int c() {
                return ((ByteArrayOutputStream) this).count;
            }

            public final com.bytedance.forest.utils.e getContext() {
                return this.f244251a;
            }

            public C3495a(int r100, com.bytedance.forest.utils.e r101) {
                super(r100);
                this.f244251a = r101;
            }

            public final void d(int r110, byte[] r111, int r112, int r113) {
                if (r110 < 0) goto L13;
                if ((r112 + r113) > r111.length) goto L11;
                if (r110 < ((ByteArrayOutputStream) this).buf.length) goto L8;
                com.bytedance.forest.utils.c r100 = this.f244251a.f244543g;
                int r101 = HeapBufferMeta.f244249d;
                com.bytedance.forest.utils.c.a(r100, 6, "HeapBufferMeta", "startPos " + r110 + " larger than cached data size, count=" + ((ByteArrayOutputStream) this).count + ", buf size=" + ((ByteArrayOutputStream) this).buf.length, false, null, null, 48);
            L8:
                ((ByteArrayOutputStream) this).count = r110;
                write(r111, r112, r113);
                return;
            L11:
                throw new IllegalArgumentException("can not copy bytes from " + r112 + " to " + r113 + ", input bytearray size is " + r111.length);
            L13:
                throw new IllegalArgumentException("startPos less than zero");
            }
        }
    }

    static {
    }

    @Override // com.bytedance.forest.model.a
    public final void b() {
        this.f244250c = null;
    }

    @Override // com.bytedance.forest.model.a
    public final void c() {
        a.C3495a r100 = this.f244250c;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    @Override // com.bytedance.forest.model.a
    public final boolean d() {
        if (this.f244250c == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.forest.model.a
    public final byte[] e() {
        a.C3495a r100 = this.f244250c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.b();
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("HeapBufferMeta(buffer_size=");
        a.C3495a r101 = this.f244250c;
        Integer r102 = null;
        if (r101 == null) goto L7;
        byte[] r103 = r101.b();
        if (r103 == null) goto L7;
        Integer r104 = Integer.valueOf(r103.length);
    L8:
        r100.append(r104);
        r100.append(", buffer_pos=");
        a.C3495a r105 = this.f244250c;
        if (r105 == null) goto L11;
        r102 = Integer.valueOf(r105.c());
    L11:
        r100.append(r102);
        r100.append(')');
        return r100.toString();
    L7:
        r104 = null;
        goto L8
    }

    @Override // com.bytedance.forest.model.a
    public com.bytedance.forest.utils.e getContext() {
        return super.getContext();
    }

    @Override // com.bytedance.forest.model.a
    public final void g(com.bytedance.forest.utils.e r100) {
        a.C3495a r101 = this.f244250c;
        if (r101 == null) goto L6;
        r101.f244251a = r100;
        return;
    }

    public HeapBufferMeta(int r100, com.bytedance.forest.utils.e r101) {
        super(r100, r101);
        this.f244250c = new a.C3495a(r100, getContext());
    }

    @Override // com.bytedance.forest.model.a
    public final void a(int r100, byte[] r101, int r102, int r103) {
        if (this.f244250c != null) goto L5;
        this.f244250c = new a.C3495a(this.f244328b, getContext());
    L5:
        a.C3495a r104 = this.f244250c;
        if (r104 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        r104.d(r100, r101, r102, r103);
    }

    @Override // com.bytedance.forest.model.a
    public final void f(int r100, byte[] r101, int r102, int r103) {
        a.C3495a r104 = this.f244250c;
        if (r104 == null) goto L6;
        System.arraycopy(r104.b(), r100, r101, r102, r103);
        return;
    }
}
