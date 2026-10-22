package io.ktor.utils.io.core;

import java.nio.ByteBuffer;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes41.dex */
@Deprecated(message = "\n    We're migrating to the new kotlinx-io library.\n    This declaration is deprecated and will be removed in Ktor 4.0.0\n    If you have any problems with migration, please contact us in \n    https://youtrack.jetbrains.com/issue/KTOR-6030/Migrate-to-new-kotlinx.io-library\n    ")
public class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f492019g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuffer f492020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f492021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f492022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f492023d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f492024e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f492025f;

    /* JADX INFO: renamed from: io.ktor.utils.io.core.a$a, reason: collision with other inner class name */
    public static final class C6312a {
    }

    static {
    }

    public final void e() {
        int r100 = this.f492025f - 8;
        int r101 = this.f492022c;
        if (r100 < r101) goto L7;
        this.f492024e = r100;
        return;
    L7:
        if (r100 >= 0) goto L9;
        Intrinsics.checkNotNullParameter(this, "<this>");
        throw new IllegalArgumentException("End gap 8 is too big: capacity is " + this.f492025f);
    L9:
        if (r100 >= this.f492023d) goto L11;
        Intrinsics.checkNotNullParameter(this, "<this>");
        throw new IllegalArgumentException("End gap 8 is too big: there are already " + this.f492023d + " bytes reserved in the beginning");
    L11:
        if (this.f492021b != r101) goto L14;
        this.f492024e = r100;
        this.f492021b = r100;
        this.f492022c = r100;
        return;
    L14:
        Intrinsics.checkNotNullParameter(this, "<this>");
        throw new IllegalArgumentException("Unable to reserve end gap 8: there are already " + (this.f492022c - this.f492021b) + " content bytes at offset " + this.f492021b);
    }

    public final String toString() {
        return "Buffer[0x" + Integer.toString(hashCode(), CharsKt.checkRadix(16)) + "](" + (this.f492022c - this.f492021b) + " used, " + (this.f492024e - this.f492022c) + " free, " + (this.f492023d + (this.f492025f - this.f492024e)) + " reserved of " + this.f492025f + ')';
    }

    public a(ByteBuffer r100) {
        Intrinsics.checkNotNullParameter(r100, "memory");
        this.f492020a = r100;
        this.f492024e = r100.limit();
        this.f492025f = r100.limit();
    }

    public final void a(int r100) {
        int r101 = this.f492022c;
        int r102 = r101 + r100;
        if (r100 >= 0) goto L5;
    L8:
        d.a(r100, this.f492024e - r101);
        throw null;
    L5:
        if (r102 > this.f492024e) goto L8;
        this.f492022c = r102;
    }

    public final void b(int r100) {
        int r101 = this.f492024e;
        int r102 = this.f492022c;
        if (r100 < r102) goto L12;
        if (r100 < r101) goto L10;
        if (r100 != r101) goto L8;
        this.f492022c = r100;
        return;
    L8:
        d.a(r100 - r102, r101 - r102);
        throw null;
    L10:
        this.f492022c = r100;
        return;
    L12:
        d.a(r100 - r102, r101 - r102);
        throw null;
    }

    public final void c(int r100) {
        if (r100 != 0) goto L4;
        return;
    L4:
        int r101 = this.f492021b;
        int r102 = r101 + r100;
        if (r100 >= 0) goto L7;
    L10:
        d.b(r100, this.f492022c - r101);
        throw null;
    L7:
        if (r102 > this.f492022c) goto L10;
        this.f492021b = r102;
    }

    public final void d(int r100) {
        boolean r101 = true;
        if (r100 < 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L19;
        if (r100 <= this.f492021b) goto L11;
        r101 = false;
    L11:
        if (r101 == false) goto L17;
        this.f492021b = r100;
        if (this.f492023d <= r100) goto L20;
        this.f492023d = r100;
        return;
    L20:
        return;
    L17:
        throw new IllegalArgumentException(("newReadPosition shouldn't be ahead of the read position: " + r100 + " > " + this.f492021b).toString());
    L19:
        throw new IllegalArgumentException(("newReadPosition shouldn't be negative: " + r100).toString());
    L5:
        r102 = false;
        goto L6
    }

    public final void f(int r100) {
        int r101 = this.f492023d;
        this.f492021b = r101;
        this.f492022c = r101;
        this.f492024e = r100;
    }
}
