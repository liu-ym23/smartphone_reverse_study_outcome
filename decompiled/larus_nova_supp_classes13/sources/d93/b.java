package d93;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR*\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0016"}, d2 = {"Ld93/b;", "", "", "eventToken", "Ljava/lang/String;", "getEventToken", "()Ljava/lang/String;", "setEventToken", "(Ljava/lang/String;)V", "eventName", "getEventName", "setEventName", "", "eventNameList", "Ljava/util/List;", "getEventNameList", "()Ljava/util/List;", "setEventNameList", "(Ljava/util/List;)V", "paramPattern", "getParamPattern", "setParamPattern", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("event_name")
    private String eventName;

    @SerializedName("event_name_list")
    private List<String> eventNameList;

    @SerializedName("token")
    private String eventToken;

    @SerializedName("param_pattern")
    private String paramPattern;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L14;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.eventToken, r4.eventToken) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.eventName, r4.eventName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.eventNameList, r4.eventNameList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.paramPattern, r4.paramPattern) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r0 = this.eventToken;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.eventName;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<String> r7 = this.eventNameList;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.paramPattern;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
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
