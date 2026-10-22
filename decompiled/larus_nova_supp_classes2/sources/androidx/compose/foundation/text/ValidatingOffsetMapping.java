package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.OffsetMapping;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/compose/foundation/text/ValidatingOffsetMapping;", "Landroidx/compose/ui/text/input/OffsetMapping;", "delegate", "originalLength", "", "transformedLength", "<init>", "(Landroidx/compose/ui/text/input/OffsetMapping;II)V", "originalToTransformed", "offset", "transformedToOriginal", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ValidatingOffsetMapping implements OffsetMapping {
    private final OffsetMapping delegate;
    private final int originalLength;
    private final int transformedLength;

    public int originalToTransformed(int r4) {
        int r0 = this.delegate.originalToTransformed(r4);
        boolean r1 = false;
        if (r4 >= 0) goto L5;
    L7:
        if (r1 == false) goto L9;
        ValidatingOffsetMappingKt.access$validateOriginalToTransformed(r0, this.transformedLength, r4);
    L9:
        return r0;
    L5:
        if (r4 > this.originalLength) goto L7;
        r1 = true;
        goto L7
    }

    public int transformedToOriginal(int r4) {
        int r0 = this.delegate.transformedToOriginal(r4);
        boolean r1 = false;
        if (r4 >= 0) goto L5;
    L7:
        if (r1 == false) goto L9;
        ValidatingOffsetMappingKt.access$validateTransformedToOriginal(r0, this.originalLength, r4);
    L9:
        return r0;
    L5:
        if (r4 > this.transformedLength) goto L7;
        r1 = true;
        goto L7
    }

    public ValidatingOffsetMapping(OffsetMapping r1, int r2, int r3) {
        this.delegate = r1;
        this.originalLength = r2;
        this.transformedLength = r3;
    }
}
