package com.ss.android.lark.contact.customized.common.repository;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.lark.pb.contact.v2.GetContactsScene;
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
import mtb.d;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.contact.customized.common.repository.ContactOpenRepository$getContactList$1", f = "ContactOpenRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ContactOpenRepository$getContactList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGetDataCallback<List<d>> $callback;
    final /* synthetic */ GetContactsScene $pbScene;
    final /* synthetic */ boolean $preferLocal;
    int label;
    final /* synthetic */ a this$0;

    public ContactOpenRepository$getContactList$1(boolean r100, a r101, GetContactsScene r102, IGetDataCallback<List<d>> r103, Continuation<? super ContactOpenRepository$getContactList$1> r104) {
        this.$preferLocal = r100;
        this.this$0 = r101;
        this.$pbScene = r102;
        this.$callback = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ContactOpenRepository$getContactList$1(this.$preferLocal, this.this$0, this.$pbScene, this.$callback, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ContactOpenRepository$getContactList$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L62;
        ResultKt.throwOnFailure(r100);
        boolean r101 = true;
        if (this.$preferLocal == false) goto L32;
        Pair r102 = a.c(this.this$0, true, this.$pbScene);
        Collection r103 = (Collection) r102.getFirst();
        if (r103 != null) goto L9;
    L12:
        boolean r104 = true;
    L13:
        if (r104 == true) goto L16;
        this.$callback.onSuccess((List<d>) r102.getFirst());
        return Unit.INSTANCE;
    L16:
        ErrorResult r105 = (ErrorResult) r102.getSecond();
        if (r105 != null) goto L19;
        r105 = null;
    L19:
        Pair r106 = a.c(this.this$0, false, this.$pbScene);
        Collection r107 = (Collection) r106.getFirst();
        if (r107 != null) goto L22;
    L25:
        if (r101 == true) goto L28;
        this.$callback.onSuccess((List<d>) r106.getFirst());
        return Unit.INSTANCE;
    L28:
        ErrorResult r108 = (ErrorResult) r106.getSecond();
        if (r108 == null) goto L56;
    L31:
        r105 = r108;
    L56:
        IGetDataCallback<List<d>> r109 = this.$callback;
        if (r105 != null) goto L59;
        Exception r110 = new Exception(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        ErrorResult r111 = new ErrorResult(0);
        ErrorResult.access$002(r111, -1);
        ErrorResult.access$102(r111, -9999);
        ErrorResult.access$202(r111, 0);
        ErrorResult.access$302(r111, r110);
        ErrorResult.access$402(r111, "");
        ErrorResult.access$502(r111, "");
        ErrorResult.access$602(r111, "");
        ErrorResult.access$702(r111, "");
        ErrorResult.access$802(r111, 0);
        ErrorResult.access$902(r111, null);
        ErrorResult.access$1002(r111, null);
        ErrorResult.access$1102(r111, null);
        r105 = r111;
    L59:
        r109.onError(r105);
        return Unit.INSTANCE;
    L22:
        if (r107.isEmpty() == true) goto L25;
        r101 = false;
        goto L25
    L9:
        if (r103.isEmpty() == true) goto L12;
        r104 = false;
        goto L13
    L32:
        Pair r112 = a.c(this.this$0, false, this.$pbScene);
        Collection r113 = (Collection) r112.getFirst();
        if (r113 != null) goto L35;
    L38:
        boolean r114 = true;
    L39:
        if (r114 == true) goto L42;
        this.$callback.onSuccess((List<d>) r112.getFirst());
        return Unit.INSTANCE;
    L42:
        r105 = (ErrorResult) r112.getSecond();
        if (r105 != null) goto L45;
        r105 = null;
    L45:
        Pair r115 = a.c(this.this$0, true, this.$pbScene);
        Collection r116 = (Collection) r115.getFirst();
        if (r116 != null) goto L48;
    L51:
        if (r101 == true) goto L54;
        this.$callback.onSuccess((List<d>) r115.getFirst());
        return Unit.INSTANCE;
    L54:
        r108 = (ErrorResult) r115.getSecond();
        if (r108 != null) goto L31;
    L48:
        if (r116.isEmpty() == true) goto L51;
        r101 = false;
        goto L51
    L35:
        if (r113.isEmpty() == true) goto L38;
        r114 = false;
        goto L39
    L62:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
