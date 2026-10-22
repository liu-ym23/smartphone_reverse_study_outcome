package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpacePerm;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceUserPerm;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f241860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f241861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f241862c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f241863d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f241864e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, List<String>> f241865f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, TreeNode> f241866g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SpaceInfo f241867h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final SpaceUserPerm f241868i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final SpacePerm f241869j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f241870k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<String, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a> f241871l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, List<String>> f241872m;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f3) == true) goto L8;
        return false;
    L8:
        f3 r101 = (f3) r100;
        if (Intrinsics.areEqual(this.f241860a, r101.f241860a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f241861b, r101.f241861b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f241862c, r101.f241862c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f241863d, r101.f241863d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f241864e, r101.f241864e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f241865f, r101.f241865f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f241866g, r101.f241866g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f241867h, r101.f241867h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f241868i, r101.f241868i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f241869j, r101.f241869j) == true) goto L39;
        return false;
    L39:
        if (this.f241870k == r101.f241870k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f241871l, r101.f241871l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f241872m, r101.f241872m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f241860a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f241861b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f241862c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f241863d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f241864e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Map<String, List<String>> r116 = this.f241865f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Map<String, TreeNode> r119 = this.f241866g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        SpaceInfo r122 = this.f241867h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        SpaceUserPerm r125 = this.f241868i;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        SpacePerm r128 = this.f241869j;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        if (this.f241870k == false) goto L45;
        int r131 = 1231;
    L46:
        int r132 = (r130 + r131) * 31;
        Map<String, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a> r133 = this.f241871l;
        if (r133 != null) goto L49;
        int r134 = 0;
    L50:
        int r135 = (r132 + r134) * 31;
        Map<String, List<String>> r136 = this.f241872m;
        if (r136 == null) goto L55;
        r101 = r136.hashCode();
    L55:
        return r135 + r101;
    L49:
        r134 = r133.hashCode();
        goto L50
    L45:
        r131 = 1237;
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
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
        return "WorkspaceInitData(rootToken=" + this.f241860a + ", favoriteRootToken=" + this.f241861b + ", sharedRootToken=" + this.f241862c + ", pinedRootToken=" + this.f241863d + ", spaceRootToken=" + this.f241864e + ", relations=" + this.f241865f + ", nodes=" + this.f241866g + ", spaceInfo=" + this.f241867h + ", spaceUserPerm=" + this.f241868i + ", spacePerm=" + this.f241869j + ", fromCache=" + this.f241870k + ", uidNodes=" + this.f241871l + ", tokenToUid=" + this.f241872m + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f3(String r100, String r101, String r102, String r103, String r104, Map<String, ? extends List<String>> r105, Map<String, TreeNode> r106, SpaceInfo r107, SpaceUserPerm r108, SpacePerm r110, boolean r111, Map<String, ? extends com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a> r112, Map<String, ? extends List<String>> r113) {
        this.f241860a = r100;
        this.f241861b = r101;
        this.f241862c = r102;
        this.f241863d = r103;
        this.f241864e = r104;
        this.f241865f = r105;
        this.f241866g = r106;
        this.f241867h = r107;
        this.f241868i = r108;
        this.f241869j = r110;
        this.f241870k = r111;
        this.f241871l = r112;
        this.f241872m = r113;
    }
}
