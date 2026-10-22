package com.larus.feishu.office.im.impl.smart_reply;

import com.bytedance.ee.bear.bitable.homepage.activity.NoticeInfo;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.feishu.office.im.impl.smart_reply.SmartReplyFloatChatController$bindQuickReplyListener$1$2", f = "SmartReplyFloatChatController.kt", i = {1}, l = {257, 258}, m = "invokeSuspend", n = {"message"}, s = {"L$0"})
final class SmartReplyFloatChatController$bindQuickReplyListener$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ u this$0;

    public static final class a implements aya.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Message f343304a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ u f343305b;

        @Override // aya.e
        public final void onSuccess(String r100) {
            Intrinsics.checkNotNullParameter(r100, "messageId");
            SmartReplyFloatChatController$bindQuickReplyListener$1$2.access$invokeSuspend$lambda$1$mobSendResult(this.f343304a, this.f343305b, true, null, null);
        }

        public a(Message r100, u r101) {
            this.f343304a = r100;
            this.f343305b = r101;
        }

        @Override // aya.e
        public final void a(Integer r100, String r101) {
            SmartReplyFloatChatController$bindQuickReplyListener$1$2.access$invokeSuspend$lambda$1$mobSendResult(this.f343304a, this.f343305b, false, r100, r101);
        }
    }

    public SmartReplyFloatChatController$bindQuickReplyListener$1$2(u r100, Continuation<? super SmartReplyFloatChatController$bindQuickReplyListener$1$2> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new SmartReplyFloatChatController$bindQuickReplyListener$1$2(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((SmartReplyFloatChatController$bindQuickReplyListener$1$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L9;
        if (r102 != 2) goto L8;
        Message r103 = (Message) this.L$0;
        ResultKt.throwOnFailure(r100);
    L17:
        Message r104 = (Message) r100;
        if (r104 == null) goto L44;
        int r105 = FlowSmartReplyAIContainerView.f343262n;
        String r106 = FlowSmartReplyAIContainerView.a.b(r104);
        u r107 = this.this$0;
        a r108 = new a(r103, r107);
        aya.a r109 = r107.f343409h.invoke();
        if (r109 == null) goto L22;
        r109.d(r106, r108);
    L22:
        va8.g0 r110 = r107.f343413l;
        if (r110 == null) goto L25;
        r110.km("SUGGEST_REPLY_SEND_TO_CHAT");
    L25:
        String r111 = null;
        if (r103 == null) goto L28;
        String r112 = com.larus.feishu.office.im.impl.smart_reply.a.a(r103);
    L29:
        if (r103 == null) goto L31;
        String r113 = r103.getMessageId();
    L32:
        aya.b r114 = r107.f343408g.invoke();
        if (r114 == null) goto L36;
        String r115 = Boxing.boxLong(r114.f16773b).toString();
        if (r115 == null) goto L36;
    L39:
        aya.b r116 = r107.f343408g.invoke();
        if (r116 == null) goto L42;
        r111 = r116.f16774c;
    L42:
        y99.a.c("forward_to_group", r112, r113, r115, r111);
    L36:
        if (r103 == null) goto L38;
        r115 = r103.getReplyId();
        goto L39
    L38:
        r115 = null;
        goto L39
    L31:
        r113 = null;
        goto L32
    L28:
        r112 = null;
    L44:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
    L13:
        Message r117 = (Message) r100;
        u r118 = this.this$0;
        this.L$0 = r117;
        this.label = 2;
        Object r119 = u.a(r118, this);
        if (r119 != r101) goto L16;
        return r101;
    L16:
        r103 = r117;
        r100 = r119;
        goto L17
    L10:
        ResultKt.throwOnFailure(r100);
        u r120 = this.this$0;
        this.label = 1;
        r100 = u.a(r120, this);
        if (r100 != r101) goto L13;
        return r101;
    }

    public static final void access$invokeSuspend$lambda$1$mobSendResult(Message r100, u r101, boolean r102, Integer r103, String r110) {
        if (r100 == null) goto L5;
        String r104 = com.larus.feishu.office.im.impl.smart_reply.a.a(r100);
    L6:
        if (r100 == null) goto L8;
        String r105 = r100.getMessageId();
    L9:
        aya.b r106 = r101.f343408g.invoke();
        if (r106 == null) goto L13;
        String r107 = Long.valueOf(r106.f16773b).toString();
        if (r107 == null) goto L13;
    L16:
        aya.b r108 = r101.f343408g.invoke();
        if (r108 == null) goto L19;
        String r109 = r108.f16774c;
    L20:
        Boolean r111 = Boolean.valueOf(r102);
        JSONObject r112 = new JSONObject();
        Intrinsics.checkNotNullParameter(r112, "params");
        y99.a.d(r112, "click", "forward_to_group");     // Catch: JSONException -> L31
        y99.a.d(r112, "ai_reply_user_type", r104);     // Catch: JSONException -> L31
        y99.a.d(r112, "ai_msg_id", r105);     // Catch: JSONException -> L31
        y99.a.d(r112, NoticeInfo.KEY_REPLY_ID, r107);     // Catch: JSONException -> L31
        y99.a.d(r112, "chat_id", r109);     // Catch: JSONException -> L31
        if (Intrinsics.areEqual(r111, Boolean.TRUE) == false) goto L24;
        String r113 = "1";
    L25:
        y99.a.d(r112, "is_success", r113);     // Catch: JSONException -> L31
        if (r103 == null) goto L28;
        y99.a.d(r112, "error_code", String.valueOf(r103.intValue()));     // Catch: JSONException -> L31
    L28:
        if (r110 == null) goto L33;
        y99.a.d(r112, "error_msg", r110);     // Catch: JSONException -> L31
    L33:
        y99.a.a("flow_doc_im_chat_box_ai_reply_send_result", r112, null);
        return;
    L24:
        r113 = "0";
    L31:
        e = move-exception;
        FLogger.f375446a.e("SmartReplyEventHelper", "error in SmartReplyEventHelper mobFlowDocImChatBoxAiReplySendResult " + e.getLocalizedMessage());
        goto L33
    L19:
        r109 = null;
    L13:
        if (r100 == null) goto L15;
        r107 = r100.getReplyId();
        goto L16
    L15:
        r107 = null;
        goto L16
    L8:
        r105 = null;
        goto L9
    L5:
        r104 = null;
        goto L6
    }
}
