package nv6;

import com.bytedance.android.live.base.model.UrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lnv6/z;", "", "", "atmosphereKey", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "Lcom/bytedance/android/live/base/model/UrlModel;", "dynamicAtmosphereIcon", "Lcom/bytedance/android/live/base/model/UrlModel;", "b", "()Lcom/bytedance/android/live/base/model/UrlModel;", "Lnv6/r0;", "showStrategy", "Lnv6/r0;", "c", "()Lnv6/r0;", "", "trackParams", "Ljava/util/Map;", "d", "()Ljava/util/Map;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class z {

    @SerializedName("atmosphere_key")
    private final String atmosphereKey;

    @SerializedName("dynamic_atmosphere_icon")
    private final UrlModel dynamicAtmosphereIcon;

    @SerializedName("show_strategy")
    private final r0 showStrategy;

    @SerializedName("track_params")
    private final Map<String, String> trackParams;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z) == true) goto L8;
        return false;
    L8:
        z r101 = (z) r100;
        if (Intrinsics.areEqual(this.atmosphereKey, r101.atmosphereKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.dynamicAtmosphereIcon, r101.dynamicAtmosphereIcon) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.showStrategy, r101.showStrategy) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.trackParams, r101.trackParams) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.atmosphereKey;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        UrlModel r104 = this.dynamicAtmosphereIcon;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        r0 r107 = this.showStrategy;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, String> r110 = this.trackParams;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LifeComponentAtmosphereInfo(atmosphereKey=" + this.atmosphereKey + ", dynamicAtmosphereIcon=" + this.dynamicAtmosphereIcon + ", showStrategy=" + this.showStrategy + ", trackParams=" + this.trackParams + ')';
    }

    public z() {
        this.atmosphereKey = null;
        this.dynamicAtmosphereIcon = null;
        this.showStrategy = null;
        this.trackParams = null;
    }

    public final String a() {
        return this.atmosphereKey;
    }

    public final UrlModel b() {
        return this.dynamicAtmosphereIcon;
    }

    public final r0 c() {
        return this.showStrategy;
    }

    public final Map<String, String> d() {
        return this.trackParams;
    }
}
