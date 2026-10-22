package com.larus.im.internal.core.conversation;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/core/conversation/ConversationInOutTracker;", "", "<init>", "()V", "cvsMap", "Lcom/flow/kmp/common/collections/ConcurrentHashMap;", "", "", "getCvsMap", "()Lcom/flow/kmp/common/collections/ConcurrentHashMap;", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConversationInOutTracker {
    public static final ConversationInOutTracker INSTANCE = null;
    private static final vt7.a<String, Boolean> cvsMap = null;

    private ConversationInOutTracker() {
    }

    static {
        INSTANCE = new ConversationInOutTracker();
        cvsMap = new vt7.a();
    }

    public final vt7.a<String, Boolean> getCvsMap() {
        return cvsMap;
    }
}
