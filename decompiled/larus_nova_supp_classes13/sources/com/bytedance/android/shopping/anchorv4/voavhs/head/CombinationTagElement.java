package com.bytedance.android.shopping.anchorv4.voavhs.head;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.matchpurchase.Point;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003J]\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006&"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/CombinationTagElement;", "Ljava/io/Serializable;", "icon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "title", "", "subTitle", "schema", "productId", "orientation", "position", "Lcom/bytedance/android/ec/model/response/anchorv3/matchpurchase/Point;", "(Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/response/anchorv3/matchpurchase/Point;)V", "getIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getOrientation", "()Ljava/lang/String;", "getPosition", "()Lcom/bytedance/android/ec/model/response/anchorv3/matchpurchase/Point;", "getProductId", "getSchema", "getSubTitle", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CombinationTagElement implements Serializable {

    @SerializedName("icon")
    private final ECUrlModel icon;

    @SerializedName("orientation")
    private final String orientation;

    @SerializedName("position")
    private final Point position;

    @SerializedName(PdpOpenThirdParam.KEY_PRODUCT_ID)
    private final String productId;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("sub_title")
    private final String subTitle;

    @SerializedName("title")
    private final String title;

    public CombinationTagElement() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ CombinationTagElement copy$default(CombinationTagElement r5, ECUrlModel r6, String r7, String r8, String r9, String r10, String r11, Point r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.icon;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.title;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.subTitle;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.schema;
    L14:
        String r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.productId;
    L17:
        String r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.orientation;
    L20:
        String r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.position;
    L23:
        ECUrlModel r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final ECUrlModel component1() {
        return this.icon;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.subTitle;
    }

    public final String component4() {
        return this.schema;
    }

    public final String component5() {
        return this.productId;
    }

    public final String component6() {
        return this.orientation;
    }

    public final Point component7() {
        return this.position;
    }

    public final CombinationTagElement copy(ECUrlModel r10, String r11, String r12, String r13, String r14, String r15, Point r16) {
        return new CombinationTagElement(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof CombinationTagElement) == false) goto L20;
        CombinationTagElement r4 = (CombinationTagElement) r3;
        if (Intrinsics.areEqual(this.icon, r4.icon) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.title, r4.title) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.subTitle, r4.subTitle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.schema, r4.schema) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.productId, r4.productId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.orientation, r4.orientation) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.position, r4.position) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        ECUrlModel r0 = this.icon;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.title;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.subTitle;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.schema;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.productId;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.orientation;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        Point r19 = this.position;
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

    public String toString() {
        return "CombinationTagElement(icon=" + this.icon + ", title=" + this.title + ", subTitle=" + this.subTitle + ", schema=" + this.schema + ", productId=" + this.productId + ", orientation=" + this.orientation + ", position=" + this.position + ")";
    }

    public final ECUrlModel getIcon() {
        return this.icon;
    }

    public final String getOrientation() {
        return this.orientation;
    }

    public final Point getPosition() {
        return this.position;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public CombinationTagElement(ECUrlModel r1, String r2, String r3, String r4, String r5, String r6, Point r7) {
        this.icon = r1;
        this.title = r2;
        this.subTitle = r3;
        this.schema = r4;
        this.productId = r5;
        this.orientation = r6;
        this.position = r7;
    }

    public /* synthetic */ CombinationTagElement(ECUrlModel r7, String r8, String r9, String r10, String r11, String r12, Point r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L5;
        ECUrlModel r16 = null;
    L7:
        if ((r14 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r14 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r14 & 8) == 0) goto L17;
        String r3 = null;
    L19:
        if ((r14 & 16) == 0) goto L21;
        String r4 = null;
    L23:
        if ((r14 & 32) == 0) goto L25;
        String r5 = null;
    L27:
        if ((r14 & 64) == 0) goto L29;
        Point r17 = null;
    L30:
        this(r16, r1, r2, r3, r4, r5, r17);
        return;
    L29:
        r17 = r13;
        goto L30
    L25:
        r5 = r12;
        goto L27
    L21:
        r4 = r11;
        goto L23
    L17:
        r3 = r10;
        goto L19
    L13:
        r2 = r9;
        goto L15
    L9:
        r1 = r8;
        goto L11
    L5:
        r16 = r7;
        goto L7
    }
}
