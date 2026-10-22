package com.bytedance.ee.bear.more;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.more.export.PageviewUIHolder;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f234705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f234706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f234707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f234708d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f234709e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f234710f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PageviewUIHolder f234711g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Fragment f234712h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f234713i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final HashMap<String, Serializable> f234714j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final sj5.d f234715k;

    public p() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f234705a, r101.f234705a) == true) goto L12;
        return false;
    L12:
        if (this.f234706b == r101.f234706b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f234707c, r101.f234707c) == true) goto L18;
        return false;
    L18:
        if (this.f234708d == r101.f234708d) goto L21;
        return false;
    L21:
        if (this.f234709e == r101.f234709e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f234710f, r101.f234710f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f234711g, r101.f234711g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f234712h, r101.f234712h) == true) goto L33;
        return false;
    L33:
        if (this.f234713i == r101.f234713i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f234714j, r101.f234714j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f234715k, r101.f234715k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        FragmentActivity r100 = this.f234705a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f234706b) * 31;
        String r104 = this.f234707c;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        int r107 = 1231;
        if (this.f234708d == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.f234709e == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r109 + r110) * 31;
        String r112 = this.f234710f;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        PageviewUIHolder r115 = this.f234711g;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        Fragment r118 = this.f234712h;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (r117 + r119) * 31;
        if (this.f234713i == true) goto L34;
        r107 = 1237;
    L34:
        int r121 = (r120 + r107) * 31;
        HashMap<String, Serializable> r122 = this.f234714j;
        if (r122 != null) goto L37;
        int r123 = 0;
    L38:
        int r124 = (r121 + r123) * 31;
        sj5.d r125 = this.f234715k;
        if (r125 == null) goto L43;
        r101 = r125.hashCode();
    L43:
        return r124 + r101;
    L37:
        r123 = r122.hashCode();
        goto L38
    L29:
        r119 = r118.hashCode();
        goto L30
    L25:
        r116 = r115.hashCode();
        goto L26
    L21:
        r113 = r112.hashCode();
        goto L22
    L17:
        r110 = 1237;
        goto L18
    L13:
        r108 = 1237;
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ShowPageFragmentBean(activity=" + this.f234705a + ", documentType=" + this.f234706b + ", token=" + this.f234707c + ", isDocV2=" + this.f234708d + ", isShowViewHistory=" + this.f234709e + ", title=" + this.f234710f + ", titleHolder=" + this.f234711g + ", sourceFragment=" + this.f234712h + ", replaceSource=" + this.f234713i + ", extraParams=" + this.f234714j + ", listener=" + this.f234715k + ')';
    }

    public final FragmentActivity getActivity() {
        return this.f234705a;
    }

    public p(FragmentActivity r100, int r101, String r102, boolean r103, boolean r104, String r105, PageviewUIHolder r106, Fragment r107, boolean r108, HashMap<String, Serializable> r110, sj5.d r111) {
        this.f234705a = r100;
        this.f234706b = r101;
        this.f234707c = r102;
        this.f234708d = r103;
        this.f234709e = r104;
        this.f234710f = r105;
        this.f234711g = r106;
        this.f234712h = r107;
        this.f234713i = r108;
        this.f234714j = r110;
        this.f234715k = r111;
    }
}
