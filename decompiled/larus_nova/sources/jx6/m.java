package jx6;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R(\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R(\u0010#\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u0017\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u001a\u001a\u0004\b$\u0010\u001cR\"\u0010%\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u001a\u001a\u0004\b&\u0010\u001cR\u001a\u0010(\u001a\u00020'8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+¨\u0006,"}, d2 = {"Ljx6/m;", "", "", "height", "I", "c", "()I", "", "needBounce", "Z", "getNeedBounce", "()Z", "Ljx6/a;", "actionCommonParams", "Ljx6/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljx6/a;", "", "", "trackingParams", "Ljava/util/Map;", "h", "()Ljava/util/Map;", "", "Ljx6/p;", "itemInfoList", "Ljava/util/List;", "d", "()Ljava/util/List;", "Ljx6/l;", "tabVO", "Ljx6/l;", ce.f26391f, "()Ljx6/l;", "Ljx6/b0;", "pointInfoList", "f", "containerPoint", "b", "", "pointDelayShowTime", "J", "e", "()J", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class m {

    @SerializedName("actionCommonParams")
    private final a actionCommonParams;

    @SerializedName("containerPoint")
    private final List<b0> containerPoint;

    @SerializedName("height")
    private final int height;

    @SerializedName("itemInfoList")
    private final List<p> itemInfoList;

    @SerializedName("needBounce")
    private final boolean needBounce;

    @SerializedName("pointDelayShowTime")
    private final long pointDelayShowTime;

    @SerializedName("pointInfoList")
    private final List<List<b0>> pointInfoList;

    @SerializedName("itemTabInfo")
    private final l tabVO;

    @SerializedName("trackingParams")
    private final Map<String, Object> trackingParams;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (this.height == r101.height) goto L12;
        return false;
    L12:
        if (this.needBounce == r101.needBounce) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.actionCommonParams, r101.actionCommonParams) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.trackingParams, r101.trackingParams) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.itemInfoList, r101.itemInfoList) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.tabVO, r101.tabVO) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.pointInfoList, r101.pointInfoList) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.containerPoint, r101.containerPoint) == true) goto L33;
        return false;
    L33:
        if (this.pointDelayShowTime == r101.pointDelayShowTime) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = this.height * 31;
        if (this.needBounce == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        a r103 = this.actionCommonParams;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        Map<String, Object> r107 = this.trackingParams;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<p> r110 = this.itemInfoList;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        l r113 = this.tabVO;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        List<List<b0>> r116 = this.pointInfoList;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        List<b0> r119 = this.containerPoint;
        if (r119 == null) goto L30;
        r104 = r119.hashCode();
    L30:
        long r120 = this.pointDelayShowTime;
        return ((r118 + r104) * 31) + ((int) (r120 ^ (r120 >>> 32)));
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
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "HeadImageVO(height=" + this.height + ", needBounce=" + this.needBounce + ", actionCommonParams=" + this.actionCommonParams + ", trackingParams=" + this.trackingParams + ", itemInfoList=" + this.itemInfoList + ", tabVO=" + this.tabVO + ", pointInfoList=" + this.pointInfoList + ", containerPoint=" + this.containerPoint + ", pointDelayShowTime=" + this.pointDelayShowTime + ')';
    }

    public m() {
        this.height = 0;
        this.needBounce = false;
        this.actionCommonParams = null;
        this.trackingParams = null;
        this.itemInfoList = null;
        this.tabVO = null;
        this.pointInfoList = null;
        this.containerPoint = null;
        this.pointDelayShowTime = 3000;
    }

    public final a a() {
        return this.actionCommonParams;
    }

    public final List<b0> b() {
        return this.containerPoint;
    }

    public final int c() {
        return this.height;
    }

    public final List<p> d() {
        return this.itemInfoList;
    }

    public final long e() {
        return this.pointDelayShowTime;
    }

    public final List<List<b0>> f() {
        return this.pointInfoList;
    }

    public final l g() {
        return this.tabVO;
    }

    public final Map<String, Object> h() {
        return this.trackingParams;
    }
}
