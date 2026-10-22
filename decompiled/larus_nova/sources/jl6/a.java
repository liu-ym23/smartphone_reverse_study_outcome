package jl6;

import com.bytedance.locallife.ability.model.AbilityInfo;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Ljl6/a;", "", "", "", "Lcom/bytedance/locallife/ability/model/AbilityInfo;", "abilityMap", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "", "abilityEnable", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "locallife-ability-api_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("ability_enable")
    private final int abilityEnable;

    @SerializedName("ability_map")
    private final Map<String, AbilityInfo> abilityMap;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.abilityMap, r101.abilityMap) == true) goto L12;
        return false;
    L12:
        if (this.abilityEnable == r101.abilityEnable) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.abilityMap.hashCode() * 31) + this.abilityEnable;
    }

    public final String toString() {
        return "AbilityControlValue(abilityMap=" + this.abilityMap + ", abilityEnable=" + this.abilityEnable + ')';
    }

    public final int a() {
        return this.abilityEnable;
    }

    public final Map<String, AbilityInfo> b() {
        return this.abilityMap;
    }

    public a(Map<String, AbilityInfo> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "abilityMap");
        this.abilityMap = r100;
        this.abilityEnable = r101;
    }
}
