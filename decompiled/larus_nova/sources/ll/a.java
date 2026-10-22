package ll;

import com.bytedance.android.ec.model.live.ligo.DynamicType;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lll/a;", "", "", "regionName", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "dynamicType", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "templateUrl", "e", "regionParams", "c", "regionType", "d", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("dynamic_type")
    private final int dynamicType;

    @SerializedName("region_name")
    private final String regionName;

    @SerializedName("region_param")
    private final String regionParams;

    @SerializedName("region_type")
    private final int regionType;

    @SerializedName("template_url")
    private final String templateUrl;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.regionName, r101.regionName) == true) goto L8;
        return false;
    L8:
        if (this.dynamicType == r101.dynamicType) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.templateUrl, r101.templateUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.regionParams, r101.regionParams) == true) goto L14;
        return false;
    L14:
        if (this.regionType == r101.regionType) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.regionName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.dynamicType) * 31;
        String r104 = this.templateUrl;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.regionParams;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return ((r106 + r101) * 31) + this.regionType;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DynamicRegion(regionName=" + this.regionName + ", dynamicType=" + this.dynamicType + ", templateUrl=" + this.templateUrl + ", regionParams=" + this.regionParams + ", regionType=" + this.regionType + ")";
    }

    public final int a() {
        return this.dynamicType;
    }

    public final String b() {
        return this.regionName;
    }

    public final String c() {
        return this.regionParams;
    }

    public final int d() {
        return this.regionType;
    }

    public final String e() {
        return this.templateUrl;
    }

    public /* synthetic */ a(int r100) {
        this(null, DynamicType.UNKNOWN.getValue(), null, null, 0);
    }

    public a(String r100, int r101, String r102, String r103, int r104) {
        this.regionName = r100;
        this.dynamicType = r101;
        this.templateUrl = r102;
        this.regionParams = r103;
        this.regionType = r104;
    }
}
