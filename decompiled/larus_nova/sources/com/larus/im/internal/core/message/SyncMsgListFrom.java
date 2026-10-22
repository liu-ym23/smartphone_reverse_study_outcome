package com.larus.im.internal.core.message;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/im/internal/core/message/SyncMsgListFrom;", "", "<init>", "(Ljava/lang/String;I)V", "FROM_RESORT_LOCAL_INDEX", "FROM_SINGLE_CHAIN", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SyncMsgListFrom extends Enum<SyncMsgListFrom> {
    public static final SyncMsgListFrom FROM_RESORT_LOCAL_INDEX = null;
    public static final SyncMsgListFrom FROM_SINGLE_CHAIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SyncMsgListFrom[] f347775a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f347776b = null;

    public static EnumEntries<SyncMsgListFrom> getEntries() {
        return f347776b;
    }

    static {
        SyncMsgListFrom r100 = new SyncMsgListFrom("FROM_RESORT_LOCAL_INDEX", 0);
        FROM_RESORT_LOCAL_INDEX = r100;
        SyncMsgListFrom r101 = new SyncMsgListFrom("FROM_SINGLE_CHAIN", 1);
        FROM_SINGLE_CHAIN = r101;
        SyncMsgListFrom[] r102 = {r100, r101};
        f347775a = r102;
        f347776b = EnumEntriesKt.enumEntries(r102);
    }

    public static SyncMsgListFrom[] values() {
        return (SyncMsgListFrom[]) f347775a.clone();
    }

    public static SyncMsgListFrom valueOf(String r100) {
        return (SyncMsgListFrom) r27.a.a(SyncMsgListFrom.class, r100);
    }

    public SyncMsgListFrom(String r100, int r101) {
        super(r100, r101);
    }
}
