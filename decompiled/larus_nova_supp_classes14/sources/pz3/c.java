package pz3;

import com.bytedance.awemeopen.infra.base.log.AoLogger;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public static final HashMap<String, ArrayList<String>> a = null;

    static {
        a = new HashMap();
    }

    public static void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        AoLogger.g("VideoScaling", new Object[]{r2});
    }

    public static void a(String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r7, "msg");
        if (r6 != null) goto L5;
        return;
    L5:
        HashMap<String, ArrayList<String>> r0 = a;
        ArrayList<String> r1 = r0.get(r5);
        if (r1 != null) goto L9;
        r1 = new ArrayList();
    L9:
        if (r1.contains(r6) == true) goto L12;
        AoLogger.g("VideoScaling", new Object[]{r5 + "-> aid: " + r6 + ", " + r7});
        r1.add(r6);
        r0.put(r5, r1);
        return;
    }
}
