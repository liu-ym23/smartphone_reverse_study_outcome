package com.bytedance.cloudplay.xplay2.api.module.local_info;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/cloudplay/xplay2/api/module/local_info/LocalInfoResult;", "", "SUCCESS", "FAIL", "CANCEl", "EXIT", "xplay2-api_release"}, k = 1, mv = {1, 8, 0})
public final enum LocalInfoResult extends Enum<LocalInfoResult> {
    public static final LocalInfoResult CANCEl = null;
    public static final LocalInfoResult EXIT = null;
    public static final LocalInfoResult FAIL = null;
    public static final LocalInfoResult SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LocalInfoResult[] f202797a = null;

    public static LocalInfoResult valueOf(String r100) {
        return (LocalInfoResult) a.a(LocalInfoResult.class, r100);
    }

    public static LocalInfoResult[] values() {
        return (LocalInfoResult[]) f202797a.clone();
    }

    static {
        LocalInfoResult r100 = new LocalInfoResult("SUCCESS", 0);
        SUCCESS = r100;
        LocalInfoResult r101 = new LocalInfoResult("FAIL", 1);
        FAIL = r101;
        LocalInfoResult r102 = new LocalInfoResult("CANCEl", 2);
        CANCEl = r102;
        LocalInfoResult r103 = new LocalInfoResult("EXIT", 3);
        EXIT = r103;
        f202797a = new LocalInfoResult[]{r100, r101, r102, r103};
    }

    public LocalInfoResult(String r100, int r101) {
        super(r100, r101);
    }
}
