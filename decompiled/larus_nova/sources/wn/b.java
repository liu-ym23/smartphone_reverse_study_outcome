package wn;

import com.bytedance.android.shopping.extensions.k;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lwn/b;", "", "", "schema", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "", "validDuration", "Ljava/lang/Long;", "getValidDuration", "()Ljava/lang/Long;", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Type f560430a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Gson f560431b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C8134b f560432c = null;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("expire_time")
    private final Long validDuration;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"wn/b$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "Lwn/b;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<Map<String, ? extends b>> {
        public a() {
        }
    }

    /* JADX INFO: renamed from: wn.b$b, reason: collision with other inner class name */
    public static final class C8134b {
        public C8134b() {
        }
    }

    static {
        f560432c = new C8134b();
        f560430a = new a().getType();
        f560431b = new Gson();
    }

    public b() {
        this.schema = null;
        this.validDuration = 0L;
    }

    public final long b() {
        return k.h(this.validDuration) * 1000;
    }

    public final String a() {
        return this.schema;
    }
}
