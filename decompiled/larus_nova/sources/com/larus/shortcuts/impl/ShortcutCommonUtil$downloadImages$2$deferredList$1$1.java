package com.larus.shortcuts.impl;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.shortcuts.impl.ShortcutCommonUtil$downloadImages$2$deferredList$1$1", f = "ShortcutCommonUtil.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
public final class ShortcutCommonUtil$downloadImages$2$deferredList$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ tw9.a $shortcutsInfo;
    Object L$0;
    int label;

    public ShortcutCommonUtil$downloadImages$2$deferredList$1$1(tw9.a r100, Continuation<? super ShortcutCommonUtil$downloadImages$2$deferredList$1$1> r101) {
        this.$shortcutsInfo = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ShortcutCommonUtil$downloadImages$2$deferredList$1$1(this.$shortcutsInfo, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ShortcutCommonUtil$downloadImages$2$deferredList$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        tw9.a r103 = (tw9.a) this.L$0;
        ResultKt.throwOnFailure(r100);
    L14:
        tw9.a r104 = r103;
        Bitmap r105 = (Bitmap) r100;
        tw9.a r106 = r104;
    L16:
        r106.f547801a = r105;
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        r106 = this.$shortcutsInfo;
        if (r106.a() == null) goto L15;
        int r107 = ShortcutCommonUtil.f369227a;
        String r108 = this.$shortcutsInfo.a();
        Intrinsics.checkNotNull(r108);
        this.L$0 = r106;
        this.label = 1;
        Object r109 = ShortcutCommonUtil.a(r108, this);
        if (r109 != r101) goto L13;
        return r101;
    L13:
        r103 = r106;
        r100 = r109;
        goto L14
    L15:
        r105 = null;
        goto L16
    }
}
