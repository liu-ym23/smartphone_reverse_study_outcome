package kotlinx.serialization.json.internal;

import kotlin.DeepRecursiveScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlinx/serialization/json/JsonElement;", "Lkotlin/DeepRecursiveScope;", "", "it"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.serialization.json.internal.JsonTreeReader$readDeepRecursive$1", f = "JsonTreeReader.kt", i = {}, l = {115}, m = "invokeSuspend", n = {}, s = {})
final class JsonTreeReader$readDeepRecursive$1 extends RestrictedSuspendLambda implements Function3<DeepRecursiveScope<Unit, ouc.i>, Unit, Continuation<? super ouc.i>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ g0 this$0;

    public JsonTreeReader$readDeepRecursive$1(g0 r100, Continuation<? super JsonTreeReader$readDeepRecursive$1> r101) {
        this.this$0 = r100;
        super(3, r101);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(DeepRecursiveScope<Unit, ouc.i> r100, Unit r101, Continuation<? super ouc.i> r102) {
        return invoke2(r100, r101, r102);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(DeepRecursiveScope<Unit, ouc.i> r100, Unit r101, Continuation<? super ouc.i> r102) {
        JsonTreeReader$readDeepRecursive$1 r103 = new JsonTreeReader$readDeepRecursive$1(this.this$0, r102);
        r103.L$0 = r100;
        return r103.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L28:
        return (ouc.i) r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        DeepRecursiveScope r103 = (DeepRecursiveScope) this.L$0;
        byte r104 = this.this$0.f505410a.r();
        if (r104 != 1) goto L12;
        return this.this$0.d(true);
    L12:
        if (r104 != 0) goto L15;
        return this.this$0.d(false);
    L15:
        if (r104 != 6) goto L21;
        g0 r105 = this.this$0;
        this.label = 1;
        r100 = g0.a(r105, r103, this);
        if (r100 != r101) goto L28;
        return r101;
    L21:
        if (r104 == 8) goto L23;
        a.m(this.this$0.f505410a, "Can't begin reading element, unexpected token", 0, null, 6);
        throw null;
    L23:
        return this.this$0.c();
    }
}
