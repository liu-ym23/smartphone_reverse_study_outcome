package androidx.compose.foundation.text.input.internal;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\tHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/text/input/internal/MaskCodepointTransformation;", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "character", "", "<init>", "(C)V", "getCharacter", "()C", "transform", "", "codepointIndex", "codepoint", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class MaskCodepointTransformation implements CodepointTransformation {
    private final char character;

    public static /* synthetic */ MaskCodepointTransformation copy$default(MaskCodepointTransformation r0, char r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.character;
    L6:
        return r0.copy(r1);
    }

    public final char component1() {
        return this.character;
    }

    public final MaskCodepointTransformation copy(char r2) {
        return new MaskCodepointTransformation(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof MaskCodepointTransformation) == true) goto L9;
        return false;
    L9:
        if (this.character == ((MaskCodepointTransformation) r4).character) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.character;
    }

    public String toString() {
        return "MaskCodepointTransformation(character=" + this.character + ')';
    }

    public final char getCharacter() {
        return this.character;
    }

    public MaskCodepointTransformation(char r1) {
        this.character = r1;
    }

    @Override // androidx.compose.foundation.text.input.internal.CodepointTransformation
    public int transform(int r1, int r2) {
        return this.character;
    }
}
