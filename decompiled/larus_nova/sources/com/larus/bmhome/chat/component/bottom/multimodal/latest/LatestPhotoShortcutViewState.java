package com.larus.bmhome.chat.component.bottom.multimodal.latest;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutViewState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "shortcutViewState", "Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/ShortcutViewState;", "skipAttachmentPanel", "", "<init>", "(Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/ShortcutViewState;Z)V", "getShortcutViewState", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/ShortcutViewState;", "getSkipAttachmentPanel", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LatestPhotoShortcutViewState implements w1a.b {
    private final ShortcutViewState shortcutViewState;
    private final boolean skipAttachmentPanel;

    /* JADX WARN: Multi-variable type inference failed */
    public LatestPhotoShortcutViewState() {
        ShortcutViewState r100 = null;
        this(r100, false, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ LatestPhotoShortcutViewState copy$default(LatestPhotoShortcutViewState r100, ShortcutViewState r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.shortcutViewState;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.skipAttachmentPanel;
    L9:
        return r100.copy(r101, r102);
    }

    public final ShortcutViewState component1() {
        return this.shortcutViewState;
    }

    public final boolean component2() {
        return this.skipAttachmentPanel;
    }

    public final LatestPhotoShortcutViewState copy(ShortcutViewState r100, boolean r101) {
        return new LatestPhotoShortcutViewState(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LatestPhotoShortcutViewState) == true) goto L8;
        return false;
    L8:
        LatestPhotoShortcutViewState r101 = (LatestPhotoShortcutViewState) r100;
        if (Intrinsics.areEqual(this.shortcutViewState, r101.shortcutViewState) == true) goto L12;
        return false;
    L12:
        if (this.skipAttachmentPanel == r101.skipAttachmentPanel) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        ShortcutViewState r100 = this.shortcutViewState;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        if (this.skipAttachmentPanel == false) goto L9;
        int r103 = 1231;
    L11:
        return r102 + r103;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "LatestPhotoShortcutViewState(shortcutViewState=" + this.shortcutViewState + ", skipAttachmentPanel=" + this.skipAttachmentPanel + ')';
    }

    public final ShortcutViewState getShortcutViewState() {
        return this.shortcutViewState;
    }

    public final boolean getSkipAttachmentPanel() {
        return this.skipAttachmentPanel;
    }

    public LatestPhotoShortcutViewState(ShortcutViewState r100, boolean r101) {
        this.shortcutViewState = r100;
        this.skipAttachmentPanel = r101;
    }

    public /* synthetic */ LatestPhotoShortcutViewState(ShortcutViewState r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = false;
    L8:
        this(r100, r101);
    }
}
