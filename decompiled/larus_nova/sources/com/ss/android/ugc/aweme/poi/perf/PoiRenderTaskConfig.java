package com.ss.android.ugc.aweme.poi.perf;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/perf/PoiRenderTaskConfig;", "", "", "", "lv1TaskList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "lv2TaskList", "b", "lv3TaskList", "c", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class PoiRenderTaskConfig {

    @SerializedName("lv1")
    private final List<String> lv1TaskList;

    @SerializedName("lv2")
    private final List<String> lv2TaskList;

    @SerializedName("lv3")
    private final List<String> lv3TaskList;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiRenderTaskConfig) == true) goto L8;
        return false;
    L8:
        PoiRenderTaskConfig r101 = (PoiRenderTaskConfig) r100;
        if (Intrinsics.areEqual(this.lv1TaskList, r101.lv1TaskList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lv2TaskList, r101.lv2TaskList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.lv3TaskList, r101.lv3TaskList) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        List<String> r100 = this.lv1TaskList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.lv2TaskList;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.lv3TaskList;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PoiRenderTaskConfig(lv1TaskList=" + this.lv1TaskList + ", lv2TaskList=" + this.lv2TaskList + ", lv3TaskList=" + this.lv3TaskList + ')';
    }

    public PoiRenderTaskConfig() {
        this.lv1TaskList = null;
        this.lv2TaskList = null;
        this.lv3TaskList = null;
    }

    public final List<String> a() {
        return this.lv1TaskList;
    }

    public final List<String> b() {
        return this.lv2TaskList;
    }

    public final List<String> c() {
        return this.lv3TaskList;
    }
}
