package com.bytedance.applet.impl;

import com.larus.multitask_management.api.data.quick_access.NodeType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.impl.AppletV2ServiceImpl$onAppletSystemSheetMenuItemClick$1$1$1", f = "AppletV2ServiceImpl.kt", i = {0, 1, 2, 3}, l = {257, 264, 277, 285}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "$this$launch", "$this$launch"}, s = {"L$0", "L$0", "L$0", "L$0"})
final class AppletV2ServiceImpl$onAppletSystemSheetMenuItemClick$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appletId;
    final /* synthetic */ boolean $isPin;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AppletV2ServiceImpl this$0;

    public AppletV2ServiceImpl$onAppletSystemSheetMenuItemClick$1$1$1(String r1, boolean r2, AppletV2ServiceImpl r3, Continuation<? super AppletV2ServiceImpl$onAppletSystemSheetMenuItemClick$1$1$1> r4) {
        this.$appletId = r1;
        this.$isPin = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        AppletV2ServiceImpl$onAppletSystemSheetMenuItemClick$1$1$1 r0 = new AppletV2ServiceImpl$onAppletSystemSheetMenuItemClick$1$1$1(this.$appletId, this.$isPin, this.this$0, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L13;
        if (r1 == 2) goto L12;
        if (r1 == 3) goto L11;
        if (r1 == 4) goto L12;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r12);
    L35:
        ll9.r r13 = (ll9.r) r12;
    L37:
        if (r13 == null) goto L43;
        Long r14 = r13.a;
        if (r14 == null) goto L43;
        AppletV2ServiceImpl r3 = this.this$0;
        r14.longValue();
        MainCoroutineDispatcher r15 = Dispatchers.getMain();
        AppletV2ServiceImpl$onAppletSystemSheetMenuItemClick$1$1$1$3$1 r4 = new AppletV2ServiceImpl$onAppletSystemSheetMenuItemClick$1$1$1$3$1(r3, null);
        this.L$0 = r2;
        this.label = 4;
        if (BuildersKt.withContext(r15, r4, this) != r0) goto L45;
        return r0;
    L45:
        return Unit.INSTANCE;
    L43:
        String r16 = this.$appletId;
        com.bytedance.ai.utils.g.a.e("AppletV2ServiceImpl", "unpin applet " + r16 + " failed");
    L12:
        CoroutineScope r5 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r12);
        goto L45
    L13:
        r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r12);
    L21:
        ll9.r r17 = (ll9.r) r12;
    L23:
        if (r17 == null) goto L29;
        Long r18 = r17.a;
        if (r18 == null) goto L29;
        AppletV2ServiceImpl r6 = this.this$0;
        r18.longValue();
        MainCoroutineDispatcher r19 = Dispatchers.getMain();
        AppletV2ServiceImpl$onAppletSystemSheetMenuItemClick$1$1$1$1$1 r7 = new AppletV2ServiceImpl$onAppletSystemSheetMenuItemClick$1$1$1$1$1(r6, null);
        this.L$0 = r2;
        this.label = 2;
        if (BuildersKt.withContext(r19, r7, this) != r0) goto L45;
        return r0;
    L29:
        String r110 = this.$appletId;
        com.bytedance.ai.utils.g.a.e("AppletV2ServiceImpl", "pin applet " + r110 + " failed");
        goto L45
    L14:
        ResultKt.throwOnFailure(r12);
        r2 = (CoroutineScope) this.L$0;
        com.bytedance.ai.utils.g.a.i("AppletV2ServiceImpl", "pin app " + this.$appletId + ", isPin: " + this.$isPin);
        if (this.$isPin == false) goto L30;
        il9.b r111 = (il9.b) ServiceManager.get().getService(il9.b.class);
        if (r111 == null) goto L22;
        ll9.o r8 = new ll9.o(NodeType.DOUBAO_APPS, this.$appletId, 4);
        this.L$0 = r2;
        this.label = 1;
        r12 = r111.V1(r8, this);
        if (r12 != r0) goto L21;
        return r0;
    L22:
        r17 = null;
        goto L23
    L30:
        il9.b r112 = (il9.b) ServiceManager.get().getService(il9.b.class);
        if (r112 == null) goto L36;
        ll9.a0 r9 = new ll9.a0(NodeType.DOUBAO_APPS, this.$appletId);
        this.L$0 = r2;
        this.label = 3;
        r12 = r112.h2(r9, this);
        if (r12 != r0) goto L35;
        return r0;
    L36:
        r13 = null;
        goto L37
    }
}
