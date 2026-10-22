package d93;

import com.google.gson.annotations.SerializedName;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR*\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0016"}, d2 = {"Ld93/b;", "", "", "eventToken", "Ljava/lang/String;", "getEventToken", "()Ljava/lang/String;", "setEventToken", "(Ljava/lang/String;)V", "eventName", "getEventName", "setEventName", "", "eventNameList", "Ljava/util/List;", "getEventNameList", "()Ljava/util/List;", "setEventNameList", "(Ljava/util/List;)V", "paramPattern", "getParamPattern", "setParamPattern", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName(ReportCardMonitorPlugin.EVENT_NAME)
    private String eventName;

    @SerializedName("event_name_list")
    private List<String> eventNameList;

    @SerializedName("token")
    private String eventToken;

    @SerializedName("param_pattern")
    private String paramPattern;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.eventToken, r101.eventToken) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.eventName, r101.eventName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.eventNameList, r101.eventNameList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.paramPattern, r101.paramPattern) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.eventToken;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.eventName;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.eventNameList;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.paramPattern;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "EventDefineDsl(eventToken=" + this.eventToken + ", eventName=" + this.eventName + ", eventNameList=" + this.eventNameList + ", paramPattern=" + this.paramPattern + ")";
    }

    public b() {
        this.eventToken = null;
        this.eventName = null;
        this.eventNameList = null;
        this.paramPattern = null;
    }
}
