package com.bytedance.applet.aibridge.menu;

import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.aibridge.menu.DismissMenuMethod$handle$1$1", f = "DimissMenuMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DismissMenuMethod$handle$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ f3.h<AbsDismissMenuMethodIDL.b> $callback;
    final /* synthetic */ AbsDismissMenuMethodIDL.a $params;
    int label;

    public DismissMenuMethod$handle$1$1(AbsDismissMenuMethodIDL.a r1, f3.h<AbsDismissMenuMethodIDL.b> r2, Continuation<? super DismissMenuMethod$handle$1$1> r3) {
        this.$params = r1;
        this.$callback = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DismissMenuMethod$handle$1$1(this.$params, this.$callback, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r4);
        cf8.c r5 = ILegacyChatUiServiceDelegate.b.H8();
        if (r5 == null) goto L9;
        boolean r0 = true;
        if (r5.e(this.$params.getMenuId()) != true) goto L9;
    L10:
        if (r0 == false) goto L12;
        f3.h<AbsDismissMenuMethodIDL.b> r6 = this.$callback;
        Intrinsics.checkNotNullParameter(AbsDismissMenuMethodIDL.b.class, "<this>");
        f3.h.a.b(r6, k3.c.a(AbsDismissMenuMethodIDL.b.class));
    L14:
        return Unit.INSTANCE;
    L12:
        f3.h.a.a(this.$callback, "menuId.isNullOrEmpty() or menuId != currentMenuId", null, null, 14);
    L9:
        r0 = false;
        goto L10
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
