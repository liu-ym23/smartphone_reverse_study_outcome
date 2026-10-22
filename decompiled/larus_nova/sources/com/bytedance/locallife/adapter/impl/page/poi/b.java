package com.bytedance.locallife.adapter.impl.page.poi;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/locallife/adapter/impl/page/poi/b;", "", "", "isTranslucent", "Ljava/lang/Boolean;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Boolean;", "locallife-adapter-impl_release"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("local_life_poi_dito_translucent")
    private final Boolean isTranslucent;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.isTranslucent, ((b) r100).isTranslucent) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.isTranslucent;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "PoiDitoTranslucentSettingEntity(isTranslucent=" + this.isTranslucent + ')';
    }

    public final Boolean a() {
        return this.isTranslucent;
    }

    public b(Boolean r100) {
        this.isTranslucent = r100;
    }
}
