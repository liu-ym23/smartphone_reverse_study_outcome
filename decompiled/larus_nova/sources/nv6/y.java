package nv6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lnv6/y;", "", "Lnv6/j;", "componentLevelConfig", "Lnv6/j;", "b", "()Lnv6/j;", "Lnv6/b;", "aggLevelConfig", "Lnv6/b;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lnv6/b;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class y {

    @SerializedName("agg_level_config")
    private final b aggLevelConfig;

    @SerializedName("component_level_config")
    private final j componentLevelConfig;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y) == true) goto L8;
        return false;
    L8:
        y r101 = (y) r100;
        if (Intrinsics.areEqual(this.componentLevelConfig, r101.componentLevelConfig) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.aggLevelConfig, r101.aggLevelConfig) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        j r100 = this.componentLevelConfig;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        b r104 = this.aggLevelConfig;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LevelConfig(componentLevelConfig=" + this.componentLevelConfig + ", aggLevelConfig=" + this.aggLevelConfig + ')';
    }

    public y() {
        this.componentLevelConfig = null;
        this.aggLevelConfig = null;
    }

    public final b a() {
        return this.aggLevelConfig;
    }

    public final j b() {
        return this.componentLevelConfig;
    }
}
