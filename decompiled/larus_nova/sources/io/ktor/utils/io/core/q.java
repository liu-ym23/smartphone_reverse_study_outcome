package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.UTF8Kt;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes41.dex */
@Deprecated(message = "\n    We're migrating to the new kotlinx-io library.\n    This declaration is deprecated and will be removed in Ktor 4.0.0\n    If you have any problems with migration, please contact us in \n    https://youtrack.jetbrains.com/issue/KTOR-6030/Migrate-to-new-kotlinx.io-library\n    ")
public abstract class q implements Appendable, Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.ktor.utils.io.pool.e<io.ktor.utils.io.core.internal.a> f492044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public io.ktor.utils.io.core.internal.a f492045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public io.ktor.utils.io.core.internal.a f492046c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ByteBuffer f492047d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f492048e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f492049f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f492050g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f492051h;

    public abstract void g();

    public abstract void h(ByteBuffer r100);

    public q() {
        AtomicReferenceFieldUpdater r100 = io.ktor.utils.io.core.internal.a.f492027j;
        this(c.f492026a);
    }

    public final void a() {
        io.ktor.utils.io.core.internal.a r100 = this.f492046c;
        if (r100 == null) goto L6;
        this.f492048e = r100.f492022c;
        return;
    }

    public final int i() {
        return this.f492051h + (this.f492048e - this.f492050g);
    }

    public final io.ktor.utils.io.core.internal.a k() {
        io.ktor.utils.io.core.internal.a r100 = this.f492045b;
        if (r100 != null) goto L5;
        return null;
    L5:
        io.ktor.utils.io.core.internal.a r101 = this.f492046c;
        if (r101 == null) goto L8;
        r101.b(this.f492048e);
    L8:
        this.f492045b = null;
        this.f492046c = null;
        this.f492048e = 0;
        this.f492049f = 0;
        this.f492050g = 0;
        this.f492051h = 0;
        this.f492047d = jsc.c.f500279b;
        return r100;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        io.ktor.utils.io.core.internal.a r100 = k();     // Catch: Throwable -> L14
        if (r100 == null) goto L9;
        io.ktor.utils.io.core.internal.a r101 = r100;
    L18:
        h(r101.f492020a);     // Catch: Throwable -> L11
        r101 = r101.i();     // Catch: Throwable -> L11
        if (r101 != null) goto L18;
        h.b(r100, this.f492044a);     // Catch: Throwable -> L14
        goto L9
    L11:
        th = move-exception;
        h.b(r100, this.f492044a);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L9:
        g();
        return;
    L14:
        th = move-exception;
        g();
        throw th;
    }

    public q(io.ktor.utils.io.pool.e<io.ktor.utils.io.core.internal.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "pool");
        this.f492044a = r100;
        ByteBuffer r101 = jsc.c.f500279b;
        this.f492047d = jsc.c.f500279b;
    }

    @Override // java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(char r100) {
        return b(r100);
    }

    public q b(char r110) {
        int r100 = this.f492048e;
        int r101 = 4;
        boolean r102 = false;
        if ((this.f492049f - r100) < 3) goto L32;
        ByteBuffer r103 = this.f492047d;
        if (r110 < 0) goto L8;
        if (r110 >= 128) goto L8;
        boolean r111 = true;
    L9:
        if (r111 == false) goto L11;
        r103.put(r100, (byte) r110);
        r101 = 1;
    L28:
        this.f492048e = r100 + r101;
        return this;
    L11:
        if (128 > r110) goto L14;
        if (r110 >= 2048) goto L14;
        boolean r112 = true;
    L15:
        if (r112 == false) goto L17;
        r103.put(r100, (byte) (((r110 >> 6) & 31) | 192));
        r103.put(r100 + 1, (byte) ((r110 & '?') | 128));
        r101 = 2;
        goto L28
    L17:
        if (2048 > r110) goto L20;
        if (r110 >= 0) goto L20;
        boolean r104 = true;
    L21:
        if (r104 == false) goto L23;
        r103.put(r100, (byte) (((r110 >> '\f') & 15) | 224));
        r103.put(r100 + 1, (byte) (((r110 >> 6) & 63) | 128));
        r103.put(r100 + 2, (byte) ((r110 & '?') | 128));
        r101 = 3;
        goto L28
    L23:
        if (0 > r110) goto L26;
        if (r110 >= 0) goto L26;
        r102 = true;
    L26:
        if (r102 == false) goto L30;
        r103.put(r100, (byte) (((r110 >> 18) & 7) | 240));
        r103.put(r100 + 1, (byte) (((r110 >> '\f') & 63) | 128));
        r103.put(r100 + 2, (byte) (((r110 >> 6) & 63) | 128));
        r103.put(r100 + 3, (byte) ((r110 & '?') | 128));
        goto L28
    L30:
        UTF8Kt.c(r110);
        throw null;
    L20:
        r104 = false;
    L14:
        r112 = false;
    L8:
        r111 = false;
        goto L9
    L32:
        io.ktor.utils.io.core.internal.a r105 = j(3);
        ByteBuffer r106 = r105.f492020a;     // Catch: Throwable -> L68
        int r113 = r105.f492022c;     // Catch: Throwable -> L68
        if (r110 < 0) goto L37;
        if (r110 >= 128) goto L37;
        boolean r114 = true;
    L38:
        if (r114 == false) goto L40;
        r106.put(r113, (byte) r110);     // Catch: Throwable -> L68
        r101 = 1;
    L58:
        r105.a(r101);     // Catch: Throwable -> L68
        if (r101 < 0) goto L61;
        r102 = true;
    L61:
        if (r102 == false) goto L65;
        a();
        return this;
    L65:
        throw new IllegalStateException("The returned value shouldn't be negative".toString());     // Catch: Throwable -> L68
    L40:
        if (128 > r110) goto L43;
        if (r110 >= 2048) goto L43;
        boolean r115 = true;
    L44:
        if (r115 == false) goto L46;
        r106.put(r113, (byte) (((r110 >> 6) & 31) | 192));     // Catch: Throwable -> L68
        r106.put(r113 + 1, (byte) ((r110 & '?') | 128));     // Catch: Throwable -> L68
        r101 = 2;
        goto L58
    L46:
        if (2048 > r110) goto L49;
        if (r110 >= 0) goto L49;
        boolean r107 = true;
    L50:
        if (r107 == false) goto L52;
        r106.put(r113, (byte) (((r110 >> '\f') & 15) | 224));     // Catch: Throwable -> L68
        r106.put(r113 + 1, (byte) (((r110 >> 6) & 63) | 128));     // Catch: Throwable -> L68
        r106.put(r113 + 2, (byte) ((r110 & '?') | 128));     // Catch: Throwable -> L68
        r101 = 3;
        goto L58
    L52:
        if (0 > r110) goto L55;
        if (r110 >= 0) goto L55;
        boolean r108 = true;
    L56:
        if (r108 == false) goto L66;
        r106.put(r113, (byte) (((r110 >> 18) & 7) | 240));     // Catch: Throwable -> L68
        r106.put(r113 + 1, (byte) (((r110 >> '\f') & 63) | 128));     // Catch: Throwable -> L68
        r106.put(r113 + 2, (byte) (((r110 >> 6) & 63) | 128));     // Catch: Throwable -> L68
        r106.put(r113 + 3, (byte) ((r110 & '?') | 128));     // Catch: Throwable -> L68
        goto L58
    L66:
        UTF8Kt.c(r110);     // Catch: Throwable -> L68
        throw null;     // Catch: Throwable -> L68
    L55:
        r108 = false;
    L49:
        r107 = false;
    L43:
        r115 = false;
    L37:
        r114 = false;
    L68:
        th = move-exception;
        a();
        throw th;
    }

    public q c(CharSequence r100) {
        if (r100 != null) goto L5;
        d("null", 0, 4);
    L6:
        return this;
    L5:
        d(r100, 0, r100.length());
        goto L6
    }

    public final void f(io.ktor.utils.io.core.internal.a r100) {
        Intrinsics.checkNotNullParameter(r100, "buffer");
        if (r100.i() != null) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L10;
        e(r100, r100, 0);
        return;
    L10:
        throw new IllegalStateException("It should be a single buffer chunk.".toString());
    L5:
        r101 = false;
        goto L6
    }

    public final io.ktor.utils.io.core.internal.a j(int r100) {
        int r101 = this.f492049f;
        int r102 = this.f492048e;
        if ((r101 - r102) < r100) goto L8;
        io.ktor.utils.io.core.internal.a r103 = this.f492046c;
        if (r103 == null) goto L8;
        r103.b(r102);
        return r103;
    L8:
        io.ktor.utils.io.core.internal.a r104 = this.f492044a.Q5();
        r104.e();
        f(r104);
        return r104;
    }

    public final void l(byte r100) {
        int r101 = this.f492048e;
        if (r101 >= this.f492049f) goto L6;
        this.f492048e = r101 + 1;
        this.f492047d.put(r101, r100);
        return;
    L6:
        io.ktor.utils.io.core.internal.a r102 = this.f492044a.Q5();
        r102.e();
        f(r102);
        int r103 = r102.f492022c;
        if (r103 == r102.f492024e) goto L11;
        r102.f492020a.put(r103, r100);
        r102.f492022c = r103 + 1;
        this.f492048e++;
        return;
    L11:
        throw new InsufficientSpaceException("No free space in the buffer to write a byte");
    }

    @Override // java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(CharSequence r100) {
        return c(r100);
    }

    @Override // java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(CharSequence r100, int r101, int r102) {
        return d(r100, r101, r102);
    }

    public q d(CharSequence r100, int r101, int r102) {
        if (r100 == null) goto L4;
        v.c(this, r100, r101, r102, Charsets.UTF_8);
        return this;
    L4:
        return d("null", r101, r102);
    }

    public final void e(io.ktor.utils.io.core.internal.a r100, io.ktor.utils.io.core.internal.a r101, int r102) {
        io.ktor.utils.io.core.internal.a r103 = this.f492046c;
        if (r103 != null) goto L5;
        this.f492045b = r100;
        this.f492051h = 0;
    L6:
        this.f492046c = r101;
        this.f492051h += r102;
        this.f492047d = r101.f492020a;
        this.f492048e = r101.f492022c;
        this.f492050g = r101.f492021b;
        this.f492049f = r101.f492024e;
        return;
    L5:
        r103.m(r100);
        int r104 = this.f492048e;
        r103.b(r104);
        this.f492051h += r104 - this.f492050g;
        goto L6
    }
}
