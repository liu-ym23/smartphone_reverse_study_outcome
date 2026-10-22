package com.bytedance.applet.aibridge.menu;

import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.aibridge.menu.UpdateMenuMethod$handle$1$2$2", f = "UpdateMenuMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class UpdateMenuMethod$handle$1$2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ f3.h<AbsUpdateMenuMethodIDL.b> $callback;
    final /* synthetic */ List<WidgetMenuItem> $it;
    final /* synthetic */ AbsUpdateMenuMethodIDL.a $params;
    int label;

    public UpdateMenuMethod$handle$1$2$2(AbsUpdateMenuMethodIDL.a r1, List<WidgetMenuItem> r2, f3.h<AbsUpdateMenuMethodIDL.b> r3, Continuation<? super UpdateMenuMethod$handle$1$2$2> r4) {
        this.$params = r1;
        this.$it = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new UpdateMenuMethod$handle$1$2$2(this.$params, this.$it, this.$callback, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L22;
        ResultKt.throwOnFailure(r8);
        cf8.c r9 = ILegacyChatUiServiceDelegate.b.H8();
        boolean r0 = false;
        if (r9 == null) goto L16;
        String r1 = this.$params.getMenuId();
        List<WidgetMenuItem> r2 = this.$it;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r4 = r2.iterator();
        int r5 = 0;
    L8:
        if (r4.hasNext() == false) goto L14;
        Object r6 = r4.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        r3.add(a.b((WidgetMenuItem) r6));
        r5 = r7;
        goto L8
    L14:
        if (r9.b(r1, r3) != true) goto L16;
        r0 = true;
    L16:
        if (r0 == false) goto L18;
        f3.h<AbsUpdateMenuMethodIDL.b> r10 = this.$callback;
        Intrinsics.checkNotNullParameter(AbsUpdateMenuMethodIDL.b.class, "<this>");
        f3.h.a.b(r10, k3.c.a(AbsUpdateMenuMethodIDL.b.class));
    L20:
        return Unit.INSTANCE;
    L18:
        f3.h.a.a(this.$callback, "menuId.isNullOrEmpty() or menuId != currentMenuId", null, null, 14);
        goto L20
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
