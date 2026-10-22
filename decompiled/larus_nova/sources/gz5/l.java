package gz5;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u0017"}, d2 = {"Lgz5/l;", "", "", "warningType", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "effectExpression", "b", "conditionExpression", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "extraInfo", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "", "uploadALog", "Ljava/lang/Boolean;", "e", "()Ljava/lang/Boolean;", "filterEventExtraInfo", "d", "api_release"}, k = 1, mv = {1, 4, 0})
public final class l {

    @SerializedName("condition_expression")
    private final String conditionExpression;

    @SerializedName("effect_expression")
    private final String effectExpression;

    @SerializedName("extra_info")
    private final Map<String, String> extraInfo;

    @SerializedName("filter_event_extra_info")
    private final Boolean filterEventExtraInfo;

    @SerializedName("upload_alog")
    private final Boolean uploadALog;

    @SerializedName("warning_type")
    private final String warningType;

    public l() {
        this(null, null, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L18;
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.warningType, r101.warningType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.effectExpression, r101.effectExpression) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.conditionExpression, r101.conditionExpression) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extraInfo, r101.extraInfo) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.uploadALog, r101.uploadALog) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.filterEventExtraInfo, r101.filterEventExtraInfo) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.warningType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.effectExpression;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.conditionExpression;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, String> r110 = this.extraInfo;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.uploadALog;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.filterEventExtraInfo;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
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
        return "ControlConfig(warningType=" + this.warningType + ", effectExpression=" + this.effectExpression + ", conditionExpression=" + this.conditionExpression + ", extraInfo=" + this.extraInfo + ", uploadALog=" + this.uploadALog + ", filterEventExtraInfo=" + this.filterEventExtraInfo + ")";
    }

    public final String a() {
        return this.conditionExpression;
    }

    public final String b() {
        return this.effectExpression;
    }

    public final Map<String, String> c() {
        return this.extraInfo;
    }

    public final Boolean d() {
        return this.filterEventExtraInfo;
    }

    public final Boolean e() {
        return this.uploadALog;
    }

    public final String f() {
        return this.warningType;
    }

    public l(String r100, Map r101, Boolean r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        String r104 = "true";
    L7:
        if ((r103 & 4) == 0) goto L10;
        r100 = "true";
    L10:
        if ((r103 & 8) == 0) goto L13;
        r101 = null;
    L13:
        if ((r103 & 16) == 0) goto L15;
        r102 = null;
    L15:
        this.warningType = null;
        this.effectExpression = r104;
        this.conditionExpression = r100;
        this.extraInfo = r101;
        this.uploadALog = r102;
        this.filterEventExtraInfo = null;
        return;
    L5:
        r104 = null;
        goto L7
    }
}
