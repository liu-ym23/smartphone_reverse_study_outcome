package com.larus.community.impl.publish;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.community.impl.publish.viewmodel.CreationPublishTitleState;
import com.larus.community.impl.publish.viewmodel.CreationPublishTitleViewModel;
import com.larus.community.impl.publish.viewmodel.CreationPublishViewModel;
import com.larus.nova.R;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.ui.arch.vm.ComponentViewModel;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/community/impl/publish/CreationPublishTitleComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "<init>", "()V", "viewModel", "Lcom/larus/community/impl/publish/viewmodel/CreationPublishTitleViewModel;", "getViewModel", "()Lcom/larus/community/impl/publish/viewmodel/CreationPublishTitleViewModel;", "viewModel$delegate", "Lcom/larus/ui/arch/vm/internal/ComponentVMLazy;", "fragmentViewModel", "Lcom/larus/community/impl/publish/viewmodel/CreationPublishViewModel;", "getFragmentViewModel", "()Lcom/larus/community/impl/publish/viewmodel/CreationPublishViewModel;", "fragmentViewModel$delegate", "Lkotlin/Lazy;", "titleLayout", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "onViewCreated", "", "view", "Landroid/view/View;", "initView", "adjustTitleRight", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationPublishTitleComponent extends BaseContentWidget {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f329650p = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.larus.ui.arch.vm.internal.l f329651m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f329652n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public NovaTitleBarEx f329653o;

    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f329654a;

        public a(v r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f329654a = r100;
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
            return this.f329654a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f329654a.invoke(r100);
        }
    }

    public static final class b implements Function0<LifecycleOwner> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComponentFeature f329655a;

        public b(ComponentFeature r100) {
            this.f329655a = r100;
        }

        @Override // kotlin.jvm.functions.Function0
        public final LifecycleOwner invoke() {
            return this.f329655a;
        }
    }

    public static final class c implements Function0<ViewModelStoreOwner> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComponentFeature f329656a;

        public c(ComponentFeature r100) {
            this.f329656a = r100;
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelStoreOwner invoke() {
            return this.f329656a;
        }
    }

    public static final class d implements Function0<ViewModelProvider.Factory> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f329657a = null;

        static {
            f329657a = new d();
        }

        public d() {
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return new ViewModelProvider.NewInstanceFactory();
        }
    }

    public CreationPublishTitleComponent() {
        this.f329651m = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(CreationPublishTitleViewModel.class), Reflection.getOrCreateKotlinClass(CreationPublishTitleState.class), new b(this), new c(this), d.f329657a);
        this.f329652n = LazyKt.lazy(new w(this));
    }

    public static final void Y2(CreationPublishTitleComponent r100) {
        r100.getClass();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        if (s1a.a.getActivity(r100).isFinishing() == true) goto L6;
        boolean r102 = ViewExtKt.h(r100.F2());     // Catch: Throwable -> L8
        ((CreationPublishTitleViewModel) r100.f329651m.getValue()).setShowPublish(r102);     // Catch: Throwable -> L8
    L6:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.community.impl.publish.v] */
    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget
    public final void onViewCreated(View r110) {
        Intrinsics.checkNotNullParameter(r110, "view");
        NovaTitleBarEx r100 = (NovaTitleBarEx) F2().findViewById(R.id.title_layout);
        this.f329653o = r100;
        if (r100 == null) goto L5;
        NovaTitleBarEx.Y5(r100, r100.getContext().getString(R.string.larus_ccMob_PreviewPage_btn_makePublic), null, null, 6);
        NovaTitleBarEx.b6(r100, R.drawable.larus_ic_left_back, false, null, null, new u(this), 14);
    L5:
        MutableLiveData<Boolean> r101 = ((CreationPublishViewModel) this.f329652n.getValue()).getPublishLiveState();
        Intrinsics.checkNotNullParameter(this, "<this>");
        r101.observe(com.larus.ui.arch.component.internal.attach.a.b(this, this), new a(new v(this)));
        ComponentViewModel.onEach$default((CreationPublishTitleViewModel) this.f329651m.getValue(), CreationPublishTitleComponent$initView$3.INSTANCE, CreationPublishTitleComponent$initView$4.INSTANCE, null, new CreationPublishTitleComponent$initView$5(this, null), 4, null);
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r111 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getView();
        if (r111 == null) goto L11;
        ChatConstraintLayout r112 = (ChatConstraintLayout) r111.findViewById(R.id.chat_constraint_layout);
        if (r112 == null) goto L12;
        r112.setOnBottomInsetUpdateListener(new y(this));
        return;
    L12:
        return;
    }
}
