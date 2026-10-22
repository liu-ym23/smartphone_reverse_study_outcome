package com.ss.android.lark.myai.export.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/myai/export/model/DataType;", "", "<init>", "(Ljava/lang/String;I)V", "STRING", "JSON_STRING", "MARKDOWN_STRING", "RAW", "myai-export-officesdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DataType extends Enum<DataType> {
    public static final DataType JSON_STRING = null;
    public static final DataType MARKDOWN_STRING = null;
    public static final DataType RAW = null;
    public static final DataType STRING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DataType[] f432890a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f432891b = null;

    public static EnumEntries<DataType> getEntries() {
        return f432891b;
    }

    static {
        DataType r100 = new DataType("STRING", 0);
        STRING = r100;
        DataType r101 = new DataType("JSON_STRING", 1);
        JSON_STRING = r101;
        DataType r102 = new DataType("MARKDOWN_STRING", 2);
        MARKDOWN_STRING = r102;
        DataType r103 = new DataType("RAW", 3);
        RAW = r103;
        DataType[] r104 = {r100, r101, r102, r103};
        f432890a = r104;
        f432891b = EnumEntriesKt.enumEntries(r104);
    }

    public static DataType[] values() {
        return (DataType[]) f432890a.clone();
    }

    public static DataType valueOf(String r100) {
        return (DataType) a.a(DataType.class, r100);
    }

    public DataType(String r100, int r101) {
        super(r100, r101);
    }
}
