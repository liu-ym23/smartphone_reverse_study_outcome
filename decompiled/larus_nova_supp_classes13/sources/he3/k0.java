package he3;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\"\u001a\u0004\u0018\u00010!8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lhe3/k0;", "", "Lhe3/e1;", "baseInfo", "Lhe3/e1;", "b", "()Lhe3/e1;", "", "", "trackInfo", "Ljava/util/Map;", "h", "()Ljava/util/Map;", "Lhe3/w0;", "custom", "Lhe3/w0;", "c", "()Lhe3/w0;", "Lhe3/h2;", "promotionInfo", "Lhe3/h2;", "f", "()Lhe3/h2;", "Lhe3/w;", "searchTagInfo", "Lhe3/w;", "g", "()Lhe3/w;", "Lhe3/l0;", "preloadImage", "Lhe3/l0;", "e", "()Lhe3/l0;", "Lhe3/t;", "extra", "Lhe3/t;", "d", "()Lhe3/t;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof k0) == false) goto L20;
        k0 r4 = (k0) r3;
        if (Intrinsics.areEqual(this.baseInfo, r4.baseInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.trackInfo, r4.trackInfo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.custom, r4.custom) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.promotionInfo, r4.promotionInfo) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.searchTagInfo, r4.searchTagInfo) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.preloadImage, r4.preloadImage) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.extra, r4.extra) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        e1 r0 = this.baseInfo;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Map<String, Object> r4 = this.trackInfo;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        w0 r7 = this.custom;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        h2 r10 = this.promotionInfo;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        w r13 = this.searchTagInfo;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        l0 r16 = this.preloadImage;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        t r19 = this.extra;
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

    public /* synthetic */ k0(h2 r9, int r10) {
        if ((r10 & 8) == 0) goto L5;
        r9 = null;
    L5:
        this(null, null, null, r9, null, null, null);
    }

    public static k0 a(k0 r8, h2 r9) {
        return new k0(r8.baseInfo, r8.trackInfo, r8.custom, r9, r8.searchTagInfo, r8.preloadImage, r8.extra);
    }

    public k0(e1 r1, Map<String, ? extends Object> r2, w0 r3, h2 r4, w r5, l0 r6, t r7) {
        this.baseInfo = r1;
        this.trackInfo = r2;
        this.custom = r3;
        this.promotionInfo = r4;
        this.searchTagInfo = r5;
        this.preloadImage = r6;
        this.extra = r7;
    }
}
