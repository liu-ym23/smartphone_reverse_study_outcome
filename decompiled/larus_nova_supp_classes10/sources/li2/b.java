package li2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0005R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lli2/b;", "", "", "strategy", "I", "a", "()I", "setStrategy", "(I)V", "", "version", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setVersion", "(Ljava/lang/String;)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("strategy")
    private int strategy;

    @SerializedName("version")
    private String version;

    public static final class a {
    }

    static {
    }

    public b() {
        Intrinsics.checkNotNullParameter("10000", "version");
        this.strategy = 0;
        this.version = "10000";
    }

    public final int a() {
        return this.strategy;
    }

    public final String b() {
        return this.version;
    }
}
