package androidx.compose.foundation.text.input.internal;

import android.os.CancellationSignal;
import android.view.inputmethod.DeleteGesture;
import android.view.inputmethod.DeleteRangeGesture;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.InsertGesture;
import android.view.inputmethod.JoinOrSplitGesture;
import android.view.inputmethod.PreviewableHandwritingGesture;
import android.view.inputmethod.RemoveSpaceGesture;
import android.view.inputmethod.SelectGesture;
import android.view.inputmethod.SelectRangeGesture;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextHighlightType;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextGranularity;
import androidx.compose.ui.text.TextInclusionStrategy;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteSurroundingTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.SetSelectionCommand;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0000¢\u0006\u0002\b\u0010J+\u0010\u0011\u001a\u00020\u0012*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0000¢\u0006\u0002\b\u0016J,\u0010\u0017\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J\u001c\u0010\u001a\u001a\u00020\r*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010\u001b\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010\u001d\u001a\u00020\r*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\nH\u0002J,\u0010\u001e\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J\u001c\u0010 \u001a\u00020\r*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010!\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\"2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010#\u001a\u00020\r*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\"2\u0006\u0010\t\u001a\u00020\nH\u0002J&\u0010$\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0018\u001a\u00020%2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J&\u0010&\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0018\u001a\u00020'2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J&\u0010(\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0018\u001a\u00020)2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J#\u0010*\u001a\u00020\r*\u00020\u00062\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0012H\u0002¢\u0006\u0004\b.\u0010/J\u0014\u00100\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\bH\u0002J#\u00101\u001a\u00020\r*\u00020\u00062\u0006\u00102\u001a\u00020,2\u0006\u00103\u001a\u000204H\u0002¢\u0006\u0004\b5\u00106JA\u0010\u0004\u001a\u00020\u0005*\u0002072\u0006\u0010\u0018\u001a\u00020\b2\b\u00108\u001a\u0004\u0018\u0001092\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0000¢\u0006\u0002\b\u0010J-\u0010\u0011\u001a\u00020\u0012*\u0002072\u0006\u0010\u0018\u001a\u00020\u00132\b\u00108\u001a\u0004\u0018\u0001092\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0000¢\u0006\u0002\b\u0016J2\u0010\u0017\u001a\u00020\u0005*\u0002072\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010=\u001a\u0004\u0018\u0001092\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002J\u001e\u0010\u001a\u001a\u00020\r*\u0002072\u0006\u0010\u0018\u001a\u00020\u00192\b\u00108\u001a\u0004\u0018\u000109H\u0002J0\u0010\u001b\u001a\u00020\u0005*\u0002072\u0006\u0010\u0018\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020?2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002J\u001e\u0010\u001d\u001a\u00020\r*\u0002072\u0006\u0010\u0018\u001a\u00020\u001c2\b\u00108\u001a\u0004\u0018\u000109H\u0002J2\u0010\u001e\u001a\u00020\u0005*\u0002072\u0006\u0010\u0018\u001a\u00020\u001f2\b\u0010=\u001a\u0004\u0018\u0001092\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002J\u001e\u0010 \u001a\u00020\r*\u0002072\u0006\u0010\u0018\u001a\u00020\u001f2\b\u00108\u001a\u0004\u0018\u000109H\u0002J0\u0010!\u001a\u00020\u0005*\u0002072\u0006\u0010\u0018\u001a\u00020\"2\u0006\u0010>\u001a\u00020?2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002J\u001e\u0010#\u001a\u00020\r*\u0002072\u0006\u0010\u0018\u001a\u00020\"2\b\u00108\u001a\u0004\u0018\u000109H\u0002J:\u0010$\u001a\u00020\u0005*\u0002072\u0006\u0010\u0018\u001a\u00020%2\u0006\u0010>\u001a\u00020?2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002J2\u0010&\u001a\u00020\u0005*\u0002072\u0006\u0010\u0018\u001a\u00020'2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002J:\u0010(\u001a\u00020\u0005*\u0002072\u0006\u0010\u0018\u001a\u00020)2\u0006\u0010>\u001a\u00020?2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002J,\u0010@\u001a\u00020\r2\u0006\u0010A\u001a\u00020\u00052\u0006\u0010>\u001a\u00020B2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002J5\u0010C\u001a\u00020\r2\u0006\u00102\u001a\u00020,2\b\u0010=\u001a\u0004\u0018\u0001092\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002¢\u0006\u0004\bD\u0010EJ;\u0010F\u001a\u00020\r2\u0006\u00102\u001a\u00020,2\u0006\u0010>\u001a\u00020?2\u0006\u0010-\u001a\u00020\u00122\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002¢\u0006\u0004\bG\u0010HJ$\u0010I\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\b2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002J\u0013\u0010J\u001a\u00020K*\u00020\u0005H\u0002¢\u0006\u0004\bL\u0010M¨\u0006N"}, d2 = {"Landroidx/compose/foundation/text/input/internal/HandwritingGestureApi34;", "", "<init>", "()V", "performHandwritingGesture", "", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "handwritingGesture", "Landroid/view/inputmethod/HandwritingGesture;", "layoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "updateSelectionState", "Lkotlin/Function0;", "", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "performHandwritingGesture$foundation_release", "previewHandwritingGesture", "", "Landroid/view/inputmethod/PreviewableHandwritingGesture;", "cancellationSignal", "Landroid/os/CancellationSignal;", "previewHandwritingGesture$foundation_release", "performSelectGesture", "gesture", "Landroid/view/inputmethod/SelectGesture;", "previewSelectGesture", "performDeleteGesture", "Landroid/view/inputmethod/DeleteGesture;", "previewDeleteGesture", "performSelectRangeGesture", "Landroid/view/inputmethod/SelectRangeGesture;", "previewSelectRangeGesture", "performDeleteRangeGesture", "Landroid/view/inputmethod/DeleteRangeGesture;", "previewDeleteRangeGesture", "performJoinOrSplitGesture", "Landroid/view/inputmethod/JoinOrSplitGesture;", "performInsertGesture", "Landroid/view/inputmethod/InsertGesture;", "performRemoveSpaceGesture", "Landroid/view/inputmethod/RemoveSpaceGesture;", "performDeletion", "rangeInTransformedText", "Landroidx/compose/ui/text/TextRange;", "adjustRange", "performDeletion-Sb-Bc2M", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;JZ)V", "fallback", "highlightRange", "range", "type", "Landroidx/compose/foundation/text/input/TextHighlightType;", "highlightRange-XJREzCE", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;JI)V", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "textFieldSelectionManager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "editCommandConsumer", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/EditCommand;", "textSelectionManager", "text", "Landroidx/compose/ui/text/AnnotatedString;", "performInsertionOnLegacyTextField", "offset", "", "performSelectionOnLegacyTextField", "performSelectionOnLegacyTextField-8ffj60Q", "(JLandroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function1;)V", "performDeletionOnLegacyTextField", "performDeletionOnLegacyTextField-vJH6DeI", "(JLandroidx/compose/ui/text/AnnotatedString;ZLkotlin/jvm/functions/Function1;)V", "fallbackOnLegacyTextField", "toTextGranularity", "Landroidx/compose/ui/text/TextGranularity;", "toTextGranularity-NUwxegE", "(I)I", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HandwritingGestureApi34 {
    public static final int $stable = 0;
    public static final HandwritingGestureApi34 INSTANCE = null;

    static {
        INSTANCE = new HandwritingGestureApi34();
    }

    private HandwritingGestureApi34() {
    }

    public static /* synthetic */ CharSequence a(Ref.IntRef r0, Ref.IntRef r1, MatchResult r2) {
        return performRemoveSpaceGesture$lambda$7(r0, r1, r2);
    }

    public static /* synthetic */ void b(TransformedTextFieldState r0) {
        previewHandwritingGesture$lambda$1(r0);
    }

    public static /* synthetic */ CharSequence c(Ref.IntRef r0, Ref.IntRef r1, MatchResult r2) {
        return performRemoveSpaceGesture$lambda$16(r0, r1, r2);
    }

    public static /* synthetic */ void d(TextFieldSelectionManager r0) {
        previewHandwritingGesture$lambda$10(r0);
    }

    private static final void previewHandwritingGesture$lambda$1(TransformedTextFieldState r4) {
        TextFieldState r0 = TransformedTextFieldState.access$getTextFieldState$p(r4);
        InputTransformation r1 = TransformedTextFieldState.access$getInputTransformation$p(r4);
        TextFieldEditUndoBehavior r2 = TextFieldEditUndoBehavior.MergeIfPossible;
        r0.getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        TextFieldBuffer r3 = r0.getMainBuffer$foundation_release();
        r3.clearHighlight$foundation_release();
        TransformedTextFieldState.access$updateWedgeAffinity(r4, r3);
        TextFieldState.access$commitEditAsUser(r0, r1, true, r2);
    }

    private static final void previewHandwritingGesture$lambda$10(TextFieldSelectionManager r0) {
        if (r0 == null) goto L5;
        r0.clearPreviewHighlight$foundation_release();
        return;
    }

    /* JADX INFO: renamed from: toTextGranularity-NUwxegE, reason: not valid java name */
    private final int m1585toTextGranularityNUwxegE(int r2) {
        if (r2 == 1) goto L9;
        if (r2 == 2) goto L11;
        return TextGranularity.Companion.getCharacter-DRrd7Zo();
    L11:
        return TextGranularity.Companion.getCharacter-DRrd7Zo();
    L9:
        return TextGranularity.Companion.getWord-DRrd7Zo();
    }

    private final int fallback(TransformedTextFieldState r12, HandwritingGesture r13) {
        TextFieldState r0 = TransformedTextFieldState.access$getTextFieldState$p(r12);
        InputTransformation r1 = TransformedTextFieldState.access$getInputTransformation$p(r12);
        TextFieldEditUndoBehavior r2 = TextFieldEditUndoBehavior.MergeIfPossible;
        r0.getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        TextFieldBuffer r3 = r0.getMainBuffer$foundation_release();
        r3.clearHighlight$foundation_release();
        TransformedTextFieldState.access$updateWedgeAffinity(r12, r3);
        TextFieldState.access$commitEditAsUser(r0, r1, true, r2);
        String r5 = r13.getFallbackText();
        if (r5 != null) goto L6;
        return 3;
    L6:
        TransformedTextFieldState.replaceSelectedText$default(r12, r5, true, null, false, 12, null);
        return 5;
    }

    private final int fallbackOnLegacyTextField(HandwritingGesture r3, Function1<? super EditCommand, Unit> r4) {
        String r5 = r3.getFallbackText();
        if (r5 != null) goto L6;
        return 3;
    L6:
        r4.invoke(new CommitTextCommand(r5, 1));
        return 5;
    }

    /* JADX INFO: renamed from: highlightRange-XJREzCE, reason: not valid java name */
    private final void m1581highlightRangeXJREzCE(TransformedTextFieldState r2, long r3, int r5) {
        if (TextRange.getCollapsed-impl(r3) == false) goto L5;
        TextFieldState r4 = TransformedTextFieldState.access$getTextFieldState$p(r2);
        InputTransformation r6 = TransformedTextFieldState.access$getInputTransformation$p(r2);
        TextFieldEditUndoBehavior r7 = TextFieldEditUndoBehavior.MergeIfPossible;
        r4.getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        TextFieldBuffer r0 = r4.getMainBuffer$foundation_release();
        r0.clearHighlight$foundation_release();
        TransformedTextFieldState.access$updateWedgeAffinity(r2, r0);
        TextFieldState.access$commitEditAsUser(r4, r6, true, r7);
        return;
    L5:
        r2.m1673highlightCharsIn7RAjNK8(r5, r3);
    }

    private final int performDeleteGesture(TransformedTextFieldState r4, DeleteGesture r5, TextLayoutState r6) {
        int r0 = m1585toTextGranularityNUwxegE(r5.getGranularity());
        long r1 = HandwritingGesture_androidKt.m1591access$getRangeForScreenRectOH9lIzo(r6, RectHelper_androidKt.toComposeRect(r5.getDeletionArea()), r0, TextInclusionStrategy.Companion.getContainsCenter());
        if (TextRange.getCollapsed-impl(r1) == true) goto L5;
        m1582performDeletionSbBc2M(r4, r1, TextGranularity.equals-impl0(r0, TextGranularity.Companion.getWord-DRrd7Zo()));
        return 1;
    L5:
        return INSTANCE.fallback(r4, r5);
    }

    private final int performDeleteRangeGesture(TransformedTextFieldState r5, DeleteRangeGesture r6, TextLayoutState r7) {
        int r0 = m1585toTextGranularityNUwxegE(r6.getGranularity());
        long r1 = HandwritingGesture_androidKt.m1593access$getRangeForScreenRectsO048IG0(r7, RectHelper_androidKt.toComposeRect(r6.getDeletionStartArea()), RectHelper_androidKt.toComposeRect(r6.getDeletionEndArea()), r0, TextInclusionStrategy.Companion.getContainsCenter());
        if (TextRange.getCollapsed-impl(r1) == true) goto L5;
        m1582performDeletionSbBc2M(r5, r1, TextGranularity.equals-impl0(r0, TextGranularity.Companion.getWord-DRrd7Zo()));
        return 1;
    L5:
        return INSTANCE.fallback(r5, r6);
    }

    /* JADX INFO: renamed from: performDeletion-Sb-Bc2M, reason: not valid java name */
    private final void m1582performDeletionSbBc2M(TransformedTextFieldState r9, long r10, boolean r12) {
        if (r12 == false) goto L4;
        r10 = HandwritingGesture_androidKt.m1586access$adjustHandwritingDeleteGestureRange72CqOWE(r10, r9.getVisualText());
    L4:
        TransformedTextFieldState.m1672replaceTextM8tDOmk$default(r9, "", r10, null, false, 12, null);
    }

    private final void performInsertionOnLegacyTextField(int r3, String r4, Function1<? super EditCommand, Unit> r5) {
        r5.invoke(HandwritingGesture_androidKt.access$compoundEditCommand(new EditCommand[]{new SetSelectionCommand(r3, r3), new CommitTextCommand(r4, 1)}));
    }

    private static final CharSequence performRemoveSpaceGesture$lambda$16(Ref.IntRef r2, Ref.IntRef r3, MatchResult r4) {
        if (r2.element != (-1)) goto L5;
        r2.element = r4.getRange().getFirst();
    L5:
        r3.element = r4.getRange().getLast() + 1;
        return "";
    }

    private static final CharSequence performRemoveSpaceGesture$lambda$7(Ref.IntRef r2, Ref.IntRef r3, MatchResult r4) {
        if (r2.element != (-1)) goto L5;
        r2.element = r4.getRange().getFirst();
    L5:
        r3.element = r4.getRange().getLast() + 1;
        return "";
    }

    /* JADX INFO: renamed from: performSelectionOnLegacyTextField-8ffj60Q, reason: not valid java name */
    private final void m1584performSelectionOnLegacyTextField8ffj60Q(long r3, TextFieldSelectionManager r5, Function1<? super EditCommand, Unit> r6) {
        r6.invoke(new SetSelectionCommand(TextRange.getStart-impl(r3), TextRange.getEnd-impl(r3)));
        if (r5 == null) goto L6;
        r5.enterSelectionMode$foundation_release(true);
        return;
    }

    private final void previewDeleteGesture(TransformedTextFieldState r3, DeleteGesture r4, TextLayoutState r5) {
        m1581highlightRangeXJREzCE(r3, HandwritingGesture_androidKt.m1591access$getRangeForScreenRectOH9lIzo(r5, RectHelper_androidKt.toComposeRect(r4.getDeletionArea()), m1585toTextGranularityNUwxegE(r4.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter()), TextHighlightType.Companion.m1549getHandwritingDeletePreviewsxJuwY());
    }

    private final void previewDeleteRangeGesture(TransformedTextFieldState r4, DeleteRangeGesture r5, TextLayoutState r6) {
        m1581highlightRangeXJREzCE(r4, HandwritingGesture_androidKt.m1593access$getRangeForScreenRectsO048IG0(r6, RectHelper_androidKt.toComposeRect(r5.getDeletionStartArea()), RectHelper_androidKt.toComposeRect(r5.getDeletionEndArea()), m1585toTextGranularityNUwxegE(r5.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter()), TextHighlightType.Companion.m1549getHandwritingDeletePreviewsxJuwY());
    }

    private final void previewSelectGesture(TransformedTextFieldState r3, SelectGesture r4, TextLayoutState r5) {
        m1581highlightRangeXJREzCE(r3, HandwritingGesture_androidKt.m1591access$getRangeForScreenRectOH9lIzo(r5, RectHelper_androidKt.toComposeRect(r4.getSelectionArea()), m1585toTextGranularityNUwxegE(r4.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter()), TextHighlightType.Companion.m1550getHandwritingSelectPreviewsxJuwY());
    }

    private final void previewSelectRangeGesture(TransformedTextFieldState r4, SelectRangeGesture r5, TextLayoutState r6) {
        m1581highlightRangeXJREzCE(r4, HandwritingGesture_androidKt.m1593access$getRangeForScreenRectsO048IG0(r6, RectHelper_androidKt.toComposeRect(r5.getSelectionStartArea()), RectHelper_androidKt.toComposeRect(r5.getSelectionEndArea()), m1585toTextGranularityNUwxegE(r5.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter()), TextHighlightType.Companion.m1550getHandwritingSelectPreviewsxJuwY());
    }

    private final void previewDeleteGesture(LegacyTextFieldState r3, DeleteGesture r4, TextFieldSelectionManager r5) {
        if (r5 == null) goto L5;
        r5.m1906setDeletionPreviewHighlight5zctL8$foundation_release(HandwritingGesture_androidKt.m1590access$getRangeForScreenRectOH9lIzo(r3, RectHelper_androidKt.toComposeRect(r4.getDeletionArea()), m1585toTextGranularityNUwxegE(r4.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter()));
        return;
    }

    private final void previewDeleteRangeGesture(LegacyTextFieldState r4, DeleteRangeGesture r5, TextFieldSelectionManager r6) {
        if (r6 == null) goto L5;
        r6.m1906setDeletionPreviewHighlight5zctL8$foundation_release(HandwritingGesture_androidKt.m1592access$getRangeForScreenRectsO048IG0(r4, RectHelper_androidKt.toComposeRect(r5.getDeletionStartArea()), RectHelper_androidKt.toComposeRect(r5.getDeletionEndArea()), m1585toTextGranularityNUwxegE(r5.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter()));
        return;
    }

    private final void previewSelectGesture(LegacyTextFieldState r3, SelectGesture r4, TextFieldSelectionManager r5) {
        if (r5 == null) goto L5;
        r5.m1908setSelectionPreviewHighlight5zctL8$foundation_release(HandwritingGesture_androidKt.m1590access$getRangeForScreenRectOH9lIzo(r3, RectHelper_androidKt.toComposeRect(r4.getSelectionArea()), m1585toTextGranularityNUwxegE(r4.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter()));
        return;
    }

    private final void previewSelectRangeGesture(LegacyTextFieldState r4, SelectRangeGesture r5, TextFieldSelectionManager r6) {
        if (r6 == null) goto L5;
        r6.m1908setSelectionPreviewHighlight5zctL8$foundation_release(HandwritingGesture_androidKt.m1592access$getRangeForScreenRectsO048IG0(r4, RectHelper_androidKt.toComposeRect(r5.getSelectionStartArea()), RectHelper_androidKt.toComposeRect(r5.getSelectionEndArea()), m1585toTextGranularityNUwxegE(r5.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter()));
        return;
    }

    private final int performDeleteGesture(LegacyTextFieldState r10, DeleteGesture r11, AnnotatedString r12, Function1<? super EditCommand, Unit> r13) {
        int r0 = m1585toTextGranularityNUwxegE(r11.getGranularity());
        long r4 = HandwritingGesture_androidKt.m1590access$getRangeForScreenRectOH9lIzo(r10, RectHelper_androidKt.toComposeRect(r11.getDeletionArea()), r0, TextInclusionStrategy.Companion.getContainsCenter());
        if (TextRange.getCollapsed-impl(r4) == true) goto L5;
        m1583performDeletionOnLegacyTextFieldvJH6DeI(r4, r12, TextGranularity.equals-impl0(r0, TextGranularity.Companion.getWord-DRrd7Zo()), r13);
        return 1;
    L5:
        return INSTANCE.fallbackOnLegacyTextField(r11, r13);
    }

    private final int performDeleteRangeGesture(LegacyTextFieldState r11, DeleteRangeGesture r12, AnnotatedString r13, Function1<? super EditCommand, Unit> r14) {
        int r0 = m1585toTextGranularityNUwxegE(r12.getGranularity());
        long r5 = HandwritingGesture_androidKt.m1592access$getRangeForScreenRectsO048IG0(r11, RectHelper_androidKt.toComposeRect(r12.getDeletionStartArea()), RectHelper_androidKt.toComposeRect(r12.getDeletionEndArea()), r0, TextInclusionStrategy.Companion.getContainsCenter());
        if (TextRange.getCollapsed-impl(r5) == true) goto L5;
        m1583performDeletionOnLegacyTextFieldvJH6DeI(r5, r13, TextGranularity.equals-impl0(r0, TextGranularity.Companion.getWord-DRrd7Zo()), r14);
        return 1;
    L5:
        return INSTANCE.fallbackOnLegacyTextField(r12, r14);
    }

    /* JADX INFO: renamed from: performDeletionOnLegacyTextField-vJH6DeI, reason: not valid java name */
    private final void m1583performDeletionOnLegacyTextFieldvJH6DeI(long r3, AnnotatedString r5, boolean r6, Function1<? super EditCommand, Unit> r7) {
        if (r6 == false) goto L4;
        r3 = HandwritingGesture_androidKt.m1586access$adjustHandwritingDeleteGestureRange72CqOWE(r3, r5);
    L4:
        r7.invoke(HandwritingGesture_androidKt.access$compoundEditCommand(new EditCommand[]{new SetSelectionCommand(TextRange.getEnd-impl(r3), TextRange.getEnd-impl(r3)), new DeleteSurroundingTextCommand(TextRange.getLength-impl(r3), 0)}));
    }

    private final int performInsertGesture(LegacyTextFieldState r3, InsertGesture r4, ViewConfiguration r5, Function1<? super EditCommand, Unit> r6) {
        if (r5 == null) goto L4;
        int r7 = HandwritingGesture_androidKt.m1587access$getOffsetForHandwritingGestured4ec7I(r3, HandwritingGesture_androidKt.access$toOffset(r4.getInsertionPoint()), r5);
        if (r7 == (-1)) goto L19;
        TextLayoutResultProxy r8 = r3.getLayoutResult();
        boolean r0 = false;
        if (r8 == null) goto L14;
        TextLayoutResult r9 = r8.getValue();
        if (r9 == null) goto L14;
        if (HandwritingGesture_androidKt.access$isBiDiBoundary(r9, r7) != true) goto L14;
        r0 = true;
    L14:
        if (r0 == true) goto L19;
        performInsertionOnLegacyTextField(r7, r4.getTextToInsert(), r6);
        return 1;
    L19:
        return fallbackOnLegacyTextField(r4, r6);
    L4:
        return fallbackOnLegacyTextField(r4, r6);
    }

    private final int performJoinOrSplitGesture(TransformedTextFieldState r11, JoinOrSplitGesture r12, TextLayoutState r13, ViewConfiguration r14) {
        if (r11.getOutputText() == r11.getUntransformedText()) goto L6;
        return 3;
    L6:
        int r15 = HandwritingGesture_androidKt.m1588access$getOffsetForHandwritingGestured4ec7I(r13, HandwritingGesture_androidKt.access$toOffset(r12.getJoinOrSplitPoint()), r14);
        if (r15 == (-1)) goto L22;
        TextLayoutResult r16 = r13.getLayoutResult();
        if (r16 != null) goto L11;
    L13:
        boolean r17 = false;
    L14:
        if (r17 == true) goto L22;
        long r4 = HandwritingGesture_androidKt.access$rangeOfWhitespaces(r11.getVisualText(), r15);
        if (TextRange.getCollapsed-impl(r4) == false) goto L19;
        TransformedTextFieldState.m1672replaceTextM8tDOmk$default(r11, " ", r4, null, false, 12, null);
    L20:
        return 1;
    L19:
        m1582performDeletionSbBc2M(r11, r4, false);
        goto L20
    L11:
        if (HandwritingGesture_androidKt.access$isBiDiBoundary(r16, r15) != true) goto L13;
        r17 = true;
    L22:
        return fallback(r11, r12);
    }

    private final int performRemoveSpaceGesture(TransformedTextFieldState r12, RemoveSpaceGesture r13, TextLayoutState r14, ViewConfiguration r15) {
        long r0 = HandwritingGesture_androidKt.m1589access$getRangeForRemoveSpaceGesture5iVPX68(r14.getLayoutResult(), HandwritingGesture_androidKt.access$toOffset(r13.getStartPoint()), HandwritingGesture_androidKt.access$toOffset(r13.getEndPoint()), r14.getTextLayoutNodeCoordinates(), r15);
        if (TextRange.getCollapsed-impl(r0) == true) goto L5;
        final Ref.IntRef r4 = new Ref.IntRef();
        r4.element = -1;
        final Ref.IntRef r6 = new Ref.IntRef();
        r6.element = -1;
        String r7 = TextRangeKt.substring-FDrldGo(r12.getVisualText(), r0);
        String r8 = new Regex("\\s+").replace(r7, new a0(r4, r6));
        if (r4.element == (-1)) goto L14;
        if (r6.element == (-1)) goto L14;
        long r9 = TextRangeKt.TextRange(TextRange.getStart-impl(r0) + r4.element, TextRange.getStart-impl(r0) + r6.element);
        TransformedTextFieldState.m1672replaceTextM8tDOmk$default(r12, r8.substring(r4.element, r8.length() - (TextRange.getLength-impl(r0) - r6.element)), r9, null, false, 12, null);
        return 1;
    L14:
        return fallback(r12, r13);
    L5:
        return INSTANCE.fallback(r12, r13);
    }

    private final int performSelectGesture(TransformedTextFieldState r4, SelectGesture r5, TextLayoutState r6, Function0<Unit> r7) {
        long r0 = HandwritingGesture_androidKt.m1591access$getRangeForScreenRectOH9lIzo(r6, RectHelper_androidKt.toComposeRect(r5.getSelectionArea()), m1585toTextGranularityNUwxegE(r5.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter());
        if (TextRange.getCollapsed-impl(r0) == true) goto L5;
        r4.m1679selectCharsIn5zctL8(r0);
        if (r7 == null) goto L11;
        r7.invoke();
        return 1;
    L11:
        return 1;
    L5:
        return INSTANCE.fallback(r4, r5);
    }

    private final int performSelectRangeGesture(TransformedTextFieldState r5, SelectRangeGesture r6, TextLayoutState r7, Function0<Unit> r8) {
        long r0 = HandwritingGesture_androidKt.m1593access$getRangeForScreenRectsO048IG0(r7, RectHelper_androidKt.toComposeRect(r6.getSelectionStartArea()), RectHelper_androidKt.toComposeRect(r6.getSelectionEndArea()), m1585toTextGranularityNUwxegE(r6.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter());
        if (TextRange.getCollapsed-impl(r0) == true) goto L5;
        r5.m1679selectCharsIn5zctL8(r0);
        if (r8 == null) goto L11;
        r8.invoke();
        return 1;
    L11:
        return 1;
    L5:
        return INSTANCE.fallback(r5, r6);
    }

    public final boolean previewHandwritingGesture$foundation_release(LegacyTextFieldState r4, PreviewableHandwritingGesture r5, final TextFieldSelectionManager r6, CancellationSignal r7) {
        AnnotatedString r0 = r4.getUntransformedText();
        if (r0 != null) goto L5;
        return false;
    L5:
        TextLayoutResultProxy r2 = r4.getLayoutResult();
        if (r2 == null) goto L12;
        TextLayoutResult r3 = r2.getValue();
        if (r3 == null) goto L12;
        TextLayoutInput r8 = r3.getLayoutInput();
        if (r8 == null) goto L12;
        AnnotatedString r9 = r8.getText();
    L14:
        if (Intrinsics.areEqual(r0, r9) == true) goto L17;
        return false;
    L17:
        if ((r5 instanceof SelectGesture) == false) goto L20;
        previewSelectGesture(r4, (SelectGesture) r5, r6);
    L28:
        if (r7 == null) goto L33;
        r7.setOnCancelListener(new z(r6));
        return true;
    L33:
        return true;
    L20:
        if ((r5 instanceof DeleteGesture) == false) goto L23;
        previewDeleteGesture(r4, (DeleteGesture) r5, r6);
        goto L28
    L23:
        if ((r5 instanceof SelectRangeGesture) == false) goto L26;
        previewSelectRangeGesture(r4, (SelectRangeGesture) r5, r6);
        goto L28
    L26:
        if ((r5 instanceof DeleteRangeGesture) == false) goto L32;
        previewDeleteRangeGesture(r4, (DeleteRangeGesture) r5, r6);
        goto L28
    L32:
        return false;
    L12:
        r9 = null;
        goto L14
    }

    private final int performInsertGesture(TransformedTextFieldState r9, InsertGesture r10, TextLayoutState r11, ViewConfiguration r12) {
        int r13 = HandwritingGesture_androidKt.m1588access$getOffsetForHandwritingGestured4ec7I(r11, HandwritingGesture_androidKt.access$toOffset(r10.getInsertionPoint()), r12);
        if (r13 == (-1)) goto L5;
        TransformedTextFieldState.m1672replaceTextM8tDOmk$default(r9, r10.getTextToInsert(), TextRangeKt.TextRange(r13), null, false, 12, null);
        return 1;
    L5:
        return fallback(r9, r10);
    }

    private final int performSelectGesture(LegacyTextFieldState r4, SelectGesture r5, TextFieldSelectionManager r6, Function1<? super EditCommand, Unit> r7) {
        long r0 = HandwritingGesture_androidKt.m1590access$getRangeForScreenRectOH9lIzo(r4, RectHelper_androidKt.toComposeRect(r5.getSelectionArea()), m1585toTextGranularityNUwxegE(r5.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter());
        if (TextRange.getCollapsed-impl(r0) == true) goto L5;
        m1584performSelectionOnLegacyTextField8ffj60Q(r0, r6, r7);
        return 1;
    L5:
        return INSTANCE.fallbackOnLegacyTextField(r5, r7);
    }

    private final int performSelectRangeGesture(LegacyTextFieldState r5, SelectRangeGesture r6, TextFieldSelectionManager r7, Function1<? super EditCommand, Unit> r8) {
        long r0 = HandwritingGesture_androidKt.m1592access$getRangeForScreenRectsO048IG0(r5, RectHelper_androidKt.toComposeRect(r6.getSelectionStartArea()), RectHelper_androidKt.toComposeRect(r6.getSelectionEndArea()), m1585toTextGranularityNUwxegE(r6.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter());
        if (TextRange.getCollapsed-impl(r0) == true) goto L5;
        m1584performSelectionOnLegacyTextField8ffj60Q(r0, r7, r8);
        return 1;
    L5:
        return INSTANCE.fallbackOnLegacyTextField(r6, r8);
    }

    public final boolean previewHandwritingGesture$foundation_release(final TransformedTextFieldState r2, PreviewableHandwritingGesture r3, TextLayoutState r4, CancellationSignal r5) {
        if ((r3 instanceof SelectGesture) == false) goto L6;
        previewSelectGesture(r2, (SelectGesture) r3, r4);
    L14:
        if (r5 == null) goto L20;
        r5.setOnCancelListener(new x(r2));
        return true;
    L20:
        return true;
    L6:
        if ((r3 instanceof DeleteGesture) == false) goto L9;
        previewDeleteGesture(r2, (DeleteGesture) r3, r4);
        goto L14
    L9:
        if ((r3 instanceof SelectRangeGesture) == false) goto L12;
        previewSelectRangeGesture(r2, (SelectRangeGesture) r3, r4);
        goto L14
    L12:
        if ((r3 instanceof DeleteRangeGesture) == false) goto L18;
        previewDeleteRangeGesture(r2, (DeleteRangeGesture) r3, r4);
        goto L14
    L18:
        return false;
    }

    private final int performJoinOrSplitGesture(LegacyTextFieldState r9, JoinOrSplitGesture r10, AnnotatedString r11, ViewConfiguration r12, Function1<? super EditCommand, Unit> r13) {
        if (r12 == null) goto L4;
        int r14 = HandwritingGesture_androidKt.m1587access$getOffsetForHandwritingGestured4ec7I(r9, HandwritingGesture_androidKt.access$toOffset(r10.getJoinOrSplitPoint()), r12);
        if (r14 == (-1)) goto L22;
        TextLayoutResultProxy r15 = r9.getLayoutResult();
        boolean r0 = false;
        if (r15 == null) goto L14;
        TextLayoutResult r16 = r15.getValue();
        if (r16 == null) goto L14;
        if (HandwritingGesture_androidKt.access$isBiDiBoundary(r16, r14) != true) goto L14;
        r0 = true;
    L14:
        if (r0 == true) goto L22;
        long r3 = HandwritingGesture_androidKt.access$rangeOfWhitespaces(r11, r14);
        if (TextRange.getCollapsed-impl(r3) == false) goto L19;
        performInsertionOnLegacyTextField(TextRange.getStart-impl(r3), " ", r13);
    L20:
        return 1;
    L19:
        m1583performDeletionOnLegacyTextFieldvJH6DeI(r3, r11, false, r13);
    L22:
        return fallbackOnLegacyTextField(r10, r13);
    L4:
        return fallbackOnLegacyTextField(r10, r13);
    }

    private final int performRemoveSpaceGesture(LegacyTextFieldState r9, RemoveSpaceGesture r10, AnnotatedString r11, ViewConfiguration r12, Function1<? super EditCommand, Unit> r13) {
        TextLayoutResultProxy r0 = r9.getLayoutResult();
        if (r0 == null) goto L5;
        TextLayoutResult r1 = r0.getValue();
    L6:
        long r2 = HandwritingGesture_androidKt.m1589access$getRangeForRemoveSpaceGesture5iVPX68(r1, HandwritingGesture_androidKt.access$toOffset(r10.getStartPoint()), HandwritingGesture_androidKt.access$toOffset(r10.getEndPoint()), r9.getLayoutCoordinates(), r12);
        if (TextRange.getCollapsed-impl(r2) == true) goto L9;
        final Ref.IntRef r14 = new Ref.IntRef();
        r14.element = -1;
        final Ref.IntRef r3 = new Ref.IntRef();
        r3.element = -1;
        String r15 = new Regex("\\s+").replace(TextRangeKt.substring-FDrldGo(r11, r2), new y(r14, r3));
        if (r14.element == (-1)) goto L18;
        if (r3.element == (-1)) goto L18;
        r13.invoke(HandwritingGesture_androidKt.access$compoundEditCommand(new EditCommand[]{new SetSelectionCommand(TextRange.getStart-impl(r2) + r14.element, TextRange.getStart-impl(r2) + r3.element), new CommitTextCommand(r15.substring(r14.element, r15.length() - (TextRange.getLength-impl(r2) - r3.element)), 1)}));
        return 1;
    L18:
        return fallbackOnLegacyTextField(r10, r13);
    L9:
        return INSTANCE.fallbackOnLegacyTextField(r10, r13);
    L5:
        r1 = null;
        goto L6
    }

    public final int performHandwritingGesture$foundation_release(LegacyTextFieldState r7, HandwritingGesture r8, TextFieldSelectionManager r9, ViewConfiguration r10, Function1<? super EditCommand, Unit> r11) {
        AnnotatedString r3 = r7.getUntransformedText();
        if (r3 != null) goto L5;
        return 3;
    L5:
        TextLayoutResultProxy r1 = r7.getLayoutResult();
        if (r1 == null) goto L12;
        TextLayoutResult r2 = r1.getValue();
        if (r2 == null) goto L12;
        TextLayoutInput r4 = r2.getLayoutInput();
        if (r4 == null) goto L12;
        AnnotatedString r5 = r4.getText();
    L14:
        if (Intrinsics.areEqual(r3, r5) == true) goto L17;
        return 3;
    L17:
        if ((r8 instanceof SelectGesture) == false) goto L20;
        return performSelectGesture(r7, (SelectGesture) r8, r9, r11);
    L20:
        if ((r8 instanceof DeleteGesture) == false) goto L23;
        return performDeleteGesture(r7, (DeleteGesture) r8, r3, r11);
    L23:
        if ((r8 instanceof SelectRangeGesture) == false) goto L26;
        return performSelectRangeGesture(r7, (SelectRangeGesture) r8, r9, r11);
    L26:
        if ((r8 instanceof DeleteRangeGesture) == false) goto L29;
        return performDeleteRangeGesture(r7, (DeleteRangeGesture) r8, r3, r11);
    L29:
        if ((r8 instanceof JoinOrSplitGesture) == false) goto L32;
        return performJoinOrSplitGesture(r7, (JoinOrSplitGesture) r8, r3, r10, r11);
    L32:
        if ((r8 instanceof InsertGesture) == false) goto L35;
        return performInsertGesture(r7, (InsertGesture) r8, r10, r11);
    L35:
        if ((r8 instanceof RemoveSpaceGesture) == true) goto L45;
        return 2;
    L45:
        return performRemoveSpaceGesture(r7, (RemoveSpaceGesture) r8, r3, r10, r11);
    L12:
        r5 = null;
        goto L14
    }

    public final int performHandwritingGesture$foundation_release(TransformedTextFieldState r2, HandwritingGesture r3, TextLayoutState r4, Function0<Unit> r5, ViewConfiguration r6) {
        if ((r3 instanceof SelectGesture) == false) goto L6;
        return performSelectGesture(r2, (SelectGesture) r3, r4, r5);
    L6:
        if ((r3 instanceof DeleteGesture) == false) goto L9;
        return performDeleteGesture(r2, (DeleteGesture) r3, r4);
    L9:
        if ((r3 instanceof SelectRangeGesture) == false) goto L12;
        return performSelectRangeGesture(r2, (SelectRangeGesture) r3, r4, r5);
    L12:
        if ((r3 instanceof DeleteRangeGesture) == false) goto L15;
        return performDeleteRangeGesture(r2, (DeleteRangeGesture) r3, r4);
    L15:
        if ((r3 instanceof JoinOrSplitGesture) == false) goto L18;
        return performJoinOrSplitGesture(r2, (JoinOrSplitGesture) r3, r4, r6);
    L18:
        if ((r3 instanceof InsertGesture) == false) goto L21;
        return performInsertGesture(r2, (InsertGesture) r3, r4, r6);
    L21:
        if ((r3 instanceof RemoveSpaceGesture) == true) goto L31;
        return 2;
    L31:
        return performRemoveSpaceGesture(r2, (RemoveSpaceGesture) r3, r4, r6);
    }
}
