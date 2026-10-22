package com.bytedance.android.shopping.mall.homepage.card.common;

import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.ec.hybrid.ECHybridSettings;
import com.bytedance.android.ec.hybrid.card.api.ECLynxCardErrorType;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxLoadType;
import com.bytedance.android.ec.hybrid.list.ECHybridListAdapter;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECNAMallCardExtra;
import com.bytedance.android.ec.hybrid.list.entity.f;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.hybrid.list.entity.n;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder;
import com.bytedance.android.ec.hybrid.list.view.ECHybridListContainer;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.monitor.ECHybridCardMonitor;
import com.bytedance.android.ec.hybrid.tools.UIToolsKt;
import com.bytedance.android.ec.hybrid.ui.ApertureView;
import com.bytedance.android.ec.hybrid.ui.CusShadowView;
import com.bytedance.android.ec.hybrid.ui.HoleOverlayView;
import com.bytedance.android.ec.vlayout.VirtualLayoutManager;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ECRoundedFrameLayout;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ToolsKt;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.android.shopping.api.mall.common.tools.l;
import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import com.bytedance.android.shopping.mall.homepage.tools.BstUtilsNewKt;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.common.utility.Logger;
import com.bytedance.forest.utils.h;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\tJ\u001e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/common/ECLynxCardMonitorHolder;", "Lcom/bytedance/android/ec/hybrid/list/holder/ECLynxCardHolder;", "Lff3/b;", "", "isCompletelyVisible", "Lkotlin/Function0;", "", "cb", "call", "a", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLynxCardMonitorHolder extends ECLynxCardHolder implements ff3.b {
    public static final int g2 = 0;
    public static final int h2 = 0;
    public static final int p2 = 0;
    public static final Lazy v2 = null;
    public com.bytedance.android.ec.hybrid.monitor.b G1;
    public float H0;
    public final ViewGroup H1;
    public ViewGroup L0;
    public final String L1;
    public final Long M1;
    public HoleOverlayView P0;
    public final Integer P1;
    public final Integer Q1;
    public final MutableLiveData<Float> S1;
    public final Function2<View, ECHybridListItemVO, Unit> T1;
    public ApertureView V0;
    public final ECMallFeed.f V1;
    public boolean W;
    public y93.d X;
    public final Lazy Y;
    public String Z;
    public CusShadowView b1;
    public final /* synthetic */ ff3.a b2;
    public boolean g1;
    public boolean h1;
    public boolean k0;
    public d k1;
    public long p0;
    public final com.bytedance.android.shopping.mall.homepage.card.common.c p1;
    public final Lazy v1;
    public final Lazy x1;
    public final Lazy y1;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ Function0 a;

        public b(Function0 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ ECLynxCardMonitorHolder a;

        public c(ECLynxCardMonitorHolder r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECLynxCardMonitorHolder r0 = this.a;     // Catch: Throwable -> L4
            int r1 = ECLynxCardMonitorHolder.g2;     // Catch: Throwable -> L4
            r0.J4();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements View.OnLayoutChangeListener {
        public final /* synthetic */ ECLynxCardMonitorHolder a;
        public final /* synthetic */ String b;

        public d(ECLynxCardMonitorHolder r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            ECLynxCardMonitorHolder.H4(this.a, this.b);
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ ECLynxCardMonitorHolder a;
        public final /* synthetic */ String b;

        public e(ECLynxCardMonitorHolder r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECLynxCardMonitorHolder.F4(this.a, this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public ECLynxCardMonitorHolder() {
        throw null;
    }

    @Override // ff3.b
    public final View Q1() {
        return this.b2.Q1();
    }

    public final void X3() {
        this.g1 = true;
        I4();
    }

    public final void a4() {
        this.g1 = true;
        I4();
    }

    public final void l4() {
        N4(null);
    }

    @Override // ff3.b
    public final void s3(LottieAnimationView r2, FrameLayout.LayoutParams r3) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r3, "lp");
        this.b2.s3(r2, r3);
    }

    static {
        g2 = b0.c(2);
        h2 = b0.c(5);
        p2 = b0.c(25);
        v2 = LazyKt.lazy(ECLynxCardMonitorHolder$Companion$lynxCardPerfReportEnable$2.INSTANCE);
    }

    public final void I4() {
        if (this.P0 != null) goto L10;
        if (this.V0 != null) goto L10;
        if (this.b1 != null) goto L10;
        return;
    L10:
        if (((Boolean) this.y1.getValue()).booleanValue() == false) goto L12;
        new Handler(Looper.getMainLooper()).post(new c(this));
        return;
    L12:
        J4();
    }

    public final void J4() {
        Lazy r0 = ECMallLogUtil.a;     // Catch: Exception -> L13
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.d.b, "clear all animation view");     // Catch: Exception -> L13
        HoleOverlayView r1 = this.P0;     // Catch: Exception -> L13
        if (r1 == null) goto L5;
        UIToolsKt.b(r1);     // Catch: Exception -> L13
    L5:
        ApertureView r2 = this.V0;     // Catch: Exception -> L13
        if (r2 == null) goto L8;
        UIToolsKt.b(r2);     // Catch: Exception -> L13
    L8:
        CusShadowView r3 = this.b1;     // Catch: Exception -> L13
        if (r3 == null) goto L11;
        UIToolsKt.b(r3);     // Catch: Exception -> L13
    L11:
        this.P0 = null;     // Catch: Exception -> L13
        this.V0 = null;     // Catch: Exception -> L13
        this.b1 = null;     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
    }

    public final void M4() {
        y93.d r1 = this.X;
        if (r1.a == false) goto L5;
        return;
    L5:
        this.X = y93.d.a(r1, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, true, 4194303);
        JSONObject r2 = new JSONObject();
        r2.put("type", "LYNX_RENDER_LOG");
        r2.put("res_version", this.M1);
        int r3 = f93.a.a;
        f93.a.c(r2, (String) this.Y.getValue());
        r2.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        ECHybridListItemVO r4 = ((BaseViewHolder) this).c;
        if (r4 == null) goto L12;
        n r5 = r4.o;
        if (r5 == null) goto L12;
        HashMap r6 = r5.b;
        if (r6 == null) goto L12;
        Object r7 = r6.get("request_id");
    L13:
        r2.put("log_id", r7);
        r2.put("lynx_schema", this.X.f());
        r2.put("error_msg", this.X.b());
        r2.put("perf_dict", this.X.e());
        r2.put("pre_decode", this.X.d());
        String r8 = (String) ((ECLynxCardHolder) this).Q.get("na_page_name");
        String r9 = "";
        if (r8 != null) goto L16;
        r8 = "";
    L16:
        r2.putOpt(PdpOpenThirdParam.KEY_PAGE_NAME, r8);
        String r10 = (String) ((ECLynxCardHolder) this).Q.get(SimilarProductParam.ENTER_FROM);
        if (r10 == null) goto L20;
        r9 = r10;
    L20:
        r2.putOpt(SimilarProductParam.ENTER_FROM, r9);
        JSONObject r11 = tv5.a.b(y93.d.a(this.X, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, false, 8387054));
        Map<String, Object> r12 = this.X.g();
        if (r12 == null) goto L28;
        Iterator<T> r13 = r12.keySet().iterator();
    L24:
        if (r13.hasNext() == false) goto L28;
        String r14 = (String) r13.next();
        Object r15 = r12.get(r14);
        if (r15 == null) goto L24;
        r11.putOpt(r14, r15);
    L28:
        ECHybridListItemVO r16 = ((BaseViewHolder) this).c;
        if (r16 == null) goto L33;
        Integer r17 = r16.c;
        if (r17 == null) goto L33;
        int r18 = r17.intValue();
    L34:
        r11.putOpt("item_type", Integer.valueOf(r18));
        r2.put("detail", r11);
        l.b(l.a, r2, this.P1, false, 12);
        return;
    L33:
        r18 = -2;
    L12:
        r7 = null;
        goto L13
    }

    public final Integer u4() {
        return this.X.c();
    }

    public final void o() {
        super.o();
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        Set<String> r1 = BstUtilsNewKt.a;
        Intrinsics.checkNotNullParameter(this, "$this$cleanMarkBstCardShowMonitor");
        if (r0 != null) goto L5;
        r0 = ((RecyclerView.ViewHolder) this).itemView;
    L5:
        r0.setTag(2131386339, null);
    }

    public final void onHide() {
        super.onHide();
        I4();
    }

    public final void onLoadSuccess() {
        super.onLoadSuccess();
        if (this.k0 == false) goto L6;
        this.W = true;
        this.k0 = false;
        com.bytedance.android.ec.hybrid.list.holder.e r1 = new com.bytedance.android.ec.hybrid.list.holder.e(this.Z, false, System.currentTimeMillis() - this.p0);
        Intrinsics.checkNotNullParameter(r1, "status");
        Intrinsics.checkNotNullParameter(r1, "status");
        ((BaseViewHolder) this).n = r1;
        return;
    }

    public final void onRelease() {
        super.onRelease();
        if (((Boolean) this.v1.getValue()).booleanValue() == false) goto L7;
        MutableLiveData<Float> r0 = this.S1;
        if (r0 == null) goto L7;
        r0.removeObserver(this.p1);
    L7:
        I4();
        d r1 = this.k1;
        if (r1 == null) goto L17;
        ECHybridListAdapter r2 = ((BaseViewHolder) this).g;
        if (r2 == null) goto L18;
        ECHybridListEngine r3 = r2.u;
        if (r3 == null) goto L19;
        ECHybridRecyclerView r4 = r3.b;
        if (r4 == null) goto L20;
        r4.removeOnLayoutChangeListener(r1);
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    }

    public final ViewGroup K4(String r4) {
        if (this.L0 != null) goto L21;
        if (Intrinsics.areEqual(r4, "5") == false) goto L19;
        ViewGroup r5 = this.H1;
        ViewGroup r0 = null;
        if (r5 == null) goto L9;
        ViewParent r6 = r5.getParent();
    L10:
        int r1 = 0;
    L11:
        if (r6 == null) goto L18;
        if (r1 >= 10) goto L18;
        if ((r6 instanceof ECHybridListContainer) == true) goto L16;
        r6 = r6.getParent();
        r1 = r1 + 1;
        goto L11
    L16:
        r0 = (ViewGroup) r6;
    L18:
        this.L0 = r0;
        goto L21
    L9:
        r6 = null;
        goto L10
    L19:
        this.L0 = this.V1.ex();
    L21:
        return this.L0;
    }

    public final void N4(Integer r7) {
        ViewGroup r0 = null;
        C4(null);
        ECHybridListItemVO r1 = ((BaseViewHolder) this).c;
        if (r1 == null) goto L7;
        com.bytedance.android.ec.hybrid.list.entity.e r2 = r1.L;
        if (r2 == null) goto L7;
        Integer r3 = r2.c;
    L8:
        if (r1 == null) goto L12;
        com.bytedance.android.ec.hybrid.list.entity.e r4 = r1.L;
        if (r4 == null) goto L12;
        List r5 = r4.b;
    L13:
        if (r3 == null) goto L50;
        if (r5 == null) goto L50;
        if (r5.size() != 4) goto L50;
        if (r7 == null) goto L19;
        int r8 = r7.intValue();
    L21:
        if (r3.intValue() != (-1)) goto L23;
    L27:
        ViewGroup r9 = this.H1;
        if ((r9 instanceof ECRoundedFrameLayout) == false) goto L31;
        r0 = r9;
    L31:
        ECRoundedFrameLayout r6 = (ECRoundedFrameLayout) r0;
        if (r6 == null) goto L64;
        Float r10 = (Float) CollectionsKt.getOrNull(r5, 0);
        float r11 = 0.0f;
        if (r10 == null) goto L36;
        float r12 = b0.c(r10) * this.H0;
    L37:
        Float r13 = (Float) CollectionsKt.getOrNull(r5, 1);
        if (r13 == null) goto L40;
        float r14 = b0.c(r13) * this.H0;
    L41:
        Float r15 = (Float) CollectionsKt.getOrNull(r5, 2);
        if (r15 == null) goto L44;
        float r16 = b0.c(r15) * this.H0;
    L45:
        Float r17 = (Float) CollectionsKt.getOrNull(r5, 3);
        if (r17 == null) goto L48;
        r11 = this.H0 * b0.c(r17);
    L48:
        r6.a(r12, r14, r16, r11);
        return;
    L44:
        r16 = 0.0f;
        goto L45
    L40:
        r14 = 0.0f;
        goto L41
    L36:
        r12 = 0.0f;
        goto L37
    L64:
        return;
    L23:
        if (r3.intValue() <= 0) goto L50;
        if (r8 < 0) goto L50;
        if (r8 >= r3.intValue()) goto L50;
    L19:
        r8 = ToolsKt.g(this);
    L50:
        ECHybridListItemVO r18 = ((BaseViewHolder) this).c;
        if (r18 == null) goto L65;
        com.bytedance.android.ec.hybrid.list.entity.e r19 = r18.L;
        if (r19 == null) goto L66;
        Double r20 = r19.a;
        if (r20 == null) goto L67;
        double r21 = r20.doubleValue();
        ViewGroup r22 = this.H1;
        if ((r22 instanceof ECRoundedFrameLayout) == false) goto L60;
        r0 = r22;
    L60:
        ECRoundedFrameLayout r23 = (ECRoundedFrameLayout) r0;
        if (r23 == null) goto L68;
        r23.setRadius(b0.c(Double.valueOf(r21)) * this.H0);
        return;
    L68:
        return;
    L67:
        return;
    L66:
        return;
    L65:
        return;
    L12:
        r5 = null;
    L7:
        r3 = null;
        goto L8
    }

    public final void onCreateKitViewEnd(long r23) {
        this.X = y93.d.a(this.X, null, null, null, null, null, null, null, null, null, null, null, Long.valueOf(r23), null, null, null, null, null, 0, false, 8384511);
    }

    public final void onReceivedError(com.bytedance.lynx.service.model.b r3) {
        StringBuilder r4 = new StringBuilder("schema: ");
        k.a r0 = ((BaseViewHolder) this).e;
        Integer r1 = null;
        if (r0 == null) goto L7;
        f r2 = r0.a;
        if (r2 == null) goto L7;
        String r5 = r2.a;
    L8:
        r4.append(r5);
        r4.append(" , itemType: ");
        ECHybridListItemVO r6 = ((BaseViewHolder) this).c;
        if (r6 == null) goto L11;
        r1 = r6.c;
    L11:
        r4.append(r1);
        Logger.d("puffone-ECLynxCardMonitorHolder.onReceivedError()", r4.toString());
        return;
    L7:
        r5 = null;
        goto L8
    }

    public final void onTimingSetup(Map<String, ? extends Object> r27) {
        super.onTimingSetup(r27);
        Object r1 = null;
        if (r27 == null) goto L5;
        Object r2 = r27.get("setup_timing");
    L7:
        if ((r2 instanceof Map) == true) goto L9;
        r2 = null;
    L9:
        Map r11 = (Map) r2;
        if (r11 != null) goto L12;
        return;
    L12:
        ECLynxCardHolder.BindType r3 = ECLynxCardHolder.BindType.UNKNOWN;
        Object r4 = r27.get("ec_session");
        if ((r4 instanceof xj.a) == true) goto L15;
        r4 = null;
    L15:
        xj.a r5 = (xj.a) r4;
        int r6 = 1;
        if (r5 == null) goto L30;
        r5.c.getClass();
        Long r7 = Long.valueOf(r5.a);
        int r8 = r5.g;
        ECLynxLoadType r9 = r5.f;
        if (r9 == null) goto L29;
        int r10 = com.bytedance.android.shopping.mall.homepage.card.common.b.a[r9.ordinal()];
        if (r10 == 1) goto L28;
        if (r10 != 2) goto L24;
        r3 = ECLynxCardHolder.BindType.PRE_CREATE;
        goto L29
    L24:
        if (r10 != 3) goto L29;
        r3 = ECLynxCardHolder.BindType.PRE_LOAD;
        goto L29
    L28:
        r3 = ECLynxCardHolder.BindType.DEFAULT;
    L29:
        Long r16 = r7;
        int r19 = r8;
    L31:
        y93.d r12 = this.X;
        Object r13 = r11.get("draw_end");
        if ((r13 instanceof Long) == true) goto L34;
        r13 = null;
    L34:
        Long r14 = (Long) r13;
        Object r15 = r11.get("load_template_start");
        if ((r15 instanceof Long) == false) goto L38;
        r1 = r15;
    L38:
        Long r17 = (Long) r1;
        if (this.W == true) goto L42;
        r6 = 2;
    L42:
        this.X = y93.d.a(r12, null, null, 1, null, null, r17, r14, Integer.valueOf(r6), r27, r11, null, null, null, null, r16, null, Integer.valueOf(r3.ordinal()), r19, false, 4356379);
        M4();
        return;
    L30:
        r16 = null;
        r19 = -1;
        goto L31
    L5:
        r2 = null;
        goto L7
    }

    public static final void E4(ECLynxCardMonitorHolder r2, View r3) {
        r2.getClass();
        if (r3 == null) goto L14;
        ViewPropertyAnimator r4 = r3.animate();
        if (r4 == null) goto L15;
        ViewPropertyAnimator r5 = r4.alpha(0.0f);
        if (r5 == null) goto L16;
        ViewPropertyAnimator r6 = r5.setDuration(300);
        if (r6 == null) goto L17;
        ViewPropertyAnimator r7 = r6.setListener(new com.bytedance.android.shopping.mall.homepage.card.common.d(r2));
        if (r7 == null) goto L18;
        r7.start();
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    public static final void F4(final ECLynxCardMonitorHolder r8, final String r9) {
        if (r8.g1 == false) goto L5;
        Lazy r10 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.d.b, "current page has leave, do not start animation");
        return;
    L5:
        final ViewGroup r0 = r8.K4(r9);
        if (r0 == null) goto L97;
        ECHybridListAdapter r1 = ((BaseViewHolder) r8).g;
        if (r1 == null) goto L93;
        ECHybridListEngine r2 = r1.u;
        if (r2 == null) goto L94;
        ECHybridRecyclerView r3 = r2.b;
        if (r3 == null) goto L95;
        VirtualLayoutManager r4 = r3.getLayoutManager();
        if (r4 == null) goto L98;
        Iterator<T> r5 = b0.b(r0).iterator();
    L19:
        if (r5.hasNext() == false) goto L23;
        Object r6 = r5.next();
        if ((((View) r6) instanceof HoleOverlayView) == false) goto L19;
    L25:
        if ((r6 instanceof HoleOverlayView) == true) goto L27;
        r6 = null;
    L27:
        HoleOverlayView r7 = (HoleOverlayView) r6;
        Iterator<T> r11 = b0.b(r0).iterator();
    L29:
        if (r11.hasNext() == false) goto L33;
        Object r12 = r11.next();
        if ((((View) r12) instanceof ApertureView) == false) goto L29;
    L35:
        if ((r12 instanceof ApertureView) == true) goto L37;
        r12 = null;
    L37:
        ApertureView r13 = (ApertureView) r12;
        Iterator<T> r14 = b0.b(r0).iterator();
    L39:
        if (r14.hasNext() == false) goto L43;
        Object r15 = r14.next();
        if ((((View) r15) instanceof CusShadowView) == false) goto L39;
    L45:
        if ((r15 instanceof CusShadowView) == true) goto L47;
        r15 = null;
    L47:
        CusShadowView r16 = (CusShadowView) r15;
        if (r7 != null) goto L75;
        if (r13 != null) goto L75;
        if (r16 != null) goto L75;
        Lazy r17 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.d.b, "start animation, cardAnimationType = " + r9);
        int r18 = r4.findFirstCompletelyVisibleItemPosition();
        int r19 = r4.findLastCompletelyVisibleItemPosition();
        if (r8.getAdapterPosition() < 0) goto L59;
        int r20 = r8.getAdapterPosition();
        if (r18 > r20) goto L59;
        if (r19 < r20) goto L59;
        boolean r21 = true;
    L60:
        if (r21 == true) goto L70;
        ECHybridListAdapter r22 = ((BaseViewHolder) r8).g;
        if (r22 == null) goto L68;
        ECHybridListEngine r23 = r22.u;
        if (r23 == null) goto L68;
        ECHybridRecyclerView r24 = r23.b;
        if (r24 == null) goto L68;
        r24.scrollToPosition(0);
    L68:
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.a.g.b, "item covered, scroll to top");
    L70:
        if (Intrinsics.areEqual(r9, "1") == false) goto L72;
    L73:
        r0.postDelayed(new com.bytedance.android.shopping.mall.homepage.card.common.e(r8), 3500);
        HoleOverlayView r25 = new HoleOverlayView(r8.H1.getContext(), null);
        r8.P0 = r25;
        r0.addView(r25);
    L74:
        r8.call(r21, new ECLynxCardMonitorHolder$startAnimation$2(r8, r0, r9));
        return;
    L72:
        if (Intrinsics.areEqual(r9, "2") == false) goto L74;
    L59:
        r21 = false;
    L75:
        if (r7 == null) goto L77;
        UIToolsKt.b(r7);
    L77:
        if (r13 == null) goto L79;
        UIToolsKt.b(r13);
    L79:
        if (r16 == null) goto L81;
        UIToolsKt.b(r16);
    L81:
        Lazy r26 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.d.b, "animation view has exit");
        return;
    L43:
        r15 = null;
        goto L45
    L33:
        r12 = null;
        goto L35
    L23:
        r6 = null;
        goto L25
    L98:
        return;
    L95:
        return;
    L94:
        return;
    L93:
        return;
    }

    public static final void H4(ECLynxCardMonitorHolder r31, String r32) {
        if (r31.P0 == null) goto L5;
    L9:
        ViewGroup r1 = r31.K4(r32);
        Point r2 = L4(r31.H1, r1);
        if (r1 == null) goto L22;
        if (r2 == null) goto L22;
        HoleOverlayView r3 = r31.P0;
        if (r3 == null) goto L16;
        r3.a(r2.x, r2.y + 2, r31.H1.getWidth(), r31.H1.getHeight());
    L16:
        ApertureView r7 = r31.V0;
        if (r7 == null) goto L19;
        int r4 = r2.x;
        int r5 = g2;
        ToolsKt.A(r7, 0.0f, null, null, null, Integer.valueOf(r4 - r5), Integer.valueOf((r2.y - r5) + 2), null, null, false, null, 975);
    L19:
        CusShadowView r0 = r31.b1;
        if (r0 == null) goto L24;
        ToolsKt.A(r0, 0.0f, null, null, null, Integer.valueOf(r2.x - h2), Integer.valueOf((r2.y - p2) + 2), null, null, false, null, 975);
        return;
    L24:
        return;
    L22:
        r31.I4();
        return;
    L5:
        if (r31.V0 != null) goto L9;
        if (r31.b1 != null) goto L9;
    }

    public static Point L4(View r2, View r3) {
        if (r2 == null) goto L7;
        if (r3 == null) goto L9;
        int[] r1 = new int[2];
        int[] r0 = new int[2];
        r3.getLocationOnScreen(r1);
        r2.getLocationOnScreen(r0);
        return new Point(r0[0] - r1[0], r0[1] - r1[1]);
    L9:
        return null;
    L7:
        return null;
    }

    private final void call(boolean r2, Function0<Unit> r3) {
        if (r2 == false) goto L4;
        r3.invoke();
        return;
    L4:
        this.H1.post(new b(r3));
    }

    public final void onTransDataTime(long r23, long r25) {
        this.X = y93.d.a(this.X, null, null, null, null, null, null, null, null, null, null, null, null, Long.valueOf(r23), Long.valueOf(r25), null, null, null, 0, false, 8364031);
    }

    public final void b4(Object r37, String r38, k.a r39) {
        Intrinsics.checkNotNullParameter(r38, "itemId");
        long r7 = System.currentTimeMillis();
        this.X = y93.d.a(this.X, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Long.valueOf(r7), null, 0, false, 8257535);
        String r4 = null;
        if (r39 == null) goto L7;
        f r0 = r39.a;
        if (r0 == null) goto L7;
        String r1 = r0.a;
    L8:
        this.Z = r1;
        if (ECHybridSettings.a() == false) goto L11;
        ((ECLynxCardHolder) this).u = new ECLynxCardMonitorHolder$onBind$1(this);
    L11:
        ECHybridListItemVO r2 = ((BaseViewHolder) this).c;
        boolean r5 = false;
        if (r2 != null) goto L14;
    L16:
        boolean r13 = false;
    L17:
        if (r2 != null) goto L19;
    L21:
        boolean r14 = false;
    L22:
        int r3 = h.a;
        if (r39 == null) goto L27;
        f r6 = r39.a;
        if (r6 == null) goto L27;
        String r8 = r6.a;
    L29:
        if (h.a(r8) == false) goto L32;
        Intrinsics.checkNotNull(r39);
        f r9 = r39.a;
        Intrinsics.checkNotNull(r9);
        f r10 = r39.a;
        Intrinsics.checkNotNull(r10);
        String r11 = r10.a;
        Intrinsics.checkNotNull(r11);
        r9.a = ToolsKt.n(r11, this.Q1);
    L32:
        if (ECHybridSettings.a() == true) goto L35;
        if (r39 == null) goto L35;
        r39.c = new ECLynxCardMonitorHolder$onBind$$inlined$apply$lambda$1(this);
    L35:
        Unit r12 = Unit.INSTANCE;
        super.b4(r37, r38, r39);
        if (r13 == true) goto L38;
    L40:
        Function2<View, ECHybridListItemVO, Unit> r15 = this.T1;
        if (r15 == null) goto L43;
        Unit r16 = (Unit) r15.invoke(((RecyclerView.ViewHolder) this).itemView, ((BaseViewHolder) this).c);
    L43:
        View r17 = ((RecyclerView.ViewHolder) this).itemView;
        Set<String> r18 = BstUtilsNewKt.a;
        Intrinsics.checkNotNullParameter(this, "$this$markBstCardShowMonitor");
        View r19 = ((RecyclerView.ViewHolder) this).itemView;
        Intrinsics.checkNotNullParameter(this, "$this$cleanMarkBstCardShowMonitor");
        if (r19 != null) goto L46;
        r19 = ((RecyclerView.ViewHolder) this).itemView;
    L46:
        r19.setTag(2131386339, null);
        String r20 = BstUtilsNewKt.d(this);
        if (r20 != null) goto L49;
    L50:
        r5 = true;
    L51:
        if (r5 == true) goto L56;
        if (r17 != null) goto L55;
        r17 = ((RecyclerView.ViewHolder) this).itemView;
    L55:
        r17.setTag(2131386339, "bst_mark");
    L56:
        y93.d r110 = this.X;
        if (r39 == null) goto L61;
        f r21 = r39.a;
        if (r21 == null) goto L61;
        String r111 = r21.a;
    L62:
        ECHybridListItemVO r22 = ((BaseViewHolder) this).c;
        if (r22 == null) goto L65;
        Integer r112 = r22.c;
    L66:
        this.X = y93.d.a(r110, r111, r112, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(((ECLynxCardHolder) this).H.ordinal()), ((BaseViewHolder) this).k, false, 5242876);
        StringBuilder r23 = new StringBuilder("schema: ");
        if (r39 == null) goto L71;
        f r24 = r39.a;
        if (r24 == null) goto L71;
        String r25 = r24.a;
    L72:
        r23.append(r25);
        r23.append(" , itemType: ");
        ECHybridListItemVO r26 = ((BaseViewHolder) this).c;
        if (r26 == null) goto L75;
        Integer r27 = r26.c;
    L76:
        r23.append(r27);
        Logger.d("puffone-ECLynxCardMonitorHolder.onBind()", r23.toString());
        int r28 = ToolsKt.g(this);
        N4(Integer.valueOf(r28));
        ECHybridListItemVO r29 = ((BaseViewHolder) this).c;
        if (r29 == null) goto L81;
        ECNAMallCardExtra r30 = r29.c();
        if (r30 == null) goto L81;
        String r31 = r30.getCardAnimationType();
    L83:
        if (h.a(r31) == true) goto L85;
    L106:
        long r32 = System.currentTimeMillis();
        com.bytedance.android.ec.hybrid.monitor.b r33 = this.G1;
        String r34 = ((ECLynxCardHolder) this).N;
        String r35 = "";
        if (r34 != null) goto L109;
        r34 = "";
    L109:
        ECHybridListItemVO r113 = ((BaseViewHolder) this).c;
        if (r113 == null) goto L115;
        Integer r114 = r113.c;
        if (r114 == null) goto L115;
        String r115 = String.valueOf(r114.intValue());
        if (r115 == null) goto L115;
    L116:
        if (r39 == null) goto L120;
        f r36 = r39.a;
        if (r36 == null) goto L120;
        r4 = r36.a;
    L120:
        if (r4 == null) goto L123;
        r35 = r4;
    L123:
        r33.getClass();
        Intrinsics.checkNotNullParameter(r34, "pageName");
        Intrinsics.checkNotNullParameter(r115, "cardName");
        Intrinsics.checkNotNullParameter(r35, "cardUrl");
        com.bytedance.android.ec.hybrid.monitor.b r40 = new com.bytedance.android.ec.hybrid.monitor.b(r34, r115, r35, r28, r7, r32, r32 - r7, r13, r14);
        this.G1 = r40;
        ECHybridCardMonitor.a(r40);
        return;
    L115:
        r115 = "";
        goto L116
    L85:
        if (CollectionsKt.contains(SetsKt.setOf(new String[]{"1", "2", "5"}), r31) == false) goto L106;
        ECHybridListItemVO r41 = ((BaseViewHolder) this).c;
        if (r41 == null) goto L106;
        if (r41.w == true) goto L106;
        Lazy r42 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.d.b, "enter to handle animation process");
        ECHybridListItemVO r43 = ((BaseViewHolder) this).c;
        if (r43 == null) goto L95;
        ECNAMallCardExtra r44 = r43.c();
        if (r44 == null) goto L95;
        r44.setCardAnimationType(null);
    L95:
        d r45 = new d(this, r31);
        this.k1 = r45;
        ECHybridListAdapter r46 = ((BaseViewHolder) this).g;
        if (r46 == null) goto L125;
        ECHybridListEngine r47 = r46.u;
        if (r47 == null) goto L125;
        ECHybridRecyclerView r48 = r47.b;
        if (r48 == null) goto L125;
        r48.addOnLayoutChangeListener(r45);
    L125:
        this.H1.post(new e(this, r31));     // Catch: Exception -> L104
    L104:
        e = move-exception;
        I4();
        EnsureManager.ensureNotReachHere(e);
    L81:
        r31 = null;
        goto L83
    L75:
        r27 = null;
    L71:
        r25 = null;
        goto L72
    L65:
        r112 = null;
    L61:
        r111 = null;
        goto L62
    L49:
        if (r20.length() != 0) goto L51;
    L38:
        if (((Boolean) v2.getValue()).booleanValue() == false) goto L40;
        int r49 = ze3.a.a;
        Intrinsics.checkNotNullParameter(new ECLynxCardMonitorHolder$onBind$3(this), "entryMapCallback");
    L27:
        r8 = null;
        goto L29
    L19:
        if (r2.w != true) goto L21;
        r14 = true;
        goto L22
    L14:
        if (r2.K != true) goto L16;
        r13 = true;
    L7:
        r1 = null;
        goto L8
    }

    public final void d4(boolean r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "source");
        Intrinsics.checkNotNullParameter(r4, "pageSource");
        super.d4(r2, r3, r4);
        if (r2 == true) goto L8;
        this.g1 = true;
        if (this.h1 == true) goto L9;
        I4();
        return;
    L9:
        return;
    }

    public final void g1(int r3, int r4, double r5) {
        HoleOverlayView r6 = this.P0;
        if (r6 == null) goto L5;
        r6.b.offset(-r3, -r4);
        r6.invalidate();
    L5:
        ApertureView r7 = this.V0;
        ViewGroup.LayoutParams r8 = null;
        if (r7 == null) goto L13;
        ViewGroup.LayoutParams r0 = r7.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == true) goto L10;
        r0 = null;
    L10:
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        if (r1 == null) goto L13;
        r1.leftMargin -= r3;
        r1.topMargin -= r4;
        r7.requestLayout();
    L13:
        CusShadowView r9 = this.b1;
        if (r9 == null) goto L23;
        ViewGroup.LayoutParams r2 = r9.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L19;
        r8 = r2;
    L19:
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r8;
        if (r10 == null) goto L24;
        r10.leftMargin -= r3;
        r10.topMargin -= r4;
        r9.requestLayout();
        return;
    L24:
        return;
    }

    public final void g4(String r3, Integer r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "scheme");
        this.Z = r3;
        this.k0 = true;
        this.p0 = System.currentTimeMillis();
        super.g4(ToolsKt.n(r3, this.Q1), r4, r5);
    }

    public final void onLoadFailed(ECLynxCardErrorType r24, Integer r25, String r26) {
        Intrinsics.checkNotNullParameter(r24, "type");
        super.onLoadFailed(r24, r25, r26);
        y93.d r2 = this.X;
        if (this.W == false) goto L5;
        int r1 = 1;
    L6:
        this.X = y93.d.a(r2, null, null, 0, r25, r26, null, null, Integer.valueOf(r1), null, null, null, null, null, null, null, null, null, 0, false, 8388451);
        M4();
        return;
    L5:
        r1 = 2;
        goto L6
    }

    public ECLynxCardMonitorHolder(ECMallFeed.h r18, String r19, Long r20, Integer r21, Integer r22, com.bytedance.android.ec.hybrid.list.entity.l.b r23, String r24, Lifecycle r25, ECLynxCardHolder.a r26, Map r27, String r28, ik.a r29, MutableLiveData r30, Function2 r31, LifecycleOwner r32, ECMallFeed.f r33, boolean r34) {
        Intrinsics.checkNotNullParameter(r18, "viewGroup");
        Intrinsics.checkNotNullParameter(r19, "sceneID");
        Intrinsics.checkNotNullParameter(r23, "pageType");
        Intrinsics.checkNotNullParameter(r27, "lynxConsumerMonitor");
        Intrinsics.checkNotNullParameter(r33, "containerAbility");
        super(r18, r19, r23, r24, r25, r26, r27, r28, r29, false, r34);
        this.b2 = new ff3.a(r18);
        this.H1 = r18;
        this.L1 = r19;
        this.M1 = r20;
        this.P1 = r21;
        this.Q1 = r22;
        this.S1 = r30;
        this.T1 = r31;
        this.V1 = r33;
        this.X = new y93.d(null, "feed", 8388351);
        this.Y = LazyKt.lazy(new ECLynxCardMonitorHolder$defaultBTM$2(this));
        this.p0 = -1;
        this.H0 = 1.0f;
        com.bytedance.android.shopping.mall.homepage.card.common.c r0 = new com.bytedance.android.shopping.mall.homepage.card.common.c(this);
        this.p1 = r0;
        this.v1 = LazyKt.lazy(ECLynxCardMonitorHolder$memoryLeakFix$2.INSTANCE);
        this.x1 = LazyKt.lazy(ECLynxCardMonitorHolder$animationDurationConfig$2.INSTANCE);
        this.y1 = LazyKt.lazy(ECLynxCardMonitorHolder$removeAnimationFix$2.INSTANCE);
        if (r32 == null) goto L6;
        if (r30 == null) goto L6;
        r30.observe(r32, r0);
    L6:
        this.G1 = new com.bytedance.android.ec.hybrid.monitor.b(0);
    }
}
