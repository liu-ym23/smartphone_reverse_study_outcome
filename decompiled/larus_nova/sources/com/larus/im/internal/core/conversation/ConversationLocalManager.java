package com.larus.im.internal.core.conversation;

import com.larus.im.internal.delegate.c1;
import com.larus.im.internal.delegate.y0;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/larus/im/internal/core/conversation/ConversationLocalManager;", "", "<init>", "()V", "KEY_CONVERSATION_VERSION", "", "getName", "recentConvVersionKey", "getConversationVersion", "", "saveConversationVersion", "", "conversationVersion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConversationLocalManager {
    public static final ConversationLocalManager INSTANCE = null;
    private static final String KEY_CONVERSATION_VERSION = "conversation_version";

    static {
        INSTANCE = new ConversationLocalManager();
    }

    private ConversationLocalManager() {
    }

    private final String getName() {
        return "conversation-local-manager" + com.larus.im.internal.delegate.b.f348193b.j();
    }

    public final long getConversationVersion() {
        return c1.f348202a.l(recentConvVersionKey(), getName());
    }

    private final String recentConvVersionKey() {
        String r100 = y0.g().f348607d;
        if (r100 != null) goto L6;
        r100 = "0";
    L6:
        return "conversation_version.".concat(r100);
    }

    public final void saveConversationVersion(long r100) {
        c1.f348202a.b(recentConvVersionKey(), r100, getName());
    }
}
