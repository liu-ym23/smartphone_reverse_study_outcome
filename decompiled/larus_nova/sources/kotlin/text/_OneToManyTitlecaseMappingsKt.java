package kotlin.text;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\f\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"titlecaseImpl", "", "", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class _OneToManyTitlecaseMappingsKt {
    public static final String titlecaseImpl(char r100) {
        String r101 = String.valueOf(r100);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type java.lang.String");
        Locale r102 = Locale.ROOT;
        String r103 = r101.toUpperCase(r102);
        if (r103.length() <= 1) goto L10;
        if (r100 == 329) goto L11;
        char r104 = r103.charAt(0);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type java.lang.String");
        String r105 = r103.substring(1);
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type java.lang.String");
        return r104 + r105.toLowerCase(r102);
    L11:
        return r103;
    L10:
        return String.valueOf(Character.toTitleCase(r100));
    }
}
