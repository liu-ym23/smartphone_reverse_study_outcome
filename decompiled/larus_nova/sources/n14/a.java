package n14;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Ln14/a;", "", "", "errNo", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "c", "(I)V", "", "errTips", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public class a {

    @SerializedName("err_no")
    private int errNo;

    @SerializedName("err_tips")
    private String errTips;

    public a() {
        this.errTips = "";
    }

    public final int a() {
        return this.errNo;
    }

    public final String b() {
        return this.errTips;
    }

    public final void c(int r100) {
        this.errNo = r100;
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.errTips = r100;
    }
}
