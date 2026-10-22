package com.larus.mainbot.api.miniartifact;

import com.larus.media.MediaScene;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/mainbot/api/miniartifact/MessageRole;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", MediaScene.SYSTEM, FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, "ASSISTANT", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MessageRole extends Enum<MessageRole> {
    public static final MessageRole ASSISTANT = null;
    public static final MessageRole SYSTEM = null;
    public static final MessageRole USER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MessageRole[] f358422a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f358423b = null;
    private final int value;

    public static EnumEntries<MessageRole> getEntries() {
        return f358423b;
    }

    static {
        MessageRole r100 = new MessageRole(MediaScene.SYSTEM, 0, 0);
        SYSTEM = r100;
        MessageRole r101 = new MessageRole(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 1, 1);
        USER = r101;
        MessageRole r102 = new MessageRole("ASSISTANT", 2, 2);
        ASSISTANT = r102;
        MessageRole[] r103 = {r100, r101, r102};
        f358422a = r103;
        f358423b = EnumEntriesKt.enumEntries(r103);
    }

    public static MessageRole[] values() {
        return (MessageRole[]) f358422a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MessageRole valueOf(String r100) {
        return (MessageRole) a.a(MessageRole.class, r100);
    }

    public MessageRole(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
