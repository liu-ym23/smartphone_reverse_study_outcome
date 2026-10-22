package com.larus.commercecredit.impl.utils;

import android.content.Context;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import t19.s;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getAllCreditInfo$2", f = "CommerceCreditConfigManager.kt", i = {0, 2}, l = {175, 181, 192, 208}, m = "invokeSuspend", n = {"localCreditConfig", "localCreditConfig"}, s = {"L$0", "L$0"})
final class CommerceCreditConfigManager$getAllCreditInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<qz8.g, qz8.g, Boolean, Unit> $callback;
    final /* synthetic */ boolean $isSupportFromLocal;
    final /* synthetic */ boolean $needTasks;
    final /* synthetic */ String $newScene;
    Object L$0;
    int label;

    /* JADX INFO: renamed from: com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getAllCreditInfo$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getAllCreditInfo$2$1", f = "CommerceCreditConfigManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<qz8.g, qz8.g, Boolean, Unit> $callback;
        final /* synthetic */ Ref.ObjectRef<qz8.g> $localCreditConfig;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function3<? super qz8.g, ? super qz8.g, ? super Boolean, Unit> r100, Ref.ObjectRef<qz8.g> r101, Continuation<? super AnonymousClass1> r102) {
            this.$callback = r100;
            this.$localCreditConfig = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.$callback, this.$localCreditConfig, r101);
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
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L9;
            ResultKt.throwOnFailure(r100);
            Function3<qz8.g, qz8.g, Boolean, Unit> r101 = this.$callback;
            if (r101 == null) goto L10;
            r101.invoke(this.$localCreditConfig.element, null, Boxing.boxBoolean(true));
            return Unit.INSTANCE;
        L10:
            return null;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getAllCreditInfo$2$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getAllCreditInfo$2$2", f = "CommerceCreditConfigManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<qz8.g, qz8.g, Boolean, Unit> $callback;
        final /* synthetic */ Ref.ObjectRef<qz8.g> $localCreditConfig;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function3<? super qz8.g, ? super qz8.g, ? super Boolean, Unit> r100, Ref.ObjectRef<qz8.g> r101, Continuation<? super AnonymousClass2> r102) {
            this.$callback = r100;
            this.$localCreditConfig = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(this.$callback, this.$localCreditConfig, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L9;
            ResultKt.throwOnFailure(r100);
            Context r101 = AppHost.f326268a.getApplication().getApplicationContext();
            s.j(s.f544207a, r101, r101.getString(R.string.larus_log_in_internet_error), null, false, 28);
            Function3<qz8.g, qz8.g, Boolean, Unit> r102 = this.$callback;
            if (r102 == null) goto L10;
            r102.invoke(this.$localCreditConfig.element, null, Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        L10:
            return null;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getAllCreditInfo$2$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getAllCreditInfo$2$3", f = "CommerceCreditConfigManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<qz8.g, qz8.g, Boolean, Unit> $callback;
        final /* synthetic */ Ref.ObjectRef<qz8.g> $localCreditConfig;
        final /* synthetic */ qz8.g $remoteCreditConfig;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(Function3<? super qz8.g, ? super qz8.g, ? super Boolean, Unit> r100, Ref.ObjectRef<qz8.g> r101, qz8.g r102, Continuation<? super AnonymousClass3> r103) {
            this.$callback = r100;
            this.$localCreditConfig = r101;
            this.$remoteCreditConfig = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass3(this.$callback, this.$localCreditConfig, this.$remoteCreditConfig, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass3) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r100);
            Function3<qz8.g, qz8.g, Boolean, Unit> r101 = this.$callback;
            if (r101 == null) goto L7;
            r101.invoke(this.$localCreditConfig.element, this.$remoteCreditConfig, Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        L7:
            return null;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CommerceCreditConfigManager$getAllCreditInfo$2(boolean r100, String r101, boolean r102, Function3<? super qz8.g, ? super qz8.g, ? super Boolean, Unit> r103, Continuation<? super CommerceCreditConfigManager$getAllCreditInfo$2> r104) {
        this.$isSupportFromLocal = r100;
        this.$newScene = r101;
        this.$needTasks = r102;
        this.$callback = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CommerceCreditConfigManager$getAllCreditInfo$2(this.$isSupportFromLocal, this.$newScene, this.$needTasks, this.$callback, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CommerceCreditConfigManager$getAllCreditInfo$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v2, types: [T, qz8.g] */
    /* JADX WARN: Type inference failed for: r13v3, types: [com.larus.commercecredit.impl.utils.a] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L14;
        if (r101 == 1) goto L13;
        if (r101 == 2) goto L12;
        if (r101 == 3) goto L11;
        if (r101 != 4) goto L10;
        ResultKt.throwOnFailure(r110);
    L57:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        Ref.ObjectRef r102 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r110);
        Object r103 = r110;
    L41:
        qz8.g r104 = (qz8.g) r103;
        FLogger r105 = FLogger.f375446a;
        StringBuilder r106 = new StringBuilder("getAllCreditInfoFromRemote: scene=");
        r106.append(this.$newScene);
        r106.append(" needTasks=");
        r106.append(this.$needTasks);
        r106.append(" isSupportFromLocal=");
        r106.append(this.$isSupportFromLocal);
        r106.append(" creditValue=");
        if (r104 == null) goto L46;
        qz8.f r107 = r104.a();
        if (r107 == null) goto L46;
        Long r108 = r107.f();
    L47:
        r106.append(r108);
        r106.append(" creditTasks=");
        if (r104 == null) goto L52;
        List<qz8.j> r109 = r104.c();
        if (r109 == null) goto L52;
        Integer r111 = Boxing.boxInt(r109.size());
    L53:
        r106.append(r111);
        r105.i("CommerceCreditConfigManager", r106.toString());
        MainCoroutineDispatcher r112 = Dispatchers.getMain();
        AnonymousClass3 r113 = new AnonymousClass3(this.$callback, r102, r104, null);
        this.L$0 = null;
        this.label = 4;
        if (BuildersKt.withContext(r112, r113, this) != r100) goto L57;
        return r100;
    L52:
        r111 = null;
    L46:
        r108 = null;
        goto L47
    L12:
        ResultKt.throwOnFailure(r110);
    L36:
        FLogger.f375446a.i("CommerceCreditConfigManager", "getAllCreditInfoFromRemote: no network scene=" + this.$newScene + " needTasks=" + this.$needTasks + " isSupportFromLocal=" + this.$isSupportFromLocal);
        return Unit.INSTANCE;
    L13:
        r102 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r110);
    L32:
        if (NetworkUtils.isNetworkAvailable(AppHost.f326268a.getApplication()) == true) goto L38;
        MainCoroutineDispatcher r114 = Dispatchers.getMain();
        AnonymousClass2 r115 = new AnonymousClass2(this.$callback, r102, null);
        this.L$0 = null;
        this.label = 2;
        if (BuildersKt.withContext(r114, r115, this) != r100) goto L36;
        return r100;
    L38:
        final long r116 = System.currentTimeMillis();
        com.larus.commercecredit.impl.model.c r117 = com.larus.commercecredit.impl.model.c.f325721a;
        final boolean r118 = this.$needTasks;
        final String r119 = this.$newScene;
        final Ref.ObjectRef r120 = r102;
        ?? r121 = new a(r120, r119, r116, r118);
        this.L$0 = r102;
        this.label = 3;
        r103 = r117.e(r118, r121, this);
        if (r103 != r100) goto L41;
        return r100;
    L14:
        ResultKt.throwOnFailure(r110);
        r102 = new Ref.ObjectRef();
        if (this.$isSupportFromLocal == false) goto L32;
        com.larus.commercecredit.impl.model.c r122 = com.larus.commercecredit.impl.model.c.f325721a;
        r102.element = com.larus.commercecredit.impl.model.c.a();
        FLogger r123 = FLogger.f375446a;
        StringBuilder r124 = new StringBuilder("getAllCreditInfoFromLocal: scene=");
        r124.append(this.$newScene);
        r124.append(" needTasks=");
        r124.append(this.$needTasks);
        r124.append(" isSupportFromLocal=true creditValue=");
        qz8.g r125 = (qz8.g) r102.element;
        if (r125 == null) goto L21;
        qz8.f r126 = r125.a();
        if (r126 == null) goto L21;
        Long r127 = r126.f();
    L22:
        r124.append(r127);
        r124.append(" creditTasks=");
        qz8.g r128 = (qz8.g) r102.element;
        if (r128 == null) goto L27;
        List<qz8.j> r129 = r128.c();
        if (r129 == null) goto L27;
        Integer r130 = Boxing.boxInt(r129.size());
    L28:
        r124.append(r130);
        r123.i("CommerceCreditConfigManager", r124.toString());
        MainCoroutineDispatcher r131 = Dispatchers.getMain();
        AnonymousClass1 r132 = new AnonymousClass1(this.$callback, r102, null);
        this.L$0 = r102;
        this.label = 1;
        if (BuildersKt.withContext(r131, r132, this) != r100) goto L32;
        return r100;
    L27:
        r130 = null;
    L21:
        r127 = null;
        goto L22
    }
}
