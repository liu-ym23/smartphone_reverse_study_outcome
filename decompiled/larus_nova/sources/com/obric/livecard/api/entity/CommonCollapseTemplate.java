package com.obric.livecard.api.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J9\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0017\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006%"}, d2 = {"Lcom/obric/livecard/api/entity/CommonCollapseTemplate;", "", "endIcon", "Lcom/obric/livecard/api/entity/Icon;", "endText", "Lcom/obric/livecard/api/entity/Text;", "startIcon", "startText", "(Lcom/obric/livecard/api/entity/Icon;Lcom/obric/livecard/api/entity/Text;Lcom/obric/livecard/api/entity/Icon;Lcom/obric/livecard/api/entity/Text;)V", "getEndIcon", "()Lcom/obric/livecard/api/entity/Icon;", "setEndIcon", "(Lcom/obric/livecard/api/entity/Icon;)V", "getEndText", "()Lcom/obric/livecard/api/entity/Text;", "setEndText", "(Lcom/obric/livecard/api/entity/Text;)V", "getStartIcon", "setStartIcon", "getStartText", "setStartText", "component1", "component2", "component3", "component4", "copy", "create", "Lcom/obric/livecard/api/entity/IslandWidget;", "isDefault", "", "(Ljava/lang/Boolean;)Lcom/obric/livecard/api/entity/IslandWidget;", "equals", "other", "hashCode", "", "toString", "", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CommonCollapseTemplate {
    private Icon endIcon;
    private Text endText;
    private Icon startIcon;
    private Text startText;

    public CommonCollapseTemplate() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ CommonCollapseTemplate copy$default(CommonCollapseTemplate r100, Icon r101, Text r102, Icon r103, Text r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.endIcon;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.endText;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.startIcon;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.startText;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Icon component1() {
        return this.endIcon;
    }

    public final Text component2() {
        return this.endText;
    }

    public final Icon component3() {
        return this.startIcon;
    }

    public final Text component4() {
        return this.startText;
    }

    public final CommonCollapseTemplate copy(Icon r100, Text r101, Icon r102, Text r103) {
        return new CommonCollapseTemplate(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CommonCollapseTemplate) == true) goto L8;
        return false;
    L8:
        CommonCollapseTemplate r101 = (CommonCollapseTemplate) r100;
        if (Intrinsics.areEqual(this.endIcon, r101.endIcon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.endText, r101.endText) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.startIcon, r101.startIcon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.startText, r101.startText) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Icon r100 = this.endIcon;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Text r104 = this.endText;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Icon r107 = this.startIcon;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Text r110 = this.startText;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "CommonCollapseTemplate(endIcon=" + this.endIcon + ", endText=" + this.endText + ", startIcon=" + this.startIcon + ", startText=" + this.startText + ')';
    }

    public final Icon getEndIcon() {
        return this.endIcon;
    }

    public final Text getEndText() {
        return this.endText;
    }

    public final Icon getStartIcon() {
        return this.startIcon;
    }

    public final Text getStartText() {
        return this.startText;
    }

    public final IslandWidget create(Boolean r110) {
        return new IslandWidget("com.obric.island_applet:common_collapse_template", this, r110, null, null, null, null, null, null, 504, null);
    }

    public final void setEndIcon(Icon r100) {
        this.endIcon = r100;
    }

    public final void setEndText(Text r100) {
        this.endText = r100;
    }

    public final void setStartIcon(Icon r100) {
        this.startIcon = r100;
    }

    public final void setStartText(Text r100) {
        this.startText = r100;
    }

    public CommonCollapseTemplate(Icon r100, Text r101, Icon r102, Text r103) {
        this.endIcon = r100;
        this.endText = r101;
        this.startIcon = r102;
        this.startText = r103;
    }

    public static /* synthetic */ IslandWidget create$default(CommonCollapseTemplate r100, Boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = Boolean.FALSE;
    L6:
        return r100.create(r101);
    }

    public /* synthetic */ CommonCollapseTemplate(Icon r100, Text r101, Icon r102, Text r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
