package io.ktor.http.content;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.http.content.MultipartKt", f = "Multipart.kt", i = {0, 1, 1}, l = {138, 143}, m = "readAllParts", n = {"$this$readAllParts", "$this$readAllParts", "parts"}, s = {"L$0", "L$0", "L$1"})
final class MultipartKt$readAllParts$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public MultipartKt$readAllParts$1(Continuation<? super MultipartKt$readAllParts$1> r100) {
        super(r100);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0060 -> B:21:0x0064). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        int r101 = this.label | Integer.MIN_VALUE;
        this.label = r101;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r101 - Integer.MIN_VALUE;
        MultipartKt$readAllParts$1 r102 = this;
    L6:
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 != 0) goto L9;
        ResultKt.throwOnFailure(r103);
        r102.L$0 = null;
        r102.label = 1;
        throw null;
    L9:
        if (r105 == 1) goto L14;
        if (r105 != 2) goto L13;
        ArrayList r106 = (ArrayList) r102.L$1;
        a r107 = (a) r102.L$0;
        ResultKt.throwOnFailure(r103);
    L21:
        e r108 = (e) r103;
        if (r108 == null) goto L24;
        r106.add(r108);
    L18:
        r102.L$0 = r107;
        r102.L$1 = r106;
        r102.label = 2;
        r103 = r107.a();
        if (r103 != r104) goto L21;
        return r104;
    L24:
        return r106;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        a r109 = (a) r102.L$0;
        ResultKt.throwOnFailure(r103);
        e r110 = (e) r103;
        if (r110 == null) goto L28;
        ArrayList r111 = new ArrayList();
        r111.add(r110);
        r107 = r109;
        r106 = r111;
        goto L18
    L28:
        return CollectionsKt.emptyList();
    L5:
        r102 = new MultipartKt$readAllParts$1(this);
        goto L6
    }
}
