package com.larus.dora.impl.ota.g2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/dora/impl/ota/g2/OtaEngineState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.g2.G2OtaFacade$acquireLegacyInstall$2$granted$1", f = "G2OtaFacade.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class G2OtaFacade$acquireLegacyInstall$2$granted$1 extends SuspendLambda implements Function2<b5, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $requestId;
    /* synthetic */ Object L$0;
    int label;

    public G2OtaFacade$acquireLegacyInstall$2$granted$1(String r100, Continuation<? super G2OtaFacade$acquireLegacyInstall$2$granted$1> r101) {
        this.$requestId = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        G2OtaFacade$acquireLegacyInstall$2$granted$1 r102 = new G2OtaFacade$acquireLegacyInstall$2$granted$1(this.$requestId, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(b5 r100, Continuation<? super Boolean> r101) {
        return ((G2OtaFacade$acquireLegacyInstall$2$granted$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(b5 r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L27;
        ResultKt.throwOnFailure(r100);
        b5 r101 = (b5) this.L$0;
        t4 r102 = r101.h();
        if (r102 == null) goto L7;
        String r103 = r102.e();
    L8:
        boolean r104 = true;
        if (Intrinsics.areEqual(r103, this.$requestId) == true) goto L25;
        List<u4> r105 = r101.i();
        String r106 = this.$requestId;
        if ((r105 instanceof Collection) == true) goto L13;
    L15:
        Iterator<T> r107 = r105.iterator();
    L17:
        if (r107.hasNext() == false) goto L14;
        if (Intrinsics.areEqual(((u4) r107.next()).e(), r106) == false) goto L17;
        boolean r108 = false;
    L21:
        if (r108 == true) goto L25;
        r104 = false;
    L14:
        r108 = true;
        goto L21
    L13:
        if (r105.isEmpty() == false) goto L15;
    L25:
        return Boxing.boxBoolean(r104);
    L7:
        r103 = null;
        goto L8
    L27:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
