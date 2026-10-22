package ds6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0011R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR&\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u0003\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lds6/a;", "", "", "pitayaTraceId", "Ljava/lang/String;", "getPitayaTraceId", "()Ljava/lang/String;", "Lds6/b;", "pitayaCommonParam", "Lds6/b;", "getPitayaCommonParam", "()Lds6/b;", "", "lifeBusinessParam", "Ljava/util/Map;", "getLifeBusinessParam", "()Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("life_business_params")
    private final Map<String, ?> lifeBusinessParam;

    @SerializedName("pitaya_common_params")
    private final b pitayaCommonParam;

    @SerializedName("pitaya_trace_id")
    private final String pitayaTraceId;

    /* JADX INFO: renamed from: ds6.a$a, reason: collision with other inner class name */
    public static final class C5705a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.pitayaTraceId, r101.pitayaTraceId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(null, null) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.lifeBusinessParam, r101.lifeBusinessParam) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.pitayaTraceId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + 0) * 31;
        Map<String, ?> r104 = this.lifeBusinessParam;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "NearbyClientAiResponse(pitayaTraceId=" + this.pitayaTraceId + ", pitayaCommonParam=null, lifeBusinessParam=" + this.lifeBusinessParam + ')';
    }

    public a() {
        this.pitayaTraceId = null;
        this.lifeBusinessParam = null;
    }
}
