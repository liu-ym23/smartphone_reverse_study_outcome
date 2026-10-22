package com.bytedance.android.shopping.card_list.container.init;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Choreographer;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.anchorv3.compat.UserInteractFrameLayout;
import com.bytedance.android.shopping.card_list.abilities.CardMultiUpdateComponent;
import com.bytedance.android.shopping.card_list.common_params.CardListContainerConfig;
import com.bytedance.android.shopping.card_list.components.CardListPageCallBackComponent;
import com.bytedance.android.shopping.card_list.components.CardListQueryFetchComponent;
import com.bytedance.android.shopping.card_list.components.i;
import com.bytedance.android.shopping.card_list.components.k;
import com.bytedance.android.shopping.card_list.container.CardListActivity;
import com.bytedance.android.shopping.card_list.container.CardListDialogFragment;
import com.bytedance.android.shopping.card_list.manager.KeyboardManager;
import com.bytedance.android.shopping.card_list.monitor.CardListYataMonitorManager;
import com.bytedance.android.shopping.card_list.monitor.cache.CacheMonitor;
import com.bytedance.android.shopping.card_list.monitor.error.CardListErrorMonitorType;
import com.bytedance.android.shopping.card_list.monitor.error.CardListRunCatchExtKt;
import com.bytedance.android.shopping.card_list.monitor.firstScreen.CardListFirstScreenPoint;
import com.bytedance.android.shopping.card_list.monitor.firstScreen.CardListYataFirstScreenDurationMonitor;
import com.bytedance.android.shopping.card_list.monitor.success_rate.CardListSuccessRateMonitor;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import com.bytedance.android.shopping.card_list.params.CartPassThroughData;
import com.bytedance.android.shopping.card_list.perf.cache.CardListCacheManager;
import com.bytedance.android.shopping.card_list.repo.CardListRepository;
import com.bytedance.android.shopping.card_list.utils.HalfPanelHelper;
import com.bytedance.android.shopping.card_list.utils.j;
import com.bytedance.android.shopping.card_list.utils.l;
import com.bytedance.android.shopping.card_list.utils.m;
import com.bytedance.android.shopping.card_list.utils.n;
import com.bytedance.android.shopping.card_list.widgets.CardListRootFrameLayoutContainer;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.common.biz.YataPageInfo;
import com.bytedance.kmp.ec.yata.common.init.PackYataSdkConfig;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class BaseCardListContainer {
    public static final /* synthetic */ int y = 0;
    public CardListObjectContainer a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public CardPassThroughData i;
    public CardListContainerConfig j;
    public AndroidYaTaInstance k;
    public String l;
    public SlcRenderContext m;
    public final Lazy n;
    public View o;
    public final Lazy p;
    public final Lazy q;
    public int r;
    public KeyboardManager s;
    public final Lazy t;
    public final long u;
    public final AtomicBoolean v;
    public final Lazy w;
    public final Lazy x;

    public static final class a {
        public static CardListDialogFragment b(CardPassThroughData r3, String r4, CardListContainerConfig r5) {
            Intrinsics.checkNotNullParameter(r3, "params");
            Intrinsics.checkNotNullParameter(r4, "sessionId");
            Intrinsics.checkNotNullParameter(r5, "pageConfig");
            CardListDialogFragment r0 = new CardListDialogFragment();
            Bundle r1 = new Bundle();
            r1.putSerializable("pass_through_data", r3);
            r1.putString("PrefetchSessionId", r4);
            r1.putSerializable("page_config", r5);
            Unit r6 = Unit.INSTANCE;
            r0.setArguments(r1);
            return r0;
        }

        public static void a(Context r4, CardPassThroughData r5, String r6, CardListContainerConfig r7) {
            Intrinsics.checkNotNullParameter(r4, "context");
            Intrinsics.checkNotNullParameter(r5, "params");
            Intrinsics.checkNotNullParameter(r6, "sessionId");
            Intrinsics.checkNotNullParameter(r7, "pageConfig");
            ActivityOptionsCompat r0 = ActivityOptionsCompat.makeCustomAnimation(r4, 2130772267, 2130772253);
            Intent r1 = new Intent(r4, CardListActivity.class);
            Bundle r2 = new Bundle();
            r2.putSerializable("pass_through_data", r5);
            r2.putString("PrefetchSessionId", r6);
            r2.putSerializable("page_config", r7);
            Unit r8 = Unit.INSTANCE;
            r1.putExtras(r2);
            r4.startActivity(r1, r0.toBundle());
        }
    }

    static {
    }

    public final boolean g() {
        return ((Boolean) this.w.getValue()).booleanValue();
    }

    public final void c() {
        CardPassThroughData r0 = this.i;
        if (r0 == null) goto L6;
        String r1 = r0.getMonitorId();
        if (r1 == null) goto L6;
    L7:
        CardListRunCatchExtKt.a(r1, "onResume", new BaseCardListContainer$doOnResume$1(this));
        this.v.compareAndSet(false, true);
        return;
    L6:
        r1 = "";
        goto L7
    }

    public final CardMultiUpdateComponent d() {
        CardListObjectContainer r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L6:
        return (CardMultiUpdateComponent) r0.b(Reflection.getOrCreateKotlinClass(CardMultiUpdateComponent.class));
    }

    public final CardListYataMonitorManager e() {
        Map<String, CardListYataMonitorManager> r0 = CardListYataMonitorManager.k;
        CardPassThroughData r1 = this.i;
        if (r1 == null) goto L5;
        String r2 = r1.getMonitorId();
    L7:
        return CardListYataMonitorManager.a.a(r2);
    L5:
        r2 = null;
        goto L7
    }

    public final CardListObjectContainer f() {
        CardListObjectContainer r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L5:
        return r0;
    }

    public final void h() {
        String r0 = this.l;
        if (r0 == null) goto L5;
        Map<String, Map<String, Long>> r1 = com.bytedance.android.shopping.card_list.monitor.firstScreen.a.a;
        Intrinsics.checkNotNullParameter(r0, "sessionId");
        com.bytedance.android.shopping.card_list.monitor.firstScreen.a.a.remove(r0);
        com.bytedance.android.shopping.card_list.monitor.firstScreen.a.c.remove(r0);
        com.bytedance.android.shopping.card_list.monitor.firstScreen.a.b.remove(r0);
    L5:
        CardListObjectContainer r2 = this.a;
        if (r2 != null) goto L8;
    L22:
        AndroidYaTaInstance r3 = this.k;
        if (r3 == null) goto L25;
        r3.d();
    L25:
        KeyboardManager r4 = this.s;
        if (r4 == null) goto L35;
        com.bytedance.android.shopping.card_list.manager.c r5 = r4.a;
        if (r5 == null) goto L35;
        ViewTreeObserver r6 = r5.h;
        if (r6 != null) goto L32;
    L34:
        r5.h = null;
        goto L35
    L32:
        if (r6.isAlive() == false) goto L34;
        r6.removeOnGlobalLayoutListener(r5.e);
    L35:
        Map<String, CardListYataMonitorManager> r7 = CardListYataMonitorManager.k;
        CardPassThroughData r8 = this.i;
        if (r8 == null) goto L39;
        String r9 = r8.getMonitorId();
        if (r9 == null) goto L39;
    L40:
        Map<String, com.bytedance.android.shopping.card_list.monitor.error.a> r10 = com.bytedance.android.shopping.card_list.monitor.error.a.b;
        if (r10 == null) goto L53;
        TypeIntrinsics.asMutableMap(r10).remove(r9);
        Map<String, CardListSuccessRateMonitor> r11 = CardListSuccessRateMonitor.g;
        if (r11 == null) goto L51;
        TypeIntrinsics.asMutableMap(r11).remove(r9);
        Map<String, CacheMonitor> r12 = CacheMonitor.d;
        if (r12 == null) goto L49;
        TypeIntrinsics.asMutableMap(r12).remove(r9);
        CardListYataMonitorManager.k.remove(r9);
        return;
    L49:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    L51:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    L53:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    L39:
        r9 = "";
        goto L40
    L8:
        if (r2.e.h.c == true) goto L22;
        JSONObject r13 = new JSONObject();
        com.bytedance.android.shopping.card_list.components.f r14 = (com.bytedance.android.shopping.card_list.components.f) this.b.getValue();
        if (r14 == null) goto L12;
        Boolean r15 = Boolean.valueOf(r14.b());
    L13:
        r13.put("errorView", r15);
        k r16 = (k) this.c.getValue();
        if (r16 == null) goto L16;
        Boolean r17 = Boolean.valueOf(r16.isLoading());
    L17:
        r13.put("loading", r17);
        r13.put("page_time", System.currentTimeMillis() - this.u);
        CardListYataMonitorManager r18 = e();
        if (r18 == null) goto L22;
        com.bytedance.android.shopping.card_list.monitor.error.a r19 = r18.e;
        if (r19 == null) goto L22;
        r19.b(CardListErrorMonitorType.PAGE_DESTROY_BEFORE_FIRST_SCREEN, "BaseCardListContainer-page_destroy_before_first_screen", r13);
        goto L22
    L16:
        r17 = null;
        goto L17
    L12:
        r15 = null;
        goto L13
    }

    public BaseCardListContainer() {
        this.b = LazyKt.lazy(new BaseCardListContainer$errorComponent$2(this));
        this.c = LazyKt.lazy(new BaseCardListContainer$loadingComponent$2(this));
        this.d = LazyKt.lazy(new BaseCardListContainer$pageCallBackComponent$2(this));
        this.e = LazyKt.lazy(new BaseCardListContainer$cardListPageCallBackComponent$2(this));
        this.f = LazyKt.lazy(new BaseCardListContainer$queryFetchComponent$2(this));
        this.g = LazyKt.lazy(new BaseCardListContainer$trackerComponent$2(this));
        this.h = LazyKt.lazy(new BaseCardListContainer$popupLayerComponent$2(this));
        this.n = LazyKt.lazy(new BaseCardListContainer$yataPerfManager$2(this));
        this.p = LazyKt.lazy(new BaseCardListContainer$footerView$2(this));
        this.q = LazyKt.lazy(new BaseCardListContainer$yataBodyView$2(this));
        this.t = LazyKt.lazy(new BaseCardListContainer$triggerInterceptorImpl$2(this));
        this.u = System.currentTimeMillis();
        this.v = new AtomicBoolean(false);
        this.w = LazyKt.lazy(new BaseCardListContainer$isCartHalfPanel$2(this));
        this.x = LazyKt.lazy(new BaseCardListContainer$halfPanelHelper$2(this));
    }

    public final void a(MotionEvent r4) {
        if (r4 != null) goto L5;
    L6:
        if (r4 != null) goto L8;
        return;
    L8:
        if (r4.getAction() != 3) goto L20;
    L9:
        CardListObjectContainer r1 = this.a;
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L12:
        List r2 = CollectionsKt.toList(r1.e.d);
        if ((true ^ r2.isEmpty()) == false) goto L21;
        Iterator r0 = r2.iterator();
    L16:
        if (r0.hasNext() == false) goto L22;
        ((e) r0.next()).c(r4);
        goto L16
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L5:
        if (r4.getAction() == 1) goto L9;
        goto L6
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void b(Bundle r23, View r24, CardPassThroughData r25, CardListContainerConfig r26, String r27, final CardListActivity r28, final Fragment r29, final g r30) {
        Intrinsics.checkNotNullParameter(r24, "rootContainerView");
        Intrinsics.checkNotNullParameter(r25, "data");
        Intrinsics.checkNotNullParameter(r26, "config");
        Intrinsics.checkNotNullParameter(r27, "sessionId");
        Intrinsics.checkNotNullParameter(r30, "service");
        com.bytedance.android.shopping.card_list.monitor.firstScreen.a.b(r27, "OnCreate");
        this.i = r25;
        this.j = r26;
        this.l = r27;
        if (r26 == null) goto L25;
        Function0<AndroidYaTaInstance> r3 = new BaseCardListContainer$initData$$inlined$let$lambda$1(this, r28, r29, r30);
        String r14 = this.l;
        if (r14 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("sessionId");
    L7:
        com.bytedance.android.shopping.card_list.common_params.a r6 = new com.bytedance.android.shopping.card_list.common_params.a(r3, r14, g());
        CardPassThroughData r4 = this.i;
        if (r4 == null) goto L24;
        r6.a = r4;
        r6.e.clear();
        r6.f.clear();
        CartPassThroughData r15 = r4.getCartSchemaData();
        if (r15 == null) goto L17;
        String r16 = r15.getShopIds();
        if (r16 == null) goto L17;
        List r17 = StringsKt.split$default(r16, new char[]{','}, false, 0, 6, null);
        if (r17 == null) goto L17;
        r6.f.addAll(r17);
    L17:
        CartPassThroughData r5 = r4.getCartSchemaData();
        if (r5 == null) goto L24;
        String r18 = r5.getCartIds();
        if (r18 == null) goto L24;
        List r7 = StringsKt.split$default(r18, new char[]{','}, false, 0, 6, null);
        if (r7 == null) goto L24;
        r6.e.addAll(r7);
    L24:
        this.a = new CardListObjectContainer(r28, r29, r6, r26, r30);
    L25:
        String r8 = com.bytedance.android.shopping.card_list.monitor.a.a;
        boolean r9 = g();
        ConcurrentHashMap<String, String> r10 = com.bytedance.android.shopping.base.event.a.a;
        String r13 = com.bytedance.android.shopping.card_list.monitor.a.a;
        JSONObject r11 = new JSONObject();
        r11.put("full_mode", r9);
        Unit r12 = Unit.INSTANCE;
        com.bytedance.android.shopping.base.event.a.d(r13, "page_create", "start", null, false, r11, 24);
        this.o = r24;
        View r2 = r24.findViewById(2131368571);
        wg.a.h(r2, ECAppInfoService.e.i());
        StringBuilder r19 = new StringBuilder();
        CardListContainerConfig r20 = this.j;
        Map r21 = null;
        if (r20 == null) goto L30;
        LauncherBizType r22 = r20.getBizType();
        if (r22 == null) goto L30;
        String r31 = r22.name();
    L31:
        r19.append(r31);
        r19.append('_');
        CardListContainerConfig r32 = this.j;
        if (r32 == null) goto L34;
        String r33 = r32.getPageType();
    L35:
        r19.append(r33);
        String r34 = r19.toString();
        if ((r2 instanceof TextView) == true) goto L38;
        View r35 = null;
    L39:
        TextView r36 = (TextView) r35;
        if (r36 == null) goto L42;
        r36.setText(r34);
    L42:
        r2.setOnClickListener(com.bytedance.android.shopping.card_list.container.init.a.a);
        CardListContainerConfig r37 = this.j;
        if (r37 == null) goto L46;
        LauncherBizType r38 = r37.getBizType();
        if (r38 == null) goto L46;
    L47:
        f r39 = c.a(r38);
        if (r39 == null) goto L54;
        CardListObjectContainer r40 = this.a;
        if (r40 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L52:
        r39.c(r40, new f.b(0), null, new BaseCardListContainer$initSDK$1(this));
    L54:
        CardListContainerConfig r41 = this.j;
        if (r41 == null) goto L67;
        LauncherBizType r42 = r41.getBizType();
        if (r42 == null) goto L67;
        f r43 = c.a(r42);
        if (r43 == null) goto L67;
        CardListObjectContainer r44 = this.a;
        if (r44 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L63:
        View r45 = this.o;
        if (r45 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("rootContainerView");
    L66:
        r43.a(r44, r45);
    L67:
        AndroidYaTaInstance r46 = this.k;
        if (r46 == null) goto L71;
        r46.E(d());
    L71:
        if (r23 != null) goto L73;
    L74:
        CardListContainerConfig r47 = this.j;
        if (r47 == null) goto L87;
        int r48 = CardListCacheManager.j;
        CardListYataMonitorManager r49 = e();
        if (r49 == null) goto L79;
        CacheMonitor r50 = r49.i;
    L80:
        CardPassThroughData r51 = this.i;
        if (r51 == null) goto L85;
        CartPassThroughData r52 = r51.getCartSchemaData();
        if (r52 == null) goto L85;
        String r53 = r52.getNewSourceType();
    L86:
        boolean r110 = CardListCacheManager.Companion.a(r50, r53, r47.getCacheValidDuration(), r47.getBizType(), r47.getNeedCacheManager());
    L88:
        if (r110 == false) goto L90;
        Choreographer.getInstance().postFrameCallback(new b(this));
    L90:
        CardListPageCallBackComponent r54 = (CardListPageCallBackComponent) this.d.getValue();
        if (r54 == null) goto L93;
        Intrinsics.checkNotNullParameter("first_enter", "scene");
        r54.n(true, "first_enter", null);
    L93:
        HalfPanelHelper r55 = (HalfPanelHelper) this.x.getValue();
        if (r55 == null) goto L125;
        View r56 = r55.q;
        View r57 = r56.findViewById(2131365191);
        r55.g = r57;
        if (r57 == null) goto L98;
        r57.setVisibility(4);
    L98:
        r55.c = r56.findViewById(2131389274);
        r55.e = (LinearLayout) r56.findViewById(2131382386);
        r55.f = r56.findViewById(2131365187);
        r55.d = (CardListRootFrameLayoutContainer) r56.findViewById(2131365188);
        if (ViewCompat.isLaidOut(r56) == true) goto L101;
    L105:
        r56.addOnLayoutChangeListener(new j(r55));
    L106:
        CardListRootFrameLayoutContainer r58 = r55.d;
        if (r58 == null) goto L109;
        r58.setBorderRadius(com.bytedance.android.shopping.extensions.b.b(20));
    L109:
        r55.r.e.n = ((Number) r55.j.getValue()).intValue();
        View r59 = r55.c;
        if (r59 == null) goto L112;
        r59.setOnClickListener(new l(r55));
    L112:
        View r60 = r55.f;
        if (r60 == null) goto L115;
        r60.setOnTouchListener(new m(r55));
    L115:
        View r61 = r55.g;
        if (r61 == null) goto L118;
        r61.setOnTouchListener(new n(r55));
    L118:
        i r62 = (i) r55.m.getValue();
        if (r62 == null) goto L125;
        LinearLayout r63 = r62.d;
        if (r63 == null) goto L125;
        ViewTreeObserver r64 = r63.getViewTreeObserver();
        if (r64 == null) goto L125;
        r64.addOnGlobalLayoutListener(new com.bytedance.android.shopping.card_list.utils.k(r64, r55));
        goto L125
    L101:
        if (r56.isLayoutRequested() == true) goto L105;
        UserInteractFrameLayout r65 = r55.d;
        if (r65 == null) goto L106;
        r65.setTranslationY(r55.c());
    L125:
        if (r23 != null) goto L127;
    L134:
        CardListContainerConfig r1 = this.j;
        if (r1 != null) goto L137;
    L138:
        CardListQueryFetchComponent r66 = (CardListQueryFetchComponent) this.f.getValue();
        if (r66 == null) goto L154;
        CardListYataMonitorManager r67 = r66.j();
        if (r67 == null) goto L145;
        CardListYataFirstScreenDurationMonitor r68 = r67.d;
        if (r68 == null) goto L145;
        CardListYataFirstScreenDurationMonitor.b(r68, CardListFirstScreenPoint.REQUEST_START);
    L145:
        CardListRepository r69 = CardListRepository.INSTANCE;
        String r70 = r66.w.a;
        LinkedHashMap r71 = new LinkedHashMap();
        CardPassThroughData r72 = r66.v.e.a;
        if (r72 == null) goto L150;
        HashMap<String, String> r73 = r72.getSchemaParamsOrCreate();
        if (r73 == null) goto L150;
        r71.putAll(r73);
    L150:
        r71.put("query_scene", "first_enter");
        r71.putAll(r66.w.c);
        PackYataSdkConfig r74 = com.bytedance.kmp.ec.yata.common.init.b.a;
        YataPageInfo r75 = (YataPageInfo) r66.n.getValue();
        if (r75 == null) goto L153;
        r21 = r75.addAndGetYataProtocolInfo();
    L153:
        r69.getQuery(r70, new ab3.b(r71, r21, "1.23.7", 6), r66.w.b).subscribeOn(Schedulers.newThread()).subscribe(new com.bytedance.android.shopping.card_list.components.l(r66));
    L154:
        com.bytedance.android.shopping.card_list.utils.a.HandlerC0036a r76 = com.bytedance.android.shopping.card_list.utils.a.a;
        CardListObjectContainer r77 = this.a;
        if (r77 != null) goto L157;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L157:
        com.bytedance.android.shopping.card_list.utils.a.a(r77, 7000, new BaseCardListContainer$doOnCreate$2(this));
        String r78 = this.l;
        if (r78 != null) goto L160;
        Intrinsics.throwUninitializedPropertyAccessException("sessionId");
    L160:
        com.bytedance.android.shopping.card_list.monitor.firstScreen.a.b(r78, "OnCreateEnd");
        com.bytedance.android.shopping.base.event.a.d(com.bytedance.android.shopping.card_list.monitor.a.a, "page_create", "end", null, false, null, 56);
        return;
    L137:
        if (r1.getQueryDataInStarter() == true) goto L154;
    L127:
        if (r23.getBoolean("CARD_LIST_PAGE_LOAD_AGAIN") != true) goto L134;
        CardListObjectContainer r79 = this.a;
        if (r79 != null) goto L131;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L131:
        r79.e.j = true;
        CardListQueryFetchComponent r80 = (CardListQueryFetchComponent) this.f.getValue();
        if (r80 == null) goto L134;
        int r81 = CardListQueryFetchComponent.x;
        r80.i(true, "first_enter", null);
    L85:
        r53 = null;
        goto L86
    L79:
        r50 = null;
        goto L80
    L87:
        r110 = false;
        goto L88
    L73:
        if (r23.getBoolean("CARD_LIST_PAGE_LOAD_AGAIN") == true) goto L90;
    L46:
        r38 = LauncherBizType.NONE;
        goto L47
    L38:
        r35 = r2;
        goto L39
    L34:
        r33 = null;
    L30:
        r31 = null;
        goto L31
    }
}
