package gq7;

import android.util.Log;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.watson.assist.utils.FileUtils;
import java.io.BufferedReader;

/* JADX INFO: loaded from: classes22.dex */
public final class d extends c {
    public d(long r100) {
        super("/proc/self/task/" + r100 + "/stat");
    }

    @Override // gq7.c
    public final b a(int r210) {
        eq7.f r100 = null;
        if (this.f482272b != null) goto L6;
        boolean r101 = hq7.a.f486512a;
        return null;
    L6:
        if (r210 == 0) goto L8;
        BufferedReader r102 = null;
    L77:
        if ((r210 & 2) <= 0) goto L36;
        eq7.f r110 = new eq7.f();     // Catch: Exception -> L34 Throwable -> L67
        if ((r210 & 4) <= 0) goto L25;
        String[] r103 = FileUtils.parseTidFile(this.f482272b);     // Catch: Throwable -> L31 Exception -> L32
        if (r103 != null) goto L23;
    L30:
        r100 = r110;
    L57:
        if (r102 != null) goto L72;
    L73:
        this.f482271a = r100;
        return r100;
    L72:
        FileUtils.a(r102);
        goto L73
    L23:
        if (r103.length != 3) goto L30;
        r110.f473524b = Integer.parseInt(r103[0]);     // Catch: Throwable -> L31 Exception -> L32
        r110.f473523a = r103[1];     // Catch: Throwable -> L31 Exception -> L32
        r110.f473529g = Long.parseLong(r103[2]) * 10;     // Catch: Throwable -> L31 Exception -> L32
        goto L30
    L25:
        String[] r111 = FileUtils.parseTidFileWithExtra(this.f482272b);     // Catch: Throwable -> L31 Exception -> L32
        if (r111 == null) goto L30;
        if (r111.length != 12) goto L30;
        r110.f473524b = Integer.parseInt(r111[0]);     // Catch: Throwable -> L31 Exception -> L32
        r110.f473523a = r111[1];     // Catch: Throwable -> L31 Exception -> L32
        r110.f473525c = Long.parseLong(r111[2]);     // Catch: Throwable -> L31 Exception -> L32
        r110.f473526d = Long.parseLong(r111[3]);     // Catch: Throwable -> L31 Exception -> L32
        r110.f473527e = Long.parseLong(r111[4]);     // Catch: Throwable -> L31 Exception -> L32
        r110.f473528f = Long.parseLong(r111[5]);     // Catch: Throwable -> L31 Exception -> L32
        r110.f473529g = Long.parseLong(r111[6]) * 10;     // Catch: Throwable -> L31 Exception -> L32
        r110.f473530h = Integer.parseInt(r111[7]);     // Catch: Throwable -> L31 Exception -> L32
        r110.f473531i = Integer.parseInt(r111[8]);     // Catch: Throwable -> L31 Exception -> L32
        Long.parseLong(r111[9]);     // Catch: Throwable -> L31 Exception -> L32
        Integer.parseInt(r111[10]);     // Catch: Throwable -> L31 Exception -> L32
        Integer.parseInt(r111[11]);     // Catch: Throwable -> L31 Exception -> L32
    L32:
        e = e;
    L68:
        Log.getStackTraceString(e);     // Catch: Throwable -> L31
        boolean r104 = hq7.a.f486512a;     // Catch: Throwable -> L31
        if (r102 != null) goto L65;
    L66:
        r100 = null;
    L65:
        FileUtils.a(r102);
        goto L66
    L36:
        if (r210 == 0) goto L42;
        if ((r210 & 1) > 0) goto L42;
        r100 = null;
    L42:
        if ((r210 & 1) <= 0) goto L44;
        String r105 = FileUtils.parseFile(this.f482272b);     // Catch: Exception -> L34 Throwable -> L67
    L45:
        if (r105 != null) goto L47;
    L64:
        if (r102 == null) goto L66;
    L47:
        if (r105.isEmpty() == true) goto L64;
        String r106 = r105.trim();     // Catch: Exception -> L34 Throwable -> L67
        Character r107 = c.f482274d;     // Catch: Exception -> L34 Throwable -> L67
        String r108 = r106.substring(0, r106.indexOf(r107.charValue())).trim();     // Catch: Exception -> L34 Throwable -> L67
        String r109 = r106.substring(r106.indexOf(r107.charValue()) + 1, r106.length()).trim();     // Catch: Exception -> L34 Throwable -> L67
        String[] r112 = r108.split("\\(");     // Catch: Exception -> L34 Throwable -> L67
        String[] r113 = r109.split(" ");     // Catch: Exception -> L34 Throwable -> L67
        if (r112.length > 1) goto L52;
    L62:
        if (r102 == null) goto L66;
    L52:
        if (r113.length <= 38) goto L62;
        eq7.f r114 = new eq7.f();     // Catch: Exception -> L34 Throwable -> L67
        r114.f473524b = Integer.parseInt(r112[0].trim());     // Catch: Throwable -> L59 Exception -> L60
        r114.f473523a = r112[1].trim();     // Catch: Throwable -> L59 Exception -> L60
        r114.f473529g = (Long.parseLong(r113[11]) + Long.parseLong(r113[12])) * 10;     // Catch: Throwable -> L59 Exception -> L60
        r113[0].getClass();     // Catch: Throwable -> L59 Exception -> L60
        r114.f473525c = Long.parseLong(r113[7].trim());     // Catch: Throwable -> L59 Exception -> L60
        r114.f473526d = Long.parseLong(r113[8].trim());     // Catch: Throwable -> L59 Exception -> L60
        r114.f473527e = Long.parseLong(r113[9].trim());     // Catch: Throwable -> L59 Exception -> L60
        r114.f473528f = Long.parseLong(r113[10].trim());     // Catch: Throwable -> L59 Exception -> L60
        r114.f473530h = Integer.parseInt(r113[15].trim());     // Catch: Throwable -> L59 Exception -> L60
        r114.f473531i = Integer.parseInt(r113[16].trim());     // Catch: Throwable -> L59 Exception -> L60
        Long.parseLong(r113[19].trim());     // Catch: Throwable -> L59 Exception -> L60
        Integer.parseInt(r113[36].trim());     // Catch: Throwable -> L59 Exception -> L60
        Integer.parseInt(r113[38].trim());     // Catch: Throwable -> L59 Exception -> L60
        r100 = r114;
        goto L57
    L60:
        e = e;
        r110 = r114;
    L59:
        r100 = r114;
    L71:
        if (r102 == null) goto L73;
    L44:
        r105 = r102.readLine();     // Catch: Exception -> L34 Throwable -> L67
    L31:
        r100 = r110;
    L34:
        e = e;
        r110 = null;
    L67:
        r100 = null;
        goto L71
    L8:
        if (this.f482273c != null) goto L10;
        this.f482273c = new PolarisFileWrapper(this.f482272b);
    L10:
        BufferedReader r115 = FileUtils.b(this.f482273c);
        if (r115 == null) goto L73;
        r102 = r115;
        goto L77
    }
}
