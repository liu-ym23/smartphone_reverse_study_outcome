package kotlin.text;

import android.util.EventsUtils;
import java.util.Locale;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"kotlin/text/CharsKt__CharJVMKt", "kotlin/text/CharsKt__CharKt"}, k = 4, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_IOPRELOAD_DATA)
public final class CharsKt extends CharsKt__CharKt {
    public static /* bridge */ /* synthetic */ int checkRadix(int r0) {
        return CharsKt__CharJVMKt.checkRadix(r0);
    }

    public static /* bridge */ /* synthetic */ int digitToInt(char r0) {
        return CharsKt__CharKt.digitToInt(r0);
    }

    public static /* bridge */ /* synthetic */ Integer digitToIntOrNull(char r0) {
        return CharsKt__CharKt.digitToIntOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ boolean equals(char r0, char r1, boolean r2) {
        return CharsKt__CharKt.equals(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ CharCategory getCategory(char r0) {
        return CharsKt__CharJVMKt.getCategory(r0);
    }

    public static /* bridge */ /* synthetic */ boolean isSurrogate(char r0) {
        return CharsKt__CharKt.isSurrogate(r0);
    }

    public static /* bridge */ /* synthetic */ boolean isWhitespace(char r0) {
        return CharsKt__CharJVMKt.isWhitespace(r0);
    }

    public static /* bridge */ /* synthetic */ String lowercase(char r0, Locale r1) {
        return CharsKt__CharJVMKt.lowercase(r0, r1);
    }

    public static /* bridge */ /* synthetic */ String titlecase(char r0) {
        return CharsKt__CharKt.titlecase(r0);
    }

    public static /* bridge */ /* synthetic */ String titlecase(char r0, Locale r1) {
        return CharsKt__CharJVMKt.titlecase(r0, r1);
    }

    private CharsKt() {
    }
}
