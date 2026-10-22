package f9a;

import com.bytedance.apm.d;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public final class a {
    public static void a(String r100, String r101, int r102, Map<String, String> r103) {
        if (d.j() == false) goto L5;
        ps3.b.a(new String[]{"report: commandId=" + r100, ", message=" + r101, ", code=" + r102, ", specificParams=" + r103});
    L5:
        if (r103 == null) goto L7;
        HashMap r104 = new HashMap(r103);
    L8:
        i9a.b r105 = new i9a.b(r100, r104);
        r105.f488823d = r102;
        r105.f488824e = r101;
        g9a.a.c(r105);
        return;
    L7:
        r104 = null;
        goto L8
    }

    public static boolean b(String r110, File r111, String r112, String r113) {
        if (d.j() == false) goto L6;
        ps3.b.a(new String[]{"postFile: commandId=" + r110, "postFile=" + r111.getAbsolutePath(), ", uploadMessage=" + r113, ", fileType=" + r112});
    L6:
        return j9a.a.a(j9a.a.f497829a, r111, 1, r112, r110, r113, System.currentTimeMillis(), null);
    }
}
