package com.larus.im.internal.jni.observer;

import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0007¨\u0006\u0004"}, d2 = {"GetOmniConversationDispatcher", "Lcom/larus/im/internal/jni/observer/ObserverContainer;", "", "Lcom/larus/im/internal/jni/observer/OmniConversationObserver;", "omnisdk_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class OmniConversationDispatcherKt {
    @Deprecated(message = "for imsdk")
    public static final ObserverContainer<String, OmniConversationObserver> GetOmniConversationDispatcher() {
        return OmniConversationDispatcher.Companion.getInst();
    }
}
