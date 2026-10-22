package kl3;

import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public b() {
    }

    public final boolean b(Object r4) {
        if (r4 != null) goto L6;
        return true;
    L6:
        if (Intrinsics.areEqual(r4, 0) == false) goto L9;
        return true;
    L9:
        if (Intrinsics.areEqual(r4, "") == false) goto L12;
        return true;
    L12:
        if (Intrinsics.areEqual(r4, Boolean.FALSE) == true) goto L19;
        return false;
    L19:
        return true;
    }

    public final boolean c(Integer r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (r2.intValue() <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean d(Object r1) {
        return !b(r1);
    }

    public final JSONObject e(String r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return k.c(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.util.Map<java.lang.String, ? extends java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v2 */
    public final <T> T a(Map<String, ? extends Object> r6, String r7, T r8) {
        if (r7 == null) goto L55;
        List r9 = new Regex("\\[|\\].|\\.").split(r7, 0);     // Catch: Exception -> L38
        ?? r1 = 0;
        if (r9 == null) goto L15;
        ArrayList r2 = new ArrayList();     // Catch: Exception -> L38
        Iterator<T> r10 = r9.iterator();     // Catch: Exception -> L38
    L8:
        if (r10.hasNext() == false) goto L16;
        T r3 = r10.next();     // Catch: Exception -> L38
        if (((String) r3).length() <= 0) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == false) goto L8;
        r2.add(r3);     // Catch: Exception -> L38
        goto L8
    L12:
        r4 = false;
    L16:
        if (r2 == null) goto L30;
        Iterator r11 = r2.iterator();     // Catch: Exception -> L38
    L19:
        if (r11.hasNext() == false) goto L30;
        String r0 = (String) r11.next();     // Catch: Exception -> L38
        if ((r6 instanceof Map) == false) goto L26;
        if (((Map) r6).containsKey(r0) == false) goto L26;
        r6 = ((Map) r6).get(r0);     // Catch: Exception -> L38
    L26:
        if ((r6 instanceof List) == false) goto L58;
        if (StringsKt.toIntOrNull(r0) == null) goto L59;
        r6 = ListProtector.get((List) r6, CastIntegerProtector.parseInt(r0));     // Catch: Exception -> L38
        goto L19
    L59:
        return r8;
    L58:
        return r8;
    L30:
        if ((r6 instanceof Object) == false) goto L34;
        r1 = r6;
    L34:
        if (r1 != 0) goto L37;
        return r8;
    L37:
        return (T) r1;
    L15:
        r2 = null;
    L57:
        return r8;
    L55:
        return r8;
    }
}
