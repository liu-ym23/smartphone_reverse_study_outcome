package com.bytedance.android.shopping.searchsimilar;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.btm.api.BtmPage;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.core.widget.DoubleColorBallStatusView;
import com.bytedance.android.shopping.anchorv3.compat.ToggleBottomSheetFragment;
import com.bytedance.android.shopping.searchsimilar.adapter.SimilarProductCardAdapter;
import com.bytedance.android.shopping.searchsimilar.adapter.SimilarProductFrameAdapter;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.searchsimilar.utils.h;
import com.bytedance.android.shopping.searchsimilar.view.ProductCardDecoration;
import com.bytedance.android.shopping.searchsimilar.view.ProductFrameDecoration;
import com.bytedance.android.shopping.searchsimilar.viewmodel.SimilarProductVM;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.track.TrackerProvider;
import com.bytedance.apm.ApmAgent;
import com.bytedance.crash.Npth;
import com.bytedance.jedi.arch.ISubscriber;
import com.bytedance.jedi.arch.lifecycleAwareLazy;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import gh3.f;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@BtmPage("a1.b1875")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/searchsimilar/SimilarProductFragment;", "Lcom/bytedance/android/shopping/anchorv3/compat/ToggleBottomSheetFragment;", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimilarProductFragment extends ToggleBottomSheetFragment {
    public static final /* synthetic */ int M = 0;
    public DoubleColorBallStatusView A;
    public LinearLayout B;
    public TextView C;
    public LinearLayout D;
    public TextView E;
    public int F;
    public int G;
    public boolean H;
    public boolean I;
    public boolean J;
    public float K;
    public boolean L;
    public final lifecycleAwareLazy n;
    public h o;
    public SimilarProductFrameAdapter p;
    public SimilarProductCardAdapter q;
    public SimilarProductParam r;
    public FrameLayout s;
    public LinearLayout t;
    public RecyclerView u;
    public TabLayout v;
    public RecyclerView w;
    public RelativeLayout x;
    public LinearLayout y;
    public DoubleColorBallStatusView z;

    public static final class a {
    }

    public final int S90() {
        return 2131560628;
    }

    public final SimilarProductVM Y90() {
        return (SimilarProductVM) this.n.getValue();
    }

    public final int getLayoutId() {
        return 2131560629;
    }

    public final String getTAG() {
        return "javaClass";
    }

    static {
        BtmSDK.registerPageClass$default(BtmSDK.INSTANCE, SimilarProductFragment.class, "a1.b1875", false, 4, null);
    }

    public SimilarProductFragment() {
        final KClass r0 = Reflection.getOrCreateKotlinClass(SimilarProductVM.class);
        final Function0<String> r1 = new SimilarProductFragment$$special$$inlined$viewModel$1(r0);
        final SimilarProductFragment$$special$$inlined$viewModel$2 r2 = SimilarProductFragment$$special$$inlined$viewModel$2.INSTANCE;
        this.n = new lifecycleAwareLazy(this, r1, new SimilarProductFragment$$special$$inlined$viewModel$3(this, r1, r0, r2));
        k1.j(getContext());
        k1.p();
        int r3 = com.bytedance.android.shopping.extensions.b.b(580);
        int r4 = com.bytedance.android.shopping.searchsimilar.utils.a.a;
        this.F = r3;
        this.G = r3;
        this.H = true;
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        if (this.I == false) goto L5;
    L7:
        com.bytedance.android.shopping.monitor.d r0 = com.bytedance.android.shopping.monitor.d.h;
        ApmAgent.removePerfTag("e_commerce", "ec_similar_product_page");
        HashMap r1 = new HashMap();
        r1.put("e_commerce", "e_commerce_exit");
        Npth.addTags(r1);
        return;
    L5:
        if (this.J == true) goto L7;
        ih3.d.b.e(true, getContext());
        goto L7
    }

    public final void onResume() {
        super.onResume();
        ih3.d r0 = ih3.d.b;
        r0.e(true, getContext());
        if (this.H == false) goto L5;
        this.I = r0.isPlaying();
        this.H = false;
    L5:
        com.bytedance.android.shopping.monitor.d r1 = com.bytedance.android.shopping.monitor.d.h;
        ApmAgent.addPerfTag("e_commerce", "ec_similar_product_page");
        com.bytedance.android.shopping.monitor.d.j("ec_similar_product_page");
    }

    public final int T90() {
        return this.F;
    }

    public final int U90() {
        return this.G;
    }

    public final void V90(boolean r1) {
        if (r1 == false) goto L5;
        int r2 = com.bytedance.android.shopping.searchsimilar.utils.a.a;
    L5:
        if (this.I == false) goto L8;
        int r3 = com.bytedance.android.shopping.searchsimilar.utils.a.a;
        return;
    }

    public final void W90(float r11) {
        if (this.K >= 0.4f) goto L13;
        if (r11 < 0.4f) goto L13;
        BottomSheetBehavior r0 = ((ToggleBottomSheetFragment) this).f;
        if (r0 == null) goto L9;
        r0.setState(3);
    L9:
        View r1 = ((ToggleBottomSheetFragment) this).e;
        if (r1 == null) goto L13;
        r1.dispatchTouchEvent(MotionEvent.obtain(0, 0, 3, 0.0f, 0.0f, 0));
    L13:
        if (this.K >= 0.4f) goto L15;
    L22:
        this.K = r11;
        return;
    L15:
        if (r11 >= 0.4f) goto L22;
        BottomSheetBehavior r2 = ((ToggleBottomSheetFragment) this).f;
        if (r2 == null) goto L19;
        r2.setState(4);
    L19:
        View r3 = ((ToggleBottomSheetFragment) this).e;
        if (r3 == null) goto L22;
        r3.dispatchTouchEvent(MotionEvent.obtain(0, 0, 3, 0.0f, 0.0f, 0));
        goto L22
    }

    public final void onActivityCreated(Bundle r18) {
        super.onActivityCreated(r18);
        Dialog r0 = getDialog();
        String r1 = null;
        if (r0 == null) goto L5;
        ConstraintLayout r2 = r0.findViewById(2131371014);
    L5:
        Dialog r3 = getDialog();
        if (r3 == null) goto L8;
        FrameLayout r4 = (FrameLayout) r3.findViewById(2131371028);
    L9:
        this.s = r4;
        Dialog r5 = getDialog();
        if (r5 == null) goto L12;
        LinearLayout r6 = (LinearLayout) r5.findViewById(2131371017);
    L13:
        this.t = r6;
        Dialog r7 = getDialog();
        if (r7 == null) goto L16;
        RecyclerView r8 = (RecyclerView) r7.findViewById(2131371020);
    L17:
        this.u = r8;
        Dialog r9 = getDialog();
        if (r9 == null) goto L20;
        TabLayout r10 = (TabLayout) r9.findViewById(2131371032);
    L21:
        this.v = r10;
        Dialog r11 = getDialog();
        if (r11 == null) goto L24;
        RecyclerView r12 = (RecyclerView) r11.findViewById(2131371008);
    L25:
        this.w = r12;
        Dialog r13 = getDialog();
        if (r13 == null) goto L28;
        RelativeLayout r14 = (RelativeLayout) r13.findViewById(2131371013);
    L29:
        this.x = r14;
        Dialog r15 = getDialog();
        if (r15 == null) goto L32;
        LinearLayout r16 = (LinearLayout) r15.findViewById(2131371025);
    L33:
        this.y = r16;
        Dialog r17 = getDialog();
        if (r17 == null) goto L36;
        DoubleColorBallStatusView r19 = (DoubleColorBallStatusView) r17.findViewById(2131371026);
    L37:
        this.z = r19;
        Dialog r20 = getDialog();
        if (r20 == null) goto L40;
        DoubleColorBallStatusView r21 = (DoubleColorBallStatusView) r20.findViewById(2131371029);
    L41:
        this.A = r21;
        Dialog r22 = getDialog();
        if (r22 == null) goto L44;
        LinearLayout r23 = (LinearLayout) r22.findViewById(2131370837);
    L45:
        this.B = r23;
        Dialog r24 = getDialog();
        if (r24 == null) goto L48;
        TextView r25 = (TextView) r24.findViewById(2131371031);
    L49:
        this.C = r25;
        Dialog r26 = getDialog();
        if (r26 == null) goto L52;
        LinearLayout r27 = (LinearLayout) r26.findViewById(2131370836);
    L53:
        this.D = r27;
        Dialog r28 = getDialog();
        if (r28 == null) goto L56;
        TextView r29 = (TextView) r28.findViewById(2131371030);
    L57:
        this.E = r29;
        this.o = new h();
        TabLayout r30 = this.v;
        if (r30 == null) goto L60;
        r30.setSelectedTabIndicator(2131233554);
    L60:
        FrameLayout r31 = this.s;
        if (r31 == null) goto L63;
        r31.setOnClickListener(new com.bytedance.android.shopping.searchsimilar.a(this));
    L63:
        LinearLayout r32 = this.t;
        if (r32 == null) goto L66;
        r32.setOnClickListener(new b(this));
    L66:
        RelativeLayout r33 = this.x;
        if (r33 == null) goto L69;
        r33.setVisibility(8);
    L69:
        LinearLayout r34 = this.y;
        if (r34 == null) goto L72;
        r34.setVisibility(0);
    L72:
        DoubleColorBallStatusView r35 = this.z;
        if (r35 == null) goto L75;
        r35.a();
    L75:
        DoubleColorBallStatusView r36 = this.z;
        if (r36 == null) goto L78;
        r36.setVisibility(0);
        r36.setECStatus(0);
    L78:
        SimilarProductFrameAdapter r37 = new SimilarProductFrameAdapter(Y90());
        SimilarProductParam r38 = this.r;
        if (r38 == null) goto L81;
        String r39 = r38.getMonitorName();
    L82:
        r37.a = r39;
        Unit r40 = Unit.INSTANCE;
        this.p = r37;
        RecyclerView r41 = this.u;
        if (r41 == null) goto L85;
        r41.setAdapter(r37);
        LinearLayoutManager r42 = new LinearLayoutManager(getActivity());
        r42.setOrientation(0);
        r41.setLayoutManager(r42);
        r41.setNestedScrollingEnabled(false);
        r41.addItemDecoration(new ProductFrameDecoration());
    L85:
        SimilarProductCardAdapter r43 = new SimilarProductCardAdapter(Y90(), this.w);
        SimilarProductParam r44 = this.r;
        if (r44 == null) goto L88;
        r1 = r44.getMonitorName();
    L88:
        r43.u = r1;
        r43.r = new SimilarProductFragment$initViews$$inlined$apply$lambda$1(this);
        int r45 = com.bytedance.android.shopping.extensions.b.b(20);
        int r46 = com.bytedance.android.shopping.extensions.b.b(16);
        r43.j = 0;
        r43.l = r45;
        r43.k = 0;
        r43.i = r46;
        Context r47 = getContext();
        if (r47 == null) goto L94;
        int r48 = g1.a;
        String r49 = g1.a.c(r47, 2131896409, new Object[0]);
        TextView r50 = r43.f;
        if (r50 == null) goto L93;
        r50.setText(r49);
    L93:
        r43.e = r49;
    L94:
        Context r51 = getContext();
        if (r51 == null) goto L97;
        int r52 = g1.a;
        r43.d = g1.a.a(r51, 2131100048);
    L97:
        Context r53 = getContext();
        if (r53 == null) goto L100;
        int r54 = g1.a;
        r43.c = g1.a.a(r53, 2131100048);
    L100:
        r43.resetLoadMoreState();
        this.q = r43;
        RecyclerView r55 = this.w;
        if (r55 == null) goto L103;
        r55.setAdapter(r43);
        r55.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        r55.addItemDecoration(new ProductCardDecoration());
        r55.setFocusableInTouchMode(false);
        jh.b.a r56 = jh.b.c;
        MonitorScenes r57 = MonitorScenes.FPS_SCENE_ANCHOR_V3_SIMILAR_PRODUCT_SCREEN;
        r56.getClass();
        jh.b.a.b(r57).b(r55);
    L103:
        TextView r58 = this.E;
        if (r58 == null) goto L106;
        r58.setOnClickListener(new c(this));
    L106:
        TextView r59 = this.C;
        if (r59 == null) goto L109;
        r59.setOnClickListener(new d(this));
    L109:
        ISubscriber.DefaultImpls.selectSubscribe$default(this, Y90(), SimilarProductFragment$initScribe$1.INSTANCE, null, new SimilarProductFragment$initScribe$2(this), 2, null);
        ISubscriber.DefaultImpls.selectSubscribe$default(this, Y90(), SimilarProductFragment$initScribe$3.INSTANCE, null, new SimilarProductFragment$initScribe$4(this), 2, null);
        ISubscriber.DefaultImpls.selectSubscribe$default(this, Y90(), SimilarProductFragment$initScribe$5.INSTANCE, null, new SimilarProductFragment$initScribe$6(this), 2, null);
        ISubscriber.DefaultImpls.selectSubscribe$default(this, Y90(), SimilarProductFragment$initScribe$7.INSTANCE, SimilarProductFragment$initScribe$8.INSTANCE, null, new SimilarProductFragment$initScribe$9(this), 4, null);
        ISubscriber.DefaultImpls.selectSubscribe$default(this, Y90(), SimilarProductFragment$initScribe$10.INSTANCE, null, new SimilarProductFragment$initScribe$11(this), 2, null);
        ISubscriber.DefaultImpls.selectSubscribe$default(this, Y90(), SimilarProductFragment$initScribe$12.INSTANCE, SimilarProductFragment$initScribe$13.INSTANCE, null, new SimilarProductFragment$initScribe$14(this), 4, null);
        ISubscriber.DefaultImpls.selectSubscribe$default(this, Y90(), SimilarProductFragment$initScribe$15.INSTANCE, SimilarProductFragment$initScribe$16.INSTANCE, null, new SimilarProductFragment$initScribe$17(this), 4, null);
        Y90().loadSimilarProduct();
        return;
    L81:
        r39 = null;
        goto L82
    L56:
        r29 = null;
        goto L57
    L52:
        r27 = null;
        goto L53
    L48:
        r25 = null;
        goto L49
    L44:
        r23 = null;
        goto L45
    L40:
        r21 = null;
        goto L41
    L36:
        r19 = null;
        goto L37
    L32:
        r16 = null;
        goto L33
    L28:
        r14 = null;
        goto L29
    L24:
        r12 = null;
        goto L25
    L20:
        r10 = null;
        goto L21
    L16:
        r8 = null;
        goto L17
    L12:
        r6 = null;
        goto L13
    L8:
        r4 = null;
        goto L9
    }

    public final void onCreate(Bundle r6) {
        super.onCreate(r6);
        Bundle r7 = getArguments();
        Object r0 = null;
        if (r7 == null) goto L5;
        Object r8 = r7.get("param_key");
    L7:
        if ((r8 instanceof SimilarProductParam) == false) goto L10;
        r0 = r8;
    L10:
        SimilarProductParam r1 = (SimilarProductParam) r0;
        this.r = r1;
        if (r1 == null) goto L22;
        Context r9 = getContext();
        if (r9 == null) goto L15;
        TrackerProvider.a r2 = TrackerProvider.Companion;
        int r3 = f.b;
        Intrinsics.checkNotNullParameter(r1, "param");
        f r4 = new f();
        f.a(r4, "group_id", r1.getAwemeId());
        f.a(r4, "author_id", r1.getAuthorId());
        f.a(r4, "carrier_source", r1.getEnterFrom());
        f.a(r4, PdpOpenThirdParam.KEY_PAGE_NAME, "similar_product_homepage");
        r2.getClass();
        TrackerProvider.a.a(r9, r4);
    L15:
        Y90().setSimilarProductParam(r1);
        Integer r10 = r1.getTotalPanelHeight();
        if (r10 == null) goto L18;
        int r11 = r10.intValue();
    L19:
        if (r11 <= 0) goto L23;
        this.G = r11;
        int r5 = com.bytedance.android.shopping.searchsimilar.utils.a.a;
        this.F = r11;
        return;
    L23:
        return;
    L18:
        r11 = 0;
        goto L19
    L22:
        return;
    L5:
        r8 = null;
        goto L7
    }

    public final void onDismiss(DialogInterface r3) {
        Intrinsics.checkNotNullParameter(r3, "dialog");     // Catch: Throwable -> L9
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r3);     // Catch: Throwable -> L9
        this.J = true;     // Catch: Throwable -> L9
        ih3.d r4 = ih3.d.b;     // Catch: Throwable -> L9
        r4.e(false, getContext());     // Catch: Throwable -> L9
        boolean r0 = r4.isPlaying();     // Catch: Throwable -> L9
        if (this.I == false) goto L6;
        if (r0 == true) goto L6;
        r4.c();     // Catch: Throwable -> L9
    L6:
        r4.h();     // Catch: Throwable -> L9
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L9:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        com.bytedance.android.shopping.monitor.d r0 = com.bytedance.android.shopping.monitor.d.h;
        ApmAgent.addPerfTag("e_commerce", "ec_similar_product_page");
        com.bytedance.android.shopping.monitor.d.j("ec_similar_product_page");
        return super.onCreateView(r3, r4, r5);
    }
}
