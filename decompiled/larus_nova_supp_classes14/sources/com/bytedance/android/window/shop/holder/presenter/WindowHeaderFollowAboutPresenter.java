package com.bytedance.android.window.shop.holder.presenter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleObserver;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.core.utils.m0;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.window.base.shop.ECWindowBubblePrompt;
import com.bytedance.android.ec.window.base.shop.WindowFansClubBubbleConfig;
import com.bytedance.android.ec.window.base.shop.WindowFansClubInfo;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.android.window.shop.eventcard.windowevent.staticevent.WindowFollowStateChangedEvent;
import com.bytedance.android.window.shop.home.presenter.plugin.ECWindowFansClubPlugin;
import com.bytedance.android.window.shop.home.presenter.plugin.ECWindowFollowFromCouponPlugin;
import com.bytedance.android.window.shop.home.presenter.plugin.ECWindowInfoAreaBubblePlugin;
import com.bytedance.android.window.shop.home.presenter.plugin.ECWindowUpdateAllTabPlugin;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.repository.api.ECWindowApi;
import com.bytedance.android.window.shop.repository.dto.WindowFollowCommitDTO;
import com.bytedance.android.window.shop.repository.dto.WindowFollowDeleteDTO;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.facebook.drawee.view.GenericDraweeView;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\bJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/window/shop/holder/presenter/WindowHeaderFollowAboutPresenter;", "Lcom/bytedance/android/window/shop/holder/presenter/ECWindowHolderBaseFragmentPresenter;", "Landroid/view/View$OnClickListener;", "Landroidx/lifecycle/LifecycleObserver;", "Lbp3/b;", "event", "", "onCartCountChanged", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowHeaderFollowAboutPresenter extends ECWindowHolderBaseFragmentPresenter implements View.OnClickListener, LifecycleObserver {
    public static final /* synthetic */ int A = 0;
    public ECWindowBubblePrompt i;
    public boolean j;
    public boolean k;
    public String l;
    public oq3.a m;
    public final com.bytedance.android.window.shop.home.tab.tabplugin.f n;
    public Disposable o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final e v;
    public final d w;
    public final b x;
    public final c y;
    public final Lazy z;

    public static final class a {
    }

    public static final class b implements ti.j {
        public final /* synthetic */ WindowHeaderFollowAboutPresenter a;

        public b(WindowHeaderFollowAboutPresenter r1) {
            this.a = r1;
        }

        public final void a(JSONObject r4) {
            Intrinsics.checkNotNullParameter(r4, "params");
            boolean r0 = r4.optBoolean("success");
            if ((!Intrinsics.areEqual(r4.optString("author_id"), this.a.d0().getShopParam().getAuthorId())) == false) goto L5;
            return;
        L5:
            if (r0 == false) goto L8;
            WindowHeaderFollowAboutPresenter r5 = this.a;
            r5.k = false;
            r5.n0(true, false, null);
            return;
        }
    }

    public static final class c implements ti.j {
        public final /* synthetic */ WindowHeaderFollowAboutPresenter a;

        public c(WindowHeaderFollowAboutPresenter r1) {
            this.a = r1;
        }

        public final void a(JSONObject r4) {
            Intrinsics.checkNotNullParameter(r4, "params");
            String r0 = r4.optString("author_id");
            int r5 = r4.optInt("level");
            if ((!Intrinsics.areEqual(r0, this.a.d0().getShopParam().getAuthorId())) == false) goto L6;
            return;
        L6:
            if ((!Intrinsics.areEqual(String.valueOf(r5), this.a.l)) == false) goto L9;
            this.a.n0(true, true, String.valueOf(r5));
            return;
        }
    }

    public static final class d implements ti.j {
        public final /* synthetic */ WindowHeaderFollowAboutPresenter a;

        public d(WindowHeaderFollowAboutPresenter r1) {
            this.a = r1;
        }

        public final void a(JSONObject r4) {
            Intrinsics.checkNotNullParameter(r4, "params");
            boolean r0 = r4.optBoolean("success");
            String r1 = r4.optString("author_id");
            int r5 = r4.optInt("level");
            if ((!Intrinsics.areEqual(r1, this.a.d0().getShopParam().getAuthorId())) == false) goto L5;
            return;
        L5:
            if (r0 == false) goto L14;
            WindowHeaderFollowAboutPresenter r2 = this.a;
            r2.k = true;
            r2.l = String.valueOf(r5);
            Integer r6 = this.a.d0().getShopParam().getFollowStatus();
            if (r6 != null) goto L10;
        L12:
            WindowHeaderFollowAboutPresenter r7 = this.a;
            r7.n0(true, true, r7.l);
            return;
        L10:
            if (r6.intValue() != 0) goto L12;
            this.a.d0().getShopParam().setFollowStatus(1);
            this.a.d0().isFollowed().c(Boolean.TRUE);
            goto L12
        }
    }

    public static final class e implements ti.j {
        public final /* synthetic */ WindowHeaderFollowAboutPresenter a;

        public e(WindowHeaderFollowAboutPresenter r1) {
            this.a = r1;
        }

        public final void a(JSONObject r5) {
            Intrinsics.checkNotNullParameter(r5, "params");
            int r0 = r5.optInt("follow_status");
            int r6 = r5.optInt("update_from_remote");
            WindowHeaderFollowAboutPresenter r1 = this.a;
            if (r0 != 1) goto L5;
            boolean r2 = true;
        L6:
            int r3 = WindowHeaderFollowAboutPresenter.A;
            r1.l0(r2);
            if (r6 != 1) goto L10;
            this.a.d0().loadHeaderInfo();
            return;
        L10:
            return;
        L5:
            r2 = false;
            goto L6
        }
    }

    static {
    }

    public final LottieAnimationView k0() {
        return (LottieAnimationView) this.r.getValue();
    }

    public final void c0() {
        this.n.b();
        Disposable r0 = this.o;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        ECLiveHybridUtil.p("ecom.shop.follow_status_update", this.v);
        ECLiveHybridUtil.p("ecom.fans_club.join_result", this.w);
        ECLiveHybridUtil.p("ecom.fans_club.exit_result", this.x);
        ECLiveHybridUtil.p("ecom.fans_club.update_info", this.y);
        s0.e(this);
    }

    public final String j0() {
        return "ec_store_flag_fans_bubble_displayed_" + ((String) this.q.getValue());
    }

    public final void m0() {
        Context r4 = null;
        if (this.j == true) goto L5;
    L21:
        Integer r0 = d0().getShopParam().getFollowStatus();
        if (r0 == null) goto L79;
        int r1 = r0.intValue();
        if (r1 == 0) goto L35;
        if (r1 != 1) goto L69;
        ECWindowApi.a.getClass();
        ECWindowApi r8 = ECWindowApi.a.a;
        if (r8 == null) goto L34;
        Observable<WindowFollowDeleteDTO> r9 = r8.unfollowShop(d0().getShopParam().getSecAuthorId(), null);
        if (r9 == null) goto L34;
        Observable r10 = bg4.b.b(r9);
        if (r10 == null) goto L34;
        r10.subscribe(new m(this), new n(this));
    L34:
        int r11 = com.bytedance.android.ec.window.base.utils.i.a;
        com.bytedance.android.ec.window.base.utils.i.e(d0().getEntranceInfoJsonObject(), "unfollow", null, MapsKt.mapOf(TuplesKt.to("shop_id", d0().getShopParam().getAuthorId())), "shop_window_ad");
    L69:
        if (r1 != 0) goto L71;
        String r5 = Y().c().getString(2131896796);
    L72:
        ECWindowViewModel r6 = d0();
        int r3 = com.bytedance.android.ec.window.base.utils.i.a;
        r6.doEventAction("click_store_follow", new Pair[]{TuplesKt.to("button_status", r5), com.bytedance.android.ec.window.base.utils.i.a("a1.b7635.c2240.d9340", true)});
        if (r1 != 0) goto L80;
        boolean r2 = com.bytedance.android.ec.window.base.shop.j.a;
        com.bytedance.android.ec.window.base.shop.j.b("window_follow_kol", PostActionType.DO);
        return;
    L80:
        return;
    L71:
        r5 = Y().c().getString(2131896742);
        goto L72
    L35:
        ViewGroup r12 = (ViewGroup) a0().findViewById(2131370894);
        if (r12 == null) goto L38;
        View r13 = r12.findViewById(2131370898);
    L39:
        if (r12 == null) goto L41;
        View r14 = r12.findViewById(2131370899);
    L42:
        if (r12 != null) goto L44;
        View r15 = null;
    L48:
        if (r14 == null) goto L50;
        r14.setVisibility(8);
    L50:
        if (r13 == null) goto L52;
        r13.setVisibility(8);
    L52:
        if (r15 == null) goto L54;
        r15.setVisibility(0);
    L54:
        oq3.a r16 = this.m;
        if (r16 == null) goto L57;
        ECUrlModel r17 = r16.t;
    L58:
        if (r17 != null) goto L60;
        String r18 = null;
    L61:
        ECWindowApi.a.getClass();
        ECWindowApi r19 = ECWindowApi.a.a;
        if (r19 == null) goto L68;
        Observable<WindowFollowCommitDTO> r20 = r19.followShop(d0().getShopParam().getSecAuthorId(), null, r18, null);
        if (r20 == null) goto L68;
        Observable r21 = bg4.b.b(r20);
        if (r21 == null) goto L68;
        r21.subscribe(new o(this, r13, r14), new p(this, r14, r13), new q(r15));
    L68:
        int r22 = com.bytedance.android.ec.window.base.utils.i.a;
        com.bytedance.android.ec.window.base.utils.i.e(d0().getEntranceInfoJsonObject(), "follow", null, MapsKt.mapOf(TuplesKt.to("shop_id", d0().getShopParam().getAuthorId())), "shop_window_ad");
        goto L69
    L60:
        r18 = "header";
        goto L61
    L57:
        r17 = null;
        goto L58
    L44:
        View r110 = r12.findViewById(((Number) this.t.getValue()).intValue());
        r15 = r110;
        if (r110 != null) goto L48;
        ProgressBar r111 = new ProgressBar(a0().getContext());
        r111.setIndeterminateDrawable(th.a.f(a0().getContext()).getDrawable(2131234881, null));
        r111.setIndeterminate(true);
        r111.setId(((Number) this.t.getValue()).intValue());
        FrameLayout.LayoutParams r112 = new FrameLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(12));
        r112.gravity = 17;
        Unit r113 = Unit.INSTANCE;
        r12.addView(r111, r112);
        r15 = r111;
        goto L48
    L41:
        r14 = null;
        goto L42
    L38:
        r13 = null;
        goto L39
    L79:
        return;
    L5:
        if (Intrinsics.areEqual((Boolean) d0().isFollowed().getValue(), Boolean.TRUE) == false) goto L21;
        WindowFansClubInfo r7 = d0().getShopParam().getFansClubInfo();
        if (r7 == null) goto L76;
        String r23 = r7.getFansClubUrl();
        if (r23 == null) goto L77;
        m0 r24 = new m0(r23);
        r24.b("author_id", d0().getShopParam().getAuthorId());
        String r25 = r24.c();
        int r26 = zq3.f.a;
        String r27 = zq3.f.c(r25, "a1.b7635.c2240.d9340", PageFinder.via(a0()), null);
        com.bytedance.android.ec.sdk.helper.p r28 = com.bytedance.android.ec.sdk.helper.p.a;
        QContext r29 = Y();
        Context r30 = l0.c(r29.c());
        if ((r30 instanceof FragmentActivity) == false) goto L14;
        r4 = r30;
    L14:
        if (r4 != null) goto L16;
        r4 = r29.a();
    L16:
        r28.openSchema(r4, r27);
        ECWindowViewModel r31 = d0();
        Pair[] r32 = new Pair[5];
        r32[0] = TuplesKt.to("fans_club_type", "ecom_fans_club");
        r32[1] = TuplesKt.to("fans_club_channel", "window");
        r32[2] = TuplesKt.to("entrance_location", d0().getShopParam().getEntranceLocation());
        if (com.bytedance.android.shopping.extensions.k.c(this.l) == false) goto L19;
        String r33 = "level_" + this.l;
    L20:
        r32[3] = TuplesKt.to("ecom_fans_status", r33);
        r32[4] = TuplesKt.to("anchor_id", d0().getShopParam().getAuthorId());
        r31.doEventAction("livesdk_ecom_fans_club_entrance_click", r32);
        return;
    L19:
        r33 = "not_in";
        goto L20
    L77:
        return;
    }

    public WindowHeaderFollowAboutPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.n = new com.bytedance.android.window.shop.home.tab.tabplugin.f();
        this.p = LazyKt.lazy(new WindowHeaderFollowAboutPresenter$sharedPrefHelper$2(this));
        this.q = LazyKt.lazy(WindowHeaderFollowAboutPresenter$currentLoginSecUserId$2.INSTANCE);
        this.r = LazyKt.lazy(new WindowHeaderFollowAboutPresenter$followIcon$2(this));
        this.s = LazyKt.lazy(new WindowHeaderFollowAboutPresenter$followIconWrapper$2(this));
        this.t = LazyKt.lazy(WindowHeaderFollowAboutPresenter$followActionLoadingViewId$2.INSTANCE);
        this.u = LazyKt.lazy(new WindowHeaderFollowAboutPresenter$fansClubPlugin$2(this));
        this.v = new e(this);
        this.w = new d(this);
        this.x = new b(this);
        this.y = new c(this);
        this.z = LazyKt.lazy(new WindowHeaderFollowAboutPresenter$dialogFragment$2(this));
    }

    public static final void i0(WindowHeaderFollowAboutPresenter r2) {
        r2.getClass();
        s0.a(new com.bytedance.android.window.shop.home.tab.tabplugin.a(r2.d0().getShopParam().getSecAuthorId(), null, null, null));
    }

    public final void b0(QModel r10) {
        e0().getLifecycle().addObserver(this);
        WindowFansClubBubbleConfig r1 = null;
        if ((r10 instanceof oq3.a) == true) goto L5;
        r10 = null;
    L5:
        oq3.a r11 = (oq3.a) r10;
        if (r11 == null) goto L145;
        this.m = r11;
        View r12 = h0().findViewById(2131370894);
        uq3.a r2 = (uq3.a) d0().getHeaderResponse().getValue();
        if (r2 == null) goto L12;
        uq3.o r3 = r2.c;
        if (r3 == null) goto L12;
        Boolean r4 = r3.p;
    L13:
        Boolean r5 = Boolean.TRUE;
        if (Intrinsics.areEqual(r4, r5) == false) goto L43;
        r12.setVisibility(0);
        r12.setOnClickListener(this);
        LottieAnimationView r13 = k0();
        if (r13 == null) goto L18;
        r13.setAnimation("ec_window_follow_animation.json");
    L18:
        zn.b<Boolean> r14 = d0().isFollowed();
        if (r14 == null) goto L21;
        Boolean r15 = (Boolean) r14.getValue();
    L22:
        if (r15 != r5) goto L26;
        LottieAnimationView r16 = k0();
        if (r16 == null) goto L29;
        r16.setProgress(1.0f);
    L29:
        d0().isFollowed().a(e0(), new s(this), false);
        View r17 = (View) this.s.getValue();
        if (r17 == null) goto L32;
        r17.setOnClickListener(this);
    L32:
        String r18 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b7635.c2240.d9340", Boolean.FALSE).withView(a0()).build());
        ECWindowViewModel r6 = d0();
        Pair[] r7 = new Pair[2];
        oq3.a r8 = this.m;
        if (r8 == null) goto L35;
        Integer r9 = r8.v;
    L36:
        if (r9 != null) goto L39;
    L41:
        String r19 = "已关注";
    L42:
        r7[0] = TuplesKt.to("button_status", r19);
        r7[1] = TuplesKt.to("btm_id", r18);
        r6.doEventAction("show_store_follow", r7);
    L47:
        uq3.a r110 = (uq3.a) d0().getHeaderResponse().getValue();
        if (r110 == null) goto L52;
        uq3.o r111 = r110.c;
        if (r111 == null) goto L52;
        WindowFansClubInfo r112 = r111.n;
    L53:
        if (r112 == null) goto L55;
        boolean r20 = r112.getOpenFansClub();
    L56:
        this.j = r20;
        if (r112 == null) goto L59;
        boolean r21 = r112.getJoinStatus();
    L60:
        this.k = r21;
        if (r112 == null) goto L63;
        Integer r113 = r112.getFansClubLevel();
    L64:
        this.l = String.valueOf(r113);
        h0().findViewById(2131370894).setOnClickListener(this);
        ECLiveHybridUtil.m("ecom.shop.follow_status_update", this.v);
        ECLiveHybridUtil.m("ecom.fans_club.join_result", this.w);
        ECLiveHybridUtil.m("ecom.fans_club.exit_result", this.x);
        ECLiveHybridUtil.m("ecom.fans_club.update_info", this.y);
        s0.c(this);
        d0().isFollowed().a(e0(), new r(this), false);
        oq3.a r114 = this.m;
        if (r114 == null) goto L67;
        Integer r115 = r114.v;
    L68:
        if (r115 != null) goto L71;
    L73:
        boolean r116 = false;
    L74:
        n0(r116, this.k, this.l);
        ECWindowBubblePrompt r117 = this.i;
        if (r117 != null) goto L77;
    L78:
        WindowFansClubInfo r118 = d0().getShopParam().getFansClubInfo();
        if (r118 == null) goto L85;
        WindowFansClubBubbleConfig r119 = r118.getFansClubBubbleConfig();
        if (r119 == null) goto L85;
        Integer r120 = r119.getShowLimit();
        if (r120 == null) goto L85;
        int r121 = r120.intValue();
    L87:
        if (((SharedPrefHelper) this.p.getValue()).h(j0(), 0) >= r121) goto L89;
        boolean r122 = true;
    L90:
        if (r122 == false) goto L143;
        WindowFansClubInfo r123 = d0().getShopParam().getFansClubInfo();
        if (r123 == null) goto L94;
        WindowFansClubBubbleConfig r124 = r123.getFansClubBubbleConfig();
    L95:
        if (r124 == null) goto L143;
        Integer r125 = d0().getShopParam().getFollowStatus();
        if (r125 != null) goto L100;
    L101:
        WindowFansClubInfo r126 = d0().getShopParam().getFansClubInfo();
        if (r126 != null) goto L104;
    L105:
        WindowFansClubInfo r127 = d0().getShopParam().getFansClubInfo();
        if (r127 == null) goto L111;
        if (r127.getOpenFansClub() == false) goto L143;
    L111:
        if (h0().findViewById(2131370897).getVisibility() != 0) goto L143;
        final View r128 = a0().findViewById(2131370895);
        if (r128 != null) goto L117;
        r128 = h0().findViewById(2131370894);
    L117:
        if (this.i != null) goto L131;
        QContext r22 = Y();
        Activity r23 = l0.c(r22.c());
        if ((r23 instanceof FragmentActivity) == true) goto L121;
        r23 = null;
    L121:
        if (r23 != null) goto L123;
        r23 = r22.a();
    L123:
        ECWindowBubblePrompt r0 = new ECWindowBubblePrompt(r23);
        WindowFansClubInfo r24 = d0().getShopParam().getFansClubInfo();
        if (r24 == null) goto L126;
        String r25 = r24.getFansClubUrl();
    L127:
        WindowFansClubInfo r26 = d0().getShopParam().getFansClubInfo();
        if (r26 == null) goto L130;
        r1 = r26.getFansClubBubbleConfig();
    L130:
        r0.b(r25, r1, r128, new WindowHeaderFollowAboutPresenter$initFansGroupPromptBubble$$inlined$also$lambda$1(this, r128));
        Unit r27 = Unit.INSTANCE;
        this.i = r0;
        goto L131
    L126:
        r25 = null;
    L131:
        int r28 = ((SharedPrefHelper) this.p.getValue()).h(j0(), 0) + 1;
        WindowFansClubInfo r29 = d0().getShopParam().getFansClubInfo();
        if (r29 == null) goto L138;
        WindowFansClubBubbleConfig r30 = r29.getFansClubBubbleConfig();
        if (r30 == null) goto L138;
        Integer r31 = r30.getShowLimit();
        if (r31 == null) goto L138;
        int r32 = r31.intValue();
    L139:
        int r33 = Math.min(r28, r32);
        SharedPrefHelper r34 = (SharedPrefHelper) this.p.getValue();
        r34.l(j0(), Integer.valueOf(r33));
        r34.a();
        ECWindowBubblePrompt r35 = this.i;
        if (r35 == null) goto L142;
        r35.a(r128);
    L142:
        d0().doEventAction("ecom_fans_club_pop_show", new Pair[]{TuplesKt.to("fans_club_type", "ecom_fans_club"), TuplesKt.to("fans_club_channel", "window"), TuplesKt.to("entrance_location", d0().getShopParam().getEntranceLocation()), TuplesKt.to("ecom_fans_status", "not_in"), TuplesKt.to("anchor_id", d0().getShopParam().getAuthorId())});
    L138:
        r32 = 2;
        goto L139
    L104:
        if (r126.getJoinStatus() == true) goto L143;
    L100:
        if (r125.intValue() == 1) goto L143;
    L94:
        r124 = null;
    L143:
        Function0<String> r129 = new WindowHeaderFollowAboutPresenter$bindPlugins$getSecAuthorId$1(this);
        this.n.a(new com.bytedance.android.window.shop.home.tab.tabplugin.e[]{new ECWindowFollowFromCouponPlugin(r129, new WindowHeaderFollowAboutPresenter$bindPlugins$1(this)), new ECWindowUpdateAllTabPlugin(r129)});
        this.n.a(new com.bytedance.android.window.shop.home.tab.tabplugin.e[]{new ECWindowInfoAreaBubblePlugin(e0(), d0(), new WindowHeaderFollowAboutPresenter$bindPlugins$2(this)), (ECWindowFansClubPlugin) this.u.getValue()});
        return;
    L89:
        r122 = false;
    L85:
        r121 = 2;
        goto L87
    L77:
        if (r117.isShowing() == true) goto L143;
    L71:
        if (r115.intValue() != 1) goto L73;
        r116 = true;
        goto L74
    L67:
        r115 = null;
        goto L68
    L63:
        r113 = null;
        goto L64
    L59:
        r21 = false;
        goto L60
    L55:
        r20 = false;
    L52:
        r112 = null;
        goto L53
    L39:
        if (r9.intValue() != 0) goto L41;
        r19 = "未关注";
        goto L42
    L35:
        r9 = null;
        goto L36
    L26:
        LottieAnimationView r130 = k0();
        if (r130 == null) goto L29;
        r130.setProgress(0.0f);
        goto L29
    L21:
        r15 = null;
        goto L22
    L43:
        r12.setVisibility(8);
        View r131 = (View) this.s.getValue();
        if (r131 == null) goto L46;
        r131.setVisibility(8);
    L46:
        h0().findViewById(2131393031).setPadding(0, 0, com.bytedance.android.shopping.extensions.b.b(36), 0);
    L12:
        r4 = null;
        goto L13
    }

    public final void l0(boolean r4) {
        d0().isFollowed().setValue(Boolean.valueOf(r4));
        d0().getShopParam().setFollowStatus(Integer.valueOf(r4 ? 1 : 0));
        Function1<hp3.b, Boolean> r0 = d0().getEventDeliverer();
        if (r0 == null) goto L5;
        int r1 = WindowFollowStateChangedEvent.a;
        WindowFollowStateChangedEvent.FollowSource r2 = WindowFollowStateChangedEvent.FollowSource.INFO_AREA;
        Intrinsics.checkNotNullParameter(r2, "source");
        String r3 = r2.getArea();
        Boolean r5 = (Boolean) r0.invoke(new WindowFollowStateChangedEvent.a(r4 ? 1 : 0, r3));
    L5:
        h0().findViewById(2131370896).setVisibility(8);
    }

    @Subscribe
    public final void onCartCountChanged(bp3.b r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        d0().getShopParam().setFollowStatus(Integer.valueOf(r3.a));
        boolean r0 = true;
        if (r3.a == 1) goto L6;
        r0 = false;
    L6:
        l0(r0);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        int r0 = rp.a.a;
        if (rp.a.a(r2.getId()) == true) goto L16;
        Lazy r1 = ECAppInfoService.a;
        if (we.a.a == true) goto L20;
        int r3 = r2.getId();
        if (r3 != 2131370894) goto L11;
        m0();
        return;
    L11:
        if (r3 == 2131371307) goto L13;
        return;
    L13:
        if ((!Intrinsics.areEqual((Boolean) d0().isFollowed().getValue(), Boolean.TRUE)) == false) goto L19;
        m0();
        return;
    L19:
        return;
    L20:
        return;
    }

    public final void o0(boolean r14, ECUrlModel r15) {
        GenericDraweeView r0 = (ECDraweeView) h0().findViewById(2131370896);
        if (r14 == false) goto L14;
        if (r15 != null) goto L6;
        return;
    L6:
        ECDraweeView r5 = (ECDraweeView) h0().findViewById(2131370896);
        float r16 = RangesKt.coerceIn(r15.getWidth() / RangesKt.coerceAtLeast(r15.getHeight(), 1.0f), 0.1f, 1.0f);     // Catch: Exception -> L9
    L10:
        r5.setAspectRatio(r16);
        h0.d(r5, r15, d0().getImageCallerContext(), null, null, null, null, 120);
        r0.setVisibility(8);
        Integer[] r17 = com.bytedance.android.ec.window.base.common.uiext.b.a;
        Intrinsics.checkNotNullParameter(r0, "$this$showWithAnimations");
        com.bytedance.android.ec.window.base.common.uiext.b.a(r0, 3, 200, true);
        Disposable r18 = this.o;
        if (r18 == null) goto L13;
        r18.dispose();
    L13:
        this.o = Observable.timer(5000, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new k(this), l.a);
        return;
    L9:
        r16 = 0.0f;
        goto L10
    L14:
        Integer[] r19 = com.bytedance.android.ec.window.base.common.uiext.b.a;
        Intrinsics.checkNotNullParameter(r0, "$this$hideWithAnimations");
        com.bytedance.android.ec.window.base.common.uiext.b.a(r0, 3, 200, false);
    }

    public final void n0(boolean r9, boolean r10, String r11) {
        int r1 = 0;
        if (this.j == false) goto L6;
        if (r9 == false) goto L6;
        boolean r0 = true;
    L7:
        h0().findViewById(2131370894);
        View r3 = h0().findViewById(2131370895);
        if (r0 == true) goto L23;
        if (r9 == true) goto L23;
        uq3.a r5 = (uq3.a) d0().getHeaderResponse().getValue();
        if (r5 == null) goto L21;
        uq3.o r6 = r5.c;
        if (r6 == null) goto L21;
        Map<String, String> r7 = r6.q;
        if (r7 == null) goto L17;
        String r8 = r7.get("header_follow_style_strategy");
    L19:
        if (Intrinsics.areEqual(r8, "gray_alpha") != true) goto L21;
        int r12 = 2131234931;
    L22:
        com.bytedance.android.ec.window.base.utils.c.d(r3, th.a.f(a0().getContext()).getDrawable(r12, null));
    L31:
        r3.requestLayout();
        if (r0 == false) goto L48;
        ((ECWindowFansClubPlugin) this.u.getValue()).h();
        h0().findViewById(2131370897).setVisibility(8);
        h0().findViewById(2131370891).setVisibility(0);
        ImageView r13 = (ImageView) h0().findViewById(2131370892);
        if (r10 == false) goto L36;
        Drawable r2 = th.a.b(Y().c(), 2131234822);
    L37:
        r13.setImageDrawable(r2);
        TextView r14 = (TextView) h0().findViewById(2131370893);
        if (r10 == true) goto L40;
    L42:
        r14.setVisibility(8);
    L43:
        ECWindowViewModel r15 = d0();
        Pair[] r16 = new Pair[5];
        r16[0] = TuplesKt.to("fans_club_type", "ecom_fans_club");
        r16[1] = TuplesKt.to("fans_club_channel", "window");
        r16[2] = TuplesKt.to("entrance_location", d0().getShopParam().getEntranceLocation());
        if (com.bytedance.android.shopping.extensions.k.c(r11) == false) goto L46;
        String r17 = "level_" + r11;
    L47:
        r16[3] = TuplesKt.to("ecom_fans_status", r17);
        r16[4] = TuplesKt.to("anchor_id", d0().getShopParam().getAuthorId());
        r15.doEventAction("livesdk_ecom_fans_club_icon_show", r16);
        return;
    L46:
        r17 = "not_in";
        goto L47
    L40:
        if (com.bytedance.android.shopping.extensions.k.c(r11) == false) goto L42;
        r14.setVisibility(0);
        r14.setText(r11);
        goto L43
    L36:
        r2 = th.a.b(Y().c(), 2131234823);
        goto L37
    L48:
        h0().findViewById(2131370897).setVisibility(0);
        h0().findViewById(2131370891).setVisibility(8);
        TextView r18 = (TextView) h0().findViewById(2131370899);
        if (r9 == false) goto L51;
        CharSequence r19 = Y().c().getText(2131896742);
    L52:
        r18.setText(r19);
        r18.getPaint().setFakeBoldText(!r9);
        if (r9 == false) goto L55;
        int r110 = -1073741825;
    L56:
        r18.setTextColor(r110);
        ImageView r111 = (ImageView) h0().findViewById(2131370898);
        if (r9 == false) goto L59;
        r1 = 8;
    L59:
        r111.setVisibility(r1);
        return;
    L55:
        r110 = -1;
        goto L56
    L51:
        r19 = Y().c().getText(2131896751);
        goto L52
    L17:
        r8 = null;
    L21:
        r12 = 2131234930;
    L23:
        GradientDrawable r20 = new GradientDrawable();
        com.bytedance.android.ec.window.base.utils.c.f(r20, GradientDrawable.Orientation.TL_BR);
        r20.setCornerRadius(com.bytedance.android.shopping.extensions.b.b(14));
        if (r0 == false) goto L26;
        com.bytedance.android.ec.window.base.utils.c.e(r20, new int[]{-5138, -5138});
    L30:
        com.bytedance.android.ec.window.base.utils.c.d(r3, r20);
        goto L31
    L26:
        if (r9 == false) goto L28;
        int[] r21 = {1275068415, 1275068415};
    L29:
        com.bytedance.android.ec.window.base.utils.c.e(r20, r21);
        goto L30
    L28:
        r21 = new int[]{-41884, -52412};
    L6:
        r0 = false;
        goto L7
    }
}
