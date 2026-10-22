package wt;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.GameCPBuyGoodsResponse.CheckResultInfo")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0007¨\u0006\r"}, d2 = {"Lwt/b;", "", "", "checkCode", "Ljava/lang/Integer;", "", "verifyDecisionDetail", "Ljava/lang/String;", "scene", BytedCertConstant.CertKey.FLOW, "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements vh7.h {

    @SerializedName("check_code")
    public Integer checkCode;

    @SerializedName(BytedCertConstant.CertKey.FLOW)
    public String flow;

    @SerializedName("scene")
    public String scene;

    @SerializedName("verify_decision_detail")
    public String verifyDecisionDetail;

    public static final class a {
    }

    static {
    }

    public b() {
        this.checkCode = 0;
        this.verifyDecisionDetail = "";
        this.scene = "";
        this.flow = "";
    }

    public b(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.checkCode = Integer.valueOf(r100.i());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.verifyDecisionDetail = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.flow = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.scene = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.checkCode != null) goto L22;
        this.checkCode = 0;
    L22:
        if (this.verifyDecisionDetail != null) goto L25;
        this.verifyDecisionDetail = "";
    L25:
        if (this.scene != null) goto L28;
        this.scene = "";
    L28:
        if (this.flow != null) goto L46;
        this.flow = "";
        return;
    }
}
