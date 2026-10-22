package com.larus.business.markdown.impl.markwon.custom.title;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f320654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f320655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f320656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f320657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f320658e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f320659f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f320660g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f320661h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f320662i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f320663j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f320664k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f320665l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f320654a == r101.f320654a) goto L12;
        return false;
    L12:
        if (this.f320655b == r101.f320655b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f320656c, r101.f320656c) == true) goto L18;
        return false;
    L18:
        if (this.f320657d == r101.f320657d) goto L21;
        return false;
    L21:
        if (this.f320658e == r101.f320658e) goto L24;
        return false;
    L24:
        if (this.f320659f == r101.f320659f) goto L27;
        return false;
    L27:
        if (this.f320660g == r101.f320660g) goto L30;
        return false;
    L30:
        if (this.f320661h == r101.f320661h) goto L33;
        return false;
    L33:
        if (this.f320662i == r101.f320662i) goto L36;
        return false;
    L36:
        if (this.f320663j == r101.f320663j) goto L39;
        return false;
    L39:
        if (this.f320664k == r101.f320664k) goto L42;
        return false;
    L42:
        if (this.f320665l == r101.f320665l) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f320654a * 31) + this.f320655b) * 31;
        Integer r101 = this.f320656c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((((((((((((((((((r100 + r102) * 31) + this.f320657d) * 31) + this.f320658e) * 31) + this.f320659f) * 31) + this.f320660g) * 31) + this.f320661h) * 31) + this.f320662i) * 31) + this.f320663j) * 31) + this.f320664k) * 31) + this.f320665l;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "CodeBlockTitleStyleConfig(titleVerticalPadding=" + this.f320654a + ", copyButton=" + this.f320655b + ", fullScreenButton=" + this.f320656c + ", previewButtonPaddingEnd=" + this.f320657d + ", previewButtonPaddingStart=" + this.f320658e + ", copyButtonPaddingEnd=" + this.f320659f + ", copyButtonPaddingStart=" + this.f320660g + ", fullScreenButtonPaddingEnd=" + this.f320661h + ", fullScreenButtonPaddingStart=" + this.f320662i + ", downloadButtonPaddingEnd=" + this.f320663j + ", downloadButtonPaddingStart=" + this.f320664k + ", titlePaddingEnd=" + this.f320665l + ')';
    }

    public a(int r100, int r101, Integer r102, int r103, int r104, int r105, int r106, int r107, int r108, int r110, int r111, int r112) {
        this.f320654a = r100;
        this.f320655b = r101;
        this.f320656c = r102;
        this.f320657d = r103;
        this.f320658e = r104;
        this.f320659f = r105;
        this.f320660g = r106;
        this.f320661h = r107;
        this.f320662i = r108;
        this.f320663j = r110;
        this.f320664k = r111;
        this.f320665l = r112;
    }
}
