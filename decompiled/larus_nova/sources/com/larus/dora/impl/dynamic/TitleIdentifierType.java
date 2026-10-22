package com.larus.dora.impl.dynamic;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/dora/impl/dynamic/TitleIdentifierType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "GeneralBar", "OnlyBack", "HistoryDeviceList", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TitleIdentifierType extends Enum<TitleIdentifierType> {
    public static final TitleIdentifierType GeneralBar = null;
    public static final TitleIdentifierType HistoryDeviceList = null;
    public static final TitleIdentifierType OnlyBack = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TitleIdentifierType[] f335141a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f335142b = null;
    private final String type;

    public static EnumEntries<TitleIdentifierType> getEntries() {
        return f335142b;
    }

    static {
        TitleIdentifierType r100 = new TitleIdentifierType("GeneralBar", 0, "general_bar");
        GeneralBar = r100;
        TitleIdentifierType r101 = new TitleIdentifierType("OnlyBack", 1, "only_back");
        OnlyBack = r101;
        TitleIdentifierType r102 = new TitleIdentifierType("HistoryDeviceList", 2, "history_device_list");
        HistoryDeviceList = r102;
        TitleIdentifierType[] r103 = {r100, r101, r102};
        f335141a = r103;
        f335142b = EnumEntriesKt.enumEntries(r103);
    }

    public static TitleIdentifierType[] values() {
        return (TitleIdentifierType[]) f335141a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static TitleIdentifierType valueOf(String r100) {
        return (TitleIdentifierType) r27.a.a(TitleIdentifierType.class, r100);
    }

    public TitleIdentifierType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
