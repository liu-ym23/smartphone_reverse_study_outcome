package com.ss.android.lark.forseti.node;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.ss.android.lark.api.bean.ForsetiMode;
import com.ss.android.lark.api.bean.ForsetiWidth;
import com.ss.android.lark.api.bean.NodePieceCustomState;
import com.ss.android.lark.api.ui.ForsetiPlaceHolderFragment;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.forseti.chain.ForsetiChainFragment;
import com.ss.android.lark.forseti.global.ForsetiActivityChainManager;
import com.ss.android.lark.forseti.node.piece.ForsetiNodePiece;
import com.ss.android.lark.forseti.widget.MinChildHeightFrameLayout;
import com.ss.android.lark.insets.AndroidQInsetsDispatchCompat;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 72\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0016\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0001J\u000e\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0001J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u0011*\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u001e\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u00112\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0#J\b\u0010$\u001a\u0004\u0018\u00010\u0011J\u0010\u0010%\u001a\u0004\u0018\u00010\u00112\u0006\u0010&\u001a\u00020\u0001J\u0006\u0010'\u001a\u00020\rJ\u0006\u0010(\u001a\u00020\rJ\b\u0010)\u001a\u00020\rH\u0016J\b\u0010*\u001a\u00020\rH\u0016J\b\u0010+\u001a\u00020 H\u0002J\b\u0010,\u001a\u00020\rH\u0016J\b\u0010-\u001a\u00020\rH\u0016J\b\u0010.\u001a\u00020\rH\u0016J\u0010\u0010/\u001a\u00020\r2\u0006\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020\rH\u0016J\u0016\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u000104j\b\u0012\u0004\u0012\u00020\u0001`5J\b\u00106\u001a\u00020\u0016H\u0016R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R-\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015j\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0001`\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u00068"}, d2 = {"Lcom/ss/android/lark/forseti/node/ForsetiNodeFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "forsetiNodePieceStack", "", "Lcom/ss/android/lark/forseti/node/piece/ForsetiNodePiece;", "getForsetiNodePieceStack", "()Ljava/util/List;", "forsetiNodePieceTagHashMap", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "getForsetiNodePieceTagHashMap", "()Ljava/util/LinkedHashMap;", "putUniqueTag", "uniqueTag", "f", "removeTag", "findTopForsetiNodePiece", "pushForsetiNodePieceStack", "", "forsetiNodePiece", "commitFragment", "Lkotlin/Function0;", "popForsetiNodePieceStack", "prepareRemoveTargetFragment", "targetFragment", "topForsetiNodePieceMoveToOnResume", "topForsetiNodePieceMoveToOnStop", WidgetCostModule.TYPE_ON_START, "onResume", "dispatchOnResumeOrNot", "onPause", "onStop", LiveCommonConstants.REASON_ON_DEDTROY, "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onLowMemory", "getBizFragments", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "toString", "Companion", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForsetiNodeFragment extends Fragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<ForsetiNodePiece> f424513d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedHashMap<String, Fragment> f424514e;

    public static final class a {
    }

    static {
    }

    @Override // androidx.fragment.app.Fragment
    public final String toString() {
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L14
        ForsetiNodePiece r102 = (ForsetiNodePiece) CollectionsKt.lastOrNull(this.f424513d);     // Catch: Throwable -> L14
        if (r102 == null) goto L6;
        Fragment r103 = r102.f424538g;     // Catch: Throwable -> L14
    L8:
        if ((r103 instanceof ForsetiPlaceHolderFragment) == true) goto L10;
    L12:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L14
    L17:
        if (Result.m9455isFailureimpl(r104) == true) goto L21;
        r100 = r104;
    L21:
        return super.toString() + "->" + ((Fragment) r100);
    L10:
        if ((!((ForsetiPlaceHolderFragment) r103).getChildFragmentManager().getFragments().isEmpty()) == false) goto L12;
        r103 = (Fragment) CollectionsKt.last(((ForsetiPlaceHolderFragment) r103).getChildFragmentManager().getFragments());     // Catch: Throwable -> L14
        goto L12
    L6:
        r103 = null;
    L14:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    public ForsetiNodeFragment() {
        this.f424513d = new ArrayList();
        this.f424514e = new LinkedHashMap();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        cib.d.a(LiveCommonConstants.REASON_ON_DEDTROY);
        Iterator r100 = ((ArrayList) this.f424513d).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((ForsetiNodePiece) r100.next()).onDestroy();
        goto L4
    L6:
        ((ArrayList) this.f424513d).clear();
        this.f424514e.clear();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onLowMemory() {
        super.onLowMemory();
        cib.d.a("onLowMemory");
        Iterator r100 = ((ArrayList) this.f424513d).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((ForsetiNodePiece) r100.next()).i().dispatchLowMemory();
        goto L4
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        cib.d.a("onPause");
        ForsetiNodePiece r100 = S90(this.f424513d);
        if (r100 == null) goto L6;
        r100.onPause();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        cib.d.a("onResume");
        int r100 = com.ss.android.lark.forseti.global.b.f424462a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.dispatch_resume_optimizeV2") == true) goto L47;
        sua.a r101 = (sua.a) ApiUtils.getApi(sua.a.class);
        Context r102 = getContext();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        tua.b r103 = r101.tryGetChainManager((FragmentActivity) r102);
        ForsetiNodeFragment r104 = null;
        if (r103 == null) goto L7;
        ForsetiChainFragment r105 = r103.v();
    L9:
        if ((r105 instanceof ForsetiChainFragment) == true) goto L12;
        r105 = null;
    L12:
        if (r105 != null) goto L15;
    L42:
        boolean r106 = true;
    L43:
        if (r106 == false) goto L51;
        ForsetiNodePiece r107 = S90(this.f424513d);
        if (r107 == null) goto L52;
        r107.onResume();
        return;
    L52:
        return;
    L51:
        return;
    L15:
        if (r103.T() != ForsetiMode.Compact) goto L20;
        ForsetiNode r108 = r105.aa0();
        if (r108 == null) goto L19;
        r104 = r108.f();
    L19:
        r106 = Intrinsics.areEqual(r104, this);
        goto L43
    L20:
        ForsetiNode r109 = r105.aa0();
        if (r109 == null) goto L23;
        ForsetiWidth r110 = r109.e();
    L25:
        if (r110 != ForsetiWidth.FULL) goto L27;
        r106 = Intrinsics.areEqual(r109.f(), this);
        goto L43
    L27:
        ForsetiNode r111 = r105.aa0();
        if (r111 == null) goto L30;
        ForsetiNodeFragment r112 = r111.f();
    L31:
        ForsetiNode r113 = r105.aa0();
        if (r113 == null) goto L37;
        ForsetiNode r114 = r113.f424498d;
        if (r114 == null) goto L37;
        r104 = r114.f();
    L37:
        if (Intrinsics.areEqual(r104, this) == true) goto L42;
        if (Intrinsics.areEqual(r112, this) == true) goto L42;
        r106 = false;
        goto L43
    L30:
        r112 = null;
        goto L31
    L23:
        r110 = null;
        goto L25
    L7:
        r105 = null;
        goto L9
    L47:
        ForsetiNodePiece r115 = S90(this.f424513d);
        if (r115 == null) goto L54;
        r115.onResume();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        cib.d.a(WidgetCostModule.TYPE_ON_START);
        ForsetiNodePiece r100 = S90(this.f424513d);
        if (r100 == null) goto L6;
        r100.onStart();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        cib.d.a("onStop");
        ForsetiNodePiece r100 = S90(this.f424513d);
        if (r100 == null) goto L6;
        r100.onStop();
        return;
    }

    public static ForsetiNodePiece S90(List r100) {
        return (ForsetiNodePiece) CollectionsKt.lastOrNull(r100);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        cib.d.a("onConfigurationChanged");
        Iterator r101 = ((ArrayList) this.f424513d).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ForsetiNodePiece r102 = (ForsetiNodePiece) r101.next();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        r102.i().noteStateNotSaved();
        r102.i().dispatchConfigurationChanged(r100);
        goto L4
    }

    public final void T90(ForsetiNodePiece r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r101, "commitFragment");
        ForsetiNodePiece r102 = (ForsetiNodePiece) CollectionsKt.lastOrNull(this.f424513d);
        if (r100 == null) goto L10;
        r100.i().attachHost(r100.f424541j);
        Fragment r103 = r100.l();
        int r104 = fib.a.f477428a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.slardar_crash_disabled") == false) goto L7;
    L8:
        r103.setArguments(r100.f424540i);
    L9:
        r100.getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        r100.i().dispatchCreate();
        r100.i().dispatchActivityCreated();
        goto L10
    L7:
        if (r103.isStateSaved() == true) goto L9;
    L10:
        if (r100 == null) goto L12;
        r100.onStart();
    L12:
        if (r100 == null) goto L14;
        r100.onResume();
    L14:
        if (r100 == null) goto L16;
        ((ArrayList) this.f424513d).add(r100);
    L16:
        r101.invoke();
        if (r102 == null) goto L19;
        r102.onPause();
    L19:
        if (r102 == null) goto L24;
        Intrinsics.checkNotNullParameter(NodePieceCustomState.COVERED_BY_FORSETI, "state");
        int r105 = ForsetiNodePiece.f424537y;
        ForsetiActivityChainManager.b r106 = r102.f424547p;
        if (r106 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("forsetiStructureNotifier");
        r106 = null;
    L23:
        r106.a();
    L24:
        if (r102 == null) goto L27;
        r102.onStop();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Log.i("FST_NodeFragment", "onViewCreated.");
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        MinChildHeightFrameLayout r103 = new MinChildHeightFrameLayout(r100.getContext(), null);
        AndroidQInsetsDispatchCompat.a(r103);
        r103.setId(R.id.forseti_node_view_group);
        return r103;
    }
}
