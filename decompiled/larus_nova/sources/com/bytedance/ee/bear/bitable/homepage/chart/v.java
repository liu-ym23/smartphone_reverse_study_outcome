package com.bytedance.ee.bear.bitable.homepage.chart;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f212639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f212640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f212641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f212642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f212643e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f212644f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f212645g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f212646h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f212647i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f212648j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f212649k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L8;
        return false;
    L8:
        v r101 = (v) r100;
        if (Intrinsics.areEqual(this.f212639a, r101.f212639a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f212640b, r101.f212640b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f212641c, r101.f212641c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f212642d, r101.f212642d) == true) goto L21;
        return false;
    L21:
        if (this.f212643e == r101.f212643e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f212644f, r101.f212644f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f212645g, r101.f212645g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f212646h, r101.f212646h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f212647i, r101.f212647i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f212648j, r101.f212648j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f212649k, r101.f212649k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f212639a.hashCode() * 31;
        String r101 = this.f212640b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f212641c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f212642d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (((r107 + r109) * 31) + this.f212643e) * 31;
        String r111 = this.f212644f;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f212645g;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f212646h;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.f212647i;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        String r123 = this.f212648j;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        String r126 = this.f212649k;
        if (r126 == null) goto L39;
        r102 = r126.hashCode();
    L39:
        return r125 + r102;
    L33:
        r124 = r123.hashCode();
        goto L34
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
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
        return "PublicParams(params=" + this.f212639a + ", module=" + this.f212640b + ", subModule=" + this.f212641c + ", fileId=" + this.f212642d + ", fileType=" + this.f212643e + ", subFileType=" + this.f212644f + ", containerId=" + this.f212645g + ", containerType=" + this.f212646h + ", shortcutToken=" + this.f212647i + ", containerEnv=" + this.f212648j + ", hpFrom=" + this.f212649k + ')';
    }

    public v(JSONObject r100, String r101, int r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f212639a = r100;
        this.f212640b = DocumentType.BITABLE_NAME;
        this.f212641c = "mobile_homepage_dashboard";
        this.f212642d = r101;
        this.f212643e = r102;
        this.f212644f = null;
        this.f212645g = null;
        this.f212646h = null;
        this.f212647i = null;
        this.f212648j = r103;
        this.f212649k = r104;
    }
}
