package com.larus.drive.sdk.api.file.list;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/drive/sdk/api/file/list/RequestDriveFileListRankType;", "", "<init>", "(Ljava/lang/String;I)V", "ACCESS_TIME", "EDIT_TIME", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RequestDriveFileListRankType extends Enum<RequestDriveFileListRankType> {
    public static final RequestDriveFileListRankType ACCESS_TIME = null;
    public static final RequestDriveFileListRankType EDIT_TIME = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RequestDriveFileListRankType[] f341581a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f341582b = null;

    public static EnumEntries<RequestDriveFileListRankType> getEntries() {
        return f341582b;
    }

    static {
        RequestDriveFileListRankType r100 = new RequestDriveFileListRankType("ACCESS_TIME", 0);
        ACCESS_TIME = r100;
        RequestDriveFileListRankType r101 = new RequestDriveFileListRankType("EDIT_TIME", 1);
        EDIT_TIME = r101;
        RequestDriveFileListRankType[] r102 = {r100, r101};
        f341581a = r102;
        f341582b = EnumEntriesKt.enumEntries(r102);
    }

    public static RequestDriveFileListRankType[] values() {
        return (RequestDriveFileListRankType[]) f341581a.clone();
    }

    public static RequestDriveFileListRankType valueOf(String r100) {
        return (RequestDriveFileListRankType) a.a(RequestDriveFileListRankType.class, r100);
    }

    public RequestDriveFileListRankType(String r100, int r101) {
        super(r100, r101);
    }
}
