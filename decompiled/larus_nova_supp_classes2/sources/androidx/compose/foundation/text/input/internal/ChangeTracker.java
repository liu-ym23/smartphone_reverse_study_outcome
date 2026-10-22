package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001:\u0001!B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nJ\u0006\u0010\u0012\u001a\u00020\u000eJ\u0017\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0019\u0010\u0017J\b\u0010\u001a\u001a\u00020\u001bH\u0016J*\u0010\u001c\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\nH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\""}, d2 = {"Landroidx/compose/foundation/text/input/internal/ChangeTracker;", "Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "initialChanges", "<init>", "(Landroidx/compose/foundation/text/input/internal/ChangeTracker;)V", "_changes", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/text/input/internal/ChangeTracker$Change;", "_changesTemp", "changeCount", "", "getChangeCount", "()I", "trackChange", "", "preStart", "preEnd", "postLength", "clearChanges", "getRange", "Landroidx/compose/ui/text/TextRange;", "changeIndex", "getRange--jx7JFs", "(I)J", "getOriginalRange", "getOriginalRange--jx7JFs", "toString", "", "appendNewChange", "mergedOverlappingChange", "preMin", "preMax", "postDelta", "Change", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ChangeTracker implements TextFieldBuffer.ChangeList {
    public static final int $stable = 8;
    private MutableVector<Change> _changes;
    private MutableVector<Change> _changesTemp;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/text/input/internal/ChangeTracker$Change;", "", "preStart", "", "preEnd", "originalStart", "originalEnd", "<init>", "(IIII)V", "getPreStart", "()I", "setPreStart", "(I)V", "getPreEnd", "setPreEnd", "getOriginalStart", "setOriginalStart", "getOriginalEnd", "setOriginalEnd", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Change {
        private int originalEnd;
        private int originalStart;
        private int preEnd;
        private int preStart;

        public static /* synthetic */ Change copy$default(Change r0, int r1, int r2, int r3, int r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.preStart;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.preEnd;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.originalStart;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.originalEnd;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final int component1() {
            return this.preStart;
        }

        public final int component2() {
            return this.preEnd;
        }

        public final int component3() {
            return this.originalStart;
        }

        public final int component4() {
            return this.originalEnd;
        }

        public final Change copy(int r2, int r3, int r4, int r5) {
            return new Change(r2, r3, r4, r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Change) == true) goto L8;
            return false;
        L8:
            Change r6 = (Change) r5;
            if (this.preStart == r6.preStart) goto L12;
            return false;
        L12:
            if (this.preEnd == r6.preEnd) goto L15;
            return false;
        L15:
            if (this.originalStart == r6.originalStart) goto L18;
            return false;
        L18:
            if (this.originalEnd == r6.originalEnd) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.preStart * 31) + this.preEnd) * 31) + this.originalStart) * 31) + this.originalEnd;
        }

        public String toString() {
            return "Change(preStart=" + this.preStart + ", preEnd=" + this.preEnd + ", originalStart=" + this.originalStart + ", originalEnd=" + this.originalEnd + ')';
        }

        public final int getOriginalEnd() {
            return this.originalEnd;
        }

        public final int getOriginalStart() {
            return this.originalStart;
        }

        public final int getPreEnd() {
            return this.preEnd;
        }

        public final int getPreStart() {
            return this.preStart;
        }

        public final void setOriginalEnd(int r1) {
            this.originalEnd = r1;
        }

        public final void setOriginalStart(int r1) {
            this.originalStart = r1;
        }

        public final void setPreEnd(int r1) {
            this.preEnd = r1;
        }

        public final void setPreStart(int r1) {
            this.preStart = r1;
        }

        public Change(int r1, int r2, int r3, int r4) {
            this.preStart = r1;
            this.preEnd = r2;
            this.originalStart = r3;
            this.originalEnd = r4;
        }
    }

    public ChangeTracker() {
        ChangeTracker r0 = null;
        this(r0, 1, r0);
    }

    public final void clearChanges() {
        this._changes.clear();
    }

    @Override // androidx.compose.foundation.text.input.TextFieldBuffer.ChangeList
    public int getChangeCount() {
        return this._changes.getSize();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("ChangeList(changes=[");
        MutableVector<Change> r1 = this._changes;
        Object[] r2 = r1.content;
        int r3 = r1.getSize();
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L8;
        Change r5 = (Change) r2[r4];
        r0.append("(" + r5.getOriginalStart() + ',' + r5.getOriginalEnd() + ")->(" + r5.getPreStart() + ',' + r5.getPreEnd() + ')');
        if (r4 >= (getChangeCount() - 1)) goto L7;
        r0.append(", ");
    L7:
        r4 = r4 + 1;
        goto L3
    L8:
        r0.append("])");
        return r0.toString();
    }

    public ChangeTracker(ChangeTracker r9) {
        int r3 = 0;
        this._changes = new MutableVector(new Change[16], 0);
        this._changesTemp = new MutableVector(new Change[16], 0);
        if (r9 == null) goto L9;
        MutableVector<Change> r10 = r9._changes;
        if (r10 == null) goto L11;
        Object[] r0 = r10.content;
        int r11 = r10.getSize();
    L7:
        if (r3 >= r11) goto L12;
        Change r1 = (Change) r0[r3];
        this._changes.add(new Change(r1.getPreStart(), r1.getPreEnd(), r1.getOriginalStart(), r1.getOriginalEnd()));
        r3 = r3 + 1;
        goto L7
    L12:
        return;
    L11:
        return;
    }

    @Override // androidx.compose.foundation.text.input.TextFieldBuffer.ChangeList
    /* JADX INFO: renamed from: getOriginalRange--jx7JFs */
    public long mo1531getOriginalRangejx7JFs(int r3) {
        Change r4 = (Change) this._changes.content[r3];
        return TextRangeKt.TextRange(r4.getOriginalStart(), r4.getOriginalEnd());
    }

    @Override // androidx.compose.foundation.text.input.TextFieldBuffer.ChangeList
    /* JADX INFO: renamed from: getRange--jx7JFs */
    public long mo1532getRangejx7JFs(int r3) {
        Change r4 = (Change) this._changes.content[r3];
        return TextRangeKt.TextRange(r4.getPreStart(), r4.getPreEnd());
    }

    public /* synthetic */ ChangeTracker(ChangeTracker r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public final void trackChange(int r9, int r10, int r11) {
        if (r9 != r10) goto L5;
        if (r11 != 0) goto L5;
        return;
    L5:
        int r0 = Math.min(r9, r10);
        int r12 = Math.max(r9, r10);
        int r13 = r11 - (r12 - r0);
        Change r1 = null;
        int r2 = 0;
        boolean r3 = false;
    L7:
        if (r2 >= this._changes.getSize()) goto L44;
        Change r4 = (Change) this._changes.content[r2];
        int r5 = r4.getPreStart();
        if (r0 > r5) goto L12;
        if (r5 > r12) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == true) goto L40;
        int r7 = r4.getPreEnd();
        if (r0 > r7) goto L18;
        if (r7 > r12) goto L18;
        boolean r8 = true;
    L19:
        if (r8 == true) goto L40;
        int r14 = r4.getPreStart();
        if (r0 > r4.getPreEnd()) goto L24;
        if (r14 > r0) goto L24;
        boolean r15 = true;
    L25:
        if (r15 == true) goto L40;
        int r16 = r4.getPreStart();
        if (r12 > r4.getPreEnd()) goto L30;
        if (r16 > r12) goto L30;
        boolean r17 = true;
    L31:
        if (r17 == true) goto L40;
        if (r4.getPreStart() <= r12) goto L37;
        if (r3 == true) goto L37;
        appendNewChange(r1, r0, r12, r13);
        r3 = true;
    L37:
        if (r3 == false) goto L39;
        r4.setPreStart(r4.getPreStart() + r13);
        r4.setPreEnd(r4.getPreEnd() + r13);
    L39:
        this._changesTemp.add(r4);
    L43:
        r2 = r2 + 1;
    L30:
        r17 = false;
    L24:
        r15 = false;
    L18:
        r8 = false;
    L40:
        if (r1 != null) goto L42;
        r1 = r4;
        goto L43
    L42:
        r1.setPreEnd(r4.getPreEnd());
        r1.setOriginalEnd(r4.getOriginalEnd());
    L12:
        r6 = false;
        goto L13
    L44:
        if (r3 == true) goto L46;
        appendNewChange(r1, r0, r12, r13);
    L46:
        MutableVector<Change> r18 = this._changes;
        this._changes = this._changesTemp;
        this._changesTemp = r18;
        r18.clear();
    }

    private final void appendNewChange(Change r3, int r4, int r5, int r6) {
        int r1 = 0;
        if (this._changesTemp.getSize() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        Change r2 = (Change) this._changesTemp.last();
        r1 = r2.getPreEnd() - r2.getOriginalEnd();
    L9:
        if (r3 != null) goto L12;
        int r7 = r4 - r1;
        int r8 = (r5 - r4) + r7;
        r3 = new Change(r4, r5 + r6, r7, r8);
    L18:
        this._changesTemp.add(r3);
        return;
    L12:
        if (r3.getPreStart() <= r4) goto L15;
        r3.setPreStart(r4);
        r3.setOriginalStart(r4);
    L15:
        if (r5 <= r3.getPreEnd()) goto L17;
        int r9 = r3.getPreEnd() - r3.getOriginalEnd();
        r3.setPreEnd(r5);
        r3.setOriginalEnd(r5 - r9);
    L17:
        r3.setPreEnd(r3.getPreEnd() + r6);
        goto L18
    L5:
        r0 = false;
        goto L6
    }
}
