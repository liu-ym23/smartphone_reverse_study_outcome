package com.bytedance.locallife.cube.api.model;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/locallife/cube/api/model/DelegateStatus;", "", "(Ljava/lang/String;I)V", ErrorCode.INIT, "LOADING", "SUCCESS", "FAIL", "DESTROYED", "cube-saas_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum DelegateStatus extends Enum<DelegateStatus> {
    private static final /* synthetic */ DelegateStatus[] $VALUES = null;
    public static final DelegateStatus DESTROYED = null;
    public static final DelegateStatus FAIL = null;
    public static final DelegateStatus INIT = null;
    public static final DelegateStatus LOADING = null;
    public static final DelegateStatus SUCCESS = null;

    private static final /* synthetic */ DelegateStatus[] $values() {
        return new DelegateStatus[]{INIT, LOADING, SUCCESS, FAIL, DESTROYED};
    }

    public static DelegateStatus valueOf(String r100) {
        return (DelegateStatus) a.a(DelegateStatus.class, r100);
    }

    public static DelegateStatus[] values() {
        return (DelegateStatus[]) $VALUES.clone();
    }

    static {
        INIT = new DelegateStatus(ErrorCode.INIT, 0);
        LOADING = new DelegateStatus("LOADING", 1);
        SUCCESS = new DelegateStatus("SUCCESS", 2);
        FAIL = new DelegateStatus("FAIL", 3);
        DESTROYED = new DelegateStatus("DESTROYED", 4);
        $VALUES = $values();
    }

    private DelegateStatus(String r100, int r101) {
        super(r100, r101);
    }
}
