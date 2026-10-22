package com.bytedance.bdp.appbase.service.protocol.file.entity;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"com/bytedance/bdp/appbase/service/protocol/file/entity/GetFileInfoEntity$FileType", "", "Lcom/bytedance/bdp/appbase/service/protocol/file/entity/GetFileInfoEntity$FileType;", "FILE", "DIR", "bdp-appbase-ext_release"}, k = 1, mv = {1, 4, 0})
public final enum GetFileInfoEntity$FileType extends Enum<GetFileInfoEntity$FileType> {
    public static final GetFileInfoEntity$FileType DIR = null;
    public static final GetFileInfoEntity$FileType FILE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GetFileInfoEntity$FileType[] f200964a = null;

    static {
        GetFileInfoEntity$FileType r100 = new GetFileInfoEntity$FileType("FILE", 0);
        FILE = r100;
        GetFileInfoEntity$FileType r101 = new GetFileInfoEntity$FileType("DIR", 1);
        DIR = r101;
        f200964a = new GetFileInfoEntity$FileType[]{r100, r101};
    }

    public static GetFileInfoEntity$FileType valueOf(String r100) {
        return (GetFileInfoEntity$FileType) a.a(GetFileInfoEntity$FileType.class, r100);
    }

    public static GetFileInfoEntity$FileType[] values() {
        return (GetFileInfoEntity$FileType[]) f200964a.clone();
    }

    public GetFileInfoEntity$FileType(String r100, int r101) {
        super(r100, r101);
    }
}
