package z14;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR*\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lz14/a;", "", "", "vid", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setVid", "(Ljava/lang/String;)V", "auth", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setAuth", "token", "b", "setToken", "", "hosts", "Ljava/util/List;", "getHosts", "()Ljava/util/List;", "setHosts", "(Ljava/util/List;)V", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class a {

    @SerializedName("auth")
    private String auth;

    @SerializedName("hosts")
    private List<String> hosts;

    @SerializedName("token")
    private String token;

    @SerializedName("vid")
    private String vid;

    public a() {
    }

    public final String d() {
        List<String> r100 = this.hosts;
        Object r101 = null;
        if (r100 == null) goto L8;
        if (r100.size() <= 0) goto L8;
        r101 = ListProtector.get(r100, 0);
    L8:
        return (String) r101;
    }

    public final String a() {
        return this.auth;
    }

    public final String b() {
        return this.token;
    }

    public final String c() {
        return this.vid;
    }
}
