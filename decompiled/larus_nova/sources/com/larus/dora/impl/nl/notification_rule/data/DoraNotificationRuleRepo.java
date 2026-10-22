package com.larus.dora.impl.nl.notification_rule.data;

import com.larus.dora.api.entity.NotificationRule;
import com.larus.dora.impl.network.DoraNetworkApi;
import com.larus.dora.impl.util.b0;
import com.larus.platform.service.AccountService;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: classes27.dex */
public final class DoraNotificationRuleRepo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DoraNotificationRuleRepo f336288a = null;

    static {
        f336288a = new DoraNotificationRuleRepo();
    }

    public DoraNotificationRuleRepo() {
    }

    public final Object e(Continuation<? super Result<? extends List<NotificationRule>>> r100) {
        if ((r100 instanceof DoraNotificationRuleRepo$loadRules$1) == false) goto L7;
        DoraNotificationRuleRepo$loadRules$1 r101 = (DoraNotificationRuleRepo$loadRules$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L16;
        if (r105 != 1) goto L15;
        String r106 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L31
        Object r107 = ((Result) r103).m9458unboximpl();     // Catch: Exception -> L31
    L22:
        if (Result.m9456isSuccessimpl(r107) == false) goto L27;
        List r108 = CollectionsKt.emptyList();     // Catch: Exception -> L31
        if (Result.m9455isFailureimpl(r107) == false) goto L26;
        r107 = r108;
    L26:
        List r109 = (List) r107;     // Catch: Exception -> L31
        b0.f338123a.getClass();     // Catch: Exception -> L31
        b0.G(r106, r109);     // Catch: Exception -> L31
        return Result.m9449constructorimpl(r109);
    L27:
        b0.f338123a.getClass();     // Catch: Exception -> L31
        List r110 = b0.m(r106);     // Catch: Exception -> L31
        if ((!r110.isEmpty()) == true) goto L37;
        return r107;
    L37:
        return Result.m9449constructorimpl(r110);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r103);
        String r111 = AccountService.f365697a.getUserId();
        DoraNetworkApi r112 = DoraNetworkApi.f336157a;     // Catch: Exception -> L31
        r101.L$0 = r111;     // Catch: Exception -> L31
        r101.label = 1;     // Catch: Exception -> L31
        Object r113 = r112.s(null, r101);     // Catch: Exception -> L31
        if (r113 != r104) goto L20;
        return r104;
    L20:
        r106 = r111;
        r107 = r113;
    L31:
        e = move-exception;
        Result.Companion r114 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(e));
    L7:
        r101 = new DoraNotificationRuleRepo$loadRules$1(this, r100);
        goto L8
    }

    public final Object a(List<String> r100, Continuation<? super Result<Boolean>> r101) {
        if ((r101 instanceof DoraNotificationRuleRepo$batchDeleteRules$1) == false) goto L7;
        DoraNotificationRuleRepo$batchDeleteRules$1 r102 = (DoraNotificationRuleRepo$batchDeleteRules$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L17;
        if (r106 != 1) goto L16;
        ResultKt.throwOnFailure(r104);     // Catch: Exception -> L13
        Object r107 = ((Result) r104).m9458unboximpl();     // Catch: Exception -> L13
    L22:
        if (Result.m9456isSuccessimpl(r107) == false) goto L35;
        Object r108 = Boxing.boxBoolean(false);     // Catch: Exception -> L13
        if (Result.m9455isFailureimpl(r107) == true) goto L28;
        r108 = r107;
    L28:
        if (((Boolean) r108).booleanValue() == false) goto L36;
        return Result.m9449constructorimpl(Boxing.boxBoolean(true));
    L36:
        return r107;
    L35:
        return r107;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r104);
        DoraNetworkApi r109 = DoraNetworkApi.f336157a;     // Catch: Exception -> L13
        r102.label = 1;     // Catch: Exception -> L13
        r107 = r109.d(r100, r102);     // Catch: Exception -> L13
        if (r107 != r105) goto L22;
        return r105;
    L13:
        e = move-exception;
        Result.Companion r110 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(e));
    L7:
        r102 = new DoraNotificationRuleRepo$batchDeleteRules$1(this, r101);
        goto L8
    }

    public final Object b(String r100, Continuation<? super Result<? extends List<String>>> r101) {
        if ((r101 instanceof DoraNotificationRuleRepo$clarifyRule$1) == false) goto L7;
        DoraNotificationRuleRepo$clarifyRule$1 r102 = (DoraNotificationRuleRepo$clarifyRule$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
        return ((Result) r104).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        DoraNetworkApi r107 = DoraNetworkApi.f336157a;
        r102.label = 1;
        Object r108 = r107.h(r100, r102);
        if (r108 != r105) goto L18;
        return r105;
    L18:
        return r108;
    L7:
        r102 = new DoraNotificationRuleRepo$clarifyRule$1(this, r101);
        goto L8
    }

    public final Object c(List<String> r100, Continuation<? super Result<Boolean>> r101) {
        if ((r101 instanceof DoraNotificationRuleRepo$createRules$1) == false) goto L7;
        DoraNotificationRuleRepo$createRules$1 r102 = (DoraNotificationRuleRepo$createRules$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L17;
        if (r106 != 1) goto L16;
        ResultKt.throwOnFailure(r104);     // Catch: Exception -> L13
        Object r107 = ((Result) r104).m9458unboximpl();     // Catch: Exception -> L13
    L22:
        if (Result.m9456isSuccessimpl(r107) == true) goto L32;
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Exception -> L13
        if (r108 != null) goto L33;
        r108 = new RuntimeException("Create rules failed");     // Catch: Exception -> L13
    L33:
        return Result.m9449constructorimpl(ResultKt.createFailure(r108));
    L32:
        return Result.m9449constructorimpl(Boxing.boxBoolean(true));
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r104);
        DoraNetworkApi r109 = DoraNetworkApi.f336157a;     // Catch: Exception -> L13
        r102.label = 1;     // Catch: Exception -> L13
        r107 = r109.i(r100, r102);     // Catch: Exception -> L13
        if (r107 != r105) goto L22;
        return r105;
    L13:
        e = move-exception;
        Result.Companion r110 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(e));
    L7:
        r102 = new DoraNotificationRuleRepo$createRules$1(this, r101);
        goto L8
    }

    public final Object d(String r100, Continuation<? super Result<Boolean>> r101) {
        if ((r101 instanceof DoraNotificationRuleRepo$deleteRule$1) == false) goto L7;
        DoraNotificationRuleRepo$deleteRule$1 r102 = (DoraNotificationRuleRepo$deleteRule$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
        return ((Result) r104).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        List<String> r107 = CollectionsKt.listOf(r100);
        r102.label = 1;
        Object r108 = a(r107, r102);
        if (r108 != r105) goto L18;
        return r105;
    L18:
        return r108;
    L7:
        r102 = new DoraNotificationRuleRepo$deleteRule$1(this, r101);
        goto L8
    }

    public final Object f(String r100, boolean r101, String r102, Continuation<? super Result<Boolean>> r103) {
        if ((r103 instanceof DoraNotificationRuleRepo$updateRuleStatus$1) == false) goto L7;
        DoraNotificationRuleRepo$updateRuleStatus$1 r104 = (DoraNotificationRuleRepo$updateRuleStatus$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L17;
        if (r108 != 1) goto L16;
        ResultKt.throwOnFailure(r106);     // Catch: Exception -> L13
        Object r109 = ((Result) r106).m9458unboximpl();     // Catch: Exception -> L13
    L26:
        if (Result.m9456isSuccessimpl(r109) == false) goto L39;
        Object r110 = Boxing.boxBoolean(false);     // Catch: Exception -> L13
        if (Result.m9455isFailureimpl(r109) == true) goto L32;
        r110 = r109;
    L32:
        if (((Boolean) r110).booleanValue() == false) goto L40;
        return Result.m9449constructorimpl(Boxing.boxBoolean(true));
    L40:
        return r109;
    L39:
        return r109;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r106);
        AccountService.f365697a.getUserId();
        DoraNetworkApi r111 = DoraNetworkApi.f336157a;     // Catch: Exception -> L13
        if (r101 == false) goto L21;
        boolean r112 = true;
    L22:
        r104.label = 1;     // Catch: Exception -> L13
        r109 = r111.G(r100, r112, r102, r104);     // Catch: Exception -> L13
        if (r109 != r107) goto L26;
        return r107;
    L21:
        r112 = false;
    L13:
        e = move-exception;
        Result.Companion r113 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(e));
    L7:
        r104 = new DoraNotificationRuleRepo$updateRuleStatus$1(this, r103);
        goto L8
    }
}
