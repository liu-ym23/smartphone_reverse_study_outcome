package com.bytedance.applet.impl;

import com.bytedance.ai.api.DebuggerMode;
import com.bytedance.ai.api.IAppletDebuggerService;
import com.larus.nova.NovaApplication;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.impl.AppletHostMessageServiceImpl$createLocalMsg$1", f = "AppletHostMessageServiceImpl.kt", i = {}, l = {405}, m = "invokeSuspend", n = {}, s = {})
public final class AppletHostMessageServiceImpl$createLocalMsg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $callback;
    final /* synthetic */ String $msgContent;
    int label;

    public AppletHostMessageServiceImpl$createLocalMsg$1(String r1, Function0<Unit> r2, Continuation<? super AppletHostMessageServiceImpl$createLocalMsg$1> r3) {
        this.$msgContent = r1;
        this.$callback = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AppletHostMessageServiceImpl$createLocalMsg$1(this.$msgContent, this.$callback, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L16:
        Boolean r11 = (Boolean) r10;
    L19:
        if (Intrinsics.areEqual(r11, Boxing.boxBoolean(true)) == true) goto L21;
        FLogger.a.e("AppletHostMessageServiceImpl", "createLocalMsg failed, debugger session not opened");
    L21:
        Function0<Unit> r12 = this.$callback;
        if (r12 == null) goto L25;
        r12.invoke();
    L25:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        gd9.i r13 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r13);
        NovaApplication r14 = r13.a().e();
        if (r14 != null) goto L11;
        gd9.i r15 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r15);
        r14 = r15.getApplication();
    L11:
        NovaApplication r4 = r14;
        IAppletDebuggerService r3 = (IAppletDebuggerService) ServiceManager.get().getService(IAppletDebuggerService.class);
        if (r3 == null) goto L17;
        DebuggerMode r6 = DebuggerMode.LOCAL_DEBUG;
        String r7 = this.$msgContent;
        this.label = 1;
        r10 = r3.d(r4, "debug", r6, r7, this);
        if (r10 != r0) goto L16;
        return r0;
    L17:
        r11 = null;
        goto L19
    }
}
