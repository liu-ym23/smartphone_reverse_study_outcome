package com.bytedance.applet.debug.view;

import com.bytedance.ai.debug.IAISDKDebugService;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.debug.view.AppletDebugVersionManagerActivity$submitChangedConfigs$2$1$1", f = "AppletDebugVersionManagerActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AppletDebugVersionManagerActivity$submitChangedConfigs$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ List<AppletDebugVersionAdapter.c> $changes;
    int label;

    public AppletDebugVersionManagerActivity$submitChangedConfigs$2$1$1(List<AppletDebugVersionAdapter.c> r1, Continuation<? super AppletDebugVersionManagerActivity$submitChangedConfigs$2$1$1> r2) {
        this.$changes = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AppletDebugVersionManagerActivity$submitChangedConfigs$2$1$1(this.$changes, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r7);
        List<AppletDebugVersionAdapter.c> r8 = this.$changes;
        Boolean r1 = Boxing.boxBoolean(false);
        Iterator<T> r9 = r8.iterator();
    L6:
        if (r9.hasNext() == false) goto L14;
        AppletDebugVersionAdapter.c r2 = (AppletDebugVersionAdapter.c) r9.next();
        boolean r3 = r1.booleanValue();
        com.bytedance.ai.utils.g.a.i("AppletDebugVersionManager", "setPreviewDebugConfig appKey=" + r2.a + ", enabled=" + r2.b + ", versionTag=" + r2.c);
        if (IAISDKDebugService.a.J(r2.a, r2.b, r2.c) == true) goto L12;
        if (r3 == true) goto L12;
        boolean r4 = false;
    L13:
        r1 = Boxing.boxBoolean(r4);
    L12:
        r4 = true;
        goto L13
    L14:
        return r1;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
