package ym;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007¨\u0006\f"}, d2 = {"Lym/a;", "", "", "", "custom", "Ljava/util/Map;", "getCustom", "()Ljava/util/Map;", "logExtra", "getLogExtra", "exendExtra", "getExendExtra", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("custom")
    private final Map<String, String> custom;

    @SerializedName("extend_info")
    private final Map<String, String> exendExtra;

    @SerializedName("log_extra")
    private final Map<String, String> logExtra;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.custom, r101.custom) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.logExtra, r101.logExtra) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.exendExtra, r101.exendExtra) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Map<String, String> r100 = this.custom;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, String> r104 = this.logExtra;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, String> r107 = this.exendExtra;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ShopStandProductDTO(custom=" + this.custom + ", logExtra=" + this.logExtra + ", exendExtra=" + this.exendExtra + ")";
    }

    public a() {
        this.custom = null;
        this.logExtra = null;
        this.exendExtra = null;
    }
}
