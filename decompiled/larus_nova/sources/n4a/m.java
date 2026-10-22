package n4a;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.loc.al;
import com.miui.easygo.constant.EasyGoConstant;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes32.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile al f517508a;

    public m() {
    }

    public static al a() {
        if (f517508a != null) goto L28;
        monitor-enter(m.class);
    L24:
        th = move-exception;
        throw th;
    L7:
        if (f517508a == null) goto L31;
    L22:
        monitor-exit(m.class);     // Catch: Throwable -> L24
        goto L28
    L31:
        al r100 = b(Build.MANUFACTURER);     // Catch: Exception -> L20 Throwable -> L24
        if ("".equals(r100.a()) == false) goto L18;
        Iterator r101 = Arrays.asList(new String[]{al.f379903a.a(), al.f379904b.a(), al.f379905c.a(), al.f379906d.a(), al.f379907e.a(), al.f379908f.a(), al.f379909g.a(), al.f379911i.a(), al.f379912j.a(), al.f379913k.a(), al.f379914l.a()}).iterator();     // Catch: Exception -> L20 Throwable -> L24
    L13:
        if (r101.hasNext() == false) goto L17;
        al r102 = b((String) r101.next());     // Catch: Exception -> L20 Throwable -> L24
        if ("".equals(r102.a()) == true) goto L13;
        r100 = r102;
        goto L18
    L17:
        r100 = al.f379915m;     // Catch: Exception -> L20 Throwable -> L24
    L18:
        f517508a = r100;     // Catch: Exception -> L20 Throwable -> L24
    L20:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L24
    L28:
        return f517508a;
    }

    public static void c(al r100, String r101) {
        Matcher r102 = PatternProtector.compile("([\\d.]+)[^\\d]*").matcher(r101);
        if (r102.find() == true) goto L10;
        return;
    L10:
        String r103 = r102.group(1);     // Catch: Exception -> L7
        r100.a(r103);     // Catch: Exception -> L7
        r100.a(CastIntegerProtector.parseInt(r103.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN)[0]));     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public static al b(String r100) {
        if (r100 == null) goto L110;
        if (r100.length() <= 0) goto L110;
        al r101 = al.f379903a;
        boolean r102 = true;
        if (r100.equalsIgnoreCase(r101.a()) == true) goto L9;
        al r103 = al.f379904b;
        if (r100.equalsIgnoreCase(r103.a()) == false) goto L25;
        String r104 = d("ro.flyme.published");
        String r105 = d("ro.meizu.setupwizard.flyme");
        if (TextUtils.isEmpty(r104) == true) goto L19;
    L22:
        String r106 = d("ro.build.display.id");
        c(r103, r106);
        r103.b(r106);
    L23:
        if (r102 == false) goto L108;
        return r103;
    L108:
        return al.f379915m;
    L19:
        if (TextUtils.isEmpty(r105) == false) goto L22;
        r102 = false;
        goto L23
    L25:
        al r107 = al.f379905c;
        if (r100.equalsIgnoreCase(r107.a()) == false) goto L33;
        String r108 = d(com.alipay.sdk.m.c.a.f25238a);
        if (TextUtils.isEmpty(r108) == true) goto L30;
        c(r107, r108);
        r107.b(r108);
    L31:
        if (r102 == false) goto L108;
        return r107;
    L30:
        r102 = false;
        goto L31
    L33:
        al r109 = al.f379906d;
        if (r100.equalsIgnoreCase(r109.a()) == false) goto L41;
        String r110 = d("ro.build.version.opporom");
        if (TextUtils.isEmpty(r110) == true) goto L38;
        c(r109, r110);
        r109.b(r110);
    L39:
        if (r102 == false) goto L108;
        return r109;
    L38:
        r102 = false;
        goto L39
    L41:
        al r111 = al.f379907e;
        if (r100.equalsIgnoreCase(r111.a()) == false) goto L49;
        String r112 = d("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(r112) == true) goto L46;
        c(r111, r112);
        r111.b(r112);
    L47:
        if (r102 == false) goto L108;
        return r111;
    L46:
        r102 = false;
        goto L47
    L49:
        al r113 = al.f379908f;
        if (r100.equalsIgnoreCase(r113.a()) == false) goto L57;
        String r114 = d("ro.smartisan.version");
        if (TextUtils.isEmpty(r114) == true) goto L54;
        c(r113, r114);
        r113.b(r114);
    L55:
        if (r102 == false) goto L108;
        return r113;
    L54:
        r102 = false;
        goto L55
    L57:
        al r115 = al.f379909g;
        if (r100.equalsIgnoreCase(r115.a()) == false) goto L67;
        String r116 = d("ro.build.display.id");
        if (TextUtils.isEmpty(r116) == false) goto L62;
    L64:
        r102 = false;
    L65:
        if (r102 == false) goto L108;
        return r115;
    L62:
        if (r116.matches("amigo([\\d.]+)[a-zA-Z]*") == false) goto L64;
        c(r115, r116);
        r115.b(r116);
        goto L65
    L67:
        al r117 = al.f379910h;
        if (r100.equalsIgnoreCase(r117.a()) == false) goto L75;
        String r118 = d("ro.letv.release.version");
        if (TextUtils.isEmpty(r118) == true) goto L72;
        c(r117, r118);
        r117.b(r118);
    L73:
        if (r102 == false) goto L108;
        return r117;
    L72:
        r102 = false;
        goto L73
    L75:
        al r119 = al.f379911i;
        if (r100.equalsIgnoreCase(r119.a()) == false) goto L83;
        String r120 = d("ro.build.sense.version");
        if (TextUtils.isEmpty(r120) == true) goto L80;
        c(r119, r120);
        r119.b(r120);
    L81:
        if (r102 == false) goto L108;
        return r119;
    L80:
        r102 = false;
        goto L81
    L83:
        al r121 = al.f379912j;
        if (r100.equalsIgnoreCase(r121.a()) == false) goto L91;
        String r122 = d("sys.lge.lgmdm_version");
        if (TextUtils.isEmpty(r122) == true) goto L88;
        c(r121, r122);
        r121.b(r122);
    L89:
        if (r102 == false) goto L108;
        return r121;
    L88:
        r102 = false;
        goto L89
    L91:
        al r123 = al.f379913k;
        if (r100.equalsIgnoreCase(r123.a()) == true) goto L94;
        al r124 = al.f379914l;
        if (r100.equalsIgnoreCase(r124.a()) == false) goto L108;
        String r125 = d("ro.build.nubia.rom.code");
        if (TextUtils.isEmpty(r125) == true) goto L104;
        c(r124, r125);
        r124.b(r125);
    L105:
        if (r102 == false) goto L108;
        return r124;
    L104:
        r102 = false;
        goto L105
    L94:
        if ("android-google".equals(d("ro.com.google.clientidbase")) == false) goto L96;
        String r126 = d("ro.build.version.release");
        r123.a(Build.VERSION.SDK_INT);
        r123.b(r126);
    L97:
        if (r102 == false) goto L108;
        return r123;
    L96:
        r102 = false;
        goto L97
    L9:
        if (TextUtils.isEmpty(d("ro.miui.ui.version.name")) == true) goto L11;
        String r127 = d("ro.build.version.incremental");
        c(r101, r127);
        r101.b(r127);
    L12:
        if (r102 == false) goto L108;
        return r101;
    L11:
        r102 = false;
    L110:
        return al.f379915m;
    }

    public static String d(String r100) {
        BufferedReader r101 = null;
        if (TextUtils.isEmpty(null) == true) goto L31;
        throw null;
    L31:
        BufferedReader r102 = new BufferedReader(new InputStreamReader(e(Runtime.getRuntime(), "getprop ".concat(r100)).getInputStream()), 1024);     // Catch: Throwable -> L11 IOException -> L15
        String r103 = r102.readLine();     // Catch: Throwable -> L8 IOException -> L10
        r102.close();     // Catch: Throwable -> L8 IOException -> L10
        r102.close();     // Catch: IOException -> L20
    L33:
        return r103;
    L8:
        th = th;
        r101 = r102;
    L12:
        if (r101 != null) goto L27;
    L14:
        throw th;
    L27:
        r101.close();     // Catch: IOException -> L22
    L16:
        if (r102 == null) goto L34;
        r102.close();     // Catch: IOException -> L21
        return null;
    L35:
        return null;
    L34:
        return null;
    L15:
        r102 = null;
    L11:
        th = th;
        goto L12
    }

    public static Process e(Runtime r110, String r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(102900, "java/lang/Runtime", "exec", r110, r101, "java.lang.Process", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, null, r112, false);
        return (Process) r113.f474983b;
    L6:
        Process r114 = r110.exec(r111);
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, r114, r112, true);
        return r114;
    }
}
