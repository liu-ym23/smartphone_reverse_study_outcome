package z43;

import com.bytedance.android.ecom.slice.ext.template.gecko.j;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR6\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R.\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u000b\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010¨\u0006\u0018"}, d2 = {"Lz43/b;", "", "", "enable", "Z", "b", "()Z", "setEnable", "(Z)V", "", "", "", "Lcom/bytedance/android/ecom/slice/ext/template/gecko/j;", "area", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "setArea", "(Ljava/util/Map;)V", "Lz43/a;", "scene", "c", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("area")
    private Map<String, ? extends List<j>> area;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("scene")
    private final Map<String, List<a>> scene;

    public b() {
    }

    public final Map<String, List<j>> a() {
        return this.area;
    }

    public final boolean b() {
        return this.enable;
    }

    public final Map<String, List<a>> c() {
        return this.scene;
    }
}
