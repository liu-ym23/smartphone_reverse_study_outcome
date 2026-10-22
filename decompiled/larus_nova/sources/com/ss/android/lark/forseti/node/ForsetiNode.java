package com.ss.android.lark.forseti.node;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.ForsetiStackChainBottomSheetBehavior;
import com.google.android.material.bottomsheet.ForsetiStackChainBottomSheetBehaviorV2;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.api.bean.ForsetiChainType;
import com.ss.android.lark.api.bean.ForsetiWidth;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.forseti.chain.ForsetiChainFragment;
import com.ss.android.lark.forseti.chain.ForsetiStackChainAdapter;
import com.ss.android.lark.forseti.chain.ForsetiStackChainStatus;
import com.ss.android.lark.forseti.chain.s;
import com.ss.android.lark.forseti.node.piece.ForsetiNodePiece;
import com.ss.android.lark.forseti.util.animation.ForsetiAnimatorLauncher;
import com.ss.android.lark.forseti.util.dragging.ForsetiColumnsDraggingHelper;
import com.ss.android.lark.forseti.widget.ForsetiNodeViewGroup;
import com.ss.android.lark.forseti.widget.ForsetiNormalChainViewGroup;
import com.ss.android.lark.forseti.widget.ForsetiStackChainViewGroup;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class ForsetiNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.forseti.global.e f424495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ForsetiChainType f424496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ForsetiNodeFragment f424497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ForsetiNode f424498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ForsetiNode f424499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function2<? super Fragment, ? super Integer, Unit> f424500f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function2<? super Fragment, ? super Integer, Unit> f424501g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ForsetiNodeViewGroup f424502h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<Fragment> f424503i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f424504j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public FragmentActivity f424505k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ForsetiNodePiece f424506l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, ForsetiNodePiece> f424507m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final CopyOnWriteArrayList<Function0<Unit>> f424508n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f424509o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.ss.android.lark.forseti.node.a f424510p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f424511q;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f424512a = null;

        static {
            f424512a = new b();
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Log.i("FST_Node", "intercept ForsetiNode click event");
        }
    }

    static {
    }

    public final ForsetiWidth e() {
        ViewGroup.LayoutParams r100 = this.f424502h.getLayoutParams();
        if (r100 != null) goto L5;
        return null;
    L5:
        if ((r100 instanceof ForsetiNormalChainViewGroup.b) == true) goto L7;
        return null;
    L7:
        return ((ForsetiNormalChainViewGroup.b) r100).f424678a;
    }

    public final ForsetiNodeFragment f() {
        ForsetiNodeFragment r100 = this.f424497c;
        if (r100 == null) goto L7;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("nodeContainerFragment");
        goto L7
    L8:
        return r100;
    L7:
        return null;
    }

    public final FragmentActivity getActivity() {
        return this.f424505k;
    }

    public static final void a(ForsetiNode r100) {
        r100.getClass();
        Log.i("FST_Node", "executeRemovalQueue, size = " + r100.f424508n.size());
        Iterator<Function0<Unit>> r101 = r100.f424508n.iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        r101.next().invoke();
        goto L4
    L7:
        if (((Boolean) r100.f424511q.getValue()).booleanValue() == false) goto L11;
        r100.f424508n.clear();
        return;
    }

    public final boolean c(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, "f");
    L3:
        boolean r101 = false;
        if (r100 == null) goto L26;
        if ((r100 instanceof ForsetiNodeFragment) == true) goto L26;
        Iterator r102 = ((ArrayList) this.f424503i).iterator();
    L9:
        if (r102.hasNext() == false) goto L13;
        if (Intrinsics.areEqual((Fragment) r102.next(), r100) == false) goto L9;
    L12:
        r101 = true;
    L23:
        if (r101 == true) goto L24;
        r100 = r100.getParentFragment();
        goto L3
    L24:
        return true;
    L13:
        ForsetiNodePiece r103 = this.f424506l;
        if (r103 == null) goto L23;
        List<Fragment> r104 = r103.j().getFragments();
        if (r104 == null) goto L23;
        Iterator<T> r105 = r104.iterator();
    L19:
        if (r105.hasNext() == false) goto L23;
        if (Intrinsics.areEqual((Fragment) r105.next(), r100) == false) goto L19;
    L26:
        return false;
    }

    public final void g(FragmentManager r100) {
        Intrinsics.checkNotNullParameter(r100, "parentFragmentManager");
        Log.i("FST_Node", "removeFromChain, " + cib.e.a((Fragment) CollectionsKt.lastOrNull(this.f424503i)));
        ForsetiNodePiece r101 = this.f424506l;
        if (r101 == null) goto L9;
        List<Fragment> r102 = r101.j().getFragments();
        FragmentTransaction r103 = r101.j().beginTransaction();
        Iterator<T> r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L8;
        r103.remove((Fragment) r104.next());
        goto L6
    L8:
        r103.commitAllowingStateLoss();
    L9:
        com.ss.android.lark.forseti.node.a r105 = this.f424510p;
        if (r105 == null) goto L13;
        ForsetiNodeViewGroup r106 = this.f424502h;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r105, "listener");
        ((ArrayList) r106.f424623b).remove(r105);
    L13:
        FragmentTransaction r107 = r100.beginTransaction();
        ForsetiNodeFragment r108 = this.f424497c;
        if (r108 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("nodeContainerFragment");
        r108 = null;
    L16:
        r107.remove(r108);
        r107.runOnCommit(new c(this));
        r107.commitAllowingStateLoss();
    }

    public final void h(final Fragment r110) {
        Intrinsics.checkNotNullParameter(r110, "anchorFragment");
        boolean r100 = false;
        ForsetiNodeFragment r101 = null;
        Float r102 = null;
        r102 = null;
        if (((ArrayList) this.f424503i).size() != 1) goto L53;
        if (this.f424496b == ForsetiChainType.TYPE_NORMAL) goto L53;
        com.ss.android.lark.forseti.global.e r103 = this.f424495a;
        s r104 = r103.f424474g;
        if ((r104 instanceof ForsetiStackChainAdapter) == false) goto L9;
        ForsetiStackChainAdapter r105 = (ForsetiStackChainAdapter) r104;
    L10:
        ForsetiChainFragment r106 = r103.f424475h;
        ForsetiStackChainStatus r107 = ForsetiStackChainStatus.DELETING;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r106.C = r107;
        if (r105 != null) goto L13;
        boolean r108 = false;
    L50:
        if (r108 == false) goto L53;
        return;
    L13:
        if (((Boolean) r105.f424382i.getValue()).booleanValue() == true) goto L23;
        BottomSheetBehavior<ForsetiStackChainViewGroup> r109 = r105.f424380g;
        if (r109 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        r109 = null;
    L18:
        if ((r109 instanceof ForsetiStackChainBottomSheetBehaviorV2) == false) goto L20;
        ForsetiStackChainBottomSheetBehaviorV2 r111 = (ForsetiStackChainBottomSheetBehaviorV2) r109;
    L21:
        if (r111 == null) goto L32;
        r111.lockToHidden();
    L32:
        View r112 = r105.f424381h;
        if (r112 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("stack");
        r112 = null;
    L36:
        if (r112.isLayoutRequested() == true) goto L44;
        View r113 = r105.f424381h;
        if (r113 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("stack");
        r113 = null;
    L40:
        r113.requestLayout();
        BottomSheetBehavior<ForsetiStackChainViewGroup> r114 = r105.f424380g;
        if (r114 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        r114 = null;
    L43:
        r114.setState(5);
    L48:
        r108 = true;
        goto L50
    L44:
        BottomSheetBehavior<ForsetiStackChainViewGroup> r115 = r105.f424380g;
        if (r115 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        r115 = null;
    L47:
        r115.setState(5);
        goto L48
    L20:
        r111 = null;
        goto L21
    L23:
        BottomSheetBehavior<ForsetiStackChainViewGroup> r116 = r105.f424380g;
        if (r116 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        r116 = null;
    L27:
        if ((r116 instanceof ForsetiStackChainBottomSheetBehavior) == false) goto L29;
        ForsetiStackChainBottomSheetBehavior r117 = (ForsetiStackChainBottomSheetBehavior) r116;
    L30:
        if (r117 == null) goto L32;
        r117.lockToHidden();
        goto L32
    L29:
        r117 = null;
        goto L30
    L9:
        r105 = null;
    L53:
        if (((Boolean) this.f424511q.getValue()).booleanValue() == true) goto L61;
        if (this.f424509o == true) goto L57;
    L64:
        this.f424507m.remove(cib.e.a(r110));
        ForsetiNodeFragment r118 = this.f424497c;
        if (r118 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("nodeContainerFragment");
        r118 = null;
    L67:
        r118.getClass();
        Intrinsics.checkNotNullParameter(r110, "f");
        Iterator<T> r119 = r118.f424514e.entrySet().iterator();
    L69:
        if (r119.hasNext() == false) goto L73;
        Object r120 = r119.next();
        if (Intrinsics.areEqual(((Map.Entry) r120).getValue(), r110) == false) goto L69;
    L74:
        Map.Entry r121 = (Map.Entry) r120;
        if (r121 == null) goto L77;
        Fragment r122 = r118.f424514e.remove(r121.getKey());
    L77:
        Fragment r123 = (Fragment) CollectionsKt.lastOrNull(this.f424503i);
        Map<String, ForsetiNodePiece> r124 = this.f424507m;
        if (r123 == null) goto L80;
        String r125 = cib.e.a(r123);
    L81:
        ForsetiNodePiece r126 = (ForsetiNodePiece) ((LinkedHashMap) r124).get(r125);
        this.f424506l = r126;
        if (r126 == null) goto L88;
        FragmentActivity r127 = this.f424505k;
        if (r127 == null) goto L87;
        r126.a(r127);
        goto L88
    L87:
        throw new IllegalArgumentException("Required value was null.".toString());
    L88:
        ForsetiNodeFragment r128 = this.f424497c;
        if (r128 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("nodeContainerFragment");
        r128 = null;
    L91:
        r128.getClass();
        Intrinsics.checkNotNullParameter(r110, "targetFragment");
        cib.d.a("prepareRemoveTargetFragment");
        Iterator r129 = ((ArrayList) r128.f424513d).iterator();
    L93:
        if (r129.hasNext() == false) goto L97;
        ForsetiNodePiece r130 = (ForsetiNodePiece) r129.next();
        if (Intrinsics.areEqual(r130.f424538g, r110) == false) goto L93;
        r130.onPause();
        r130.onStop();
        cib.d.a("prepareRemoveTargetFragment: removeTargetFragment");
        ((ArrayList) r128.f424513d).remove(r130);
    L98:
        ((ArrayList) this.f424503i).remove(r110);
        if (((Boolean) this.f424511q.getValue()).booleanValue() == false) goto L101;
    L103:
        if (r130 == null) goto L146;
        uua.a r131 = r130.f424553v;
        if (r131 != null) goto L107;
    L109:
        if (r100 == false) goto L134;
        Function2<? super Fragment, ? super Integer, Unit> r132 = this.f424501g;
        Bundle r133 = r130.f424538g.getArguments();
        if (r133 == null) goto L113;
        r133.putBoolean("isRemoving", true);
    L113:
        ForsetiNodeFragment r134 = this.f424497c;
        if (r134 != null) goto L116;
        Intrinsics.throwUninitializedPropertyAccessException("nodeContainerFragment");
        r134 = null;
    L116:
        int r135 = ((ArrayList) r134.f424513d).size();
        d r136 = new d(this, r132, r130, r135);
        e r137 = new e(this, r132, r130, r135);
        Lazy r138 = ForsetiAnimatorLauncher.f424576a;
        if (((Boolean) ForsetiAnimatorLauncher.f424576a.getValue()).booleanValue() == false) goto L130;
        FragmentActivity r139 = this.f424495a.getActivity();
        int r140 = ForsetiNodePiece.f424537y;
        Intrinsics.checkNotNullParameter(r130, "<this>");
        View r141 = r130.l().getView();
        Float r142 = Float.valueOf(0.0f);
        Window r143 = this.f424495a.getActivity().getWindow();
        if (r143 == null) goto L128;
        View r144 = r143.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L125;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r145 = ThreadMethodProxy.currentThread();
        if (r145 == com.larus.home.impl.utils.c.f346341a) goto L125;
        com.larus.home.impl.utils.c.a(r145, "getDecorView");
    L125:
        if (r144 == null) goto L128;
        r102 = Float.valueOf(r144.getWidth());
    L128:
        if (ForsetiAnimatorLauncher.a(r139, r141, r142, r102, r137) == true) goto L147;
        d(r130, r135);
        return;
    L147:
        return;
    L130:
        int r146 = ForsetiNodePiece.f424537y;
        Intrinsics.checkNotNullParameter(r130, "<this>");
        View r147 = r130.l().getView();
        if (r147 != null) goto L133;
        d(r130, r135);
        return;
    L133:
        FragmentActivity r148 = this.f424495a.getActivity();
        Intrinsics.checkNotNullParameter(r148, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r147, "view");
        Animation r149 = AnimationUtils.loadAnimation(r148, R.anim.exit_to_right);
        r149.setInterpolator(PathInterpolatorCompat.create(0.34f, 0.69f, 0.1f, 1.0f));
        r149.setAnimationListener(r136);
        r147.startAnimation(r149);
        return;
    L134:
        ForsetiNodeFragment r150 = this.f424497c;
        if (r150 != null) goto L137;
        Intrinsics.throwUninitializedPropertyAccessException("nodeContainerFragment");
    L138:
        d(r130, ((ArrayList) r101.f424513d).size());
        return;
    L137:
        r101 = r150;
        goto L138
    L107:
        if (r131.f551782a != true) goto L109;
        r100 = true;
        goto L109
    L146:
        return;
    L101:
        if (((ArrayList) this.f424503i).size() != 0) goto L103;
        this.f424508n.clear();
        goto L103
    L97:
        r130 = null;
        goto L98
    L80:
        r125 = null;
        goto L81
    L73:
        r120 = null;
        goto L74
    L57:
        if (((ArrayList) this.f424503i).contains(r110) == false) goto L64;
        Log.i("FST_Node", "Animation in progress, delaying fragment removal(clearDelayQueueTimingFG disable).");
        this.f424508n.add(new ForsetiNode$removeBizFragment$1(this, r110));
        return;
    L61:
        if (this.f424509o == false) goto L64;
        Log.i("FST_Node", "Animation in progress, delaying fragment removal(clearDelayQueueTimingFG enable).");
        this.f424508n.add(new ForsetiNode$removeBizFragment$2(this, r110));
    }

    public ForsetiNode(com.ss.android.lark.forseti.global.e r100, ForsetiChainType r101) {
        Intrinsics.checkNotNullParameter(r100, "forsetiContext");
        Intrinsics.checkNotNullParameter(r101, "chainType");
        this.f424495a = r100;
        this.f424496b = r101;
        ForsetiColumnsDraggingHelper r102 = r100.f424471d;
        ForsetiNodeViewGroup r103 = new ForsetiNodeViewGroup(r100.getActivity(), null);
        r103.setId(View.generateViewId());
        r103.setOnClickListener(b.f424512a);
        this.f424502h = r103;
        this.f424503i = new ArrayList();
        this.f424504j = true;
        this.f424507m = new LinkedHashMap();
        this.f424508n = new CopyOnWriteArrayList();
        this.f424511q = LazyKt.lazy(ForsetiNode$clearDelayQueueTimingFG$2.INSTANCE);
    }

    public final void d(ForsetiNodePiece r100, int r101) {
        r100.onDestroy();
        Function2<? super Fragment, ? super Integer, Unit> r102 = this.f424500f;
        if (r102 == null) goto L5;
        r102.invoke(r100.f424538g, Integer.valueOf(r101));
    L5:
        ForsetiNodeFragment r103 = this.f424497c;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("nodeContainerFragment");
        r103 = null;
    L8:
        ForsetiNodePiece r104 = (ForsetiNodePiece) CollectionsKt.lastOrNull(r103.f424513d);
        if (r104 == null) goto L12;
        r104.onResume();
        return;
    }

    public final void i(FragmentActivity r100, ForsetiWidth r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ViewGroup.LayoutParams r102 = this.f424502h.getLayoutParams();
        if (r101 != null) goto L7;
        Log.e("FST_Node", "updateContentViewWidth failed, forsetiWidth should not be null.");
        return;
    L7:
        if (r102 != null) goto L9;
    L17:
        ForsetiNormalChainViewGroup.b r103 = new ForsetiNormalChainViewGroup.b(r100, -1, -1);
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r103.f424678a = r101;
        this.f424502h.setLayoutParams(r103);
        return;
    L9:
        if ((r102 instanceof ForsetiNormalChainViewGroup.b) == false) goto L17;
        if (((ForsetiNormalChainViewGroup.b) r102).f424678a == r101) goto L19;
        ForsetiNodeViewGroup r104 = this.f424502h;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 == null) goto L16;
        ForsetiNormalChainViewGroup.b r106 = (ForsetiNormalChainViewGroup.b) r105;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r106.f424678a = r101;
        r104.setLayoutParams(r106);
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.android.lark.forseti.widget.ForsetiNormalChainViewGroup.ForsetiChainLayoutParams");
    }

    public final void b(Fragment r110, final String r111, uua.a r112) {
        Intrinsics.checkNotNullParameter(r110, "f");
        Intrinsics.checkNotNullParameter(r111, "tag");
        Intrinsics.checkNotNullParameter(r112, "options");
        Log.i("FST_Node", "addFragment, " + cib.e.a(r110));
        int r100 = ForsetiNodePiece.f424537y;
        FragmentActivity r101 = this.f424495a.getActivity();
        Bundle r102 = r110.getArguments();
        ForsetiNodeFragment r103 = this.f424497c;
        ForsetiNodeFragment r113 = null;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("nodeContainerFragment");
        ForsetiNodeFragment r104 = null;
    L6:
        com.ss.android.lark.forseti.global.e r105 = this.f424495a;
        ForsetiNodePiece r106 = ForsetiNodePiece.a.a(r101, r110, r102, null, r104, r105.f424472e, r105.f424469b.f424459a, r112);
        r106.f424544m = r112.f551783b;
        this.f424506l = r106;
        this.f424507m.put(cib.e.a(r110), this.f424506l);
        ForsetiNodePiece r107 = this.f424506l;
        if (r107 == null) goto L13;
        FragmentActivity r108 = this.f424505k;
        if (r108 == null) goto L12;
        Intrinsics.checkNotNullParameter(r107, "<this>");
        Intrinsics.checkNotNullParameter(r108, "hostActivity");
        r107.a(r108);
        Log.i("ForsetiNodePiece", "forsetiNodePiece attach");
        goto L13
    L12:
        throw new IllegalArgumentException("Required value was null.".toString());
    L13:
        Log.i("FST_Node", "uniqueFragmentTag = " + r111 + ", fragment = " + r110.getClass().getName());
        ForsetiNodeFragment r109 = this.f424497c;
        if (r109 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("nodeContainerFragment");
        r109 = null;
    L16:
        r109.getClass();
        Intrinsics.checkNotNullParameter(r111, "uniqueTag");
        Intrinsics.checkNotNullParameter(r110, "f");
        r109.f424514e.put(r111, r110);
        int r114 = fib.a.f477428a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.delete_placeholder_disabled") == true) goto L24;
        ((ArrayList) this.f424503i).add(r110);
        ForsetiNodeFragment r115 = this.f424497c;
        if (r115 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("nodeContainerFragment");
    L22:
        r113.T90(this.f424506l, new ForsetiNode$addFragment$2(this, r111));
        return;
    L21:
        r113 = r115;
        goto L22
    L24:
        ForsetiNodeFragment r116 = this.f424497c;
        if (r116 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("nodeContainerFragment");
    L28:
        r113.T90(this.f424506l, new ForsetiNode$addFragment$3(this, r111));
        ((ArrayList) this.f424503i).add(r110);
        return;
    L27:
        r113 = r116;
        goto L28
    L5:
        r104 = r103;
        goto L6
    }
}
