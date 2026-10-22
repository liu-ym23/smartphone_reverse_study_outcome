package com.bytedance.ee.bear.container;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ee.bear.dependency.LoadingLayoutScope;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.facade.common.ExtensionFragmentImpl;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 `2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002`aB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016J&\u00105\u001a\u0004\u0018\u00010\u001b2\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\u001a\u0010<\u001a\u0002022\u0006\u0010=\u001a\u00020\u001b2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010>\u001a\u000202H\u0016J\b\u0010?\u001a\u000202H\u0016J\b\u0010@\u001a\u000202H\u0002J\b\u0010A\u001a\u000202H\u0002J\b\u0010B\u001a\u000202H\u0002J\b\u0010C\u001a\u000202H\u0002J\b\u0010D\u001a\u000202H\u0002J\b\u0010E\u001a\u00020\u000eH\u0002J\u0012\u0010F\u001a\u0002022\b\u0010G\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010H\u001a\u000202H\u0002JC\u0010I\u001a\u0002022\u0006\u0010J\u001a\u00020\b2\b\b\u0001\u0010K\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010L2\b\u0010N\u001a\u0004\u0018\u00010\b2\u000e\u0010O\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010PH\u0002¢\u0006\u0002\u0010QJ\u0010\u0010R\u001a\u0002022\u0006\u0010=\u001a\u00020\u001bH\u0002J\b\u0010S\u001a\u00020TH\u0016J\b\u0010U\u001a\u00020VH\u0016J\u0012\u0010W\u001a\u0002022\b\u0010X\u001a\u0004\u0018\u00010YH\u0016J\u0012\u0010Z\u001a\u00020V2\b\u0010X\u001a\u0004\u0018\u00010YH\u0016J%\u0010[\u001a\u0004\u0018\u0001H\\\"\u0004\b\u0000\u0010\\2\u000e\u0010]\u001a\n\u0012\u0004\u0012\u0002H\\\u0018\u00010^H\u0016¢\u0006\u0002\u0010_R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010%\u001a\u0004\b.\u0010/¨\u0006b"}, d2 = {"Lcom/bytedance/ee/bear/container/ContainerFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "Lcom/bytedance/ee/bear/facade/common/IExtensionHost;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/IDocContainer;", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "ivBack", "Landroid/widget/ImageView;", "containerTitleBar", "Landroid/widget/FrameLayout;", "containerContentLoading", "containerFullLoading", "containerError", "titleBarLayout", "Lcom/bytedance/ee/bear/dependency/ITitleBarLayout;", "loadingLayout", "Lcom/bytedance/ee/bear/dependency/ILoadingLayout;", "loadingLayoutState", "Lcom/bytedance/ee/bear/container/ContainerLoadingLayoutState;", "errorLayout", "Lcom/bytedance/ee/bear/dependency/IErrorLayout;", "containerCover", "Landroid/view/View;", "containerDependency", "Lcom/bytedance/ee/bear/dependency/ContainerDependency;", "extensionFragmentImpl", "Lcom/bytedance/ee/bear/facade/common/ExtensionFragmentImpl;", "viewModel", "Lcom/bytedance/ee/bear/container/ContainerViewModel;", "getViewModel", "()Lcom/bytedance/ee/bear/container/ContainerViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "reloadInterceptor", "Lcom/bytedance/ee/bear/container/ContainerReloadInterceptor;", "getReloadInterceptor", "()Lcom/bytedance/ee/bear/container/ContainerReloadInterceptor;", "setReloadInterceptor", "(Lcom/bytedance/ee/bear/container/ContainerReloadInterceptor;)V", "mUserComponentDelegate", "Lcom/bytedance/ee/bear/user/container/UserComponentDelegate;", "getMUserComponentDelegate", "()Lcom/bytedance/ee/bear/user/container/UserComponentDelegate;", "mUserComponentDelegate$delegate", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onDetach", "onDestroyView", "collect", "showTitleBar", "hideTitleBar", "showLoading", "hideLoading", "getLoadingContainer", "updateLoadingLayout", "targetLoadingLayout", "hideError", "showError", "msg", "iconRes", "", "code", "buttonTis", JSEventListener.ACTION, "Lkotlin/Function0;", "(Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "initViews", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "onBackPressed", "", "addExtension", "extension", "Lcom/bytedance/ee/bear/facade/common/BaseExtension;", "removeExtension", "findExtension", "T", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "Companion", "InterceptTouchFrameLayout", "framework-container_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContainerFragment extends BaseFragment implements d0c.c, sa5.o, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.n {
    public final String e;
    public ImageView f;
    public FrameLayout g;
    public FrameLayout h;
    public FrameLayout i;
    public FrameLayout j;
    public yx4.e k;
    public yx4.d l;
    public d m;
    public yx4.c n;
    public View o;
    public final yx4.a p;
    public ExtensionFragmentImpl q;
    public final Lazy r;
    public f s;
    public final Lazy t;

    public static final class a {
    }

    public final class b extends FrameLayout {
        public final /* synthetic */ ContainerFragment a;

        @Override // android.view.ViewGroup, android.view.View
        public final boolean dispatchTouchEvent(MotionEvent r6) {
            Intrinsics.checkNotNullParameter(r6, "ev");
            ExtensionFragmentImpl r2 = this.a.q;     // Catch: IndexOutOfBoundsException -> L19 IllegalArgumentException -> L21
            if (r2 == null) goto L14;
            Iterator r3 = ((ArrayList) r2.a).iterator();     // Catch: IndexOutOfBoundsException -> L19 IllegalArgumentException -> L21
        L7:
            if (r3.hasNext() == false) goto L11;
            if (((sa5.e) r3.next()).h(r6) == false) goto L7;
            boolean r4 = true;
        L12:
            if (r4 != true) goto L14;
            boolean r5 = true;
        L15:
            if (r5 == false) goto L29;
            Log.i(this.a.e, "dispatchTouchEvent consumed by extension");     // Catch: IndexOutOfBoundsException -> L19 IllegalArgumentException -> L21
            return true;
        L29:
            return super.dispatchTouchEvent(r6);
        L11:
            r4 = false;
        L14:
            r5 = false;
        L21:
            e = move-exception;
            Log.e(this.a.e, "dispatchTouchEvent error", e);
            return false;
        L19:
            e = move-exception;
            Log.e(this.a.e, "dispatchTouchEvent error", e);
            return false;
        }

        public b(ContainerFragment r2, Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            this.a = r2;
            super(r3);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ ContainerFragment a;

        public c(ContainerFragment r1) {
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

    public final /* synthetic */ com.ss.android.lark.passportc.api.m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ e0c.l provideComponent() {
        return d0c.b.b(this);
    }

    public final FrameLayout U90() {
        yx4.d r0 = this.l;
        if (r0 == null) goto L5;
        LoadingLayoutScope r1 = r0.getScope();
    L7:
        if (r1 != LoadingLayoutScope.FULL_CONTAINER) goto L11;
        FrameLayout r2 = this.i;
        if (r2 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("containerFullLoading");
        return null;
    L15:
        return r2;
    L11:
        r2 = this.h;
        if (r2 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("containerContentLoading");
        return null;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        ExtensionFragmentImpl r0 = this.q;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L10;
        return true;
    L10:
        return super.onBackPressed();
    L5:
        if (r0.a() != true) goto L7;
        r1 = true;
        goto L7
    }

    public final void onDestroyView() {
        yx4.d r0 = this.l;
        if (r0 == null) goto L5;
        r0.hideLoading();
    L5:
        yx4.d r1 = this.l;
        if (r1 == null) goto L8;
        r1.detachLoadingView();
    L8:
        this.l = null;
        this.m = null;
        yx4.e r2 = this.k;
        if (r2 == null) goto L11;
        r2.c();
    L11:
        super.onDestroyView();
    }

    public ContainerFragment() {
        this.e = "ContainerFragment" + hashCode();
        yx4.a r0 = yx4.b.a;
        this.p = yx4.b.a;
        final Function0<Fragment> r1 = new ContainerFragment$special$$inlined$viewModels$default$1(this);
        this.r = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ContainerViewModel.class), new ContainerFragment$special$$inlined$viewModels$default$2(r1), new ContainerFragment$special$$inlined$viewModels$default$3(r1, this));
        this.t = LazyKt.lazy(new ContainerFragment$mUserComponentDelegate$2(this));
    }

    public final UserSession e9() {
        return PassportcConvention.b(this);
    L5:
        return ContainerConstsKt.a();
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onDetach() {
        super.onDetach();
        this.q = null;
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m107provideComponent() {
        return provideComponent();
    }

    @Override // sa5.o
    public final void Xi(sa5.e r2) {
        ExtensionFragmentImpl r0 = this.q;
        if (r0 == null) goto L6;
        r0.Xi(r2);
        return;
    }

    public final void onAttach(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super.onAttach(r5);
        this.q = new ExtensionFragmentImpl(new WeakReference(this), CollectionsKt.listOf(new sa5.e[]{new ta5.l(this), new ta5.j()}));
    }

    @Override // sa5.o
    public final sa5.e vb(Class r2) {
        ExtensionFragmentImpl r0 = this.q;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.vb(r2);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        r7.setTag(2131371995, this);
        this.f = (ImageView) r7.findViewById(2131376031);
        this.g = (FrameLayout) r7.findViewById(2131367784);
        this.h = (FrameLayout) r7.findViewById(2131367753);
        this.i = (FrameLayout) r7.findViewById(2131367763);
        this.j = (FrameLayout) r7.findViewById(2131367760);
        this.o = r7.findViewById(2131367755);
        ImageView r9 = this.f;
        if (r9 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("ivBack");
        r9 = null;
    L5:
        r9.setOnClickListener(new c(this));
        this.k = this.p.getTitleBarLayout();
        this.l = this.p.b();
        this.n = this.p.c();
        yx4.e r10 = this.k;
        if (r10 == null) goto L11;
        FrameLayout r0 = this.g;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("containerTitleBar");
        r0 = null;
    L10:
        r10.b(r0);
    L11:
        yx4.d r11 = this.l;
        if (r11 == null) goto L14;
        r11.attachLoadingView(U90());
    L14:
        yx4.c r12 = this.n;
        if (r12 == null) goto L20;
        FrameLayout r1 = this.j;
        if (r1 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("containerError");
        r1 = null;
    L19:
        r12.a(r1);
    L20:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), Dispatchers.getMain().getImmediate(), null, new ContainerFragment$collect$1(this, null), 2, null);
        ((ContainerViewModel) this.r.getValue()).load(this, (vo5.a) this.t.getValue(), PassportcConvention.b(this));
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131559270, r3, false);
        b r6 = new b(this, r2.getContext());
        r6.addView(r5, new FrameLayout.LayoutParams(-1, -1));
        return r6;
    }
}
