package com.larus.livetutor.impl.hybrid;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.business.debug.api.ILiveTutorDebugService;
import com.larus.common.apphost.AppHost;
import com.larus.livetutor.impl.LiveTutorActivity;
import com.larus.livetutor.impl.databinding.LiveTutorLayoutBinding;
import com.larus.livetutor.impl.repository.viewmodel.ITutorRefresh;
import com.larus.livetutor.impl.repository.viewmodel.LiveTutorViewModel;
import com.larus.livetutor.impl.repository.viewmodel.PageStateViewModel;
import com.larus.livetutor.impl.rtc.api.RTCServiceStatus;
import com.larus.livetutor.impl.utils.UtilsKt;
import com.larus.livetutor.impl.utils.track.LiveTutorTrackerService;
import com.larus.livetutor.impl.view.LiveTutorFragmentContainer;
import com.larus.livetutor.impl.view.LiveTutorPlanView;
import com.larus.livetutor.impl.view.LiveTutorTeachView;
import com.larus.livetutor.impl.view.LiveTutorTopBarView;
import com.larus.livetutor.impl.view.TutorLogPanel;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u009d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u001a\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020*H\u0016J\u0010\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020\u0013H\u0002J\b\u0010.\u001a\u00020*H\u0016J\b\u0010/\u001a\u00020*H\u0016J\b\u00100\u001a\u00020*H\u0002J\f\u00101\u001a\u00020**\u00020\u0007H\u0002J\u0010\u00102\u001a\u00020*2\u0006\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u00020*H\u0002J\u0010\u00106\u001a\u00020*2\u0006\u00107\u001a\u00020\u0013H\u0002J\b\u00108\u001a\u00020*H\u0002J\b\u00109\u001a\u00020*H\u0002J\b\u0010:\u001a\u00020*H\u0016J\b\u0010;\u001a\u00020\u0013H\u0016J\b\u0010<\u001a\u00020*H\u0016J\u001a\u0010=\u001a\u00020*2\u0006\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010\u0011H\u0016J\u0018\u0010A\u001a\u00020*2\u0006\u0010>\u001a\u00020?2\u0006\u0010B\u001a\u00020CH\u0016J\u001e\u0010D\u001a\u00020*2\u0014\u0010E\u001a\u0010\u0012\u0004\u0012\u00020G\u0012\u0006\u0012\u0004\u0018\u00010H0FH\u0016J\u0010\u0010I\u001a\u00020*2\b\u0010J\u001a\u0004\u0018\u00010&J\u0006\u0010K\u001a\u00020*J,\u0010L\u001a\u00020\u00112\u0006\u0010M\u001a\u00020G2\u0006\u0010N\u001a\u00020G2\u0012\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020*0PH\u0007J\u0012\u0010Q\u001a\u00020*2\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u0011J\u0006\u0010S\u001a\u00020TJ\u0006\u0010U\u001a\u00020\u0013J\b\u0010V\u001a\u00020*H\u0016J\u0010\u0010W\u001a\u00020*2\u0006\u0010X\u001a\u00020\u0013H\u0016J\b\u0010Y\u001a\u00020*H\u0016J\b\u0010Z\u001a\u00020*H\u0016J\u0010\u0010[\u001a\u00020*2\u0006\u0010\\\u001a\u00020]H\u0016J\b\u0010^\u001a\u00020*H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020 X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006_"}, d2 = {"Lcom/larus/livetutor/impl/hybrid/LiveTutorHybridContainer;", "Lcom/larus/livetutor/impl/hybrid/BaseHybridContainer;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/larus/livetutor/impl/LiveTutorActivity;", "<init>", "(Lcom/larus/livetutor/impl/LiveTutorActivity;)V", "binding", "Lcom/larus/livetutor/impl/databinding/LiveTutorLayoutBinding;", "viewModel", "Lcom/larus/livetutor/impl/repository/viewmodel/LiveTutorViewModel;", "getViewModel", "()Lcom/larus/livetutor/impl/repository/viewmodel/LiveTutorViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "planView", "Lcom/larus/livetutor/impl/view/LiveTutorPlanView;", "ttsSpeedControlHintView", "Landroid/view/View;", "enterPlan", "", "value", "enterTeach", "getEnterTeach", "()Z", "lastNetworkTipsShow", "appStatusListener", "com/larus/livetutor/impl/hybrid/LiveTutorHybridContainer$appStatusListener$1", "Lcom/larus/livetutor/impl/hybrid/LiveTutorHybridContainer$appStatusListener$1;", "isFromBackground", "webviewStartLoadTime", "", "themeRes", "", "getThemeRes", "()I", "setThemeRes", "(I)V", "curFragment", "Landroidx/fragment/app/Fragment;", "provideBulletContainer", "Landroid/view/ViewGroup;", "preCreate", "", WidgetCostModule.TYPE_ON_CREATE, "setLottieOpt", "opt", WidgetCostModule.TYPE_ON_START, "initView", "initDebugLog", "initPageStateView", "showErrorView", "errorState", "Lcom/larus/livetutor/impl/repository/viewmodel/PageChildState;", "retryError", "showPlanView", "showLoadingAnim", "showTeachView", "tryShowTtsSpeedControlHint", "initData", "onBackPressed", "onActivityLoadUri", "onLoadUriSuccess", "uri", "Landroid/net/Uri;", "kitView", "onLoadUriFail", "e", "", "putBizTrackerCommonParams", "params", "", "", "", "addFragment", WidgetService.PARAM_FRAGMENT, "removeFragment", "showTipsBannerView", "bannerText", "btnText", "clickBlock", "Lkotlin/Function1;", "dismissTipsView", "view", "getWebViewLocation", "", "getWebviewLoadResult", "onFinish", "onWindowFocusChanged", "hasFocus", "onPause", "onResume", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", LiveCommonConstants.REASON_ON_DEDTROY, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LiveTutorHybridContainer extends BaseHybridContainer {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LiveTutorLayoutBinding f356155e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f356156f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LiveTutorPlanView f356157g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f356158h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f356159i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f356160j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f356161k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a f356162l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f356163m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f356164n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Fragment f356165o;

    public static final class a implements f09.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveTutorHybridContainer f356166a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveTutorActivity f356167b;

        @Override // f09.a.b
        public final void onAllActivityDestroyed() {
        }

        @Override // f09.a.b
        public final void onAppBackground() {
            LiveTutorHybridContainer r100 = this.f356166a;
            r100.f356163m = true;
            r100.c().enterBackground();
            LiveTutorTrackerService r101 = kj9.b.c();
            if (r101 == null) goto L6;
            r101.f356690d.b();
            return;
        }

        @Override // f09.a.b
        public final void onAppForeground() {
            boolean r100 = kj9.b.f503724a;
            StringBuilder r101 = new StringBuilder("[enterForeground], currentPageState = ");
            RTCServiceStatus r102 = this.f356166a.c().getCurrentPageState();
            if (r102 == null) goto L5;
            String r103 = r102.getClass().getSimpleName();
        L6:
            r101.append(r103);
            kj9.b.a(r101.toString());
            LiveTutorHybridContainer r104 = this.f356166a;
            if (r104.f356163m == false) goto L12;
            r104.c().enterForeground();
            LiveTutorTrackerService r105 = kj9.b.c();
            if (r105 == null) goto L13;
            LifecycleCoroutineScope r106 = LifecycleOwnerKt.getLifecycleScope(this.f356167b);
            Intrinsics.checkNotNullParameter(r106, "scope");
            r105.f356690d.a(r106);
            return;
        L13:
            return;
        L12:
            return;
        L5:
            r103 = null;
            goto L6
        }

        public a(LiveTutorHybridContainer r100, LiveTutorActivity r101) {
            this.f356166a = r100;
            this.f356167b = r101;
        }
    }

    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f356168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver f356169b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LiveTutorHybridContainer f356170c;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            UtilsKt.g(this.f356170c.f356155e.f355978g.getBulletContainerView(), null, Integer.valueOf(this.f356170c.f356155e.f355979h.getHeight()), null, null, 13);
            if (this.f356169b.isAlive() == false) goto L5;
            this.f356169b.removeOnGlobalLayoutListener(this);
            return;
        L5:
            this.f356168a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        public b(LiveTutorTopBarView r100, ViewTreeObserver r101, LiveTutorHybridContainer r102) {
            this.f356168a = r100;
            this.f356169b = r101;
            this.f356170c = r102;
        }
    }

    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f356171a;

        public c(k r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f356171a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f356171a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f356171a.invoke(r100);
        }
    }

    public final LiveTutorViewModel c() {
        return (LiveTutorViewModel) this.f356156f.getValue();
    }

    public final void g() {
        boolean r100 = kj9.b.f503724a;
        StringBuilder r101 = new StringBuilder("[removeFragment] remove fragment ");
        Fragment r102 = this.f356165o;
        if (r102 == null) goto L5;
        String r103 = r102.getClass().getSimpleName();
    L6:
        r101.append(r103);
        r101.append(" status = ");
        Fragment r104 = this.f356165o;
        if (r104 == null) goto L9;
        Boolean r105 = Boolean.valueOf(r104.isAdded());
    L10:
        r101.append(r105);
        kj9.b.a(r101.toString());
        Fragment r106 = this.f356165o;
        if (r106 != null) goto L13;
        return;
    L13:
        e1.o(this.f356155e.f355976e);
        if (r106.isAdded() == true) goto L16;
        return;
    L16:
        FragmentTransaction r107 = getContext().getSupportFragmentManager().beginTransaction();
        r107.remove(r106);
        this.f356165o = null;
        r107.commitNowAllowingStateLoss();
        return;
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.larus.livetutor.impl.hybrid.k] */
    public final void d() {
        LiveTutorViewModel r100 = c();
        r100.initViewModel(this);
        r100.refreshData(ITutorRefresh.RefreshStrategy.PASSIVE_REFRESH, null, new com.larus.livetutor.impl.hybrid.c(this));
        this.f356155e.f355978g.getVoiceOperationView().setViewModel(r100);
        this.f356155e.f355979h.setViewModel(r100);
        this.f356155e.f355978g.setViewModel(r100);
        r100.addClosePageListener(new j(this));
        UtilsKt.m(this.f356153c, null, new LiveTutorHybridContainer$initData$1$3(r100, this, null), 3);
        UtilsKt.m(this.f356153c, null, new LiveTutorHybridContainer$initData$1$4(r100, this, null), 3);
        UtilsKt.m(this.f356153c, null, new LiveTutorHybridContainer$initData$1$5(r100, this, null), 3);
        r100.getDismissTtsSpeedControlHintEvent().observe(getContext(), new c(new k(this)));
        AppHost.Companion r101 = AppHost.f326268a;
        if (r101.isDebug() == true) goto L7;
        if (r101.isTestChannel() == true) goto L7;
        return;
    L7:
        if (ServiceManager.get().getService(ILiveTutorDebugService.class) == null) goto L12;
        j19.c.f(this.f356155e.f355973b);
        UtilsKt.h(this.f356155e.f355973b, new g(this));
        this.f356155e.f355973b.setOnLongClickListener(new h(this));
        c().addDebugInfo(new i(this));
        return;
    }

    public final void e() {
        getContext().setContentView(this.f356155e.f355972a);
        this.f356157g = (LiveTutorPlanView) this.f356155e.f355972a.findViewById(R.id.live_tutor_plan_container);
        this.f356155e.f355972a.setBackgroundColor(-1);
        LiveTutorTopBarView r100 = this.f356155e.f355979h;
        ViewTreeObserver r101 = r100.getViewTreeObserver();
        r100.getViewTreeObserver().addOnGlobalLayoutListener(new b(r100, r101, this));
        final LiveTutorLayoutBinding r102 = this.f356155e;
        PageStateViewModel.onPageState$default(c(), new l(), new m(r102), null, new n(this), new o(this), null, 36, null);
        LiveTutorPlanView r103 = this.f356157g;
        if (r103 == null) goto L6;
        r103.o6(c());
        return;
    }

    @Override // com.larus.livetutor.impl.hybrid.BaseHybridContainer
    public final void onDestroy() {
        super.onDestroy();
        kj9.b.d("[onDestroy]");
        LiveTutorTrackerService r100 = kj9.b.c();
        if (r100 == null) goto L5;
        r100.f356690d.b();
    L5:
        c().onDestroy();
        r0.c.a.f535397a = false;
        r0.c.a.f535398b = false;
        r0.c.a.f535399c = false;
        AppHost.f326268a.a().c(this.f356162l);
    }

    @Override // com.larus.livetutor.impl.hybrid.BaseHybridContainer
    public final void onPause() {
        super.onPause();
        kj9.b.d("[onPause]");
        LiveTutorTrackerService r100 = kj9.b.c();
        if (r100 == null) goto L10;
        JSONObject r101 = new JSONObject();
        long r102 = System.currentTimeMillis();
        Long r103 = r100.f356689c;
        if (r103 == null) goto L7;
        long r104 = r103.longValue();
    L8:
        r101.put("stay_duration", r102 - r104);
        Unit r105 = Unit.INSTANCE;
        LiveTutorTrackerService.b(r100, "live_tutor_leave_page", r101, 4);
        r100.f356689c = null;
        return;
    L7:
        r104 = 0;
        goto L8
    }

    @Override // com.larus.livetutor.impl.hybrid.BaseHybridContainer
    public final void onResume() {
        super.onResume();
        kj9.b.d("[onResume]");
        if (this.f356163m == false) goto L11;
        LiveTutorTrackerService r100 = kj9.b.c();
        if (r100 == null) goto L9;
        LiveTutorTrackerService.b(r100, "live_tutor_enter_page", null, 6);
        if (r100.f356689c != null) goto L9;
        r100.f356689c = Long.valueOf(System.currentTimeMillis());
    L9:
        this.f356163m = false;
        return;
    }

    @Override // com.larus.livetutor.impl.hybrid.BaseHybridContainer
    public final void onStart() {
        super.onStart();
        int r100 = com.larus.livetutor.impl.utils.j.f356680a;
        com.larus.livetutor.impl.utils.j.a(getContext());
        getContext().getWindow().setSoftInputMode(16);
    }

    public LiveTutorHybridContainer(LiveTutorActivity r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110);
        View r100 = r110.getLayoutInflater().inflate(R.layout.live_tutor_layout, null, false);
        int r101 = R.id.debug;
        TextView r102 = (TextView) ViewBindings.findChildViewById(r100, R.id.debug);
        if (r102 == null) goto L23;
        r101 = R.id.debug_log;
        TutorLogPanel r103 = (TutorLogPanel) ViewBindings.findChildViewById(r100, R.id.debug_log);
        if (r103 == null) goto L23;
        r101 = R.id.live_tutor_error_container;
        FrameLayout r104 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.live_tutor_error_container);
        if (r104 == null) goto L23;
        r101 = R.id.live_tutor_fragment_container;
        LiveTutorFragmentContainer r105 = (LiveTutorFragmentContainer) ViewBindings.findChildViewById(r100, R.id.live_tutor_fragment_container);
        if (r105 == null) goto L23;
        ConstraintLayout r106 = (ConstraintLayout) r100;
        r101 = R.id.live_tutor_plan_container;
        LiveTutorPlanView r107 = (LiveTutorPlanView) ViewBindings.findChildViewById(r100, R.id.live_tutor_plan_container);
        if (r107 == null) goto L23;
        r101 = R.id.live_tutor_teach_container;
        LiveTutorTeachView r111 = (LiveTutorTeachView) ViewBindings.findChildViewById(r100, R.id.live_tutor_teach_container);
        if (r111 == null) goto L23;
        r101 = R.id.live_tutor_top_bar;
        LiveTutorTopBarView r112 = (LiveTutorTopBarView) ViewBindings.findChildViewById(r100, R.id.live_tutor_top_bar);
        if (r112 == null) goto L23;
        r101 = R.id.live_tutor_transition_lottie;
        if (((LottieAnimationView) ViewBindings.findChildViewById(r100, R.id.live_tutor_transition_lottie)) == null) goto L23;
        r101 = R.id.tts_speed_control_hint_stub;
        ViewStub r113 = (ViewStub) ViewBindings.findChildViewById(r100, R.id.tts_speed_control_hint_stub);
        if (r113 == null) goto L23;
        this.f356155e = new LiveTutorLayoutBinding(r106, r102, r103, r104, r105, r107, r111, r112, r113);
        this.f356156f = LazyKt.lazy(new e(this));
        this.f356162l = new a(this, r110);
        return;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public final void a(Fragment r100) {
        j19.c.f(this.f356155e.f355976e);
        if (r100.isAdded() == false) goto L5;
        return;
    L5:
        if (this.f356165o != null) goto L14;
        FragmentTransaction r101 = getContext().getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r101, r100, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "LIVE_TUTOR_FRAGMENT", R.id.live_tutor_fragment_container) == true) goto L11;
        r101.replace(R.id.live_tutor_fragment_container, r100, "LIVE_TUTOR_FRAGMENT");
    L11:
        boolean r102 = kj9.b.f503724a;
        kj9.b.a("[addFragment] add fragment ".concat(r100.getClass().getSimpleName()));
        this.f356165o = r100;
        r101.commitNowAllowingStateLoss();
        return;
    }

    public final void b(View r100) {
        kj9.b.a("[dismissTipsView] remove tips view");
        if (r100 == null) goto L5;
        e1.o(r100);
        this.f356155e.f355978g.removeView(r100);
        return;
    L5:
        Iterator r101 = SequencesKt.filter(ViewGroupKt.getChildren(this.f356155e.f355978g), new r()).iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        View r102 = (View) r101.next();
        e1.o(r102);
        this.f356155e.f355978g.removeView(r102);
        goto L7
    }

    public final void h(boolean r100) {
        this.f356155e.f355979h.S5(false, false);
        LiveTutorPlanView r101 = this.f356157g;
        if (r101 == null) goto L9;
        j19.c.f(r101);
        if (r100 == false) goto L9;
        LiveTutorPlanView r102 = this.f356157g;
        if (r102 == null) goto L9;
        r102.k6();
    L9:
        e1.o(this.f356155e.f355978g);
        e1.o(this.f356155e.f355975d);
    }

    public final void f(Uri r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, "e");
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, "e");
        c().eLogger("onWebViewLoadUriFail", "uri = " + r100 + ", msg = " + r101.getMessage());
        c().loadUriResult(false, System.currentTimeMillis() - this.f356164n, r101);
    }

    public final View i(String r100, String r101, final Function1<? super View, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "bannerText");
        Intrinsics.checkNotNullParameter(r101, "btnText");
        Intrinsics.checkNotNullParameter(r102, "clickBlock");
        final View r103 = LayoutInflater.from(getContext()).inflate(R.layout.live_tutor_restart_pop, null, false);
        r103.setTag("tipsBannerView");
        r103.setClickable(true);
        TextView r104 = (TextView) r103.findViewById(R.id.tv_tip);
        if (r104 == null) goto L5;
        r104.setText(r100);
    L5:
        TextView r105 = (TextView) r103.findViewById(R.id.tb_restart);
        if (r105 == null) goto L8;
        r105.setText(r101);
        UtilsKt.h(r105, new d(r102, r103));
    L8:
        int r106 = this.f356155e.f355978g.getInputFragmentHeight() - i5.e0();
        LiveTutorTeachView r107 = this.f356155e.f355978g;
        ConstraintLayout.LayoutParams r108 = new ConstraintLayout.LayoutParams(-2, i5.m0());
        r108.bottomToBottom = 0;
        r108.leftToLeft = 0;
        r108.rightToRight = 0;
        ((ViewGroup.MarginLayoutParams) r108).bottomMargin = r106;
        ((ViewGroup.MarginLayoutParams) r108).leftMargin = i5.E();
        ((ViewGroup.MarginLayoutParams) r108).rightMargin = i5.E();
        Unit r109 = Unit.INSTANCE;
        r107.addView(r103, r108);
        return r103;
    }
}
