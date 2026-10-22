package y9;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR.\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Ly9/p;", "", "", "disable", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "setDisable", "(I)V", "", "", "Ly9/p$a;", "whiteList", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "setWhiteList", "(Ljava/util/Map;)V", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class p {

    @SerializedName("disable")
    private int disable;

    @SerializedName("white_list")
    private Map<String, a> whiteList;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Ly9/p$a;", "", "", "mode", "I", "b", "()I", "setMode", "(I)V", "", "latchInitJs", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setLatchInitJs", "(Ljava/lang/String;)V", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("latch_init_js")
        private String latchInitJs;

        @SerializedName("mode")
        private int mode;

        /* JADX INFO: renamed from: y9.p$a$a, reason: collision with other inner class name */
        public static final class C8316a {
        }

        static {
        }

        public a() {
            this.latchInitJs = "";
        }

        public final String a() {
            return this.latchInitJs;
        }

        public final int b() {
            return this.mode;
        }
    }

    public p() {
        this.whiteList = MapsKt.emptyMap();
    }

    public final int a() {
        return this.disable;
    }

    public final Map<String, a> b() {
        return this.whiteList;
    }
}
