package ft1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.crash.Npth;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f478773a = 0;

    static {
    }

    public static void a(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        Iterator r101 = r100.entrySet().iterator();     // Catch: Exception -> L9
    L5:
        if (r101.hasNext() == false) goto L7;
        Map.Entry r102 = (Map.Entry) r101.next();     // Catch: Exception -> L9
        String r103 = (String) r102.getKey();     // Catch: Exception -> L9
        String r104 = (String) r102.getValue();     // Catch: Exception -> L9
        goto L5
    L7:
        Npth.addTags(r100);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        ALogger.e("LiveNpthHelper", "add tags error: " + e.getMessage());
    }
}
