package com.bytedance.android.shopping.deepfeed.ui.vh;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.ec.core.utils.n1;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.buynow.data.model.PageScrollStatus;
import com.bytedance.android.shopping.deepfeed.action.DeepFeedCommentClickArea;
import com.bytedance.android.shopping.deepfeed.data.DeepFeedQueryParam;
import com.bytedance.android.shopping.deepfeed.event.DeepFeedProductEventTracker;
import com.bytedance.android.shopping.deepfeed.fold.DeepFeedFoldHelper;
import com.bytedance.android.shopping.deepfeed.ui.DeepFeedProductBannerAdapter;
import com.bytedance.android.shopping.deepfeed.ui.DeepFeedProductOverScrollPagerSnapHelper;
import com.bytedance.android.shopping.deepfeed.ui.view.DeepFeedProductView;
import com.bytedance.android.shopping.deepfeed.viewmodel.DeepFeedProductViewModel;
import com.bytedance.android.shopping.deepfeed.weights.DeepFeedAbilityComment;
import com.bytedance.android.shopping.deepfeed.weights.DeepFeedProductAbilityView;
import com.bytedance.android.shopping.deepfeed.weights.DeepFeedProductHeaderTabLayout;
import com.bytedance.android.shopping.deepfeed.weights.DeepFeedProductHeaderView;
import com.bytedance.android.shopping.deepfeed.weights.DeepFeedProductInfoExtraView;
import com.bytedance.android.shopping.deepfeed.weights.DeepFeedProductInfoView;
import com.bytedance.android.shopping.deepfeed.weights.DeepFeedProductToolContainer;
import com.bytedance.android.shopping.deepfeed.weights.video.VideoCoverLayout;
import com.bytedance.android.shopping.infeed.data.idl.HeaderBannerItemType;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackData;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackDataElements;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.bytedance.android.shopping.infeed.data.idl.InFeedUrlModel;
import com.bytedance.android.shopping.infeed.data.idl.ad.AdBaseInfo;
import com.bytedance.android.shopping.inflow.cardui.product.header.indicator.ProductCardProgressIndicator;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import he3.e1;
import he3.e2;
import he3.f1;
import he3.g1;
import he3.h1;
import he3.k1;
import he3.k2;
import he3.m1;
import he3.o0;
import he3.p0;
import he3.r0;
import he3.w1;
import he3.x0;
import he3.x1;
import he3.z0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/ui/vh/DeepFeedProductVH;", "Lcom/bytedance/android/shopping/deepfeed/ui/vh/AbsDeepFeedProductVH;", "Landroid/view/View$OnClickListener;", "", "Landroid/view/View$OnLongClickListener;", "Lcom/bytedance/android/shopping/deepfeed/action/i;", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class DeepFeedProductVH extends AbsDeepFeedProductVH implements View.OnClickListener, View.OnLongClickListener, com.bytedance.android.shopping.deepfeed.action.i {
    public static final /* synthetic */ int P0 = 0;
    public final com.bytedance.android.ec.core.imagex.r H0;
    public final com.bytedance.android.shopping.deepfeed.action.h L0;
    public boolean Q;
    public boolean R;
    public final boolean S;
    public final Function1<DeepFeedCommentClickArea, Unit> T;
    public final Function0<Unit> U;
    public final Function2<Integer, String, Unit> V;
    public final Function2<Integer, String, Unit> W;
    public final e X;
    public boolean Y;
    public final LifecycleOwner Z;
    public final DeepFeedProductView k0;
    public final HashMap<InFeedProductV2, re3.a> p0;

    public static final class a {
    }

    public static final class b implements View.OnLongClickListener {
        public final /* synthetic */ DeepFeedProductVH a;

        public b(DeepFeedProductVH r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r5) {
            if (this.a.m4() == false) goto L5;
            return false;
        L5:
            DeepFeedProductVH r6 = this.a;
            com.bytedance.android.shopping.deepfeed.action.h r1 = r6.L0;
            r6.getAdapterPosition();
            r1.c();
            DeepFeedProductViewModel r7 = this.a.i4();
            DeepFeedProductVH r2 = this.a;
            r7.longPress(r2.m, "other", r2.n);
            return false;
        }
    }

    public static final class c implements yg3.e {
        public final /* synthetic */ DeepFeedProductVH a;

        @Override // yg3.e
        public final void g() {
            DeepFeedProductViewModel r1 = this.a.i4();
            DeepFeedProductVH r0 = this.a;
            DeepFeedProductViewModel.enterProductDetail$default(r1, r0.m, r0.q, r0.k0, r0.n, null, 16, null);
        }

        public c(DeepFeedProductVH r1) {
            this.a = r1;
        }
    }

    public static final class d implements ke3.a {
        public final /* synthetic */ DeepFeedProductVH a;

        public d(DeepFeedProductVH r1) {
            this.a = r1;
        }

        @Override // ke3.a
        public final void a(int r8, boolean r9) {
            DeepFeedProductVH r0 = this.a;
            InFeedProductV2 r1 = r0.m;
            if (r1 == null) goto L8;
            re3.a r2 = r0.p0.get(r1);
            if (r2 == null) goto L8;
            r2.a = r9;
        L8:
            if (this.a.k0.getHeaderView().e() == false) goto L12;
            if (r8 != 0) goto L11;
            this.a.k0.getHeaderView().d(com.bytedance.android.shopping.deepfeed.utlis.f.b);
        L13:
            Integer r10 = this.a.i4().findReportCardIndex(this.a.m);
            if (r10 == null) goto L19;
            int r3 = r10.intValue();
            int r4 = this.a.k0.getHeaderView().getCurrentSelected();
            DeepFeedProductEventTracker r5 = this.a.i4().getEventTracker();
            if (r5 == null) goto L20;
            DeepFeedProductVH r11 = this.a;
            r5.C(r3, r4, r9, r11.q, r11.k0, r11.m);
            return;
        L20:
            return;
        L19:
            return;
        L11:
            DeepFeedProductHeaderView r12 = this.a.k0.getHeaderView();
            r12.A.setVisibility(4);
            r12.B.setVisibility(4);
            goto L13
        L12:
            DeepFeedProductHeaderView r13 = this.a.k0.getHeaderView();
            r13.A.setVisibility(4);
            r13.B.setVisibility(4);
            goto L13
        }
    }

    public static final class e implements Function1<Boolean, Unit> {
        public final /* synthetic */ DeepFeedProductVH a;

        public e(DeepFeedProductVH r1) {
            this.a = r1;
        }

        public final Object invoke(Object r3) {
            boolean r4 = ((Boolean) r3).booleanValue();
            if (r4 == true) goto L5;
            this.a.k0.getHeaderView().getMuteIcon().setVisibility(8);
            this.a.k0.getHeaderView().getUnmuteIcon().setVisibility(8);
        L5:
            this.a.i4().reportVideoPlay(this.a.m, r4);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.i
    public final void Z1() {
        String r1 = "";
        if (this.o == false) goto L13;
        this.Y = false;
        com.bytedance.android.shopping.deepfeed.action.h r0 = this.L0;
        InFeedProductV2 r2 = this.m;
        if (r2 == null) goto L12;
        he3.v r3 = r2.getDynamicData();
        if (r3 == null) goto L12;
        String r4 = r3.l;
        if (r4 == null) goto L12;
        r1 = r4;
    L12:
        getAdapterPosition();
        getAdapterPosition();
        i4().curNoFullScreenCount();
        r0.x(r1);
        return;
    L13:
        this.Y = true;
        com.bytedance.android.shopping.deepfeed.action.h r5 = this.L0;
        InFeedProductV2 r6 = this.m;
        if (r6 == null) goto L21;
        he3.v r7 = r6.getDynamicData();
        if (r7 == null) goto L21;
        String r8 = r7.l;
        if (r8 == null) goto L21;
        r1 = r8;
    L21:
        getAdapterPosition();
        getAdapterPosition();
        i4().curNoFullScreenCount();
        r5.x(r1);
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public final void d4() {
        InFeedProductV2 r0 = this.m;
        if (r0 == null) goto L13;
        re3.a r1 = this.p0.get(r0);
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.e == false) goto L9;
        r1.d = true;
    L9:
        DeepFeedProductHeaderView r2 = this.k0.getHeaderView();
        boolean r3 = r1.e;
        boolean r4 = r1.d;
        DeepFeedProductBannerAdapter r5 = r2.f;
        if (r5 == null) goto L15;
        r5.h = r3;
        r5.i = r4;
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public final void e4() {
        if (this.k0.getHeaderView().e() == false) goto L5;
        this.k0.getHeaderView().n("exit");
    L5:
        this.k0.getHeaderView().e.c();
        DeepFeedProductBannerAdapter r0 = this.k0.getHeaderView().getBannerAdapter();
        if (r0 == null) goto L14;
        RecyclerView.ViewHolder r1 = r0.a;
        if ((r1 instanceof DeepFeedProductBannerVideoVH) == true) goto L10;
        r1 = null;
    L10:
        DeepFeedProductBannerVideoVH r2 = (DeepFeedProductBannerVideoVH) r1;
        if (r2 == null) goto L15;
        r2.V3();
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public final void f4() {
        if (this.k0.getHeaderView().e() == false) goto L5;
        this.k0.getHeaderView().i();
    L5:
        InFeedProductV2 r0 = this.m;
        if (r0 == null) goto L14;
        InFeedProductPackData r1 = r0.getPackData();
        if (r1 == null) goto L14;
        InFeedProductPackDataElements r2 = r1.getElements();
        if (r2 == null) goto L14;
        List<p0> r3 = r2.getProducts();
        if (r3 == null) goto L14;
        p0 r4 = (p0) CollectionsKt.firstOrNull(r3);
    L15:
        if (r4 != null) goto L17;
    L19:
        this.k0.getHeaderView().getOverScrollSnapHelper().e = false;
        return;
    L17:
        if (this.o == false) goto L19;
        this.k0.getHeaderView().m();
    L14:
        r4 = null;
        goto L15
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public final void g4() {
        DeepFeedProductHeaderView r0 = this.k0.getHeaderView();
        if (r0.k < (r0.getItemCount() - 1)) goto L6;
        r0.a.scrollToPosition(r0.getItemCount() - 1);
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public final boolean l4() {
        InFeedProductV2 r0 = this.m;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isSkeletonData() != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public final boolean m4() {
        InFeedProductV2 r0 = this.m;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isSkeletonData() != true) goto L7;
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.view.ViewGroup, com.bytedance.android.shopping.deepfeed.weights.DeepFeedProductInfoExtraView, java.lang.Object] */
    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public final void v4() {
        if (tc3.f.b() == false) goto L9;
        ?? r0 = this.k0.getInfoView().getExtraView();
        r0.getClass();
        if (tc3.f.b() == false) goto L10;
        r0.post(new com.bytedance.android.shopping.deepfeed.weights.n(r0));
        return;
    L10:
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.i
    public final boolean isCardVisible() {
        return this.o;
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public final void onResume() {
        super.onResume();
    }

    public static final void A4(DeepFeedProductVH r3) {
        if (r3.m == null) goto L16;
        DeepFeedProductHeaderView r0 = r3.k0.getHeaderView();
        x0 r1 = (x0) CollectionsKt.getOrNull(r0.p0, r0.k);
        if (r1 == null) goto L8;
        String r2 = r1.e;
    L9:
        if (r2 == null) goto L17;
        DeepFeedProductEventTracker r4 = r3.i4().getEventTracker();
        if (r4 == null) goto L15;
        Intrinsics.checkNotNullParameter(r2, "tabName");
        LinkedHashMap r5 = new LinkedHashMap();
        r5.put("tab_name", r2);
        r4.doEventAction("deep_feed_tab_content_click", r5);
        return;
    L15:
        return;
    L17:
        return;
    L8:
        r2 = null;
        goto L9
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.i
    public final void T2(String r6) {
        Intrinsics.checkNotNullParameter(r6, "text");
        DeepFeedProductEventTracker r0 = i4().getEventTracker();
        if (r0 == null) goto L6;
        int r1 = getAdapterPosition();
        InFeedProductV2 r2 = this.m;
        List<String> r3 = this.n;
        Intrinsics.checkNotNullParameter(r6, "aiText");
        Map<String, Object> r4 = r0.g(r1, r2, r3);
        r4.put("ai_query", r6);
        r0.doEventAction("deep_feed_ai_show", r4);
        return;
    }

    /* JADX WARN: Type inference failed for: r6v12, types: [android.view.ViewGroup, com.bytedance.android.shopping.deepfeed.ui.view.DeepFeedProductView, java.lang.Object] */
    public final void a4(Object r22) {
        InFeedProductV2 r1 = (InFeedProductV2) r22;
        Intrinsics.checkNotNullParameter(r1, "item");
        InFeedProductV2 r2 = this.m;
        this.m = r1;
        this.R = false;
        this.k0.getHeaderView().setVideoProgressReportListener(new DeepFeedProductVH$onBind$1(this));
        ((ArrayList) this.n).clear();
        InFeedProductPackData r4 = r1.getPackData();
        if (r4 == null) goto L15;
        InFeedProductPackDataElements r5 = r4.getElements();
        if (r5 == null) goto L15;
        List<p0> r6 = r5.getProducts();
        if (r6 == null) goto L15;
        p0 r7 = (p0) CollectionsKt.firstOrNull(r6);
        if (r7 == null) goto L15;
        h1 r8 = r7.d();
        if (r8 == null) goto L15;
        f1 r9 = r8.a();
        if (r9 == null) goto L15;
        String r10 = r9.a();
    L16:
        InFeedProductPackData r11 = r1.getPackData();
        if (r11 == null) goto L31;
        InFeedProductPackDataElements r12 = r11.getElements();
        if (r12 == null) goto L31;
        List<p0> r13 = r12.getProducts();
        if (r13 == null) goto L31;
        p0 r14 = (p0) CollectionsKt.firstOrNull(r13);
        if (r14 == null) goto L31;
        g1 r15 = r14.c();
        if (r15 == null) goto L31;
        List<f1> r16 = r15.a();
        if (r16 == null) goto L31;
        f1 r17 = (f1) CollectionsKt.firstOrNull(r16);
        if (r17 == null) goto L31;
        String r18 = r17.a();
    L33:
        if (r10 == null) goto L35;
        String r19 = AbsDeepFeedProductVH.h4(r10);
        Intrinsics.checkNotNullParameter(r19, "<set-?>");
        this.C = r19;
    L35:
        if (r18 == null) goto L37;
        String r20 = AbsDeepFeedProductVH.h4(r18);
        Intrinsics.checkNotNullParameter(r20, "<set-?>");
        this.D = r20;
    L37:
        re3.a r21 = this.p0.get(r1);
        int r23 = i4().curNoFullScreenCount();
        int r24 = i4().curNoFullScreenCount();
        int r25 = getAdapterPosition();
        if (r25 < 0) goto L40;
        if (r24 <= r25) goto L40;
    L44:
        Lazy r26 = DeepFeedFoldHelper.a;
        Context r27 = this.L0.getContext();
        if (r27 == null) goto L47;
        Activity r28 = ECHybridExtensionsKt.a(r27);
    L48:
        DeepFeedFoldHelper.b(r28);
        boolean r29 = true;
    L50:
        if (r21 != null) goto L59;
        r21 = new re3.a();
        int r30 = getAdapterPosition();
        if (1 > r30) goto L58;
        if (r23 < r30) goto L58;
        if (r1.isSkeletonData() == true) goto L58;
        r21.d = true;
        r21.e = true;
        r21.f = true;
    L58:
        this.p0.put(r1, r21);
    L59:
        r21.c = r29;
        if (this.S == false) goto L74;
        ?? r31 = this.k0;
        if (r29 == false) goto L73;
        com.bytedance.android.shopping.deepfeed.action.h r32 = r31.l;
        if (r32 == null) goto L66;
        r32.s();
    L66:
        n1.a r33 = n1.i;
        r33.getClass();
        if (n1.e != 0) goto L69;
        r33.getClass();
        n1.a.e(ECAppInfoService.e.getApplicationContext());
    L69:
        r31.setLayoutParams(new ViewGroup.LayoutParams(-1, n1.e));
        r31.i.setVisibility(4);
        int r34 = tc3.f.a;
        if (Intrinsics.areEqual(tc3.a.a().g(), Boolean.TRUE) == false) goto L72;
        r31.i.getLayoutParams().height = com.bytedance.android.shopping.extensions.b.b(8);
        goto L74
    L72:
        r31.i.getLayoutParams().height = com.bytedance.android.shopping.extensions.b.b(12);
        goto L74
    L73:
        r31.getClass();
        r31.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        ExtensionsKt.gone(r31.i);
    L74:
        this.k0.R5(r21.f);
        Integer r35 = i4().findCardIndex(this.m);
        DeepFeedProductToolContainer r36 = this.k0.getToolContainer();
        com.bytedance.android.shopping.deepfeed.action.h r110 = this.L0;
        r36.getClass();
        Intrinsics.checkNotNullParameter(r1, "deepFeed");
        String r111 = "deepFeedContext";
        Intrinsics.checkNotNullParameter(r110, "deepFeedContext");
        Intrinsics.checkNotNullParameter(r1, "deepFeed");
        Intrinsics.checkNotNullParameter(r110, "deepFeedContext");
        Intrinsics.checkNotNullParameter(r1, "$this$isSHowAiInCenter");
        Intrinsics.checkNotNullParameter(r110, "deepFeedContext");
        List<he3.q> r112 = com.bytedance.android.shopping.deepfeed.utlis.g.a(r1);
        if (r112 != null) goto L77;
    L80:
        boolean r113 = true;
    L81:
        if (r113 == true) goto L86;
        if (r1.getDynamicData().j == true) goto L86;
        r110.m();
    L86:
        if (com.bytedance.android.shopping.deepfeed.utlis.g.c(r1) == false) goto L88;
    L117:
        Intrinsics.checkNotNullParameter(r1, "$this$hasMultiTab");
        InFeedProductPackData r114 = r1.getPackData();
        if (r114 == null) goto L134;
        InFeedProductPackDataElements r115 = r114.getElements();
        if (r115 == null) goto L134;
        List<p0> r116 = r115.getProducts();
        if (r116 == null) goto L134;
        p0 r117 = (p0) CollectionsKt.firstOrNull(r116);
        if (r117 == null) goto L134;
        m1 r118 = r117.i();
        if (r118 == null) goto L134;
        he3.m r119 = r118.a();
        if (r119 == null) goto L134;
        he3.s r120 = r119.c();
        if (r120 == null) goto L134;
        List<o0> r121 = r120.a();
        if (r121 == null) goto L134;
        Boolean r122 = Boolean.valueOf(!r121.isEmpty());
    L136:
        if (Intrinsics.areEqual(r122, Boolean.TRUE) == false) goto L140;
        VideoCoverLayout r123 = r36.c;
        if (r123 == null) goto L143;
        d2.d(r123, 0, 0, 0, com.bytedance.android.shopping.extensions.b.b(4));
    L143:
        d2.d(r36.b, com.bytedance.android.shopping.extensions.b.b(12), 0, com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(12));
        DeepFeedProductHeaderTabLayout r37 = r36.f;
        r37.b(com.bytedance.android.shopping.extensions.b.b(16), r37.b.size());
    L144:
        DeepFeedProductHeaderView r38 = this.k0.getHeaderView();
        boolean r124 = r21.a;
        boolean r125 = r21.e;
        boolean r126 = r21.d;
        com.bytedance.android.ec.core.imagex.r r127 = this.H0;
        LifecycleOwner r39 = this.Z;
        e r40 = this.X;
        boolean r128 = r21.c;
        com.bytedance.android.shopping.deepfeed.action.h r41 = this.L0;
        r38.getClass();
        Intrinsics.checkNotNullParameter(r1, "inFeedProductInfo");
        Intrinsics.checkNotNullParameter(r127, "imageCallerContext");
        Intrinsics.checkNotNullParameter(r39, "owner");
        re3.a r129 = r21;
        Intrinsics.checkNotNullParameter(r40, "videoPlayListenerForCard");
        Intrinsics.checkNotNullParameter(r41, "deepFeedContext");
        Intrinsics.checkNotNullParameter(this, "parentAbility");
        r38.I = this;
        r38.V = com.bytedance.android.shopping.deepfeed.event.f.a(r1);
        r41.m();
        if (r1.isSkeletonData() == false) goto L147;
        x0 r130 = new x0();
        r130.a(HeaderBannerItemType.Skeleton);
        List<x0> r0 = CollectionsKt.listOf(r130);
        boolean r131 = r125;
        r111 = "deepFeedContext";
    L225:
        r38.S = 0;
        r38.T = 0;
        VideoCoverLayout r132 = r38.d;
        if (r132 == null) goto L228;
        r41.m();
        r132.j = false;
    L228:
        if (r35 != null) goto L231;
    L236:
        boolean r133 = true;
    L238:
        if (r133 == false) goto L258;
        Intrinsics.checkNotNullParameter(r39, "owner");
        Intrinsics.checkNotNullParameter(r40, "videoPlayListenerForCard");
        DeepFeedProductBannerAdapter r3 = new DeepFeedProductBannerAdapter(r39, r128, r35);
        r38.f = r3;
        r38.a.setAdapter(r3);
        DeepFeedProductBannerAdapter r42 = r38.f;
        if (r42 == null) goto L242;
        DeepFeedProductHeaderView.e r43 = r38.s;
        Intrinsics.checkNotNullParameter(r43, "listener");
        r42.c = r43;
    L242:
        DeepFeedProductBannerAdapter r44 = r38.f;
        if (r44 == null) goto L245;
        Function1<DeepFeedCommentClickArea, Unit> r45 = r38.t;
        Intrinsics.checkNotNullParameter(r45, "listener");
        r44.d = r45;
    L245:
        DeepFeedProductBannerAdapter r46 = r38.f;
        if (r46 == null) goto L248;
        r46.e = r38.u;
    L248:
        if (r46 == null) goto L250;
        DeepFeedProductHeaderView.h r47 = r38.O;
        Intrinsics.checkNotNullParameter(r47, "listener");
        r46.m = r47;
    L250:
        DeepFeedProductBannerAdapter r48 = r38.f;
        if (r48 == null) goto L253;
        Function0<Unit> r49 = r38.Q;
        Intrinsics.checkNotNullParameter(r49, "listener");
        r48.n = r49;
    L253:
        DeepFeedProductBannerAdapter r50 = r38.f;
        if (r50 == null) goto L256;
        DeepFeedProductHeaderView.f r51 = r38.v;
        Intrinsics.checkNotNullParameter(r51, "listener");
        r50.f = r51;
    L256:
        r38.P = r40;
        r38.S = 0;
        r38.T = 0;
    L258:
        if (r1.isSkeletonData() == false) goto L262;
        View r52 = r38.H;
        int r53 = 8;
        if (r52 == null) goto L266;
        r52.setVisibility(8);
    L266:
        if (r0.isEmpty() == false) goto L270;
        r38.a.setVisibility(r53);
        r38.J = CollectionsKt.emptyList();
        DeepFeedProductHeaderTabLayout r54 = r38.y;
        if (r54 == null) goto L518;
        r54.setVisibility(r53);
    L518:
        if (this.k0.getHeaderView().e() == true) goto L520;
        DeepFeedProductHeaderView r55 = this.k0.getHeaderView();
        r55.A.setVisibility(4);
        r55.B.setVisibility(4);
    L521:
        this.k0.getInfoView().R5(r1, i4().getCompositeDisposable(), this.L0, this);
        this.k0.getAbilityView().R5(r1, r129.c, this.L0, this);
        this.k0.getSearchBarView().R5(r1, this);
        this.q = "c320293.d3330694_i" + (getAdapterPosition() + 1);
        this.r = "c320293.d106653_i" + (getAdapterPosition() + 1);
        this.s = "c320293.d29208_i" + (getAdapterPosition() + 1);
        this.t = "c320293.d469094_i" + (getAdapterPosition() + 1);
        this.u = "c958668.d09676_i" + (getAdapterPosition() + 1);
        this.v = "c320293.d535468_i" + (getAdapterPosition() + 1);
        this.w = "c320293.d519239_i" + (getAdapterPosition() + 1);
        this.x = "c320293.d389228_i" + (getAdapterPosition() + 1);
        this.z = "c320293.d75409_i" + (getAdapterPosition() + 1);
        this.A = "c320293.d71568_i" + (getAdapterPosition() + 1);
        this.B = "c320293.d27588_i" + (getAdapterPosition() + 1);
        getAdapterPosition();
        this.y = "c320293.d106644_i" + (getAdapterPosition() + 1);
        B4(r2, r1, r129);
        com.bytedance.android.shopping.deepfeed.data.repo.l r56 = i4().getResp();
        if (r56 == null) goto L524;
        uc3.f r57 = r56.g();
    L525:
        r4();
        if (r1.isCacheData() == false) goto L529;
        t4(new u(r57));
    L529:
        if (this.Q == true) goto L535;
        z0 r58 = r1.getRespExtra();
        if (r58 == null) goto L535;
        if (r58.a != true) goto L535;
        this.Q = true;
        t4(new v(r57));
    L535:
        com.bytedance.android.shopping.deepfeed.data.repo.l r59 = i4().getResp();
        if (r59 != null) goto L538;
    L550:
        Map<String, Object> r60 = le3.b.c(this.q, this.k0);
        if (r60 == null) goto L559;
        InFeedProductV2 r61 = this.m;
        if (r61 == null) goto L559;
        he3.v r62 = r61.getDynamicData();
        if (r62 == null) goto L559;
        Map<String, Object> r63 = r62.a;
        if (r63 == null) goto L559;
        r63.putAll(r60);
    L559:
        InFeedProductV2 r64 = this.m;
        if (r64 == null) goto L564;
        he3.v r65 = r64.getDynamicData();
        if (r65 == null) goto L564;
        r65.b = getLayoutPosition();
    L564:
        Intrinsics.checkNotNullParameter(r1, "feedProductV2");
        com.bytedance.android.shopping.deepfeed.ui.vh.d r66 = new com.bytedance.android.shopping.deepfeed.ui.vh.d(this, r1);
        this.J = r66;
        i4().addCouponListener(r66);
        return;
    L538:
        if (r59.l == true) goto L550;
        if (r1.isCacheData() == true) goto L550;
        z0 r67 = r1.getRespExtra();
        if (r67 == null) goto L546;
        boolean r68 = true;
        if (r67.a == true) goto L550;
    L547:
        com.bytedance.android.shopping.deepfeed.data.repo.l r69 = i4().getResp();
        if (r69 == null) goto L550;
        t4(new t(this, r57));
        r69.l = r68;
        goto L550
    L546:
        r68 = true;
        goto L547
    L524:
        r57 = null;
        goto L525
    L520:
        this.k0.getHeaderView().d(com.bytedance.android.shopping.deepfeed.utlis.f.b);
        goto L521
    L270:
        r38.a.setVisibility(0);
        ((ArrayList) r38.p0).clear();
        ((ArrayList) r38.p0).addAll(r0);
        r38.J = DeepFeedProductHeaderView.b(r0);
        if (r1.isCacheData() == false) goto L273;
    L275:
        boolean r70 = false;
    L276:
        r38.M = r70;
        r38.i = r124;
        int r71 = r0.size();
        if (r38.h() == true) goto L279;
        DeepFeedProductHeaderTabLayout r72 = r38.y;
        if (r72 == null) goto L303;
        r72.setVisibility(8);
    L303:
        x0 r73 = (x0) CollectionsKt.firstOrNull(r0);
        if (r73 == null) goto L306;
        r73.getType();
    L306:
        HeaderBannerItemType r74 = HeaderBannerItemType.Image;
        List<x0> r75 = r0;
        if ((r75 instanceof Collection) == true) goto L309;
    L311:
        Iterator<T> r76 = r75.iterator();
    L313:
        if (r76.hasNext() == false) goto L320;
        if (((x0) r76.next()).getType() != HeaderBannerItemType.CoverVideo) goto L317;
        boolean r77 = true;
    L318:
        if (r77 == false) goto L313;
        boolean r78 = true;
    L321:
        if (r78 == false) goto L326;
        int r79 = 1;
        if (r0.size() != 1) goto L325;
        HeaderBannerItemType r80 = HeaderBannerItemType.CoverVideo;
    L327:
        int r81 = com.bytedance.android.shopping.deepfeed.weights.f.a[r80.ordinal()];
        if (r81 == r79) goto L369;
        if (r81 != 2) goto L331;
        VideoCoverLayout r82 = r38.d;
        if (r82 == null) goto L363;
        r82.setVisibility(0);
    L363:
        FrameLayout r84 = r38.c;
        if (r84 == null) goto L366;
        r84.setVisibility(8);
    L366:
        VideoCoverLayout r85 = r38.d;
        if (r85 == null) goto L375;
        r85.c(HeaderBannerItemType.CoverVideo, 0);
    L375:
        r38.k = 0;
        r38.K = r127;
        DeepFeedProductBannerAdapter r86 = r38.f;
        if (r86 == null) goto L378;
        Intrinsics.checkNotNullParameter(r127, "imageCallerContext");
        Intrinsics.checkNotNullParameter(r41, r111);
        r86.p = r127;
        r86.q = r41;
    L378:
        DeepFeedProductBannerAdapter r87 = r38.f;
        if (r87 == null) goto L381;
        r87.h = r131;
        r87.i = r126;
    L381:
        if (r87 == null) goto L383;
        DeepFeedProductHeaderView.g r88 = r38.W;
        Intrinsics.checkNotNullParameter(r88, "listener");
        r87.o = r88;
    L383:
        DeepFeedProductBannerAdapter r89 = r38.f;
        if (r89 == null) goto L386;
        r89.D2(r0, r133);
    L386:
        r38.G = r0;
        DeepFeedProductBannerAdapter r90 = r38.f;
        if (r90 == null) goto L389;
        r90.r = r124;
    L389:
        r38.g.c = r124;
        r38.a();
        r38.p(r38.k);
        if (r38.e() == false) goto L394;
        VideoCoverLayout r91 = r38.d;
        if (r91 == null) goto L394;
        r91.b(0.0f, true);
    L394:
        InFeedProductPackData r92 = r1.getPackData();
        if (r92 == null) goto L409;
        InFeedProductPackDataElements r94 = r92.getElements();
        if (r94 == null) goto L409;
        List<p0> r95 = r94.getProducts();
        if (r95 == null) goto L409;
        p0 r96 = (p0) CollectionsKt.firstOrNull(r95);
        if (r96 == null) goto L409;
        w1 r97 = r96.o();
        if (r97 == null) goto L409;
        List<x1> r98 = r97.a();
        if (r98 == null) goto L409;
        x1 r99 = (x1) CollectionsKt.firstOrNull(r98);
        if (r99 == null) goto L409;
        String r100 = r99.a();
    L411:
        if (com.bytedance.android.shopping.extensions.k.c(r100) == true) goto L413;
    L419:
        boolean r101 = false;
    L420:
        if (r101 == false) goto L429;
        AppCompatTextView r102 = r38.x;
        if (r102 == null) goto L424;
        r102.setText("相关搜索·" + r100);
    L424:
        ConstraintLayout r103 = r38.w;
        if (r103 == null) goto L428;
        r103.setVisibility(0);
    L428:
        r38.z = true;
    L433:
        DeepFeedProductOverScrollPagerSnapHelper r104 = r38.g;
        if (r38.e() == false) goto L452;
        List<x0> r105 = r38.p0;
        if ((r105 instanceof Collection) == true) goto L438;
    L440:
        Iterator r106 = ((ArrayList) r105).iterator();
    L442:
        if (r106.hasNext() == false) goto L449;
        if (((x0) r106.next()).getType() != HeaderBannerItemType.Image) goto L446;
        boolean r107 = true;
    L447:
        if (r107 == false) goto L442;
        boolean r108 = true;
    L450:
        if (r108 == true) goto L452;
        boolean r109 = true;
    L453:
        r104.d = r109;
        View r134 = r38.H;
        if (r134 == null) goto L457;
        GradientDrawable r135 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{ColorProtector.parseColor("#00000000"), ColorProtector.parseColor("#80000000")});
        Intrinsics.checkNotNullParameter(r134, "$this$setBackgroundCompat");
        r134.setBackground(r135);
    L457:
        TextView r136 = r38.C;
        InFeedProductPackData r137 = r1.getPackData();
        if (r137 == null) goto L466;
        InFeedProductPackDataElements r138 = r137.getElements();
        if (r138 == null) goto L466;
        ie3.a r139 = r138.getAd();
        if (r139 == null) goto L466;
        AdBaseInfo r140 = r139.a();
        if (r140 == null) goto L466;
        Boolean r141 = Boolean.valueOf(r140.getShowAdTag());
    L467:
        if (r141 == null) goto L469;
        boolean r142 = r141.booleanValue();
    L470:
        wg.a.h(r136, r142);
        if (tc3.f.f() == false) goto L518;
        View r143 = r38.H;
        if (r143 == null) goto L476;
        ViewGroup.LayoutParams r144 = r143.getLayoutParams();
    L478:
        if ((r144 instanceof ViewGroup.MarginLayoutParams) == true) goto L480;
        r144 = null;
    L480:
        ViewGroup.MarginLayoutParams r145 = (ViewGroup.MarginLayoutParams) r144;
        ViewGroup.LayoutParams r146 = r38.getLayoutParams();
        if ((r146 instanceof ViewGroup.MarginLayoutParams) == true) goto L483;
        r146 = null;
    L483:
        ViewGroup.MarginLayoutParams r147 = (ViewGroup.MarginLayoutParams) r146;
        if (com.bytedance.android.shopping.deepfeed.utlis.g.d(r1) == true) goto L518;
        Intrinsics.checkNotNullParameter(r1, "$this$isShowSearchBar");
        InFeedProductPackData r148 = r1.getPackData();
        if (r148 == null) goto L503;
        InFeedProductPackDataElements r149 = r148.getElements();
        if (r149 == null) goto L503;
        List<p0> r150 = r149.getProducts();
        if (r150 == null) goto L503;
        p0 r151 = (p0) CollectionsKt.firstOrNull(r150);
        if (r151 == null) goto L503;
        w1 r152 = r151.o();
        if (r152 == null) goto L503;
        List<x1> r153 = r152.a();
        if (r153 == null) goto L503;
        x1 r154 = (x1) CollectionsKt.firstOrNull(r153);
        if (r154 == null) goto L503;
        String r155 = r154.a();
        if (r155 == null) goto L503;
        boolean r156 = com.bytedance.forest.utils.h.a(r155);
    L504:
        if (r156 == true) goto L506;
    L512:
        if (r145 == null) goto L514;
        r145.height = com.bytedance.android.shopping.extensions.b.b(130);
    L514:
        View r157 = r38.H;
        if (r157 == null) goto L518;
        r157.setTranslationY(com.bytedance.android.shopping.extensions.b.b(20));
        goto L518
    L506:
        if (tc3.f.f() == false) goto L512;
        if (r145 == null) goto L509;
        r145.height = com.bytedance.android.shopping.extensions.b.b(180);
    L509:
        View r158 = r38.H;
        if (r158 == null) goto L518;
        r158.setTranslationY(com.bytedance.android.shopping.extensions.b.b(50));
    L503:
        r156 = false;
        goto L504
    L476:
        r144 = null;
        goto L478
    L469:
        r142 = false;
    L466:
        r141 = null;
        goto L467
    L446:
        r107 = false;
    L449:
        r108 = false;
        goto L450
    L438:
        if (((ArrayList) r105).isEmpty() == false) goto L440;
    L452:
        r109 = false;
        goto L453
    L429:
        ConstraintLayout r159 = r38.w;
        if (r159 == null) goto L432;
        r159.setVisibility(8);
    L432:
        r38.z = false;
        goto L433
    L413:
        if (tc3.f.f() == true) goto L419;
        if (com.bytedance.android.shopping.deepfeed.utlis.g.c(r1) == true) goto L419;
        if (r38.h() == true) goto L419;
        r101 = true;
    L409:
        r100 = null;
        goto L411
    L331:
        if (r81 == 3) goto L351;
        ProductCardProgressIndicator r160 = r38.b;
        if (r160 == null) goto L335;
        r160.setup(r71);
    L335:
        ProductCardProgressIndicator r161 = r38.b;
        if (r161 == null) goto L338;
        r161.setFillCurrent(false);
    L338:
        ProductCardProgressIndicator r162 = r38.b;
        if (r162 != null) goto L341;
    L345:
        VideoCoverLayout r163 = r38.d;
        if (r163 == null) goto L348;
        r163.setVisibility(8);
    L348:
        FrameLayout r164 = r38.c;
        if (r164 == null) goto L375;
        r164.setVisibility(0);
        goto L375
    L341:
        if (r38.i == false) goto L343;
        float r165 = 1.0f;
    L344:
        r162.b(0, r165);
        goto L345
    L343:
        r165 = 0.0f;
        goto L344
    L351:
        r38.i = true;
        VideoCoverLayout r166 = r38.d;
        if (r166 == null) goto L354;
        r166.setVisibility(0);
    L354:
        FrameLayout r167 = r38.c;
        if (r167 == null) goto L357;
        r167.setVisibility(8);
    L357:
        VideoCoverLayout r168 = r38.d;
        if (r168 == null) goto L375;
        r168.c(HeaderBannerItemType.VideoAndImage, r71);
        goto L375
    L369:
        FrameLayout r169 = r38.c;
        if (r169 == null) goto L372;
        r169.setVisibility(8);
    L372:
        VideoCoverLayout r170 = r38.d;
        if (r170 == null) goto L375;
        r170.setVisibility(8);
        goto L375
    L325:
        r80 = HeaderBannerItemType.VideoAndImage;
        goto L327
    L326:
        r79 = 1;
        r80 = HeaderBannerItemType.Image;
        goto L327
    L317:
        r77 = false;
    L320:
        r78 = false;
        goto L321
    L309:
        if (r75.isEmpty() == false) goto L311;
    L279:
        if (r38.M == false) goto L283;
        DeepFeedProductHeaderTabLayout r171 = r38.y;
        if (r171 == null) goto L283;
        r171.setVisibility(0);
    L283:
        FrameLayout r172 = r38.c;
        if (r172 == null) goto L287;
        r172.setVisibility(8);
    L287:
        if (r38.e() == true) goto L289;
    L293:
        VideoCoverLayout r173 = r38.d;
        if (r173 == null) goto L297;
        r173.setVisibility(8);
    L297:
        if (r38.c() == false) goto L375;
        r38.e.c();
        goto L375
    L289:
        if (r38.M == false) goto L293;
        VideoCoverLayout r174 = r38.d;
        if (r174 == null) goto L297;
        r174.c(HeaderBannerItemType.CoverVideo, 0);
        goto L297
    L273:
        if (r38.h() == false) goto L275;
        r70 = true;
        goto L276
    L262:
        r53 = 8;
        View r175 = r38.H;
        if (r175 == null) goto L266;
        r175.setVisibility(0);
        goto L266
    L231:
        if (r35.intValue() != 0) goto L236;
        if ((!Intrinsics.areEqual(r0, r38.G)) == true) goto L236;
        r133 = false;
        goto L238
    L147:
        InFeedProductPackData r176 = r1.getPackData();
        if (r176 == null) goto L154;
        InFeedProductPackDataElements r177 = r176.getElements();
        if (r177 == null) goto L154;
        List<p0> r178 = r177.getProducts();
        if (r178 == null) goto L154;
        p0 r179 = (p0) CollectionsKt.firstOrNull(r178);
    L155:
        if (r179 == null) goto L163;
        m1 r180 = r179.i();
        if (r180 == null) goto L163;
        he3.m r181 = r180.a();
        if (r181 == null) goto L163;
        he3.s r182 = r181.c();
        if (r182 == null) goto L163;
        List<o0> r183 = r182.a();
    L164:
        if (r35 != null) goto L167;
    L207:
        r131 = r125;
    L206:
        r111 = "deepFeedContext";
    L208:
        boolean r184 = false;
    L209:
        if (r184 == false) goto L213;
        r0 = r38.G;
        if (r0 != null) goto L225;
        r0 = CollectionsKt.emptyList();
        goto L225
    L213:
        if (r179 == null) goto L217;
        k1 r185 = r179.g();
        if (r185 == null) goto L217;
        List<e2> r186 = r185.c();
    L218:
        r38.D = r186;
        if (r179 == null) goto L223;
        k1 r187 = r179.g();
        if (r187 == null) goto L223;
        List<InFeedUrlModel> r188 = r187.b();
    L224:
        r38.E = r188;
        r38.F = r183;
        Set<String> r189 = DeepFeedProductHeaderView.H0;
        r0 = DeepFeedProductHeaderView.a.c(r1, false);
    L223:
        r188 = null;
    L217:
        r186 = null;
        goto L218
    L167:
        if (r35.intValue() != 0) goto L207;
        r131 = r125;
        if (r38.G == null) goto L206;
        List<o0> r190 = r183;
        if (r190 != null) goto L173;
    L176:
        boolean r191 = true;
    L177:
        if (r191 == true) goto L179;
        r184 = Intrinsics.areEqual(r183, r38.F);
        r111 = "deepFeedContext";
        goto L209
    L179:
        if (r179 == null) goto L183;
        k1 r192 = r179.g();
        if (r192 == null) goto L183;
        List<e2> r193 = r192.c();
    L184:
        if (r193 == null) goto L192;
        k1 r194 = r179.g();
        if (r194 == null) goto L188;
        List<e2> r195 = r194.c();
    L190:
        if (Intrinsics.areEqual(r195, r38.D) == false) goto L193;
    L205:
        r184 = true;
    L193:
        if (r179 == null) goto L197;
        k1 r196 = r179.g();
        if (r196 == null) goto L197;
        List<InFeedUrlModel> r197 = r196.b();
    L198:
        if (r197 == null) goto L208;
        k1 r198 = r179.g();
        if (r198 == null) goto L202;
        List<InFeedUrlModel> r199 = r198.b();
    L204:
        if (Intrinsics.areEqual(r199, r38.E) == false) goto L208;
    L202:
        r199 = null;
    L197:
        r197 = null;
        goto L198
    L188:
        r195 = null;
        goto L190
    L192:
        r111 = "deepFeedContext";
    L183:
        r193 = null;
        goto L184
    L173:
        if (r190.isEmpty() == true) goto L176;
        r191 = false;
    L163:
        r183 = null;
    L154:
        r179 = null;
        goto L155
    L140:
        VideoCoverLayout r1100 = r36.c;
        if (r1100 == null) goto L143;
        d2.d(r1100, 0, 0, 0, com.bytedance.android.shopping.extensions.b.b(12));
    L134:
        r122 = null;
        goto L136
    L88:
        if (tc3.f.f() == false) goto L117;
        Intrinsics.checkNotNullParameter(r1, "$this$hasSearch");
        InFeedProductPackData r1101 = r1.getPackData();
        if (r1101 == null) goto L104;
        InFeedProductPackDataElements r1102 = r1101.getElements();
        if (r1102 == null) goto L104;
        List<p0> r1103 = r1102.getProducts();
        if (r1103 == null) goto L104;
        p0 r1104 = (p0) CollectionsKt.firstOrNull(r1103);
        if (r1104 == null) goto L104;
        w1 r1105 = r1104.o();
        if (r1105 == null) goto L104;
        List<x1> r1106 = r1105.a();
        if (r1106 == null) goto L104;
        x1 r1107 = (x1) CollectionsKt.firstOrNull(r1106);
        if (r1107 == null) goto L104;
        String r1108 = r1107.a();
    L105:
        if (r1108 != null) goto L107;
    L110:
        boolean r1109 = true;
    L112:
        if ((!r1109) == false) goto L117;
        VideoCoverLayout r1110 = r36.c;
        if (r1110 == null) goto L116;
        d2.d(r1110, 0, 0, 0, com.bytedance.android.shopping.extensions.b.b(40));
    L116:
        d2.d(r36.b, com.bytedance.android.shopping.extensions.b.b(12), 0, com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(40));
        DeepFeedProductHeaderTabLayout r200 = r36.f;
        r200.b(com.bytedance.android.shopping.extensions.b.b(48), r200.b.size());
        goto L144
    L107:
        if (r1108.length() == 0) goto L110;
        r1109 = false;
    L104:
        r1108 = null;
        goto L105
    L77:
        if (r112.isEmpty() == true) goto L80;
        r113 = false;
        goto L81
    L47:
        r28 = null;
    L40:
        InFeedProductV2 r201 = this.m;
        if (r201 != null) goto L43;
    L49:
        r29 = false;
        goto L50
    L43:
        if (r201.isSkeletonData() != true) goto L49;
    L31:
        r18 = null;
    L15:
        r10 = null;
        goto L16
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public final void c4(int r3) {
        InFeedProductV2 r0 = this.m;
        if (r0 == null) goto L21;
        re3.a r1 = this.p0.get(r0);
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.e == false) goto L17;
        DeepFeedProductBannerAdapter r2 = this.k0.getHeaderView().f;
        if (r2 == null) goto L23;
        RecyclerView.ViewHolder r4 = r2.a;
        if ((r4 instanceof AbstractDeepFeedBannerVH) == true) goto L13;
        r4 = null;
    L13:
        AbstractDeepFeedBannerVH r5 = (AbstractDeepFeedBannerVH) r4;
        if (r5 == null) goto L24;
        r5.T3(r3);
        return;
    L24:
        return;
    L23:
        return;
    L17:
        if (getAdapterPosition() != 4) goto L26;
        if (r3 >= 0) goto L27;
        EventBus.getDefault().post(new ge3.a(true));
        return;
    L27:
        return;
    L26:
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public final void n4(boolean r2) {
        if (this.k0.getHeaderView().e() == false) goto L6;
        super.n4(r2);
        this.k0.getHeaderView().setMute(r2);
        this.k0.getHeaderView().d(r2);
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r12) {
        if (m4() == false) goto L5;
        return;
    L5:
        getAdapterPosition();
        this.L0.c();
        if (Intrinsics.areEqual(r12, this.k0.getHeaderView().getMuteIcon()) == false) goto L9;
        n4(false);
    L23:
        InFeedProductV2 r13 = this.m;
        if (r13 == null) goto L36;
        InFeedProductPackData r14 = r13.getPackData();
        if (r14 == null) goto L36;
        InFeedProductPackDataElements r15 = r14.getElements();
        if (r15 == null) goto L36;
        List<p0> r16 = r15.getProducts();
        if (r16 == null) goto L36;
        p0 r17 = (p0) CollectionsKt.firstOrNull(r16);
        if (r17 == null) goto L36;
        e1 r18 = r17.b();
        if (r18 == null) goto L36;
        String r19 = r18.a();
    L37:
        DeepFeedQueryParam r0 = i4().getFeedParam();
        if (r0 == null) goto L41;
        r0.appendInnerAction(r19);
        return;
    L41:
        return;
    L36:
        r19 = null;
        goto L37
    L9:
        if (Intrinsics.areEqual(r12, this.k0.getHeaderView().getUnmuteIcon()) == false) goto L12;
        n4(true);
        goto L23
    L12:
        if (Intrinsics.areEqual(r12, this.k0.getHeaderView().getSearchContainer()) == false) goto L15;
        i4().clickSearch(this.m, this.v, this.k0, this.n);
        goto L23
    L15:
        if (Intrinsics.areEqual(r12, this.k0.getInfoView().getExtraView()) == false) goto L18;
        DeepFeedProductViewModel.clickProductCard$default(i4(), this.m, "价格", this.q, this.k0, this.n, null, null, 96, null);
        goto L23
    L18:
        if (Intrinsics.areEqual(r12, this.k0.getAbilityView().getAbilityBuyAndCart().getAbilityAddCart()) == false) goto L21;
        i4().clickAddCart(this.m, this.k0.getAbilityView().getAbilityBuyAndCart().getAbilityAddCart(), this.E, this.F, this.s, this.n);
        goto L23
    L21:
        if (Intrinsics.areEqual(r12, this.k0.getAbilityView().getAbilityBuyAndCart().getAbilityBuy()) == false) goto L23;
        i4().clickBuy(this.m, this.E, this.F, this.D, this.t, this.k0, this.n);
        goto L23
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r5) {
        if (m4() == false) goto L5;
        return false;
    L5:
        getAdapterPosition();
        this.L0.c();
        if (Intrinsics.areEqual(r5, this.k0.getInfoView().getMaskTitle()) == false) goto L8;
        String r6 = "title";
    L9:
        i4().longPress(this.m, r6, this.n);
        return false;
    L8:
        r6 = "other";
        goto L9
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public final void s4(String r3) {
        Intrinsics.checkNotNullParameter(r3, "finishMethod");
        DeepFeedProductHeaderView r1 = this.k0.getHeaderView();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "finishMethod");
        r1.k(r3);
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public final void u4(boolean r17) {
        this.o = r17;
        RecyclerView.ViewHolder r2 = null;
        if (r17 == true) goto L5;
    L189:
        if (r17 == false) goto L191;
        return;
    L191:
        if (this.k0.getHeaderView().e() == true) goto L193;
        DeepFeedProductHeaderView r1 = this.k0.getHeaderView();
        r1.k = 0;
        r1.a.scrollToPosition(0);
        r1.post(new com.bytedance.android.shopping.deepfeed.weights.g(r1, false));
    L193:
        this.k0.getHeaderView().e.c();
        InFeedProductV2 r3 = this.m;
        if (r3 == null) goto L203;
        re3.a r4 = this.p0.get(r3);
        if (r4 == null) goto L198;
        r4.a = false;
    L198:
        this.k0.getHeaderView().setIgnoreAnimCall(false);
        DeepFeedProductBannerAdapter r5 = this.k0.getHeaderView().getBannerAdapter();
        if (r5 == null) goto L201;
        r5.r = false;
    L201:
        this.k0.getHeaderView().getOverScrollSnapHelper().c = false;
        ie3.b.a("show_over", "");
    L203:
        if (this.k0.getHeaderView().e() == false) goto L205;
        this.k0.getHeaderView().n(PageScrollStatus.slide);
    L205:
        DeepFeedProductBannerAdapter r6 = this.k0.getHeaderView().getBannerAdapter();
        if (r6 == null) goto L222;
        RecyclerView.ViewHolder r7 = r6.a;
        if ((r7 instanceof DeepFeedProductBannerVideoVH) == false) goto L211;
        r2 = r7;
    L211:
        DeepFeedProductBannerVideoVH r8 = (DeepFeedProductBannerVideoVH) r2;
        if (r8 == null) goto L223;
        r8.V3();
        return;
    L223:
        return;
    L222:
        return;
    L5:
        if (this.R == true) goto L10;
        this.R = true;
        Function0<Unit> r9 = this.M;
        if (r9 == null) goto L10;
        Unit r10 = (Unit) r9.invoke();
    L10:
        if (this.Y == false) goto L12;
        Z1();
    L12:
        i4().onFocusInFeedProductChange(this.m);
        InFeedProductV2 r11 = this.m;
        if (r11 == null) goto L38;
        re3.a r12 = this.p0.get(r11);
        if (this.k0.getHeaderView().e() == false) goto L17;
        DeepFeedProductHeaderView r13 = this.k0.getHeaderView();
        r13.k = 0;
        r13.a.scrollToPosition(0);
        r13.post(new com.bytedance.android.shopping.deepfeed.weights.g(r13, true));
        r13.a.post(new com.bytedance.android.shopping.deepfeed.weights.k(r13));
    L30:
        if (r12 == null) goto L38;
        if (r12.e == false) goto L34;
        r12.d = false;
    L34:
        DeepFeedProductHeaderView r14 = this.k0.getHeaderView();
        boolean r15 = r12.e;
        boolean r16 = r12.d;
        DeepFeedProductBannerAdapter r18 = r14.f;
        if (r18 == null) goto L38;
        r18.h = r15;
        r18.i = r16;
        goto L38
    L17:
        if (r12 != null) goto L19;
    L21:
        boolean r19 = false;
    L22:
        ProductCardProgressIndicator r20 = this.k0.getHeaderView().getProgressIndicator();
        if (r20 == null) goto L25;
        r20.setFillCurrent(false);
    L25:
        ProductCardProgressIndicator r21 = this.k0.getHeaderView().getProgressIndicator();
        if (r21 == null) goto L28;
        r21.b(0, 0.0f);
    L28:
        if (r19 == false) goto L30;
        this.k0.getHeaderView().m();
        goto L30
    L19:
        if (r12.a == true) goto L21;
        r19 = true;
    L38:
        if (this.k0.getHeaderView().e() == false) goto L40;
        this.k0.getHeaderView().setMute(com.bytedance.android.shopping.deepfeed.utlis.f.b);
        this.k0.getHeaderView().d(com.bytedance.android.shopping.deepfeed.utlis.f.b);
    L40:
        InFeedProductV2 r22 = this.m;
        if (r22 == null) goto L49;
        InFeedProductPackData r23 = r22.getPackData();
        if (r23 == null) goto L49;
        InFeedProductPackDataElements r24 = r23.getElements();
        if (r24 == null) goto L49;
        List<p0> r25 = r24.getProducts();
        if (r25 == null) goto L49;
        p0 r26 = (p0) CollectionsKt.firstOrNull(r25);
    L50:
        if (r26 == null) goto L58;
        m1 r27 = r26.i();
        if (r27 == null) goto L58;
        he3.m r28 = r27.a();
        if (r28 == null) goto L58;
        he3.r r29 = r28.b();
        if (r29 == null) goto L58;
        Boolean r30 = r29.g();
    L60:
        if (Intrinsics.areEqual(r30, Boolean.TRUE) == false) goto L70;
        m1 r31 = r26.i();
        if (r31 == null) goto L68;
        he3.m r32 = r31.a();
        if (r32 == null) goto L68;
        he3.r r33 = r32.b();
        if (r33 == null) goto L68;
        String r34 = r33.e();
    L69:
        String r110 = r34;
    L71:
        if (r26 == null) goto L86;
        r0 r35 = r26.p();
        if (r35 == null) goto L86;
        k2 r36 = r35.a();
        if (r36 == null) goto L86;
        com.bytedance.android.shopping.deepfeed.action.h r111 = this.L0;
        InFeedProductV2 r37 = this.m;
        DeepFeedProductView r38 = this.k0;
        String r39 = this.u;
        List<String> r112 = this.n;
        ECUrlModel r113 = r36.b();
        String r40 = r36.c();
        m1 r41 = r26.i();
        if (r41 == null) goto L83;
        he3.m r42 = r41.a();
        if (r42 == null) goto L83;
        he3.r r43 = r42.b();
        if (r43 == null) goto L83;
        String r114 = r43.f();
    L84:
        r111.r(new com.bytedance.android.shopping.deepfeed.viewmodel.e(r37, r38, r39, r112, r113, r114, r110, r40));
    L83:
        r114 = null;
    L86:
        if (m4() == true) goto L184;
        j4();
        DeepFeedProductEventTracker r44 = i4().getEventTracker();
        if (r44 == null) goto L98;
        InFeedProductV2 r45 = this.m;
        if (r45 != null) goto L92;
    L95:
        boolean r46 = false;
    L96:
        if (r46 == true) goto L98;
    L182:
        int r47 = ie3.b.a;
        ie3.b.a("show", "");
        Intrinsics.checkNotNullParameter(new DeepFeedProductVH$setUserVisibleChanged$3(this), "isSuccess");
        goto L184
    L92:
        if (r44.a.contains(r45) == true) goto L95;
        r44.a.add(r45);
        r46 = true;
    L98:
        Integer r48 = i4().findReportCardIndex(this.m);
        if (r48 == null) goto L182;
        int r49 = r48.intValue();
        this.L0.j();
        if (Intrinsics.areEqual(null, this.k0) == false) goto L106;
        DeepFeedProductEventTracker r50 = i4().getEventTracker();
        if (r50 == null) goto L106;
        InFeedProductV2 r51 = this.m;
        String r52 = this.u;
        ConstraintLayout r53 = this.k0;
        int r54 = DeepFeedProductEventTracker.d;
        r50.A(r49, r51, r52, r53, null, null);
    L106:
        if (kd3.a.a(this.k0.getHeaderView().getSearchContainer()) == false) goto L113;
        DeepFeedProductEventTracker r55 = i4().getEventTracker();
        if (r55 == null) goto L113;
        InFeedProductV2 r56 = this.m;
        String r57 = this.v;
        ConstraintLayout r58 = this.k0;
        DeepFeedQueryParam r59 = i4().getFeedParam();
        int r115 = DeepFeedProductEventTracker.d;
        Intrinsics.checkNotNullParameter(r58, FreqActions.ACTION_VIEW);
        Map<String, ? extends Object> r60 = DeepFeedProductEventTracker.e(r49, r56, r59);
        if (r60 == null) goto L113;
        DeepFeedProductEventTracker.c(r60, null);
        le3.b.a(r60, r57, r58);
        r55.doEventAction("trending_words_show", r60);
    L113:
        DeepFeedProductAbilityView r61 = this.k0.getAbilityView();
        ConstraintLayout r62 = r61.b;
        if (r62 != null) goto L116;
    L119:
        r61.getClass();
        boolean r63 = false;
    L120:
        if (r63 == false) goto L124;
        DeepFeedProductEventTracker r64 = i4().getEventTracker();
        if (r64 == null) goto L124;
        InFeedProductV2 r65 = this.m;
        String r66 = this.w;
        ConstraintLayout r67 = this.k0;
        int r68 = DeepFeedProductEventTracker.d;
        r64.B(r49, r65, r66, r67, null, null);
    L124:
        DeepFeedProductAbilityView r69 = this.k0.getAbilityView();
        DeepFeedAbilityComment r70 = r69.a;
        if (r70 != null) goto L127;
    L130:
        r69.getClass();
        boolean r71 = false;
    L131:
        if (r71 == false) goto L136;
        DeepFeedProductEventTracker r72 = i4().getEventTracker();
        if (r72 == null) goto L136;
        InFeedProductV2 r73 = this.m;
        String r74 = this.x;
        ConstraintLayout r75 = this.k0;
        int r76 = DeepFeedProductEventTracker.d;
        r72.y(r49, r73, r74, r75, null, null);
    L136:
        if (kd3.a.a(this.k0.getAbilityView().getAbilityBuyAndCart().getAbilityAddCart()) == false) goto L141;
        DeepFeedProductEventTracker r77 = i4().getEventTracker();
        if (r77 == null) goto L141;
        InFeedProductV2 r78 = this.m;
        String r79 = this.s;
        ConstraintLayout r80 = this.k0;
        int r81 = DeepFeedProductEventTracker.d;
        r77.v(r49, r78, r79, r80, null, null);
    L141:
        if (kd3.a.a(this.k0.getAbilityView().getAbilityBuyAndCart().getAbilityBuy()) == false) goto L146;
        DeepFeedProductEventTracker r82 = i4().getEventTracker();
        if (r82 == null) goto L146;
        InFeedProductV2 r84 = this.m;
        String r85 = this.t;
        ConstraintLayout r86 = this.k0;
        int r87 = DeepFeedProductEventTracker.d;
        r82.w(r49, r84, r85, r86, null, null);
    L146:
        if ((!this.k0.getInfoView().getRecReasonTagList().isEmpty()) == false) goto L148;
        ((ArrayList) this.n).addAll(this.k0.getInfoView().getRecReasonTagList());
    L148:
        String r88 = this.k0.getInfoView().getMaskTitle().getTitleProductTag();
        if (r88 == null) goto L151;
        ((ArrayList) this.n).add(r88);
    L151:
        Iterator r89 = ((ArrayList) this.n).iterator();
    L153:
        if (r89.hasNext() == false) goto L157;
        String r116 = (String) r89.next();
        DeepFeedProductEventTracker r90 = i4().getEventTracker();
        if (r90 == null) goto L153;
        Integer r91 = Integer.valueOf(r49);
        InFeedProductV2 r92 = this.m;
        int r94 = DeepFeedProductEventTracker.d;
        r90.u(r91, r92, r116, null, null);
        goto L153
    L157:
        InFeedProductV2 r95 = this.m;
        if (r95 == null) goto L160;
        i4().onCardShow(r95);
    L160:
        DeepFeedProductEventTracker r96 = i4().getEventTracker();
        if (r96 == null) goto L164;
        InFeedProductV2 r97 = this.m;
        String r98 = this.q;
        DeepFeedProductView r99 = this.k0;
        List<String> r117 = this.n;
        int r100 = DeepFeedProductEventTracker.d;
        r96.z(r49, r97, r98, r99, r117, null);
    L164:
        if (this.k0.getHeaderView().M == false) goto L182;
        List<DeepFeedProductHeaderView.b> r101 = this.k0.getHeaderView().J;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L168:
        if (r103.hasNext() == false) goto L171;
        r102.add(((DeepFeedProductHeaderView.b) r103.next()).a);
        goto L168
    L171:
        if (r102.isEmpty() == true) goto L182;
        DeepFeedProductEventTracker r104 = i4().getEventTracker();
        if (r104 == null) goto L182;
        DeepFeedProductHeaderTabLayout r105 = this.k0.getHeaderView().y;
        if (r105 != null) goto L178;
    L180:
        String r106 = "long";
    L181:
        boolean r118 = this.k0.getHeaderView().L;
        Intrinsics.checkNotNullParameter(r106, "tabStyle");
        Intrinsics.checkNotNullParameter(r102, "tabNames");
        LinkedHashMap r119 = new LinkedHashMap();
        r119.put("tab_style", r106);
        r119.put("tab_count", Integer.valueOf(r102.size()));
        r119.put("tab_names", CollectionsKt.joinToString$default(r102, ",", null, null, 0, null, null, 62, null));
        r119.put("slide_auto", Integer.valueOf(r118 ? 1 : 0));
        r104.doEventAction("deep_feed_tab_show", r119);
        goto L182
    L178:
        if (r105.a() == false) goto L180;
        r106 = "short";
        goto L181
    L127:
        if (kd3.a.a(r70) != true) goto L130;
        r71 = true;
        goto L131
    L116:
        if (kd3.a.a(r62) != true) goto L119;
        r63 = true;
    L184:
        if (this.k0.getAiRecView().getVisibility() != 0) goto L187;
        this.k0.getAiRecView().R5();
    L187:
        if (this.k0.getCenterAiRecView().getVisibility() != 0) goto L189;
        this.k0.getCenterAiRecView().R5();
    L68:
        r34 = null;
        goto L69
    L70:
        r110 = null;
    L58:
        r30 = null;
    L49:
        r26 = null;
        goto L50
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    @Deprecated(message = "在 slice 场景不需要这个方法了")
    public final void w4(int r3) {
        DeepFeedProductBannerAdapter r0 = this.k0.getHeaderView().f;
        if (r0 == null) goto L11;
        RecyclerView.ViewHolder r1 = r0.a;
        if ((r1 instanceof AbstractDeepFeedBannerVH) == true) goto L7;
        r1 = null;
    L7:
        AbstractDeepFeedBannerVH r2 = (AbstractDeepFeedBannerVH) r1;
        if (r2 == null) goto L12;
        r2.U3(r3);
        return;
    L12:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.shopping.deepfeed.action.i
    public final void z1(final com.bytedance.android.shopping.deepfeed.action.a r19) {
        Intrinsics.checkNotNullParameter(r19, "click");
        if (m4() == false) goto L6;
        return;
    L6:
        if ((r19 instanceof com.bytedance.android.shopping.deepfeed.action.a.c) == false) goto L9;
        i4().clickComment(this.m, this.x, this.k0, this.n);
        return;
    L9:
        if ((r19 instanceof com.bytedance.android.shopping.deepfeed.action.a.b) == false) goto L12;
        i4().clickCollect(this.m, this.w, this.k0, this.n, null, new DeepFeedProductVH$onCardInnerClick$1(r19));
        return;
    L12:
        if ((r19 instanceof com.bytedance.android.shopping.deepfeed.action.a.f) == false) goto L15;
        i4().clickStore(this.m, this.u, this.k0, this.n);
        return;
    L15:
        if ((r19 instanceof com.bytedance.android.shopping.deepfeed.action.a.g) == false) goto L18;
        DeepFeedProductViewModel.clickProductCard$default(i4(), this.m, "标题", this.q, this.k0, this.n, this.B, null, 64, null);
        return;
    L18:
        if ((r19 instanceof com.bytedance.android.shopping.deepfeed.action.a.h) == false) goto L20;
        DeepFeedProductViewModel.clickProductCard$default(i4(), this.m, "详情", this.q, this.k0, this.n, this.A, null, 64, null);
        return;
    L20:
        Object r4 = null;
        if ((r19 instanceof com.bytedance.android.shopping.deepfeed.action.a.d) == false) goto L38;
        InFeedProductV2 r1 = this.m;
        if (r1 == null) goto L36;
        Intrinsics.checkNotNullParameter(r1, "$this$displayHasLive");
        p0 r2 = r1.cardData();
        if (r2 == null) goto L34;
        m1 r3 = r2.i();
        if (r3 == null) goto L34;
        he3.m r5 = r3.a();
        if (r5 == null) goto L34;
        he3.r r6 = r5.b();
        if (r6 == null) goto L34;
        r4 = r6.b();
    L34:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) != true) goto L36;
        i4().clickLiveInteraction(this.m, "缩略图", this.z, this.k0, this.n);
        DeepFeedProductViewModel.reportClickSmallImage$default(i4(), this.m, "缩略图", this.k0, this.n, null, 16, null);
        int r7 = ie3.b.a;
        ie3.b.a("realtime_click", "image");
        return;
    L36:
        DeepFeedProductViewModel.clickProductCard$default(i4(), this.m, "缩略图", this.q, this.k0, this.n, this.z, null, 64, null);
        return;
    L38:
        if ((r19 instanceof com.bytedance.android.shopping.deepfeed.action.a.i) == false) goto L41;
        i4().seekVideoProgress(this.m, this.n);
        return;
    L41:
        if ((r19 instanceof com.bytedance.android.shopping.deepfeed.action.a.e) == false) goto L44;
        i4().clickSearch(this.m, this.v, this.k0, this.n);
        return;
    L44:
        if ((r19 instanceof com.bytedance.android.shopping.deepfeed.action.a.C0049a) == true) goto L46;
        return;
    L46:
        if (getAdapterPosition() != (i4().curNoFullScreenCount() - 1)) goto L49;
        i4().addNoFullScreenCount();
    L49:
        if (getAdapterPosition() < i4().curNoFullScreenCount()) goto L51;
        boolean r9 = true;
    L52:
        InFeedProductV2 r8 = this.m;
        if (r8 == null) goto L57;
        he3.v r10 = r8.getDynamicData();
        if (r10 == null) goto L57;
        r10.j = true;
    L57:
        DeepFeedProductEventTracker r11 = i4().getEventTracker();
        if (r11 == null) goto L60;
        int r12 = getAdapterPosition();
        InFeedProductV2 r13 = this.m;
        List<String> r14 = this.n;
        String r15 = ((com.bytedance.android.shopping.deepfeed.action.a.C0049a) r19).a;
        Intrinsics.checkNotNullParameter(r14, "productTagsList");
        Intrinsics.checkNotNullParameter(r15, "queryClick");
        Map<String, Object> r16 = r11.g(r12, r13, r14);
        r16.put("query_click", r15);
        r11.doEventAction("deep_feed_ai_click", r16);
    L60:
        com.bytedance.android.shopping.deepfeed.action.a.C0049a r17 = (com.bytedance.android.shopping.deepfeed.action.a.C0049a) r19;
        if (r17.c == false) goto L87;
        String r18 = UUID.randomUUID().toString();
        i4().insertCard(getAdapterPosition() + 1, r17.a, r18);
        com.bytedance.android.shopping.deepfeed.data.repo.l r20 = i4().getResp();
        if (r20 == null) goto L132;
        String r21 = r17.a;
        List<String> r22 = r17.b;
        Integer r110 = Integer.valueOf(getAdapterPosition() + 1);
        InFeedProductV2 r23 = this.m;
        if (r23 == null) goto L69;
        z0 r24 = r23.getRespExtra();
        if (r24 == null) goto L69;
        r4 = r24.b();
    L69:
        Integer r111 = r4;
        InFeedProductV2 r25 = this.m;
        if (r25 == null) goto L85;
        InFeedProductPackData r26 = r25.getPackData();
        if (r26 == null) goto L85;
        InFeedProductPackDataElements r27 = r26.getElements();
        if (r27 == null) goto L85;
        List<p0> r28 = r27.getProducts();
        if (r28 == null) goto L85;
        p0 r29 = (p0) CollectionsKt.firstOrNull(r28);
        if (r29 == null) goto L85;
        e1 r30 = r29.b();
        if (r30 == null) goto L85;
        String r31 = r30.a();
        if (r31 == null) goto L85;
        String r112 = r31;
    L86:
        com.bytedance.android.shopping.deepfeed.data.repo.l.d(r20, new com.bytedance.android.shopping.deepfeed.data.repo.n(r21, r22, null, r9, r110, r111, r18, r112));
        return;
    L85:
        r112 = "";
        goto L86
    L132:
        return;
    L87:
        com.bytedance.android.shopping.deepfeed.data.repo.l r32 = i4().getResp();
        if (r32 == null) goto L134;
        String r33 = r17.a;
        List<String> r34 = r17.b;
        Integer r35 = Integer.valueOf(getAdapterPosition() + 1);
        InFeedProductV2 r36 = this.m;
        if (r36 == null) goto L94;
        z0 r37 = r36.getRespExtra();
        if (r37 == null) goto L94;
        r4 = r37.b();
    L94:
        Integer r113 = r4;
        InFeedProductV2 r38 = this.m;
        if (r38 == null) goto L102;
        he3.v r39 = r38.getDynamicData();
        if (r39 == null) goto L102;
        String r40 = r39.l;
        if (r40 == null) goto L102;
        String r114 = r40;
    L103:
        InFeedProductV2 r41 = this.m;
        if (r41 == null) goto L119;
        InFeedProductPackData r42 = r41.getPackData();
        if (r42 == null) goto L119;
        InFeedProductPackDataElements r43 = r42.getElements();
        if (r43 == null) goto L119;
        List<p0> r44 = r43.getProducts();
        if (r44 == null) goto L119;
        p0 r45 = (p0) CollectionsKt.firstOrNull(r44);
        if (r45 == null) goto L119;
        e1 r46 = r45.b();
        if (r46 == null) goto L119;
        String r47 = r46.a();
        if (r47 == null) goto L119;
        String r115 = r47;
    L120:
        com.bytedance.android.shopping.deepfeed.data.repo.l.d(r32, new com.bytedance.android.shopping.deepfeed.data.repo.n(r33, r34, r35, r9, null, r113, r114, r115));
        return;
    L119:
        r115 = "";
    L102:
        r114 = "";
        goto L103
    L134:
        return;
    L51:
        r9 = false;
        goto L52
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public final void y4(he3.l r4, com.bytedance.android.shopping.deepfeed.action.h r5) {
        Intrinsics.checkNotNullParameter(r4, "couponResp");
        Intrinsics.checkNotNullParameter(r5, "dfContext");
        InFeedProductV2 r0 = this.m;
        if (r0 == null) goto L6;
        r0.getDynamicData().d = r4;
        DeepFeedProductInfoView r6 = this.k0.getInfoView();
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, "inFeedProduct");
        Intrinsics.checkNotNullParameter(r5, "dpContext");
        DeepFeedProductInfoExtraView r7 = r6.b;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r0, "product");
        Intrinsics.checkNotNullParameter(r5, "dpContext");
        r7.Y5(r0, r5, true);
        return;
    }

    public final void B4(InFeedProductV2 r4, InFeedProductV2 r5, re3.a r6) {
        if (this.o == false) goto L12;
        if (r4 == null) goto L12;
        if (r4.isCacheData() != true) goto L12;
        if (r5.isCacheData() == true) goto L12;
        if (this.k0.getHeaderView().M == false) goto L12;
        boolean r7 = true;
    L13:
        if (r7 == true) goto L16;
        return;
    L16:
        if (this.k0.getHeaderView().e() == false) goto L20;
        DeepFeedProductHeaderView r8 = this.k0.getHeaderView();
        r8.k = 0;
        r8.a.scrollToPosition(0);
        r8.post(new com.bytedance.android.shopping.deepfeed.weights.g(r8, true));
        r8.a.post(new com.bytedance.android.shopping.deepfeed.weights.k(r8));
        return;
    L20:
        if ((!r6.a) == false) goto L23;
        this.k0.getHeaderView().m();
        return;
    L23:
        return;
    L12:
        r7 = false;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DeepFeedProductVH(LifecycleOwner r9, DeepFeedProductView r10, HashMap<InFeedProductV2, re3.a> r11, com.bytedance.android.ec.core.imagex.r r12, com.bytedance.android.shopping.deepfeed.action.h r13) {
        Intrinsics.checkNotNullParameter(r9, "owner");
        Intrinsics.checkNotNullParameter(r10, "inFeedProductView");
        Intrinsics.checkNotNullParameter(r11, "productViewsStatusMap");
        Intrinsics.checkNotNullParameter(r12, "imageCallerContext");
        Intrinsics.checkNotNullParameter(r13, "deepFeedContext");
        super(r9, r10, r13);
        this.Z = r9;
        this.k0 = r10;
        this.p0 = r11;
        this.H0 = r12;
        this.L0 = r13;
        this.S = true;
        View.OnClickListener r14 = new DeepFeedProductVH$bannerImageClickListener$1(this);
        b r15 = new b(this);
        Function1<DeepFeedCommentClickArea, Unit> r0 = new DeepFeedProductVH$bannerCommentClickListener$1(this);
        this.T = r0;
        d r1 = new d(this);
        Function0<Unit> r2 = new DeepFeedProductVH$bannerCommentShowListener$1(this);
        this.U = r2;
        Function2<Integer, String, Unit> r3 = new DeepFeedProductVH$bannerTabClickListener$1(this);
        this.V = r3;
        Function2<Integer, String, Unit> r4 = new DeepFeedProductVH$bannerTabSlideListener$1(this);
        this.W = r4;
        c r5 = new c(this);
        this.X = new e(this);
        r10.setOnClickListener(this);
        r10.setBackgroundColor(-16777216);
        ConstraintLayout r6 = r10.getHeaderView().getSearchContainer();
        if (r6 == null) goto L5;
        r6.setOnClickListener(this);
    L5:
        DeepFeedProductHeaderView r7 = r10.getHeaderView();
        r7.getClass();
        Intrinsics.checkNotNullParameter(r1, "selectListener");
        Intrinsics.checkNotNullParameter(r14, "imageClickListener");
        Intrinsics.checkNotNullParameter(r0, "commentClickListener");
        Intrinsics.checkNotNullParameter(r2, "commentShowListener");
        Intrinsics.checkNotNullParameter(r3, "tabClickListener");
        Intrinsics.checkNotNullParameter(r4, "tabSlideListener");
        Intrinsics.checkNotNullParameter(r5, "overScrollListener");
        Intrinsics.checkNotNullParameter(r15, "longPressListener");
        r7.l = r1;
        r7.m = r14;
        r7.n = r0;
        r7.o = r2;
        r7.p = r3;
        r7.q = r4;
        r7.g.a = r5;
        r7.r = r15;
        r10.getHeaderView().getMuteIcon().setOnClickListener(this);
        r10.getHeaderView().getUnmuteIcon().setOnClickListener(this);
        r10.getInfoView().getExtraView().setOnClickListener(this);
        r10.getAbilityView().getAbilityBuyAndCart().getAbilityAddCart().setOnClickListener(this);
        r10.getAbilityView().getAbilityBuyAndCart().getAbilityBuy().setOnClickListener(this);
        r10.setLongClickable(true);
        r10.setOnLongClickListener(this);
        r10.getSearchBarView().setLongClickable(true);
        r10.getSearchBarView().setOnLongClickListener(this);
        r10.getInfoView().getMaskTitle().setLongClickable(true);
        r10.getInfoView().getMaskTitle().setOnLongClickListener(this);
        r10.getInfoView().getExtraView().setLongClickable(true);
        r10.getInfoView().getExtraView().setOnLongClickListener(this);
        SimpleDraweeView r16 = r10.getInfoView().getDisplayImage();
        if (r16 == null) goto L8;
        r16.setLongClickable(true);
    L8:
        SimpleDraweeView r17 = r10.getInfoView().getDisplayImage();
        if (r17 == null) goto L11;
        r17.setOnLongClickListener(this);
    L11:
        SimpleDraweeView r18 = r10.getInfoView().getDisplayImageDanceImage();
        if (r18 == null) goto L14;
        r18.setLongClickable(true);
    L14:
        SimpleDraweeView r19 = r10.getInfoView().getDisplayImageDanceImage();
        if (r19 == null) goto L17;
        r19.setOnLongClickListener(this);
    L17:
        Intrinsics.checkNotNullParameter(r13, "ctx");
        r10.l = r13;
    }
}
