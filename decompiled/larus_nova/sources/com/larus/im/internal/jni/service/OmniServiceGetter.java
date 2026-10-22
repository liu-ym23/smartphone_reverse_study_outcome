package com.larus.im.internal.jni.service;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0007H\u0086 J\t\u0010\b\u001a\u00020\tH\u0086 J\t\u0010\n\u001a\u00020\u000bH\u0086 J\t\u0010\f\u001a\u00020\rH\u0086 J\t\u0010\u000e\u001a\u00020\u000fH\u0086 J\t\u0010\u0010\u001a\u00020\u0011H\u0086 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/im/internal/jni/service/OmniServiceGetter;", "", "omniSdkPtr", "", "<init>", "(J)V", "getMessageService", "Lcom/larus/im/internal/jni/service/OmniMessageService;", "getConversationService", "Lcom/larus/im/internal/jni/service/OmniConversationService;", "getThreadService", "Lcom/larus/im/internal/jni/service/OmniThreadService;", "getCmdService", "Lcom/larus/im/internal/jni/service/OmniCmdService;", "getAiJobService", "Lcom/larus/im/internal/jni/service/OmniAIJobService;", "getProjectService", "Lcom/larus/im/internal/jni/service/OmniProjectService;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniServiceGetter {
    private final long omniSdkPtr;

    public final native OmniAIJobService getAiJobService();

    public final native OmniCmdService getCmdService();

    public final native OmniConversationService getConversationService();

    public final native OmniMessageService getMessageService();

    public final native OmniProjectService getProjectService();

    public final native OmniThreadService getThreadService();

    public OmniServiceGetter(long r100) {
        this.omniSdkPtr = r100;
    }
}
