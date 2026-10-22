package fz4;

import android.webkit.WebView;
import com.bytedance.ee.bear.domain.BearUrl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f479353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WebView f479354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BearUrl f479355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f479356d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f479357e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f479358f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f479359g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f479353a == r101.f479353a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f479354b, r101.f479354b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f479355c, r101.f479355c) == true) goto L18;
        return false;
    L18:
        if (this.f479356d == r101.f479356d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f479357e, r101.f479357e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f479358f, r101.f479358f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f479359g, r101.f479359g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f479353a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        WebView r103 = this.f479354b;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        BearUrl r107 = this.f479355c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.f479356d == true) goto L18;
        r100 = 1237;
    L18:
        int r110 = (r109 + r100) * 31;
        String r111 = this.f479357e;
        if (r111 != null) goto L21;
        int r112 = 0;
    L22:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f479358f;
        if (r114 != null) goto L25;
        int r115 = 0;
    L26:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f479359g;
        if (r117 == null) goto L31;
        r104 = r117.hashCode();
    L31:
        return r116 + r104;
    L25:
        r115 = r114.hashCode();
        goto L26
    L21:
        r112 = r111.hashCode();
        goto L22
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "DocShotParams(isMindNote=" + this.f479353a + ", webView=" + this.f479354b + ", bearUrl=" + this.f479355c + ", isWiki=" + this.f479356d + ", source=" + this.f479357e + ", title=" + this.f479358f + ", exportType=" + this.f479359g + ')';
    }

    public c(boolean r100, WebView r101, BearUrl r102, boolean r103, String r104, String r105, String r106) {
        this.f479353a = r100;
        this.f479354b = r101;
        this.f479355c = r102;
        this.f479356d = r103;
        this.f479357e = r104;
        this.f479358f = r105;
        this.f479359g = r106;
    }
}
