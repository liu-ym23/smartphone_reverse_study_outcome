package sh4;

import com.bytedance.crash.i;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.util.h;
import com.bytedance.crash.util.p;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.BufferedReader;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends oh4.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static a f541963h;

    /* JADX INFO: renamed from: sh4.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes3.dex */
    public static class C7610a extends oh4.b.AbstractC7056b {
        public static String m(String r100) {
            int r101 = CastIntegerProtector.parseInt(r100);     // Catch: Throwable -> L23
            if (r101 > 100) goto L7;
            return "[0, 100]";
        L7:
            if (r101 > 200) goto L10;
            return "(100, 200]";
        L10:
            if (r101 > 500) goto L13;
            return "(200, 500]";
        L13:
            if (r101 > 1000) goto L16;
            return "(500, 1000]";
        L16:
            if (r101 > 5000) goto L19;
            return "(1000, 5000]";
        L19:
            if (r101 > 10000) goto L21;
            return "(5000, 10000]";
        L21:
            int r102 = r101 / 10000;
            return "(" + r102 + "0000, " + (r102 + 1) + "0000]";
        L23:
            return "0";
        }

        public C7610a(com.bytedance.crash.monitor.a r100, PolarisFileWrapper r101) {
            super(r100, r101);
        }

        @Override // oh4.b.AbstractC7056b
        public final void h(Map<String, String> r100, oh4.b.c r101) {
            super.h(r100, r101);
            if (com.bytedance.crash.general.a.f() == false) goto L5;
            String r102 = "true";
        L6:
            ((HashMap) r100).put("is_root", r102);
            return;
        L5:
            r102 = "false";
            goto L6
        }

        @Override // oh4.b.AbstractC7056b
        public final boolean i(File r210, oh4.b.c r211) {
            String r100 = "Signal 6(SIGABRT), Code -12(SI_REF_LEAK)\n";
            PolarisFileWrapper r101 = new PolarisFileWrapper(r210, "ref_table.txt");
            if (r101.exists() == true) goto L75;
            return false;
        L75:
        L70:
            return false;
        L6:
            if (h.f(r101.getAbsolutePath()) != null) goto L9;
            p.e("refContent is null");     // Catch: Throwable -> L70
            return false;
        L9:
            BufferedReader r102 = new BufferedReader(new PolarisFileReaderWrapper(r101));     // Catch: Throwable -> L70
            StringBuilder r103 = new StringBuilder();     // Catch: Throwable -> L70
            StringBuilder r104 = new StringBuilder();     // Catch: Throwable -> L70
            String r105 = "";
            String r106 = null;
            String r110 = "";
            String r111 = r110;
            String r112 = r111;
            String r113 = r112;
            String r114 = r113;
            char r115 = 0;
            boolean r116 = false;
        L11:
            String r107 = r102.readLine();     // Catch: Throwable -> L70
            r102 = r102;
            if (r107 == null) goto L66;
            if (r105.equals(r107) == true) goto L15;
            String r117 = r105;
            char r108 = r107.charAt(0);     // Catch: Throwable -> L70
            String r109 = r107.trim();     // Catch: Throwable -> L70
            if (r109.length() == 0) goto L18;
            String r212 = r100;
            if (r108 >= 'a') goto L22;
        L30:
            String r213 = r110;
            if (r115 != 1) goto L44;
            if (r108 < '0') goto L40;
            if (r108 > '9') goto L40;
            String[] r118 = r107.split("\\s+");     // Catch: Throwable -> L70
            if (r118.length != 2) goto L37;
            r110 = r118[0];     // Catch: Throwable -> L70
            r113 = r118[1];     // Catch: Throwable -> L70
        L42:
            r115 = 2;
        L65:
            r105 = r117;
            r100 = r212;
            goto L11
        L37:
            p.a("something is wrong with ref info title");     // Catch: Throwable -> L70
        L67:
            String r119 = r103.toString();     // Catch: Throwable -> L70
            r211.f523285a = r104.toString();     // Catch: Throwable -> L70
            StringBuilder r120 = new StringBuilder();     // Catch: Throwable -> L70
            String r121 = r212;
            r120.append(r121);     // Catch: Throwable -> L70
            r120.append(r119);     // Catch: Throwable -> L70
            r211.f523286b = r120.toString();     // Catch: Throwable -> L70
            l(r210, "tombstone.txt", ("pid: 1234, tid: " + r211.f523290f + ", ThreadName: " + r211.f523287c + "  >>> " + i.getContext().getPackageName() + " <<<\n") + r121 + ("abort message: " + r106 + " ref leak type: " + r111 + "(count: " + r112 + "), backtrace type: " + r113 + "(count: " + r213 + ")\n") + "backtrace: \n" + r119);     // Catch: Throwable -> L70
            l(r210, "javastack.txt", r211.f523285a);     // Catch: Throwable -> L70
            ((HashMap) r211.f523292h).put("has_ref_leak_log", "true");     // Catch: Throwable -> L70
            ((HashMap) r211.f523292h).put("ref_leak_type", r106);     // Catch: Throwable -> L70
            ((HashMap) r211.f523292h).put(r106 + "_ref_range", m(r114));     // Catch: Throwable -> L70
            ((HashMap) r211.f523292h).put(r106 + "_ref_top_type", r111);     // Catch: Throwable -> L70
            return true;
        L40:
            if (r109.startsWith("Summary") == false) goto L64;
            r110 = r213;
        L64:
            r110 = r213;
            goto L65
        L44:
            if (r115 != 2) goto L64;
            if (r109.startsWith("#") == false) goto L50;
            r103.append(r107);     // Catch: Throwable -> L70
            r103.append("\n");     // Catch: Throwable -> L70
            goto L64
        L50:
            if (r109.startsWith(INotificationHitPoint.NoticeType.AT) == false) goto L54;
            r104.append(r107);     // Catch: Throwable -> L70
            r104.append("\n");     // Catch: Throwable -> L70
            if (r116 == true) goto L64;
            r110 = r213;
            r116 = true;
            goto L65
        L54:
            if (r116 == true) goto L67;
            char r122 = r109.charAt(0);     // Catch: Throwable -> L70
            if (r122 <= '0') goto L64;
            if (r122 > '9') goto L64;
            String[] r123 = r109.split("\\s+");     // Catch: Throwable -> L70
            if (r123.length < 3) goto L63;
            r112 = r123[0];     // Catch: Throwable -> L70
            r111 = r123[2];     // Catch: Throwable -> L70
        L63:
            r110 = r213;
            r115 = 0;
            goto L65
        L22:
            if (r108 > 'z') goto L30;
            if (r106 != null) goto L73;
            r106 = r107.split(" ")[0];     // Catch: Throwable -> L70
        L29:
            r115 = 1;
            goto L65
        L73:
            Matcher r124 = PatternProtector.compile("^.*:\\s+(\\S+),.*:\\s+(.*),.*:\\s+(\\S+).*$").matcher(r107);     // Catch: Throwable -> L72
            if (r124.find() == false) goto L29;
            r114 = r124.group(1);     // Catch: Throwable -> L72
            String r125 = r124.group(2);     // Catch: Throwable -> L72
            Objects.requireNonNull(r125);     // Catch: Throwable -> L72
            r211.f523290f = Long.decode(r125).longValue();     // Catch: Throwable -> L72
            r211.f523287c = r124.group(3);     // Catch: Throwable -> L72
        L18:
            r105 = r117;
            goto L11
        L15:
            r117 = r105;
            goto L18
        L66:
            r212 = r100;
            r213 = r110;
            goto L67
        }

        public static void l(File r100, String r101, String r102) {
            if (r102 != null) goto L4;
            return;
        L4:
            if ("".equals(r102) == true) goto L16;
            PolarisFileWrapper r103 = new PolarisFileWrapper(r100, r101);
            if (r103.exists() == true) goto L10;
            r103.createNewFile();     // Catch: Throwable -> L12
        L10:
            h.h(r103, r102, false);     // Catch: Throwable -> L12
            return;
        L17:
            return;
        }
    }

    @Override // oh4.b
    public final boolean b() {
        return NativeBridge.G();
    }

    public a() {
    }
}
