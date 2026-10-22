package he3;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\"\u001a\u0004\u0018\u00010!8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lhe3/k0;", "", "Lhe3/e1;", "baseInfo", "Lhe3/e1;", "b", "()Lhe3/e1;", "", "", "trackInfo", "Ljava/util/Map;", "h", "()Ljava/util/Map;", "Lhe3/w0;", "custom", "Lhe3/w0;", "c", "()Lhe3/w0;", "Lhe3/h2;", "promotionInfo", "Lhe3/h2;", "f", "()Lhe3/h2;", "Lhe3/w;", "searchTagInfo", "Lhe3/w;", ce.f26391f, "()Lhe3/w;", "Lhe3/l0;", "preloadImage", "Lhe3/l0;", "e", "()Lhe3/l0;", "Lhe3/t;", "extra", "Lhe3/t;", "d", "()Lhe3/t;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k0 {

    @SerializedName("base_info")
    private final e1 baseInfo;

    @SerializedName("custom")
    private final w0 custom;

    @SerializedName("extra")
    private final t extra;

    @SerializedName("preload_image")
    private final l0 preloadImage;

    @SerializedName("promotion_info")
    private final h2 promotionInfo;

    @SerializedName("search_tag_points")
    private final w searchTagInfo;

    @SerializedName("track_info")
    private final Map<String, Object> trackInfo;

    public k0() {
        this(null, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k0) == false) goto L20;
        k0 r101 = (k0) r100;
        if (Intrinsics.areEqual(this.baseInfo, r101.baseInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.trackInfo, r101.trackInfo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.custom, r101.custom) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.promotionInfo, r101.promotionInfo) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.searchTagInfo, r101.searchTagInfo) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.preloadImage, r101.preloadImage) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        e1 r100 = this.baseInfo;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, Object> r104 = this.trackInfo;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        w0 r107 = this.custom;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        h2 r110 = this.promotionInfo;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        w r113 = this.searchTagInfo;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        l0 r116 = this.preloadImage;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        t r119 = this.extra;
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
        return "DeepFeedSlcNaData(baseInfo=" + this.baseInfo + ", trackInfo=" + this.trackInfo + ", custom=" + this.custom + ", promotionInfo=" + this.promotionInfo + ", searchTagInfo=" + this.searchTagInfo + ", preloadImage=" + this.preloadImage + ", extra=" + this.extra + ")";
    }

    public final e1 b() {
        return this.baseInfo;
    }

    public final w0 c() {
        return this.custom;
    }

    public final t d() {
        return this.extra;
    }

    public final l0 e() {
        return this.preloadImage;
    }

    public final h2 f() {
        return this.promotionInfo;
    }

    public final w g() {
        return this.searchTagInfo;
    }

    public final Map<String, Object> h() {
        return this.trackInfo;
    }

    public /* synthetic */ k0(h2 r100, int r110) {
        if ((r110 & 8) == 0) goto L5;
        r100 = null;
    L5:
        this(null, null, null, r100, null, null, null);
    }

    public static k0 a(k0 r100, h2 r101) {
        return new k0(r100.baseInfo, r100.trackInfo, r100.custom, r101, r100.searchTagInfo, r100.preloadImage, r100.extra);
    }

    public k0(e1 r100, Map<String, ? extends Object> r101, w0 r102, h2 r103, w r104, l0 r105, t r106) {
        this.baseInfo = r100;
        this.trackInfo = r101;
        this.custom = r102;
        this.promotionInfo = r103;
        this.searchTagInfo = r104;
        this.preloadImage = r105;
        this.extra = r106;
    }
}
