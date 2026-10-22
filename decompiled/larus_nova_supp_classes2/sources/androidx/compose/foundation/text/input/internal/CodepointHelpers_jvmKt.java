package androidx.compose.foundation.text.input.internal;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0005\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¨\u0006\u0007"}, d2 = {"codePointAt", "", "", "index", "charCount", "codePoint", "codePointBefore", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CodepointHelpers_jvmKt {
    public static final int charCount(int r0) {
        return Character.charCount(r0);
    }

    public static final int codePointAt(CharSequence r0, int r1) {
        return Character.codePointAt(r0, r1);
    }

    public static final int codePointBefore(CharSequence r0, int r1) {
        return Character.codePointBefore(r0, r1);
    }
}
