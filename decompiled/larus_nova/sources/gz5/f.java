package gz5;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001a"}, d2 = {"Lgz5/f;", "", "", "", "apiIds", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "", "resourceIds", "d", "Lgz5/p;", "frequencyConfig", "Lgz5/p;", "getFrequencyConfig", "()Lgz5/p;", "Lgz5/v;", "returnConfig", "Lgz5/v;", "e", "()Lgz5/v;", "Lgz5/l;", "monitorConfigs", "c", "blockConfigs", "b", "api_release"}, k = 1, mv = {1, 4, 0})
public final class f {

    @SerializedName("api_ids")
    private final List<Integer> apiIds;

    @SerializedName("block_configs")
    private final List<l> blockConfigs;

    @SerializedName("frequency_config")
    private final p frequencyConfig;

    @SerializedName("monitor_configs")
    private final List<l> monitorConfigs;

    @SerializedName(EffectConfiguration.KEY_RESOURCE_IDS)
    private final List<String> resourceIds;

    @SerializedName("return_config")
    private final v returnConfig;

    public f() {
        this(null, null, null, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L18;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.apiIds, r101.apiIds) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.resourceIds, r101.resourceIds) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.frequencyConfig, r101.frequencyConfig) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.returnConfig, r101.returnConfig) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.monitorConfigs, r101.monitorConfigs) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.blockConfigs, r101.blockConfigs) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        List<Integer> r100 = this.apiIds;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.resourceIds;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        p r107 = this.frequencyConfig;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        v r110 = this.returnConfig;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<l> r113 = this.monitorConfigs;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        List<l> r116 = this.blockConfigs;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
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
        return "ApiInfo(apiIds=" + this.apiIds + ", resourceIds=" + this.resourceIds + ", frequencyConfig=" + this.frequencyConfig + ", returnConfig=" + this.returnConfig + ", monitorConfigs=" + this.monitorConfigs + ", blockConfigs=" + this.blockConfigs + ")";
    }

    public final List<Integer> a() {
        return this.apiIds;
    }

    public final List<l> b() {
        return this.blockConfigs;
    }

    public final List<l> c() {
        return this.monitorConfigs;
    }

    public final List<String> d() {
        return this.resourceIds;
    }

    public final v e() {
        return this.returnConfig;
    }

    public f(List r100, List r101, List r102, List r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = CollectionsKt.emptyList();
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = CollectionsKt.emptyList();
    L9:
        if ((r104 & 16) == 0) goto L12;
        r102 = CollectionsKt.emptyList();
    L12:
        if ((r104 & 32) == 0) goto L14;
        r103 = CollectionsKt.emptyList();
    L14:
        this.apiIds = r100;
        this.resourceIds = r101;
        this.frequencyConfig = null;
        this.returnConfig = null;
        this.monitorConfigs = r102;
        this.blockConfigs = r103;
    }
}
