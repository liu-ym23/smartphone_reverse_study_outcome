package com.bytedance.applet.utils;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.a2;
import com.larus.bmhome.utils.LaunchLandingConfigHelperDelegate;
import com.larus.bmhome.utils.q3;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TextContent;
import com.larus.im.bean.message.block.AppletBlock;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.y;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import yc9.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class MessageUtils {
    public static final MessageUtils a = null;

    public static final class a implements IIMCallback<Message> {
        public final /* synthetic */ CompletableDeferred<Message> a;

        public final boolean mustInMain() {
            return !y0.a();
        }

        public a(CompletableDeferred<Message> r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            Intrinsics.checkNotNullParameter(r2, "error");
            this.a.complete(null);
        }

        public final void onSuccess(Object r2) {
            CompletableDeferred<Message> r0 = this.a;
            r0.complete((Message) r2);
        }
    }

    public static final class b implements IIMCallback<Message> {
        public final /* synthetic */ String a;
        public final /* synthetic */ CompletableDeferred<Boolean> b;

        public final boolean mustInMain() {
            return !y0.a();
        }

        public final void onFailure(IIMError r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            FLogger.a.e("MessageUtils", "updateMessageContentBlock remote update fail, msgId=" + this.a + " error=" + r4.getExt());
            this.b.complete(Boolean.FALSE);
        }

        public final void onSuccess(Object r5) {
            Message r6 = (Message) r5;
            Intrinsics.checkNotNullParameter(r6, "result");
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("[MessageUtils] updateContentRemote success msgId=");
            r1.append(this.a);
            r1.append(" result.isNewBlockType=");
            r1.append(r6.isNewBlockType());
            r1.append(" result.contentLength=");
            String r2 = r6.getContent();
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = r2.length();
        L6:
            r1.append(r4);
            r1.append(" result.contentBlockSize=");
            List r7 = r6.getContentBlock();
            if (r7 == null) goto L9;
            r3 = r7.size();
        L9:
            r1.append(r3);
            r0.i("MessageUtils", r1.toString());
            this.b.complete(Boolean.TRUE);
            return;
        L5:
            r4 = 0;
            goto L6
        }

        public b(String r1, CompletableDeferred<Boolean> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        a = new MessageUtils();
    }

    public MessageUtils() {
    }

    public static void a(String r25, String r26) {
        Intrinsics.checkNotNullParameter(r25, "convId");
        Intrinsics.checkNotNullParameter(r26, "content");
        NativeMessageServiceImpl r0 = com.larus.im.d.e();
        int r1 = wf9.b.a;
        String r18 = com.flow.kmp.common.util.i.a();
        r0.addMessage(new f0(r25, null, AccountService.a.getUserId(), 0, 1003, r26, r18, null, 11, null, false, null, null, null, null, null, r26, null, null, null, null, 534772426), null);
    }

    public static void k(String r7, Function1 r8) {
        Intrinsics.checkNotNullParameter(r8, "callback");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new MessageUtils$isLastMessage$1(r8, r7, null), 3, null);
    }

    public final Object d(String r5, Continuation<? super String> r6) {
        if ((r6 instanceof MessageUtils$findOrCreateConversationByBot$1) == false) goto L7;
        MessageUtils$findOrCreateConversationByBot$1 r0 = (MessageUtils$findOrCreateConversationByBot$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L18:
        return ((q3) r7).a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        LaunchLandingConfigHelperDelegate r8 = LaunchLandingConfigHelperDelegate.b;
        r0.label = 1;
        r7 = r8.d(r5, r0);
        if (r7 != r2) goto L18;
        return r2;
    L7:
        r0 = new MessageUtils$findOrCreateConversationByBot$1(this, r6);
        goto L8
    }

    public final Object e(String r5, Continuation<? super String> r6) {
        if ((r6 instanceof MessageUtils$getConversationId$1) == false) goto L7;
        MessageUtils$getConversationId$1 r0 = (MessageUtils$getConversationId$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L17:
        Message r8 = (Message) r7;
        if (r8 != null) goto L22;
        return null;
    L22:
        return r8.getConversationId();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        r0.label = 1;
        r7 = zh8.a.a.E1(r5, r0);
        if (r7 != r2) goto L17;
        return r2;
    L7:
        r0 = new MessageUtils$getConversationId$1(this, r6);
        goto L8
    }

    public final Object f(String r7, Continuation<? super String> r8) {
        if ((r8 instanceof MessageUtils$getLastMessageId$1) == false) goto L7;
        MessageUtils$getLastMessageId$1 r0 = (MessageUtils$getLastMessageId$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L17:
        Message r10 = (Message) r9;
        if (r10 != null) goto L20;
        return null;
    L20:
        return r10.getMessageId();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        CompletableDeferred r11 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        com.larus.im.d.e().l(r7, new a(r11));
        r0.label = 1;
        r9 = r11.await(r0);
        if (r9 != r2) goto L17;
        return r2;
    L7:
        r0 = new MessageUtils$getLastMessageId$1(this, r8);
        goto L8
    }

    public final Object g(String r5, Continuation<? super String> r6) {
        if ((r6 instanceof MessageUtils$getReplyId$1) == false) goto L7;
        MessageUtils$getReplyId$1 r0 = (MessageUtils$getReplyId$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L17:
        Message r8 = (Message) r7;
        if (r8 != null) goto L22;
        return null;
    L22:
        return r8.getReplyId();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        IChatRepoService r9 = zh8.a.a;
        IChatRepoService r10 = zh8.a.a;
        r0.label = 1;
        r7 = r10.E1(r5, r0);
        if (r7 != r2) goto L17;
        return r2;
    L7:
        r0 = new MessageUtils$getReplyId$1(this, r6);
        goto L8
    }

    public final Object h(String r5, Continuation<? super String> r6) {
        if ((r6 instanceof MessageUtils$getWidgetInfoStringFromMessage$1) == false) goto L7;
        MessageUtils$getWidgetInfoStringFromMessage$1 r0 = (MessageUtils$getWidgetInfoStringFromMessage$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L17:
        Message r8 = (Message) r7;
        String r9 = null;
        if (r8 != null) goto L20;
        return null;
    L20:
        if (com.larus.im.bean.message.a.b0(r8) == false) goto L31;
        Block r10 = com.larus.im.bean.message.a.p(r8, BlockType.BLOCK_TYPE_WIDGET);
        if (r10 == null) goto L28;
        BlockContent r11 = r10.getContent();
        if (r11 == null) goto L28;
        AppletBlock r12 = r11.getAppletBlock();
        if (r12 == null) goto L28;
        r9 = r12.renderData;
    L28:
        if (r9 != null) goto L41;
        return "";
    L41:
        return r9;
    L31:
        if (r8.getContentType() != 1) goto L39;
        Object r13 = com.larus.bmhome.chat.bean.d.t(r8);
        if ((r13 instanceof TextContent) == false) goto L35;
        TextContent r14 = (TextContent) r13;
    L36:
        if (r14 != null) goto L44;
        return null;
    L44:
        return r14.text;
    L35:
        r14 = null;
        goto L36
    L39:
        return r8.getContent();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        IChatRepoService r15 = zh8.a.a;
        IChatRepoService r16 = zh8.a.a;
        r0.label = 1;
        r7 = r16.E1(r5, r0);
        if (r7 != r2) goto L17;
        return r2;
    L7:
        r0 = new MessageUtils$getWidgetInfoStringFromMessage$1(this, r6);
        goto L8
    }

    public final Object i(String r11, Continuation<? super Boolean> r12) {
        if ((r12 instanceof MessageUtils$isContextClearedMessage$1) == false) goto L7;
        MessageUtils$isContextClearedMessage$1 r0 = (MessageUtils$isContextClearedMessage$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        MessageUtils$isContextClearedMessage$1 r5 = r0;
        Object r13 = r5.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r5.label;
        Boolean r7 = null;
        String r8 = null;
        boolean r9 = false;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        Message r14 = (Message) r5.L$0;
        ResultKt.throwOnFailure(r13);
    L30:
        wc9.e r15 = (wc9.e) r13;
        if (r15 == null) goto L33;
        r8 = r15.B;
    L33:
        r7 = Boxing.boxBoolean(!Intrinsics.areEqual(r8, r14.getSectionId()));
    L34:
        if (r7 == null) goto L37;
        r9 = r7.booleanValue();
    L37:
        return Boxing.boxBoolean(r9);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r13);
    L23:
        r14 = (Message) r13;
        if (r14 == null) goto L37;
        String r16 = r14.getConversationId();
        if (r16 == null) goto L34;
        IConversationRepoService r4 = zh8.a.b;
        r5.L$0 = r14;
        r5.label = 2;
        r13 = IConversationRepoService.a.c(r4, r16, false, null, r5, 6);
        if (r13 != r2) goto L30;
        return r2;
    L16:
        ResultKt.throwOnFailure(r13);
        if (StringsKt.isBlank(r11) == true) goto L19;
        IChatRepoService r17 = zh8.a.a;
        r5.label = 1;
        r13 = r17.E1(r11, r5);
        if (r13 != r2) goto L23;
        return r2;
    L19:
        return Boxing.boxBoolean(false);
    L7:
        r0 = new MessageUtils$isContextClearedMessage$1(this, r12);
        goto L8
    }

    public final Object j(String r7, Continuation<? super Boolean> r8) {
        if ((r8 instanceof MessageUtils$isLastMessage$2) == false) goto L7;
        MessageUtils$isLastMessage$2 r0 = (MessageUtils$isLastMessage$2) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        r7 = (String) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L37:
        return Boxing.boxBoolean(Intrinsics.areEqual((String) r9, r7));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r7 = (String) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L29:
        Message r10 = (Message) r9;
        if (r10 == null) goto L39;
        String r11 = r10.getConversationId();
        if (r11 == null) goto L39;
        MessageUtils r4 = a;
        r0.L$0 = r7;
        r0.label = 2;
        r9 = r4.f(r11, r0);
        if (r9 != r2) goto L37;
        return r2;
    L39:
        return Boxing.boxBoolean(false);
    L16:
        ResultKt.throwOnFailure(r9);
        if (r7 != null) goto L19;
    L22:
        boolean r12 = true;
    L23:
        if (r12 == true) goto L25;
        IChatRepoService r13 = zh8.a.a;
        IChatRepoService r14 = zh8.a.a;
        r0.L$0 = r7;
        r0.label = 1;
        r9 = r14.E1(r7, r0);
        if (r9 != r2) goto L29;
        return r2;
    L25:
        return Boxing.boxBoolean(false);
    L19:
        if (r7.length() == 0) goto L22;
        r12 = false;
    L7:
        r0 = new MessageUtils$isLastMessage$2(this, r8);
        goto L8
    }

    public static a2 c(String r14, int r15, Map r16, String r17) {
        Intrinsics.checkNotNullParameter(r14, "content");
        Integer r12 = Integer.valueOf(r15);
        if (r15 != 100) goto L5;
        String r1 = r14;
    L6:
        if (r16 != null) goto L8;
        Map r2 = MapsKt.emptyMap();
    L9:
        if (r17 != null) goto L11;
        int r3 = wf9.b.a;
        String r4 = com.flow.kmp.common.util.i.a();
    L13:
        return new a2(r12, r1, r2, r4);
    L11:
        r4 = r17;
        goto L13
    L8:
        r2 = r16;
        goto L9
    L5:
        TextContent r13 = new TextContent(r14, null, null, null, null, null, null, null, 254, null);
        Intrinsics.checkNotNullParameter(r13, "what");
        r1 = GsonProtectorUtils.toJson(HttpExtKt.f, r13);
        goto L6
    }

    public final Object n(String r93, String r94, boolean r95, Continuation<? super Boolean> r96) {
        if ((r96 instanceof MessageUtils$updateMessageContentBlock$1) == false) goto L7;
        MessageUtils$updateMessageContentBlock$1 r2 = (MessageUtils$updateMessageContentBlock$1) r96;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        String r0 = (String) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L111:
        if (((Boolean) r1).booleanValue() == true) goto L115;
        FLogger.a.e("MessageUtils", "updateMessageContentBlock remote update fail, msgId=" + r0);
        return Boxing.boxBoolean(false);
    L115:
        return Boxing.boxBoolean(true);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r6 = (String) r2.L$1;
        String r7 = (String) r2.L$0;
        ResultKt.throwOnFailure(r1);
        String r8 = r6;
        Object r9 = r1;
    L27:
        Message r10 = (Message) r9;
        if (r10 != null) goto L31;
        FLogger.a.e("MessageUtils", "updateMessageContentBlock message not found, msgId=" + r7);
        return Boxing.boxBoolean(false);
    L31:
        List r11 = r10.getContentBlock();
        if (r11 != null) goto L34;
    L38:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r11 = vd9.r.a(r10);
        if ((!r11.isEmpty()) == true) goto L42;
        r11 = null;
    L42:
        if (r11 == null) goto L94;
    L44:
        Iterator r12 = r11.iterator();
        int r13 = 0;
    L46:
        if (r12.hasNext() == false) goto L59;
        Block r14 = (Block) r12.next();
        if (r14.getBlockType() != BlockType.BLOCK_TYPE_WIDGET.getValue()) goto L55;
        BlockContent r15 = r14.getContent();
        if (r15 == null) goto L52;
        AppletBlock r16 = r15.getAppletBlock();
    L53:
        if (r16 == null) goto L55;
        boolean r17 = true;
    L56:
        if (r17 == true) goto L60;
        r13 = r13 + 1;
    L60:
        if (r13 >= 0) goto L62;
        FLogger.a.e("MessageUtils", "buildUpdatedContentBlock widget block not found, msgId=" + r10.getMessageId());
        goto L94
    L62:
        Block r18 = (Block) ListProtector.get(r11, r13);
        BlockContent r19 = r18.getContent();
        if (r19 == null) goto L94;
        AppletBlock r20 = r19.getAppletBlock();
        if (r20 == null) goto L94;
        String r21 = r20.renderData;
        if (r21 != null) goto L71;
    L74:
        boolean r110 = true;
    L75:
        if (r110 == false) goto L116;
        FLogger.a.e("MessageUtils", "buildNewRenderData oldRenderData is null or blank");
    L92:
        String r64 = null;
    L93:
        if (r64 == null) goto L94;
        List r22 = CollectionsKt.toMutableList(r11);
        ListProtector.set(r22, r13, Block.copy$default(r18, 0, null, null, BlockContent.copy$default(r19, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, AppletBlock.copy$default(r20, r64, null, null, null, null, 30, null), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.MAX_VALUE, -1, 31, null), false, null, null, null, 247, null));
    L96:
        List r23 = r22;
        if (r23 != null) goto L99;
    L102:
        boolean r24 = true;
    L103:
        if (r24 == false) goto L106;
        FLogger.a.e("MessageUtils", "updateMessageContentBlock buildUpdatedContentBlock failed, msgId=" + r7);
        return Boxing.boxBoolean(false);
    L106:
        CompletableDeferred r25 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        com.larus.im.d.e().w(r7, r22, new b(r7, r25));
        r2.L$0 = r7;
        r2.L$1 = null;
        r2.label = 2;
        r1 = r25.await(r2);
        if (r1 != r4) goto L109;
        return r4;
    L109:
        r0 = r7;
        goto L111
    L99:
        if (r23.isEmpty() == true) goto L102;
        r24 = false;
        goto L103
    L116:
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L79
        Object r26 = Result.constructor-impl(new JSONObject(r21));     // Catch: Throwable -> L79
    L82:
        if (Result.exceptionOrNull-impl(r26) != null) goto L91;
        JSONObject r27 = (JSONObject) r26;
        Object r28 = r27.opt("widget_data");
        if (r28 == null) goto L86;
        String r112 = r28.getClass().getSimpleName();
    L87:
        String r113 = r112;
        if ((r28 instanceof String) == false) goto L90;
        r27.put("widget_data", r8);
        r64 = r27.toString();
        goto L93
    L90:
        FLogger.a.e("MessageUtils", "[MessageUtils] current widget_data is not string(type=" + r113 + ')');
        goto L92
    L86:
        r112 = "missing";
        goto L87
    L91:
        FLogger.a.e("MessageUtils", "buildNewRenderData parse renderData failed");
    L79:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r26 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L82
    L71:
        if (StringsKt.isBlank(r21) == true) goto L74;
        r110 = false;
        goto L75
    L52:
        r16 = null;
    L55:
        r17 = false;
        goto L56
    L59:
        r13 = -1;
    L94:
        r22 = null;
        goto L96
    L34:
        if ((!r11.isEmpty()) == true) goto L37;
        r11 = null;
    L37:
        if (r11 != null) goto L44;
    L16:
        ResultKt.throwOnFailure(r1);
        FLogger r29 = FLogger.a;
        r29.i("MessageUtils", "[MessageUtils] updateMessageContentBlock start msgId=" + r93 + " needBlockMeta=" + r95 + " widgetDataLen=" + r94.length());
        if (r94.length() != 0) goto L19;
        boolean r30 = true;
    L20:
        if (r30 == false) goto L23;
        r29.e("MessageUtils", "updateMessageContentBlock widgetData is empty, msgId=" + r93);
        return Boxing.boxBoolean(false);
    L23:
        IChatRepoService r31 = zh8.a.a;
        r2.L$0 = r93;
        r2.L$1 = r94;
        r2.label = 1;
        Object r32 = r31.E1(r93, r2);
        if (r32 != r4) goto L26;
        return r4;
    L26:
        r7 = r93;
        r9 = r32;
        r8 = r94;
        goto L27
    L19:
        r30 = false;
    L7:
        r2 = new MessageUtils$updateMessageContentBlock$1(this, r96);
        goto L8
    }

    public final Object o(String r5, String r6, String r7, Continuation<? super Boolean> r8) {
        if ((r8 instanceof MessageUtils$updateMessageResponseForModel$1) == false) goto L7;
        MessageUtils$updateMessageResponseForModel$1 r0 = (MessageUtils$updateMessageResponseForModel$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L18:
        if ((((com.larus.network.http.a) r9) instanceof com.larus.network.http.f) == false) goto L22;
        FLogger.a.e("MessageUtils", "updateMessage fail!!!");
        return Boxing.boxBoolean(false);
    L22:
        return Boxing.boxBoolean(true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        IChatRepoService r10 = zh8.a.a;
        r10.J1(r5, r6, null);
        r0.label = 1;
        r9 = r10.I1(r5, r6, r7, r0);
        if (r9 != r2) goto L18;
        return r2;
    L7:
        r0 = new MessageUtils$updateMessageResponseForModel$1(this, r8);
        goto L8
    }

    public static void l(String r12, String r13, String r14, Map r15, Function0 r16) {
        Intrinsics.checkNotNullParameter(r12, "msg");
        Intrinsics.checkNotNullParameter(r13, "cvsId");
        Intrinsics.checkNotNullParameter(r14, "botID");
        jw3.c r0 = jw3.c.a;
        jw3.d r1 = jw3.c.c.get();
        boolean r4 = false;
        if (r1 == null) goto L10;
        StringBuilder r6 = new StringBuilder("send msg to ");
        r6.append(r14);
        r6.append(" msg is ");
        r6.append(r12);
        r6.append(", empty?");
        if (r12.length() != 0) goto L7;
        boolean r7 = true;
    L8:
        r6.append(r7);
        r1.trace(r6.toString());
        goto L10
    L7:
        r7 = false;
    L10:
        if (r12.length() != 0) goto L12;
        r4 = true;
    L12:
        if (r4 == false) goto L15;
        FLogger.a.e("MessageUtils", "SendMsg but msg is empty");
        return;
    L15:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new MessageUtils$sendTextMessage$1(r13, r14, r12, r15, r16, null), 3, null);
    }

    public final Object m(String r17, int r18, String r19, String r20, Continuation<? super Boolean> r21) {
        if ((r21 instanceof MessageUtils$setEnvContext$1) == false) goto L7;
        MessageUtils$setEnvContext$1 r1 = (MessageUtils$setEnvContext$1) r21;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        MessageUtils$setEnvContext$1 r13 = r1;
        Object r0 = r13.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r13.label;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        ResultKt.throwOnFailure(r0);
    L30:
        com.larus.network.http.a r5 = (com.larus.network.http.a) r0;
        FLogger.a.d("MessageUtils", "setEnvContext: " + r5);
        boolean r6 = r5 instanceof y;
    L33:
        return Boxing.boxBoolean(r6);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r7 = r13.I$0;
        String r8 = (String) r13.L$2;
        String r9 = (String) r13.L$1;
        String r10 = (String) r13.L$0;
        ResultKt.throwOnFailure(r0);
        int r12 = r7;
        String r11 = r8;
        String r14 = r9;
        Object r15 = r0;
        String r16 = r10;
    L19:
        wc9.e r22 = (wc9.e) r15;
        if (r22 == null) goto L31;
        JSONObject r23 = new JSONObject();
        r23.put("timestamp", AppHost.a.getAppClock().currentTimeMillis());
        String r24 = r22.B;
        if (r24 == null) goto L26;
        Long r25 = StringsKt.toLongOrNull(r24);
        if (r25 == null) goto L26;
        long r26 = r25.longValue();
    L27:
        r23.put("section_id", r26);
        r23.put("conversation_id", CastLongProtector.parseLong(r16));
        r23.put("event_type", r12);
        r23.put("key", r14);
        r23.put("value", r11);
        r13.L$0 = null;
        r13.L$1 = null;
        r13.L$2 = null;
        r13.label = 2;
        r0 = HttpExtKt.k("AISDK", BizResponse.class, "/alice/message/event_log", r23, null, null, false, null, null, null, r13, 1008);
        if (r0 != r3) goto L30;
        return r3;
    L26:
        r26 = 0;
        goto L27
    L31:
        FLogger.a.d("MessageUtils", "setEnvContext: failed get conversation info convId " + r16);
        r6 = false;
        goto L33
    L16:
        ResultKt.throwOnFailure(r0);
        r16 = r17;
        r13.L$0 = r16;
        r14 = r19;
        r13.L$1 = r14;
        r11 = r20;
        r13.L$2 = r11;
        r12 = r18;
        r13.I$0 = r12;
        r13.label = 1;
        r15 = IConversationRepoService.a.c(zh8.a.b, r17, false, null, r13, 6);
        if (r15 != r3) goto L19;
        return r3;
    L7:
        r1 = new MessageUtils$setEnvContext$1(this, r21);
        goto L8
    }

    public final Object b(String r23, String r24, String r25, List<a2> r26, List<String> r27, boolean r28, List<String> r29, Continuation<? super Boolean> r30) {
        String r0 = r23;
        if ((r30 instanceof MessageUtils$createMessage$2) == false) goto L7;
        MessageUtils$createMessage$2 r2 = (MessageUtils$createMessage$2) r30;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r2.label;
        if (r4 == 0) goto L18;
        if (r4 == 1) goto L17;
        if (r4 == 2) goto L16;
        if (r4 != 3) goto L15;
        boolean r5 = r2.Z$0;
        String r6 = (String) r2.L$2;
        String r7 = (String) r2.L$1;
        String r8 = (String) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L53:
        boolean r9 = ((Boolean) r1).booleanValue();
        String r16 = r8;
        String r11 = r6;
        String r14 = r7;
    L55:
        jw3.c r10 = jw3.c.a;
        jw3.d r12 = jw3.c.c.get();
        if (r12 == null) goto L61;
        if (r11 != null) goto L59;
        r11 = "";
    L59:
        r12.a(r11, r16, r14, r5, r9);
    L61:
        return Boxing.boxBoolean(r9);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r5 = r2.Z$0;
        List<String> r15 = (List) r2.L$5;
        List<String> r17 = (List) r2.L$4;
        List<a2> r18 = (List) r2.L$3;
        String r19 = (String) r2.L$2;
        String r20 = (String) r2.L$1;
        String r21 = (String) r2.L$0;
        ResultKt.throwOnFailure(r1);
        List<String> r110 = r15;
        r11 = r19;
        String r111 = r20;
        String r112 = r21;
        List<a2> r22 = r18;
    L40:
        r9 = ((Boolean) r1).booleanValue();
        if (r9 == true) goto L54;
        IChatRepoService r31 = zh8.a.a;
        if (r11 != null) goto L45;
        String r32 = "";
    L46:
        if (r17 != null) goto L48;
        List<String> r33 = CollectionsKt.emptyList();
    L49:
        r2.L$0 = r112;
        r2.L$1 = r111;
        r2.L$2 = r11;
        r2.L$3 = null;
        r2.L$4 = null;
        r2.L$5 = null;
        r2.Z$0 = r5;
        r2.label = 3;
        String r113 = r111;
        String r210 = r11;
        List<String> r114 = r110;
        String r115 = r112;
        r1 = r31.p1(r112, r111, r32, r22, r33, r5, r114, r2);
        if (r1 != r13) goto L52;
        return r13;
    L52:
        r7 = r113;
        r8 = r115;
        r6 = r210;
        goto L53
    L48:
        r33 = r17;
        goto L49
    L45:
        r32 = r11;
        goto L46
    L54:
        r14 = r111;
        r16 = r112;
        goto L55
    L17:
        boolean r34 = r2.Z$0;
        List<String> r35 = (List) r2.L$5;
        List<String> r36 = (List) r2.L$4;
        List<a2> r37 = (List) r2.L$3;
        String r38 = (String) r2.L$2;
        String r39 = (String) r2.L$1;
        String r116 = (String) r2.L$0;
        ResultKt.throwOnFailure(r1);
        boolean r117 = r34;
        List<a2> r40 = r37;
        String r41 = r38;
    L27:
        String r42 = (String) r1;
        String r118 = r41;
        String r43 = r39;
        boolean r44 = r117;
        String r45 = r42;
        List<a2> r119 = r40;
        r0 = r116;
        List<String> r46 = r35;
        List<String> r120 = r36;
    L29:
        IChatRepoService r47 = zh8.a.a;
        if (r118 != null) goto L32;
        String r121 = "";
    L33:
        if (r120 != null) goto L35;
        List<String> r122 = CollectionsKt.emptyList();
    L36:
        r2.L$0 = r0;
        r2.L$1 = r43;
        r2.L$2 = r118;
        r2.L$3 = r119;
        r2.L$4 = r120;
        r2.L$5 = r46;
        r2.Z$0 = r44;
        r2.label = 2;
        String r48 = r45;
        String r49 = r121;
        r110 = r46;
        boolean r123 = r44;
        List<String> r50 = r122;
        List<String> r124 = r120;
        List<a2> r125 = r119;
        String r211 = r118;
        Object r51 = r47.p1(r0, r48, r49, r119, r50, r123, r110, r2);
        if (r51 != r13) goto L39;
        return r13;
    L39:
        r112 = r0;
        r111 = r43;
        r1 = r51;
        r17 = r124;
        r5 = r123;
        r22 = r125;
        r11 = r211;
        goto L40
    L35:
        r122 = r120;
        goto L36
    L32:
        r121 = r118;
        goto L33
    L18:
        ResultKt.throwOnFailure(r1);
        if (r24.length() != 0) goto L21;
        boolean r52 = true;
    L22:
        if (r52 == false) goto L28;
        MessageUtils r53 = a;
        r2.L$0 = r0;
        r2.L$1 = r24;
        r41 = r25;
        r2.L$2 = r41;
        r40 = r26;
        r2.L$3 = r40;
        r2.L$4 = r27;
        r2.L$5 = r29;
        r117 = r28;
        r2.Z$0 = r117;
        r2.label = 1;
        r1 = r53.d(r0, r2);
        if (r1 != r13) goto L26;
        return r13;
    L26:
        r36 = r27;
        r39 = r24;
        r35 = r29;
        r116 = r0;
        goto L27
    L28:
        r43 = r24;
        r118 = r25;
        r45 = r43;
        r119 = r26;
        r46 = r29;
        r120 = r27;
        r44 = r28;
        goto L29
    L21:
        r52 = false;
    L7:
        r2 = new MessageUtils$createMessage$2(this, r30);
        goto L8
    }
}
