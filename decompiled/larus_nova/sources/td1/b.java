package td1;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Ltd1/b;", "", "", "disable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setDisable", "(Z)V", "", "disableTip", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setDisableTip", "(Ljava/lang/String;)V", "disableToast", "c", "setDisableToast", "", "disableType", "J", "d", "()J", "setDisableType", "(J)V", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("disable")
    private boolean disable;

    @SerializedName("disable_tip")
    private String disableTip;

    @SerializedName("disable_toast")
    private String disableToast;

    @SerializedName("disable_type")
    private long disableType;

    public static final class a {
    }

    static {
    }

    public b() {
    }

    public final boolean a() {
        return this.disable;
    }

    public final String b() {
        return this.disableTip;
    }

    public final String c() {
        return this.disableToast;
    }

    public final long d() {
        return this.disableType;
    }
}
