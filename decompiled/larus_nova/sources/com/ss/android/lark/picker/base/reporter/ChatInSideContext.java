package com.ss.android.lark.picker.base.reporter;

import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0007J\u0006\u0010\u0013\u001a\u00020\u0005J\b\u0010\u0014\u001a\u00020\u0012H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/picker/base/reporter/ChatInSideContext;", "", "<init>", "()V", "inChatContext", "", "chatId", "", "getChatId$annotations", "getChatId", "()Ljava/lang/String;", "setChatId", "(Ljava/lang/String;)V", "chatType", "getChatType$annotations", "getChatType", "setChatType", "chatIn", "", "inChat", BasicTestActionHandler.TEST_ACTION_RESET, "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatInSideContext {
    public static final ChatInSideContext INSTANCE = null;
    private static String chatId;
    private static String chatType;
    private static boolean inChatContext;

    private ChatInSideContext() {
    }

    @JvmStatic
    public static final void chatIn() {
        inChatContext = true;
    }

    @JvmStatic
    public static /* synthetic */ void getChatId$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getChatType$annotations() {
    }

    @JvmStatic
    public static final void reset() {
        inChatContext = false;
        chatId = "";
        chatType = "";
    }

    static {
        INSTANCE = new ChatInSideContext();
        chatId = "";
        chatType = "";
    }

    public static final String getChatId() {
        return chatId;
    }

    public static final String getChatType() {
        return chatType;
    }

    public final boolean inChat() {
        return inChatContext;
    }

    public static final void setChatId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        chatId = r100;
    }

    public static final void setChatType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        chatType = r100;
    }
}
