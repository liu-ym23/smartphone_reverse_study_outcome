package androidx.compose.foundation.text.input;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.style.TextDecoration;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a#\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0012\u0010\b\u001a\u00020\t*\u00020\u00012\u0006\u0010\n\u001a\u00020\u0003\u001a\u0012\u0010\u000b\u001a\u00020\t*\u00020\u00012\u0006\u0010\n\u001a\u00020\u0003\u001a\n\u0010\f\u001a\u00020\t*\u00020\u0001\u001aA\u0010\r\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00100\u000fj\u0002`\u00110\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0018\u0010\u0013\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00100\u000fj\u0002`\u0011\u0018\u00010\u0014H\u0002¢\u0006\u0002\b\u0015\u001a\n\u0010\u0016\u001a\u00020\u0017*\u00020\u0001¨\u0006\u0018"}, d2 = {"rememberTextFieldState", "Landroidx/compose/foundation/text/input/TextFieldState;", "initialText", "", "initialSelection", "Landroidx/compose/ui/text/TextRange;", "rememberTextFieldState-Le-punE", "(Ljava/lang/String;JLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/text/input/TextFieldState;", "setTextAndPlaceCursorAtEnd", "", "text", "setTextAndSelectAll", "clearText", "finalizeComposingAnnotations", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "Landroidx/compose/foundation/text/input/PlacedAnnotation;", "composition", "annotationList", "Landroidx/compose/runtime/collection/MutableVector;", "finalizeComposingAnnotations-itr0ztk", "toTextFieldBuffer", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextFieldStateKt {
    public static /* synthetic */ TextFieldState a(String r0, long r1) {
        return rememberTextFieldState_Le_punE$lambda$1$lambda$0(r0, r1);
    }

    public static final void clearText(TextFieldState r3) {
        TextFieldBuffer r0 = r3.startEdit();
        TextFieldBufferKt.delete(r0, 0, r0.getLength());     // Catch: Throwable -> L6
        TextFieldBufferKt.placeCursorAtEnd(r0);     // Catch: Throwable -> L6
        r3.commitEdit(r0);     // Catch: Throwable -> L6
        r3.finishEditing();
        return;
    L6:
        th = move-exception;
        r3.finishEditing();
        throw th;
    }

    public static final TextFieldBuffer toTextFieldBuffer(TextFieldState r8) {
        TextFieldBuffer r7 = new TextFieldBuffer(r8.getValue$foundation_release(), null, null, null, 14, null);
        r7.setCanCallAddStyle$foundation_release(true);
        return r7;
    }

    /* JADX INFO: renamed from: access$finalizeComposingAnnotations-itr0ztk, reason: not valid java name */
    public static final /* synthetic */ List m1539access$finalizeComposingAnnotationsitr0ztk(TextRange r0, MutableVector r1) {
        return m1540finalizeComposingAnnotationsitr0ztk(r0, r1);
    }

    /* JADX INFO: renamed from: finalizeComposingAnnotations-itr0ztk, reason: not valid java name */
    private static final List<AnnotatedString.Range<AnnotatedString.Annotation>> m1540finalizeComposingAnnotationsitr0ztk(TextRange r25, MutableVector<AnnotatedString.Range<AnnotatedString.Annotation>> r26) {
        if (r26 != null) goto L4;
    L9:
        if (r25 == null) goto L14;
        if (TextRange.getCollapsed-impl(r25.unbox-impl()) == true) goto L14;
        return CollectionsKt.listOf(new AnnotatedString.Range(new SpanStyle(0, 0, null, null, null, null, null, 0, null, null, null, 0, TextDecoration.Companion.getUnderline(), null, null, null, 61439, null), TextRange.getMin-impl(r25.unbox-impl()), TextRange.getMax-impl(r25.unbox-impl())));
    L14:
        return CollectionsKt.emptyList();
    L4:
        if (r26.getSize() == 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        return CollectionsKt.toList(r26.asMutableList());
    L6:
        r0 = false;
        goto L7
    }

    private static final TextFieldState rememberTextFieldState_Le_punE$lambda$1$lambda$0(String r2, long r3) {
        return new TextFieldState(r2, r3, null);
    }

    public static final void setTextAndPlaceCursorAtEnd(TextFieldState r3, String r4) {
        TextFieldBuffer r0 = r3.startEdit();
        r0.replace(0, r0.getLength(), r4);     // Catch: Throwable -> L6
        TextFieldBufferKt.placeCursorAtEnd(r0);     // Catch: Throwable -> L6
        r3.commitEdit(r0);     // Catch: Throwable -> L6
        r3.finishEditing();
        return;
    L6:
        th = move-exception;
        r3.finishEditing();
        throw th;
    }

    public static final void setTextAndSelectAll(TextFieldState r3, String r4) {
        TextFieldBuffer r0 = r3.startEdit();
        r0.replace(0, r0.getLength(), r4);     // Catch: Throwable -> L6
        TextFieldBufferKt.selectAll(r0);     // Catch: Throwable -> L6
        r3.commitEdit(r0);     // Catch: Throwable -> L6
        r3.finishEditing();
        return;
    L6:
        th = move-exception;
        r3.finishEditing();
        throw th;
    }

    /* JADX INFO: renamed from: rememberTextFieldState-Le-punE, reason: not valid java name */
    public static final TextFieldState m1541rememberTextFieldStateLepunE(final String r7, final long r8, Composer r10, int r11, int r12) {
        if ((r12 & 1) == 0) goto L6;
        r7 = "";
    L6:
        if ((r12 & 2) == 0) goto L9;
        r8 = TextRangeKt.TextRange(r7.length());
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(1125389485, r11, -1, "androidx.compose.foundation.text.input.rememberTextFieldState (TextFieldState.kt:660)");
    L11:
        boolean r13 = false;
        Object[] r0 = new Object[0];
        TextFieldState.Saver r1 = TextFieldState.Saver.INSTANCE;
        if (((r11 & 14) ^ 6) <= 4) goto L16;
        if (r10.changed(r7) == false) goto L16;
    L17:
        boolean r2 = true;
    L20:
        if (((r11 & 112) ^ 48) <= 32) goto L24;
        if (r10.changed(r8) == false) goto L24;
    L25:
        r13 = true;
    L26:
        boolean r14 = r2 | r13;
        Object r15 = r10.rememberedValue();
        if (r14 == false) goto L29;
    L30:
        r15 = new a(r7, r8);
        r10.updateRememberedValue(r15);
    L31:
        TextFieldState r9 = (TextFieldState) RememberSaveableKt.rememberSaveable(r0, r1, (Function0) r15, r10, 48);
        if (ComposerKt.isTraceInProgress() == false) goto L34;
        ComposerKt.traceEventEnd();
    L34:
        return r9;
    L29:
        if (r15 != Composer.Companion.getEmpty()) goto L31;
    L24:
        if ((r11 & 48) != 32) goto L26;
    L16:
        if ((r11 & 6) == 4) goto L17;
        r2 = false;
        goto L20
    }
}
