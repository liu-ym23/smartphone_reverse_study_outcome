package sj3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R&\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lsj3/d;", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "bgImg", "Lcom/bytedance/android/ec/model/ECUrlModel;", "b", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "Lsj3/n;", "text", "Lsj3/n;", "f", "()Lsj3/n;", "", ReportConstant.COMMON_ACTION_TYPE, "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "", "schema", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "couponMetaId", "d", "", "couponInfo", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("action_type")
    private final Integer actionType;

    @SerializedName("bg_img")
    private final ECUrlModel bgImg;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_COUPON_INFO)
    private final Map<String, String> couponInfo;

    @SerializedName("coupon_meta_id")
    private final String couponMetaId;

    @SerializedName("jump_schema")
    private final String schema;

    @SerializedName("text")
    private final n text;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L18;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.bgImg, r101.bgImg) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.actionType, r101.actionType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.couponMetaId, r101.couponMetaId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.couponInfo, r101.couponInfo) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        ECUrlModel r100 = this.bgImg;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        n r104 = this.text;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.actionType;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.schema;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.couponMetaId;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Map<String, String> r116 = this.couponInfo;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
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
        return "ShopMemberButton(bgImg=" + this.bgImg + ", text=" + this.text + ", actionType=" + this.actionType + ", schema=" + this.schema + ", couponMetaId=" + this.couponMetaId + ", couponInfo=" + this.couponInfo + ")";
    }

    public final Integer a() {
        return this.actionType;
    }

    public final ECUrlModel b() {
        return this.bgImg;
    }

    public final Map<String, String> c() {
        return this.couponInfo;
    }

    public final String d() {
        return this.couponMetaId;
    }

    public final String e() {
        return this.schema;
    }

    public final n f() {
        return this.text;
    }
}
