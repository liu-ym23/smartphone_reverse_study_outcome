package com.bytedance.applet.model.floating;

import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
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
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.model.floating.FloatingSpeakerConfigImplKt$onSpeak$4", f = "FloatingSpeakerConfigImpl.kt", i = {1, 1}, l = {376, 382, 392}, m = "invokeSuspend", n = {"conversation", "$this$invokeSuspend_u24lambda_u242_u24lambda_u241"}, s = {"L$0", "L$4"})
final class FloatingSpeakerConfigImplKt$onSpeak$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ y4.c $ability;
    final /* synthetic */ String $currentTaskId;
    final /* synthetic */ Message $msg;
    final /* synthetic */ long $startTimeStamp;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;

    public FloatingSpeakerConfigImplKt$onSpeak$4(y4.c r1, String r2, Message r3, long r4, Continuation<? super FloatingSpeakerConfigImplKt$onSpeak$4> r6) {
        this.$ability = r1;
        this.$currentTaskId = r2;
        this.$msg = r3;
        this.$startTimeStamp = r4;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new FloatingSpeakerConfigImplKt$onSpeak$4(this.$ability, this.$currentTaskId, this.$msg, this.$startTimeStamp, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        boolean r10 = true;
        if (r0 == 0) goto L12;
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L10;
        if (r0 != 3) goto L9;
        ResultKt.throwOnFailure(r21);
    L32:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        JSONObject r1 = (JSONObject) this.L$6;
        String r2 = (String) this.L$5;
        JSONObject r3 = (JSONObject) this.L$4;
        JSONObject r4 = (JSONObject) this.L$3;
        y4.c r5 = (y4.c) this.L$2;
        JSONObject r6 = (JSONObject) this.L$1;
        wc9.e r9 = (wc9.e) this.L$0;
        ResultKt.throwOnFailure(r21);
        wc9.e r11 = r9;
        JSONObject r12 = r6;
        Object r8 = r21;
    L26:
        r3.put("chat", ((JSONObject) r8).optJSONArray("chat_context"));
        JSONObject r13 = new JSONObject();
        r13.put("id", r5.b.invoke());
        Unit r14 = Unit.INSTANCE;
        r3.put("bot_info", r13);
        r1.put(r2, r4);
        JSONObject r16 = r12;
        wc9.e r15 = r11;
    L28:
        String r17 = this.$currentTaskId;
        y4.c r18 = this.$ability;
        Message r19 = this.$msg;
        long r20 = this.$startTimeStamp;
        MainCoroutineDispatcher r22 = Dispatchers.getMain();
        FloatingSpeakerConfigImplKt$onSpeak$4$2$1 r23 = new FloatingSpeakerConfigImplKt$onSpeak$4$2$1(r17, r15, r18, r19, r16, r20, null);
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.L$4 = null;
        this.L$5 = null;
        this.L$6 = null;
        this.label = 3;
        if (BuildersKt.withContext(r22, r23, this) != r7) goto L32;
        return r7;
    L11:
        ResultKt.throwOnFailure(r21);
        Object r24 = r21;
    L15:
        wc9.e r25 = (wc9.e) r24;
        String r26 = this.$currentTaskId;
        z r27 = FloatingSpeakerConfigImplKt.a;
        JSONObject r28 = new JSONObject();
        r28.put("uid", AccountService.a.getSecUserId());
        r28.put("did", com.larus.platform.service.o.a.getDeviceId());
        r28.put("app_version", String.valueOf(AppHost.a.getUpdateVersionCode()));
        ISettingRepoService r29 = zh8.a.c;
        r28.put("speech_language", r29.Q0());
        r28.put("asr_language", r29.S0());
        r28.put("model", r29.Z(r29.r0()));
        r28.put("local_message_id", r26);
        r28.put("os", "Android");
        r28.put("item_id", "");
        r28.put("dumpRate", r29.B() ? 1 : 0);
        r28.put("send_mq", r29.B());
        r5 = this.$ability;
        z2 r30 = z2.a;
        hq9.n r31 = r30.U0().a();
        if (r31 != null) goto L18;
    L20:
        r10 = false;
    L21:
        if (r10 == false) goto L27;
        r4 = new JSONObject();
        r4.put("version", FloatingSpeakerConfigImplKt.d);
        String r32 = (String) r5.a.invoke();
        r30.U0();
        this.L$0 = r25;
        this.L$1 = r28;
        this.L$2 = r5;
        this.L$3 = r4;
        this.L$4 = r4;
        r2 = "context";
        this.L$5 = "context";
        this.L$6 = r28;
        this.label = 2;
        r8 = FloatingSpeakerConfigImplKt.a(r32, this);
        if (r8 != r7) goto L25;
        return r7;
    L25:
        r11 = r25;
        r1 = r28;
        r12 = r1;
        r3 = r4;
        goto L26
    L27:
        r15 = r25;
        r16 = r28;
        goto L28
    L18:
        if (r31.b() != true) goto L20;
    L12:
        ResultKt.throwOnFailure(r21);
        String r33 = (String) this.$ability.a.invoke();
        this.label = 1;
        z r34 = FloatingSpeakerConfigImplKt.a;
        r24 = IConversationRepoService.a.c(zh8.a.b, r33, false, null, this, 6);
        if (r24 != r7) goto L15;
        return r7;
    }
}
