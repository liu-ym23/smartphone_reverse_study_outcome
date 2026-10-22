package et0;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.HonorWallElement;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfileFansClub;
import com.bytedance.android.live.base.model.user.ProfileFansClubData;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.base.model.user.ProfileText;
import com.bytedance.android.live.base.model.user.SubscribeInfo;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.c1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.profile.ui.base.h;
import com.bytedance.android.live.profile.ui.base.i;
import com.bytedance.android.live.profile.ui.util.m;
import com.bytedance.android.livesdk.common.LiveViewStub;
import com.larus.nova.R;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements bt0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f473854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f473855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f473856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f473857d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f473858e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f473859f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f473860g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f473861h;

    public b() {
    }

    @Override // bt0.b
    public final void f() {
    }

    @Override // bt0.b
    public final void onViewShow() {
    }

    @Override // bt0.b
    public final void g() {
        h r100 = this.f473854a;
        if (r100 == null) goto L16;
        NewProfileUser r101 = r100.getTargetUser();
        if (r101 == null) goto L17;
        ProfileSkin r102 = r101.mProfileSkin;
        if (r102 == null) goto L18;
        ProfileCustomSkin r103 = r102.skin;
        if (r103 == null) goto L19;
        ProfileCustomSkin.HonorWallUI r104 = r103.honorWallSkin;
        if (r104 == null) goto L20;
        String r105 = r104.contentColor;
        if (r105 == null) goto L21;
        int r106 = m.f86955a;
        m.e(this.f473857d, r105);
        m.e(this.f473858e, r105);
        m.e(this.f473859f, r105);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // bt0.b
    public final void p(LiveViewStub r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        TextView r101 = null;
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_view_new_profile_tag_layout, null, false);
        if (r102 != null) goto L5;
        return;
    L5:
        r100.a(r102);
        this.f473855b = r102.findViewById(R.id.profile_tag_fans_layout);
        this.f473857d = (TextView) r102.findViewById(R.id.profile_tag_never_join_fans_club);
        this.f473858e = (TextView) r102.findViewById(R.id.profile_tag_only_subscribe);
        View r103 = this.f473855b;
        if (r103 == null) goto L8;
        r101 = (TextView) r103.findViewById(R.id.profile_tag_fans_name);
    L8:
        this.f473856c = r101;
        this.f473859f = r102.findViewById(R.id.profile_fans_club_count_layout);
        this.f473860g = (TextView) r102.findViewById(R.id.profile_fans_club_count);
        this.f473861h = (TextView) r102.findViewById(R.id.profile_fans_club_count_suffix);
    }

    @Override // com.bytedance.android.live.profile.profilecontext.c
    public final void setProfileContext(h r100) {
        this.f473854a = r100;
    }

    @Override // bt0.b
    public final void h(ProfileText r110, HonorWallElement r111, NewProfileUser r112, h r113) {
        Intrinsics.checkNotNullParameter(r111, "elementInfo");
        Intrinsics.checkNotNullParameter(r112, "profileUser");
        Intrinsics.checkNotNullParameter(r113, "profileContext");
        c.f473862g.getClass();
        Intrinsics.checkNotNullParameter(r111, "element");
        Intrinsics.checkNotNullParameter(r112, "user");
        Intrinsics.checkNotNullParameter(r113, "profileContext");
        int r114 = r111.getId();
        c r100 = null;
        k r101 = null;
        r101 = null;
        r101 = null;
        k r102 = null;
        r102 = null;
        r102 = null;
        if (r114 != HonorWallElement.TYPE_FANS_CLUB) goto L34;
        int r103 = HonorWallElement.TYPE_FANS_CLUB;
        if (i.k(r113) == false) goto L9;
        if (i.m(r113) == false) goto L9;
    L12:
        boolean r104 = true;
    L14:
        ProfileFansClub r105 = r112.fansClub;
        if (r105 == null) goto L19;
        ProfileFansClubData r115 = r105.getData();
        if (r115 == null) goto L19;
        String r106 = r115.clubName;
    L20:
        ProfileFansClub r116 = r112.fansClub;
        if (r116 == null) goto L27;
        ProfileFansClubData r117 = r116.getData();
        if (r117 == null) goto L27;
        ProfileFansClubData.ProfileUserBadge r118 = r117.badge;
        if (r118 == null) goto L27;
        r101 = r118.getToShowIcon();
    L27:
        k r107 = r101;
        SubscribeInfo r119 = r112.subscribeInfo;
        if (r119 == null) goto L30;
        boolean r108 = r119.isMember;
    L31:
        c r120 = new c(r103, r104, r105, r106, r107, r108);
    L32:
        r100 = r120;
    L63:
        if (r100 != null) goto L66;
        return;
    L66:
        if (r100.f473864b == false) goto L97;
        ProfileFansClub r121 = r100.f473865c;
        View r122 = this.f473859f;
        if (r122 == null) goto L70;
        UtilityKotlinExtentionsKt.w(r122);
    L70:
        int r123 = m.f86955a;
        m.a(this.f473860g);
        if (r121 != null) goto L73;
        Pair<String, String> r124 = c1.b(0);
    L78:
        TextView r125 = this.f473860g;
        if (r125 == null) goto L81;
        r125.setText(((String) r124.first).toString());
    L81:
        TextView r126 = this.f473861h;
        if (r126 == null) goto L113;
        Object[] r127 = new Object[1];
        String r128 = (String) r124.second;
        if (r128 != null) goto L87;
        r128 = "";
    L87:
        r127[0] = r128;
        r126.setText(s1.C(R.string.ttlive_new_profile_fan_count_tv, r127));
        return;
    L113:
        return;
    L73:
        String r129 = r121.fansCountStr;
        if (r129 == null) goto L76;
    L88:
        if (r129 == null) goto L92;
        TextView r130 = this.f473860g;
        if (r130 == null) goto L92;
        r130.setText(r129);
    L92:
        String r131 = r121.fansCountSubStr;
        if (r131 == null) goto L115;
        TextView r132 = this.f473861h;
        if (r132 == null) goto L116;
        r132.setText(r131);
        return;
    L116:
        return;
    L115:
        return;
    L76:
        if (r121.fansCountSubStr != null) goto L88;
        r124 = c1.b(r121.totalFansCount);
        goto L78
    L97:
        k r133 = r100.f473867e;
        String r134 = r100.f473866d;
        boolean r135 = r100.f473868f;
        if (r133 != null) goto L109;
        if (r135 == false) goto L103;
        TextView r136 = this.f473858e;
        if (r136 == null) goto L106;
        UtilityKotlinExtentionsKt.w(r136);
    L106:
        View r137 = this.f473855b;
        if (r137 == null) goto L118;
        UtilityKotlinExtentionsKt.u(r137);
        return;
    L118:
        return;
    L103:
        TextView r138 = this.f473857d;
        if (r138 == null) goto L106;
        UtilityKotlinExtentionsKt.w(r138);
        goto L106
    L109:
        View r139 = this.f473855b;
        if (r139 == null) goto L120;
        r139.post(new a(this, r133, r134));
        return;
    L120:
        return;
    L30:
        r108 = false;
    L19:
        r106 = null;
    L9:
        if (i.k(r113) == false) goto L11;
    L13:
        r104 = false;
        goto L14
    L11:
        if (i.l(r113) == false) goto L13;
    L34:
        if (r114 != HonorWallElement.TYPE_SHOP_FANS_CLUB) goto L63;
        int r109 = HonorWallElement.TYPE_SHOP_FANS_CLUB;
        if (i.k(r113) == false) goto L40;
        if (i.m(r113) == false) goto L40;
    L43:
        boolean r140 = true;
    L45:
        ProfileFansClub r141 = r112.shopFansClub;
        if (r141 == null) goto L50;
        ProfileFansClubData r142 = r141.getData();
        if (r142 == null) goto L50;
        String r143 = r142.clubName;
    L51:
        ProfileFansClub r144 = r112.shopFansClub;
        if (r144 == null) goto L58;
        ProfileFansClubData r145 = r144.getData();
        if (r145 == null) goto L58;
        ProfileFansClubData.ProfileUserBadge r146 = r145.badge;
        if (r146 == null) goto L58;
        r102 = r146.getToShowShopFansClubIcon();
    L58:
        k r147 = r102;
        SubscribeInfo r148 = r112.subscribeInfo;
        if (r148 == null) goto L61;
        boolean r149 = r148.isMember;
    L62:
        r120 = new c(r109, r140, r141, r143, r147, r149);
        goto L32
    L61:
        r149 = false;
    L50:
        r143 = null;
    L40:
        if (i.k(r113) == false) goto L42;
    L44:
        r140 = false;
        goto L45
    L42:
        if (i.l(r113) == false) goto L44;
        goto L43
    }

    @Override // bt0.b
    public void update(ProfileText r100, HonorWallElement r101, NewProfileUser r102, h r103) {
        Intrinsics.checkNotNullParameter(r101, "elementInfo");
        Intrinsics.checkNotNullParameter(r102, "profileUser");
        Intrinsics.checkNotNullParameter(r103, "profileContext");
        View r104 = this.f473859f;
        if (r104 == null) goto L5;
        UtilityKotlinExtentionsKt.t(r104);
    L5:
        TextView r105 = this.f473857d;
        if (r105 == null) goto L8;
        UtilityKotlinExtentionsKt.u(r105);
    L8:
        TextView r106 = this.f473858e;
        if (r106 == null) goto L11;
        UtilityKotlinExtentionsKt.u(r106);
    L11:
        View r107 = this.f473855b;
        if (r107 == null) goto L14;
        UtilityKotlinExtentionsKt.w(r107);
    L14:
        h(r100, r101, r102, r103);
        int r108 = m.f86955a;
        m.g(CollectionsKt.listOf(new View[]{this.f473857d, this.f473858e, this.f473859f}), s1.h(R.color.ttlive_new_profile_black));
        g();
    }
}
