package com.larus.avlink.api;

import com.huawei.hms.support.feature.result.CommonConstant;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/avlink/api/DatasetVideoResolution;", "", CommonConstant.KEY_DISPLAY_NAME, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "P1080", "K3", "dora_avlink_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DatasetVideoResolution extends Enum<DatasetVideoResolution> {
    public static final DatasetVideoResolution K3 = null;
    public static final DatasetVideoResolution P1080 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DatasetVideoResolution[] f291638a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f291639b = null;
    private final String displayName;

    public static EnumEntries<DatasetVideoResolution> getEntries() {
        return f291639b;
    }

    static {
        DatasetVideoResolution r100 = new DatasetVideoResolution("P1080", 0, "1080P");
        P1080 = r100;
        DatasetVideoResolution r101 = new DatasetVideoResolution("K3", 1, "3K");
        K3 = r101;
        DatasetVideoResolution[] r102 = {r100, r101};
        f291638a = r102;
        f291639b = EnumEntriesKt.enumEntries(r102);
    }

    public static DatasetVideoResolution[] values() {
        return (DatasetVideoResolution[]) f291638a.clone();
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public static DatasetVideoResolution valueOf(String r100) {
        return (DatasetVideoResolution) a.a(DatasetVideoResolution.class, r100);
    }

    public DatasetVideoResolution(String r100, int r101, String r102) {
        super(r100, r101);
        this.displayName = r102;
    }
}
