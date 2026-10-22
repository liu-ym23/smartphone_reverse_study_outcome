package androidx.compose.foundation.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.SpanStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005¨\u0006\u0011"}, d2 = {"Landroidx/compose/foundation/text/TextAnnotatorScope;", "", "initialText", "Landroidx/compose/ui/text/AnnotatedString;", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;)V", "styledText", "getStyledText", "()Landroidx/compose/ui/text/AnnotatedString;", "setStyledText", "replaceStyle", "", "linkRange", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/LinkAnnotation;", "newStyle", "Landroidx/compose/ui/text/SpanStyle;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class TextAnnotatorScope {
    private final AnnotatedString initialText;
    private AnnotatedString styledText;

    public static /* synthetic */ AnnotatedString.Range a(Ref.BooleanRef r0, AnnotatedString.Range r1, SpanStyle r2, AnnotatedString.Range r3) {
        return replaceStyle$lambda$0(r0, r1, r2, r3);
    }

    public final AnnotatedString getStyledText() {
        return this.styledText;
    }

    public TextAnnotatorScope(AnnotatedString r1) {
        this.initialText = r1;
        this.styledText = r1;
    }

    public final void setStyledText(AnnotatedString r1) {
        this.styledText = r1;
    }

    public final void replaceStyle(final AnnotatedString.Range<LinkAnnotation> r4, final SpanStyle r5) {
        final Ref.BooleanRef r0 = new Ref.BooleanRef();
        this.styledText = this.initialText.mapAnnotations(new h3(r0, r4, r5));
    }

    private static final AnnotatedString.Range replaceStyle$lambda$0(Ref.BooleanRef r26, AnnotatedString.Range r27, SpanStyle r28, AnnotatedString.Range r29) {
        if (r26.element == true) goto L5;
    L15:
        AnnotatedString.Range r1 = r29;
        AnnotatedString.Range r3 = r1;
    L16:
        r26.element = Intrinsics.areEqual(r27, r3);
        return r1;
    L5:
        if ((r29.getItem() instanceof SpanStyle) == false) goto L15;
        if (r29.getStart() != r27.getStart()) goto L15;
        if (r29.getEnd() != r27.getEnd()) goto L15;
        if (r28 != null) goto L13;
        SpanStyle r2 = new SpanStyle(0, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, null, 65535, null);
    L14:
        r1 = new AnnotatedString.Range(r2, r29.getStart(), r29.getEnd());
        r3 = r29;
        goto L16
    L13:
        r2 = r28;
        goto L14
    }
}
