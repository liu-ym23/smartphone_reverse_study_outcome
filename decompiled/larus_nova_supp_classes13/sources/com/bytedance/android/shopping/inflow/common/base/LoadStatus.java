package com.bytedance.android.shopping.inflow.common.base;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/inflow/common/base/LoadStatus;", "", "IDLE", "LOADING", "SUCCESS", "PACK_SUCCESS", "PACK_ERROR", "FINISH_ERROR", "FINISH_EMPTY", "FINISH_NO_MORE", "FINISH_HAS_MORE", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LoadStatus extends Enum<LoadStatus> {
    public static final LoadStatus FINISH_EMPTY = null;
    public static final LoadStatus FINISH_ERROR = null;
    public static final LoadStatus FINISH_HAS_MORE = null;
    public static final LoadStatus FINISH_NO_MORE = null;
    public static final LoadStatus IDLE = null;
    public static final LoadStatus LOADING = null;
    public static final LoadStatus PACK_ERROR = null;
    public static final LoadStatus PACK_SUCCESS = null;
    public static final LoadStatus SUCCESS = null;
    public static final /* synthetic */ LoadStatus[] a = null;

    static {
        LoadStatus r1 = new LoadStatus("IDLE", 0);
        IDLE = r1;
        LoadStatus r2 = new LoadStatus("LOADING", 1);
        LOADING = r2;
        LoadStatus r3 = new LoadStatus("SUCCESS", 2);
        SUCCESS = r3;
        LoadStatus r4 = new LoadStatus("PACK_SUCCESS", 3);
        PACK_SUCCESS = r4;
        LoadStatus r5 = new LoadStatus("PACK_ERROR", 4);
        PACK_ERROR = r5;
        LoadStatus r6 = new LoadStatus("FINISH_ERROR", 5);
        FINISH_ERROR = r6;
        LoadStatus r7 = new LoadStatus("FINISH_EMPTY", 6);
        FINISH_EMPTY = r7;
        LoadStatus r8 = new LoadStatus("FINISH_NO_MORE", 7);
        FINISH_NO_MORE = r8;
        LoadStatus r9 = new LoadStatus("FINISH_HAS_MORE", 8);
        FINISH_HAS_MORE = r9;
        a = new LoadStatus[]{r1, r2, r3, r4, r5, r6, r7, r8, r9};
    }

    public static LoadStatus valueOf(String r1) {
        return (LoadStatus) a.a(LoadStatus.class, r1);
    }

    public static LoadStatus[] values() {
        return (LoadStatus[]) a.clone();
    }

    public LoadStatus(String r1, int r2) {
        super(r1, r2);
    }
}
