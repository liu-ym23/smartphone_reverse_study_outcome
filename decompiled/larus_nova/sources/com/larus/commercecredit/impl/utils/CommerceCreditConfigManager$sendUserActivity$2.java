package com.larus.commercecredit.impl.utils;

import com.bytedance.common.utility.NetworkUtils;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import qz8.q;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$sendUserActivity$2", f = "CommerceCreditConfigManager.kt", i = {1}, l = {TTVideoEngineInterface.PLAYER_OPTION_SEGMENT_FORMAT_FLAG, TTVideoEngineInterface.PLAYER_OPTION_ENABLE_OPEN_BARRAGE_MASK}, m = "invokeSuspend", n = {"result"}, s = {"L$0"})
public final class CommerceCreditConfigManager$sendUserActivity$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<q, Continuation<? super Unit>, Object> $callback;
    final /* synthetic */ String $scene;
    final /* synthetic */ DowngradeSource $source;
    Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public CommerceCreditConfigManager$sendUserActivity$2(String r100, DowngradeSource r101, Function2<? super q, ? super Continuation<? super Unit>, ? extends Object> r102, Continuation<? super CommerceCreditConfigManager$sendUserActivity$2> r103) {
        this.$scene = r100;
        this.$source = r101;
        this.$callback = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CommerceCreditConfigManager$sendUserActivity$2(this.$scene, this.$source, this.$callback, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CommerceCreditConfigManager$sendUserActivity$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.larus.commercecredit.impl.utils.f] */
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
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L10;
        if (r101 == 1) goto L9;
        if (r101 != 2) goto L8;
        q r102 = (q) this.L$0;
        ResultKt.throwOnFailure(r110);
    L23:
        q r111 = r102;
    L24:
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("sendUserActivity success scene=");
        r104.append(this.$scene);
        r104.append(" activityTime=");
        Long r105 = null;
        if (r111 == null) goto L27;
        Long r106 = Boxing.boxLong(r111.a());
    L28:
        r104.append(r106);
        r104.append(" totalCreditNum=");
        if (r111 == null) goto L31;
        r105 = Boxing.boxLong(r111.b());
    L31:
        r104.append(r105);
        r103.i("CommerceCreditConfigManager", r104.toString());
        if (r111 == null) goto L35;
        com.larus.commercecredit.impl.model.c r107 = com.larus.commercecredit.impl.model.c.f325721a;
        com.larus.commercecredit.impl.model.c.j(r111.b());
    L35:
        return Unit.INSTANCE;
    L27:
        r106 = null;
        goto L28
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r110);
    L17:
        r111 = (q) r110;
        Function2<q, Continuation<? super Unit>, Object> r108 = this.$callback;
        if (r108 == null) goto L24;
        this.L$0 = r111;
        this.label = 2;
        if (r108.invoke(r111, this) != r100) goto L22;
        return r100;
    L22:
        r102 = r111;
        goto L23
    L10:
        ResultKt.throwOnFailure(r110);
        if (NetworkUtils.isNetworkAvailable(AppHost.f326268a.getApplication()) == true) goto L14;
        FLogger.f375446a.i("CommerceCreditConfigManager", "sendUserActivity: no network scene=" + this.$scene);
        return Unit.INSTANCE;
    L14:
        FLogger.f375446a.i("CommerceCreditConfigManager", "sendUserActivity: scene=" + this.$scene + " source=" + this.$source);
        final long r109 = System.currentTimeMillis();
        com.larus.commercecredit.impl.model.c r112 = com.larus.commercecredit.impl.model.c.f325721a;
        DowngradeSource r113 = this.$source;
        final String r114 = this.$scene;
        ?? r115 = new f(r114, r109);
        this.label = 1;
        r110 = r112.i(r113, r115, this);
        if (r110 != r100) goto L17;
        return r100;
    }
}
