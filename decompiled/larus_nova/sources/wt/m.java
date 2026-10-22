package wt;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.UserClaimCoupon")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0007R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004¨\u0006\u0012"}, d2 = {"Lwt/m;", "", "", "couponId", "Ljava/lang/String;", "", "couponDiscountAmount", "Ljava/lang/Long;", "couponDiscountLimit", "couponExpireTime", "", "isDefault", "Ljava/lang/Boolean;", "couponTemplateId", "couponType", "couponName", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m implements vh7.h {

    @SerializedName("coupon_discount_amount")
    public Long couponDiscountAmount;

    @SerializedName("coupon_discount_limit")
    public Long couponDiscountLimit;

    @SerializedName("coupon_expire_time")
    public Long couponExpireTime;

    @SerializedName("coupon_id")
    public String couponId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_COUPON_NAME)
    public String couponName;

    @SerializedName("coupon_template_id")
    public String couponTemplateId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_COUPON_TYPE)
    public Long couponType;

    @SerializedName("is_default")
    public Boolean isDefault;

    public m() {
        this.couponId = "";
        this.couponDiscountAmount = 0L;
        this.couponDiscountLimit = 0L;
        this.couponExpireTime = 0L;
        this.isDefault = Boolean.FALSE;
        this.couponTemplateId = "";
        this.couponType = 0L;
        this.couponName = "";
    }

    public m(am3.g r100) {
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
        this.couponName = am3.h.c(r100);
        goto L3
    L8:
        this.couponType = Long.valueOf(r100.j());
        goto L3
    L9:
        this.couponTemplateId = am3.h.c(r100);
        goto L3
    L10:
        this.isDefault = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L11:
        this.couponExpireTime = Long.valueOf(r100.j());
        goto L3
    L12:
        this.couponDiscountLimit = Long.valueOf(r100.j());
        goto L3
    L13:
        this.couponDiscountAmount = Long.valueOf(r100.j());
        goto L3
    L14:
        this.couponId = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.couponId != null) goto L19;
        this.couponId = "";
    L19:
        if (this.couponDiscountAmount != null) goto L22;
        this.couponDiscountAmount = 0L;
    L22:
        if (this.couponDiscountLimit != null) goto L25;
        this.couponDiscountLimit = 0L;
    L25:
        if (this.couponExpireTime != null) goto L28;
        this.couponExpireTime = 0L;
    L28:
        if (this.isDefault != null) goto L31;
        this.isDefault = Boolean.FALSE;
    L31:
        if (this.couponTemplateId != null) goto L34;
        this.couponTemplateId = "";
    L34:
        if (this.couponType != null) goto L37;
        this.couponType = 0L;
    L37:
        if (this.couponName != null) goto L60;
        this.couponName = "";
        return;
    }
}
