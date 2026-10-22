package sg2;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService;
import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import com.bytedance.android.ec.core.hybrid.ECBridgeProviderInjector;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.ECLiveEntranceMonitor;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.live.LiveClearScreenMode;
import com.bytedance.android.ec.model.live.LiveScreenMoveMode;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.ec.model.response.ECPromotionCampaign;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.dynamiccontext.LiveDynamicContext;
import com.bytedance.android.livesdk.livecommerce.hybrid.LiveCommerceBridgeProvider;
import com.bytedance.android.livesdk.livecommerce.intro.model.req.IntroCardScene;
import com.bytedance.android.livesdk.livecommerce.intro.utils.IntroCardLoadOpt;
import com.bytedance.android.livesdk.livecommerce.livereplay.ECLiveReplayModule_ProvideFactory;
import com.bytedance.android.livesdk.livecommerce.oldflash.LiveFlashNewFragment;
import com.bytedance.android.livesdk.livecommerce.oldflash.LiveFlashViewModel;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.playback.ExplainPlaybackModule_ProvideFactory;
import com.bytedance.android.livesdk.livecommerce.promotion.card.LivePromotionCard;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.LivePromotionCardV2;
import com.bytedance.android.livesdk.livecommerce.promotionlist.LivePromotionListFragment;
import com.bytedance.android.livesdk.livecommerce.room.LiveRoomProvider;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.ExtraController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.FlashController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.LynxAnchorPromotionListUtils;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.controller.related.IRelatedInfoManager$FromSource;
import com.bytedance.android.livesdk.livecommerce.room.controller.related.IRelatedInfoManager$Scene;
import com.bytedance.android.livesdk.livecommerce.room.controller.related.RelatedInfoManager;
import com.bytedance.android.livesdk.livecommerce.room.coupon.CouponGrowProvider;
import com.bytedance.android.livesdk.livecommerce.room.hover.ECLiveDialogHoverManager;
import com.bytedance.android.livesdk.livecommerce.room.service.CommerceServiceDelegate;
import com.bytedance.android.livesdk.livecommerce.room.utils.ECLiveClearScreenHelper;
import com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.BottomRightCardManager;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.PromotionCardLoadOptUtils;
import com.bytedance.android.livesdk.livecommerce.router.ECLiveSchemaBuilder;
import com.bytedance.android.livesdk.livecommerce.saascoupon.SaasCouponModule_ProvideFactory;
import com.bytedance.android.livesdk.livecommerce.utils.ECPreloadGeckoChannelUtil;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.LiveCommerceMessageProvider;
import com.bytedance.android.livesdk.livecommerce.utils.m0;
import com.bytedance.android.livesdk.livecommerce.utils.x0;
import com.bytedance.android.shopping.api.address.IAddressService;
import com.bytedance.android.shopping.ligo.context.LigoComponentRegistry;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Observable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class s implements tk.b, cf.l {
    public static final s d = null;

    @Inject
    public el2.j a;

    @Inject
    public fl2.a b;
    public hh2.a c;

    public final void callInjection() {
        ECLiveEntranceMonitor.trace("callInjection", "ECLiveCommerceService", false);
        int r0 = ECSdk.a;
        ECSdk.b(IAdapterService.class, new m());
    }

    public final boolean enableFullLiveCommerce() {
        return true;
    }

    static {
        d = new s();
    }

    public final hf.a Ja() {
        return new ECLiveSchemaBuilder();
    }

    public final void La() {
        com.bytedance.android.livesdk.livecommerce.view.countdown.d r0 = com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.a;
        if (r0.c.booleanValue() == true) goto L7;
        r0.a();
        return;
    }

    public final void Ma() {
        com.bytedance.android.livesdk.livecommerce.view.countdown.d r0 = com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.a;
        com.bytedance.android.livesdk.livecommerce.view.countdown.c r1 = r0.b;
        if (r1 != null) goto L5;
    L7:
        r0.c = Boolean.FALSE;
        ((CopyOnWriteArrayList) r0.a).clear();
        com.bytedance.android.livesdk.livecommerce.view.countdown.c r2 = new com.bytedance.android.livesdk.livecommerce.view.countdown.c(r0);
        r0.b = r2;
        monitor-enter(r2);
        r2.a = false;     // Catch: Throwable -> L13
        r2.b = true;     // Catch: Throwable -> L13
        com.bytedance.android.livesdk.livecommerce.view.countdown.e r3 = r2.c;     // Catch: Throwable -> L13
        r3.sendMessage(r3.obtainMessage(1));     // Catch: Throwable -> L13
        monitor-exit(r2);
        return;
    L13:
        th = move-exception;
        throw th;
    L5:
        if (r1.b() == false) goto L7;
    }

    public final void c() {
        if (this.a != null) goto L5;
        l();
    L5:
        el2.j r0 = this.a;
        if (r0 == null) goto L9;
        r0.c();
        return;
    }

    public final void d() {
        if (this.a != null) goto L5;
        l();
    L5:
        el2.j r0 = this.a;
        if (r0 == null) goto L9;
        r0.d();
        return;
    }

    public final uk.a getBuyNowService() {
        return new o();
    }

    public final xk.b getECLiveReplayService() {
        if (this.b != null) goto L6;
        l();
    L6:
        return this.b;
    }

    public final com.bytedance.android.ec.live.api.commerce.userinfo.f getECUserInfoService() {
        return new jl2.a();
    }

    public final al.a getLiveBizWindowLayoutAbility() {
        return new ck2.a();
    }

    public final al.b getLiveBizWindowLogAbility() {
        return new ck2.b();
    }

    public final al.c getLiveBizWindowWidgetAbility() {
        return new ck2.c();
    }

    public final boolean isProductDetailPageExpanded() {
        Lazy r0 = ExtraController.l;
        ExtraController r1 = ControllerCenter.c(null, null).u;
        Objects.toString(r1);
        return r1.j;
    }

    public final void l() {
        if (this.c != null) goto L5;
        this.c = hh2.a.a();
    L5:
        hh2.a r0 = this.c;
        r0.getClass();
        r0.b.getClass();
        this.a = ExplainPlaybackModule_ProvideFactory.proxyProvide(r0.c);
        this.b = ECLiveReplayModule_ProvideFactory.proxyProvide(r0.d);
    }

    public final boolean za() {
        Application.ActivityLifecycleCallbacks r0 = ControllerCenter.a;
        return !ControllerCenter.b.isEmpty();
    }

    public s() {
        this.a = null;
        this.b = null;
        this.c = null;
        bf.a.a(new com.bytedance.android.livesdk.livecommerce.router.b());
        bf.a.a(new com.bytedance.android.livesdk.livecommerce.router.a());
        LiveCommerceBridgeProvider r0 = LiveCommerceBridgeProvider.a;
        Lazy r1 = ECBridgeProviderInjector.b;
        ((CopyOnWriteArrayList) ECBridgeProviderInjector.a.a().a).add(r0);
        LiveCommerceMessageProvider.a.c();
        com.bytedance.android.livesdk.livecommerce.eventcenter.h r2 = com.bytedance.android.livesdk.livecommerce.eventcenter.h.a;
        Lazy r3 = LiveDynamicContext.c;
        LiveDynamicContext.a.a().a = r2;
        int r4 = com.bytedance.android.livesdk.livecommerce.eventcenter.e.a;
        LigoComponentRegistry r5 = (LigoComponentRegistry) LigoComponentRegistry.b.getValue();
        Uri r6 = UriProtector.parse("led://ec_live_promotion_card");
        com.bytedance.android.livesdk.livecommerce.dynamic.compose.router.b r7 = new com.bytedance.android.livesdk.livecommerce.dynamic.compose.router.b();
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "uri");
        Intrinsics.checkNotNullParameter(r7, "compose");
        r5.a.put(r6.toString(), r7);
        m(5000, new j());
        boolean r8 = ECPreloadGeckoChannelUtil.a;
        m(10000, new k());
        m(12000, new l());
    }

    public final boolean Ea() {
        if (com.bytedance.android.livesdk.livecommerce.utils.n.b() == false) goto L6;
    L12:
        return true;
    L6:
        if (com.bytedance.android.livesdk.livecommerce.utils.n.a() == true) goto L12;
        Boolean r0 = Boolean.FALSE;
        Boolean r1 = (Boolean) EComABUtils.getLiveSettingValue("list_cell_explaining_anim_degrade_enable", r0);
        Boolean r2 = (Boolean) EComABUtils.getLiveSettingValue("live_ecom_animation_degrade_strategy_switch", r0);
        if (r1.booleanValue() == true) goto L11;
    L13:
        return false;
    L11:
        if (r2.booleanValue() == false) goto L13;
        goto L12
    }

    public final View Ia() {
        fh2.a r0 = PromotionListController.H();
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.p() == true) goto L7;
        return null;
    L7:
        return r0.En();
    }

    public final boolean Na() {
        if (EComABUtils.useClearScreenAbilityFromCard() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final float[] Pa() {
        fh2.a r0 = PromotionListController.H();
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.p() == true) goto L7;
        return null;
    L7:
        return r0.dt();
    }

    public final cf.w getRoomInfo() {
        RoomContextController r0 = RoomContextController.H();
        String r2 = r0.B();
        String r3 = r0.y();
        if (r0.w() == true) goto L5;
    L7:
        boolean r1 = false;
    L9:
        return new cf.w(r2, r3, Boolean.valueOf(r1));
    L5:
        if (r0.C().n.getBoolean("EXTRA_BOOL_ROOM_HAS_COMMERCE") == false) goto L7;
        r1 = true;
        goto L9
    }

    public final boolean onBackPressed() {
        com.bytedance.android.ec.core.opt.ab.d.a();
        return false;
    }

    public final void updatePromotionList() {
        fh2.a r0 = PromotionListController.H();
        if (r0 == null) goto L6;
        r0.vm(false);
        return;
    }

    public final void ya() {
        fh2.a r0 = PromotionListController.H();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.p() == false) goto L9;
        r0.ya();
        return;
    }

    public final void Oa(boolean r3) {
        ECLivePerformanceMonitor.b r0 = ECLivePerformanceMonitor.x;
        ECLivePerformanceMonitor r1 = ECLivePerformanceMonitor.c.a(null, null);
        if (r1 == null) goto L6;
        r1.p(3, r3);
        return;
    }

    public final void Qa(String r2) {
        int r0 = ECSdk.a;
        ((IAdapterService) ECSdk.a(IAdapterService.class)).excActionBySetting(r2);
    }

    public final void e(vk.d r3) {
        String r4 = r3.b;
        Locale r0 = Locale.ROOT;
        if (r4.toLowerCase(r0).contains("ec://liveDrawerCommonFragment".toLowerCase(r0)) == false) goto L6;
        l();
        return;
    }

    public final void g(JSONObject r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.optBoolean("SendTextEvent", false) == false) goto L10;
        int r5 = ECSdk.a;
        IECUserTrackerService r6 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r6 == null) goto L30;
        r6.getMarketingService().a("live_send_comment_in_room", PostActionType.DO, "live");
        return;
    L30:
        return;
    L10:
        if (r4.optBoolean("onExitRoom", false) == false) goto L17;
        int r7 = com.bytedance.android.livesdk.livecommerce.room.controller.business.c.i;     // Catch: Throwable -> L14
        com.bytedance.android.livesdk.livecommerce.room.controller.business.c r8 = ControllerCenter.c(null, null).o;     // Catch: Throwable -> L14
        Objects.toString(r8);     // Catch: Throwable -> L14
        r8.getClass();     // Catch: Throwable -> L14
        CouponGrowProvider.l.getClass();     // Catch: Throwable -> L14
        CouponGrowProvider r9 = CouponGrowProvider.f;     // Catch: Throwable -> L14
        r9.getClass();     // Catch: Throwable -> L14
        CouponGrowProvider.Companion.a("levrom");     // Catch: Throwable -> L14
        ((LinkedHashMap) CouponGrowProvider.k).clear();     // Catch: Throwable -> L23
        ((LinkedHashMap) r9.b).clear();     // Catch: Throwable -> L23
        r9.b();     // Catch: Throwable -> L23
        return;
    L36:
        return;
    L14:
        th = move-exception;
        ECExceptionMonitor.e(th);
        return;
    L17:
        if (r4.optBoolean("applyNormalCoupon", false) == false) goto L33;
        int r10 = com.bytedance.android.livesdk.livecommerce.room.controller.business.c.i;     // Catch: Throwable -> L20
        com.bytedance.android.livesdk.livecommerce.room.controller.business.c r11 = ControllerCenter.c(null, null).o;     // Catch: Throwable -> L20
        Objects.toString(r11);     // Catch: Throwable -> L20
        r11.J();     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        ECExceptionMonitor.e(th);
        return;
    }

    public final JSONObject getLiveShoppingData(int r2) {
        int r0 = RoomContextController.h;
        y r1 = RoomContextController.a.a().c;
        if (r1 != null) goto L5;
        return null;
    L5:
        return r1.g(r2);
    }

    public final void h(Activity r1) {
        com.bytedance.android.ec.core.opt.ab.d.a();
        com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
    }

    public final void handleWebcastInRoomSchema(Map<String, Object> r5) {
        ECLiveABUtils r0 = ECLiveABUtils.INSTANCE;
        if (r0.getEC_LIVE_IN_ROOM_CHECK_ROOM_ID() == false) goto L12;
        if (r5 == null) goto L12;
        Object r1 = r5.get("room_id");
        if ((r1 instanceof String) == false) goto L12;
        String r2 = (String) r1;
        if (TextUtils.isEmpty(r2) == true) goto L12;
        boolean r3 = EntryController.M1;
        EntryController.a.b(r2, null).O(r5);
        return;
    L12:
        if (r0.getEC_LIVE_IN_ROOM_CHECK_ROOM_ID() == false) goto L14;
        int r4 = com.bytedance.android.ec.sdk.helper.j.a;
        com.bytedance.android.ec.sdk.helper.j.d("ECLiveCommerceService", "sslocal://webcast_inroom_eclive 上未携带 room_id，可能会导致打开商列错误", null, null);
    L14:
        boolean r6 = EntryController.M1;
        EntryController.a.a().O(r5);
    }

    public final boolean i(Object r2) {
        if ((r2 instanceof com.bytedance.android.ec.adapter.api.c) == false) goto L6;
        ((com.bytedance.android.ec.adapter.api.c) r2).a();
        return true;
    L6:
        return false;
    }

    public final void notifyPromotionNum(int r3) {
        x0 r0 = x0.a();
        wk.d r1 = new wk.d(r3);
        r0.a.onNext(r1);
    }

    public final boolean showEnterRoomTicketExpandDialog(boolean r9) {
        int r0 = com.bytedance.android.livesdk.livecommerce.room.controller.business.c.i;
        com.bytedance.android.livesdk.livecommerce.room.controller.business.c r1 = ControllerCenter.c(null, null).o;
        Objects.toString(r1);
        r1.getClass();
    L7:
        th = move-exception;
        ECExceptionMonitor.e(th);
    L10:
        if (r1.f == null) goto L12;
        return true;
    L12:
        return false;
    L4:
        if (r1.w() == false) goto L10;
        CouponGrowProvider.Companion r2 = CouponGrowProvider.l;     // Catch: Throwable -> L7
        Context r3 = r1.m();     // Catch: Throwable -> L7
        Map<String, String> r4 = r1.p();     // Catch: Throwable -> L7
        String r5 = r1.B();     // Catch: Throwable -> L7
        boolean r6 = r1.t();     // Catch: Throwable -> L7
        PromotionListController r7 = r1.A().r;     // Catch: Throwable -> L7
        r2.getClass();     // Catch: Throwable -> L7
        r1.f = CouponGrowProvider.Companion.i(r3, r9, r4, r5, r6, r7);     // Catch: Throwable -> L7
        goto L10
    }

    public final void showInteractionAndEnterRoom(String r2) {
        int r0 = ECSdk.a;
        ((IAdapterService) ECSdk.a(IAdapterService.class)).showInteractionAndEnterRoom(r2);
    }

    public final void showInteractionMask(String r2) {
        int r0 = ECSdk.a;
        ((IAdapterService) ECSdk.a(IAdapterService.class)).showInteractionMask(r2);
    }

    public final void switchFlashConfig(boolean r3) {
        int r0 = FlashController.f;
        FlashController r1 = ControllerCenter.c(null, null).p;
        Objects.toString(r1);
        r1.c = r3;
        boolean r2 = LynxAnchorPromotionListUtils.a;
        JSONObject r4 = new JSONObject();
        r4.put("switch_on", com.bytedance.android.shopping.extensions.k.q(Boolean.valueOf(r3)));     // Catch: JSONException -> L5
    L10:
        ECLiveHybridUtil.f("ecom.anchor.updateFlashSaleSwitch", r4);
        PromotionListController.H();
        return;
    L5:
        e = move-exception;
        String r5 = e.getMessage();
        if (r5 != null) goto L9;
        r5 = "";
    L9:
        ECExceptionMonitor.c(r5);
        goto L10
    }

    public static void m(long r2, final Runnable r4) {
        new Handler(Looper.getMainLooper()).postDelayed(new p(r4), r2);
    }

    public final void Aa(int r3, String r4) {
        int r0 = ECLiveDialogHoverManager.j;
        boolean r1 = EntryController.M1;
        if (ECLiveDialogHoverManager.a.a(EntryController.a.a().U) == true) goto L6;
        ECLiveClearScreenHelper.a(r3, getRoomInfo().a, RoomContextController.a.a().D());
    L6:
        if (r4 != "clear_screen_upon_list") goto L14;
        fh2.a r5 = PromotionListController.H();
        if (r5 != null) goto L10;
        return;
    L10:
        if (r3 != 2) goto L12;
        ((LivePromotionListFragment) r5).ja0(true);
        return;
    L12:
        ((LivePromotionListFragment) r5).ja0(false);
        return;
    }

    public final boolean Ba(ECPromotionCampaign r1, long r2) {
        return com.bytedance.android.livesdk.livecommerce.utils.k.a(r1, r2);
    }

    public final void Ca(String r2, com.bytedance.android.ec.model.live.r r3) {
        int r0 = com.bytedance.android.livesdk.livecommerce.messagev2.a.k;
        ((ArrayList) ControllerCenter.c(r2, null).n.g).remove(r3);
    }

    public final void Ka(String r2, com.bytedance.android.ec.model.live.r r3) {
        int r0 = com.bytedance.android.livesdk.livecommerce.messagev2.a.k;
        ((ArrayList) ControllerCenter.c(r2, null).n.g).add(r3);
    }

    public final void chooseCategory(String r3, String r4) {
        int r0 = FlashController.f;
        FlashController r1 = ControllerCenter.c(null, null).p;
        Objects.toString(r1);
        LiveFlashNewFragment r2 = r1.d;
        if (r2 == null) goto L9;
        LiveFlashViewModel r5 = (LiveFlashViewModel) r2.g;
        if (r5 == null) goto L7;
        r5.setCategory(r3, r4);
    L7:
        r2.pa0(false);
        r2.la0(false, true);
        return;
    }

    public final void hookECOMLiveParams(String r2, Bundle r3) {
        new ECLiveSchemaBuilder().g(r2, r3);
    }

    public final void j(String r3, Bundle r4) {
        Lazy r0 = LiveRoomProvider.a;
        Intrinsics.checkNotNullParameter(r3, "clickFrom");
        Intrinsics.checkNotNullParameter(r4, "businessArg");
        com.bytedance.android.livesdk.livecommerce.room.g r1 = LiveRoomProvider.g;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r1.a = r3;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r1.b = r4;
    }

    public final Fragment k(Context r13, CommerceServiceDelegate.i r14) {
        Fragment[] r0 = {null};
        PromotionListController.T.getClass();
        PromotionListController.a.a().M(r13, "other", r14, null, false, null, null, new r(r0));
        return r0[0];
    }

    public final boolean showExitRoomTicketExpandDialog(boolean r9, Runnable r10) {
        int r0 = com.bytedance.android.livesdk.livecommerce.room.controller.business.c.i;
        com.bytedance.android.livesdk.livecommerce.room.controller.business.c r1 = ControllerCenter.c(null, null).o;
        Objects.toString(r1);
        r1.getClass();
        CouponGrowProvider.Companion r2 = CouponGrowProvider.l;     // Catch: Throwable -> L5
        Context r3 = r1.m();     // Catch: Throwable -> L5
        Map<String, String> r4 = r1.p();     // Catch: Throwable -> L5
        String r5 = r1.B();     // Catch: Throwable -> L5
        PromotionListController r6 = r1.A().r;     // Catch: Throwable -> L5
        r2.getClass();     // Catch: Throwable -> L5
        r1.g = CouponGrowProvider.Companion.j(r3, r9, r4, r5, r6, r10);     // Catch: Throwable -> L5
    L8:
        if (r1.g == null) goto L10;
        return true;
    L10:
        return false;
    L5:
        th = move-exception;
        ECExceptionMonitor.e(th);
        goto L8
    }

    public final DialogFragment showLiveFlashFragment(Context r4, Bundle r5) {
        dm.a.a("ECLiveCommerceService").i("showLiveFlashFragment");
        int r0 = FlashController.f;
        FlashController r1 = ControllerCenter.c(null, null).p;
        Objects.toString(r1);
        return r1.I(r4, r5, 0L);
    }

    public final void startShowFloatInNextLifecycle(Activity r4, String r5) {
        int r0 = ECSdk.a;
        IAdapterService r1 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r1 == null) goto L8;
        com.bytedance.android.ec.adapter.api.j r2 = r1.getLiveWindowService();
        if (r2 == null) goto L9;
        com.bytedance.android.ec.adapter.api.a r3 = new com.bytedance.android.ec.adapter.api.a();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r3.a = r5;
        r2.e(r4, r3);
        return;
    L9:
        return;
    }

    public final com.bytedance.android.livesdk.livecommerce.promotion.card.b Da(ViewGroup r1, com.bytedance.android.livesdk.livecommerce.promotion.card.g r2, boolean r3) {
        if (r3 == false) goto L6;
        return new LivePromotionCardV2(r1, r2);
    L6:
        return new LivePromotionCard(r1, r2);
    }

    public final void a(FragmentActivity r3, String r4, Window r5) {
        if (EComABUtils.disableAnchorV4ReduceFrame() != 1) goto L5;
        return;
    L5:
        int r0 = RoomContextController.h;
        com.bytedance.android.livesdk.livecommerce.room.api.c r1 = RoomContextController.a.a().J();
        if (r1 == null) goto L9;
        r1.a(r3, r4, r5);
        return;
    }

    public final void b(FragmentActivity r3, String r4, Window r5) {
        if (EComABUtils.disableAnchorV4ReduceFrame() != 1) goto L5;
        return;
    L5:
        int r0 = RoomContextController.h;
        com.bytedance.android.livesdk.livecommerce.room.api.c r1 = RoomContextController.a.a().J();
        if (r1 == null) goto L9;
        r1.d(r3, r4, r5, null);
        return;
    }

    public final void f(FragmentActivity r2, String r3, Window r4) {
        int r0 = RoomContextController.h;
        com.bytedance.android.livesdk.livecommerce.room.api.c r1 = RoomContextController.a.a().J();
        if (r1 == null) goto L6;
        r1.f(r2, r3, r4);
        return;
    }

    public final void setAddress(String r8, int r9, String r10) {
        int r0 = ECSdk.a;
        IAddressService r1 = (IAddressService) ECSdk.a(IAddressService.class);
        if (r1 == null) goto L6;
        r1.setAddress(o83.c.a(r8, r9, r10), 1, true, null, null);
        return;
    }

    public final void tryShowLiveFlashFragment(Context r4, Bundle r5, Function1<DialogFragment, Unit> r6) {
        dm.a.a("ECLiveCommerceService").i("tryShowLiveFlashFragment");
        int r0 = FlashController.f;
        FlashController r1 = ControllerCenter.c(null, null).p;
        Objects.toString(r1);
        r1.J(r4, r5, 0L, r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [sg2.n] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void tryShowSaasCouponDialog(Context r4, Bundle r5, Function1<JSONObject, Unit> r6) {
        final String r0 = r5.getString("room_id", "");
        int r1 = com.bytedance.android.livesdk.livecommerce.room.controller.business.c.i;
        com.bytedance.android.livesdk.livecommerce.room.controller.business.c r2 = ControllerCenter.c(r0, null).o;
        Objects.toString(r2);
        if (r2.h != null) goto L5;
        r2.h = SaasCouponModule_ProvideFactory.proxyProvide(hh2.a.a().e);
    L5:
        el2.n r3 = r2.h;
        if (r3 == 0) goto L9;
        r3.a(r4, r5, r6, new n(r0));
        return;
    }

    public final void Fa(boolean r2, Fragment r3, LiveClearScreenMode r4, LiveScreenMoveMode r5) {
        PromotionListController.T.getClass();
        ECLiveDialogHoverManager r0 = PromotionListController.a.a().R;
        if (r0 == null) goto L8;
        if (r2 == false) goto L6;
        r0.c(r3, r4, r5);
        return;
    L6:
        r0.b(r3, r4, r5);
        return;
    }

    public final ECUIPromotion Ha(ECPromotion r1, Context r2, long r3, Boolean r5) {
        return com.bytedance.android.livesdk.livecommerce.utils.k.d(r1, r2, r3, r5);
    }

    public final void roomEnter(String r31, String r32, String r33, Map<String, String> r34) {
        if (r33 != null) goto L5;
        return;
    L5:
        JSONObject r3 = z1.g(r33);
        if (r3 == null) goto L123;
        String r4 = r3.optString("show_cart");
        if (r4.isEmpty() == false) goto L10;
        return;
    L10:
        if ("1".equals(r4) == true) goto L15;
        if ("true".equalsIgnoreCase(r4) == true) goto L15;
        return;
    L15:
        if (r32.isEmpty() == false) goto L17;
        return;
    L17:
        if (BDLocationException.ERROR_TIMEOUT.equals(r32) == true) goto L132;
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.y.o.getClass();
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.y r5 = com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.y.a.a(r31);
        Intrinsics.checkNotNullParameter(r31, "roomId");
        Intrinsics.checkNotNullParameter(r32, "anchorId");
        Intrinsics.checkNotNullParameter(r3, "ecomLiveParams");
        Intrinsics.checkNotNullParameter(r34, "eventParams");
        StringBuilder r9 = new StringBuilder("optCardLoadV3Api: ");
        boolean r11 = com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.y.j;
        r9.append(r11);
        r9.append(",optCardLoadV3Layout: ");
        boolean r13 = com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.y.k;
        r9.append(r13);
        String r14 = ",optCardLoadV3Event: ";
        r9.append(",optCardLoadV3Event: ");
        r9.append(com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.y.l);
        r9.append(",optCardLoadV3Image: ");
        r9.append(com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.y.m);
        r9.append("\necomLiveParams: ");
        r9.append(r3);
        r9.append("\n eventParams: ");
        int r17 = m0.a;
        r9.append(GsonProtectorUtils.toJson(m0.a.a, r34));
        OptCardUtil.b("roomEnter", r9.toString());
        String r15 = "store_id";
        if (r5.a == false) goto L22;
    L44:
        String r28 = ",optCardLoadV3Event: ";
        String r29 = "store_id";
        if (r13 == true) goto L47;
    L51:
        PromotionCardLoadOptUtils.Companion r6 = PromotionCardLoadOptUtils.p;
        r6.getClass();
        PromotionCardLoadOptUtils r10 = PromotionCardLoadOptUtils.Companion.c(r31);
        Intrinsics.checkNotNullParameter(r31, "roomId");
        Intrinsics.checkNotNullParameter(r32, "anchorId");
        Intrinsics.checkNotNullParameter(r3, "ecomLiveParams");
        Intrinsics.checkNotNullParameter(r34, "eventParams");
        StringBuilder r12 = new StringBuilder("optCardLoadV3Api: ");
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.y.o.getClass();
        boolean r16 = com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.y.j;
        r12.append(r16);
        r12.append(",optCardLoadV3Layout: ");
        boolean r18 = com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.y.k;
        r12.append(r18);
        r12.append(r28);
        r12.append(com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.y.l);
        r12.append(",optCardLoadV3Image: ");
        r12.append(com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.y.m);
        r12.append("\necomLiveParams: ");
        r12.append(r3);
        r12.append("\n eventParams: ");
        int r19 = m0.a;
        r12.append(GsonProtectorUtils.toJson(m0.a.a, r34));
        OptCardUtil.b("roomEnter", r12.toString());
        String r110 = r3.optString("related_info");
        boolean r111 = EntryController.M1;
        RelatedInfoManager r112 = EntryController.a.b(r31, null).M();
        r112.i(r110, IRelatedInfoManager$FromSource.ENTER_ECOM_LIVE_PARAMS);
        String r113 = r112.f(IRelatedInfoManager$Scene.CARRY_ON_CARD);
        if (r113 != null) goto L55;
    L73:
        com.bytedance.android.livesdk.livecommerce.intro.utils.f.o.getClass();
        Intrinsics.checkNotNullParameter(r31, "roomId");
        HashMap<String, com.bytedance.android.livesdk.livecommerce.intro.utils.f> r7 = com.bytedance.android.livesdk.livecommerce.intro.utils.f.n;
        com.bytedance.android.livesdk.livecommerce.intro.utils.f r20 = r7.get(r31);
        if (r20 != null) goto L76;
        r20 = new com.bytedance.android.livesdk.livecommerce.intro.utils.f();
        r7.put(r31, r20);
    L76:
        Intrinsics.checkNotNullParameter(r31, "roomId");
        Intrinsics.checkNotNullParameter(r32, "anchorId");
        Intrinsics.checkNotNullParameter(r3, "ecomLiveParams");
        Intrinsics.checkNotNullParameter(r34, "eventParams");
        StringBuilder r8 = new StringBuilder("optCardLoadV3Api: ");
        boolean r21 = com.bytedance.android.livesdk.livecommerce.intro.utils.f.j;
        r8.append(r21);
        r8.append(",optCardLoadV3Layout: ");
        boolean r22 = com.bytedance.android.livesdk.livecommerce.intro.utils.f.k;
        r8.append(r22);
        r8.append(r28);
        r8.append(com.bytedance.android.livesdk.livecommerce.intro.utils.f.l);
        r8.append(",optCardLoadV3Image: ");
        r8.append(com.bytedance.android.livesdk.livecommerce.intro.utils.f.m);
        r8.append("\necomLiveParams: ");
        r8.append(r3);
        r8.append("\n eventParams: ");
        int r23 = m0.a;
        r8.append(GsonProtectorUtils.toJson(m0.a.a, r34));
        OptCardUtil.b("roomEnter", r8.toString());
        if (r20.a == false) goto L79;
    L104:
        if (r22 == true) goto L106;
        return;
    L106:
        if (r20.h == true) goto L129;
        Activity r0 = ECAppInfoService.e.a();
        if (r0 == null) goto L130;
        r20.h = true;
        r20.i = new WeakReference(r0);
        boolean r1 = IntroCardLoadOpt.f;
        IntroCardLoadOpt.a.a(r0);
        return;
    L130:
        return;
    L129:
        return;
    L79:
        if (r20.e == true) goto L104;
        if (r20.f != null) goto L104;
        if (r21 == false) goto L126;
        HashMap r24 = new HashMap();
        Iterator<String> r25 = r3.keys();
    L86:
        if (r25.hasNext() == false) goto L88;
        String r26 = r25.next();
        r24.put(r26, r3.optString(r26));
        goto L86
    L88:
        com.bytedance.android.livesdk.livecommerce.intro.utils.j r114 = new com.bytedance.android.livesdk.livecommerce.intro.utils.j(r34, r24, r31, r32);
        com.bytedance.android.livesdk.livecommerce.intro.manager.t r115 = new com.bytedance.android.livesdk.livecommerce.intro.manager.t();
        Intrinsics.checkNotNullParameter(r115, "dataSource");
        r20.a = true;
        r20.b = Long.valueOf(SystemClock.elapsedRealtime());
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator r27 = r24.entrySet().iterator();
    L90:
        if (r27.hasNext() == false) goto L96;
        Map.Entry r30 = (Map.Entry) r27.next();
        String r35 = r29;
        if (Intrinsics.areEqual((String) r30.getKey(), r35) == false) goto L94;
        r2.put(r30.getKey(), r30.getValue());
    L94:
        r29 = r35;
        goto L90
    L96:
        if ((!r2.isEmpty()) == true) goto L99;
        r2 = null;
    L99:
        IntroCardScene r116 = IntroCardScene.ENTER_ROOM;
        if ((112 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) == 0) goto L102;
        LinkedHashMap r117 = null;
    L103:
        Intrinsics.checkNotNullParameter(r114, "roomInfo");
        Intrinsics.checkNotNullParameter(r116, "cardScene");
        r20.f = r115.a(r114, r116, false, false, null, null, null, r117).subscribe(new com.bytedance.android.livesdk.livecommerce.intro.utils.h(r20), new com.bytedance.android.livesdk.livecommerce.intro.utils.i(r20));
        return;
    L102:
        r117 = r2;
        goto L103
    L126:
        return;
    L55:
        if (r10.a == false) goto L57;
    L67:
        if (r18 == false) goto L73;
        if (r10.i == true) goto L73;
        Activity r118 = ECAppInfoService.e.a();
        if (r118 == null) goto L73;
        r10.i = true;
        r10.j = new WeakReference(r118);
        PromotionCardLoadOptUtils.Companion.a(r6, r118, r10.l);
        goto L73
    L57:
        if (r10.e == true) goto L67;
        if (r10.f != null) goto L67;
        if (r16 == false) goto L73;
        HashMap r36 = new HashMap();
        Iterator<String> r119 = r3.keys();
    L64:
        if (r119.hasNext() == false) goto L66;
        String r120 = r119.next();
        r36.put(r120, r3.optString(r120));
        goto L64
    L66:
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.p r121 = new com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.p(r34, r36, r31, r32);
        r10.a = true;
        r10.b = Long.valueOf(SystemClock.elapsedRealtime());
        r10.f = ((Observable) r10.k.invoke(r121, r113, Boolean.FALSE)).subscribe(new com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.n(r10, r36, r121), new com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.o(r10));
        goto L73
    L47:
        if (r5.h == true) goto L51;
        Activity r37 = ECAppInfoService.e.a();
        if (r37 == null) goto L51;
        r5.h = true;
        r5.i = new WeakReference(r37);
        boolean r38 = com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.f;
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.a.a(r37);
        goto L51
    L22:
        if (r5.e == true) goto L44;
        if (r5.f != null) goto L44;
        if (r11 == false) goto L43;
        HashMap r39 = new HashMap();
        Iterator<String> r122 = r3.keys();
    L29:
        if (r122.hasNext() == false) goto L31;
        String r123 = r122.next();
        r39.put(r123, r3.optString(r123));
        r122 = r122;
        goto L29
    L31:
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.c0 r124 = new com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.c0(r34, r39, r31, r32);
        qk2.a r210 = new qk2.a();
        r5.a = true;
        r5.b = Long.valueOf(SystemClock.elapsedRealtime());
        LinkedHashMap r125 = new LinkedHashMap();
        Iterator r126 = r39.entrySet().iterator();
    L33:
        if (r126.hasNext() == false) goto L38;
        Map.Entry r211 = (Map.Entry) r126.next();
        r14 = r14;
        if (Intrinsics.areEqual((String) r211.getKey(), r15) == false) goto L33;
        r125.put(r211.getKey(), r211.getValue());
        r15 = r15;
        goto L33
    L38:
        r28 = r14;
        r29 = r15;
        if ((!r125.isEmpty()) == false) goto L41;
        LinkedHashMap r212 = r125;
    L42:
        r5.f = pk2.a.C0160a.a(r210, r124, false, true, null, r212, null, 192).subscribe(new com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.a0(r5, r39, r124), new com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.b0(r5));
        goto L51
    L41:
        r212 = null;
        goto L42
    L43:
        r28 = ",optCardLoadV3Event: ";
        r29 = "store_id";
        goto L51
    L132:
        return;
    }

    public final cf.d Ga(Context r10, com.bytedance.android.shopping.store.home.presenter.preview.c r11, LiveRoomParams r12, com.bytedance.android.shopping.store.home.presenter.preview.d r13, im.m r14) {
        int r0 = RoomContextController.h;
        return new BottomRightCardManager(r10, r11, r12, r13, 1, r14, RoomContextController.a.a());
    }
}
