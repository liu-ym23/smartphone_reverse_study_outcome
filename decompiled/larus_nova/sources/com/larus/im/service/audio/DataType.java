package com.larus.im.service.audio;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/im/service/audio/DataType;", "", "<init>", "(Ljava/lang/String;I)V", "RECORD", "PLAYER", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DataType extends Enum<DataType> {
    public static final DataType PLAYER = null;
    public static final DataType RECORD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DataType[] f350637a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350638b = null;

    public static EnumEntries<DataType> getEntries() {
        return f350638b;
    }

    static {
        DataType r100 = new DataType("RECORD", 0);
        RECORD = r100;
        DataType r101 = new DataType("PLAYER", 1);
        PLAYER = r101;
        DataType[] r102 = {r100, r101};
        f350637a = r102;
        f350638b = EnumEntriesKt.enumEntries(r102);
    }

    public static DataType[] values() {
        return (DataType[]) f350637a.clone();
    }

    public static DataType valueOf(String r100) {
        return (DataType) r27.a.a(DataType.class, r100);
    }

    public DataType(String r100, int r101) {
        super(r100, r101);
    }
}
