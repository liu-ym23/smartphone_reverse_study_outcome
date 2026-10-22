package l9b;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f508127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f508128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f508129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f508130d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f508131e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f508132f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Unit> f508133g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<Unit> f508134h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<Unit> f508135i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function0<Unit> f508136j;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f508127a == r101.f508127a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f508128b, r101.f508128b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f508129c, r101.f508129c) == true) goto L18;
        return false;
    L18:
        if (this.f508130d == r101.f508130d) goto L21;
        return false;
    L21:
        if (this.f508131e == r101.f508131e) goto L24;
        return false;
    L24:
        if (this.f508132f == r101.f508132f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f508133g, r101.f508133g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f508134h, r101.f508134h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f508135i, r101.f508135i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f508136j, r101.f508136j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f508127a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((((r101 * 31) + this.f508128b.hashCode()) * 31) + this.f508129c.hashCode()) * 31;
        if (this.f508130d == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f508131e == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f508132f == true) goto L18;
        r100 = 1237;
    L18:
        int r107 = (r106 + r100) * 31;
        Function0<Unit> r108 = this.f508133g;
        int r109 = 0;
        if (r108 != null) goto L21;
        int r110 = 0;
    L22:
        int r111 = (r107 + r110) * 31;
        Function0<Unit> r112 = this.f508134h;
        if (r112 != null) goto L25;
        int r113 = 0;
    L26:
        int r114 = (r111 + r113) * 31;
        Function0<Unit> r115 = this.f508135i;
        if (r115 != null) goto L29;
        int r116 = 0;
    L30:
        int r117 = (r114 + r116) * 31;
        Function0<Unit> r118 = this.f508136j;
        if (r118 == null) goto L35;
        r109 = r118.hashCode();
    L35:
        return r117 + r109;
    L29:
        r116 = r115.hashCode();
        goto L30
    L25:
        r113 = r112.hashCode();
        goto L26
    L21:
        r110 = r108.hashCode();
        goto L22
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "OfficeContactHeaderConfig(showNewFriendEntry=" + this.f508127a + ", newFriendBadgeCount=" + this.f508128b + ", newFriendSubtitle=" + this.f508129c + ", showProfileCardEntry=" + this.f508130d + ", showExternalContactEntry=" + this.f508131e + ", showOrgContactsTitle=" + this.f508132f + ", onNewFriendClick=" + this.f508133g + ", onGroupChatClick=" + this.f508134h + ", onProfileCardClick=" + this.f508135i + ", onExternalContactClick=" + this.f508136j + ')';
    }

    public /* synthetic */ a(int r110) {
        this(false, "", "", false, false, false, null, null, null, null);
    }

    public a(boolean r100, String r101, String r102, boolean r103, boolean r104, boolean r105, Function0<Unit> r106, Function0<Unit> r107, Function0<Unit> r110, Function0<Unit> r111) {
        Intrinsics.checkNotNullParameter(r101, "newFriendBadgeCount");
        Intrinsics.checkNotNullParameter(r102, "newFriendSubtitle");
        this.f508127a = r100;
        this.f508128b = r101;
        this.f508129c = r102;
        this.f508130d = r103;
        this.f508131e = r104;
        this.f508132f = r105;
        this.f508133g = r106;
        this.f508134h = r107;
        this.f508135i = r110;
        this.f508136j = r111;
    }
}
