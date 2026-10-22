package com.obric.oui.privacy;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f402483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f402484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f402485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<j> f402486d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f402487e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<String> f402488f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f402489g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f402490h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f402491i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f402492j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f402493k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f402483a, r101.f402483a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f402484b, r101.f402484b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f402485c, r101.f402485c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f402486d, r101.f402486d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f402487e, r101.f402487e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f402488f, r101.f402488f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f402489g, r101.f402489g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f402490h, r101.f402490h) == true) goto L33;
        return false;
    L33:
        if (this.f402491i == r101.f402491i) goto L36;
        return false;
    L36:
        if (this.f402492j == r101.f402492j) goto L39;
        return false;
    L39:
        if (this.f402493k == r101.f402493k) goto L41;
        return false;
    L41:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17, types: [int] */
    /* JADX WARN: Type inference failed for: r2v18 */
    public final int hashCode() {
        String r100 = this.f402483a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f402484b.hashCode()) * 31;
        String r104 = this.f402485c;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.f402486d.hashCode()) * 31;
        String r107 = this.f402487e;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r106 + r108) * 31) + this.f402488f.hashCode()) * 31;
        String r110 = this.f402489g;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f402490h;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        int r114 = (r112 + r101) * 31;
        boolean r115 = this.f402491i;
        ?? r116 = 1;
        ?? r117 = r115;
        if (r115 == false) goto L25;
        r117 = 1;
    L25:
        int r118 = (r114 + r117) * 31;
        boolean r119 = this.f402492j;
        ?? r120 = r119;
        if (r119 == false) goto L28;
        r120 = 1;
    L28:
        int r121 = (r118 + r120) * 31;
        boolean r122 = this.f402493k;
        if (r122 == true) goto L33;
        r116 = r122;
    L33:
        return r121 + r116;
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
        return "OPrivacySheetConfig(appIconPackageName=" + this.f402483a + ", appName=" + this.f402484b + ", appDescription=" + this.f402485c + ", items=" + this.f402486d + ", privacyPolicyText=" + this.f402487e + ", privacyPolicyLinkTexts=" + this.f402488f + ", agreeButtonText=" + this.f402489g + ", exitButtonText=" + this.f402490h + ", enableDim=" + this.f402491i + ", cancelable=" + this.f402492j + ", enableEnterAnim=" + this.f402493k + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(String r100, String r101, String r102, List<? extends j> r103, String r104, List<String> r105, String r106, String r107, boolean r110, boolean r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r101, "appName");
        Intrinsics.checkNotNullParameter(r103, "items");
        Intrinsics.checkNotNullParameter(r105, "privacyPolicyLinkTexts");
        this.f402483a = r100;
        this.f402484b = r101;
        this.f402485c = r102;
        this.f402486d = r103;
        this.f402487e = r104;
        this.f402488f = r105;
        this.f402489g = r106;
        this.f402490h = r107;
        this.f402491i = r110;
        this.f402492j = r111;
        this.f402493k = r112;
    }
}
