package com.ss.android.lark.passport.flow.auth_type.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.flow.auth_type.AuthTypeStepInfo;
import com.ss.android.lark.passport.flow.core.model.ButtonInfo;
import com.ss.android.lark.passport.flow.core.model.ButtonType;
import com.ss.android.lark.passport.flow.core.router.FlowStep;
import com.ss.android.lark.passport.flow.mfa.FlowVerifyFactor;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0004\"#$%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018J\u001a\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0002J\f\u0010!\u001a\u00020\u0015*\u00020\u0015H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006&"}, d2 = {"Lcom/ss/android/lark/passport/flow/auth_type/viewmodel/AuthTypeViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "viewStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/ss/android/lark/passport/flow/auth_type/viewmodel/AuthTypeViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "eventStateFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/ss/android/lark/passport/flow/auth_type/viewmodel/AuthTypeViewModel$UIEvent;", "eventState", "Lkotlinx/coroutines/flow/SharedFlow;", "getEventState", "()Lkotlinx/coroutines/flow/SharedFlow;", "init", "", "stepInfo", "Lcom/ss/android/lark/passport/flow/auth_type/AuthTypeStepInfo;", "reduce", "action", "Lcom/ss/android/lark/passport/flow/auth_type/viewmodel/AuthTypeViewModel$ActionState;", CloudControlInf.ROUTE, "nextStep", "Lcom/ss/android/lark/passport/flow/core/router/FlowStep;", DyPayConstant.KEY_SHOW_LOADING, "", "shouldShowLoading", "buttonType", "Lcom/ss/android/lark/passport/flow/core/model/ButtonType;", "filterSupportedAuthTypes", "ViewState", "ActionState", "UIEvent", "Companion", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthTypeViewModel extends ViewModel {
    private static final b Companion = null;
    private static final String TAG = "AuthTypeViewModel";
    private final d1<c> eventState;
    private final MutableSharedFlow<c> eventStateFlow;
    private final i1<d> viewState;
    private final z0<d> viewStateFlow;

    public static abstract class a {

        /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.auth_type.viewmodel.AuthTypeViewModel$a$a, reason: collision with other inner class name */
        public static final class C5228a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final FlowStep f437735a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C5228a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f437735a, ((C5228a) r100).f437735a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                FlowStep r100 = this.f437735a;
                if (r100 != null) goto L6;
                return 0;
            L6:
                return r100.hashCode();
            }

            public final String toString() {
                return "ClickBottomButton(nextStep=" + this.f437735a + ')';
            }

            public C5228a(FlowStep r100) {
                this.f437735a = r100;
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final FlowStep f437736a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final ButtonType f437737b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof b) == true) goto L8;
                return false;
            L8:
                b r101 = (b) r100;
                if (Intrinsics.areEqual(this.f437736a, r101.f437736a) == true) goto L12;
                return false;
            L12:
                if (this.f437737b == r101.f437737b) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                FlowStep r100 = this.f437736a;
                if (r100 != null) goto L5;
                int r101 = 0;
            L7:
                return (r101 * 31) + this.f437737b.hashCode();
            L5:
                r101 = r100.hashCode();
                goto L7
            }

            public final String toString() {
                return "ClickVerifyItem(nextStep=" + this.f437736a + ", buttonType=" + this.f437737b + ')';
            }

            public b(FlowStep r100, ButtonType r101) {
                Intrinsics.checkNotNullParameter(r101, "buttonType");
                this.f437736a = r100;
                this.f437737b = r101;
            }
        }

        public a() {
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static abstract class c {

        public static final class a extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final FlowStep f437738a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final boolean f437739b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof a) == true) goto L8;
                return false;
            L8:
                a r101 = (a) r100;
                if (Intrinsics.areEqual(this.f437738a, r101.f437738a) == true) goto L12;
                return false;
            L12:
                if (this.f437739b == r101.f437739b) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                int r100 = this.f437738a.hashCode() * 31;
                if (this.f437739b == false) goto L5;
                int r101 = 1231;
            L7:
                return r100 + r101;
            L5:
                r101 = 1237;
                goto L7
            }

            public final String toString() {
                return "RouteToNext(step=" + this.f437738a + ", showLoading=" + this.f437739b + ')';
            }

            public a(FlowStep r100, boolean r101) {
                Intrinsics.checkNotNullParameter(r100, "step");
                this.f437738a = r100;
                this.f437739b = r101;
            }
        }

        public c() {
        }
    }

    public static abstract class d {

        public static final class a extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final AuthTypeStepInfo f437740a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f437740a, ((a) r100).f437740a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f437740a.hashCode();
            }

            public final String toString() {
                return "AuthTypes(stepInfo=" + this.f437740a + ')';
            }

            public a(AuthTypeStepInfo r100) {
                Intrinsics.checkNotNullParameter(r100, "stepInfo");
                this.f437740a = r100;
            }
        }

        public static final class b extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f437741a = null;

            static {
                f437741a = new b();
            }

            public b() {
            }
        }

        public d() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.auth_type.viewmodel.AuthTypeViewModel$route$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.passport.flow.auth_type.viewmodel.AuthTypeViewModel$route$1", f = "AuthTypeViewModel.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FlowStep $nextStep;
        final /* synthetic */ boolean $showLoading;
        int label;
        final /* synthetic */ AuthTypeViewModel this$0;

        public AnonymousClass1(AuthTypeViewModel r100, FlowStep r101, boolean r102, Continuation<? super AnonymousClass1> r103) {
            this.this$0 = r100;
            this.$nextStep = r101;
            this.$showLoading = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, this.$nextStep, this.$showLoading, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            MutableSharedFlow r103 = AuthTypeViewModel.access$getEventStateFlow$p(this.this$0);
            c.a r104 = new c.a(this.$nextStep, this.$showLoading);
            this.label = 1;
            if (r103.emit(r104, this) != r101) goto L12;
            return r101;
        }
    }

    static {
        Companion = new b();
    }

    public AuthTypeViewModel() {
        StateFlowImpl r100 = j1.a(d.b.f437741a);
        this.viewStateFlow = r100;
        this.viewState = e.b(r100);
        MutableSharedFlow<c> r101 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.eventStateFlow = r101;
        this.eventState = e.a(r101);
    }

    public final d1<c> getEventState() {
        return this.eventState;
    }

    public final i1<d> getViewState() {
        return this.viewState;
    }

    public static final /* synthetic */ MutableSharedFlow access$getEventStateFlow$p(AuthTypeViewModel r100) {
        return r100.eventStateFlow;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final AuthTypeStepInfo filterSupportedAuthTypes(AuthTypeStepInfo r100) {
        AuthTypeStepInfo r101 = new AuthTypeStepInfo();
        r101.title = r100.title;
        r101.subTitle = r100.subTitle;
        r101.targetTenantIcon = r100.targetTenantIcon;
        ArrayList<ButtonInfo> r102 = r100.authTypeList;
        if (r102 == null) goto L10;
        ArrayList<ButtonInfo> r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L11;
        Object r105 = r104.next();
        FlowVerifyFactor.a r106 = FlowVerifyFactor.Companion;
        int r107 = ((ButtonInfo) r105).actionType;
        r106.getClass();
        if (FlowVerifyFactor.a.b(r107) == false) goto L6;
        r103.add(r105);
    L11:
        r101.authTypeList = r103;
        r101.bottomButton = r100.bottomButton;
        return r101;
    L10:
        r103 = 0;
        goto L11
    }

    private final boolean shouldShowLoading(ButtonType r100) {
        if (r100 != ButtonType.VERIFY_PHONE) goto L5;
    L7:
        return false;
    L5:
        if (r100 == ButtonType.VERIFY_EMAIL) goto L7;
        return true;
    }

    public final void init(AuthTypeStepInfo r100) {
        if (r100 != null) goto L5;
    L19:
        PassportLog.b(TAG, "init auth type but stepInfo is invalid");
        this.viewStateFlow.setValue(d.b.f437741a);
        return;
    L5:
        if (r100.authTypeList == null) goto L19;
        AuthTypeStepInfo r101 = filterSupportedAuthTypes(r100);
        ArrayList<ButtonInfo> r102 = r101.authTypeList;
        if (r102 != null) goto L10;
    L13:
        boolean r103 = true;
    L14:
        if (r103 == false) goto L17;
        PassportLog.b(TAG, "init auth type but no supported factor");
        this.viewStateFlow.setValue(d.b.f437741a);
        return;
    L17:
        this.viewStateFlow.setValue(new d.a(r101));
        return;
    L10:
        if (r102.isEmpty() == true) goto L13;
        r103 = false;
        goto L14
    }

    public final void reduce(a r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if ((r100 instanceof a.b) == false) goto L6;
        a.b r101 = (a.b) r100;
        route(r101.f437736a, shouldShowLoading(r101.f437737b));
        return;
    L6:
        if ((r100 instanceof a.C5228a) == false) goto L10;
        route(((a.C5228a) r100).f437735a, false);
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    private final void route(FlowStep r100, boolean r101) {
        if (r100 != null) goto L5;
        PassportLog.b(TAG, "route auth type but nextStep is null");
        return;
    L5:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r100, r101, null), 3, null);
    }
}
