package vj3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R*\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lvj3/a;", "", "", "baseOnWidthDp", "Ljava/lang/Float;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Float;", "", "enableClickDebounce", "Ljava/lang/Boolean;", "d", "()Ljava/lang/Boolean;", "", "clickInterval", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "", "", "customGlobalProps", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "viewScale", "getViewScale", "fontScale", "e", "imageBizTag", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("scale_logical_width_base")
    private final Float baseOnWidthDp;

    @SerializedName("click_interval_time")
    private final Integer clickInterval;

    @SerializedName("custom_global_props")
    private final Map<String, Object> customGlobalProps;

    @SerializedName("enable_click_debounce")
    private final Boolean enableClickDebounce;

    @SerializedName("font_scale_ratio")
    private final Float fontScale;

    @SerializedName("image_biz_tag")
    private final String imageBizTag;

    @SerializedName("view_scale_ratio")
    private final Float viewScale;

    public a() {
        this(null, null, null, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L20;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.baseOnWidthDp, r101.baseOnWidthDp) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.enableClickDebounce, r101.enableClickDebounce) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.clickInterval, r101.clickInterval) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.customGlobalProps, r101.customGlobalProps) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.viewScale, r101.viewScale) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.fontScale, r101.fontScale) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.imageBizTag, r101.imageBizTag) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        Float r100 = this.baseOnWidthDp;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.enableClickDebounce;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.clickInterval;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, Object> r110 = this.customGlobalProps;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Float r113 = this.viewScale;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Float r116 = this.fontScale;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.imageBizTag;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
    L25:
        r117 = 0;
        goto L26
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
        return "SliceConfigData(baseOnWidthDp=" + this.baseOnWidthDp + ", enableClickDebounce=" + this.enableClickDebounce + ", clickInterval=" + this.clickInterval + ", customGlobalProps=" + this.customGlobalProps + ", viewScale=" + this.viewScale + ", fontScale=" + this.fontScale + ", imageBizTag=" + this.imageBizTag + ")";
    }

    public final Float a() {
        return this.baseOnWidthDp;
    }

    public final Integer b() {
        return this.clickInterval;
    }

    public final Map<String, Object> c() {
        return this.customGlobalProps;
    }

    public final Boolean d() {
        return this.enableClickDebounce;
    }

    public final Float e() {
        return this.fontScale;
    }

    public final String f() {
        return this.imageBizTag;
    }

    public a(Float r100, Float r101, Float r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 16) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 32) == 0) goto L11;
        r102 = null;
    L11:
        this.baseOnWidthDp = r100;
        this.enableClickDebounce = null;
        this.clickInterval = null;
        this.customGlobalProps = null;
        this.viewScale = r101;
        this.fontScale = r102;
        this.imageBizTag = null;
    }
}
