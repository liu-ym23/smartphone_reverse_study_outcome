package com.bytedance.crash.dumper;

import android.text.TextUtils;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    public static class a extends d {
        @Override // com.bytedance.crash.dumper.b.d
        public final Pattern a() {
            return PatternProtector.compile("^  native: #\\d{1,3} pc [0-9a-f]{8,16} {2}(/(?:[^/]+/)+.*\\.so).*");
        }

        public a(PolarisFileWrapper r100) {
            super(r100);
        }

        @Override // com.bytedance.crash.dumper.b.d
        public final boolean b(String r100) {
            return r100.startsWith("  native: #");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.crash.dumper.b$b, reason: collision with other inner class name */
    public static class C2953b extends d {
        @Override // com.bytedance.crash.dumper.b.d
        public final Pattern a() {
            return PatternProtector.compile("^#\\d{1,3} pc [0-9a-f]{8,16} {2}(/(?:[^/]+/)+.*\\.so).*");
        }

        public C2953b(PolarisFileWrapper r100) {
            super(r100);
        }

        @Override // com.bytedance.crash.dumper.b.d
        public final boolean b(String r100) {
            return r100.startsWith("#");
        }
    }

    public static class c extends d {
        @Override // com.bytedance.crash.dumper.b.d
        public final Pattern a() {
            return PatternProtector.compile("^0x[0-9a-f]{1,16}:(/(?:[^/]+/)+[^.]+\\.so):.*");
        }

        public c(PolarisFileWrapper r100) {
            super(r100);
        }

        @Override // com.bytedance.crash.dumper.b.d
        public final boolean b(String r100) {
            return r100.startsWith("0x");
        }
    }

    public static abstract class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File f203149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Pattern f203150b;

        public abstract Pattern a();

        public abstract boolean b(String r100);

        public d(PolarisFileWrapper r100) {
            this.f203149a = r100;
            this.f203150b = a();
        }

        public final void c(List<String> r100) {
            if (this.f203149a.exists() == true) goto L22;
            return;
        L22:
            BufferedReader r101 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper(this.f203149a)));     // Catch: Throwable -> L18
        L24:
            String r102 = r101.readLine();     // Catch: Throwable -> L21
            if (r102 == null) goto L19;
            if (b(r102) == false) goto L24;
            Matcher r103 = this.f203150b.matcher(r102);     // Catch: Throwable -> L21
            if (r103.find() == false) goto L24;
            if (r103.groupCount() != 1) goto L24;
            String r104 = r103.group(1);     // Catch: Throwable -> L21
            ArrayList r105 = (ArrayList) r100;     // Catch: Throwable -> L21
            if (r105.contains(r104) == true) goto L24;
            r105.add(r104);     // Catch: Throwable -> L21
        L19:
            com.bytedance.crash.util.g.a(r101);
            return;
        L18:
            r101 = null;
            goto L19
        }
    }

    public static String a(String r100) {
        StringBuilder r101 = new StringBuilder();
        if (r100.length() >= 16) goto L6;
        r101.append(r100);     // Catch: Throwable -> L11
    L12:
        goto L10
    L6:
        r101.append(r100.charAt(6));     // Catch: Throwable -> L11
        r101.append(r100.charAt(7));     // Catch: Throwable -> L11
        r101.append(r100.charAt(4));     // Catch: Throwable -> L11
        r101.append(r100.charAt(5));     // Catch: Throwable -> L11
        r101.append(r100.charAt(2));     // Catch: Throwable -> L11
        r101.append(r100.charAt(3));     // Catch: Throwable -> L11
        r101.append(r100.charAt(0));     // Catch: Throwable -> L11
        r101.append(r100.charAt(1));     // Catch: Throwable -> L11
        r101.append(r100.charAt(10));     // Catch: Throwable -> L11
        r101.append(r100.charAt(11));     // Catch: Throwable -> L11
        r101.append(r100.charAt(8));     // Catch: Throwable -> L11
        r101.append(r100.charAt(9));     // Catch: Throwable -> L11
        r101.append(r100.charAt(14));     // Catch: Throwable -> L11
        r101.append(r100.charAt(15));     // Catch: Throwable -> L11
        r101.append(r100.charAt(12));     // Catch: Throwable -> L11
        r101.append(r100.charAt(13));     // Catch: Throwable -> L11
        if (r100.length() < 32) goto L12;
        r101.append(r100, 16, 32);     // Catch: Throwable -> L11
        r101.append('0');     // Catch: Throwable -> L11
    L10:
        return r101.toString().toUpperCase();
    }

    public static boolean b(String r100) {
        if (r100.startsWith("/system/lib") == false) goto L5;
    L10:
        return true;
    L5:
        if (r100.startsWith("/vendor/lib") == true) goto L10;
        if (r100.startsWith("/apex/") == true) goto L10;
        return false;
    }

    public static void d(JSONObject r100, Map<String, String> r101) {
        JSONArray r102 = new JSONArray();
        Iterator r103 = ((HashMap) r101).entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L19;
        Map.Entry r104 = (Map.Entry) r103.next();
        String r105 = (String) r104.getKey();     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r105) == true) goto L13;
        int r106 = r105.lastIndexOf(47);     // Catch: Throwable -> L18
        if (r106 == (-1)) goto L13;
        String r107 = r105.substring(r106 + 1);     // Catch: Throwable -> L18
        int r108 = r107.indexOf(".apk!");     // Catch: Throwable -> L18
        if (r108 == (-1)) goto L15;
        r107 = r107.substring(r108 + 5);     // Catch: Throwable -> L18
    L15:
        if (TextUtils.isEmpty(r107) == true) goto L4;
        JSONObject r109 = new JSONObject();     // Catch: Throwable -> L18
        com.bytedance.crash.util.j.h(r109, "lib_name", r107);     // Catch: Throwable -> L18
        com.bytedance.crash.util.j.h(r109, "lib_uuid", a((String) r104.getValue()));     // Catch: Throwable -> L18
        r102.put(r109);     // Catch: Throwable -> L18
    L13:
        r107 = null;
        goto L15
    L19:
        com.bytedance.crash.util.j.h(r100, "crash_lib_uuid", r102);
    }

    public static void c(JSONObject r100, File r101, boolean r102) {
        HashMap r103 = new HashMap();
        ArrayList r104 = new ArrayList();
        if (r102 == false) goto L33;
        PolarisFileWrapper r105 = new PolarisFileWrapper(r101, "tombstone.txt");
        if (r105.exists() == false) goto L32;
        Pattern r106 = PatternProtector.compile("^ {4}(/(?:[^/]+/)+[^.]+\\.so) \\(BuildId: ([0-9a-f]+)\\).*");
        BufferedReader r107 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper(r105)));     // Catch: Throwable -> L30
    L48:
        String r108 = r107.readLine();     // Catch: Throwable -> L45
        if (r108 == null) goto L31;
        if (r108.startsWith("build id:") == false) goto L48;
    L13:
        String r109 = r107.readLine();     // Catch: Throwable -> L45
        if (r109 == null) goto L48;
        if (r109.startsWith("    /") == false) goto L48;
        Matcher r110 = r106.matcher(r109);     // Catch: Throwable -> L45
        if (r110.find() == false) goto L13;
        if (r110.groupCount() != 2) goto L13;
        String r111 = r110.group(1);     // Catch: Throwable -> L45
        String r112 = r110.group(2);     // Catch: Throwable -> L45
        if (r111 == null) goto L13;
        if (b(r111) == true) goto L13;
        if (r103.containsKey(r111) == true) goto L13;
        r103.put(r111, r112);     // Catch: Throwable -> L45
    L31:
        com.bytedance.crash.util.g.a(r107);
    L30:
        r107 = null;
    L32:
        new C2953b(new PolarisFileWrapper(r101, "nstack.txt")).c(r104);
    L33:
        new c(new PolarisFileWrapper(r101, "rountines.txt")).c(r104);
        Iterator r113 = r104.iterator();
    L35:
        if (r113.hasNext() == false) goto L43;
        String r114 = (String) r113.next();
        if (b(r114) == true) goto L35;
        if (r103.containsKey(r114) == true) goto L35;
        String r115 = NativeBridge.a(r114);
        if (r115 == null) goto L35;
        r103.put(r114, r115);
        goto L35
    L43:
        d(r100, r103);
    }
}
