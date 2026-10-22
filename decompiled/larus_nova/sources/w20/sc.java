package w20;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u001e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR$\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\b¨\u0006'"}, d2 = {"Lw20/sc;", "", "", "request_page", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "setRequest_page", "(Ljava/lang/String;)V", "", "source", "Ljava/lang/Integer;", RXScreenCaptureService.KEY_INDEX, "()Ljava/lang/Integer;", "setSource", "(Ljava/lang/Integer;)V", "account", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setAccount", "enough_callback", "e", "setEnough_callback", "bussiness_scene", "b", "setBussiness_scene", "recharge_source", com.amap.api.col.s.ce.f26391f, "setRecharge_source", "lack_money", "f", "setLack_money", "charge_reason", "d", "setCharge_reason", "callback_scheme", "c", "setCallback_scheme", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class sc {

    @SerializedName("account")
    private Integer account;

    @SerializedName("bussiness_scene")
    private Integer bussiness_scene;

    @SerializedName("callback_scheme")
    private String callback_scheme;

    @SerializedName("charge_reason")
    private String charge_reason;

    @SerializedName("enough_callback")
    private String enough_callback;

    @SerializedName("lack_money")
    private Integer lack_money;

    @SerializedName("recharge_source")
    private Integer recharge_source;

    @SerializedName("request_page")
    private String request_page;

    @SerializedName("source")
    private Integer source;

    public sc() {
    }

    public final Integer a() {
        return this.account;
    }

    public final Integer b() {
        return this.bussiness_scene;
    }

    public final String c() {
        return this.callback_scheme;
    }

    public final String d() {
        return this.charge_reason;
    }

    public final String e() {
        return this.enough_callback;
    }

    public final Integer f() {
        return this.lack_money;
    }

    public final Integer g() {
        return this.recharge_source;
    }

    public final String h() {
        return this.request_page;
    }

    public final Integer i() {
        return this.source;
    }
}
