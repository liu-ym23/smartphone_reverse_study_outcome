package ss0;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Lss0/b;", "", "", "enable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setEnable", "(Z)V", "", "verticalScheme", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setVerticalScheme", "(Ljava/lang/String;)V", "horizontalScheme", "b", "setHorizontalScheme", "<init>", "()V", "live-profile-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("enabled")
    private boolean enable;

    @SerializedName("horizontal_schema")
    private String horizontalScheme;

    @SerializedName("vertical_schema")
    private String verticalScheme;

    public b() {
        this.verticalScheme = "";
        this.horizontalScheme = "";
    }

    public final boolean a() {
        return this.enable;
    }

    public final String b() {
        return this.horizontalScheme;
    }

    public final String c() {
        return this.verticalScheme;
    }
}
