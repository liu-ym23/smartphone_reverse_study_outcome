package com.bytedance.android.livesdk.livecommerce.iron.helper;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.common.api.IECCommonService;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.ec.core.utils.FloatWindowScene;
import com.bytedance.android.ec.core.utils.LoginUtil;
import com.bytedance.android.ec.core.utils.UrlBuilderV2;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.x0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.BuyNowPreloadParams;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.ec.model.promotion.ECUIAskExplainInfo;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUIPingGroup;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.promotion.ECUIPromotionLiveListConfig;
import com.bytedance.android.ec.model.response.ActionType;
import com.bytedance.android.ec.model.response.CheckSKUParams;
import com.bytedance.android.ec.model.response.ECEditCartParams;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.ec.model.response.ECJumpDestination;
import com.bytedance.android.ec.model.response.ECPromotionCheckResponse;
import com.bytedance.android.ec.model.response.PrefetchOrder;
import com.bytedance.android.ec.model.response.StepperActionType;
import com.bytedance.android.ec.model.response.UltimateBuy;
import com.bytedance.android.ec.model.response.anchorv3.SourceType;
import com.bytedance.android.ec.model.response.h0;
import com.bytedance.android.ec.model.response.j0;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.ec.model.sku.SkuShowAndDismissState;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.dynamiccontext.LiveDynamicContext;
import com.bytedance.android.livesdk.livecommerce.event.ECEventUtilsV2;
import com.bytedance.android.livesdk.livecommerce.event.l0;
import com.bytedance.android.livesdk.livecommerce.eventcenter.LiveEventCenter;
import com.bytedance.android.livesdk.livecommerce.model.ECUISkuInfo;
import com.bytedance.android.livesdk.livecommerce.network.response.ECAskExplainResponse;
import com.bytedance.android.livesdk.livecommerce.playback.utils.ExplainPlaybackUtils;
import com.bytedance.android.livesdk.livecommerce.playback.utils.LiveReplayPageOptEnums;
import com.bytedance.android.livesdk.livecommerce.promotion.card.module.ListItemButtonModule$addCartListener$1;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.LiveActionTracker;
import com.bytedance.android.livesdk.livecommerce.room.controller.CoreRequests;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.utils.ECLiveEventHelper;
import com.bytedance.android.livesdk.livecommerce.room.utils.LiveRoomRedirectInfo;
import com.bytedance.android.livesdk.livecommerce.utils.ECDisplayUtils;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.EnumEntranceInfoScene;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.marketing.sdk.api.IMarketingServiceV2;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.data.api.ChainPoint;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONException;
import org.json.JSONObject;
import vi2.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class PromotionJumpDispatcher implements jf.d {
    public static final /* synthetic */ int i = 0;
    public final boolean b;
    public final int c;
    public final com.bytedance.android.livesdk.livecommerce.iron.helper.c d;
    public final Lazy e;
    public final bk2.d f;
    public final jf.c g;
    public final com.bytedance.android.livesdk.livecommerce.promotion.card.d h;

    public final class LiveSkuCallback implements com.bytedance.android.livesdk.livecommerce.room.utils.e {
        public final String a;
        public final Context b;
        public final com.bytedance.android.ec.common.api.jump.model.g c;
        public final /* synthetic */ PromotionJumpDispatcher d;

        @Override // com.bytedance.android.livesdk.livecommerce.room.utils.e
        public final Function1<Boolean, Unit> e() {
            return null;
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.utils.e
        public final Function1<Long, Unit> a() {
            return new PromotionJumpDispatcher$LiveSkuCallback$adLogCallBack$1(this);
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.utils.e
        public final Function2<String[], Long, Unit> b() {
            return new PromotionJumpDispatcher$LiveSkuCallback$skuSpecChangeState$1(this);
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.utils.e
        public final Function1<SkuShowAndDismissState, Unit> c() {
            return new PromotionJumpDispatcher$LiveSkuCallback$skuRestoreState$1(this);
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.utils.e
        public final Context context() {
            return this.b;
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.utils.e
        public final String d() {
            return this.a;
        }

        public final Context getContext() {
            return this.b;
        }

        public LiveSkuCallback(PromotionJumpDispatcher r2, Context r3, com.bytedance.android.ec.common.api.jump.model.g r4, String r5) {
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r4, "promotionParams");
            Intrinsics.checkNotNullParameter(r5, "sessionId");
            this.d = r2;
            this.b = r3;
            this.c = r4;
            this.a = r5;
        }
    }

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ Context a;
        public final /* synthetic */ Function1 b;

        public b(Context r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            ECAskExplainResponse r5 = (ECAskExplainResponse) r4;
            if (r5 != null) goto L5;
            return;
        L5:
            if (((com.bytedance.android.ec.model.g) r5).statusCode != 0) goto L9;
            Context r0 = this.a;
            com.bytedance.android.livesdk.livecommerce.utils.k.n(r0, th.a.g(r0, 2131896694));
            this.b.invoke(Long.valueOf(r5.getUserCount()));
            return;
        }
    }

    public static final class c implements v0<ECPromotionCheckResponse> {
        public final /* synthetic */ PromotionJumpDispatcher a;
        public final /* synthetic */ String b;
        public final /* synthetic */ il2.a c;
        public final /* synthetic */ Function1 d;
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g e;
        public final /* synthetic */ com.bytedance.android.btm.api.model.d f;
        public final /* synthetic */ Context g;
        public final /* synthetic */ String h;
        public final /* synthetic */ Function1 i;

        @Override // vi2.v0
        public final void onError(Throwable r10) {
            Map r0 = com.bytedance.android.ec.core.monitor.c.a;     // Catch: Exception -> L4
            com.bytedance.android.ec.core.monitor.c.j(this.b, MetricNames.API_DURATION);     // Catch: Exception -> L4
            com.bytedance.android.ec.core.monitor.c.d(this.b);     // Catch: Exception -> L4
        L6:
            if (r10 != null) goto L8;
            Throwable r1 = new Throwable("check promotion fail");
        L9:
            ECExceptionMonitor.e(r1);
            il2.a r2 = this.c;
            if (r2 != null) goto L12;
        L18:
            String r3 = a2.d(this.h);
            if (r3 == null) goto L21;
            PromotionJumpDispatcher.z(this.a, this.g, r3);
        L21:
            Function1 r4 = this.i;
            if (r4 == null) goto L27;
            Unit r11 = (Unit) r4.invoke(r10);
            return;
        L27:
            return;
        L12:
            if (r10 == null) goto L14;
            String r5 = r10.getMessage();
        L15:
            il2.a r6 = il2.a.C0145a.a(r2, "req_check_v2_fail", null, false, r5, null, null, 48);
            if (r6 == null) goto L18;
            ((LiveActionTracker) r6).e(false);
            goto L18
        L14:
            r5 = null;
            goto L15
        L8:
            r1 = r10;
        L4:
            e = move-exception;
            ECExceptionMonitor.e(e);
            goto L6
        }

        @Override // vi2.v0
        public final void onSuccess(ECPromotionCheckResponse r11) {
            ECPromotionCheckResponse r12 = r11;
            Map r0 = com.bytedance.android.ec.core.monitor.c.a;
            com.bytedance.android.ec.core.monitor.c.j(this.b, MetricNames.API_DURATION);
            if (r12 != null) goto L5;
        L10:
            oh.a.b("livesdk_check_promotion_toast", new k(this, r12));
            il2.a r2 = this.c;
            String r1 = null;
            if (r2 != null) goto L13;
        L23:
            PromotionJumpDispatcher r3 = this.a;
            Context r4 = this.g;
            if (r12 == null) goto L26;
            r1 = ((com.bytedance.android.ec.model.g) r12).statusMessage;
        L26:
            PromotionJumpDispatcher.z(r3, r4, r1);
        L27:
            com.bytedance.android.ec.core.monitor.c.d(this.b);
            return;
        L13:
            if (r12 == null) goto L15;
            String r5 = String.valueOf(((com.bytedance.android.ec.model.g) r12).statusCode);
        L16:
            Map r6 = MapsKt.mapOf(TuplesKt.to("status_code", r5));
            if (r12 == null) goto L19;
            String r7 = ((com.bytedance.android.ec.model.g) r12).statusMessage;
        L20:
            il2.a r8 = il2.a.C0145a.a(r2, "req_check_v2_fail", r6, false, r7, null, null, 48);
            if (r8 == null) goto L23;
            ((LiveActionTracker) r8).e(false);
            goto L23
        L19:
            r7 = null;
            goto L20
        L15:
            r5 = null;
            goto L16
        L5:
            if (((com.bytedance.android.ec.model.g) r12).statusCode != 0) goto L10;
            il2.a r9 = this.c;
            if (r9 == null) goto L9;
            il2.a.C0145a.a(r9, "req_check_v2_success", null, false, null, null, null, 62);
        L9:
            this.d.invoke(r12);
            goto L27
        }

        public c(PromotionJumpDispatcher r1, String r2, il2.a r3, Function1 r4, com.bytedance.android.ec.common.api.jump.model.g r5, com.bytedance.android.btm.api.model.d r6, Context r7, String r8, Function1 r9) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
        }
    }

    static {
    }

    public static jf.e F(com.bytedance.android.ec.common.api.jump.model.f r1, ql.a r2) {
        JSONObject r3 = r2.getExtraTransmissibleLogParams();
        if (r3 == null) goto L5;
        String r4 = r3.optString("carrier_type");
    L7:
        if (Intrinsics.areEqual(r4, "live_gift") == true) goto L14;
        if (r1 == null) goto L13;
        jf.e r5 = r1.d;
        if (r5 == null) goto L13;
        return r5;
    L13:
        return jf.e.g.b;
    L14:
        return jf.e.b.b;
    L5:
        r4 = null;
        goto L7
    }

    public static int M(ql.a r1, String r2) {
        if (Intrinsics.areEqual(r2, "matching_button") == false) goto L6;
        Integer r3 = 10;
    L17:
        if (r3 != null) goto L21;
        return 0;
    L21:
        return r3.intValue();
    L6:
        if ((!Intrinsics.areEqual(r2, "button")) == false) goto L11;
        ECJumpDestination r4 = r1.getJumpDestination();
        if (r4 == null) goto L16;
        r3 = Integer.valueOf(r4.getBlank());
    L16:
        r3 = null;
        goto L17
    L11:
        if (r1.shouldShowFindSimilar() == false) goto L13;
        r3 = 8;
        goto L17
    L13:
        ECJumpDestination r5 = r1.getJumpDestination();
        if (r5 == null) goto L16;
        r3 = Integer.valueOf(r5.getButton());
        goto L17
    }

    public final void b(final Context r14, final com.bytedance.android.ec.common.api.jump.model.g r15) {
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter("blank", "clickArea");
        Intrinsics.checkNotNullParameter(r15, "promotionParams");
        if (EComABUtils.getLiveLongPressFindSimilarity() == true) goto L5;
        return;
    L5:
        final Function1<ECPromotionCheckResponse, Unit> r0 = new PromotionJumpDispatcher$clickLongPress$callback$1(r14, r15);
        ECUIPromotion r1 = r15.a;
        if (r1 == null) goto L10;
        D(this, r14, r15, 2, 0, 1, r1.isFlash(), null, null, null, new PromotionJumpDispatcher$clickLongPress$1(r0), 8136);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.promotion.ECUIPromotion");
    }

    public PromotionJumpDispatcher(bk2.d r2, jf.c r3, com.bytedance.android.livesdk.livecommerce.promotion.card.d r4) {
        Intrinsics.checkNotNullParameter(r2, "disposableScope");
        Intrinsics.checkNotNullParameter(r4, "promotionSimpleSku");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.b = EComABUtils.enableCheckRespAppendPromotion();
        this.c = EComABUtils.getPromotionSchemaOpt();
        this.d = new com.bytedance.android.livesdk.livecommerce.iron.helper.c();
        this.e = LazyKt.lazy(new PromotionJumpDispatcher$dispatcherScope$2(this));
    }

    public static void E(sl.g r2, IOrderSchema r3, String r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r2 != null) goto L6;
    L7:
        if (r2 != null) goto L9;
    L16:
        int r5 = ECSdk.a;
        IEShoppingService r6 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r6 == null) goto L26;
        sc3.c r7 = r6.getBuyNowService();
        if (r7 == null) goto L27;
        String r8 = r3.getQueryParam("check_parallel_id");
        if (r8 != null) goto L23;
        r8 = "";
    L23:
        r7.f(r8, r4);
        return;
    L27:
        return;
    L26:
        return;
    L9:
        if (r2.a() != 1) goto L15;
        StringBuilder r9 = new StringBuilder();
        r9.append(r2.a());
        r9.append('_');
        sl.a r10 = r2.b();
        if (r10 == null) goto L13;
        String r11 = r10.a();
    L14:
        r9.append(r11);
        r4 = r9.toString();
        goto L16
    L13:
        r11 = null;
        goto L14
    L15:
        r4 = r2.a() + "_null";
        goto L16
    L6:
        if (r2.a() != 6) goto L7;
    }

    public static final void t(PromotionJumpDispatcher r5, ECPromotionCheckResponse r6, ql.a r7) {
        if (r5.b == false) goto L53;
        com.bytedance.android.ec.model.response.n r8 = r6.getAddCartParams();
        if (r8 == null) goto L48;
        String r9 = r8.b();
        if (r9 == null) goto L49;
        boolean r1 = false;
        if (r9.length() <= 0) goto L12;
        boolean r0 = true;
    L13:
        String r3 = null;
        if (r0 == true) goto L17;
        r9 = null;
    L17:
        if (r9 == null) goto L50;
        JSONObject r10 = z1.g(r9);
        if (r10 == null) goto L51;
        String r2 = r7.getTrackExtra();
        if (r2.length() <= 0) goto L23;
        r1 = true;
    L23:
        if (r1 == true) goto L26;
        r2 = null;
    L26:
        if (r2 == null) goto L36;
        JSONObject r4 = z1.g(r2);
        if (r4 == null) goto L36;
        Iterator<String> r11 = r10.keys();
    L31:
        if (r11.hasNext() == false) goto L35;
        String r12 = r11.next();
        Object r13 = r10.opt(r12);
        if (r13 == null) goto L31;
        r4.put(r12, r13);
        goto L31
    L35:
        r7.setTrackExtra(r4.toString());
        return;
    L36:
        com.bytedance.android.ec.model.response.n r14 = r6.getAddCartParams();
        if (r14 == null) goto L39;
        r3 = r14.b();
    L39:
        if (r3 != null) goto L41;
        r3 = "";
    L41:
        r7.setTrackExtra(r3);
        Unit r15 = Unit.INSTANCE;
        return;
    L51:
        return;
    L50:
        return;
    L12:
        r0 = false;
        goto L13
    L49:
        return;
    L48:
        return;
    }

    public static final void z(PromotionJumpDispatcher r0, Context r1, String r2) {
        r0.getClass();
        if (r1 == null) goto L9;
        if (r2 != null) goto L7;
        r2 = "";
    L7:
        com.bytedance.android.livesdk.livecommerce.utils.k.n(r1, r2);
        return;
    }

    public final void f(Context r11, com.bytedance.android.ec.common.api.jump.model.g r12, Function1<? super Long, Unit> r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "promotionParams");
        Intrinsics.checkNotNullParameter(r13, "success");
        ql.a r0 = r12.a;
        LiveRoomParams r14 = r12.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        String r2 = r0.getPromotionId();
        String r1 = null;
        if (r14 == null) goto L5;
        String r4 = r14.getAuthorId();
    L6:
        if (r14 == null) goto L8;
        String r5 = r14.getSecAuthorId();
    L9:
        if (r14 == null) goto L11;
        String r8 = r14.getRoomId();
    L12:
        if (r14 == null) goto L14;
        r1 = r14.getRoomUniqueKey();
    L14:
        String r3 = com.bytedance.android.ec.sdk.helper.r.a.getCurrentUserId();
        String r15 = vi2.h.a;
        bk2.c.a(vi2.h.e(r8, r1, si2.g.D, new vi2.u(r2, r3, r4, r5, r8, r1)).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(r11, r13)), this.f);
        return;
    L11:
        r8 = null;
        goto L12
    L8:
        r5 = null;
        goto L9
    L5:
        r4 = null;
        goto L6
    }

    public static void L(com.bytedance.android.ec.common.api.jump.model.a r5, String r6, String r7, com.bytedance.android.btm.api.model.d r8) {
        ECLiveABUtils r0 = ECLiveABUtils.INSTANCE;
        if (r0.getEC_LIVE_EVENT_ATTRIBUTION_PARAMS_UPLOAD() == false) goto L32;
        String r1 = null;
        if (r5 == null) goto L7;
        com.bytedance.android.ec.common.api.jump.model.f r2 = (com.bytedance.android.ec.common.api.jump.model.f) r5.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
    L8:
        if (r2 == null) goto L10;
        jf.b r3 = r2.c;
    L12:
        if (Intrinsics.areEqual(r3, jf.b.g.b) == false) goto L15;
        String r4 = "livesdk_popup_card";
    L25:
        if (r5 != null) goto L27;
        r5 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L27:
        sg2.v r9 = new sg2.v("ecom_module_click", r5);
        r9.c("page_name", "livesdk_live_room");
        r9.c("module_name", r4);
        r9.c("click_area", r6);
        r9.c("schema", StringsKt.take(r7, r0.getEC_LIVE_REPORT_PLATFORM_MAX_LENGTH().intValue()));
        if (r8 == null) goto L30;
        r1 = r8.a;
    L30:
        r9.i(r1);
        return;
    L15:
        if (Intrinsics.areEqual(r3, jf.b.f.b) == false) goto L17;
        r4 = "livesdk_live_list";
        goto L25
    L17:
        if (r2 == null) goto L21;
        jf.b r10 = r2.c;
        if (r10 == null) goto L21;
        r4 = r10.a;
    L22:
        if (r4 != null) goto L25;
        r4 = "";
    L21:
        r4 = null;
        goto L22
    L10:
        r3 = null;
        goto L12
    L7:
        r2 = null;
        goto L8
    }

    public final void c(Context r9, String r10, com.bytedance.android.btm.api.model.d r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r9, "context");
        if (r10 != null) goto L6;
        return;
    L6:
        if (r12 == false) goto L16;
        FloatWindowScene r13 = FloatWindowScene.SCENE_3D;
        int r2 = com.bytedance.android.ec.core.utils.v.a;
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter("3dmodel_page", "requestPageParam");
        Intrinsics.checkNotNullParameter(r13, "scene");
        int r3 = ECSdk.a;
        IAdapterService r4 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r4 == null) goto L16;
        com.bytedance.android.ec.adapter.api.j r5 = r4.getLiveWindowService();
        if (r5 == null) goto L16;
        Activity r6 = com.bytedance.android.ec.sdk.plugin.e.getActivity(r9);
        com.bytedance.android.ec.adapter.api.a r7 = new com.bytedance.android.ec.adapter.api.a();
        if (com.bytedance.android.ec.core.utils.u.a[r13.ordinal()] != 1) goto L15;
        RelativeLayout.LayoutParams r14 = new RelativeLayout.LayoutParams(1, 1);
        r14.addRule(10);
        r14.addRule(11);
        r14.topMargin = eh.b.b(r9);
        Unit r8 = Unit.INSTANCE;
        r7.f = r14;
    L15:
        Intrinsics.checkNotNullParameter("3dmodel_page", "<set-?>");
        r7.a = "3dmodel_page";
        Unit r15 = Unit.INSTANCE;
        r5.e(r6, r7);
    L16:
        n(r9, l0.s(r10, "meta_params", new Pair[]{new Pair("ecom_group_type", "live")}), r11, null, null, null);
    }

    public final void i(Context r12, com.bytedance.android.ec.common.api.jump.model.g r13, com.bytedance.android.btm.api.model.d r14, il2.a r15) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "promotionParams");
        ECUIPromotion r0 = r13.a;
        if (r0 == null) goto L79;
        ECUIPromotion r1 = r0;
        com.bytedance.android.ec.common.api.jump.model.f r2 = r13.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        LiveRoomParams r3 = r13.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        final Uri.Builder r4 = UriProtector.parse("sslocal://shopping/playback/").buildUpon();
        boolean r5 = true;
        if (EComABUtils.replayPreloadEnable() == false) goto L15;
        String r6 = r1.commentaryVideoData;
        if (r6 != null) goto L9;
    L12:
        boolean r7 = true;
    L13:
        if (r7 == true) goto L15;
        r4.appendQueryParameter("video_data", r1.commentaryVideoData);
        goto L15
    L9:
        if (r6.length() == 0) goto L12;
        r7 = false;
    L15:
        r4.appendQueryParameter("promotion_id", r1.getPromotionId());
        String r8 = null;
        if (r3 == null) goto L18;
        String r9 = r3.getRoomId();
    L19:
        String r10 = "";
        if (r9 != null) goto L22;
        r9 = "";
    L22:
        r4.appendQueryParameter("room_id", r9);
        if (r3 == null) goto L25;
        String r11 = r3.getAuthorId();
    L26:
        if (r11 != null) goto L28;
        r11 = "";
    L28:
        r4.appendQueryParameter("author_id", r11);
        if (r3 == null) goto L31;
        String r16 = r3.getSecAuthorId();
    L32:
        if (r16 != null) goto L34;
        r16 = "";
    L34:
        r4.appendQueryParameter("sec_author_id", r16);
        String r17 = r1.fragmentId;
        if (r17 != null) goto L37;
        r17 = "";
    L37:
        r4.appendQueryParameter("fragment_id", r17);
        r4.appendQueryParameter("enter_scene", "live");
        int r18 = ExplainPlaybackUtils.a;
        if (ECSettingKeys.D() == LiveReplayPageOptEnums.MULTI_CARD.getTrial()) goto L42;
        r5 = false;
    L42:
        if (r5 == false) goto L44;
        r4.appendQueryParameter("enable_multi_card", "1");
    L44:
        if (r3 == null) goto L46;
        String r19 = r3.getFollowStatus();
    L47:
        if (r19 != null) goto L49;
        r19 = "";
    L49:
        r4.appendQueryParameter("follow_status", r19);
        JSONObject r20 = r13.getEntranceInfo();
        jf.b.j r21 = jf.b.j.b;
        r20.put("carrier_type", "replay_popup_card");
        r20.put("ecom_group_type", "live");
        r4.appendQueryParameter("entrance_info", r20.toString());
        Map r22 = r1.getEventParams();
        if (r22 == null) goto L60;
        Iterator r23 = r22.entrySet().iterator();
    L53:
        if (r23.hasNext() == false) goto L60;
        Map.Entry r24 = (Map.Entry) r23.next();
        if (TextUtils.isEmpty((CharSequence) r24.getKey()) == true) goto L53;
        if (TextUtils.isEmpty((CharSequence) r24.getValue()) == true) goto L53;
        r4.appendQueryParameter((String) r24.getKey(), (String) r24.getValue());
    L60:
        if (r1.getSingleSku() == true) goto L62;
        String r25 = "1";
    L63:
        r4.appendQueryParameter("with_sku", r25);
        r4.appendQueryParameter("ecom_entrance_form", "live_list_card");
        r4.appendQueryParameter("commodity_type", r1.getEventItemType());
        if (r3 == null) goto L66;
        String r26 = r3.getSourcePage();
    L67:
        if (r26 == null) goto L70;
        r10 = r26;
    L70:
        r4.appendQueryParameter("source_page", r10);
        r4.appendQueryParameter("from_live", "1");
        if (r2 == null) goto L73;
        String r27 = r2.a;
    L74:
        if (r2 == null) goto L76;
        r8 = r2.b;
    L76:
        UtilityKotlinExtentionsKt.f(r27, r8, new PromotionJumpDispatcher$openVideoPlayback$2(r4));
        n(r12, r4.build().toString(), r14, r13, null, r15);
        return;
    L73:
        r27 = null;
        goto L74
    L66:
        r26 = null;
        goto L67
    L62:
        r25 = BDLocationException.ERROR_TIMEOUT;
        goto L63
    L46:
        r19 = null;
        goto L47
    L31:
        r16 = null;
        goto L32
    L25:
        r11 = null;
        goto L26
    L18:
        r9 = null;
        goto L19
    L79:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.promotion.ECUIPromotion");
    }

    public final void o(final Context r2, final String r3, final LiveRoomParams r4, final com.bytedance.android.btm.api.model.d r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Map r0 = LoginUtil.a;
        LoginUtil.f(r2, new PromotionJumpDispatcher$openFromShopPage$1(r3, r4, r5, r2));
    }

    public final void A(final Context r8, com.bytedance.android.ec.common.api.jump.model.g r9, final boolean r10, final il2.a r11, final Function1 r12) {
        int r0 = ECLiveLoginHelper.a;
        ECLiveLoginHelper.b(r8, r9, r11, new PromotionJumpDispatcher$checkLoginAndLawHintAndExecute$1(this, r8, r10, r11, r12));
    }

    public final void e(Context r40, com.bytedance.android.ec.common.api.jump.model.g r41, com.bytedance.android.btm.api.model.d r42, LiveActionTracker r43, int r44) {
        Intrinsics.checkNotNullParameter(r41, "promotionParams");
        if (r43 == null) goto L6;
        il2.a.C0145a.a(r43, "open_product_detail_pdp", null, false, null, null, null, 62);
    L6:
        if (r40 != null) goto L12;
        if (r43 == null) goto L350;
        il2.a r1 = il2.a.C0145a.a(r43, "open_product_detail_pdp", null, false, "context_is_null", null, null, 48);
        if (r1 == null) goto L351;
        ((LiveActionTracker) r1).e(false);
        return;
    L351:
        return;
    L350:
        return;
    L12:
        jf.c r2 = this.g;
        if (r2 != null) goto L15;
    L21:
        PromotionDetailSchemaHelper r3 = PromotionDetailSchemaHelper.a;
        String r8 = r41.a.getScheme();
        if (r43 == null) goto L26;
        il2.b r10 = r43.b();
        if (r10 == null) goto L26;
        Long r11 = r10.a;
    L27:
        r3.getClass();
        Intrinsics.checkNotNullParameter(r40, "context");
        Intrinsics.checkNotNullParameter(r41, "absParams");
        com.bytedance.android.ec.common.api.jump.model.g r4 = r41.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.g.class));
        if (r4 == null) goto L30;
        final ql.a r12 = r4.a;
    L31:
        com.bytedance.android.ec.common.api.jump.model.f r13 = r41.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        gi2.a r14 = (gi2.a) r41.getParamsModel(Reflection.getOrCreateKotlinClass(gi2.a.class));
        pk2.b r15 = (pk2.b) r41.getParamsModel(Reflection.getOrCreateKotlinClass(pk2.b.class));
        final LiveRoomParams r16 = r41.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        UrlBuilderV2 r9 = new UrlBuilderV2(r8);
        JSONObject r0 = z1.g((String) r9.getMMap().get("ad_params"));
        if (r0 != null) goto L34;
        r0 = new JSONObject();
    L34:
        String r17 = (String) r9.getMMap().get("client_params");
        if (r17 == null) goto L38;
        JSONObject r18 = z1.g(r17);
        if (r18 == null) goto L38;
    L39:
        String r7 = (String) r9.getMMap().get("product_info");
        if (r7 == null) goto L43;
        JSONObject r19 = z1.g(r7);
        if (r19 == null) goto L43;
    L44:
        ECEventUtilsV2.b.getClass();
        Intrinsics.checkNotNullParameter(r0, "adParams");
        JSONObject r5 = z1.g(r0.optString("ad_extra_data"));
        if (r5 == null) goto L47;
        r5.put("source_page", "live_confirm_button");
    L48:
        if (r5 == null) goto L50;
        com.bytedance.android.shopping.extensions.k.l(r0, "ad_extra_data", r5.toString());
        Unit r6 = Unit.INSTANCE;
    L50:
        com.bytedance.android.shopping.extensions.k.l(r18, "show_sku_panel", Long.valueOf(r44));
        if (ECLiveABUtils.INSTANCE.getECOM_DETAIL_SHOW_HOT_ATMOSPHERE().booleanValue() == false) goto L56;
        if (r12 == null) goto L56;
        ECHotAtmosphere r20 = r12.getHotAtmosphere();
        if (r20 == null) goto L56;
        com.bytedance.android.shopping.extensions.k.l(r18, "live_hot_sale_component", com.bytedance.android.shopping.extensions.k.v(r20).toString());
    L56:
        if (r13 == null) goto L58;
        jf.b r21 = r13.c;
    L60:
        if (Intrinsics.areEqual(r21, jf.b.j.b) == false) goto L62;
        long r110 = 1;
    L63:
        com.bytedance.android.shopping.extensions.k.l(r18, "disable_live_window", Long.valueOf(r110));
        com.bytedance.android.shopping.extensions.k.l(r19, "promotion_source", Long.valueOf(SourceType.XIAO_DIAN.getType()));
        if (r11 == null) goto L66;
        com.bytedance.android.shopping.extensions.k.l(r18, "pre_page_click_start", r11);
    L66:
        final JSONObject r22 = r41.getEntranceInfo();
        if (r16 == null) goto L69;
        String r23 = r16.getLogExtra();
    L70:
        JSONObject r24 = z1.g(r23);
        if (r24 == null) goto L73;
        r24.remove("vid");
        com.bytedance.android.shopping.extensions.k.l(r0, "log_extra", r24);
    L74:
        if (r16 == null) goto L78;
        Map r25 = r16.getReportParams();
        if (r25 == null) goto L78;
        JSONObject r26 = cd.a.c(r25);
    L79:
        if (r16 == null) goto L86;
        Function0 r27 = r16.getScreenType();
        if (r27 == null) goto L86;
        String r28 = (String) r27.invoke();
        if (r28 == null) goto L86;
        com.bytedance.android.shopping.extensions.k.l(r26, "screen_type", r28);
        Unit r29 = Unit.INSTANCE;
    L86:
        if (r12 == null) goto L88;
        String r30 = r12.getBaseVerifiedCategory();
    L89:
        String r31 = a2.d(r30);
        if (r31 == null) goto L93;
        com.bytedance.android.shopping.extensions.k.l(r26, "base_verified_category", r31);
        Unit r32 = Unit.INSTANCE;
    L93:
        if (r12 == null) goto L97;
        String r45 = "1";
        boolean r33 = r12.isCrossborderProduct();
        String r111 = BDLocationException.ERROR_TIMEOUT;
        if (r33 != true) goto L98;
        String r34 = r45;
    L99:
        com.bytedance.android.shopping.extensions.k.l(r26, "is_crossborder_goods", r34);
        if (r12 == null) goto L105;
        if (r12.isPreSale() != true) goto L105;
        String r35 = r45;
    L106:
        com.bytedance.android.shopping.extensions.k.l(r26, "upfront_presell", r35);
        if (r12 != null) goto L109;
    L111:
        String r36 = r111;
    L112:
        com.bytedance.android.shopping.extensions.k.l(r26, "is_explaining", r36);
        if (r12 == null) goto L115;
        String r37 = String.valueOf(r12.getLocalNum());
    L116:
        String r38 = a2.d(r37);
        if (r38 == null) goto L120;
        com.bytedance.android.shopping.extensions.k.l(r26, "local_num", r38);
        Unit r39 = Unit.INSTANCE;
    L120:
        if (r12 == null) goto L143;
        UrlBuilderV2 r210 = r9;
        JSONObject r46 = r12.getTransmissibleJson(false);
        if (r46 == null) goto L144;
        if (r16 == null) goto L125;
        String r47 = r16.getEcomSceneId();
    L126:
        r19 = r19;
        if (r47 != null) goto L129;
        r47 = "";
    L129:
        com.bytedance.android.shopping.extensions.k.l(r46, "ecom_scene_id", r47);
        if (r16 == null) goto L132;
        String r48 = r16.getAuthorId();
    L133:
        if (r48 != null) goto L135;
        r48 = "";
    L135:
        com.bytedance.android.shopping.extensions.k.l(r46, "anchor_id", r48);
        if (r16 == null) goto L138;
        String r49 = r16.getRoomId();
    L139:
        if (r49 != null) goto L141;
        r49 = "";
    L141:
        com.bytedance.android.shopping.extensions.k.l(r46, "room_id", r49);
        Unit r50 = Unit.INSTANCE;
        boolean r51 = true;
    L145:
        x0.b(r26, r46, r51);
        if (r22 == null) goto L188;
        String r52 = a2.d(r22.optString("anchor_id"));
        if (r52 == null) goto L150;
        com.bytedance.android.shopping.extensions.k.l(r26, "author_id", r52);
        Unit r53 = Unit.INSTANCE;
    L150:
        String r54 = a2.d(r22.optString("enter_from_merge"));
        if (r54 == null) goto L153;
        com.bytedance.android.shopping.extensions.k.l(r26, "carrier_source", r54);
        Unit r55 = Unit.INSTANCE;
    L153:
        String r56 = a2.d(r22.optString("enter_from_merge"));
        if (r56 == null) goto L156;
        com.bytedance.android.shopping.extensions.k.l(r26, "enter_from_merge", r56);
        Unit r57 = Unit.INSTANCE;
    L156:
        String r58 = a2.d(r22.optString("enter_method"));
        if (r58 == null) goto L159;
        com.bytedance.android.shopping.extensions.k.l(r26, "enter_method", r58);
        Unit r59 = Unit.INSTANCE;
    L159:
        String r60 = a2.d(r22.optString("follow_status"));
        if (r60 == null) goto L162;
        com.bytedance.android.shopping.extensions.k.l(r26, "follow_status", r60);
        Unit r61 = Unit.INSTANCE;
    L162:
        String r62 = a2.d(r22.optString("group_id"));
        if (r62 == null) goto L165;
        com.bytedance.android.shopping.extensions.k.l(r26, "group_id", r62);
        Unit r63 = Unit.INSTANCE;
    L165:
        String r64 = a2.d(r22.optString("creative_id"));
        if (r64 == null) goto L168;
        com.bytedance.android.shopping.extensions.k.l(r26, "creative_id", r64);
        Unit r65 = Unit.INSTANCE;
    L168:
        if (r24 == null) goto L174;
        String r66 = r24.toString();
        if (r66 == null) goto L174;
        String r67 = a2.d(r66);
        if (r67 == null) goto L174;
        com.bytedance.android.shopping.extensions.k.l(r26, "log_extra", r67);
        Unit r68 = Unit.INSTANCE;
    L174:
        String r69 = a2.d(r22.optString("is_other_channel"));
        if (r69 == null) goto L177;
        com.bytedance.android.shopping.extensions.k.l(r26, "is_other_channel", r69);
        Unit r70 = Unit.INSTANCE;
    L177:
        JSONObject r71 = z1.g(r22.optString("live_tracker_params"));
        if (r71 == null) goto L186;
        Iterator<String> r72 = r71.keys();
    L181:
        if (r72.hasNext() == false) goto L185;
        String r73 = r72.next();
        String r112 = a2.d(r71.optString(r73));
        if (r112 == null) goto L181;
        com.bytedance.android.shopping.extensions.k.l(r26, r73, r112);
        Unit r74 = Unit.INSTANCE;
        goto L181
    L185:
        Unit r75 = Unit.INSTANCE;
    L186:
        Unit r76 = Unit.INSTANCE;
    L188:
        int r77 = com.bytedance.android.livesdk.livecommerce.utils.q.a;
        EnumEntranceInfoScene r78 = EnumEntranceInfoScene.ENTER_PRODUCT_DETAIL;
        gl.a r79 = com.bytedance.android.livesdk.livecommerce.utils.q.a(r78, null);
        if (r79 == null) goto L215;
        Pair[] r80 = new Pair[4];
        if (r12 == null) goto L195;
        gi2.a r211 = r14;
        char r113 = 1;
        if (r12.isOnExplaining() != true) goto L196;
        String r114 = r45;
    L197:
        r80[0] = TuplesKt.to("is_explaining", r114);
        if (r12 == null) goto L204;
        ECUIAskExplainInfo r81 = r12.getAskExplainInfo();
        if (r81 == null) goto L204;
        if (r81.isAsked() != r113) goto L204;
        String r82 = r45;
    L205:
        r80[r113] = TuplesKt.to("is_explain_apply", r82);
        if (r12 == null) goto L208;
        String r83 = String.valueOf(r12.getLocalNum());
    L209:
        r80[2] = TuplesKt.to("local_num", r83);
        if (r12 == null) goto L213;
        String r85 = r12.getEcomGroupType();
        if (r85 == null) goto L213;
    L214:
        r80[3] = TuplesKt.to("ecom_group_type", r85);
        r79.g(r80);
        Unit r86 = Unit.INSTANCE;
    L216:
        if (r79 == null) goto L218;
        com.bytedance.android.livesdk.livecommerce.utils.s.a(r79, r22, PromotionDetailSchemaHelper$buildPromotionDetailPdpSchema$entranceInfoJSON$1$1.INSTANCE);
        Unit r87 = Unit.INSTANCE;
    L218:
        if (r79 == null) goto L220;
        com.bytedance.android.livesdk.livecommerce.utils.s.b(r79, new Pair[]{TuplesKt.to("ecom_group_type", "live")}, new PromotionDetailSchemaHelper$buildPromotionDetailPdpSchema$$inlined$run$lambda$1(r12, r22, r16));
        Unit r88 = Unit.INSTANCE;
    L220:
        if (r79 == null) goto L230;
        Pair[] r89 = new Pair[2];
        if (r22 == null) goto L224;
        String r90 = r22.optString("enter_method");
    L225:
        r89[0] = TuplesKt.to("source_method", r90);
        if (r22 == null) goto L228;
        String r91 = r22.optString("enter_from_merge");
    L229:
        r89[1] = TuplesKt.to("carrier_source", r91);
        com.bytedance.android.livesdk.livecommerce.utils.s.b(r79, r89, new PromotionDetailSchemaHelper$buildPromotionDetailPdpSchema$$inlined$run$lambda$2(r12, r22, r16));
        Unit r92 = Unit.INSTANCE;
        goto L230
    L228:
        r91 = null;
        goto L229
    L224:
        r90 = null;
    L230:
        if (r79 == null) goto L259;
        Pair[] r93 = new Pair[4];
        if (r12 == null) goto L234;
        String r94 = r12.getPromotionId();
    L235:
        r93[0] = TuplesKt.to("promotion_id", r94);
        if (r12 == null) goto L238;
        String r95 = r12.getProductId();
    L239:
        r93[1] = TuplesKt.to("product_id", r95);
        if (r12 == null) goto L242;
        String r96 = r12.getPromotionId();
    L244:
        if (cg4.a.a(r96) == true) goto L247;
        r96 = null;
    L247:
        if (r96 != null) goto L251;
        if (r12 == null) goto L250;
        r96 = r12.getProductId();
        goto L251
    L250:
        r96 = null;
    L251:
        r93[2] = TuplesKt.to("commodity_id", r96);
        if (r12 == null) goto L257;
        String r97 = r12.getEventItemType();
        if (r97 == null) goto L257;
        String r98 = r97;
    L258:
        r93[3] = TuplesKt.to("commodity_type", r98);
        com.bytedance.android.livesdk.livecommerce.utils.s.b(r79, r93, new PromotionDetailSchemaHelper$buildPromotionDetailPdpSchema$$inlined$run$lambda$3(r12, r22, r16));
        Unit r99 = Unit.INSTANCE;
    L257:
        r98 = r111;
        goto L258
    L242:
        r96 = null;
        goto L244
    L238:
        r95 = null;
        goto L239
    L234:
        r94 = null;
    L259:
        if (r79 == null) goto L264;
        if (r16 == null) goto L262;
        JSONObject r100 = r16.getPassThroughLogData();
    L263:
        com.bytedance.android.livesdk.livecommerce.utils.s.a(r79, r100, PromotionDetailSchemaHelper$buildPromotionDetailPdpSchema$entranceInfoJSON$1$6.INSTANCE);
        Unit r101 = Unit.INSTANCE;
        goto L264
    L262:
        r100 = null;
    L264:
        if (r79 == null) goto L266;
        JSONObject r102 = r79.e();
    L268:
        if (r15 == null) goto L270;
        com.bytedance.android.shopping.extensions.k.l(r18, "clear_screen_upon", "clear_screen_upon_card");
    L278:
        hh2.g r103 = hh2.f.a.a;
        if (r103 == null) goto L283;
        Boolean r104 = r103.c();
        if (r104 == null) goto L283;
        boolean r105 = r104.booleanValue();
    L284:
        if (r105 == false) goto L292;
        int r106 = ECSdk.a;
        s83.g r107 = (s83.g) ECSdk.a(s83.g.class);
        if (r107 == null) goto L291;
        s83.a r108 = r107.q();
        if (r108 == null) goto L291;
        if (r108.i() == 0) goto L292;
    L291:
        boolean r109 = true;
    L293:
        if (r109 == false) goto L295;
        com.bytedance.android.shopping.extensions.k.l(r18, "full_mode", 1L);
    L295:
        if (r12 == null) goto L308;
        ECUrlModel r115 = r12.getDetailCover();
        if (r115 == null) goto L308;
        List r116 = r115.getUrlList();
        if (r116 == null) goto L308;
        String r117 = (String) CollectionsKt.getOrNull(r116, 0);
        if (r117 == null) goto L308;
        if ((!StringsKt.isBlank(r117)) == true) goto L306;
        r117 = null;
    L306:
        if (r117 == null) goto L308;
        JSONObject r118 = r19;
        com.bytedance.android.shopping.extensions.k.l(r118, "cover_img", r117);
    L309:
        UrlBuilderV2 r119 = r210;
        r119.addOrReplaceParam("client_params", r18);
        r119.addOrReplaceParam("product_info", r118);
        int r120 = ECSdk.a;
        IEShoppingService r121 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r121 == null) goto L314;
        p83.d r122 = r121.getAnchorV3Service();
        if (r122 == null) goto L314;
        String r123 = r122.c(r40, r119.build(), new p83.h(false, null, null, false, null, null, r102, r26, null, null, r0, null, null, null, null, 16252734));
    L315:
        if (r123 == null) goto L322;
        if (r4 == 0) goto L318;
        Map r124 = r4.getChainParams();
    L319:
        String r125 = BtmUtilsKt.b(r123, BtmUtilsKt.a(r42, r124));
        if (r125 == null) goto L323;
        com.bytedance.android.livesdk.livecommerce.utils.s.d(r125, r78, new PromotionDetailSchemaHelper$buildPromotionDetailPdpSchema$5(r16));
        com.bytedance.android.livesdk.livecommerce.utils.s.c(r125, r78);
    L324:
        if (r125 != null) goto L326;
        String r126 = "";
    L327:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new PromotionJumpDispatcher$reportAdParamsPdp$1(r126, null), 2, null);
        cl.d r127 = com.bytedance.android.ec.sdk.helper.k.a();
        if (r127 == null) goto L330;
        r127.h(MapsKt.mapOf(TuplesKt.to("detailSchema", r126)));
    L330:
        LiveRoomParams r128 = r41.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        if (r42 == null) goto L338;
        BcmParams r129 = r42.c;
        if (r129 == null) goto L338;
        if (r128 == null) goto L336;
        String r130 = r128.getAuthorId();
    L337:
        r129.put("author_id", r130);
        goto L338
    L336:
        r130 = null;
    L338:
        if (r43 == null) goto L340;
        String r131 = "button";
        il2.a.C0145a.a(r43, "open_product_detail_pdp", MapsKt.mapOf(new Pair[]{TuplesKt.to("click_area", r131), TuplesKt.to("force_fullscreen", String.valueOf(false))}), false, null, null, null, 60);
    L341:
        n(r40, r126, r42, r41, r131, r43);
        jf.c r132 = this.g;
        if (r132 == null) goto L354;
        r132.a();
        return;
    L354:
        return;
    L340:
        r131 = "button";
        goto L341
    L326:
        r126 = r125;
    L323:
        r125 = null;
        goto L324
    L318:
        r124 = null;
        goto L319
    L322:
        r42 = r42;
    L314:
        r123 = null;
    L308:
        r118 = r19;
    L292:
        r109 = false;
    L283:
        r105 = true;
        goto L284
    L270:
        if (r211 == null) goto L272;
        com.bytedance.android.shopping.extensions.k.l(r18, "clear_screen_upon", "clear_screen_upon_list");
        goto L278
    L272:
        if (r13 == null) goto L274;
        jf.b r133 = r13.c;
    L276:
        if (Intrinsics.areEqual(r133, jf.b.k.b) == false) goto L278;
        com.bytedance.android.shopping.extensions.k.l(r18, "clear_screen_upon", "clear_screen_upon_card");
        goto L278
    L274:
        r133 = null;
        goto L276
    L266:
        r102 = null;
    L213:
        r85 = "live";
        goto L214
    L208:
        r83 = null;
    L204:
        r82 = r111;
    L196:
        r114 = r111;
        goto L197
    L195:
        r211 = r14;
        r113 = 1;
        goto L196
    L215:
        r211 = r14;
        goto L216
    L138:
        r49 = null;
        goto L139
    L132:
        r48 = null;
        goto L133
    L125:
        r47 = null;
    L144:
        r51 = true;
        r46 = null;
        goto L145
    L143:
        r210 = r9;
        goto L144
    L115:
        r37 = null;
        goto L116
    L109:
        if (r12.isOnExplaining() != true) goto L111;
        r36 = r45;
    L105:
        r35 = r111;
    L98:
        r34 = r111;
        goto L99
    L97:
        r45 = "1";
        r111 = BDLocationException.ERROR_TIMEOUT;
        goto L98
    L88:
        r30 = null;
    L78:
        r26 = new JSONObject();
        goto L79
    L73:
        r24 = null;
        goto L74
    L69:
        r23 = null;
        goto L70
    L62:
        r110 = 0;
        goto L63
    L58:
        r21 = null;
        goto L60
    L47:
        r5 = null;
    L43:
        r19 = new JSONObject();
    L38:
        r18 = new JSONObject();
        goto L39
    L30:
        r12 = null;
    L26:
        r11 = null;
        goto L27
    L15:
        if (r2.c(r40, r42, false) != true) goto L21;
        if (r43 == null) goto L352;
        il2.a r134 = il2.a.C0145a.a(r43, "open_product_detail_intercepted", null, false, null, null, null, 62);
        if (r134 == null) goto L353;
        ((LiveActionTracker) r134).e(false);
        return;
    L353:
        return;
    }

    public final void k(final Context r14, final String r15, final com.bytedance.android.ec.common.api.jump.model.g r16, final com.bytedance.android.btm.api.model.d r17, final LiveActionTracker r18) {
        final String r4 = "button";
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r15, "schema");
        Intrinsics.checkNotNullParameter(r16, "promotionParams");
        int r0 = ECSdk.a;
        IEShoppingService r1 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r1 == null) goto L7;
        sc3.c r2 = r1.getBuyNowService();
        if (r2 == null) goto L7;
        com.bytedance.android.shopping.buynow.monitor.firstscreen.a r3 = r2.n(new com.bytedance.android.ec.model.d(r14, "PromotionJumpDispatcher_3", System.currentTimeMillis()));
    L8:
        if (r3 == null) goto L10;
        r3.c(ChainPoint.PAGE_INIT, null);
    L10:
        if (r3 == null) goto L12;
        r3.c(ChainPoint.PAGE_START, Long.valueOf(System.currentTimeMillis()));
    L12:
        final String r5 = UUID.randomUUID().toString();
        B(this, r14, r16, "", r18, new PromotionJumpDispatcher$openSKUPanel$1(this, r14, r5, r4, r16, r15, r17, r18));
        return;
    L7:
        r3 = null;
        goto L8
    }

    public final void m(final Context r15, final String r16, final com.bytedance.android.ec.common.api.jump.model.g r17, final com.bytedance.android.btm.api.model.d r18, final LiveActionTracker r19) {
        final String r4 = "button";
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter("button", "clickArea");
        Intrinsics.checkNotNullParameter(r17, "promotionParams");
        int r0 = ECSdk.a;
        IEShoppingService r1 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r1 == null) goto L7;
        sc3.c r2 = r1.getBuyNowService();
        if (r2 == null) goto L7;
        final com.bytedance.android.shopping.buynow.monitor.firstscreen.a r9 = r2.n(new com.bytedance.android.ec.model.d(r15, "PromotionJumpDispatcher_3", System.currentTimeMillis()));
    L8:
        if (r9 == null) goto L10;
        r9.c(ChainPoint.PAGE_INIT, null);
    L10:
        if (r9 == null) goto L12;
        r9.c(ChainPoint.PAGE_START, Long.valueOf(System.currentTimeMillis()));
    L12:
        final String r3 = UUID.randomUUID().toString();
        B(this, r15, r17, "", r19, new PromotionJumpDispatcher$openOrderPanel$1(this, r15, r3, r4, r17, r16, r18, r19, r9));
        return;
    L7:
        r9 = null;
        goto L8
    }

    public final void p(final Context r2, final String r3, final com.bytedance.android.btm.api.model.d r4, String r5, final boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "schema");
        Intrinsics.checkNotNullParameter(r5, "source");
        Map r0 = LoginUtil.a;
        LoginUtil.e(r2, r5, new PromotionJumpDispatcher$loginAndOpenSchema$1(r6, r3, r2, r4));
    }

    public static /* synthetic */ void B(PromotionJumpDispatcher r6, Context r7, com.bytedance.android.ec.common.api.jump.model.g r8, String r9, il2.a r10, Function1 r11) {
        r6.A(r7, r8, true, r10, r11);
    }

    public final IOrderSchema K(Context r4, com.bytedance.android.ec.common.api.jump.model.g r5, sc3.b r6, String r7, int r8, com.bytedance.android.btm.api.model.d r9) {
        PrefetchOrder r0 = r5.a.getPrefetchOrder();
        if (r0 != null) goto L5;
        return null;
    L5:
        if (Intrinsics.areEqual(r7, "button") == true) goto L7;
        return null;
    L7:
        if (r8 == 1) goto L9;
        return null;
    L9:
        if (a2.b(r0.getSchema()) == false) goto L52;
        if (r6 == null) goto L12;
        r6.c(ChainPoint.CREATE_SCHEMA_START, null);
    L12:
        int r10 = f.a;
        IOrderSchema r11 = f.c(r0.getSchema(), r5, r7, r9);
        f.a(r11, UUID.randomUUID().toString(), r5, this.h);
        if (r11 == null) goto L45;
        LiveRoomParams r12 = r5.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        Map<String, String> r13 = ECLiveABUtils.INSTANCE.getEC_LIVE_PREFETCH_ORDER_ROUTE_RULE();
        int r14 = RoomContextController.h;
        if (r12 == null) goto L17;
        String r15 = r12.getRoomId();
    L18:
        if (r12 == null) goto L20;
        String r16 = r12.getRoomUniqueKey();
    L21:
        LiveRoomRedirectInfo r17 = RoomContextController.a.b(r15, r16).g;
        if (r17 == null) goto L24;
        String r18 = r17.a;
    L25:
        String r19 = r13.get(r18);
        String r20 = "";
        if (r19 != null) goto L28;
        r19 = "";
    L28:
        r11.replaceOrAppendParam("check_parallel_flag", r19);
        if (r0.isDiffModel() == false) goto L35;
        int r21 = ECSdk.a;
        IEShoppingService r22 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r22 == null) goto L40;
        sc3.c r23 = r22.getBuyNowService();
        if (r23 == null) goto L40;
        String r24 = r23.m(r4, r11);
    L41:
        if (r24 == null) goto L44;
        r20 = r24;
    L44:
        r11.replaceOrAppendParam("check_parallel_id", r20);
    L40:
        r24 = null;
        goto L41
    L35:
        int r25 = ECSdk.a;
        IEShoppingService r26 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r26 == null) goto L40;
        sc3.c r27 = r26.getBuyNowService();
        if (r27 == null) goto L40;
        r24 = r27.r(r4, r11);
        goto L41
    L24:
        r18 = null;
        goto L25
    L20:
        r16 = null;
        goto L21
    L17:
        r15 = null;
    L45:
        if (r6 == null) goto L48;
        r6.c(ChainPoint.CREATE_SCHEMA_END, null);
    L48:
        return r11;
    L52:
        return null;
    }

    public final void d(Context r14, LiveRoomParams r15, String r16, com.bytedance.android.btm.api.model.d r17, boolean r18, String r19) {
        Intrinsics.checkNotNullParameter(r14, "context");
        Map r1 = null;
        if (r15 == null) goto L5;
        String r3 = r15.getRoomId();
    L6:
        if (r15 == null) goto L8;
        String r4 = r15.getRoomUniqueKey();
    L9:
        if (r16 == null) goto L14;
        if (r15 == null) goto L12;
        Map r5 = r15.getChainParams();
    L13:
        String r6 = BtmUtilsKt.b(r16, BtmUtilsKt.a(r17, r5));
    L16:
        if (r15 == null) goto L18;
        Map r0 = r15.getEcomLiveParams();
    L19:
        if (r0 != null) goto L21;
        r0 = MapsKt.emptyMap();
    L21:
        Map r10 = r0;
        if (r15 == null) goto L24;
        r1 = r15.getReportParams();
    L24:
        if (r1 != null) goto L26;
        Map r11 = MapsKt.emptyMap();
    L27:
        com.bytedance.android.livesdk.livecommerce.params.a.b(r14, r3, r4, r6, r19, r18, null, null, r10, r11, 192);
        return;
    L26:
        r11 = r1;
        goto L27
    L18:
        r0 = null;
        goto L19
    L12:
        r5 = null;
        goto L13
    L14:
        r6 = null;
        goto L16
    L8:
        r4 = null;
        goto L9
    L5:
        r3 = null;
        goto L6
    }

    public final void j(final Context r14, final com.bytedance.android.ec.common.api.jump.model.g r15, final com.bytedance.android.btm.api.model.d r16, final ListItemButtonModule$addCartListener$1 r17, final View r18, final Pair r19) {
        final String r4 = "button";
        Intrinsics.checkNotNullParameter(r15, "promotionParams");
        Intrinsics.checkNotNullParameter("button", "clickArea");
        if (r14 != null) goto L5;
        return;
    L5:
        B(this, r14, r15, "list_card_addcart", null, new PromotionJumpDispatcher$clickAddCart$1(this, r15, r14, r4, r16, r18, r19, r17));
    }

    public final void n(Context r10, String r11, com.bytedance.android.btm.api.model.d r12, com.bytedance.android.ec.common.api.jump.model.g r13, String r14, il2.a r15) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "schema");
        String r16 = BtmUtilsKt.b(r11, r12);
        if (r15 == null) goto L7;
        il2.a r17 = il2.a.C0145a.a(r15, "open_schema", null, false, null, null, r16, 30);
        if (r17 == null) goto L7;
        ((LiveActionTracker) r17).e(false);
    L7:
        Handler r18 = com.bytedance.android.livesdk.livecommerce.utils.k.a;
        com.bytedance.android.livesdk.livecommerce.room.f.b(r10, r16);
        L(r13, r14, r16, r12);
    }

    public final void g(final com.bytedance.android.ec.common.api.jump.model.g r20, final String r21, final boolean r22, final String r23, final BtmItemBuilder r24, final View r25, final boolean r26) {
        Intrinsics.checkNotNullParameter(r20, "promotionParams");
        Intrinsics.checkNotNullParameter(r21, "clickArea");
        LiveRoomParams r16 = r20.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        final com.bytedance.android.ec.common.api.jump.model.f r12 = r20.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        gi2.a r0 = (gi2.a) r20.getParamsModel(Reflection.getOrCreateKotlinClass(gi2.a.class));
        final pk2.b r8 = (pk2.b) r20.getParamsModel(Reflection.getOrCreateKotlinClass(pk2.b.class));
        final rh2.b r7 = (rh2.b) r20.getParamsModel(Reflection.getOrCreateKotlinClass(rh2.b.class));
        final ql.a r11 = r20.a;
        String r2 = null;
        if (r0 == null) goto L5;
        int r1 = 1;
    L10:
        Integer r17 = r1;
    L11:
        if (r17 == null) goto L20;
        Lazy r3 = LiveEventCenter.b;
        com.bytedance.android.livesdk.livecommerce.eventcenter.d r4 = LiveEventCenter.a.a();
        if (r16 == null) goto L15;
        String r5 = r16.getRoomId();
    L16:
        if (r16 == null) goto L18;
        String r6 = r16.getRoomUniqueKey();
    L19:
        r4.sendEvent("product_click", new lh2.b(r5, r6, r11, r17.intValue()));
        goto L20
    L18:
        r6 = null;
        goto L19
    L15:
        r5 = null;
    L20:
        if (r12 == null) goto L22;
        jf.b r9 = r12.c;
    L24:
        if (Intrinsics.areEqual(r9, jf.b.l.b) == false) goto L38;
        if (r24 == null) goto L29;
        BtmItemBuilder r10 = r24.copy();
        if (r10 == null) goto L29;
        PageFinder r13 = r10.getPageFinder();
    L30:
        BcmParams r14 = new BcmParams();
        JSONObject r15 = r20.getEntranceInfo();     // Catch: Throwable -> L35
        if (r15 == null) goto L37;
        r2 = r15.optString("search_params");     // Catch: Throwable -> L35
    L37:
        r14.put("search_params", r2);
        BcmParams.Companion.getClass();
        BcmParams r18 = BcmParams.a.a(r2);
        r14.put("search_id", r18.optString("search_id", ""));
        r14.put("search_result_id", r18.optString("search_result_id", ""));
        Unit r19 = Unit.INSTANCE;
        com.bytedance.android.bcm.api.b.a.setUnitParams(r13, "ecom_entrance", r14);
    L35:
        th = move-exception;
        ECExceptionMonitor.e(th);
        r2 = "";
    L29:
        r13 = null;
    L38:
        final Integer r110 = r17;
        oh.a.b("recordClickPromotionEvent", new PromotionJumpDispatcher$recordClickEvent$2(this, r11, r22, r21, r26, r7, r8, r20, r110, r24, r12, r25, r23));
        jf.c r27 = this.g;
        if (r27 == null) goto L41;
        r27.g(r21, r11, r24);
    L41:
        if (r22 == true) goto L43;
        return;
    L43:
        int r28 = r21.hashCode();
        if (r28 != (-1377687758)) goto L46;
        String r29 = "button";
        if (r21.equals("button") == false) goto L54;
    L53:
        String r30 = r29;
    L55:
        int r31 = M(r11, r21);
        if (r31 != 1) goto L58;
        String r32 = "confirm_page";
    L65:
        if (r16 != null) goto L67;
        return;
    L67:
        if (r16.isDisplayRoom() != true) goto L73;
        int r33 = com.bytedance.android.livesdk.livecommerce.room.controller.business.n.o;
        com.bytedance.android.livesdk.livecommerce.room.controller.business.n.H(com.bytedance.android.livesdk.livecommerce.room.controller.business.n.a.a(r16.getDisplayRoomId(), r16.getRoomUniqueKey()), r20.a, r30, r32);
        return;
    L73:
        return;
    L58:
        if (r31 != 2) goto L60;
        r32 = "landing_page";
        goto L65
    L60:
        if (r31 == 6) goto L62;
        r32 = "shop_ad";
        goto L65
    L62:
        r32 = "";
    L54:
        r30 = "";
        goto L55
    L46:
        if (r28 != 93819220) goto L54;
        if (r21.equals("blank") == false) goto L54;
        r29 = "name";
        goto L53
    L22:
        r9 = null;
        goto L24
    L5:
        if (r8 != null) goto L9;
        if (r7 != null) goto L9;
        r17 = null;
    L9:
        r1 = 2;
        goto L10
    }

    public final void q(final Context r14, final com.bytedance.android.ec.common.api.jump.model.g r15, final com.bytedance.android.btm.api.model.d r16, final ListItemButtonModule$addCartListener$1 r17, final View r18, final StepperActionType r19, final int r20) {
        Intrinsics.checkNotNullParameter(r15, "promotionParams");
        Intrinsics.checkNotNullParameter(r19, "stepperAction");
        if (r14 != null) goto L5;
        return;
    L5:
        int r0 = g.d[r19.ordinal()];
        if (r0 != 1) goto L8;
        String r1 = "list_card_addcart";
    L13:
        String r4 = r1;
        B(this, r14, r15, r4, null, new PromotionJumpDispatcher$clickStepperCart$1(this, r15, r19, r14, r20, r16, r18, r17));
        return;
    L8:
        if (r0 != 2) goto L11;
        r1 = "list_card_subcart";
        goto L13
    L11:
        throw new NoWhenBranchMatchedException();
    }

    public final void r(final Context r17, com.bytedance.android.ec.common.api.jump.model.g r18, String r19, boolean r20, com.bytedance.android.btm.api.model.d r21, il2.a r22, int r23) {
        Intrinsics.checkNotNullParameter(r18, "promotionParams");
        if (r22 == null) goto L6;
        il2.a.C0145a.a(r22, "open_product_detail", null, false, null, null, null, 62);
    L6:
        if (r17 != null) goto L12;
        if (r22 == null) goto L48;
        il2.a r1 = il2.a.C0145a.a(r22, "open_product_detail", null, false, "context_is_null", null, null, 48);
        if (r1 == null) goto L49;
        ((LiveActionTracker) r1).e(false);
        return;
    L49:
        return;
    L48:
        return;
    L12:
        jf.c r2 = this.g;
        if (r2 != null) goto L15;
    L21:
        PromotionDetailSchemaHelper r3 = PromotionDetailSchemaHelper.a;
        String r6 = null;
        if (r22 == null) goto L26;
        il2.b r8 = r22.b();
        if (r8 == null) goto L26;
        Long r13 = r8.a;
    L27:
        r3.getClass();
        String r4 = PromotionDetailSchemaHelper.a(r18, r19, r20, r21, r23, r13);
        UrlBuilderV2 r9 = new UrlBuilderV2(r4);
        if (Intrinsics.areEqual((String) r9.getMMap().get("fullscreen"), "1") == false) goto L30;
    L31:
        gi2.a r10 = (gi2.a) r18.getParamsModel(Reflection.getOrCreateKotlinClass(gi2.a.class));
        int r11 = ECSdk.a;
        ECSdk.b(IAdapterService.class, new PromotionJumpDispatcher$openPromotionDetail$2(r17));
    L32:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new PromotionJumpDispatcher$reportAdParams$1(r4, null), 2, null);
        cl.d r12 = com.bytedance.android.ec.sdk.helper.k.a();
        if (r12 == null) goto L35;
        r12.h(MapsKt.mapOf(TuplesKt.to("detailSchema", r4)));
    L35:
        LiveRoomParams r14 = r18.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        if (r21 == null) goto L42;
        BcmParams r15 = r21.c;
        if (r15 == null) goto L42;
        if (r14 == null) goto L41;
        r6 = r14.getAuthorId();
    L41:
        r15.put("author_id", r6);
    L42:
        if (r22 == null) goto L44;
        il2.a.C0145a.a(r22, "open_product_detail", MapsKt.mapOf(new Pair[]{TuplesKt.to("click_area", r19), TuplesKt.to("force_fullscreen", String.valueOf(r20))}), false, null, null, null, 60);
    L44:
        n(r17, r4, r21, r18, r19, r22);
        jf.c r0 = this.g;
        if (r0 == null) goto L52;
        r0.a();
        return;
    L52:
        return;
    L30:
        if (Intrinsics.areEqual((String) r9.getMMap().get("fullscreen"), "true") == false) goto L32;
    L26:
        r13 = null;
        goto L27
    L15:
        if (r2.c(r17, r21, false) != true) goto L21;
        if (r22 == null) goto L50;
        il2.a r5 = il2.a.C0145a.a(r22, "open_product_detail_intercepted", null, false, null, null, null, 62);
        if (r5 == null) goto L51;
        ((LiveActionTracker) r5).e(false);
        return;
    L51:
        return;
    }

    public static final void s(PromotionJumpDispatcher r31, Context r32, com.bytedance.android.ec.common.api.jump.model.g r33, cf.a r34, com.bytedance.android.btm.api.model.d r35, il2.a r36, String r37, String r38) {
        r31.getClass();
        if (r36 == null) goto L5;
        il2.a.C0145a.a(r36, "add_cart_directly", null, false, null, null, null, 62);
    L5:
        ql.a r1 = r33.a;
        LiveRoomParams r2 = r33.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        com.bytedance.android.ec.common.api.jump.model.f r3 = r33.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        String r4 = null;
        if (r3 == null) goto L8;
        String r26 = r3.b;
    L9:
        JSONObject r5 = r33.getAddToCartEntranceInfo();
        r5.put("product_id", r1.getProductId());
        String r23 = r5.toString();
        int r6 = com.bytedance.android.livesdk.livecommerce.eventcenter.ability.c.b;
        String r7 = r1.getOriginType();
        if (r7 != null) goto L12;
        String r12 = "";
    L13:
        String r8 = r1.getOriginId();
        if (r8 != null) goto L16;
        String r13 = "";
    L17:
        String r14 = r1.getPromotionId();
        String r15 = r1.getProductId();
        if (r2 == null) goto L20;
        String r9 = r2.getAuthorId();
    L21:
        if (r9 != null) goto L23;
        String r16 = "";
    L24:
        if (r2 == null) goto L26;
        String r17 = r2.getSecAuthorId();
    L27:
        if (r2 == null) goto L29;
        r4 = r2.getRoomId();
    L29:
        if (r4 != null) goto L31;
        String r18 = "";
    L32:
        String r19 = r1.getShopId();
        if (r38 != null) goto L35;
        String r20 = r1.getTrackExtra();
    L36:
        boolean r21 = Intrinsics.areEqual(r1.getIsGroupBuying(), "1");
        boolean r22 = !ECDisplayUtils.c(r32);
        if (r2 == null) goto L43;
        Function0 r10 = r2.isHourArrivedRoom();
        if (r10 == null) goto L43;
        if (((Boolean) r10.invoke()).booleanValue() != true) goto L43;
        boolean r25 = true;
    L44:
        com.bytedance.android.livesdk.livecommerce.eventcenter.ability.c.a.a(r32, 0, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r37, r25, r26, BtmUtilsKt.a(r35, r33.getChainParams()), r1.getChannelId(), r1.getChannelType(), new h(r3, r34, r36));
        return;
    L43:
        r25 = false;
        goto L44
    L35:
        r20 = r38;
        goto L36
    L31:
        r18 = r4;
        goto L32
    L26:
        r17 = null;
        goto L27
    L23:
        r16 = r9;
        goto L24
    L20:
        r9 = null;
        goto L21
    L16:
        r13 = r8;
        goto L17
    L12:
        r12 = r7;
        goto L13
    L8:
        r26 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.Object, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r1v10, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r27v0 */
    /* JADX WARN: Type inference failed for: r27v1 */
    /* JADX WARN: Type inference failed for: r27v12 */
    /* JADX WARN: Type inference failed for: r27v13 */
    /* JADX WARN: Type inference failed for: r27v2 */
    /* JADX WARN: Type inference failed for: r27v3 */
    /* JADX WARN: Type inference failed for: r27v4 */
    /* JADX WARN: Type inference failed for: r27v6 */
    /* JADX WARN: Type inference failed for: r27v7 */
    /* JADX WARN: Type inference failed for: r27v8 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    public static final void v(PromotionJumpDispatcher r32, Context r33, com.bytedance.android.ec.common.api.jump.model.g r34, ECEditCartParams r35, StepperActionType r36, int r37, com.bytedance.android.btm.api.model.d r38, cf.a r39) {
        com.bytedance.android.btm.api.model.d r0 = r38;
        r32.getClass();
        if (r35.getEditReqParam() != null) goto L10;
        int r1 = g.h[r36.ordinal()];
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L200;
        UIUtils.displayToast(r33, th.a.g(r33, 2131896881));
        return;
    L200:
        return;
    L9:
        UIUtils.displayToast(r33, th.a.g(r33, 2131896302));
        return;
    L10:
        String r7 = r35.getEditReqParam();
        ql.a r11 = r34.a;
        LiveRoomParams r12 = r34.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        String r14 = r35.getPath();
        String r13 = r35.getSingleSkuId();
        ArrayList r8 = new ArrayList();
        if (r12 == null) goto L13;
        String r15 = r12.getRoomUniqueKey();
    L14:
        r8.add(new si2.k("room_unique_key", r15));
        JSONObject r9 = r34.getAddToCartEntranceInfo();
        r9.put("product_id", r11.getProductId());
        String r10 = r9.toString();
        String r16 = EcomBcmTracker.g(BtmUtilsKt.a(r0, r34.getChainParams()));
        com.bytedance.android.ec.common.api.jump.model.f r17 = r34.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        if (r0 == null) goto L17;
        String r18 = r0.a;
    L19:
        if (r18 == null) goto L24;
        String r20 = r10;
        String r21 = "ecom_scene_id";
        String r22 = "promotion_id";
        String r2 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder(r18, Boolean.FALSE).build());
        if (r2 == null) goto L25;
        String r23 = r2;
    L26:
        if (r17 == null) goto L28;
        String r19 = r17.b;
    L29:
        BtmSDK r3 = BtmSDK.INSTANCE;
        if (r0 == null) goto L33;
        PageFinder r4 = r0.b;
        if (r4 == null) goto L33;
    L34:
        com.bytedance.android.btm.api.model.e r5 = r3.getBtmPageInfo(r4);
        if (r5 == null) goto L40;
        String r6 = r5.a;
        if (r6 == null) goto L40;
        String r24 = r6;
    L41:
        LinkedHashMap r25 = new LinkedHashMap();
        String r26 = r18;
        r8.add(new si2.k("bcm_chain", r16));
        ?? r27 = new JSONObject(r7);     // Catch: JSONException -> L155
        r27.optString("cart_id", "");     // Catch: JSONException -> L155
        JSONObject r28 = r27.optJSONObject("cart_add_item");     // Catch: JSONException -> L155
        if (r28 == null) goto L135;
        r28.put("bcm_chain", r16);     // Catch: JSONException -> L155
        JSONObject r110 = r28.optJSONObject("extra");     // Catch: JSONException -> L155
        if (r110 != null) goto L47;
        r110 = new JSONObject();     // Catch: JSONException -> L155
    L47:
        ArrayList r29 = r8;
        String r30 = r27.optString("cart_track");     // Catch: JSONException -> L153
        boolean r210 = false;
        if (r30.length() <= 0) goto L53;
        r27 = 1;
    L175:
        if (r27 != 0) goto L56;
        JSONObject r31 = new JSONObject();     // Catch: Exception -> L173
    L174:
    L61:
        if (r12 == null) goto L70;
        String r40 = r12.getRoomId();     // Catch: JSONException -> L153
        if (r40 == null) goto L70;
        if ((!StringsKt.isBlank(r40)) == true) goto L68;
        r40 = null;
    L68:
        if (r40 == null) goto L70;
        r110.put("room_id", r40);     // Catch: JSONException -> L153
        r31.put("room_id", r40);     // Catch: JSONException -> L153
    L70:
        if (r12 == null) goto L79;
        String r41 = r12.getAuthorId();     // Catch: JSONException -> L153
        if (r41 == null) goto L79;
        if ((!StringsKt.isBlank(r41)) == true) goto L77;
        r41 = null;
    L77:
        if (r41 == null) goto L79;
        r110.put("author_id", r41);     // Catch: JSONException -> L153
        r31.put("author_id", r41);     // Catch: JSONException -> L153
    L79:
        String r42 = r11.getShopId();     // Catch: JSONException -> L153
        if (r42 != null) goto L82;
    L87:
        String r43 = r11.getPromotionId();     // Catch: JSONException -> L153
        if (r43 != null) goto L90;
    L95:
        String r44 = r21;
        String r45 = r110.optString(r44);     // Catch: JSONException -> L153
        if ((!StringsKt.isBlank(r45)) == true) goto L99;
        r45 = null;
    L99:
        if (r45 == null) goto L101;
        r31.put(r44, r45);     // Catch: JSONException -> L153
    L101:
        if (r20 == null) goto L109;
        JSONObject r46 = z1.g(r20);     // Catch: JSONException -> L153
        if (r46 == null) goto L109;
        Iterator<String> r47 = r46.keys();     // Catch: JSONException -> L153
    L106:
        if (r47.hasNext() == false) goto L108;
        String r48 = r47.next();     // Catch: JSONException -> L153
        r31.put(r48, r46.optString(r48));     // Catch: JSONException -> L153
        goto L106
    L108:
        Unit r49 = Unit.INSTANCE;     // Catch: JSONException -> L153
    L109:
        if (r0 != null) goto L111;
        r0 = new com.bytedance.android.btm.api.model.d();     // Catch: JSONException -> L153
        r0.b = PageFinder.via(r19);     // Catch: JSONException -> L153
    L111:
        String r50 = EcomBcmTracker.d(r0, r31.toString());     // Catch: JSONException -> L153
        if (r50 != null) goto L114;
        r50 = r31.toString();     // Catch: JSONException -> L153
    L114:
        String r51 = r50;
        r110.put("cart_track", r51);     // Catch: JSONException -> L153
        r110.put("btm_show_id", r24);     // Catch: JSONException -> L153
        String r52 = r35.getTrackExtra();     // Catch: JSONException -> L153
        if (r52 != null) goto L117;
        r52 = r11.getTrackExtra();     // Catch: JSONException -> L153
    L117:
        if (r52 != null) goto L119;
    L134:
        r28.put("extra", r110);     // Catch: JSONException -> L153
        r25.put("entrance_info", r51);     // Catch: JSONException -> L153
        Unit r53 = Unit.INSTANCE;     // Catch: JSONException -> L153
        ?? r211 = r27;
    L136:
        ?? r54 = r211;
        r54.put("bcm_chain", r16);     // Catch: JSONException -> L153
        Unit r55 = Unit.INSTANCE;     // Catch: JSONException -> L153
        Iterator<String> r56 = r54.keys();     // Catch: JSONException -> L150
        if (r56 != null) goto L140;
        r8 = r29;
    L149:
        ?? r57 = r54;
    L158:
        int r58 = g.i[r36.ordinal()];
        if (r58 != 1) goto L161;
        String r59 = "add";
    L166:
        String r111 = r59;
        CompositeDisposable r60 = CoreRequests.a;
        ?? r61 = r57;
        if (r57 != 0) goto L169;
        r61 = new JSONObject();
    L169:
        ?? r62 = r61;
        ArrayList r112 = r8;
        m r113 = new m(r32, r36, r11, r13, r37, r39, r24, r20, r34, r26, r23, r19, r111, r33);
        bk2.d r63 = r32.f;
        Intrinsics.checkNotNullParameter(r112, "paramList");
        Intrinsics.checkNotNullParameter(r62, "editRequestBody");
        Intrinsics.checkNotNullParameter(r113, "apiObserver");
        Disposable r64 = vi2.h.e(null, null, r14, new vi2.x(r14, r112, r62)).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.livecommerce.room.controller.h(r113), new com.bytedance.android.livesdk.livecommerce.room.controller.i(r113));
        if (r63 == null) goto L199;
        r63.add(r64);
        return;
    L199:
        return;
    L161:
        if (r58 != 2) goto L164;
        r59 = "sub";
        goto L166
    L164:
        throw new NoWhenBranchMatchedException();
    L140:
        if (r56.hasNext() == false) goto L144;
        String r65 = r56.next();     // Catch: JSONException -> L150
        r8 = r29;
        r8.add(new si2.k(r65, r54.optString(r65)));     // Catch: JSONException -> L146
        r29 = r8;
    L146:
        e = e;
    L152:
        ?? r66 = r54;
    L157:
        ECExceptionMonitor.e(e);
        r57 = r66;
        goto L158
    L144:
        r8 = r29;
        Unit r67 = Unit.INSTANCE;     // Catch: JSONException -> L146
    L150:
        e = e;
        r8 = r29;
        goto L152
    L119:
        if (r52.length() <= 0) goto L121;
        r210 = true;
    L121:
        if (r210 == false) goto L134;
        JSONObject r68 = new JSONObject(r52);     // Catch: Exception -> L132
        Iterator<String> r69 = r68.keys();     // Catch: Exception -> L132
    L124:
        if (r69.hasNext() == false) goto L130;
        String r70 = r69.next();     // Catch: Exception -> L132
        r110.put(r70, r68.opt(r70));     // Catch: Exception -> L128
    L128:
        e = move-exception;
        ECExceptionMonitor.e(e);     // Catch: Exception -> L132
        goto L124
    L130:
        Unit r71 = Unit.INSTANCE;     // Catch: Exception -> L132
    L132:
        e = move-exception;
        ECExceptionMonitor.e(e);     // Catch: JSONException -> L153
        goto L134
    L90:
        if ((!StringsKt.isBlank(r43)) == true) goto L93;
        r43 = null;
    L93:
        if (r43 == null) goto L95;
        String r72 = r22;
        r110.put(r72, r43);     // Catch: JSONException -> L153
        r31.put(r72, r43);     // Catch: JSONException -> L153
        goto L95
    L82:
        if ((!StringsKt.isBlank(r42)) == true) goto L85;
        r42 = null;
    L85:
        if (r42 == null) goto L87;
        r110.put("shop_user_id", r42);     // Catch: JSONException -> L153
        goto L87
    L56:
        r31 = new JSONObject(r30);     // Catch: Exception -> L173
    L60:
        r31 = new JSONObject();     // Catch: JSONException -> L153
        goto L61
    L53:
        r27 = 0;
    L59:
        r27 = r27;
    L153:
        e = e;
        r8 = r29;
    L156:
        r66 = 0;
        goto L157
    L135:
        r211 = r27;
        r29 = r8;
    L155:
        e = e;
    L40:
        r24 = "";
    L33:
        r4 = PageFinder.via(r19);
        goto L34
    L28:
        r19 = null;
    L25:
        r23 = "";
        goto L26
    L24:
        r22 = "promotion_id";
        r21 = "ecom_scene_id";
        r20 = r10;
        goto L25
    L17:
        r18 = null;
        goto L19
    L13:
        r15 = null;
        goto L14
    }

    public final void h(final Context r14, final String r15, final com.bytedance.android.ec.common.api.jump.model.g r16, final com.bytedance.android.btm.api.model.d r17, final il2.a r18, final View r19, final Function0<Unit> r20, final Pair<Integer, Integer> r21) {
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r15, "clickArea");
        Intrinsics.checkNotNullParameter(r16, "promotionParams");
        int r0 = ECLiveLoginHelper.a;
        ECLiveLoginHelper.b(r14, r16, r18, new PromotionJumpDispatcher$clickBuyOrItem$1(this, r14, r15, r16, r17, r18, r19, r20, r21));
    }

    public static final boolean y(PromotionJumpDispatcher r33, final Context r34, ECPromotionCheckResponse r35, ECUIPromotion r36, com.bytedance.android.ec.common.api.jump.model.g r37, com.bytedance.android.btm.api.model.d r38, final il2.a r39, final View r40, final Pair r41) {
        r33.getClass();
        if (r35 == null) goto L309;
        if (r34 == null) goto L309;
        sl.g r0 = r35.getAction();
        if (r0 == null) goto L12;
        if (r0.a() == 5) goto L309;
    L12:
        if (r0 != null) goto L14;
    L15:
        String r16 = null;
        if (r0 == null) goto L20;
        sl.a r3 = r0.b();
        if (r3 == null) goto L20;
        String r4 = r3.a();
    L22:
        if (Intrinsics.areEqual(r4, "PRODUCT_DETAIL") == true) goto L309;
        if (r0 == null) goto L309;
        if (r35.getJumpDestination() != null) goto L309;
        com.bytedance.android.livesdk.livecommerce.ability.f<?> r5 = com.bytedance.android.livesdk.livecommerce.eventcenter.a.a(r0);
        if (r5 == null) goto L303;
        if (r39 == null) goto L31;
        il2.a.C0145a.a(r39, "processed_by_check_action", MapsKt.mapOf(TuplesKt.to("action", r5.a)), false, null, null, null, 60);
    L31:
        LiveRoomParams r17 = r37.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        com.bytedance.android.ec.common.api.jump.model.f r1 = r37.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        String r7 = r5.a;
        switch(r7.hashCode()) {
            case -1236338690: goto L261;
            case -826929628: goto L235;
            case 804212474: goto L135;
            case 1045365711: goto L35;
            default: goto L260;
        };
    L261:
        boolean r13 = false;
        if (r7.equals("add_cart") == false) goto L300;
        final jf.e r2 = F(r1, r36);
        Object r6 = r5.b;
        if ((r6 instanceof sl.b) == true) goto L266;
        r6 = null;
    L266:
        sl.b r8 = (sl.b) r6;
        if (r8 == null) goto L296;
        r8.g(r36);
        Pair[] r9 = new Pair[9];
        if (r17 == null) goto L271;
        String r10 = r17.getAuthorId();
    L272:
        r9[0] = TuplesKt.to("anchor_id", r10);
        if (r17 == null) goto L275;
        String r11 = r17.getSecAuthorId();
    L276:
        r9[1] = TuplesKt.to("anchor_sec_id", r11);
        if (r17 == null) goto L279;
        String r12 = r17.getRoomId();
    L280:
        r9[2] = TuplesKt.to("room_id", r12);
        JSONObject r14 = r37.getAddToCartEntranceInfo();
        String r15 = r36.getProductId();
        if (r15 != null) goto L283;
        r15 = "";
    L283:
        r14.put("product_id", r15);
        Unit r18 = Unit.INSTANCE;
        r9[3] = TuplesKt.to("entrance_info", r14.toString());
        PromotionListController.T.getClass();
        r9[4] = TuplesKt.to("is_hour_arrived_room", String.valueOf(PromotionListController.a.a().J()));
        com.bytedance.android.ec.common.api.jump.model.f r19 = r37.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        if (r19 == null) goto L286;
        String r20 = r19.b;
    L287:
        r9[5] = TuplesKt.to("btm_page_id", r20);
        com.bytedance.android.ec.model.response.n r21 = r35.getAddCartParams();
        if (r21 == null) goto L291;
        String r22 = r21.a();
        if (r22 == null) goto L291;
    L292:
        r9[6] = TuplesKt.to("single_sku_id", r22);
        com.bytedance.android.ec.model.response.n r23 = r35.getAddCartParams();
        if (r23 == null) goto L295;
        r16 = r23.b();
    L295:
        r9[7] = TuplesKt.to("track_extra", r16);
        r9[8] = TuplesKt.to("source_page", String.valueOf(r2.a));
        r8.f(MapsKt.mapOf(r9));
        r8.a = r38;
        com.bytedance.android.livesdk.livecommerce.ability.f r24 = new com.bytedance.android.livesdk.livecommerce.ability.f("LiveList", r5.a, r8);
        Lazy r25 = LiveDynamicContext.c;
        LiveDynamicContext.a.a().a().d(r34, r24, r37, r39, new PromotionJumpDispatcher$processCheckRespInCheckAndBuy$$inlined$let$lambda$1(r2, r39, r34, r40, r41));
        String r26 = Unit.INSTANCE;
    L259:
        r16 = r26;
    L301:
        if (r16 == null) goto L304;
    L308:
        return true;
    L304:
        if (r39 == null) goto L308;
        il2.a r27 = il2.a.C0145a.a(r39, "processed_by_check_action", null, false, "unsupported_action_type", null, null, 48);
        if (r27 == null) goto L308;
        ((LiveActionTracker) r27).e(r13);
        Unit r28 = Unit.INSTANCE;
    L291:
        r22 = "";
        goto L292
    L286:
        r20 = null;
        goto L287
    L279:
        r12 = null;
        goto L280
    L275:
        r11 = null;
        goto L276
    L271:
        r10 = null;
        goto L272
    L296:
        if (r39 == null) goto L301;
        il2.a r29 = il2.a.C0145a.a(r39, "add_cart_atomic", null, false, "data_format_wrong", null, null, 48);
        if (r29 == null) goto L301;
        ((LiveActionTracker) r29).e(false);
        r16 = Unit.INSTANCE;
    L300:
        Lazy r30 = LiveDynamicContext.c;
        com.bytedance.android.livesdk.livecommerce.ability.b.a.a(LiveDynamicContext.a.a().a(), r34, r5, r37, r39, null, 16);
        r16 = Unit.INSTANCE;
    L260:
        r13 = false;
        goto L300
    L35:
        if (r7.equals("add_cart_jump") == false) goto L260;
        Object r31 = r5.b;
        if ((r31 instanceof sl.c) == true) goto L39;
        r31 = null;
    L39:
        sl.c r32 = (sl.c) r31;
        JSONObject r42 = r37.getAddToCartEntranceInfo();
        String r43 = r36.getProductId();
        if (r43 != null) goto L42;
        r43 = "";
    L42:
        r42.put("product_id", r43);
        String r210 = r42.toString();
        String r44 = r36.getTrackExtra();
        if (r44 != null) goto L45;
    L48:
        boolean r45 = true;
    L49:
        if (r45 == false) goto L311;
        com.bytedance.android.ec.model.response.n r46 = r35.getAddCartParams();
        if (r46 == null) goto L53;
        String r47 = r46.b();
    L54:
        if (r47 != null) goto L56;
        r47 = "";
    L56:
        String r110 = r47;
    L94:
        if (r39 == null) goto L97;
        il2.a.C0145a.a(r39, "add_cart_directly", MapsKt.mapOf(new Pair[]{TuplesKt.to("promotion_id", r36.getPromotionId()), TuplesKt.to("product_id", r36.getProductId())}), false, null, null, null, 60);
    L97:
        int r48 = com.bytedance.android.livesdk.livecommerce.eventcenter.ability.c.b;
        String r49 = r36.getOriginType();
        if (r49 != null) goto L100;
        String r111 = "";
    L101:
        String r50 = r36.getOriginId();
        if (r50 != null) goto L104;
        String r112 = "";
    L105:
        String r113 = r36.getPromotionId();
        String r114 = r36.getProductId();
        if (r17 == null) goto L108;
        String r51 = r17.getAuthorId();
    L109:
        if (r51 != null) goto L111;
        r51 = "";
    L111:
        if (r17 == null) goto L113;
        String r211 = r17.getSecAuthorId();
    L114:
        if (r17 == null) goto L116;
        r16 = r17.getRoomId();
    L116:
        if (r16 != null) goto L118;
        String r115 = "";
    L119:
        String r212 = r36.getShopId();
        boolean r213 = Intrinsics.areEqual(r36.getIsGroupBuying(), "1");
        boolean r214 = !ECDisplayUtils.c(r34);
        PromotionListController.T.getClass();
        boolean r215 = Intrinsics.areEqual(String.valueOf(PromotionListController.a.a().J()), "true");
        com.bytedance.android.ec.model.response.n r52 = r35.getAddCartParams();
        if (r52 == null) goto L125;
        String r53 = r52.a();
        if (r53 == null) goto L125;
        String r310 = r53;
    L126:
        com.bytedance.android.ec.common.api.jump.model.f r54 = r37.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        if (r54 == null) goto L132;
        String r55 = r54.b;
        if (r55 == null) goto L132;
        String r311 = r55;
    L133:
        com.bytedance.android.livesdk.livecommerce.eventcenter.ability.c.a.a(r34, -1, r111, r112, r113, r114, r51, r211, r115, r212, r110, r213, r214, r210, r310, r215, r311, r38, r36.getChannelId(), r36.getChannelType(), new u(r32, r33, r39, r37, r38, r34, r40));
        r16 = Unit.INSTANCE;
    L233:
        r13 = false;
    L132:
        r311 = "";
    L125:
        r310 = "";
        goto L126
    L118:
        r115 = r16;
        goto L119
    L113:
        r211 = null;
        goto L114
    L108:
        r51 = null;
        goto L109
    L104:
        r112 = r50;
        goto L105
    L100:
        r111 = r49;
        goto L101
    L53:
        r47 = null;
        goto L54
    L311:
        com.bytedance.android.ec.model.response.n r56 = r35.getAddCartParams();     // Catch: Exception -> L91
        if (r56 == null) goto L93;
        String r57 = r56.b();     // Catch: Exception -> L91
        if (r57 == null) goto L93;
        JSONObject r58 = z1.g(r57);     // Catch: Exception -> L91
        if (r58 == null) goto L93;
        JSONObject r59 = z1.g(r44);     // Catch: Exception -> L91
        if (r59 == null) goto L68;
        String r60 = JSONObjectProtectorUtils.getString(r59, "cart_track");     // Catch: Exception -> L91
        if (r60 == null) goto L68;
        JSONObject r61 = z1.g(r60);     // Catch: Exception -> L91
    L69:
        if (r61 == null) goto L71;
        z1.b(r61, r58);     // Catch: Exception -> L91
        Unit r62 = Unit.INSTANCE;     // Catch: Exception -> L91
    L71:
        if (r59 == null) goto L76;
        if (r61 == null) goto L74;
        String r63 = r61.toString();     // Catch: Exception -> L91
    L75:
        r59.put("cart_track", r63);     // Catch: Exception -> L91
        goto L76
    L74:
        r63 = null;
    L76:
        Iterator<String> r64 = r58.keys();     // Catch: Exception -> L91
    L78:
        if (r64.hasNext() == false) goto L83;
        String r65 = r64.next();     // Catch: Exception -> L91
        Object r116 = r58.opt(r65);     // Catch: Exception -> L91
        if (r116 == null) goto L78;
        if (r59 == null) goto L78;
        r59.put(r65, r116);     // Catch: Exception -> L91
        goto L78
    L83:
        if (r59 == null) goto L85;
        String r66 = r59.toString();     // Catch: Exception -> L91
    L86:
        if (r66 != null) goto L88;
        r44 = "";
    L89:
        Unit r67 = Unit.INSTANCE;     // Catch: Exception -> L91
        goto L93
    L88:
        r44 = r66;
        goto L89
    L85:
        r66 = null;
    L68:
        r61 = null;
    L93:
        r110 = r44;
    L91:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L93
    L45:
        if (r44.length() == 0) goto L48;
        r45 = false;
        goto L49
    L135:
        if (r7.equals("add_cart_open_page_list") == false) goto L260;
        Object r68 = r5.b;
        if ((r68 instanceof sl.d) == true) goto L139;
        r68 = null;
    L139:
        sl.d r69 = (sl.d) r68;
        JSONObject r70 = r37.getAddToCartEntranceInfo();
        String r71 = r36.getProductId();
        if (r71 != null) goto L142;
        r71 = "";
    L142:
        r70.put("product_id", r71);
        String r216 = r70.toString();
        String r72 = r36.getTrackExtra();
        if (r72 != null) goto L145;
    L148:
        boolean r73 = true;
    L149:
        if (r73 == false) goto L313;
        com.bytedance.android.ec.model.response.n r74 = r35.getAddCartParams();
        if (r74 == null) goto L153;
        String r75 = r74.b();
    L154:
        if (r75 != null) goto L156;
        r75 = "";
    L156:
        String r117 = r75;
    L194:
        if (r39 == null) goto L196;
        il2.a.C0145a.a(r39, "add_cart_directly", MapsKt.mapOf(new Pair[]{TuplesKt.to("promotion_id", r36.getPromotionId()), TuplesKt.to("product_id", r36.getProductId())}), false, null, null, null, 60);
    L196:
        int r76 = com.bytedance.android.livesdk.livecommerce.eventcenter.ability.c.b;
        String r77 = r36.getOriginType();
        if (r77 != null) goto L199;
        String r118 = "";
    L200:
        String r78 = r36.getOriginId();
        if (r78 != null) goto L203;
        String r119 = "";
    L204:
        String r120 = r36.getPromotionId();
        String r121 = r36.getProductId();
        if (r17 == null) goto L207;
        String r79 = r17.getAuthorId();
    L208:
        if (r79 != null) goto L210;
        r79 = "";
    L210:
        if (r17 == null) goto L212;
        String r217 = r17.getSecAuthorId();
    L213:
        if (r17 == null) goto L215;
        r16 = r17.getRoomId();
    L215:
        if (r16 != null) goto L217;
        String r218 = "";
    L218:
        String r219 = r36.getShopId();
        boolean r220 = Intrinsics.areEqual(r36.getIsGroupBuying(), "1");
        boolean r221 = !ECDisplayUtils.c(r34);
        PromotionListController.T.getClass();
        boolean r222 = Intrinsics.areEqual(String.valueOf(PromotionListController.a.a().J()), "true");
        com.bytedance.android.ec.model.response.n r80 = r35.getAddCartParams();
        if (r80 == null) goto L224;
        String r81 = r80.a();
        if (r81 == null) goto L224;
        String r312 = r81;
    L225:
        com.bytedance.android.ec.common.api.jump.model.f r82 = r37.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        if (r82 == null) goto L231;
        String r83 = r82.b;
        if (r83 == null) goto L231;
        String r313 = r83;
    L232:
        com.bytedance.android.livesdk.livecommerce.eventcenter.ability.c.a.a(r34, -1, r118, r119, r120, r121, r79, r217, r218, r219, r117, r220, r221, r216, r312, r222, r313, r38, r36.getChannelId(), r36.getChannelType(), new t(r17, r69, r39, r36, r38, r34, r40));
        r16 = Unit.INSTANCE;
    L231:
        r313 = "";
    L224:
        r312 = "";
        goto L225
    L217:
        r218 = r16;
        goto L218
    L212:
        r217 = null;
        goto L213
    L207:
        r79 = null;
        goto L208
    L203:
        r119 = r78;
        goto L204
    L199:
        r118 = r77;
        goto L200
    L153:
        r75 = null;
        goto L154
    L313:
        com.bytedance.android.ec.model.response.n r85 = r35.getAddCartParams();     // Catch: Exception -> L191
        if (r85 == null) goto L193;
        String r86 = r85.b();     // Catch: Exception -> L191
        if (r86 == null) goto L193;
        JSONObject r87 = z1.g(r86);     // Catch: Exception -> L191
        if (r87 == null) goto L193;
        JSONObject r88 = z1.g(r72);     // Catch: Exception -> L191
        if (r88 == null) goto L168;
        String r122 = JSONObjectProtectorUtils.getString(r88, "cart_track");     // Catch: Exception -> L191
        if (r122 == null) goto L168;
        JSONObject r123 = z1.g(r122);     // Catch: Exception -> L191
    L169:
        if (r123 == null) goto L171;
        z1.b(r123, r87);     // Catch: Exception -> L191
        Unit r124 = Unit.INSTANCE;     // Catch: Exception -> L191
    L171:
        if (r88 == null) goto L176;
        if (r123 == null) goto L174;
        String r125 = r123.toString();     // Catch: Exception -> L191
    L175:
        r88.put("cart_track", r125);     // Catch: Exception -> L191
        goto L176
    L174:
        r125 = null;
    L176:
        Iterator<String> r126 = r87.keys();     // Catch: Exception -> L191
    L178:
        if (r126.hasNext() == false) goto L183;
        String r127 = r126.next();     // Catch: Exception -> L191
        Object r128 = r87.opt(r127);     // Catch: Exception -> L191
        if (r128 == null) goto L178;
        if (r88 == null) goto L178;
        r88.put(r127, r128);     // Catch: Exception -> L191
        goto L178
    L183:
        if (r88 == null) goto L185;
        String r89 = r88.toString();     // Catch: Exception -> L191
    L186:
        if (r89 != null) goto L188;
        r72 = "";
    L189:
        Unit r90 = Unit.INSTANCE;     // Catch: Exception -> L191
        goto L193
    L188:
        r72 = r89;
        goto L189
    L185:
        r89 = null;
    L168:
        r123 = null;
    L193:
        r117 = r72;
    L191:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L193
    L145:
        if (r72.length() == 0) goto L148;
        r73 = false;
        goto L149
    L235:
        if (r7.equals("open_page_list_show_dialog") == false) goto L260;
        Object r91 = r5.b;
        if ((r91 instanceof sl.f) == true) goto L239;
        r91 = null;
    L239:
        sl.f r92 = (sl.f) r91;
        if (r38 == null) goto L242;
        PromotionListController.c r93 = new PromotionListController.c(null, false, null, null, BtmSDK.INSTANCE.createJumpSourceBtmToken(r38), null, null, null, 239);
        Unit r94 = Unit.INSTANCE;
        PromotionListController.c r95 = r93;
    L243:
        PromotionListController.a r96 = PromotionListController.T;
        if (r17 == null) goto L246;
        String r97 = r17.getRoomId();
    L247:
        if (r17 == null) goto L249;
        String r98 = r17.getRoomUniqueKey();
    L250:
        r96.getClass();
        PromotionListController r99 = PromotionListController.a.c(r97, r98);
        v r100 = new v();
        if (r92 == null) goto L253;
        sl.k r101 = r92.a();
    L254:
        PromotionListController.N(r99, r34, "live_pop_card_buy_to_add", r100, r95, false, new wj2.g.b(r101), null, null, 192);
        if (r39 == null) goto L233;
        r13 = false;
        il2.a r102 = il2.a.C0145a.a(r39, "open_promotion_list_and_show_dialog", null, false, null, null, null, 62);
        if (r102 == null) goto L301;
        ((LiveActionTracker) r102).e(false);
        r26 = Unit.INSTANCE;
        goto L259
    L253:
        r101 = null;
        goto L254
    L249:
        r98 = null;
        goto L250
    L246:
        r97 = null;
        goto L247
    L242:
        r95 = null;
        goto L243
    L303:
        r13 = false;
    L20:
        r4 = null;
        goto L22
    L14:
        if (r0.a() != 6) goto L15;
    L309:
        return false;
    }

    public final void G(Context r20, String r21, int r22, com.bytedance.android.ec.common.api.jump.model.g r23, sl.r r24, com.bytedance.android.btm.api.model.d r25, il2.a r26, View r27, Pair r28) {
        if (r26 != null) goto L5;
    L9:
        if (r24 == null) goto L11;
        Integer r4 = Integer.valueOf(r24.getType());
    L12:
        int r7 = 2;
        if (r4 != null) goto L16;
    L18:
        if (r4 == null) goto L224;
        if (r4.intValue() != 2) goto L224;
    L22:
        jf.c r5 = this.g;
        if (r5 == null) goto L26;
        r5.d(r20, r25);
    L26:
        if (r24.getType() == 2) goto L29;
        r7 = 1;
    L29:
        LiveRoomParams r6 = r23.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        com.bytedance.android.ec.common.api.jump.model.f r8 = r23.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        if (r8 == null) goto L54;
        jf.e r9 = r8.d;
        if (r9 == null) goto L54;
        if (Intrinsics.areEqual(r9, jf.e.f.b) == true) goto L37;
        r9 = null;
    L37:
        if (r9 == null) goto L54;
        if (r27 == null) goto L54;
        float[] r10 = wj2.d.a(r27);
        float r11 = r10[0];
        float r12 = r10[1];
        PromotionListController.a r13 = PromotionListController.T;
        if (r6 == null) goto L42;
        String r14 = r6.getRoomId();
    L43:
        if (r6 == null) goto L45;
        String r15 = r6.getRoomUniqueKey();
    L46:
        r13.getClass();
        PromotionListController.a.c(r14, r15).B = new Pair(Integer.valueOf((int) r11), Integer.valueOf((int) r12));
        if (r6 == null) goto L49;
        String r16 = r6.getRoomId();
    L50:
        if (r6 == null) goto L52;
        String r17 = r6.getRoomUniqueKey();
    L53:
        PromotionListController.a.c(r16, r17).C = r28;
        goto L54
    L52:
        r17 = null;
        goto L53
    L49:
        r16 = null;
        goto L50
    L45:
        r15 = null;
        goto L46
    L42:
        r14 = null;
    L54:
        int r18 = y.a;
        String r19 = r24.a();
        com.bytedance.android.livesdk.livecommerce.promotion.card.d r29 = this.h;
        Intrinsics.checkNotNullParameter(r21, "sessionId");
        Intrinsics.checkNotNullParameter(r23, "promotionParams");
        Intrinsics.checkNotNullParameter(r29, "promotionSimpleSku");
        if (r19 == null) goto L64;
        int r110 = ECSdk.a;
        IEShoppingService r111 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r111 == null) goto L62;
        sc3.i r112 = r111.getSkuYataService();
        if (r112 == null) goto L62;
        xh3.a r30 = r112.h(r19);
    L63:
        if (r30 == null) goto L64;
        ql.a r113 = r23.a;
        LiveRoomParams r114 = r23.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        com.bytedance.android.ec.common.api.jump.model.f r115 = r23.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        if (r114 == null) goto L70;
        String r116 = r114.getGroupId();
        if (r116 == null) goto L70;
        r30.b("biz_context.item_id", r116);
    L70:
        String r1 = PromotionDetailSchemaHelper.b(PromotionDetailSchemaHelper.a, r23, "blank");
        r30.b("biz_context.detail_url", r1);
        r30.b("client_params.sku_session_id", r21);
        Pair<String[], Long> r31 = r29.a(r113.getPromotionId());
        if (r31 == null) goto L73;
        r30.b("client_params.default_spec_id", r31.getFirst());
        r30.b("client_params.default_count", r31.getSecond());
        r30.b("client_params.disable_server_specs_default_select", Boolean.TRUE);
    L73:
        cf.l r32 = (cf.l) ECSdk.a(cf.l.class);
        if (r32 == null) goto L76;
        View r33 = r32.Ia();
    L77:
        if (r33 != null) goto L83;
        cf.l r34 = (cf.l) ECSdk.a(cf.l.class);
        if (r34 == null) goto L81;
        float[] r35 = r34.Pa();
    L82:
        if (r35 != null) goto L83;
    L89:
        com.bytedance.android.ec.common.api.jump.model.f r36 = r23.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        if (r36 == null) goto L92;
        jf.e r37 = r36.d;
    L94:
        if (Intrinsics.areEqual(r37, jf.e.f.b) == false) goto L113;
        PromotionListController.a r38 = PromotionListController.T;
        if (r114 == null) goto L98;
        String r117 = r114.getRoomId();
    L99:
        if (r114 == null) goto L101;
        String r118 = r114.getRoomUniqueKey();
    L102:
        r38.getClass();
        if (PromotionListController.a.c(r117, r118).B == null) goto L113;
        if (r114 == null) goto L106;
        String r39 = r114.getRoomId();
    L107:
        if (r114 == null) goto L109;
        String r119 = r114.getRoomUniqueKey();
    L111:
        if (PromotionListController.a.c(r39, r119).C == null) goto L113;
    L112:
        int r40 = 0;
    L114:
        r30.b("client_params.add_cart_toast_type", Integer.valueOf(r40));
        JSONObject r41 = z1.f(r113.getTrackExtra());
        String r120 = r41.optString("cart_track");
        if (r120.length() <= 0) goto L117;
        boolean r121 = true;
    L118:
        if (r121 == false) goto L120;
        JSONObject r122 = new JSONObject(r120);
    L121:
        JSONObject r123 = r23.getAddToCartEntranceInfo();
        LiveRoomParams r124 = r6;
        r123.put("product_id", r113.getProductId());
        Iterator<String> r2 = r123.keys();
    L123:
        if (r2.hasNext() == false) goto L125;
        String r42 = r2.next();
        r122.put(r42, r123.optString(r42));
        r2 = r2;
        goto L123
    L125:
        r41.put("cart_track", r122);
        r30.c("api.add.extra", r41.toString(), 1);
        JSONObject r3 = new JSONObject();
        if (r114 == null) goto L130;
        JSONObject r43 = r114.getPassThroughLogData();
        if (r43 == null) goto L130;
        z1.b(r3, r43);
    L130:
        z1.b(r3, r113.getTransmissibleJson());
        if (r114 == null) goto L133;
        String r44 = r114.getEcomSceneId();
    L134:
        if (r44 != null) goto L136;
        r44 = "";
    L136:
        r3.put("ecom_scene_id", r44);
        if (r114 == null) goto L139;
        String r45 = r114.getAuthorId();
    L140:
        if (r45 != null) goto L142;
        r45 = "";
    L142:
        r3.put("anchor_id", r45);
        if (r114 == null) goto L145;
        String r46 = r114.getRoomId();
    L146:
        if (r46 != null) goto L148;
        r46 = "";
    L148:
        r3.put("room_id", r46);
        if (r114 == null) goto L155;
        Function0 r47 = r114.getRoomType();
        if (r47 == null) goto L155;
        Integer r48 = (Integer) r47.invoke();
        if (r48 == null) goto L155;
        int r49 = r48.intValue();
    L156:
        ECUISkuInfo r50 = com.bytedance.android.livesdk.livecommerce.utils.k.f(r113, r1, r49);
        if (r114 == null) goto L159;
        String r51 = r114.getRoomId();
    L160:
        r50.k = r51;
        if (r114 == null) goto L163;
        String r52 = r114.getAuthorId();
    L164:
        r50.l = r52;
        if (r114 == null) goto L167;
        String r53 = r114.getSecAuthorId();
    L168:
        r50.n = r53;
        if (r114 == null) goto L171;
        String r54 = r114.getGroupId();
    L172:
        r50.m = r54;
        if (r115 == null) goto L177;
        jf.b r55 = r115.c;
        if (r55 == null) goto L177;
        String r56 = r55.a;
    L178:
        r50.p = r56;
        Map r57 = e.a(r50, r23, r7);
        if (r114 == null) goto L183;
        String r58 = r114.getSearchParams();
        if (r58 == null) goto L183;
        r57.put("search_params", r58);
    L183:
        LinkedHashMap r59 = new LinkedHashMap();
        r59.putAll(z1.j(r3));
        r59.putAll(r57);
        String r60 = com.bytedance.android.shopping.extensions.k.x(r59);
        if (r60 == null) goto L186;
        r30.c("track.client", r60, 0);
    L186:
        JSONObject r61 = r23.getEntranceInfo();
        com.bytedance.android.livesdk.livecommerce.room.controller.related.b.a(r61, z1.f((String) ((LinkedHashMap) r57).get("entrance_info")), false);
        com.bytedance.android.livesdk.livecommerce.room.controller.related.b.a(r61, r3, false);
        if (r114 == null) goto L189;
        String r62 = r114.getEnterFromMerge();
    L190:
        r61.put("carrier_source", r62);
        if (r114 == null) goto L193;
        String r63 = r114.getEnterMethod();
    L194:
        r61.put("source_method", r63);
        String r64 = r113.getEcomGroupType();
        if (r64 != null) goto L197;
        r64 = "live";
    L197:
        r61.put("ecom_group_type", r64);
        r30.d(CollectionsKt.listOf(new String[]{"track.client.entrance_info", "api.sku.entrance_info"}), r61.toString());
        JSONObject r65 = new JSONObject();
        r65.put("_param_live_platform", "live");
        if (r114 == null) goto L200;
        String r66 = r114.getFollowStatus();
    L201:
        r65.put("follow_status", r66);
        r65.put("entrance_info", r23.getEntranceInfo().toString());
        r65.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        r65.put("enter_from", "live");
        Unit r67 = Unit.INSTANCE;
        r30.c("url.coupon.log_data", r65.toString(), 0);
        com.bytedance.android.btm.api.model.d r0 = BtmUtilsKt.a(r25, r23.getChainParams());
        if (r0 == null) goto L206;
        String r68 = BtmSDK.INSTANCE.createJumpSourceBtmToken(r0);
        if (r68 == null) goto L206;
        r30.a(r68);
    L206:
        if (r30 == null) goto L208;
        String r69 = r30.f();
    L209:
        if (r26 == null) goto L214;
        il2.a r70 = il2.a.C0145a.a(r26, "handle_sku_schema_jump", MapsKt.mapOf(TuplesKt.to("diff_action_type", String.valueOf(r22))), false, null, null, r69, 28);
        if (r70 == null) goto L214;
        ((LiveActionTracker) r70).e(false);
    L214:
        if (r22 != 1) goto L222;
        int r71 = ECSdk.a;
        IEShoppingService r72 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r72 == null) goto L220;
        sc3.i r73 = r72.getSkuYataService();
        if (r73 == null) goto L220;
        r73.m(UriProtector.parse(r69));
        Object r74 = "";
    L221:
        this.d.b(r21, new Pair("live_sku_android", r74));
        return;
    L220:
        r74 = null;
        goto L221
    L222:
        com.bytedance.android.ec.sdk.helper.p.a.openSchema(r20, r69);
        com.bytedance.android.ec.common.api.jump.model.g r75 = ECLiveEventHelper.a;
        PromotionJumpDispatcher$handleSkuSchemaAction$3 r76 = new PromotionJumpDispatcher$handleSkuSchemaAction$3(this, r20, r23, r124, r21);
        Intrinsics.checkNotNullParameter(r76, "callback");
        ECLiveEventHelper.c = r76;
        return;
    L208:
        r69 = null;
        goto L209
    L200:
        r66 = null;
        goto L201
    L193:
        r63 = null;
        goto L194
    L189:
        r62 = null;
    L177:
        r56 = null;
        goto L178
    L171:
        r54 = null;
        goto L172
    L167:
        r53 = null;
        goto L168
    L163:
        r52 = null;
        goto L164
    L159:
        r51 = null;
    L155:
        r49 = -1;
        goto L156
    L145:
        r46 = null;
        goto L146
    L139:
        r45 = null;
        goto L140
    L133:
        r44 = null;
        goto L134
    L120:
        r122 = new JSONObject();
        goto L121
    L117:
        r121 = false;
        goto L118
    L109:
        r119 = null;
        goto L111
    L106:
        r39 = null;
        goto L107
    L101:
        r118 = null;
        goto L102
    L98:
        r117 = null;
    L113:
        r40 = 1;
        goto L114
    L92:
        r37 = null;
        goto L94
    L81:
        r35 = null;
    L83:
        if (r115 == null) goto L85;
        jf.b r77 = r115.c;
    L87:
        if ((!Intrinsics.areEqual(r77, jf.b.l.b)) == false) goto L89;
    L85:
        r77 = null;
        goto L87
    L76:
        r33 = null;
    L62:
        r30 = null;
    L64:
        r124 = r6;
        r30 = null;
    L224:
        if (r26 == null) goto L232;
        il2.a r78 = il2.a.C0145a.a(r26, "handle_sku_schema_action", null, false, "unsupported_action_type", null, null, 48);
        if (r78 == null) goto L233;
        ((LiveActionTracker) r78).e(false);
        return;
    L233:
        return;
    L232:
        return;
    L16:
        if (r4.intValue() != 1) goto L18;
    L11:
        r4 = null;
        goto L12
    L5:
        if (r24 == null) goto L7;
        String r79 = String.valueOf(r24.getType());
    L8:
        il2.a.C0145a.a(r26, "handle_sku_schema_action", MapsKt.mapOf(TuplesKt.to("sku_action_type", r79)), false, null, null, null, 60);
        goto L9
    L7:
        r79 = null;
        goto L8
    }

    public static /* synthetic */ void J(PromotionJumpDispatcher r12, Context r13, String r14, int r15, com.bytedance.android.ec.common.api.jump.model.g r16, com.bytedance.android.btm.api.model.d r17, UltimateBuy r18, View r19, Pair r20, il2.a r21) {
        r12.I(r13, r14, r15, 1, r16, r17, r18, r19, r20, r21, null);
    }

    public static final void u(PromotionJumpDispatcher r11, ql.a r12, com.bytedance.android.ec.common.api.jump.model.g r13, String r14, String r15, String r16, boolean r17, String r18, int r19, int r20) {
        r11.getClass();
        oh.a.c("ECEditShopCartResultEvent", new l(r17, r13, r18, r19, r20, r12, r15, r16, r14));
    }

    public static final void x(final PromotionJumpDispatcher r24, final Context r25, String r26, int r27, final com.bytedance.android.ec.common.api.jump.model.g r28, final String r29, final String r30, final sc3.b r31, final com.bytedance.android.btm.api.model.d r32, final il2.a r33) {
        if (r33 == null) goto L5;
        r24.getClass();
        il2.a.C0145a.a(r33, "jump_to_order", null, false, null, null, null, 62);
    L5:
        jf.c r1 = r24.g;
        if (r1 == null) goto L8;
        r1.e(r25, r32);
    L8:
        final ql.a r9 = r28.a;
        if (r33 == null) goto L11;
        il2.a.C0145a.a(r33, "jump_to_order_inner", MapsKt.mapOf(new Pair[]{TuplesKt.to("order_url", r30), TuplesKt.to("is_auto_coupon", String.valueOf(r9.isAutoApplyCoupon()))}), false, null, null, null, 60);
    L11:
        String r13 = null;
        if (r9.isAutoApplyCoupon() == false) goto L36;
        if (r31 == null) goto L15;
        r31.c(ChainPoint.AUTO_COUPON_START, Long.valueOf(System.currentTimeMillis()));
    L15:
        Function0<Unit> r14 = new PromotionJumpDispatcher$jumpToOrderPageInner$1(r24, r31, r30, r28, r29, r32, r33, r9, r25);
        Map r2 = com.bytedance.android.ec.core.monitor.c.a;     // Catch: Exception -> L33
        String r10 = com.bytedance.android.ec.core.monitor.c.c(MonitorScenes.EC_SKU_COUPON_APPLY_API_DURATION, null);     // Catch: Exception -> L33
        com.bytedance.android.ec.core.monitor.c.e(r10, "scene", "live");     // Catch: Exception -> L33
        com.bytedance.android.ec.core.monitor.c.e(r10, LocationMonitorConst.TYPE, LocationInfoConst.SINGLE);     // Catch: Exception -> L33
        com.bytedance.android.ec.core.monitor.c.e(r10, "path", "coupon/apply/auto/");     // Catch: Exception -> L33
        com.bytedance.android.ec.core.monitor.c.h(r10, MetricNames.API_DURATION, null);     // Catch: Exception -> L33
        ql.a r11 = r28.a;     // Catch: Exception -> L33
        LiveRoomParams r12 = r28.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));     // Catch: Exception -> L33
        if (r33 == null) goto L19;
        il2.a.C0145a.a(r33, "req_apply_coupon", MapsKt.mapOf(new Pair[]{TuplesKt.to("promotion_id", r11.getPromotionId()), TuplesKt.to("product_id", r11.getProductId()), TuplesKt.to("shop_id", r11.getShopId())}), false, null, null, null, 60);     // Catch: Exception -> L33
    L19:
        if (r12 == null) goto L21;
        String r20 = r12.getRoomId();     // Catch: Exception -> L33
    L22:
        if (r12 == null) goto L24;
        String r21 = r12.getAuthorId();     // Catch: Exception -> L33
    L25:
        if (r12 == null) goto L27;
        String r22 = r12.getSecAuthorId();     // Catch: Exception -> L33
    L28:
        if (r12 == null) goto L30;
        String r23 = r12.getEcomSceneId();     // Catch: Exception -> L33
    L31:
        String r19 = r11.getShopId();     // Catch: Exception -> L33
        String r17 = r11.getProductId();     // Catch: Exception -> L33
        String r18 = r11.getPromotionId();     // Catch: Exception -> L33
        String r16 = String.valueOf((int) (CastFloatProtector.parseFloat(r11.getPrice()) * 100));     // Catch: Exception -> L33
        String r3 = vi2.h.a;     // Catch: Exception -> L33
        nl2.b.b(vi2.h.e(null, null, si2.g.B, new vi2.t(r16, r17, r18, r19, r20, r21, r22, r23)).observeOn(AndroidSchedulers.mainThread()).subscribe(new i(r24, r10, r25, r33, r14), new j(r24, r10, r25, r33, r14)));     // Catch: Exception -> L33
    L86:
        jf.c r0 = r24.g;
        if (r0 == null) goto L92;
        r0.h();
        return;
    L92:
        return;
    L30:
        r23 = null;
        goto L31
    L27:
        r22 = null;
        goto L28
    L24:
        r21 = null;
        goto L25
    L21:
        r20 = null;
    L33:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L86
    L36:
        if (r31 == null) goto L38;
        r31.c(ChainPoint.CREATE_SCHEMA_START, null);
    L38:
        IOrderSchema r15 = f.c(r30, r28, r29, r32);
        if (r15 != null) goto L44;
        if (r33 == null) goto L86;
        il2.a r4 = il2.a.C0145a.a(r33, "jump_to_order_inner", null, false, "schema_is_null", null, null, 48);
        if (r4 == null) goto L86;
        ((LiveActionTracker) r4).e(false);
        goto L86
    L44:
        int r5 = com.bytedance.android.livesdk.livecommerce.iron.helper.b.a;
        String r6 = r9.getProductId();
        if (r6 != null) goto L47;
        String r110 = "";
    L48:
        String r7 = r9.getPromotionId();
        if (r7 != null) goto L51;
        String r111 = "";
    L52:
        String r8 = r9.getEventItemType();
        if (r8 != null) goto L55;
        String r112 = "";
    L56:
        com.bytedance.android.livesdk.livecommerce.iron.helper.b.a(r15, r110, r111, r112, r9.getBenefitLabels(), PromotionDetailSchemaHelper.b(PromotionDetailSchemaHelper.a, r28, "blank"));
        if (r31 == null) goto L59;
        r31.c(ChainPoint.CREATE_SCHEMA_END, null);
    L59:
        int r34 = ECSdk.a;
        IEShoppingService r35 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r35 == null) goto L64;
        sc3.c r36 = r35.getBuyNowService();
        if (r36 == null) goto L64;
        r36.b(r15);
    L64:
        if (r31 == null) goto L67;
        r31.d(r15);
    L67:
        if (r15.u() == false) goto L85;
        IEShoppingService r37 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r37 == null) goto L73;
        sc3.c r38 = r37.getBuyNowService();
        if (r38 == null) goto L73;
        r38.g(r25, r15);
    L73:
        if (r33 == null) goto L78;
        il2.a r39 = il2.a.C0145a.a(r33, "open_buy_now", null, false, null, null, null, 62);
        if (r39 == null) goto L78;
        ((LiveActionTracker) r39).e(false);
    L78:
        if (r27 != 2) goto L86;
        IEShoppingService r40 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r40 == null) goto L84;
        sc3.c r41 = r40.getBuyNowService();
        if (r41 == null) goto L84;
        r13 = r41.k(r15);
    L84:
        r24.d.a(r26, r13);
        goto L86
    L85:
        r24.n(r25, r15.formatToUrl(), r32, r28, r29, r33);
        goto L86
    L55:
        r112 = r8;
        goto L56
    L51:
        r111 = r7;
        goto L52
    L47:
        r110 = r6;
        goto L48
    }

    /* JADX WARN: Failed to calculate best type for var: r15v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v1 ??, new type: java.lang.Integer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:681)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r15v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v1 ??, new type: java.lang.Integer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r15v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v1 ??, new type: java.lang.Integer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r15v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v1 ??, new type: java.lang.Integer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r15v18 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v18 ??, new type: java.lang.Integer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:681)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r15v18 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v18 ??, new type: java.lang.Integer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r15v18 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v18 ??, new type: java.lang.Integer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r15v18 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v18 ??, new type: java.lang.Integer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r15v19 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v19 ??, new type: java.lang.Integer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:681)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r15v19 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v19 ??, new type: java.lang.Integer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r15v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v2 ??, new type: java.lang.Integer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:681)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r15v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v2 ??, new type: java.lang.Integer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r15v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v2 ??, new type: java.lang.Integer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r15v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v2 ??, new type: java.lang.Integer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v1 java.lang.Integer, new type: java.lang.Integer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.applyResolvedVars(TypeSearch.java:100)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:76)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.runMultiVariableSearch(FixTypesVisitor.java:119)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 5 more
     */
    public static final void w(PromotionJumpDispatcher r24, Context r25, String r26, int r27, String r28, IOrderSchema r29, com.bytedance.android.ec.common.api.jump.model.g r30, sl.o r31, com.bytedance.android.btm.api.model.d r32, il2.a r33, sc3.b r34) {
        r24.getClass();
        if (r33 == null) goto L10;
        if (r31 == null) goto L7;
        String r8 = String.valueOf(r31.getType());
    L8:
        il2.a.C0145a.a(r33, "handle_order_schema_action", MapsKt.mapOf(TuplesKt.to("order_action_type", r8)), false, null, null, null, 60);
        goto L10
    L7:
        r8 = null;
    L10:
        PrefetchOrder r9 = r30.a.getPrefetchOrder();
        if (r31 == null) goto L13;
        Integer r15 = Integer.valueOf(r31.getType());
    L15:
        if (r15 != 0) goto L18;
    L20:
        if (r15 == 0) goto L102;
        if (r15.intValue() != 2) goto L102;
    L24:
        if (r29 == null) goto L26;
        r31.getType();
    L26:
        if (r29 != null) goto L28;
    L39:
        if (r31 == null) goto L42;
        r31.getType();
    L42:
        if (r31.getType() != 2) goto L44;
        int r10 = 1;
    L45:
        Integer r12 = Integer.valueOf(r10);
        String r11 = r31.a();
        jf.c r16 = r24.g;
        if (r16 == null) goto L48;
        r16.e(r25, r32);
    L48:
        if (r34 == null) goto L50;
        r34.c(ChainPoint.CREATE_SCHEMA_START, r15);
    L50:
        int r17 = f.a;
        IOrderSchema r18 = f.b(r11, r30, r28, r32, r12, r24.c);
        if (r29 == null) goto L61;
        PrefetchOrder r13 = r30.a.getPrefetchOrder();
        if (r13 == null) goto L61;
        if (r13.isDiffModel() != true) goto L61;
        if (r18 == null) goto L61;
        String r3 = r29.getQueryParam("check_parallel_id");
        if (r3 != null) goto L60;
        r3 = "";
    L60:
        r18.replaceOrAppendParam("check_parallel_id", r3);
    L61:
        if (r18 != null) goto L66;
        if (r33 == null) goto L173;
        il2.a r0 = il2.a.C0145a.a(r33, "open_order_new", null, false, "schema_is_null", null, null, 48);
        if (r0 == null) goto L174;
        ((LiveActionTracker) r0).e(false);
        return;
    L174:
        return;
    L173:
        return;
    L66:
        int r1 = ECSdk.a;
        IEShoppingService r2 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r2 == null) goto L71;
        sc3.c r4 = r2.getBuyNowService();
        if (r4 == null) goto L71;
        r4.b(r18);
    L71:
        if (r33 == null) goto L75;
        IOrderSchema r5 = r18;
        il2.a r6 = il2.a.C0145a.a(r33, "open_order_new", MapsKt.mapOf(new Pair[]{TuplesKt.to("diff_action_type", String.valueOf(r27)), TuplesKt.to("is_native", String.valueOf(r18.u()))}), false, null, null, null, 60);
        if (r6 == null) goto L77;
        ((LiveActionTracker) r6).e(false);
    L77:
        if (r27 != 1) goto L86;
        IEShoppingService r7 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r7 == null) goto L83;
        sc3.c r14 = r7.getBuyNowService();
        if (r14 == null) goto L83;
        String r19 = r14.q(r5.formatToUrl(), new EntranceInfoScene("ecomLive", EnumEntranceInfoScene.ENTER_ORDER_PAGE.getValue()));
    L84:
        r24.d.b(r26, new Pair("live_ultimate_buy_single_android", r19));
    L98:
        jf.c r20 = r24.g;
        if (r20 == null) goto L176;
        r20.h();
        return;
    L176:
        return;
    L83:
        r19 = null;
        goto L84
    L86:
        if (r34 == null) goto L88;
        r34.c(ChainPoint.CREATE_SCHEMA_END, null);
    L88:
        if (r34 == null) goto L91;
        r34.d(r5);
    L91:
        if (r5.u() == false) goto L97;
        IEShoppingService r21 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r21 == null) goto L98;
        sc3.c r22 = r21.getBuyNowService();
        if (r22 == null) goto L98;
        r22.g(r25, r5);
        goto L98
    L97:
        r24.n(r25, r5.formatToUrl(), r32, r30, r28, r33);
        goto L98
    L75:
        r5 = r18;
        goto L77
    L44:
        r10 = 0;
        goto L45
    L28:
        if (r31.getType() != 2) goto L39;
        if (r9 == null) goto L39;
        if (r9.isFetchModel() != true) goto L39;
        int r23 = ECSdk.a;
        IEShoppingService r35 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r35 == null) goto L37;
        sc3.c r36 = r35.getBuyNowService();
        if (r36 == null) goto L37;
        r36.g(r25, r29);
    L37:
        if (r34 == null) goto L171;
        r34.d(r29);
        return;
    L171:
        return;
    L102:
        if (r15 == 0) goto L166;
        if (r15.intValue() != 3) goto L166;
        if (r29 == null) goto L122;
        if (r9 == null) goto L122;
        if (r9.isFetchModel() != true) goto L122;
        String r37 = r29.getQueryParam("sku_session_id");
        if (r37 != null) goto L114;
        r37 = "";
    L114:
        int r38 = ECSdk.a;
        IEShoppingService r39 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r39 == null) goto L119;
        sc3.c r40 = r39.getBuyNowService();
        if (r40 == null) goto L119;
        r40.g(r25, r29);
    L119:
        if (r34 == null) goto L121;
        r34.d(r29);
    L121:
        com.bytedance.android.ec.common.api.jump.model.g r41 = ECLiveEventHelper.a;
        LiveSkuCallback r42 = new LiveSkuCallback(r24, r25, r30, r37);
        Intrinsics.checkNotNullParameter(r42, "callback");
        ECLiveEventHelper.c = r42;
        return;
    L122:
        if (r34 == null) goto L124;
        r34.c(ChainPoint.CREATE_SCHEMA_START, null);
    L124:
        int r43 = f.a;
        IOrderSchema r44 = f.c(r31.a(), r30, r28, r32);
        f.a(r44, r26, r30, r24.h);
        if (r29 == null) goto L135;
        PrefetchOrder r45 = r30.a.getPrefetchOrder();
        if (r45 == null) goto L135;
        if (r45.isDiffModel() != true) goto L135;
        if (r44 == null) goto L135;
        String r46 = r29.getQueryParam("check_parallel_id");
        if (r46 != null) goto L134;
        r46 = "";
    L134:
        r44.replaceOrAppendParam("check_parallel_id", r46);
    L135:
        if (r34 == null) goto L137;
        r34.c(ChainPoint.CREATE_SCHEMA_END, null);
    L137:
        if (r44 != null) goto L143;
        if (r33 == null) goto L179;
        il2.a r47 = il2.a.C0145a.a(r33, "open_order_multi_ultimate", null, false, "schema_is_null", null, null, 48);
        if (r47 == null) goto L180;
        ((LiveActionTracker) r47).e(false);
        return;
    L180:
        return;
    L179:
        return;
    L143:
        if (r33 == null) goto L147;
        String r210 = null;
        String r48 = r26;
        String r211 = "ecomLive";
        String r212 = "callback";
        il2.a r49 = il2.a.C0145a.a(r33, "open_order_multi_ultimate", MapsKt.mapOf(TuplesKt.to("diff_action_type", String.valueOf(r27))), false, null, null, null, 60);
        if (r49 == null) goto L149;
        ((LiveActionTracker) r49).e(false);
    L149:
        if (r27 != 1) goto L157;
        int r50 = ECSdk.a;
        IEShoppingService r51 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r51 == null) goto L155;
        sc3.c r52 = r51.getBuyNowService();
        if (r52 == null) goto L155;
        String r110 = r52.q(r44.formatToUrl(), new EntranceInfoScene(r211, EnumEntranceInfoScene.ENTER_ORDER_PAGE.getValue()));
    L156:
        r24.d.b(r48, new Pair("live_ultimate_buy_android", r110));
        return;
    L155:
        r110 = r210;
        goto L156
    L157:
        if (r34 == null) goto L159;
        r34.d(r44);
    L159:
        int r53 = ECSdk.a;
        IEShoppingService r54 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r54 == null) goto L164;
        sc3.c r55 = r54.getBuyNowService();
        if (r55 == null) goto L164;
        r55.g(r25, r44);
    L164:
        com.bytedance.android.ec.common.api.jump.model.g r56 = ECLiveEventHelper.a;
        LiveSkuCallback r57 = new LiveSkuCallback(r24, r25, r30, r48);
        Intrinsics.checkNotNullParameter(r57, r212);
        ECLiveEventHelper.c = r57;
        return;
    L147:
        r210 = null;
        r48 = r26;
        r211 = "ecomLive";
        r212 = "callback";
    L166:
        if (r33 == null) goto L184;
        il2.a r58 = il2.a.C0145a.a(r33, "handle_order_schema_action", null, false, "unsupported_action_type", null, null, 48);
        if (r58 == null) goto L185;
        ((LiveActionTracker) r58).e(false);
        return;
    L185:
        return;
    L184:
        return;
    L18:
        if (r15.intValue() != 1) goto L20;
    L13:
        r15 = r15;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r154v1 */
    /* JADX WARN: Type inference failed for: r154v2 */
    /* JADX WARN: Type inference failed for: r3v6, types: [kotlin.jvm.functions.Function0] */
    /* JADX WARN: Type inference failed for: r7v4, types: [com.bytedance.android.livesdk.livecommerce.iron.helper.PromotionJumpDispatcher$openSkuDialogFragment$4] */
    /* JADX WARN: Type inference failed for: r7v44, types: [com.bytedance.android.livesdk.livecommerce.iron.helper.PromotionJumpDispatcher$openSkuDialogFragment$4] */
    public final void I(final Context r146, String r147, int r148, int r149, final com.bytedance.android.ec.common.api.jump.model.g r150, final com.bytedance.android.btm.api.model.d r151, UltimateBuy r152, View r153, Pair<Integer, Integer> r154, il2.a r155, sc3.b r156) {
        if (r155 == null) goto L6;
        il2.a.C0145a.a(r155, "open_sku", null, false, null, null, null, 62);
    L6:
        if ((r146 instanceof FragmentActivity) == true) goto L12;
        if (r155 == null) goto L427;
        il2.a r1 = il2.a.C0145a.a(r155, "open_sku", null, false, "context_is_null", null, null, 48);
        if (r1 == null) goto L428;
        ((LiveActionTracker) r1).e(false);
        return;
    L428:
        return;
    L427:
        return;
    L12:
        jf.c r6 = this.g;
        if (r6 == null) goto L16;
        r6.d(r146, r151);
    L16:
        if (r156 == null) goto L18;
        r156.c(ChainPoint.CREATE_SCHEMA_START, null);
    L18:
        FragmentManager r7 = ((FragmentActivity) r146).getSupportFragmentManager();
        ql.a r8 = r150.a;
        final LiveRoomParams r9 = r150.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        com.bytedance.android.ec.common.api.jump.model.f r10 = r150.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        gi2.a r11 = (gi2.a) r150.getParamsModel(Reflection.getOrCreateKotlinClass(gi2.a.class));
        pk2.b r12 = (pk2.b) r150.getParamsModel(Reflection.getOrCreateKotlinClass(pk2.b.class));
        rh2.b r13 = (rh2.b) r150.getParamsModel(Reflection.getOrCreateKotlinClass(rh2.b.class));
        if (r10 == null) goto L21;
        jf.b r14 = r10.c;
    L22:
        String r15 = PromotionDetailSchemaHelper.b(PromotionDetailSchemaHelper.a, r150, "blank");
        if (r9 == null) goto L29;
        Function0 r16 = r9.getRoomType();
        if (r16 == null) goto L29;
        Integer r17 = (Integer) r16.invoke();
        if (r17 == null) goto L29;
        int r18 = r17.intValue();
    L30:
        final ECUISkuInfo r19 = com.bytedance.android.livesdk.livecommerce.utils.k.f(r8, r15, r18);
        if (r9 == null) goto L33;
        String r110 = r9.getRoomId();
    L34:
        r19.k = r110;
        if (r9 == null) goto L37;
        String r111 = r9.getAuthorId();
    L38:
        r19.l = r111;
        if (r9 == null) goto L41;
        String r112 = r9.getSecAuthorId();
    L42:
        r19.n = r112;
        if (r9 == null) goto L45;
        String r113 = r9.getGroupId();
    L46:
        r19.m = r113;
        if (r14 == null) goto L49;
        String r114 = r14.a;
    L50:
        r19.p = r114;
        Pair<String[], Long> r20 = this.h.a(r8.getPromotionId());
        if (r20 == null) goto L53;
        ECUISkuInfo.a r115 = new ECUISkuInfo.a((String[]) r20.getFirst(), ((Number) r20.getSecond()).longValue());
    L54:
        r19.s = r115;
        if (r10 == null) goto L57;
        jf.b r21 = r10.c;
    L58:
        jf.b.l r22 = jf.b.l.b;
        if (Intrinsics.areEqual(r21, r22) == false) goto L61;
        String r23 = "live_list_search";
    L68:
        if (r10 == null) goto L93;
        jf.e r116 = r10.d;
        if (r116 == null) goto L93;
        String r117 = "live_list_search";
        if (Intrinsics.areEqual(r116, jf.e.f.b) == true) goto L75;
        r116 = null;
    L75:
        if (r116 == null) goto L92;
        if (r153 == null) goto L92;
        float[] r118 = wj2.d.a(r153);
        float r119 = r118[0];
        float r120 = r118[1];
        PromotionListController.a r121 = PromotionListController.T;
        if (r9 == null) goto L80;
        String r2 = r9.getRoomId();
    L81:
        if (r9 == null) goto L83;
        String r24 = r9.getRoomUniqueKey();
    L84:
        r121.getClass();
        PromotionListController.a.c(r2, r24).B = new Pair(Integer.valueOf((int) r119), Integer.valueOf((int) r120));
        if (r9 == null) goto L87;
        String r3 = r9.getRoomId();
    L88:
        if (r9 == null) goto L90;
        String r25 = r9.getRoomUniqueKey();
    L91:
        PromotionListController.a.c(r3, r25).C = r154;
    L94:
        int r4 = e.a;
        com.bytedance.android.livesdk.livecommerce.iron.helper.c r5 = this.d;
        ?? r26 = new PromotionJumpDispatcher$openSkuDialogFragment$4(this, r146, r151);
        Function1<SkuShowAndDismissState, Unit> r27 = new PromotionJumpDispatcher$openSkuDialogFragment$5(this, r19, r150, r9);
        if (r12 != null) goto L108;
        if (r13 != null) goto L108;
        if (r149 != 1) goto L101;
        String r122 = r23.concat("_add_cart");
    L109:
        FragmentManager r28 = r7;
        Intrinsics.checkNotNullParameter(r28, "fragmentManager");
        Intrinsics.checkNotNullParameter(r147, "sessionId");
        Intrinsics.checkNotNullParameter(r5, "diffHelper");
        Intrinsics.checkNotNullParameter(r150, "promotionParams");
        Intrinsics.checkNotNullParameter(r19, "ecUISkuInfo");
        Intrinsics.checkNotNullParameter(r122, "openMethod");
        ql.a r29 = r150.a;
        com.bytedance.android.ec.common.api.jump.model.f r123 = r150.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        gi2.a r124 = (gi2.a) r150.getParamsModel(Reflection.getOrCreateKotlinClass(gi2.a.class));
        final LiveRoomParams r125 = r150.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        if (r123 == null) goto L112;
        jf.b r126 = r123.c;
    L113:
        ECUISkuInfo.a r0 = r19.s;
        if (r0 == null) goto L131;
        String[] r30 = r0.a;
        if (r30 == null) goto L131;
        if (r30.length != 0) goto L120;
        boolean r34 = true;
    L122:
        if ((!r34) == true) goto L125;
        r30 = null;
    L125:
        if (r30 == null) goto L131;
        SkuRestoreState r31 = new SkuRestoreState(r30.length);
        r31.setSelectSkuKeys(r30);
        ECUISkuInfo.a r32 = r19.s;
        if (r32 == null) goto L129;
        long r33 = r32.b;
    L130:
        r31.setProductCount(r33);
        SkuRestoreState r38 = r31;
        ?? r157 = r26;
    L132:
        if (r124 == null) goto L138;
        Function0<Boolean> r35 = r124.d;
        if (r35 == null) goto L138;
        if (((Boolean) r35.invoke()).booleanValue() != true) goto L138;
        boolean r46 = true;
    L139:
        if (r123 == null) goto L141;
        jf.b r36 = r123.c;
    L143:
        if (Intrinsics.areEqual(r36, jf.b.j.b) == false) goto L145;
        int r63 = 202;
    L146:
        JSONObject r37 = r150.getEntranceInfo();
        JSONObject r39 = r150.getAddToCartEntranceInfo();
        r39.put("product_id", r29.getProductId());
        String r127 = r39.toString();
        com.bytedance.android.ec.common.api.jump.model.f r40 = r150.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        if (r40 == null) goto L149;
        jf.e r41 = r40.d;
    L150:
        jf.e.f r42 = jf.e.f.b;
        if (Intrinsics.areEqual(r41, r42) == false) goto L171;
        PromotionListController.a r43 = PromotionListController.T;
        if (r125 == null) goto L155;
        String r44 = r125.getRoomId();
    L156:
        if (r125 == null) goto L158;
        String r128 = r125.getRoomUniqueKey();
    L159:
        r43.getClass();
        if (PromotionListController.a.c(r44, r128).B == null) goto L171;
        if (r125 == null) goto L163;
        String r45 = r125.getRoomId();
    L164:
        if (r125 == null) goto L166;
        String r47 = r125.getRoomUniqueKey();
    L168:
        if (PromotionListController.a.c(r45, r47).C == null) goto L171;
        int r48 = 1;
    L177:
        int r129 = -1;
    L180:
        if (r149 != r48) goto L182;
        boolean r1110 = true;
    L183:
        int r49 = r19.r;
        List r50 = r29.getBenefitLabels();
        if (r50 == null) goto L201;
        ArrayList r130 = new ArrayList();
        Iterator r51 = r50.iterator();
    L187:
        if (r51.hasNext() == false) goto L196;
        Object r52 = r51.next();
        Iterator r131 = r51;
        Map r53 = ((PromotionBenefitLabel) r52).getExtra();
        if (r53 == null) goto L191;
        String r54 = (String) r53.get("pass_through");
    L193:
        if (Intrinsics.areEqual(r54, "1") == false) goto L195;
        r130.add(r52);
    L195:
        r51 = r131;
        goto L187
    L191:
        r54 = null;
        goto L193
    L196:
        ArrayList r55 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r130, 10));
        Iterator r56 = r130.iterator();
    L198:
        if (r56.hasNext() == false) goto L200;
        r55.add(((PromotionBenefitLabel) r56.next()).createClone());
        goto L198
    L200:
        ArrayList r68 = r55;
    L202:
        String r57 = r19.j;
        boolean r410 = Intrinsics.areEqual("1", r19.t);
        if (r125 == null) goto L205;
        Map r58 = r125.getReportParams();
    L206:
        if (r58 != null) goto L208;
        r58 = MapsKt.emptyMap();
    L208:
        Map r1210 = r58;
        Map r103 = e.a(r19, r150, r149);
        JSONObject r59 = new JSONObject();
        if (r125 == null) goto L213;
        JSONObject r60 = r125.getPassThroughLogData();
        if (r60 == null) goto L213;
        z1.b(r59, r60);
    L213:
        z1.b(r59, r29.getTransmissibleJson());
        Unit r61 = Unit.INSTANCE;
        if (r125 == null) goto L216;
        String r62 = r125.getEcomSceneId();
    L218:
        if (r62 != null) goto L220;
        r62 = "";
    L220:
        r59.put("ecom_scene_id", r62);
        if (r125 == null) goto L223;
        String r64 = r125.getAuthorId();
    L224:
        if (r64 != null) goto L226;
        r64 = "";
    L226:
        r59.put("anchor_id", r64);
        if (r125 == null) goto L229;
        String r65 = r125.getRoomId();
    L230:
        if (r65 != null) goto L232;
        r65 = "";
    L232:
        r59.put("room_id", r65);
        String r1211 = r59.toString();
        String r66 = r19.f;
        if (r66 != null) goto L235;
        String r510 = "";
    L236:
        String r71 = r29.getChannelId();
        Integer r72 = r29.getChannelType();
        int r67 = r19.i;
        int r69 = ul.d.a;
        if (r149 != 1) goto L239;
        boolean r70 = true;
    L240:
        int r610 = ul.d.b(1, r70, 4);
        String r73 = r19.o;
        ECUICampaign r74 = r19.e;
        if (r74 == null) goto L243;
        Boolean r75 = r74.isGroup();
    L244:
        Boolean r76 = Boolean.TRUE;
        if (Intrinsics.areEqual(r75, r76) == false) goto L247;
    L250:
        boolean r611 = true;
    L251:
        String r77 = r19.l;
        if (r77 != null) goto L254;
        String r511 = "";
    L255:
        String r78 = r19.n;
        if (r78 != null) goto L258;
        String r512 = "";
    L259:
        if (r125 == null) goto L261;
        String r1111 = r125.getSourcePage();
    L262:
        String r79 = r19.k;
        String r132 = r19.g;
        String r80 = r19.a;
        if (r80 != null) goto L265;
        String r1212 = "";
    L266:
        String r81 = r19.b;
        if (r81 != null) goto L269;
        String r1213 = "";
    L270:
        String r82 = r19.h;
        if (r125 == null) goto L273;
        String r1112 = r125.getEnterMethod();
    L274:
        final FragmentManager r133 = r28;
        String r83 = r19.m;
        String r134 = r122;
        ECUICampaign r135 = r19.e;
        if (r135 == null) goto L277;
        Boolean r136 = r135.isGroup();
    L279:
        if (Intrinsics.areEqual(r136, r76) == false) goto L288;
        ECUICampaign r85 = r19.e;
        if (r85 == null) goto L288;
        ECUIPingGroup r86 = r85.groupData;
        if (r86 == null) goto L288;
        String r87 = r86.getGroupId();
        if (r87 == null) goto L288;
        String r1113 = r87;
    L290:
        if (r126 == null) goto L292;
        String r710 = r126.a;
    L294:
        if (r125 == null) goto L296;
        String r1114 = r125.getEnterFromMerge();
    L297:
        if (r37 == null) goto L299;
        String r88 = r37.toString();
    L300:
        EnumEntranceInfoScene r137 = EnumEntranceInfoScene.ENTER_SKU;
        Intrinsics.checkNotNullParameter(r137, "scene");
        gl.a r89 = com.bytedance.android.livesdk.livecommerce.utils.q.a(r137, r88);
        if (r89 == null) goto L316;
        Pair[] r138 = new Pair[3];
        if (r125 == null) goto L305;
        String r90 = r125.getEnterFromMerge();
    L306:
        r138[0] = TuplesKt.to("carrier_source", r90);
        if (r125 == null) goto L309;
        String r91 = r125.getEnterMethod();
    L310:
        r138[1] = TuplesKt.to("source_method", r91);
        String r92 = r29.getEcomGroupType();
        if (r92 != null) goto L313;
        r92 = "live";
    L313:
        r138[2] = TuplesKt.to("ecom_group_type", r92);
        r89.g(r138);
        String r93 = r89.h();
        if (r93 == null) goto L317;
        com.bytedance.android.livesdk.livecommerce.utils.s.d(r93, r137, new OpenSkuPanelLiveHelper$openSkuPanelFragment$skuParams$6(r125));
        com.bytedance.android.livesdk.livecommerce.utils.s.c(r93, r137);
        String r101 = r93;
    L318:
        String r94 = r19.d;
        if (r125 == null) goto L321;
        String r1115 = r125.getSearchParams();
    L322:
        BuyNowPreloadParams r411 = new BuyNowPreloadParams(false, null, null, null, null, r29.getTitle(), null, null, null, 479, null);
        if (r124 == null) goto L325;
        int r139 = r124.hashCode();
    L326:
        String r412 = String.valueOf(r139);
        if (r152 == null) goto L332;
        CheckSKUParams r95 = r152.getSkuParams();
        if (r95 == null) goto L332;
        Integer r96 = r95.getAddCartOptLive();
        if (r96 == null) goto L332;
    L335:
        Integer r413 = r96;
    L337:
        if (r152 == null) goto L343;
        CheckSKUParams r97 = r152.getSkuParams();
        if (r97 == null) goto L343;
        Integer r98 = r97.getHeightPercent();
        if (r98 == null) goto L343;
        int r99 = r98.intValue();
    L344:
        Integer r910 = Integer.valueOf(r99);
        if (r152 == null) goto L351;
        CheckSKUParams r100 = r152.getSkuParams();
        if (r100 == null) goto L351;
        Float r102 = r100.getMaskAlpha();
        if (r102 == null) goto L351;
        float r911 = r102.floatValue();
    L352:
        if (r152 == null) goto L356;
        CheckSKUParams r104 = r152.getSkuParams();
        if (r104 == null) goto L356;
        Integer r810 = Integer.valueOf(r104.getForceYataSku());
    L357:
        if (r152 == null) goto L361;
        CheckSKUParams r105 = r152.getSkuParams();
        if (r105 == null) goto L361;
        String r711 = r105.getBizIdentifier();
    L363:
        if (r152 == null) goto L369;
        CheckSKUParams r106 = r152.getSkuParams();
        if (r106 == null) goto L369;
        Long r107 = r106.getWarehouseListId();
        if (r107 == null) goto L369;
        String r1310 = String.valueOf(r107.longValue());
    L370:
        if (r152 == null) goto L376;
        CheckSKUParams r108 = r152.getSkuParams();
        if (r108 == null) goto L376;
        Long r109 = r108.getLiveShopMode();
        if (r109 == null) goto L376;
        String r1311 = String.valueOf(r109.longValue());
    L377:
        SkuParams r140 = new SkuParams(null, null, r38, null, r411, r67, null, 0, null, false, r46, r412, r413, r410, r82, r510, r73, false, r132, null, r511, r512, null, r83, r79, r611, r610, r63, null, null, r49, r57, r68, null, r711, r71, r72, null, r710, null, null, null, null, null, null, null, false, null, null, null, r810, false, false, false, null, r910, null, null, r911, null, null, null, null, null, r94, r101, null, r103, null, r134, null, 0, "OpenSkuPanelLiveHelper-openSkuPanelFragment", null, r1114, r1111, r1112, r1115, r1110, null, r1113, null, null, r1211, null, r1210, r129, 0, false, r127, r1213, r1212, false, null, null, null, null, null, null, r1310, r1311, 273285963, -75759710, -242875692, 7, null);
        if (r156 == null) goto L380;
        cf.u r141 = null;
        r156.c(ChainPoint.CREATE_SCHEMA_END, null);
    L381:
        int r142 = ECSdk.a;
        IECCommonService r143 = (IECCommonService) ECSdk.a(IECCommonService.class);
        if (r143 == null) goto L384;
        final JSONObject r144 = r37;
        d r145 = new d(r125, r144);
        Function0<String> r158 = new OpenSkuPanelLiveHelper$openSkuPanelFragment$skuService$2(r144);
        Function2<SkuParams, Long, Unit> r159 = new OpenSkuPanelLiveHelper$openSkuPanelFragment$skuService$3(r125);
        final ?? r160 = r157;
        Function1<String, Unit> r161 = new OpenSkuPanelLiveHelper$openSkuPanelFragment$skuService$4(r160, r133);
        com.bytedance.android.btm.api.model.d r162 = r151;
        cf.u r163 = IECCommonService.a.d(r143, r133, r140, r145, BtmUtilsKt.a(r162, r150.getChainParams()), r158, r159, r161, r27, null, null, null, r29.getUltimateBuyType(), null, null, null, 28672);
    L386:
        if (r148 == 2) goto L388;
    L408:
        if (r163 == null) goto L413;
        if (r11 == null) goto L413;
        Function1<cf.u, Unit> r164 = r11.g;
        if (r164 == null) goto L413;
        Unit r165 = (Unit) r164.invoke(r163);
    L413:
        jf.c r166 = this.g;
        if (r166 == null) goto L416;
        r166.m();
    L416:
        if (r155 == null) goto L420;
        cf.u r167 = r141;
        il2.a r168 = il2.a.C0145a.a(r155, "open_sku_success", null, false, null, null, null, 62);
        if (r168 == null) goto L421;
        ((LiveActionTracker) r168).e(false);
    L421:
        L(r150, r167, "sku", r162);
        return;
    L420:
        r167 = r141;
        goto L421
    L388:
        if (r149 != 2) goto L400;
        IEShoppingService r169 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r169 == null) goto L397;
        sc3.i r170 = r169.getSkuYataService();
        if (r170 == null) goto L397;
        if (r152 == null) goto L395;
        int r171 = r152.getType();
    L396:
        cf.u r172 = r170.f(r140, r171);
    L398:
        r5.a(r147, r172);
        goto L408
    L395:
        r171 = 2;
    L397:
        r172 = r141;
        goto L398
    L400:
        if (r149 != 1) goto L408;
        IEShoppingService r173 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r173 == null) goto L406;
        sc3.i r174 = r173.getSkuYataService();
        if (r174 == null) goto L406;
        r174.n(r140);
        cf.u r175 = "";
    L407:
        r5.a(r147, r175);
    L406:
        r175 = r141;
        goto L407
    L384:
        r162 = r151;
        r163 = r141;
        goto L386
    L380:
        r141 = null;
    L376:
        r1311 = null;
    L369:
        r1310 = null;
    L361:
        r711 = null;
    L356:
        r810 = null;
    L351:
        r911 = 0.0f;
    L343:
        r99 = 73;
    L332:
        ECUIPromotionLiveListConfig r176 = r29.getClientData().g;
        if (r176 == null) goto L336;
        r96 = r176.getAddCartOpt();
        goto L335
    L336:
        r413 = null;
        goto L337
    L325:
        r139 = 0;
        goto L326
    L321:
        r1115 = null;
    L317:
        r101 = null;
        goto L318
    L309:
        r91 = null;
        goto L310
    L305:
        r90 = null;
        goto L306
    L316:
        r37 = r37;
        r57 = r57;
        goto L317
    L299:
        r88 = null;
        goto L300
    L296:
        r1114 = null;
        goto L297
    L292:
        r710 = null;
    L288:
        r1113 = "";
        goto L290
    L277:
        r136 = null;
        goto L279
    L273:
        r1112 = null;
        goto L274
    L269:
        r1213 = r81;
        goto L270
    L265:
        r1212 = r80;
        goto L266
    L261:
        r1111 = null;
        goto L262
    L258:
        r512 = r78;
        goto L259
    L254:
        r511 = r77;
        goto L255
    L247:
        if (r19.w == true) goto L250;
        r611 = false;
        goto L251
    L243:
        r75 = null;
        goto L244
    L239:
        r70 = false;
        goto L240
    L235:
        r510 = r66;
        goto L236
    L229:
        r65 = null;
        goto L230
    L223:
        r64 = null;
        goto L224
    L216:
        r62 = null;
        goto L218
    L205:
        r58 = null;
        goto L206
    L201:
        r68 = null;
        goto L202
    L182:
        r1110 = false;
        goto L183
    L166:
        r47 = null;
        goto L168
    L163:
        r45 = null;
        goto L164
    L158:
        r128 = null;
        goto L159
    L155:
        r44 = null;
    L171:
        com.bytedance.android.ec.common.api.jump.model.f r177 = r150.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        if (r177 == null) goto L174;
        jf.e r178 = r177.d;
    L175:
        boolean r179 = Intrinsics.areEqual(r178, r42);
        r48 = 1;
        if ((!r179) == true) goto L177;
        r129 = 0;
        goto L180
    L174:
        r178 = null;
        goto L175
    L149:
        r41 = null;
        goto L150
    L145:
        r63 = 201;
        goto L146
    L141:
        r36 = null;
    L138:
        r46 = false;
        goto L139
    L129:
        r33 = 1;
        goto L130
    L120:
        r34 = false;
    L131:
        r157 = r26;
        r28 = r28;
        r38 = null;
        goto L132
    L112:
        r126 = null;
        goto L113
    L101:
        if (r10 == null) goto L103;
        jf.b r180 = r10.c;
    L105:
        if (Intrinsics.areEqual(r180, r22) == false) goto L107;
        r122 = r117;
        goto L109
    L107:
        r122 = r23.concat("_buy");
        goto L109
    L103:
        r180 = null;
    L108:
        r122 = "live_card_buy";
        goto L109
    L90:
        r25 = null;
        goto L91
    L87:
        r3 = null;
        goto L88
    L83:
        r24 = null;
        goto L84
    L80:
        r2 = null;
    L92:
        r22 = r22;
    L93:
        r22 = r22;
        r117 = "live_list_search";
        goto L94
    L61:
        if (r10 == null) goto L63;
        jf.b r181 = r10.c;
    L65:
        if (Intrinsics.areEqual(r181, jf.b.j.b) == false) goto L67;
        r23 = "live_replay";
        goto L68
    L67:
        r23 = "live_list";
        goto L68
    L63:
        r181 = null;
        goto L65
    L57:
        r21 = null;
        goto L58
    L53:
        r115 = null;
        goto L54
    L49:
        r114 = null;
        goto L50
    L45:
        r113 = null;
        goto L46
    L41:
        r112 = null;
        goto L42
    L37:
        r111 = null;
        goto L38
    L33:
        r110 = null;
    L29:
        r18 = -1;
        goto L30
    L21:
        r14 = null;
        goto L22
    }

    public final void a(final Context r27, final com.bytedance.android.ec.common.api.jump.model.g r28, j0 r29, final String r30, final Integer r31, final int r32, final int r33, final cf.a r34, final int r35, final com.bytedance.android.btm.api.model.d r36, final il2.a r37) {
        Intrinsics.checkNotNullParameter(r27, "context");
        Intrinsics.checkNotNullParameter(r28, "promotionParams");
        Intrinsics.checkNotNullParameter(r29, "action");
        Intrinsics.checkNotNullParameter(r30, "clickArea");
        if (r37 == null) goto L5;
        il2.a.C0145a.a(r37, "handle_action", MapsKt.mapOf(TuplesKt.to("action_type", String.valueOf(r29.a()))), false, null, null, null, 60);
    L5:
        ActionType r0 = r29.a();
        if (r0 == null) goto L12;
        int r1 = g.a[r0.ordinal()];
        if (r1 == 1) goto L63;
        if (r1 == 2) goto L34;
        if (r1 != 3) goto L12;
        com.bytedance.android.ec.model.response.l r2 = r29.c();
        if (r2 != null) goto L25;
        dm.a.a("PromotionJumpDispatcher").w("handleAction handleDeferRequest deferActionMeta is null", null);
        if (r37 == null) goto L371;
        il2.a r3 = il2.a.C0145a.a(r37, "handle_action", null, false, "defer_action_meta_is_null", null, null, 48);
        if (r3 == null) goto L372;
        ((LiveActionTracker) r3).e(false);
        return;
    L372:
        return;
    L371:
        return;
    L25:
        String r4 = r2.a();
        Map r5 = r2.b();
        long r6 = r2.c();
        if (r4 != null) goto L33;
        dm.a.a("PromotionJumpDispatcher").w("handleAction handleDeferRequest deferActionMeta route is null", null);
        if (r37 == null) goto L373;
        il2.a r7 = il2.a.C0145a.a(r37, "handle_action", null, false, "defer_action_meta_route_is_null", null, null, 48);
        if (r7 == null) goto L374;
        ((LiveActionTracker) r7).e(false);
        return;
    L374:
        return;
    L373:
        return;
    L33:
        BuildersKt.launch((com.bytedance.android.livesdk.livecommerce.utils.g) this.e.getValue(), Dispatchers.getMain().getImmediate(), CoroutineStart.UNDISPATCHED, new PromotionJumpDispatcher$handleAction$1(this, r6, r5, r4, r28.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class)), null));
        return;
    L34:
        h0 r8 = r29.d();
        if (r8 != null) goto L42;
        dm.a.a("PromotionJumpDispatcher").w("handleAction handleJumpAction jumpAction is null", null);
        if (r37 == null) goto L375;
        il2.a r9 = il2.a.C0145a.a(r37, "handle_action", null, false, "jump_action_is_null", null, null, 48);
        if (r9 == null) goto L376;
        ((LiveActionTracker) r9).e(false);
        return;
    L376:
        return;
    L375:
        return;
    L42:
        String r10 = r8.a();
        if (r10 != null) goto L50;
        dm.a.a("PromotionJumpDispatcher").w("handleAction handleJumpAction jumpAction.url is null", null);
        if (r37 == null) goto L377;
        il2.a r11 = il2.a.C0145a.a(r37, "handle_action", null, false, "schema_is_null", null, null, 48);
        if (r11 == null) goto L378;
        ((LiveActionTracker) r11).e(false);
        return;
    L378:
        return;
    L377:
        return;
    L50:
        if (r37 == null) goto L52;
        boolean r12 = false;
        il2.a.C0145a.a(r37, "handle_action_jump", null, false, null, null, r10, 30);
    L53:
        jf.c r13 = this.g;
        if (r13 != null) goto L56;
    L62:
        n(r27, r10, r36, r28, r30, r37);
        return;
    L56:
        if (r13.k(r10) != true) goto L62;
        if (r37 == null) goto L385;
        il2.a r14 = il2.a.C0145a.a(r37, "handle_action_jump_check", null, false, "schema_jump_intercepted", null, null, 48);
        if (r14 == null) goto L386;
        ((LiveActionTracker) r14).e(r12);
        return;
    L386:
        return;
    L385:
        return;
    L52:
        r12 = false;
        goto L53
    L63:
        com.bytedance.android.ec.model.response.c r15 = r29.b();
        if (r15 != null) goto L71;
        dm.a.a("PromotionJumpDispatcher").w("handleAction handleBizAction bizAction is null", null);
        if (r37 == null) goto L379;
        il2.a r16 = il2.a.C0145a.a(r37, "handle_action", null, false, "biz_action_is_null", null, null, 48);
        if (r16 == null) goto L380;
        ((LiveActionTracker) r16).e(false);
        return;
    L380:
        return;
    L379:
        return;
    L71:
        JSONObject r17 = z1.g(r15.b());
        if (r37 == null) goto L74;
        char r18 = 3;
        il2.a.C0145a.a(r37, "handle_action_biz", MapsKt.mapOf(TuplesKt.to("biz_action_name", r15.a())), false, null, null, null, 60);
    L75:
        String r19 = r15.a();
        if (r19 != null) goto L79;
    L80:
        Throwable r20 = null;
        int r21 = 2;
        char r22 = 1;
    L356:
        if (r37 == null) goto L360;
        Pair[] r23 = new Pair[r21];
        r23[0] = TuplesKt.to("biz_action_name", r15.a());
        r23[r22] = TuplesKt.to("click_area", r30);
        il2.a r24 = il2.a.C0145a.a(r37, "handle_action_biz", MapsKt.mapOf(r23), false, "unknown_action_name", r28.a.getLogid(), null, 32);
        if (r24 == null) goto L360;
        ((LiveActionTracker) r24).e(false);
    L360:
        dm.a.a("PromotionJumpDispatcher").w("handleActionBiz understand actionName: " + r15.a(), r20);
        return;
    L79:
        switch(r19.hashCode()) {
            case -1925534164: goto L324;
            case -1875223846: goto L314;
            case -1192872425: goto L299;
            case -1173571632: goto L289;
            case -360010818: goto L259;
            case 24377793: goto L256;
            case 813458585: goto L184;
            case 1800871684: goto L142;
            case 1865208001: goto L82;
            default: goto L80;
        };
    L256:
        r20 = null;
        if (r19.equals("PRODUCT_DETAIL") == false) goto L288;
        jf.d.b.c(this, r27, r28, r30, ECDisplayUtils.c(r27), r36, r37);
        return;
    L288:
        char r25 = 1;
    L298:
        r21 = 2;
        r22 = r25;
        goto L356
    L259:
        String r26 = "";
        r20 = null;
        if (r19.equals("COMBINATION_JUMP") == false) goto L288;
        com.bytedance.android.ec.common.api.jump.model.f r38 = r28.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        LiveRoomParams r39 = r28.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        if (r38 == null) goto L264;
        jf.b r40 = r38.c;
    L265:
        if (r17 == 0) goto L267;
        String r41 = r17.optString("url");
    L268:
        if (r41 == null) goto L271;
        r26 = r41;
    L271:
        Pair[] r42 = new Pair[4];
        if (r40 == null) goto L274;
        String r43 = r40.a;
    L275:
        r42[0] = new Pair("ecom_entrance_form", r43);
        if (r39 == null) goto L278;
        String r44 = r39.getAuthorId();
    L279:
        r42[1] = new Pair("author_id", r44);
        if (r39 == null) goto L282;
        String r45 = r39.getGroupId();
    L283:
        r42[2] = new Pair("group_id", r45);
        if (r39 == null) goto L286;
        String r46 = r39.getRoomId();
    L287:
        r42[r18] = new Pair("room_id", r46);
        n(r27, l0.s(r26, "meta_param", r42), r36, r28, r30, r37);
        return;
    L286:
        r46 = null;
        goto L287
    L282:
        r45 = null;
        goto L283
    L278:
        r44 = null;
        goto L279
    L274:
        r43 = null;
        goto L275
    L267:
        r41 = null;
        goto L268
    L264:
        r40 = null;
        goto L265
    L289:
        r20 = null;
        r25 = 1;
        if (r19.equals("GIVEN_JUMP") == false) goto L298;
        if (r17 == 0) goto L293;
        String r47 = r17.optString("url");
    L294:
        if (r47 != null) goto L296;
        String r48 = "";
    L297:
        UrlBuilderV2 r49 = new UrlBuilderV2(r48);
        r49.addOrReplaceParam("entrance_info", r28.getEntranceInfo().toString());
        n(r27, r49.build(), r36, r28, r30, r37);
        return;
    L296:
        r48 = r47;
        goto L297
    L293:
        r47 = null;
        goto L294
    L299:
        r20 = null;
        r21 = 2;
        r22 = 1;
        boolean r50 = true;
        if (r19.equals("MARKETING_EXPRESS") == false) goto L356;
        Activity r51 = com.bytedance.android.ec.core.utils.l0.b(r27);
        if (r51 != null) goto L304;
        dm.a.a("PromotionJumpDispatcher").b("execute marketingExpress can't find Activity " + r27, null);
        return;
    L304:
        dm.a.b r52 = dm.a.a("PromotionJumpDispatcher");
        StringBuilder r53 = new StringBuilder("execute marketingExpress actionParams: is ");
        if (r15.b() != null) goto L308;
        r50 = false;
    L308:
        r53.append(r50);
        r53.append(" has value");
        r52.i(r53.toString());
        IMarketingServiceV2 r54 = (IMarketingServiceV2) ServiceManager.get().getService(IMarketingServiceV2.class);
        if (r54 == null) goto L311;
        com.bytedance.android.marketing.sdk.api.c r55 = new com.bytedance.android.marketing.sdk.api.c(r51, null, 2);
        r55.a = r15.b();
        r55.d("ec_live");
        r55.c("live");
        Unit r56 = Unit.INSTANCE;
        String r57 = IMarketingServiceV2.a.a(r54, r55, 0, null, null, null, null, null, 126);
    L312:
        if (r57 != null) goto L401;
        dm.a.a("PromotionJumpDispatcher").b("execute marketingExpress getService is null", null);
        return;
    L401:
        return;
    L311:
        r57 = null;
        goto L312
    L314:
        r20 = null;
        r21 = 2;
        r22 = 1;
        if (r19.equals("AUCTION_BID_V2") == false) goto L356;
        com.bytedance.android.livesdk.livecommerce.iron.helper.a r58 = com.bytedance.android.livesdk.livecommerce.iron.helper.a.a;
        if (r17 == 0) goto L319;
        String r59 = r17.optString("url");
    L320:
        if (r59 != null) goto L322;
        String r60 = "";
    L323:
        r58.getClass();
        com.bytedance.android.livesdk.livecommerce.iron.helper.a.a(r27, r60, r28, r36, r37);
        return;
    L322:
        r60 = r59;
        goto L323
    L319:
        r59 = null;
        goto L320
    L324:
        r20 = null;
        r21 = 2;
        r22 = 1;
        if (r19.equals("PROMOTION_CHECK") == false) goto L356;
        int r61 = ECSdk.a;
        IEShoppingService r62 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r62 == null) goto L331;
        sc3.c r63 = r62.getBuyNowService();
        if (r63 == null) goto L331;
        com.bytedance.android.shopping.buynow.monitor.firstscreen.a r64 = r63.n(new com.bytedance.android.ec.model.d(r27, "PromotionJumpDispatcher_2", System.currentTimeMillis()));
    L332:
        final Ref.ObjectRef r65 = new Ref.ObjectRef();
        r65.element = null;
        if (r64 == null) goto L335;
        r64.c(ChainPoint.PAGE_INIT, null);
    L335:
        if (r31 == null) goto L352;
        if (r64 == null) goto L338;
        r64.c(ChainPoint.SKU_CHECK_START, Long.valueOf(System.currentTimeMillis()));
    L338:
        int r110 = r31.intValue();
        if (r17 != 0) goto L341;
    L343:
        boolean r111 = false;
    L344:
        if (r17 == 0) goto L346;
        String r112 = r17.optString("path");
    L348:
        if (r17 == 0) goto L350;
        String r210 = r17.optString("fallback_toast");
    L351:
        Function1<Throwable, Unit> r113 = new PromotionJumpDispatcher$handleActionBiz$1(this, r65);
        final com.bytedance.android.shopping.buynow.monitor.firstscreen.a r66 = r64;
        C(r27, r28, r110, r32, r33, r111, r35, r112, true, r36, r210, r37, r113, new PromotionJumpDispatcher$handleActionBiz$2(this, r28, r27, r30, r31, r65, r36, r66, r37, r32, r33, r34, r35));
        r65.element = K(r27, r28, r64, r30, r31.intValue(), r36);
        return;
    L350:
        r210 = null;
        goto L351
    L346:
        r112 = null;
        goto L348
    L341:
        if (r17.optInt("is_flash") != 1) goto L343;
        r111 = true;
        goto L344
    L352:
        if (r37 == null) goto L405;
        il2.a r67 = il2.a.C0145a.a(r37, "handle_action_biz", null, false, "click_enter_from_is_null", null, null, 48);
        if (r67 == null) goto L406;
        ((LiveActionTracker) r67).e(false);
        return;
    L406:
        return;
    L405:
        return;
    L331:
        r64 = null;
        goto L332
    L82:
        if (r19.equals("AUCTION_BID") == false) goto L255;
        if (r17 == 0) goto L85;
        String r68 = r17.optString("url");
    L86:
        if (r68 != null) goto L88;
        String r69 = "";
    L89:
        com.bytedance.android.livesdk.livecommerce.iron.helper.a r70 = com.bytedance.android.livesdk.livecommerce.iron.helper.a.a;
        Intrinsics.checkNotNullParameter(r28, "promotionParams");
        if (r37 == null) goto L93;
        il2.a.C0145a.a(r37, "open_bid_v2", null, false, null, null, null, 62);
    L93:
        if (r27 != null) goto L98;
        if (r37 == null) goto L389;
        il2.a r71 = il2.a.C0145a.a(r37, "open_bid_v2", null, false, "context_is_null", null, null, 48);
        if (r71 == null) goto L390;
        ((LiveActionTracker) r71).e(false);
        return;
    L390:
        return;
    L389:
        return;
    L98:
        LiveRoomParams r72 = r28.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        com.bytedance.android.ec.common.api.jump.model.f r73 = r28.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        if (r73 == null) goto L101;
        jf.b r74 = r73.c;
    L102:
        if (r72 == null) goto L104;
        Map<String, String> r75 = new sg2.v("", r72).g();
    L105:
        UrlBuilderV2 r76 = new UrlBuilderV2(r69);
        r76.addOrReplaceParam("from_type", "live");
        if (r72 == null) goto L108;
        String r77 = r72.getCreativeId();
    L109:
        if (r77 != null) goto L111;
        String r78 = r7;
    L112:
        r76.addOrReplaceParam("creative_id", r78);
        JSONObject r79 = new JSONObject();
        JSONObject r80 = new JSONObject();
        if (r75 == null) goto L118;
        Iterator<Map.Entry<String, String>> r81 = r75.entrySet().iterator();
    L116:
        if (r81.hasNext() == false) goto L118;
        Map.Entry<String, String> r82 = r81.next();
        r80.put(r82.getKey(), r82.getValue());
    L118:
        if (r74 == null) goto L120;
        String r83 = r74.a;
    L121:
        r80.put("ecom_entrance_form", r83);
        r80.put(r19, r28.a.getProductId());
        if (r72 == null) goto L126;
        Function0 r85 = r72.getScreenType();
        if (r85 == null) goto L126;
        String r86 = (String) r85.invoke();
    L127:
        if (r86 != null) goto L129;
        String r87 = r7;
    L130:
        r80.put("screen_type", r87);
        Unit r88 = Unit.INSTANCE;
        r79.put("ecom_live_lynx_log_data", r80);
        JSONObject r89 = new JSONObject();
        JSONObject r90 = new JSONObject();
        r90.put("product_id", r28.a.getProductId());
        r89.put("order_log_data", r90);
        JSONObject r91 = new JSONObject();
        if (r75 == null) goto L136;
        Iterator<Map.Entry<String, String>> r92 = r75.entrySet().iterator();
    L134:
        if (r92.hasNext() == false) goto L136;
        Map.Entry<String, String> r93 = r92.next();
        r91.put(r93.getKey(), r93.getValue());
    L136:
        Unit r94 = Unit.INSTANCE;
        r89.put("order_entrance_info", r91);
        r79.put("ecom_live_lynx_data", r89);
        r76.addOrReplaceParam("mega_object", r79.toString());
        BtmUtilsKt.c(r76, BtmUtilsKt.a(r36, r28.getChainParams()));
        String r95 = r76.build();
        Handler r96 = com.bytedance.android.livesdk.livecommerce.utils.k.a;
        com.bytedance.android.livesdk.livecommerce.room.f.b(r27, r95);
        if (r37 == null) goto L392;
        il2.a r97 = il2.a.C0145a.a(r37, "open_bid_v2", MapsKt.mapOf(TuplesKt.to("bid_schema", r95)), false, null, null, null, 60);
        if (r97 == null) goto L393;
        ((LiveActionTracker) r97).e(false);
        return;
    L393:
        return;
    L392:
        return;
    L129:
        r87 = r86;
    L126:
        r86 = null;
        goto L127
    L120:
        r83 = null;
        goto L121
    L111:
        r78 = r77;
        goto L112
    L108:
        r77 = null;
        goto L109
    L104:
        r75 = null;
        goto L105
    L101:
        r74 = null;
        goto L102
    L88:
        r69 = r68;
        goto L89
    L85:
        r68 = null;
    L255:
        r20 = null;
        goto L288
    L142:
        if (r19.equals("COMMENTARY_JUMP") == false) goto L255;
        if (r17 == 0) goto L145;
        String r98 = r17.optString("url");
    L146:
        if (r98 != null) goto L148;
        r98 = "";
    L148:
        final UrlBuilderV2 r99 = new UrlBuilderV2(r98);
        ql.a r100 = r28.a;
        com.bytedance.android.ec.common.api.jump.model.f r101 = r28.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        LiveRoomParams r102 = r28.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        if (r102 == null) goto L151;
        String r103 = r102.getRoomId();
    L152:
        if (r103 != null) goto L154;
        r103 = "";
    L154:
        r99.addOrReplaceParam("room_id", r103);
        if (r102 == null) goto L157;
        String r104 = r102.getSecAuthorId();
    L158:
        if (r104 != null) goto L160;
        r104 = "";
    L160:
        r99.addOrReplaceParam("sec_author_id", r104);
        if (r102 == null) goto L163;
        String r105 = r102.getFollowStatus();
    L164:
        if (r105 != null) goto L166;
        r105 = "";
    L166:
        r99.addOrReplaceParam("follow_status", r105);
        JSONObject r106 = r28.getEntranceInfo();
        jf.b.j r107 = jf.b.j.b;
        r106.put("carrier_type", "replay_popup_card");
        r106.put("ecom_group_type", "live");
        r99.addOrReplaceParam("entrance_info", r106.toString());
        Map r108 = r100.getEventParams();
        if (r108 == null) goto L176;
        Iterator r109 = r108.entrySet().iterator();
    L170:
        if (r109.hasNext() == false) goto L176;
        Map.Entry r114 = (Map.Entry) r109.next();
        if (TextUtils.isEmpty((CharSequence) r114.getKey()) == true) goto L170;
        if (TextUtils.isEmpty((CharSequence) r114.getValue()) == true) goto L170;
        r99.addOrReplaceParam((String) r114.getKey(), (String) r114.getValue());
    L176:
        if (r101 == null) goto L178;
        String r115 = r101.a;
    L179:
        if (r101 == null) goto L181;
        String r116 = r101.b;
    L182:
        UtilityKotlinExtentionsKt.f(r115, r116, new PromotionJumpDispatcher$handleActionBiz$4(r99));
        n(r27, r99.build(), r36, r28, r30, r37);
        return;
    L181:
        r116 = null;
        goto L182
    L178:
        r115 = null;
        goto L179
    L163:
        r105 = null;
        goto L164
    L157:
        r104 = null;
        goto L158
    L151:
        r103 = null;
        goto L152
    L145:
        r98 = null;
        goto L146
    L184:
        if (r19.equals("AUCTION_READY_PRODUCT_DETAIL") == false) goto L255;
        if (r17 == 0) goto L187;
        String r117 = r17.optString("path");
    L188:
        if (r117 != null) goto L191;
        r117 = "";
    L191:
        if (r17 == 0) goto L193;
        Long r118 = Long.valueOf(r17.optLong("report_type"));
    L195:
        if (r17 == 0) goto L197;
        Long r119 = Long.valueOf(r17.optLong("auction_id"));
    L199:
        if (r117.length() <= 0) goto L201;
        boolean r120 = true;
    L202:
        if (r120 == true) goto L205;
        r117 = null;
    L205:
        if (r117 == null) goto L254;
        if (r28 == null) goto L208;
        LiveRoomParams r121 = (LiveRoomParams) r28.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
    L209:
        if (r28 == null) goto L211;
        com.bytedance.android.ec.common.api.jump.model.g r122 = (com.bytedance.android.ec.common.api.jump.model.g) r28.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.g.class));
    L212:
        LinkedHashMap r123 = new LinkedHashMap();
        if (r118 == null) goto L215;
        String r124 = String.valueOf(r118.longValue());
    L216:
        if (r124 != null) goto L218;
        r124 = "";
    L218:
        r123.put("report_type", r124);
        if (r119 == null) goto L221;
        String r125 = String.valueOf(r119.longValue());
    L222:
        if (r125 != null) goto L224;
        r125 = "";
    L224:
        r123.put("auction_id", r125);
        if (r121 == null) goto L227;
        String r126 = r121.getRoomId();
    L228:
        if (r126 != null) goto L230;
        r126 = "";
    L230:
        r123.put("room_id", r126);
        if (r122 == null) goto L235;
        ql.a r127 = r122.a;
        if (r127 == null) goto L235;
        String r128 = r127.getProductId();
    L236:
        if (r128 != null) goto L238;
        String r129 = "";
    L239:
        r123.put("product_id", r129);
        if (r121 == null) goto L242;
        String r130 = r121.getAuthorId();
    L243:
        if (r130 != null) goto L245;
        String r131 = "";
    L246:
        if (r121 == null) goto L248;
        String r132 = r121.getSecAuthorId();
    L249:
        if (r132 != null) goto L251;
        String r133 = "";
    L252:
        bk2.c.a(vi2.h.e(null, null, r117, new vi2.v(r133, r131, r123, MapsKt.mapOf(TuplesKt.to("Agw-Js-Conv", "str")), r117)).subscribeOn(Schedulers.io()).subscribeOn(Schedulers.io()).subscribe(w.a, x.a), this.f);
        goto L254
    L251:
        r133 = r132;
        goto L252
    L248:
        r132 = null;
        goto L249
    L245:
        r131 = r130;
        goto L246
    L242:
        r130 = null;
        goto L243
    L238:
        r129 = r128;
    L235:
        r128 = null;
        goto L236
    L227:
        r126 = null;
        goto L228
    L221:
        r125 = null;
        goto L222
    L215:
        r124 = null;
        goto L216
    L211:
        r122 = null;
        goto L212
    L208:
        r121 = null;
    L254:
        jf.d.b.c(this, r27, r28, r30, ECDisplayUtils.c(r27), r36, r37);
        return;
    L201:
        r120 = false;
        goto L202
    L197:
        r119 = null;
        goto L199
    L193:
        r118 = null;
        goto L195
    L187:
        r117 = null;
        goto L188
    L74:
        r18 = 3;
    L12:
        dm.a.a("PromotionJumpDispatcher").w("handleAction understand actionType: " + r29.a(), null);
        if (r37 == null) goto L381;
        il2.a r134 = il2.a.C0145a.a(r37, "handle_action", null, false, "unsupported_action_type", null, null, 48);
        if (r134 == null) goto L382;
        ((LiveActionTracker) r134).e(false);
        return;
    L382:
        return;
    }

    public final void l(final Context r17, final String r18, final Integer r19, final com.bytedance.android.ec.common.api.jump.model.g r20, final j0 r21, final int r22, final int r23, final cf.a r24, final int r25, final com.bytedance.android.btm.api.model.d r26, final il2.a r27) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, "clickArea");
        Intrinsics.checkNotNullParameter(r20, "promotionParams");
        Intrinsics.checkNotNullParameter(r21, "action");
        int r0 = ECLiveLoginHelper.a;
        ECLiveLoginHelper.b(r17, r20, r27, new PromotionJumpDispatcher$handleClick$1(this, r27, r20, r18, r26, r17, r21, r19, r22, r23, r24, r25));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void D(PromotionJumpDispatcher r18, Context r19, com.bytedance.android.ec.common.api.jump.model.g r20, int r21, int r22, int r23, boolean r24, com.bytedance.android.btm.api.model.d r25, il2.a r26, Function1 r27, Function1 r28, int r29) {
        if ((r29 & 8) == 0) goto L5;
        int r7 = 0;
    L7:
        if ((r29 & 16) == 0) goto L9;
        int r8 = 0;
    L11:
        if ((r29 & 32) == 0) goto L13;
        boolean r9 = false;
    L15:
        if ((r29 & 64) == 0) goto L17;
        int r10 = -1;
    L19:
        if ((r29 & DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE) == 0) goto L21;
        com.bytedance.android.btm.api.model.d r13 = null;
    L23:
        if ((r29 & 2048) == 0) goto L25;
        il2.a r15 = null;
    L27:
        if ((r29 & 4096) == 0) goto L29;
        Function1 r16 = null;
    L30:
        r18.C(r19, r20, r21, r7, r8, r9, r10, null, false, r13, null, r15, r16, r28);
        return;
    L29:
        r16 = r27;
        goto L30
    L25:
        r15 = r26;
        goto L27
    L21:
        r13 = r25;
        goto L23
    L17:
        r10 = 0;
        goto L19
    L13:
        r9 = r24;
        goto L15
    L9:
        r8 = r23;
        goto L11
    L5:
        r7 = r22;
        goto L7
    }

    public static boolean H(PromotionJumpDispatcher r29, Context r30, String r31, String r32, int r33, IOrderSchema r34, com.bytedance.android.ec.common.api.jump.model.g r35, ECPromotionCheckResponse r36, com.bytedance.android.btm.api.model.d r37, View r38, Pair r39, sc3.b r40, il2.a r41, int r42) {
        if ((r42 & 16) == 0) goto L5;
        IOrderSchema r15 = null;
    L7:
        if ((r42 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) == 0) goto L9;
        com.bytedance.android.btm.api.model.d r10 = null;
    L11:
        if ((r42 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) == 0) goto L13;
        View r11 = null;
    L15:
        if ((r42 & DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE) == 0) goto L17;
        Pair r12 = null;
    L19:
        if ((r42 & DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION) == 0) goto L21;
        sc3.b r9 = null;
    L23:
        if ((r42 & 2048) == 0) goto L25;
        il2.a r24 = null;
    L26:
        r29.getClass();
        if (r36 == null) goto L29;
        sl.g r1 = r36.getDiffAction();
    L30:
        boolean r25 = false;
        if (r1 == null) goto L33;
        int r7 = 1;
    L34:
        if (r36 == null) goto L36;
        sl.g r2 = r36.getDiffAction();
    L37:
        if (r2 == null) goto L39;
        sl.g r3 = r36.getDiffAction();
    L41:
        sl.g r26 = r3;
    L43:
        pk2.b r4 = (pk2.b) r35.getParamsModel(Reflection.getOrCreateKotlinClass(pk2.b.class));
        rh2.b r5 = (rh2.b) r35.getParamsModel(Reflection.getOrCreateKotlinClass(rh2.b.class));
        if (r33 != 1) goto L48;
        String r0 = "list_card_buynow";
    L46:
        String r27 = r0;
        if (r24 != null) goto L57;
    L61:
        if (r26 == null) goto L63;
        Integer r6 = Integer.valueOf(r26.a());
    L65:
        if (r6 != null) goto L68;
    L77:
        if (r6 != null) goto L80;
    L90:
        int r13 = r7;
        sc3.b r14 = r9;
        IOrderSchema r310 = r15;
        boolean r16 = true;
        if (r6 != null) goto L94;
    L105:
        if (r24 == null) goto L107;
        il2.a r17 = r24;
        il2.a.C0145a.a(r17, "handle_trade_schema_action_result", MapsKt.mapOf(TuplesKt.to("is_consumed", String.valueOf(r25))), false, null, null, null, 60);
    L107:
        if (r26 != null) goto L109;
    L113:
        if (r36 == null) goto L115;
        sl.g r8 = r36.getAction();
    L116:
        E(r8, r310, null);
    L117:
        return r25;
    L115:
        r8 = null;
        goto L116
    L109:
        if (r26.a() != 6) goto L113;
        if (r310 == null) goto L113;
        if (r310.C() == r16) goto L117;
    L94:
        if (r6.intValue() != 6) goto L105;
        final r r18 = new r(r29, r30, r31, r13, r32, r36, r310, r35, r26, r10, r24, r14);
        if (r13 != 1) goto L99;
        UtilityKotlinExtentionsKt.i(new PromotionJumpDispatcher$handleTradeSchemaAction$3(r18));
        goto L105
    L99:
        if (r14 == null) goto L101;
        r14.c(ChainPoint.SKU_CHECK_END, Long.valueOf(System.currentTimeMillis()));
    L101:
        if (r14 == null) goto L103;
        r14.c(ChainPoint.PAGE_START, Long.valueOf(System.currentTimeMillis()));
    L103:
        il2.a r43 = r24;
        B(r29, r30, r35, r27, r43, new PromotionJumpDispatcher$handleTradeSchemaAction$4(r18));
    L104:
        r25 = true;
        goto L105
    L80:
        if (r6.intValue() != 5) goto L90;
        int r19 = r7;
        r310 = r15;
        r16 = true;
        com.bytedance.android.btm.api.model.d r20 = r10;
        sc3.b r110 = r9;
        final q r21 = new q(r29, r30, r31, r7, r32, r35, r26, r20, r24, r11, r12);
        if (r19 != 1) goto L85;
        UtilityKotlinExtentionsKt.i(new PromotionJumpDispatcher$handleTradeSchemaAction$1(r21));
        goto L105
    L85:
        if (r110 == null) goto L87;
        r110.c(ChainPoint.SKU_CHECK_END, Long.valueOf(System.currentTimeMillis()));
    L87:
        if (r110 == null) goto L89;
        r110.c(ChainPoint.PAGE_START, Long.valueOf(System.currentTimeMillis()));
    L89:
        il2.a r44 = r24;
        B(r29, r30, r35, r27, r44, new PromotionJumpDispatcher$handleTradeSchemaAction$2(r21));
        goto L104
    L68:
        if (r6.intValue() != 1) goto L77;
        sl.a r22 = r26.b();
        if (r22 == null) goto L72;
        String r23 = r22.a();
    L74:
        if (Intrinsics.areEqual(r23, "PRODUCT_DETAIL") == false) goto L76;
        jf.d.b.c(r29, r30, r35, r32, ECDisplayUtils.c(r30), r10, r24);
        r310 = r15;
        r16 = true;
        goto L104
    L76:
        r310 = r15;
        r16 = true;
        goto L105
    L72:
        r23 = null;
        goto L74
    L63:
        r6 = null;
        goto L65
    L57:
        if (r26 == null) goto L59;
        String r28 = String.valueOf(r26.a());
    L60:
        il2.a r111 = r24;
        il2.a.C0145a.a(r111, "handle_trade_schema_action", MapsKt.mapOf(TuplesKt.to("action_type", r28)), false, null, null, null, 60);
        goto L61
    L59:
        r28 = null;
        goto L60
    L48:
        if (r33 != 3) goto L50;
        r0 = "list_card_addcart";
        goto L46
    L50:
        if (r4 != null) goto L54;
        if (r5 != null) goto L54;
        r0 = "";
    L54:
        r0 = "popup_card_buynow";
        goto L46
    L39:
        if (r36 == null) goto L42;
        r3 = r36.getAction();
        goto L41
    L42:
        r26 = null;
        goto L43
    L36:
        r2 = null;
        goto L37
    L33:
        r7 = 0;
        goto L34
    L29:
        r1 = null;
        goto L30
    L25:
        r24 = r41;
        goto L26
    L21:
        r9 = r40;
        goto L23
    L17:
        r12 = r39;
        goto L19
    L13:
        r11 = r38;
        goto L15
    L9:
        r10 = r37;
        goto L11
    L5:
        r15 = r34;
        goto L7
    }

    public final void C(Context r39, com.bytedance.android.ec.common.api.jump.model.g r40, int r41, int r42, int r43, boolean r44, int r45, String r46, boolean r47, com.bytedance.android.btm.api.model.d r48, String r49, il2.a r50, Function1<? super Throwable, Unit> r51, Function1<? super ECPromotionCheckResponse, Unit> r52) {
        Map r0 = com.bytedance.android.ec.core.monitor.c.a;
        String r2 = com.bytedance.android.ec.core.monitor.c.c(MonitorScenes.EC_SKU_CHECK_API_DURATION, null);
        com.bytedance.android.ec.core.monitor.c.e(r2, "scene", "live");
        com.bytedance.android.ec.core.monitor.c.e(r2, LocationMonitorConst.TYPE, LocationInfoConst.SINGLE);
        com.bytedance.android.ec.core.monitor.c.e(r2, "path", "check/");
        com.bytedance.android.ec.core.monitor.c.h(r2, MetricNames.API_DURATION, null);
        ql.a r13 = r40.a;
        LiveRoomParams r14 = r40.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        com.bytedance.android.ec.common.api.jump.model.f r1 = r40.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        gi2.a r15 = (gi2.a) r40.getParamsModel(Reflection.getOrCreateKotlinClass(gi2.a.class));
        pk2.b r16 = (pk2.b) r40.getParamsModel(Reflection.getOrCreateKotlinClass(pk2.b.class));
        rh2.b r3 = (rh2.b) r40.getParamsModel(Reflection.getOrCreateKotlinClass(rh2.b.class));
        if (r1 == null) goto L5;
        jf.b r4 = r1.c;
    L6:
        if (r1 == null) goto L8;
        String r5 = r1.e;
    L9:
        if (r15 == null) goto L11;
        int r33 = 102;
    L19:
        ECEventUtilsV2 r6 = ECEventUtilsV2.b;
        if (r4 == null) goto L22;
        String r17 = r4.a;
    L23:
        if (r14 == null) goto L27;
        JSONObject r7 = r14.getEntranceInfo();
        if (r7 == null) goto L27;
        Map r18 = z1.j(r7);
    L28:
        if (r14 == null) goto L30;
        Map r8 = r14.getEcomLiveParamsEventParams();
    L31:
        if (r8 != null) goto L33;
        r8 = MapsKt.emptyMap();
    L33:
        Map r19 = r8;
        if (r15 == null) goto L36;
        String r20 = r15.b;
    L37:
        if (r15 == null) goto L39;
        String r21 = r15.c;
    L40:
        if (r14 == null) goto L42;
        String r22 = r14.getEcomSceneId();
    L43:
        r6.getClass();
        String r110 = ECEventUtilsV2.b(r17, r18, r19, r20, r21, r22);
        if (r16 != null) goto L46;
        if (r3 != null) goto L46;
    L48:
        if (r4 == null) goto L51;
        String r9 = r4.a;
    L50:
        String r10 = r9;
    L52:
        int r11 = F(r1, r13).a;
        if (r50 == null) goto L61;
        Pair[] r12 = new Pair[9];
        r12[0] = TuplesKt.to("promotion_id", r13.getPromotionId());
        r12[1] = TuplesKt.to("product_id", r13.getProductId());
        r12[2] = TuplesKt.to("status", String.valueOf(r13.getStatus()));
        r12[3] = TuplesKt.to("carrier_type", r10);
        r12[4] = TuplesKt.to("click_enter_from", String.valueOf(r41));
        r12[5] = TuplesKt.to("source_page", String.valueOf(r11));
        r12[6] = TuplesKt.to("force_path", r46);
        r12[7] = TuplesKt.to("request_scene", String.valueOf(r33));
        if (r16 != null) goto L57;
    L59:
        Object r23 = BDLocationException.ERROR_TIMEOUT;
    L60:
        r12[8] = TuplesKt.to("new_explain_card", r23);
        il2.a.C0145a.a(r50, "req_check_v2", MapsKt.mapOf(r12), false, null, null, null, 60);
        goto L61
    L57:
        if (ECLiveABUtils.INSTANCE.getENABLE_KMP_POP_CARD() == false) goto L59;
        r23 = "1";
    L61:
        CompositeDisposable r24 = CoreRequests.a;
        if (r14 == null) goto L64;
        String r25 = r14.getAuthorId();
    L65:
        if (r14 == null) goto L67;
        String r26 = r14.getSecAuthorId();
    L68:
        if (r14 == null) goto L70;
        String r27 = r14.getRoomId();
    L71:
        if (r14 == null) goto L73;
        String r28 = r14.getRoomUniqueKey();
    L74:
        if (r14 == null) goto L76;
        String r29 = r14.getDisplayRoomId();
    L77:
        String r210 = r13.getPromotionId();
        String r211 = r13.getProductId();
        int r212 = r13.getStatus();
        Integer r213 = Integer.valueOf(r41);
        String r410 = r28;
        String r411 = r27;
        String r30 = r10;
        c r31 = new c(this, r2, r50, r52, r40, r48, r39, r49, r51);
        bk2.d r32 = this.f;
        if (r15 == null) goto L86;
        if (r14 == null) goto L81;
        String r34 = r14.getRoomId();
    L82:
        if (r14 == null) goto L84;
        String r35 = r14.getRoomUniqueKey();
    L85:
        int r37 = com.bytedance.android.livesdk.livecommerce.promotionlist.base.c.a(r34, r35);
    L87:
        int r36 = this.c;
        String r38 = r13.getCheckCallback();
        if (r16 != null) goto L90;
    L92:
        Object r53 = BDLocationException.ERROR_TIMEOUT;
    L93:
        Map r310 = MapsKt.mapOf(TuplesKt.to("use_card_v2", r53));
        if (r110 != null) goto L96;
        String r54 = ECEventUtilsV2.e(r30);
    L97:
        if (r213 == null) goto L99;
        int r55 = r213.intValue();
    L100:
        String r56 = vi2.h.a;
        if (TextUtils.isEmpty(r46) == false) goto L103;
        String r57 = si2.g.E;
    L104:
        dm.a.a("ECNetwrokAPI").i("checkPromotion path: " + r57);
        Disposable r58 = vi2.h.e(r411, r410, r57, new vi2.w(r210, r211, r212, r411, r410, r29, r25, r26, r54, r43, r11, r55, r47, r38, r36, r33, r42, r57, r310, r37)).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.livecommerce.room.controller.f(r31), new com.bytedance.android.livesdk.livecommerce.room.controller.g(r31));
        if (r32 == null) goto L108;
        r32.add(r58);
        return;
    L108:
        return;
    L103:
        r57 = si2.g.a + r46;
        goto L104
    L99:
        r55 = 0;
        goto L100
    L96:
        r54 = r110;
        goto L97
    L90:
        if (ECLiveABUtils.INSTANCE.getENABLE_KMP_POP_CARD() == false) goto L92;
        r53 = "1";
        goto L93
    L84:
        r35 = null;
        goto L85
    L81:
        r34 = null;
        goto L82
    L86:
        r37 = 73;
        goto L87
    L76:
        r29 = null;
        goto L77
    L73:
        r28 = null;
        goto L74
    L70:
        r27 = null;
        goto L71
    L67:
        r26 = null;
        goto L68
    L64:
        r25 = null;
        goto L65
    L51:
        r10 = null;
    L46:
        if (r44 == false) goto L48;
        int r59 = jf.b.a.b;
        r9 = "buynow_all";
        goto L50
    L42:
        r22 = null;
        goto L43
    L39:
        r21 = null;
        goto L40
    L36:
        r20 = null;
        goto L37
    L30:
        r8 = null;
    L27:
        r18 = null;
        goto L28
    L22:
        r17 = null;
        goto L23
    L11:
        if (r16 != null) goto L18;
        if (r3 != null) goto L18;
        if (Intrinsics.areEqual(r5, "schema") == false) goto L17;
        r33 = 103;
        goto L19
    L17:
        r33 = r45;
    L18:
        r33 = 101;
        goto L19
    L8:
        r5 = null;
        goto L9
    L5:
        r4 = null;
        goto L6
    }
}
