package gz5;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lgz5/o;", "", "", "", EffectConfiguration.KEY_RESOURCE_IDS, "Ljava/util/List;", "b", "()Ljava/util/List;", "fragments", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "api_release"}, k = 1, mv = {1, 4, 0})
public final class o {

    @SerializedName("fragments")
    private final List<String> fragments;

    @SerializedName(EffectConfiguration.KEY_RESOURCE_IDS)
    private final List<String> resource_ids;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == false) goto L10;
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.resource_ids, r101.resource_ids) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.fragments, r101.fragments) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<String> r100 = this.resource_ids;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.fragments;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "FragmentCheckModel(resource_ids=" + this.resource_ids + ", fragments=" + this.fragments + ")";
    }

    public o() {
        List<String> r100 = CollectionsKt.emptyList();
        List<String> r101 = CollectionsKt.emptyList();
        this.resource_ids = r100;
        this.fragments = r101;
    }

    public final List<String> a() {
        return this.fragments;
    }

    public final List<String> b() {
        return this.resource_ids;
    }
}
