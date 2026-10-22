package bl2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b/\u00100R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00061"}, d2 = {"Lbl2/b;", "Lcom/bytedance/android/ec/model/g;", "Lbl2/e;", "newcomerTicketModel", "Lbl2/e;", "e", "()Lbl2/e;", "setNewcomerTicketModel", "(Lbl2/e;)V", "", "toast", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "setToast", "(Ljava/lang/String;)V", "", "errNo", "I", "a", "()I", "setErrNo", "(I)V", "errTips", "getErrTips", "setErrTips", "Lel/b;", "lynxCouponPopupModel", "Lel/b;", "d", "()Lel/b;", "setLynxCouponPopupModel", "(Lel/b;)V", "Lel/a;", "fullLynxPageCouponPopup", "Lel/a;", "c", "()Lel/a;", "setFullLynxPageCouponPopup", "(Lel/a;)V", "", "forceShowToast", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "setForceShowToast", "(Ljava/lang/Boolean;)V", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b extends com.bytedance.android.ec.model.g {

    @SerializedName("err_no")
    private int errNo;

    @SerializedName("err_tips")
    private String errTips;

    @SerializedName("force_show_toast")
    private Boolean forceShowToast;

    @SerializedName("full_page_coupon_popup")
    private el.a fullLynxPageCouponPopup;

    @SerializedName("lynx_coupon_popup")
    private el.b lynxCouponPopupModel;

    @SerializedName("coupon_popup")
    private e newcomerTicketModel;

    @SerializedName("toast")
    private String toast;

    public b() {
        this.forceShowToast = Boolean.FALSE;
    }

    public final int a() {
        return this.errNo;
    }

    public final Boolean b() {
        return this.forceShowToast;
    }

    public final el.a c() {
        return this.fullLynxPageCouponPopup;
    }

    public final el.b d() {
        return this.lynxCouponPopupModel;
    }

    public final e e() {
        return this.newcomerTicketModel;
    }

    public final String f() {
        return this.toast;
    }
}
