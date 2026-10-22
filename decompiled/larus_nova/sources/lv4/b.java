package lv4;

import ay4.d;
import com.ss.android.lark.vfs.VFSFile;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    public static void a(VFSFile r100, Map r101, int r110) {
        VFSFile[] r102 = r100.listFiles();
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.length <= 0) goto L26;
        int r103 = r102.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L27;
        VFSFile r105 = r102[r104];
        if (r105.getName() != null) goto L11;
    L20:
        tt5.a.d("ResUtils", "item name or absolutePath empty");
    L21:
        r104 = r104 + 1;
        goto L7
    L11:
        if (r105.getAbsolutePath() == null) goto L20;
        if (d.a().i(r105.getAbsolutePath()).isFile() == false) goto L19;
        String r106 = r105.getAbsolutePath();
        Intrinsics.checkNotNull(r106);
        if (StringsKt.endsWith$default(r106, "mobile_subpage.html", false, 2, null) == false) goto L18;
        ((HashMap) r101).put("mobile_subpage.html", r106);
        goto L19
    L18:
        HashMap r107 = (HashMap) r101;
        r107.put(r106.substring(r110), r106);
    L19:
        a(r105, r101, r110);
        goto L21
    L27:
        return;
    }
}
