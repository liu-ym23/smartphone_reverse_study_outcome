package com.larus.disk.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/disk/api/MessageCacheCleanScene;", "", "<init>", "(Ljava/lang/String;I)V", "REGULAR", "LOW_DISK", "MANUAL", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MessageCacheCleanScene extends Enum<MessageCacheCleanScene> {
    public static final MessageCacheCleanScene LOW_DISK = null;
    public static final MessageCacheCleanScene MANUAL = null;
    public static final MessageCacheCleanScene REGULAR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MessageCacheCleanScene[] f330519a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f330520b = null;

    public static EnumEntries<MessageCacheCleanScene> getEntries() {
        return f330520b;
    }

    static {
        MessageCacheCleanScene r100 = new MessageCacheCleanScene("REGULAR", 0);
        REGULAR = r100;
        MessageCacheCleanScene r101 = new MessageCacheCleanScene("LOW_DISK", 1);
        LOW_DISK = r101;
        MessageCacheCleanScene r102 = new MessageCacheCleanScene("MANUAL", 2);
        MANUAL = r102;
        MessageCacheCleanScene[] r103 = {r100, r101, r102};
        f330519a = r103;
        f330520b = EnumEntriesKt.enumEntries(r103);
    }

    public static MessageCacheCleanScene[] values() {
        return (MessageCacheCleanScene[]) f330519a.clone();
    }

    public static MessageCacheCleanScene valueOf(String r100) {
        return (MessageCacheCleanScene) r27.a.a(MessageCacheCleanScene.class, r100);
    }

    public MessageCacheCleanScene(String r100, int r101) {
        super(r100, r101);
    }
}
