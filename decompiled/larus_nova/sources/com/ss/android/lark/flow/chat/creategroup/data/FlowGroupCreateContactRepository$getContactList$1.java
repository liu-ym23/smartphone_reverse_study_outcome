package com.ss.android.lark.flow.chat.creategroup.data;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.creategroup.data.FlowGroupCreateContactRepository$getContactList$1", f = "FlowGroupCreateContactRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FlowGroupCreateContactRepository$getContactList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGetDataCallback<List<a>> $callback;
    final /* synthetic */ Long $chatId;
    final /* synthetic */ boolean $preferLocal;
    int label;

    public FlowGroupCreateContactRepository$getContactList$1(boolean r100, Long r101, IGetDataCallback<List<a>> r102, Continuation<? super FlowGroupCreateContactRepository$getContactList$1> r103) {
        this.$preferLocal = r100;
        this.$chatId = r101;
        this.$callback = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new FlowGroupCreateContactRepository$getContactList$1(this.$preferLocal, this.$chatId, this.$callback, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((FlowGroupCreateContactRepository$getContactList$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L63;
        ResultKt.throwOnFailure(r100);
        boolean r101 = true;
        if (this.$preferLocal == false) goto L31;
        int r102 = d.f422058a;
        Pair r103 = d.a(true, this.$chatId);
        Collection r104 = (Collection) r103.getFirst();
        if (r104 != null) goto L9;
    L12:
        boolean r105 = true;
    L13:
        if (r105 == true) goto L16;
        this.$callback.onSuccess((List<a>) r103.getFirst());
        return Unit.INSTANCE;
    L16:
        ErrorResult r106 = (ErrorResult) r103.getSecond();
        if (r106 != null) goto L19;
        r106 = null;
    L19:
        Pair r107 = d.a(false, this.$chatId);
        Collection r108 = (Collection) r107.getFirst();
        if (r108 != null) goto L22;
    L25:
        if (r101 == true) goto L28;
        this.$callback.onSuccess((List<a>) r107.getFirst());
        return Unit.INSTANCE;
    L28:
        ErrorResult r109 = (ErrorResult) r107.getSecond();
        if (r109 == null) goto L57;
    L56:
        r106 = r109;
    L57:
        IGetDataCallback<List<a>> r110 = this.$callback;
        if (r106 != null) goto L60;
        Exception r111 = new Exception(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        ErrorResult r112 = new ErrorResult(0);
        ErrorResult.access$002(r112, -1);
        ErrorResult.access$102(r112, -9999);
        ErrorResult.access$202(r112, 0);
        ErrorResult.access$302(r112, r111);
        ErrorResult.access$402(r112, "");
        ErrorResult.access$502(r112, "");
        ErrorResult.access$602(r112, "");
        ErrorResult.access$702(r112, "");
        ErrorResult.access$802(r112, 0);
        ErrorResult.access$902(r112, null);
        ErrorResult.access$1002(r112, null);
        ErrorResult.access$1102(r112, null);
        r106 = r112;
    L60:
        r110.onError(r106);
        return Unit.INSTANCE;
    L22:
        if (r108.isEmpty() == true) goto L25;
        r101 = false;
        goto L25
    L9:
        if (r104.isEmpty() == true) goto L12;
        r105 = false;
        goto L13
    L31:
        int r113 = d.f422058a;
        Pair r114 = d.a(false, this.$chatId);
        Collection r115 = (Collection) r114.getFirst();
        if (r115 != null) goto L34;
    L37:
        boolean r116 = true;
    L38:
        if (r116 == true) goto L41;
        this.$callback.onSuccess((List<a>) r114.getFirst());
        return Unit.INSTANCE;
    L41:
        r106 = (ErrorResult) r114.getSecond();
        if (r106 != null) goto L44;
        r106 = null;
    L44:
        Pair r117 = d.a(true, this.$chatId);
        Collection r118 = (Collection) r117.getFirst();
        if (r118 != null) goto L47;
    L50:
        if (r101 == true) goto L53;
        this.$callback.onSuccess((List<a>) r117.getFirst());
        return Unit.INSTANCE;
    L53:
        r109 = (ErrorResult) r117.getSecond();
        if (r109 != null) goto L56;
    L47:
        if (r118.isEmpty() == true) goto L50;
        r101 = false;
        goto L50
    L34:
        if (r115.isEmpty() == true) goto L37;
        r116 = false;
        goto L38
    L63:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
