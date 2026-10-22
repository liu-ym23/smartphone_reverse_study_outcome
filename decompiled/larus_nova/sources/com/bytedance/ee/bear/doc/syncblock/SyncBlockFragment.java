package com.bytedance.ee.bear.doc.syncblock;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.bytedance.ee.bear.document.DocumentFragment;
import com.bytedance.ee.bear.document.loading.LoadingLayout;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 Q2\u00020\u00012\u00020\u0002:\u0002QRB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0002J&\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\u001a\u0010;\u001a\u00020\f2\u0006\u0010<\u001a\u0002042\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\u0010\u0010=\u001a\u00020\f2\u0006\u0010>\u001a\u00020?H\u0002J\u0018\u0010@\u001a\u00020\f2\u0006\u0010>\u001a\u00020?2\u0006\u0010A\u001a\u00020BH\u0002J\u0018\u0010C\u001a\u00020\f2\u0006\u0010>\u001a\u00020?2\u0006\u0010D\u001a\u00020EH\u0002J\u0010\u0010F\u001a\u00020\f2\u0006\u0010>\u001a\u00020?H\u0002J\u0010\u0010G\u001a\u00020\f2\u0006\u0010>\u001a\u00020?H\u0002J\b\u0010H\u001a\u00020\fH\u0016J\b\u0010I\u001a\u00020\fH\u0002J\u0018\u0010J\u001a\u00020\f2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020EH\u0002J\b\u0010N\u001a\u00020\fH\u0002J\b\u0010O\u001a\u00020PH\u0016R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010+\u001a\u00020,8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u000e\u00101\u001a\u000202X\u0082.¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/bytedance/ee/bear/doc/syncblock/SyncBlockFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "baseTitleBarFromXml", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getBaseTitleBarFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setBaseTitleBarFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "clearFromXmlViewCache", "", "mLoadingLayout", "Lcom/bytedance/ee/bear/doc/syncblock/SyncBlockLoadingLayout;", "mShowRunnable", "Lcom/bytedance/ee/bear/doc/syncblock/SyncBlockFragment$ShowRunnable;", "mHandler", "Landroid/os/Handler;", "disposableContainer", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposableContainer", "()Lio/reactivex/disposables/CompositeDisposable;", "disposableContainer$delegate", "Lkotlin/Lazy;", "spaceKitUrlHelper", "Lcom/bytedance/ee/bear/domain/container/ISpaceKitUrlHelper;", "getSpaceKitUrlHelper", "()Lcom/bytedance/ee/bear/domain/container/ISpaceKitUrlHelper;", "setSpaceKitUrlHelper", "(Lcom/bytedance/ee/bear/domain/container/ISpaceKitUrlHelper;)V", "localAccountService", "Lcom/bytedance/ee/bear/contract/LocalAccountService;", "getLocalAccountService", "()Lcom/bytedance/ee/bear/contract/LocalAccountService;", "setLocalAccountService", "(Lcom/bytedance/ee/bear/contract/LocalAccountService;)V", "netService", "Lcom/bytedance/ee/bear/contract/NetService;", "getNetService", "()Lcom/bytedance/ee/bear/contract/NetService;", "setNetService", "(Lcom/bytedance/ee/bear/contract/NetService;)V", "routeService", "Lcom/bytedance/ee/bear/route/RouteService;", "getRouteService", "()Lcom/bytedance/ee/bear/route/RouteService;", "setRouteService", "(Lcom/bytedance/ee/bear/route/RouteService;)V", "viewModel", "Lcom/bytedance/ee/bear/doc/syncblock/SyncBlockViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "rootView", "fetchSourceToken", "bearUrl", "Lcom/bytedance/ee/bear/domain/BearUrl;", "handleServiceError", "e", "Lcom/bytedance/ee/bear/contract/NetService$ServerErrorException;", "routeDocumentFragment", "token", "", "routeToH5", "routeToDocumentFragment", "onDestroyView", "stopLoading", "loadFailed", "code", "", "message", "lazyShow", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "Companion", "ShowRunnable", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SyncBlockFragment extends Hilt_SyncBlockFragment implements d0c.c {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f218266q = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BaseTitleBar f218267g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SyncBlockLoadingLayout f218268h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f218269i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Handler f218270j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f218271k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Inject
    public t45.c f218272l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Inject
    public h0 f218273m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Inject
    public NetService f218274n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Inject
    public h f218275o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public SyncBlockViewModel f218276p;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<SyncBlockLoadingLayout> f218277a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile boolean f218278b;

        @Override // java.lang.Runnable
        public final void run() {
            WeakReference<SyncBlockLoadingLayout> r100 = this.f218277a;     // Catch: Throwable -> L12
            if (r100 == null) goto L15;
            SyncBlockLoadingLayout r101 = r100.get();     // Catch: Throwable -> L12
            if (r101 != null) goto L8;
            return;
        L8:
            if (this.f218278b == true) goto L20;
            r101.setOnClickListener(null);     // Catch: Throwable -> L12
            r101.setVisibility(0);     // Catch: Throwable -> L12
            return;
        L20:
            return;
        L15:
            return;
        L12:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L21;
            throw th;
        }

        public b(SyncBlockLoadingLayout r100) {
            this.f218277a = new WeakReference(r100);
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SyncBlockFragment f218279a;

        public c(SyncBlockFragment r100) {
            this.f218279a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            FragmentActivity r101 = this.f218279a.getActivity();
            if (r101 == null) goto L6;
            r101.onBackPressed();
            return;
        }
    }

    public static final class d implements LoadingLayout.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SyncBlockFragment f218280a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BearUrl f218281b;

        public d(SyncBlockFragment r100, BearUrl r101) {
            this.f218280a = r100;
            this.f218281b = r101;
        }

        @Override // com.bytedance.ee.bear.document.loading.LoadingLayout.c
        public final void onFailedRetry(int r100) {
            SyncBlockFragment r101 = this.f218280a;
            BearUrl r102 = this.f218281b;
            int r103 = SyncBlockFragment.f218266q;
            r101.V90(r102);
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SyncBlockFragment f218282a;

        public e(SyncBlockFragment r100) {
            this.f218282a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        L16:
            return;
        L3:
            if (com.bytedance.ee.util.ui.b.a(this.f218282a.getActivity()) == false) goto L11;
            FragmentActivity r100 = this.f218282a.getActivity();     // Catch: Throwable -> L8
            if (r100 == null) goto L15;
            r100.finish();     // Catch: Throwable -> L8
            return;
        L15:
            return;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider, dagger.hilt.internal.GeneratedComponentManager
    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.CC.$default$generatedComponent(this);
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // d0c.c, dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        ((CompositeDisposable) this.f218271k.getValue()).dispose();
        this.f218268h = null;
        stopLoading();
        super.onDestroyView();
        this.f218267g = null;
    }

    public final void stopLoading() {
        SyncBlockLoadingLayout r100 = this.f218268h;
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        b r101 = this.f218269i;
        if (r101 == null) goto L8;
        r101.f218278b = true;
    L8:
        b r102 = this.f218269i;
        if (r102 == null) goto L12;
        this.f218270j.removeCallbacks(r102);
        return;
    }

    public SyncBlockFragment() {
        this.f218270j = new Handler(Looper.getMainLooper());
        this.f218271k = LazyKt.lazy(SyncBlockFragment$disposableContainer$2.INSTANCE);
    }

    @Override // d0c.c
    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    public final void V90(BearUrl r100) {
        String r101 = r100.f222564e;
        if (r101 == null) goto L5;
        BaseFragment r102 = DocumentFragment.ja0(r100, getArguments());
    L6:
        FragmentTransaction r103 = getParentFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r103, r102, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, R.id.documentFragment) == true) goto L10;
        r103 = r103.replace(R.id.documentFragment, r102);
    L10:
        r103.commitAllowingStateLoss();
        return;
    L5:
        r102 = DocumentFragment.ka0(r101, getArguments());
        goto L6
    }

    public final void W90(BearUrl r100) {
        h r101 = this.f218275o;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("routeService");
        r101 = null;
    L6:
        if (r101 == null) goto L8;
        r101.u5(com.bytedance.ee.util.io.e.a(r100.f222564e, "routeFromSync", "true"));
    L8:
        j.d(new e(this), 50);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        super.onViewCreated(r100, r101);
        this.f218276p = (SyncBlockViewModel) new ViewModelProvider(this).get(SyncBlockViewModel.class);
        tt5.a.h("SyncBlockFragment", "onViewCreated");
        View r102 = this.f218267g;
        NetService r103 = null;
        if (r102 != null) goto L9;
        View r104 = getView();
        if (r104 == null) goto L7;
        r102 = r104.findViewById(R.id.baseTitleBar);
    L8:
        this.f218267g = (BaseTitleBar) r102;
        goto L9
    L7:
        r102 = null;
    L9:
        ((BaseTitleBar) r102).setLeftClickListener(new c(this));
        this.f218268h = (SyncBlockLoadingLayout) r100.findViewById(R.id.loading);
        Bundle r105 = getArguments();
        if (r105 == null) goto L13;
        BearUrl r106 = (BearUrl) r105.getParcelable("bear_url");
        if (r106 == null) goto L13;
    L22:
        SyncBlockLoadingLayout r107 = this.f218268h;
        if (r107 == null) goto L26;
        r107.setOnRetryListener(new d(this, r106));
    L26:
        if (this.f218269i == null) goto L28;
        tt5.a.h("SyncBlockFragment", "lazyShow: is already showing");
    L35:
        SyncBlockViewModel r108 = this.f218276p;
        if (r108 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r108 = null;
    L38:
        h0 r109 = this.f218273m;
        if (r109 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("localAccountService");
        r109 = null;
    L42:
        NetService r110 = this.f218274n;
        if (r110 == null) goto L45;
        r103 = r110;
    L46:
        ((CompositeDisposable) this.f218271k.getValue()).add(r108.fetch(r109, r103, r106).subscribe(new com.bytedance.ee.bear.doc.syncblock.a(this, r106), new com.bytedance.ee.bear.doc.syncblock.b(this, r106)));
        return;
    L45:
        Intrinsics.throwUninitializedPropertyAccessException("netService");
        goto L46
    L28:
        SyncBlockLoadingLayout r111 = this.f218268h;
        if (r111 == null) goto L31;
        r111.setVisibility(8);
    L31:
        b r112 = new b(this.f218268h);
        long r113 = DocOpenConfig.f218554h - ((long) 100);
        if (r113 >= 0) goto L34;
        r113 = 0;
    L34:
        this.f218270j.removeCallbacks(r112);
        this.f218270j.postDelayed(r112, r113);
        this.f218269i = r112;
    L13:
        t45.c r114 = this.f218272l;
        if (r114 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("spaceKitUrlHelper");
        r114 = null;
    L17:
        Bundle r115 = getArguments();
        if (r115 == null) goto L20;
        String r116 = r115.getString("url");
    L21:
        r106 = r114.Z(r116);
        goto L22
    L20:
        r116 = null;
        goto L21
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.sync_block_fragment, r101, false);
    }
}
