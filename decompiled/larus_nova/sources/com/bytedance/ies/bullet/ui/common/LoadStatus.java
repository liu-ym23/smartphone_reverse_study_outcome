package com.bytedance.ies.bullet.ui.common;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/LoadStatus;", "", ErrorCode.INIT, "LOADING", "SUCCESS", "FAIL", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum LoadStatus extends Enum<LoadStatus> {
    public static final LoadStatus FAIL = null;
    public static final LoadStatus INIT = null;
    public static final LoadStatus LOADING = null;
    public static final LoadStatus SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoadStatus[] f248236a = null;

    public static LoadStatus valueOf(String r100) {
        return (LoadStatus) r27.a.a(LoadStatus.class, r100);
    }

    public static LoadStatus[] values() {
        return (LoadStatus[]) f248236a.clone();
    }

    static {
        LoadStatus r100 = new LoadStatus(ErrorCode.INIT, 0);
        INIT = r100;
        LoadStatus r101 = new LoadStatus("LOADING", 1);
        LOADING = r101;
        LoadStatus r102 = new LoadStatus("SUCCESS", 2);
        SUCCESS = r102;
        LoadStatus r103 = new LoadStatus("FAIL", 3);
        FAIL = r103;
        f248236a = new LoadStatus[]{r100, r101, r102, r103};
    }

    public LoadStatus(String r100, int r101) {
        super(r100, r101);
    }
}
