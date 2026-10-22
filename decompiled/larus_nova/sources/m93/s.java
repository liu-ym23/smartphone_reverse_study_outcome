package m93;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lm93/s;", "", "", "switchVersion", "Ljava/lang/Long;", "getSwitchVersion", "()Ljava/lang/Long;", "Lm93/b;", RuleConditionBean.BIZ_DATA_KEY, "Lm93/b;", "getBizData", "()Lm93/b;", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f512620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f512621b;

    @SerializedName("biz_data")
    private final b bizData;

    @SerializedName("switch_version")
    private final Long switchVersion;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof s) == false) goto L14;
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f512620a, r101.f512620a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f512621b, r101.f512621b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.switchVersion, r101.switchVersion) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bizData, r101.bizData) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Object r100 = this.f512620a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Object r104 = this.f512621b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.switchVersion;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        b r110 = this.bizData;
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
        return "NewerOneOffItem(items=" + this.f512620a + ", coupons=" + this.f512621b + ", switchVersion=" + this.switchVersion + ", bizData=" + this.bizData + ")";
    }

    public s() {
        this.f512620a = null;
        this.f512621b = null;
        this.switchVersion = null;
        this.bizData = null;
    }
}
