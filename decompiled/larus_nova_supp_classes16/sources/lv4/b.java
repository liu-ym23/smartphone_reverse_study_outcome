package lv4;

import ay4.d;
import com.ss.android.lark.vfs.VFSFile;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    public static void a(VFSFile r8, Map r9, int r10) {
        File[] r11 = r8.listFiles();
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.length <= 0) goto L26;
        int r0 = r11.length;
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L27;
        File r3 = r11[r2];
        if (r3.getName() != null) goto L11;
    L20:
        tt5.a.d("ResUtils", "item name or absolutePath empty");
    L21:
        r2 = r2 + 1;
        goto L7
    L11:
        if (r3.getAbsolutePath() == null) goto L20;
        if (d.a().i(r3.getAbsolutePath()).isFile() == false) goto L19;
        String r4 = r3.getAbsolutePath();
        Intrinsics.checkNotNull(r4);
        if (StringsKt.endsWith$default(r4, "mobile_subpage.html", false, 2, null) == false) goto L18;
        ((HashMap) r9).put("mobile_subpage.html", r4);
        goto L19
    L18:
        HashMap r6 = (HashMap) r9;
        r6.put(r4.substring(r10), r4);
    L19:
        a(r3, r9, r10);
        goto L21
    L27:
        return;
    }
}
