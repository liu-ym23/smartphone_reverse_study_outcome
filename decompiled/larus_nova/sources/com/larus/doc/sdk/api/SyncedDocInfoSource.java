package com.larus.doc.sdk.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/doc/sdk/api/SyncedDocInfoSource;", "", "<init>", "(Ljava/lang/String;I)V", "CHAT_INPUT_HIDDEN", "USER_CHANGES", "OFFLINE_SYNC", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SyncedDocInfoSource extends Enum<SyncedDocInfoSource> {
    public static final SyncedDocInfoSource CHAT_INPUT_HIDDEN = null;
    public static final SyncedDocInfoSource OFFLINE_SYNC = null;
    public static final SyncedDocInfoSource USER_CHANGES = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SyncedDocInfoSource[] f331604a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f331605b = null;

    public static EnumEntries<SyncedDocInfoSource> getEntries() {
        return f331605b;
    }

    static {
        SyncedDocInfoSource r100 = new SyncedDocInfoSource("CHAT_INPUT_HIDDEN", 0);
        CHAT_INPUT_HIDDEN = r100;
        SyncedDocInfoSource r101 = new SyncedDocInfoSource("USER_CHANGES", 1);
        USER_CHANGES = r101;
        SyncedDocInfoSource r102 = new SyncedDocInfoSource("OFFLINE_SYNC", 2);
        OFFLINE_SYNC = r102;
        SyncedDocInfoSource[] r103 = {r100, r101, r102};
        f331604a = r103;
        f331605b = EnumEntriesKt.enumEntries(r103);
    }

    public static SyncedDocInfoSource[] values() {
        return (SyncedDocInfoSource[]) f331604a.clone();
    }

    public static SyncedDocInfoSource valueOf(String r100) {
        return (SyncedDocInfoSource) a.a(SyncedDocInfoSource.class, r100);
    }

    public SyncedDocInfoSource(String r100, int r101) {
        super(r100, r101);
    }
}
