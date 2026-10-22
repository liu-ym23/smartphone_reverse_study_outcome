package w20;

import com.bytedance.bdp.appbase.settings.SettingsConstants;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lw20/p9;", "", "", "", "keys", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setKeys", "(Ljava/util/List;)V", SettingsConstants.SETTINGS_UPDATE_FROM, "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setRequest_from", "(Ljava/lang/String;)V", "<init>", "()V", "livehybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p9 {

    @SerializedName("keys")
    private List<String> keys;

    @SerializedName(SettingsConstants.SETTINGS_UPDATE_FROM)
    private String request_from;

    public p9() {
    }

    public final List<String> a() {
        return this.keys;
    }

    public final String b() {
        return this.request_from;
    }
}
