package hk3;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lhk3/c;", "", "Lcom/google/gson/JsonObject;", "allowList", "Lcom/google/gson/JsonObject;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/google/gson/JsonObject;", "", "default", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("allow_list")
    private final JsonObject allowList;

    /* JADX INFO: renamed from: default, reason: not valid java name */
    @SerializedName("default")
    private final Integer f1161default;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.allowList, r101.allowList) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f1161default, r101.f1161default) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        JsonObject r100 = this.allowList;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f1161default;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "TabSetting(allowList=" + this.allowList + ", default=" + this.f1161default + ")";
    }

    public c() {
        this.allowList = null;
        this.f1161default = null;
    }

    public final JsonObject a() {
        return this.allowList;
    }

    public final Integer b() {
        return this.f1161default;
    }
}
