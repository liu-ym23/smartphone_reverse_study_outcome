package rd3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u000f¨\u0006\u001b"}, d2 = {"Lrd3/o;", "", "", "id", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "title", "getTitle", SocialConstants.PARAM_APP_DESC, "getDesc", "Lcom/bytedance/android/ec/model/ECUrlModel;", "cover", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getCover", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "subTitle", "getSubTitle", "Lrd3/d;", "boardTypeInfo", "Lrd3/d;", "getBoardTypeInfo", "()Lrd3/d;", "link", "getLink", "typeIcon", "getTypeIcon", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o {

    @SerializedName("board_type_info")
    private final d boardTypeInfo;

    @SerializedName("cover")
    private final ECUrlModel cover;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private final String desc;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f537258id;

    @SerializedName("link")
    private final String link;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    private final String subTitle;

    @SerializedName("title")
    private final String title;

    @SerializedName("type_icon")
    private final ECUrlModel typeIcon;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == false) goto L22;
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f537258id, r101.f537258id) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cover, r101.cover) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.subTitle, r101.subTitle) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.boardTypeInfo, r101.boardTypeInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.link, r101.link) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.typeIcon, r101.typeIcon) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f537258id;
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
        String r107 = this.desc;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        ECUrlModel r110 = this.cover;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.subTitle;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        d r116 = this.boardTypeInfo;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.link;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        ECUrlModel r122 = this.typeIcon;
        if (r122 == null) goto L34;
        r101 = r122.hashCode();
    L34:
        return r121 + r101;
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
        return "Rank(id=" + this.f537258id + ", title=" + this.title + ", desc=" + this.desc + ", cover=" + this.cover + ", subTitle=" + this.subTitle + ", boardTypeInfo=" + this.boardTypeInfo + ", link=" + this.link + ", typeIcon=" + this.typeIcon + ")";
    }

    public o() {
        this.f537258id = null;
        this.title = null;
        this.desc = null;
        this.cover = null;
        this.subTitle = null;
        this.boardTypeInfo = null;
        this.link = null;
        this.typeIcon = null;
    }

    public final String a() {
        return this.f537258id;
    }
}
