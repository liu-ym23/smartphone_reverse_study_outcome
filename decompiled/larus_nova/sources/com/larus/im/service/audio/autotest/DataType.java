package com.larus.im.service.audio.autotest;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/im/service/audio/autotest/DataType;", "", "<init>", "(Ljava/lang/String;I)V", "MIC", "REF", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DataType extends Enum<DataType> {
    public static final DataType MIC = null;
    public static final DataType REF = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DataType[] f350682a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350683b = null;

    public static EnumEntries<DataType> getEntries() {
        return f350683b;
    }

    static {
        DataType r100 = new DataType("MIC", 0);
        MIC = r100;
        DataType r101 = new DataType("REF", 1);
        REF = r101;
        DataType[] r102 = {r100, r101};
        f350682a = r102;
        f350683b = EnumEntriesKt.enumEntries(r102);
    }

    public static DataType[] values() {
        return (DataType[]) f350682a.clone();
    }

    public static DataType valueOf(String r100) {
        return (DataType) a.a(DataType.class, r100);
    }

    public DataType(String r100, int r101) {
        super(r100, r101);
    }
}
