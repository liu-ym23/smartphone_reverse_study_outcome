package ta0;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f¨\u0006\u001e"}, d2 = {"Lta0/c;", "", "", "status", "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", "setStatus", "(Ljava/lang/Integer;)V", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "exchange_session_id", "d", "setExchange_session_id", "added_diamonds", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setAdded_diamonds", "error_code", "b", "setError_code", "error_msg", "c", "setError_msg", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class c {

    @SerializedName("added_diamonds")
    private Integer added_diamonds;

    @SerializedName("error_code")
    private Integer error_code;

    @SerializedName("error_msg")
    private String error_msg;

    @SerializedName("exchange_session_id")
    private String exchange_session_id;

    @SerializedName("status")
    private Integer status;

    @SerializedName("type")
    private String type;

    public c() {
    }

    public final Integer a() {
        return this.added_diamonds;
    }

    public final Integer b() {
        return this.error_code;
    }

    public final String c() {
        return this.error_msg;
    }

    public final String d() {
        return this.exchange_session_id;
    }

    public final Integer e() {
        return this.status;
    }

    public final String getType() {
        return this.type;
    }
}
