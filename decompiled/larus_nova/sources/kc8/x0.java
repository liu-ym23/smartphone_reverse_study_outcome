package kc8;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f502614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e0 f502615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z f502616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<String> f502617d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<String> f502618e;

    public x0() {
        this(null, null, null, null, null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x0) == true) goto L8;
        return false;
    L8:
        x0 r101 = (x0) r100;
        if (Intrinsics.areEqual(this.f502614a, r101.f502614a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f502615b, r101.f502615b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f502616c, r101.f502616c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f502617d, r101.f502617d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f502618e, r101.f502618e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        n r100 = this.f502614a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        e0 r104 = this.f502615b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        z r107 = this.f502616c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Function0<String> r110 = this.f502617d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Function0<String> r113 = this.f502618e;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "WidgetBlockConfig(containerPadding=" + this.f502614a + ", menuInterceptor=" + this.f502615b + ", longClickHandler=" + this.f502616c + ", originMessageIdProvider=" + this.f502617d + ", widgetThemeProvider=" + this.f502618e + ')';
    }

    public x0(n r100, com.larus.larkfeed.impl.lark.holder.content.h r101, com.larus.larkfeed.impl.lark.holder.content.s r102, cb8.a0 r103, cb8.b0 r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r105 & 16) == 0) goto L17;
        r104 = null;
    L17:
        this.f502614a = r100;
        this.f502615b = r101;
        this.f502616c = r102;
        this.f502617d = r103;
        this.f502618e = r104;
    }
}
