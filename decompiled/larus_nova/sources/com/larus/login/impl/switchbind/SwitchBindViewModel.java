package com.larus.login.impl.switchbind;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.larus.account.base.api.ILoginService;
import com.larus.login.api.SwitchBindParam;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0003\"#$B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\r\u0010\u001c\u001a\u00020\u0016H\u0000¢\u0006\u0002\b\u001dJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000eH\u0002J\b\u0010!\u001a\u00020\u0016H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006%"}, d2 = {"Lcom/larus/login/impl/switchbind/SwitchBindViewModel;", "Landroidx/lifecycle/ViewModel;", "loginService", "Lcom/larus/account/base/api/ILoginService;", "<init>", "(Lcom/larus/account/base/api/ILoginService;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/login/impl/switchbind/SwitchBindState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "data", "Lcom/larus/account/base/model/BindConflictUserInfoData;", "platformAppId", "", "platform", "platformNickname", "getPlatformNickname", "()Ljava/lang/String;", "dispatch", "", "intent", "Lcom/larus/login/impl/switchbind/SwitchBindIntent;", "fetchAccountInfo", "switchBindParam", "Lcom/larus/login/api/SwitchBindParam;", "consumeAccountInfoError", "consumeAccountInfoError$impl_mainlandRelease", "switchBindDisabled", "", "userInfoData", "executeSwitch", "Companion", "SwitchBindViewModelFactory", "UnlinkedAccountChecker", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SwitchBindViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "SwitchBindViewModel";
    private final z0<n> _state;
    private q38.h data;
    private final ILoginService loginService;
    private String platform;
    private String platformAppId;
    private final i1<n> state;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u0002H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/larus/login/impl/switchbind/SwitchBindViewModel$SwitchBindViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "<init>", "()V", "create", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SwitchBindViewModelFactory implements ViewModelProvider.Factory {
        public SwitchBindViewModelFactory() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public final /* synthetic */ ViewModel create(Class r100, CreationExtras r101) {
            return ViewModelProvider.Factory.CC.$default$create(this, r100, r101);
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public final /* synthetic */ ViewModel create(KClass r100, CreationExtras r101) {
            return ViewModelProvider.Factory.CC.$default$create(this, r100, r101);
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public final <T extends ViewModel> T create(Class<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "modelClass");
            FLogger.f375446a.i(SwitchBindViewModel.TAG, "SwitchBindViewModelFactory create: ".concat(r100.getName()));
            if (r100.isAssignableFrom(SwitchBindViewModel.class) == false) goto L7;
            return new SwitchBindViewModel((ILoginService) ServiceManager.get().getService(ILoginService.class));
        L7:
            throw new IllegalArgumentException("Unknown ViewModel class");
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f358238a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Lazy f358239b;

        public static final class a {
        }

        static {
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "platformAppId");
            this.f358238a = r100;
            this.f358239b = LazyKt.lazy(new o());
        }

        public static boolean a(boolean r100, String r101) {
            if (r100 == true) goto L5;
            FLogger.f375446a.i(SwitchBindViewModel.TAG, "[" + r101 + "] ignored by config");
            return false;
        L5:
            return true;
        }
    }

    /* JADX INFO: renamed from: com.larus.login.impl.switchbind.SwitchBindViewModel$executeSwitch$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.login.impl.switchbind.SwitchBindViewModel$executeSwitch$1", f = "SwitchBindViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SwitchBindViewModel this$0;

        /* JADX INFO: renamed from: com.larus.login.impl.switchbind.SwitchBindViewModel$executeSwitch$1$a */
        public static final class a implements n38.m {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SwitchBindViewModel f358240a;

            public a(SwitchBindViewModel r100) {
                this.f358240a = r100;
            }

            @Override // n38.m
            public final void onSuccess(String r100) {
                FLogger.f375446a.i(SwitchBindViewModel.TAG, "[executeSwitch] onSuccess");
                z0 r101 = SwitchBindViewModel.access$get_state$p(this.f358240a);
                n r102 = (n) SwitchBindViewModel.access$get_state$p(this.f358240a).getValue();
                Result.Companion r103 = Result.Companion;
                r101.setValue(n.a(r102, false, null, null, null, Result.m9448boximpl(Result.m9449constructorimpl(Unit.INSTANCE)), 14));
            }

            @Override // n38.m
            public final void a(int r100, String r110, String r111, String r112) {
                FLogger.f375446a.e(SwitchBindViewModel.TAG, "[executeSwitch] onFailed, " + r100 + ':' + r110);
                z0 r113 = SwitchBindViewModel.access$get_state$p(this.f358240a);
                n r101 = (n) SwitchBindViewModel.access$get_state$p(this.f358240a).getValue();
                Result.Companion r114 = Result.Companion;
                r113.setValue(n.a(r101, false, null, null, null, Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(new Throwable(r100 + ':' + r110)))), 14));
            }
        }

        public AnonymousClass1(SwitchBindViewModel r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
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
        public final Object invokeSuspend(Object r110) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L35;
            ResultKt.throwOnFailure(r110);
            SwitchBindViewModel.access$get_state$p(this.this$0).setValue(n.a((n) SwitchBindViewModel.access$get_state$p(this.this$0).getValue(), true, null, null, null, null, 30));
            q38.o r111 = SwitchBindViewModel.access$getData$p(this.this$0).b();     // Catch: Exception -> L30
            String r100 = null;
            if (r111 == null) goto L9;
            String r112 = r111.a();     // Catch: Exception -> L30
        L10:
            String r101 = "";
            if (r112 != null) goto L13;
            r112 = "";
        L13:
            q38.o r102 = SwitchBindViewModel.access$getData$p(this.this$0).b();     // Catch: Exception -> L30
            if (r102 == null) goto L16;
            r100 = r102.b();     // Catch: Exception -> L30
        L16:
            if (r100 == null) goto L19;
            r101 = r100;
        L19:
            FLogger r103 = FLogger.f375446a;     // Catch: Exception -> L30
            StringBuilder r104 = new StringBuilder("[executeSwitch] start, profileKeyPresent=");     // Catch: Exception -> L30
            boolean r105 = false;
            if (r112.length() <= 0) goto L22;
            boolean r106 = true;
        L23:
            r104.append(r106);     // Catch: Exception -> L30
            r104.append(", verifyTicketPresent=");     // Catch: Exception -> L30
            if (r101.length() <= 0) goto L26;
            r105 = true;
        L26:
            r104.append(r105);     // Catch: Exception -> L30
            r104.append(", platformAppId=");     // Catch: Exception -> L30
            r104.append(SwitchBindViewModel.access$getPlatformAppId$p(this.this$0));     // Catch: Exception -> L30
            r104.append(", platform=");     // Catch: Exception -> L30
            r104.append(SwitchBindViewModel.access$getPlatform$p(this.this$0));     // Catch: Exception -> L30
            r103.i(SwitchBindViewModel.TAG, r104.toString());     // Catch: Exception -> L30
            ILoginService r107 = SwitchBindViewModel.access$getLoginService$p(this.this$0);     // Catch: Exception -> L30
            if (r107 == null) goto L33;
            r107.c(r112, SwitchBindViewModel.access$getPlatformAppId$p(this.this$0), r101, new a(this.this$0));     // Catch: Exception -> L30
        L33:
            return Unit.INSTANCE;
        L22:
            r106 = false;
            goto L23
        L9:
            r112 = null;
        L30:
            e = move-exception;
            FLogger.f375446a.e(SwitchBindViewModel.TAG, "[executeSwitch] exception: " + e.getMessage());
            z0 r108 = SwitchBindViewModel.access$get_state$p(this.this$0);
            n r109 = (n) SwitchBindViewModel.access$get_state$p(this.this$0).getValue();
            Result.Companion r113 = Result.Companion;
            r108.setValue(n.a(r109, false, null, null, null, Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(e))), 14));
            goto L33
        L35:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.login.impl.switchbind.SwitchBindViewModel$fetchAccountInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.login.impl.switchbind.SwitchBindViewModel$fetchAccountInfo$1", f = "SwitchBindViewModel.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
    public static final class C114781 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SwitchBindParam $switchBindParam;
        int label;
        final /* synthetic */ SwitchBindViewModel this$0;

        /* JADX INFO: renamed from: com.larus.login.impl.switchbind.SwitchBindViewModel$fetchAccountInfo$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.login.impl.switchbind.SwitchBindViewModel$fetchAccountInfo$1$1", f = "SwitchBindViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C44181 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ SwitchBindViewModel this$0;

            public C44181(SwitchBindViewModel r100, Continuation<? super C44181> r101) {
                this.this$0 = r100;
                super(2, r101);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                return new C44181(this.this$0, r101);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                return invoke2(r100, r101);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                return ((C44181) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r100) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r100);
                SwitchBindViewModel.access$get_state$p(this.this$0).setValue(n.a((n) SwitchBindViewModel.access$get_state$p(this.this$0).getValue(), true, null, null, null, null, 22));
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public C114781(SwitchBindParam r100, SwitchBindViewModel r101, Continuation<? super C114781> r102) {
            this.$switchBindParam = r100;
            this.this$0 = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C114781(this.$switchBindParam, this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C114781) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v1, types: [com.larus.login.impl.switchbind.SwitchBindViewModel$fetchAccountInfo$1$2] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L11:
            FLogger.f375446a.i(SwitchBindViewModel.TAG, "[fetchAccountInfo] start, switchBindParam:" + this.$switchBindParam);
            SwitchBindViewModel r103 = this.this$0;
            String r104 = this.$switchBindParam.f356995b;
            String r105 = "";
            if (r104 != null) goto L14;
            r104 = "";
        L14:
            SwitchBindViewModel.access$setPlatformAppId$p(r103, r104);
            SwitchBindViewModel r106 = this.this$0;
            String r107 = this.$switchBindParam.f356996c;
            if (r107 != null) goto L17;
            r107 = "";
        L17:
            SwitchBindViewModel.access$setPlatform$p(r106, r107);
            ILoginService r108 = SwitchBindViewModel.access$getLoginService$p(this.this$0);
            if (r108 == 0) goto L25;
            String r109 = this.$switchBindParam.f356994a;
            if (r109 == null) goto L23;
            r105 = r109;
        L23:
            String r110 = SwitchBindViewModel.access$getPlatformAppId$p(this.this$0);
            String r111 = SwitchBindViewModel.access$getPlatform$p(this.this$0);
            final SwitchBindViewModel r112 = this.this$0;
            r108.A(r105, r110, r111, new AnonymousClass2(r112));
        L25:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            MainCoroutineDispatcher r113 = Dispatchers.getMain();
            C44181 r114 = new C44181(this.this$0, null);
            this.label = 1;
            if (BuildersKt.withContext(r113, r114, this) != r101) goto L11;
            return r101;
        }
    }

    static {
        Companion = new a();
    }

    public final void consumeAccountInfoError$impl_mainlandRelease() {
        z0<n> r100 = this._state;
        r100.setValue(n.a(r100.getValue(), false, null, null, null, null, 23));
    }

    public final String getPlatformNickname() {
        q38.m r100 = this.data.a();
        if (r100 == null) goto L5;
        String r101 = r100.a();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    private final void executeSwitch() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final i1<n> getState() {
        return this.state;
    }

    public SwitchBindViewModel(ILoginService r100) {
        this.loginService = r100;
        StateFlowImpl r101 = j1.a(new n(0));
        this._state = r101;
        this.state = kotlinx.coroutines.flow.e.b(r101);
        this.data = new q38.h(0);
        this.platformAppId = "";
        this.platform = "";
    }

    public static final /* synthetic */ q38.h access$getData$p(SwitchBindViewModel r100) {
        return r100.data;
    }

    public static final /* synthetic */ ILoginService access$getLoginService$p(SwitchBindViewModel r100) {
        return r100.loginService;
    }

    public static final /* synthetic */ String access$getPlatform$p(SwitchBindViewModel r100) {
        return r100.platform;
    }

    public static final /* synthetic */ String access$getPlatformAppId$p(SwitchBindViewModel r100) {
        return r100.platformAppId;
    }

    public static final /* synthetic */ z0 access$get_state$p(SwitchBindViewModel r100) {
        return r100._state;
    }

    private final void fetchAccountInfo(SwitchBindParam r100) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C114781(r100, this, null), 2, null);
    }

    private final boolean switchBindDisabled(q38.h r100) {
        q38.c r101 = q38.i.a(r100);
        if (r101 != null) goto L5;
        return false;
    L5:
        b r102 = new b(this.platformAppId);
        Intrinsics.checkNotNullParameter(r101, "user");
        String r103 = null;
        if (b.a(((av9.c) r102.f358239b.getValue()).c(), "Platform") == false) goto L35;
        q38.g r104 = r101.a();
        if (r104 == null) goto L35;
        List<q38.k> r105 = r104.b();
        if (r105 == null) goto L35;
        if (r105.size() > 1) goto L33;
        List<q38.k> r106 = r105;
        if ((r106 instanceof Collection) == true) goto L18;
    L20:
        Iterator<T> r107 = r106.iterator();
    L22:
        if (r107.hasNext() == false) goto L30;
        q38.k r108 = (q38.k) r107.next();
        if (r108 == null) goto L26;
        String r109 = Integer.valueOf(r108.a()).toString();
    L28:
        if (Intrinsics.areEqual(r109, r102.f358238a) == false) goto L22;
        boolean r110 = true;
    L31:
        if (r110 == false) goto L33;
        boolean r111 = true;
    L34:
        boolean r112 = !r111;
    L36:
        q38.g r113 = r101.a();
        if (r113 == null) goto L39;
        String r114 = r113.d();
    L41:
        if (b.a(((av9.c) r102.f358239b.getValue()).b(), "Mobile") == true) goto L43;
        boolean r115 = false;
    L50:
        q38.g r116 = r101.a();
        if (r116 == null) goto L54;
        r103 = r116.c();
    L54:
        if (b.a(((av9.c) r102.f358239b.getValue()).a(), "Email") == true) goto L56;
        boolean r117 = false;
    L63:
        FLogger.f375446a.i(TAG, "[isUnlinked] result[" + r112 + ':' + r115 + ':' + r117 + ']');
        if (r112 == true) goto L75;
        if (r115 == true) goto L73;
        if (r117 == true) goto L74;
        return true;
    L74:
        return false;
    L73:
        return false;
    L75:
        return false;
    L56:
        if (r103 != null) goto L58;
    L61:
        boolean r118 = true;
    L62:
        r117 = !r118;
        goto L63
    L58:
        if (r103.length() == 0) goto L61;
        r118 = false;
        goto L62
    L43:
        if (r114 != null) goto L45;
    L48:
        boolean r119 = true;
    L49:
        r115 = !r119;
        goto L50
    L45:
        if (r114.length() == 0) goto L48;
        r119 = false;
        goto L49
    L39:
        r114 = null;
        goto L41
    L26:
        r109 = null;
    L30:
        r110 = false;
        goto L31
    L18:
        if (r106.isEmpty() == false) goto L20;
    L33:
        r111 = false;
    L35:
        r112 = false;
        goto L36
    }

    public final void dispatch(g r100) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        FLogger.f375446a.i(TAG, "[dispatch] intent=" + Reflection.getOrCreateKotlinClass(r100.getClass()).getSimpleName());
        if ((r100 instanceof g.b) == false) goto L6;
        fetchAccountInfo(((g.b) r100).f358248a);
        return;
    L6:
        if ((r100 instanceof g.a) == false) goto L10;
        executeSwitch();
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ void access$setData$p(SwitchBindViewModel r100, q38.h r101) {
        r100.data = r101;
    }

    public static final /* synthetic */ void access$setPlatform$p(SwitchBindViewModel r100, String r101) {
        r100.platform = r101;
    }

    public static final /* synthetic */ void access$setPlatformAppId$p(SwitchBindViewModel r100, String r101) {
        r100.platformAppId = r101;
    }

    public static final /* synthetic */ boolean access$switchBindDisabled(SwitchBindViewModel r100, q38.h r101) {
        return r100.switchBindDisabled(r101);
    }
}
