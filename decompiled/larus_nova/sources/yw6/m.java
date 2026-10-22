package yw6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lyw6/m;", "", "", "statusCode", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "", com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG, "Ljava/lang/String;", "b", "()Ljava/lang/String;", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public class m {

    @SerializedName("status_code")
    private final int statusCode;

    @SerializedName("status_msg")
    private final String statusMsg;

    public m() {
        this(0);
    }

    public final int a() {
        return this.statusCode;
    }

    public final String b() {
        return this.statusMsg;
    }

    public m(int r100) {
        this.statusCode = 0;
        this.statusMsg = null;
    }
}
