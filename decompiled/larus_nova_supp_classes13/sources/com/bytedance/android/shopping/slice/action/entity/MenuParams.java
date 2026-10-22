package com.bytedance.android.shopping.slice.action.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JV\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000eR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\f¨\u0006#"}, d2 = {"Lcom/bytedance/android/shopping/slice/action/entity/MenuParams;", "Ljava/io/Serializable;", "icon", "", "iconHeight", "", "iconWidth", "iconPosition", "space", "text", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;)V", "getIcon", "()Ljava/lang/String;", "getIconHeight", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getIconPosition", "getIconWidth", "getSpace", "getText", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;)Lcom/bytedance/android/shopping/slice/action/entity/MenuParams;", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MenuParams implements Serializable {

    @SerializedName("icon")
    private final String icon;

    @SerializedName("icon_height")
    private final Double iconHeight;

    @SerializedName("icon_position")
    private final String iconPosition;

    @SerializedName("icon_width")
    private final Double iconWidth;

    @SerializedName("space")
    private final Double space;

    @SerializedName("text")
    private final String text;

    public MenuParams() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ MenuParams copy$default(MenuParams r4, String r5, Double r6, Double r7, String r8, Double r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.icon;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.iconHeight;
    L8:
        Double r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.iconWidth;
    L11:
        Double r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.iconPosition;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.space;
    L17:
        Double r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.text;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.icon;
    }

    public final Double component2() {
        return this.iconHeight;
    }

    public final Double component3() {
        return this.iconWidth;
    }

    public final String component4() {
        return this.iconPosition;
    }

    public final Double component5() {
        return this.space;
    }

    public final String component6() {
        return this.text;
    }

    public final MenuParams copy(String r9, Double r10, Double r11, String r12, Double r13, String r14) {
        return new MenuParams(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof MenuParams) == false) goto L18;
        MenuParams r4 = (MenuParams) r3;
        if (Intrinsics.areEqual(this.icon, r4.icon) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.iconHeight, r4.iconHeight) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.iconWidth, r4.iconWidth) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.iconPosition, r4.iconPosition) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.space, r4.space) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.text, r4.text) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        String r0 = this.icon;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Double r4 = this.iconHeight;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Double r7 = this.iconWidth;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.iconPosition;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Double r13 = this.space;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.text;
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

    public String toString() {
        return "MenuParams(icon=" + this.icon + ", iconHeight=" + this.iconHeight + ", iconWidth=" + this.iconWidth + ", iconPosition=" + this.iconPosition + ", space=" + this.space + ", text=" + this.text + ")";
    }

    public final String getIcon() {
        return this.icon;
    }

    public final Double getIconHeight() {
        return this.iconHeight;
    }

    public final String getIconPosition() {
        return this.iconPosition;
    }

    public final Double getIconWidth() {
        return this.iconWidth;
    }

    public final Double getSpace() {
        return this.space;
    }

    public final String getText() {
        return this.text;
    }

    public MenuParams(String r1, Double r2, Double r3, String r4, Double r5, String r6) {
        this.icon = r1;
        this.iconHeight = r2;
        this.iconWidth = r3;
        this.iconPosition = r4;
        this.space = r5;
        this.text = r6;
    }

    public /* synthetic */ MenuParams(String r6, Double r7, Double r8, String r9, Double r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        String r14 = null;
    L7:
        if ((r12 & 2) == 0) goto L9;
        Double r1 = null;
    L11:
        if ((r12 & 4) == 0) goto L13;
        Double r2 = null;
    L15:
        if ((r12 & 8) == 0) goto L17;
        String r3 = null;
    L19:
        if ((r12 & 16) == 0) goto L21;
        Double r4 = null;
    L23:
        if ((r12 & 32) == 0) goto L25;
        String r15 = null;
    L26:
        this(r14, r1, r2, r3, r4, r15);
        return;
    L25:
        r15 = r11;
        goto L26
    L21:
        r4 = r10;
        goto L23
    L17:
        r3 = r9;
        goto L19
    L13:
        r2 = r8;
        goto L15
    L9:
        r1 = r7;
        goto L11
    L5:
        r14 = r6;
        goto L7
    }
}
