package com.larus.bmhome.chat.manager;

import com.larus.bmhome.chat.api.ConversationFeedActionType;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f306853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f306854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f306855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Integer> f306856d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<List<Pair<String, String>>> f306857e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f306858f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Unit> f306859g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Set<ConversationFeedActionType> f306860h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f306861i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f306862j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f306863k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f306864l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f306865m;

    public u0() {
        this(0, false, null, null, null, null, false, false, false, null, 8191);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u0) == true) goto L8;
        return false;
    L8:
        u0 r101 = (u0) r100;
        if (this.f306853a == r101.f306853a) goto L12;
        return false;
    L12:
        if (this.f306854b == r101.f306854b) goto L15;
        return false;
    L15:
        if (this.f306855c == r101.f306855c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f306856d, r101.f306856d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f306857e, r101.f306857e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f306858f, r101.f306858f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f306859g, r101.f306859g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f306860h, r101.f306860h) == true) goto L33;
        return false;
    L33:
        if (this.f306861i == r101.f306861i) goto L36;
        return false;
    L36:
        if (this.f306862j == r101.f306862j) goto L39;
        return false;
    L39:
        if (this.f306863k == r101.f306863k) goto L42;
        return false;
    L42:
        if (this.f306864l == r101.f306864l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f306865m, r101.f306865m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f306853a * 31;
        int r101 = 1231;
        if (this.f306854b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f306855c == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (((r103 + r104) * 31) + this.f306856d.hashCode()) * 31;
        Function0<List<Pair<String, String>>> r106 = this.f306857e;
        int r107 = 0;
        if (r106 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r105 + r108) * 31;
        Function0<Unit> r110 = this.f306858f;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Function0<Unit> r113 = this.f306859g;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Set<ConversationFeedActionType> r116 = this.f306860h;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        if (this.f306861i == false) goto L29;
        int r119 = 1231;
    L30:
        int r120 = (r118 + r119) * 31;
        if (this.f306862j == false) goto L33;
        int r121 = 1231;
    L34:
        int r122 = (r120 + r121) * 31;
        if (this.f306863k == false) goto L37;
        int r123 = 1231;
    L38:
        int r124 = (r122 + r123) * 31;
        if (this.f306864l == true) goto L42;
        r101 = 1237;
    L42:
        int r125 = (r124 + r101) * 31;
        String r126 = this.f306865m;
        if (r126 == null) goto L47;
        r107 = r126.hashCode();
    L47:
        return r125 + r107;
    L37:
        r123 = 1237;
        goto L38
    L33:
        r121 = 1237;
        goto L34
    L29:
        r119 = 1237;
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
        r108 = r106.hashCode();
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ScreenMenuViewConfig(marginStart=" + this.f306853a + ", isBgBlur=" + this.f306854b + ", alignToAnchorStart=" + this.f306855c + ", snapshotExcludedViewIds=" + this.f306856d + ", projectOptionsProvider=" + this.f306857e + ", onCreateProjectRequested=" + this.f306858f + ", onArchiveRequested=" + this.f306859g + ", allowedActions=" + this.f306860h + ", allowWorkspacePathCopy=" + this.f306861i + ", pinAndRenameOnly=" + this.f306862j + ", enablePinAction=" + this.f306863k + ", usePinTimeForPinState=" + this.f306864l + ", renameDefaultInput=" + this.f306865m + ')';
    }

    public u0(int r110, boolean r111, List r112, com.larus.home.impl.main.side_bar.view.adapter.h0 r113, com.larus.home.impl.main.side_bar.view.adapter.i0 r210, com.larus.home.impl.main.side_bar.view.adapter.j0 r211, boolean r212, boolean r213, boolean r214, String r215, int r216) {
        if ((r216 & 1) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r216 & 2) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r216 & 8) == 0) goto L13;
        List r102 = CollectionsKt.emptyList();
    L15:
        if ((r216 & 16) == 0) goto L17;
        com.larus.home.impl.main.side_bar.view.adapter.h0 r103 = null;
    L19:
        if ((r216 & 32) == 0) goto L21;
        com.larus.home.impl.main.side_bar.view.adapter.i0 r104 = null;
    L23:
        if ((r216 & 64) == 0) goto L25;
        com.larus.home.impl.main.side_bar.view.adapter.j0 r105 = null;
    L26:
        boolean r114 = true;
        if ((r216 & 256) == 0) goto L29;
        boolean r115 = true;
    L31:
        if ((r216 & 512) == 0) goto L33;
        boolean r116 = false;
    L35:
        if ((r216 & 1024) != 0) goto L39;
        r114 = r213;
    L39:
        if ((r216 & 2048) == 0) goto L41;
        boolean r117 = false;
    L43:
        if ((r216 & 4096) == 0) goto L45;
        String r106 = null;
    L46:
        Intrinsics.checkNotNullParameter(r102, "snapshotExcludedViewIds");
        this.f306853a = r100;
        this.f306854b = r101;
        this.f306855c = false;
        this.f306856d = r102;
        this.f306857e = r103;
        this.f306858f = r104;
        this.f306859g = r105;
        this.f306860h = null;
        this.f306861i = r115;
        this.f306862j = r116;
        this.f306863k = r114;
        this.f306864l = r117;
        this.f306865m = r106;
        return;
    L45:
        r106 = r215;
        goto L46
    L41:
        r117 = r214;
        goto L43
    L33:
        r116 = r212;
        goto L35
    L29:
        r115 = false;
        goto L31
    L25:
        r105 = r211;
        goto L26
    L21:
        r104 = r210;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
