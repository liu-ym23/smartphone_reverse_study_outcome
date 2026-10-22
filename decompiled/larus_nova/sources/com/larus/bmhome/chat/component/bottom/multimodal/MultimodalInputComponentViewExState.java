package com.larus.bmhome.chat.component.bottom.multimodal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/multimodal/MultimodalInputComponentViewExState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "hasAutoOpenedCamera", "", "<init>", "(Z)V", "getHasAutoOpenedCamera", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultimodalInputComponentViewExState implements w1a.b {
    private final boolean hasAutoOpenedCamera;

    public MultimodalInputComponentViewExState() {
        boolean r100 = false;
        this(r100, 1, null);
    }

    public static /* synthetic */ MultimodalInputComponentViewExState copy$default(MultimodalInputComponentViewExState r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.hasAutoOpenedCamera;
    L6:
        return r100.copy(r101);
    }

    public final boolean component1() {
        return this.hasAutoOpenedCamera;
    }

    public final MultimodalInputComponentViewExState copy(boolean r100) {
        return new MultimodalInputComponentViewExState(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MultimodalInputComponentViewExState) == true) goto L9;
        return false;
    L9:
        if (this.hasAutoOpenedCamera == ((MultimodalInputComponentViewExState) r100).hasAutoOpenedCamera) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        if (this.hasAutoOpenedCamera == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public String toString() {
        return "MultimodalInputComponentViewExState(hasAutoOpenedCamera=" + this.hasAutoOpenedCamera + ')';
    }

    public final boolean getHasAutoOpenedCamera() {
        return this.hasAutoOpenedCamera;
    }

    public MultimodalInputComponentViewExState(boolean r100) {
        this.hasAutoOpenedCamera = r100;
    }

    public /* synthetic */ MultimodalInputComponentViewExState(boolean r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = false;
    L5:
        this(r100);
    }
}
