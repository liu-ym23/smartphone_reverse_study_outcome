package r43;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lr43/a;", "", "", "httpStatusCode", "Ljava/lang/Integer;", "getHttpStatusCode", "()Ljava/lang/Integer;", "c", "(Ljava/lang/Integer;)V", "statusCode", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "d", "", com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG, "Ljava/lang/String;", "b", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class a {

    @Expose(serialize = false)
    private Integer httpStatusCode;

    @SerializedName("status_code")
    private Integer statusCode;

    @SerializedName("status_msg")
    private String statusMsg;

    public a() {
    }

    public final Integer a() {
        return this.statusCode;
    }

    public final String b() {
        return this.statusMsg;
    }

    public final void c(Integer r100) {
        this.httpStatusCode = r100;
    }

    public final void d(Integer r100) {
        this.statusCode = r100;
    }

    public final void e(String r100) {
        this.statusMsg = r100;
    }
}
