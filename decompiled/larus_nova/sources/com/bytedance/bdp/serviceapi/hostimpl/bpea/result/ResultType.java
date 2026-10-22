package com.bytedance.bdp.serviceapi.hostimpl.bpea.result;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/bdp/serviceapi/hostimpl/bpea/result/ResultType;", "", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "OK", "ERROR_BPEA_CERT_INVALID", "bdp-service-api_release"}, k = 1, mv = {1, 4, 0})
public final enum ResultType extends Enum<ResultType> {
    public static final ResultType ERROR_BPEA_CERT_INVALID = null;
    public static final ResultType OK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResultType[] f201601a = null;
    private final String desc;

    static {
        ResultType r100 = new ResultType("OK", 0, "operate success");
        OK = r100;
        ResultType r101 = new ResultType("ERROR_BPEA_CERT_INVALID", 1, "bpea cert is invalid");
        ERROR_BPEA_CERT_INVALID = r101;
        f201601a = new ResultType[]{r100, r101};
    }

    public static ResultType valueOf(String r100) {
        return (ResultType) a.a(ResultType.class, r100);
    }

    public static ResultType[] values() {
        return (ResultType[]) f201601a.clone();
    }

    public final String getDesc() {
        return this.desc;
    }

    public ResultType(String r100, int r101, String r102) {
        super(r100, r101);
        this.desc = r102;
    }
}
