package com.obric.assistant.live.template;

import com.obric.livecard.api.entity.ColorToken;
import com.obric.livecard.api.entity.Icon;
import com.obric.livecard.api.entity.Text;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\fHÆ\u0003JP\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020\t2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010 R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u00062"}, d2 = {"Lcom/obric/assistant/live/template/ObricExpandedDialogueActionButton;", "", "id", "", "icon", "Lcom/obric/livecard/api/entity/Icon;", "text", "Lcom/obric/livecard/api/entity/Text;", "dismissKeyguard", "", "backgroundColor", "color", "Lcom/obric/livecard/api/entity/ColorToken;", "<init>", "(Ljava/lang/String;Lcom/obric/livecard/api/entity/Icon;Lcom/obric/livecard/api/entity/Text;Ljava/lang/Boolean;Ljava/lang/String;Lcom/obric/livecard/api/entity/ColorToken;)V", "getId", "()Ljava/lang/String;", "getIcon", "()Lcom/obric/livecard/api/entity/Icon;", "setIcon", "(Lcom/obric/livecard/api/entity/Icon;)V", "getText", "()Lcom/obric/livecard/api/entity/Text;", "setText", "(Lcom/obric/livecard/api/entity/Text;)V", "getDismissKeyguard", "()Ljava/lang/Boolean;", "setDismissKeyguard", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getBackgroundColor", "setBackgroundColor", "(Ljava/lang/String;)V", "getColor", "()Lcom/obric/livecard/api/entity/ColorToken;", "setColor", "(Lcom/obric/livecard/api/entity/ColorToken;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Lcom/obric/livecard/api/entity/Icon;Lcom/obric/livecard/api/entity/Text;Ljava/lang/Boolean;Ljava/lang/String;Lcom/obric/livecard/api/entity/ColorToken;)Lcom/obric/assistant/live/template/ObricExpandedDialogueActionButton;", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricExpandedDialogueActionButton {
    private String backgroundColor;
    private ColorToken color;
    private Boolean dismissKeyguard;
    private Icon icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f390233id;
    private Text text;

    public static /* synthetic */ ObricExpandedDialogueActionButton copy$default(ObricExpandedDialogueActionButton r100, String r101, Icon r102, Text r103, Boolean r104, String r105, ColorToken r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.f390233id;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.icon;
    L8:
        Icon r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.text;
    L11:
        Text r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.dismissKeyguard;
    L14:
        Boolean r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.backgroundColor;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.color;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.f390233id;
    }

    public final Icon component2() {
        return this.icon;
    }

    public final Text component3() {
        return this.text;
    }

    public final Boolean component4() {
        return this.dismissKeyguard;
    }

    public final String component5() {
        return this.backgroundColor;
    }

    public final ColorToken component6() {
        return this.color;
    }

    public final ObricExpandedDialogueActionButton copy(String r100, Icon r110, Text r111, Boolean r112, String r113, ColorToken r114) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r110, "icon");
        Intrinsics.checkNotNullParameter(r111, "text");
        return new ObricExpandedDialogueActionButton(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricExpandedDialogueActionButton) == true) goto L8;
        return false;
    L8:
        ObricExpandedDialogueActionButton r101 = (ObricExpandedDialogueActionButton) r100;
        if (Intrinsics.areEqual(this.f390233id, r101.f390233id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.dismissKeyguard, r101.dismissKeyguard) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.color, r101.color) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.f390233id.hashCode() * 31) + this.icon.hashCode()) * 31) + this.text.hashCode()) * 31;
        Boolean r101 = this.dismissKeyguard;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.backgroundColor;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        ColorToken r108 = this.color;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "ObricExpandedDialogueActionButton(id=" + this.f390233id + ", icon=" + this.icon + ", text=" + this.text + ", dismissKeyguard=" + this.dismissKeyguard + ", backgroundColor=" + this.backgroundColor + ", color=" + this.color + ')';
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final ColorToken getColor() {
        return this.color;
    }

    public final Boolean getDismissKeyguard() {
        return this.dismissKeyguard;
    }

    public final Icon getIcon() {
        return this.icon;
    }

    public final String getId() {
        return this.f390233id;
    }

    public final Text getText() {
        return this.text;
    }

    public final void setBackgroundColor(String r100) {
        this.backgroundColor = r100;
    }

    public final void setColor(ColorToken r100) {
        this.color = r100;
    }

    public final void setDismissKeyguard(Boolean r100) {
        this.dismissKeyguard = r100;
    }

    public final void setIcon(Icon r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.icon = r100;
    }

    public final void setText(Text r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.text = r100;
    }

    public ObricExpandedDialogueActionButton(String r100, Icon r101, Text r102, Boolean r103, String r104, ColorToken r105) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "icon");
        Intrinsics.checkNotNullParameter(r102, "text");
        this.f390233id = r100;
        this.icon = r101;
        this.text = r102;
        this.dismissKeyguard = r103;
        this.backgroundColor = r104;
        this.color = r105;
    }

    public /* synthetic */ ObricExpandedDialogueActionButton(String r100, Icon r101, Text r110, Boolean r111, String r112, ColorToken r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        r100 = "actionBtn";
    L5:
        String r102 = r100;
        if ((r114 & 8) == 0) goto L8;
        Boolean r103 = null;
    L10:
        if ((r114 & 16) == 0) goto L12;
        String r104 = null;
    L14:
        if ((r114 & 32) == 0) goto L16;
        ColorToken r105 = null;
    L17:
        this(r102, r101, r110, r103, r104, r105);
        return;
    L16:
        r105 = r113;
        goto L17
    L12:
        r104 = r112;
        goto L14
    L8:
        r103 = r111;
        goto L10
    }
}
