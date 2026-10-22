package yl2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lyl2/b;", "", "Lyl2/g;", "showGoodsDetail", "Lyl2/g;", "e", "()Lyl2/g;", "", "showShelf", "Ljava/lang/Boolean;", "g", "()Ljava/lang/Boolean;", "showAnchorShelf", "d", "Lyl2/h;", "showGoodsDetailMp", "Lyl2/h;", "f", "()Lyl2/h;", "Lyl2/c;", "autoOpenLiveLifeShelfTracker", "Lyl2/c;", "a", "()Lyl2/c;", "Lyl2/d;", "autoOpenShelfParams", "Lyl2/d;", "b", "()Lyl2/d;", "Lyl2/e;", "previewParams", "Lyl2/e;", "c", "()Lyl2/e;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("auto_open_live_life_shelf_tracker")
    private final c autoOpenLiveLifeShelfTracker;

    @SerializedName("auto_open_live_life_shelf_params")
    private final d autoOpenShelfParams;

    @SerializedName("preview_params")
    private final e previewParams;

    @SerializedName("auto_open_live_life_anchor_shelf")
    private final Boolean showAnchorShelf;

    @SerializedName("show_goods_detail")
    private final g showGoodsDetail;

    @SerializedName("show_goods_detail_mp")
    private final h showGoodsDetailMp;

    @SerializedName("auto_open_live_life_shelf")
    private final Boolean showShelf;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L20;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.showGoodsDetail, r4.showGoodsDetail) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.showShelf, r4.showShelf) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.showAnchorShelf, r4.showAnchorShelf) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.showGoodsDetailMp, r4.showGoodsDetailMp) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.autoOpenLiveLifeShelfTracker, r4.autoOpenLiveLifeShelfTracker) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.autoOpenShelfParams, r4.autoOpenShelfParams) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.previewParams, r4.previewParams) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        g r0 = this.showGoodsDetail;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.showShelf;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.showAnchorShelf;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        h r10 = this.showGoodsDetailMp;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        c r13 = this.autoOpenLiveLifeShelfTracker;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        d r16 = this.autoOpenShelfParams;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        e r19 = this.previewParams;
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
        return "LocalLifeParam(showGoodsDetail=" + this.showGoodsDetail + ", showShelf=" + this.showShelf + ", showAnchorShelf=" + this.showAnchorShelf + ", showGoodsDetailMp=" + this.showGoodsDetailMp + ", autoOpenLiveLifeShelfTracker=" + this.autoOpenLiveLifeShelfTracker + ", autoOpenShelfParams=" + this.autoOpenShelfParams + ", previewParams=" + this.previewParams + ")";
    }

    public b() {
        Boolean r0 = Boolean.FALSE;
        this.showGoodsDetail = null;
        this.showShelf = r0;
        this.showAnchorShelf = r0;
        this.showGoodsDetailMp = null;
        this.autoOpenLiveLifeShelfTracker = null;
        this.autoOpenShelfParams = null;
        this.previewParams = null;
    }

    public final c a() {
        return this.autoOpenLiveLifeShelfTracker;
    }

    public final d b() {
        return this.autoOpenShelfParams;
    }

    public final e c() {
        return this.previewParams;
    }

    public final Boolean d() {
        return this.showAnchorShelf;
    }

    public final g e() {
        return this.showGoodsDetail;
    }

    public final h f() {
        return this.showGoodsDetailMp;
    }

    public final Boolean g() {
        return this.showShelf;
    }
}
