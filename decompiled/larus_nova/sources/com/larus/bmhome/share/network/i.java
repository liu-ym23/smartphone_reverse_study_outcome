package com.larus.bmhome.share.network;

import androidx.fragment.app.DialogFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f313849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f313850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final jr9.a f313851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SaveMessageShareInfo f313852d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f313853e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.larus.bmhome.share.panel.b f313854f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DialogFragment f313855g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f313849a, r101.f313849a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f313850b, r101.f313850b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f313851c, r101.f313851c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f313852d, r101.f313852d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f313853e, r101.f313853e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f313854f, r101.f313854f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f313855g, r101.f313855g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f313849a.hashCode() * 31;
        Long r101 = this.f313850b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f313851c.hashCode()) * 31;
        SaveMessageShareInfo r105 = this.f313852d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        g r108 = this.f313853e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (((r107 + r109) * 31) + this.f313854f.hashCode()) * 31;
        DialogFragment r111 = this.f313855g;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ShareDetailData(usedApi=" + this.f313849a + ", code=" + this.f313850b + ", shareItemConfig=" + this.f313851c + ", saveMessageShareInfo=" + this.f313852d + ", shareCodePreviewData=" + this.f313853e + ", flowShareContent=" + this.f313854f + ", shareDialog=" + this.f313855g + ')';
    }

    public i(String r100, Long r101, jr9.a r102, SaveMessageShareInfo r103, g r104, com.larus.bmhome.share.panel.b r105, DialogFragment r106, int r110) {
        if ((r110 & 8) == 0) goto L6;
        r103 = null;
    L6:
        if ((r110 & 16) == 0) goto L8;
        r104 = null;
    L8:
        Intrinsics.checkNotNullParameter(r100, "usedApi");
        Intrinsics.checkNotNullParameter(r102, "shareItemConfig");
        Intrinsics.checkNotNullParameter(r105, "flowShareContent");
        this.f313849a = r100;
        this.f313850b = r101;
        this.f313851c = r102;
        this.f313852d = r103;
        this.f313853e = r104;
        this.f313854f = r105;
        this.f313855g = r106;
    }
}
