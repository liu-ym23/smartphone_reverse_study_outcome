package com.bytedance.android.shopping.mall.homepage.card.video;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.list.ability.v;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.ec.hybrid.tools.TransitionAnimationHelper;
import com.bytedance.android.ec.hybrid.ui.IHybridVideoBoxView;
import com.bytedance.android.shopping.api.mall.common.homepage.card.BigFontAdapter;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$CommonColorStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$CusTextStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$LayoutStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$ModuleDesc;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$Product;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$User;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ECGradientView;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ECRoundedConstraintLayout;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ECRoundedCornerImageView;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ECRoundedFrameLayout;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ECUpdateHeightConstraintLayout;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ToolsKt;
import com.bytedance.android.shopping.api.mall.common.homepage.card.video.VideoCardData;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.android.shopping.api.mall.common.tools.p;
import com.bytedance.android.shopping.mall.homepage.card.AbstractNativeCard;
import com.bytedance.android.shopping.mall.homepage.card.common.BottomInfoView;
import com.bytedance.android.shopping.mall.homepage.card.common.BottomInfoViewForVideo;
import com.bytedance.android.shopping.mall.homepage.card.common.LiveHeaderView;
import com.bytedance.android.shopping.mall.homepage.card.common.ProductView;
import com.bytedance.android.shopping.mall.homepage.card.common.feedback.FeedbackView;
import com.bytedance.android.shopping.mall.homepage.tools.LastActionRecorderKt;
import com.bytedance.android.shopping.mall.homepage.tools.d0;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import yj.i;
import yj.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/video/NativeVideoCard;", "Lcom/bytedance/android/shopping/mall/homepage/card/AbstractNativeCard;", "Lff3/b;", "a", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NativeVideoCard extends AbstractNativeCard implements ff3.b {
    public static final /* synthetic */ int T1 = 0;
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public final Lazy D;
    public final Lazy E;
    public final Lazy F;
    public final Lazy G;
    public final String G1;
    public final Lazy H;
    public final Lazy H0;
    public final Function0<Unit> H1;
    public final Lazy I;
    public final Lazy J;
    public final Lazy K;
    public final Lazy L;
    public final Lazy L0;
    public final boolean L1;
    public final Lazy M;
    public final MutableLiveData<Float> M1;
    public LiveHeaderView N;
    public VideoCardData O;
    public VideoCardModel P;
    public final Lazy P0;
    public final com.bytedance.android.shopping.api.mall.idl.c P1;
    public IHybridVideoBoxView Q;
    public final Function0<Boolean> Q1;
    public String R;
    public boolean S;
    public final /* synthetic */ ff3.a S1;
    public int T;
    public final Lazy U;
    public long V;
    public final Lazy V0;
    public long W;
    public boolean X;
    public final com.bytedance.android.shopping.mall.homepage.card.video.a Y;
    public final Lazy Z;
    public final Lazy b1;
    public boolean g1;
    public final boolean h1;
    public final Lazy k0;
    public final Integer k1;
    public final f p0;
    public final com.bytedance.android.shopping.mall.homepage.card.live.e p1;
    public com.bytedance.android.ec.hybrid.card.api.e u;
    public com.bytedance.android.ec.hybrid.card.api.e v;
    public final g93.a v1;
    public final Lazy w;
    public final Lazy x;
    public final com.bytedance.android.ec.hybrid.card.api.f x1;
    public final Lazy y;
    public final String y1;
    public final Lazy z;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ NativeVideoCard a;
        public final /* synthetic */ float b;

        public b(NativeVideoCard r1, float r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            NativeVideoCard r0 = this.a;     // Catch: Throwable -> L7
            com.bytedance.android.ec.hybrid.card.api.e r1 = r0.u;     // Catch: Throwable -> L7
            int r2 = (int) (r0.T * this.b);     // Catch: Throwable -> L7
            Lazy r3 = ToolsKt.a;     // Catch: Throwable -> L7
            Intrinsics.checkNotNullParameter(r0, "$this$updateWindVaneExtra");     // Catch: Throwable -> L7
            if (r1 == null) goto L10;
            Map<String, Object> r4 = ToolsKt.c(r0, r2);     // Catch: Throwable -> L7
            int r5 = com.bytedance.android.ec.hybrid.card.api.d.e;     // Catch: Throwable -> L7
            r1.e(com.bytedance.android.ec.hybrid.card.api.d.a.c("", r4), false);     // Catch: Throwable -> L7
            return;
        L10:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        }
    }

    static {
    }

    public final BottomInfoViewForVideo A4() {
        return (BottomInfoViewForVideo) this.I.getValue();
    }

    public final FrameLayout B4() {
        return (FrameLayout) this.E.getValue();
    }

    public final boolean C3() {
        return true;
    }

    public final ProductView C4() {
        return (ProductView) this.G.getValue();
    }

    public final ECUpdateHeightConstraintLayout E4() {
        return (ECUpdateHeightConstraintLayout) this.w.getValue();
    }

    public final SimpleDraweeView F4() {
        return (SimpleDraweeView) this.z.getValue();
    }

    public final TextView H4() {
        return (TextView) this.B.getValue();
    }

    public final ECRoundedFrameLayout I4() {
        return (ECRoundedFrameLayout) this.x.getValue();
    }

    public final FrameLayout J4() {
        return (FrameLayout) this.D.getValue();
    }

    @Override // ff3.b
    public final View Q1() {
        return this.S1.Q1();
    }

    @Override // com.bytedance.android.shopping.mall.homepage.card.AbstractNativeCard
    public final String q4() {
        return "4";
    }

    @Override // ff3.b
    public final void s3(LottieAnimationView r2, FrameLayout.LayoutParams r3) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r3, "lp");
        this.S1.s3(r2, r3);
    }

    @Override // com.bytedance.android.shopping.mall.homepage.card.AbstractNativeCard
    public final int s4() {
        return 4;
    }

    public final void D() {
        ((BaseViewHolder) this).a = IHybridListViewHolder.ECCardPlayState.IDLE;
        if (this.X == true) goto L5;
    L8:
        K4();
        return;
    L5:
        if (this.h1 == false) goto L8;
        this.X = false;
    }

    public final void K4() {
        IHybridVideoBoxView r0 = this.Q;
        if (r0 != null) goto L19;
        return;
    L19:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        if (r0 == null) goto L8;
        r0.f();     // Catch: Throwable -> L13
    L8:
        IHybridVideoBoxView r2 = this.Q;     // Catch: Throwable -> L13
        if (r2 == null) goto L11;
        r2.a();     // Catch: Throwable -> L13
    L11:
        I4().removeView(this.Q);     // Catch: Throwable -> L13
        I4().removeAllViews();     // Catch: Throwable -> L13
        this.Q = null;     // Catch: Throwable -> L13
        j4(IHybridListViewHolder.ECCardPlayState.IDLE);     // Catch: Throwable -> L13
        ((BaseViewHolder) this).j = false;     // Catch: Throwable -> L13
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L21;
        EnsureManager.ensureNotReachHere(r4);
        return;
    L21:
        return;
    L13:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    public final void L4() {
        Lazy r0 = BigFontAdapter.a;
        if (BigFontAdapter.c(ToolsKt.k(this)) == false) goto L6;
        BigFontAdapter.e((View) this.L.getValue(), 6);
        A4().T5();
        return;
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [android.view.ViewGroup, com.bytedance.android.shopping.api.mall.common.homepage.card.common.ECRoundedConstraintLayout, com.bytedance.android.shopping.api.mall.common.homepage.card.common.ECUpdateHeightConstraintLayout] */
    public final void O4() {
        ECHybridListItemVO r0 = ((BaseViewHolder) this).c;
        List r1 = null;
        if (r0 == null) goto L8;
        com.bytedance.android.ec.hybrid.list.entity.e r2 = r0.L;
        if (r2 == null) goto L8;
        Double r3 = r2.a;
        if (r3 == null) goto L8;
    L14:
        if (r3 == null) goto L16;
        double r4 = r3.doubleValue();
    L17:
        Lazy r5 = TransitionAnimationHelper.a;
        TransitionAnimationHelper.e(J4(), ((float) r4) * this.s, false);
        ECHybridListItemVO r6 = ((BaseViewHolder) this).c;
        if (r6 == null) goto L22;
        com.bytedance.android.ec.hybrid.list.entity.e r7 = r6.L;
        if (r7 == null) goto L22;
        Integer r8 = r7.c;
    L23:
        if (r6 == null) goto L27;
        com.bytedance.android.ec.hybrid.list.entity.e r9 = r6.L;
        if (r9 == null) goto L27;
        r1 = r9.b;
    L27:
        if (r8 == null) goto L55;
        if (r1 == null) goto L55;
        if (r1.size() != 4) goto L55;
        int r10 = ToolsKt.g(this);
        if (r8.intValue() != (-1)) goto L34;
    L38:
        ?? r11 = E4();
        Float r12 = (Float) CollectionsKt.getOrNull(r1, 0);
        float r13 = 0.0f;
        if (r12 == null) goto L41;
        float r14 = b0.c(r12) * this.s;
    L42:
        Float r15 = (Float) CollectionsKt.getOrNull(r1, 1);
        if (r15 == null) goto L45;
        float r16 = b0.c(r15) * this.s;
    L46:
        Float r17 = (Float) CollectionsKt.getOrNull(r1, 2);
        if (r17 == null) goto L49;
        float r18 = b0.c(r17) * this.s;
    L50:
        Float r19 = (Float) CollectionsKt.getOrNull(r1, 3);
        if (r19 == null) goto L53;
        r13 = this.s * b0.c(r19);
    L53:
        r11.a = r14;
        r11.b = r16;
        r11.c = r18;
        r11.d = r13;
        r11.R5();
        r11.invalidate();
        return;
    L49:
        r18 = 0.0f;
        goto L50
    L45:
        r16 = 0.0f;
        goto L46
    L41:
        r14 = 0.0f;
        goto L42
    L34:
        if (r8.intValue() <= 0) goto L55;
        if (r10 < 0) goto L55;
        if (r10 < r8.intValue()) goto L38;
    L55:
        E4().setRadius(b0.c(Double.valueOf(r4)) * this.s);
        return;
    L22:
        r8 = null;
        goto L23
    L16:
        r4 = 6.0d;
    L8:
        VideoCardModel r20 = this.P;
        if (r20 == null) goto L13;
        VideoCardData.FavoriteItemStyle r21 = r20.getItemStyle();
        if (r21 == null) goto L13;
        r3 = r21.getItemCornerRadius();
    L13:
        r3 = null;
        goto L14
    }

    public final void onCreate() {
        new com.bytedance.android.shopping.mall.homepage.card.c(I4(), this.Y, ToolsKt.k(this)).a();
        new com.bytedance.android.shopping.mall.homepage.card.c(C4(), this.Y, ToolsKt.k(this)).a();
        L4();
        if (com.bytedance.android.ec.hybrid.tools.e.b.getType().c() == true) goto L5;
        return;
    L5:
        if (((Boolean) ToolsKt.b.getValue()).booleanValue() == true) goto L9;
        int r0 = com.bytedance.android.ec.hybrid.list.util.c.a;
        P4(com.bytedance.android.ec.hybrid.list.util.c.f(((RecyclerView.ViewHolder) this).itemView.getContext()));
        return;
    }

    public final void onShow() {
        ECHybridListItemVO r0 = ((BaseViewHolder) this).c;
        if (r0 == null) goto L6;
        r0.K = false;
        return;
    }

    public final void onHide() {
        K4();
        b0.e((ECRoundedCornerImageView) this.A.getValue());
    }

    public final void onRelease() {
        super.onRelease();
        com.bytedance.android.ec.hybrid.card.api.e r0 = this.u;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        this.u = null;
        E4().f = null;
        if (((Boolean) this.H0.getValue()).booleanValue() == false) goto L11;
        MutableLiveData<Float> r1 = this.M1;
        if (r1 == null) goto L12;
        r1.removeObserver(this.p0);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.shopping.mall.homepage.card.AbstractNativeCard
    public final ECRoundedConstraintLayout r4() {
        return E4();
    }

    public final void l4() {
        O4();
    }

    public final boolean n4() {
        return this.L1;
    }

    public final void o() {
        super.o();
    }

    public static final void y4(final NativeVideoCard r5) {
        Pair[] r0 = new Pair[3];
        VideoCardData r1 = r5.O;
        CommonData.WindVaneEventData r2 = null;
        if (r1 == null) goto L5;
        Object r3 = r1.carryRCInfoWindVaneParams();
    L6:
        r0[0] = TuplesKt.to("wind_vane_params", r3);
        r0[1] = TuplesKt.to("index", Integer.valueOf(ToolsKt.g(r5)));
        r0[2] = TuplesKt.to("section_index", Integer.valueOf(ToolsKt.q(r5)));
        final Map r4 = MapsKt.mutableMapOf(r0);
        VideoCardData r6 = r5.O;
        if (r6 == null) goto L18;
        CommonData.WindVaneEventData r7 = r6.getWindVaneData();
        if (r7 == null) goto L18;
        String r8 = r7.getWindVaneSchema();
        if (r8 == null) goto L18;
        if (com.bytedance.forest.utils.h.a(r8) != true) goto L18;
        Gson r9 = p.a;
        VideoCardData r10 = r5.O;
        if (r10 == null) goto L17;
        r2 = r10.getWindVaneData();
    L17:
        r4.put("wind_vane_data", p.c(r2));
    L18:
        LastActionRecorderKt.b(r5, true, new NativeVideoCard$recordActionAndSendQueryRecommend$1(r5, r4));
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void D1(Long r9) {
        K4();
        ((BaseViewHolder) this).a = IHybridListViewHolder.ECCardPlayState.PLAYING;
        this.X = false;
        t r10 = com.bytedance.android.shopping.api.mall.common.tools.h.b.getHybridLynxHostService();
        VideoCardData.Video r1 = null;
        if (r10 == null) goto L5;
        IHybridVideoBoxView r11 = r10.getHybridVideoBoxView(((RecyclerView.ViewHolder) this).itemView.getContext(), true);
    L6:
        this.Q = r11;
        if (r11 != null) goto L10;
        g.d(this, 1, 0, null, 2, 6);
        return;
    L10:
        I4().addView(this.Q);
        Gson r12 = new Gson();
        VideoCardData r2 = this.O;
        if (r2 == null) goto L13;
        r1 = r2.getVideo();
    L13:
        String r13 = GsonProtectorUtils.toJson(r12, r1);
        IHybridVideoBoxView r3 = this.Q;
        if (r3 == null) goto L16;
        r3.setStateChangeReporter(new NativeVideoCard$playVideo$1(this));
    L16:
        IHybridVideoBoxView r4 = this.Q;
        if (r4 == null) goto L19;
        r4.setVideoData(r13);
    L19:
        String r14 = this.R;
        if (r14 != null) goto L22;
    L24:
        IHybridVideoBoxView r15 = this.Q;
        if (r15 == null) goto L27;
        int r5 = IHybridVideoBoxView.a;
        r15.g();
    L27:
        this.V = System.currentTimeMillis();
        ((BaseViewHolder) this).j = true;
        return;
    L22:
        if (this.v1 == null) goto L24;
        N4(g93.a.a(r14), !((Boolean) this.U.getValue()).booleanValue());
        goto L24
    L5:
        r11 = null;
        goto L6
    }

    public final void M4(int r15) {
        ToolsKt.B(F4(), null);
        ToolsKt.B(I4(), null);
        ToolsKt.A(E4(), 0.0f, null, null, Integer.valueOf(r15), null, null, null, null, false, null, 1015);
    }

    public final void P4(float r18) {
        this.s = r18;
        com.bytedance.android.shopping.api.mall.idl.c r1 = this.P1;
        boolean r2 = false;
        if (r1 == null) goto L15;
        Integer r3 = r1.b;
        if (r3 == null) goto L15;
        if (r3.intValue() <= 0) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == true) goto L13;
        r3 = null;
    L13:
        if (r3 == null) goto L15;
        Integer r5 = Integer.valueOf(b0.c(r3));
    L16:
        com.bytedance.android.shopping.api.mall.idl.c r6 = this.P1;
        if (r6 == null) goto L19;
        Integer r7 = r6.d;
    L20:
        if (r6 != null) goto L22;
    L35:
        VideoCardModel r8 = this.P;
        if (r8 == null) goto L49;
        VideoCardModel.ElementStyle r9 = r8.getElementStyle();
        if (r9 == null) goto L49;
        Double r10 = r9.getHeight();
        if (r10 == null) goto L49;
        if (r10.doubleValue() <= 0) goto L44;
        r2 = true;
    L44:
        if (r2 == true) goto L47;
        r10 = null;
    L47:
        if (r10 == null) goto L49;
        M4(ToolsKt.d(Double.valueOf(r10.doubleValue()), ((RecyclerView.ViewHolder) this).itemView.getContext(), ((Boolean) this.L0.getValue()).booleanValue(), r5));
    L49:
        ConstraintLayout r11 = A4();
        VideoCardModel r12 = this.P;
        if (r12 == null) goto L54;
        VideoCardModel.ElementStyle r13 = r12.getElementStyle();
        if (r13 == null) goto L54;
        CommonModel$LayoutStyle r14 = r13.getInfoLayout();
    L55:
        ToolsKt.A(r11, r18, r14, null, null, Integer.valueOf(b0.c(8)), Integer.valueOf(b0.c(8)), Integer.valueOf(b0.c(8)), Integer.valueOf(b0.c(8)), false, null, 780);
        View r15 = (View) this.L.getValue();
        VideoCardModel r16 = this.P;
        if (r16 == null) goto L60;
        VideoCardModel.ElementStyle r17 = r16.getElementStyle();
        if (r17 == null) goto L60;
        CommonModel$LayoutStyle r19 = r17.getLogoLayout();
    L61:
        ToolsKt.A(r15, r18, r19, Integer.valueOf(b0.c(18)), Integer.valueOf(b0.c(18)), Integer.valueOf(b0.c(8)), Integer.valueOf(b0.c(8)), null, null, false, null, 960);
        TextView r20 = H4();
        VideoCardModel r21 = this.P;
        if (r21 == null) goto L66;
        VideoCardModel.ElementStyle r22 = r21.getElementStyle();
        if (r22 == null) goto L66;
        CommonModel$LayoutStyle r23 = r22.getVideoTitleLayout();
    L67:
        ToolsKt.A(r20, r18, r23, null, null, Integer.valueOf(b0.c(8)), null, Integer.valueOf(b0.c(8)), Integer.valueOf(b0.c(7)), false, null, 812);
        VideoCardModel r24 = this.P;
        if (r24 == null) goto L77;
        VideoCardModel.ElementStyle r25 = r24.getElementStyle();
        if (r25 == null) goto L77;
        CommonModel$LayoutStyle r26 = r25.getVideoTitleLayout();
        if (r26 == null) goto L77;
        Integer r27 = r26.getHeight();
        if (r27 == null) goto L77;
        H4().setHeight((int) (r27.intValue() * r18));
    L77:
        if (com.bytedance.android.ec.hybrid.tools.e.b.getType().c() == false) goto L79;
        int r28 = 13;
    L80:
        TextView r29 = H4();
        VideoCardModel r30 = this.P;
        if (r30 == null) goto L89;
        VideoCardModel.ElementStyle r31 = r30.getElementStyle();
        if (r31 == null) goto L89;
        CommonModel$CusTextStyle r32 = r31.getVideoTitleTextStyle();
        if (r32 == null) goto L89;
        Integer r33 = r32.getFontSize();
        if (r33 == null) goto L89;
        r28 = r33.intValue();
    L89:
        r29.setTextSize(1, r28 * this.s);
        O4();
        A4().setViewScaleSize(r18);
        FeedbackView r34 = t4().b;
        if (r34 == null) goto L92;
        r34.setViewScale(r18);
    L92:
        ECHybridExtensionsKt.c().post(new b(this, r18));
        return;
    L79:
        r28 = 14;
    L66:
        r23 = null;
    L60:
        r19 = null;
    L54:
        r14 = null;
        goto L55
    L22:
        if (r6.a() != true) goto L35;
        if (r7 == null) goto L35;
        if (r7.intValue() <= 0) goto L35;
        com.bytedance.android.ec.hybrid.list.ability.a r35 = ((BaseViewHolder) this).b;
        if (r35 == null) goto L49;
        v r36 = (v) r35.getAbility(v.class);
        if (r36 == null) goto L49;
        Integer r37 = r36.Gg(r7.intValue());
        if (r37 == null) goto L49;
        int r38 = r37.intValue();
        if (r38 <= 0) goto L49;
        M4(b0.c(Float.valueOf(r38 * 1.5f)));
        goto L49
    L19:
        r7 = null;
        goto L20
    L9:
        r4 = false;
    L15:
        r5 = null;
        goto L16
    }

    public final void h4(boolean r2) {
        IHybridVideoBoxView r3 = this.Q;
        if (r3 == null) goto L6;
        new NativeVideoCard$saveCurrentFrame$1(this);
        r3.c();
        return;
    }

    public final void m4(com.bytedance.android.ec.hybrid.list.entity.a r3) {
        Intrinsics.checkNotNullParameter(r3, "extraData");
        Intrinsics.checkNotNullParameter(r3, "extraData");
        String r0 = r3.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 != true) goto L16;
        VideoCardData r2 = this.O;
        if (r2 == null) goto L17;
        CommonData.Extra r4 = r2.getExtra();
        if (r4 == null) goto L18;
        r4.setRecommendInfo(r3.a);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L7:
        r1 = false;
        goto L8
    }

    public static final String w4(NativeVideoCard r11, boolean r12) {
        VideoCardData r0 = r11.O;
        String r1 = "";
        if (r0 == null) goto L6;
        String r2 = r0.getSchema();
        if (r2 == null) goto L6;
    L7:
        LinkedHashMap r3 = new LinkedHashMap();
        if (r12 == false) goto L17;
        VideoCardData r13 = r11.O;
        if (r13 == null) goto L15;
        CommonData.Product r14 = r13.getProduct();
        if (r14 == null) goto L15;
        String r15 = r14.getProductId();
        if (r15 == null) goto L15;
    L16:
        r3.put("open_product_id", r15);
    L15:
        r15 = "";
    L17:
        r3.put("entrance_page", ToolsKt.f(r11));
        String r5 = "order_center_video";
        if (Intrinsics.areEqual(ToolsKt.k(r11).get(PdpOpenThirdParam.KEY_PAGE_NAME), "order_homepage") == false) goto L20;
        Object r16 = "order_center_video";
    L21:
        r3.put(SimilarProductParam.ENTER_FROM, r16);
        Intrinsics.checkNotNullParameter(r11, "$this$getPreviousPage");
        r3.put("previous_page", ToolsKt.f(r11));
        JsonObject r8 = new JsonObject();
        if (Intrinsics.areEqual(ToolsKt.k(r11).get(PdpOpenThirdParam.KEY_PAGE_NAME), "order_homepage") == true) goto L25;
        r5 = "xtab_homepage_video";
    L25:
        r8.addProperty(SimilarProductParam.ENTER_FROM, r5);
        Intrinsics.checkNotNullParameter(r11, "$this$getPreviousPage");
        r8.addProperty("previous_page", ToolsKt.f(r11));
        r8.addProperty("is_auto_play", 1);
        r8.addProperty("ecom_entrance_form", "cover_card");
        r8.addProperty("EVENT_ORIGIN_FEATURE", "TEMAI");
        VideoCardData r17 = r11.O;
        if (r17 == null) goto L29;
        String r18 = r17.rcPriorityFromProduct();
        if (r18 == null) goto L29;
    L30:
        r8.addProperty("recommend_info", r18);
        r8.addProperty("request_id", ToolsKt.l(r11));
        r8.addProperty("outflow_order", Integer.valueOf(ToolsKt.g(r11)));
        r8.addProperty("click_order", Integer.valueOf(ToolsKt.g(r11)));
        VideoCardData r19 = r11.O;
        if (r19 == null) goto L36;
        CommonData.CardCommon r110 = r19.getCardCommon();
        if (r110 == null) goto L36;
        String r111 = r110.getResourceId();
        if (r111 == null) goto L36;
    L37:
        r8.addProperty("resource_id", r111);
        r8.addProperty("entrance_type", "video");
        r8.addProperty("tab_id", ToolsKt.r(r11));
        r8.addProperty("tab_name", ToolsKt.s(r11));
        r8.addProperty("ecom_scene_id", ToolsKt.m(r11));
        r8.addProperty("carrier_source", String.valueOf(r3.get(SimilarProductParam.ENTER_FROM)));
        VideoCardData r112 = r11.O;
        if (r112 == null) goto L45;
        CommonData.MarketingData r113 = r112.getMarketingData();
        if (r113 == null) goto L45;
        String r114 = r113.getTransMeta();
        if (r114 == null) goto L45;
        r1 = r114;
    L45:
        r8.addProperty("trans_meta", r1);
        r3.put("tracker", URLEncoder.encode(r8.toString()));
        return ToolsKt.u(r2, r3);
    L36:
        r111 = "";
    L29:
        r18 = "";
        goto L30
    L20:
        r16 = "xtab_homepage_video";
    L6:
        r2 = "";
        goto L7
    }

    public final void N4(boolean r1, boolean r2) {
        IHybridVideoBoxView r3 = this.Q;
        if (r3 == null) goto L5;
        r3.setMuted(r1);
    L5:
        IHybridVideoBoxView r4 = this.Q;
        if (r4 == null) goto L8;
        r4.e();
    L8:
        if (r1 == false) goto L10;
        ((ImageView) this.K.getValue()).setImageResource(2131248018);
        return;
    L10:
        ((ImageView) this.K.getValue()).setImageResource(2131248019);
    }

    /* JADX WARN: Type inference failed for: r6v35, types: [android.view.View, androidx.constraintlayout.widget.ConstraintLayout, com.bytedance.android.shopping.mall.homepage.card.common.LiveHeaderView] */
    public final void b4(Object r32, String r33, k.a r34) {
        Intrinsics.checkNotNullParameter(r33, "itemId");
        super.b4(r32, r33, r34);
        if ((r32 instanceof VideoCardData) == true) goto L5;
        Object r2 = null;
    L6:
        VideoCardData r3 = (VideoCardData) r2;
        if (r3 != null) goto L9;
        return;
    L9:
        this.O = r3;
        ECHybridListItemVO r4 = ((BaseViewHolder) this).c;
        if (r4 == null) goto L18;
        String r5 = r4.b();
        if (r5 == null) goto L18;
        VideoCardData r6 = this.O;
        if (r6 == null) goto L18;
        CommonData.Extra r7 = r6.getExtra();
        if (r7 == null) goto L18;
        r7.setRecommendInfo(r5);
    L18:
        VideoCardData r8 = this.O;
        if (r8 == null) goto L455;
        VideoCardModel r9 = h.a(r8);
        this.P = r9;
        final String r1 = String.valueOf(r32.hashCode());
        this.R = r9.getVideo().getId();
        VideoCardData.FavoriteItemStyle r10 = r9.getItemStyle();
        if (r10 == null) goto L40;
        String r11 = r10.getItemThemeColor();
        if (r11 == null) goto L40;
        C4().setThemeColor(r11);
        VideoCardModel r12 = this.P;
        if (r12 == null) goto L31;
        VideoCardModel.ElementStyle r13 = r12.getElementStyle();
        if (r13 == null) goto L31;
        CommonModel$CusTextStyle r14 = r13.getCoinStyle();
        if (r14 == null) goto L31;
        String r15 = r14.getBackgroundColor();
    L32:
        if (r15 != null) goto L34;
    L37:
        boolean r16 = true;
    L38:
        if (r16 == false) goto L40;
        A4().setContainerColor(r11);
        goto L40
    L34:
        if (r15.length() == 0) goto L37;
        r16 = false;
    L31:
        r15 = null;
    L40:
        Double r17 = r9.getElementStyle().getPlayerLayout().getRadius();
        if (r17 == null) goto L43;
        float r18 = b0.c(Double.valueOf(r17.doubleValue()));
        I4().a(0.0f, 0.0f, r18, r18);
        ToolsKt.a(F4(), r18);
        ((ECRoundedCornerImageView) this.A.getValue()).a(r18, r18);
    L43:
        ToolsKt.F((ECGradientView) this.y.getValue(), r9.getElementStyle().getPlayerMaskStyle());
        H4().setText(r9.getVideo().getDesc());
        boolean r19 = Intrinsics.areEqual(r9.getShowJustNowUI(), Boolean.TRUE);
        this.S = r19;
        if (r19 == false) goto L119;
        FrameLayout r20 = (FrameLayout) this.J.getValue();
        GradientDrawable r110 = new GradientDrawable();
        r110.setStroke(b0.c(2), ColorProtector.parseColor("#FF002A"));
        ECHybridListItemVO r111 = ((BaseViewHolder) this).c;
        if (r111 == null) goto L50;
        com.bytedance.android.ec.hybrid.list.entity.e r112 = r111.L;
        if (r112 == null) goto L50;
        Integer r113 = r112.c;
    L51:
        if (r111 == null) goto L55;
        com.bytedance.android.ec.hybrid.list.entity.e r114 = r111.L;
        if (r114 == null) goto L55;
        List r115 = r114.b;
    L56:
        if (r113 == null) goto L84;
        if (r115 == null) goto L84;
        if (r115.size() != 4) goto L84;
        int r116 = ToolsKt.g(this);
        if (r113.intValue() != (-1)) goto L63;
    L67:
        Float r21 = (Float) CollectionsKt.getOrNull(r115, 0);
        if (r21 == null) goto L70;
        float r22 = b0.c(Float.valueOf(r21.floatValue() - 1)) * this.s;
    L71:
        Float r117 = (Float) CollectionsKt.getOrNull(r115, 1);
        if (r117 == null) goto L74;
        float r118 = b0.c(Float.valueOf(r117.floatValue() - 1)) * this.s;
    L75:
        Float r119 = (Float) CollectionsKt.getOrNull(r115, 2);
        if (r119 == null) goto L78;
        float r120 = b0.c(Float.valueOf(r119.floatValue() - 1)) * this.s;
    L79:
        Float r121 = (Float) CollectionsKt.getOrNull(r115, 3);
        if (r121 == null) goto L82;
        float r122 = b0.c(Float.valueOf(r121.floatValue() - 1)) * this.s;
    L83:
        r110.setCornerRadii(new float[]{r22, r22, r118, r118, r120, r120, r122, r122});
        boolean r23 = true;
    L85:
        if (r23 == true) goto L102;
        ECHybridListItemVO r24 = ((BaseViewHolder) this).c;
        if (r24 == null) goto L93;
        com.bytedance.android.ec.hybrid.list.entity.e r25 = r24.L;
        if (r25 == null) goto L93;
        Double r26 = r25.a;
        if (r26 == null) goto L93;
        Number r27 = Double.valueOf(r26.doubleValue() - ((double) 1));
    L99:
        if (r27 != null) goto L101;
        r27 = 9;
    L101:
        r110.setCornerRadius(b0.c(r27));
    L93:
        VideoCardModel r28 = this.P;
        if (r28 == null) goto L98;
        VideoCardData.FavoriteItemStyle r29 = r28.getItemStyle();
        if (r29 == null) goto L98;
        r27 = r29.getItemCornerRadius();
    L98:
        r27 = null;
    L102:
        b0.j(r20, r110);
        b0.n((FrameLayout) this.J.getValue());
        b0.n((ImageView) this.K.getValue());
        String r30 = this.R;
        if (r30 != null) goto L105;
    L118:
        b0.e((View) this.L.getValue());
    L120:
        com.bytedance.android.shopping.mall.homepage.card.live.e r31 = this.p1;
        String r35 = r31.a;
        String r36 = r31.b;
        String r37 = r31.d;
        Pair r123 = W3();
        String r124 = (String) r123.getFirst();
        if (r124 == null) goto L123;
        r35 = r124;
    L123:
        String r125 = (String) r123.getSecond();
        if (r125 == null) goto L126;
        r36 = r125.concat("_cover");
        r37 = r125.concat("_product");
    L126:
        C4().S5(r35, r37);
        String r38 = r9.getElementStyle().getVideoTitleTextStyle().getColor();
        if (r38 == null) goto L129;
        H4().setTextColor(ColorProtector.parseColor(r38));
    L129:
        String r39 = r9.getElementStyle().getMaskStyle().getColorFrom();
        String r126 = r9.getElementStyle().getMaskStyle().getColorTo();
        Integer r127 = r9.getElementStyle().getMaskStyle().getHeight();
        if (r127 == null) goto L453;
        ((View) this.H.getValue()).getLayoutParams().height = r127.intValue();
    L453:
        View r128 = (View) this.H.getValue();     // Catch: Exception -> L137
        GradientDrawable r129 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor(r39), Color.parseColor(r126)});     // Catch: Exception -> L137
        Double r40 = r9.getElementStyle().getPlayerLayout().getRadius();     // Catch: Exception -> L137
        if (r40 == null) goto L135;
        float r41 = b0.c(Double.valueOf(r40.doubleValue()));     // Catch: Exception -> L137
        r129.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, r41, r41, r41, r41});     // Catch: Exception -> L137
    L135:
        Unit r42 = Unit.INSTANCE;     // Catch: Exception -> L137
        b0.j(r128, r129);     // Catch: Exception -> L137
    L139:
        if (r9.getLiveHeader() == null) goto L237;
        VideoCardData.Companion.LiveHeader r43 = r9.getLiveHeader();
        boolean r44 = b0.b(E4()).contains((View) this.M.getValue());
        if (r43 != null) goto L144;
        if (r44 == false) goto L144;
    L226:
        A4().setVisibility(8);
        ViewGroup.LayoutParams r45 = F4().getLayoutParams();
        if ((r45 instanceof ConstraintLayout.LayoutParams) == true) goto L229;
        r45 = null;
    L229:
        ConstraintLayout.LayoutParams r46 = (ConstraintLayout.LayoutParams) r45;
        if (r46 == null) goto L270;
        if (r9.getElementStyle().isEnlarge() == true) goto L270;
        ConstraintLayout r47 = this.N;
        if (r47 == null) goto L236;
        r46.bottomToTop = r47.getId();
    L236:
        F4().setLayoutParams(r46);
    L270:
        if (r9.getExperiment().getHideVideoDesc() == false) goto L273;
        b0.e(H4());
    L273:
        if (d0.b(F4(), r9.getVideo().getCover(), r35, r36) == true) goto L275;
        F4().setImageURI(r9.getVideo().getCover());
    L275:
        ToolsKt.y(E4(), r9.getVideo().getAccessibilityLabel());
        com.bytedance.android.shopping.mall.homepage.card.common.feedback.b r48 = t4();
        VideoCardData r49 = this.O;
        String r50 = "";
        if (r49 == null) goto L281;
        VideoCardData.Video r51 = r49.getVideo();
        if (r51 == null) goto L281;
        String r52 = r51.getItemId();
        if (r52 == null) goto L281;
    L282:
        r48.getClass();
        Intrinsics.checkNotNullParameter(r52, "<set-?>");
        r48.a = r52;
        CommonData.WindVaneEventData r53 = r9.getWindVane();
        if (r53 == null) goto L316;
        String r54 = r53.getWindVaneLynxData();
        if (r54 == null) goto L316;
        if (com.bytedance.forest.utils.h.a(r54) != true) goto L316;
        String r55 = r9.getWindVane().getWindVaneSchema();
        if (r55 == null) goto L316;
        if (com.bytedance.forest.utils.h.a(r55) != true) goto L316;
        Logger.d("puffone-NativeVideoCard.bindData()", "有风向标数据:" + this.x1 + ',' + r9.getWindVane().getWindVaneSchema() + ',' + r9.getWindVane().getWindVaneLynxData() + ',' + r9.getWindVane().getAppendHeight());
        J4().setVisibility(0);
        Pair[] r56 = new Pair[1];
        VideoCardData r57 = this.O;
        if (r57 == null) goto L298;
        VideoCardData.FavoriteVideoCardABValues r58 = r57.getFavoriteVideoCardABValues();
        if (r58 == null) goto L298;
        Map<String, Object> r59 = r58.toMap();
        if (r59 == null) goto L298;
    L299:
        r56[0] = TuplesKt.to("ab_values", r59);
        Map r130 = MapsKt.mutableMapOf(r56);
        if (this.u != null) goto L310;
        int r60 = UIUtils.px2dip(((RecyclerView.ViewHolder) this).itemView.getContext(), ((RecyclerView.ViewHolder) this).itemView.getHeight());
        Integer r61 = r9.getWindVane().getAppendMargin();
        if (r61 == null) goto L304;
        int r62 = r61.intValue();
    L305:
        int r63 = r60 + r62;
        this.T = r63;
        r130.putAll(ToolsKt.c(this, r63));
        com.bytedance.android.ec.hybrid.card.api.f r131 = this.x1;
        if (r131 == null) goto L308;
        FrameLayout r132 = J4();
        String r133 = r9.getWindVane().getWindVaneSchema();
        Intrinsics.checkNotNull(r133);
        ECLynxCard r64 = r131.IW(r132, r133, r9.getWindVane().getWindVaneLynxData(), r130, new ViewGroup.LayoutParams(-1, -2), new d(this, r9), null);
    L309:
        this.u = r64;
    L317:
        CommonData.CoinData r65 = r9.getCoinData();
        if (r65 == null) goto L320;
        Integer r66 = r65.getCoinLynxHeight();
    L322:
        if (r66 == null) goto L352;
        String r67 = r9.getCoinData().getCoinLynxSchema();
        if (r67 == null) goto L352;
        if (com.bytedance.forest.utils.h.a(r67) != true) goto L352;
        if (r9.getProduct().getMarketingData() == null) goto L352;
        Logger.d("puffone-NativeVideoCard.bindData()", "有金币数据:" + this.x1 + ',' + r9.getCoinData().getCoinLynxSchema() + ',' + r9.getCoinData().getCoinLynxHeight());
        B4().setVisibility(0);
        com.bytedance.android.ec.hybrid.card.api.e r68 = this.v;
        if (r68 != null) goto L347;
        com.bytedance.android.ec.hybrid.card.api.f r69 = this.x1;
        if (r69 == null) goto L340;
        FrameLayout r70 = B4();
        String r134 = r9.getCoinData().getCoinLynxSchema();
        Intrinsics.checkNotNull(r134);
        JSONObject r71 = new JSONObject();
        r71.put("marketing_data", GsonProtectorUtils.toJson(new Gson(), r9.getProduct().getMarketingData()));
        VideoCardModel.TTExperiment r72 = r9.getTtExperiment();
        if (r72 == null) goto L339;
        String r73 = r72.getTaskExpGroup();
        if (r73 == null) goto L339;
        r50 = r73;
    L339:
        r71.put("task_tab_show_exp_group", r50);
        Unit r74 = Unit.INSTANCE;
        String r135 = r71.toString();
        Integer r75 = r9.getCoinData().getCoinLynxHeight();
        Intrinsics.checkNotNull(r75);
        ECLynxCard r76 = r69.IW(r70, r134, r135, null, new ViewGroup.LayoutParams(-1, r75.intValue()), new com.bytedance.android.shopping.mall.homepage.card.video.b(), null);
    L341:
        this.v = r76;
        if (r76 == null) goto L346;
        View r77 = r76.b();
        if (r77 == null) goto L346;
        r77.setOnClickListener(new c(this));
    L346:
        ConstraintSet r78 = new ConstraintSet();
        r78.clone(E4());
        r78.connect(2131364473, 4, 2131367090, 3);
        r78.applyTo(E4());
    L355:
        u4(r9.getElementStyle().getFeedBackLayout());
        P4(this.s);
        L4();
        CommonModel$CommonColorStyle r79 = r9.getElementStyle().getRootStyle();
        IHybridHostService r80 = com.bytedance.android.ec.hybrid.a.h();
        if (r80 == null) goto L362;
        i r81 = r80.getIHybridHostAppInfo();
        if (r81 == null) goto L362;
        if (r81.isNightMode() != true) goto L362;
        boolean r82 = true;
    L364:
        if (r9.getElementStyle().getDarkModeEnable() == false) goto L369;
        if (r82 == false) goto L369;
        String r84 = r79.getColorDark();
        if (r84 == null) goto L372;
        E4().setBackgroundColor(ColorProtector.parseColor(r84));
    L372:
        VideoCardModel r85 = this.P;
        if (r85 == null) goto L384;
        VideoCardModel.ElementStyle r86 = r85.getElementStyle();
        if (r86 == null) goto L384;
        Float r87 = r86.getFeedCardRatio();
        if (r87 == null) goto L384;
        float r88 = r87.floatValue();
        ViewGroup.LayoutParams r89 = E4().getLayoutParams();
        if ((r89 instanceof ConstraintLayout.LayoutParams) == true) goto L381;
        r89 = null;
    L381:
        ConstraintLayout.LayoutParams r90 = (ConstraintLayout.LayoutParams) r89;
        if (r90 == null) goto L384;
        r90.dimensionRatio = String.valueOf(r88);
        ((ViewGroup.MarginLayoutParams) r90).height = 0;
    L384:
        VideoCardModel r91 = this.P;
        if (r91 == null) goto L391;
        VideoCardModel.Experiment r92 = r91.getExperiment();
        if (r92 == null) goto L391;
        Double r94 = r92.getAppendHeight();
        if (r94 == null) goto L391;
        double r95 = r94.doubleValue();
    L393:
        if (r95 <= 0.0d) goto L403;
        com.bytedance.android.shopping.api.mall.idl.c r96 = this.P1;
        if (r96 == null) goto L400;
        Integer r97 = r96.b;
        if (r97 == null) goto L400;
        int r98 = r97.intValue();
    L401:
        if (r98 <= 0) goto L403;
        E4().g = b0.c(Double.valueOf((r95 * ((double) r98)) / ((double) 375)));
    L400:
        r98 = ToolsKt.o(((RecyclerView.ViewHolder) this).itemView.getContext());
    L403:
        VideoCardModel r99 = this.P;
        if (r99 == null) goto L410;
        VideoCardModel.ElementStyle r100 = r99.getElementStyle();
        if (r100 == null) goto L410;
        if (r100.isEnlarge() != true) goto L410;
        boolean r101 = true;
    L411:
        if (r101 == false) goto L431;
        ViewGroup.LayoutParams r102 = F4().getLayoutParams();
        if ((r102 instanceof ConstraintLayout.LayoutParams) == true) goto L415;
        r102 = null;
    L415:
        ConstraintLayout.LayoutParams r103 = (ConstraintLayout.LayoutParams) r102;
        if (r103 == null) goto L418;
        r103.bottomToTop = -1;
        r103.bottomToBottom = 0;
        ((ViewGroup.MarginLayoutParams) r103).height = -1;
    L418:
        ViewGroup.LayoutParams r104 = I4().getLayoutParams();
        if ((r104 instanceof ConstraintLayout.LayoutParams) == true) goto L421;
        r104 = null;
    L421:
        ConstraintLayout.LayoutParams r105 = (ConstraintLayout.LayoutParams) r104;
        if (r105 == null) goto L424;
        r105.bottomToBottom = 0;
    L424:
        ViewGroup.LayoutParams r106 = A4().getLayoutParams();
        if ((r106 instanceof ConstraintLayout.LayoutParams) == true) goto L427;
        r106 = null;
    L427:
        ConstraintLayout.LayoutParams r107 = (ConstraintLayout.LayoutParams) r106;
        if (r107 == null) goto L430;
        r107.topToBottom = -1;
    L430:
        ToolsKt.B(F4(), null);
        ToolsKt.B(I4(), null);
        this.g1 = true;
        return;
    L431:
        ViewGroup.LayoutParams r108 = null;
        if (this.g1 == false) goto L457;
        this.g1 = false;
        ViewGroup.LayoutParams r109 = F4().getLayoutParams();
        if ((r109 instanceof ConstraintLayout.LayoutParams) == true) goto L436;
        r109 = null;
    L436:
        ConstraintLayout.LayoutParams r136 = (ConstraintLayout.LayoutParams) r109;
        if (r136 == null) goto L439;
        r136.bottomToTop = A4().getId();
        r136.bottomToBottom = -1;
        ((ViewGroup.MarginLayoutParams) r136).height = 0;
    L439:
        ViewGroup.LayoutParams r137 = I4().getLayoutParams();
        if ((r137 instanceof ConstraintLayout.LayoutParams) == true) goto L442;
        r137 = null;
    L442:
        ConstraintLayout.LayoutParams r138 = (ConstraintLayout.LayoutParams) r137;
        if (r138 == null) goto L445;
        r138.bottomToBottom = F4().getId();
    L445:
        ViewGroup.LayoutParams r139 = A4().getLayoutParams();
        if ((r139 instanceof ConstraintLayout.LayoutParams) == false) goto L449;
        r108 = r139;
    L449:
        ConstraintLayout.LayoutParams r140 = (ConstraintLayout.LayoutParams) r108;
        if (r140 == null) goto L458;
        r140.topToBottom = F4().getId();
        return;
    L458:
        return;
    L457:
        return;
    L410:
        r101 = false;
    L391:
        r95 = 0.0d;
    L369:
        String r141 = r79.getColor();
        if (r141 == null) goto L372;
        E4().setBackgroundColor(ColorProtector.parseColor(r141));
    L362:
        r82 = false;
        goto L364
    L340:
        r76 = null;
        goto L341
    L347:
        int r142 = com.bytedance.android.ec.hybrid.card.api.d.e;
        String r143 = r9.getCoinData().getCoinLynxSchema();
        if (r143 == null) goto L351;
        r50 = r143;
    L351:
        r68.e(com.bytedance.android.ec.hybrid.card.api.d.a.c(r50, null), true);
        ViewGroup.LayoutParams r144 = B4().getLayoutParams();
        Integer r145 = r9.getCoinData().getCoinLynxHeight();
        Intrinsics.checkNotNull(r145);
        r144.height = r145.intValue();
    L352:
        Logger.d("puffone-NativeVideoCard.bindData()", "无金币标数据");
        B4().setVisibility(8);
        if (this.v == null) goto L355;
        ConstraintSet r146 = new ConstraintSet();
        r146.clone(E4());
        r146.connect(2131364473, 4, 0, 4);
        r146.applyTo(E4());
        goto L355
    L320:
        r66 = null;
        goto L322
    L308:
        r64 = null;
        goto L309
    L304:
        r62 = 0;
        goto L305
    L310:
        r130.putAll(ToolsKt.c(this, this.T));
        com.bytedance.android.ec.hybrid.card.api.e r147 = this.u;
        if (r147 == null) goto L317;
        int r148 = com.bytedance.android.ec.hybrid.card.api.d.e;
        String r149 = r9.getWindVane().getWindVaneLynxData();
        if (r149 != null) goto L315;
        r149 = "";
    L315:
        r147.e(com.bytedance.android.ec.hybrid.card.api.d.a.c(r149, r130), true);
    L298:
        r59 = new LinkedHashMap();
    L316:
        Logger.d("puffone-NativeLiveCard.bindData()", "无风向标数据");
        J4().setVisibility(8);
    L281:
        r52 = "";
    L144:
        if (r43 != null) goto L148;
        ConstraintLayout r150 = this.N;
        if (r150 == null) goto L148;
        r150.setVisibility(8);
    L148:
        if (r43 != null) goto L150;
        ConstraintLayout r151 = this.N;
        if (r151 == null) goto L226;
        r151.setVisibility(8);
        goto L226
    L150:
        if (this.N != null) goto L159;
        ?? r152 = new LiveHeaderView(((RecyclerView.ViewHolder) this).itemView.getContext());
        r152.setId(ViewCompat.generateViewId());
        View r153 = (View) this.M.getValue();
        ConstraintLayout r154 = E4();
        int r155 = r154.indexOfChild(r153);
        r154.removeViewInLayout(r153);
        ConstraintLayout.LayoutParams r156 = new ConstraintLayout.LayoutParams(-1, b0.c(32));
        r156.startToStart = 0;
        r156.endToEnd = 0;
        r156.bottomToBottom = 0;
        VideoCardModel r157 = this.P;
        if (r157 == null) goto L157;
        VideoCardModel.ElementStyle r158 = r157.getElementStyle();
        if (r158 == null) goto L157;
        if (r158.isEnlarge() != true) goto L157;
    L158:
        r154.addView(r152, r155, r156);
        this.N = r152;
    L157:
        r156.topToBottom = F4().getId();
    L159:
        LiveHeaderView r159 = this.N;
        if (r159 == null) goto L220;
        View r160 = ((RecyclerView.ViewHolder) this).itemView;
        VideoCardModel r161 = this.P;
        if (r161 == null) goto L166;
        VideoCardModel.ElementStyle r162 = r161.getElementStyle();
        if (r162 == null) goto L166;
        CommonModel$CusTextStyle r163 = r162.getLiveHeaderStateStyle();
    L167:
        VideoCardModel r164 = this.P;
        if (r164 == null) goto L172;
        VideoCardModel.ElementStyle r165 = r164.getElementStyle();
        if (r165 == null) goto L172;
        CommonModel$CusTextStyle r166 = r165.getUserTextStyle();
    L173:
        VideoCardModel r167 = this.P;
        if (r167 == null) goto L178;
        VideoCardModel.ElementStyle r168 = r167.getElementStyle();
        if (r168 == null) goto L178;
        CommonModel$LayoutStyle r169 = r168.getLiveHeaderEnterIconLayout();
    L179:
        LiveHeaderView.Companion.LiveHeaderStyle r170 = new LiveHeaderView.Companion.LiveHeaderStyle(r163, r166, r169);
        Function1<String, Unit> r171 = new NativeVideoCard$handleLiveHeader$$inlined$let$lambda$1(this, r1);
        Intrinsics.checkNotNullParameter(r43, "liveHeader");
        Intrinsics.checkNotNullParameter(r1, "uniqueId");
        Intrinsics.checkNotNullParameter(this, "viewHolder");
        Intrinsics.checkNotNullParameter(r160, "itemView");
        Intrinsics.checkNotNullParameter(r171, "onClick");
        r159.a = r43;
        r159.c = this;
        r159.b = r160;
        r159.getClass();
        r159.e = r171;
        r159.d = r1;
        String r172 = r43.getAvatar();
        if (r172 == null) goto L182;
        r159.h.setImageURI(r172);
        r159.h.setVisibility(0);
    L183:
        String r173 = r43.getLiveIcon();
        if (r173 == null) goto L186;
        r159.i.setImageURI(r173);
        r159.i.setVisibility(0);
    L187:
        CommonModel$CusTextStyle r174 = r170.getStateStyle();
        String r175 = r43.getLiveDesc();
        if (r175 != null) goto L190;
        r159.j.setVisibility(8);
    L201:
        CommonModel$CusTextStyle r176 = r170.getUserDescStyle();
        String r177 = r43.getNickName();
        if (r177 != null) goto L204;
        r159.k.setVisibility(8);
    L215:
        CommonModel$LayoutStyle r178 = r170.getEnterIconLayout();
        String r179 = r43.getEnterLiveIcon();
        if (r179 == null) goto L218;
        r159.l.setImageURI(r179);
        r159.l.setVisibility(0);
        ToolsKt.A(r159.l, 0.0f, r178, Integer.valueOf(LiveHeaderView.n), Integer.valueOf(LiveHeaderView.o), null, null, null, null, false, null, 1009);
    L219:
        AlphaAnimation r180 = new AlphaAnimation(0.0f, 0.4f);
        r180.setRepeatCount(-1);
        r180.setRepeatMode(2);
        r180.setDuration(500);
        ScaleAnimation r181 = new ScaleAnimation(1.0f, 0.875f, 1.0f, 0.889f, 1, 0.5f, 1, 0.5f);
        r181.setDuration(500);
        r181.setRepeatCount(-1);
        r181.setRepeatMode(2);
        ScaleAnimation r182 = new ScaleAnimation(1.0f, 0.875f, 1.0f, 0.875f, 1, 0.5f, 1, 0.5f);
        r182.setDuration(500);
        r182.setRepeatCount(-1);
        r182.setRepeatMode(2);
        r159.f.startAnimation(r180);
        r159.g.startAnimation(r181);
        r159.h.startAnimation(r182);
        goto L220
    L218:
        r159.l.setVisibility(4);
        goto L219
    L204:
        if (r177.length() <= 0) goto L206;
        boolean r183 = true;
    L207:
        if (r183 == false) goto L213;
        r159.k.setText(r177);
        r159.k.setVisibility(0);
        if (r176 == null) goto L215;
        Integer r184 = r176.getFontSize();
        if (r184 == null) goto L215;
        r159.k.setTextSize(1, r184.intValue());
        goto L215
    L213:
        r159.k.setVisibility(8);
        goto L215
    L206:
        r183 = false;
        goto L207
    L190:
        if (r175.length() <= 0) goto L192;
        boolean r185 = true;
    L193:
        if (r185 == false) goto L199;
        r159.j.setText(r175);
        r159.j.setVisibility(0);
        if (r174 == null) goto L201;
        Integer r186 = r174.getFontSize();
        if (r186 == null) goto L201;
        r159.j.setTextSize(1, r186.intValue());
        goto L201
    L199:
        r159.j.setVisibility(8);
        goto L201
    L192:
        r185 = false;
        goto L193
    L186:
        r159.i.setVisibility(8);
        goto L187
    L182:
        r159.h.setVisibility(4);
    L178:
        r169 = null;
    L172:
        r166 = null;
    L166:
        r163 = null;
    L220:
        ConstraintLayout r187 = this.N;
        if (r187 == null) goto L226;
        r187.setVisibility(0);
        goto L226
    L237:
        A4().setVisibility(0);
        ConstraintLayout r188 = this.N;
        if (r188 == null) goto L241;
        r188.setVisibility(8);
    L241:
        if (r9.getExperiment().getNoProductInfo() == false) goto L251;
        ((SimpleDraweeView) this.C.getValue()).setVisibility(8);
        ((TextView) this.F.getValue()).setVisibility(8);
        C4().setVisibility(8);
        A4().setVisibility(0);
        H4().setVisibility(0);
        BottomInfoViewForVideo r189 = A4();
        CommonModel$Product r190 = r9.getProduct();
        CommonModel$User r191 = r9.getUser();
        BottomInfoView.Companion.Experiment r192 = new BottomInfoView.Companion.Experiment(false, false, r9.getExperiment().getCoinLabelStyle(), false, 11, null);
        BottomInfoView.Companion.ElementStyle r193 = new BottomInfoView.Companion.ElementStyle(new CommonModel$ModuleDesc(r9.getElementStyle().getAvatarLayout(), r9.getElementStyle().getUserTextStyle()), null, null, new CommonModel$ModuleDesc(r9.getElementStyle().getCoinLayout(), r9.getElementStyle().getCoinStyle()), r9.getElementStyle().getCoinIconLayout(), 6, null);
        CommonData.ElementStyle.VideoLikeStyle r194 = r9.getElementStyle().getVideoLikeStyle();
        if (r194 == null) goto L245;
        String r195 = r194.getText();
    L246:
        CommonData.ElementStyle.VideoLikeStyle r196 = r9.getElementStyle().getVideoLikeStyle();
        if (r196 == null) goto L249;
        String r197 = r196.getIcon();
    L250:
        r189.U5(r190, r191, null, false, r192, r193, new com.bytedance.android.shopping.mall.homepage.card.common.a(r195, r197));
    L261:
        ViewGroup.LayoutParams r198 = F4().getLayoutParams();
        if ((r198 instanceof ConstraintLayout.LayoutParams) == true) goto L264;
        r198 = null;
    L264:
        ConstraintLayout.LayoutParams r199 = (ConstraintLayout.LayoutParams) r198;
        if (r199 == null) goto L270;
        if (r9.getElementStyle().isEnlarge() == true) goto L270;
        r199.bottomToTop = A4().getId();
        F4().setLayoutParams(r199);
        goto L270
    L249:
        r197 = null;
        goto L250
    L245:
        r195 = null;
        goto L246
    L251:
        com.bytedance.android.shopping.mall.homepage.card.live.e r200 = this.p1;
        String r201 = r200.a;
        String r202 = r200.c;
        Pair r203 = W3();
        String r204 = (String) r203.getFirst();
        if (r204 == null) goto L254;
        r201 = r204;
    L254:
        String r205 = (String) r203.getSecond();
        if (r205 == null) goto L257;
        r202 = r205.concat("_avatar");
    L257:
        ((SimpleDraweeView) this.C.getValue()).setVisibility(0);
        ((TextView) this.F.getValue()).setVisibility(0);
        C4().setVisibility(0);
        A4().setVisibility(8);
        H4().setVisibility(8);
        if (d0.b((SimpleDraweeView) this.C.getValue(), r9.getUser().getAvatar(), r201, r202) == true) goto L260;
        ((SimpleDraweeView) this.C.getValue()).setImageURI(r9.getUser().getAvatar());
    L260:
        ((TextView) this.F.getValue()).setText(r9.getUser().getNickname());
        C4().R5(r9.getProduct(), r9.getExperiment().isNewProductUI(), false);
        goto L261
    L105:
        if (this.v1 == null) goto L110;
        HashMap<String, Boolean> r206 = g93.a.a;
        Intrinsics.checkNotNullParameter(r30, "id");
        if (g93.a.a.containsKey(r30) != true) goto L110;
        boolean r207 = false;
    L111:
        if (r207 == true) goto L114;
        r30 = null;
    L114:
        if (r30 == null) goto L118;
        if (this.v1 == null) goto L118;
        g93.a.b(r30, true);
    L110:
        r207 = true;
        goto L111
    L82:
        r122 = 0.0f;
        goto L83
    L78:
        r120 = 0.0f;
        goto L79
    L74:
        r118 = 0.0f;
        goto L75
    L70:
        r22 = 0.0f;
        goto L71
    L63:
        if (r113.intValue() <= 0) goto L84;
        if (r116 < 0) goto L84;
        if (r116 < r113.intValue()) goto L67;
    L84:
        r23 = false;
    L55:
        r115 = null;
    L50:
        r113 = null;
        goto L51
    L119:
        b0.e((FrameLayout) this.J.getValue());
        b0.e((ImageView) this.K.getValue());
        b0.n((View) this.L.getValue());
        goto L120
    L455:
        return;
    L5:
        r2 = r32;
        goto L6
    }

    public NativeVideoCard(final View r2, boolean r3, Integer r4, com.bytedance.android.shopping.mall.homepage.card.live.e r5, g93.a r6, com.bytedance.android.ec.hybrid.card.api.f r7, String r8, String r9, Function0 r10, boolean r11, MutableLiveData r12, LifecycleOwner r13, com.bytedance.android.shopping.api.mall.idl.c r14, Function0 r15) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r5, "imageXMonitorTag");
        super(r2);
        this.S1 = new ff3.a(r2);
        this.h1 = r3;
        this.k1 = r4;
        this.p1 = r5;
        this.v1 = r6;
        this.x1 = r7;
        this.y1 = r8;
        this.G1 = r9;
        this.H1 = r10;
        this.L1 = r11;
        this.M1 = r12;
        this.P1 = r14;
        this.Q1 = r15;
        this.w = LazyKt.lazy(new NativeVideoCard$videoCardRootView$2(r2));
        this.x = LazyKt.lazy(new NativeVideoCard$videoViewContainer$2(r2));
        this.y = LazyKt.lazy(new NativeVideoCard$videoViewGlobalMask$2(this));
        this.z = LazyKt.lazy(new NativeVideoCard$videoCover$2(r2));
        this.A = LazyKt.lazy(new NativeVideoCard$videoViewFrame$2(r2));
        this.B = LazyKt.lazy(new NativeVideoCard$videoLayerDesc$2(r2));
        this.C = LazyKt.lazy(new NativeVideoCard$videoLayerMerchantImage$2(r2));
        this.D = LazyKt.lazy(new NativeVideoCard$windVanePanel$2(r2));
        this.E = LazyKt.lazy(new NativeVideoCard$coinPanel$2(r2));
        Lazy r16 = LazyKt.lazy(new NativeVideoCard$videoLayerMerchantName$2(r2));
        this.F = r16;
        this.G = LazyKt.lazy(new NativeVideoCard$productView$2(r2));
        this.H = LazyKt.lazy(new NativeVideoCard$maskView$2(r2));
        this.I = LazyKt.lazy(new NativeVideoCard$bottomInfoView$2(r2));
        Lazy r17 = LazyKt.lazy(new NativeVideoCard$videoWatchedView$2(r2));
        this.J = r17;
        Lazy r18 = LazyKt.lazy(new NativeVideoCard$videoMuteImg$2(r2));
        this.K = r18;
        this.L = LazyKt.lazy(new NativeVideoCard$videoLayerPlayIcon$2(r2));
        this.M = LazyKt.lazy(new NativeVideoCard$liveHeaderStub$2(r2));
        this.U = LazyKt.lazy(new NativeVideoCard$playVideoOpt$2(this));
        this.V = System.currentTimeMillis();
        this.W = System.currentTimeMillis();
        this.Z = LazyKt.lazy(NativeVideoCard$enterDetailOptAb$2.INSTANCE);
        this.k0 = LazyKt.lazy(NativeVideoCard$enterDetailOptBlackPageName$2.INSTANCE);
        f r19 = new f(this);
        this.p0 = r19;
        this.H0 = LazyKt.lazy(NativeVideoCard$memoryLeakFix$2.INSTANCE);
        this.L0 = LazyKt.lazy(NativeVideoCard$enableFoldConfig$2.INSTANCE);
        this.P0 = LazyKt.lazy(NativeVideoCard$videoTransAnimOpt$2.INSTANCE);
        this.V0 = LazyKt.lazy(NativeVideoCard$animationPageName$2.INSTANCE);
        this.b1 = LazyKt.lazy(NativeVideoCard$muteNeedReplay$2.INSTANCE);
        C4().S5(r5.a, r5.d);
        View.OnClickListener r20 = com.bytedance.android.shopping.mall.homepage.card.a.a(new NativeVideoCard$cardClickListener$1(this, r2), new NativeVideoCard$cardClickListener$2(this));
        View.OnClickListener r21 = com.bytedance.android.shopping.mall.homepage.card.a.a(new NativeVideoCard$productClickListener$1(this, r2), new NativeVideoCard$productClickListener$2(this));
        I4().setOnClickListener(r20);
        A4().setOnClickListener(r20);
        C4().setOnClickListener(r21);
        com.bytedance.android.shopping.mall.homepage.card.video.a r22 = new com.bytedance.android.shopping.mall.homepage.card.video.a(this);
        this.Y = r22;
        I4().setHapticFeedbackEnabled(false);
        I4().setOnLongClickListener(r22);
        A4().setHapticFeedbackEnabled(false);
        A4().setOnLongClickListener(r22);
        C4().setOnLongClickListener(r22);
        E4().setBackgroundColor(-1);
        ((TextView) r16.getValue()).setTextColor(-1);
        Lazy r23 = HybridAppInfoService.a;
        if (HybridAppInfoService.m() == false) goto L5;
        ((TextView) r16.getValue()).setTextColor(ColorProtector.parseColor("#FEFFFFFF"));
    L5:
        ((ImageView) ((FrameLayout) r17.getValue()).findViewById(2131386340)).setImageResource(2131248020);
        e r24 = new e(this);
        ((ImageView) r18.getValue()).setOnClickListener(r24);
        if (r13 == null) goto L9;
        if (r12 == null) goto L9;
        r12.observe(r13, r19);
    L9:
        ECUpdateHeightConstraintLayout r25 = E4();
        Function2<Integer, Integer, Unit> r26 = new AnonymousClass2(this);
        r25.getClass();
        Intrinsics.checkNotNullParameter(r26, "listener");
        r25.f = r26;
        B4().setOnClickListener(r20);
    }
}
