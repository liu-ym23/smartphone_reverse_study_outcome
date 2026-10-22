package el;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lel/b;", "", "", "data", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setData", "(Ljava/lang/String;)V", "schema", "b", "setSchema", "", "showDuration", "Ljava/lang/Long;", "c", "()Ljava/lang/Long;", "setShowDuration", "(Ljava/lang/Long;)V", "", "showPriority", "Ljava/lang/Integer;", "d", "()Ljava/lang/Integer;", "setShowPriority", "(Ljava/lang/Integer;)V", "<init>", "()V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("data")
    private String data;

    @SerializedName("schema")
    private String schema;

    @SerializedName("show_duration")
    private Long showDuration;

    @SerializedName("show_priority")
    private Integer showPriority;

    public b() {
        this.showDuration = 0L;
        this.showPriority = 0;
    }

    public final String a() {
        return this.data;
    }

    public final String b() {
        return this.schema;
    }

    public final Long c() {
        return this.showDuration;
    }

    public final Integer d() {
        return this.showPriority;
    }
}
