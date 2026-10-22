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

/* JADX INFO: loaded from: classes14.dex */
public final class b {
    public b() {
    }

    public final boolean b(Object r100) {
        if (r100 != null) goto L6;
        return true;
    L6:
        if (Intrinsics.areEqual(r100, 0) == false) goto L9;
        return true;
    L9:
        if (Intrinsics.areEqual(r100, "") == false) goto L12;
        return true;
    L12:
        if (Intrinsics.areEqual(r100, Boolean.FALSE) == true) goto L19;
        return false;
    L19:
        return true;
    }

    public final boolean c(Integer r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.intValue() <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean d(Object r100) {
        return !b(r100);
    }

    public final JSONObject e(String r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return k.c(r100);
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
    public final <T> T a(Map<String, ? extends Object> r100, String r101, T r102) {
        if (r101 == null) goto L55;
        List<String> r103 = new Regex("\\[|\\].|\\.").split(r101, 0);     // Catch: Exception -> L38
        ?? r104 = 0;
        if (r103 == null) goto L15;
        ArrayList r105 = new ArrayList();     // Catch: Exception -> L38
        Iterator<T> r106 = r103.iterator();     // Catch: Exception -> L38
    L8:
        if (r106.hasNext() == false) goto L16;
        T r107 = r106.next();     // Catch: Exception -> L38
        if (((String) r107).length() <= 0) goto L12;
        boolean r108 = true;
    L13:
        if (r108 == false) goto L8;
        r105.add(r107);     // Catch: Exception -> L38
        goto L8
    L12:
        r108 = false;
    L16:
        if (r105 == null) goto L30;
        Iterator r109 = r105.iterator();     // Catch: Exception -> L38
    L19:
        if (r109.hasNext() == false) goto L30;
        String r110 = (String) r109.next();     // Catch: Exception -> L38
        if ((r100 instanceof Map) == false) goto L26;
        if (((Map) r100).containsKey(r110) == false) goto L26;
        r100 = ((Map) r100).get(r110);     // Catch: Exception -> L38
    L26:
        if ((r100 instanceof List) == false) goto L58;
        if (StringsKt.toIntOrNull(r110) == null) goto L59;
        r100 = ListProtector.get((List) r100, CastIntegerProtector.parseInt(r110));     // Catch: Exception -> L38
        goto L19
    L59:
        return r102;
    L58:
        return r102;
    L30:
        if ((r100 instanceof Object) == false) goto L34;
        r104 = r100;
    L34:
        if (r104 != 0) goto L37;
        return r102;
    L37:
        return (T) r104;
    L15:
        r105 = null;
    L57:
        return r102;
    L55:
        return r102;
    }
}
