package com.larus.commercecredit.impl.utils;

import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.keva.Keva;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$openCommerceCreditGuide$2", f = "CommerceCreditConfigManager.kt", i = {}, l = {247, 262}, m = "invokeSuspend", n = {}, s = {})
final class CommerceCreditConfigManager$openCommerceCreditGuide$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<qz8.k, Unit> $openAction;
    final /* synthetic */ DowngradeSource $source;
    int label;

    /* JADX INFO: renamed from: com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$openCommerceCreditGuide$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$openCommerceCreditGuide$2$1", f = "CommerceCreditConfigManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ qz8.k $creditTip;
        final /* synthetic */ Function1<qz8.k, Unit> $openAction;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super qz8.k, Unit> r100, qz8.k r101, Continuation<? super AnonymousClass1> r102) {
            this.$openAction = r100;
            this.$creditTip = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.$openAction, this.$creditTip, r101);
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
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r100);
            this.$openAction.invoke(this.$creditTip);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CommerceCreditConfigManager$openCommerceCreditGuide$2(DowngradeSource r100, Function1<? super qz8.k, Unit> r101, Continuation<? super CommerceCreditConfigManager$openCommerceCreditGuide$2> r102) {
        this.$source = r100;
        this.$openAction = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CommerceCreditConfigManager$openCommerceCreditGuide$2(this.$source, this.$openAction, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CommerceCreditConfigManager$openCommerceCreditGuide$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.larus.commercecredit.impl.utils.e] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L9;
        if (r102 != 2) goto L8;
        ResultKt.throwOnFailure(r100);
    L52:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
    L17:
        qz8.k r103 = (qz8.k) r100;
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("openCreditTipFromRemote: isFirstVisit=");
        if (r103 == null) goto L20;
        Boolean r106 = Boxing.boxBoolean(r103.b());
    L21:
        r105.append(r106);
        r105.append(" title=");
        if (r103 == null) goto L26;
        qz8.e r107 = r103.a();
        if (r107 == null) goto L26;
        String r108 = r107.h();
    L27:
        r105.append(r108);
        r105.append(" desc=");
        if (r103 == null) goto L32;
        qz8.e r109 = r103.a();
        if (r109 == null) goto L32;
        String r110 = r109.d();
    L33:
        r105.append(r110);
        r104.i("CommerceCreditConfigManager", r105.toString());
        if (r103 != null) goto L36;
    L38:
        boolean r111 = false;
    L40:
        if (r111 == false) goto L44;
        com.larus.commercecredit.impl.model.c r112 = com.larus.commercecredit.impl.model.c.f325721a;
        Keva r113 = com.larus.commercecredit.impl.model.c.c();
        if (r113 == null) goto L52;
        r113.storeBoolean("credit_tip_show_status", true);
        goto L52
    L44:
        if (r103 == null) goto L52;
        com.larus.commercecredit.impl.model.c r114 = com.larus.commercecredit.impl.model.c.f325721a;
        Keva r115 = com.larus.commercecredit.impl.model.c.c();
        if (r115 == null) goto L48;
        r115.storeBoolean("credit_tip_show_status", true);
    L48:
        MainCoroutineDispatcher r116 = Dispatchers.getMain();
        AnonymousClass1 r117 = new AnonymousClass1(this.$openAction, r103, null);
        this.label = 2;
        if (BuildersKt.withContext(r116, r117, this) != r101) goto L52;
        return r101;
    L36:
        if (r103.b() == true) goto L38;
        r111 = true;
    L32:
        r110 = null;
    L26:
        r108 = null;
        goto L27
    L20:
        r106 = null;
        goto L21
    L10:
        ResultKt.throwOnFailure(r100);
        if (NetworkUtils.isNetworkAvailable(AppHost.f326268a.getApplication().getApplicationContext()) == true) goto L14;
        FLogger.f375446a.i("CommerceCreditConfigManager", "openCreditTipFromRemote: no network");
        return Unit.INSTANCE;
    L14:
        final long r118 = System.currentTimeMillis();
        com.larus.commercecredit.impl.model.c r119 = com.larus.commercecredit.impl.model.c.f325721a;
        DowngradeSource r120 = this.$source;
        ?? r121 = new e(r118);
        this.label = 1;
        r100 = r119.f(r120, r121, this);
        if (r100 != r101) goto L17;
        return r101;
    }
}
