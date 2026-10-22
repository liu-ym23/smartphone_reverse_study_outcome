package sl;

import com.bytedance.map.api.monitor.MapMonitorConst;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR(\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lsl/q;", "", "", "promotionId", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "bizName", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "url", "e", "", "showTime", "J", "d", "()J", "", "eventParams", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class q {

    @SerializedName(MapMonitorConst.BIZ_NAME)
    private final String bizName;

    @SerializedName("event_params")
    private final Map<String, String> eventParams;

    @SerializedName("promotion_id")
    private final String promotionId;

    @SerializedName("showTime")
    private final long showTime;

    @SerializedName("url")
    private final String url;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q) == false) goto L16;
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.promotionId, r101.promotionId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bizName, r101.bizName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L12;
        return false;
    L12:
        if (this.showTime == r101.showTime) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.eventParams, r101.eventParams) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.promotionId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.bizName;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.url;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        long r110 = this.showTime;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        Map<String, String> r112 = this.eventParams;
        if (r112 == null) goto L18;
        r101 = r112.hashCode();
    L18:
        return r111 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ECShowPromotionCardGuide(promotionId=" + this.promotionId + ", bizName=" + this.bizName + ", url=" + this.url + ", showTime=" + this.showTime + ", eventParams=" + this.eventParams + ")";
    }

    public q() {
        this.promotionId = null;
        this.bizName = null;
        this.url = null;
        this.showTime = 3000;
        this.eventParams = null;
    }

    public final String a() {
        return this.bizName;
    }

    public final Map<String, String> b() {
        return this.eventParams;
    }

    public final String c() {
        return this.promotionId;
    }

    public final long d() {
        return this.showTime;
    }

    public final String e() {
        return this.url;
    }
}
