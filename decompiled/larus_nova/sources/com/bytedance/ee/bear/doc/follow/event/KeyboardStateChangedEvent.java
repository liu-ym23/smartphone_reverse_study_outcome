package com.bytedance.ee.bear.doc.follow.event;

import java.util.Objects;

/* JADX INFO: loaded from: classes16.dex */
public class KeyboardStateChangedEvent implements ContentEvent {
    public final boolean forcePortrait;
    public final boolean shown;

    public int hashCode() {
        return Objects.hash(new Object[]{Boolean.valueOf(this.shown), Boolean.valueOf(this.forcePortrait)});
    }

    public String toString() {
        return "KeyboardStateChangedEvent{shown=" + this.shown + ",forcePortrait=" + this.forcePortrait + '}';
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L17;
        KeyboardStateChangedEvent r101 = (KeyboardStateChangedEvent) r100;
        if (this.shown == r101.shown) goto L13;
    L15:
        return false;
    L13:
        if (this.forcePortrait != r101.forcePortrait) goto L15;
        return true;
    }

    public KeyboardStateChangedEvent(boolean r100, boolean r101) {
        this.shown = r100;
        this.forcePortrait = r101;
    }
}
