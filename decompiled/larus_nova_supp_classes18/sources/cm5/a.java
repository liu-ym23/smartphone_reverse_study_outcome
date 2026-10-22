package cm5;

import ay4.c;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static VFSFile b() {
        Biz r0 = Biz.DOCS;
        int r1 = c.a;
        VFSFile r2 = c.a.b(r0, "Space", false, 12).toFile();
        if (r2.exists() == true) goto L5;
        r2.mkdirs();
    L5:
        return r2;
    }

    public static VFSPath a(String r6) {
        VFSPath r0 = b().getVfsPath();
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        String r1 = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String r2 = r6.trim() + r1 + ".png";
        VFSFile r3 = b().getVfsPath().subPath("temp" + r2).toFile();     // Catch: Exception -> L8
        r3.createNewFile();     // Catch: Exception -> L8
        r3.delete();     // Catch: Exception -> L8
        boolean r4 = true;
    L10:
        if (r4 == true) goto L13;
        r2 = r1 + ".png";
    L13:
        return r0.subPath(r2);
    L8:
        e = move-exception;
        tt5.a.f("isfileNameVaild", e, false);
        r4 = false;
        goto L10
    }
}
