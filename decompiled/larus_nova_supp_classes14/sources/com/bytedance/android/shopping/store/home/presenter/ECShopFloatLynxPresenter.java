package com.bytedance.android.shopping.store.home.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.hybrid.card.api.ECLynxLoadParam;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.list.util.CommonUtilKt;
import com.bytedance.android.ec.store.db.StoreDatabase;
import com.bytedance.android.ec.store.floatlayout.StoreFloatLayout;
import com.bytedance.android.ec.store.repository.vo.ContainerType;
import com.bytedance.android.ec.store.utils.taskmanager.ECTaskManager;
import com.bytedance.android.ec.store.utils.taskmanager.TaskPriority;
import com.bytedance.android.marketing.sdk.api.ECMarketingSDK;
import com.bytedance.android.marketing.sdk.api.IMarketingServiceV2;
import com.bytedance.android.shopping.store.arch.ECStoreFoldPhoneHelper;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.verse.api.IVerseService;
import com.bytedance.android.shopping.yata.business.function.ScrollPosition;
import com.bytedance.applet.debugger.DebuggerSessionViewModel;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentConstants$CmtLongPanelStrategy;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.JsonObject;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import io.reactivex.Observable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000bJ\b\u0010\u0004\u001a\u00020\u0003H\u0007J\b\u0010\u0005\u001a\u00020\u0003H\u0007J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\b\u0010\t\u001a\u00020\u0003H\u0007J\b\u0010\n\u001a\u00020\u0003H\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/store/home/presenter/ECShopFloatLynxPresenter;", "Lcom/bytedance/android/shopping/store/home/presenter/ECShopBasePresenter;", "Landroidx/lifecycle/LifecycleObserver;", "", "unregisterJsv", "registerJsb", "Lcom/bytedance/android/ec/store/view/t;", "event", "onShopMarqueeEnd", "sendPageVisibleEvent", "sendPageInVisibleEvent", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopFloatLynxPresenter extends ECShopBasePresenter implements LifecycleObserver {
    public static final /* synthetic */ int K = 0;
    public int A;
    public boolean B;
    public String C;
    public String D;
    public View E;
    public boolean F;
    public com.bytedance.android.shopping.store.home.entity.l G;
    public final Map<com.bytedance.android.shopping.store.home.entity.l, Boolean> H;
    public final ECShopFloatLynxPresenter$jsShowFloatLynxLayerEventSubscriber$1 I;
    public final b J;
    public final List<String> u;
    public View v;
    public boolean w;
    public FrameLayout x;
    public ECLynxCard y;
    public boolean z;

    public static final class a {
    }

    public static final class b implements ti.j {
        public final /* synthetic */ ECShopFloatLynxPresenter a;

        public b(ECShopFloatLynxPresenter r1) {
            this.a = r1;
        }

        public final void a(JSONObject r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            if (Intrinsics.areEqual(String.valueOf(r2.optInt("shopId")), this.a.T().getStoreParam().getShopId()) == false) goto L8;
            ECShopFloatLynxPresenter r3 = this.a;
            if (r3.B == false) goto L9;
            r3.T().setActivitySceneFroRedPack("leave_shop_red_pack");
            this.a.T().fetchActivityData(this.a.T().getActivitySceneFroRedPack());
            return;
        L9:
            return;
        }
    }

    public static final class c implements com.bytedance.android.marketing.sdk.api.a {
        public c() {
        }

        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
        }

        public final void b(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "rit");
            Intrinsics.checkNotNullParameter(r3, "component");
        }

        public final void onLoadSuccess(View r2) {
            Intrinsics.checkNotNullParameter(r2, "lynxView");
            ECStoreFoldPhoneHelper.i(r2);
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ ECShopFloatLynxPresenter a;

        public d(ECShopFloatLynxPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            com.bytedance.android.ec.store.repository.vo.i r4 = (com.bytedance.android.ec.store.repository.vo.i) r3;
            if (r4 == null) goto L7;
            ECShopFloatLynxPresenter r0 = this.a;
            int r1 = ECShopFloatLynxPresenter.K;
            r0.z0(r4, null, null);
            return;
        }
    }

    static {
    }

    public ECShopFloatLynxPresenter() {
        this(null);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void registerJsb() {
        ECLiveHybridUtil.m("ecom.store.create_float_lynx_container", this.I);
        ECLiveHybridUtil.m("ecom.store.close_store_redpack", this.J);
        com.bytedance.android.ec.core.utils.s0.c(this);
        this.F = true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void sendPageInVisibleEvent() {
        ECLynxCard r0 = this.y;
        if (r0 == null) goto L6;
        IVerseService r3 = ECLynxCard.f;
        ECLynxCard.m(r0, false, "page", ECLynxCard.a.a(false, false), false, false, false, 0, 248);
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void sendPageVisibleEvent() {
        ECLynxCard r0 = this.y;
        if (r0 == null) goto L5;
        IVerseService r3 = ECLynxCard.f;
        ECLynxCard.m(r0, true, "page", ECLynxCard.a.a(false, false), false, false, false, 0, 248);
    L5:
        this.F = true;
        com.bytedance.android.shopping.store.home.entity.l r1 = this.G;
        if (r1 == null) goto L8;
        y0(r1);
    L8:
        this.G = null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void unregisterJsv() {
        ECLiveHybridUtil.p("ecom.store.create_float_lynx_container", this.I);
        ECLiveHybridUtil.p("ecom.store.close_store_redpack", this.J);
        com.bytedance.android.ec.core.utils.s0.e(this);
        this.F = false;
    }

    public final void C() {
        W().getLifecycle().removeObserver(this);
    }

    public ECShopFloatLynxPresenter(Fragment r1) {
        super(r1);
        this.u = new ArrayList();
        this.z = true;
        this.H = new LinkedHashMap();
        this.I = new ECShopFloatLynxPresenter$jsShowFloatLynxLayerEventSubscriber$1(this);
        this.J = new b(this);
    }

    public static final void s0(ECShopFloatLynxPresenter r14) {
        if (r14.w == false) goto L5;
        return;
    L5:
        if (r14.V() == false) goto L123;
        com.bytedance.android.shopping.store.home.entity.l r0 = (com.bytedance.android.shopping.store.home.entity.l) r14.T().getFloatArea().getValue();
        if (r0 == null) goto L121;
        List<com.bytedance.android.ec.store.repository.vo.i> r1 = r0.a;
        if (r1 == null) goto L122;
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L12:
        boolean r4 = false;
        if (r3.hasNext() == false) goto L19;
        Object r5 = r3.next();
        if (((com.bytedance.android.ec.store.repository.vo.i) r5).b() != 1) goto L17;
        r4 = true;
    L17:
        if (r4 == false) goto L12;
        r2.add(r5);
        goto L12
    L19:
        Iterator r6 = r2.iterator();
    L21:
        if (r6.hasNext() == false) goto L124;
        com.bytedance.android.ec.store.repository.vo.i r11 = (com.bytedance.android.ec.store.repository.vo.i) r6.next();
        if (r14.T().getStoreParam().isPreview() == false) goto L25;
        r14.w0(r11);
    L100:
        r14.w = true;
        goto L21
    L25:
        List r7 = r11.g();
        String r8 = null;
        if (r7 == null) goto L41;
        Iterator r9 = r7.iterator();
    L29:
        if (r9.hasNext() == false) goto L39;
        Object r10 = r9.next();
        Integer r12 = ((com.bytedance.android.ec.store.repository.dto.f) r10).a();
        if (r12 != null) goto L34;
    L36:
        boolean r13 = false;
    L37:
        if (r13 == false) goto L29;
    L40:
        com.bytedance.android.ec.store.repository.dto.f r15 = (com.bytedance.android.ec.store.repository.dto.f) r10;
    L42:
        List r16 = r11.g();
        if (r16 == null) goto L58;
        Iterator r17 = r16.iterator();
    L46:
        if (r17.hasNext() == false) goto L56;
        Object r18 = r17.next();
        Integer r19 = ((com.bytedance.android.ec.store.repository.dto.f) r18).a();
        if (r19 != null) goto L51;
    L53:
        boolean r20 = false;
    L54:
        if (r20 == false) goto L46;
    L57:
        com.bytedance.android.ec.store.repository.dto.f r110 = (com.bytedance.android.ec.store.repository.dto.f) r18;
    L59:
        if (r15 != null) goto L62;
        if (r110 != null) goto L62;
        r14.w0(r11);
    L62:
        String r21 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        if (r15 == null) goto L65;
        Integer r22 = r15.c();
    L67:
        if (r22 != null) goto L70;
    L72:
        String r111 = r21;
    L73:
        if (r110 == null) goto L75;
        Integer r23 = r110.c();
    L76:
        if (r23 != null) goto L79;
    L81:
        String r112 = r21;
    L82:
        if (r15 == null) goto L84;
        String r24 = r15.d();
    L85:
        Intrinsics.checkNotNullParameter("store", CommentConstants$CmtLongPanelStrategy.DEFAULT);
        if (r24 != null) goto L88;
        String r25 = "store";
    L89:
        if (r110 == null) goto L91;
        r8 = r110.d();
    L91:
        Intrinsics.checkNotNullParameter("store", CommentConstants$CmtLongPanelStrategy.DEFAULT);
        if (r8 != null) goto L94;
        String r26 = "store";
    L95:
        om.g r27 = om.g.a;
        String r28 = r11.f();
        String r29 = com.bytedance.android.ec.sdk.helper.r.a.f();
        Intrinsics.checkNotNullParameter(r28, "componentName");
        Intrinsics.checkNotNullParameter(r29, "userId");
        Intrinsics.checkNotNullParameter(r111, "time");
        StoreDatabase r30 = lm.a.b.a();
        if (r30 == null) goto L98;
        Observable r31 = Observable.create(new om.e(r30, r28, r29, r111));
    L99:
        r14.T().add(bg4.b.b(r31).subscribe(new e0(r14, r25, r26, r15, r110, r11, r111, r112)));
        goto L100
    L98:
        r31 = Observable.just(CollectionsKt.emptyList());
        goto L99
    L94:
        r26 = r8;
        goto L95
    L88:
        r25 = r24;
        goto L89
    L84:
        r24 = null;
        goto L85
    L79:
        if (r23.intValue() != 0) goto L81;
        r112 = "all";
        goto L82
    L75:
        r23 = null;
        goto L76
    L70:
        if (r22.intValue() != 0) goto L72;
        r111 = "all";
        goto L73
    L65:
        r22 = null;
        goto L67
    L51:
        if (r19.intValue() != 1) goto L53;
        r20 = true;
        goto L54
    L56:
        r18 = null;
        goto L57
    L58:
        r110 = null;
        goto L59
    L34:
        if (r12.intValue() != 0) goto L36;
        r13 = true;
        goto L37
    L39:
        r10 = null;
        goto L40
    L41:
        r15 = null;
        goto L42
    L124:
        return;
    L122:
        return;
    L121:
        return;
    }

    public static final void t0(ECShopFloatLynxPresenter r8) {
        com.bytedance.android.shopping.store.home.entity.l r0 = (com.bytedance.android.shopping.store.home.entity.l) r8.T().getFloatArea().getValue();
        if (r0 == null) goto L7;
        List<com.bytedance.android.ec.store.repository.vo.i> r1 = r0.a;
        if (r1 == null) goto L7;
        r8.z = r1.isEmpty();
    L7:
        com.bytedance.android.shopping.store.home.entity.l r2 = (com.bytedance.android.shopping.store.home.entity.l) r8.T().getFloatArea().getValue();
        if (r2 == null) goto L27;
        Map<String, String> r3 = r2.c;
        if (r3 == null) goto L28;
        String r4 = r3.get("aweme_lite_gold_coin");
        if (r4 == null) goto L29;
        FrameLayout r5 = new FrameLayout(r8.u().c());
        r5.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        LinkedHashMap r6 = new LinkedHashMap();
        com.bytedance.geckox.b r7 = com.bytedance.geckox.b.a.a;
        if (com.bytedance.geckox.b.a().getEnv() != GeckoGlobalConfig.ENVType.PROD) goto L16;
        int r9 = 1;
    L17:
        r6.put("gecko_env_online", Integer.valueOf(r9));
        JSONObject r10 = new JSONObject();
        r10.put("store_type", "shop");
        r10.put("author_id", r8.T().getStoreParam().getStoreAccountParam().getUserId());
        r10.put("shop_id", r8.T().getStoreParam().getShopId());
        r10.put("follow_status", r8.T().getStoreParam().getFollowStatus());
        Activity r11 = com.bytedance.android.ec.core.utils.l0.b(r8.u().c());
        if (r11 == null) goto L20;
        String r12 = hm.c.e(r11);
    L21:
        r10.put("entrance_info", r12);
        String r13 = UriProtector.parse(r4).buildUpon().appendQueryParameter("event_params", r10.toString()).build().toString();
        FrameLayout r14 = r8.x;
        if (r14 == null) goto L30;
        r14.addView(r5);
        r8.y = new ECLynxCard();
        ECLynxLoadParam.a r15 = new ECLynxLoadParam.a(r8.u().c(), r13, r5);
        r15.a(CommonUtilKt.a(r4));
        Intrinsics.checkNotNullParameter(r6, "ecGlobalProps");
        r15.p = r6;
        r15.q = null;
        k0 r16 = new k0(r8, r5, r6);
        Intrinsics.checkNotNullParameter(r16, "lifecycle");
        r15.o = r16;
        r15.j(DebuggerSessionViewModel.MODE_SWITCH_TIMEOUT_MS);
        ViewGroup.LayoutParams r17 = new ViewGroup.LayoutParams(-1, -1);
        Intrinsics.checkNotNullParameter(r17, "ecLayoutParams");
        r15.u = r17;
        r15.h(r8.T().getSceneId());
        ECLynxCard r18 = r8.y;
        if (r18 == null) goto L31;
        r18.j(new ECLynxLoadParam(r15));
        return;
    L31:
        return;
    L30:
        return;
    L20:
        r12 = null;
        goto L21
    L16:
        r9 = 0;
        goto L17
    L29:
        return;
    L28:
        return;
    }

    public final void A(QModel r8) {
        Fragment r9 = this.h;
        Object r0 = null;
        if (r9 == null) goto L7;
        View r10 = r9.getView();
        if (r10 == null) goto L7;
        FrameLayout r11 = (FrameLayout) r10.findViewById(2131371126);
    L8:
        this.x = r11;
        String r12 = T().getStoreParam().getMarketInfo();
        if (r12 != null) goto L11;
    L23:
        this.E = o0().findViewById(2131371161);
        T().getCurrentTabLiveData().a(W(), new f0(this), false);
        T().isProductListAllShowCrossShop().a(W(), new g0(this), false);
        T().getFloatArea().a(W(), new h0(this), false);
        T().getCroppedState().a(W(), new i0(this), false);
        T().getScrollState().a(W(), new j0(this), false);
        ConcurrentHashMap<String, Object> r13 = ECShopABSettings.a;
        Object r14 = 0;
        if (Intrinsics.areEqual("ec_shop_top_card", "ec_shop_launch_opt_common_2") == false) goto L200;
        if (ECShopABSettings.b != null) goto L194;
        int r4 = com.bytedance.android.ec.core.opt.ab.n.a;
        int r5 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L184
        Object r7 = com.bytedance.android.ec.base.settings.d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L78
        if (r7 != null) goto L33;
    L75:
        Object r15 = null;
    L76:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L78
    L80:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L184
        if (r17 == null) goto L84;
        EnsureManager.ensureNotReachHere(r17);     // Catch: Throwable -> L184
    L84:
        if (Result.isFailure-impl(r16) == false) goto L87;
        r16 = null;
    L87:
        if ((r16 instanceof Integer) == true) goto L89;
        r16 = null;
    L89:
        Object r18 = (Integer) r16;     // Catch: Throwable -> L184
        if (r18 != null) goto L96;
        Object r19 = com.bytedance.android.ec.base.settings.d.a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L184
        if ((r19 instanceof Integer) == true) goto L95;
        r19 = null;
    L95:
        r18 = (Integer) r19;     // Catch: Throwable -> L184
    L96:
        if (r18 != null) goto L193;
        int r20 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L184
        Object r21 = com.bytedance.android.ec.base.settings.d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L148
        if (r21 != null) goto L103;
    L145:
        Object r22 = null;
    L146:
        Object r23 = Result.constructor-impl(r22);     // Catch: Throwable -> L148
    L150:
        Throwable r24 = Result.exceptionOrNull-impl(r23);     // Catch: Throwable -> L174
        if (r24 == null) goto L154;
        EnsureManager.ensureNotReachHere(r24);     // Catch: Throwable -> L174
    L154:
        if (Result.isFailure-impl(r23) == false) goto L157;
        r23 = null;
    L157:
        if ((r23 instanceof Integer) == true) goto L159;
        r23 = null;
    L159:
        r18 = (Integer) r23;     // Catch: Throwable -> L174
        if (r18 != null) goto L182;
        IHybridHostService r25 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L174
        if (r25 == null) goto L165;
        Object r26 = r25.getHostABValue("ec_shop_launch_opt_common_2", r14);     // Catch: Throwable -> L174
    L166:
        if (r26 != null) goto L168;
    L180:
        r18 = r14;
        goto L182
    L168:
        if ((r26 instanceof Integer) == false) goto L171;
        r0 = r26;
    L171:
        Object r1 = (Integer) r0;     // Catch: Throwable -> L174
        if (r1 == null) goto L180;
    L181:
        r18 = r1;
        goto L182
    L174:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L184
        r1 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L184
        Throwable r28 = Result.exceptionOrNull-impl(r1);     // Catch: Throwable -> L184
        if (r28 == null) goto L179;
        EnsureManager.ensureNotReachHere(r28);     // Catch: Throwable -> L184
    L179:
        if (Result.isFailure-impl(r1) == false) goto L181;
    L165:
        r26 = null;
    L182:
        com.bytedance.android.ec.base.settings.d.d("ec_shop_launch_opt_common_2", r18);     // Catch: Throwable -> L184
        goto L193
    L103:
        if ((r21 instanceof Integer) == true) goto L105;
        Object r29 = null;
    L106:
        r22 = (Integer) r29;     // Catch: Throwable -> L148
        if (r22 != null) goto L146;
        if ((r21 instanceof Number) == false) goto L133;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L118;
        Float r30 = Float.valueOf(((Number) r21).floatValue());     // Catch: Throwable -> L148
        if ((r30 instanceof Integer) == true) goto L116;
        r30 = null;
    L116:
        r22 = (Integer) r30;     // Catch: Throwable -> L148
        goto L146
    L118:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L124;
        Double r31 = Double.valueOf(((Number) r21).doubleValue());     // Catch: Throwable -> L148
        if ((r31 instanceof Integer) == true) goto L122;
        r31 = null;
    L122:
        r22 = (Integer) r31;     // Catch: Throwable -> L148
        goto L146
    L124:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L127;
        r22 = Integer.valueOf(((Number) r21).intValue());     // Catch: Throwable -> L148
        goto L146
    L127:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L133;
        Long r32 = Long.valueOf(((Number) r21).longValue());     // Catch: Throwable -> L148
        if ((r32 instanceof Integer) == true) goto L131;
        r32 = null;
    L131:
        r22 = (Integer) r32;     // Catch: Throwable -> L148
    L133:
        if ((r21 instanceof JSONObject) == false) goto L135;
    L386:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L141
        Object r33 = SDKSettingsCacheManager.a().fromJson(r21.toString(), Integer.class);     // Catch: Throwable -> L141
        if ((r33 instanceof Integer) == true) goto L139;
        r33 = null;
    L139:
        Object r34 = Result.constructor-impl((Integer) r33);     // Catch: Throwable -> L141
    L143:
        r22 = r34;
        if (Result.isFailure-impl(r22) == false) goto L146;
    L141:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L148
        r34 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L148
        goto L143
    L135:
        if ((r21 instanceof JSONArray) == false) goto L145;
    L105:
        r29 = r21;
    L148:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L174
        r23 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L193:
        ECShopABSettings.b = (Integer) r18;
        goto L194
    L33:
        if ((r7 instanceof Integer) == true) goto L35;
        Object r37 = null;
    L36:
        r15 = (Integer) r37;     // Catch: Throwable -> L78
        if (r15 != null) goto L76;
        if ((r7 instanceof Number) == false) goto L63;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L48;
        Float r38 = Float.valueOf(((Number) r7).floatValue());     // Catch: Throwable -> L78
        if ((r38 instanceof Integer) == true) goto L46;
        r38 = null;
    L46:
        r15 = (Integer) r38;     // Catch: Throwable -> L78
        goto L76
    L48:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L54;
        Double r39 = Double.valueOf(((Number) r7).doubleValue());     // Catch: Throwable -> L78
        if ((r39 instanceof Integer) == true) goto L52;
        r39 = null;
    L52:
        r15 = (Integer) r39;     // Catch: Throwable -> L78
        goto L76
    L54:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L57;
        r15 = Integer.valueOf(((Number) r7).intValue());     // Catch: Throwable -> L78
        goto L76
    L57:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L63;
        Long r40 = Long.valueOf(((Number) r7).longValue());     // Catch: Throwable -> L78
        if ((r40 instanceof Integer) == true) goto L61;
        r40 = null;
    L61:
        r15 = (Integer) r40;     // Catch: Throwable -> L78
    L63:
        if ((r7 instanceof JSONObject) == false) goto L65;
    L384:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L71
        Object r41 = SDKSettingsCacheManager.a().fromJson(r7.toString(), Integer.class);     // Catch: Throwable -> L71
        if ((r41 instanceof Integer) == true) goto L69;
        r41 = null;
    L69:
        Object r42 = Result.constructor-impl((Integer) r41);     // Catch: Throwable -> L71
    L73:
        r15 = r42;
        if (Result.isFailure-impl(r15) == false) goto L76;
    L71:
        th = move-exception;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L78
        r42 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L78
        goto L73
    L65:
        if ((r7 instanceof JSONArray) == false) goto L75;
    L35:
        r37 = r7;
    L78:
        th = move-exception;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L184
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L184
    L184:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Object r2 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r45 = Result.exceptionOrNull-impl(r2);
        if (r45 == null) goto L189;
        EnsureManager.ensureNotReachHere(r45);
    L189:
        if (Result.isFailure-impl(r2) == true) goto L192;
        r14 = r2;
    L192:
        r18 = r14;
    L194:
        r14 = ECShopABSettings.b;
        if (r14 == null) goto L198;
    L373:
        ECShopABSettings.a.put("ec_shop_top_card", r14);
        if (((Number) r14).intValue() <= 0) goto L376;
        Lazy r46 = ECTaskManager.b;
        ECTaskManager.a.a().a(T().getStoreParam().getLifecycleMonitorId(), TaskPriority.AFTER_FIRST_SCREEN, new ECShopFloatLynxPresenter$initFloatLayout$6(this));
    L376:
        T().getMarketFloatVO().a(W(), new d(this), false);
        W().getLifecycle().addObserver(this);
        return;
    L198:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L200:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L211;
        int r47 = com.bytedance.android.ec.core.opt.ab.p.a;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L206
        jj4.b r49 = jj4.b.b;     // Catch: Throwable -> L206
        Object r50 = jj4.a.a("ec_shop_top_card", Integer.class, r14, false);     // Catch: Throwable -> L206
        if (r50 != null) goto L210;
        Intrinsics.throwNpe();     // Catch: Throwable -> L206
    L210:
        r14 = r50;
    L206:
        th = move-exception;
        Result.Companion r51 = Result.Companion;
        r50 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r50) == false) goto L210;
    L211:
        int r52 = com.bytedance.android.ec.core.opt.ab.n.a;
        int r53 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r54 = Result.Companion;     // Catch: Throwable -> L367
        Object r55 = com.bytedance.android.ec.base.settings.d.c.get("ec_shop_top_card");     // Catch: Throwable -> L262
        if (r55 != null) goto L217;
    L259:
        Object r56 = null;
    L260:
        Object r57 = Result.constructor-impl(r56);     // Catch: Throwable -> L262
    L264:
        Throwable r58 = Result.exceptionOrNull-impl(r57);     // Catch: Throwable -> L367
        if (r58 == null) goto L268;
        EnsureManager.ensureNotReachHere(r58);     // Catch: Throwable -> L367
    L268:
        if (Result.isFailure-impl(r57) == false) goto L271;
        r57 = null;
    L271:
        if ((r57 instanceof Integer) == true) goto L273;
        r57 = null;
    L273:
        Object r59 = (Integer) r57;     // Catch: Throwable -> L367
        if (r59 != null) goto L280;
        Object r60 = com.bytedance.android.ec.base.settings.d.a.get("ec_shop_top_card");     // Catch: Throwable -> L367
        if ((r60 instanceof Integer) == true) goto L279;
        r60 = null;
    L279:
        r59 = (Integer) r60;     // Catch: Throwable -> L367
    L280:
        if (r59 == null) goto L282;
    L281:
        r14 = r59;
        goto L373
    L282:
        int r61 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L367
        Object r62 = com.bytedance.android.ec.base.settings.d.c.get("ec_shop_top_card");     // Catch: Throwable -> L332
        if (r62 != null) goto L287;
    L329:
        Object r63 = null;
    L330:
        Object r64 = Result.constructor-impl(r63);     // Catch: Throwable -> L332
    L334:
        Throwable r65 = Result.exceptionOrNull-impl(r64);     // Catch: Throwable -> L358
        if (r65 == null) goto L338;
        EnsureManager.ensureNotReachHere(r65);     // Catch: Throwable -> L358
    L338:
        if (Result.isFailure-impl(r64) == false) goto L341;
        r64 = null;
    L341:
        if ((r64 instanceof Integer) == true) goto L343;
        r64 = null;
    L343:
        r59 = (Integer) r64;     // Catch: Throwable -> L358
        if (r59 != null) goto L365;
        IHybridHostService r66 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L358
        if (r66 == null) goto L349;
        Object r67 = r66.getHostABValue("ec_shop_top_card", r14);     // Catch: Throwable -> L358
    L350:
        if (r67 != null) goto L352;
    L364:
        r59 = r14;
        goto L365
    L352:
        if ((r67 instanceof Integer) == false) goto L355;
        r0 = r67;
    L355:
        r59 = (Integer) r0;     // Catch: Throwable -> L358
        if (r59 != null) goto L365;
    L349:
        r67 = null;
    L365:
        com.bytedance.android.ec.base.settings.d.d("ec_shop_top_card", r59);     // Catch: Throwable -> L367
        goto L281
    L287:
        if ((r62 instanceof Integer) == true) goto L289;
        Object r68 = null;
    L290:
        r63 = (Integer) r68;     // Catch: Throwable -> L332
        if (r63 != null) goto L330;
        if ((r62 instanceof Number) == false) goto L317;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L302;
        Float r69 = Float.valueOf(((Number) r62).floatValue());     // Catch: Throwable -> L332
        if ((r69 instanceof Integer) == true) goto L300;
        r69 = null;
    L300:
        r63 = (Integer) r69;     // Catch: Throwable -> L332
        goto L330
    L302:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L308;
        Double r70 = Double.valueOf(((Number) r62).doubleValue());     // Catch: Throwable -> L332
        if ((r70 instanceof Integer) == true) goto L306;
        r70 = null;
    L306:
        r63 = (Integer) r70;     // Catch: Throwable -> L332
        goto L330
    L308:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L311;
        r63 = Integer.valueOf(((Number) r62).intValue());     // Catch: Throwable -> L332
        goto L330
    L311:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L317;
        Long r71 = Long.valueOf(((Number) r62).longValue());     // Catch: Throwable -> L332
        if ((r71 instanceof Integer) == true) goto L315;
        r71 = null;
    L315:
        r63 = (Integer) r71;     // Catch: Throwable -> L332
    L317:
        if ((r62 instanceof JSONObject) == false) goto L319;
    L399:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L325
        Object r72 = SDKSettingsCacheManager.a().fromJson(r62.toString(), Integer.class);     // Catch: Throwable -> L325
        if ((r72 instanceof Integer) == true) goto L323;
        r72 = null;
    L323:
        Object r73 = Result.constructor-impl((Integer) r72);     // Catch: Throwable -> L325
    L327:
        r63 = r73;
        if (Result.isFailure-impl(r63) == false) goto L330;
    L325:
        th = move-exception;
        Result.Companion r74 = Result.Companion;     // Catch: Throwable -> L332
        r73 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L332
        goto L327
    L319:
        if ((r62 instanceof JSONArray) == false) goto L329;
    L289:
        r68 = r62;
    L358:
        th = move-exception;
        Result.Companion r75 = Result.Companion;     // Catch: Throwable -> L367
        r59 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L367
        Throwable r76 = Result.exceptionOrNull-impl(r59);     // Catch: Throwable -> L367
        if (r76 == null) goto L363;
        EnsureManager.ensureNotReachHere(r76);     // Catch: Throwable -> L367
    L363:
        if (Result.isFailure-impl(r59) == false) goto L365;
    L332:
        th = move-exception;
        Result.Companion r77 = Result.Companion;     // Catch: Throwable -> L358
        r64 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L358
        goto L334
    L217:
        if ((r55 instanceof Integer) == true) goto L219;
        Object r78 = null;
    L220:
        r56 = (Integer) r78;     // Catch: Throwable -> L262
        if (r56 != null) goto L260;
        if ((r55 instanceof Number) == false) goto L247;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L232;
        Float r79 = Float.valueOf(((Number) r55).floatValue());     // Catch: Throwable -> L262
        if ((r79 instanceof Integer) == true) goto L230;
        r79 = null;
    L230:
        r56 = (Integer) r79;     // Catch: Throwable -> L262
        goto L260
    L232:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L238;
        Double r80 = Double.valueOf(((Number) r55).doubleValue());     // Catch: Throwable -> L262
        if ((r80 instanceof Integer) == true) goto L236;
        r80 = null;
    L236:
        r56 = (Integer) r80;     // Catch: Throwable -> L262
        goto L260
    L238:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L241;
        r56 = Integer.valueOf(((Number) r55).intValue());     // Catch: Throwable -> L262
        goto L260
    L241:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L247;
        Long r81 = Long.valueOf(((Number) r55).longValue());     // Catch: Throwable -> L262
        if ((r81 instanceof Integer) == true) goto L245;
        r81 = null;
    L245:
        r56 = (Integer) r81;     // Catch: Throwable -> L262
    L247:
        if ((r55 instanceof JSONObject) == false) goto L249;
    L397:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L255
        Object r82 = SDKSettingsCacheManager.a().fromJson(r55.toString(), Integer.class);     // Catch: Throwable -> L255
        if ((r82 instanceof Integer) == true) goto L253;
        r82 = null;
    L253:
        Object r83 = Result.constructor-impl((Integer) r82);     // Catch: Throwable -> L255
    L257:
        r56 = r83;
        if (Result.isFailure-impl(r56) == false) goto L260;
    L255:
        th = move-exception;
        Result.Companion r84 = Result.Companion;     // Catch: Throwable -> L262
        r83 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L262
        goto L257
    L249:
        if ((r55 instanceof JSONArray) == false) goto L259;
    L219:
        r78 = r55;
    L262:
        th = move-exception;
        Result.Companion r85 = Result.Companion;     // Catch: Throwable -> L367
        r57 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L367
    L367:
        th = move-exception;
        Result.Companion r86 = Result.Companion;
        r50 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r87 = Result.exceptionOrNull-impl(r50);
        if (r87 == null) goto L372;
        EnsureManager.ensureNotReachHere(r87);
    L372:
        if (Result.isFailure-impl(r50) == false) goto L210;
    L11:
        if (r12.length() <= 0) goto L13;
        boolean r88 = true;
    L14:
        if (r88 != true) goto L23;
        Fragment r89 = this.h;
        String r90 = T().getStoreParam().getMarketInfo();
        if (r90 != null) goto L18;
        r90 = "";
    L18:
        Map r91 = com.bytedance.android.ec.core.utils.z1.k(new JSONObject(r90));
        IMarketingServiceV2 r92 = ECMarketingSDK.c();
        if (r92 == null) goto L21;
        com.bytedance.android.marketing.sdk.api.c r93 = new com.bytedance.android.marketing.sdk.api.c(null, r89, 1);
        Map r94 = MapsKt.toMutableMap(r91);
        Intrinsics.checkNotNullParameter(r94, "<set-?>");
        r93.l = r94;
        Unit r95 = Unit.INSTANCE;
        String r96 = r92.e(r93, null);
    L22:
        this.C = r96;
        goto L23
    L21:
        r96 = null;
        goto L22
    L13:
        r88 = false;
    L7:
        r11 = null;
        goto L8
    }

    @Subscribe
    public final void onShopMarqueeEnd(com.bytedance.android.ec.store.view.t r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        T().getShopMarqueeEnd().c(Boolean.TRUE);
    }

    public final void w0(final com.bytedance.android.ec.store.repository.vo.i r10) {
        final Context r2 = u().c();
        final Fragment r3 = u().a;
        final JSONObject r4 = com.bytedance.android.ec.core.utils.z1.g(r10.d());
        final String r5 = r10.f();
        if (r10.c() == false) goto L5;
        final int r6 = 0;
    L6:
        StoreFloatLayout r7 = new ECShopFloatLynxPresenter$createDefaultFloatLayout$1(r10, r2, r3, r4, r5, r6);
        StoreFloatLayout.d(r7, r10.e(), MapsKt.mapOf(new Pair[]{TuplesKt.to("metaInfo", T().getMetaInfo(0)), TuplesKt.to("data", r10.d())}));
        this.v = r7;
        x0(r7);
        return;
    L5:
        r6 = e0();
        goto L6
    }

    public final void x0(View r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (V() == false) goto L6;
        int r0 = 0;
    L7:
        r2.setVisibility(r0);
        return;
    L6:
        r0 = 4;
        goto L7
    }

    public final void y0(com.bytedance.android.shopping.store.home.entity.l r11) {
        if (V() == true) goto L6;
        this.H.put(r11, Boolean.FALSE);
        return;
    L6:
        Boolean r0 = (Boolean) ((LinkedHashMap) this.H).get(r11);
        boolean r1 = false;
        if (r0 == null) goto L9;
        boolean r2 = r0.booleanValue();
    L10:
        if (r2 == false) goto L12;
        return;
    L12:
        List<com.bytedance.android.ec.store.repository.vo.i> r3 = r11.a;
        if (r3 == null) goto L15;
        com.bytedance.android.ec.store.repository.vo.i r4 = (com.bytedance.android.ec.store.repository.vo.i) CollectionsKt.firstOrNull(r3);
    L16:
        if (r4 == null) goto L18;
        int r5 = r4.b();
    L19:
        String r6 = this.C;
        c r7 = new c();
        if (r5 != ContainerType.MARKETING_CONTAINER.getType()) goto L29;
        if (r6 == null) goto L29;
        if (r6.length() <= 0) goto L25;
        r1 = true;
    L25:
        if (r1 != true) goto L29;
        IMarketingServiceV2 r8 = ECMarketingSDK.c();
        if (r8 == null) goto L31;
        r8.f(r6, this.x, r7, null, null, null);
        return;
    L31:
        return;
    L29:
        z0(r4, r11, r7);
        return;
    L18:
        r5 = -1;
        goto L19
    L15:
        r4 = null;
        goto L16
    L9:
        r2 = false;
        goto L10
    }

    public static final void v0(ECShopFloatLynxPresenter r7, String r8) {
        String r5 = r7.C;
        if (r5 == null) goto L8;
        IMarketingServiceV2 r0 = ECMarketingSDK.c();
        if (r0 == null) goto L9;
        IMarketingServiceV2.a.b(r0, r8, null, null, null, r5, 25);
        return;
    L9:
        return;
    }

    public static final void u0(ECShopFloatLynxPresenter r7, String r8, boolean r9) {
        String r5 = r7.C;
        if (r5 == null) goto L8;
        IMarketingServiceV2 r0 = ECMarketingSDK.c();
        if (r0 == null) goto L9;
        JsonObject r2 = new JsonObject();
        r2.addProperty("visible", Integer.valueOf(r9 ? 1 : 0));
        r2.addProperty("source", "top_tab");
        r2.addProperty("tab_id", r8);
        Unit r10 = Unit.INSTANCE;
        IMarketingServiceV2.a.b(r0, "ecom.marketing.event.pageVisibilityChange", r2, null, null, r5, 25);
        return;
    L9:
        return;
    }

    public final void z0(com.bytedance.android.ec.store.repository.vo.i r25, com.bytedance.android.shopping.store.home.entity.l r26, com.bytedance.android.marketing.sdk.api.a r27) {
        if (r25 == null) goto L5;
        String r3 = r25.d();
    L6:
        JSONObject r4 = com.bytedance.android.ec.core.utils.z1.g(r3);
        if (r4 == null) goto L64;
        int r5 = r4.optInt("type", -1);
        String r6 = r4.optString("content");
        if (r4.optInt("show_leave_shop_red_pack_toast", 0) != 1) goto L11;
        boolean r7 = true;
    L12:
        this.B = r7;
        if (this.x != null) goto L15;
        return;
    L15:
        Map r8 = MapsKt.toMutableMap(ECStoreParam.getTabMetaInfo$default(T().getStoreParam(), 0, null, 2, null));
        String r10 = T().getEntranceInfo();
        if (r10 != null) goto L18;
        r10 = "";
    L18:
        r8.put("entrance_info", r10);
        r8.put("btm", "a1.b6269.c56510");
        Pair[] r11 = new Pair[2];
        r11[0] = TuplesKt.to("width", -1);
        if (T().isMiddleTabFramework() == false) goto L21;
    L62:
        int r12 = th.a.e(u().c(), true).getResources().getDimensionPixelSize(2131166444);     // Catch: Throwable -> L26
    L27:
        Resources r14 = th.a.e(u().c(), true).getResources();
        r11[1] = TuplesKt.to(ScrollPosition.POSITION_BOTTOM, Integer.valueOf((int) (r12 / Math.max(1.0f, WindowDisplayMetricsOverride.apply(r14, r14.getDisplayMetrics()).density))));
        Map r13 = MapsKt.mapOf(r11);
        if (r5 == 0) goto L30;
        return;
    L30:
        if (com.bytedance.android.shopping.extensions.k.c(r6) == false) goto L66;
        this.D = "shop_homepage_banner_v2";
        FrameLayout r15 = this.x;
        if (r15 == null) goto L67;
        IMarketingServiceV2 r16 = ECMarketingSDK.c();
        if (r16 == null) goto L57;
        com.bytedance.android.marketing.sdk.api.c r17 = new com.bytedance.android.marketing.sdk.api.c(null, null, 3);
        Intrinsics.checkNotNullParameter(r15, "container");
        r17.b = r15;
        r17.a = r6;
        Resources r2 = Resources.getSystem();
        float r9 = WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()).density;
        int[] r18 = new int[2];
        View r19 = this.E;
        if (r19 == null) goto L38;
        r19.getLocationOnScreen(r18);
    L38:
        float r110 = r18[0] / r9;
        float r20 = r18[1] / r9;
        Pair[] r21 = new Pair[4];
        com.bytedance.android.shopping.store.home.entity.n r22 = (com.bytedance.android.shopping.store.home.entity.n) T().getHeaderArea().getValue();
        if (r22 == null) goto L41;
        com.bytedance.android.shopping.store.home.entity.j r23 = r22.i;
    L42:
        if (r23 == null) goto L44;
        int r24 = 1;
    L45:
        r21[0] = TuplesKt.to("has_high_priority_animation", Integer.valueOf(r24));
        com.bytedance.android.shopping.store.home.entity.n r28 = (com.bytedance.android.shopping.store.home.entity.n) T().getHeaderArea().getValue();
        if (r28 == null) goto L52;
        com.bytedance.android.shopping.store.home.entity.j r29 = r28.i;
        if (r29 == null) goto L52;
        if (r29.f != true) goto L52;
        int r30 = 1;
    L53:
        r21[1] = TuplesKt.to("has_high_priority_guide", Integer.valueOf(r30));
        r21[2] = TuplesKt.to("coupon_style", Integer.valueOf(ECShopABSettings.a()));
        r21[3] = TuplesKt.to("close_animation_position", MapsKt.mapOf(new Pair[]{TuplesKt.to("x", Float.valueOf(r110)), TuplesKt.to("y", Float.valueOf(r20))}));
        Map r31 = MapsKt.mapOf(r21);
        r17.e = r8;
        r17.d = r31;
        long r32 = System.currentTimeMillis();
        Map r111 = MapsKt.mapOf(TuplesKt.to("shop_homepage_banner_v2", r13));
        if (ECShopABSettings.k.getEC_SHOP_POPUP_LAYOUT_INFO() != 1) goto L56;
        KtSafeMethodExtensionKt.safePut(r4, "shop_homepage_popup_v2", MapsKt.mapOf(new Pair[]{TuplesKt.to("width", -1), TuplesKt.to("height", -1)}));
    L56:
        Unit r33 = Unit.INSTANCE;
        String r34 = IMarketingServiceV2.a.a(r16, r17, r32, r111, null, null, r27, null, 88);
    L58:
        this.C = r34;
        com.bytedance.android.ec.core.utils.s0.a(new com.bytedance.android.ec.store.floatlayout.c("shop_floating_layer", null));
        if (r26 == null) goto L68;
        this.H.put(r26, Boolean.TRUE);
        return;
    L68:
        return;
    L52:
        r30 = 0;
        goto L53
    L44:
        r24 = 0;
        goto L45
    L41:
        r23 = null;
        goto L42
    L57:
        r34 = null;
        goto L58
    L67:
        return;
    L66:
        return;
    L26:
        r12 = 0;
        goto L27
    L21:
        if (Intrinsics.areEqual((Boolean) T().isBrandShop().getValue(), Boolean.TRUE) == true) goto L62;
        r12 = e0();
        goto L27
    L11:
        r7 = false;
        goto L12
    L64:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public static final Map q0(ECShopFloatLynxPresenter r3, List r4, String r5, int r6) {
        r3.getClass();
        ArrayList r7 = new ArrayList();
        Iterator r8 = r4.iterator();
    L4:
        if (r8.hasNext() == false) goto L13;
        Object r0 = r8.next();
        nm.b r1 = (nm.b) r0;
        if (Intrinsics.areEqual(r1.d, r5) == true) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == false) goto L4;
        r7.add(r0);
        goto L4
    L8:
        if (r1.e != r6) goto L10;
        r2 = true;
        goto L11
    L13:
        LinkedHashMap r9 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r7, 10)), 16));
        Iterator r10 = r7.iterator();
    L15:
        if (r10.hasNext() == false) goto L17;
        Object r11 = r10.next();
        r9.put(((nm.b) r11).d, r11);
        goto L15
    L17:
        return r9;
    }

    public static final void r0(ECShopFloatLynxPresenter r9, nm.b r10, String r11, String r12, int r13, String r14) {
        r9.getClass();
        if (r10 == null) goto L9;
        r10.g++;
        om.g r15 = om.g.a;
        Intrinsics.checkNotNullParameter(r10, "item");
        StoreDatabase r16 = lm.a.b.a();
        if (r16 == null) goto L7;
        Observable r17 = Observable.create(new om.f(r16, r10));
    L8:
        bg4.b.b(r17).subscribe();
        return;
    L7:
        r17 = Observable.just(-1);
        goto L8
    L9:
        nm.b r18 = new nm.b(0, r11, com.bytedance.android.ec.sdk.helper.r.a.f(), r12, r13, r14, 1);
        om.g r19 = om.g.a;
        Intrinsics.checkNotNullParameter(r18, "item");
        StoreDatabase r20 = lm.a.b.a();
        if (r20 == null) goto L12;
        Observable r21 = Observable.create(new om.d(r20, r18));
    L13:
        bg4.b.b(r21).subscribe();
        return;
    L12:
        r21 = Observable.just(-1L);
        goto L13
    }
}
