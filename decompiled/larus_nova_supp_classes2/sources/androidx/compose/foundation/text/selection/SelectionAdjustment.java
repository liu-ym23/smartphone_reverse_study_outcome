package androidx.compose.foundation.text.selection;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bà\u0080\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "", "adjust", "Landroidx/compose/foundation/text/selection/Selection;", "layout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface SelectionAdjustment {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionAdjustment$Companion;", "", "<init>", "()V", "None", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "getNone", "()Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "Character", "getCharacter", "Word", "getWord", "Paragraph", "getParagraph", "CharacterWithWordAccelerate", "getCharacterWithWordAccelerate", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final SelectionAdjustment Character = null;
        private static final SelectionAdjustment CharacterWithWordAccelerate = null;
        private static final SelectionAdjustment None = null;
        private static final SelectionAdjustment Paragraph = null;
        private static final SelectionAdjustment Word = null;

        private Companion() {
        }

        public static /* synthetic */ Selection a(SelectionLayout r0) {
            return Character$lambda$1(r0);
        }

        public static /* synthetic */ Selection b(SelectionLayout r0) {
            return Paragraph$lambda$3(r0);
        }

        public static /* synthetic */ Selection c(SelectionLayout r0) {
            return None$lambda$0(r0);
        }

        public static /* synthetic */ Selection d(SelectionLayout r0) {
            return CharacterWithWordAccelerate$lambda$4(r0);
        }

        public static /* synthetic */ Selection e(SelectionLayout r0) {
            return Word$lambda$2(r0);
        }

        static {
            $$INSTANCE = new Companion();
            None = new l();
            Character = new m();
            Word = new n();
            Paragraph = new o();
            CharacterWithWordAccelerate = new p();
        }

        public final SelectionAdjustment getCharacter() {
            return Character;
        }

        public final SelectionAdjustment getCharacterWithWordAccelerate() {
            return CharacterWithWordAccelerate;
        }

        public final SelectionAdjustment getNone() {
            return None;
        }

        public final SelectionAdjustment getParagraph() {
            return Paragraph;
        }

        public final SelectionAdjustment getWord() {
            return Word;
        }

        private static final Selection Character$lambda$1(SelectionLayout r1) {
            return SelectionAdjustmentKt.ensureAtLeastOneChar(None.adjust(r1), r1);
        }

        private static final Selection CharacterWithWordAccelerate$lambda$4(SelectionLayout r5) {
            Selection r0 = r5.getPreviousSelection();
            if (r0 != null) goto L7;
            return Word.adjust(r5);
        L7:
            if (r5.isStartHandle() == false) goto L9;
            Selection.AnchorInfo r1 = r0.getStart();
            Selection.AnchorInfo r2 = SelectionAdjustmentKt.access$updateSelectionBoundary(r5, r5.getStartInfo(), r1);
            Selection.AnchorInfo r4 = r0.getEnd();
            Selection.AnchorInfo r3 = r2;
        L11:
            if (Intrinsics.areEqual(r2, r1) == false) goto L14;
            return r0;
        L14:
            if (r5.getCrossStatus() != CrossStatus.CROSSED) goto L16;
        L21:
            boolean r6 = true;
        L23:
            return SelectionAdjustmentKt.ensureAtLeastOneChar(new Selection(r3, r4, r6), r5);
        L16:
            if (r5.getCrossStatus() == CrossStatus.COLLAPSED) goto L18;
        L20:
            r6 = false;
            goto L23
        L18:
            if (r3.getOffset() <= r4.getOffset()) goto L20;
        L9:
            r1 = r0.getEnd();
            r2 = SelectionAdjustmentKt.access$updateSelectionBoundary(r5, r5.getEndInfo(), r1);
            r3 = r0.getStart();
            r4 = r2;
            goto L11
        }

        private static final Selection None$lambda$0(SelectionLayout r4) {
            Selection.AnchorInfo r1 = r4.getStartInfo().anchorForOffset(r4.getStartInfo().getRawStartHandleOffset());
            Selection.AnchorInfo r2 = r4.getEndInfo().anchorForOffset(r4.getEndInfo().getRawEndHandleOffset());
            if (r4.getCrossStatus() != CrossStatus.CROSSED) goto L5;
            boolean r5 = true;
        L7:
            return new Selection(r1, r2, r5);
        L5:
            r5 = false;
            goto L7
        }

        private static final Selection Paragraph$lambda$3(SelectionLayout r1) {
            return SelectionAdjustmentKt.access$adjustToBoundaries(r1, SelectionAdjustment$Companion$Paragraph$1$1.INSTANCE);
        }

        private static final Selection Word$lambda$2(SelectionLayout r1) {
            return SelectionAdjustmentKt.access$adjustToBoundaries(r1, SelectionAdjustment$Companion$Word$1$1.INSTANCE);
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    Selection adjust(SelectionLayout r1);
}
