package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.text.input.internal.IndexTransformationType;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.WedgeAffinity;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"calculateNextCursorPositionAndWedgeAffinity", "Landroidx/compose/foundation/text/input/internal/selection/CursorAndWedgeAffinity;", "proposedCursor", "", "cursor", "transformedTextFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "(IILandroidx/compose/foundation/text/input/internal/TransformedTextFieldState;)J", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextPreparedSelectionKt {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[IndexTransformationType.values().length];
            r0[IndexTransformationType.Untransformed.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[IndexTransformationType.Deletion.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[IndexTransformationType.Replacement.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[IndexTransformationType.Insertion.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static final long calculateNextCursorPositionAndWedgeAffinity(int r5, int r6, TransformedTextFieldState r7) {
        if (r5 != (-1)) goto L7;
        return CursorAndWedgeAffinity.m1689constructorimpl(r6);
    L7:
        if (r5 <= r6) goto L9;
        boolean r8 = true;
    L10:
        long r1 = r7.m1674mapFromTransformedjx7JFs(r5);
        long r3 = r7.m1677mapToTransformedGEjPoXI(r1);
        if (TextRange.getCollapsed-impl(r1) == false) goto L16;
        if (TextRange.getCollapsed-impl(r3) == false) goto L16;
        IndexTransformationType r9 = IndexTransformationType.Untransformed;
    L26:
        int r10 = WhenMappings.$EnumSwitchMapping$0[r9.ordinal()];
        if (r10 != 1) goto L29;
        if (r8 == false) goto L51;
        WedgeAffinity r11 = WedgeAffinity.Start;
    L53:
        return CursorAndWedgeAffinity.m1690constructorimpl(r5, r11);
    L51:
        r11 = WedgeAffinity.End;
        goto L53
    L29:
        if (r10 == 2) goto L60;
        if (r10 != 3) goto L33;
        if (r8 == false) goto L59;
        return CursorAndWedgeAffinity.m1690constructorimpl(TextRange.getEnd-impl(r3), WedgeAffinity.Start);
    L59:
        return CursorAndWedgeAffinity.m1690constructorimpl(TextRange.getStart-impl(r3), WedgeAffinity.End);
    L33:
        if (r10 != 4) goto L44;
        if (r8 == false) goto L40;
        if (r5 != TextRange.getStart-impl(r3)) goto L55;
        return CursorAndWedgeAffinity.m1690constructorimpl(r5, WedgeAffinity.Start);
    L55:
        return CursorAndWedgeAffinity.m1690constructorimpl(TextRange.getEnd-impl(r3), WedgeAffinity.End);
    L40:
        if (r5 != TextRange.getEnd-impl(r3)) goto L57;
        return CursorAndWedgeAffinity.m1690constructorimpl(r5, WedgeAffinity.End);
    L57:
        return CursorAndWedgeAffinity.m1690constructorimpl(TextRange.getStart-impl(r3), WedgeAffinity.Start);
    L44:
        throw new NoWhenBranchMatchedException();
    L60:
        return CursorAndWedgeAffinity.m1689constructorimpl(r5);
    L16:
        if (TextRange.getCollapsed-impl(r1) == true) goto L21;
        if (TextRange.getCollapsed-impl(r3) == true) goto L21;
        r9 = IndexTransformationType.Replacement;
    L21:
        if (TextRange.getCollapsed-impl(r1) == true) goto L23;
    L25:
        r9 = IndexTransformationType.Deletion;
        goto L26
    L23:
        if (TextRange.getCollapsed-impl(r3) == true) goto L25;
        r9 = IndexTransformationType.Insertion;
        goto L26
    L9:
        r8 = false;
        goto L10
    }
}
