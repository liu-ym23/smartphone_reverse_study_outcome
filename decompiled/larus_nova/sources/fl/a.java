package fl;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b-\u0010.R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R$\u0010\u001d\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R$\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010*\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0015\u001a\u0004\b+\u0010\u0017\"\u0004\b,\u0010\u0019¨\u0006/"}, d2 = {"Lfl/a;", "", "", "doAttribution", "Ljava/lang/Boolean;", "getDoAttribution", "()Ljava/lang/Boolean;", "setDoAttribution", "(Ljava/lang/Boolean;)V", "shouldPrefetch", "getShouldPrefetch", "setShouldPrefetch", "", "timestamp", "Ljava/lang/Long;", "getTimestamp", "()Ljava/lang/Long;", "setTimestamp", "(Ljava/lang/Long;)V", "", "validDur", "Ljava/lang/Integer;", "getValidDur", "()Ljava/lang/Integer;", "setValidDur", "(Ljava/lang/Integer;)V", "invalidSec", "getInvalidSec", "setInvalidSec", "reinitValidDur", "getReinitValidDur", "setReinitValidDur", "enableReinitValid", "getEnableReinitValid", "setEnableReinitValid", "Lorg/json/JSONObject;", "ptyAlgInfo", "Lorg/json/JSONObject;", "getPtyAlgInfo", "()Lorg/json/JSONObject;", "setPtyAlgInfo", "(Lorg/json/JSONObject;)V", "code", "getCode", "setCode", "<init>", "()V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("code")
    private Integer code;

    @SerializedName("do_attribution")
    private Boolean doAttribution;

    @SerializedName("enable_reinit_valid")
    private Boolean enableReinitValid;

    @SerializedName("invalid_sec")
    private Integer invalidSec;

    @SerializedName("pty_alg_info")
    private JSONObject ptyAlgInfo;

    @SerializedName("reinit_valid_dur")
    private Integer reinitValidDur;

    @SerializedName("should_prefetch")
    private Boolean shouldPrefetch;

    @SerializedName("timestamp")
    private Long timestamp;

    @SerializedName("valid_dur")
    private Integer validDur;

    public a() {
    }
}
