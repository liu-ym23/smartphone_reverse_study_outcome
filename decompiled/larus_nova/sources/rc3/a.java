package rc3;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class a {
    public static final Integer a(String r110) {
        Object r100 = null;
        int r111 = 0;
        if (r110 != null) goto L5;
    L47:
        if (r110 != null) goto L49;
        return null;
    L49:
        if (StringsKt.startsWith$default(r110, "#", false, 2, null) != true) goto L67;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L52
        Object r102 = Result.m9449constructorimpl(Integer.valueOf(Color.parseColor(r110)));     // Catch: Throwable -> L52
    L55:
        if (Result.m9455isFailureimpl(r102) == true) goto L59;
        r100 = r102;
    L59:
        return (Integer) r100;
    L52:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L55
    L67:
        return null;
    L5:
        if (StringsKt.startsWith$default(r110, "rgba", false, 2, null) != true) goto L47;
        List r104 = StringsKt.split$default(StringsKt.replace$default(StringsKt.replace$default(r110, "rgba(", "", false, 4, null), ")", "", false, 4, null), new String[]{","}, false, 0, 6, null);
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator r106 = r104.iterator();
    L8:
        if (r106.hasNext() == false) goto L14;
        String r107 = (String) r106.next();
        if (r107 == null) goto L13;
        r105.add(StringsKt.trim(r107).toString());
        goto L8
    L13:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L14:
        List r108 = CollectionsKt.toList(r105);
        String r109 = (String) CollectionsKt.getOrNull(r108, 0);
        if (r109 == null) goto L19;
        Integer r112 = StringsKt.toIntOrNull(r109);
        if (r112 == null) goto L19;
        int r113 = r112.intValue();
    L20:
        String r114 = (String) CollectionsKt.getOrNull(r108, 1);
        if (r114 == null) goto L25;
        Integer r115 = StringsKt.toIntOrNull(r114);
        if (r115 == null) goto L25;
        int r116 = r115.intValue();
    L26:
        String r117 = (String) CollectionsKt.getOrNull(r108, 2);
        if (r117 == null) goto L31;
        Integer r118 = StringsKt.toIntOrNull(r117);
        if (r118 == null) goto L31;
        r111 = r118.intValue();
    L31:
        String r119 = (String) CollectionsKt.getOrNull(r108, 3);
        if (r119 == null) goto L36;
        Float r120 = StringsKt.toFloatOrNull(r119);
        if (r120 == null) goto L36;
        float r121 = r120.floatValue();
    L62:
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L39
        Object r123 = Result.m9449constructorimpl(Integer.valueOf(Color.argb((int) (255 * r121), r113, r116, r111)));     // Catch: Throwable -> L39
    L42:
        if (Result.m9455isFailureimpl(r123) == true) goto L46;
        r100 = r123;
    L46:
        return (Integer) r100;
    L39:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r123 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L36:
        r121 = 0.0f;
    L25:
        r116 = 0;
    L19:
        r113 = 0;
        goto L20
    }
}
