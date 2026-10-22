package com.bytedance.ee.bear.doc.follow.event;

import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class KeyboardStateChangedEvent implements ContentEvent {
    public final boolean forcePortrait;
    public final boolean shown;

    public int hashCode() {
        return Objects.hash(new Object[]{Boolean.valueOf(this.shown), Boolean.valueOf(this.forcePortrait)});
    }

    public String toString() {
        return "KeyboardStateChangedEvent{shown=" + this.shown + ",forcePortrait=" + this.forcePortrait + '}';
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L17;
        KeyboardStateChangedEvent r6 = (KeyboardStateChangedEvent) r5;
        if (this.shown == r6.shown) goto L13;
    L15:
        return false;
    L13:
        if (this.forcePortrait != r6.forcePortrait) goto L15;
        return true;
    }

    public KeyboardStateChangedEvent(boolean r1, boolean r2) {
        this.shown = r1;
        this.forcePortrait = r2;
    }
}
