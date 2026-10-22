package androidx.compose.foundation.text.input.internal;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u0005H\u0002J\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0086\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J2\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u0005J\u0012\u0010\u001c\u001a\u00020\u00122\n\u0010\u001d\u001a\u00060\u001ej\u0002`\u001fJ\u0006\u0010 \u001a\u00020\u0005J\b\u0010!\u001a\u00020\"H\u0016R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Landroidx/compose/foundation/text/input/internal/GapBuffer;", "", "initBuffer", "", "initGapStart", "", "initGapEnd", "<init>", "([CII)V", "capacity", "buffer", "gapStart", "gapEnd", "gapLength", "get", "", "index", "makeSureAvailableSpace", "", "requestSize", "delete", "start", "end", "replace", "text", "", "textStart", "textEnd", "append", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "length", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class GapBuffer {
    private char[] buffer;
    private int capacity;
    private int gapEnd;
    private int gapStart;

    private final int gapLength() {
        return this.gapEnd - this.gapStart;
    }

    public final int length() {
        return this.capacity - gapLength();
    }

    public String toString() {
        return "";
    }

    private final void makeSureAvailableSpace(int r6) {
        if (r6 > gapLength()) goto L5;
        return;
    L5:
        int r7 = r6 - gapLength();
        int r0 = this.capacity;
    L6:
        r0 = r0 * 2;
        if ((r0 - this.capacity) < r7) goto L6;
        char[] r8 = new char[r0];
        ArraysKt.copyInto(this.buffer, r8, 0, 0, this.gapStart);
        int r1 = this.capacity;
        int r2 = this.gapEnd;
        int r3 = r1 - r2;
        int r4 = r0 - r3;
        ArraysKt.copyInto(this.buffer, r8, r4, r2, r3 + r2);
        this.buffer = r8;
        this.capacity = r0;
        this.gapEnd = r4;
    }

    public final void append(StringBuilder r4) {
        r4.append(this.buffer, 0, this.gapStart - 0);
        char[] r0 = this.buffer;
        int r1 = this.gapEnd;
        r4.append(r0, r1, this.capacity - r1);
    }

    public final char get(int r3) {
        int r0 = this.gapStart;
        if (r3 >= r0) goto L7;
        return this.buffer[r3];
    L7:
        return this.buffer[(r3 - r0) + this.gapEnd];
    }

    private final void delete(int r5, int r6) {
        int r0 = this.gapStart;
        if (r5 >= r0) goto L6;
        if (r6 > r0) goto L6;
        int r1 = r0 - r6;
        char[] r2 = this.buffer;
        ArraysKt.copyInto(r2, r2, this.gapEnd - r1, r6, r0);
        this.gapStart = r5;
        this.gapEnd -= r1;
        return;
    L6:
        if (r5 >= r0) goto L9;
        if (r6 < r0) goto L9;
        this.gapEnd = r6 + gapLength();
        this.gapStart = r5;
        return;
    L9:
        int r7 = r5 + gapLength();
        int r8 = r6 + gapLength();
        int r3 = this.gapEnd;
        char[] r4 = this.buffer;
        ArraysKt.copyInto(r4, r4, this.gapStart, r3, r7);
        this.gapStart += r7 - r3;
        this.gapEnd = r8;
    }

    public GapBuffer(char[] r2, int r3, int r4) {
        this.capacity = r2.length;
        this.buffer = r2;
        this.gapStart = r3;
        this.gapEnd = r4;
    }

    public final void replace(int r3, int r4, CharSequence r5, int r6, int r7) {
        int r0 = r7 - r6;
        makeSureAvailableSpace(r0 - (r4 - r3));
        delete(r3, r4);
        ToCharArray_androidKt.toCharArray(r5, this.buffer, this.gapStart, r6, r7);
        this.gapStart += r0;
    }

    public static /* synthetic */ void replace$default(GapBuffer r6, int r7, int r8, CharSequence r9, int r10, int r11, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L5;
        int r4 = 0;
    L7:
        if ((r12 & 16) == 0) goto L9;
        r11 = r9.length();
    L9:
        r6.replace(r7, r8, r9, r4, r11);
        return;
    L5:
        r4 = r10;
        goto L7
    }
}
