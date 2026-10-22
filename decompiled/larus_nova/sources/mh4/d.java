package mh4;

import android.os.Process;
import com.bytedance.crash.i;
import com.bytedance.crash.util.JSONWriter;
import com.bytedance.crash.util.g;
import com.bytedance.crash.util.j;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.lark.inv.export.router.InvRouter;
import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f513952a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f513953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static PolarisFileWrapper f513954c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static PolarisFileWrapper f513955d;

    static {
        f513952a = PatternProtector.compile("^(\\d+)-(\\d+)\\.json");
    }

    public static File d() {
        if (f513954c != null) goto L8;
        PolarisFileWrapper r100 = i.d();
        if (r100 == null) goto L8;
        f513954c = g.b(r100, CloudControlInf.PLUGIN);
    L8:
        return f513954c;
    }

    public static File e() {
        if (f513955d != null) goto L8;
        long r100 = i.b();
        int r101 = Process.myPid();
        File r102 = d();
        if (r102 == null) goto L8;
        f513955d = new PolarisFileWrapper(r102, r100 + "-" + r101 + InvRouter.FLOW_SUFFIX);
    L8:
        return f513955d;
    }

    private static void update() {
        if (jh4.d.f499080b == true) goto L5;
        return;
    L5:
        jh4.d.c r100 = jh4.d.f499079a;
        if (r100 != null) goto L21;
    L9:
        JSONArray r101 = null;
    L10:
        if (r101 != null) goto L12;
        return;
    L12:
        if (r101.length() == 0) goto L28;
        BufferedWriter r102 = new BufferedWriter(new PolarisFileWriterWrapper(e(), false));     // Catch: Throwable -> L19
        JSONObject r103 = new JSONObject();
        r103.put("plugin_info", r101);     // Catch: Throwable -> L18
        r103.put("mira_init", true);     // Catch: Throwable -> L18
        new JSONWriter(r102).c(r103);     // Catch: Throwable -> L18
        r102.flush();     // Catch: Throwable -> L18
    L16:
        g.a(r102);
        return;
    L29:
        return;
    L28:
        return;
    L21:
        r101 = ((jh4.a) r100).a();     // Catch: Throwable -> L20
        goto L10
    }

    public static void a() {
        long r100 = System.currentTimeMillis();
        long r101 = f513953b;
        if (r101 != 0) goto L5;
    L6:
        f513953b = r100;
        wh4.b.postDelayed(new c(), 1000);
        return;
    L5:
        if ((r100 - r101) > 1000) goto L6;
    }

    public static void b() {
        File r100 = d();
        if (r100 == null) goto L87;
        File[] r101 = r100.listFiles();
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.length == 0) goto L88;
        long r102 = System.currentTimeMillis();
        ArrayList r103 = new ArrayList();
        File[] r104 = new PolarisFileWrapper("/proc").listFiles();
        int r105 = 0;
        if (r104 != null) goto L13;
    L30:
        ArrayList r106 = new ArrayList();
        com.bytedance.crash.crash.c r107 = com.bytedance.crash.crash.c.f203123d;
        if (r107 == null) goto L33;
        PolarisFileWrapper r108 = r107.f203124a;
    L35:
        if (r108 == null) goto L43;
        File[] r109 = r108.listFiles();
        if (r109 == null) goto L43;
        if (r109.length == 0) goto L43;
        int r110 = r109.length;
        int r111 = 0;
    L41:
        if (r111 >= r110) goto L43;
        r106.add(r109[r111].getName() + InvRouter.FLOW_SUFFIX);
        r111 = r111 + 1;
    L43:
        File[] r112 = new PolarisFileWrapper(i.d(), "anr").listFiles();
        if (r112 != null) goto L46;
    L50:
        int r113 = r101.length;
    L51:
        if (r105 >= r113) goto L89;
        File r114 = r101[r105];
        String r115 = r114.getName();
        if (r106.contains(r115) == true) goto L71;
        Matcher r116 = f513952a.matcher(r115);
        if (r116.find() == true) goto L58;
    L70:
        g.e(r114);
        goto L71
    L58:
        if (r116.groupCount() != 2) goto L70;
        String r117 = r116.group(1);
        if (r117 == null) goto L62;
        long r118 = CastLongProtector.parseLong(r117);
    L63:
        String r119 = r116.group(2);
        if (r118 == i.b()) goto L71;
        if (r118 > r102) goto L71;
        if (r103.contains(r119) == false) goto L70;
    L62:
        r118 = 0;
    L71:
        r105 = r105 + 1;
        goto L51
    L89:
        return;
    L46:
        if (r112.length == 0) goto L50;
        int r120 = r112.length;
        int r121 = 0;
    L48:
        if (r121 >= r120) goto L50;
        r106.add(r112[r121].getName() + InvRouter.FLOW_SUFFIX);
        r121 = r121 + 1;
        goto L48
    L33:
        r108 = null;
        goto L35
    L13:
        if (r104.length == 0) goto L30;
        int r122 = r104.length;
        int r123 = 0;
    L15:
        if (r123 >= r122) goto L30;
        File r124 = r104[r123];
        String r125 = r124.getName();
        int r126 = 0;
    L18:
        if (r126 >= r125.length()) goto L26;
        char r127 = r125.charAt(r126);
        if (r127 < '0') goto L25;
        if (r127 > '9') goto L25;
        r126 = r126 + 1;
    L25:
        boolean r128 = false;
    L27:
        if (r128 == false) goto L29;
        r103.add(r124.getName());
    L29:
        r123 = r123 + 1;
        goto L15
    L26:
        r128 = true;
        goto L27
    L88:
        return;
    }

    public static /* synthetic */ void c() {
        update();
    }

    public static void f(JSONObject r100, File r101) {
        String r102 = r101.getName();
        File r103 = d();
        if (r103 == null) goto L5;
        PolarisFileWrapper r104 = new PolarisFileWrapper(r103, r102 + InvRouter.FLOW_SUFFIX);
    L6:
        if (r104 != null) goto L8;
    L15:
        j.h(r100, "mira_init", Boolean.FALSE);
        return;
    L8:
        if (r104.exists() == false) goto L15;
        String r105 = g.f(r104);
        if (r105 == null) goto L15;
        j.d(r100, new JSONObject(r105));     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        ch4.c.b("pushTo", th);
        goto L15
    L5:
        r104 = null;
        goto L6
    }
}
