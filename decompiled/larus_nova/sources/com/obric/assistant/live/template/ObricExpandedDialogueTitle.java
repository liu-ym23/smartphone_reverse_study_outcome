package com.obric.assistant.live.template;

import com.obric.livecard.api.entity.Icon;
import com.obric.livecard.api.entity.Text;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/obric/assistant/live/template/ObricExpandedDialogueTitle;", "", "icon", "Lcom/obric/livecard/api/entity/Icon;", "text", "Lcom/obric/livecard/api/entity/Text;", "<init>", "(Lcom/obric/livecard/api/entity/Icon;Lcom/obric/livecard/api/entity/Text;)V", "getIcon", "()Lcom/obric/livecard/api/entity/Icon;", "setIcon", "(Lcom/obric/livecard/api/entity/Icon;)V", "getText", "()Lcom/obric/livecard/api/entity/Text;", "setText", "(Lcom/obric/livecard/api/entity/Text;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricExpandedDialogueTitle {
    private Icon icon;
    private Text text;

    public static /* synthetic */ ObricExpandedDialogueTitle copy$default(ObricExpandedDialogueTitle r100, Icon r101, Text r102, int r103, Object r104) {
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

    public final Text component2() {
        return this.text;
    }

    public final ObricExpandedDialogueTitle copy(Icon r100, Text r101) {
        Intrinsics.checkNotNullParameter(r100, "icon");
        Intrinsics.checkNotNullParameter(r101, "text");
        return new ObricExpandedDialogueTitle(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricExpandedDialogueTitle) == true) goto L8;
        return false;
    L8:
        ObricExpandedDialogueTitle r101 = (ObricExpandedDialogueTitle) r100;
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.icon.hashCode() * 31) + this.text.hashCode();
    }

    public String toString() {
        return "ObricExpandedDialogueTitle(icon=" + this.icon + ", text=" + this.text + ')';
    }

    public final Icon getIcon() {
        return this.icon;
    }

    public final Text getText() {
        return this.text;
    }

    public final void setIcon(Icon r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.icon = r100;
    }

    public final void setText(Text r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.text = r100;
    }

    public ObricExpandedDialogueTitle(Icon r100, Text r101) {
        Intrinsics.checkNotNullParameter(r100, "icon");
        Intrinsics.checkNotNullParameter(r101, "text");
        this.icon = r100;
        this.text = r101;
    }
}
