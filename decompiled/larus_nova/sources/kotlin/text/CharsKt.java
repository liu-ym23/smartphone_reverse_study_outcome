package kotlin.text;

import java.util.Locale;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"kotlin/text/CharsKt__CharJVMKt", "kotlin/text/CharsKt__CharKt"}, k = 4, mv = {1, 9, 0}, xi = 49)
public final class CharsKt extends CharsKt__CharKt {
    public static /* bridge */ /* synthetic */ int checkRadix(int r100) {
        return CharsKt__CharJVMKt.checkRadix(r100);
    }

    public static /* bridge */ /* synthetic */ int digitToInt(char r100) {
        return CharsKt__CharKt.digitToInt(r100);
    }

    public static /* bridge */ /* synthetic */ Integer digitToIntOrNull(char r100) {
        return CharsKt__CharKt.digitToIntOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ boolean equals(char r100, char r101, boolean r102) {
        return CharsKt__CharKt.equals(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ CharCategory getCategory(char r100) {
        return CharsKt__CharJVMKt.getCategory(r100);
    }

    public static /* bridge */ /* synthetic */ boolean isSurrogate(char r100) {
        return CharsKt__CharKt.isSurrogate(r100);
    }

    public static /* bridge */ /* synthetic */ boolean isWhitespace(char r100) {
        return CharsKt__CharJVMKt.isWhitespace(r100);
    }

    public static /* bridge */ /* synthetic */ String lowercase(char r100, Locale r101) {
        return CharsKt__CharJVMKt.lowercase(r100, r101);
    }

    public static /* bridge */ /* synthetic */ String titlecase(char r100) {
        return CharsKt__CharKt.titlecase(r100);
    }

    public static /* bridge */ /* synthetic */ String titlecase(char r100, Locale r101) {
        return CharsKt__CharJVMKt.titlecase(r100, r101);
    }

    private CharsKt() {
    }
}
