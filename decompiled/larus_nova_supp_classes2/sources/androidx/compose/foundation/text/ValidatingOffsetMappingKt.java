package androidx.compose.foundation.text;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u001a\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a\u001e\u0010\t\u001a\u00020\n*\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fH\u0001\u001a \u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0002\u001a \u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0014"}, d2 = {"ValidatingEmptyOffsetMappingIdentity", "Landroidx/compose/ui/text/input/OffsetMapping;", "getValidatingEmptyOffsetMappingIdentity", "()Landroidx/compose/ui/text/input/OffsetMapping;", "filterWithValidation", "Landroidx/compose/ui/text/input/TransformedText;", "Landroidx/compose/ui/text/input/VisualTransformation;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "throwIfNotValidTransform", "", "originalLength", "", "limit", "validateTransformedToOriginal", "originalOffset", "offset", "validateOriginalToTransformed", "transformedOffset", "transformedLength", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ValidatingOffsetMappingKt {
    private static final OffsetMapping ValidatingEmptyOffsetMappingIdentity = null;

    static {
        ValidatingEmptyOffsetMappingIdentity = new ValidatingOffsetMapping(OffsetMapping.Companion.getIdentity(), 0, 0);
    }

    public static final OffsetMapping getValidatingEmptyOffsetMappingIdentity() {
        return ValidatingEmptyOffsetMappingIdentity;
    }

    public static final TransformedText filterWithValidation(VisualTransformation r4, AnnotatedString r5) {
        TransformedText r6 = r4.filter(r5);
        throwIfNotValidTransform$default(r6, r5.length(), 0, 2, null);
        return new TransformedText(r6.getText(), new ValidatingOffsetMapping(r6.getOffsetMapping(), r5.length(), r6.getText().length()));
    }

    public static final /* synthetic */ void access$validateOriginalToTransformed(int r0, int r1, int r2) {
        validateOriginalToTransformed(r0, r1, r2);
    }

    public static final /* synthetic */ void access$validateTransformedToOriginal(int r0, int r1, int r2) {
        validateTransformedToOriginal(r0, r1, r2);
    }

    public static final void throwIfNotValidTransform(TransformedText r5, int r6, int r7) {
        int r0 = r5.getText().length();
        int r1 = Math.min(r6, r7);
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        validateOriginalToTransformed(r5.getOffsetMapping().originalToTransformed(r3), r0, r3);
        r3 = r3 + 1;
        goto L3
    L5:
        validateOriginalToTransformed(r5.getOffsetMapping().originalToTransformed(r6), r0, r6);
        int r8 = Math.min(r0, r7);
    L6:
        if (r2 >= r8) goto L8;
        validateTransformedToOriginal(r5.getOffsetMapping().transformedToOriginal(r2), r6, r2);
        r2 = r2 + 1;
        goto L6
    L8:
        validateTransformedToOriginal(r5.getOffsetMapping().transformedToOriginal(r0), r6, r0);
    }

    private static final void validateOriginalToTransformed(int r2, int r3, int r4) {
        boolean r0 = false;
        if (r2 < 0) goto L6;
        if (r2 > r3) goto L6;
        r0 = true;
    L6:
        if (r0 == true) goto L9;
        InlineClassHelperKt.throwIllegalStateException("OffsetMapping.originalToTransformed returned invalid mapping: " + r4 + " -> " + r2 + " is not in range of transformed text [0, " + r3 + ']');
        return;
    }

    private static final void validateTransformedToOriginal(int r2, int r3, int r4) {
        boolean r0 = false;
        if (r2 < 0) goto L6;
        if (r2 > r3) goto L6;
        r0 = true;
    L6:
        if (r0 == true) goto L9;
        InlineClassHelperKt.throwIllegalStateException("OffsetMapping.transformedToOriginal returned invalid mapping: " + r4 + " -> " + r2 + " is not in range of original text [0, " + r3 + ']');
        return;
    }

    public static /* synthetic */ void throwIfNotValidTransform$default(TransformedText r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = 100;
    L5:
        throwIfNotValidTransform(r0, r1, r2);
    }
}
