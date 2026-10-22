package com.bytedance.applet.impl;

import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.social.userchat.model.LocalSubConvHelper;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.impl.AppletHostMessageServiceImpl$sendFollowUpMessage$1", f = "AppletHostMessageServiceImpl.kt", i = {3}, l = {105, 109, 112, 123}, m = "invokeSuspend", n = {"targetConversationId"}, s = {"L$0"})
public final class AppletHostMessageServiceImpl$sendFollowUpMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $extraData;
    final /* synthetic */ String $prompt;
    Object L$0;
    int label;
    final /* synthetic */ AppletHostMessageServiceImpl this$0;

    public AppletHostMessageServiceImpl$sendFollowUpMessage$1(String r1, String r2, String r3, AppletHostMessageServiceImpl r4, Continuation<? super AppletHostMessageServiceImpl$sendFollowUpMessage$1> r5) {
        this.$conversationId = r1;
        this.$prompt = r2;
        this.$extraData = r3;
        this.this$0 = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new AppletHostMessageServiceImpl$sendFollowUpMessage$1(this.$conversationId, this.$prompt, this.$extraData, this.this$0, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r28) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        Map r9 = null;
        if (r0 == 0) goto L14;
        if (r0 == 1) goto L13;
        if (r0 == 2) goto L12;
        if (r0 == 3) goto L11;
        if (r0 != 4) goto L10;
        String r1 = (String) this.L$0;
        ResultKt.throwOnFailure(r28);
        final String r13 = r1;
        Object r2 = r28;
    L47:
        final String r3 = (String) r2;
        if (r3 != null) goto L50;
        r3 = "";
    L50:
        com.larus.bmhome.chat.model.repo.u1 r11 = zh8.a.a.u1();
        String r12 = this.$prompt;
        String r4 = this.$extraData;
        if ((!StringsKt.isBlank(r4)) == true) goto L54;
        r4 = null;
    L54:
        if (r4 == null) goto L56;
        r9 = MapsKt.mapOf(TuplesKt.to("applet_follow_up_data", r4));
    L56:
        final AppletHostMessageServiceImpl r5 = this.this$0;
        com.larus.bmhome.chat.model.repo.u1.a.f(r11, r12, r13, "applet_follow_up", r9, new a0(r5, r13, r3), null, null, false, null, "applet#sendFollowUpMessage", null, null, null, false, 31688);
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r28);
        Object r6 = r28;
    L34:
        wc9.e r8 = (wc9.e) r6;
    L36:
        if (r8 != null) goto L39;
        FLogger.a.w("AppletHostMessageServiceImpl", "sendFollowUpMessage skip, conversation not found: " + this.$conversationId);
        return Unit.INSTANCE;
    L39:
        String r10 = r8.a;
        if (StringsKt.isBlank(r10) == false) goto L43;
        FLogger.a.w("AppletHostMessageServiceImpl", "sendFollowUpMessage skip, failed to get conversationId from conversation");
        return Unit.INSTANCE;
    L43:
        LocalSubConvHelper r14 = LocalSubConvHelper.a;
        this.L$0 = r10;
        this.label = 4;
        r2 = r14.f(r8, this);
        if (r2 != r7) goto L46;
        return r7;
    L46:
        r13 = r10;
        goto L47
    L12:
        ResultKt.throwOnFailure(r28);
        Object r15 = r28;
    L30:
        r8 = (wc9.e) r15;
        goto L36
    L13:
        ResultKt.throwOnFailure(r28);
        Object r16 = r28;
    L26:
        r8 = (wc9.e) r16;
        goto L36
    L14:
        ResultKt.throwOnFailure(r28);
        if (com.larus.platform.exp.o.a() == true) goto L17;
    L19:
        boolean r17 = false;
    L21:
        if (StringsKt.isBlank(this.$conversationId) == false) goto L31;
        if (r17 == false) goto L27;
        LocalSubConvHelper r18 = LocalSubConvHelper.a;
        String r19 = AccountService.a.getSecUserId();
        this.label = 1;
        r16 = r18.c(r19, null, this);
        if (r16 != r7) goto L26;
        return r7;
    L27:
        IConversationRepoService r20 = RepoDispatcherDelegate.b.f();
        this.label = 2;
        r15 = r20.f(this);
        if (r15 != r7) goto L30;
        return r7;
    L31:
        IConversationRepoService r21 = RepoDispatcherDelegate.b.f();
        String r22 = this.$conversationId;
        this.label = 3;
        r6 = IConversationRepoService.a.c(r21, r22, false, null, this, 6);
        if (r6 != r7) goto L34;
        return r7;
    L17:
        if (StringsKt.isBlank(this.$conversationId) == false) goto L19;
        r17 = true;
        goto L21
    }
}
