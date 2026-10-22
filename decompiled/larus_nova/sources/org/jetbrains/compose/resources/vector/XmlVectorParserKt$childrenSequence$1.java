package org.jetbrains.compose.resources.vector;

import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import cwc.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lorg/jetbrains/compose/resources/vector/xmldom/Node;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "org.jetbrains.compose.resources.vector.XmlVectorParserKt$childrenSequence$1", f = "XmlVectorParser.kt", i = {0, 0}, l = {273}, m = "invokeSuspend", n = {"$this$sequence", RXScreenCaptureService.KEY_INDEX}, s = {"L$0", "I$0"})
final class XmlVectorParserKt$childrenSequence$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ a $this_childrenSequence;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    int label;

    public XmlVectorParserKt$childrenSequence$1(a r100, Continuation<? super XmlVectorParserKt$childrenSequence$1> r101) {
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        XmlVectorParserKt$childrenSequence$1 r102 = new XmlVectorParserKt$childrenSequence$1(null, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(SequenceScope<Object> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(SequenceScope<Object> r100, Continuation<? super Unit> r101) {
        return ((XmlVectorParserKt$childrenSequence$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 != 0) goto L5;
        ResultKt.throwOnFailure(r100);
        SequenceScope r102 = (SequenceScope) this.L$0;
        throw null;
    L5:
        if (r101 != 1) goto L12;
        int r103 = this.I$1;
        int r104 = this.I$0;
        SequenceScope r105 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r100);
        if ((r104 + 1) >= r103) goto L9;
        throw null;
    L9:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
