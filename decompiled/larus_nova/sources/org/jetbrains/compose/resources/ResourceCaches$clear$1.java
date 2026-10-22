package org.jetbrains.compose.resources;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "org.jetbrains.compose.resources.ResourceCaches", f = "ResourceCaches.kt", i = {}, l = {50}, m = "clear$library_release", n = {}, s = {})
final class ResourceCaches$clear$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ o this$0;

    public ResourceCaches$clear$1(o r100, Continuation<? super ResourceCaches$clear$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        o r101 = this.this$0;
        r101.getClass();
        int r102 = this.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r102 - Integer.MIN_VALUE;
        ResourceCaches$clear$1 r103 = this;
    L6:
        Object r104 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L12;
        if (r106 != 1) goto L11;
        Iterator r107 = (Iterator) r103.L$0;
        ResultKt.throwOnFailure(r104);
    L14:
        if (r107.hasNext() == false) goto L19;
        AsyncCache r108 = (AsyncCache) r107.next();
        r103.L$0 = r107;
        r103.label = 1;
        if (r108.a(r103) != r105) goto L14;
        return r105;
    L19:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r104);
        r107 = ((ArrayList) o.f525845a).iterator();
        goto L14
    L5:
        r103 = new ResourceCaches$clear$1(r101, this);
        goto L6
    }
}
