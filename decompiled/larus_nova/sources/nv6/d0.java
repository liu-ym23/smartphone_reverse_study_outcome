package nv6;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R(\u0010$\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"Lnv6/d0;", "", "Lnv6/p0;", "showGoodsDetail", "Lnv6/p0;", "e", "()Lnv6/p0;", "", "showShelf", "Ljava/lang/Boolean;", ce.f26391f, "()Ljava/lang/Boolean;", "showAnchorShelf", "d", "Lnv6/q0;", "showGoodsDetailMp", "Lnv6/q0;", "f", "()Lnv6/q0;", "Lnv6/f0;", "autoOpenLiveLifeShelfTracker", "Lnv6/f0;", "b", "()Lnv6/f0;", "Lnv6/g0;", "autoOpenShelfParams", "Lnv6/g0;", "c", "()Lnv6/g0;", "Lnv6/i0;", "previewParams", "Lnv6/i0;", "getPreviewParams", "()Lnv6/i0;", "", "", "autoDrawTicketParams", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class d0 {

    @SerializedName("auto_draw_ticket_params")
    private final Map<String, Object> autoDrawTicketParams;

    @SerializedName("auto_open_live_life_shelf_tracker")
    private final f0 autoOpenLiveLifeShelfTracker;

    @SerializedName("auto_open_live_life_shelf_params")
    private final g0 autoOpenShelfParams;

    @SerializedName("preview_params")
    private final i0 previewParams;

    @SerializedName("auto_open_live_life_anchor_shelf")
    private final Boolean showAnchorShelf;

    @SerializedName("show_goods_detail")
    private final p0 showGoodsDetail;

    @SerializedName("show_goods_detail_mp")
    private final q0 showGoodsDetailMp;

    @SerializedName("auto_open_live_life_shelf")
    private final Boolean showShelf;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d0) == true) goto L8;
        return false;
    L8:
        d0 r101 = (d0) r100;
        if (Intrinsics.areEqual(this.showGoodsDetail, r101.showGoodsDetail) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.showShelf, r101.showShelf) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.showAnchorShelf, r101.showAnchorShelf) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.showGoodsDetailMp, r101.showGoodsDetailMp) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.autoOpenLiveLifeShelfTracker, r101.autoOpenLiveLifeShelfTracker) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.autoOpenShelfParams, r101.autoOpenShelfParams) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.previewParams, r101.previewParams) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.autoDrawTicketParams, r101.autoDrawTicketParams) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        p0 r100 = this.showGoodsDetail;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.showShelf;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.showAnchorShelf;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        q0 r110 = this.showGoodsDetailMp;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        f0 r113 = this.autoOpenLiveLifeShelfTracker;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        g0 r116 = this.autoOpenShelfParams;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        i0 r119 = this.previewParams;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Map<String, Object> r122 = this.autoDrawTicketParams;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
    L29:
        r120 = r119.hashCode();
        goto L30
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
        return "LocalLifeParam(showGoodsDetail=" + this.showGoodsDetail + ", showShelf=" + this.showShelf + ", showAnchorShelf=" + this.showAnchorShelf + ", showGoodsDetailMp=" + this.showGoodsDetailMp + ", autoOpenLiveLifeShelfTracker=" + this.autoOpenLiveLifeShelfTracker + ", autoOpenShelfParams=" + this.autoOpenShelfParams + ", previewParams=" + this.previewParams + ", autoDrawTicketParams=" + this.autoDrawTicketParams + ')';
    }

    public d0() {
        Boolean r100 = Boolean.FALSE;
        this.showGoodsDetail = null;
        this.showShelf = r100;
        this.showAnchorShelf = r100;
        this.showGoodsDetailMp = null;
        this.autoOpenLiveLifeShelfTracker = null;
        this.autoOpenShelfParams = null;
        this.previewParams = null;
        this.autoDrawTicketParams = null;
    }

    public final Map<String, Object> a() {
        return this.autoDrawTicketParams;
    }

    public final f0 b() {
        return this.autoOpenLiveLifeShelfTracker;
    }

    public final g0 c() {
        return this.autoOpenShelfParams;
    }

    public final Boolean d() {
        return this.showAnchorShelf;
    }

    public final p0 e() {
        return this.showGoodsDetail;
    }

    public final q0 f() {
        return this.showGoodsDetailMp;
    }

    public final Boolean g() {
        return this.showShelf;
    }
}
