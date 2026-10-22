package d9a;

import com.alipay.sdk.m.u.i;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes32.dex */
public final class b {
    public static void a(File r100, HashMap<String, Object> r101, List<String> r102) {
        if (r100.getName().startsWith(".") == false) goto L5;
        return;
    L5:
        int r103 = 0;
        if (xu3.e.b(r102) == true) goto L13;
        Iterator r104 = ((ArrayList) r102).iterator();
    L9:
        if (r104.hasNext() == false) goto L13;
        String r105 = (String) r104.next();
        if (r100.getAbsolutePath().startsWith(r105) == false) goto L9;
        boolean r106 = true;
    L14:
        if (r106 == false) goto L20;
        StringBuilder r107 = new StringBuilder();
        int r108 = 0;
    L17:
        if (r108 >= r100.getName().length()) goto L19;
        r107.append("*");
        r108 = r108 + 1;
        goto L17
    L19:
        String r109 = r107.toString();
    L22:
        if (r100.isFile() == false) goto L25;
        r101.put(r109, Long.valueOf(r100.length()));
    L25:
        if (r100.isDirectory() == false) goto L29;
        HashMap r110 = new HashMap();
        r101.put(r109, r110);
        String[] r111 = r100.list();
        int r112 = r111.length;
    L27:
        if (r103 >= r112) goto L35;
        a(new PolarisFileWrapper(r100, r111[r103]), r110, r102);
        r103 = r103 + 1;
        goto L27
    L35:
        return;
    L29:
        return;
    L20:
        r109 = r100.getName();
    L13:
        r106 = false;
        goto L14
    }

    public static void b(PolarisFileWrapper r100, BufferedWriter r101, List r102) throws IOException {
        HashMap r103 = new HashMap();
        r101.write("{");
        r101.newLine();
        File[] r104 = r100.listFiles();
        int r105 = 0;
    L4:
        if (r105 >= r104.length) goto L12;
        r103.clear();
        a(r104[r105], r103, r102);
        if (r103.keySet().isEmpty() == true) goto L11;
        c(r103, 1, r101);
        if ((r105 + 1) >= r104.length) goto L11;
        r101.write(",");
    L11:
        r105 = r105 + 1;
        goto L4
    L12:
        r101.write(i.f25855d);
        r101.flush();
    }

    public static void c(HashMap<String, Object> r110, int r111, BufferedWriter r112) throws IOException {
        int r100 = r110.keySet().size();
        Iterator<String> r101 = r110.keySet().iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L25;
        String r103 = r101.next();
        Object r104 = r110.get(r103);
        r102 = r102 + 1;
        if ((r104 instanceof Long) == true) goto L7;
        int r105 = 0;
    L16:
        if (r105 >= r111) goto L18;
        r112.write("\t");
        r105 = r105 + 1;
        goto L16
    L18:
        r112.write(String.format("\"%s\": {", new Object[]{r103.replaceAll("\n", "")}));
        r112.newLine();
        int r106 = r111 + 1;
        c((HashMap) r104, r106, r112);
        int r107 = 0;
    L19:
        if (r107 >= r106) goto L21;
        r112.write("\t");
        r107 = r107 + 1;
        goto L19
    L21:
        r112.write(i.f25855d);
        if (r102 >= r100) goto L24;
        r112.write(",");
    L24:
        r112.newLine();
        goto L4
    L7:
        int r108 = 0;
    L9:
        if (r108 >= (r111 + 1)) goto L11;
        r112.write("\t");
        r108 = r108 + 1;
        goto L9
    L11:
        r112.write(String.format("\"%s\": %d", new Object[]{r103.replaceAll("\n", ""), Long.valueOf(((Long) r104).longValue())}));
        if (r102 >= r100) goto L14;
        r112.write(",");
    L14:
        r112.newLine();
        goto L4
    }
}
