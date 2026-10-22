package com.bytedance.android.shopping.orderlist.list.widget.gul;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.host.api.search.IECHostSearchService;
import com.bytedance.android.ec.host.api.search.MALLSCENE;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.api.mall.feed.ECMallFeedState;
import com.bytedance.android.shopping.api.mall.feed.IECMallFeedService;
import com.bytedance.android.shopping.api.mall.feed.f;
import com.bytedance.android.shopping.mall.feed.ECMallFeedOptService;
import com.bytedance.android.shopping.orderlist.common.monitor.business.OrderCommonBusinessMonitor;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.BaseLinkedScrollView;
import com.bytedance.android.shopping.orderlist.list.container.OrderListFragment;
import com.bytedance.android.shopping.orderlist.list.starter.OrderListParams;
import com.bytedance.android.shopping.orderlist.list.viewmodel.OrderListViewModel;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.utils.t;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import ti.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u000689:;<=B%\u0012\u0006\u00102\u001a\u000201\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000103\u0012\b\b\u0002\u00105\u001a\u00020\u0006¢\u0006\u0004\b6\u00107J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002R\u001b\u0010\u0014\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0018\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010 \u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001f\u0010\u0017R\u001b\u0010#\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0011\u001a\u0004\b\"\u0010\u0013R\u001b\u0010&\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0011\u001a\u0004\b%\u0010\u0017R\u001d\u0010+\u001a\u0004\u0018\u00010'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0011\u001a\u0004\b)\u0010*R\u001f\u00100\u001a\u00060,R\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u0011\u001a\u0004\b.\u0010/¨\u0006>"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/widget/gul/OrderListGULView;", "Landroid/widget/FrameLayout;", "Ljg3/b;", "Lcom/bytedance/android/shopping/utils/t;", "Landroid/view/View;", "getView", "", "height", "", "setGULHeight", "getGULVerticalOffset", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "Lcom/bytedance/android/shopping/orderlist/common/monitor/business/OrderCommonBusinessMonitor;", "getBusinessMonitor", "", "d", "Lkotlin/Lazy;", "getMallFeedEnable", "()Z", "mallFeedEnable", "e", "getChangeTabPrefetchGyl", "()I", "changeTabPrefetchGyl", "", "f", "getChangeTabPrefetchGylExpired", "()J", "changeTabPrefetchGylExpired", "g", "getMonitorOrderListRebuildGyl", "monitorOrderListRebuildGyl", "h", "getMallFeedApiCacheEnable", "mallFeedApiCacheEnable", "i", "getIgnoreHidGul", "ignoreHidGul", "Lcom/bytedance/android/shopping/api/mall/feed/d;", "k", "getMallFeedComponent", "()Lcom/bytedance/android/shopping/api/mall/feed/d;", "mallFeedComponent", "Lcom/bytedance/android/shopping/orderlist/list/widget/gul/OrderListGULView$ECMallFeedLinkedScrollListener;", "l", "getMallFeedLinkedScrollListener", "()Lcom/bytedance/android/shopping/orderlist/list/widget/gul/OrderListGULView$ECMallFeedLinkedScrollListener;", "mallFeedLinkedScrollListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ECMallFeedConfigGenerator", "b", "ECMallFeedLinkedScrollListener", "c", "LoadState", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderListGULView extends FrameLayout implements jg3.b, t {
    public final FrameLayout a;
    public OrderListGULComponent b;
    public OrderListFragment c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public com.bytedance.android.shopping.orderlist.list.widget.gul.a j;
    public final Lazy k;
    public final Lazy l;
    public LoadState m;
    public int n;
    public boolean o;
    public boolean p;
    public boolean q;
    public Function0<Unit> r;
    public final CopyOnWriteArrayList<Function0<Unit>> s;

    public final class ECMallFeedConfigGenerator {
        public final HashMap<String, Object> a;
        public final Lazy b;
        public final boolean c;
        public final /* synthetic */ OrderListGULView d;

        public ECMallFeedConfigGenerator(OrderListGULView r6) {
            this.d = r6;
            int r7 = p.a;
            HashMap r0 = new HashMap();
            Object r2 = null;
            r0.put("api_cache_valid_period", null);
            r0.putAll(((IECMallFeedService) ServiceManager.get().getService(IECMallFeedService.class)).c().a());
            Unit r1 = Unit.INSTANCE;
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
            jj4.b r4 = jj4.b.b;     // Catch: Throwable -> L7
            Object r8 = jj4.a.a("ec_order_list_gul_config", HashMap.class, r0, false);     // Catch: Throwable -> L7
            Object r9 = r8;
            if (r8 != null) goto L13;
            Intrinsics.throwNpe();     // Catch: Throwable -> L7
            r9 = r8;
        L13:
            this.a = (HashMap) r9;
            this.b = LazyKt.lazy(OrderListGULView$ECMallFeedConfigGenerator$preloadThreshold$2.INSTANCE);
            int r10 = n.a;
            Object r5 = Boolean.FALSE;
            int r11 = com.bytedance.android.ec.base.settings.a.a;
            Object r12 = com.bytedance.android.ec.base.settings.d.c.get("ec_order_list_gul_image_prefetch_enable");     // Catch: Throwable -> L66
            if (r12 != null) goto L18;
        L63:
            Object r13 = null;
        L64:
            Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L66
        L68:
            Throwable r15 = Result.exceptionOrNull-impl(r14);     // Catch: Throwable -> L175
            if (r15 == null) goto L72;
            EnsureManager.ensureNotReachHere(r15);     // Catch: Throwable -> L175
        L72:
            if (Result.isFailure-impl(r14) == false) goto L75;
            r14 = null;
        L75:
            if ((r14 instanceof Boolean) == true) goto L77;
            r14 = null;
        L77:
            Object r16 = (Boolean) r14;     // Catch: Throwable -> L175
            if (r16 != null) goto L84;
            Object r17 = com.bytedance.android.ec.base.settings.d.a.get("ec_order_list_gul_image_prefetch_enable");     // Catch: Throwable -> L175
            if ((r17 instanceof Boolean) == true) goto L83;
            r17 = null;
        L83:
            r16 = (Boolean) r17;     // Catch: Throwable -> L175
        L84:
            if (r16 != null) goto L184;
            int r18 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L175
            Object r19 = com.bytedance.android.ec.base.settings.d.c.get("ec_order_list_gul_image_prefetch_enable");     // Catch: Throwable -> L139
            if (r19 != null) goto L91;
        L136:
            Object r20 = null;
        L137:
            Object r21 = Result.constructor-impl(r20);     // Catch: Throwable -> L139
        L141:
            Throwable r22 = Result.exceptionOrNull-impl(r21);     // Catch: Throwable -> L166
            if (r22 == null) goto L145;
            EnsureManager.ensureNotReachHere(r22);     // Catch: Throwable -> L166
        L145:
            if (Result.isFailure-impl(r21) == false) goto L148;
            r21 = null;
        L148:
            if ((r21 instanceof Boolean) == true) goto L150;
            r21 = null;
        L150:
            r16 = (Boolean) r21;     // Catch: Throwable -> L166
            if (r16 != null) goto L173;
            IHybridHostService r23 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L166
            if (r23 == null) goto L156;
            Object r24 = r23.getHostABValue("ec_order_list_gul_image_prefetch_enable", r5);     // Catch: Throwable -> L166
        L157:
            if (r24 != null) goto L159;
        L172:
            r16 = r5;
            goto L173
        L159:
            if ((r24 instanceof Boolean) == false) goto L162;
            r2 = r24;
        L162:
            Boolean r25 = (Boolean) r2;     // Catch: Throwable -> L166
            if (r25 == null) goto L172;
            r16 = r25;
            goto L173
        L166:
            th = move-exception;
            Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L175
            r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L175
            Throwable r27 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L175
            if (r27 == null) goto L171;
            EnsureManager.ensureNotReachHere(r27);     // Catch: Throwable -> L175
        L171:
            if (Result.isFailure-impl(r16) == false) goto L173;
        L156:
            r24 = null;
        L173:
            com.bytedance.android.ec.base.settings.d.d("ec_order_list_gul_image_prefetch_enable", r16);     // Catch: Throwable -> L175
            goto L184
        L91:
            if ((r19 instanceof Boolean) == true) goto L93;
            Object r28 = null;
        L94:
            r20 = (Boolean) r28;     // Catch: Throwable -> L139
            if (r20 != null) goto L137;
            if ((r19 instanceof Number) == false) goto L124;
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L106;
            Float r29 = Float.valueOf(((Number) r19).floatValue());     // Catch: Throwable -> L139
            if ((r29 instanceof Boolean) == true) goto L104;
            r29 = null;
        L104:
            r20 = (Boolean) r29;     // Catch: Throwable -> L139
            goto L137
        L106:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L112;
            Double r30 = Double.valueOf(((Number) r19).doubleValue());     // Catch: Throwable -> L139
            if ((r30 instanceof Boolean) == true) goto L110;
            r30 = null;
        L110:
            r20 = (Boolean) r30;     // Catch: Throwable -> L139
            goto L137
        L112:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L118;
            Integer r31 = Integer.valueOf(((Number) r19).intValue());     // Catch: Throwable -> L139
            if ((r31 instanceof Boolean) == true) goto L116;
            r31 = null;
        L116:
            r20 = (Boolean) r31;     // Catch: Throwable -> L139
            goto L137
        L118:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L124;
            Long r32 = Long.valueOf(((Number) r19).longValue());     // Catch: Throwable -> L139
            if ((r32 instanceof Boolean) == true) goto L122;
            r32 = null;
        L122:
            r20 = (Boolean) r32;     // Catch: Throwable -> L139
        L124:
            if ((r19 instanceof JSONObject) == false) goto L126;
        L186:
            SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L132
            Object r33 = SDKSettingsCacheManager.a().fromJson(r19.toString(), Boolean.class);     // Catch: Throwable -> L132
            if ((r33 instanceof Boolean) == true) goto L130;
            r33 = null;
        L130:
            Object r34 = Result.constructor-impl((Boolean) r33);     // Catch: Throwable -> L132
        L134:
            r20 = r34;
            if (Result.isFailure-impl(r20) == false) goto L137;
        L132:
            th = move-exception;
            Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L139
            r34 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L139
            goto L134
        L126:
            if ((r19 instanceof JSONArray) == false) goto L136;
        L93:
            r28 = r19;
        L139:
            th = move-exception;
            Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L166
            r21 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
        L184:
            this.c = ((Boolean) r16).booleanValue();
            return;
        L18:
            if ((r12 instanceof Boolean) == true) goto L20;
            Object r37 = null;
        L21:
            r13 = (Boolean) r37;     // Catch: Throwable -> L66
            if (r13 != null) goto L64;
            if ((r12 instanceof Number) == false) goto L51;
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L33;
            Float r38 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L66
            if ((r38 instanceof Boolean) == true) goto L31;
            r38 = null;
        L31:
            r13 = (Boolean) r38;     // Catch: Throwable -> L66
            goto L64
        L33:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L39;
            Double r39 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L66
            if ((r39 instanceof Boolean) == true) goto L37;
            r39 = null;
        L37:
            r13 = (Boolean) r39;     // Catch: Throwable -> L66
            goto L64
        L39:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L45;
            Integer r40 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L66
            if ((r40 instanceof Boolean) == true) goto L43;
            r40 = null;
        L43:
            r13 = (Boolean) r40;     // Catch: Throwable -> L66
            goto L64
        L45:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L51;
            Long r41 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L66
            if ((r41 instanceof Boolean) == true) goto L49;
            r41 = null;
        L49:
            r13 = (Boolean) r41;     // Catch: Throwable -> L66
        L51:
            if ((r12 instanceof JSONObject) == false) goto L53;
        L191:
            SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L59
            Object r42 = SDKSettingsCacheManager.a().fromJson(r12.toString(), Boolean.class);     // Catch: Throwable -> L59
            if ((r42 instanceof Boolean) == true) goto L57;
            r42 = null;
        L57:
            Object r43 = Result.constructor-impl((Boolean) r42);     // Catch: Throwable -> L59
        L61:
            r13 = r43;
            if (Result.isFailure-impl(r13) == false) goto L64;
        L59:
            th = move-exception;
            Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L66
            r43 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L66
            goto L61
        L53:
            if ((r12 instanceof JSONArray) == false) goto L63;
        L20:
            r37 = r12;
        L66:
            th = move-exception;
            Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L175
            r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L175
        L175:
            th = move-exception;
            Result.Companion r46 = Result.Companion;
            Object r47 = Result.constructor-impl(ResultKt.createFailure(th));
            Throwable r48 = Result.exceptionOrNull-impl(r47);
            if (r48 == null) goto L180;
            EnsureManager.ensureNotReachHere(r48);
        L180:
            if (Result.isFailure-impl(r47) == true) goto L183;
            r5 = r47;
        L183:
            r16 = r5;
        L7:
            th = move-exception;
            Result.Companion r49 = Result.Companion;
            Object r50 = Result.constructor-impl(ResultKt.createFailure(th));
            Object r51 = r0;
            if (Result.isFailure-impl(r50) == true) goto L12;
            r51 = r50;
        L12:
            r9 = r51;
            goto L13
        }
    }

    public final class ECMallFeedLinkedScrollListener implements com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.c {
        public final Lazy a;
        public final /* synthetic */ OrderListGULView b;

        @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.c
        public final void a() {
        }

        @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.c
        public final void c(float r1) {
        }

        public ECMallFeedLinkedScrollListener(OrderListGULView r1) {
            this.b = r1;
            this.a = LazyKt.lazy(OrderListGULView$ECMallFeedLinkedScrollListener$methodSetScrollState$2.INSTANCE);
        }

        @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.c
        public final void onScrollStateChanged(final int r3) {
            Lazy r0 = OrderCommonLog.a;
            OrderCommonLog.c("OrderListGULView", new OrderListGULView$ECMallFeedLinkedScrollListener$onScrollStateChanged$1(r3));
            RecyclerView r1 = null;
            if (r3 != 3) goto L5;
        L12:
            com.bytedance.android.shopping.api.mall.feed.d r4 = OrderListGULView.l(this.b);
            if (r4 == null) goto L15;
            r1 = r4.getFeedView();
        L15:
            d(r1, 1);
            return;
        L5:
            if (r3 == 2) goto L12;
            if (r3 != 0) goto L17;
            com.bytedance.android.shopping.api.mall.feed.d r5 = OrderListGULView.l(this.b);
            if (r5 == null) goto L11;
            r1 = r5.getFeedView();
        L11:
            d(r1, 0);
            return;
        }

        @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.c
        public final void b(int r1, com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.b r2) {
            Intrinsics.checkNotNullParameter(r2, "verticalOffsetInfo");
            Intrinsics.checkNotNullParameter(r2, "verticalOffsetInfo");
        }

        public final void d(RecyclerView r4, int r5) {
            if (r4 != null) goto L19;
            return;
        L19:
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
            Method r1 = (Method) this.a.getValue();     // Catch: Throwable -> L10
            if (r1 == null) goto L7;
            Object r6 = r1.invoke(r4, new Object[]{Integer.valueOf(r5)});     // Catch: Throwable -> L10
        L8:
            Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L10
        L12:
            Throwable r8 = Result.exceptionOrNull-impl(r7);
            if (r8 == null) goto L18;
            EnsureManager.ensureNotReachHere("OrderListGULView, reflect invoke setScrollState method failed");
            if (ECAppInfoService.e.isLocalTest() == false) goto L21;
            throw r8;
        L21:
            return;
        L18:
            return;
        L7:
            r6 = null;
        L10:
            th = move-exception;
            Result.Companion r9 = Result.Companion;
            r7 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L12
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/widget/gul/OrderListGULView$LoadState;", "", "NONE", "LOADING", "SUCCESS", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LoadState extends Enum<LoadState> {
        public static final LoadState LOADING = null;
        public static final LoadState NONE = null;
        public static final LoadState SUCCESS = null;
        public static final /* synthetic */ LoadState[] a = null;

        static {
            LoadState r1 = new LoadState("NONE", 0);
            NONE = r1;
            LoadState r2 = new LoadState("LOADING", 1);
            LOADING = r2;
            LoadState r3 = new LoadState("SUCCESS", 2);
            SUCCESS = r3;
            a = new LoadState[]{r1, r2, r3};
        }

        public static LoadState valueOf(String r1) {
            return (LoadState) r27.a.a(LoadState.class, r1);
        }

        public static LoadState[] values() {
            return (LoadState[]) a.clone();
        }

        public LoadState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public final class b implements com.bytedance.android.shopping.api.mall.feed.e {
        public Map<String, Object> a;
        public final /* synthetic */ OrderListGULView b;

        @Override // com.bytedance.android.shopping.api.mall.feed.e
        public final /* bridge */ /* synthetic */ yj.e Pn() {
            return null;
        }

        @Override // com.bytedance.android.shopping.api.mall.feed.e
        public final Map<String, Object> getGlobalProps() {
            Pair[] r0 = new Pair[1];
            OrderListFragment r1 = this.b.c;
            if (r1 == null) goto L12;
            OrderListViewModel r2 = r1.Y90();
            if (r2 == null) goto L12;
            com.bytedance.android.shopping.orderlist.list.viewmodel.a r3 = r2.getStaticState();
            if (r3 == null) goto L12;
            Integer r4 = r3.l;
            if (r4 == null) goto L12;
            String r5 = String.valueOf(r4.intValue());
            if (r5 == null) goto L12;
        L13:
            r0[0] = TuplesKt.to("current_tab", r5);
            Map<String, Object> r6 = MapsKt.mutableMapOf(r0);
            r6.putAll(a());
            return r6;
        L12:
            r5 = "";
            goto L13
        }

        @Override // com.bytedance.android.shopping.api.mall.feed.e
        public final boolean isDarkMode() {
            return false;
        }

        public final Map<String, Object> a() {
            if (this.a != null) goto L52;
            OrderListFragment r0 = this.b.c;
            String r1 = null;
            if (r0 == null) goto L13;
            OrderListViewModel r2 = r0.Y90();
            if (r2 == null) goto L13;
            com.bytedance.android.shopping.orderlist.list.viewmodel.a r3 = r2.getStaticState();
            if (r3 == null) goto L13;
            OrderListParams r4 = r3.g;
            if (r4 == null) goto L13;
            Map<String, String> r5 = r4.getSchemaParamsMap();
        L14:
            IECMallFeedService r6 = (IECMallFeedService) ServiceManager.get().getService(IECMallFeedService.class);
            if (r6 == null) goto L20;
            ECMallFeedOptService r7 = r6.c();
            if (r7 == null) goto L20;
            Map<String, Object> r8 = r7.b(r5);
            r8.put(PdpOpenThirdParam.KEY_PAGE_NAME, "order_list_page");
            this.a = r8;
            return r8;
        L20:
            LinkedHashMap r9 = new LinkedHashMap();
            boolean r10 = false;
            if (r5 == null) goto L38;
            Set<Map.Entry<String, String>> r11 = r5.entrySet();
            if (r11 == null) goto L38;
            Iterator<T> r12 = r11.iterator();
        L26:
            if (r12.hasNext() == false) goto L38;
            Map.Entry r13 = (Map.Entry) r12.next();
            if ((!StringsKt.isBlank((CharSequence) r13.getKey())) == false) goto L26;
            CharSequence r14 = (CharSequence) r13.getValue();
            if (r14 != null) goto L32;
        L35:
            boolean r15 = true;
        L36:
            if (r15 == true) goto L26;
            Object r16 = r13.getKey();
            Object r17 = r13.getValue();
            Intrinsics.checkNotNull(r17);
            r9.put(r16, r17);
            goto L26
        L32:
            if (StringsKt.isBlank(r14) == true) goto L35;
            r15 = false;
        L38:
            r9.put(PdpOpenThirdParam.KEY_PAGE_NAME, "order_list_page");
            if (r5 == null) goto L41;
            r1 = r5.get("history_path");
        L41:
            if (r1 != null) goto L43;
        L44:
            r10 = true;
        L46:
            if (r10 == false) goto L51;
            if (r5 == null) goto L50;
            r1 = r5.get(SimilarProductParam.ENTER_FROM);
            if (r1 != null) goto L51;
        L50:
            r1 = "";
        L51:
            r9.put(SimilarProductParam.ENTER_FROM, r1);
            Unit r18 = Unit.INSTANCE;
            this.a = r9;
            goto L52
        L43:
            if (StringsKt.isBlank(r1) == false) goto L46;
        L13:
            r5 = null;
        L52:
            Map<String, Object> r19 = this.a;
            if (r19 == null) goto L55;
            return r19;
        L55:
            return new LinkedHashMap();
        }

        @Override // com.bytedance.android.shopping.api.mall.feed.e
        public final boolean oi() {
            OrderListGULView r0 = this.b;
            boolean r1 = r0.p;
            r0.p = false;
            return r1;
        }

        @Override // com.bytedance.android.shopping.api.mall.feed.e
        public final LifecycleOwner s4() {
            LifecycleOwner r0 = ECHybridExtensionsKt.a(this.b.getContext());
            if (r0 == null) goto L7;
            return r0;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }

        public b(OrderListGULView r1) {
            this.b = r1;
        }

        @Override // com.bytedance.android.shopping.api.mall.feed.e
        public final Map<String, Object> PN(String r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "apiKey");
            Intrinsics.checkNotNullParameter(r1, "apiKey");
            return null;
        }

        @Override // com.bytedance.android.shopping.api.mall.feed.e
        public final Map<String, String> Xj(String r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "apiKey");
            Intrinsics.checkNotNullParameter(r1, "apiKey");
            return null;
        }

        @Override // com.bytedance.android.shopping.api.mall.feed.e
        public final void jq(Map<String, ? extends Object> r3, Set<String> r4) {
            LinkedHashMap r0 = new LinkedHashMap();
            r0.putAll(a());
            if (r4 == null) goto L8;
            Iterator<T> r5 = r4.iterator();
        L6:
            if (r5.hasNext() == false) goto L8;
            r0.remove((String) r5.next());
        L8:
            if (r3 == null) goto L10;
            r0.putAll(r3);
        L10:
            this.a = r0;
        }
    }

    public final class c implements f {
        public boolean a;
        public final /* synthetic */ OrderListGULView b;

        public c(OrderListGULView r1) {
            this.b = r1;
        }

        @Override // com.bytedance.android.shopping.api.mall.feed.f
        public final void a(ECMallFeedState r7) {
            Intrinsics.checkNotNullParameter(r7, "state");
            boolean r2 = true;
            switch(d.a[r7.ordinal()]) {
                case 1: goto L18;
                case 2: goto L18;
                case 3: goto L13;
                case 4: goto L13;
                case 5: goto L13;
                case 6: goto L5;
                case 7: goto L5;
                default: goto L38;
            };
        L5:
            this.a = false;
            OrderCommonBusinessMonitor r0 = OrderListGULView.h(this.b);
            if (r0 != null) goto L8;
            return;
        L8:
            if (r7 != ECMallFeedState.INIT_FAILED) goto L10;
            String r8 = "failed on init";
        L11:
            r0.d(r8);
            return;
        L10:
            r8 = "failed on refresh";
            goto L11
        L18:
            OrderCommonBusinessMonitor r1 = OrderListGULView.h(this.b);
            if (r1 == null) goto L22;
            r1.c = System.currentTimeMillis();
            r1.c("load_gul_start", null);
        L22:
            if (OrderListGULView.k(this.b) == true) goto L24;
        L31:
            r2 = false;
        L32:
            this.a = r2;
            return;
        L24:
            if (this.a == false) goto L31;
            if (r7 != ECMallFeedState.REFRESHING) goto L31;
            Lazy r9 = OrderCommonLog.a;
            OrderCommonLog.c("OrderListGULView", OrderListGULView$ECMallFeedStateListener$onLoadSuccessfully$1.INSTANCE);
            OrderCommonBusinessMonitor r10 = OrderListGULView.h(this.b);
            if (r10 == null) goto L30;
            r10.e();
        L30:
            OrderListGULView.n(this.b);
            goto L32
        L38:
            return;
        L13:
            if (this.a == true) goto L36;
            Lazy r11 = OrderCommonLog.a;
            OrderCommonLog.c("OrderListGULView", OrderListGULView$ECMallFeedStateListener$onLoadSuccessfully$1.INSTANCE);
            OrderCommonBusinessMonitor r12 = OrderListGULView.h(this.b);
            if (r12 == null) goto L17;
            r12.e();
        L17:
            OrderListGULView.n(this.b);
            this.a = true;
            return;
        }
    }

    static {
    }

    private final int getChangeTabPrefetchGyl() {
        return ((Number) this.e.getValue()).intValue();
    }

    private final long getChangeTabPrefetchGylExpired() {
        return ((Number) this.f.getValue()).longValue();
    }

    private final int getIgnoreHidGul() {
        return ((Number) this.i.getValue()).intValue();
    }

    private final boolean getMallFeedApiCacheEnable() {
        return ((Boolean) this.h.getValue()).booleanValue();
    }

    private final com.bytedance.android.shopping.api.mall.feed.d getMallFeedComponent() {
        return (com.bytedance.android.shopping.api.mall.feed.d) this.k.getValue();
    }

    private final boolean getMallFeedEnable() {
        return ((Boolean) this.d.getValue()).booleanValue();
    }

    private final ECMallFeedLinkedScrollListener getMallFeedLinkedScrollListener() {
        return (ECMallFeedLinkedScrollListener) this.l.getValue();
    }

    private final int getMonitorOrderListRebuildGyl() {
        return ((Number) this.g.getValue()).intValue();
    }

    public final void g() {
        this.p = true;
    }

    @Override // jg3.b
    public int getGULVerticalOffset() {
        return ((Number) OrderCommonErrorMonitorKt.e(0, new AnonymousClass1(this))).intValue();
    }

    @Override // jg3.b
    public View getView() {
        return this;
    }

    private final OrderCommonBusinessMonitor getBusinessMonitor() {
        OrderListFragment r0 = this.c;
        if (r0 == null) goto L7;
        ig3.a r1 = r0.K;
        if (r1 == null) goto L7;
        return r1.c;
    L7:
        return null;
    }

    @Override // jg3.b
    public final boolean a() {
        return ((Boolean) OrderCommonErrorMonitorKt.e(Boolean.FALSE, new OrderListGULView$canMovingDown$1(this))).booleanValue();
    }

    @Override // jg3.b
    public final boolean b() {
        if (this.m != LoadState.SUCCESS) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // jg3.b
    public final boolean c() {
        return ((Boolean) OrderCommonErrorMonitorKt.e(Boolean.TRUE, new OrderListGULView$canMovingUp$1(this))).booleanValue();
    }

    @Override // jg3.b
    public final boolean isLoading() {
        if (this.m != LoadState.LOADING) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // jg3.b
    public final void show() {
        ViewGroup.LayoutParams r0 = this.a.getLayoutParams();
        if (r0 != null) goto L5;
    L7:
        t(this.a, Integer.valueOf(this.n));
        return;
    L5:
        if (r0.height != this.n) goto L7;
    }

    @Override // jg3.b
    public final void t0() {
        OrderCommonErrorMonitorKt.f(new OrderListGULView$scrollToTop$1(this));
    }

    public final RecyclerView getRecyclerView() {
        if (getMallFeedEnable() == false) goto L9;
        com.bytedance.android.shopping.api.mall.feed.d r0 = getMallFeedComponent();
        if (r0 != null) goto L10;
        return null;
    L10:
        return r0.getFeedView();
    L9:
        return p(this.a);
    }

    public final void r() {
        if (getMallFeedEnable() == true) goto L9;
        OrderListGULComponent r0 = this.b;
        if (r0 == null) goto L9;
        l r1 = r0.a;
        if (r1 == null) goto L9;
        JSONObject r2 = new JSONObject();
        r2.put("visible", false);
        r2.put("timestamp", System.currentTimeMillis());
        Unit r3 = Unit.INSTANCE;
        r1.sendJsEvent("H5_visibilityChange", r2);
    L9:
        u(false);
    }

    @Override // jg3.b
    public final void release() {
        if (getMallFeedEnable() == true) goto L8;
        OrderListGULComponent r0 = this.b;
        if (r0 == null) goto L9;
        r0.release();
        return;
    L9:
        return;
    }

    public final void s() {
        if (getMallFeedEnable() == true) goto L9;
        OrderListGULComponent r0 = this.b;
        if (r0 == null) goto L9;
        l r1 = r0.a;
        if (r1 == null) goto L9;
        JSONObject r2 = new JSONObject();
        r2.put("visible", true);
        r2.put("timestamp", System.currentTimeMillis());
        Unit r3 = Unit.INSTANCE;
        r1.sendJsEvent("H5_visibilityChange", r2);
    L9:
        u(true);
    }

    public static final /* synthetic */ OrderCommonBusinessMonitor h(OrderListGULView r0) {
        return r0.getBusinessMonitor();
    }

    public static final /* synthetic */ int i(OrderListGULView r0) {
        return r0.getChangeTabPrefetchGyl();
    }

    public static final /* synthetic */ long j(OrderListGULView r2) {
        return r2.getChangeTabPrefetchGylExpired();
    }

    public static final /* synthetic */ boolean k(OrderListGULView r0) {
        return r0.getMallFeedApiCacheEnable();
    }

    public static final /* synthetic */ com.bytedance.android.shopping.api.mall.feed.d l(OrderListGULView r0) {
        return r0.getMallFeedComponent();
    }

    public static final /* synthetic */ int m(OrderListGULView r0) {
        return r0.getMonitorOrderListRebuildGyl();
    }

    public static final void n(OrderListGULView r2) {
        r2.getClass();
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListGULView", OrderListGULView$handleGulLoadSuccess$1.INSTANCE);
        r2.t0();
        r2.m = LoadState.SUCCESS;
        Function0<Unit> r1 = r2.r;
        if (r1 == null) goto L5;
        Unit r3 = (Unit) r1.invoke();
    L5:
        r2.r = null;
        Iterator<Function0<Unit>> r4 = r2.s.iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        Function0<Unit> r5 = r4.next();
        if (r5 == null) goto L7;
        Unit r6 = (Unit) r5.invoke();
        goto L7
    L11:
        r2.s.clear();
    }

    public static RecyclerView p(View r2) {
        RecyclerView r1 = null;
        if ((r2 instanceof ViewGroup) == true) goto L5;
        r2 = null;
    L5:
        ViewGroup r3 = (ViewGroup) r2;
        if (r3 == null) goto L16;
        Iterator r4 = com.bytedance.commerce.base.view.b.a(r3).iterator();
    L9:
        if (r4.hasNext() == false) goto L22;
        RecyclerView r0 = (View) r4.next();
        if ((r0 instanceof RecyclerView) == true) goto L21;
        r1 = p(r0);
        if (r1 == null) goto L9;
        return r1;
    L21:
        return r0;
    L22:
        return r1;
    L16:
        return null;
    }

    @Override // jg3.b
    public final void d(Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "disposableCallback");
        if (this.m != LoadState.SUCCESS) goto L5;
        r3.invoke();
        return;
    L5:
        this.r = r3;
    }

    @Override // jg3.b
    public final void e(String r6) {
        Intrinsics.checkNotNullParameter(r6, "tag");
        if (getIgnoreHidGul() != 1) goto L7;
        if (StringsKt.contains$default(r6, "doRefreshYataUI", false, 2, null) == false) goto L7;
        return;
    L7:
        if (StringsKt.contains$default(r6, "doRefreshBeforeGulShow", false, 2, null) == true) goto L16;
        ViewGroup.LayoutParams r7 = this.a.getLayoutParams();
        if (r7 != null) goto L12;
    L14:
        t(this.a, 0);
        return;
    L12:
        if (r7.height != 0) goto L14;
        return;
    }

    @Override // jg3.b
    public final void f(Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "disposableCallback");
        if (this.m != LoadState.SUCCESS) goto L5;
        r3.invoke();
        return;
    L5:
        this.s.add(r3);
    }

    @Override // jg3.b
    public void setGULHeight(int r1) {
        this.n = r1;
    }

    public final void u(boolean r6) {
        int r0 = ECSdk.a;
        IECHostService r1 = (IECHostService) ECSdk.a(IECHostService.class);
        String r2 = null;
        if (r1 == null) goto L5;
        IECHostSearchService r3 = r1.getECHostSearchService();
    L6:
        if (r3 == null) goto L16;
        MALLSCENE r4 = MALLSCENE.MALLSCENE_ORDER_LIST;
        if (r3.showWindWane(r4) == true) goto L10;
        return;
    L10:
        if (this.q == false) goto L18;
        com.bytedance.android.shopping.api.mall.feed.d r5 = getMallFeedComponent();
        if (r5 == null) goto L14;
        r2 = r5.getSceneId();
    L14:
        r3.onUpdatePageState(r6, r2, r4);
        return;
    L18:
        return;
    L16:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void q(OrderListFragment r6, Integer r7) {
        Intrinsics.checkNotNullParameter(r6, "fragment");
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListGULView", OrderListGULView$initOrReload$1.INSTANCE);
        this.c = r6;
        if (this.q == true) goto L9;
        if (r6 == null) goto L9;
        com.bytedance.android.shopping.orderlist.list.container.c r1 = r6.I;
        if (r1 == null) goto L9;
        r1.j(new e(this));
    L9:
        if (this.b != null) goto L11;
        this.b = new OrderListGULComponent(getContext(), r6, this.a);
    L11:
        this.m = LoadState.LOADING;
        this.q = true;
        if (getMallFeedEnable() == true) goto L14;
        OrderListGULComponent r8 = this.b;
        if (r8 == null) goto L55;
        r8.a(new OrderListGULView$initOrReload$4(this));
    L55:
        u(true);
        return;
    L14:
        if (this.o == true) goto L18;
        this.o = true;
        com.bytedance.android.shopping.orderlist.list.container.c r9 = r6.I;
        if (r9 == null) goto L18;
        r9.o(this);
    L18:
        com.bytedance.android.shopping.api.mall.feed.d r10 = getMallFeedComponent();
        if (r10 == null) goto L47;
        ViewParent r2 = getParent();
    L21:
        ViewParent r3 = null;
        if (r2 == null) goto L27;
        if ((r2 instanceof BaseLinkedScrollView) == true) goto L25;
        r2 = r2.getParent();
        goto L21
    L25:
        BaseLinkedScrollView r4 = (BaseLinkedScrollView) r2;
    L28:
        if (r4 == null) goto L30;
        r4.a("ECMallFeed", getMallFeedLinkedScrollListener());
    L30:
        if (r4 != null) goto L36;
        EnsureManager.ensureNotReachHere("OrderListGULView, can not found BaseLinkedScrollView");
        if (ECAppInfoService.e.isLocalTest() == false) goto L36;
        throw new IllegalStateException("OrderListGULView, can not found BaseLinkedScrollView");
    L36:
        View r5 = r10.getView();
        if ((!Intrinsics.areEqual(r5.getParent(), this.a)) == false) goto L46;
        ViewParent r11 = r5.getParent();
        if ((r11 instanceof ViewGroup) == false) goto L42;
        r3 = r11;
    L42:
        ViewGroup r12 = (ViewGroup) r3;
        if (r12 == null) goto L45;
        r12.removeView(r5);
    L45:
        this.a.addView(r5, new FrameLayout.LayoutParams(-1, -1));
    L46:
        r10.a(r7);
        goto L55
    L27:
        r4 = null;
        goto L28
    L47:
        EnsureManager.ensureNotReachHere("OrderListGULView, ECMallFeedComponent is null");
        if (ECAppInfoService.e.isLocalTest() == false) goto L55;
        throw new IllegalStateException("OrderListGULView, ECMallFeedComponent is null");
    }

    @Override // android.view.View, jg3.b
    public final void scrollBy(final int r2, final int r3) {
        OrderCommonErrorMonitorKt.f(new C03001(this, r2, r3));
    }

    public final void t(View r3, Integer r4) {
        int r1 = 0;
        if (r3.getLayoutParams() == null) goto L9;
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if (r4 == null) goto L7;
        r1 = r4.intValue();
    L7:
        r0.height = r1;
    L12:
        r3.requestLayout();
        r3.invalidate();
        return;
    L9:
        if (r4 == null) goto L11;
        r1 = r4.intValue();
    L11:
        r3.setLayoutParams(new FrameLayout.LayoutParams(-1, r1));
        goto L12
    }

    public OrderListGULView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        FrameLayout r5 = new FrameLayout(r2);
        this.a = r5;
        this.d = LazyKt.lazy(OrderListGULView$mallFeedEnable$2.INSTANCE);
        this.e = LazyKt.lazy(OrderListGULView$changeTabPrefetchGyl$2.INSTANCE);
        this.f = LazyKt.lazy(OrderListGULView$changeTabPrefetchGylExpired$2.INSTANCE);
        this.g = LazyKt.lazy(OrderListGULView$monitorOrderListRebuildGyl$2.INSTANCE);
        this.h = LazyKt.lazy(OrderListGULView$mallFeedApiCacheEnable$2.INSTANCE);
        this.i = LazyKt.lazy(OrderListGULView$ignoreHidGul$2.INSTANCE);
        this.k = LazyKt.lazy(new OrderListGULView$mallFeedComponent$2(this, r2));
        this.l = LazyKt.lazy(new OrderListGULView$mallFeedLinkedScrollListener$2(this));
        this.m = LoadState.NONE;
        removeAllViews();
        r5.removeAllViews();
        addView(r5, new FrameLayout.LayoutParams(-1, -2));
        this.s = new CopyOnWriteArrayList();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(final boolean r9, final int r10, final int r11, final int r12, final int r13) {
        OrderCommonErrorMonitorKt.f(new C02991(this, r9, r10, r11, r12, r13));
    }

    public static final /* synthetic */ void o(OrderListGULView r0, boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }
}
