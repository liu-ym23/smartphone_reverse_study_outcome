package rc3;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final Integer a(String r17) {
        Object r9 = null;
        int r10 = 0;
        if (r17 != null) goto L5;
    L47:
        if (r17 != null) goto L49;
        return null;
    L49:
        if (StringsKt.startsWith$default(r17, "#", false, 2, null) != true) goto L67;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L52
        Object r0 = Result.constructor-impl(Integer.valueOf(Color.parseColor(r17)));     // Catch: Throwable -> L52
    L55:
        if (Result.isFailure-impl(r0) == true) goto L59;
        r9 = r0;
    L59:
        return (Integer) r9;
    L52:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L55
    L67:
        return null;
    L5:
        if (StringsKt.startsWith$default(r17, "rgba", false, 2, null) != true) goto L47;
        List r3 = StringsKt.split$default(StringsKt.replace$default(StringsKt.replace$default(r17, "rgba(", "", false, 4, null), ")", "", false, 4, null), new String[]{","}, false, 0, 6, null);
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r5 = r3.iterator();
    L8:
        if (r5.hasNext() == false) goto L14;
        String r6 = (String) r5.next();
        if (r6 == null) goto L13;
        r4.add(StringsKt.trim(r6).toString());
        goto L8
    L13:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L14:
        List r7 = CollectionsKt.toList(r4);
        String r8 = (String) CollectionsKt.getOrNull(r7, 0);
        if (r8 == null) goto L19;
        Integer r11 = StringsKt.toIntOrNull(r8);
        if (r11 == null) goto L19;
        int r12 = r11.intValue();
    L20:
        String r13 = (String) CollectionsKt.getOrNull(r7, 1);
        if (r13 == null) goto L25;
        Integer r14 = StringsKt.toIntOrNull(r13);
        if (r14 == null) goto L25;
        int r15 = r14.intValue();
    L26:
        String r16 = (String) CollectionsKt.getOrNull(r7, 2);
        if (r16 == null) goto L31;
        Integer r18 = StringsKt.toIntOrNull(r16);
        if (r18 == null) goto L31;
        r10 = r18.intValue();
    L31:
        String r19 = (String) CollectionsKt.getOrNull(r7, 3);
        if (r19 == null) goto L36;
        Float r20 = StringsKt.toFloatOrNull(r19);
        if (r20 == null) goto L36;
        float r21 = r20.floatValue();
    L62:
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L39
        Object r23 = Result.constructor-impl(Integer.valueOf(Color.argb((int) (255 * r21), r12, r15, r10)));     // Catch: Throwable -> L39
    L42:
        if (Result.isFailure-impl(r23) == true) goto L46;
        r9 = r23;
    L46:
        return (Integer) r9;
    L39:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
    L36:
        r21 = 0.0f;
    L25:
        r15 = 0;
    L19:
        r12 = 0;
        goto L20
    }
}
