package gz5;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.effectmanager.effect.model.ComposerHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lgz5/v;", "", "", "defaultValue", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "Lgz5/c0;", "typeInfo", "Lgz5/c0;", "c", "()Lgz5/c0;", "defaultResult", "Ljava/lang/Object;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Object;", "api_release"}, k = 1, mv = {1, 4, 0})
public final class v {

    @SerializedName("default_result")
    private final Object defaultResult;

    @SerializedName(ComposerHelper.COMPOSER_DEFAULT_VALUE)
    private final String defaultValue;

    @SerializedName("type_info")
    private final c0 typeInfo;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof v) == false) goto L12;
        v r101 = (v) r100;
        if (Intrinsics.areEqual(this.defaultValue, r101.defaultValue) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.typeInfo, r101.typeInfo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.defaultResult, r101.defaultResult) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.defaultValue;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        c0 r104 = this.typeInfo;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Object r107 = this.defaultResult;
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
        return "ReturnConfig(defaultValue=" + this.defaultValue + ", typeInfo=" + this.typeInfo + ", defaultResult=" + this.defaultResult + ")";
    }

    public v() {
        this.defaultValue = null;
        this.typeInfo = null;
        this.defaultResult = null;
    }

    public final Object a() {
        return this.defaultResult;
    }

    public final String b() {
        return this.defaultValue;
    }

    public final c0 c() {
        return this.typeInfo;
    }
}
