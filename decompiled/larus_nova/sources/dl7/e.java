package dl7;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\r"}, d2 = {"Ldl7/e;", "", "", "status", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "text", "c", "shortText", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "<init>", "()V", "luckydog-api_release"}, k = 1, mv = {1, 4, 0})
public final class e {

    @SerializedName("short_text")
    private final String shortText;

    @SerializedName("status")
    private final String status;

    @SerializedName("text")
    private final String text;

    public e() {
    }

    public final String toString() {
        return "PendantContent(status=" + this.status + ", text=" + this.text + ", shortText=" + this.shortText + ')';
    }

    public final String a() {
        return this.shortText;
    }

    public final String b() {
        return this.status;
    }

    public final String c() {
        return this.text;
    }
}
