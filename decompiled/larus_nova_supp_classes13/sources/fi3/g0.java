package fi3;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lfi3/g0;", "", "", "pageName", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "actionName", "a", "rateType", "d", "", "category", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g0 {
    public static final /* synthetic */ int a = 0;

    @SerializedName("action_name")
    private final String actionName;

    @SerializedName("category")
    private final Map<String, Object> category;

    @SerializedName(PdpOpenThirdParam.KEY_PAGE_NAME)
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

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof g0) == false) goto L14;
        g0 r4 = (g0) r3;
        if (Intrinsics.areEqual(this.pageName, r4.pageName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.actionName, r4.actionName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.rateType, r4.rateType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.category, r4.category) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r0 = this.pageName;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.actionName;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.rateType;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Map<String, Object> r10 = this.category;
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

    public g0(String r1, String r2, String r3, Map<String, ? extends Object> r4) {
        this.pageName = r1;
        this.actionName = r2;
        this.rateType = r3;
        this.category = r4;
    }
}
