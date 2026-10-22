package xfa;

import android.os.Bundle;
import com.alipay.sdk.m.u.i;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f563551a = 0;

    static {
    }

    public static String c(String r100) {
        StringBuilder r101 = new StringBuilder(r100.length());
        int r102 = 0;
    L4:
        if (r102 >= r100.length()) goto L24;
        char r103 = r100.charAt(r102);
        if (r103 != '\f') goto L8;
        r101.append("\\f");
    L22:
        r102 = r102 + 1;
        goto L4
    L8:
        if (r103 != '\r') goto L10;
        r101.append("\\r");
        goto L22
    L10:
        if (r103 != '\"') goto L12;
        r101.append("\\\"");
        goto L22
    L12:
        if (r103 == '\\') goto L18;
        switch(r103) {
            case 8: goto L17;
            case 9: goto L16;
            case 10: goto L15;
            default: goto L14;
        };
    L14:
        r101.append(r103);
        goto L22
    L15:
        r101.append("\\n");
        goto L22
    L16:
        r101.append("\\t");
        goto L22
    L17:
        r101.append("\\b");
        goto L22
    L18:
        r101.append("\\\\");
        goto L22
    L24:
        return r101.toString();
    }

    public static String b(Bundle r110, int r111) {
        StringBuilder r100 = new StringBuilder();
        r100.append("{");
        List r101 = CollectionsKt.toList(r110.keySet());
        int r102 = Math.min(r101.size(), 30);
        Iterator r103 = CollectionsKt.take(r101, 30).iterator();
        int r104 = 0;
    L4:
        if (r103.hasNext() == false) goto L18;
        Object r105 = r103.next();
        int r112 = r104 + 1;
        if (r104 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        String r106 = (String) r105;
        r100.append(Typography.quote);     // Catch: Exception -> L13
        Intrinsics.checkNotNull(r106);     // Catch: Exception -> L13
        r100.append(c(r106));     // Catch: Exception -> L13
        r100.append(Typography.quote);     // Catch: Exception -> L13
        r100.append(": ");     // Catch: Exception -> L13
        a(r100, r110.get(r106), r111);     // Catch: Exception -> L13
        if (r104 >= (r102 - 1)) goto L16;
        r100.append(", ");     // Catch: Exception -> L13
    L16:
        r104 = r112;
    L13:
        r100.append(Typography.quote);
        Intrinsics.checkNotNull(r106);
        r100.append(c(r106));
        r100.append(Typography.quote);
        r100.append(": ");
        r100.append(Typography.quote);
        r100.append(c("[Error serializing value]"));
        r100.append(Typography.quote);
        if (r104 >= (r102 - 1)) goto L16;
        r100.append(", ");
        goto L16
    L18:
        if (r101.size() <= 30) goto L22;
        if (r102 <= 0) goto L21;
        r100.append(", ");
    L21:
        r100.append(Typography.quote);
        r100.append(c("[TRUNCATED: more than 30 keys]"));
        r100.append(Typography.quote);
        r100.append(": ");
        r100.append(Typography.quote);
        r100.append(c("..."));
        r100.append(Typography.quote);
    L22:
        r100.append(i.f25855d);
        return r100.toString();
    }

    public static void a(StringBuilder r100, Object r101, int r102) {
        if (r101 != null) goto L5;
        r100.append("null");
        return;
    L5:
        if ((r101 instanceof String) == false) goto L8;
        r100.append(Typography.quote);
        r100.append(c((String) r101));
        r100.append(Typography.quote);
        return;
    L8:
        if ((r101 instanceof Integer) == false) goto L10;
    L79:
        r100.append(r101);
        return;
    L10:
        if ((r101 instanceof Long) == true) goto L79;
        if ((r101 instanceof Float) == true) goto L79;
        if ((r101 instanceof Double) == true) goto L79;
        if ((r101 instanceof Boolean) == true) goto L79;
        if ((r101 instanceof Bundle) == true) goto L21;
        int r103 = 0;
        if ((r101 instanceof int[]) == false) goto L34;
        r100.append("[");
        int[] r104 = (int[]) r101;
        int r105 = r104.length;
        int r106 = 0;
    L27:
        if (r103 >= r105) goto L32;
        int r107 = r106 + 1;
        r100.append(r104[r103]);
        if (r106 >= (r104.length - 1)) goto L31;
        r100.append(", ");
    L31:
        r103 = r103 + 1;
        r106 = r107;
        goto L27
    L32:
        r100.append("]");
        return;
    L34:
        if ((r101 instanceof long[]) == false) goto L43;
        r100.append("[");
        long[] r108 = (long[]) r101;
        int r109 = r108.length;
        int r110 = 0;
    L36:
        if (r103 >= r109) goto L41;
        int r111 = r110 + 1;
        r100.append(r108[r103]);
        if (r110 >= (r108.length - 1)) goto L40;
        r100.append(", ");
    L40:
        r103 = r103 + 1;
        r110 = r111;
        goto L36
    L41:
        r100.append("]");
        return;
    L43:
        if ((r101 instanceof float[]) == false) goto L52;
        r100.append("[");
        float[] r112 = (float[]) r101;
        int r113 = r112.length;
        int r114 = 0;
    L45:
        if (r103 >= r113) goto L50;
        int r115 = r114 + 1;
        r100.append(r112[r103]);
        if (r114 >= (r112.length - 1)) goto L49;
        r100.append(", ");
    L49:
        r103 = r103 + 1;
        r114 = r115;
        goto L45
    L50:
        r100.append("]");
        return;
    L52:
        if ((r101 instanceof double[]) == false) goto L61;
        r100.append("[");
        double[] r116 = (double[]) r101;
        int r117 = r116.length;
        int r118 = 0;
    L54:
        if (r103 >= r117) goto L59;
        int r119 = r118 + 1;
        r100.append(r116[r103]);
        if (r118 >= (r116.length - 1)) goto L58;
        r100.append(", ");
    L58:
        r103 = r103 + 1;
        r118 = r119;
        goto L54
    L59:
        r100.append("]");
        return;
    L61:
        if ((r101 instanceof boolean[]) == false) goto L70;
        r100.append("[");
        boolean[] r120 = (boolean[]) r101;
        int r121 = r120.length;
        int r122 = 0;
    L63:
        if (r103 >= r121) goto L68;
        int r123 = r122 + 1;
        r100.append(r120[r103]);
        if (r122 >= (r120.length - 1)) goto L67;
        r100.append(", ");
    L67:
        r103 = r103 + 1;
        r122 = r123;
        goto L63
    L68:
        r100.append("]");
        return;
    L70:
        if ((r101 instanceof Object[]) == false) goto L78;
        r100.append("[");
        Object[] r124 = (Object[]) r101;
        int r125 = r124.length;
        int r126 = 0;
    L72:
        if (r103 >= r125) goto L77;
        int r127 = r126 + 1;
        a(r100, r124[r103], r102);
        if (r126 >= (r124.length - 1)) goto L76;
        r100.append(", ");
    L76:
        r103 = r103 + 1;
        r126 = r127;
        goto L72
    L77:
        r100.append("]");
        return;
    L78:
        r100.append(Typography.quote);
        r100.append(c(r101.toString()));
        r100.append(Typography.quote);
        return;
    L21:
        if (r102 >= 3) goto L23;
        r100.append(b((Bundle) r101, r102 + 1));
        return;
    L23:
        r100.append(Typography.quote);
        r100.append(c("[TRUNCATED: max recursion depth reached]"));
        r100.append(Typography.quote);
    }
}
