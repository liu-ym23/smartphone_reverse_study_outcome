package com.bytedance.android.shopping.slice.action.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u001c\b\u0086\b\u0018\u0000 12\u00020\u0001:\u00012BW\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\u0018\b\u0002\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f¢\u0006\u0004\b/\u00100J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0019\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fHÆ\u0003JY\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0018\b\u0002\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fHÆ\u0001J\t\u0010\u0016\u001a\u00020\bHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\rHÖ\u0003R\u001a\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b\u001e\u0010\u001dR\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b#\u0010$R$\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R2\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00063"}, d2 = {"Lcom/bytedance/android/shopping/slice/action/entity/PDPBuyWithoutCheckParam;", "Ljava/io/Serializable;", "", "secKillActivityOnGoing", "", "component1", "component2", "component3", "", "component4", "Lcom/bytedance/android/ec/core/btm/a;", "component5", "", "", "component6", "secActivityBeginTime", "secActivityEndTime", "hasSecActivity", "orderUrl", "btmFields", "updateParams", "copy", "toString", "", "hashCode", "other", "equals", "J", "getSecActivityBeginTime", "()J", "getSecActivityEndTime", "Z", "getHasSecActivity", "()Z", "Ljava/lang/String;", "getOrderUrl", "()Ljava/lang/String;", "Lcom/bytedance/android/ec/core/btm/a;", "getBtmFields", "()Lcom/bytedance/android/ec/core/btm/a;", "setBtmFields", "(Lcom/bytedance/android/ec/core/btm/a;)V", "Ljava/util/Map;", "getUpdateParams", "()Ljava/util/Map;", "setUpdateParams", "(Ljava/util/Map;)V", "<init>", "(JJZLjava/lang/String;Lcom/bytedance/android/ec/core/btm/a;Ljava/util/Map;)V", "Companion", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PDPBuyWithoutCheckParam implements Serializable {
    public static final a Companion = null;

    @SerializedName("btm_fields")
    private com.bytedance.android.ec.core.btm.a btmFields;

    @SerializedName("has_sec_activity")
    private final boolean hasSecActivity;

    @SerializedName(PdpOpenThirdParam.KEY_ORDER_URL)
    private final String orderUrl;

    @SerializedName("sec_activity_begin_time")
    private final long secActivityBeginTime;

    @SerializedName("sec_activity_end_time")
    private final long secActivityEndTime;

    @SerializedName("update_params")
    private Map<String, ? extends Object> updateParams;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PDPBuyWithoutCheckParam() {
        this(0, 0, false, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PDPBuyWithoutCheckParam copy$default(PDPBuyWithoutCheckParam r9, long r10, long r12, boolean r14, String r15, com.bytedance.android.ec.core.btm.a r16, Map r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        long r1 = r9.secActivityBeginTime;
    L7:
        if ((r18 & 2) == 0) goto L9;
        long r3 = r9.secActivityEndTime;
    L11:
        if ((r18 & 4) == 0) goto L13;
        boolean r5 = r9.hasSecActivity;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r6 = r9.orderUrl;
    L19:
        if ((r18 & 16) == 0) goto L21;
        com.bytedance.android.ec.core.btm.a r7 = r9.btmFields;
    L23:
        if ((r18 & 32) == 0) goto L25;
        Map r8 = r9.updateParams;
    L27:
        return r9.copy(r1, r3, r5, r6, r7, r8);
    L25:
        r8 = r17;
        goto L27
    L21:
        r7 = r16;
        goto L23
    L17:
        r6 = r15;
        goto L19
    L13:
        r5 = r14;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }

    public final long component1() {
        return this.secActivityBeginTime;
    }

    public final long component2() {
        return this.secActivityEndTime;
    }

    public final boolean component3() {
        return this.hasSecActivity;
    }

    public final String component4() {
        return this.orderUrl;
    }

    public final com.bytedance.android.ec.core.btm.a component5() {
        return this.btmFields;
    }

    public final Map<String, Object> component6() {
        return this.updateParams;
    }

    public final PDPBuyWithoutCheckParam copy(long r11, long r13, boolean r15, String r16, com.bytedance.android.ec.core.btm.a r17, Map<String, ? extends Object> r18) {
        return new PDPBuyWithoutCheckParam(r11, r13, r15, r16, r17, r18);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof PDPBuyWithoutCheckParam) == false) goto L18;
        PDPBuyWithoutCheckParam r7 = (PDPBuyWithoutCheckParam) r6;
        if (this.secActivityBeginTime == r7.secActivityBeginTime) goto L8;
        return false;
    L8:
        if (this.secActivityEndTime == r7.secActivityEndTime) goto L10;
        return false;
    L10:
        if (this.hasSecActivity == r7.hasSecActivity) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.orderUrl, r7.orderUrl) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.btmFields, r7.btmFields) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.updateParams, r7.updateParams) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    public int hashCode() {
        long r0 = this.secActivityBeginTime;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.secActivityEndTime;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        boolean r4 = this.hasSecActivity;
        ?? r5 = r4;
        if (r4 == false) goto L5;
        r5 = 1;
    L5:
        int r6 = (r2 + r5) * 31;
        String r7 = this.orderUrl;
        int r8 = 0;
        if (r7 == null) goto L8;
        int r9 = r7.hashCode();
    L9:
        int r10 = (r6 + r9) * 31;
        com.bytedance.android.ec.core.btm.a r11 = this.btmFields;
        if (r11 == null) goto L12;
        int r12 = r11.hashCode();
    L13:
        int r13 = (r10 + r12) * 31;
        Map<String, ? extends Object> r14 = this.updateParams;
        if (r14 == null) goto L17;
        r8 = r14.hashCode();
    L17:
        return r13 + r8;
    L12:
        r12 = 0;
        goto L13
    L8:
        r9 = 0;
        goto L9
    }

    public String toString() {
        return "PDPBuyWithoutCheckParam(secActivityBeginTime=" + this.secActivityBeginTime + ", secActivityEndTime=" + this.secActivityEndTime + ", hasSecActivity=" + this.hasSecActivity + ", orderUrl=" + this.orderUrl + ", btmFields=" + this.btmFields + ", updateParams=" + this.updateParams + ")";
    }

    public final boolean secKillActivityOnGoing() {
        long r0 = System.currentTimeMillis() / ((long) 1000);
        long r2 = this.secActivityBeginTime;
        long r4 = this.secActivityEndTime;
        if (r2 <= r0) goto L6;
    L10:
        return false;
    L6:
        if (r4 < r0) goto L10;
        if (this.hasSecActivity == false) goto L10;
        return true;
    }

    public final com.bytedance.android.ec.core.btm.a getBtmFields() {
        return this.btmFields;
    }

    public final boolean getHasSecActivity() {
        return this.hasSecActivity;
    }

    public final String getOrderUrl() {
        return this.orderUrl;
    }

    public final long getSecActivityBeginTime() {
        return this.secActivityBeginTime;
    }

    public final long getSecActivityEndTime() {
        return this.secActivityEndTime;
    }

    public final Map<String, Object> getUpdateParams() {
        return this.updateParams;
    }

    public final void setBtmFields(com.bytedance.android.ec.core.btm.a r1) {
        this.btmFields = r1;
    }

    public final void setUpdateParams(Map<String, ? extends Object> r1) {
        this.updateParams = r1;
    }

    public PDPBuyWithoutCheckParam(long r1, long r3, boolean r5, String r6, com.bytedance.android.ec.core.btm.a r7, Map<String, ? extends Object> r8) {
        this.secActivityBeginTime = r1;
        this.secActivityEndTime = r3;
        this.hasSecActivity = r5;
        this.orderUrl = r6;
        this.btmFields = r7;
        this.updateParams = r8;
    }

    public /* synthetic */ PDPBuyWithoutCheckParam(long r10, long r12, boolean r14, String r15, com.bytedance.android.ec.core.btm.a r16, Map r17, int r18, DefaultConstructorMarker r19) {
        long r1 = 0;
        if ((r18 & 1) == 0) goto L5;
        long r3 = 0;
    L7:
        if ((r18 & 2) != 0) goto L11;
        r1 = r12;
    L11:
        if ((r18 & 4) == 0) goto L13;
        boolean r0 = false;
    L14:
        Map r6 = null;
        if ((r18 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r18 & 16) == 0) goto L21;
        com.bytedance.android.ec.core.btm.a r7 = null;
    L23:
        if ((r18 & 32) != 0) goto L26;
        r6 = r17;
    L26:
        this(r3, r1, r0, r5, r7, r6);
        return;
    L21:
        r7 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r0 = r14;
        goto L14
    L5:
        r3 = r10;
        goto L7
    }
}
