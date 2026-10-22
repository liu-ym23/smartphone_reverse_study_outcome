package com.bytedance.android.window.shop.home.presenter;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.window.base.common.headlive.WindowV3LiveRoomVO;
import com.bytedance.android.ec.window.base.setting.WindowSettingKeys;
import com.bytedance.android.ec.window.base.shop.ECWindowFansClubResponse;
import com.bytedance.android.ec.window.base.shop.WindowFansClubInfo;
import com.bytedance.android.ec.window.base.shop.WindowFansClubScene;
import com.bytedance.android.ec.window.base.view.ECWindowLiveCircleView;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.window.shop.eventcard.windowevent.staticevent.WindowFollowStateChangedEvent;
import com.bytedance.android.window.shop.home.ECWindowDialogFragment;
import com.bytedance.android.window.shop.home.ECWindowParam;
import com.bytedance.android.window.shop.home.presenter.plugin.ECWindowFansClubPlugin;
import com.bytedance.android.window.shop.home.presenter.plugin.ECWindowFollowFromCouponPlugin;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.repository.api.ECWindowApi;
import com.bytedance.android.window.shop.repository.dto.WindowFollowCommitDTO;
import com.bytedance.android.window.shop.repository.dto.WindowFollowDeleteDTO;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\fB\u0007¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/android/window/shop/home/presenter/ECWindowInfoPresenterBase;", "Lcom/bytedance/android/window/shop/home/presenter/AbsECWindowPresenter;", "Landroid/view/View$OnClickListener;", "Landroidx/lifecycle/LifecycleObserver;", "", "onResume", "onDestroy", "Lbp3/b;", "event", "onCartCountChanged", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECWindowInfoPresenterBase extends AbsECWindowPresenter implements View.OnClickListener, LifecycleObserver {
    public static final /* synthetic */ int E = 0;
    public final e A;
    public final d B;
    public final b C;
    public final c D;
    public final int m;
    public final int n;
    public final int o;
    public final int p;
    public final int[] q;
    public boolean r;
    public boolean s;
    public String t;
    public ViewGroup u;
    public SimpleDraweeView v;
    public final com.bytedance.android.window.shop.home.tab.tabplugin.f w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    public static final class a {
    }

    public static final class b implements ti.j {
        public final /* synthetic */ ECWindowInfoPresenterBase a;

        public b(ECWindowInfoPresenterBase r1) {
            this.a = r1;
        }

        public final void a(JSONObject r4) {
            Intrinsics.checkNotNullParameter(r4, "params");
            boolean r0 = r4.optBoolean("success");
            if ((!Intrinsics.areEqual(r4.optString("author_id"), this.a.O().getShopParam().getAuthorId())) == false) goto L5;
            return;
        L5:
            if (r0 == false) goto L8;
            ECWindowInfoPresenterBase r5 = this.a;
            r5.s = false;
            r5.j0(true, false, null);
            return;
        }
    }

    public static final class c implements ti.j {
        public final /* synthetic */ ECWindowInfoPresenterBase a;

        public c(ECWindowInfoPresenterBase r1) {
            this.a = r1;
        }

        public final void a(JSONObject r4) {
            Intrinsics.checkNotNullParameter(r4, "params");
            String r0 = r4.optString("author_id");
            int r5 = r4.optInt("level");
            if ((!Intrinsics.areEqual(r0, this.a.O().getShopParam().getAuthorId())) == false) goto L6;
            return;
        L6:
            if ((!Intrinsics.areEqual(String.valueOf(r5), this.a.t)) == false) goto L9;
            this.a.j0(true, true, String.valueOf(r5));
            return;
        }
    }

    public static final class d implements ti.j {
        public final /* synthetic */ ECWindowInfoPresenterBase a;

        public d(ECWindowInfoPresenterBase r1) {
            this.a = r1;
        }

        public final void a(JSONObject r4) {
            Intrinsics.checkNotNullParameter(r4, "params");
            boolean r0 = r4.optBoolean("success");
            String r1 = r4.optString("author_id");
            int r5 = r4.optInt("level");
            if ((!Intrinsics.areEqual(r1, this.a.O().getShopParam().getAuthorId())) == false) goto L5;
            return;
        L5:
            if (r0 == false) goto L14;
            ECWindowInfoPresenterBase r2 = this.a;
            r2.s = true;
            r2.t = String.valueOf(r5);
            Integer r6 = this.a.O().getShopParam().getFollowStatus();
            if (r6 != null) goto L10;
        L12:
            ECWindowInfoPresenterBase r7 = this.a;
            r7.j0(true, true, r7.t);
            return;
        L10:
            if (r6.intValue() != 0) goto L12;
            this.a.O().getShopParam().setFollowStatus(1);
            this.a.O().isFollowed().c(Boolean.TRUE);
            goto L12
        }
    }

    public static final class e implements ti.j {
        public final /* synthetic */ ECWindowInfoPresenterBase a;

        public e(ECWindowInfoPresenterBase r1) {
            this.a = r1;
        }

        public final void a(JSONObject r5) {
            Intrinsics.checkNotNullParameter(r5, "params");
            int r0 = r5.optInt("follow_status");
            int r6 = r5.optInt("update_from_remote");
            ECWindowInfoPresenterBase r1 = this.a;
            if (r0 != 1) goto L5;
            boolean r2 = true;
        L6:
            int r3 = ECWindowInfoPresenterBase.E;
            r1.e0(r2);
            if (r6 != 1) goto L10;
            this.a.O().loadHeaderInfo();
            return;
        L10:
            return;
        L5:
            r2 = false;
            goto L6
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ ECWindowInfoPresenterBase a;

        public f(ECWindowInfoPresenterBase r1) {
            this.a = r1;
        }

        public final void onChanged(Object r15) {
            uq3.a r16 = (uq3.a) r15;
            if (r16 == null) goto L194;
            ECWindowInfoPresenterBase r0 = this.a;
            uq3.o r1 = r16.c;
            Integer r2 = null;
            if (r1 == null) goto L8;
            String r3 = r1.k;
        L9:
            int r4 = ECWindowInfoPresenterBase.E;
            r0.getClass();
            if (zq3.l.b() == true) goto L12;
        L25:
            TextView r5 = (TextView) r0.w().b(2131391420).f();
            r5.post(new m1(r0, r5, r3));
            ECWindowInfoPresenterBase r6 = this.a;
            r6.getClass();
            int r7 = 8;
            if (zq3.l.b() == true) goto L28;
        L91:
            SimpleDraweeView r8 = r6.w().b(2131376605).f();
            uq3.o r9 = r16.c;
            if (r9 == null) goto L94;
            ECUrlModel r10 = r9.m;
        L95:
            com.bytedance.android.ec.core.imagex.h0.d(r8, r10, r6.O().getImageCallerContext(), null, null, null, null, 120);
            r8.setOnClickListener(r6);
            uq3.o r11 = r16.c;
            if (r11 == null) goto L104;
            Map<String, String> r12 = r11.q;
            if (r12 == null) goto L100;
            String r13 = r12.get("header_follow_style_strategy");
        L102:
            if (Intrinsics.areEqual(r13, "gray_alpha") != true) goto L104;
            boolean r14 = true;
        L105:
            a1 r17 = (a1) r6.y.getValue();
            if (r14 == false) goto L108;
            String r18 = "ec_window_follow_animation_v2.json";
        L109:
            r17.getClass();
            Intrinsics.checkNotNullParameter(r18, "assetName");
            LottieAnimationView r19 = r17.d;
            if (r19 == null) goto L112;
            r19.setAnimation(r18);
        L112:
            a1 r20 = (a1) r6.y.getValue();
            Boolean r21 = (Boolean) r6.O().isFollowed().getValue();
            Boolean r22 = Boolean.TRUE;
            r20.a(Intrinsics.areEqual(r21, r22), false);
            r6.O().isFollowed().a(r6.U(), new l1(r6), false);
            LottieAnimationView r23 = (LottieAnimationView) r6.x.getValue();
            if (r23 == null) goto L115;
            r23.setOnClickListener(r6);
        L115:
            View r24 = r6.w().b(2131370894).f();
            uq3.o r25 = r16.c;
            if (r25 == null) goto L118;
            Boolean r26 = r25.p;
        L120:
            if (Intrinsics.areEqual(r26, r22) == false) goto L122;
            r7 = 0;
        L122:
            r24.setVisibility(r7);
            r24.setOnClickListener(r6);
            ViewExtensionsKt.g(r24, 14.0f, 14.0f, 14.0f, 14.0f);
            if (r6.d0() == true) goto L125;
        L138:
            uq3.o r27 = r16.c;
            if (r27 == null) goto L143;
            WindowFansClubInfo r28 = r27.n;
            if (r28 == null) goto L143;
            boolean r29 = r28.getOpenFansClub();
        L144:
            r6.r = r29;
            uq3.o r30 = r16.c;
            if (r30 == null) goto L149;
            WindowFansClubInfo r31 = r30.n;
            if (r31 == null) goto L149;
            boolean r32 = r31.getJoinStatus();
        L150:
            r6.s = r32;
            uq3.o r33 = r16.c;
            if (r33 == null) goto L155;
            WindowFansClubInfo r34 = r33.n;
            if (r34 == null) goto L155;
            Integer r35 = r34.getFansClubLevel();
        L156:
            r6.t = String.valueOf(r35);
            uq3.o r36 = r16.c;
            if (r36 == null) goto L159;
            Integer r37 = r36.j;
        L160:
            if (r37 != null) goto L163;
        L165:
            boolean r38 = false;
        L166:
            r6.j0(r38, r6.s, r6.t);
            uq3.o r39 = r16.c;
            if (r39 == null) goto L169;
            Boolean r40 = r39.p;
        L171:
            if (Intrinsics.areEqual(r40, r22) == true) goto L173;
        L184:
            ECLiveHybridUtil.m("ecom.shop.follow_status_update", this.a.A);
            ECLiveHybridUtil.m("ecom.fans_club.join_result", this.a.B);
            ECLiveHybridUtil.m("ecom.fans_club.exit_result", this.a.C);
            ECLiveHybridUtil.m("ecom.fans_club.update_info", this.a.D);
            this.a.y().post(new n1(this));
            return;
        L173:
            if (r6.d0() == true) goto L184;
            String r41 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b7635.c2240.d9340", Boolean.FALSE).withView(r6.y()).build());
            ECWindowViewModel r42 = r6.O();
            Pair[] r43 = new Pair[2];
            uq3.o r110 = r16.c;
            if (r110 == null) goto L177;
            r2 = r110.j;
        L177:
            if (r2 != null) goto L180;
        L182:
            String r111 = "已关注";
        L183:
            r43[0] = TuplesKt.to("button_status", r111);
            r43[1] = TuplesKt.to("btm_id", r41);
            r42.doEventAction("show_store_follow", r43);
            goto L184
        L180:
            if (r2.intValue() != 0) goto L182;
            r111 = "未关注";
            goto L183
        L169:
            r40 = null;
            goto L171
        L163:
            if (r37.intValue() != 1) goto L165;
            r38 = true;
            goto L166
        L159:
            r37 = null;
        L155:
            r35 = null;
        L149:
            r32 = false;
        L143:
            r29 = false;
            goto L144
        L125:
            if (r6.F() == false) goto L138;
            if (r6.O().isCroppedStyle() == true) goto L134;
            ECWindowLiveCircleView r44 = r6.w().b(2131376366).f();
            uq3.o r45 = r16.c;
            if (r45 == null) goto L131;
            WindowV3LiveRoomVO r46 = r45.f;
        L132:
            if (r46 == null) goto L134;
            r44.setVisibility(0);
            r44.a();
            goto L134
        L131:
            r46 = null;
        L134:
            SimpleDraweeView r47 = r6.v;
            if (r47 != null) goto L137;
            Intrinsics.throwUninitializedPropertyAccessException("headImg");
        L137:
            r47.setOnClickListener(r6);
            goto L138
        L118:
            r26 = null;
            goto L120
        L108:
            r18 = "ec_window_follow_animation.json";
            goto L109
        L100:
            r13 = null;
        L104:
            r14 = false;
            goto L105
        L94:
            r10 = null;
            goto L95
        L28:
            if (r6.d0() == false) goto L91;
            TextView r48 = (TextView) r6.y().findViewById(2131391389);
            if (r48 == null) goto L91;
            com.bytedance.android.ec.hybrid.list.entity.k r49 = r16.b;
            if (r49 == null) goto L64;
            ArrayList r50 = r49.c;
            if (r50 == null) goto L64;
            Iterator<T> r51 = r50.iterator();
        L37:
            if (r51.hasNext() == false) goto L41;
            T r52 = r51.next();
            if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.i) r52).a, "author_info") == false) goto L37;
        L42:
            com.bytedance.android.ec.hybrid.list.entity.i r53 = (com.bytedance.android.ec.hybrid.list.entity.i) r52;
            if (r53 == null) goto L64;
            ArrayList r54 = r53.i;
            if (r54 == null) goto L64;
            Iterator<T> r55 = r54.iterator();
        L48:
            if (r55.hasNext() == false) goto L60;
            T r56 = r55.next();
            Object r57 = ((ECHybridListItemVO) r56).d();
            if ((r57 instanceof com.bytedance.android.window.shop.repository.tab.entity.f) == true) goto L52;
            r57 = null;
        L52:
            com.bytedance.android.window.shop.repository.tab.entity.f r58 = (com.bytedance.android.window.shop.repository.tab.entity.f) r57;
            if (r58 != null) goto L55;
        L57:
            boolean r59 = false;
        L58:
            if (r59 == false) goto L48;
        L61:
            ECHybridListItemVO r60 = (ECHybridListItemVO) r56;
            if (r60 == null) goto L64;
            Object r61 = r60.d();
        L66:
            if ((r61 instanceof oq3.a) == true) goto L68;
            r61 = null;
        L68:
            oq3.a r62 = (oq3.a) r61;
            if (r62 == null) goto L81;
            List<uq3.d> r63 = r62.p;
            if (r63 == null) goto L81;
            uq3.d r64 = (uq3.d) CollectionsKt.firstOrNull(r63);
            if (r64 == null) goto L81;
            List<uq3.i> r65 = r64.c;
            if (r65 == null) goto L81;
            uq3.i r66 = (uq3.i) CollectionsKt.firstOrNull(r65);
            if (r66 == null) goto L81;
            String r67 = r66.b;
            if (r67 == null) goto L81;
            String r68 = StringsKt.trim(r67).toString();
        L82:
            if (r68 != null) goto L84;
        L87:
            boolean r69 = true;
        L88:
            if (r69 == false) goto L90;
            r48.setVisibility(8);
            goto L91
        L90:
            r48.setVisibility(0);
            r48.setText(r68);
            goto L91
        L84:
            if (r68.length() == 0) goto L87;
            r69 = false;
        L81:
            r68 = null;
            goto L82
        L55:
            if (r58.i != 701) goto L57;
            r59 = true;
            goto L58
        L60:
            r56 = null;
            goto L61
        L41:
            r52 = null;
        L64:
            r61 = null;
            goto L66
        L12:
            if (r0.d0() == false) goto L25;
            StringBuilder r70 = new StringBuilder();
            if (r3 != null) goto L16;
            r3 = "";
        L16:
            r70.append(r3);
            zn.b<uq3.a> r71 = r0.O().getHeaderResponse();
            if (r71 == null) goto L23;
            uq3.a r72 = (uq3.a) r71.getValue();
            if (r72 == null) goto L23;
            uq3.o r73 = r72.c;
            if (r73 == null) goto L23;
            String r74 = r73.l;
        L24:
            r70.append(r74);
            r3 = r70.toString();
        L23:
            r74 = null;
            goto L24
        L8:
            r3 = null;
            goto L9
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ ECWindowInfoPresenterBase a;

        public g(ECWindowInfoPresenterBase r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            ECWindowInfoPresenterBase r0 = this.a;
            boolean r5 = ((Boolean) r4).booleanValue();
            ECWindowInfoPresenterBase r1 = this.a;
            r0.j0(r5, r1.s, r1.t);
        }
    }

    static {
    }

    public final void C() {
        this.w.b();
        if (d0() == false) goto L9;
        ECWindowLiveCircleView r0 = w().b(2131376366).f();
        ValueAnimator r1 = r0.i;
        if (r1 == null) goto L9;
        if (r1.isRunning() == false) goto L9;
        r0.i.cancel();
    L9:
        ECLiveHybridUtil.p("ecom.shop.follow_status_update", this.A);
        ECLiveHybridUtil.p("ecom.fans_club.join_result", this.B);
        ECLiveHybridUtil.p("ecom.fans_club.exit_result", this.C);
        ECLiveHybridUtil.p("ecom.fans_club.update_info", this.D);
        com.bytedance.android.ec.core.utils.s0.e(this);
    }

    public final boolean d0() {
        SimpleDraweeView r0 = this.v;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("headImg");
    L6:
        return Intrinsics.areEqual((String) r0.getTag(), "scene_head");
    }

    public final void f0() {
        if (this.r == true) goto L5;
    L20:
        Integer r0 = O().getShopParam().getFollowStatus();
        if (r0 == null) goto L51;
        int r1 = r0.intValue();
        if (r1 == 0) goto L34;
        if (r1 != 1) goto L42;
        ECWindowApi.a.getClass();
        ECWindowApi r7 = ECWindowApi.a.a;
        if (r7 == null) goto L33;
        Observable<WindowFollowDeleteDTO> r8 = r7.unfollowShop(O().getShopParam().getSecAuthorId(), null);
        if (r8 == null) goto L33;
        Observable r9 = bg4.b.b(r8);
        if (r9 == null) goto L33;
        r9.subscribe(new f1(this), new g1(this));
    L33:
        int r10 = com.bytedance.android.ec.window.base.utils.i.a;
        com.bytedance.android.ec.window.base.utils.i.e(O().getEntranceInfoJsonObject(), "unfollow", null, MapsKt.mapOf(TuplesKt.to("shop_id", O().getShopParam().getAuthorId())), "shop_window_ad");
    L42:
        if (r1 != 0) goto L44;
        String r4 = u().c().getString(2131896796);
    L45:
        ECWindowViewModel r5 = O();
        int r6 = com.bytedance.android.ec.window.base.utils.i.a;
        r5.doEventAction("click_store_follow", new Pair[]{TuplesKt.to("button_status", r4), com.bytedance.android.ec.window.base.utils.i.a("a1.b7635.c2240.d9340", false)});
        if (r1 != 0) goto L52;
        boolean r2 = com.bytedance.android.ec.window.base.shop.j.a;
        com.bytedance.android.ec.window.base.shop.j.b("window_follow_kol", PostActionType.DO);
        return;
    L52:
        return;
    L44:
        r4 = u().c().getString(2131896742);
        goto L45
    L34:
        ECWindowApi.a.getClass();
        ECWindowApi r11 = ECWindowApi.a.a;
        if (r11 == null) goto L41;
        Observable<WindowFollowCommitDTO> r12 = r11.followShop(O().getShopParam().getSecAuthorId(), null, "header", null);
        if (r12 == null) goto L41;
        Observable r13 = bg4.b.b(r12);
        if (r13 == null) goto L41;
        r13.subscribe(new h1(this), new i1(this));
    L41:
        int r14 = com.bytedance.android.ec.window.base.utils.i.a;
        com.bytedance.android.ec.window.base.utils.i.e(O().getEntranceInfoJsonObject(), "follow", null, MapsKt.mapOf(TuplesKt.to("shop_id", O().getShopParam().getAuthorId())), "shop_window_ad");
        goto L42
    L51:
        return;
    L5:
        if (Intrinsics.areEqual((Boolean) O().isFollowed().getValue(), Boolean.TRUE) == false) goto L20;
        ECWindowFansClubPlugin r3 = (ECWindowFansClubPlugin) this.z.getValue();
        String r15 = this.t;
        WindowFansClubInfo r16 = r3.f.getShopParam().getFansClubInfo();
        if (r16 == null) goto L49;
        String r17 = r16.getFansClubUrl();
        if (r17 != null) goto L12;
        return;
    L12:
        if (r3.c == false) goto L15;
        r17 = w36.a.c(UriProtector.parse(r17), ECWindowFansClubPlugin.i).toString();
    L15:
        com.bytedance.android.ec.core.utils.m0 r18 = new com.bytedance.android.ec.core.utils.m0(r17);
        r18.b("author_id", r3.f.getShopParam().getAuthorId());
        String r19 = r18.c();
        int r20 = zq3.f.a;
        Activity r21 = r3.e;
        zq3.f.b(r21, r3.f, r19, "a1.b7635.c2240.d9340", PageFinder.via(r21), null);
        ECWindowViewModel r22 = r3.f;
        Pair[] r23 = new Pair[5];
        r23[0] = TuplesKt.to("fans_club_type", "ecom_fans_club");
        r23[1] = TuplesKt.to("fans_club_channel", "window");
        r23[2] = TuplesKt.to("entrance_location", r3.f.getShopParam().getEntranceLocation());
        if (com.bytedance.android.shopping.extensions.k.c(r15) == false) goto L18;
        String r24 = "level_" + r15;
    L19:
        r23[3] = TuplesKt.to("ecom_fans_status", r24);
        r23[4] = TuplesKt.to("anchor_id", r3.f.getShopParam().getAuthorId());
        r22.doEventAction("livesdk_ecom_fans_club_entrance_click", r23);
        return;
    L18:
        r24 = "not_in";
        goto L19
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        if (this.s == false) goto L12;
        ECWindowApi.a.getClass();
        ECWindowApi r0 = ECWindowApi.a.a;
        if (r0 == null) goto L13;
        Observable<ECWindowFansClubResponse> r1 = r0.getFansClubInfo(O().getShopParam().getAuthorId(), Integer.valueOf(WindowFansClubScene.Window.ordinal()), Boolean.TRUE);
        if (r1 == null) goto L14;
        Observable r2 = bg4.b.b(r1);
        if (r2 == null) goto L15;
        r2.subscribe(new j1(this), k1.a);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public ECWindowInfoPresenterBase() {
        this.m = 1461065763;
        this.n = (int) 4294925412L;
        this.o = (int) 4294914884L;
        this.p = 253106211;
        this.q = new int[]{872349776, 872349776};
        this.w = new com.bytedance.android.window.shop.home.tab.tabplugin.f();
        this.x = LazyKt.lazy(new ECWindowInfoPresenterBase$followIcon$2(this));
        this.y = LazyKt.lazy(new ECWindowInfoPresenterBase$followIconDelegate$2(this));
        this.z = LazyKt.lazy(new ECWindowInfoPresenterBase$fansClubPlugin$2(this));
        this.A = new e(this);
        this.B = new d(this);
        this.C = new b(this);
        this.D = new c(this);
    }

    public final void h0() {
        if (T() == true) goto L6;
        return;
    L6:
        if (com.bytedance.android.shopping.extensions.k.c(O().getShopParam().getAuthorId()) == false) goto L14;
        String r0 = "aweme://user/profile/" + O().getShopParam().getAuthorId();
        com.bytedance.android.ec.sdk.helper.p r1 = com.bytedance.android.ec.sdk.helper.p.a;
        QContext r2 = u();
        Context r3 = com.bytedance.android.ec.core.utils.l0.c(r2.c());
        if ((r3 instanceof FragmentActivity) == true) goto L10;
        r3 = null;
    L10:
        if (r3 != null) goto L12;
        r3 = r2.a();
    L12:
        r1.openSchema(r3, r0);
        return;
    }

    public void i0() {
        if (d0() == true) goto L5;
    L7:
        h0();
        return;
    L5:
        if (F() == false) goto L7;
        O().getOpenLiveByHeadClick().setValue(Boolean.TRUE);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        U().getLifecycle().removeObserver(this);
    }

    public int b0() {
        return this.p;
    }

    public int c0() {
        return this.m;
    }

    public static final /* synthetic */ ViewGroup Z(ECWindowInfoPresenterBase r1) {
        ViewGroup r2 = r1.u;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("shopNameWrapper");
    L5:
        return r2;
    }

    public static final void a0(ECWindowInfoPresenterBase r2) {
        r2.getClass();
        com.bytedance.android.ec.core.utils.s0.a(new com.bytedance.android.window.shop.home.tab.tabplugin.a(r2.O().getShopParam().getSecAuthorId(), null, null, null));
    }

    public void A(QModel r6) {
        U().getLifecycle().addObserver(this);
        this.u = (ViewGroup) w().b(2131378860).f();
        this.v = w().b(2131376605).f();
        O().getHeaderResponse().a(U(), new f(this), false);
        com.bytedance.android.ec.core.utils.s0.c(this);
        O().isFollowed().a(U(), new g(this), false);
        this.w.a(new com.bytedance.android.window.shop.home.tab.tabplugin.e[]{new ECWindowFollowFromCouponPlugin(new ECWindowInfoPresenterBase$bindPlugins$1(this), new ECWindowInfoPresenterBase$bindPlugins$2(this))});
    }

    public final void e0(boolean r4) {
        if (d0() == false) goto L5;
        WindowFollowStateChangedEvent.FollowSource r0 = WindowFollowStateChangedEvent.FollowSource.TOP_BAR;
    L6:
        Function1<hp3.b, Boolean> r1 = O().getEventDeliverer();
        if (r1 == null) goto L9;
        int r2 = WindowFollowStateChangedEvent.a;
        Intrinsics.checkNotNullParameter(r0, "source");
        String r3 = r0.getArea();
        Boolean r5 = (Boolean) r1.invoke(new WindowFollowStateChangedEvent.a(r4 ? 1 : 0, r3));
    L9:
        O().isFollowed().setValue(Boolean.valueOf(r4));
        O().getShopParam().setFollowStatus(Integer.valueOf(r4 ? 1 : 0));
        if (d0() == true) goto L13;
        w().b(2131370896).c();
        return;
    L13:
        return;
    L5:
        r0 = WindowFollowStateChangedEvent.FollowSource.INFO_AREA;
        goto L6
    }

    @Subscribe
    public final void onCartCountChanged(bp3.b r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        O().getShopParam().setFollowStatus(Integer.valueOf(r3.a));
        boolean r0 = true;
        if (r3.a == 1) goto L6;
        r0 = false;
    L6:
        e0(r0);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        Intrinsics.checkNotNullParameter(r5, "v");
        int r0 = rp.a.a;
        if (rp.a.a(r5.getId()) == false) goto L5;
        return;
    L5:
        int r6 = r5.getId();
        if (r6 != 2131376605) goto L9;
        i0();
        return;
    L9:
        if (r6 != 2131378860) goto L24;
        ECWindowParam r7 = ECQuickUtilKt.d(u(), ECWindowViewModel.class, ECWindowDialogFragment.class).getShopParam();
        BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b7635.c2240.d8972", Boolean.TRUE).withView(y()).build());
        uq3.a r1 = (uq3.a) ECQuickUtilKt.d(u(), ECWindowViewModel.class, ECWindowDialogFragment.class).getHeaderResponse().getValue();
        if (r1 == null) goto L16;
        uq3.o r2 = r1.c;
        if (r2 == null) goto L16;
        String r3 = r2.o;
        if (r3 == null) goto L16;
    L17:
        com.bytedance.android.ec.sdk.helper.p r8 = com.bytedance.android.ec.sdk.helper.p.a;
        QContext r4 = u();
        Context r9 = com.bytedance.android.ec.core.utils.l0.c(r4.c());
        if ((r9 instanceof FragmentActivity) == true) goto L20;
        r9 = null;
    L20:
        if (r9 != null) goto L22;
        r9 = r4.a();
    L22:
        r8.openSchema(r9, r3);
        return;
    L16:
        int r10 = WindowSettingKeys.a.a;
        r3 = WindowSettingKeys.a.b(r7.getPageName(), r7.getAuthorId(), r7.getSecAuthorId(), r7.getFollowStatus());
        goto L17
    L24:
        if (r6 != 2131370894) goto L27;
        f0();
        return;
    L27:
        if (r6 == 2131371307) goto L29;
        return;
    L29:
        if ((!Intrinsics.areEqual((Boolean) O().isFollowed().getValue(), Boolean.TRUE)) == false) goto L36;
        f0();
        return;
    }

    public final void j0(boolean r9, boolean r10, String r11) {
        int r2 = 0;
        if (this.r == false) goto L6;
        if (r9 == false) goto L6;
        boolean r0 = true;
    L7:
        View r3 = w().b(2131370894).f();
        GradientDrawable r4 = new GradientDrawable();
        com.bytedance.android.ec.window.base.utils.c.f(r4, GradientDrawable.Orientation.TL_BR);
        r4.setCornerRadius(com.bytedance.android.ec.core.utils.q.a(6));
        if (r0 == false) goto L10;
        com.bytedance.android.ec.window.base.utils.c.e(r4, this.q);
    L15:
        if (d0() == true) goto L18;
        r3 = w().b(2131370895).f();
    L18:
        Intrinsics.checkNotNullParameter(r3, "$this$setBackgroundCompat");
        r3.setBackground(r4);
        r3.requestLayout();
        if (r0 == true) goto L21;
        w().b(2131370897).f().setVisibility(0);
        w().b(2131370891).f().setVisibility(8);
        TextView r12 = (TextView) w().b(2131370899).f();
        if (r9 == false) goto L41;
        CharSequence r13 = u().c().getText(2131896742);
    L42:
        r12.setText(r13);
        r12.getPaint().setFakeBoldText(!r9);
        if (r9 == false) goto L45;
        int r14 = c0();
    L46:
        r12.setTextColor(r14);
        ImageView r15 = (ImageView) w().b(2131370898).f();
        if (r9 == false) goto L49;
        r2 = 8;
    L49:
        r15.setVisibility(r2);
        return;
    L45:
        r14 = -1;
        goto L46
    L41:
        r13 = u().c().getText(2131896751);
        goto L42
    L21:
        if (d0() == true) goto L23;
        ((ECWindowFansClubPlugin) this.z.getValue()).h();
    L23:
        w().b(2131370897).f().setVisibility(8);
        w().b(2131370891).f().setVisibility(0);
        ImageView r16 = (ImageView) w().b(2131370892).f();
        if (r10 == false) goto L26;
        Drawable r1 = th.a.b(u().c(), 2131234822);
    L27:
        r16.setImageDrawable(r1);
        TextView r17 = (TextView) w().b(2131370893).f();
        if (r10 == true) goto L30;
    L32:
        r17.setVisibility(8);
    L33:
        ECWindowViewModel r18 = O();
        Pair[] r19 = new Pair[5];
        r19[0] = TuplesKt.to("fans_club_type", "ecom_fans_club");
        r19[1] = TuplesKt.to("fans_club_channel", "window");
        r19[2] = TuplesKt.to("entrance_location", O().getShopParam().getEntranceLocation());
        if (com.bytedance.android.shopping.extensions.k.c(r11) == false) goto L36;
        String r110 = "level_" + r11;
    L37:
        r19[3] = TuplesKt.to("ecom_fans_status", r110);
        r19[4] = TuplesKt.to("anchor_id", O().getShopParam().getAuthorId());
        r18.doEventAction("livesdk_ecom_fans_club_icon_show", r19);
        return;
    L36:
        r110 = "not_in";
        goto L37
    L30:
        if (com.bytedance.android.shopping.extensions.k.c(r11) == false) goto L32;
        r17.setVisibility(0);
        r17.setText(r11);
        goto L33
    L26:
        r1 = th.a.b(u().c(), 2131234823);
        goto L27
    L10:
        if (r9 == false) goto L12;
        int[] r6 = {b0(), b0()};
    L13:
        com.bytedance.android.ec.window.base.utils.c.e(r4, r6);
        goto L15
    L12:
        r6 = new int[]{this.n, this.o};
    L6:
        r0 = false;
        goto L7
    }
}
