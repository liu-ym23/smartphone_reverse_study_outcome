package com.obric.livecard.api.entity;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Deprecated(message = "请使用ButtonV2")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b/\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000fJ\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u00100\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0006HÆ\u0003Jt\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u00020\t2\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\u0003HÖ\u0001J\t\u00109\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u0013R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0011\"\u0004\b$\u0010\u0013R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001a\"\u0004\b*\u0010\u001c¨\u0006:"}, d2 = {"Lcom/obric/livecard/api/entity/Button;", "", "height", "", "width", "icon", "", "id", "dismissKeyguard", "", "textIconStyle", "Lcom/obric/livecard/api/entity/TextIconStyle;", "backgroundIcon", "text", "iconLight", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/obric/livecard/api/entity/TextIconStyle;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBackgroundIcon", "()Ljava/lang/String;", "setBackgroundIcon", "(Ljava/lang/String;)V", "getDismissKeyguard", "()Ljava/lang/Boolean;", "setDismissKeyguard", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getHeight", "()I", "setHeight", "(I)V", "getIcon", "setIcon", "getIconLight", "setIconLight", "getId", "setId", "getText", "setText", "getTextIconStyle", "()Lcom/obric/livecard/api/entity/TextIconStyle;", "setTextIconStyle", "(Lcom/obric/livecard/api/entity/TextIconStyle;)V", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/obric/livecard/api/entity/TextIconStyle;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/livecard/api/entity/Button;", "equals", "other", "hashCode", "toString", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Button {
    private String backgroundIcon;
    private Boolean dismissKeyguard;
    private int height;
    private String icon;
    private String iconLight;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f396888id;
    private String text;
    private TextIconStyle textIconStyle;
    private int width;

    public static /* synthetic */ Button copy$default(Button r110, int r111, int r112, String r113, String r114, Boolean r115, TextIconStyle r116, String r117, String r118, String r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        int r100 = r110.height;
    L7:
        if ((r210 & 2) == 0) goto L9;
        int r101 = r110.width;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r102 = r110.icon;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r103 = r110.f396888id;
    L19:
        if ((r210 & 16) == 0) goto L21;
        Boolean r104 = r110.dismissKeyguard;
    L23:
        if ((r210 & 32) == 0) goto L25;
        TextIconStyle r105 = r110.textIconStyle;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r106 = r110.backgroundIcon;
    L31:
        if ((r210 & 128) == 0) goto L33;
        String r107 = r110.text;
    L35:
        if ((r210 & 256) == 0) goto L37;
        String r108 = r110.iconLight;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final int component1() {
        return this.height;
    }

    public final int component2() {
        return this.width;
    }

    public final String component3() {
        return this.icon;
    }

    public final String component4() {
        return this.f396888id;
    }

    public final Boolean component5() {
        return this.dismissKeyguard;
    }

    public final TextIconStyle component6() {
        return this.textIconStyle;
    }

    public final String component7() {
        return this.backgroundIcon;
    }

    public final String component8() {
        return this.text;
    }

    public final String component9() {
        return this.iconLight;
    }

    public final Button copy(int r110, int r111, String r112, String r113, Boolean r114, TextIconStyle r115, String r116, String r117, String r210) {
        Intrinsics.checkNotNullParameter(r112, "icon");
        return new Button(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Button) == true) goto L8;
        return false;
    L8:
        Button r101 = (Button) r100;
        if (this.height == r101.height) goto L12;
        return false;
    L12:
        if (this.width == r101.width) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f396888id, r101.f396888id) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.dismissKeyguard, r101.dismissKeyguard) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.textIconStyle, r101.textIconStyle) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.backgroundIcon, r101.backgroundIcon) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.iconLight, r101.iconLight) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.height * 31) + this.width) * 31) + this.icon.hashCode()) * 31;
        String r101 = this.f396888id;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Boolean r105 = this.dismissKeyguard;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        TextIconStyle r108 = this.textIconStyle;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.backgroundIcon;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.text;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.iconLight;
        if (r117 == null) goto L27;
        r102 = r117.hashCode();
    L27:
        return r116 + r102;
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "Button(height=" + this.height + ", width=" + this.width + ", icon=" + this.icon + ", id=" + this.f396888id + ", dismissKeyguard=" + this.dismissKeyguard + ", textIconStyle=" + this.textIconStyle + ", backgroundIcon=" + this.backgroundIcon + ", text=" + this.text + ", iconLight=" + this.iconLight + ')';
    }

    public final String getBackgroundIcon() {
        return this.backgroundIcon;
    }

    public final Boolean getDismissKeyguard() {
        return this.dismissKeyguard;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getIconLight() {
        return this.iconLight;
    }

    public final String getId() {
        return this.f396888id;
    }

    public final String getText() {
        return this.text;
    }

    public final TextIconStyle getTextIconStyle() {
        return this.textIconStyle;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setBackgroundIcon(String r100) {
        this.backgroundIcon = r100;
    }

    public final void setDismissKeyguard(Boolean r100) {
        this.dismissKeyguard = r100;
    }

    public final void setHeight(int r100) {
        this.height = r100;
    }

    public final void setIcon(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.icon = r100;
    }

    public final void setIconLight(String r100) {
        this.iconLight = r100;
    }

    public final void setId(String r100) {
        this.f396888id = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }

    public final void setTextIconStyle(TextIconStyle r100) {
        this.textIconStyle = r100;
    }

    public final void setWidth(int r100) {
        this.width = r100;
    }

    public Button(int r100, int r101, String r102, String r103, Boolean r104, TextIconStyle r105, String r106, String r107, String r110) {
        Intrinsics.checkNotNullParameter(r102, "icon");
        this.height = r100;
        this.width = r101;
        this.icon = r102;
        this.f396888id = r103;
        this.dismissKeyguard = r104;
        this.textIconStyle = r105;
        this.backgroundIcon = r106;
        this.text = r107;
        this.iconLight = r110;
    }

    public /* synthetic */ Button(int r110, int r111, String r112, String r113, Boolean r114, TextIconStyle r115, String r210, String r211, String r212, int r213, DefaultConstructorMarker r214) {
        if ((r213 & 8) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r213 & 16) == 0) goto L9;
        Boolean r101 = null;
    L11:
        if ((r213 & 32) == 0) goto L13;
        TextIconStyle r102 = null;
    L15:
        if ((r213 & 64) == 0) goto L17;
        String r116 = null;
    L19:
        if ((r213 & 128) == 0) goto L21;
        String r117 = null;
    L23:
        if ((r213 & 256) == 0) goto L25;
        String r118 = null;
    L26:
        this(r110, r111, r112, r100, r101, r102, r116, r117, r118);
        return;
    L25:
        r118 = r212;
        goto L26
    L21:
        r117 = r211;
        goto L23
    L17:
        r116 = r210;
        goto L19
    L13:
        r102 = r115;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
