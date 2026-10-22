package com.larus.bmhome.chat.manager;

import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.setting.IUserSettingCacheService;
import com.larus.bmhome.chat.setting.bean.UserConfigKey;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: classes25.dex */
public final class ExpertSwitchManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CoroutineScope f306663a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ISettingRepoService f306664b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f306665c = null;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.manager.ExpertSwitchManager$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.chat.manager.ExpertSwitchManager$1", f = "ExpertSwitchManager.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.manager.ExpertSwitchManager$1$a */
        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<T> f306666a = null;

            static {
                f306666a = new a();
            }

            public a() {
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object r100, Continuation r101) {
                UserConfigKey r102 = (UserConfigKey) r100;
                FLogger.f375446a.d("ExpertSwitchManager", "init userConfigUpdatedFlow:" + r102);
                if (r102 != UserConfigKey.EXPERT_SWITCH) goto L9;
                Object r103 = BuildersKt.withContext(Dispatchers.getMain(), new ExpertSwitchManager$1$1$1(null), r101);
                if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
                return r103;
            L10:
                return Unit.INSTANCE;
            L9:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(Continuation<? super AnonymousClass1> r100) {
            super(2, r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(r101);
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
            if (r102 != 1) goto L6;
            ResultKt.throwOnFailure(r100);
        L16:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            IUserSettingCacheService r103 = (IUserSettingCacheService) ServiceManager.get().getService(IUserSettingCacheService.class);
            if (r103 == null) goto L18;
            d1<UserConfigKey> r104 = r103.i();
            if (r104 == null) goto L18;
            FlowCollector<? super UserConfigKey> r105 = a.f306666a;
            this.label = 1;
            if (r104.collect(r105, this) != r101) goto L16;
            return r101;
        L18:
            return Unit.INSTANCE;
        }
    }

    public ExpertSwitchManager() {
    }

    static {
        CoroutineScope r100 = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        f306663a = r100;
        f306664b = RepoDispatcherDelegate.f307737b.c();
        f306665c = LazyKt.lazy(new f0());
        BuildersKt.launch$default(r100, null, null, new AnonymousClass1(null), 3, null);
    }

    public static final void a() {
        boolean r100 = f306664b.f0();
        Iterator r101 = ((List) f306665c.getValue()).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Function1 r102 = (Function1) ((WeakReference) r101.next()).get();
        if (r102 == null) goto L4;
        r102.invoke(Boolean.valueOf(r100));
        goto L4
    }

    public static void b(boolean r100, Function1 r101) {
        BuildersKt.launch$default(f306663a, null, null, new ExpertSwitchManager$updateExpertSwitchState$1(r100, r101, null), 3, null);
    }
}
