package com.bytedance.android.shopping.new_cart.hybrid;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.shopping.extensions.b;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b&\b\u0086\b\u0018\u0000 G2\u00020\u0001:\u0001HB\u0081\u0001\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\f\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u001a\u001a\u00020\f\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u001c\u001a\u00020\f\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\bE\u0010FJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\n\u001a\u00020\tHÆ\u0003J\t\u0010\u000b\u001a\u00020\tHÆ\u0003J\t\u0010\r\u001a\u00020\fHÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u000f\u001a\u00020\fHÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0011\u001a\u00020\fHÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0083\u0001\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\f2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u001a\u001a\u00020\f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u001c\u001a\u00020\f2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u0010!\u001a\u00020\u0007HÖ\u0001J\t\u0010\"\u001a\u00020\tHÖ\u0001J\u0013\u0010%\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010#HÖ\u0003R$\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010+\u001a\u0004\b0\u0010-\"\u0004\b1\u0010/R\"\u0010\u0018\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010&\u001a\u0004\b7\u0010(\"\u0004\b8\u0010*R\"\u0010\u001a\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u00102\u001a\u0004\b9\u00104\"\u0004\b:\u00106R$\u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010&\u001a\u0004\b;\u0010(\"\u0004\b<\u0010*R\"\u0010\u001c\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u00102\u001a\u0004\b=\u00104\"\u0004\b>\u00106R$\u0010\u001d\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010&\u001a\u0004\b?\u0010(\"\u0004\b@\u0010*R$\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010&\u001a\u0004\bA\u0010(\"\u0004\bB\u0010*R$\u0010\u001f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010&\u001a\u0004\bC\u0010(\"\u0004\bD\u0010*¨\u0006I"}, d2 = {"Lcom/bytedance/android/shopping/new_cart/hybrid/CartHybridDialogPrams;", "Ljava/io/Serializable;", "Lorg/json/JSONObject;", "getCloseTriggerParams", "params", "", "setCloseTriggerParams", "", "component1", "", "component2", "component3", "", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "schema", "heightPercent", "bottomOffset", "hasMask", "maskColor", "maskClickDisable", "type", "enablePullUp", "closeTriggerEvent", "closeTriggerParamsJson", "popupCode", "copy", "toString", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getSchema", "()Ljava/lang/String;", "setSchema", "(Ljava/lang/String;)V", "I", "getHeightPercent", "()I", "setHeightPercent", "(I)V", "getBottomOffset", "setBottomOffset", "Z", "getHasMask", "()Z", "setHasMask", "(Z)V", "getMaskColor", "setMaskColor", "getMaskClickDisable", "setMaskClickDisable", "getType", "setType", "getEnablePullUp", "setEnablePullUp", "getCloseTriggerEvent", "setCloseTriggerEvent", "getCloseTriggerParamsJson", "setCloseTriggerParamsJson", "getPopupCode", "setPopupCode", "<init>", "(Ljava/lang/String;IIZLjava/lang/String;ZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CartHybridDialogPrams implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("bottomOffset")
    private int bottomOffset;

    @SerializedName("closeTriggerEvent")
    private String closeTriggerEvent;

    @SerializedName("closeTriggerParams")
    private String closeTriggerParamsJson;

    @SerializedName("enablePullUp")
    private boolean enablePullUp;

    @SerializedName("hasMask")
    private boolean hasMask;

    @SerializedName("heightPercent")
    private int heightPercent;

    @SerializedName("maskClickDisable")
    private boolean maskClickDisable;

    @SerializedName("maskColor")
    private String maskColor;

    @SerializedName("popupCode")
    private String popupCode;

    @SerializedName("schema")
    private String schema;

    @SerializedName("type")
    private String type;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CartHybridDialogPrams() {
        this(null, 0, 0, false, null, false, null, false, null, null, null, 2047, null);
    }

    public static /* synthetic */ CartHybridDialogPrams copy$default(CartHybridDialogPrams r12, String r13, int r14, int r15, boolean r16, String r17, boolean r18, String r19, boolean r20, String r21, String r22, String r23, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        String r2 = r12.schema;
    L7:
        if ((r24 & 2) == 0) goto L9;
        int r3 = r12.heightPercent;
    L11:
        if ((r24 & 4) == 0) goto L13;
        int r4 = r12.bottomOffset;
    L15:
        if ((r24 & 8) == 0) goto L17;
        boolean r5 = r12.hasMask;
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r6 = r12.maskColor;
    L23:
        if ((r24 & 32) == 0) goto L25;
        boolean r7 = r12.maskClickDisable;
    L27:
        if ((r24 & 64) == 0) goto L29;
        String r8 = r12.type;
    L31:
        if ((r24 & 128) == 0) goto L33;
        boolean r9 = r12.enablePullUp;
    L35:
        if ((r24 & 256) == 0) goto L37;
        String r10 = r12.closeTriggerEvent;
    L39:
        if ((r24 & 512) == 0) goto L41;
        String r11 = r12.closeTriggerParamsJson;
    L43:
        if ((r24 & 1024) == 0) goto L45;
        String r1 = r12.popupCode;
    L47:
        return r12.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r1);
    L45:
        r1 = r23;
        goto L47
    L41:
        r11 = r22;
        goto L43
    L37:
        r10 = r21;
        goto L39
    L33:
        r9 = r20;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }

    public final String component1() {
        return this.schema;
    }

    public final String component10() {
        return this.closeTriggerParamsJson;
    }

    public final String component11() {
        return this.popupCode;
    }

    public final int component2() {
        return this.heightPercent;
    }

    public final int component3() {
        return this.bottomOffset;
    }

    public final boolean component4() {
        return this.hasMask;
    }

    public final String component5() {
        return this.maskColor;
    }

    public final boolean component6() {
        return this.maskClickDisable;
    }

    public final String component7() {
        return this.type;
    }

    public final boolean component8() {
        return this.enablePullUp;
    }

    public final String component9() {
        return this.closeTriggerEvent;
    }

    public final CartHybridDialogPrams copy(String r14, int r15, int r16, boolean r17, String r18, boolean r19, String r20, boolean r21, String r22, String r23, String r24) {
        return new CartHybridDialogPrams(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof CartHybridDialogPrams) == false) goto L28;
        CartHybridDialogPrams r4 = (CartHybridDialogPrams) r3;
        if (Intrinsics.areEqual(this.schema, r4.schema) == true) goto L8;
        return false;
    L8:
        if (this.heightPercent == r4.heightPercent) goto L10;
        return false;
    L10:
        if (this.bottomOffset == r4.bottomOffset) goto L12;
        return false;
    L12:
        if (this.hasMask == r4.hasMask) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.maskColor, r4.maskColor) == true) goto L16;
        return false;
    L16:
        if (this.maskClickDisable == r4.maskClickDisable) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.type, r4.type) == true) goto L20;
        return false;
    L20:
        if (this.enablePullUp == r4.enablePullUp) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.closeTriggerEvent, r4.closeTriggerEvent) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.closeTriggerParamsJson, r4.closeTriggerParamsJson) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.popupCode, r4.popupCode) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public final JSONObject getCloseTriggerParams() {
        String r1 = this.closeTriggerParamsJson;     // Catch: Exception -> L8
        if (r1 == null) goto L13;
        return new JSONObject(r1);
    L13:
        return null;
    L8:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String r0 = this.schema;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((((r2 * 31) + this.heightPercent) * 31) + this.bottomOffset) * 31;
        boolean r4 = this.hasMask;
        ?? r5 = 1;
        ?? r6 = r4;
        if (r4 == false) goto L9;
        r6 = 1;
    L9:
        int r7 = (r3 + r6) * 31;
        String r8 = this.maskColor;
        if (r8 == null) goto L12;
        int r9 = r8.hashCode();
    L13:
        int r10 = (r7 + r9) * 31;
        boolean r11 = this.maskClickDisable;
        ?? r12 = r11;
        if (r11 == false) goto L16;
        r12 = 1;
    L16:
        int r13 = (r10 + r12) * 31;
        String r14 = this.type;
        if (r14 == null) goto L19;
        int r15 = r14.hashCode();
    L20:
        int r16 = (r13 + r15) * 31;
        boolean r17 = this.enablePullUp;
        if (r17 == true) goto L24;
        r5 = r17;
    L24:
        int r18 = (r16 + r5) * 31;
        String r19 = this.closeTriggerEvent;
        if (r19 == null) goto L27;
        int r20 = r19.hashCode();
    L28:
        int r21 = (r18 + r20) * 31;
        String r22 = this.closeTriggerParamsJson;
        if (r22 == null) goto L31;
        int r23 = r22.hashCode();
    L32:
        int r24 = (r21 + r23) * 31;
        String r25 = this.popupCode;
        if (r25 == null) goto L36;
        r1 = r25.hashCode();
    L36:
        return r24 + r1;
    L31:
        r23 = 0;
        goto L32
    L27:
        r20 = 0;
        goto L28
    L19:
        r15 = 0;
        goto L20
    L12:
        r9 = 0;
        goto L13
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "CartHybridDialogPrams(schema=" + this.schema + ", heightPercent=" + this.heightPercent + ", bottomOffset=" + this.bottomOffset + ", hasMask=" + this.hasMask + ", maskColor=" + this.maskColor + ", maskClickDisable=" + this.maskClickDisable + ", type=" + this.type + ", enablePullUp=" + this.enablePullUp + ", closeTriggerEvent=" + this.closeTriggerEvent + ", closeTriggerParamsJson=" + this.closeTriggerParamsJson + ", popupCode=" + this.popupCode + ")";
    }

    public final int getBottomOffset() {
        return this.bottomOffset;
    }

    public final String getCloseTriggerEvent() {
        return this.closeTriggerEvent;
    }

    public final String getCloseTriggerParamsJson() {
        return this.closeTriggerParamsJson;
    }

    public final boolean getEnablePullUp() {
        return this.enablePullUp;
    }

    public final boolean getHasMask() {
        return this.hasMask;
    }

    public final int getHeightPercent() {
        return this.heightPercent;
    }

    public final boolean getMaskClickDisable() {
        return this.maskClickDisable;
    }

    public final String getMaskColor() {
        return this.maskColor;
    }

    public final String getPopupCode() {
        return this.popupCode;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getType() {
        return this.type;
    }

    public final void setBottomOffset(int r1) {
        this.bottomOffset = r1;
    }

    public final void setCloseTriggerEvent(String r1) {
        this.closeTriggerEvent = r1;
    }

    public final void setCloseTriggerParams(JSONObject r1) {
        if (r1 == null) goto L4;
        String r2 = r1.toString();
    L5:
        this.closeTriggerParamsJson = r2;
        return;
    L4:
        r2 = null;
        goto L5
    }

    public final void setCloseTriggerParamsJson(String r1) {
        this.closeTriggerParamsJson = r1;
    }

    public final void setEnablePullUp(boolean r1) {
        this.enablePullUp = r1;
    }

    public final void setHasMask(boolean r1) {
        this.hasMask = r1;
    }

    public final void setHeightPercent(int r1) {
        this.heightPercent = r1;
    }

    public final void setMaskClickDisable(boolean r1) {
        this.maskClickDisable = r1;
    }

    public final void setMaskColor(String r1) {
        this.maskColor = r1;
    }

    public final void setPopupCode(String r1) {
        this.popupCode = r1;
    }

    public final void setSchema(String r1) {
        this.schema = r1;
    }

    public final void setType(String r1) {
        this.type = r1;
    }

    public CartHybridDialogPrams(String r1, int r2, int r3, boolean r4, String r5, boolean r6, String r7, boolean r8, String r9, String r10, String r11) {
        this.schema = r1;
        this.heightPercent = r2;
        this.bottomOffset = r3;
        this.hasMask = r4;
        this.maskColor = r5;
        this.maskClickDisable = r6;
        this.type = r7;
        this.enablePullUp = r8;
        this.closeTriggerEvent = r9;
        this.closeTriggerParamsJson = r10;
        this.popupCode = r11;
    }

    public /* synthetic */ CartHybridDialogPrams(String r13, int r14, int r15, boolean r16, String r17, boolean r18, String r19, boolean r20, String r21, String r22, String r23, int r24, DefaultConstructorMarker r25) {
        String r2 = null;
        if ((r24 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r24 & 2) == 0) goto L9;
        int r3 = 73;
    L11:
        if ((r24 & 4) == 0) goto L13;
        int r4 = b.b(75);
    L15:
        if ((r24 & 8) == 0) goto L17;
        boolean r5 = true;
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r6 = "1711276032";
    L22:
        boolean r8 = false;
        if ((r24 & 32) == 0) goto L25;
        boolean r7 = false;
    L27:
        if ((r24 & 64) == 0) goto L29;
        String r9 = null;
    L31:
        if ((r24 & 128) != 0) goto L35;
        r8 = r20;
    L35:
        if ((r24 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r24 & 512) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r24 & 1024) != 0) goto L46;
        r2 = r23;
    L46:
        this(r1, r3, r4, r5, r6, r7, r9, r8, r10, r11, r2);
        return;
    L41:
        r11 = r22;
        goto L43
    L37:
        r10 = r21;
        goto L39
    L29:
        r9 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L22
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r1 = r13;
        goto L7
    }
}
