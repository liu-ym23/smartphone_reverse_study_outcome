package sj3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R&\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lsj3/d;", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "bgImg", "Lcom/bytedance/android/ec/model/ECUrlModel;", "b", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "Lsj3/n;", "text", "Lsj3/n;", "f", "()Lsj3/n;", "", "actionType", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "", "schema", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "couponMetaId", "d", "", "couponInfo", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("action_type")
    private final Integer actionType;

    @SerializedName("bg_img")
    private final ECUrlModel bgImg;

    @SerializedName("coupon_info")
    private final Map<String, String> couponInfo;

    @SerializedName("coupon_meta_id")
    private final String couponMetaId;

    @SerializedName("jump_schema")
    private final String schema;

    @SerializedName("text")
    private final n text;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d) == false) goto L18;
        d r4 = (d) r3;
        if (Intrinsics.areEqual(this.bgImg, r4.bgImg) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.text, r4.text) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.actionType, r4.actionType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.schema, r4.schema) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.couponMetaId, r4.couponMetaId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.couponInfo, r4.couponInfo) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        ECUrlModel r0 = this.bgImg;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        n r4 = this.text;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.actionType;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.schema;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.couponMetaId;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Map<String, String> r16 = this.couponInfo;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        return r15 + r1;
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
