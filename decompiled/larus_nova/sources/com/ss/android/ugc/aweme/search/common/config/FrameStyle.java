package com.ss.android.ugc.aweme.search.common.config;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/config/FrameStyle;", "", "", "color", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "", "cornerRadius", FaceService.girlLabel, "b", "()F", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FrameStyle {

    @SerializedName("color")
    private final String color;

    @SerializedName("corner_radius")
    private final float cornerRadius;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof FrameStyle) == false) goto L10;
        FrameStyle r101 = (FrameStyle) r100;
        if (Intrinsics.areEqual(this.color, r101.color) == true) goto L8;
        return false;
    L8:
        if (Float.compare(this.cornerRadius, r101.cornerRadius) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.color;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (r101 * 31) + Float.floatToIntBits(this.cornerRadius);
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return "FrameStyle(color=" + this.color + ", cornerRadius=" + this.cornerRadius + ")";
    }

    public FrameStyle() {
        Intrinsics.checkNotNullParameter(CustomHeaderConfig.COLOR_LIGHT, "color");
        this.color = CustomHeaderConfig.COLOR_LIGHT;
        this.cornerRadius = 100.0f;
    }

    public final String a() {
        return this.color;
    }

    public final float b() {
        return this.cornerRadius;
    }
}
