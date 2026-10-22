package com.obric.assistant.live.template;

import com.obric.livecard.api.entity.Icon;
import com.obric.livecard.api.entity.IslandWidget;
import com.obric.livecard.api.entity.Text;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0001'B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\u0010\u001aJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J9\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010 \u001a\u00020\u00192\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011¨\u0006("}, d2 = {"Lcom/obric/assistant/live/template/ObricCommonCollapsedTemplate;", "Lcom/obric/assistant/live/template/IObricTemplate;", "endIcon", "Lcom/obric/livecard/api/entity/Icon;", "endText", "Lcom/obric/livecard/api/entity/Text;", "startIcon", "startText", "<init>", "(Lcom/obric/livecard/api/entity/Icon;Lcom/obric/livecard/api/entity/Text;Lcom/obric/livecard/api/entity/Icon;Lcom/obric/livecard/api/entity/Text;)V", "getEndIcon", "()Lcom/obric/livecard/api/entity/Icon;", "setEndIcon", "(Lcom/obric/livecard/api/entity/Icon;)V", "getEndText", "()Lcom/obric/livecard/api/entity/Text;", "setEndText", "(Lcom/obric/livecard/api/entity/Text;)V", "getStartIcon", "setStartIcon", "getStartText", "setStartText", "create", "Lcom/obric/livecard/api/entity/IslandWidget;", "isDefault", "", "(Ljava/lang/Boolean;)Lcom/obric/livecard/api/entity/IslandWidget;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricCommonCollapsedTemplate implements IObricTemplate {
    public static final a Companion = null;
    private static final String TEMPLATE_ID = "com.obric.island_assistant:common_collapse_template";
    private Icon endIcon;
    private Text endText;
    private Icon startIcon;
    private Text startText;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ObricCommonCollapsedTemplate() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ObricCommonCollapsedTemplate copy$default(ObricCommonCollapsedTemplate r100, Icon r101, Text r102, Icon r103, Text r104, int r105, Object r106) {
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

    public final ObricCommonCollapsedTemplate copy(Icon r100, Text r101, Icon r102, Text r103) {
        return new ObricCommonCollapsedTemplate(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricCommonCollapsedTemplate) == true) goto L8;
        return false;
    L8:
        ObricCommonCollapsedTemplate r101 = (ObricCommonCollapsedTemplate) r100;
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
        return "ObricCommonCollapsedTemplate(endIcon=" + this.endIcon + ", endText=" + this.endText + ", startIcon=" + this.startIcon + ", startText=" + this.startText + ')';
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

    @Override // com.obric.assistant.live.template.IObricTemplate
    public IslandWidget create(Boolean r110) {
        return new IslandWidget(TEMPLATE_ID, this, r110, null, null, null, null, null, null, 504, null);
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

    public ObricCommonCollapsedTemplate(Icon r100, Text r101, Icon r102, Text r103) {
        this.endIcon = r100;
        this.endText = r101;
        this.startIcon = r102;
        this.startText = r103;
    }

    public /* synthetic */ ObricCommonCollapsedTemplate(Icon r100, Text r101, Icon r102, Text r103, int r104, DefaultConstructorMarker r105) {
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
