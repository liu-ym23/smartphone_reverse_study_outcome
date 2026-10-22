package com.ss.android.lark.forseti.node.piece;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentController;
import androidx.fragment.app.FragmentHostCallback;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.lark.api.bean.ForsetiMode;
import com.ss.android.lark.api.bean.NodePieceCustomState;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.forseti.global.ForsetiActivityChainManager;
import com.ss.android.lark.forseti.node.ForsetiNodeFragment;
import com.ss.android.lark.forseti.widget.MinChildHeightFrameLayout;
import com.ss.android.lark.insets.AndroidQInsetsDispatchCompat;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.vivo.push.PushClientConstants;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000é\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001V\u0018\u0000 \u0086\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\b\u0086\u0001\u0087\u0001\u0088\u0001\u0089\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010Z\u001a\u00020\u0007H\u0002J\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00070\\J\u001c\u0010]\u001a\u0004\u0018\u00010^2\u0006\u0010_\u001a\u00020`2\b\u0010a\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010b\u001a\u00020cH\u0016J\u0012\u0010d\u001a\u00020c2\b\u0010e\u001a\u0004\u0018\u00010\u0017H\u0016J\u0018\u0010f\u001a\u00020c2\u0006\u0010g\u001a\u00020\u000e2\u0006\u0010h\u001a\u00020\u0007H\u0002J\u0010\u0010i\u001a\u00020c2\u0006\u0010g\u001a\u00020\u000eH\u0002J\u0010\u0010j\u001a\u00020c2\u0006\u0010k\u001a\u00020\u0017H\u0016J\b\u0010l\u001a\u00020cH\u0002J\u0018\u0010m\u001a\u00020*2\u0006\u0010n\u001a\u00020@2\u0006\u0010o\u001a\u00020pH\u0002J\u0010\u0010q\u001a\u00020c2\u0006\u0010r\u001a\u00020\u000eH\u0002J\b\u0010s\u001a\u00020*H\u0002J\b\u0010t\u001a\u00020cH\u0016J\b\u0010u\u001a\u00020cH\u0016J\b\u0010v\u001a\u00020cH\u0016J\b\u0010w\u001a\u00020cH\u0016J\b\u0010x\u001a\u00020cH\u0016J\b\u0010y\u001a\u00020cH\u0016J\u0010\u0010z\u001a\u00020c2\u0006\u0010{\u001a\u00020\u0017H\u0016J\u0010\u0010|\u001a\u00020c2\u0006\u0010}\u001a\u00020~H\u0016J\u0011\u0010\u007f\u001a\u00020c2\u0007\u0010\u0080\u0001\u001a\u00020*H\u0016J\t\u0010\u0081\u0001\u001a\u00020cH\u0016J\t\u0010\u0082\u0001\u001a\u00020*H\u0016J\u0010\u0010\u0083\u0001\u001a\u00020c2\u0007\u0010o\u001a\u00030\u0084\u0001J\t\u0010\u0085\u0001\u001a\u00020cH\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR9\u0010\f\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001b\u00100\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b2\u00103R\u001b\u00106\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b8\u00105\u001a\u0004\b7\u0010\u000bR\u000e\u00109\u001a\u00020:X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010?\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u00105\u001a\u0004\bA\u0010BR\u0014\u0010D\u001a\b\u0012\u0004\u0012\u00020F0EX\u0082\u000e¢\u0006\u0002\n\u0000R6\u0010G\u001a*\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020J0I0Hj\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020J0I`KX\u0082\u000e¢\u0006\u0002\n\u0000R6\u0010L\u001a*\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020M0I0Hj\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020M0I`KX\u0082\u000e¢\u0006\u0002\n\u0000RB\u0010N\u001a6\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0O0I0Hj\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0O0I`KX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010R\u001a\u0004\u0018\u00010Q2\b\u0010P\u001a\u0004\u0018\u00010Q@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u0010\u0010U\u001a\u00020VX\u0082\u0004¢\u0006\u0004\n\u0002\u0010WR\u000e\u0010X\u001a\u00020YX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u008a\u0001"}, d2 = {"Lcom/ss/android/lark/forseti/node/piece/ForsetiNodePiece;", "Lcom/ss/android/lark/forseti/node/piece/ForsetiNodeBasePiece;", "Lcom/ss/android/lark/forseti/node/piece/IForsetiPieceLifecycle;", "Lcom/ss/android/lark/api/util/IForsetiNodePieceCustomStateMonitor;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "rootFragment", "Landroidx/fragment/app/Fragment;", "<init>", "(Landroid/content/Context;Landroidx/fragment/app/Fragment;)V", "getRootFragment", "()Landroidx/fragment/app/Fragment;", "rootFragmentFactory", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", PushClientConstants.TAG_CLASS_NAME, "getRootFragmentFactory", "()Lkotlin/jvm/functions/Function1;", "setRootFragmentFactory", "(Lkotlin/jvm/functions/Function1;)V", "arguments", "Landroid/os/Bundle;", "getArguments", "()Landroid/os/Bundle;", "setArguments", "(Landroid/os/Bundle;)V", "forsetiNodeFragment", "Lcom/ss/android/lark/forseti/node/ForsetiNodeFragment;", "getForsetiNodeFragment", "()Lcom/ss/android/lark/forseti/node/ForsetiNodeFragment;", "setForsetiNodeFragment", "(Lcom/ss/android/lark/forseti/node/ForsetiNodeFragment;)V", "fragmentRemovingListener", "", "Lcom/ss/android/lark/api/ui/IForsetiFragmentRemovingListener;", "getFragmentRemovingListener", "()Ljava/util/List;", "setFragmentRemovingListener", "(Ljava/util/List;)V", "isDestroyed", "", "usePageTransformAnimation", "getUsePageTransformAnimation", "()Z", "setUsePageTransformAnimation", "(Z)V", "fragmentController", "Landroidx/fragment/app/FragmentController;", "getFragmentController", "()Landroidx/fragment/app/FragmentController;", "fragmentController$delegate", "Lkotlin/Lazy;", "forsetiNodePieceFragment", "getForsetiNodePieceFragment", "forsetiNodePieceFragment$delegate", "forsetiStructureNotifier", "Lcom/ss/android/lark/forseti/global/ForsetiActivityChainManager$ForsetiStructureNotifier;", "placeMode", "Lcom/ss/android/lark/api/bean/ForsetiMode;", "notifyUserLifecycleChangedCallbacks", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "getFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "fragmentManager$delegate", "mLaunchedFragments", "Ljava/util/ArrayDeque;", "Lcom/ss/android/lark/forseti/node/piece/ForsetiNodePiece$ForsetiLaunchFragmentInfos;", "mStartActivityForResults", "Ljava/util/HashMap;", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "Lkotlin/collections/HashMap;", "mStartIntentSenderForResults", "Landroidx/activity/result/IntentSenderRequest;", "mRequestPermissions", "", "value", "Lcom/ss/android/lark/api/bean/ForsetiInnerOptions;", "options", "getOptions", "()Lcom/ss/android/lark/api/bean/ForsetiInnerOptions;", "fragmentLifecycleCallback", "com/ss/android/lark/forseti/node/piece/ForsetiNodePiece$fragmentLifecycleCallback$1", "Lcom/ss/android/lark/forseti/node/piece/ForsetiNodePiece$fragmentLifecycleCallback$1;", "dispatcher", "Landroidx/activity/OnBackPressedDispatcher;", "requireFragment", "getBizFragments", "", "createView", "Landroid/view/View;", "containerId", "", "tag", "removeAllViews", "", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "registerStartActivityForResult", "who", WidgetService.PARAM_FRAGMENT, "unregisterStartActivityForResult", "onSaveInstanceState", "outState", "markFragmentsCreated", "markState", "manager", "state", "Landroidx/lifecycle/Lifecycle$State;", "dispatchedFragmentLogger", "lifeCycleEvent", "executeLifecycleAction", WidgetCostModule.TYPE_ON_START, "onResume", "onPause", "onStop", LiveCommonConstants.REASON_ON_DEDTROY, "onActivityResult", "onNewIntent", "bundle", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onMultiWindowModeChanged", "isInMultiWindowMode", "onLowMemory", "isCoveredByForsetiNode", "setNodePieceCustomState", "Lcom/ss/android/lark/api/bean/NodePieceCustomState;", "clearCache", "Companion", "ForsetiNodePieceFragment", "ForsetiNodePieceHostCallBacks", "ForsetiLaunchFragmentInfos", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForsetiNodePiece extends ForsetiNodeBasePiece {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f424537y = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Fragment f424538g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function1<? super String, ? extends Fragment> f424539h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Bundle f424540i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ForsetiNodeFragment f424541j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<com.ss.android.lark.api.ui.a> f424542k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f424543l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f424544m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f424545n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f424546o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ForsetiActivityChainManager.b f424547p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f424548q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ArrayDeque<b> f424549r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final HashMap<String, ActivityResultLauncher<Intent>> f424550s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final HashMap<String, ActivityResultLauncher<IntentSenderRequest>> f424551t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final HashMap<String, ActivityResultLauncher<String[]>> f424552u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public uua.a f424553v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ForsetiNodePiece$fragmentLifecycleCallback$1 f424554w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final OnBackPressedDispatcher f424555x;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/forseti/node/piece/ForsetiNodePiece$ForsetiNodePieceFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ForsetiNodePieceFragment extends Fragment {

        public static final class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f424556a = null;

            static {
                f424556a = new a();
            }

            public a() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                Log.i("ForsetiNodePiece", "intercept click.");
            }
        }

        public ForsetiNodePieceFragment() {
        }

        @Override // androidx.fragment.app.Fragment
        public final void onViewCreated(View r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super.onViewCreated(r100, r101);
            r100.setOnClickListener(a.f424556a);
        }

        @Override // androidx.fragment.app.Fragment
        public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
            Intrinsics.checkNotNullParameter(r100, "inflater");
            MinChildHeightFrameLayout r103 = new MinChildHeightFrameLayout(r100.getContext(), null);
            AndroidQInsetsDispatchCompat.a(r103);
            r103.setId(View.generateViewId());
            return r103;
        }
    }

    @Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u00032\u00020\u0004B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ,\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016JN\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0017J+\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010\u0013\u001a\u00020\nH\u0017¢\u0006\u0002\u0010 J\u0012\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\nH\u0016J\n\u0010$\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u00101\u001a\u0002022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\u0002022\u0006\u00106\u001a\u00020\u001fH\u0016J\b\u00107\u001a\u000202H\u0016J\b\u00108\u001a\u00020\nH\u0016J\b\u00109\u001a\u000202H\u0016R\u0014\u0010%\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020*8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020.8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u0006:"}, d2 = {"Lcom/ss/android/lark/forseti/node/piece/ForsetiNodePiece$ForsetiNodePieceHostCallBacks;", "Landroidx/fragment/app/FragmentHostCallback;", "Landroid/app/Activity;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Landroidx/activity/OnBackPressedDispatcherOwner;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "handler", "Landroid/os/Handler;", "windowAnimations", "", "<init>", "(Lcom/ss/android/lark/forseti/node/piece/ForsetiNodePiece;Landroid/content/Context;Landroid/os/Handler;I)V", "onStartActivityFromFragment", "", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "intent", "Landroid/content/Intent;", "requestCode", "options", "Landroid/os/Bundle;", "onStartIntentSenderFromFragment", "Landroid/content/IntentSender;", "fillInIntent", "flagsMask", "flagsValues", "extraFlags", "onRequestPermissionsFromFragment", ComplianceResult.JsonKey.PERMISSIONS, "", "", "(Landroidx/fragment/app/Fragment;[Ljava/lang/String;I)V", "onFindViewById", "Landroid/view/View;", "id", "onGetHost", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "getViewModelStore", "()Landroidx/lifecycle/ViewModelStore;", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "onBackPressedDispatcher", "Landroidx/activity/OnBackPressedDispatcher;", "getOnBackPressedDispatcher", "()Landroidx/activity/OnBackPressedDispatcher;", "onShouldSaveFragmentState", "", "onGetLayoutInflater", "Landroid/view/LayoutInflater;", "onShouldShowRequestPermissionRationale", "permission", "onHasWindowAnimations", "onGetWindowAnimations", "onHasView", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ForsetiNodePieceHostCallBacks extends FragmentHostCallback<Activity> implements ViewModelStoreOwner, OnBackPressedDispatcherOwner {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ForsetiNodePiece f424557a;

        @Override // androidx.lifecycle.LifecycleOwner
        public final Lifecycle getLifecycle() {
            return this.f424557a.getLifecycleRegistry();
        }

        @Override // androidx.activity.OnBackPressedDispatcherOwner
        public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return this.f424557a.f424555x;
        }

        @Override // androidx.lifecycle.ViewModelStoreOwner
        public final ViewModelStore getViewModelStore() {
            return this.f424557a.getViewModelStore();
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public final Activity onGetHost() {
            return this.f424557a.getActivity();
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public final LayoutInflater onGetLayoutInflater() {
            LayoutInflater r100 = this.f424557a.f424534d;
            if (r100 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("layoutInflater");
            r100 = null;
        L7:
            return r100.cloneInContext(this.f424557a.b());
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public final int onGetWindowAnimations() {
            FragmentActivity r100 = this.f424557a.getActivity();
            if (r100 == null) goto L9;
            Window r101 = r100.getWindow();
            if (r101 == null) goto L9;
            WindowManager.LayoutParams r102 = r101.getAttributes();
            if (r102 == null) goto L9;
            return r102.windowAnimations;
        L9:
            return 0;
        }

        @Override // androidx.fragment.app.FragmentHostCallback, androidx.fragment.app.FragmentContainer
        public final boolean onHasView() {
            FragmentActivity r100 = this.f424557a.getActivity();
            View r101 = null;
            if (r100 == null) goto L5;
            Window r102 = r100.getWindow();
        L6:
            if (r102 == null) goto L8;
            r101 = r102.peekDecorView();
        L8:
            if (r101 == null) goto L10;
            return true;
        L10:
            return false;
        L5:
            r102 = null;
            goto L6
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public final boolean onHasWindowAnimations() {
            FragmentActivity r100 = this.f424557a.getActivity();
            if (r100 == null) goto L5;
            Window r101 = r100.getWindow();
        L6:
            if (r101 == null) goto L8;
            return true;
        L8:
            return false;
        L5:
            r101 = null;
            goto L6
        }

        @Override // androidx.fragment.app.FragmentHostCallback, androidx.fragment.app.FragmentContainer
        public final View onFindViewById(int r100) {
            ForsetiNodeFragment r101 = this.f424557a.f424541j;
            if (r101 == null) goto L7;
            View r102 = r101.getView();
            if (r102 == null) goto L7;
            return r102.findViewById(r100);
        L7:
            return null;
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public final boolean onShouldSaveFragmentState(Fragment r100) {
            Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
            return this.f424557a.f424543l;
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public final boolean onShouldShowRequestPermissionRationale(String r100) {
            Intrinsics.checkNotNullParameter(r100, "permission");
            return ActivityCompat.shouldShowRequestPermissionRationale(this.f424557a.b(), r100);
        }

        public ForsetiNodePieceHostCallBacks(ForsetiNodePiece r100, FragmentActivity r101, Handler r102) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r102, "handler");
            this.f424557a = r100;
            super(r101, r102, 0);
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        @Deprecated(message = "Deprecated in Java", replaceWith = @ReplaceWith(expression = "super.onRequestPermissionsFromFragment(fragment, permissions, requestCode)", imports = {"androidx.fragment.app.FragmentHostCallback"}))
        public final void onRequestPermissionsFromFragment(Fragment r100, String[] r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
            Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
            String r103 = UUID.randomUUID().toString();
            ForsetiNodePiece.c(this.f424557a, r103, r100);
            this.f424557a.f424549r.addLast(new b("RequestMultiplePermissions: " + r103, r102));
            ActivityResultLauncher<String[]> r104 = this.f424557a.f424552u.get(r103);
            if (r104 == null) goto L6;
            r104.launch(r101);
            return;
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public final void onStartActivityFromFragment(Fragment r100, Intent r101, int r102, Bundle r103) {
            Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
            String r104 = UUID.randomUUID().toString();
            ForsetiNodePiece.c(this.f424557a, r104, r100);
            this.f424557a.f424549r.addLast(new b("StartActivityForResult: " + r104, r102));
            if (r101 == null) goto L6;
            if (r103 == null) goto L6;
            r101.putExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE, r103);
        L6:
            ActivityResultLauncher<Intent> r105 = this.f424557a.f424550s.get(r104);
            if (r105 == null) goto L10;
            r105.launch(r101);
            return;
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        @Deprecated(message = "Deprecated in Java")
        public final void onStartIntentSenderFromFragment(Fragment r100, IntentSender r101, int r102, Intent r103, int r104, int r105, int r106, Bundle r110) {
            Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
            String r107 = UUID.randomUUID().toString();
            ForsetiNodePiece.c(this.f424557a, r107, r100);
            if (r110 == null) goto L8;
            if (r103 != null) goto L6;
            Intent r108 = new Intent();
            r108.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
        L7:
            r108.putExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE, r110);
            goto L8
        L6:
            r108 = r103;
        L8:
            Intrinsics.checkNotNull(r101);
            IntentSenderRequest r109 = new IntentSenderRequest.Builder(r101).setFillInIntent(r103).setFlags(r105, r104).build();
            this.f424557a.f424549r.addLast(new b("StartIntentSenderForResult: " + r107, r102));
            ActivityResultLauncher<IntentSenderRequest> r111 = this.f424557a.f424551t.get(r107);
            if (r111 == null) goto L12;
            r111.launch(r109);
            return;
        }
    }

    public static final class a {
        @JvmStatic
        public static ForsetiNodePiece a(FragmentActivity r100, Fragment r101, Bundle r102, Function1 r103, ForsetiNodeFragment r104, ForsetiActivityChainManager.b r105, ForsetiMode r106, uua.a r107) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "rootFragment");
            Intrinsics.checkNotNullParameter(r105, "forsetiStructureNotifier");
            Intrinsics.checkNotNullParameter(r106, "placeMode");
            ForsetiNodePiece r108 = new ForsetiNodePiece(r100, r101);
            r108.f424540i = r102;
            r108.f424539h = r103;
            r108.f424541j = r104;
            r108.f424547p = r105;
            r108.f424553v = r107;
            return r108;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f424558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f424559b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f424558a, r101.f424558a) == true) goto L12;
            return false;
        L12:
            if (this.f424559b == r101.f424559b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f424558a.hashCode() * 31) + this.f424559b;
        }

        public final String toString() {
            return "ForsetiLaunchFragmentInfos(mWho=" + this.f424558a + ", mRequestCode=" + this.f424559b + ')';
        }

        public b(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "mWho");
            this.f424558a = r100;
            this.f424559b = r101;
        }
    }

    static {
        NodePieceCustomState r100 = NodePieceCustomState.NORMAL;
    }

    public final FragmentController i() {
        return (FragmentController) this.f424545n.getValue();
    }

    public final FragmentManager j() {
        return (FragmentManager) this.f424548q.getValue();
    }

    public final Fragment l() {
        Fragment r100 = this.f424538g;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final boolean h() {
        if (j().isDestroyed() == true) goto L6;
        return true;
    L6:
        Log.e("ForsetiNodePiece", "Fragment host is destroyed or null.");
        return false;
    }

    public final void onDestroy() {
        if (h() == true) goto L5;
        return;
    L5:
        g(LiveCommonConstants.REASON_ON_DEDTROY);
        this.f424543l = true;
        Fragment r100 = l();     // Catch: Exception -> L8
        j().beginTransaction().remove(r100).commitNowAllowingStateLoss();     // Catch: Exception -> L8
        i().dispatchDestroy();     // Catch: Exception -> L8
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);     // Catch: Exception -> L8
    L10:
        j().unregisterFragmentLifecycleCallbacks(this.f424554w);
        Iterator<Map.Entry<String, ActivityResultLauncher<Intent>>> r101 = this.f424550s.entrySet().iterator();
    L12:
        if (r101.hasNext() == false) goto L14;
        r101.next().getValue().unregister();
        goto L12
    L14:
        Iterator<Map.Entry<String, ActivityResultLauncher<IntentSenderRequest>>> r102 = this.f424551t.entrySet().iterator();
    L16:
        if (r102.hasNext() == false) goto L18;
        r102.next().getValue().unregister();
        goto L16
    L18:
        Iterator<Map.Entry<String, ActivityResultLauncher<String[]>>> r103 = this.f424552u.entrySet().iterator();
    L20:
        if (r103.hasNext() == false) goto L22;
        r103.next().getValue().unregister();
        goto L20
    L22:
        this.f424550s.clear();
        this.f424551t.clear();
        this.f424552u.clear();
        ((ArrayList) this.f424542k).clear();
        return;
    L8:
        e = move-exception;
        Log.e("ForsetiNodePiece", "onDestroy: ", e);
        goto L10
    }

    public final void onPause() {
        if (h() == true) goto L5;
        return;
    L5:
        g("onPause");
        if (this.f424538g.getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) goto L8;
        i().dispatchPause();
    L8:
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    public final void onResume() {
        if (h() == true) goto L5;
        return;
    L5:
        g("onResume");
        i().noteStateNotSaved();
        i().execPendingActions();
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        i().dispatchResume();
    }

    public final void onStart() {
        if (h() == true) goto L5;
        return;
    L5:
        g(WidgetCostModule.TYPE_ON_START);
        Intrinsics.checkNotNullParameter(NodePieceCustomState.NORMAL, "state");
        ForsetiActivityChainManager.b r100 = this.f424547p;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("forsetiStructureNotifier");
        r100 = null;
    L8:
        r100.a();
        i().noteStateNotSaved();
        i().execPendingActions();
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_START);
        i().dispatchStart();
    }

    public final void onStop() {
        if (h() == true) goto L5;
        return;
    L5:
        g("onStop");
    L7:
        if (k(j(), Lifecycle.State.CREATED) == true) goto L7;
        int r100 = fib.a.f477428a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.slardar_crash_disabled") == false) goto L17;
        i().dispatchStop();
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        return;
    L17:
        i().dispatchStop();     // Catch: Exception -> L12
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_STOP);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        Log.e("ForsetiNodePiece", "onStop: ", e);
    }

    public final void g(String r100) {
        Log.i("ForsetiNodePiece", r100 + ", " + cib.e.a(l()));
    }

    /* JADX WARN: Type inference failed for: r3v14, types: [com.ss.android.lark.forseti.node.piece.ForsetiNodePiece$fragmentLifecycleCallback$1] */
    public ForsetiNodePiece(final FragmentActivity r100, Fragment r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "rootFragment");
        this.f424538g = r101;
        this.f424542k = new ArrayList();
        this.f424544m = true;
        this.f424545n = LazyKt.lazy(new ForsetiNodePiece$fragmentController$2(this));
        this.f424546o = LazyKt.lazy(ForsetiNodePiece$forsetiNodePieceFragment$2.INSTANCE);
        ForsetiMode.a r102 = ForsetiMode.CREATOR;
        this.f424548q = LazyKt.lazy(new ForsetiNodePiece$fragmentManager$2(this));
        this.f424549r = new ArrayDeque();
        this.f424550s = new HashMap();
        this.f424551t = new HashMap();
        this.f424552u = new HashMap();
        this.f424554w = new ForsetiNodePiece$fragmentLifecycleCallback$1(this, r100);
        this.f424555x = new OnBackPressedDispatcher(new com.ss.android.lark.forseti.node.piece.a(this));
    }

    public static final void e(ForsetiNodePiece r100, String r101) {
        ActivityResultLauncher<Intent> r102 = r100.f424550s.get(r101);
        if (r102 == null) goto L5;
        r102.unregister();
    L5:
        ActivityResultLauncher<IntentSenderRequest> r103 = r100.f424551t.get(r101);
        if (r103 == null) goto L8;
        r103.unregister();
    L8:
        ActivityResultLauncher<String[]> r104 = r100.f424552u.get(r101);
        if (r104 == null) goto L11;
        r104.unregister();
    L11:
        r100.f424550s.remove(r101);
        r100.f424551t.remove(r101);
        r100.f424552u.remove(r101);
    }

    public static boolean k(FragmentManager r100, Lifecycle.State r101) {
        Iterator<Fragment> r102 = r100.getFragments().iterator();
        boolean r103 = false;
    L4:
        if (r102.hasNext() == false) goto L11;
        Fragment r104 = r102.next();
        if (r104.getHost() == null) goto L9;
        r103 = r103 | k(r104.getChildFragmentManager(), r101);
    L9:
        if (r104.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L4;
        Lifecycle r105 = r104.getLifecycle();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type androidx.lifecycle.LifecycleRegistry");
        ((LifecycleRegistry) r105).setCurrentState(r101);
        r103 = true;
        goto L4
    L11:
        return r103;
    }

    public final void f(int r100, String r101) {
        Fragment r102 = l();
        if (r101 != null) goto L5;
        String r103 = "root_fragment";
    L7:
        if (r101 != null) goto L9;
        r101 = "root_fragment";
    L9:
        String r104 = "fst_node_piece_".concat(r101);
        Log.i("ForsetiNodePiece", "isAttached = " + l().isAdded() + ", fragment = " + cib.e.a(r102));
    L25:
        e = move-exception;
        Log.e("ForsetiNodePiece", "createView error", e);
    L27:
        r102.getView();
        return;
    L11:
        if (j().findFragmentByTag(r104) != null) goto L18;
        FragmentTransaction r105 = j().beginTransaction();     // Catch: Exception -> L25
        Fragment r106 = (Fragment) this.f424546o.getValue();     // Catch: Exception -> L25
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r105, r106, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r104, r100) == true) goto L16;
        r105.add(r100, r106, r104);     // Catch: Exception -> L25
    L16:
        r105.commitNowAllowingStateLoss();     // Catch: Exception -> L25
    L18:
        if (j().findFragmentByTag(r103) != null) goto L27;
        FragmentTransaction r107 = j().beginTransaction();     // Catch: Exception -> L25
        int r108 = ((Fragment) this.f424546o.getValue()).requireView().getId();     // Catch: Exception -> L25
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r107, r102, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r103, r108) == true) goto L23;
        r107.add(r108, r102, r103);     // Catch: Exception -> L25
    L23:
        r107.commitNowAllowingStateLoss();     // Catch: Exception -> L25
        goto L27
    L5:
        r103 = r101;
        goto L7
    }

    public static final void c(ForsetiNodePiece r100, String r101, Fragment r102) {
        r100.f424550s.put(r101, r100.b().getActivityResultRegistry().register("StartActivityForResult: " + r101, new ActivityResultContracts.StartActivityForResult(), new com.ss.android.lark.forseti.node.piece.b(r100, r102, r101)));
        r100.f424551t.put(r101, r100.b().getActivityResultRegistry().register("StartIntentSenderForResult: " + r101, new ActivityResultContracts.StartIntentSenderForResult(), new c(r100, r102, r101)));
        r100.f424552u.put(r101, r100.b().getActivityResultRegistry().register("RequestMultiplePermissions: " + r101, new ActivityResultContracts.RequestMultiplePermissions(), new d(r100, r102, r101)));
    }
}
