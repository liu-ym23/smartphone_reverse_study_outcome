package wm2;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lwm2/a;", "", "", "defaultValue", "Ljava/lang/String;", "getDefaultValue", "()Ljava/lang/String;", "setDefaultValue", "(Ljava/lang/String;)V", "optimizeValue", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setOptimizeValue", "darkValue", "getDarkValue", "setDarkValue", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a {

    @SerializedName("dark")
    private String darkValue;

    @SerializedName("default")
    private String defaultValue;

    @SerializedName("optimize")
    private String optimizeValue;

    public a() {
        this.defaultValue = "";
        this.optimizeValue = "";
        this.darkValue = "";
    }

    public final String a() {
        return this.optimizeValue;
    }
}
