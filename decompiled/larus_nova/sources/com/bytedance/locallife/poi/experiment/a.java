package com.bytedance.locallife.poi.experiment;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/locallife/poi/experiment/a;", "", "", "switchPoiAfterFmp", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("switch_poi_after_fmp")
    private final int switchPoiAfterFmp;

    public a() {
        this(0);
    }

    public final int a() {
        return this.switchPoiAfterFmp;
    }

    public a(int r100) {
        this.switchPoiAfterFmp = 0;
    }
}
