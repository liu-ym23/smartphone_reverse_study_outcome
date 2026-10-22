package com.bytedance.applet.impl;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.nova.NovaApplication;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.ActivityManagerLancet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.impl.AppletHostMessageServiceImpl$sendFollowUpMessage$1$3$1", f = "AppletHostMessageServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AppletHostMessageServiceImpl$sendFollowUpMessage$1$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $targetBotId;
    final /* synthetic */ String $targetConversationId;
    int label;
    final /* synthetic */ AppletHostMessageServiceImpl this$0;

    public AppletHostMessageServiceImpl$sendFollowUpMessage$1$3$1(AppletHostMessageServiceImpl r1, String r2, String r3, Continuation<? super AppletHostMessageServiceImpl$sendFollowUpMessage$1$3$1> r4) {
        this.this$0 = r1;
        this.$targetConversationId = r2;
        this.$targetBotId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AppletHostMessageServiceImpl$sendFollowUpMessage$1$3$1(this.this$0, this.$targetConversationId, this.$targetBotId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L96;
        ResultKt.throwOnFailure(r11);
        gd9.i r12 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r12);
        Activity r13 = r12.a().e();
        AppletHostMessageServiceImpl r0 = this.this$0;
        int r1 = AppletHostMessageServiceImpl.a;
        r0.getClass();
        String r2 = com.larus.platform.service.w0.b();
        gd9.i r3 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r3);
        Iterator r4 = CollectionsKt.asReversed(r3.a().d()).iterator();
    L5:
        boolean r5 = true;
        String r6 = null;
        if (r4.hasNext() == false) goto L17;
        Object r7 = r4.next();
        Activity r8 = (Activity) r7;
        if (r8.isFinishing() == false) goto L10;
    L14:
        boolean r9 = false;
    L15:
        if (r9 == false) goto L5;
    L18:
        Activity r10 = (Activity) r7;
        String r14 = "//flow/chat?conversation_id=" + this.$targetConversationId + "&bot_id=" + this.$targetBotId;
        this.this$0.getClass();
        if (r10 == null) goto L43;
        if (r13 != null) goto L22;
    L24:
        boolean r15 = false;
    L25:
        if (r15 == true) goto L43;
        AppletHostMessageServiceImpl r16 = this.this$0;
        int r17 = r10.getTaskId();
        r16.getClass();
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L38
        gd9.i r19 = com.larus.im.b.a;     // Catch: Throwable -> L38
        Intrinsics.checkNotNull(r19);     // Catch: Throwable -> L38
        Object r110 = r19.getApplication().getSystemService("activity");     // Catch: Throwable -> L38
        if ((r110 instanceof ActivityManager) == false) goto L30;
        ActivityManager r111 = (ActivityManager) r110;     // Catch: Throwable -> L38
    L31:
        if (r111 != null) goto L33;
        FLogger.a.w("AppletHostMessageServiceImpl", "moveTaskToFront skipped, activityManager is null");     // Catch: Throwable -> L38
        goto L43
    L33:
        if (r17 == 0) goto L35;
        r111.moveTaskToFront(r17, 0);     // Catch: Throwable -> L38
    L36:
        Object r112 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L38
    L40:
        Throwable r113 = Result.exceptionOrNull-impl(r112);
        if (r113 == null) goto L43;
        FLogger.a.e("AppletHostMessageServiceImpl", "moveTaskToFront failed, taskId=" + r17 + ", error=" + r113);
        goto L43
    L35:
        ActivityManagerLancet.handleFakeMoveTaskToFront(0);     // Catch: Throwable -> L38
        goto L36
    L30:
        r111 = null;
    L38:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r112 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L40
    L22:
        if (r13.getTaskId() != r10.getTaskId()) goto L24;
        r15 = true;
    L43:
        gd9.i r114 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r114);
        List r115 = r114.a().d();
        ListIterator r116 = r115.listIterator(r115.size());
    L45:
        if (r116.hasPrevious() == false) goto L54;
        Object r21 = r116.previous();
        Activity r22 = (Activity) r21;
        if (r10 != null) goto L49;
    L51:
        boolean r23 = false;
    L52:
        if (r23 == false) goto L45;
    L55:
        Activity r24 = (Activity) r21;
        Fragment r117 = com.larus.platform.service.w0.a(r24);
        if (r117 != null) goto L59;
        r117 = com.larus.platform.service.w0.a(r10);
    L59:
        if ((r117 instanceof xe8.a) == false) goto L61;
        xe8.a r118 = (xe8.a) r117;
    L62:
        if (r118 == null) goto L65;
        r6 = r118.getConversationId();
    L65:
        if (Intrinsics.areEqual(r6, this.$targetConversationId) == false) goto L70;
        u7 r25 = r118.WF().getAbility(u7.class);
        if (r25 == null) goto L69;
        r25.O5(true);
    L94:
        return Unit.INSTANCE;
    L69:
        r118.m8();
        goto L94
    L70:
        this.this$0.getClass();
        if (r10 != null) goto L89;
        this.this$0.getClass();
        gd9.i r119 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r119);
        NovaApplication r120 = r119.getApplication();
        String r26 = com.larus.platform.service.w0.b();
        if (r26.length() == 0) goto L76;
        r5 = false;
    L76:
        if (r5 == false) goto L78;
        FLogger.a.w("AppletHostMessageServiceImpl", "openChatAfterMainActivityReady skipped, mainActivityClassName is empty");
        goto L94
    L78:
        Ref.ObjectRef r27 = new Ref.ObjectRef();
        r27.element = r14;
        Ref.ObjectRef r28 = new Ref.ObjectRef();
        z r29 = new z(r26, r27, r28, r120);
        r28.element = r29;
        r120.registerActivityLifecycleCallbacks(r29);
        Intent r30 = SmartRouter.buildRoute(r120, "//main_page").b();
        if (r30 != null) goto L81;
        AppletHostMessageServiceImpl.n(r28, r27, r120);
        FLogger.a.w("AppletHostMessageServiceImpl", "openChatAfterMainActivityReady skipped, mainIntent is null");
        goto L94
    L81:
        r30.addFlags(872415232);
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L84
        r120.startActivity(r30);     // Catch: Throwable -> L84
        Object r32 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L84
    L86:
        Throwable r33 = Result.exceptionOrNull-impl(r32);
        if (r33 == null) goto L94;
        AppletHostMessageServiceImpl.n(r28, r27, r120);
        FLogger.a.e("AppletHostMessageServiceImpl", "openChatAfterMainActivityReady startActivity failed", r33);
    L84:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        r32 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L86
    L89:
        if (r24 == null) goto L92;
        r10 = r24;
    L92:
        SmartRouter.buildRoute(r10, r14).d();
        goto L94
    L61:
        r118 = null;
        goto L62
    L49:
        if (r22.getTaskId() != r10.getTaskId()) goto L51;
        r23 = true;
        goto L52
    L54:
        r21 = null;
        goto L55
    L10:
        if (r8.isDestroyed() == true) goto L14;
        if (Intrinsics.areEqual(r8.getClass().getName(), r2) == false) goto L14;
        r9 = true;
        goto L15
    L17:
        r7 = null;
        goto L18
    L96:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
