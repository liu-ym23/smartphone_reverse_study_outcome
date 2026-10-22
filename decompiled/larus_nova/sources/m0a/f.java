package m0a;

import com.larus.ugc.feed.api.model.CommunityCreateLaunchModeKmp;
import com.larus.ugc.feed.api.model.FabVisibilityStateKmp;
import com.larus.ugc.feed.api.model.TabItemInfoKmp;
import com.larus.ugc.feed.api.model.UserCreationKmp;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CommunityCreateLaunchModeKmp f511515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f511516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f511517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f511518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<TabItemInfoKmp> f511519e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f511520f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TabItemInfoKmp f511521g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final FabVisibilityStateKmp f511522h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f511523i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final UserCreationKmp f511524j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f511525k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f511526l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f511527m;

    public f() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f511515a == r101.f511515a) goto L12;
        return false;
    L12:
        if (this.f511516b == r101.f511516b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f511517c, r101.f511517c) == true) goto L18;
        return false;
    L18:
        if (this.f511518d == r101.f511518d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f511519e, r101.f511519e) == true) goto L24;
        return false;
    L24:
        if (this.f511520f == r101.f511520f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f511521g, r101.f511521g) == true) goto L30;
        return false;
    L30:
        if (this.f511522h == r101.f511522h) goto L33;
        return false;
    L33:
        if (this.f511523i == r101.f511523i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f511524j, r101.f511524j) == true) goto L39;
        return false;
    L39:
        if (this.f511525k == r101.f511525k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f511526l, r101.f511526l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f511527m, r101.f511527m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f511515a.hashCode() * 31;
        int r101 = 1231;
        if (this.f511516b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((((((((r100 + r102) * 31) + this.f511517c.hashCode()) * 31) + this.f511518d) * 31) + this.f511519e.hashCode()) * 31) + this.f511520f) * 31;
        TabItemInfoKmp r104 = this.f511521g;
        int r105 = 0;
        if (r104 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r103 + r106) * 31) + this.f511522h.hashCode()) * 31;
        if (this.f511523i == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r107 + r108) * 31;
        UserCreationKmp r110 = this.f511524j;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        if (this.f511525k == true) goto L22;
        r101 = 1237;
    L22:
        int r113 = (r112 + r101) * 31;
        String r114 = this.f511526l;
        if (r114 != null) goto L25;
        int r115 = 0;
    L26:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f511527m;
        if (r117 == null) goto L31;
        r105 = r117.hashCode();
    L31:
        return r116 + r105;
    L25:
        r115 = r114.hashCode();
        goto L26
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = 1237;
        goto L14
    L9:
        r106 = r104.hashCode();
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "CommunityCreateUiStateKmp(launchMode=" + this.f511515a + ", isMultiTab=" + this.f511516b + ", currentPage=" + this.f511517c + ", recommendType=" + this.f511518d + ", tabList=" + this.f511519e + ", currentTabIndex=" + this.f511520f + ", lastTabItemInfo=" + this.f511521g + ", fabVisibility=" + this.f511522h + ", showAvatar=" + this.f511523i + ", pendingPublishedCreation=" + this.f511524j + ", hasResumedBefore=" + this.f511525k + ", lastEnterMethod=" + this.f511526l + ", previousPage=" + this.f511527m + ')';
    }

    public /* synthetic */ f(int r110) {
        this(CommunityCreateLaunchModeKmp.STANDALONE, false, "community_create", 1, CollectionsKt.emptyList(), 0, null, FabVisibilityStateKmp.VISIBLE, false, null, false, null, null);
    }

    public f(CommunityCreateLaunchModeKmp r100, boolean r101, String r102, int r103, List<TabItemInfoKmp> r104, int r105, TabItemInfoKmp r106, FabVisibilityStateKmp r107, boolean r110, UserCreationKmp r111, boolean r112, String r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "launchMode");
        Intrinsics.checkNotNullParameter(r102, "currentPage");
        Intrinsics.checkNotNullParameter(r104, "tabList");
        Intrinsics.checkNotNullParameter(r107, "fabVisibility");
        this.f511515a = r100;
        this.f511516b = r101;
        this.f511517c = r102;
        this.f511518d = r103;
        this.f511519e = r104;
        this.f511520f = r105;
        this.f511521g = r106;
        this.f511522h = r107;
        this.f511523i = r110;
        this.f511524j = r111;
        this.f511525k = r112;
        this.f511526l = r113;
        this.f511527m = r114;
    }

    public static f a(f r110, CommunityCreateLaunchModeKmp r111, boolean r112, String r113, int r114, List r115, int r210, TabItemInfoKmp r211, FabVisibilityStateKmp r212, boolean r213, UserCreationKmp r214, boolean r215, String r216, String r217, int r218) {
        if ((r218 & 1) == 0) goto L5;
        CommunityCreateLaunchModeKmp r100 = r110.f511515a;
    L7:
        if ((r218 & 2) == 0) goto L9;
        boolean r101 = r110.f511516b;
    L11:
        if ((r218 & 4) == 0) goto L13;
        String r102 = r110.f511517c;
    L15:
        if ((r218 & 8) == 0) goto L17;
        int r103 = r110.f511518d;
    L19:
        if ((r218 & 16) == 0) goto L21;
        List r104 = r110.f511519e;
    L23:
        if ((r218 & 32) == 0) goto L25;
        int r105 = r110.f511520f;
    L27:
        if ((r218 & 64) == 0) goto L29;
        TabItemInfoKmp r106 = r110.f511521g;
    L31:
        if ((r218 & 128) == 0) goto L33;
        FabVisibilityStateKmp r107 = r110.f511522h;
    L35:
        if ((r218 & 256) == 0) goto L37;
        boolean r116 = r110.f511523i;
    L39:
        if ((r218 & 512) == 0) goto L41;
        UserCreationKmp r117 = r110.f511524j;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        boolean r118 = r110.f511525k;
    L47:
        if ((r218 & 2048) == 0) goto L49;
        String r119 = r110.f511526l;
    L51:
        if ((r218 & 4096) == 0) goto L53;
        String r108 = r110.f511527m;
    L54:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r100, "launchMode");
        Intrinsics.checkNotNullParameter(r102, "currentPage");
        Intrinsics.checkNotNullParameter(r104, "tabList");
        Intrinsics.checkNotNullParameter(r107, "fabVisibility");
        return new f(r100, r101, r102, r103, r104, r105, r106, r107, r116, r117, r118, r119, r108);
    L53:
        r108 = r217;
        goto L54
    L49:
        r119 = r216;
        goto L51
    L45:
        r118 = r215;
        goto L47
    L41:
        r117 = r214;
        goto L43
    L37:
        r116 = r213;
        goto L39
    L33:
        r107 = r212;
        goto L35
    L29:
        r106 = r211;
        goto L31
    L25:
        r105 = r210;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
