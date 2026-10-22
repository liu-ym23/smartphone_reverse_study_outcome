package com.larus.avlink.api;

import com.huawei.hms.support.feature.result.CommonConstant;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/avlink/api/DatasetVideoRatio;", "", CommonConstant.KEY_DISPLAY_NAME, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "R3_4", "R9_16", "R16_9", "dora_avlink_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DatasetVideoRatio extends Enum<DatasetVideoRatio> {
    public static final DatasetVideoRatio R16_9 = null;
    public static final DatasetVideoRatio R3_4 = null;
    public static final DatasetVideoRatio R9_16 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DatasetVideoRatio[] f291636a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f291637b = null;
    private final String displayName;

    public static EnumEntries<DatasetVideoRatio> getEntries() {
        return f291637b;
    }

    static {
        DatasetVideoRatio r100 = new DatasetVideoRatio("R3_4", 0, "3:4");
        R3_4 = r100;
        DatasetVideoRatio r101 = new DatasetVideoRatio("R9_16", 1, "9:16");
        R9_16 = r101;
        DatasetVideoRatio r102 = new DatasetVideoRatio("R16_9", 2, "16:9");
        R16_9 = r102;
        DatasetVideoRatio[] r103 = {r100, r101, r102};
        f291636a = r103;
        f291637b = EnumEntriesKt.enumEntries(r103);
    }

    public static DatasetVideoRatio[] values() {
        return (DatasetVideoRatio[]) f291636a.clone();
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public static DatasetVideoRatio valueOf(String r100) {
        return (DatasetVideoRatio) a.a(DatasetVideoRatio.class, r100);
    }

    public DatasetVideoRatio(String r100, int r101, String r102) {
        super(r100, r101);
        this.displayName = r102;
    }
}
