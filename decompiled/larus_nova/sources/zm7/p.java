package zm7;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lzm7/p;", "", "", "state", "Ljava/lang/String;", "getState", "()Ljava/lang/String;", "stateDesc", "b", "schema", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "iconUrl", "getIconUrl", "extra", "getExtra", "luckyhost-api_release"}, k = 1, mv = {1, 4, 0})
public final class p {

    @SerializedName("extra")
    private final String extra;

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("state")
    private final String state;

    @SerializedName("state_desc")
    private final String stateDesc;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L16;
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.state, r101.state) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.stateDesc, r101.stateDesc) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.state;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.stateDesc;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.schema;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.iconUrl;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.extra;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
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
        return "StateContent(state=" + this.state + ", stateDesc=" + this.stateDesc + ", schema=" + this.schema + ", iconUrl=" + this.iconUrl + ", extra=" + this.extra + ")";
    }

    public final String a() {
        return this.schema;
    }

    public final String b() {
        return this.stateDesc;
    }
}
