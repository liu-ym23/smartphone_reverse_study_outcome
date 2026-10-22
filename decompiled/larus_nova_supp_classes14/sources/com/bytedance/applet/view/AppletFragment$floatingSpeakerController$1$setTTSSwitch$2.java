package com.bytedance.applet.view;

import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.model.repo.UserSettingRepoDelegate;
import com.larus.bmhome.chat.model.repo.x1;
import com.larus.platform.service.z2;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.view.AppletFragment$floatingSpeakerController$1$setTTSSwitch$2", f = "AppletFragment.kt", i = {1}, l = {964, 966}, m = "invokeSuspend", n = {"conversationId"}, s = {"L$0"})
final class AppletFragment$floatingSpeakerController$1$setTTSSwitch$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ boolean $enable;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    final /* synthetic */ AppletFragment this$0;

    public AppletFragment$floatingSpeakerController$1$setTTSSwitch$2(String r1, boolean r2, AppletFragment r3, Continuation<? super AppletFragment$floatingSpeakerController$1$setTTSSwitch$2> r4) {
        this.$botId = r1;
        this.$enable = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AppletFragment$floatingSpeakerController$1$setTTSSwitch$2(this.$botId, this.$enable, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        boolean r2 = this.Z$0;
        AppletFragment r3 = (AppletFragment) this.L$1;
        String r4 = (String) this.L$0;
        ResultKt.throwOnFailure(r8);
        ?? r5 = r2;
    L22:
        ((Boolean) r8).booleanValue();
        if (r5 != 0) goto L28;
        x1 r9 = r3.l;
        if (r9 == null) goto L28;
        r9.i6("click_tts_icon", true);
    L28:
        if (z2.a.voiceGlobalSwitchEnable() == false) goto L30;
        UserSettingRepoDelegate.b.i(r5);
    L32:
        return Unit.INSTANCE;
    L30:
        UserSettingRepoDelegate.b.h(r4, r5);
        goto L32
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
    L13:
        wc9.e r10 = (wc9.e) r8;
        if (r10 == null) goto L16;
        String r11 = r10.a;
    L17:
        if (r11 == null) goto L32;
        boolean r6 = this.$enable;
        AppletFragment r7 = this.this$0;
        IChatRepoService r12 = zh8.a.a;
        IConversationRepoService r13 = zh8.a.b;
        this.L$0 = r11;
        this.L$1 = r7;
        this.Z$0 = r6;
        this.label = 2;
        Object r14 = r13.p(r11, r6, this);
        if (r14 != r0) goto L21;
        return r0;
    L21:
        r5 = r6;
        r3 = r7;
        r4 = r11;
        r8 = r14;
        goto L22
    L16:
        r11 = null;
        goto L17
    L10:
        ResultKt.throwOnFailure(r8);
        IConversationRepoService r15 = RepoDispatcherDelegate.b.f();
        String r16 = this.$botId;
        this.label = 1;
        r8 = r15.a(r16, this);
        if (r8 != r0) goto L13;
        return r0;
    }
}
