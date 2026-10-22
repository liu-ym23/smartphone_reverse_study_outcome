package com.larus.commercecredit.impl.utils;

import android.content.Context;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
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
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import qz8.l;
import t19.s;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getGroupInvitationInfo$2", f = "CommerceCreditConfigManager.kt", i = {}, l = {339, 348, 358}, m = "invokeSuspend", n = {}, s = {})
final class CommerceCreditConfigManager$getGroupInvitationInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $campaignKey;
    final /* synthetic */ Function1<l, Unit> $inviteActionCallback;
    final /* synthetic */ String $scene;
    int label;

    /* JADX INFO: renamed from: com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getGroupInvitationInfo$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getGroupInvitationInfo$2$1", f = "CommerceCreditConfigManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

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
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r100);
            Context r101 = AppHost.f326268a.getApplication().getApplicationContext();
            s.j(s.f544207a, r101, r101.getString(R.string.larus_credit_errToast_share), null, false, 28);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getGroupInvitationInfo$2$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.commercecredit.impl.utils.CommerceCreditConfigManager$getGroupInvitationInfo$2$2", f = "CommerceCreditConfigManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ l $groupInvitationInfo;
        final /* synthetic */ Function1<l, Unit> $inviteActionCallback;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function1<? super l, Unit> r100, l r101, Continuation<? super AnonymousClass2> r102) {
            this.$inviteActionCallback = r100;
            this.$groupInvitationInfo = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(this.$inviteActionCallback, this.$groupInvitationInfo, r101);
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
            if (this.label != 0) goto L25;
            ResultKt.throwOnFailure(r100);
            this.$inviteActionCallback.invoke(this.$groupInvitationInfo);
            l r101 = this.$groupInvitationInfo;
            if (r101 == null) goto L21;
            String r102 = r101.c();
            boolean r103 = true;
            if (r102 != null) goto L9;
        L12:
            boolean r104 = true;
        L13:
            if (r104 == false) goto L23;
            String r105 = this.$groupInvitationInfo.d();
            if (r105 != null) goto L17;
        L20:
            if (r103 == false) goto L23;
        L17:
            if (r105.length() == 0) goto L20;
            r103 = false;
        L23:
            return Unit.INSTANCE;
        L9:
            if (r102.length() == 0) goto L12;
            r104 = false;
        L21:
            Context r106 = AppHost.f326268a.getApplication().getApplicationContext();
            s.j(s.f544207a, r106, r106.getString(R.string.larus_credit_errToast_copy), null, false, 28);
            goto L23
        L25:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CommerceCreditConfigManager$getGroupInvitationInfo$2(String r100, String r101, Function1<? super l, Unit> r102, Continuation<? super CommerceCreditConfigManager$getGroupInvitationInfo$2> r103) {
        this.$scene = r100;
        this.$campaignKey = r101;
        this.$inviteActionCallback = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CommerceCreditConfigManager$getGroupInvitationInfo$2(this.$scene, this.$campaignKey, this.$inviteActionCallback, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CommerceCreditConfigManager$getGroupInvitationInfo$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.larus.commercecredit.impl.utils.c] */
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
        if (r101 == 0) goto L12;
        if (r101 == 1) goto L11;
        if (r101 == 2) goto L10;
        if (r101 != 3) goto L9;
        ResultKt.throwOnFailure(r110);
    L30:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r110);
    L22:
        l r111 = (l) r110;
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("getGroupInvitationInfo: scene=");
        r103.append(this.$scene);
        r103.append(" campaignKey=");
        r103.append(this.$campaignKey);
        r103.append(" shareText=");
        if (r111 == null) goto L25;
        String r104 = r111.c();
    L26:
        r103.append(r104);
        r102.i("CommerceCreditConfigManager", r103.toString());
        MainCoroutineDispatcher r105 = Dispatchers.getMain();
        AnonymousClass2 r106 = new AnonymousClass2(this.$inviteActionCallback, r111, null);
        this.label = 3;
        if (BuildersKt.withContext(r105, r106, this) != r100) goto L30;
        return r100;
    L25:
        r104 = null;
        goto L26
    L11:
        ResultKt.throwOnFailure(r110);
    L17:
        FLogger.f375446a.i("CommerceCreditConfigManager", "getGroupInfoFromRemote: no network scene=" + this.$scene + " campaignKey=" + this.$campaignKey);
        return Unit.INSTANCE;
    L12:
        ResultKt.throwOnFailure(r110);
        if (NetworkUtils.isNetworkAvailable(AppHost.f326268a.getApplication()) == true) goto L19;
        MainCoroutineDispatcher r112 = Dispatchers.getMain();
        AnonymousClass1 r107 = new AnonymousClass1(null);
        this.label = 1;
        if (BuildersKt.withContext(r112, r107, this) != r100) goto L17;
        return r100;
    L19:
        final long r108 = System.currentTimeMillis();
        com.larus.commercecredit.impl.model.c r113 = com.larus.commercecredit.impl.model.c.f325721a;
        final String r109 = this.$campaignKey;
        final String r114 = this.$scene;
        ?? r115 = new c(r114, r108, r109);
        this.label = 2;
        r110 = r113.h(r109, r115, this);
        if (r110 != r100) goto L22;
        return r100;
    }
}
