package im;

import com.amap.api.col.s.ce;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.livehostapi.business.depend.livead.MiniAppConstants;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001a\u0010&\u001a\u00020%8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lim/v;", "", "", "roomId", "Ljava/lang/String;", RXScreenCaptureService.KEY_INDEX, "()Ljava/lang/String;", "title", ce.f26396k, "Lcom/bytedance/android/ec/model/ECUrlModel;", "cover", "Lcom/bytedance/android/ec/model/ECUrlModel;", "b", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "streamData", ce.f26395j, "enterUrl", "c", "anchorId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "popUrl", "h", "Lim/q;", "liveGift", "Lim/q;", "e", "()Lim/q;", "Lim/s;", "liveProduct", "Lim/s;", "f", "()Lim/s;", "", "liveType", "Ljava/lang/Integer;", ce.f26391f, "()Ljava/lang/Integer;", "", "hasLiveTab", "Z", "d", "()Z", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v {

    @SerializedName("anchor_id")
    private final String anchorId;

    @SerializedName("cover")
    private final ECUrlModel cover;

    @SerializedName("enter_url")
    private final String enterUrl;

    @SerializedName("has_live_tab")
    private final boolean hasLiveTab;

    @SerializedName("live_gift")
    private final q liveGift;

    @SerializedName("live_product")
    private final s liveProduct;

    @SerializedName("live_type")
    private final Integer liveType;

    @SerializedName("pop_url")
    private final String popUrl;

    @SerializedName("room_id")
    private final String roomId;

    @SerializedName(MiniAppConstants.KEY_MINI_APP_STREAM_DATA)
    private final String streamData;

    @SerializedName("title")
    private final String title;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof v) == false) goto L28;
        v r101 = (v) r100;
        if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.cover, r101.cover) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.streamData, r101.streamData) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.enterUrl, r101.enterUrl) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.anchorId, r101.anchorId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.popUrl, r101.popUrl) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.liveGift, r101.liveGift) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.liveProduct, r101.liveProduct) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.liveType, r101.liveType) == true) goto L26;
        return false;
    L26:
        if (this.hasLiveTab == r101.hasLiveTab) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r100 = this.roomId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.title;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ECUrlModel r107 = this.cover;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.streamData;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.enterUrl;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.anchorId;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.popUrl;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        q r122 = this.liveGift;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        s r125 = this.liveProduct;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.liveType;
        if (r128 == null) goto L41;
        r101 = r128.hashCode();
    L41:
        int r129 = (r127 + r101) * 31;
        boolean r130 = this.hasLiveTab;
        ?? r131 = r130;
        if (r130 == false) goto L45;
        r131 = 1;
    L45:
        return r129 + r131;
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
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
        return "StoreV3LiveRoomDTO(roomId=" + this.roomId + ", title=" + this.title + ", cover=" + this.cover + ", streamData=" + this.streamData + ", enterUrl=" + this.enterUrl + ", anchorId=" + this.anchorId + ", popUrl=" + this.popUrl + ", liveGift=" + this.liveGift + ", liveProduct=" + this.liveProduct + ", liveType=" + this.liveType + ", hasLiveTab=" + this.hasLiveTab + ")";
    }

    public v() {
        this.roomId = null;
        this.title = null;
        this.cover = null;
        this.streamData = null;
        this.enterUrl = null;
        this.anchorId = null;
        this.popUrl = null;
        this.liveGift = null;
        this.liveProduct = null;
        this.liveType = null;
        this.hasLiveTab = false;
    }

    public final String a() {
        return this.anchorId;
    }

    public final ECUrlModel b() {
        return this.cover;
    }

    public final String c() {
        return this.enterUrl;
    }

    public final boolean d() {
        return this.hasLiveTab;
    }

    public final q e() {
        return this.liveGift;
    }

    public final s f() {
        return this.liveProduct;
    }

    public final Integer g() {
        return this.liveType;
    }

    public final String h() {
        return this.popUrl;
    }

    public final String i() {
        return this.roomId;
    }

    public final String j() {
        return this.streamData;
    }

    public final String k() {
        return this.title;
    }
}
