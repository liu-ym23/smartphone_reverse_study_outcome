package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.StringHelpers_jvmKt;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0001\u001a\u001c\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0000¨\u0006\u000b"}, d2 = {"mask", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation$Companion;", "character", "", "toVisualText", "", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "codepointTransformation", "offsetMappingCalculator", "Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CodepointTransformationKt {
    public static final CodepointTransformation mask(CodepointTransformation.Companion r0, char r1) {
        return new MaskCodepointTransformation(r1);
    }

    public static final CharSequence toVisualText(TextFieldCharSequence r8, CodepointTransformation r9, OffsetMappingCalculator r10) {
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
        boolean r2 = false;
        int r3 = 0;
    L4:
        if (r1 >= r8.length()) goto L9;
        int r4 = CodepointHelpers_jvmKt.codePointAt(r8, r1);
        int r5 = r9.transform(r3, r4);
        int r6 = CodepointHelpers_jvmKt.charCount(r4);
        if (r5 == r4) goto L8;
        int r7 = CodepointHelpers_jvmKt.charCount(r5);
        r10.recordEditOperation(r0.length(), r0.length() + r6, r7);
        r2 = true;
    L8:
        StringHelpers_jvmKt.appendCodePointX(r0, r5);
        r1 = r1 + r6;
        r3 = r3 + 1;
        goto L4
    L9:
        String r11 = r0.toString();
        if (r2 == true) goto L12;
        return r8;
    L12:
        return r11;
    }
}
