package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0001\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J2\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\bJ\u0011\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bH\u0096\u0002J\u0018\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0001R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/text/input/internal/PartialGapBuffer;", "", "text", "<init>", "(Ljava/lang/CharSequence;)V", "buffer", "Landroidx/compose/foundation/text/input/internal/GapBuffer;", "bufStart", "", "bufEnd", "length", "getLength", "()I", "replace", "", "start", "end", "textStart", "textEnd", "get", "", "index", "subSequence", "startIndex", "endIndex", "toString", "", "contentEquals", "", "other", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PartialGapBuffer implements CharSequence {
    public static final int $stable = 0;
    public static final int BUF_SIZE = 255;
    public static final Companion Companion = null;
    public static final int NOWHERE = -1;
    public static final int SURROUNDING_SIZE = 64;
    private int bufEnd;
    private int bufStart;
    private GapBuffer buffer;
    private CharSequence text;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/text/input/internal/PartialGapBuffer$Companion;", "", "<init>", "()V", "BUF_SIZE", "", "SURROUNDING_SIZE", "NOWHERE", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    public int getLength() {
        GapBuffer r0 = this.buffer;
        if (r0 != null) goto L7;
        return this.text.length();
    L7:
        return (this.text.length() - (this.bufEnd - this.bufStart)) + r0.length();
    }

    @Override // java.lang.CharSequence
    public String toString() {
        GapBuffer r0 = this.buffer;
        if (r0 == null) goto L5;
        StringBuilder r1 = new StringBuilder();
        r1.append(this.text, 0, this.bufStart);
        r0.append(r1);
        CharSequence r2 = this.text;
        r1.append(r2, this.bufEnd, r2.length());
        return r1.toString();
    L5:
        return this.text.toString();
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return getLength();
    }

    public PartialGapBuffer(CharSequence r1) {
        this.text = r1;
        this.bufStart = -1;
        this.bufEnd = -1;
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int r1) {
        return get(r1);
    }

    public final boolean contentEquals(CharSequence r2) {
        return Intrinsics.areEqual(toString(), r2.toString());
    }

    public char get(int r5) {
        GapBuffer r0 = this.buffer;
        if (r0 != null) goto L7;
        return this.text.charAt(r5);
    L7:
        if (r5 < this.bufStart) goto L9;
        int r1 = r0.length();
        int r2 = this.bufStart;
        if (r5 >= (r1 + r2)) goto L15;
        return r0.get(r5 - r2);
    L15:
        return this.text.charAt(r5 - ((r1 - this.bufEnd) + r2));
    L9:
        return this.text.charAt(r5);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int r2, int r3) {
        return toString().subSequence(r2, r3);
    }

    public final void replace(int r9, int r10, CharSequence r11, int r12, int r13) {
        boolean r0 = true;
        if (r9 > r10) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("start=" + r9 + " > end=" + r10);
    L8:
        if (r12 > r13) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == true) goto L13;
        InlineClassHelperKt.throwIllegalArgumentException("textStart=" + r12 + " > textEnd=" + r13);
    L13:
        if (r9 < 0) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == true) goto L18;
        InlineClassHelperKt.throwIllegalArgumentException("start must be non-negative, but was " + r9);
    L18:
        if (r12 >= 0) goto L21;
        r0 = false;
    L21:
        if (r0 == true) goto L23;
        InlineClassHelperKt.throwIllegalArgumentException("textStart must be non-negative, but was " + r12);
    L23:
        GapBuffer r5 = this.buffer;
        int r1 = r13 - r12;
        if (r5 != null) goto L27;
        int r6 = Math.max(255, r1 + 128);
        char[] r7 = new char[r6];
        int r8 = Math.min(r9, 64);
        int r14 = Math.min(this.text.length() - r10, 64);
        int r15 = r9 - r8;
        ToCharArray_androidKt.toCharArray(this.text, r7, 0, r15, r9);
        int r16 = r6 - r14;
        int r17 = r14 + r10;
        ToCharArray_androidKt.toCharArray(this.text, r7, r16, r10, r17);
        ToCharArray_androidKt.toCharArray(r11, r7, r8, r12, r13);
        this.buffer = new GapBuffer(r7, r8 + r1, r16);
        this.bufStart = r15;
        this.bufEnd = r17;
        return;
    L27:
        int r18 = this.bufStart;
        int r19 = r9 - r18;
        int r20 = r10 - r18;
        if (r19 >= 0) goto L30;
    L34:
        this.text = toString();
        this.buffer = null;
        this.bufStart = -1;
        this.bufEnd = -1;
        replace(r9, r10, r11, r12, r13);
        return;
    L30:
        if (r20 > r5.length()) goto L34;
        r5.replace(r19, r20, r11, r12, r13);
        return;
    L15:
        r4 = false;
        goto L16
    L10:
        r3 = false;
        goto L11
    L5:
        r2 = false;
        goto L6
    }

    public static /* synthetic */ void replace$default(PartialGapBuffer r6, int r7, int r8, CharSequence r9, int r10, int r11, int r12, Object r13) {
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
