package com.bytedance.bdp.serviceapi.defaults.permission;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
public final class BdpPermissionResult {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/bdp/serviceapi/defaults/permission/BdpPermissionResult$ResultType;", "", "GRANTED", "DENIED", "NOT_FOUND", "bdp-service-api_release"}, k = 1, mv = {1, 4, 0})
    public static final enum ResultType extends Enum<ResultType> {
        public static final ResultType DENIED = null;
        public static final ResultType GRANTED = null;
        public static final ResultType NOT_FOUND = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ResultType[] f201577a = null;

        static {
            ResultType r100 = new ResultType("GRANTED", 0);
            GRANTED = r100;
            ResultType r101 = new ResultType("DENIED", 1);
            DENIED = r101;
            ResultType r102 = new ResultType("NOT_FOUND", 2);
            NOT_FOUND = r102;
            f201577a = new ResultType[]{r100, r101, r102};
        }

        public static ResultType valueOf(String r100) {
            return (ResultType) r27.a.a(ResultType.class, r100);
        }

        public static ResultType[] values() {
            return (ResultType[]) f201577a.clone();
        }

        public ResultType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public BdpPermissionResult(ResultType r100) {
    }
}
