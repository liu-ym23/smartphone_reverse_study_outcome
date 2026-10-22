package fy;

import com.bytedance.android.livesdkapi.depend.model.live.linker.BattleConfigSetting;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerInviteContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f479138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f479139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f479140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f479141d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BattleConfigSetting f479142e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f479143f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f479144g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f479145h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f479146i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f479147j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f479148k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LinkerInviteContent f479149l;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L30;
        a r101 = (a) r100;
        if (this.f479138a == r101.f479138a) goto L8;
        return false;
    L8:
        if (this.f479139b == r101.f479139b) goto L10;
        return false;
    L10:
        if (this.f479140c == r101.f479140c) goto L12;
        return false;
    L12:
        if (this.f479141d == r101.f479141d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f479142e, r101.f479142e) == true) goto L16;
        return false;
    L16:
        if (this.f479143f == r101.f479143f) goto L18;
        return false;
    L18:
        if (this.f479144g == r101.f479144g) goto L20;
        return false;
    L20:
        if (this.f479145h == r101.f479145h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f479146i, r101.f479146i) == true) goto L24;
        return false;
    L24:
        if (this.f479147j == r101.f479147j) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f479148k, r101.f479148k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f479149l, r101.f479149l) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        int r100 = ((((((this.f479138a * 31) + this.f479139b) * 31) + this.f479140c) * 31) + this.f479141d) * 31;
        BattleConfigSetting r101 = this.f479142e;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        boolean r105 = this.f479143f;
        ?? r106 = 1;
        ?? r107 = r105;
        if (r105 == false) goto L9;
        r107 = 1;
    L9:
        int r108 = (r104 + r107) * 31;
        boolean r109 = this.f479144g;
        ?? r110 = r109;
        if (r109 == false) goto L12;
        r110 = 1;
    L12:
        int r111 = (r108 + r110) * 31;
        boolean r112 = this.f479145h;
        if (r112 == true) goto L16;
        r106 = r112;
    L16:
        int r113 = (r111 + r106) * 31;
        String r114 = this.f479146i;
        if (r114 == null) goto L19;
        int r115 = r114.hashCode();
    L20:
        int r116 = (((r113 + r115) * 31) + this.f479147j) * 31;
        String r117 = this.f479148k;
        if (r117 == null) goto L23;
        int r118 = r117.hashCode();
    L24:
        int r119 = (r116 + r118) * 31;
        LinkerInviteContent r120 = this.f479149l;
        if (r120 == null) goto L28;
        r102 = r120.hashCode();
    L28:
        return r119 + r102;
    L23:
        r118 = 0;
        goto L24
    L19:
        r115 = 0;
        goto L20
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "AnchorReplyParams(matchType=" + this.f479138a + ", inviteType=" + this.f479139b + ", inviteSource=" + this.f479140c + ", multiPkMode=" + this.f479141d + ", battleConfigSetting=" + this.f479142e + ", isFromNpkInvite=" + this.f479143f + ", isMultiReply=" + this.f479144g + ", isMatchAutoReply=" + this.f479145h + ", reqSrc=" + this.f479146i + ", pkSwitchMode=" + this.f479147j + ", inviteUserId=" + this.f479148k + ", inviteContent=" + this.f479149l + ")";
    }

    public /* synthetic */ a(int r110) {
        this(0, 0, 0, 0, null, false, false, false, "", 0, "0", null);
    }

    public a(int r100, int r101, int r102, int r103, BattleConfigSetting r104, boolean r105, boolean r106, boolean r107, String r110, int r111, String r112, LinkerInviteContent r113) {
        Intrinsics.checkNotNullParameter(r110, "reqSrc");
        Intrinsics.checkNotNullParameter(r112, "inviteUserId");
        this.f479138a = r100;
        this.f479139b = r101;
        this.f479140c = r102;
        this.f479141d = r103;
        this.f479142e = r104;
        this.f479143f = r105;
        this.f479144g = r106;
        this.f479145h = r107;
        this.f479146i = r110;
        this.f479147j = r111;
        this.f479148k = r112;
        this.f479149l = r113;
    }
}
