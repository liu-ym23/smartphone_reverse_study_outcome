package io.ktor.http.content;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.http.content.MultipartKt", f = "Multipart.kt", i = {0, 0, 1, 1}, l = {128, 129}, m = "forEachPart", n = {"$this$forEachPart", "partHandler", "$this$forEachPart", "partHandler"}, s = {"L$0", "L$1", "L$0", "L$1"})
final class MultipartKt$forEachPart$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public MultipartKt$forEachPart$1(Continuation<? super MultipartKt$forEachPart$1> r100) {
        super(r100);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0075 -> B:11:0x0032). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        int r101 = this.label | Integer.MIN_VALUE;
        this.label = r101;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r101 - Integer.MIN_VALUE;
        MultipartKt$forEachPart$1 r102 = this;
    L6:
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L15;
        if (r105 == 1) goto L14;
        if (r105 != 2) goto L13;
        Function2 r106 = (Function2) r102.L$1;
        a r107 = (a) r102.L$0;
        ResultKt.throwOnFailure(r103);
    L11:
        a r108 = r107;
        Function2 r109 = r106;
        Object r110 = r104;
        Function2 r111 = r109;
    L16:
        r102.L$0 = r108;
        r102.L$1 = r111;
        r102.label = 1;
        Object r112 = r108.a();
        if (r112 == r110) goto L28;
        r107 = r108;
        r103 = r112;
        Object r113 = r110;
        r106 = r111;
        r104 = r113;
    L20:
        e r114 = (e) r103;
        if (r114 == null) goto L27;
        r102.L$0 = r107;
        r102.L$1 = r106;
        r102.label = 2;
        if (r106.invoke(r114, r102) != r104) goto L11;
        return r104;
    L27:
        return Unit.INSTANCE;
    L28:
        return r110;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        r106 = (Function2) r102.L$1;
        r107 = (a) r102.L$0;
        ResultKt.throwOnFailure(r103);
        goto L20
    L15:
        ResultKt.throwOnFailure(r103);
        r108 = null;
        r110 = r104;
        r111 = null;
        goto L16
    L5:
        r102 = new MultipartKt$forEachPart$1(this);
        goto L6
    }
}
