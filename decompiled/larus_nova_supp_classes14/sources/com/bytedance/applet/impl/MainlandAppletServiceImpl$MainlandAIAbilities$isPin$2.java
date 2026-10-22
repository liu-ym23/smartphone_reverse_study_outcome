package com.bytedance.applet.impl;

import com.larus.multitask_management.api.data.quick_access.NodeType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.impl.MainlandAppletServiceImpl$MainlandAIAbilities$isPin$2", f = "MainlandAppletServiceImpl.kt", i = {}, l = {745}, m = "invokeSuspend", n = {}, s = {})
public final class MainlandAppletServiceImpl$MainlandAIAbilities$isPin$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $appletId;
    int label;

    public MainlandAppletServiceImpl$MainlandAIAbilities$isPin$2(String r1, Continuation<? super MainlandAppletServiceImpl$MainlandAIAbilities$isPin$2> r2) {
        this.$appletId = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MainlandAppletServiceImpl$MainlandAIAbilities$isPin$2(this.$appletId, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = false;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L13:
        ll9.r r8 = (ll9.r) r7;
        if (r8 == null) goto L25;
        List r9 = r8.e;
        if (r9 == null) goto L25;
        ll9.m r10 = (ll9.m) CollectionsKt.firstOrNull(r9);
        if (r10 == null) goto L25;
        String r3 = this.$appletId;
        if (Intrinsics.areEqual(r10.b, r3) == false) goto L22;
        Boolean r11 = r10.c;
    L23:
        r2 = Intrinsics.areEqual(r11, Boxing.boxBoolean(true));
        goto L25
    L22:
        r11 = Boxing.boxBoolean(false);
    L25:
        return Boxing.boxBoolean(r2);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        ll9.g r12 = new ll9.g(CollectionsKt.listOf(new ll9.k(NodeType.DOUBAO_APPS, this.$appletId)));
        il9.b r4 = (il9.b) ServiceManager.get().getService(il9.b.class);
        if (r4 == null) goto L25;
        this.label = 1;
        r7 = r4.H0(r12, this);
        if (r7 != r0) goto L13;
        return r0;
    }
}
