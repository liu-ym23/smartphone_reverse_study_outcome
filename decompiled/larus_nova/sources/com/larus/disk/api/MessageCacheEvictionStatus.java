package com.larus.disk.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/disk/api/MessageCacheEvictionStatus;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "PARTIAL", "STALE_SNAPSHOT", "UNAVAILABLE", "FAILED", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MessageCacheEvictionStatus extends Enum<MessageCacheEvictionStatus> {
    public static final MessageCacheEvictionStatus FAILED = null;
    public static final MessageCacheEvictionStatus PARTIAL = null;
    public static final MessageCacheEvictionStatus STALE_SNAPSHOT = null;
    public static final MessageCacheEvictionStatus SUCCESS = null;
    public static final MessageCacheEvictionStatus UNAVAILABLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MessageCacheEvictionStatus[] f330521a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f330522b = null;

    public static EnumEntries<MessageCacheEvictionStatus> getEntries() {
        return f330522b;
    }

    static {
        MessageCacheEvictionStatus r100 = new MessageCacheEvictionStatus("SUCCESS", 0);
        SUCCESS = r100;
        MessageCacheEvictionStatus r101 = new MessageCacheEvictionStatus("PARTIAL", 1);
        PARTIAL = r101;
        MessageCacheEvictionStatus r102 = new MessageCacheEvictionStatus("STALE_SNAPSHOT", 2);
        STALE_SNAPSHOT = r102;
        MessageCacheEvictionStatus r103 = new MessageCacheEvictionStatus("UNAVAILABLE", 3);
        UNAVAILABLE = r103;
        MessageCacheEvictionStatus r104 = new MessageCacheEvictionStatus("FAILED", 4);
        FAILED = r104;
        MessageCacheEvictionStatus[] r105 = {r100, r101, r102, r103, r104};
        f330521a = r105;
        f330522b = EnumEntriesKt.enumEntries(r105);
    }

    public static MessageCacheEvictionStatus[] values() {
        return (MessageCacheEvictionStatus[]) f330521a.clone();
    }

    public static MessageCacheEvictionStatus valueOf(String r100) {
        return (MessageCacheEvictionStatus) r27.a.a(MessageCacheEvictionStatus.class, r100);
    }

    public MessageCacheEvictionStatus(String r100, int r101) {
        super(r100, r101);
    }
}
