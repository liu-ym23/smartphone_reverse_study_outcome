package tm6;

import com.bytedance.locallife.common.utils.d;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Ltm6/b;", "", "", "event", "Ljava/lang/String;", "getEvent", "()Ljava/lang/String;", "paramsJson", "getParamsJson", "locallife-adapter-impl_release"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("event")
    private final String event;

    @SerializedName(AdDownloadEventConfig.JsonKey.PARAMS_JSON)
    private final String paramsJson;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.event, r101.event) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.paramsJson, r101.paramsJson) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.event.hashCode() * 31) + this.paramsJson.hashCode();
    }

    public final String toString() {
        return "DolphinParamsRequest(event=" + this.event + ", paramsJson=" + this.paramsJson + ')';
    }

    public b(int r100) {
        String r101 = d.c(new a(0));
        Intrinsics.checkNotNullParameter("life_saas_setting_libra", "event");
        Intrinsics.checkNotNullParameter(r101, "paramsJson");
        this.event = "life_saas_setting_libra";
        this.paramsJson = r101;
    }
}
