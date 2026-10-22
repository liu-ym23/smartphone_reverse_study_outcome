package com.larus.disk.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/disk/api/MessageCacheQueryStatus;", "", "<init>", "(Ljava/lang/String;I)V", "READY", "UNAVAILABLE", "FAILED", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MessageCacheQueryStatus extends Enum<MessageCacheQueryStatus> {
    public static final MessageCacheQueryStatus FAILED = null;
    public static final MessageCacheQueryStatus READY = null;
    public static final MessageCacheQueryStatus UNAVAILABLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MessageCacheQueryStatus[] f330523a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f330524b = null;

    public static EnumEntries<MessageCacheQueryStatus> getEntries() {
        return f330524b;
    }

    static {
        MessageCacheQueryStatus r100 = new MessageCacheQueryStatus("READY", 0);
        READY = r100;
        MessageCacheQueryStatus r101 = new MessageCacheQueryStatus("UNAVAILABLE", 1);
        UNAVAILABLE = r101;
        MessageCacheQueryStatus r102 = new MessageCacheQueryStatus("FAILED", 2);
        FAILED = r102;
        MessageCacheQueryStatus[] r103 = {r100, r101, r102};
        f330523a = r103;
        f330524b = EnumEntriesKt.enumEntries(r103);
    }

    public static MessageCacheQueryStatus[] values() {
        return (MessageCacheQueryStatus[]) f330523a.clone();
    }

    public static MessageCacheQueryStatus valueOf(String r100) {
        return (MessageCacheQueryStatus) r27.a.a(MessageCacheQueryStatus.class, r100);
    }

    public MessageCacheQueryStatus(String r100, int r101) {
        super(r100, r101);
    }
}
