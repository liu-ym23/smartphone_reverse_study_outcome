package m14;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lm14/b;", "Ln14/a;", "Lm14/a;", "data", "Lm14/a;", "getData", "()Lm14/a;", "setData", "(Lm14/a;)V", "", "logId", "Ljava/lang/String;", "getLogId", "()Ljava/lang/String;", "setLogId", "(Ljava/lang/String;)V", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class b extends n14.a {

    @SerializedName("data")
    private a data;

    @SerializedName("log_id")
    private String logId;

    public b() {
        this.data = new a();
        this.logId = "";
    }
}
