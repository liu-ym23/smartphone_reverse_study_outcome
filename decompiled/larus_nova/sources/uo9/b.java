package uo9;

import android.graphics.drawable.Drawable;
import android.webkit.WebView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebView f550943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f550944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f550945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Drawable f550946d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final yo9.a f550947e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f550948f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f550943a, r101.f550943a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f550944b, r101.f550944b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f550945c, r101.f550945c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f550946d, r101.f550946d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f550947e, r101.f550947e) == true) goto L24;
        return false;
    L24:
        if (this.f550948f == r101.f550948f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        WebView r100 = this.f550943a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f550944b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f550945c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Drawable r110 = this.f550946d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        yo9.a r113 = this.f550947e;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        int r114 = (r112 + r101) * 31;
        if (this.f550948f == false) goto L25;
        int r115 = 1231;
    L27:
        return r114 + r115;
    L25:
        r115 = 1237;
        goto L27
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
        return "DocShotParams(webView=" + this.f550943a + ", url=" + this.f550944b + ", inputViewHeight=" + this.f550945c + ", bgDrawable=" + this.f550946d + ", listener=" + this.f550947e + ", justShowLoading=" + this.f550948f + ')';
    }

    public b(WebView r100, String r101, Integer r102, Drawable r103, yo9.a r104) {
        this.f550943a = r100;
        this.f550944b = r101;
        this.f550945c = r102;
        this.f550946d = r103;
        this.f550947e = r104;
        this.f550948f = true;
    }
}
