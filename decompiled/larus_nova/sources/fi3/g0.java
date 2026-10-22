package fi3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lfi3/g0;", "", "", "pageName", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "actionName", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "rateType", "d", "", "category", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f477264a = 0;

    @SerializedName("action_name")
    private final String actionName;

    @SerializedName("category")
    private final Map<String, Object> category;

    @SerializedName("page_name")
    private final String pageName;

    @SerializedName("rate_type")
    private final String rateType;

    public static final class a {
    }

    static {
    }

    public g0() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g0) == false) goto L14;
        g0 r101 = (g0) r100;
        if (Intrinsics.areEqual(this.pageName, r101.pageName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.actionName, r101.actionName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.rateType, r101.rateType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.category, r101.category) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.pageName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.actionName;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.rateType;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, Object> r110 = this.category;
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
        return "PdpActionRateParams(pageName=" + this.pageName + ", actionName=" + this.actionName + ", rateType=" + this.rateType + ", category=" + this.category + ")";
    }

    public final String a() {
        return this.actionName;
    }

    public final Map<String, Object> b() {
        return this.category;
    }

    public final String c() {
        return this.pageName;
    }

    public final String d() {
        return this.rateType;
    }

    public g0(String r100, String r101, String r102, Map<String, ? extends Object> r103) {
        this.pageName = r100;
        this.actionName = r101;
        this.rateType = r102;
        this.category = r103;
    }
}
