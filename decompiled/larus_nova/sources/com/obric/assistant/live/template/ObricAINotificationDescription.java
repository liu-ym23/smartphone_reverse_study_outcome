package com.obric.assistant.live.template;

import com.obric.livecard.api.entity.Icon;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/obric/assistant/live/template/ObricAINotificationDescription;", "", "icon", "Lcom/obric/livecard/api/entity/Icon;", "text", "Lcom/obric/assistant/live/template/ObricAINotificationTemplateText;", "<init>", "(Lcom/obric/livecard/api/entity/Icon;Lcom/obric/assistant/live/template/ObricAINotificationTemplateText;)V", "getIcon", "()Lcom/obric/livecard/api/entity/Icon;", "setIcon", "(Lcom/obric/livecard/api/entity/Icon;)V", "getText", "()Lcom/obric/assistant/live/template/ObricAINotificationTemplateText;", "setText", "(Lcom/obric/assistant/live/template/ObricAINotificationTemplateText;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAINotificationDescription {
    private Icon icon;
    private ObricAINotificationTemplateText text;

    public static /* synthetic */ ObricAINotificationDescription copy$default(ObricAINotificationDescription r100, Icon r101, ObricAINotificationTemplateText r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.icon;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.text;
    L9:
        return r100.copy(r101, r102);
    }

    public final Icon component1() {
        return this.icon;
    }

    public final ObricAINotificationTemplateText component2() {
        return this.text;
    }

    public final ObricAINotificationDescription copy(Icon r100, ObricAINotificationTemplateText r101) {
        Intrinsics.checkNotNullParameter(r101, "text");
        return new ObricAINotificationDescription(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricAINotificationDescription) == true) goto L8;
        return false;
    L8:
        ObricAINotificationDescription r101 = (ObricAINotificationDescription) r100;
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Icon r100 = this.icon;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.text.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public String toString() {
        return "ObricAINotificationDescription(icon=" + this.icon + ", text=" + this.text + ')';
    }

    public final Icon getIcon() {
        return this.icon;
    }

    public final ObricAINotificationTemplateText getText() {
        return this.text;
    }

    public final void setIcon(Icon r100) {
        this.icon = r100;
    }

    public final void setText(ObricAINotificationTemplateText r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.text = r100;
    }

    public ObricAINotificationDescription(Icon r100, ObricAINotificationTemplateText r101) {
        Intrinsics.checkNotNullParameter(r101, "text");
        this.icon = r100;
        this.text = r101;
    }

    public /* synthetic */ ObricAINotificationDescription(Icon r100, ObricAINotificationTemplateText r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100, r101);
    }
}
