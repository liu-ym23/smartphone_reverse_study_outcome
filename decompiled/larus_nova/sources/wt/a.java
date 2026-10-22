package wt;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.GameCPBuyGoodsResponse.Data")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lwt/a;", "", "", "orderId", "Ljava/lang/String;", "", "orderTime", "Ljava/lang/Long;", "paymentId", "cashierParam", "cashierType", "payResultLink", "orderDetailLink", "Lwt/b;", "checkResultInfo", "Lwt/b;", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements vh7.h {

    @SerializedName("cashier_param")
    public String cashierParam;

    @SerializedName("cashier_type")
    public String cashierType;

    @SerializedName(LocationMonitorConst.CHECK_RESULT)
    public b checkResultInfo;

    @SerializedName("order_detail_link")
    public String orderDetailLink;

    @SerializedName("order_id")
    public String orderId;

    @SerializedName("order_create_time")
    public Long orderTime;

    @SerializedName("pay_result_link")
    public String payResultLink;

    @SerializedName("payment_id")
    public String paymentId;

    public a() {
        this.orderId = "";
        this.orderTime = 0L;
        this.paymentId = "";
        this.cashierParam = "";
        this.cashierType = "";
        this.payResultLink = "";
        this.orderDetailLink = "";
    }

    public a(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        switch(r102) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        this.orderTime = Long.valueOf(r100.j());
        goto L3
    L8:
        this.orderDetailLink = am3.h.c(r100);
        goto L3
    L9:
        this.payResultLink = am3.h.c(r100);
        goto L3
    L10:
        this.checkResultInfo = new b(r100);
        goto L3
    L11:
        this.cashierType = am3.h.c(r100);
        goto L3
    L12:
        this.cashierParam = am3.h.c(r100);
        goto L3
    L13:
        this.paymentId = am3.h.c(r100);
        goto L3
    L14:
        this.orderId = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.orderId != null) goto L19;
        this.orderId = "";
    L19:
        if (this.orderTime != null) goto L22;
        this.orderTime = 0L;
    L22:
        if (this.paymentId != null) goto L25;
        this.paymentId = "";
    L25:
        if (this.cashierParam != null) goto L28;
        this.cashierParam = "";
    L28:
        if (this.cashierType != null) goto L31;
        this.cashierType = "";
    L31:
        if (this.payResultLink != null) goto L34;
        this.payResultLink = "";
    L34:
        if (this.orderDetailLink != null) goto L57;
        this.orderDetailLink = "";
        return;
    }
}
