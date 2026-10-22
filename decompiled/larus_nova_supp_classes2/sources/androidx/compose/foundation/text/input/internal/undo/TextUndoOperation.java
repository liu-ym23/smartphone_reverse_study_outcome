package androidx.compose.foundation.text.input.internal.undo;

import androidx.compose.foundation.text.UndoManager_jvmKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 $2\u00020\u0001:\u0001$BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0007\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\t\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;", "", "index", "", "preText", "", "postText", "preSelection", "Landroidx/compose/ui/text/TextRange;", "postSelection", "timeInMillis", "", "canMerge", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;JJJZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIndex", "()I", "getPreText", "()Ljava/lang/String;", "getPostText", "getPreSelection-d9O1mEE", "()J", "J", "getPostSelection-d9O1mEE", "getTimeInMillis", "getCanMerge", "()Z", "textEditType", "Landroidx/compose/foundation/text/input/internal/undo/TextEditType;", "getTextEditType", "()Landroidx/compose/foundation/text/input/internal/undo/TextEditType;", "deletionType", "Landroidx/compose/foundation/text/input/internal/undo/TextDeleteType;", "getDeletionType", "()Landroidx/compose/foundation/text/input/internal/undo/TextDeleteType;", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextUndoOperation {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final Saver<TextUndoOperation, Object> Saver = null;
    private final boolean canMerge;
    private final int index;
    private final long postSelection;
    private final String postText;
    private final long preSelection;
    private final String preText;
    private final TextEditType textEditType;
    private final long timeInMillis;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final Saver<TextUndoOperation, Object> getSaver() {
            return TextUndoOperation.access$getSaver$cp();
        }
    }

    public /* synthetic */ TextUndoOperation(int r1, String r2, String r3, long r4, long r6, long r8, boolean r10, DefaultConstructorMarker r11) {
        this(r1, r2, r3, r4, r6, r8, r10);
    }

    static {
        Companion = new Companion(null);
        Saver = new TextUndoOperation$Companion$Saver$1();
    }

    public final TextDeleteType getDeletionType() {
        if (this.textEditType == TextEditType.Delete) goto L7;
        return TextDeleteType.NotByUser;
    L7:
        if (TextRange.getCollapsed-impl(this.postSelection) == true) goto L11;
        return TextDeleteType.NotByUser;
    L11:
        if (TextRange.getCollapsed-impl(this.preSelection) == false) goto L18;
        if (TextRange.getStart-impl(this.preSelection) <= TextRange.getStart-impl(this.postSelection)) goto L16;
        return TextDeleteType.Start;
    L16:
        return TextDeleteType.End;
    L18:
        if (TextRange.getStart-impl(this.preSelection) != TextRange.getStart-impl(this.postSelection)) goto L24;
        if (TextRange.getStart-impl(this.preSelection) != this.index) goto L24;
        return TextDeleteType.Inner;
    L24:
        return TextDeleteType.NotByUser;
    }

    public static final /* synthetic */ Saver access$getSaver$cp() {
        return Saver;
    }

    public final boolean getCanMerge() {
        return this.canMerge;
    }

    public final int getIndex() {
        return this.index;
    }

    /* JADX INFO: renamed from: getPostSelection-d9O1mEE, reason: not valid java name */
    public final long m1735getPostSelectiond9O1mEE() {
        return this.postSelection;
    }

    public final String getPostText() {
        return this.postText;
    }

    /* JADX INFO: renamed from: getPreSelection-d9O1mEE, reason: not valid java name */
    public final long m1736getPreSelectiond9O1mEE() {
        return this.preSelection;
    }

    public final String getPreText() {
        return this.preText;
    }

    public final TextEditType getTextEditType() {
        return this.textEditType;
    }

    public final long getTimeInMillis() {
        return this.timeInMillis;
    }

    private TextUndoOperation(int r1, String r2, String r3, long r4, long r6, long r8, boolean r10) {
        this.index = r1;
        this.preText = r2;
        this.postText = r3;
        this.preSelection = r4;
        this.postSelection = r6;
        this.timeInMillis = r8;
        this.canMerge = r10;
        boolean r5 = true;
        if (r2.length() != 0) goto L5;
        boolean r7 = true;
    L6:
        if (r7 == false) goto L16;
        if (r3.length() != 0) goto L10;
        boolean r9 = true;
    L11:
        if (r9 == false) goto L16;
        throw new IllegalArgumentException("Either pre or post text must not be empty");
    L10:
        r9 = false;
    L16:
        if (r2.length() != 0) goto L18;
        boolean r11 = true;
    L19:
        if (r11 == false) goto L27;
        if (r3.length() <= 0) goto L23;
        boolean r12 = true;
    L24:
        if (r12 == false) goto L27;
        TextEditType r13 = TextEditType.Insert;
    L38:
        this.textEditType = r13;
        return;
    L23:
        r12 = false;
    L27:
        if (r2.length() <= 0) goto L29;
        boolean r14 = true;
    L30:
        if (r14 == true) goto L32;
    L37:
        r13 = TextEditType.Replace;
        goto L38
    L32:
        if (r3.length() == 0) goto L35;
        r5 = false;
    L35:
        if (r5 == false) goto L37;
        r13 = TextEditType.Delete;
        goto L38
    L29:
        r14 = false;
        goto L30
    L18:
        r11 = false;
        goto L19
    L5:
        r7 = false;
        goto L6
    }

    public /* synthetic */ TextUndoOperation(int r15, String r16, String r17, long r18, long r20, long r22, boolean r24, int r25, DefaultConstructorMarker r26) {
        if ((r25 & 32) == 0) goto L5;
        long r10 = UndoManager_jvmKt.timeNowMillis();
    L7:
        if ((r25 & 64) == 0) goto L9;
        boolean r12 = true;
    L10:
        this(r15, r16, r17, r18, r20, r10, r12, null);
        return;
    L9:
        r12 = r24;
        goto L10
    L5:
        r10 = r22;
        goto L7
    }
}
