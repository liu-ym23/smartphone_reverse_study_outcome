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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 Q2\u00020\u00012\u00020\u0002:\u0002QRB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0002J&\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\u001a\u0010;\u001a\u00020\f2\u0006\u0010<\u001a\u0002042\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\u0010\u0010=\u001a\u00020\f2\u0006\u0010>\u001a\u00020?H\u0002J\u0018\u0010@\u001a\u00020\f2\u0006\u0010>\u001a\u00020?2\u0006\u0010A\u001a\u00020BH\u0002J\u0018\u0010C\u001a\u00020\f2\u0006\u0010>\u001a\u00020?2\u0006\u0010D\u001a\u00020EH\u0002J\u0010\u0010F\u001a\u00020\f2\u0006\u0010>\u001a\u00020?H\u0002J\u0010\u0010G\u001a\u00020\f2\u0006\u0010>\u001a\u00020?H\u0002J\b\u0010H\u001a\u00020\fH\u0016J\b\u0010I\u001a\u00020\fH\u0002J\u0018\u0010J\u001a\u00020\f2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020EH\u0002J\b\u0010N\u001a\u00020\fH\u0002J\b\u0010O\u001a\u00020PH\u0016R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010+\u001a\u00020,8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u000e\u00101\u001a\u000202X\u0082.¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/bytedance/ee/bear/doc/syncblock/SyncBlockFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "baseTitleBarFromXml", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getBaseTitleBarFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setBaseTitleBarFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "clearFromXmlViewCache", "", "mLoadingLayout", "Lcom/bytedance/ee/bear/doc/syncblock/SyncBlockLoadingLayout;", "mShowRunnable", "Lcom/bytedance/ee/bear/doc/syncblock/SyncBlockFragment$ShowRunnable;", "mHandler", "Landroid/os/Handler;", "disposableContainer", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposableContainer", "()Lio/reactivex/disposables/CompositeDisposable;", "disposableContainer$delegate", "Lkotlin/Lazy;", "spaceKitUrlHelper", "Lcom/bytedance/ee/bear/domain/container/ISpaceKitUrlHelper;", "getSpaceKitUrlHelper", "()Lcom/bytedance/ee/bear/domain/container/ISpaceKitUrlHelper;", "setSpaceKitUrlHelper", "(Lcom/bytedance/ee/bear/domain/container/ISpaceKitUrlHelper;)V", "localAccountService", "Lcom/bytedance/ee/bear/contract/LocalAccountService;", "getLocalAccountService", "()Lcom/bytedance/ee/bear/contract/LocalAccountService;", "setLocalAccountService", "(Lcom/bytedance/ee/bear/contract/LocalAccountService;)V", "netService", "Lcom/bytedance/ee/bear/contract/NetService;", "getNetService", "()Lcom/bytedance/ee/bear/contract/NetService;", "setNetService", "(Lcom/bytedance/ee/bear/contract/NetService;)V", "routeService", "Lcom/bytedance/ee/bear/route/RouteService;", "getRouteService", "()Lcom/bytedance/ee/bear/route/RouteService;", "setRouteService", "(Lcom/bytedance/ee/bear/route/RouteService;)V", "viewModel", "Lcom/bytedance/ee/bear/doc/syncblock/SyncBlockViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "rootView", "fetchSourceToken", "bearUrl", "Lcom/bytedance/ee/bear/domain/BearUrl;", "handleServiceError", "e", "Lcom/bytedance/ee/bear/contract/NetService$ServerErrorException;", "routeDocumentFragment", "token", "", "routeToH5", "routeToDocumentFragment", "onDestroyView", "stopLoading", "loadFailed", "code", "", "message", "lazyShow", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "Companion", "ShowRunnable", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SyncBlockFragment extends Hilt_SyncBlockFragment implements d0c.c {
    public static final /* synthetic */ int q = 0;
    public BaseTitleBar g;
    public SyncBlockLoadingLayout h;
    public b i;
    public final Handler j;
    public final Lazy k;

    @Inject
    public t45.c l;

    @Inject
    public h0 m;

    @Inject
    public NetService n;

    @Inject
    public h o;
    public SyncBlockViewModel p;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final WeakReference<SyncBlockLoadingLayout> a;
        public volatile boolean b;

        @Override // java.lang.Runnable
        public final void run() {
            WeakReference<SyncBlockLoadingLayout> r0 = this.a;     // Catch: Throwable -> L12
            if (r0 == null) goto L15;
            SyncBlockLoadingLayout r1 = r0.get();     // Catch: Throwable -> L12
            if (r1 != null) goto L8;
            return;
        L8:
            if (this.b == true) goto L20;
            r1.setOnClickListener(null);     // Catch: Throwable -> L12
            r1.setVisibility(0);     // Catch: Throwable -> L12
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

        public b(SyncBlockLoadingLayout r2) {
            this.a = new WeakReference(r2);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ SyncBlockFragment a;

        public c(SyncBlockFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            FragmentActivity r2 = this.a.getActivity();
            if (r2 == null) goto L6;
            r2.onBackPressed();
            return;
        }
    }

    public static final class d implements LoadingLayout.c {
        public final /* synthetic */ SyncBlockFragment a;
        public final /* synthetic */ BearUrl b;

        public d(SyncBlockFragment r1, BearUrl r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.ee.bear.document.loading.LoadingLayout.c
        public final void onFailedRetry(int r3) {
            SyncBlockFragment r4 = this.a;
            BearUrl r0 = this.b;
            int r1 = SyncBlockFragment.q;
            r4.V90(r0);
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ SyncBlockFragment a;

        public e(SyncBlockFragment r1) {
            this.a = r1;
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
            if (com.bytedance.ee.util.ui.b.a(this.a.getActivity()) == false) goto L11;
            FragmentActivity r0 = this.a.getActivity();     // Catch: Throwable -> L8
            if (r0 == null) goto L15;
            r0.finish();     // Catch: Throwable -> L8
            return;
        L15:
            return;
        }
    }

    static {
    }

    public final void afterUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    public final void onDestroyView() {
        ((CompositeDisposable) this.k.getValue()).dispose();
        this.h = null;
        stopLoading();
        super.onDestroyView();
        this.g = null;
    }

    public final void stopLoading() {
        SyncBlockLoadingLayout r0 = this.h;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        b r1 = this.i;
        if (r1 == null) goto L8;
        r1.b = true;
    L8:
        b r2 = this.i;
        if (r2 == null) goto L12;
        this.j.removeCallbacks(r2);
        return;
    }

    public SyncBlockFragment() {
        this.j = new Handler(Looper.getMainLooper());
        this.k = LazyKt.lazy(SyncBlockFragment$disposableContainer$2.INSTANCE);
    }

    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m156provideComponent() {
        return provideComponent();
    }

    public final void V90(BearUrl r5) {
        String r0 = r5.e;
        if (r0 == null) goto L5;
        BaseFragment r6 = DocumentFragment.ja0(r5, getArguments());
    L6:
        FragmentTransaction r1 = getParentFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r6, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131369388) == true) goto L10;
        r1 = r1.replace(2131369388, r6);
    L10:
        r1.commitAllowingStateLoss();
        return;
    L5:
        r6 = DocumentFragment.ka0(r0, getArguments());
        goto L6
    }

    public final void W90(BearUrl r4) {
        h r0 = this.o;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("routeService");
        r0 = null;
    L6:
        if (r0 == null) goto L8;
        r0.u5(com.bytedance.ee.util.io.e.a(r4.e, "routeFromSync", "true"));
    L8:
        j.d(new e(this), 50);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "rootView");
        super.onViewCreated(r7, r8);
        this.p = (SyncBlockViewModel) new ViewModelProvider(this).get(SyncBlockViewModel.class);
        tt5.a.h("SyncBlockFragment", "onViewCreated");
        View r0 = this.g;
        NetService r1 = null;
        if (r0 != null) goto L9;
        View r2 = getView();
        if (r2 == null) goto L7;
        r0 = r2.findViewById(2131363979);
    L8:
        this.g = (BaseTitleBar) r0;
        goto L9
    L7:
        r0 = null;
    L9:
        ((BaseTitleBar) r0).setLeftClickListener(new c(this));
        this.h = (SyncBlockLoadingLayout) r7.findViewById(2131378977);
        Bundle r9 = getArguments();
        if (r9 == null) goto L13;
        BearUrl r10 = (BearUrl) r9.getParcelable("bear_url");
        if (r10 == null) goto L13;
    L22:
        SyncBlockLoadingLayout r3 = this.h;
        if (r3 == null) goto L26;
        r3.setOnRetryListener(new d(this, r10));
    L26:
        if (this.i == null) goto L28;
        tt5.a.h("SyncBlockFragment", "lazyShow: is already showing");
    L35:
        SyncBlockViewModel r11 = this.p;
        if (r11 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r11 = null;
    L38:
        h0 r4 = this.m;
        if (r4 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("localAccountService");
        r4 = null;
    L42:
        NetService r5 = this.n;
        if (r5 == null) goto L45;
        r1 = r5;
    L46:
        ((CompositeDisposable) this.k.getValue()).add(r11.fetch(r4, r1, r10).subscribe(new com.bytedance.ee.bear.doc.syncblock.a(this, r10), new com.bytedance.ee.bear.doc.syncblock.b(this, r10)));
        return;
    L45:
        Intrinsics.throwUninitializedPropertyAccessException("netService");
        goto L46
    L28:
        SyncBlockLoadingLayout r12 = this.h;
        if (r12 == null) goto L31;
        r12.setVisibility(8);
    L31:
        b r13 = new b(this.h);
        long r6 = DocOpenConfig.h - ((long) 100);
        if (r6 >= 0) goto L34;
        r6 = 0;
    L34:
        this.j.removeCallbacks(r13);
        this.j.postDelayed(r13, r6);
        this.i = r13;
    L13:
        t45.c r14 = this.l;
        if (r14 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("spaceKitUrlHelper");
        r14 = null;
    L17:
        Bundle r16 = getArguments();
        if (r16 == null) goto L20;
        String r17 = r16.getString("url");
    L21:
        r10 = r14.Z(r17);
        goto L22
    L20:
        r17 = null;
        goto L21
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131564926, r3, false);
    }
}
