package com.bytedance.ies.ezpermission.core;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.bytedance.bpea.basics.Cert;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f248569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f248570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Cert f248571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<List<String>> f248572d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i f248573e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h f248574f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f248575g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f248576h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final k f248577i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final j f248578j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final PermissionResultListener f248579k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L32;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f248569a, r101.f248569a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f248570b, r101.f248570b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f248571c, r101.f248571c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f248572d, r101.f248572d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f248573e, r101.f248573e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f248574f, r101.f248574f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f248575g, r101.f248575g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f248576h, r101.f248576h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f248577i, r101.f248577i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f248578j, r101.f248578j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(null, null) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f248579k, r101.f248579k) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(null, null) == true) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    public final int hashCode() {
        Activity r100 = this.f248569a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        Fragment r103 = this.f248570b;
        if (r103 == null) goto L9;
        int r104 = r103.hashCode();
    L10:
        int r105 = (r102 + r104) * 31;
        Cert r106 = this.f248571c;
        if (r106 == null) goto L13;
        int r107 = r106.hashCode();
    L14:
        int r108 = (r105 + r107) * 31;
        List<List<String>> r109 = this.f248572d;
        if (r109 == null) goto L17;
        int r110 = r109.hashCode();
    L18:
        int r111 = (r108 + r110) * 31;
        i r112 = this.f248573e;
        if (r112 == null) goto L21;
        int r113 = r112.hashCode();
    L22:
        int r114 = (r111 + r113) * 31;
        h r115 = this.f248574f;
        if (r115 == null) goto L25;
        int r116 = r115.hashCode();
    L26:
        int r117 = (r114 + r116) * 31;
        a r118 = this.f248575g;
        if (r118 == null) goto L29;
        int r119 = r118.hashCode();
    L30:
        int r120 = (r117 + r119) * 31;
        b r121 = this.f248576h;
        if (r121 == null) goto L33;
        int r122 = r121.hashCode();
    L34:
        int r123 = (r120 + r122) * 31;
        k r124 = this.f248577i;
        if (r124 == null) goto L37;
        int r125 = r124.hashCode();
    L38:
        int r126 = (r123 + r125) * 31;
        j r127 = this.f248578j;
        if (r127 == null) goto L41;
        int r128 = r127.hashCode();
    L42:
        int r129 = (((r126 + r128) * 31) + 0) * 31;
        PermissionResultListener r130 = this.f248579k;
        if (r130 == null) goto L45;
        int r131 = r130.hashCode();
    L47:
        return ((r129 + r131) * 31) + 0;
    L45:
        r131 = 0;
        goto L47
    L41:
        r128 = 0;
        goto L42
    L37:
        r125 = 0;
        goto L38
    L33:
        r122 = 0;
        goto L34
    L29:
        r119 = 0;
        goto L30
    L25:
        r116 = 0;
        goto L26
    L21:
        r113 = 0;
        goto L22
    L17:
        r110 = 0;
        goto L18
    L13:
        r107 = 0;
        goto L14
    L9:
        r104 = 0;
        goto L10
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "EzPermissionRequest(activity=" + this.f248569a + ", fragment=" + this.f248570b + ", cert=" + this.f248571c + ", permissionList=" + this.f248572d + ", explainBeforeListener=" + this.f248573e + ", explainAfterListener=" + this.f248574f + ", beforeNormalPermissionCallback=" + this.f248575g + ", beforeSpecialPermissionCallback=" + this.f248576h + ", onRequestListener=" + this.f248577i + ", permanentDeniedListener=" + this.f248578j + ", checkCertCallback=null, resultListener=" + this.f248579k + ", permissionErrorCallback=null)";
    }

    public final Activity getActivity() {
        return this.f248569a;
    }

    public e(Activity r100, Fragment r101, Cert r102, List r103, i r104, h r105, a r106, b r107, k r110, j r111, PermissionResultListener r112) {
        Intrinsics.checkNotNullParameter(r103, "permissionList");
        this.f248569a = r100;
        this.f248570b = r101;
        this.f248571c = r102;
        this.f248572d = r103;
        this.f248573e = r104;
        this.f248574f = r105;
        this.f248575g = r106;
        this.f248576h = r107;
        this.f248577i = r110;
        this.f248578j = r111;
        this.f248579k = r112;
    }
}
