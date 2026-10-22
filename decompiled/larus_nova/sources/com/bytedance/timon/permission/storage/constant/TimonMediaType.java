package com.bytedance.timon.permission.storage.constant;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/timon/permission/storage/constant/TimonMediaType;", "", "IMAGE", "VIDEO", "AUDIO", "permission-keeper-storage_release"}, k = 1, mv = {1, 7, 1})
public final enum TimonMediaType extends Enum<TimonMediaType> {
    public static final TimonMediaType AUDIO = null;
    public static final TimonMediaType IMAGE = null;
    public static final TimonMediaType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TimonMediaType[] f270654a = null;

    public static TimonMediaType valueOf(String r100) {
        return (TimonMediaType) a.a(TimonMediaType.class, r100);
    }

    public static TimonMediaType[] values() {
        return (TimonMediaType[]) f270654a.clone();
    }

    static {
        TimonMediaType r100 = new TimonMediaType("IMAGE", 0);
        IMAGE = r100;
        TimonMediaType r101 = new TimonMediaType("VIDEO", 1);
        VIDEO = r101;
        TimonMediaType r102 = new TimonMediaType("AUDIO", 2);
        AUDIO = r102;
        f270654a = new TimonMediaType[]{r100, r101, r102};
    }

    public TimonMediaType(String r100, int r101) {
        super(r100, r101);
    }
}
