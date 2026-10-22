package com.bytedance.sdk.account.log.util;

import android.os.Bundle;
import android.util.Log;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class LogFormatter {
    static {
    }

    public static String a(Pair[] r100) {
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L6;
        Pair r104 = r100[r103];
        String r105 = (String) r104.component1();
        Object r106 = r104.component2();
        r101.append(r105);
        r101.append(" = ");
        r101.append(c(b(r106), r105.length() + 3));
        r101.append("\n");
        r103 = r103 + 1;
        goto L3
    L6:
        return r101.toString();
    }

    public static String b(final Object r110) {
        if ((r110 instanceof Object[]) == false) goto L6;
        return Arrays.toString((Object[]) r110);
    L6:
        if ((r110 instanceof int[]) == false) goto L9;
        return Arrays.toString((int[]) r110);
    L9:
        if ((r110 instanceof boolean[]) == false) goto L12;
        return Arrays.toString((boolean[]) r110);
    L12:
        if ((r110 instanceof char[]) == false) goto L15;
        return Arrays.toString((char[]) r110);
    L15:
        if ((r110 instanceof byte[]) == false) goto L18;
        return Arrays.toString((byte[]) r110);
    L18:
        if ((r110 instanceof short[]) == false) goto L21;
        return Arrays.toString((short[]) r110);
    L21:
        if ((r110 instanceof long[]) == false) goto L24;
        return Arrays.toString((long[]) r110);
    L24:
        if ((r110 instanceof float[]) == false) goto L27;
        return Arrays.toString((float[]) r110);
    L27:
        if ((r110 instanceof double[]) == false) goto L30;
        return Arrays.toString((double[]) r110);
    L30:
        if ((r110 instanceof JSONObject) == false) goto L33;
        return ((JSONObject) r110).toString(2);
    L33:
        if ((r110 instanceof JSONArray) == true) goto L92;
        int r100 = 0;
        if ((r110 instanceof Map) == false) goto L51;
        StringBuilder r101 = new StringBuilder("{\n");
        Map r102 = (Map) r110;
        Iterator r111 = r102.entrySet().iterator();
    L39:
        if (r111.hasNext() == false) goto L49;
        Map.Entry r112 = (Map.Entry) r111.next();
        Object r113 = r112.getKey();
        Object r114 = r112.getValue();
        r101.append(tb2.c.DEFAULT_TEXT);
        r101.append(r113);
        r101.append(" = ");
        if (r114 != r110) goto L43;
        String r115 = "<Self Reference!>";
    L44:
        r101.append(r115);
        if (r100 != (r102.entrySet().size() - 1)) goto L47;
        String r116 = "";
    L48:
        r101.append(r116);
        r100 = r100 + 1;
        goto L39
    L47:
        r116 = ",\n";
        goto L48
    L43:
        r115 = c(b(r114), 2);
        goto L44
    L49:
        r101.append("\n}");
        return r101.toString();
    L51:
        if ((r110 instanceof Collection) == false) goto L57;
        if (((Collection) r110).size() <= 5) goto L95;
        return CollectionsKt.joinToString$default((Iterable) r110, ", \n", "[\n", "\n]", 0, null, new LogFormatter$toLoggableString$1(r110), 24, null);
    L95:
        return CollectionsKt.joinToString$default((Iterable) r110, ", ", "[", "]", 0, null, new LogFormatter$toLoggableString$2(r110), 24, null);
    L57:
        if ((r110 instanceof Throwable) == false) goto L60;
        return Log.getStackTraceString((Throwable) r110);
    L60:
        if ((r110 instanceof Bundle) == false) goto L75;
        StringBuilder r103 = new StringBuilder("Bundle {\n");
        Bundle r104 = (Bundle) r110;
        Iterator<T> r117 = r104.keySet().iterator();
    L63:
        if (r117.hasNext() == false) goto L73;
        String r118 = (String) r117.next();
        Object r119 = r104.get(r118);
        r103.append(tb2.c.DEFAULT_TEXT);
        r103.append(r118);
        r103.append(" = ");
        if (r119 != r110) goto L67;
        String r120 = "<Self Reference!>";
    L68:
        r103.append(r120);
        if (r100 != (r104.size() - 1)) goto L71;
        String r121 = "";
    L72:
        r103.append(r121);
        r100 = r100 + 1;
        goto L63
    L71:
        r121 = ",\n";
        goto L72
    L67:
        r120 = c(b(r119), 2);
        goto L68
    L73:
        r103.append("\n}");
        return r103.toString();
    L75:
        return String.valueOf(r110);
    L92:
        return ((JSONArray) r110).toString(2);
    }

    public static String c(String r100, int r110) {
        int r101 = 0;
        if (StringsKt.contains$default(r100, "\n", false, 2, null) == true) goto L5;
        return r100;
    L5:
        List r102 = StringsKt.split$default(r100, new String[]{"\n"}, false, 0, 6, null);
        StringBuilder r103 = new StringBuilder();
        int r104 = r102.size();
    L6:
        if (r101 >= r104) goto L14;
        if (r101 == 0) goto L9;
        r103.append(StringsKt.repeat(" ", r110));
    L9:
        r103.append((String) ListProtector.get(r102, r101));
        if (r101 >= (r102.size() - 1)) goto L12;
        r103.append("\n");
    L12:
        r101 = r101 + 1;
        goto L6
    L14:
        return r103.toString();
    }
}
