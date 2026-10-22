package org.jetbrains.compose.resources.plural;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lorg/jetbrains/compose/resources/plural/PluralRuleList;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "org.jetbrains.compose.resources.plural.PluralRuleList$Companion$getInstance$3", f = "PluralRuleList.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PluralRuleList$Companion$getInstance$3 extends SuspendLambda implements Function1<Continuation<? super b>, Object> {
    final /* synthetic */ int $listIndex;
    int label;

    public PluralRuleList$Companion$getInstance$3(int r100, Continuation<? super PluralRuleList$Companion$getInstance$3> r101) {
        this.$listIndex = r100;
        super(1, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new PluralRuleList$Companion$getInstance$3(this.$listIndex, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super b> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super b> r100) {
        return ((PluralRuleList$Companion$getInstance$3) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        int r101 = b.f525867a;
        int r102 = this.$listIndex;
        Pair<PluralCategory, String>[] r103 = a.f525866b[r102];
        ArrayList r104 = new ArrayList(r103.length);
        int r105 = r103.length;
        int r106 = 0;
    L5:
        if (r106 >= r105) goto L8;
        Pair<PluralCategory, String> r107 = r103[r106];
        r104.add(new PluralRule(r107.getFirst(), r107.getSecond()));
        r106 = r106 + 1;
        goto L5
    L8:
        return new b((PluralRule[]) r104.toArray(new PluralRule[0]));
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
