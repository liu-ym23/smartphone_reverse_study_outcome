package sp6;

import com.amap.api.col.s.ce;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u0016R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006R\u001c\u0010 \u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006R\u001a\u0010\"\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\u0014\u001a\u0004\b#\u0010\u0016¨\u0006$"}, d2 = {"Lsp6/e;", "", "", "x", "Ljava/lang/String;", ce.f26395j, "()Ljava/lang/String;", "y", ce.f26396k, "width", RXScreenCaptureService.KEY_INDEX, "height", "b", "", "wh_ratio", FaceService.girlLabel, "h", "()F", "", "gradientDirection", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "", "itemBgColor", "Ljava/util/List;", "c", "()Ljava/util/List;", "itemCorner", "d", "repeatMarginX", "e", "repeatMarginY", "f", "repeatTimes", ce.f26391f, "dito-common-saas_release"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("gradient_direction")
    private final int gradientDirection;

    @SerializedName("height")
    private final String height;

    @SerializedName("item_color")
    private final List<String> itemBgColor;

    @SerializedName("item_corner")
    private final int itemCorner;

    @SerializedName("repeat_margin_x")
    private final String repeatMarginX;

    @SerializedName("repeat_margin_y")
    private final String repeatMarginY;

    @SerializedName("repeat_times")
    private final int repeatTimes;

    @SerializedName("wh_ratio")
    private final float wh_ratio;

    @SerializedName("width")
    private final String width;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @SerializedName("x")
    private final String f542901x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @SerializedName("y")
    private final String f542902y;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f542901x, r101.f542901x) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f542902y, r101.f542902y) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.width, r101.width) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L21;
        return false;
    L21:
        if (Float.compare(this.wh_ratio, r101.wh_ratio) == 0) goto L24;
        return false;
    L24:
        if (this.gradientDirection == r101.gradientDirection) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.itemBgColor, r101.itemBgColor) == true) goto L30;
        return false;
    L30:
        if (this.itemCorner == r101.itemCorner) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.repeatMarginX, r101.repeatMarginX) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.repeatMarginY, r101.repeatMarginY) == true) goto L39;
        return false;
    L39:
        if (this.repeatTimes == r101.repeatTimes) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f542901x;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f542902y;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.width;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.height;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (((((r109 + r111) * 31) + Float.floatToIntBits(this.wh_ratio)) * 31) + this.gradientDirection) * 31;
        List<String> r113 = this.itemBgColor;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (((r112 + r114) * 31) + this.itemCorner) * 31;
        String r116 = this.repeatMarginX;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.repeatMarginY;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return ((r118 + r101) * 31) + this.repeatTimes;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "SkeletonItemModel(x=" + this.f542901x + ", y=" + this.f542902y + ", width=" + this.width + ", height=" + this.height + ", wh_ratio=" + this.wh_ratio + ", gradientDirection=" + this.gradientDirection + ", itemBgColor=" + this.itemBgColor + ", itemCorner=" + this.itemCorner + ", repeatMarginX=" + this.repeatMarginX + ", repeatMarginY=" + this.repeatMarginY + ", repeatTimes=" + this.repeatTimes + ')';
    }

    public e() {
        this.f542901x = null;
        this.f542902y = null;
        this.width = null;
        this.height = null;
        this.wh_ratio = 0.0f;
        this.gradientDirection = 1;
        this.itemBgColor = null;
        this.itemCorner = 0;
        this.repeatMarginX = null;
        this.repeatMarginY = null;
        this.repeatTimes = 0;
    }

    public final int a() {
        return this.gradientDirection;
    }

    public final String b() {
        return this.height;
    }

    public final List<String> c() {
        return this.itemBgColor;
    }

    public final int d() {
        return this.itemCorner;
    }

    public final String e() {
        return this.repeatMarginX;
    }

    public final String f() {
        return this.repeatMarginY;
    }

    public final int g() {
        return this.repeatTimes;
    }

    public final float h() {
        return this.wh_ratio;
    }

    public final String i() {
        return this.width;
    }

    public final String j() {
        return this.f542901x;
    }

    public final String k() {
        return this.f542902y;
    }
}
