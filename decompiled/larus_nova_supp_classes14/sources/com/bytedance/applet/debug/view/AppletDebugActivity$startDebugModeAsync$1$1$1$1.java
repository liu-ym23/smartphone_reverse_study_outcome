package com.bytedance.applet.debug.view;

import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.applet.debug.AppletDebugManager;
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
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.debug.view.AppletDebugActivity$startDebugModeAsync$1$1$1$1", f = "AppletDebugActivity.kt", i = {}, l = {333}, m = "invokeSuspend", n = {}, s = {})
public final class AppletDebugActivity$startDebugModeAsync$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $debugInfo;
    final /* synthetic */ JSONObject $debugInfoObj;
    final /* synthetic */ boolean $isLegacy;
    final /* synthetic */ String $packageName;
    final /* synthetic */ String $versionTag;
    int label;
    final /* synthetic */ AppletDebugActivity this$0;

    public AppletDebugActivity$startDebugModeAsync$1$1$1$1(String r1, boolean r2, AppletDebugActivity r3, String r4, JSONObject r5, String r6, Continuation<? super AppletDebugActivity$startDebugModeAsync$1$1$1$1> r7) {
        this.$packageName = r1;
        this.$isLegacy = r2;
        this.this$0 = r3;
        this.$debugInfo = r4;
        this.$debugInfoObj = r5;
        this.$versionTag = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new AppletDebugActivity$startDebugModeAsync$1$1$1$1(this.$packageName, this.$isLegacy, this.this$0, this.$debugInfo, this.$debugInfoObj, this.$versionTag, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        AppletAppManagerService r6 = AppletAppManagerService.INSTANCE;
        String r2 = this.$packageName;
        Intrinsics.checkNotNull(r2);
        r6.getClass();
        AppletAppManagerService.f(r2);
        if (this.$isLegacy == false) goto L11;
        AppletDebugActivity r7 = this.this$0;
        int r3 = AppletDebugActivity.l;
        r7.R1(true);
        boolean r8 = AppletDebugManager.a;
        String r9 = this.$debugInfo;
        String r4 = this.$packageName;
        Intrinsics.checkNotNull(r4);
        AppletDebugManager.c(r9, r4);
        this.this$0.O1(this.$debugInfoObj);
        goto L15
    L11:
        AppletDebugActivity r10 = this.this$0;
        String r11 = this.$packageName;
        Intrinsics.checkNotNull(r11);
        String r12 = this.$versionTag;
        this.label = 1;
        if (AppletDebugActivity.N1(r10, r11, r12, this) != r0) goto L15;
        return r0;
    }
}
