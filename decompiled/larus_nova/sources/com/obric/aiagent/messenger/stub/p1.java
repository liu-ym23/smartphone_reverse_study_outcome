package com.obric.aiagent.messenger.stub;

import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.chat.IObricChatContextService;
import com.obric.assistant.chat.ObricChatContextServiceDelegate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f384932a = 0;

    static {
    }

    public static void a(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.put("is_obric_continuous_talk", "1");
        String r101 = (String) r100.remove("inner_log_id");
        if (r101 == null) goto L5;
        FLogger.f375446a.i("SemanticAudioHelper", "getContinuousExt called, first query logId=".concat(r101));
        String r102 = (String) r100.put("o_semantic_screen_qa_first_logid", r101);
    L5:
        r100.remove("reply_unique_key");
    }

    public static void b(List r100) {
        Intrinsics.checkNotNullParameter(r100, "messages");
        FLogger.f375446a.i("SemanticAudioHelper", "handleObricContinuousTalk called, messages=" + r100);
        Iterator r101 = r100.iterator();
    L3:
        boolean r102 = false;
        com.obric.audio.continuous_talk.b r103 = null;
        if (r101.hasNext() == false) goto L11;
        Object r104 = r101.next();
        if (((Message) r104).getContentType() != 1) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == false) goto L3;
    L12:
        Message r106 = (Message) r104;
        if (r106 == null) goto L32;
        String r107 = r106.getMessageId();
        if (r107 != null) goto L17;
        return;
    L17:
        FLogger r108 = FLogger.f375446a;
        r108.i("SemanticAudioHelper", "requestChat called, messageId=".concat(r107));
        t1a.b r109 = IObricChatContextService.a.a(ObricChatContextServiceDelegate.f386558b);
        if (r109 == null) goto L20;
        r103 = (com.obric.audio.continuous_talk.b) r109.getAbility(com.obric.audio.continuous_talk.b.class);
    L20:
        StringBuilder r110 = new StringBuilder("requestChat: hasContinuousTalk=");
        if (r103 == null) goto L23;
        r102 = true;
    L23:
        r110.append(r102);
        r108.i("SemanticAudioHelper", r110.toString());
        if (r103 == null) goto L33;
        JSONObject r111 = new JSONObject();
        r111.put(com.bytedance.android.ec.core.event.a.KEY_QUESTION_ID, r107);
        r103.I0(r111);
        return;
    L33:
        return;
    L32:
        return;
    L8:
        r105 = false;
        goto L9
    L11:
        r104 = null;
        goto L12
    }
}
