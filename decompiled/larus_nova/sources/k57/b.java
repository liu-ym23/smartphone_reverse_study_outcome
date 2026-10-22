package k57;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lk57/b;", "", "data", "Ljava/lang/Object;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Object;", "", "error", "Ljava/lang/Throwable;", "getError", "()Ljava/lang/Throwable;", "live-kmp-platform-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class b {

    @SerializedName("data")
    private final Object data;

    @SerializedName("error")
    private final Throwable error;

    public final Object a() {
        return this.data;
    }

    public b(Object r100, Throwable r101) {
        this.data = r100;
        this.error = r101;
    }
}
