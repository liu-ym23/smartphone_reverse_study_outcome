package com.obric.livecard.api.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b6\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0011J\t\u00104\u001a\u00020\u0003HÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010*J\u000b\u00106\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0006HÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010;\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010=\u001a\u00020\fHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u008a\u0001\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010@J\u0013\u0010A\u001a\u00020\f2\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010C\u001a\u00020\u0003HÖ\u0001J\t\u0010D\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010\u001aR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b%\u0010\u0013\"\u0004\b&\u0010\u0015R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0018\"\u0004\b(\u0010\u001aR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001c\"\u0004\b3\u0010\u001e¨\u0006E"}, d2 = {"Lcom/obric/livecard/api/entity/Icon;", "", "height", "", "width", "icon", "", "loop", "autoplay", "id", "backgroundIcon", "useBorderRadius", "", "iconLight", "strokeWidth", "", "strokeColor", "(IILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Float;Ljava/lang/String;)V", "getAutoplay", "()Ljava/lang/Integer;", "setAutoplay", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getBackgroundIcon", "()Ljava/lang/String;", "setBackgroundIcon", "(Ljava/lang/String;)V", "getHeight", "()I", "setHeight", "(I)V", "getIcon", "setIcon", "getIconLight", "setIconLight", "getId", "setId", "getLoop", "setLoop", "getStrokeColor", "setStrokeColor", "getStrokeWidth", "()Ljava/lang/Float;", "setStrokeWidth", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getUseBorderRadius", "()Z", "setUseBorderRadius", "(Z)V", "getWidth", "setWidth", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(IILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Float;Ljava/lang/String;)Lcom/obric/livecard/api/entity/Icon;", "equals", "other", "hashCode", "toString", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Icon {
    private Integer autoplay;
    private String backgroundIcon;
    private int height;
    private String icon;
    private String iconLight;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f396890id;
    private Integer loop;
    private String strokeColor;
    private Float strokeWidth;
    private boolean useBorderRadius;
    private int width;

    public static /* synthetic */ Icon copy$default(Icon r110, int r111, int r112, String r113, Integer r114, Integer r115, String r116, String r117, boolean r210, String r211, Float r212, String r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        int r100 = r110.height;
    L7:
        if ((r214 & 2) == 0) goto L9;
        int r101 = r110.width;
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r102 = r110.icon;
    L15:
        if ((r214 & 8) == 0) goto L17;
        Integer r103 = r110.loop;
    L19:
        if ((r214 & 16) == 0) goto L21;
        Integer r104 = r110.autoplay;
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r105 = r110.f396890id;
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r106 = r110.backgroundIcon;
    L31:
        if ((r214 & 128) == 0) goto L33;
        boolean r107 = r110.useBorderRadius;
    L35:
        if ((r214 & 256) == 0) goto L37;
        String r118 = r110.iconLight;
    L39:
        if ((r214 & 512) == 0) goto L41;
        Float r119 = r110.strokeWidth;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        String r108 = r110.strokeColor;
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

    public final int component1() {
        return this.height;
    }

    public final Float component10() {
        return this.strokeWidth;
    }

    public final String component11() {
        return this.strokeColor;
    }

    public final int component2() {
        return this.width;
    }

    public final String component3() {
        return this.icon;
    }

    public final Integer component4() {
        return this.loop;
    }

    public final Integer component5() {
        return this.autoplay;
    }

    public final String component6() {
        return this.f396890id;
    }

    public final String component7() {
        return this.backgroundIcon;
    }

    public final boolean component8() {
        return this.useBorderRadius;
    }

    public final String component9() {
        return this.iconLight;
    }

    public final Icon copy(int r110, int r111, String r112, Integer r113, Integer r114, String r115, String r210, boolean r211, String r212, Float r213, String r214) {
        Intrinsics.checkNotNullParameter(r112, "icon");
        return new Icon(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Icon) == true) goto L8;
        return false;
    L8:
        Icon r101 = (Icon) r100;
        if (this.height == r101.height) goto L12;
        return false;
    L12:
        if (this.width == r101.width) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.loop, r101.loop) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.autoplay, r101.autoplay) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f396890id, r101.f396890id) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.backgroundIcon, r101.backgroundIcon) == true) goto L30;
        return false;
    L30:
        if (this.useBorderRadius == r101.useBorderRadius) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.iconLight, r101.iconLight) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.strokeWidth, r101.strokeWidth) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.strokeColor, r101.strokeColor) == true) goto L41;
        return false;
    L41:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v31 */
    public int hashCode() {
        int r100 = ((((this.height * 31) + this.width) * 31) + this.icon.hashCode()) * 31;
        Integer r101 = this.loop;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Integer r105 = this.autoplay;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f396890id;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.backgroundIcon;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        boolean r114 = this.useBorderRadius;
        ?? r115 = r114;
        if (r114 == false) goto L21;
        r115 = 1;
    L21:
        int r116 = (r113 + r115) * 31;
        String r117 = this.iconLight;
        if (r117 != null) goto L24;
        int r118 = 0;
    L25:
        int r119 = (r116 + r118) * 31;
        Float r120 = this.strokeWidth;
        if (r120 != null) goto L28;
        int r121 = 0;
    L29:
        int r122 = (r119 + r121) * 31;
        String r123 = this.strokeColor;
        if (r123 == null) goto L34;
        r102 = r123.hashCode();
    L34:
        return r122 + r102;
    L28:
        r121 = r120.hashCode();
        goto L29
    L24:
        r118 = r117.hashCode();
        goto L25
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
        return "Icon(height=" + this.height + ", width=" + this.width + ", icon=" + this.icon + ", loop=" + this.loop + ", autoplay=" + this.autoplay + ", id=" + this.f396890id + ", backgroundIcon=" + this.backgroundIcon + ", useBorderRadius=" + this.useBorderRadius + ", iconLight=" + this.iconLight + ", strokeWidth=" + this.strokeWidth + ", strokeColor=" + this.strokeColor + ')';
    }

    public final Integer getAutoplay() {
        return this.autoplay;
    }

    public final String getBackgroundIcon() {
        return this.backgroundIcon;
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
        return this.f396890id;
    }

    public final Integer getLoop() {
        return this.loop;
    }

    public final String getStrokeColor() {
        return this.strokeColor;
    }

    public final Float getStrokeWidth() {
        return this.strokeWidth;
    }

    public final boolean getUseBorderRadius() {
        return this.useBorderRadius;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setAutoplay(Integer r100) {
        this.autoplay = r100;
    }

    public final void setBackgroundIcon(String r100) {
        this.backgroundIcon = r100;
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
        this.f396890id = r100;
    }

    public final void setLoop(Integer r100) {
        this.loop = r100;
    }

    public final void setStrokeColor(String r100) {
        this.strokeColor = r100;
    }

    public final void setStrokeWidth(Float r100) {
        this.strokeWidth = r100;
    }

    public final void setUseBorderRadius(boolean r100) {
        this.useBorderRadius = r100;
    }

    public final void setWidth(int r100) {
        this.width = r100;
    }

    public Icon(int r100, int r101, String r102, Integer r103, Integer r104, String r105, String r106, boolean r107, String r110, Float r111, String r112) {
        Intrinsics.checkNotNullParameter(r102, "icon");
        this.height = r100;
        this.width = r101;
        this.icon = r102;
        this.loop = r103;
        this.autoplay = r104;
        this.f396890id = r105;
        this.backgroundIcon = r106;
        this.useBorderRadius = r107;
        this.iconLight = r110;
        this.strokeWidth = r111;
        this.strokeColor = r112;
    }

    public /* synthetic */ Icon(int r110, int r111, String r112, Integer r113, Integer r210, String r211, String r212, boolean r213, String r214, Float r215, String r216, int r217, DefaultConstructorMarker r218) {
        if ((r217 & 8) == 0) goto L5;
        Integer r100 = null;
    L7:
        if ((r217 & 16) == 0) goto L9;
        Integer r101 = null;
    L11:
        if ((r217 & 32) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r217 & 64) == 0) goto L17;
        String r114 = null;
    L19:
        if ((r217 & 128) == 0) goto L21;
        boolean r115 = false;
    L23:
        if ((r217 & 256) == 0) goto L25;
        String r116 = null;
    L27:
        if ((r217 & 512) == 0) goto L29;
        Float r117 = null;
    L31:
        if ((r217 & 1024) == 0) goto L33;
        String r118 = null;
    L34:
        this(r110, r111, r112, r100, r101, r102, r114, r115, r116, r117, r118);
        return;
    L33:
        r118 = r216;
        goto L34
    L29:
        r117 = r215;
        goto L31
    L25:
        r116 = r214;
        goto L27
    L21:
        r115 = r213;
        goto L23
    L17:
        r114 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
