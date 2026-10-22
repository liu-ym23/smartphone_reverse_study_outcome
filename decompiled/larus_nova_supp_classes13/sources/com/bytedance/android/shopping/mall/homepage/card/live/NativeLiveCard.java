package com.bytedance.android.shopping.mall.homepage.card.live;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.list.ability.v;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECNAMallCardExtra;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.ec.hybrid.tools.TransitionAnimationHelper;
import com.bytedance.android.ec.hybrid.ui.IHybridLiveBoxView;
import com.bytedance.android.shopping.api.mall.MallPageName;
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
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ProductStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.Shape;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.TextBaseUIParams;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ToolsKt;
import com.bytedance.android.shopping.api.mall.common.homepage.card.live.LiveCardData;
import com.bytedance.android.shopping.api.mall.common.tools.MallServiceUtil;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.android.shopping.mall.feed.opt.MallLiveCardOpt;
import com.bytedance.android.shopping.mall.homepage.card.common.BottomInfoView;
import com.bytedance.android.shopping.mall.homepage.card.common.ProductView;
import com.bytedance.android.shopping.mall.homepage.card.common.feedback.FeedbackView;
import com.bytedance.android.shopping.mall.homepage.card.product.ProductPriceView;
import com.bytedance.android.shopping.mall.homepage.card.product.ProductTextView;
import com.bytedance.android.shopping.mall.homepage.tools.a0;
import com.bytedance.android.shopping.mall.homepage.tools.c0;
import com.bytedance.android.shopping.mall.homepage.tools.d0;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.ugc.aweme.thread.ThreadPoolHelper;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import yj.t;
import yj.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/live/NativeLiveCard;", "Lcom/bytedance/android/shopping/mall/homepage/card/live/BaseLiveViewHolder;", "Lff3/b;", "Lcom/bytedance/android/ec/hybrid/list/prebind/d;", "a", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NativeLiveCard extends BaseLiveViewHolder implements ff3.b, com.bytedance.android.ec.hybrid.list.prebind.d {
    public static final /* synthetic */ int Z2 = 0;
    public boolean E2;
    public boolean F2;
    public final Lazy G1;
    public final f G2;
    public final Lazy H0;
    public final Lazy H1;
    public final Lazy H2;
    public float I2;
    public final m J2;
    public final Lazy K2;
    public final Lazy L0;
    public final Lazy L1;
    public final Lazy L2;
    public com.bytedance.android.ec.hybrid.card.api.e M;
    public final Lazy M1;
    public final Lazy M2;
    public com.bytedance.android.ec.hybrid.card.api.e N;
    public final Lazy N2;
    public final Lazy O;
    public final Lazy O2;
    public final Lazy P;
    public final Lazy P0;
    public boolean P1;
    public int P2;
    public final Lazy Q;
    public IHybridLiveBoxView Q1;
    public final boolean Q2;
    public final Lazy R;
    public final boolean R2;
    public final Lazy S;
    public boolean S1;
    public final com.bytedance.android.shopping.mall.homepage.card.live.e S2;
    public final Lazy T;
    public LiveCardModel T1;
    public final com.bytedance.android.ec.hybrid.card.api.f T2;
    public final Lazy U;
    public final boolean U2;
    public final Lazy V;
    public final Lazy V0;
    public long V1;
    public final MutableLiveData<Float> V2;
    public final Lazy W;
    public final com.bytedance.android.shopping.api.mall.idl.c W2;
    public final Lazy X;
    public final Function0<Boolean> X2;
    public final Lazy Y;
    public final /* synthetic */ ff3.a Y2;
    public final Lazy Z;
    public final Lazy b1;
    public long b2;
    public final Lazy g1;
    public boolean g2;
    public final Lazy h1;
    public final Lazy h2;
    public final Lazy k0;
    public final Lazy k1;
    public final Lazy p0;
    public final Lazy p1;
    public final Lazy p2;
    public final Lazy v1;
    public final Lazy v2;
    public final Lazy x1;
    public String x2;
    public final Lazy y1;
    public Long y2;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ NativeLiveCard a;

        public b(NativeLiveCard r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            Object r4 = r3.getAnimatedValue();
            if ((r4 instanceof Integer) == true) goto L5;
            r4 = null;
        L5:
            Integer r5 = (Integer) r4;
            if (r5 == null) goto L9;
            int r6 = r5.intValue();
            NativeLiveCard r0 = this.a;
            int r1 = NativeLiveCard.Z2;
            r0.P4().scrollTo(0, r6);
            return;
        }
    }

    public static final class c extends AnimatorListenerAdapter {
        public final /* synthetic */ NativeLiveCard a;

        public c(NativeLiveCard r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            NativeLiveCard r3 = this.a;
            int r0 = NativeLiveCard.Z2;
            r3.P4().scrollTo(0, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            NativeLiveCard r3 = this.a;
            int r0 = NativeLiveCard.Z2;
            r3.P4().scrollTo(0, 0);
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ Function0 a;

        public d(Function0 r1) {
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

    public static final class e implements Runnable {
        public final /* synthetic */ NativeLiveCard a;
        public final /* synthetic */ float b;

        public e(NativeLiveCard r1, float r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            NativeLiveCard r0 = this.a;     // Catch: Throwable -> L7
            com.bytedance.android.ec.hybrid.card.api.e r1 = r0.M;     // Catch: Throwable -> L7
            int r2 = (int) (r0.P2 * this.b);     // Catch: Throwable -> L7
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

    public final ProductTextView J4() {
        return (ProductTextView) this.x1.getValue();
    }

    public final View K4() {
        return (View) this.G1.getValue();
    }

    public final SimpleDraweeView L4() {
        return (SimpleDraweeView) this.y1.getValue();
    }

    public final BottomInfoView N4() {
        return (BottomInfoView) this.g1.getValue();
    }

    public final FrameLayout O4() {
        return (FrameLayout) this.V.getValue();
    }

    public final ECUpdateHeightConstraintLayout P4() {
        return (ECUpdateHeightConstraintLayout) this.O.getValue();
    }

    @Override // ff3.b
    public final View Q1() {
        return this.Y2.Q1();
    }

    public final SimpleDraweeView R4() {
        return (SimpleDraweeView) this.R.getValue();
    }

    public final TextView S4() {
        return (TextView) this.T.getValue();
    }

    public final SimpleDraweeView T4() {
        return (SimpleDraweeView) this.W.getValue();
    }

    public final ImageView U4() {
        return (ImageView) this.k1.getValue();
    }

    public final View V4() {
        return (View) this.p1.getValue();
    }

    public final ECRoundedFrameLayout W4() {
        return (ECRoundedFrameLayout) this.P.getValue();
    }

    public final FrameLayout X4() {
        return (FrameLayout) this.h1.getValue();
    }

    public final SimpleDraweeView Y4() {
        return (SimpleDraweeView) this.Z.getValue();
    }

    public final ProductView Z4() {
        return (ProductView) this.V0.getValue();
    }

    public final SimpleDraweeView a5() {
        return (SimpleDraweeView) this.p0.getValue();
    }

    public final FrameLayout b5() {
        return (FrameLayout) this.U.getValue();
    }

    @Override // ff3.b
    public final void s3(LottieAnimationView r2, FrameLayout.LayoutParams r3) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r3, "lp");
        this.Y2.s3(r2, r3);
    }

    public final void D() {
        ((BaseViewHolder) this).a = IHybridListViewHolder.ECCardPlayState.IDLE;
        ToolsKt.E(T4());
        if (this.E2 == false) goto L9;
        if (this.Q2 == false) goto L9;
        this.E2 = false;
        return;
    L9:
        if (h5() == false) goto L16;
        IHybridLiveBoxView r0 = this.Q1;
        if (r0 == null) goto L13;
        IHybridLiveBoxView.stopPlayerClient$default(r0, null, 1, null);
    L13:
        IHybridLiveBoxView r1 = this.Q1;
        if (r1 == null) goto L18;
        b0.e(r1);
        return;
    L18:
        return;
    L16:
        F4();
    }

    public final void F4() {
        if (this.Q1 != null) goto L5;
        return;
    L5:
        Fragment r0 = this.E;
        if ((r0 instanceof com.bytedance.android.shopping.api.mall.i) == true) goto L8;
        r0 = null;
    L8:
        com.bytedance.android.shopping.api.mall.i r1 = (com.bytedance.android.shopping.api.mall.i) r0;
        if (r1 == null) goto L11;
        String r2 = r1.d();
    L13:
        if (this.P1 == false) goto L15;
    L21:
        IHybridLiveBoxView r3 = this.Q1;
        if (r3 == null) goto L24;
        r3.destroy();
    L24:
        W4().removeAllViews();
        this.Q1 = null;
        long r4 = System.currentTimeMillis() - this.b2;
        Intrinsics.checkNotNullParameter(this, "$this$reportFeedAdPlayOver");
        com.bytedance.android.shopping.mall.homepage.card.live.a.a(this, "feed_ad_play_over", MapsKt.mapOf(TuplesKt.to("duration", Long.valueOf(r4))));
        this.b2 = System.currentTimeMillis();
        j4(IHybridListViewHolder.ECCardPlayState.IDLE);
        ((BaseViewHolder) this).j = false;
        return;
    L15:
        if (TextUtils.isEmpty(this.v) == false) goto L17;
    L18:
        IHybridLiveBoxView r5 = this.Q1;
        if (r5 == null) goto L21;
        r5.setMute(true);
        goto L21
    L17:
        if (TextUtils.equals(this.v, r2) == true) goto L21;
    L11:
        r2 = null;
        goto L13
    }

    public final boolean H4() {
        LiveCardModel r0 = this.T1;
        if (r0 == null) goto L28;
        LiveCardModel.Experiment r1 = r0.getExperiment();
        if (r1 != null) goto L7;
        return false;
    L7:
        if (r1.getLiveCardChangeCover() != true) goto L30;
        int r2 = com.bytedance.forest.utils.h.a;
        LiveCardData r3 = this.u;
        if (r3 == null) goto L17;
        CommonData.Product r4 = r3.getProduct();
        if (r4 == null) goto L17;
        CommonData.UrlStruct r5 = r4.getCover();
        if (r5 == null) goto L17;
        List<String> r6 = r5.getUrlList();
        if (r6 == null) goto L17;
        String r7 = (String) CollectionsKt.getOrNull(r6, 0);
    L19:
        if (com.bytedance.forest.utils.h.a(r7) == false) goto L31;
        LiveCardModel r8 = this.T1;
        if (r8 == null) goto L32;
        CommonModel$Product r9 = r8.getProduct();
        if (r9 != null) goto L25;
        return false;
    L25:
        if (r9.isCoverInPool() != true) goto L34;
        return true;
    L34:
        return false;
    L32:
        return false;
    L31:
        return false;
    L17:
        r7 = null;
        goto L19
    L30:
        return false;
    L28:
        return false;
    }

    public final void I2() {
        if (this.Q1 == null) goto L5;
        return;
    L5:
        if (((Number) this.h2.getValue()).intValue() > 1) goto L7;
        return;
    L7:
        if (CollectionsKt.contains((List) this.p2.getValue(), this.K) == false) goto L18;
        ECHybridListItemVO r0 = ((BaseViewHolder) this).c;
        if (r0 != null) goto L11;
        return;
    L11:
        if (r0.l != true) goto L20;
        I4();
        IHybridLiveBoxView r1 = this.Q1;
        if (r1 == null) goto L21;
        r1.preCreatePlayerView();
        return;
    L21:
        return;
    L20:
        return;
    }

    public final GradientDrawable M4() {
        GradientDrawable r0 = new GradientDrawable();
        r0.setStroke(b0.c(2), ColorProtector.parseColor("#FF002A"));
        ECHybridListItemVO r2 = ((BaseViewHolder) this).c;
        Number r3 = null;
        if (r2 == null) goto L7;
        com.bytedance.android.ec.hybrid.list.entity.e r4 = r2.L;
        if (r4 == null) goto L7;
        Integer r5 = r4.c;
    L8:
        if (r2 == null) goto L12;
        com.bytedance.android.ec.hybrid.list.entity.e r6 = r2.L;
        if (r6 == null) goto L12;
        List r7 = r6.b;
    L13:
        boolean r8 = false;
        if (r5 == null) goto L41;
        if (r7 == null) goto L41;
        if (r7.size() != 4) goto L41;
        int r9 = ToolsKt.g(this);
        if (r5.intValue() != (-1)) goto L21;
    L25:
        Float r10 = (Float) CollectionsKt.getOrNull(r7, 0);
        float r11 = 0.0f;
        if (r10 == null) goto L28;
        float r12 = b0.c(Float.valueOf(r10.floatValue() - 1)) * this.s;
    L29:
        Float r13 = (Float) CollectionsKt.getOrNull(r7, 1);
        if (r13 == null) goto L32;
        float r14 = b0.c(Float.valueOf(r13.floatValue() - 1)) * this.s;
    L33:
        Float r15 = (Float) CollectionsKt.getOrNull(r7, 2);
        if (r15 == null) goto L36;
        float r16 = b0.c(Float.valueOf(r15.floatValue() - 1)) * this.s;
    L37:
        Float r17 = (Float) CollectionsKt.getOrNull(r7, 3);
        if (r17 == null) goto L40;
        r11 = this.s * b0.c(Float.valueOf(r17.floatValue() - 1));
    L40:
        r0.setCornerRadii(new float[]{r12, r12, r14, r14, r16, r16, r11, r11});
        r8 = true;
        goto L41
    L36:
        r16 = 0.0f;
        goto L37
    L32:
        r14 = 0.0f;
        goto L33
    L28:
        r12 = 0.0f;
        goto L29
    L21:
        if (r5.intValue() <= 0) goto L41;
        if (r9 < 0) goto L41;
        if (r9 < r5.intValue()) goto L25;
    L41:
        if (r8 == true) goto L57;
        ECHybridListItemVO r1 = ((BaseViewHolder) this).c;
        if (r1 == null) goto L49;
        com.bytedance.android.ec.hybrid.list.entity.e r18 = r1.L;
        if (r18 == null) goto L49;
        Double r19 = r18.a;
        if (r19 == null) goto L49;
        r3 = Double.valueOf(r19.doubleValue() - ((double) 1));
    L54:
        if (r3 != null) goto L56;
        r3 = 9;
    L56:
        r0.setCornerRadius(b0.c(r3));
    L49:
        LiveCardModel r20 = this.T1;
        if (r20 == null) goto L54;
        LiveCardData.FavoriteItemStyle r21 = r20.getItemStyle();
        if (r21 == null) goto L54;
        r3 = r21.getItemCornerRadius();
    L57:
        return r0;
    L12:
        r7 = null;
    L7:
        r5 = null;
        goto L8
    }

    public final String Q4() {
        String r2 = null;
        Map<String, ? extends Object> r3 = null;
        r2 = null;
        if (((Boolean) this.v2.getValue()).booleanValue() == true) goto L5;
    L24:
        int r0 = com.bytedance.forest.utils.h.a;
        LiveCardData r1 = this.u;
        if (r1 == null) goto L29;
        LiveCardData.Live r4 = r1.getLive();
        if (r4 == null) goto L29;
        String r5 = r4.getStreamData();
    L31:
        if (com.bytedance.forest.utils.h.a(r5) == false) goto L40;
        Map<String, Object> r6 = c0.a;
        LiveCardData r7 = this.u;
        if (r7 == null) goto L37;
        LiveCardData.Live r8 = r7.getLive();
        if (r8 == null) goto L37;
        r2 = r8.getStreamData();
    L37:
        String r9 = URLEncoder.encode(r2);
        Intrinsics.checkNotNullParameter("pullStreamData", "key");
        Intrinsics.checkNotNullParameter(r9, "value");
        Map<String, Object> r10 = c0.a;
        if (r10 == null) goto L43;
        r10.put("pullStreamData", r9);
    L43:
        ECHybridListItemVO r11 = ((BaseViewHolder) this).c;
        if (r11 == null) goto L49;
        ECNAMallCardExtra r12 = r11.c();
        if (r12 == null) goto L49;
        Map r13 = r12.getSchemaMap();
        if (r13 == null) goto L49;
    L51:
        return c0.a(r13, false, ToolsKt.g(this), new NativeLiveCard$getLiveClickSchema$2(this));
    L49:
        r13 = MapsKt.emptyMap();
        goto L51
    L40:
        Map<String, Object> r14 = c0.a;
        Intrinsics.checkNotNullParameter("pullStreamData", "key");
        Map<String, Object> r15 = c0.a;
        if (r15 == null) goto L43;
        r15.remove("pullStreamData");
    L29:
        r5 = null;
        goto L31
    L5:
        if (e5() == false) goto L24;
        a0 r16 = new a0(ToolsKt.k(this));
        ECHybridListItemVO r17 = ((BaseViewHolder) this).c;
        if (r17 == null) goto L12;
        ECNAMallCardExtra r18 = r17.c();
        if (r18 == null) goto L12;
        Map<String, String> r19 = r18.getSchemaMap();
        if (r19 == null) goto L12;
    L13:
        Map<String, String> r20 = r19;
        int r21 = ToolsKt.g(this);
        LiveCardData r22 = this.u;
        if (r22 == null) goto L18;
        LiveCardData.Live r23 = r22.getLive();
        if (r23 == null) goto L18;
        String r24 = r23.getStreamData();
    L20:
        if (com.bytedance.forest.utils.h.a(r24) == false) goto L23;
        r3 = MapsKt.mapOf(TuplesKt.to("pullStreamData", URLEncoder.encode(r24)));
    L23:
        return r16.a(r20, false, r21, r3, new NativeLiveCard$getLiveClickSchema$1(this));
    L18:
        r24 = null;
    L12:
        r19 = MapsKt.emptyMap();
        goto L13
    }

    public final void d5() {
        LiveCardData r1 = this.u;
        if (r1 == null) goto L7;
        LiveCardData.Live r2 = r1.getLive();
        if (r2 == null) goto L7;
        String r3 = r2.getDescText();
    L9:
        if (com.bytedance.forest.utils.h.a(r3) == false) goto L147;
        J4().setVisibility(0);
        LiveCardModel r4 = this.T1;
        if (r4 == null) goto L17;
        LiveCardModel.ElementStyle r5 = r4.getElementStyle();
        if (r5 == null) goto L17;
        CommonModel$CusTextStyle r6 = r5.getArriveTimeTextStyle();
        if (r6 == null) goto L17;
        String r7 = r6.getBackgroundColor();
    L18:
        LiveCardModel r8 = this.T1;
        if (r8 == null) goto L27;
        LiveCardModel.ElementStyle r9 = r8.getElementStyle();
        if (r9 == null) goto L27;
        CommonModel$LayoutStyle r10 = r9.getArriveTimeTextLayout();
        if (r10 == null) goto L27;
        Double r11 = r10.getRadius();
        if (r11 == null) goto L27;
        Float r13 = Float.valueOf((float) r11.doubleValue());
    L28:
        LiveCardModel r12 = this.T1;
        if (r12 == null) goto L35;
        LiveCardModel.ElementStyle r14 = r12.getElementStyle();
        if (r14 == null) goto L35;
        CommonModel$LayoutStyle r15 = r14.getArriveTimeTextLayout();
        if (r15 == null) goto L35;
        Integer r16 = r15.getRight();
    L36:
        ProductTextView r17 = J4();
        LiveCardModel r18 = this.T1;
        if (r18 == null) goto L44;
        LiveCardModel.ElementStyle r19 = r18.getElementStyle();
        if (r19 == null) goto L44;
        CommonModel$CusTextStyle r20 = r19.getArriveTimeTextStyle();
        if (r20 == null) goto L44;
        String r21 = r20.getColor();
        if (r21 == null) goto L44;
    L45:
        String r110 = r21;
        LiveCardModel r22 = this.T1;
        if (r22 == null) goto L54;
        LiveCardModel.ElementStyle r23 = r22.getElementStyle();
        if (r23 == null) goto L54;
        CommonModel$CusTextStyle r24 = r23.getArriveTimeTextStyle();
        if (r24 == null) goto L54;
        Integer r25 = r24.getFontWeight();
        if (r25 == null) goto L54;
        int r26 = r25.intValue();
    L55:
        Integer r27 = Integer.valueOf(r26);
        Float r29 = Float.valueOf(0.5f);
        LiveCardModel r28 = this.T1;
        if (r28 == null) goto L64;
        LiveCardModel.ElementStyle r30 = r28.getElementStyle();
        if (r30 == null) goto L64;
        CommonModel$LayoutStyle r31 = r30.getArriveTimeTextLayout();
        if (r31 == null) goto L64;
        Integer r32 = r31.getLeft();
        if (r32 == null) goto L64;
        Float r210 = Float.valueOf(r32.intValue());
    L66:
        if (r16 == null) goto L68;
        Float r211 = Float.valueOf(r16.intValue());
    L69:
        int r40 = 3;
        if (com.bytedance.forest.utils.h.a(r7) == false) goto L73;
        if (r13 == null) goto L73;
        int r33 = 1;
        Shape r34 = new Shape(CollectionsKt.listOf(new Float[]{r13, r13, r13, r13}), null, null, r7, 6, null);
    L74:
        new TextBaseUIParams(r3, new ProductStyle(null, null, r110, null, r27, null, "DouyinNumberABC-Medium", r210, r211, null, null, null, r29, null, null, null, 1, r34, null, null, null, 1895979, null));
        r17.y(r12);
        LiveCardModel r35 = this.T1;
        if (r35 == null) goto L81;
        LiveCardModel.ElementStyle r36 = r35.getElementStyle();
        if (r36 == null) goto L81;
        if (r36.getRemoveShadow() != r33) goto L81;
        J4().setShadowLayer(0.0f, 0.0f, 0.0f, 0);
    L82:
        LiveCardData r37 = this.u;
        if (r37 == null) goto L85;
        String r38 = r37.getDescIcon();
    L86:
        int r39 = -1;
        if (com.bytedance.forest.utils.h.a(r38) == false) goto L105;
        ViewGroup.LayoutParams r41 = J4().getLayoutParams();
        if ((r41 instanceof ConstraintLayout.LayoutParams) == true) goto L91;
        r41 = null;
    L91:
        ConstraintLayout.LayoutParams r42 = (ConstraintLayout.LayoutParams) r41;
        if (r42 == null) goto L94;
        r42.leftToRight = L4().getId();
    L94:
        if (r42 == null) goto L96;
        r42.topToTop = L4().getId();
    L96:
        if (r42 == null) goto L98;
        r42.bottomToBottom = L4().getId();
    L98:
        if (r42 == null) goto L100;
        r42.leftToLeft = -1;
    L100:
        L4().setVisibility(0);
        SimpleDraweeView r43 = L4();
        LiveCardData r44 = this.u;
        if (r44 == null) goto L103;
        String r45 = r44.getDescIcon();
    L104:
        r43.setImageURI(r45);
    L119:
        LiveCardModel r46 = this.T1;
        if (r46 == null) goto L126;
        LiveCardModel.ElementStyle r47 = r46.getElementStyle();
        if (r47 == null) goto L126;
        Integer r48 = r47.getColorfulCardStyle();
        if (r48 == null) goto L126;
        int r49 = r48.intValue();
    L127:
        if (r13 == null) goto L129;
        float r50 = r13.floatValue();
    L130:
        float r51 = b0.c(Float.valueOf(r50));
        if (r49 != r33) goto L133;
        J4().setBackground(null);
        AppCompatTextView r52 = J4();
        if (r16 == null) goto L142;
        int r53 = r16.intValue();
    L143:
        r52.setPadding(0, 0, b0.c(Integer.valueOf(r53)), 0);
        K4().setVisibility(0);
        View r54 = K4();
        p93.b.d.getClass();
        Integer r55 = p93.b.e(r7);
        if (r55 == null) goto L146;
        r39 = r55.intValue();
    L146:
        int r56 = ColorProtector.parseColor("#21FFFFFF");
        int r57 = b0.c(Double.valueOf(0.5d));
        float[] r58 = new float[4];
        r58[0] = r51;
        r58[r33] = r51;
        r58[2] = r51;
        r58[3] = r51;
        r54.setBackground(p93.b.a(r39, r56, r57, r58));
        return;
    L142:
        r53 = 3;
        goto L143
    L133:
        if (r49 == 2) goto L135;
        K4().setVisibility(8);
        return;
    L135:
        J4().setBackground(null);
        AppCompatTextView r59 = J4();
        if (r16 == null) goto L138;
        r40 = r16.intValue();
    L138:
        r59.setPadding(0, 0, b0.c(Integer.valueOf(r40)), 0);
        K4().setVisibility(0);
        K4().setBackground(ContextCompat.getDrawable(((RecyclerView.ViewHolder) this).itemView.getContext(), 2131243902));
        return;
    L129:
        r50 = 3.0f;
    L126:
        r49 = 0;
        goto L127
    L103:
        r45 = null;
        goto L104
    L105:
        L4().setVisibility(8);
        ViewGroup.LayoutParams r60 = J4().getLayoutParams();
        if ((r60 instanceof ConstraintLayout.LayoutParams) == true) goto L108;
        r60 = null;
    L108:
        ConstraintLayout.LayoutParams r61 = (ConstraintLayout.LayoutParams) r60;
        if (r61 == null) goto L111;
        r61.leftToRight = -1;
    L111:
        if (r61 == null) goto L113;
        r61.topToTop = -1;
    L113:
        if (r61 == null) goto L115;
        r61.bottomToBottom = -1;
    L115:
        if (r61 == null) goto L117;
        r61.leftToLeft = R4().getId();
    L117:
        if (r61 == null) goto L119;
        r61.bottomToBottom = R4().getId();
        goto L119
    L85:
        r38 = null;
    L81:
        J4().setShadowLayer(2.0f, 0.0f, 1.0f, ColorProtector.parseColor("#57000000"));
    L73:
        r33 = 1;
        J4().setBackground(null);
        r34 = null;
        goto L74
    L68:
        r211 = null;
    L64:
        r210 = null;
    L54:
        r26 = 500;
    L44:
        r21 = "#FFFFFFFF";
    L35:
        r16 = null;
    L27:
        r13 = null;
    L17:
        r7 = null;
        goto L18
    L147:
        J4().setVisibility(8);
        L4().setVisibility(8);
        K4().setVisibility(8);
        return;
    L7:
        r3 = null;
        goto L9
    }

    public final void f5() {
        if (com.bytedance.android.ec.hybrid.tools.e.b.getType().f() == true) goto L5;
        return;
    L5:
        Long r0 = this.y2;
        if (r0 == null) goto L82;
        long r4 = System.currentTimeMillis() - r0.longValue();
        String r1 = this.x2;
        Intrinsics.checkNotNullParameter(this, "$this$reportPlayDuration");
        Intrinsics.checkNotNullParameter(r1, "clientHash");
        List r7 = CollectionsKt.listOf(new String[]{"enter_from_merge", "enter_method", "anchor_id"});
        ECHybridListItemVO r8 = ((BaseViewHolder) this).c;
        if (r8 == null) goto L57;
        com.bytedance.android.ec.hybrid.list.entity.n r9 = r8.o;
        if (r9 == null) goto L57;
        Intrinsics.checkNotNullParameter(r7, "name");
        HashMap r10 = new HashMap();
        Iterator r11 = r7.iterator();
    L13:
        if (r11.hasNext() == false) goto L58;
        String r12 = (String) r11.next();
        HashMap r13 = r9.a;
        if (r13 == null) goto L19;
        Object r14 = r13.get(r12);
        if (r14 == null) goto L19;
        r10.put(r12, r14);
    L19:
        HashMap r15 = r9.b;
        if (r15 == null) goto L24;
        Object r16 = r15.get(r12);
        if (r16 == null) goto L24;
        r10.put(r12, r16);
    L24:
        List r17 = r9.c;
        if (r17 == null) goto L35;
        Iterator r18 = r17.iterator();
    L28:
        if (r18.hasNext() == false) goto L35;
        com.bytedance.android.ec.hybrid.list.entity.c r19 = (com.bytedance.android.ec.hybrid.list.entity.c) r18.next();
        r19.getClass();
        Intrinsics.checkNotNullParameter(r12, "name");
        Map r110 = r19.b;
        if (r110 == null) goto L32;
        Object r111 = r110.get(r12);
    L33:
        if (r111 == null) goto L28;
        r10.put(r12, r111);
        goto L13
    L32:
        r111 = null;
    L35:
        List r112 = r9.e;
        if (r112 == null) goto L46;
        Iterator r113 = r112.iterator();
    L39:
        if (r113.hasNext() == false) goto L46;
        com.bytedance.android.ec.hybrid.list.entity.c r114 = (com.bytedance.android.ec.hybrid.list.entity.c) r113.next();
        r114.getClass();
        Intrinsics.checkNotNullParameter(r12, "name");
        Map r115 = r114.b;
        if (r115 == null) goto L43;
        Object r116 = r115.get(r12);
    L44:
        if (r116 == null) goto L39;
        r10.put(r12, r116);
        goto L13
    L43:
        r116 = null;
    L46:
        List r117 = r9.g;
        if (r117 == null) goto L13;
        Iterator r118 = r117.iterator();
    L50:
        if (r118.hasNext() == false) goto L13;
        com.bytedance.android.ec.hybrid.list.entity.c r119 = (com.bytedance.android.ec.hybrid.list.entity.c) r118.next();
        r119.getClass();
        Intrinsics.checkNotNullParameter(r12, "name");
        Map r120 = r119.b;
        if (r120 == null) goto L54;
        Object r121 = r120.get(r12);
    L55:
        if (r121 == null) goto L50;
        r10.put(r12, r121);
        goto L13
    L54:
        r121 = null;
    L58:
        JSONObject r20 = new JSONObject();
        r20.putOpt("duration", Long.valueOf(r4));
        r20.putOpt("client_code", r1);
        LiveCardData r2 = this.u;
        Object r5 = "";
        if (r2 == null) goto L64;
        LiveCardData.Live r3 = r2.getLive();
        if (r3 == null) goto L64;
        String r6 = r3.getRoomId();
        if (r6 == null) goto L64;
    L65:
        r20.putOpt("room_id", r6);
        r20.putOpt("request_id", ToolsKt.l(this));
        if (r10 == null) goto L69;
        Object r21 = r10.get("anchor_id");
        if (r21 == null) goto L69;
    L70:
        r20.putOpt("anchor_id", r21);
        if (r10 == null) goto L74;
        Object r22 = r10.get("enter_from_merge");
        if (r22 == null) goto L74;
    L75:
        r20.putOpt("enter_from_merge", r22);
        if (r10 == null) goto L81;
        Object r23 = r10.get("enter_method");
        if (r23 == null) goto L81;
        r5 = r23;
    L81:
        r20.putOpt("enter_method", r5);
        AppLogNewUtils.onEventV3("livesdk_live_window_duration_v2", r20);
    L74:
        r22 = "";
    L69:
        r21 = "";
    L64:
        r6 = "";
    L57:
        r10 = null;
    L82:
        this.y2 = null;
    }

    public final boolean h5() {
        if (((Number) this.h2.getValue()).intValue() > 0) goto L5;
    L7:
        return false;
    L5:
        if (CollectionsKt.contains((List) this.p2.getValue(), this.K) == false) goto L7;
        return true;
    }

    public final void i5() {
        Lazy r0 = BigFontAdapter.a;
        if (BigFontAdapter.c(ToolsKt.k(this)) == false) goto L30;
        ViewGroup.LayoutParams r1 = V4().getLayoutParams();
        ViewGroup.LayoutParams r2 = null;
        if ((r1 instanceof ConstraintLayout.LayoutParams) == true) goto L7;
        r1 = null;
    L7:
        ConstraintLayout.LayoutParams r3 = (ConstraintLayout.LayoutParams) r1;
        if (r3 == null) goto L10;
        r3.rightToRight = 0;
        r3.horizontalBias = 0.0f;
        r3.constrainedWidth = true;
    L10:
        S4().setGravity(16);
        BigFontAdapter.e(V4(), 4);
        View r4 = V4();
        Intrinsics.checkNotNullParameter(r4, FreqActions.ACTION_VIEW);
        if (Build.VERSION.SDK_INT < 24) goto L18;
        Drawable r5 = r4.getBackground();
        if ((r5 instanceof GradientDrawable) == true) goto L15;
        r5 = null;
    L15:
        GradientDrawable r6 = (GradientDrawable) r5;
        if (r6 == null) goto L18;
        r6.setCornerRadius(r6.getCornerRadius() * BigFontAdapter.a().getScale());
    L18:
        View r7 = V4();
        int r8 = (int) UIUtils.dip2Px(V4().getContext(), 10.0f);
        Intrinsics.checkNotNullParameter(r7, FreqActions.ACTION_VIEW);
        ViewGroup.LayoutParams r9 = r7.getLayoutParams();
        if ((r9 instanceof ViewGroup.MarginLayoutParams) == false) goto L22;
        r2 = r9;
    L22:
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r2;
        if (r10 == null) goto L26;
        if (r8 <= 0) goto L26;
        r10.rightMargin = r8;
    L26:
        BigFontAdapter.e(T4(), 6);
        BigFontAdapter.d(S4());
        N4().T5();
        com.bytedance.android.shopping.mall.homepage.card.common.feedback.b r11 = t4();
        r11.c = Boolean.TRUE;
        FeedbackView r12 = r11.b;
        if (r12 == null) goto L31;
        r12.U5();
        return;
    L31:
        return;
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [android.view.ViewGroup, com.bytedance.android.shopping.api.mall.common.homepage.card.common.ECRoundedConstraintLayout, com.bytedance.android.shopping.api.mall.common.homepage.card.common.ECUpdateHeightConstraintLayout] */
    public final void n5() {
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
        TransitionAnimationHelper.e(b5(), ((float) r4) * this.s, false);
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
        ?? r11 = P4();
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
        P4().setRadius(b0.c(Double.valueOf(r4)) * this.s);
        return;
    L22:
        r8 = null;
        goto L23
    L16:
        r4 = 6.0d;
    L8:
        LiveCardModel r20 = this.T1;
        if (r20 == null) goto L13;
        LiveCardData.FavoriteItemStyle r21 = r20.getItemStyle();
        if (r21 == null) goto L13;
        r3 = r21.getItemCornerRadius();
    L13:
        r3 = null;
        goto L14
    }

    public final void onCreate() {
        new com.bytedance.android.shopping.mall.homepage.card.c(W4(), this.G2, ToolsKt.k(this)).a();
        new com.bytedance.android.shopping.mall.homepage.card.c(Z4(), this.G2, ToolsKt.k(this)).a();
        i5();
        if (com.bytedance.android.ec.hybrid.tools.e.b.getType().c() == true) goto L5;
        return;
    L5:
        if (((Boolean) ToolsKt.b.getValue()).booleanValue() == true) goto L9;
        int r0 = com.bytedance.android.ec.hybrid.list.util.c.a;
        o5(com.bytedance.android.ec.hybrid.list.util.c.f(((RecyclerView.ViewHolder) this).itemView.getContext()));
        return;
    }

    public final void onShow() {
        LiveCardData r0 = this.u;
        if (r0 == null) goto L5;
        Boolean r1 = r0.getNeedAnimation();
    L7:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L12;
        LiveCardData r2 = this.u;
        if (r2 == null) goto L11;
        r2.setNeedAnimation(Boolean.FALSE);
    L11:
        P4().scrollTo(0, P4().getHeight());
        ValueAnimator r3 = ValueAnimator.ofInt(new int[]{P4().getScrollY(), 0});
        r3.setDuration(200);
        r3.addUpdateListener(new b(this));
        r3.addListener(new c(this));
        r3.start();
    L12:
        this.V1 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(this, "$this$reportFeedAdShow");
        com.bytedance.android.shopping.mall.homepage.card.live.a.a(this, "feed_ad_show", null);
        this.F2 = true;
        ECHybridListItemVO r4 = ((BaseViewHolder) this).c;
        if (r4 == null) goto L16;
        r4.K = false;
        return;
    L16:
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.shopping.mall.homepage.card.live.BaseLiveViewHolder
    public final boolean w4() {
        if (this.P1 == false) goto L11;
        LiveCardData r0 = this.u;
        if (r0 == null) goto L7;
        Boolean r1 = r0.getCardMute();
    L9:
        if ((!Intrinsics.areEqual(r1, Boolean.TRUE)) == false) goto L11;
        return true;
    L7:
        r1 = null;
    L11:
        return false;
    }

    @Override // com.bytedance.android.shopping.mall.homepage.card.live.BaseLiveViewHolder
    public final String A4() {
        return Q4();
    }

    public final void I4() {
        F4();
        if (this.R2 == false) goto L11;
        u r0 = MallServiceUtil.a();
        if (r0 != null) goto L7;
    L8:
        this.z = System.currentTimeMillis();
        this.A = System.currentTimeMillis();
        o.b(this, 1, 0, null, 2, 6);
        return;
    L7:
        if (r0.a() != true) goto L8;
    L11:
        if (com.bytedance.android.shopping.api.mall.common.tools.h.b.liveSdkInitFinished() == true) goto L37;
        return;
    L37:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L27
        t r2 = com.bytedance.android.ec.hybrid.a.g();     // Catch: Throwable -> L27
        Unit r3 = null;
        if (r2 == null) goto L16;
        IHybridLiveBoxView r4 = r2.getHybridLiveBoxViewWithReUse(((RecyclerView.ViewHolder) this).itemView.getContext(), h5());     // Catch: Throwable -> L27
    L17:
        this.Q1 = r4;     // Catch: Throwable -> L27
        Gson r5 = new Gson();     // Catch: Throwable -> L27
        LiveCardData r6 = this.u;     // Catch: Throwable -> L27
        if (r6 == null) goto L21;
        Object r7 = r6.getLive();     // Catch: Throwable -> L27
        if (r7 == null) goto L21;
    L22:
        String r8 = r5.toJson(r7);     // Catch: Throwable -> L27
        IHybridLiveBoxView r9 = this.Q1;     // Catch: Throwable -> L27
        if (r9 == null) goto L25;
        r9.setLiveData(r8);     // Catch: Throwable -> L27
        r3 = Unit.INSTANCE;     // Catch: Throwable -> L27
    L25:
        Object r10 = Result.constructor-impl(r3);     // Catch: Throwable -> L27
    L29:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L33;
        EnsureManager.ensureNotReachHere(r11);
    L33:
        if (this.Q1 == null) goto L35;
        W4().addView(this.Q1, new FrameLayout.LayoutParams(-1, -1));
    L35:
        ((BaseViewHolder) this).j = true;
        return;
    L21:
        r7 = "";
        goto L22
    L16:
        r4 = null;
    L27:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    }

    public final boolean e5() {
        Object r0 = ToolsKt.k(this).get(PdpOpenThirdParam.KEY_PAGE_NAME);
        if (r0 == null) goto L5;
        String r1 = r0.toString();
    L6:
        if (r1 == null) goto L24;
        int r2 = r1.hashCode();
        if (r2 == (-1773284929)) goto L22;
        if (r2 == (-115656858)) goto L19;
        if (r2 != 556139984) goto L24;
        if (r1.equals(MallPageName.X_TAB_MALL) == false) goto L24;
    L23:
        return false;
    L19:
        if (r1.equals("popup_mall_homepage") == false) goto L24;
    L22:
        if (r1.equals("order_homepage") == true) goto L23;
    L24:
        return true;
    L5:
        r1 = null;
        goto L6
    }

    public final void o() {
        if (h5() == false) goto L10;
        g5(this);
        IHybridLiveBoxView r0 = this.Q1;
        if (r0 == null) goto L7;
        IHybridLiveBoxView.stopPlayerClient$default(r0, null, 1, null);
    L7:
        IHybridLiveBoxView r1 = this.Q1;
        if (r1 == null) goto L10;
        b0.e(r1);
    L10:
        super.o();
    }

    public final void onHide() {
        if (h5() == false) goto L5;
        D();
    L6:
        b0.e((ECRoundedCornerImageView) this.S.getValue());
        long r0 = System.currentTimeMillis() - this.V1;
        Intrinsics.checkNotNullParameter(this, "$this$reportFeedAdShowOver");
        com.bytedance.android.shopping.mall.homepage.card.live.a.a(this, "feed_ad_show_over", MapsKt.mapOf(TuplesKt.to("duration", Long.valueOf(r0))));
        this.V1 = System.currentTimeMillis();
        this.F2 = false;
        return;
    L5:
        F4();
        goto L6
    }

    @Override // com.bytedance.android.shopping.mall.homepage.card.live.BaseLiveViewHolder
    public final void onRelease() {
        super.onRelease();
        com.bytedance.android.ec.hybrid.card.api.e r0 = this.M;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        this.M = null;
        P4().f = null;
        if (((Boolean) this.K2.getValue()).booleanValue() == false) goto L11;
        MutableLiveData<Float> r1 = this.V2;
        if (r1 == null) goto L12;
        r1.removeObserver(this.J2);
        return;
    L12:
        return;
    }

    public final void p5() {
        ViewGroup.LayoutParams r0 = R4().getLayoutParams();
        Float r2 = null;
        if ((r0 instanceof ConstraintLayout.LayoutParams) == true) goto L5;
        r0 = null;
    L5:
        ConstraintLayout.LayoutParams r1 = (ConstraintLayout.LayoutParams) r0;
        ViewGroup.LayoutParams r3 = N4().getLayoutParams();
        if ((r3 instanceof ConstraintLayout.LayoutParams) == true) goto L8;
        r3 = null;
    L8:
        ConstraintLayout.LayoutParams r4 = (ConstraintLayout.LayoutParams) r3;
        LiveCardModel r5 = this.T1;
        if (r5 == null) goto L20;
        LiveCardModel.Experiment r6 = r5.getExperiment();
        if (r6 == null) goto L20;
        if (r6.getLiveCardEnlargePlayArea() != true) goto L20;
        if (r1 == null) goto L16;
        r1.bottomToTop = -1;
    L16:
        if (r1 == null) goto L18;
        r1.bottomToBottom = 0;
    L18:
        if (r4 == null) goto L41;
        r4.topToBottom = -1;
        return;
    L41:
        return;
    L20:
        if (r1 == null) goto L22;
        r1.bottomToTop = N4().getId();
    L22:
        if (r1 == null) goto L24;
        r1.bottomToBottom = -1;
    L24:
        if (r4 == null) goto L26;
        r4.topToBottom = R4().getId();
    L26:
        LiveCardModel r7 = this.T1;
        if (r7 == null) goto L31;
        LiveCardModel.ElementStyle r8 = r7.getElementStyle();
        if (r8 == null) goto L31;
        Double r9 = r8.getHeight();
    L32:
        if (r9 != null) goto L43;
        LiveCardModel r10 = this.T1;
        if (r10 == null) goto L38;
        LiveCardModel.ElementStyle r11 = r10.getElementStyle();
        if (r11 == null) goto L38;
        r2 = r11.getFeedCardRatio();
    L38:
        if (r2 != null) goto L44;
        ToolsKt.B(R4(), String.valueOf(0.8028169014d));
        ToolsKt.B(W4(), String.valueOf(0.8028169014d));
        ToolsKt.A(P4(), 0.0f, null, null, -2, null, null, null, null, false, null, 1015);
        return;
    L44:
        return;
    L43:
        return;
    L31:
        r9 = null;
        goto L32
    }

    @Override // com.bytedance.android.shopping.mall.homepage.card.live.BaseLiveViewHolder, com.bytedance.android.shopping.mall.homepage.card.AbstractNativeCard
    public final ECRoundedConstraintLayout r4() {
        return P4();
    }

    public final void X3() {
        f5();
    }

    public final void l4() {
        n5();
    }

    public final boolean n4() {
        return this.U2;
    }

    public static void g5(NativeLiveCard r1) {
        r1.g2 = false;
        ToolsKt.E(r1.T4());
        r1.j4(IHybridListViewHolder.ECCardPlayState.IDLE);
    }

    public final void D1(Long r3) {
        ((BaseViewHolder) this).a = IHybridListViewHolder.ECCardPlayState.PLAYING;
        if (this.Q1 != null) goto L5;
        I4();
    L5:
        this.E2 = false;
        this.y = r3;
        this.z = System.currentTimeMillis();
        this.S1 = true;
        String r0 = this.v;
        if (r0 == null) goto L11;
        if (this.J == null) goto L11;
        l5(g93.a.a(r0));
    L11:
        if (h5() == false) goto L19;
        IHybridLiveBoxView r1 = this.Q1;
        if (r1 == null) goto L19;
        if (r1.getVisibility() != 8) goto L19;
        this.g2 = true;
        IHybridLiveBoxView r4 = this.Q1;
        if (r4 == null) goto L19;
        b0.n(r4);
    L19:
        IHybridLiveBoxView r5 = this.Q1;
        if (r5 == null) goto L22;
        r5.stream(new NativeLiveCard$playVideo$2(this));
    L22:
        ToolsKt.D(T4());
    }

    public final void h4(boolean r3) {
        Function0<Unit> r0 = new NativeLiveCard$saveCurrentFrame$saveFrame$1(this);
        if (r3 == false) goto L5;
        ThreadPoolHelper.c().submit(new d(r0));
        return;
    L5:
        r0.invoke();
    }

    public final void k5(int r15) {
        ToolsKt.B(R4(), null);
        ToolsKt.B(W4(), null);
        ToolsKt.A(P4(), 0.0f, null, null, Integer.valueOf(r15), null, null, null, null, false, null, 1015);
    }

    public final void l5(boolean r4) {
        IHybridLiveBoxView r0 = this.Q1;
        if (r0 == null) goto L6;
        r0.setMute(r4);
    L6:
        if (r4 == false) goto L11;
        ImageView r5 = U4();
        MallLiveCardOpt.a r1 = MallLiveCardOpt.d;
        Context r2 = ((RecyclerView.ViewHolder) this).itemView.getContext();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "context");
        Bitmap r3 = MallLiveCardOpt.b;
        if (r3 != null) goto L10;
        r3 = BitmapFactory.decodeResource(r2.getResources(), 2131248018);
    L10:
        r5.setImageBitmap(r3);
        return;
    L11:
        ImageView r6 = U4();
        MallLiveCardOpt.a r7 = MallLiveCardOpt.d;
        Context r8 = ((RecyclerView.ViewHolder) this).itemView.getContext();
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "context");
        Bitmap r9 = MallLiveCardOpt.c;
        if (r9 != null) goto L14;
        r9 = BitmapFactory.decodeResource(r8.getResources(), 2131248019);
    L14:
        r6.setImageBitmap(r9);
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
        LiveCardData r2 = this.u;
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

    public final void o5(float r47) {
        this.s = r47;
        com.bytedance.android.shopping.api.mall.idl.c r1 = this.W2;
        String r16 = null;
        if (r1 == null) goto L15;
        Integer r2 = r1.b;
        if (r2 == null) goto L15;
        if (r2.intValue() <= 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == true) goto L13;
        r2 = null;
    L13:
        if (r2 == null) goto L15;
        Integer r12 = Integer.valueOf(b0.c(r2));
    L16:
        com.bytedance.android.shopping.api.mall.idl.c r4 = this.W2;
        if (r4 == null) goto L19;
        Integer r5 = r4.d;
    L20:
        if (r4 != null) goto L22;
    L35:
        LiveCardModel r6 = this.T1;
        if (r6 == null) goto L50;
        LiveCardModel.ElementStyle r7 = r6.getElementStyle();
        if (r7 == null) goto L50;
        Double r8 = r7.getHeight();
        if (r8 == null) goto L50;
        if (r8.doubleValue() <= 0) goto L44;
        boolean r9 = true;
    L45:
        if (r9 == true) goto L48;
        r8 = null;
    L48:
        if (r8 == null) goto L50;
        k5(ToolsKt.d(Double.valueOf(r8.doubleValue()), ((RecyclerView.ViewHolder) this).itemView.getContext(), ((Boolean) this.L2.getValue()).booleanValue(), r12));
        goto L50
    L44:
        r9 = false;
    L50:
        ConstraintLayout r10 = N4();
        LiveCardModel r11 = this.T1;
        if (r11 == null) goto L55;
        LiveCardModel.ElementStyle r13 = r11.getElementStyle();
        if (r13 == null) goto L55;
        CommonModel$LayoutStyle r14 = r13.getInfoLayout();
    L56:
        Integer r30 = r12;
        ToolsKt.A(r10, r47, r14, null, null, Integer.valueOf(b0.c(8)), Integer.valueOf(b0.c(8)), Integer.valueOf(b0.c(8)), Integer.valueOf(b0.c(8)), false, null, 780);
        View r17 = V4();
        LiveCardModel r15 = this.T1;
        if (r15 == null) goto L61;
        LiveCardModel.ElementStyle r18 = r15.getElementStyle();
        if (r18 == null) goto L61;
        CommonModel$LayoutStyle r19 = r18.getLogoLayout();
    L62:
        ToolsKt.A(r17, 0.0f, r19, null, 18, 8, 8, null, null, true, r30, 197);
        Lazy r20 = TransitionAnimationHelper.a;
        TransitionAnimationHelper.e(V4(), b0.c(10) * r47, false);
        SimpleDraweeView r110 = T4();
        LiveCardModel r21 = this.T1;
        if (r21 == null) goto L67;
        LiveCardModel.ElementStyle r22 = r21.getElementStyle();
        if (r22 == null) goto L67;
        CommonModel$LayoutStyle r111 = r22.getLogoLayout();
    L68:
        ToolsKt.A(r110, 0.0f, r111, 18, 18, null, null, null, null, true, r30, 241);
        TextView r112 = S4();
        LiveCardModel r23 = this.T1;
        if (r23 == null) goto L73;
        LiveCardModel.ElementStyle r24 = r23.getElementStyle();
        if (r24 == null) goto L73;
        CommonModel$LayoutStyle r113 = r24.getLogoTextLayout();
    L74:
        ToolsKt.A(r112, 0.0f, r113, null, null, 4, null, 8, null, true, r30, 173);
        TextView r25 = S4();
        LiveCardModel r26 = this.T1;
        if (r26 == null) goto L83;
        LiveCardModel.ElementStyle r27 = r26.getElementStyle();
        if (r27 == null) goto L83;
        CommonModel$CusTextStyle r28 = r27.getLogoTextStyle();
        if (r28 == null) goto L83;
        Integer r29 = r28.getFontSize();
        if (r29 == null) goto L83;
        int r31 = r29.intValue();
    L84:
        r25.setTextSize(1, r31 * this.s);
        if (J4().getVisibility() != 0) goto L154;
        LiveCardModel r32 = this.T1;
        if (r32 == null) goto L95;
        LiveCardModel.ElementStyle r33 = r32.getElementStyle();
        if (r33 == null) goto L95;
        CommonModel$LayoutStyle r34 = r33.getArriveTimeTextLayout();
        if (r34 == null) goto L95;
        Integer r35 = r34.getHeight();
        if (r35 == null) goto L95;
        int r36 = r35.intValue();
    L96:
        AppCompatTextView r37 = J4();
        if (r36 <= 0) goto L99;
        float r38 = r47;
    L100:
        ToolsKt.A(r37, r38, null, null, Integer.valueOf(r36), null, null, null, null, false, null, 1014);
        ProductTextView r39 = J4();
        LiveCardModel r40 = this.T1;
        if (r40 == null) goto L109;
        LiveCardModel.ElementStyle r41 = r40.getElementStyle();
        if (r41 == null) goto L109;
        CommonModel$CusTextStyle r42 = r41.getArriveTimeTextStyle();
        if (r42 == null) goto L109;
        Integer r43 = r42.getFontSize();
        if (r43 == null) goto L109;
        int r44 = r43.intValue();
    L110:
        r39.setTextSize(1, r44 * this.s);
        if (L4().getVisibility() != 0) goto L133;
        int r45 = b0.c(6);
        if (K4().getVisibility() != 0) goto L115;
        int r114 = b0.c(11);
        int r210 = 4;
        ToolsKt.A(K4(), r47, null, null, null, Integer.valueOf(b0.c(8)), null, null, null, false, null, 1006);
        r45 = r114;
    L116:
        SimpleDraweeView r46 = L4();
        LiveCardModel r48 = this.T1;
        if (r48 == null) goto L121;
        LiveCardModel.ElementStyle r49 = r48.getElementStyle();
        if (r49 == null) goto L121;
        CommonModel$LayoutStyle r50 = r49.getArriveTimeIconLayout();
    L122:
        ToolsKt.A(r46, r47, r50, Integer.valueOf(b0.c(12)), Integer.valueOf(b0.c(12)), Integer.valueOf(r45), null, null, Integer.valueOf(b0.c(8)), false, null, 864);
        AppCompatTextView r51 = J4();
        LiveCardModel r52 = this.T1;
        if (r52 == null) goto L131;
        LiveCardModel.ElementStyle r53 = r52.getElementStyle();
        if (r53 == null) goto L131;
        CommonModel$LayoutStyle r54 = r53.getArriveTimeIconLayout();
        if (r54 == null) goto L131;
        Integer r55 = r54.getRight();
        if (r55 == null) goto L131;
        int r56 = r55.intValue();
    L132:
        ToolsKt.A(r51, r47, null, null, null, Integer.valueOf(r56), null, null, null, false, null, 1006);
    L155:
        LiveCardModel r57 = this.T1;
        if (r57 == null) goto L160;
        LiveCardModel.Live r58 = r57.getLive();
        if (r58 == null) goto L160;
        String r115 = r58.getAnimateImageUrl();
    L161:
        if (r115 != null) goto L163;
    L166:
        boolean r59 = true;
    L167:
        if (r59 == false) goto L169;
        Y4().setVisibility(8);
        b0.e((ProductTextView) this.P0.getValue());
    L243:
        n5();
        N4().setViewScaleSize(r47);
        FeedbackView r60 = t4().b;
        if (r60 == null) goto L246;
        r60.setViewScale(r47);
    L246:
        ECHybridExtensionsKt.c().post(new e(this, r47));
        return;
    L169:
        if (((Boolean) this.N2.getValue()).booleanValue() == false) goto L192;
        LiveCardModel r61 = this.T1;
        if (r61 == null) goto L175;
        LiveCardModel.ElementStyle r62 = r61.getElementStyle();
        if (r62 == null) goto L175;
        CommonModel$LayoutStyle r310 = r62.getRedPacketLayout();
    L176:
        ViewGroup.LayoutParams r63 = Y4().getLayoutParams();
        if ((r63 instanceof ConstraintLayout.LayoutParams) == true) goto L179;
        r63 = null;
    L179:
        ConstraintLayout.LayoutParams r64 = (ConstraintLayout.LayoutParams) r63;
        if (r64 == null) goto L199;
        if (r310 == null) goto L184;
        Integer r65 = r310.getLeft();
    L186:
        if (r65 != null) goto L188;
    L190:
        r64.leftToLeft = -1;
        r64.topToTop = -1;
        r64.rightToRight = R4().getId();
        r64.bottomToBottom = R4().getId();
        ((ViewGroup.MarginLayoutParams) r64).topMargin = 0;
        ((ViewGroup.MarginLayoutParams) r64).leftMargin = 0;
        ToolsKt.A(Y4(), this.s, r310, Integer.valueOf(b0.c(30)), null, null, null, Integer.valueOf(b0.c(Integer.valueOf(r210))), Integer.valueOf(b0.c(10)), false, null, 824);
        goto L199
    L188:
        if (r310.getTop() == null) goto L190;
        r64.leftToLeft = R4().getId();
        r64.topToTop = R4().getId();
        r64.rightToRight = -1;
        r64.bottomToBottom = -1;
        ((ViewGroup.MarginLayoutParams) r64).rightMargin = 0;
        ((ViewGroup.MarginLayoutParams) r64).bottomMargin = 0;
        ToolsKt.A(Y4(), this.s, r310, Integer.valueOf(b0.c(30)), null, Integer.valueOf(b0.c(Integer.valueOf(r210))), Integer.valueOf(b0.c(10)), null, null, false, null, 968);
        goto L199
    L184:
        r65 = null;
    L199:
        Y4().setVisibility(0);
        SimpleDraweeView r66 = Y4();
        SimpleDraweeView r67 = Y4();
        Intrinsics.checkNotNullParameter(r67, FreqActions.ACTION_VIEW);
        com.bytedance.android.shopping.api.mall.common.homepage.card.common.e r68 = new com.bytedance.android.shopping.api.mall.common.homepage.card.common.e(r67);
        com.bytedance.android.shopping.mall.homepage.card.live.e r69 = this.S2;
        if (d0.a(r66, r68, r115, r69.a, r69.e) == true) goto L202;
        Y4().setController(ToolsKt.e(Y4(), r115).setAutoPlayAnimations(true).build());
    L202:
        LiveCardModel r70 = this.T1;
        if (r70 == null) goto L207;
        LiveCardModel.Live r71 = r70.getLive();
        if (r71 == null) goto L207;
        int r72 = r71.getAnimateImageWidth();
    L208:
        LiveCardModel r73 = this.T1;
        if (r73 == null) goto L213;
        LiveCardModel.Live r74 = r73.getLive();
        if (r74 == null) goto L213;
        int r75 = r74.getAnimateImageHeight();
    L214:
        if (r72 <= 0) goto L226;
        if (r75 <= 0) goto L226;
        if (((Boolean) this.N2.getValue()).booleanValue() == false) goto L219;
        ToolsKt.A(Y4(), r47, null, Integer.valueOf(b0.c(Integer.valueOf(r72))), Integer.valueOf(b0.c(Integer.valueOf(r75))), null, null, null, null, false, null, 1010);
        goto L226
    L219:
        ViewGroup.LayoutParams r76 = Y4().getLayoutParams();
        if ((r76 instanceof ViewGroup.MarginLayoutParams) == true) goto L222;
        r76 = null;
    L222:
        ViewGroup.MarginLayoutParams r77 = (ViewGroup.MarginLayoutParams) r76;
        if (r77 == null) goto L226;
        r77.width = b0.c(Integer.valueOf(r72));
        r77.height = b0.c(Integer.valueOf(r75));
    L226:
        if (((Boolean) this.N2.getValue()).booleanValue() == false) goto L243;
        int r78 = com.bytedance.forest.utils.h.a;
        LiveCardModel r79 = this.T1;
        if (r79 == null) goto L232;
        LiveCardModel.Live r80 = r79.getLive();
        if (r80 == null) goto L232;
        String r81 = r80.getContent();
    L234:
        if (com.bytedance.forest.utils.h.a(r81) == false) goto L241;
        ProductTextView r82 = (ProductTextView) this.P0.getValue();
        LiveCardModel r84 = this.T1;
        if (r84 == null) goto L240;
        LiveCardModel.Live r85 = r84.getLive();
        if (r85 == null) goto L240;
        r16 = r85.getContent();
    L240:
        r82.y(new TextBaseUIParams(r16, new ProductStyle(null, null, "#FFFFFFFF", Float.valueOf(8.0f), 500, null, "DouyinNumberABC-Medium", null, null, Float.valueOf(1.0f), Float.valueOf(1.0f), null, null, null, null, null, 1, new Shape(CollectionsKt.listOf(new Float[]{Float.valueOf(6.0f), Float.valueOf(6.0f), Float.valueOf(6.0f), Float.valueOf(6.0f)}), null, null, "#B2000000", 6, null), null, null, null, 1898915, null)));
        b0.n((ProductTextView) this.P0.getValue());
        goto L243
    L241:
        b0.e((ProductTextView) this.P0.getValue());
    L232:
        r81 = null;
    L213:
        r75 = 0;
    L207:
        r72 = 0;
    L175:
        r310 = null;
        goto L176
    L192:
        SimpleDraweeView r86 = Y4();
        LiveCardModel r87 = this.T1;
        if (r87 == null) goto L197;
        LiveCardModel.ElementStyle r88 = r87.getElementStyle();
        if (r88 == null) goto L197;
        CommonModel$LayoutStyle r89 = r88.getRedPacketLayout();
    L198:
        ToolsKt.A(r86, r47, r89, Integer.valueOf(b0.c(30)), null, null, null, Integer.valueOf(b0.c(Integer.valueOf(r210))), Integer.valueOf(b0.c(10)), false, null, 824);
    L197:
        r89 = null;
        goto L198
    L163:
        if (r115.length() == 0) goto L166;
        r59 = false;
    L160:
        r115 = null;
    L131:
        r56 = b0.c(2);
    L121:
        r50 = null;
        goto L122
    L115:
        r210 = 4;
        goto L116
    L133:
        r210 = 4;
        AppCompatTextView r90 = J4();
        LiveCardModel r91 = this.T1;
        if (r91 == null) goto L142;
        LiveCardModel.ElementStyle r92 = r91.getElementStyle();
        if (r92 == null) goto L142;
        CommonModel$LayoutStyle r94 = r92.getArriveTimeIconLayout();
        if (r94 == null) goto L142;
        Integer r95 = r94.getLeft();
        if (r95 == null) goto L142;
        int r96 = r95.intValue();
    L143:
        Integer r97 = Integer.valueOf(r96 + b0.c(2));
        LiveCardModel r98 = this.T1;
        if (r98 == null) goto L152;
        LiveCardModel.ElementStyle r99 = r98.getElementStyle();
        if (r99 == null) goto L152;
        CommonModel$LayoutStyle r100 = r99.getArriveTimeIconLayout();
        if (r100 == null) goto L152;
        Integer r101 = r100.getBottom();
        if (r101 == null) goto L152;
        int r102 = r101.intValue();
    L153:
        ToolsKt.A(r90, r47, null, null, null, r97, null, null, Integer.valueOf(r102), false, null, 878);
    L152:
        r102 = b0.c(8);
    L142:
        r96 = b0.c(6);
    L109:
        r44 = 11;
        goto L110
    L99:
        r38 = 1.0f;
    L95:
        r36 = -2;
        goto L96
    L154:
        r210 = 4;
    L83:
        r31 = 11;
    L73:
        r113 = null;
    L67:
        r111 = null;
    L61:
        r19 = null;
    L55:
        r14 = null;
        goto L56
    L22:
        if (r4.a() != true) goto L35;
        if (r5 == null) goto L35;
        if (r5.intValue() <= 0) goto L35;
        com.bytedance.android.ec.hybrid.list.ability.a r103 = ((BaseViewHolder) this).b;
        if (r103 == null) goto L50;
        v r104 = (v) r103.getAbility(v.class);
        if (r104 == null) goto L50;
        Integer r105 = r104.Gg(r5.intValue());
        if (r105 == null) goto L50;
        int r106 = r105.intValue();
        if (r106 <= 0) goto L50;
        k5(b0.c(Float.valueOf(r106 * 1.5f)));
        goto L50
    L19:
        r5 = null;
        goto L20
    L9:
        r3 = false;
    L15:
        r12 = null;
        goto L16
    }

    public static final String E4(NativeLiveCard r16, boolean r17) {
        LiveCardData r1 = r16.u;
        String r2 = "";
        if (r1 == null) goto L6;
        String r3 = r1.getSchema();
        if (r3 == null) goto L6;
    L7:
        LinkedHashMap r4 = new LinkedHashMap();
        if (r17 == false) goto L10;
        r4.put("pop_type", "ecom_list_panel");
    L10:
        r4.put("click_order", Integer.valueOf(ToolsKt.g(r16)));
        r4.put("request_id", ToolsKt.l(r16));
        r4.put("enter_from_merge", r16.y4());
        LiveCardData r5 = r16.u;
        if (r5 == null) goto L13;
        Boolean r6 = r5.isAd();
    L14:
        Boolean r7 = Boolean.TRUE;
        if (Intrinsics.areEqual(r6, r7) == false) goto L17;
        long r10 = com.bytedance.android.shopping.mall.homepage.card.live.a.b(r16);
        String r8 = com.bytedance.android.shopping.mall.homepage.card.live.a.c(r16);
        r4.put("is_other_channel", "effective_ad");
        r4.put("creative_id", Long.valueOf(r10));
        r4.put("log_extra", r8);
        r4.put("is_effect_ad", r7);
        JsonObject r14 = new JsonObject();
        r14.addProperty("creativeID", Long.valueOf(r10));
        r14.addProperty("logExtra", r8);
        Unit r9 = Unit.INSTANCE;
        r4.put("effect_ad_extra", r14.toString());
        JsonObject r11 = new JsonObject();
        r11.addProperty("is_other_channel", "effective_ad");
        r11.addProperty("creative_id", Long.valueOf(r10));
        r11.addProperty("log_extra", r8);
        r4.put("extra_params", r11.toString());
    L17:
        JsonObject r12 = new JsonObject();
        r12.addProperty("should_show_panel", 0);
        boolean r13 = true;
        if (r17 == false) goto L20;
        r12.addProperty("pop_goods_detail", 1);
    L21:
        LiveCardData r15 = r16.u;
        if (r15 == null) goto L27;
        CommonData.Product r18 = r15.getProduct();
        if (r18 == null) goto L27;
        String r19 = r18.getProductId();
        if (r19 == null) goto L27;
    L28:
        r12.addProperty(PdpOpenThirdParam.KEY_PRODUCT_ID, r19);
        JsonObject r110 = new JsonObject();
        Intrinsics.checkNotNullParameter(r16, "$this$getPreviousPage");
        r110.addProperty("previous_page", ToolsKt.f(r16));
        r110.addProperty("outflow_order", Integer.valueOf(ToolsKt.g(r16)));
        r110.addProperty("click_order", Integer.valueOf(ToolsKt.g(r16)));
        LiveCardData r20 = r16.u;
        if (r20 == null) goto L34;
        CommonData.CardCommon r21 = r20.getCardCommon();
        if (r21 == null) goto L34;
        String r22 = r21.getResourceId();
        if (r22 == null) goto L34;
    L35:
        r110.addProperty("resource_id", r22);
        r110.addProperty("entrance_type", "live");
        LiveCardData r23 = r16.u;
        if (r23 == null) goto L39;
        String r24 = r23.rcPriorityFromProduct();
        if (r24 == null) goto L39;
    L40:
        r110.addProperty("recommend_info", r24);
        r110.addProperty("tab_id", ToolsKt.r(r16));
        r110.addProperty("tab_name", ToolsKt.s(r16));
        LiveCardData r25 = r16.u;
        if (r25 == null) goto L45;
        LiveCardData.Live r26 = r25.getLive();
        if (r26 == null) goto L45;
        List<String> r27 = r26.getRelationTags();
    L46:
        List<String> r28 = r27;
        if (r28 != null) goto L49;
    L52:
        if (r13 == true) goto L63;
        LiveCardData r29 = r16.u;
        if (r29 == null) goto L61;
        LiveCardData.Live r30 = r29.getLive();
        if (r30 == null) goto L61;
        List<String> r31 = r30.getRelationTags();
        if (r31 == null) goto L61;
        String r32 = (String) CollectionsKt.getOrNull(r31, 0);
        if (r32 == null) goto L61;
    L62:
        r110.addProperty("relation_tags", r32);
    L61:
        r32 = "";
    L63:
        LiveCardData r33 = r16.u;
        if (r33 == null) goto L66;
        Boolean r34 = r33.isAd();
    L68:
        if (Intrinsics.areEqual(r34, r7) == false) goto L70;
        r110.addProperty("is_other_channel", "effective_ad");
    L70:
        r110.addProperty("carrier_source", r16.y4());
        LiveCardData r35 = r16.u;
        if (r35 == null) goto L78;
        CommonData.MarketingData r36 = r35.getMarketIngData();
        if (r36 == null) goto L78;
        String r37 = r36.getTransMeta();
        if (r37 == null) goto L78;
        r2 = r37;
    L78:
        r110.addProperty("trans_meta", r2);
        Unit r38 = Unit.INSTANCE;
        r12.add("pass_through_log_data", r110);
        JsonObject r39 = new JsonObject();
        r39.addProperty("ecom_scene_id", ToolsKt.m(r16));
        r12.add("multi_room_data", r39);
        r12.addProperty("carrier_source", r16.y4());
        r4.put("ecom_live_params", URLEncoder.encode(r12.toString()));
        return ToolsKt.u(r3, r4);
    L66:
        r34 = null;
        goto L68
    L49:
        if (r28.isEmpty() == true) goto L52;
        r13 = false;
    L45:
        r27 = null;
    L39:
        r24 = "";
    L34:
        r22 = "";
    L27:
        r19 = "";
        goto L28
    L20:
        r12.addProperty("pop_goods_detail", 0);
        goto L21
    L13:
        r6 = null;
    L6:
        r3 = "";
        goto L7
    }

    @Override // com.bytedance.android.shopping.mall.homepage.card.live.BaseLiveViewHolder
    public final void b4(Object r33, String r34, com.bytedance.android.ec.hybrid.list.entity.k.a r35) {
        Intrinsics.checkNotNullParameter(r34, "itemId");
        super.b4(r33, r34, r35);
        Object r0 = r33;
        if ((r0 instanceof LiveCardData) == true) goto L5;
        r0 = null;
    L5:
        LiveCardData r1 = (LiveCardData) r0;
        if (r1 != null) goto L8;
        return;
    L8:
        this.u = r1;
        ECHybridListItemVO r2 = ((BaseViewHolder) this).c;
        if (r2 == null) goto L18;
        String r3 = r2.b();
        if (r3 == null) goto L18;
        LiveCardData r4 = this.u;
        if (r4 == null) goto L18;
        CommonData.Extra r5 = r4.getExtra();
        if (r5 == null) goto L18;
        r5.setRecommendInfo(r3);
    L18:
        if (h5() == true) goto L20;
    L47:
        LiveCardData r6 = this.u;
        if (r6 == null) goto L468;
        String r7 = ToolsKt.r(this);
        String r8 = this.K;
        if (r8 != null) goto L52;
        r8 = "";
    L52:
        LiveCardModel r9 = com.bytedance.android.shopping.mall.homepage.card.live.d.a(r6, r7, r8);
        this.T1 = r9;
        this.I2 = 1.0f;
        LiveCardData r10 = this.u;
        if (r10 == null) goto L57;
        LiveCardData.Live r11 = r10.getLive();
        if (r11 == null) goto L57;
        String r12 = r11.getRoomId();
    L58:
        this.v = r12;
        LiveCardData.FavoriteItemStyle r13 = r9.getItemStyle();
        if (r13 == null) goto L79;
        String r14 = r13.getItemThemeColor();
        if (r14 == null) goto L79;
        Z4().setThemeColor(r14);
        LiveCardModel r15 = this.T1;
        if (r15 == null) goto L69;
        LiveCardModel.ElementStyle r16 = r15.getElementStyle();
        if (r16 == null) goto L69;
        CommonModel$CusTextStyle r17 = r16.getCoinStyle();
        if (r17 == null) goto L69;
        String r18 = r17.getBackgroundColor();
    L70:
        if (r18 != null) goto L72;
    L75:
        boolean r19 = true;
    L76:
        if (r19 == false) goto L78;
        N4().setContainerColor(r14);
    L78:
        Unit r20 = Unit.INSTANCE;
        goto L79
    L72:
        if (r18.length() == 0) goto L75;
        r19 = false;
    L69:
        r18 = null;
    L79:
        Double r21 = r9.getElementStyle().getPlayerLayout().getRadius();
        if (r21 == null) goto L82;
        float r22 = b0.c(Double.valueOf(r21.doubleValue()));
        W4().a(0.0f, 0.0f, r22, r22);
        ToolsKt.a(R4(), r22);
        ((ECRoundedCornerImageView) this.S.getValue()).a(r22, r22);
    L82:
        ToolsKt.F((ECGradientView) this.Q.getValue(), r9.getElementStyle().getPlayerMaskStyle());
        com.bytedance.android.shopping.mall.homepage.card.live.e r23 = this.S2;
        String r24 = r23.a;
        String r110 = r23.b;
        String r111 = r23.c;
        String r25 = r23.d;
        Pair r112 = W3();
        String r113 = (String) r112.getFirst();
        if (r113 == null) goto L85;
        Unit r26 = Unit.INSTANCE;
        r24 = r113;
    L85:
        String r114 = (String) r112.getSecond();
        if (r114 == null) goto L88;
        r110 = r114.concat("_cover");
        r111 = r114.concat("_avatar");
        r25 = r114.concat("_product");
        Unit r115 = Unit.INSTANCE;
    L88:
        Z4().S5(r24, r25);
        LiveCardModel r27 = this.T1;
        if (r27 == null) goto L93;
        LiveCardModel.Live r28 = r27.getLive();
        if (r28 == null) goto L93;
        String r29 = r28.getCover();
    L94:
        if (r29 != null) goto L96;
        r29 = "";
    L96:
        GenericDraweeHierarchy r116 = R4().getHierarchy();
        if (r116 == null) goto L99;
        r116.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
    L99:
        R4().setPadding(0, 0, 0, 0);
        b0.e((ImageView) this.H0.getValue());
        b0.e((ImageView) this.L0.getValue());
        if (H4() == false) goto L114;
        LiveCardData r30 = this.u;
        if (r30 == null) goto L110;
        CommonData.Product r31 = r30.getProduct();
        if (r31 == null) goto L110;
        CommonData.UrlStruct r32 = r31.getCover();
        if (r32 == null) goto L110;
        List<String> r36 = r32.getUrlList();
        if (r36 == null) goto L110;
        r29 = (String) CollectionsKt.getOrNull(r36, 0);
    L111:
        if (r29 != null) goto L114;
        r29 = "";
    L110:
        r29 = null;
    L114:
        if (d0.b(R4(), r29, r24, r110) == true) goto L116;
        R4().setImageURI(r29);
    L116:
        Boolean r37 = r9.getShowJustNowUI();
        Boolean r117 = Boolean.TRUE;
        boolean r38 = Intrinsics.areEqual(r37, r117);
        this.P1 = r38;
        if (r38 == false) goto L152;
        ECHybridListItemVO r39 = ((BaseViewHolder) this).c;
        if (r39 == null) goto L152;
        if (r39.w == true) goto L152;
        kjc.c r40 = new kjc.c();
        if (2 != kjc.a.a()) goto L126;
        kjc.b r118 = r40.a;
        b0.n((View) this.H1.getValue());
        b0.j(X4(), M4());
        r118.a = Unit.INSTANCE;
        r40.b = true;
    L126:
        if (r40.b == true) goto L128;
        kjc.b r119 = r40.a;
        b0.e((View) this.H1.getValue());
        b0.n((View) this.L1.getValue());
        r119.a = Unit.INSTANCE;
    L128:
        Object r41 = r40.a.a;
        b0.n(X4());
        LiveCardData r42 = this.u;
        if (r42 == null) goto L131;
        Boolean r43 = r42.getCardMute();
    L133:
        if (Intrinsics.areEqual(r43, r117) == false) goto L135;
        b0.e(U4());
    L151:
        b0.e(V4());
    L175:
        String r44 = r9.getElementStyle().getLogoTextStyle().getColor();
        if (r44 == null) goto L179;
        S4().setTextColor(ColorProtector.parseColor(r44));
        Unit r45 = Unit.INSTANCE;
    L179:
        if (r9.getExperiment().getNoProductInfo() == false) goto L181;
        ((SimpleDraweeView) this.X.getValue()).setVisibility(8);
        ((TextView) this.Y.getValue()).setVisibility(8);
        Z4().setVisibility(8);
        N4().setVisibility(0);
        BottomInfoView r120 = N4();
        CommonModel$Product r121 = r9.getProduct();
        CommonModel$User r122 = r9.getUser();
        LiveCardModel.Live r123 = r9.getLive();
        boolean r124 = r9.getShowAdTag();
        BottomInfoView.Companion.Experiment r46 = new BottomInfoView.Companion.Experiment(r9.getExperiment().getLiveCardEnlargePlayArea(), r9.getElementStyle().getDarkModeEnable(), r9.getExperiment().getCoinLabelStyle(), r9.getExperiment().getShowPeopleNewIcon());
        BottomInfoView.Companion.ElementStyle r47 = new BottomInfoView.Companion.ElementStyle(new CommonModel$ModuleDesc(r9.getElementStyle().getAvatarLayout(), r9.getElementStyle().getUserTextStyle()), new CommonModel$ModuleDesc(r9.getElementStyle().getHotLayout(), r9.getElementStyle().getHotTextStyle()), new CommonModel$CommonColorStyle(null, r9.getElementStyle().getHotIconStyle().getColorDark(), r9.getElementStyle().getHotIconStyle().getColorLight(), null, null, 25, null), new CommonModel$ModuleDesc(r9.getElementStyle().getCoinLayout(), r9.getElementStyle().getCoinStyle()), r9.getElementStyle().getCoinIconLayout());
        int r48 = BottomInfoView.p;
        r120.U5(r121, r122, r123, r124, r46, r47, null);
    L185:
        int r49 = com.bytedance.forest.utils.h.a;
        if (com.bytedance.forest.utils.h.a(r9.getLive().getRecommend()) == false) goto L188;
        S4().setText(r9.getLive().getRecommend());
        b0.n(S4());
    L189:
        ToolsKt.y(P4(), r9.getLive().getAccessibilityLabel());
        com.bytedance.android.shopping.mall.homepage.card.common.feedback.b r50 = t4();
        LiveCardData r51 = this.u;
        if (r51 == null) goto L195;
        LiveCardData.Live r52 = r51.getLive();
        if (r52 == null) goto L195;
        String r53 = r52.getRoomId();
        if (r53 == null) goto L195;
    L196:
        r50.getClass();
        Intrinsics.checkNotNullParameter(r53, "<set-?>");
        r50.a = r53;
        Lazy r54 = HybridAppInfoService.a;
        if (HybridAppInfoService.m() == true) goto L208;
        String r55 = r9.getLive().getPlayIconUrl();
        if (r55.length() <= 0) goto L201;
        boolean r56 = true;
    L202:
        if (r56 == true) goto L205;
        r55 = null;
    L205:
        if (r55 == null) goto L207;
        T4().setImageURI(r55);
        Unit r57 = Unit.INSTANCE;
        goto L208
    L207:
        T4().setImageResource(2131248025);
        Unit r58 = Unit.INSTANCE;
        goto L208
    L201:
        r56 = false;
    L208:
        CommonData.WindVaneEventData r59 = r9.getWindVane();
        if (r59 == null) goto L242;
        String r60 = r59.getWindVaneLynxData();
        if (r60 == null) goto L242;
        if (com.bytedance.forest.utils.h.a(r60) != true) goto L242;
        String r61 = r9.getWindVane().getWindVaneSchema();
        if (r61 == null) goto L242;
        if (com.bytedance.forest.utils.h.a(r61) != true) goto L242;
        Logger.d("puffone-NativeLiveCard.bindData()", "有风向标数据:" + this.T2 + ',' + r9.getWindVane().getWindVaneSchema() + ',' + r9.getWindVane().getWindVaneLynxData() + ',' + r9.getWindVane().getAppendHeight());
        b5().setVisibility(0);
        Pair[] r62 = new Pair[1];
        LiveCardData r63 = this.u;
        if (r63 == null) goto L224;
        LiveCardData.FavoriteLiveCardABValues r64 = r63.getFavoriteLiveCardABValues();
        if (r64 == null) goto L224;
        Map<String, Object> r65 = r64.toMap();
        if (r65 == null) goto L224;
    L225:
        r62[0] = TuplesKt.to("ab_values", r65);
        Map r125 = MapsKt.mutableMapOf(r62);
        if (this.M != null) goto L236;
        int r66 = UIUtils.px2dip(((RecyclerView.ViewHolder) this).itemView.getContext(), ((RecyclerView.ViewHolder) this).itemView.getHeight());
        Integer r67 = r9.getWindVane().getAppendMargin();
        if (r67 == null) goto L230;
        int r68 = r67.intValue();
    L231:
        int r69 = r66 + r68;
        this.P2 = r69;
        r125.putAll(ToolsKt.c(this, r69));
        com.bytedance.android.ec.hybrid.card.api.f r126 = this.T2;
        if (r126 == null) goto L234;
        FrameLayout r127 = b5();
        String r128 = r9.getWindVane().getWindVaneSchema();
        Intrinsics.checkNotNull(r128);
        ECLynxCard r70 = r126.IW(r127, r128, r9.getWindVane().getWindVaneLynxData(), r125, new ViewGroup.LayoutParams(-1, -2), new g(this, r9), null);
    L235:
        this.M = r70;
    L243:
        CommonData.CoinData r71 = r9.getCoinData();
        if (r71 == null) goto L246;
        Integer r72 = r71.getCoinLynxHeight();
    L248:
        if (r72 == null) goto L276;
        String r73 = r9.getCoinData().getCoinLynxSchema();
        if (r73 == null) goto L276;
        if (com.bytedance.forest.utils.h.a(r73) != true) goto L276;
        if (r9.getProduct().getMarketingData() == null) goto L276;
        Logger.d("puffone-NativeLiveCard.bindData()", "有金币数据:" + this.T2 + ',' + r9.getCoinData().getCoinLynxSchema() + ',' + r9.getCoinData().getCoinLynxHeight());
        O4().setVisibility(0);
        com.bytedance.android.ec.hybrid.card.api.e r74 = this.N;
        if (r74 != null) goto L272;
        com.bytedance.android.ec.hybrid.card.api.f r129 = this.T2;
        if (r129 == null) goto L265;
        FrameLayout r130 = O4();
        String r131 = r9.getCoinData().getCoinLynxSchema();
        Intrinsics.checkNotNull(r131);
        JSONObject r75 = new JSONObject();
        r75.put("marketing_data", GsonProtectorUtils.toJson(new Gson(), r9.getProduct().getMarketingData()));
        LiveCardModel.TTExperiment r76 = r9.getTtExperiment();
        if (r76 == null) goto L263;
        String r77 = r76.getTaskExpGroup();
        if (r77 == null) goto L263;
    L264:
        r75.put("task_tab_show_exp_group", r77);
        Unit r78 = Unit.INSTANCE;
        String r132 = r75.toString();
        Integer r79 = r9.getCoinData().getCoinLynxHeight();
        Intrinsics.checkNotNull(r79);
        ECLynxCard r80 = r129.IW(r130, r131, r132, null, new ViewGroup.LayoutParams(-1, r79.intValue()), new h(), null);
    L266:
        this.N = r80;
        if (r80 == null) goto L271;
        View r81 = r80.b();
        if (r81 == null) goto L271;
        r81.setOnClickListener(new i(this));
        Unit r82 = Unit.INSTANCE;
    L271:
        ConstraintSet r84 = new ConstraintSet();
        r84.clone(P4());
        r84.connect(2131364473, 4, 2131367090, 3);
        r84.applyTo(P4());
    L279:
        LiveCardData r85 = this.u;
        if (r85 == null) goto L282;
        Boolean r86 = r85.isAd();
    L284:
        if (Intrinsics.areEqual(r86, r117) == false) goto L296;
        LiveCardData r87 = this.u;
        if (r87 == null) goto L290;
        LiveCardData.FavoriteLiveCardABValues r88 = r87.getFavoriteLiveCardABValues();
        if (r88 == null) goto L290;
        Boolean r89 = r88.getLiveCardEnlargePlayArea();
    L292:
        if (Intrinsics.areEqual(r89, r117) == false) goto L294;
        ((ImageView) this.v1.getValue()).setBackgroundColor(ColorProtector.parseColor("#99FFFFFF"));
    L295:
        ((ImageView) this.v1.getValue()).setVisibility(0);
    L297:
        d5();
        if (((Boolean) this.H2.getValue()).booleanValue() == false) goto L300;
        ((View) this.b1.getValue()).setVisibility(8);
    L313:
        LiveCardData r90 = this.u;
        if (r90 == null) goto L318;
        CommonData.ElementStyle r91 = r90.getElementStyle();
        if (r91 == null) goto L318;
        CommonData.PriceContent r92 = r91.getPrice();
    L319:
        if (r92 == null) goto L367;
        ProductPriceView r94 = (ProductPriceView) this.M1.getValue();
        LiveCardData r95 = this.u;
        if (r95 == null) goto L325;
        CommonData.ElementStyle r96 = r95.getElementStyle();
        if (r96 == null) goto L325;
        CommonData.PriceContent r133 = r96.getPrice();
    L326:
        CommonData.PriceCommon r97 = new CommonData.PriceCommon(r133, null, null, null, null, null, 62, null);
        r94.getClass();
        Intrinsics.checkNotNullParameter(r97, "data");
        ProductTextView r98 = r94.b;
        CommonData.PriceContent r99 = r97.getPrice();
        if (r99 == null) goto L329;
        TextBaseUIParams r100 = r99.getSymbol();
    L330:
        r98.getClass();
        if (r100 == null) goto L335;
        ProductStyle r101 = r100.getStyle();
        if (r101 == null) goto L335;
        r98.z(r101);
        r98.x(r101);
    L335:
        ProductTextView r102 = r94.c;
        CommonData.PriceContent r103 = r97.getPrice();
        if (r103 == null) goto L338;
        TextBaseUIParams r104 = r103.getIntegers();
    L339:
        r102.y(r104);
        ProductTextView r105 = r94.d;
        CommonData.PriceContent r106 = r97.getPrice();
        if (r106 == null) goto L342;
        TextBaseUIParams r107 = r106.getDecimal();
    L343:
        r105.y(r107);
        ProductTextView r108 = r94.e;
        CommonData.PriceContent r109 = r97.getPrice();
        if (r109 == null) goto L346;
        TextBaseUIParams r134 = r109.getUnit();
    L347:
        r108.y(r134);
        r94.f.y(r97.getPriceAbove());
        r94.g.y(r97.getPriceLabel());
        r94.h.y(r97.getSalesCount());
        TextBaseUIParams r135 = r97.getSalesCount();
        if (r135 == null) goto L354;
        ProductStyle r136 = r135.getStyle();
        if (r136 == null) goto L354;
        Float r137 = r136.getFontSize();
        if (r137 == null) goto L354;
        float r138 = r137.floatValue();
    L355:
        r94.a = (int) r138;
        LiveCardData r139 = this.u;
        if (r139 == null) goto L366;
        CommonData.ElementStyle r140 = r139.getElementStyle();
        if (r140 == null) goto L366;
        CommonData.PriceContent r141 = r140.getPrice();
        if (r141 == null) goto L366;
        ProductStyle r142 = r141.getStyle();
        if (r142 == null) goto L366;
        Float r143 = r142.getMarginRight();
        if (r143 == null) goto L366;
        ToolsKt.A((ProductPriceView) this.M1.getValue(), 0.0f, null, null, null, null, null, Integer.valueOf(b0.c(Float.valueOf(r143.floatValue()))), null, false, null, 959);
        Unit r144 = Unit.INSTANCE;
    L366:
        b0.n((ProductPriceView) this.M1.getValue());
    L368:
        LiveCardModel r145 = this.T1;
        if (r145 == null) goto L390;
        LiveCardModel.Live r146 = r145.getLive();
        if (r146 == null) goto L390;
        if (r146.getShowProductImage() != true) goto L390;
        LiveCardModel r147 = this.T1;
        if (r147 == null) goto L379;
        CommonModel$Product r148 = r147.getProduct();
        if (r148 == null) goto L379;
        String r149 = r148.getCover();
    L380:
        if (r149 != null) goto L382;
    L389:
        a5().setVisibility(8);
    L391:
        ECHybridListItemVO r150 = ((BaseViewHolder) this).c;
        if (r150 != null) goto L394;
    L424:
        ViewGroup.LayoutParams r151 = null;
    L425:
        u4(r9.getElementStyle().getFeedbackLayout());
        o5(this.s);
        i5();
        LiveCardModel r152 = this.T1;
        if (r152 == null) goto L448;
        LiveCardModel.ElementStyle r153 = r152.getElementStyle();
        if (r153 == null) goto L448;
        CommonModel$CommonColorStyle r154 = r153.getRootStyle();
        if (r154 == null) goto L448;
        IHybridHostService r155 = com.bytedance.android.ec.hybrid.a.h();
        if (r155 == null) goto L438;
        yj.i r156 = r155.getIHybridHostAppInfo();
        if (r156 == null) goto L438;
        if (r156.isNightMode() != true) goto L438;
        boolean r157 = true;
    L439:
        LiveCardModel r158 = this.T1;
        Intrinsics.checkNotNull(r158);
        if (r158.getElementStyle().getDarkModeEnable() == false) goto L445;
        if (r157 == false) goto L445;
        String r159 = r154.getColorDark();
        if (r159 == null) goto L448;
        P4().setBackgroundColor(ColorProtector.parseColor(r159));
    L445:
        String r160 = r154.getColor();
        if (r160 == null) goto L448;
        P4().setBackgroundColor(ColorProtector.parseColor(r160));
    L438:
        r157 = false;
    L448:
        LiveCardModel r161 = this.T1;
        if (r161 == null) goto L455;
        LiveCardModel.Experiment r162 = r161.getExperiment();
        if (r162 == null) goto L455;
        Double r163 = r162.getAppendHeight();
        if (r163 == null) goto L455;
        double r164 = r163.doubleValue();
    L457:
        if (r164 <= 0.0d) goto L467;
        com.bytedance.android.shopping.api.mall.idl.c r165 = this.W2;
        if (r165 == null) goto L464;
        Integer r166 = r165.b;
        if (r166 == null) goto L464;
        int r167 = r166.intValue();
    L465:
        if (r167 <= 0) goto L467;
        P4().g = b0.c(Double.valueOf((r164 * ((double) r167)) / ((double) 375)));
    L464:
        r167 = ToolsKt.o(((RecyclerView.ViewHolder) this).itemView.getContext());
    L467:
        p5();
    L469:
        Lazy r168 = BigFontAdapter.a;
        if (BigFontAdapter.c(ToolsKt.k(this)) == false) goto L481;
        BottomInfoView r169 = N4();
        r169.getClass();
        SimpleDraweeView r170 = r169.j;
        Intrinsics.checkNotNullParameter(r170, FreqActions.ACTION_VIEW);
        BigFontAdapter.FontType r171 = BigFontAdapter.a();
        BigFontAdapter.FontType r172 = BigFontAdapter.FontType.MINI;
        if (r171 != r172) goto L474;
    L476:
        TextView r173 = r169.l;
        Intrinsics.checkNotNullParameter(r173, FreqActions.ACTION_VIEW);
        if (BigFontAdapter.a() == r172) goto L481;
        if (BigFontAdapter.a() == BigFontAdapter.FontType.MEDIUM) goto L481;
        b0.e(r173);
        goto L481
    L474:
        if (BigFontAdapter.a() == BigFontAdapter.FontType.MEDIUM) goto L476;
        b0.e(r170);
    L481:
        LiveCardModel r174 = this.T1;
        if (r174 == null) goto L502;
        LiveCardModel.ElementStyle r175 = r174.getElementStyle();
        if (r175 == null) goto L503;
        Float r176 = r175.getFeedCardRatio();
        if (r176 == null) goto L504;
        float r177 = r176.floatValue();
        ViewGroup.LayoutParams r178 = P4().getLayoutParams();
        if ((r178 instanceof ConstraintLayout.LayoutParams) == true) goto L490;
        ViewGroup.LayoutParams r179 = r151;
    L491:
        ConstraintLayout.LayoutParams r180 = (ConstraintLayout.LayoutParams) r179;
        if (r180 == null) goto L505;
        r180.dimensionRatio = String.valueOf(r177);
        ((ViewGroup.MarginLayoutParams) r180).height = 0;
        return;
    L505:
        return;
    L490:
        r179 = r178;
        goto L491
    L504:
        return;
    L503:
        return;
    L502:
        return;
    L455:
        r164 = 0.0d;
        goto L457
    L394:
        if (r150.w == true) goto L424;
        String r181 = r9.getElementStyle().getLeftTopAnimUrl();
        if (r181 != null) goto L398;
    L401:
        boolean r182 = true;
    L402:
        if (r182 == false) goto L405;
        b0.e((SimpleDraweeView) this.k0.getValue());
        goto L424
    L405:
        if (r181.length() != 0) goto L407;
        boolean r183 = true;
    L408:
        if (r183 == false) goto L410;
    L423:
        r151 = null;
        b0.e((SimpleDraweeView) this.k0.getValue());
        goto L425
    L410:
        if (StringsKt.endsWith$default(r181, ".webp", false, 2, null) == false) goto L423;
        SimpleDraweeView r184 = (SimpleDraweeView) this.k0.getValue();
        Lazy r185 = ToolsKt.a;
        Intrinsics.checkNotNullParameter(r184, "$this$loadWebAndHide");
        Intrinsics.checkNotNullParameter(r181, "webpUrl");
        if (r181.length() != 0) goto L415;
        boolean r186 = true;
    L416:
        if (r186 == true) goto L421;
        r151 = null;
        if (StringsKt.endsWith$default(r181, ".webp", false, 2, null) == false) goto L422;
        b0.n(r184);
        r184.setController(Fresco.newDraweeControllerBuilder().setUri(r181).setControllerListener(new com.bytedance.android.shopping.api.mall.common.homepage.card.common.i(r184)).build());
    L422:
        b0.e(r184);
        goto L425
    L421:
        r151 = null;
        goto L422
    L415:
        r186 = false;
        goto L416
    L407:
        r183 = false;
        goto L408
    L398:
        if (r181.length() == 0) goto L401;
        r182 = false;
        goto L402
    L382:
        if (r149.length() <= 0) goto L384;
        boolean r187 = true;
    L385:
        if (r187 == false) goto L389;
        a5().setVisibility(0);
        SimpleDraweeView r188 = a5();
        SimpleDraweeView r189 = a5();
        Intrinsics.checkNotNullParameter(r189, FreqActions.ACTION_VIEW);
        com.bytedance.android.shopping.api.mall.common.homepage.card.common.e r190 = new com.bytedance.android.shopping.api.mall.common.homepage.card.common.e(r189);
        com.bytedance.android.shopping.mall.homepage.card.live.e r191 = this.S2;
        if (d0.a(r188, r190, r149, r191.a, r191.f) == true) goto L391;
        a5().setController(ToolsKt.e(a5(), r149).setAutoPlayAnimations(true).build());
        goto L391
    L384:
        r187 = false;
    L379:
        r149 = null;
    L390:
        a5().setVisibility(8);
    L354:
        r138 = 0.0f;
        goto L355
    L346:
        r134 = null;
        goto L347
    L342:
        r107 = null;
        goto L343
    L338:
        r104 = null;
        goto L339
    L329:
        r100 = null;
    L325:
        r133 = null;
        goto L326
    L367:
        b0.e((ProductPriceView) this.M1.getValue());
    L318:
        r92 = null;
        goto L319
    L300:
        String r192 = r9.getElementStyle().getMaskStyle().getColorFrom();
        String r193 = r9.getElementStyle().getMaskStyle().getColorTo();
        Integer r194 = r9.getElementStyle().getMaskStyle().getHeight();
        if (r194 == null) goto L498;
        ((View) this.b1.getValue()).getLayoutParams().height = r194.intValue();
        Unit r195 = Unit.INSTANCE;
    L498:
        View r196 = (View) this.b1.getValue();     // Catch: Exception -> L311
        GradientDrawable r197 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor(r192), Color.parseColor(r193)});     // Catch: Exception -> L311
        Double r198 = r9.getElementStyle().getPlayerLayout().getRadius();     // Catch: Exception -> L311
        if (r198 == null) goto L309;
        float r199 = b0.c(Double.valueOf(r198.doubleValue()));     // Catch: Exception -> L311
        float[] r200 = new float[8];     // Catch: Exception -> L311
        r200[0] = 0.0f;     // Catch: Exception -> L495
        r200[1] = 0.0f;     // Catch: Exception -> L495
        r200[2] = 0.0f;     // Catch: Exception -> L495
        r200[3] = 0.0f;     // Catch: Exception -> L495
        r200[4] = r199;     // Catch: Exception -> L495
        r200[5] = r199;     // Catch: Exception -> L495
        r200[6] = r199;     // Catch: Exception -> L495
        r200[7] = r199;     // Catch: Exception -> L495
        r197.setCornerRadii(r200);     // Catch: Exception -> L495
        Unit r201 = Unit.INSTANCE;     // Catch: Exception -> L495
    L309:
        Unit r202 = Unit.INSTANCE;     // Catch: Exception -> L495
        b0.j(r196, r197);     // Catch: Exception -> L495
        goto L313
    L294:
        ((ImageView) this.v1.getValue()).setBackgroundColor(ColorProtector.parseColor("#57000000"));
    L290:
        r89 = null;
        goto L292
    L296:
        ((ImageView) this.v1.getValue()).setVisibility(8);
        goto L297
    L282:
        r86 = null;
    L263:
        r77 = r4;
        goto L264
    L265:
        r80 = null;
        goto L266
    L272:
        int r203 = com.bytedance.android.ec.hybrid.card.api.d.e;
        String r204 = r9.getCoinData().getCoinLynxSchema();
        if (r204 != null) goto L275;
        r204 = r4;
    L275:
        r74.e(com.bytedance.android.ec.hybrid.card.api.d.a.c(r204, null), true);
        Unit r205 = Unit.INSTANCE;
        ViewGroup.LayoutParams r206 = O4().getLayoutParams();
        Integer r207 = r9.getCoinData().getCoinLynxHeight();
        Intrinsics.checkNotNull(r207);
        r206.height = r207.intValue();
    L276:
        Logger.d("puffone-NativeLiveCard.bindData()", "无金币标数据");
        O4().setVisibility(8);
        if (this.N == null) goto L279;
        ConstraintSet r208 = new ConstraintSet();
        r208.clone(P4());
        r208.connect(2131364473, 4, 0, 4);
        r208.applyTo(P4());
        goto L279
    L246:
        r72 = null;
        goto L248
    L234:
        r70 = null;
        goto L235
    L230:
        r68 = 0;
        goto L231
    L236:
        r125.putAll(ToolsKt.c(this, this.P2));
        com.bytedance.android.ec.hybrid.card.api.e r209 = this.M;
        if (r209 == null) goto L243;
        int r210 = com.bytedance.android.ec.hybrid.card.api.d.e;
        String r211 = r9.getWindVane().getWindVaneLynxData();
        if (r211 != null) goto L241;
        r211 = "";
    L241:
        r209.e(com.bytedance.android.ec.hybrid.card.api.d.a.c(r211, r125), true);
        Unit r212 = Unit.INSTANCE;
    L224:
        r65 = new LinkedHashMap();
    L242:
        Logger.d("puffone-NativeLiveCard.bindData()", "无风向标数据");
        b5().setVisibility(8);
    L195:
        r53 = r4;
        goto L196
    L188:
        b0.e(S4());
        goto L189
    L181:
        ((TextView) this.Y.getValue()).setVisibility(0);
        ((SimpleDraweeView) this.X.getValue()).setVisibility(0);
        Z4().setVisibility(0);
        N4().setVisibility(8);
        if (d0.b((SimpleDraweeView) this.X.getValue(), r9.getUser().getAvatar(), r24, r111) == true) goto L184;
        ((SimpleDraweeView) this.X.getValue()).setImageURI(r9.getUser().getAvatar());
    L184:
        ((TextView) this.Y.getValue()).setText(r9.getUser().getNickname());
        Z4().R5(r9.getProduct(), r9.getExperiment().isNewProductUI(), r9.getShowAdTag());
        goto L185
    L135:
        b0.n(U4());
        String r213 = this.v;
        if (r213 == null) goto L151;
        if (this.J == null) goto L143;
        HashMap<String, Boolean> r1100 = g93.a.a;
        Intrinsics.checkNotNullParameter(r213, "id");
        if (g93.a.a.containsKey(r213) != true) goto L143;
        boolean r1101 = false;
    L144:
        if (r1101 == true) goto L147;
        r213 = null;
    L147:
        if (r213 == null) goto L151;
        if (this.J == null) goto L151;
        g93.a.b(r213, false);
        Unit r214 = Unit.INSTANCE;
    L143:
        r1101 = true;
        goto L144
    L131:
        r43 = null;
    L152:
        LiveCardData r215 = this.u;
        if (r215 == null) goto L159;
        CommonData.Product r216 = r215.getProduct();
        if (r216 == null) goto L159;
        CommonData.Product.DecorationParam r217 = r216.getDecorationParam();
        if (r217 == null) goto L159;
        Boolean r218 = r217.getShowBorder();
    L161:
        if (Intrinsics.areEqual(r218, r117) == false) goto L174;
        ECHybridListItemVO r219 = ((BaseViewHolder) this).c;
        if (r219 == null) goto L174;
        if (r219.w == true) goto L174;
        LiveCardData r220 = this.u;
        if (r220 == null) goto L173;
        CommonData.Product r221 = r220.getProduct();
        if (r221 == null) goto L173;
        CommonData.Product.DecorationParam r222 = r221.getDecorationParam();
        if (r222 == null) goto L173;
        r222.setShowBorder(Boolean.FALSE);
    L173:
        b0.j(X4(), M4());
        b0.n(X4());
        b0.e((View) this.H1.getValue());
        b0.e((View) this.L1.getValue());
        b0.e(U4());
        b0.n(V4());
        ObjectAnimator r223 = ObjectAnimator.ofFloat(X4(), "alpha", new float[]{0.0f, 1.0f});
        r223.setDuration(520);
        ObjectAnimator r1102 = ObjectAnimator.ofFloat(X4(), "alpha", new float[]{1.0f, 0.0f});
        r1102.setDuration(520);
        r1102.setStartDelay(3480);
        AnimatorSet r224 = new AnimatorSet();
        r224.playTogether(new Animator[]{r223, r1102});
        r224.start();
    L174:
        b0.e(X4());
        b0.e(U4());
        b0.e((View) this.L1.getValue());
        b0.n(V4());
    L159:
        r218 = null;
    L93:
        r29 = null;
    L57:
        r12 = null;
        goto L58
    L468:
        r151 = null;
        goto L469
    L20:
        if (((BaseViewHolder) this).j == false) goto L22;
    L25:
        g5(this);
        IHybridLiveBoxView r225 = this.Q1;
        if (r225 == null) goto L28;
        IHybridLiveBoxView.stopPlayerClient$default(r225, null, 1, null);
    L28:
        IHybridLiveBoxView r226 = this.Q1;
        if (r226 == null) goto L500;
        b0.e(r226);
    L500:
        Result.Companion r227 = Result.Companion;     // Catch: Throwable -> L42
        Gson r228 = new Gson();     // Catch: Throwable -> L42
        LiveCardData r229 = this.u;     // Catch: Throwable -> L42
        if (r229 == null) goto L35;
        Object r230 = r229.getLive();     // Catch: Throwable -> L42
        if (r230 == null) goto L35;
    L36:
        String r231 = r228.toJson(r230);     // Catch: Throwable -> L42
        IHybridLiveBoxView r232 = this.Q1;     // Catch: Throwable -> L42
        if (r232 == null) goto L39;
        r232.setLiveData(r231);     // Catch: Throwable -> L42
        Unit r233 = Unit.INSTANCE;     // Catch: Throwable -> L42
    L40:
        Result.constructor-impl(r233);     // Catch: Throwable -> L42
    L44:
        IHybridLiveBoxView r234 = this.Q1;
        if (r234 == null) goto L47;
        r234.setMute(true);
        goto L47
    L39:
        r233 = null;
    L35:
        r230 = "";
    L42:
        th = move-exception;
        Result.Companion r235 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L44
    L22:
        if (((BaseViewHolder) this).a != IHybridListViewHolder.ECCardPlayState.IDLE) goto L25;
        if (this.g2 == false) goto L500;
        goto L25
    }

    public final void d4(boolean r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "source");
        Intrinsics.checkNotNullParameter(r7, "pageSource");
        super.d4(r5, r6, r7);
        if (Intrinsics.areEqual(r6, "page") == true) goto L5;
    L7:
        boolean r8 = false;
    L8:
        if (r8 == false) goto L10;
        return;
    L10:
        if (r5 == true) goto L12;
        long r9 = System.currentTimeMillis() - this.V1;
        Intrinsics.checkNotNullParameter(this, "$this$reportFeedAdShowOver");
        com.bytedance.android.shopping.mall.homepage.card.live.a.a(this, "feed_ad_show_over", MapsKt.mapOf(TuplesKt.to("duration", Long.valueOf(r9))));
        this.V1 = System.currentTimeMillis();
        this.F2 = false;
        ToolsKt.E(Y4());
        return;
    L12:
        if (this.F2 == true) goto L14;
        this.V1 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(this, "$this$reportFeedAdShow");
        com.bytedance.android.shopping.mall.homepage.card.live.a.a(this, "feed_ad_show", null);
        this.F2 = true;
    L14:
        ToolsKt.D(Y4());
        return;
    L5:
        if (Intrinsics.areEqual(r7, "other") == false) goto L7;
        r8 = true;
        goto L8
    }

    public NativeLiveCard(final View r17, boolean r18, Integer r19, boolean r20, Fragment r21, View r22, int r23, n r24, com.bytedance.android.shopping.mall.homepage.card.live.e r25, g93.a r26, com.bytedance.android.ec.hybrid.card.api.f r27, String r28, String r29, boolean r30, MutableLiveData r31, LifecycleOwner r32, com.bytedance.android.shopping.api.mall.idl.c r33, Function0 r34) {
        Intrinsics.checkNotNullParameter(r17, "itemView");
        Intrinsics.checkNotNullParameter(r24, "pageStateChangeObserver");
        Intrinsics.checkNotNullParameter(r25, "imageXMonitorTag");
        super(r17, r21, r22, r23, r19, r24, r26, r28, r29);
        this.Y2 = new ff3.a(r17);
        this.Q2 = r18;
        this.R2 = r20;
        this.S2 = r25;
        this.T2 = r27;
        this.U2 = r30;
        this.V2 = r31;
        this.W2 = r33;
        this.X2 = r34;
        this.O = LazyKt.lazy(new NativeLiveCard$liveCardRootView$2(r17));
        this.P = LazyKt.lazy(new NativeLiveCard$liveViewContainer$2(r17));
        this.Q = LazyKt.lazy(new NativeLiveCard$liveViewGlobalMask$2(this));
        this.R = LazyKt.lazy(new NativeLiveCard$liveCoverImage$2(r17));
        this.S = LazyKt.lazy(new NativeLiveCard$liveViewFrame$2(r17));
        this.T = LazyKt.lazy(new NativeLiveCard$liveLayerMessage$2(r17));
        this.U = LazyKt.lazy(new NativeLiveCard$windVanePanel$2(r17));
        this.V = LazyKt.lazy(new NativeLiveCard$coinPanel$2(r17));
        this.W = LazyKt.lazy(new NativeLiveCard$liveLayerPlayIcon$2(r17));
        this.X = LazyKt.lazy(new NativeLiveCard$liveLayerMerchantImage$2(r17));
        Lazy r0 = LazyKt.lazy(new NativeLiveCard$liveLayerMerchantName$2(r17));
        this.Y = r0;
        this.Z = LazyKt.lazy(new NativeLiveCard$liveWidgetImage$2(r17));
        this.k0 = LazyKt.lazy(new NativeLiveCard$leftTopAnim$2(r17));
        this.p0 = LazyKt.lazy(new NativeLiveCard$simpleProductView$2(r17));
        this.H0 = LazyKt.lazy(new NativeLiveCard$imageTopBlur$2(r17));
        this.L0 = LazyKt.lazy(new NativeLiveCard$imageBottomBlur$2(r17));
        this.P0 = LazyKt.lazy(new NativeLiveCard$privilegeText$2(r17));
        this.V0 = LazyKt.lazy(new NativeLiveCard$productView$2(r17));
        this.b1 = LazyKt.lazy(new NativeLiveCard$maskView$2(r17));
        this.g1 = LazyKt.lazy(new NativeLiveCard$bottomInfoView$2(r17));
        this.h1 = LazyKt.lazy(new NativeLiveCard$liveWatchedView$2(r17));
        this.k1 = LazyKt.lazy(new NativeLiveCard$liveMuteImg$2(r17));
        this.p1 = LazyKt.lazy(new NativeLiveCard$livePlayInfoContainer$2(r17));
        this.v1 = LazyKt.lazy(new NativeLiveCard$adSmallBlackDot$2(r17));
        this.x1 = LazyKt.lazy(new NativeLiveCard$arriveTime$2(r17));
        this.y1 = LazyKt.lazy(new NativeLiveCard$arriveTimeIcon$2(r17));
        this.G1 = LazyKt.lazy(new NativeLiveCard$arriveTimeBg$2(r17));
        this.H1 = LazyKt.lazy(new NativeLiveCard$watchedLayout$2(r17));
        this.L1 = LazyKt.lazy(new NativeLiveCard$liveCardWatchedIcon$2(r17));
        this.M1 = LazyKt.lazy(new NativeLiveCard$productPriceView$2(r17));
        this.S1 = true;
        this.V1 = System.currentTimeMillis();
        this.b2 = System.currentTimeMillis();
        Lazy r2 = LazyKt.lazy(NativeLiveCard$reuseLiveView$2.INSTANCE);
        this.h2 = r2;
        Lazy r3 = LazyKt.lazy(NativeLiveCard$reuseLiveViewPages$2.INSTANCE);
        this.p2 = r3;
        this.v2 = LazyKt.lazy(NativeLiveCard$useNonMallSchemaProcessor$2.INSTANCE);
        this.x2 = "";
        this.F2 = true;
        this.H2 = LazyKt.lazy(NativeLiveCard$maskHide$2.INSTANCE);
        this.I2 = 1.0f;
        m r4 = new m(this);
        this.J2 = r4;
        this.K2 = LazyKt.lazy(NativeLiveCard$memoryLeakFix$2.INSTANCE);
        this.L2 = LazyKt.lazy(NativeLiveCard$enableFoldConfig$2.INSTANCE);
        this.M2 = LazyKt.lazy(NativeLiveCard$liveTransAnimOpt$2.INSTANCE);
        this.N2 = LazyKt.lazy(NativeLiveCard$equityVisible$2.INSTANCE);
        this.O2 = LazyKt.lazy(NativeLiveCard$animationPageName$2.INSTANCE);
        Z4().S5(r25.a, r25.d);
        View.OnClickListener r5 = com.bytedance.android.shopping.mall.homepage.card.a.a(new j(this, r17, r28), new NativeLiveCard$cardClickListener$2(this));
        View.OnClickListener r6 = com.bytedance.android.shopping.mall.homepage.card.a.a(new l(this, r17), new NativeLiveCard$productClickListener$2(this));
        W4().setOnClickListener(r5);
        N4().setOnClickListener(r5);
        Z4().setOnClickListener(r6);
        f r7 = new f(this);
        this.G2 = r7;
        W4().setHapticFeedbackEnabled(false);
        W4().setOnLongClickListener(r7);
        N4().setHapticFeedbackEnabled(false);
        N4().setOnLongClickListener(r7);
        Z4().setOnLongClickListener(r7);
        P4().setBackgroundColor(-1);
        ((TextView) r0.getValue()).setTextColor(-1);
        Lazy r8 = HybridAppInfoService.a;
        if (HybridAppInfoService.m() == false) goto L5;
        T4().setImageResource(2131248026);
        ((TextView) r0.getValue()).setTextColor(ColorProtector.parseColor("#FEFFFFFF"));
    L5:
        k r1 = new k(this, r26);
        U4().setOnClickListener(r1);
        if (r32 == null) goto L9;
        if (r31 == null) goto L9;
        r31.observe(r32, r4);
    L9:
        ECUpdateHeightConstraintLayout r9 = P4();
        Function2<Integer, Integer, Unit> r10 = new AnonymousClass2(this);
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "listener");
        r9.f = r10;
        O4().setOnClickListener(r5);
        if (r32 != null) goto L12;
        return;
    L12:
        if (((Number) r2.getValue()).intValue() == 1) goto L14;
        return;
    L14:
        if (CollectionsKt.contains((List) r3.getValue(), r28) == false) goto L19;
        r32.getLifecycle().addObserver(new NativeLiveCard$clearViewOnDestroy$1(this));
        return;
    }
}
