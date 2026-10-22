package vj3;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R*\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lvj3/a;", "", "", "baseOnWidthDp", "Ljava/lang/Float;", "a", "()Ljava/lang/Float;", "", "enableClickDebounce", "Ljava/lang/Boolean;", "d", "()Ljava/lang/Boolean;", "", "clickInterval", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "", "", "customGlobalProps", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "viewScale", "getViewScale", "fontScale", "e", "imageBizTag", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L20;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.baseOnWidthDp, r4.baseOnWidthDp) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.enableClickDebounce, r4.enableClickDebounce) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.clickInterval, r4.clickInterval) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.customGlobalProps, r4.customGlobalProps) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.viewScale, r4.viewScale) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.fontScale, r4.fontScale) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.imageBizTag, r4.imageBizTag) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        Float r0 = this.baseOnWidthDp;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.enableClickDebounce;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.clickInterval;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Map<String, Object> r10 = this.customGlobalProps;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Float r13 = this.viewScale;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Float r16 = this.fontScale;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.imageBizTag;
        if (r19 == null) goto L30;
        r1 = r19.hashCode();
    L30:
        return r18 + r1;
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
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

    public a(Float r3, Float r4, Float r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 16) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 32) == 0) goto L11;
        r5 = null;
    L11:
        this.baseOnWidthDp = r3;
        this.enableClickDebounce = null;
        this.clickInterval = null;
        this.customGlobalProps = null;
        this.viewScale = r4;
        this.fontScale = r5;
        this.imageBizTag = null;
    }
}
