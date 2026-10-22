package sj3;

import com.amap.api.col.s.ce;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R(\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR(\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u001e¨\u0006!"}, d2 = {"Lsj3/e;", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "bgImgSingle", "Lcom/bytedance/android/ec/model/ECUrlModel;", "b", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "bgImgDouble", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lsj3/n;", "title", "Lsj3/n;", RXScreenCaptureService.KEY_INDEX, "()Lsj3/n;", "subTitle", ce.f26391f, "subTitleDouble", "h", "icon", "e", "Lsj3/d;", "button", "Lsj3/d;", "c", "()Lsj3/d;", "", "", "logExtra", "Ljava/util/Map;", "f", "()Ljava/util/Map;", "extra", "d", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("bg_img_double")
    private final ECUrlModel bgImgDouble;

    @SerializedName("bg_img_single")
    private final ECUrlModel bgImgSingle;

    @SerializedName("button")
    private final d button;

    @SerializedName("extra")
    private final Map<String, String> extra;

    @SerializedName("icon")
    private final ECUrlModel icon;

    @SerializedName("log_extra")
    private final Map<String, String> logExtra;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    private final n subTitle;

    @SerializedName("sub_title_double")
    private final n subTitleDouble;

    @SerializedName("title")
    private final n title;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L24;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.bgImgSingle, r101.bgImgSingle) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bgImgDouble, r101.bgImgDouble) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.subTitle, r101.subTitle) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.subTitleDouble, r101.subTitleDouble) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.button, r101.button) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.logExtra, r101.logExtra) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        ECUrlModel r100 = this.bgImgSingle;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ECUrlModel r104 = this.bgImgDouble;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        n r107 = this.title;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        n r110 = this.subTitle;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        n r113 = this.subTitleDouble;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        ECUrlModel r116 = this.icon;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        d r119 = this.button;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Map<String, String> r122 = this.logExtra;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Map<String, String> r125 = this.extra;
        if (r125 == null) goto L38;
        r101 = r125.hashCode();
    L38:
        return r124 + r101;
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
        return "ShopMemberDTO(bgImgSingle=" + this.bgImgSingle + ", bgImgDouble=" + this.bgImgDouble + ", title=" + this.title + ", subTitle=" + this.subTitle + ", subTitleDouble=" + this.subTitleDouble + ", icon=" + this.icon + ", button=" + this.button + ", logExtra=" + this.logExtra + ", extra=" + this.extra + ")";
    }

    public e() {
        this.bgImgSingle = null;
        this.bgImgDouble = null;
        this.title = null;
        this.subTitle = null;
        this.subTitleDouble = null;
        this.icon = null;
        this.button = null;
        this.logExtra = null;
        this.extra = null;
    }

    public final ECUrlModel a() {
        return this.bgImgDouble;
    }

    public final ECUrlModel b() {
        return this.bgImgSingle;
    }

    public final d c() {
        return this.button;
    }

    public final Map<String, String> d() {
        return this.extra;
    }

    public final ECUrlModel e() {
        return this.icon;
    }

    public final Map<String, String> f() {
        return this.logExtra;
    }

    public final n g() {
        return this.subTitle;
    }

    public final n h() {
        return this.subTitleDouble;
    }

    public final n i() {
        return this.title;
    }
}
