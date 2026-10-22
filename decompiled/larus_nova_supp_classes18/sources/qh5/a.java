package qh5;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final HashMap<String, Integer> a = null;

    static {
        HashMap<String, Integer> r0 = new HashMap();
        a = r0;
        r0.put("default", 30);
        r0.put("user_perm", 16);
    }

    public static boolean a(String r1, String r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "sceneKey");
        Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.OPT);
        Integer r4 = a.get(r1);
        if (r4 != null) goto L6;
        return false;
    L6:
        if ((r4.intValue() & r3) == 0) goto L9;
        return true;
    L9:
        return false;
    }
}
