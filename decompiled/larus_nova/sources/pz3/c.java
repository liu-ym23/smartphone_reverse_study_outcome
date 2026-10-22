package pz3;

import com.bytedance.awemeopen.infra.base.log.AoLogger;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, ArrayList<String>> f531077a = null;

    static {
        f531077a = new HashMap();
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        AoLogger.g("VideoScaling", new Object[]{r100});
    }

    public static void a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r102, "msg");
        if (r101 != null) goto L5;
        return;
    L5:
        HashMap<String, ArrayList<String>> r103 = f531077a;
        ArrayList<String> r104 = r103.get(r100);
        if (r104 != null) goto L9;
        r104 = new ArrayList();
    L9:
        if (r104.contains(r101) == true) goto L12;
        AoLogger.g("VideoScaling", new Object[]{r100 + "-> aid: " + r101 + ", " + r102});
        r104.add(r101);
        r103.put(r100, r104);
        return;
    }
}
