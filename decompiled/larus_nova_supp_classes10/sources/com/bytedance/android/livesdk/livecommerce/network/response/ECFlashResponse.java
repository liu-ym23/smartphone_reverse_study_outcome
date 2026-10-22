package com.bytedance.android.livesdk.livecommerce.network.response;

import com.bytedance.android.ec.model.g;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\"\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0093\u0001\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\u001c\b\u0002\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0010\u0018\u00010\u000b¢\u0006\u0004\b?\u0010@J\t\u0010\u0004\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0017\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bHÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0010\u0018\u00010\u000bHÆ\u0003J\u0095\u0001\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00032\u001c\b\u0002\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0010\u0018\u00010\u000bHÆ\u0001J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\u0013\u0010!\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003R\"\u0010\u0012\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010'\u001a\u0004\b\u0013\u0010(\"\u0004\b)\u0010*R$\u0010\u0014\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010+\u001a\u0004\b0\u0010-\"\u0004\b1\u0010/R$\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010+\u001a\u0004\b2\u0010-\"\u0004\b3\u0010/R0\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010\u0018\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010'\u001a\u0004\b\u0018\u0010(\"\u0004\b9\u0010*R\"\u0010\u0019\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010'\u001a\u0004\b\u0019\u0010(\"\u0004\b:\u0010*R\"\u0010\u001a\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\"\u001a\u0004\b;\u0010$\"\u0004\b<\u0010&R6\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0010\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u00104\u001a\u0004\b=\u00106\"\u0004\b>\u00108¨\u0006A"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/network/response/ECFlashResponse;", "Lcom/bytedance/android/ec/model/g;", "Ljava/io/Serializable;", "", "component1", "", "component2", "", "component3", "component4", "component5", "", "component6", "component7", "component8", "component9", "", "component10", "hasAuth", "isOpen", "shopId", "names", "ids", "properties", "isNewStyle", "isNeedBarCode", "lastBarCodeState", "properties_adapt_multi", "copy", "toString", "hashCode", "", "other", "equals", "I", "getHasAuth", "()I", "setHasAuth", "(I)V", "Z", "()Z", "setOpen", "(Z)V", "Ljava/lang/String;", "getShopId", "()Ljava/lang/String;", "setShopId", "(Ljava/lang/String;)V", "getNames", "setNames", "getIds", "setIds", "Ljava/util/Map;", "getProperties", "()Ljava/util/Map;", "setProperties", "(Ljava/util/Map;)V", "setNewStyle", "setNeedBarCode", "getLastBarCodeState", "setLastBarCodeState", "getProperties_adapt_multi", "setProperties_adapt_multi", "<init>", "(IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ZZILjava/util/Map;)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECFlashResponse extends g implements Serializable {

    @SerializedName("is_auth")
    private int hasAuth;

    @SerializedName("last_category_cids")
    private String ids;

    @SerializedName("sku_auth")
    private boolean isNeedBarCode;

    @SerializedName("has_auth")
    private boolean isNewStyle;

    @SerializedName("is_open")
    private boolean isOpen;

    @SerializedName("last_sku_state")
    private int lastBarCodeState;

    @SerializedName("last_category_name")
    private String names;

    @SerializedName("last_properties")
    private Map<String, String> properties;

    @SerializedName("last_properties_multi")
    private Map<String, ? extends List<String>> properties_adapt_multi;

    @SerializedName("shop_id")
    private String shopId;

    public ECFlashResponse() {
        this(0, false, null, null, null, null, false, false, 0, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECFlashResponse copy$default(ECFlashResponse r11, int r12, boolean r13, String r14, String r15, String r16, Map r17, boolean r18, boolean r19, int r20, Map r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        int r2 = r11.hasAuth;
    L7:
        if ((r22 & 2) == 0) goto L9;
        boolean r3 = r11.isOpen;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r4 = r11.shopId;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r5 = r11.names;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r6 = r11.ids;
    L23:
        if ((r22 & 32) == 0) goto L25;
        Map r7 = r11.properties;
    L27:
        if ((r22 & 64) == 0) goto L29;
        boolean r8 = r11.isNewStyle;
    L31:
        if ((r22 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) == 0) goto L33;
        boolean r9 = r11.isNeedBarCode;
    L35:
        if ((r22 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) == 0) goto L37;
        int r10 = r11.lastBarCodeState;
    L39:
        if ((r22 & DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE) == 0) goto L41;
        Map r1 = r11.properties_adapt_multi;
    L43:
        return r11.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L41:
        r1 = r21;
        goto L43
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    public final int component1() {
        return this.hasAuth;
    }

    public final Map<String, List<String>> component10() {
        return this.properties_adapt_multi;
    }

    public final boolean component2() {
        return this.isOpen;
    }

    public final String component3() {
        return this.shopId;
    }

    public final String component4() {
        return this.names;
    }

    public final String component5() {
        return this.ids;
    }

    public final Map<String, String> component6() {
        return this.properties;
    }

    public final boolean component7() {
        return this.isNewStyle;
    }

    public final boolean component8() {
        return this.isNeedBarCode;
    }

    public final int component9() {
        return this.lastBarCodeState;
    }

    public final ECFlashResponse copy(int r13, boolean r14, String r15, String r16, String r17, Map<String, String> r18, boolean r19, boolean r20, int r21, Map<String, ? extends List<String>> r22) {
        return new ECFlashResponse(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ECFlashResponse) == false) goto L26;
        ECFlashResponse r4 = (ECFlashResponse) r3;
        if (this.hasAuth == r4.hasAuth) goto L8;
        return false;
    L8:
        if (this.isOpen == r4.isOpen) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.shopId, r4.shopId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.names, r4.names) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.ids, r4.ids) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.properties, r4.properties) == true) goto L18;
        return false;
    L18:
        if (this.isNewStyle == r4.isNewStyle) goto L20;
        return false;
    L20:
        if (this.isNeedBarCode == r4.isNeedBarCode) goto L22;
        return false;
    L22:
        if (this.lastBarCodeState == r4.lastBarCodeState) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.properties_adapt_multi, r4.properties_adapt_multi) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int r0 = this.hasAuth * 31;
        boolean r1 = this.isOpen;
        ?? r2 = 1;
        ?? r3 = r1;
        if (r1 == false) goto L5;
        r3 = 1;
    L5:
        int r4 = (r0 + r3) * 31;
        String r5 = this.shopId;
        int r6 = 0;
        if (r5 == null) goto L8;
        int r7 = r5.hashCode();
    L9:
        int r8 = (r4 + r7) * 31;
        String r9 = this.names;
        if (r9 == null) goto L12;
        int r10 = r9.hashCode();
    L13:
        int r11 = (r8 + r10) * 31;
        String r12 = this.ids;
        if (r12 == null) goto L16;
        int r13 = r12.hashCode();
    L17:
        int r14 = (r11 + r13) * 31;
        Map<String, String> r15 = this.properties;
        if (r15 == null) goto L20;
        int r16 = r15.hashCode();
    L21:
        int r17 = (r14 + r16) * 31;
        boolean r18 = this.isNewStyle;
        ?? r19 = r18;
        if (r18 == false) goto L24;
        r19 = 1;
    L24:
        int r20 = (r17 + r19) * 31;
        boolean r21 = this.isNeedBarCode;
        if (r21 == true) goto L28;
        r2 = r21;
    L28:
        int r22 = (((r20 + r2) * 31) + this.lastBarCodeState) * 31;
        Map<String, ? extends List<String>> r23 = this.properties_adapt_multi;
        if (r23 == null) goto L32;
        r6 = r23.hashCode();
    L32:
        return r22 + r6;
    L20:
        r16 = 0;
        goto L21
    L16:
        r13 = 0;
        goto L17
    L12:
        r10 = 0;
        goto L13
    L8:
        r7 = 0;
        goto L9
    }

    public String toString() {
        return "ECFlashResponse(hasAuth=" + this.hasAuth + ", isOpen=" + this.isOpen + ", shopId=" + this.shopId + ", names=" + this.names + ", ids=" + this.ids + ", properties=" + this.properties + ", isNewStyle=" + this.isNewStyle + ", isNeedBarCode=" + this.isNeedBarCode + ", lastBarCodeState=" + this.lastBarCodeState + ", properties_adapt_multi=" + this.properties_adapt_multi + ")";
    }

    public final int getHasAuth() {
        return this.hasAuth;
    }

    public final String getIds() {
        return this.ids;
    }

    public final int getLastBarCodeState() {
        return this.lastBarCodeState;
    }

    public final String getNames() {
        return this.names;
    }

    public final Map<String, String> getProperties() {
        return this.properties;
    }

    public final Map<String, List<String>> getProperties_adapt_multi() {
        return this.properties_adapt_multi;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final boolean isNeedBarCode() {
        return this.isNeedBarCode;
    }

    public final boolean isNewStyle() {
        return this.isNewStyle;
    }

    public final boolean isOpen() {
        return this.isOpen;
    }

    public final void setHasAuth(int r1) {
        this.hasAuth = r1;
    }

    public final void setIds(String r1) {
        this.ids = r1;
    }

    public final void setLastBarCodeState(int r1) {
        this.lastBarCodeState = r1;
    }

    public final void setNames(String r1) {
        this.names = r1;
    }

    public final void setNeedBarCode(boolean r1) {
        this.isNeedBarCode = r1;
    }

    public final void setNewStyle(boolean r1) {
        this.isNewStyle = r1;
    }

    public final void setOpen(boolean r1) {
        this.isOpen = r1;
    }

    public final void setProperties(Map<String, String> r1) {
        this.properties = r1;
    }

    public final void setProperties_adapt_multi(Map<String, ? extends List<String>> r1) {
        this.properties_adapt_multi = r1;
    }

    public final void setShopId(String r1) {
        this.shopId = r1;
    }

    public ECFlashResponse(int r1, boolean r2, String r3, String r4, String r5, Map<String, String> r6, boolean r7, boolean r8, int r9, Map<String, ? extends List<String>> r10) {
        this.hasAuth = r1;
        this.isOpen = r2;
        this.shopId = r3;
        this.names = r4;
        this.ids = r5;
        this.properties = r6;
        this.isNewStyle = r7;
        this.isNeedBarCode = r8;
        this.lastBarCodeState = r9;
        this.properties_adapt_multi = r10;
    }

    public /* synthetic */ ECFlashResponse(int r13, boolean r14, String r15, String r16, String r17, Map r18, boolean r19, boolean r20, int r21, Map r22, int r23, DefaultConstructorMarker r24) {
        int r2 = 0;
        if ((r23 & 1) == 0) goto L5;
        int r1 = 0;
    L7:
        if ((r23 & 2) == 0) goto L9;
        boolean r3 = false;
    L10:
        Map r5 = null;
        if ((r23 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r23 & 8) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r23 & 16) == 0) goto L21;
        String r7 = null;
    L23:
        if ((r23 & 32) == 0) goto L25;
        Map r8 = null;
    L27:
        if ((r23 & 64) == 0) goto L29;
        boolean r9 = false;
    L31:
        if ((r23 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) == 0) goto L33;
        boolean r10 = false;
    L35:
        if ((r23 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) != 0) goto L39;
        r2 = r21;
    L39:
        if ((r23 & DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE) != 0) goto L42;
        r5 = r22;
    L42:
        this(r1, r3, r4, r6, r7, r8, r9, r10, r2, r5);
        return;
    L33:
        r10 = r20;
        goto L35
    L29:
        r9 = r19;
        goto L31
    L25:
        r8 = r18;
        goto L27
    L21:
        r7 = r17;
        goto L23
    L17:
        r6 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L10
    L5:
        r1 = r13;
        goto L7
    }
}
