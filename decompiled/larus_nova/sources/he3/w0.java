package he3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\r"}, d2 = {"Lhe3/w0;", "", "", "subsideType", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "recommendInfo", "b", "entranceInfo", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class w0 {

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO)
    private final String entranceInfo;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO)
    private final String recommendInfo;

    @SerializedName("subside_type")
    private final String subsideType;

    public w0() {
    }

    public final String a() {
        return this.entranceInfo;
    }

    public final String b() {
        return this.recommendInfo;
    }

    public final String c() {
        return this.subsideType;
    }
}
