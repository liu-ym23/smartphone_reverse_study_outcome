package qh5;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, Integer> f532968a = null;

    static {
        HashMap<String, Integer> r100 = new HashMap();
        f532968a = r100;
        r100.put("default", 30);
        r100.put("user_perm", 16);
    }

    public static boolean a(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "sceneKey");
        Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.OPT);
        Integer r103 = f532968a.get(r100);
        if (r103 != null) goto L6;
        return false;
    L6:
        if ((r103.intValue() & r102) == 0) goto L9;
        return true;
    L9:
        return false;
    }
}
