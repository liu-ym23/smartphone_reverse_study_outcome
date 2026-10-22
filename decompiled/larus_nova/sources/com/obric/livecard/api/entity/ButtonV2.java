package com.obric.livecard.api.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b7\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0012J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010:\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0092\u0001\u0010@\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010AJ\u0013\u0010B\u001a\u00020\u000b2\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010D\u001a\u00020\u0007HÖ\u0001J\t\u0010E\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u0016R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0018\"\u0004\b(\u0010\u001aR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010\u001aR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0018\"\u0004\b,\u0010\u001aR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b1\u0010\u001c\"\u0004\b2\u0010\u001eR\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b3\u0010#\"\u0004\b4\u0010%¨\u0006F"}, d2 = {"Lcom/obric/livecard/api/entity/ButtonV2;", "", "icon", "", "text", "Lcom/obric/livecard/api/entity/Text;", "height", "", "width", "id", "dismissKeyguard", "", "backgroundIcon", "iconLight", "foregroundColor", "Lcom/obric/livecard/api/entity/ColorToken;", "backgroundColor", "verification", "(Ljava/lang/String;Lcom/obric/livecard/api/entity/Text;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/obric/livecard/api/entity/ColorToken;Lcom/obric/livecard/api/entity/ColorToken;Ljava/lang/Boolean;)V", "getBackgroundColor", "()Lcom/obric/livecard/api/entity/ColorToken;", "setBackgroundColor", "(Lcom/obric/livecard/api/entity/ColorToken;)V", "getBackgroundIcon", "()Ljava/lang/String;", "setBackgroundIcon", "(Ljava/lang/String;)V", "getDismissKeyguard", "()Ljava/lang/Boolean;", "setDismissKeyguard", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getForegroundColor", "setForegroundColor", "getHeight", "()Ljava/lang/Integer;", "setHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getIcon", "setIcon", "getIconLight", "setIconLight", "getId", "setId", "getText", "()Lcom/obric/livecard/api/entity/Text;", "setText", "(Lcom/obric/livecard/api/entity/Text;)V", "getVerification", "setVerification", "getWidth", "setWidth", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Lcom/obric/livecard/api/entity/Text;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/obric/livecard/api/entity/ColorToken;Lcom/obric/livecard/api/entity/ColorToken;Ljava/lang/Boolean;)Lcom/obric/livecard/api/entity/ButtonV2;", "equals", "other", "hashCode", "toString", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ButtonV2 {
    private ColorToken backgroundColor;
    private String backgroundIcon;
    private Boolean dismissKeyguard;
    private ColorToken foregroundColor;
    private Integer height;
    private String icon;
    private String iconLight;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f396889id;
    private Text text;
    private Boolean verification;
    private Integer width;

    public ButtonV2() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public static /* synthetic */ ButtonV2 copy$default(ButtonV2 r110, String r111, Text r112, Integer r113, Integer r114, String r115, Boolean r116, String r117, String r210, ColorToken r211, ColorToken r212, Boolean r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        String r100 = r110.icon;
    L7:
        if ((r214 & 2) == 0) goto L9;
        Text r101 = r110.text;
    L11:
        if ((r214 & 4) == 0) goto L13;
        Integer r102 = r110.height;
    L15:
        if ((r214 & 8) == 0) goto L17;
        Integer r103 = r110.width;
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r104 = r110.f396889id;
    L23:
        if ((r214 & 32) == 0) goto L25;
        Boolean r105 = r110.dismissKeyguard;
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r106 = r110.backgroundIcon;
    L31:
        if ((r214 & 128) == 0) goto L33;
        String r107 = r110.iconLight;
    L35:
        if ((r214 & 256) == 0) goto L37;
        ColorToken r118 = r110.foregroundColor;
    L39:
        if ((r214 & 512) == 0) goto L41;
        ColorToken r119 = r110.backgroundColor;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        Boolean r108 = r110.verification;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r118, r119, r108);
    L45:
        r108 = r213;
        goto L47
    L41:
        r119 = r212;
        goto L43
    L37:
        r118 = r211;
        goto L39
    L33:
        r107 = r210;
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

    public final String component1() {
        return this.icon;
    }

    public final ColorToken component10() {
        return this.backgroundColor;
    }

    public final Boolean component11() {
        return this.verification;
    }

    public final Text component2() {
        return this.text;
    }

    public final Integer component3() {
        return this.height;
    }

    public final Integer component4() {
        return this.width;
    }

    public final String component5() {
        return this.f396889id;
    }

    public final Boolean component6() {
        return this.dismissKeyguard;
    }

    public final String component7() {
        return this.backgroundIcon;
    }

    public final String component8() {
        return this.iconLight;
    }

    public final ColorToken component9() {
        return this.foregroundColor;
    }

    public final ButtonV2 copy(String r110, Text r111, Integer r112, Integer r113, String r114, Boolean r115, String r210, String r211, ColorToken r212, ColorToken r213, Boolean r214) {
        return new ButtonV2(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ButtonV2) == true) goto L8;
        return false;
    L8:
        ButtonV2 r101 = (ButtonV2) r100;
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.width, r101.width) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f396889id, r101.f396889id) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.dismissKeyguard, r101.dismissKeyguard) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.backgroundIcon, r101.backgroundIcon) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.iconLight, r101.iconLight) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.foregroundColor, r101.foregroundColor) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.verification, r101.verification) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        String r100 = this.icon;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Text r104 = this.text;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.height;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.width;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f396889id;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.dismissKeyguard;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.backgroundIcon;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.iconLight;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        ColorToken r125 = this.foregroundColor;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        ColorToken r128 = this.backgroundColor;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Boolean r131 = this.verification;
        if (r131 == null) goto L47;
        r101 = r131.hashCode();
    L47:
        return r130 + r101;
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ButtonV2(icon=" + this.icon + ", text=" + this.text + ", height=" + this.height + ", width=" + this.width + ", id=" + this.f396889id + ", dismissKeyguard=" + this.dismissKeyguard + ", backgroundIcon=" + this.backgroundIcon + ", iconLight=" + this.iconLight + ", foregroundColor=" + this.foregroundColor + ", backgroundColor=" + this.backgroundColor + ", verification=" + this.verification + ')';
    }

    public final ColorToken getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getBackgroundIcon() {
        return this.backgroundIcon;
    }

    public final Boolean getDismissKeyguard() {
        return this.dismissKeyguard;
    }

    public final ColorToken getForegroundColor() {
        return this.foregroundColor;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getIconLight() {
        return this.iconLight;
    }

    public final String getId() {
        return this.f396889id;
    }

    public final Text getText() {
        return this.text;
    }

    public final Boolean getVerification() {
        return this.verification;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public final void setBackgroundColor(ColorToken r100) {
        this.backgroundColor = r100;
    }

    public final void setBackgroundIcon(String r100) {
        this.backgroundIcon = r100;
    }

    public final void setDismissKeyguard(Boolean r100) {
        this.dismissKeyguard = r100;
    }

    public final void setForegroundColor(ColorToken r100) {
        this.foregroundColor = r100;
    }

    public final void setHeight(Integer r100) {
        this.height = r100;
    }

    public final void setIcon(String r100) {
        this.icon = r100;
    }

    public final void setIconLight(String r100) {
        this.iconLight = r100;
    }

    public final void setId(String r100) {
        this.f396889id = r100;
    }

    public final void setText(Text r100) {
        this.text = r100;
    }

    public final void setVerification(Boolean r100) {
        this.verification = r100;
    }

    public final void setWidth(Integer r100) {
        this.width = r100;
    }

    public ButtonV2(String r100, Text r101, Integer r102, Integer r103, String r104, Boolean r105, String r106, String r107, ColorToken r108, ColorToken r110, Boolean r111) {
        this.icon = r100;
        this.text = r101;
        this.height = r102;
        this.width = r103;
        this.f396889id = r104;
        this.dismissKeyguard = r105;
        this.backgroundIcon = r106;
        this.iconLight = r107;
        this.foregroundColor = r108;
        this.backgroundColor = r110;
        this.verification = r111;
    }

    public /* synthetic */ ButtonV2(String r110, Text r111, Integer r112, Integer r113, String r114, Boolean r115, String r116, String r210, ColorToken r211, ColorToken r212, Boolean r213, int r214, DefaultConstructorMarker r215) {
        Boolean r100 = null;
        if ((r214 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r214 & 2) == 0) goto L9;
        Text r102 = null;
    L11:
        if ((r214 & 4) == 0) goto L13;
        Integer r103 = null;
    L15:
        if ((r214 & 8) == 0) goto L17;
        Integer r104 = null;
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r214 & 32) == 0) goto L25;
        Boolean r106 = null;
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r214 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r214 & 256) == 0) goto L37;
        ColorToken r117 = null;
    L39:
        if ((r214 & 512) == 0) goto L41;
        ColorToken r118 = null;
    L43:
        if ((r214 & 1024) != 0) goto L46;
        r100 = r213;
    L46:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r117, r118, r100);
        return;
    L41:
        r118 = r212;
        goto L43
    L37:
        r117 = r211;
        goto L39
    L33:
        r108 = r210;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
