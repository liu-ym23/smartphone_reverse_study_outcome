package com.bytedance.android.shopping.feed.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cf.p;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.legacy.AbsFragment;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.core.utils.n1;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.anchorv3.repository.dto.InnerFlowPageStyleDTO;
import com.bytedance.android.shopping.anchorv3.repository.dto.PageStyle;
import com.bytedance.android.shopping.api.PageDestroyTypeEvent;
import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import com.bytedance.android.shopping.api.anchorv3.ECUIParam;
import com.bytedance.android.shopping.buynow.data.model.PageScrollStatus;
import com.bytedance.android.shopping.feed.event.y;
import com.bytedance.android.shopping.feed.utils.d0;
import com.bytedance.android.shopping.feed.view.CouponView;
import com.bytedance.android.shopping.feed.view.InnerFeedPageHeadWidget;
import com.bytedance.android.shopping.feed.view.InnerFeedPageRightWidget;
import com.bytedance.android.shopping.feed.view.m;
import com.bytedance.android.shopping.feed.view.n;
import com.bytedance.android.shopping.feed.view.o;
import com.bytedance.android.shopping.inflow.compat.VideoZoomableToggleBottomSheetFragment;
import com.bytedance.android.shopping.inflow.view.TopRoundRelativeLayout;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.common.utility.Logger;
import com.bytedance.jedi.arch.JediView;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/feed/fragment/VideoProductFeedFragment;", "Lcom/bytedance/android/shopping/inflow/compat/VideoZoomableToggleBottomSheetFragment;", "Lcom/bytedance/android/shopping/feed/view/d;", "", "Lqk/d;", "event", "", "tryCloseInflow", "<init>", "()V", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoProductFeedFragment extends VideoZoomableToggleBottomSheetFragment implements com.bytedance.android.shopping.feed.view.d {
    public static final /* synthetic */ int O = 0;
    public int A;
    public int B;
    public InnerFlowPageStyleDTO C;
    public AnchorV3Param D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public float I;
    public boolean J;
    public com.bytedance.android.shopping.feed.d K;
    public final com.bytedance.android.shopping.feed.fragment.head.h L;
    public boolean M;
    public boolean N;
    public ProductFeedContentFragment r;
    public ViewGroup s;
    public View t;
    public View u;
    public View v;
    public CouponView w;
    public FrameLayout x;
    public final int y;
    public int z;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.shopping.inflow.compat.ToggleBottomSheetFragment
    public final int S90() {
        return 2131560642;
    }

    @Override // com.bytedance.android.shopping.inflow.compat.ToggleBottomSheetFragment
    public final int getLayoutId() {
        return 2131560643;
    }

    @Override // com.bytedance.android.shopping.inflow.compat.ToggleBottomSheetFragment
    public final String getTAG() {
        return "video_product_flow";
    }

    public VideoProductFeedFragment() {
        int r0 = k1.j(getContext());
        this.y = r0;
        n1.i.getClass();
        int r1 = n1.a.b();
        this.z = r1;
        Resources r2 = Resources.getSystem();
        this.A = (r0 - r1) - MathKt.roundToInt(TypedValue.applyDimension(1, 30, WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics())));
        this.H = true;
        this.J = true;
        this.L = new com.bytedance.android.shopping.feed.fragment.head.h();
    }

    @Override // com.bytedance.android.shopping.inflow.compat.VideoZoomableToggleBottomSheetFragment
    public final void onDestroy() {
        super.onDestroy();
        if (ld3.c.j() == 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L10;
        int r1 = ECSdk.a;
        cf.l r2 = (cf.l) ECSdk.a(cf.l.class);
        if (r2 == null) goto L10;
        r2.d();
    L10:
        Iterator r3 = ((ArrayList) je3.a.c).iterator();
    L12:
        if (r3.hasNext() == false) goto L14;
        ((Function1) r3.next()).invoke(null);
        goto L12
    L14:
        s0.a(PageDestroyTypeEvent.PRODUCT_INNER);
        s0.e(this);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        dm.a.a("lgz_log_debug").a("VideoProductFeedFragment onPause");
        if (ld3.c.j() == 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        if (this.G == false) goto L10;
        return;
    L10:
        if (this.E == true) goto L15;
        com.bytedance.android.shopping.feed.utils.f.b.e(true, getContext());
        return;
    L15:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.android.shopping.inflow.compat.VideoZoomableToggleBottomSheetFragment, com.bytedance.android.shopping.inflow.compat.ToggleBottomSheetFragment
    public final void onResume() {
        super.onResume();
        dm.a.a("lgz_log_debug").a("VideoProductFeedFragment onResume");
        if (ld3.c.j() == 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L23;
        if (this.F == false) goto L10;
    L11:
        com.bytedance.android.shopping.feed.utils.f.b.a(getView());
    L13:
        if (this.H == false) goto L16;
        this.G = com.bytedance.android.shopping.feed.utils.f.b.isPlaying();
        this.H = false;
    L16:
        if (this.F == false) goto L18;
    L19:
        int r1 = ECSdk.a;
        cf.l r2 = (cf.l) ECSdk.a(cf.l.class);
        if (r2 == null) goto L23;
        r2.c();
        goto L23
    L18:
        if (this.M == false) goto L23;
    L10:
        if (this.M == false) goto L13;
    L23:
        if (this.G == true) goto L26;
        da0(true);
        return;
    L26:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.android.shopping.inflow.compat.ToggleBottomSheetFragment
    public final int U90() {
        return this.z;
    }

    public static View aa0(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    @Override // com.bytedance.android.shopping.inflow.compat.ToggleBottomSheetFragment
    public final void V90(boolean r5) {
        this.F = r5;
        ProductFeedContentFragment r0 = this.r;
        if (r0 == null) goto L5;
        r0.X90(r5, true);
    L5:
        if (r5 == false) goto L20;
        Dialog r1 = getDialog();
        View r2 = null;
        if (r1 == null) goto L11;
        Window r3 = r1.getWindow();
        if (r3 == null) goto L11;
        View r4 = aa0(r3);
    L13:
        if ((r4 instanceof ViewGroup) == false) goto L16;
        r2 = r4;
    L16:
        ViewGroup r6 = (ViewGroup) r2;
        if (r6 == null) goto L20;
        r6.removeView(this.s);
    L11:
        r4 = null;
    L20:
        if (ld3.c.j() == 0) goto L22;
        boolean r7 = true;
    L23:
        if (r7 == false) goto L25;
    L34:
        if (r5 == true) goto L36;
        da0(false);
    L39:
        s0.a(new qk.e());
        return;
    L36:
        if (this.G == false) goto L39;
        da0(true);
        goto L39
    L25:
        if (this.G == false) goto L34;
        if (isResumed() == false) goto L34;
        if (r5 == false) goto L30;
    L33:
        com.bytedance.android.shopping.feed.utils.f.b.a(getView());
        goto L34
    L30:
        if (this.M == true) goto L33;
        com.bytedance.android.shopping.feed.utils.f r8 = com.bytedance.android.shopping.feed.utils.f.b;
        r8.h();
        r8.c();
        goto L34
    L22:
        r7 = false;
        goto L23
    }

    @Override // com.bytedance.android.shopping.inflow.compat.VideoZoomableToggleBottomSheetFragment, com.bytedance.android.shopping.inflow.compat.ToggleBottomSheetFragment
    public final void W90(float r19) {
        Logger.d("VideoProductFeedFragment", "VideoProductFeedFragment = " + r19);
        super.W90(r19);
        double r2 = (double) r19;
        if (r2 >= 0.0d) goto L5;
    L19:
        ProductFeedContentFragment r4 = this.r;
        if (r4 == null) goto L127;
        if (r19 < 0) goto L127;
        float r11 = 1;
        if (r19 > r11) goto L127;
        float r12 = 1.0f - r19;
        InnerFeedPageHeadWidget r13 = r4.h;
        if (r13 == null) goto L64;
        if (r2 <= 0.99d) goto L43;
        if (r13.s == true) goto L33;
        r13.d();
        r13.setAlpha(1.0f);
    L33:
        r13.s = true;
        View[] r3 = {r13.p, r13.a, r13.d};
        int r5 = 0;
    L34:
        if (r5 >= 3) goto L39;
        View r14 = r3[r5];
        if (r14 == null) goto L38;
        r14.setAlpha(1.0f);
    L38:
        r5 = r5 + 1;
        goto L34
    L39:
        View r6 = r13.t;
        if (r6 == null) goto L64;
        r6.post(new m(r13));
        goto L64
    L43:
        if (r2 <= 0.7d) goto L54;
        int r7 = com.bytedance.android.shopping.extensions.b.b(Double.valueOf(((double) 30) - ((r2 - 0.7d) * ((double) 100))));
        View r8 = r13.t;
        if (r8 == null) goto L47;
        r8.post(new n(r13, r7));
    L47:
        float r15 = (r11 - ((r11 - r19) * 3)) - 0.1f;
        View[] r9 = {r13.p, r13.a, r13.d};
        int r10 = 0;
    L48:
        if (r10 >= 3) goto L64;
        View r16 = r9[r10];
        if (r16 == null) goto L52;
        r16.setAlpha(r15);
    L52:
        r10 = r10 + 1;
        goto L48
    L54:
        if (r13.s == false) goto L59;
        View r17 = r13.t;
        if (r17 == null) goto L58;
        r17.post(new o(r13));
    L58:
        r13.e();
    L59:
        View r18 = r13.a;
        if (r18 == null) goto L62;
        r18.setAlpha(r11 - r19);
    L62:
        r13.s = false;
    L64:
        if (r4.isDetached() == true) goto L94;
        int r20 = (int) (r12 * ProductFeedContentFragment.T90(r4.getContext()));
        TopRoundRelativeLayout r21 = r4.j;
        if (r21 == null) goto L68;
        r21.setBorderRadius(r20);
    L68:
        RecyclerView r22 = r4.k;
        if (r22 == null) goto L71;
        Drawable r23 = r22.getBackground();
    L73:
        if ((r23 instanceof com.bytedance.android.shopping.feed.widget.d) == true) goto L75;
        r23 = null;
    L75:
        com.bytedance.android.shopping.feed.widget.d r24 = (com.bytedance.android.shopping.feed.widget.d) r23;
        if (r24 == null) goto L78;
        r24.a(r19);
    L78:
        InnerFlowPageStyleDTO r25 = r4.U90().getInnerFlowPageStyle();
        if (r25 == null) goto L83;
        PageStyle r26 = r25.getPageStyle();
        if (r26 == null) goto L83;
        Integer r27 = r26.getBgHighLight();
    L84:
        if (r27 == null) goto L94;
        if (r27.intValue() != 1) goto L94;
        RecyclerView r28 = r4.k;
        if (r28 == null) goto L94;
        Drawable r29 = r28.getBackground();
        if (r29 == null) goto L94;
        r29.setAlpha((int) (255 * r19));
    L83:
        r27 = null;
        goto L84
    L71:
        r23 = null;
    L94:
        if (r4.v == true) goto L96;
    L103:
        RecyclerView r30 = r4.k;
        if (r30 == null) goto L106;
        RecyclerView.LayoutManager r31 = r30.getLayoutManager();
    L108:
        if ((r31 instanceof LinearLayoutManager) == true) goto L110;
        r31 = null;
    L110:
        LinearLayoutManager r32 = (LinearLayoutManager) r31;
        if (r32 == null) goto L127;
        int r33 = r32.findFirstVisibleItemPosition();
        int r34 = r32.findLastVisibleItemPosition();
        if (r33 > r34) goto L127;
    L114:
        RecyclerView r35 = r4.k;
        if (r35 == null) goto L117;
        RecyclerView.ViewHolder r36 = r35.findViewHolderForLayoutPosition(r33);
    L119:
        if ((r36 instanceof com.bytedance.android.shopping.feed.viewholder.a) == true) goto L121;
        r36 = null;
    L121:
        com.bytedance.android.shopping.feed.viewholder.a r37 = (com.bytedance.android.shopping.feed.viewholder.a) r36;
        if (r37 == null) goto L124;
        r37.O(r19);
    L124:
        if (r33 == r34) goto L127;
        r33 = r33 + 1;
        goto L114
    L117:
        r36 = null;
        goto L119
    L106:
        r31 = null;
        goto L108
    L96:
        if (r19 != 1.0f) goto L100;
        View r38 = r4.l;
        if (r38 == null) goto L103;
        r38.setVisibility(4);
        goto L103
    L100:
        View r39 = r4.l;
        if (r39 == null) goto L103;
        r39.setVisibility(0);
    L127:
        if (this.I >= 0.4f) goto L148;
        if (r19 < 0.4f) goto L148;
        BottomSheetBehavior<View> r40 = this.f;
        if (r40 == null) goto L133;
        r40.setState(3);
    L133:
        ProductFeedContentFragment r41 = this.r;
        if (r41 == null) goto L136;
        r41.U90().setHasExpandInflow(true);
    L136:
        View r42 = this.e;
        if (r42 == null) goto L139;
        r42.dispatchTouchEvent(MotionEvent.obtain(0, 0, 3, 0.0f, 0.0f, 0));
    L139:
        Dialog r43 = getDialog();
        if (r43 == null) goto L144;
        Window r44 = r43.getWindow();
        if (r44 == null) goto L144;
        com.bytedance.android.shopping.extensions.m.a(r44, true);
    L144:
        ProductFeedContentFragment r45 = this.r;
        if (r45 == null) goto L148;
        int r46 = ProductFeedContentFragment.I;
        r45.X90(true, false);
    L148:
        if (this.I >= 0.4f) goto L150;
    L165:
        this.I = r19;
        InnerFlowPageStyleDTO r47 = this.C;
        if (r47 == null) goto L170;
        PageStyle r48 = r47.getPageStyle();
        if (r48 == null) goto L170;
        Integer r49 = r48.getBgHighLight();
    L171:
        if (r49 != null) goto L174;
    L180:
        Iterator r50 = ((ArrayList) je3.a.a).iterator();
    L182:
        if (r50.hasNext() == false) goto L184;
        ((Function2) r50.next()).invoke(null, Float.valueOf(r19));
        goto L182
    L184:
        return;
    L174:
        if (r49.intValue() != 1) goto L180;
        if (r19 > 0) goto L180;
        View r51 = this.u;
        if (r51 == null) goto L180;
        r51.setTranslationY(this.A - (this.B * r19));
    L170:
        r49 = null;
        goto L171
    L150:
        if (r19 >= 0.4f) goto L165;
        BottomSheetBehavior<View> r52 = this.f;
        if (r52 == null) goto L154;
        r52.setState(4);
    L154:
        View r53 = this.e;
        if (r53 == null) goto L157;
        r53.dispatchTouchEvent(MotionEvent.obtain(0, 0, 3, 0.0f, 0.0f, 0));
    L157:
        Dialog r54 = getDialog();
        if (r54 == null) goto L162;
        Window r55 = r54.getWindow();
        if (r55 == null) goto L162;
        com.bytedance.android.shopping.extensions.m.a(r55, false);
    L162:
        ProductFeedContentFragment r56 = this.r;
        if (r56 == null) goto L165;
        int r57 = ProductFeedContentFragment.I;
        r56.X90(false, false);
        goto L165
    L5:
        if (r2 > 1.0d) goto L19;
        View r58 = this.t;
        if (r58 == null) goto L9;
        r58.setAlpha(r19);
    L9:
        FrameLayout r59 = this.x;
        if (r59 == null) goto L12;
        r59.setAlpha(1.0f - r19);
    L12:
        CouponView r60 = this.w;
        if (r60 == null) goto L19;
        if (r60.getVisibility() != 0) goto L19;
        CouponView r61 = this.w;
        if (r61 == null) goto L19;
        r61.setAlpha(r19);
        goto L19
    }

    @Override // com.bytedance.android.shopping.inflow.compat.ToggleBottomSheetFragment
    public final void X90(int r3) {
        boolean r0 = true;
        if (r3 == 1) goto L9;
        if (r3 == 2) goto L9;
        int r4 = ph.a.a;
    L12:
        this.J = r0;
        return;
    L9:
        if (this.J == false) goto L11;
        int r5 = ph.a.a;
    L11:
        r0 = false;
        goto L12
    }

    @Override // com.bytedance.android.shopping.inflow.compat.VideoZoomableToggleBottomSheetFragment
    public final void Z90(float r5) {
        super.Z90(r5);
        int r0 = U90();
        ProductFeedContentFragment r1 = this.r;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r5 > 0) goto L7;
        int r2 = (int) (r0 * (1 + r5));
    L12:
        p r3 = r1.H;
        if (r3 == null) goto L17;
        r3.d(r2, r0, r5);
        return;
    L17:
        return;
    L7:
        RecyclerView r4 = r1.k;
        if (r4 == null) goto L10;
        int r6 = r4.getHeight();
    L11:
        r2 = (int) (r0 + ((r6 - r0) * r5));
        goto L12
    L10:
        r6 = r0;
        goto L11
    }

    public final void ba0(AnchorV3Param r10) {
        Intrinsics.checkNotNullParameter(r10, "anchorV3Param");
        if (r10.getCurrentPromotion().isApiBack() == true) goto L6;
        return;
    L6:
        if (r10.getCurrentPromotion().isPreload() == false) goto L8;
        return;
    L8:
        FrameLayout r3 = this.x;
        if (r3 == null) goto L23;
        com.bytedance.android.shopping.feed.fragment.head.h r0 = this.L;
        Context r4 = getContext();
        CouponView r5 = this.w;
        ProductFeedContentFragment r6 = this.r;
        Dialog r1 = getDialog();
        if (r1 == null) goto L13;
        View r2 = r1.findViewById(2131367533);
    L14:
        com.bytedance.android.shopping.feed.fragment.head.g r8 = new com.bytedance.android.shopping.feed.fragment.head.g(r10, r3, r4, r5, r6, r2);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r8, "data");
        if ((!((ArrayList) r0.a).isEmpty()) == true) goto L18;
        ((ArrayList) r0.a).add(new com.bytedance.android.shopping.feed.fragment.head.b());
        ((ArrayList) r0.a).add(new com.bytedance.android.shopping.feed.fragment.head.f());
    L18:
        Iterator r11 = ((ArrayList) r0.a).iterator();
    L20:
        if (r11.hasNext() == false) goto L27;
        if (((com.bytedance.android.shopping.feed.fragment.head.c) r11.next()).a(r8) == false) goto L20;
        return;
    L27:
        return;
    L13:
        r2 = null;
        goto L14
    }

    public final void ca0(DialogInterface r4) {
        Intrinsics.checkNotNullParameter(r4, "dialog");
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r4);
        da0(false);
        if (ld3.c.j() == 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
    L28:
        s0.a(new y(PageScrollStatus.slide));
        return;
    L8:
        if (this.N == true) goto L28;
        this.E = true;
        ProductFeedContentFragment r1 = this.r;
        if (r1 != null) goto L12;
    L22:
        com.bytedance.android.shopping.feed.utils.f.b.e(false, getContext());
    L23:
        com.bytedance.android.shopping.feed.utils.f r5 = com.bytedance.android.shopping.feed.utils.f.b;
        boolean r2 = r5.isPlaying();
        if (this.G == false) goto L27;
        if (r2 == true) goto L27;
        r5.c();
    L27:
        r5.h();
        goto L28
    L12:
        if (r1.isDetached() == false) goto L14;
    L19:
        boolean r3 = false;
    L20:
        if (r3 != true) goto L22;
        com.bytedance.android.shopping.feed.utils.f.b.f();
        goto L23
    L14:
        if (((AbsFragment) r1).e == true) goto L19;
        if (r1.getActivity() == null) goto L19;
        r3 = r1.U90().getHasEnterVideoDetailActivity();
        goto L20
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.android.shopping.feed.view.d
    public final void close(boolean r2) {
        this.N = r2;
        dismissAllowingStateLoss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L12;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void da0(boolean r9) {
        if (ld3.f.a() == true) goto L5;
        return;
    L5:
        com.bytedance.android.shopping.feed.utils.f r1 = com.bytedance.android.shopping.feed.utils.f.b;
        AnchorV3Param r0 = this.D;
        if (r0 == null) goto L11;
        ECLogExtraData r2 = r0.getLogExtraData();
        if (r2 == null) goto L11;
        String r3 = r2.getEnterFrom();
        if (r3 == null) goto L11;
    L12:
        r1.d(r9, r3, getActivity(), true, this.G, null);
        return;
    L11:
        r3 = "";
        goto L12
    }

    public final void ea0(InnerFlowPageStyleDTO r4) {
        Intrinsics.checkNotNullParameter(r4, "innerFlowPageStyle");
        ProductFeedContentFragment r1 = this.r;
        if (r1 == null) goto L15;
        Intrinsics.checkNotNullParameter(r4, "innerFlowPageStyle");
        r1.U90().setInnerFlowPageStyle(r4);
        InnerFeedPageHeadWidget r5 = r1.h;
        if (r5 == null) goto L7;
        r5.b(r1.U90(), r1.C);
    L7:
        InnerFeedPageRightWidget r6 = r1.i;
        if (r6 == null) goto L10;
        r6.a(r1.U90(), new f(r1));
    L10:
        RecyclerView r7 = r1.k;
        if (r7 == null) goto L13;
        r7.setOnTouchListener(new g(r1));
    L13:
        r1.initBackground();
        return;
    }

    @Override // com.bytedance.android.shopping.inflow.compat.ToggleBottomSheetFragment
    public final void onCreate(Bundle r7) {
        int r0 = ph.a.a;
        Intrinsics.checkNotNullParameter(requireContext(), "context");
        super.onCreate(r7);
        Bundle r8 = getArguments();
        Object r1 = null;
        if (r8 == null) goto L5;
        Object r9 = r8.get("param_key");
    L7:
        if ((r9 instanceof AnchorV3Param) == true) goto L9;
        r9 = null;
    L9:
        AnchorV3Param r10 = (AnchorV3Param) r9;
        boolean r2 = true;
        if (r10 == null) goto L33;
        this.D = r10;
        ECUIParam r3 = r10.getUiParam();
        if (r3 == null) goto L16;
        Integer r4 = r3.getPanelHeight();
        if (r4 == null) goto L16;
        int r5 = r4.intValue();
    L17:
        if (r5 <= 0) goto L19;
        this.z = r5;
    L19:
        ECUIParam r11 = r10.getUiParam();
        if (r11 == null) goto L22;
        Integer r12 = r11.getSplitPercent();
    L23:
        if (r12 != null) goto L26;
    L31:
        int r13 = this.y - this.z;
        Resources r6 = Resources.getSystem();
        this.A = r13 - MathKt.roundToInt(TypedValue.applyDimension(1, 30, WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics())));
        goto L33
    L26:
        if (r12.intValue() != 9) goto L31;
        n1.i.getClass();
        if (n1.d != 0) goto L30;
        n1.a.e(ECAppInfoService.e.getApplicationContext());
    L30:
        this.z = n1.d;
        this.M = true;
        goto L31
    L22:
        r12 = null;
    L16:
        r5 = 0;
    L33:
        if (ld3.c.j() != 0) goto L36;
        r2 = false;
    L36:
        if (r2 == false) goto L38;
        JediView.DefaultImpls.getLifecycleOwner(this).getLifecycle().addObserver(new AwemeFeedVideoController(this));
        Unit r14 = Unit.INSTANCE;
    L38:
        Bundle r15 = getArguments();
        if (r15 == null) goto L41;
        Object r16 = r15.get("page_style");
    L43:
        if ((r16 instanceof InnerFlowPageStyleDTO) == false) goto L46;
        r1 = r16;
    L46:
        this.C = (InnerFlowPageStyleDTO) r1;
        s0.c(this);
        ECLiveHybridUtil.m("ecGetTagProductInfo", d0.b);
        return;
    L41:
        r16 = null;
        goto L43
    L5:
        r9 = null;
        goto L7
    }

    public final void onDismiss(DialogInterface r2) {
        ca0(r2);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    @Override // com.bytedance.android.shopping.inflow.compat.ToggleBottomSheetFragment, android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface r3) {
        Intrinsics.checkNotNullParameter(r3, "dialog");
        super.onShow(r3);
        List<Function2<String, Float, Unit>> r4 = je3.a.a;
        Iterator<T> r5 = je3.a.b.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((Function1) r5.next()).invoke(null);
        goto L4
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void tryCloseInflow(qk.d r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (isDetached() == false) goto L5;
        return;
    L5:
        if (getActivity() == null) goto L10;
        close(true);
        return;
    }

    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, FreqActions.ACTION_VIEW);
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r7, r8);
        FragmentTransaction r9 = getChildFragmentManager().beginTransaction();
        ProductFeedContentFragment r10 = new ProductFeedContentFragment();
        r10.setArguments(getArguments());
        Intrinsics.checkNotNullParameter(this, "parentView");
        r10.u = this;
        r10.B = this.K;
        Function0<Unit> r0 = new VideoProductFeedFragment$initContentFragment$$inlined$apply$lambda$1(this);
        Intrinsics.checkNotNullParameter(r0, "function");
        r10.y = r0;
        VideoProductFeedFragment$initContentFragment$1$1$2 r1 = new VideoProductFeedFragment$initContentFragment$1$1$2(this);
        Intrinsics.checkNotNullParameter(r1, "function");
        r10.z = r1;
        Unit r2 = Unit.INSTANCE;
        this.r = r10;
        int r11 = ld3.c.a;
        int r12 = com.bytedance.android.ec.core.opt.ab.n.a;
        Object r3 = Boolean.TRUE;
        int r4 = com.bytedance.android.ec.base.settings.a.a;
        FrameLayout r5 = null;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L163
        Object r13 = com.bytedance.android.ec.base.settings.d.c.get("iesec_inflow_red_packet");     // Catch: Throwable -> L56
        if (r13 != null) goto L8;
    L53:
        Object r14 = null;
    L54:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L56
    L58:
        Throwable r16 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L163
        if (r16 == null) goto L62;
        EnsureManager.ensureNotReachHere(r16);     // Catch: Throwable -> L163
    L62:
        if (Result.isFailure-impl(r15) == false) goto L65;
        r15 = null;
    L65:
        if ((r15 instanceof Boolean) == true) goto L67;
        r15 = null;
    L67:
        Object r17 = (Boolean) r15;     // Catch: Throwable -> L163
        if (r17 != null) goto L74;
        Object r18 = com.bytedance.android.ec.base.settings.d.a.get("iesec_inflow_red_packet");     // Catch: Throwable -> L163
        if ((r18 instanceof Boolean) == true) goto L73;
        r18 = null;
    L73:
        r17 = (Boolean) r18;     // Catch: Throwable -> L163
    L74:
        if (r17 != null) goto L173;
        int r19 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L163
        Object r20 = com.bytedance.android.ec.base.settings.d.c.get("iesec_inflow_red_packet");     // Catch: Throwable -> L129
        if (r20 != null) goto L81;
    L126:
        Object r21 = null;
    L127:
        Object r22 = Result.constructor-impl(r21);     // Catch: Throwable -> L129
    L131:
        Throwable r23 = Result.exceptionOrNull-impl(r22);     // Catch: Throwable -> L154
        if (r23 == null) goto L135;
        EnsureManager.ensureNotReachHere(r23);     // Catch: Throwable -> L154
    L135:
        if (Result.isFailure-impl(r22) == false) goto L138;
        r22 = null;
    L138:
        if ((r22 instanceof Boolean) == true) goto L140;
        r22 = null;
    L140:
        r17 = (Boolean) r22;     // Catch: Throwable -> L154
        if (r17 != null) goto L161;
        IHybridHostService r24 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r24 == null) goto L146;
        Object r25 = r24.getHostABValue("iesec_inflow_red_packet", r3);     // Catch: Throwable -> L154
    L147:
        if (r25 != null) goto L149;
    L160:
        r17 = r3;
        goto L161
    L149:
        if ((r25 instanceof Boolean) == true) goto L151;
        r25 = null;
    L151:
        r17 = (Boolean) r25;     // Catch: Throwable -> L154
        if (r17 != null) goto L161;
    L154:
        th = move-exception;
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L163
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r27 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L163
        if (r27 == null) goto L159;
        EnsureManager.ensureNotReachHere(r27);     // Catch: Throwable -> L163
    L159:
        if (Result.isFailure-impl(r17) == false) goto L161;
    L146:
        r25 = null;
    L161:
        com.bytedance.android.ec.base.settings.d.d("iesec_inflow_red_packet", r17);     // Catch: Throwable -> L163
        goto L173
    L81:
        if ((r20 instanceof Boolean) == true) goto L83;
        Object r28 = null;
    L84:
        r21 = (Boolean) r28;     // Catch: Throwable -> L129
        if (r21 != null) goto L127;
        if ((r20 instanceof Number) == false) goto L114;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L96;
        Float r29 = Float.valueOf(((Number) r20).floatValue());     // Catch: Throwable -> L129
        if ((r29 instanceof Boolean) == true) goto L94;
        r29 = null;
    L94:
        r21 = (Boolean) r29;     // Catch: Throwable -> L129
        goto L127
    L96:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L102;
        Double r30 = Double.valueOf(((Number) r20).doubleValue());     // Catch: Throwable -> L129
        if ((r30 instanceof Boolean) == true) goto L100;
        r30 = null;
    L100:
        r21 = (Boolean) r30;     // Catch: Throwable -> L129
        goto L127
    L102:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L108;
        Integer r31 = Integer.valueOf(((Number) r20).intValue());     // Catch: Throwable -> L129
        if ((r31 instanceof Boolean) == true) goto L106;
        r31 = null;
    L106:
        r21 = (Boolean) r31;     // Catch: Throwable -> L129
        goto L127
    L108:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L114;
        Long r32 = Long.valueOf(((Number) r20).longValue());     // Catch: Throwable -> L129
        if ((r32 instanceof Boolean) == true) goto L112;
        r32 = null;
    L112:
        r21 = (Boolean) r32;     // Catch: Throwable -> L129
    L114:
        if ((r20 instanceof JSONObject) == false) goto L116;
    L414:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L122
        Object r33 = SDKSettingsCacheManager.a().fromJson(r20.toString(), Boolean.class);     // Catch: Throwable -> L122
        if ((r33 instanceof Boolean) == true) goto L120;
        r33 = null;
    L120:
        Object r34 = Result.constructor-impl((Boolean) r33);     // Catch: Throwable -> L122
    L124:
        r21 = r34;
        if (Result.isFailure-impl(r21) == false) goto L127;
    L122:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L129
        r34 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L129
        goto L124
    L116:
        if ((r20 instanceof JSONArray) == false) goto L126;
    L83:
        r28 = r20;
    L129:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L154
        r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L173:
        if (((Boolean) r17).booleanValue() == false) goto L348;
        ProductFeedContentFragment r37 = this.r;
        if (r37 == null) goto L348;
        new Handler().postDelayed(new h(r37, this), 1000);
        int r38 = ld3.c.a;
        int r39 = com.bytedance.android.ec.core.opt.ab.n.a;
        Object r40 = Boolean.TRUE;
        int r41 = com.bytedance.android.ec.base.settings.a.a;
        Object r42 = com.bytedance.android.ec.base.settings.d.c.get("iesec_inflow_benefit_banner");     // Catch: Throwable -> L229
        if (r42 != null) goto L181;
    L226:
        Object r43 = null;
    L227:
        Object r44 = Result.constructor-impl(r43);     // Catch: Throwable -> L229
    L231:
        Throwable r45 = Result.exceptionOrNull-impl(r44);     // Catch: Throwable -> L336
        if (r45 == null) goto L235;
        EnsureManager.ensureNotReachHere(r45);     // Catch: Throwable -> L336
    L235:
        if (Result.isFailure-impl(r44) == false) goto L238;
        r44 = null;
    L238:
        if ((r44 instanceof Boolean) == true) goto L240;
        r44 = null;
    L240:
        Object r46 = (Boolean) r44;     // Catch: Throwable -> L336
        if (r46 != null) goto L247;
        Object r47 = com.bytedance.android.ec.base.settings.d.a.get("iesec_inflow_benefit_banner");     // Catch: Throwable -> L336
        if ((r47 instanceof Boolean) == true) goto L246;
        r47 = null;
    L246:
        r46 = (Boolean) r47;     // Catch: Throwable -> L336
    L247:
        if (r46 != null) goto L346;
        int r48 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L336
        Object r49 = com.bytedance.android.ec.base.settings.d.c.get("iesec_inflow_benefit_banner");     // Catch: Throwable -> L302
        if (r49 != null) goto L254;
    L299:
        Object r50 = null;
    L300:
        Object r51 = Result.constructor-impl(r50);     // Catch: Throwable -> L302
    L304:
        Throwable r52 = Result.exceptionOrNull-impl(r51);     // Catch: Throwable -> L327
        if (r52 == null) goto L308;
        EnsureManager.ensureNotReachHere(r52);     // Catch: Throwable -> L327
    L308:
        if (Result.isFailure-impl(r51) == false) goto L311;
        r51 = null;
    L311:
        if ((r51 instanceof Boolean) == true) goto L313;
        r51 = null;
    L313:
        r46 = (Boolean) r51;     // Catch: Throwable -> L327
        if (r46 != null) goto L334;
        IHybridHostService r53 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L327
        if (r53 == null) goto L319;
        Object r54 = r53.getHostABValue("iesec_inflow_benefit_banner", r40);     // Catch: Throwable -> L327
    L320:
        if (r54 != null) goto L322;
    L333:
        r46 = r40;
        goto L334
    L322:
        if ((r54 instanceof Boolean) == true) goto L324;
        r54 = null;
    L324:
        r46 = (Boolean) r54;     // Catch: Throwable -> L327
        if (r46 != null) goto L334;
    L327:
        th = move-exception;
        Result.Companion r55 = Result.Companion;     // Catch: Throwable -> L336
        r46 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L336
        Throwable r56 = Result.exceptionOrNull-impl(r46);     // Catch: Throwable -> L336
        if (r56 == null) goto L332;
        EnsureManager.ensureNotReachHere(r56);     // Catch: Throwable -> L336
    L332:
        if (Result.isFailure-impl(r46) == false) goto L334;
    L319:
        r54 = null;
    L334:
        com.bytedance.android.ec.base.settings.d.d("iesec_inflow_benefit_banner", r46);     // Catch: Throwable -> L336
        goto L346
    L254:
        if ((r49 instanceof Boolean) == true) goto L256;
        Object r57 = null;
    L257:
        r50 = (Boolean) r57;     // Catch: Throwable -> L302
        if (r50 != null) goto L300;
        if ((r49 instanceof Number) == false) goto L287;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L269;
        Float r58 = Float.valueOf(((Number) r49).floatValue());     // Catch: Throwable -> L302
        if ((r58 instanceof Boolean) == true) goto L267;
        r58 = null;
    L267:
        r50 = (Boolean) r58;     // Catch: Throwable -> L302
        goto L300
    L269:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L275;
        Double r59 = Double.valueOf(((Number) r49).doubleValue());     // Catch: Throwable -> L302
        if ((r59 instanceof Boolean) == true) goto L273;
        r59 = null;
    L273:
        r50 = (Boolean) r59;     // Catch: Throwable -> L302
        goto L300
    L275:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L281;
        Integer r60 = Integer.valueOf(((Number) r49).intValue());     // Catch: Throwable -> L302
        if ((r60 instanceof Boolean) == true) goto L279;
        r60 = null;
    L279:
        r50 = (Boolean) r60;     // Catch: Throwable -> L302
        goto L300
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L287;
        Long r61 = Long.valueOf(((Number) r49).longValue());     // Catch: Throwable -> L302
        if ((r61 instanceof Boolean) == true) goto L285;
        r61 = null;
    L285:
        r50 = (Boolean) r61;     // Catch: Throwable -> L302
    L287:
        if ((r49 instanceof JSONObject) == false) goto L289;
    L399:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L295
        Object r62 = SDKSettingsCacheManager.a().fromJson(r49.toString(), Boolean.class);     // Catch: Throwable -> L295
        if ((r62 instanceof Boolean) == true) goto L293;
        r62 = null;
    L293:
        Object r63 = Result.constructor-impl((Boolean) r62);     // Catch: Throwable -> L295
    L297:
        r50 = r63;
        if (Result.isFailure-impl(r50) == false) goto L300;
    L295:
        th = move-exception;
        Result.Companion r64 = Result.Companion;     // Catch: Throwable -> L302
        r63 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L302
        goto L297
    L289:
        if ((r49 instanceof JSONArray) == false) goto L299;
    L256:
        r57 = r49;
    L302:
        th = move-exception;
        Result.Companion r65 = Result.Companion;     // Catch: Throwable -> L327
        r51 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L327
    L346:
        if (((Boolean) r46).booleanValue() == false) goto L348;
        int r66 = if.a.a;
        Intrinsics.checkNotNullParameter(new i(r37, this), "listener");
        goto L348
    L181:
        if ((r42 instanceof Boolean) == true) goto L183;
        Object r67 = null;
    L184:
        r43 = (Boolean) r67;     // Catch: Throwable -> L229
        if (r43 != null) goto L227;
        if ((r42 instanceof Number) == false) goto L214;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L196;
        Float r68 = Float.valueOf(((Number) r42).floatValue());     // Catch: Throwable -> L229
        if ((r68 instanceof Boolean) == true) goto L194;
        r68 = null;
    L194:
        r43 = (Boolean) r68;     // Catch: Throwable -> L229
        goto L227
    L196:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L202;
        Double r69 = Double.valueOf(((Number) r42).doubleValue());     // Catch: Throwable -> L229
        if ((r69 instanceof Boolean) == true) goto L200;
        r69 = null;
    L200:
        r43 = (Boolean) r69;     // Catch: Throwable -> L229
        goto L227
    L202:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L208;
        Integer r70 = Integer.valueOf(((Number) r42).intValue());     // Catch: Throwable -> L229
        if ((r70 instanceof Boolean) == true) goto L206;
        r70 = null;
    L206:
        r43 = (Boolean) r70;     // Catch: Throwable -> L229
        goto L227
    L208:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L214;
        Long r71 = Long.valueOf(((Number) r42).longValue());     // Catch: Throwable -> L229
        if ((r71 instanceof Boolean) == true) goto L212;
        r71 = null;
    L212:
        r43 = (Boolean) r71;     // Catch: Throwable -> L229
    L214:
        if ((r42 instanceof JSONObject) == false) goto L216;
    L410:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L222
        Object r72 = SDKSettingsCacheManager.a().fromJson(r42.toString(), Boolean.class);     // Catch: Throwable -> L222
        if ((r72 instanceof Boolean) == true) goto L220;
        r72 = null;
    L220:
        Object r73 = Result.constructor-impl((Boolean) r72);     // Catch: Throwable -> L222
    L224:
        r43 = r73;
        if (Result.isFailure-impl(r43) == false) goto L227;
    L222:
        th = move-exception;
        Result.Companion r74 = Result.Companion;     // Catch: Throwable -> L229
        r73 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L229
        goto L224
    L216:
        if ((r42 instanceof JSONArray) == false) goto L226;
    L183:
        r67 = r42;
    L229:
        th = move-exception;
        Result.Companion r75 = Result.Companion;     // Catch: Throwable -> L336
        r44 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L336
    L336:
        th = move-exception;
        Result.Companion r76 = Result.Companion;
        Object r77 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r78 = Result.exceptionOrNull-impl(r77);
        if (r78 == null) goto L341;
        EnsureManager.ensureNotReachHere(r78);
    L341:
        if (Result.isFailure-impl(r77) == true) goto L344;
        r40 = r77;
    L344:
        r46 = r40;
    L348:
        ProductFeedContentFragment r79 = this.r;
        Intrinsics.checkNotNull(r79);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r9, r79, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131383121) == true) goto L352;
        r9.add(2131383121, r79);
    L352:
        r9.commit();
        Dialog r80 = getDialog();
        if (r80 == null) goto L355;
        View r81 = r80.findViewById(2131383127);
    L356:
        this.t = r81;
        Dialog r82 = getDialog();
        if (r82 == null) goto L359;
        View r84 = r82.findViewById(2131383148);
    L360:
        this.u = r84;
        InnerFlowPageStyleDTO r85 = this.C;
        if (r85 == null) goto L365;
        PageStyle r86 = r85.getPageStyle();
        if (r86 == null) goto L365;
        Integer r87 = r86.getBgHighLight();
    L366:
        if (r87 != null) goto L369;
    L380:
        Dialog r88 = getDialog();
        if (r88 == null) goto L383;
        View r89 = r88.findViewById(2131383121);
    L384:
        this.v = r89;
        Dialog r90 = getDialog();
        if (r90 == null) goto L387;
        CouponView r91 = (CouponView) r90.findViewById(2131383115);
    L388:
        this.w = r91;
        Dialog r92 = getDialog();
        if (r92 == null) goto L391;
        r5 = (FrameLayout) r92.findViewById(2131372872);
    L391:
        this.x = r5;
        AnchorV3Param r94 = this.D;
        if (r94 == null) goto L418;
        ba0(r94);
        return;
    L418:
        return;
    L387:
        r91 = null;
        goto L388
    L383:
        r89 = null;
        goto L384
    L369:
        if (r87.intValue() != 1) goto L380;
        View r95 = this.t;
        if (r95 == null) goto L373;
        r95.setVisibility(8);
    L373:
        View r96 = this.u;
        if (r96 == null) goto L376;
        r96.setVisibility(0);
    L376:
        View r97 = this.u;
        if (r97 == null) goto L379;
        r97.setTranslationY(this.A);
    L379:
        this.B = this.z;
    L365:
        r87 = null;
        goto L366
    L359:
        r84 = null;
        goto L360
    L355:
        r81 = null;
        goto L356
    L8:
        if ((r13 instanceof Boolean) == true) goto L10;
        Object r98 = null;
    L11:
        r14 = (Boolean) r98;     // Catch: Throwable -> L56
        if (r14 != null) goto L54;
        if ((r13 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L23;
        Float r99 = Float.valueOf(((Number) r13).floatValue());     // Catch: Throwable -> L56
        if ((r99 instanceof Boolean) == true) goto L21;
        r99 = null;
    L21:
        r14 = (Boolean) r99;     // Catch: Throwable -> L56
        goto L54
    L23:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L29;
        Double r100 = Double.valueOf(((Number) r13).doubleValue());     // Catch: Throwable -> L56
        if ((r100 instanceof Boolean) == true) goto L27;
        r100 = null;
    L27:
        r14 = (Boolean) r100;     // Catch: Throwable -> L56
        goto L54
    L29:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        Integer r101 = Integer.valueOf(((Number) r13).intValue());     // Catch: Throwable -> L56
        if ((r101 instanceof Boolean) == true) goto L33;
        r101 = null;
    L33:
        r14 = (Boolean) r101;     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r102 = Long.valueOf(((Number) r13).longValue());     // Catch: Throwable -> L56
        if ((r102 instanceof Boolean) == true) goto L39;
        r102 = null;
    L39:
        r14 = (Boolean) r102;     // Catch: Throwable -> L56
    L41:
        if ((r13 instanceof JSONObject) == false) goto L43;
    L403:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L49
        Object r103 = SDKSettingsCacheManager.a().fromJson(r13.toString(), Boolean.class);     // Catch: Throwable -> L49
        if ((r103 instanceof Boolean) == true) goto L47;
        r103 = null;
    L47:
        Object r104 = Result.constructor-impl((Boolean) r103);     // Catch: Throwable -> L49
    L51:
        r14 = r104;
        if (Result.isFailure-impl(r14) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L56
        r104 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r13 instanceof JSONArray) == false) goto L53;
    L10:
        r98 = r13;
    L56:
        th = move-exception;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L163
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Object r108 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r109 = Result.exceptionOrNull-impl(r108);
        if (r109 == null) goto L168;
        EnsureManager.ensureNotReachHere(r109);
    L168:
        if (Result.isFailure-impl(r108) == true) goto L171;
        r3 = r108;
    L171:
        r17 = r3;
        goto L173
    }
}
