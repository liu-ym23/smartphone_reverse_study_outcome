package com.larus.business.markdown.impl.markwon.core.spans.codeblock;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f320620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f320621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f320622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f320623d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f320624e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f320625f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f320626g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f320627h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f320628i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f320620a, r101.f320620a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f320621b, r101.f320621b) == true) goto L15;
        return false;
    L15:
        if (this.f320622c == r101.f320622c) goto L18;
        return false;
    L18:
        if (Float.compare(this.f320623d, r101.f320623d) == 0) goto L21;
        return false;
    L21:
        if (Float.compare(this.f320624e, r101.f320624e) == 0) goto L24;
        return false;
    L24:
        if (this.f320625f == r101.f320625f) goto L27;
        return false;
    L27:
        if (this.f320626g == r101.f320626g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f320627h, r101.f320627h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f320628i, r101.f320628i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v18 */
    public final int hashCode() {
        Integer r100 = this.f320620a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f320621b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((((((((r103 + r105) * 31) + this.f320622c) * 31) + Float.floatToIntBits(this.f320623d)) * 31) + Float.floatToIntBits(this.f320624e)) * 31) + this.f320625f) * 31;
        boolean r107 = this.f320626g;
        ?? r108 = r107;
        if (r107 == false) goto L13;
        r108 = 1;
    L13:
        int r109 = (r106 + r108) * 31;
        b r110 = this.f320627h;
        if (r110 != null) goto L16;
        int r111 = 0;
    L17:
        int r112 = (r109 + r111) * 31;
        a r113 = this.f320628i;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L16:
        r111 = r110.hashCode();
        goto L17
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CodeBlockSpan2Info(codeBlockStartIndex=" + this.f320620a + ", codeBlockEndIndex=" + this.f320621b + ", titleBgColor=" + this.f320622c + ", cornerRadius=" + this.f320623d + ", borderWidth=" + this.f320624e + ", borderColor=" + this.f320625f + ", enableBackground=" + this.f320626g + ", scrollableInfo=" + this.f320627h + ", numberInfo=" + this.f320628i + ')';
    }

    public c(Integer r100, Integer r101, int r102, float r103, float r104, int r105, boolean r106, b r107, a r108) {
        this.f320620a = r100;
        this.f320621b = r101;
        this.f320622c = r102;
        this.f320623d = r103;
        this.f320624e = r104;
        this.f320625f = r105;
        this.f320626g = r106;
        this.f320627h = r107;
        this.f320628i = r108;
    }
}
