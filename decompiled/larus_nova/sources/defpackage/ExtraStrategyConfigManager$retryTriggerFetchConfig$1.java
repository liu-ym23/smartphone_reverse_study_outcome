package defpackage;

import com.bytedance.ies.argus.bean.config.a;
import com.bytedance.ies.argus.repository.ArgusConfigType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "ExtraStrategyConfigManager$retryTriggerFetchConfig$1", f = "ExtraStrategyConfigManager.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
public final class ExtraStrategyConfigManager$retryTriggerFetchConfig$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isOffline;
    final /* synthetic */ int $retryCount;
    int label;
    final /* synthetic */ ExtraStrategyConfigManager this$0;

    public ExtraStrategyConfigManager$retryTriggerFetchConfig$1(ExtraStrategyConfigManager r100, boolean r101, int r102, Continuation<? super ExtraStrategyConfigManager$retryTriggerFetchConfig$1> r103) {
        this.this$0 = r100;
        this.$isOffline = r101;
        this.$retryCount = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ExtraStrategyConfigManager$retryTriggerFetchConfig$1(this.this$0, this.$isOffline, this.$retryCount, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ExtraStrategyConfigManager$retryTriggerFetchConfig$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        ExtraStrategyConfigManager r103 = this.this$0;
        boolean r104 = this.$isOffline;
        int r105 = this.$retryCount + 1;
        Map<ArgusConfigType, Class<? extends a>> r106 = ExtraStrategyConfigManager.f1182b;
        r103.b(r104, r105);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        this.label = 1;
        if (DelayKt.delay(10000, this) != r101) goto L11;
        return r101;
    }
}
