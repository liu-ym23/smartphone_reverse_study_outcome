package androidx.compose.foundation.text.input.internal;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldBufferKt;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u0000 `2\u00020\u0001:\u0002_`B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010!\u001a\u00020\"2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u000e\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%J\u0015\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020(¢\u0006\u0004\b)\u0010*J\u0015\u0010+\u001a\u00020\"2\u0006\u0010,\u001a\u00020(¢\u0006\u0004\b-\u0010*J\u001d\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u0002002\u0006\u0010'\u001a\u00020(¢\u0006\u0004\b1\u00102J\u000e\u00103\u001a\u00020\"2\u0006\u00104\u001a\u000205J\u0006\u00106\u001a\u00020\"J\u0006\u00107\u001a\u00020\"J1\u00108\u001a\u00020\"2\u0006\u00104\u001a\u0002052\u0006\u00109\u001a\u00020(2\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020=¢\u0006\u0004\b>\u0010?J,\u0010@\u001a\u00020\"2\u0006\u00104\u001a\u0002052\b\b\u0002\u0010A\u001a\u00020=2\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020=J\u0006\u0010B\u001a\u00020\"J\u0006\u0010C\u001a\u00020\"J\u0006\u0010D\u001a\u00020\"J\u0006\u0010E\u001a\u00020\"J,\u0010F\u001a\u00020\"2\b\b\u0002\u0010<\u001a\u00020=2\u0017\u0010G\u001a\u0013\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\"0H¢\u0006\u0002\bJH\u0086\bJ\f\u0010K\u001a\u00020\"*\u00020IH\u0002J\u0015\u0010L\u001a\u00020(2\u0006\u0010M\u001a\u00020%¢\u0006\u0004\bN\u0010OJ\u0015\u0010L\u001a\u00020(2\u0006\u00109\u001a\u00020(¢\u0006\u0004\bP\u0010QJ\u0015\u0010R\u001a\u00020(2\u0006\u0010M\u001a\u00020%¢\u0006\u0004\bS\u0010OJ\u0015\u0010R\u001a\u00020(2\u0006\u00109\u001a\u00020(¢\u0006\u0004\bT\u0010QJ\u0016\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020XH\u0086@¢\u0006\u0002\u0010YJ\u0013\u0010Z\u001a\u00020=2\b\u0010[\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\\\u001a\u00020%H\u0016J\b\u0010]\u001a\u00020^H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R+\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00198F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006a"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "", "textFieldState", "Landroidx/compose/foundation/text/input/TextFieldState;", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "codepointTransformation", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "<init>", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/foundation/text/input/internal/CodepointTransformation;Landroidx/compose/foundation/text/input/OutputTransformation;)V", "outputTransformedText", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$TransformedText;", "codepointTransformedText", "untransformedText", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getUntransformedText", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "outputText", "getOutputText", "visualText", "getVisualText", "<set-?>", "Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "selectionWedgeAffinity", "getSelectionWedgeAffinity", "()Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "setSelectionWedgeAffinity", "(Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;)V", "selectionWedgeAffinity$delegate", "Landroidx/compose/runtime/MutableState;", "update", "", "placeCursorBeforeCharAt", "transformedOffset", "", "selectCharsIn", "transformedRange", "Landroidx/compose/ui/text/TextRange;", "selectCharsIn-5zc-tL8", "(J)V", "selectUntransformedCharsIn", "untransformedRange", "selectUntransformedCharsIn-5zc-tL8", "highlightCharsIn", "type", "Landroidx/compose/foundation/text/input/TextHighlightType;", "highlightCharsIn-7RAjNK8", "(IJ)V", "replaceAll", "newText", "", "selectAll", "deleteSelectedText", "replaceText", "range", "undoBehavior", "Landroidx/compose/foundation/text/input/internal/undo/TextFieldEditUndoBehavior;", "restartImeIfContentChanges", "", "replaceText-M8tDOmk", "(Ljava/lang/CharSequence;JLandroidx/compose/foundation/text/input/internal/undo/TextFieldEditUndoBehavior;Z)V", "replaceSelectedText", "clearComposition", "collapseSelectionToMax", "collapseSelectionToEnd", "undo", "redo", "editUntransformedTextAsUser", "block", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "Lkotlin/ExtensionFunctionType;", "updateWedgeAffinity", "mapToTransformed", "offset", "mapToTransformed--jx7JFs", "(I)J", "mapToTransformed-GEjPoXI", "(J)J", "mapFromTransformed", "mapFromTransformed--jx7JFs", "mapFromTransformed-GEjPoXI", "collectImeNotifications", "", "notifyImeListener", "Landroidx/compose/foundation/text/input/TextFieldState$NotifyImeListener;", "(Landroidx/compose/foundation/text/input/TextFieldState$NotifyImeListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "equals", "other", "hashCode", "toString", "", "TransformedText", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TransformedTextFieldState {
    public static final int $stable = 0;
    private static final Companion Companion = null;
    private final CodepointTransformation codepointTransformation;
    private final State<TransformedText> codepointTransformedText;
    private InputTransformation inputTransformation;
    private final OutputTransformation outputTransformation;
    private final State<TransformedText> outputTransformedText;
    private final MutableState selectionWedgeAffinity$delegate;
    private final TextFieldState textFieldState;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0003J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0003J+\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000bH\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0003¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$Companion;", "", "<init>", "()V", "calculateTransformedText", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$TransformedText;", "untransformedValue", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "wedgeAffinity", "Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "codepointTransformation", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "mapToTransformed", "Landroidx/compose/ui/text/TextRange;", "range", "mapping", "Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "selectionWedgeAffinity", "mapToTransformed-XGyztTk", "(JLandroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;)J", "mapFromTransformed", "mapFromTransformed-xdX6-G0", "(JLandroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;)J", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r0 = new int[WedgeAffinity.values().length];
                r0[WedgeAffinity.Start.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[WedgeAffinity.End.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                $EnumSwitchMapping$0 = r0;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        /* JADX INFO: renamed from: mapFromTransformed-xdX6-G0, reason: not valid java name */
        private final long m1683mapFromTransformedxdX6G0(long r6, OffsetMappingCalculator r8) {
            long r0 = r8.m1613mapFromDestjx7JFs(TextRange.getStart-impl(r6));
            if (TextRange.getCollapsed-impl(r6) == false) goto L5;
            long r2 = r0;
        L6:
            int r9 = Math.min(TextRange.getMin-impl(r0), TextRange.getMin-impl(r2));
            int r1 = Math.max(TextRange.getMax-impl(r0), TextRange.getMax-impl(r2));
            if (TextRange.getReversed-impl(r6) == false) goto L10;
            return TextRangeKt.TextRange(r1, r9);
        L10:
            return TextRangeKt.TextRange(r9, r1);
        L5:
            r2 = r8.m1613mapFromDestjx7JFs(TextRange.getEnd-impl(r6));
            goto L6
        }

        /* JADX INFO: renamed from: access$mapFromTransformed-xdX6-G0, reason: not valid java name */
        public static final /* synthetic */ long m1681access$mapFromTransformedxdX6G0(Companion r0, long r1, OffsetMappingCalculator r3) {
            return r0.m1683mapFromTransformedxdX6G0(r1, r3);
        }

        @JvmStatic
        private final TransformedText calculateTransformedText(TextFieldCharSequence r11, OutputTransformation r12, SelectionWedgeAffinity r13) {
            OffsetMappingCalculator r8 = new OffsetMappingCalculator();
            TextFieldBuffer r9 = new TextFieldBuffer(r11, null, null, r8, 6, null);
            boolean r1 = true;
            r9.setCanCallAddStyle$foundation_release(true);
            r12.transformOutput(r9);
            r9.setCanCallAddStyle$foundation_release(false);
            List<AnnotatedString.Range<AnnotatedString.Annotation>> r5 = r9.getOutputTransformationAnnotations$foundation_release();
            if (r9.getChanges().getChangeCount() != 0) goto L12;
            List<AnnotatedString.Range<AnnotatedString.Annotation>> r3 = r5;
            if (r3 != null) goto L7;
        L10:
            if (r1 == false) goto L12;
            return null;
        L7:
            if (r3.isEmpty() == true) goto L10;
            r1 = false;
        L12:
            long r2 = m1684mapToTransformedXGyztTk(r11.m1535getSelectiond9O1mEE(), r8, r13);
            TextRange r4 = r11.m1534getCompositionMzsxiRA();
            if (r4 == null) goto L15;
            TextRange r6 = TextRange.box-impl(TransformedTextFieldState.access$getCompanion$p().m1684mapToTransformedXGyztTk(r4.unbox-impl(), r8, r13));
        L17:
            return new TransformedText(TextFieldBuffer.m1524toTextFieldCharSequencewFTz33Y$foundation_release$default(r9, r2, r6, null, r5, 4, null), r8);
        L15:
            r6 = null;
            goto L17
        }

        @JvmStatic
        /* JADX INFO: renamed from: mapToTransformed-XGyztTk, reason: not valid java name */
        private final long m1684mapToTransformedXGyztTk(long r8, OffsetMappingCalculator r10, SelectionWedgeAffinity r11) {
            long r0 = r10.m1614mapFromSourcejx7JFs(TextRange.getStart-impl(r8));
            if (TextRange.getCollapsed-impl(r8) == false) goto L5;
            long r2 = r0;
        L6:
            WedgeAffinity r12 = null;
            if (r11 == null) goto L9;
            WedgeAffinity r4 = r11.getStartAffinity();
        L11:
            if (TextRange.getCollapsed-impl(r8) == false) goto L13;
            r12 = r4;
        L16:
            if (r4 != null) goto L18;
        L26:
            if (r12 != null) goto L28;
        L37:
            int r13 = Math.min(TextRange.getMin-impl(r0), TextRange.getMin-impl(r2));
            int r14 = Math.max(TextRange.getMax-impl(r0), TextRange.getMax-impl(r2));
            if (TextRange.getReversed-impl(r8) == false) goto L41;
            return TextRangeKt.TextRange(r14, r13);
        L41:
            return TextRangeKt.TextRange(r13, r14);
        L28:
            if (TextRange.getCollapsed-impl(r2) == true) goto L37;
            int r15 = WhenMappings.$EnumSwitchMapping$0[r12.ordinal()];
            if (r15 == 1) goto L35;
            if (r15 != 2) goto L34;
            long r16 = TextRangeKt.TextRange(TextRange.getEnd-impl(r2));
        L36:
            r2 = r16;
            goto L37
        L34:
            throw new NoWhenBranchMatchedException();
        L35:
            r16 = TextRangeKt.TextRange(TextRange.getStart-impl(r2));
            goto L36
        L18:
            if (TextRange.getCollapsed-impl(r0) == true) goto L26;
            int r5 = WhenMappings.$EnumSwitchMapping$0[r4.ordinal()];
            if (r5 == 1) goto L25;
            if (r5 != 2) goto L24;
            r0 = TextRangeKt.TextRange(TextRange.getEnd-impl(r0));
            goto L26
        L24:
            throw new NoWhenBranchMatchedException();
        L25:
            r0 = TextRangeKt.TextRange(TextRange.getStart-impl(r0));
            goto L26
        L13:
            if (r11 == null) goto L16;
            r12 = r11.getEndAffinity();
            goto L16
        L9:
            r4 = null;
            goto L11
        L5:
            r2 = r10.m1614mapFromSourcejx7JFs(TextRange.getEnd-impl(r8));
            goto L6
        }

        @JvmStatic
        private final TransformedText calculateTransformedText(TextFieldCharSequence r12, CodepointTransformation r13, SelectionWedgeAffinity r14) {
            OffsetMappingCalculator r0 = new OffsetMappingCalculator();
            CharSequence r2 = CodepointTransformationKt.toVisualText(r12, r13, r0);
            if (r2 != r12) goto L5;
            return null;
        L5:
            long r3 = m1684mapToTransformedXGyztTk(r12.m1535getSelectiond9O1mEE(), r0, r14);
            TextRange r15 = r12.m1534getCompositionMzsxiRA();
            if (r15 == null) goto L8;
            TextRange r5 = TextRange.box-impl(TransformedTextFieldState.access$getCompanion$p().m1684mapToTransformedXGyztTk(r15.unbox-impl(), r0, r14));
        L10:
            return new TransformedText(new TextFieldCharSequence(r2, r3, r5, null, null, null, 56, null), r0);
        L8:
            r5 = null;
            goto L10
        }

        public static final /* synthetic */ TransformedText access$calculateTransformedText(Companion r0, TextFieldCharSequence r1, OutputTransformation r2, SelectionWedgeAffinity r3) {
            return r0.calculateTransformedText(r1, r2, r3);
        }

        /* JADX INFO: renamed from: access$mapToTransformed-XGyztTk, reason: not valid java name */
        public static final /* synthetic */ long m1682access$mapToTransformedXGyztTk(Companion r0, long r1, OffsetMappingCalculator r3, SelectionWedgeAffinity r4) {
            return r0.m1684mapToTransformedXGyztTk(r1, r3, r4);
        }

        public static final /* synthetic */ TransformedText access$calculateTransformedText(Companion r0, TextFieldCharSequence r1, CodepointTransformation r2, SelectionWedgeAffinity r3) {
            return r0.calculateTransformedText(r1, r2, r3);
        }

        /* JADX INFO: renamed from: mapToTransformed-XGyztTk$default, reason: not valid java name */
        public static /* synthetic */ long m1685mapToTransformedXGyztTk$default(Companion r0, long r1, OffsetMappingCalculator r3, SelectionWedgeAffinity r4, int r5, Object r6) {
            if ((r5 & 4) == 0) goto L6;
            r4 = null;
        L6:
            return r0.m1684mapToTransformedXGyztTk(r1, r3, r4);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$TransformedText;", "", "text", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "offsetMapping", "Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "<init>", "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;)V", "getText", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getOffsetMapping", "()Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class TransformedText {
        private final OffsetMappingCalculator offsetMapping;
        private final TextFieldCharSequence text;

        public static /* synthetic */ TransformedText copy$default(TransformedText r0, TextFieldCharSequence r1, OffsetMappingCalculator r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.text;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.offsetMapping;
        L9:
            return r0.copy(r1, r2);
        }

        public final TextFieldCharSequence component1() {
            return this.text;
        }

        public final OffsetMappingCalculator component2() {
            return this.offsetMapping;
        }

        public final TransformedText copy(TextFieldCharSequence r2, OffsetMappingCalculator r3) {
            return new TransformedText(r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof TransformedText) == true) goto L8;
            return false;
        L8:
            TransformedText r6 = (TransformedText) r5;
            if (Intrinsics.areEqual(this.text, r6.text) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.offsetMapping, r6.offsetMapping) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.text.hashCode() * 31) + this.offsetMapping.hashCode();
        }

        public String toString() {
            return "TransformedText(text=" + this.text + ", offsetMapping=" + this.offsetMapping + ')';
        }

        public final OffsetMappingCalculator getOffsetMapping() {
            return this.offsetMapping;
        }

        public final TextFieldCharSequence getText() {
            return this.text;
        }

        public TransformedText(TextFieldCharSequence r1, OffsetMappingCalculator r2) {
            this.text = r1;
            this.offsetMapping = r2;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.TransformedTextFieldState$collectImeNotifications$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TransformedTextFieldState", f = "TransformedTextFieldState.kt", i = {0}, l = {755}, m = "collectImeNotifications", n = {"transformedNotifyImeListener"}, s = {"L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ TransformedTextFieldState this$0;

        public AnonymousClass1(TransformedTextFieldState r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return this.this$0.collectImeNotifications(null, this);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void a(TextFieldState.NotifyImeListener r0, TransformedTextFieldState r1, TextFieldCharSequence r2, TextFieldCharSequence r3, boolean r4) {
        collectImeNotifications$lambda$20(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ TransformedText b(TransformedTextFieldState r0, CodepointTransformation r1) {
        return codepointTransformedText$lambda$3$lambda$2(r0, r1);
    }

    public static /* synthetic */ TransformedText c(TransformedTextFieldState r0, OutputTransformation r1) {
        return outputTransformedText$lambda$1$lambda$0(r0, r1);
    }

    @JvmStatic
    private static final TransformedText calculateTransformedText(TextFieldCharSequence r1, OutputTransformation r2, SelectionWedgeAffinity r3) {
        return Companion.access$calculateTransformedText(Companion, r1, r2, r3);
    }

    @JvmStatic
    private static final TransformedText calculateTransformedText(TextFieldCharSequence r1, CodepointTransformation r2, SelectionWedgeAffinity r3) {
        return Companion.access$calculateTransformedText(Companion, r1, r2, r3);
    }

    @JvmStatic
    /* JADX INFO: renamed from: mapFromTransformed-xdX6-G0, reason: not valid java name */
    private static final long m1670mapFromTransformedxdX6G0(long r1, OffsetMappingCalculator r3) {
        return Companion.m1681access$mapFromTransformedxdX6G0(Companion, r1, r3);
    }

    @JvmStatic
    /* JADX INFO: renamed from: mapToTransformed-XGyztTk, reason: not valid java name */
    private static final long m1671mapToTransformedXGyztTk(long r1, OffsetMappingCalculator r3, SelectionWedgeAffinity r4) {
        return Companion.m1682access$mapToTransformedXGyztTk(Companion, r1, r3, r4);
    }

    public final void collapseSelectionToEnd() {
        TextFieldState r0 = this.textFieldState;
        InputTransformation r1 = this.inputTransformation;
        TextFieldEditUndoBehavior r2 = TextFieldEditUndoBehavior.MergeIfPossible;
        r0.getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        TextFieldBuffer r3 = r0.getMainBuffer$foundation_release();
        TextFieldBufferKt.setSelectionCoerced$default(r3, TextRange.getEnd-impl(r3.m1527getSelectiond9O1mEE()), 0, 2, null);
        TextFieldState.access$commitEditAsUser(r0, r1, true, r2);
    }

    public final void collapseSelectionToMax() {
        TextFieldState r0 = this.textFieldState;
        InputTransformation r1 = this.inputTransformation;
        TextFieldEditUndoBehavior r2 = TextFieldEditUndoBehavior.MergeIfPossible;
        r0.getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        TextFieldBuffer r3 = r0.getMainBuffer$foundation_release();
        TextFieldBufferKt.setSelectionCoerced$default(r3, TextRange.getMax-impl(r3.m1527getSelectiond9O1mEE()), 0, 2, null);
        TextFieldState.access$commitEditAsUser(r0, r1, true, r2);
    }

    public final void deleteSelectedText() {
        TextFieldState r0 = this.textFieldState;
        InputTransformation r1 = this.inputTransformation;
        TextFieldEditUndoBehavior r2 = TextFieldEditUndoBehavior.NeverMerge;
        r0.getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        TextFieldBuffer r3 = r0.getMainBuffer$foundation_release();
        TextFieldBufferKt.delete(r3, TextRange.getMin-impl(r3.m1527getSelectiond9O1mEE()), TextRange.getMax-impl(r3.m1527getSelectiond9O1mEE()));
        TextFieldBufferKt.setSelectionCoerced$default(r3, TextRange.getMin-impl(r3.m1527getSelectiond9O1mEE()), 0, 2, null);
        updateWedgeAffinity(r3);
        TextFieldState.access$commitEditAsUser(r0, r1, true, r2);
    }

    public final TextFieldCharSequence getOutputText() {
        State<TransformedText> r0 = this.outputTransformedText;
        if (r0 == null) goto L9;
        TransformedText r1 = (TransformedText) r0.getValue();
        if (r1 == null) goto L9;
        TextFieldCharSequence r2 = r1.getText();
        if (r2 == null) goto L9;
        return r2;
    L9:
        return getUntransformedText();
    }

    public final SelectionWedgeAffinity getSelectionWedgeAffinity() {
        return (SelectionWedgeAffinity) this.selectionWedgeAffinity$delegate.getValue();
    }

    public final TextFieldCharSequence getUntransformedText() {
        return this.textFieldState.getValue$foundation_release();
    }

    public final TextFieldCharSequence getVisualText() {
        State<TransformedText> r0 = this.codepointTransformedText;
        if (r0 == null) goto L9;
        TransformedText r1 = (TransformedText) r0.getValue();
        if (r1 == null) goto L9;
        TextFieldCharSequence r2 = r1.getText();
        if (r2 == null) goto L9;
        return r2;
    L9:
        return getOutputText();
    }

    public int hashCode() {
        int r0 = this.textFieldState.hashCode() * 31;
        CodepointTransformation r1 = this.codepointTransformation;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        OutputTransformation r5 = this.outputTransformation;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        return r4 + r2;
    L5:
        r3 = 0;
        goto L6
    }

    public final void redo() {
        this.textFieldState.getUndoState().redo();
    }

    public final void selectAll() {
        TextFieldState r0 = this.textFieldState;
        InputTransformation r1 = this.inputTransformation;
        TextFieldEditUndoBehavior r2 = TextFieldEditUndoBehavior.MergeIfPossible;
        r0.getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        TextFieldBuffer r3 = r0.getMainBuffer$foundation_release();
        TextFieldBufferKt.setSelectionCoerced(r3, 0, r3.getLength());
        TextFieldState.access$commitEditAsUser(r0, r1, true, r2);
    }

    public String toString() {
        return "TransformedTextFieldState(textFieldState=" + this.textFieldState + ", outputTransformation=" + this.outputTransformation + ", outputTransformedText=" + this.outputTransformedText + ", codepointTransformation=" + this.codepointTransformation + ", codepointTransformedText=" + this.codepointTransformedText + ", outputText=\"" + getOutputText() + "\", visualText=\"" + getVisualText() + "\")";
    }

    public final void undo() {
        this.textFieldState.getUndoState().undo();
    }

    public static final /* synthetic */ Companion access$getCompanion$p() {
        return Companion;
    }

    public static final /* synthetic */ InputTransformation access$getInputTransformation$p(TransformedTextFieldState r0) {
        return r0.inputTransformation;
    }

    public static final /* synthetic */ TextFieldState access$getTextFieldState$p(TransformedTextFieldState r0) {
        return r0.textFieldState;
    }

    private final void updateWedgeAffinity(TextFieldBuffer r3) {
        if (r3.getChangeTracker$foundation_release().getChangeCount() > 0) goto L5;
        return;
    L5:
        if (TextRange.getCollapsed-impl(r3.m1527getSelectiond9O1mEE()) == false) goto L9;
        setSelectionWedgeAffinity(new SelectionWedgeAffinity(WedgeAffinity.Start));
        return;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof TransformedTextFieldState) == true) goto L8;
        return false;
    L8:
        TransformedTextFieldState r5 = (TransformedTextFieldState) r4;
        if (Intrinsics.areEqual(this.textFieldState, r5.textFieldState) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.codepointTransformation, r5.codepointTransformation) == true) goto L15;
        return false;
    L15:
        return Intrinsics.areEqual(this.outputTransformation, r5.outputTransformation);
    }

    /* JADX INFO: renamed from: mapFromTransformed--jx7JFs, reason: not valid java name */
    public final long m1674mapFromTransformedjx7JFs(int r4) {
        State<TransformedText> r0 = this.outputTransformedText;
        OffsetMappingCalculator r1 = null;
        if (r0 == null) goto L7;
        TransformedText r2 = (TransformedText) r0.getValue();
        if (r2 == null) goto L7;
        OffsetMappingCalculator r3 = r2.getOffsetMapping();
    L8:
        State<TransformedText> r5 = this.codepointTransformedText;
        if (r5 == null) goto L13;
        TransformedText r6 = (TransformedText) r5.getValue();
        if (r6 == null) goto L13;
        r1 = r6.getOffsetMapping();
    L13:
        if (r1 == null) goto L15;
        long r7 = r1.m1613mapFromDestjx7JFs(r4);
    L16:
        if (r3 != null) goto L18;
        return r7;
    L18:
        return Companion.m1681access$mapFromTransformedxdX6G0(Companion, r7, r3);
    L15:
        r7 = TextRangeKt.TextRange(r4);
    L7:
        r3 = null;
        goto L8
    }

    /* JADX INFO: renamed from: mapFromTransformed-GEjPoXI, reason: not valid java name */
    public final long m1675mapFromTransformedGEjPoXI(long r4) {
        State<TransformedText> r0 = this.outputTransformedText;
        OffsetMappingCalculator r1 = null;
        if (r0 == null) goto L7;
        TransformedText r2 = (TransformedText) r0.getValue();
        if (r2 == null) goto L7;
        OffsetMappingCalculator r3 = r2.getOffsetMapping();
    L8:
        State<TransformedText> r5 = this.codepointTransformedText;
        if (r5 == null) goto L13;
        TransformedText r6 = (TransformedText) r5.getValue();
        if (r6 == null) goto L13;
        r1 = r6.getOffsetMapping();
    L13:
        if (r1 == null) goto L15;
        r4 = Companion.m1681access$mapFromTransformedxdX6G0(Companion, r4, r1);
    L15:
        if (r3 != null) goto L17;
        return r4;
    L17:
        return Companion.m1681access$mapFromTransformedxdX6G0(Companion, r4, r3);
    L7:
        r3 = null;
        goto L8
    }

    /* JADX INFO: renamed from: mapToTransformed--jx7JFs, reason: not valid java name */
    public final long m1676mapToTransformedjx7JFs(int r5) {
        State<TransformedText> r0 = this.outputTransformedText;
        OffsetMappingCalculator r1 = null;
        if (r0 == null) goto L7;
        TransformedText r2 = (TransformedText) r0.getValue();
        if (r2 == null) goto L7;
        OffsetMappingCalculator r3 = r2.getOffsetMapping();
    L8:
        State<TransformedText> r4 = this.codepointTransformedText;
        if (r4 == null) goto L13;
        TransformedText r6 = (TransformedText) r4.getValue();
        if (r6 == null) goto L13;
        r1 = r6.getOffsetMapping();
    L13:
        if (r3 == null) goto L15;
        long r7 = r3.m1614mapFromSourcejx7JFs(r5);
    L16:
        if (r1 != null) goto L18;
        return r7;
    L18:
        return Companion.m1682access$mapToTransformedXGyztTk(Companion, r7, r1, getSelectionWedgeAffinity());
    L15:
        r7 = TextRangeKt.TextRange(r5);
    L7:
        r3 = null;
        goto L8
    }

    /* JADX INFO: renamed from: mapToTransformed-GEjPoXI, reason: not valid java name */
    public final long m1677mapToTransformedGEjPoXI(long r10) {
        State<TransformedText> r0 = this.outputTransformedText;
        OffsetMappingCalculator r1 = null;
        if (r0 == null) goto L7;
        TransformedText r2 = (TransformedText) r0.getValue();
        if (r2 == null) goto L7;
        OffsetMappingCalculator r5 = r2.getOffsetMapping();
    L8:
        State<TransformedText> r3 = this.codepointTransformedText;
        if (r3 == null) goto L13;
        TransformedText r4 = (TransformedText) r3.getValue();
        if (r4 == null) goto L13;
        r1 = r4.getOffsetMapping();
    L13:
        if (r5 == null) goto L15;
        r10 = Companion.m1685mapToTransformedXGyztTk$default(Companion, r10, r5, null, 4, null);
    L15:
        if (r1 != null) goto L17;
        return r10;
    L17:
        return Companion.m1682access$mapToTransformedXGyztTk(Companion, r10, r1, getSelectionWedgeAffinity());
    L7:
        r5 = null;
        goto L8
    }

    public final void placeCursorBeforeCharAt(int r3) {
        m1679selectCharsIn5zctL8(TextRangeKt.TextRange(r3));
    }

    public final void replaceAll(CharSequence r7) {
        TextFieldState r0 = this.textFieldState;
        InputTransformation r1 = this.inputTransformation;
        TextFieldEditUndoBehavior r2 = TextFieldEditUndoBehavior.MergeIfPossible;
        r0.getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        TextFieldBuffer r3 = r0.getMainBuffer$foundation_release();
        TextFieldBufferKt.delete(r3, 0, r3.getLength());
        r3.append(r7.toString());
        updateWedgeAffinity(r3);
        TextFieldState.access$commitEditAsUser(r0, r1, true, r2);
    }

    /* JADX INFO: renamed from: selectCharsIn-5zc-tL8, reason: not valid java name */
    public final void m1679selectCharsIn5zctL8(long r1) {
        m1680selectUntransformedCharsIn5zctL8(m1675mapFromTransformedGEjPoXI(r1));
    }

    /* JADX INFO: renamed from: selectUntransformedCharsIn-5zc-tL8, reason: not valid java name */
    public final void m1680selectUntransformedCharsIn5zctL8(long r6) {
        TextFieldState r0 = this.textFieldState;
        InputTransformation r1 = this.inputTransformation;
        TextFieldEditUndoBehavior r2 = TextFieldEditUndoBehavior.MergeIfPossible;
        r0.getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        TextFieldBufferKt.setSelectionCoerced(r0.getMainBuffer$foundation_release(), TextRange.getStart-impl(r6), TextRange.getEnd-impl(r6));
        TextFieldState.access$commitEditAsUser(r0, r1, true, r2);
    }

    public final void setSelectionWedgeAffinity(SelectionWedgeAffinity r2) {
        this.selectionWedgeAffinity$delegate.setValue(r2);
    }

    public final void update(InputTransformation r1) {
        this.inputTransformation = r1;
    }

    public static final /* synthetic */ void access$updateWedgeAffinity(TransformedTextFieldState r0, TextFieldBuffer r1) {
        r0.updateWedgeAffinity(r1);
    }

    private static final TransformedText codepointTransformedText$lambda$3$lambda$2(TransformedTextFieldState r2, CodepointTransformation r3) {
        Companion r0 = Companion;
        State<TransformedText> r1 = r2.outputTransformedText;
        if (r1 == null) goto L8;
        TransformedText r4 = (TransformedText) r1.getValue();
        if (r4 == null) goto L8;
        TextFieldCharSequence r5 = r4.getText();
        if (r5 == null) goto L8;
    L10:
        return Companion.access$calculateTransformedText(r0, r5, r3, r2.getSelectionWedgeAffinity());
    L8:
        r5 = r2.textFieldState.getValue$foundation_release();
        goto L10
    }

    private static final TransformedText outputTransformedText$lambda$1$lambda$0(TransformedTextFieldState r2, OutputTransformation r3) {
        return Companion.access$calculateTransformedText(Companion, r2.textFieldState.getValue$foundation_release(), r3, r2.getSelectionWedgeAffinity());
    }

    public final Object collectImeNotifications(final TextFieldState.NotifyImeListener r5, Continuation<?> r6) {
        if ((r6 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r6;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L12;
        TextFieldState.NotifyImeListener r8 = (TextFieldState.NotifyImeListener) r0.L$0;
        ResultKt.throwOnFailure(r7);
    L23:
        throw new KotlinNothingValueException();
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        if (this.outputTransformation == null) goto L17;
        r5 = new c2(r5, this);
    L17:
        r0.L$0 = r5;
        r0.label = 1;
        kotlinx.coroutines.j r9 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r0), 1);
        r9.C();
        access$getTextFieldState$p(this).addNotifyImeListener$foundation_release(r5);
        r9.i(new TransformedTextFieldState$collectImeNotifications$2$1(this, r5));
        Object r10 = r9.B();
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L20:
        if (r10 != r2) goto L23;
        return r2;
    L7:
        r0 = new AnonymousClass1(this, r6);
        goto L8
    }

    public final void editUntransformedTextAsUser(boolean r5, Function1<? super TextFieldBuffer, Unit> r6) {
        TextFieldState r0 = access$getTextFieldState$p(this);
        InputTransformation r1 = access$getInputTransformation$p(this);
        TextFieldEditUndoBehavior r2 = TextFieldEditUndoBehavior.MergeIfPossible;
        r0.getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        TextFieldBuffer r3 = r0.getMainBuffer$foundation_release();
        r6.invoke(r3);
        access$updateWedgeAffinity(this, r3);
        TextFieldState.access$commitEditAsUser(r0, r1, r5, r2);
    }

    /* JADX INFO: renamed from: highlightCharsIn-7RAjNK8, reason: not valid java name */
    public final void m1673highlightCharsIn7RAjNK8(int r6, long r7) {
        long r8 = m1675mapFromTransformedGEjPoXI(r7);
        TextFieldState r0 = this.textFieldState;
        InputTransformation r1 = this.inputTransformation;
        TextFieldEditUndoBehavior r2 = TextFieldEditUndoBehavior.MergeIfPossible;
        r0.getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        r0.getMainBuffer$foundation_release().m1528setHighlightK7f2yys$foundation_release(r6, TextRange.getStart-impl(r8), TextRange.getEnd-impl(r8));
        TextFieldState.access$commitEditAsUser(r0, r1, true, r2);
    }

    public TransformedTextFieldState(TextFieldState r1, InputTransformation r2, final CodepointTransformation r3, final OutputTransformation r4) {
        this.textFieldState = r1;
        this.inputTransformation = r2;
        this.codepointTransformation = r3;
        this.outputTransformation = r4;
        if (r4 == null) goto L5;
        State<TransformedText> r5 = SnapshotStateKt.derivedStateOf(new a2(this, r4));
    L6:
        this.outputTransformedText = r5;
        if (r3 == null) goto L9;
        State<TransformedText> r6 = SnapshotStateKt.derivedStateOf(new b2(this, r3));
    L10:
        this.codepointTransformedText = r6;
        this.selectionWedgeAffinity$delegate = SnapshotStateKt.mutableStateOf$default(new SelectionWedgeAffinity(WedgeAffinity.Start), null, 2, null);
        return;
    L9:
        r6 = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    public final void replaceSelectedText(CharSequence r7, boolean r8, TextFieldEditUndoBehavior r9, boolean r10) {
        TextFieldState r0 = this.textFieldState;
        InputTransformation r1 = this.inputTransformation;
        r0.getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        TextFieldBuffer r2 = r0.getMainBuffer$foundation_release();
        if (r8 == false) goto L5;
        r2.commitComposition$foundation_release();
    L5:
        long r3 = r2.m1527getSelectiond9O1mEE();
        r2.replace(TextRange.getMin-impl(r3), TextRange.getMax-impl(r3), r7);
        TextFieldBufferKt.setSelectionCoerced$default(r2, TextRange.getMin-impl(r3) + r7.length(), 0, 2, null);
        updateWedgeAffinity(r2);
        TextFieldState.access$commitEditAsUser(r0, r1, r10, r9);
    }

    /* JADX INFO: renamed from: replaceText-M8tDOmk, reason: not valid java name */
    public final void m1678replaceTextM8tDOmk(CharSequence r6, long r7, TextFieldEditUndoBehavior r9, boolean r10) {
        TextFieldState r0 = this.textFieldState;
        InputTransformation r1 = this.inputTransformation;
        r0.getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        TextFieldBuffer r2 = r0.getMainBuffer$foundation_release();
        long r8 = m1675mapFromTransformedGEjPoXI(r7);
        r2.replace(TextRange.getMin-impl(r8), TextRange.getMax-impl(r8), r6);
        TextFieldBufferKt.setSelectionCoerced$default(r2, TextRange.getMin-impl(r8) + r6.length(), 0, 2, null);
        updateWedgeAffinity(r2);
        TextFieldState.access$commitEditAsUser(r0, r1, r10, r9);
    }

    private static final void collectImeNotifications$lambda$20(TextFieldState.NotifyImeListener r2, TransformedTextFieldState r3, TextFieldCharSequence r4, TextFieldCharSequence r5, boolean r6) {
        TransformedText r7 = Companion.access$calculateTransformedText(Companion, r4, r3.outputTransformation, r3.getSelectionWedgeAffinity());
        if (r7 == null) goto L7;
        TextFieldCharSequence r8 = r7.getText();
        if (r8 == null) goto L7;
        r4 = r8;
    L7:
        r2.onChange(r4, r3.getVisualText(), r6);
    }

    public static /* synthetic */ void editUntransformedTextAsUser$default(TransformedTextFieldState r2, boolean r3, Function1 r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L5;
        r3 = true;
    L5:
        TextFieldState r7 = access$getTextFieldState$p(r2);
        InputTransformation r8 = access$getInputTransformation$p(r2);
        TextFieldEditUndoBehavior r0 = TextFieldEditUndoBehavior.MergeIfPossible;
        r7.getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        TextFieldBuffer r1 = r7.getMainBuffer$foundation_release();
        r4.invoke(r1);
        access$updateWedgeAffinity(r2, r1);
        TextFieldState.access$commitEditAsUser(r7, r8, r3, r0);
    }

    public /* synthetic */ TransformedTextFieldState(TextFieldState r2, InputTransformation r3, CodepointTransformation r4, OutputTransformation r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = null;
    L11:
        this(r2, r3, r4, r5);
    }

    public static /* synthetic */ void replaceSelectedText$default(TransformedTextFieldState r0, CharSequence r1, boolean r2, TextFieldEditUndoBehavior r3, boolean r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = false;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = TextFieldEditUndoBehavior.MergeIfPossible;
    L9:
        if ((r5 & 8) == 0) goto L11;
        r4 = true;
    L11:
        r0.replaceSelectedText(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: replaceText-M8tDOmk$default, reason: not valid java name */
    public static /* synthetic */ void m1672replaceTextM8tDOmk$default(TransformedTextFieldState r6, CharSequence r7, long r8, TextFieldEditUndoBehavior r10, boolean r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L5;
        r10 = TextFieldEditUndoBehavior.MergeIfPossible;
    L5:
        TextFieldEditUndoBehavior r4 = r10;
        if ((r12 & 8) == 0) goto L8;
        boolean r5 = true;
    L9:
        r6.m1678replaceTextM8tDOmk(r7, r8, r4, r5);
        return;
    L8:
        r5 = r11;
        goto L9
    }
}
