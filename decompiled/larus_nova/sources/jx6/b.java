package jx6;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Ljx6/b;", "", "", ReportConstant.COMMON_ACTION_TYPE, "Ljava/lang/String;", "b", "()Ljava/lang/String;", "Lcom/google/gson/JsonObject;", "actionParams", "Lcom/google/gson/JsonObject;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/google/gson/JsonObject;", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("actionParams")
    private final JsonObject actionParams;

    @SerializedName(ReportConstant.COMMON_ACTION_TYPE)
    private final String actionType;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.actionType, r101.actionType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.actionParams, r101.actionParams) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.actionType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        JsonObject r104 = this.actionParams;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ActionInfo(actionType=" + this.actionType + ", actionParams=" + this.actionParams + ')';
    }

    public b() {
        this.actionType = null;
        this.actionParams = null;
    }

    public final JsonObject a() {
        return this.actionParams;
    }

    public final String b() {
        return this.actionType;
    }
}
