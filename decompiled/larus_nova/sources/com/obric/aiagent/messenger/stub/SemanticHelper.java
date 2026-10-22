package com.obric.aiagent.messenger.stub;

import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.chat.impl.MessageApiImpl;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class SemanticHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SemanticHelper f384873a = null;

    static {
        f384873a = new SemanticHelper();
    }

    public SemanticHelper() {
    }

    public static void a(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.put("is_semantic_screen_qa", "1");
        String r101 = (String) r100.get("o_session");     // Catch: Exception -> L8
        if (r101 == null) goto L6;
        JSONObject r102 = new JSONObject(r101);     // Catch: Exception -> L8
    L12:
    L10:
        r102.put("is_semantic_screen_qa", "1");
        r100.put("o_session", r102.toString());
        return;
    L6:
        r102 = new JSONObject();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        FLogger.f375446a.w("SemanticHelper", "Failed to parse o_session JSON, creating new", e);
        r102 = new JSONObject();
        goto L10
    }

    public static boolean b(Message r100, Message r101) {
        if (r101 != null) goto L6;
        return false;
    L6:
        if (com.larus.utils.o0.d(r100.getMessageId()) == false) goto L10;
        if (Intrinsics.areEqual(r101.getMessageId(), r100.getMessageId()) == false) goto L10;
    L13:
        boolean r102 = true;
    L16:
        if (com.larus.utils.o0.d(com.larus.im.bean.message.a.g(r100)) == true) goto L18;
    L20:
        boolean r103 = false;
    L21:
        if (r102 == true) goto L23;
        if (r103 == true) goto L23;
        return false;
    L23:
        return true;
    L18:
        if (Intrinsics.areEqual(com.larus.im.bean.message.a.g(r101), com.larus.im.bean.message.a.g(r100)) == false) goto L20;
        r103 = true;
    L10:
        if (com.larus.utils.o0.d(r100.getLocalMessageId()) == true) goto L12;
    L14:
        r102 = false;
        goto L16
    L12:
        if (Intrinsics.areEqual(r101.getLocalMessageId(), r100.getLocalMessageId()) == false) goto L14;
        goto L13
    }

    public final Object c(Message r100, String r110, Continuation<? super Boolean> r111) {
        if ((r111 instanceof SemanticHelper$preCheck$1) == false) goto L7;
        SemanticHelper$preCheck$1 r101 = (SemanticHelper$preCheck$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        String r105 = null;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        Message r106 = (Message) r101.L$1;
        Message r113 = (Message) r101.L$0;
        ResultKt.throwOnFailure(r112);
        Message r114 = r106;
        r100 = r113;
        Object r115 = r112;
    L27:
        Message r116 = (Message) r115;
        boolean r107 = b(r100, r116);
        FLogger r108 = FLogger.f375446a;
        StringBuilder r109 = new StringBuilder("preCheck called, compare (message to latestSendMessage/lastLocalMessage), msgId: (");
        r109.append(r100.getMessageId());
        r109.append(", ");
        if (r114 == null) goto L30;
        String r117 = r114.getMessageId();
    L31:
        r109.append(r117);
        r109.append(", ");
        if (r116 == null) goto L34;
        String r118 = r116.getMessageId();
    L35:
        r109.append(r118);
        r109.append("), localMsgId: (");
        r109.append(r100.getLocalMessageId());
        r109.append(", ");
        if (r114 == null) goto L38;
        String r119 = r114.getLocalMessageId();
    L39:
        r109.append(r119);
        r109.append(", ");
        if (r116 == null) goto L42;
        String r120 = r116.getLocalMessageId();
    L43:
        r109.append(r120);
        r109.append("), collectionId: (");
        r109.append(com.larus.im.bean.message.a.g(r100));
        r109.append(", ");
        if (r114 == null) goto L46;
        String r121 = com.larus.im.bean.message.a.g(r114);
    L47:
        r109.append(r121);
        r109.append(", ");
        if (r116 == null) goto L50;
        r105 = com.larus.im.bean.message.a.g(r116);
    L50:
        r109.append(r105);
        r109.append("), hitByDb: ");
        r109.append(r107);
        r108.i("SemanticHelper", r109.toString());
        return Boxing.boxBoolean(r107);
    L46:
        r121 = null;
        goto L47
    L42:
        r120 = null;
        goto L43
    L38:
        r119 = null;
        goto L39
    L34:
        r118 = null;
        goto L35
    L30:
        r117 = null;
        goto L31
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        IObricChatService.f386556a.getClass();
        IObricChatService r122 = IObricChatService.a.a();
        if (r122 == null) goto L17;
        r122.g();
        r114 = MessageApiImpl.f386895a.j(r110);
    L19:
        if (b(r100, r114) == false) goto L22;
        FLogger.f375446a.i("SemanticHelper", "preCheck hit by cache, msgId: " + r100.getMessageId() + ", localMsgId: " + r100.getLocalMessageId());
        return Boxing.boxBoolean(true);
    L22:
        r101.L$0 = r100;
        r101.L$1 = r114;
        r101.label = 1;
        kotlinx.coroutines.j r123 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r101), 1);
        r123.C();
        com.larus.im.d.e().l(r110, new q1(r123));
        r115 = r123.B();
        if (r115 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L25:
        if (r115 != r103) goto L27;
        return r103;
    L17:
        r114 = null;
    L7:
        r101 = new SemanticHelper$preCheck$1(this, r111);
        goto L8
    }
}
