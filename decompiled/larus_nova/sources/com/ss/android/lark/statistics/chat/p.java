package com.ss.android.lark.statistics.chat;

import com.ss.android.lark.chat.entity.message.Message;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes38.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Function1<Message, Unit>> f440690a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentLinkedQueue<Function1<Message, Unit>> f440691b = null;

    static {
        f440690a = new ConcurrentHashMap();
        f440691b = new ConcurrentLinkedQueue();
    }

    public static final void a(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "realMessage");
        Function1<Message, Unit> r101 = f440690a.remove(r100.getcId());
        if (r101 == null) goto L6;
        r101.invoke(r100);
        return;
    }

    /* JADX WARN: Type inference failed for: r7v4, types: [T, s5c.d] */
    /* JADX WARN: Type inference failed for: r7v7, types: [T, s5c.d] */
    public static void b(boolean r100, s5c.d r101, final List r102) {
        final boolean r103 = false;
        final Map r104 = null;
        ChatHitPointExtraParams$Click r105 = ChatHitPointExtraParams$Click.INPUT_BOX_MSG_SEND;
        final ChatMessageHitPointExtensionKt$pushSendRichTextSendHitPointAdvanced$1 r106 = ChatMessageHitPointExtensionKt$pushSendRichTextSendHitPointAdvanced$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r105, "click");
        Intrinsics.checkNotNullParameter(r106, "monitorSendImChatMainClick");
        s5c.h r107 = s5c.h.f540777a;
        if (r100 == false) goto L5;
        ChatHitPointExtraParams$Type r108 = ChatHitPointExtraParams$Type.BUTTON_SEND;
    L6:
        ChatHitPointExtraParams$IsFullScreen r109 = ChatHitPointExtraParams$IsFullScreen.FALSE;
        final Ref.ObjectRef r110 = new Ref.ObjectRef();
        ?? r111 = r105.plus(r107).plus(r108).plus(r109);
        r110.element = r111;
        if (r101 == null) goto L9;
        r110.element = r111.plus(r101);
    L9:
        final Exception r112 = new Exception("chat id is null");
        f440691b.offer(new ChatMessageHitPointExtensionKt$pushSendRichTextSendHitPointAdvanced$2(r103, r104, r106, r110, r112, r102));
        return;
    L5:
        r108 = ChatHitPointExtraParams$Type.HOTKEY_SEND;
        goto L6
    }
}
