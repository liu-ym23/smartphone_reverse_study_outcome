package ya0;

import com.bytedance.android.live.initialize.api.IWTOLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static IWTOLogger f567013a;

    static {
    }

    public static void c(String r100) {
        Intrinsics.checkNotNullParameter("wto_async_optimizer", "tag");
        Intrinsics.checkNotNullParameter(r100, "msg");
        IWTOLogger r101 = f567013a;
        if (r101 == null) goto L6;
        r101.i("wto_async_optimizer", r100);
        return;
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "sceneInfo");
        Intrinsics.checkNotNullParameter(r101, "msg");
        IWTOLogger r102 = f567013a;
        if (r102 == null) goto L6;
        r102.i("WTO_", r100 + ",\n\t" + r101);
        return;
    }

    public static void b(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        IWTOLogger r102 = f567013a;
        if (r102 == null) goto L13;
        StringBuilder r103 = new StringBuilder();
        r103.append(r100);
        StackTraceElement[] r104 = null;
        if (r101 == null) goto L7;
        String r105 = r101.getMessage();
    L8:
        r103.append(r105);
        if (r101 == null) goto L11;
        r104 = r101.getStackTrace();
    L11:
        r103.append(r104);
        r102.e("WTO_SCHDULE_ERROR", r103.toString(), r101);
        return;
    L7:
        r105 = null;
        goto L8
    }

    public static void d(com.bytedance.android.live.initialize.a r100, String r101, Map r102) {
        Intrinsics.checkNotNullParameter(r100, "executePeriod");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, "info");
        String r103 = "{\n\t\"msg\":".concat(r101) + ",\n\t\"period\":" + r100.f69375b;
        Iterator r104 = ((LinkedHashMap) r102).entrySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        Map.Entry r105 = (Map.Entry) r104.next();
        r103 = r103 + ",\n\t\"" + ((String) r105.getKey()) + "\":" + r105.getValue();
        goto L4
    L6:
        String r106 = r103 + "\n}";
        IWTOLogger r107 = f567013a;
        if (r107 == null) goto L11;
        r107.i("WTO_SCHDULE", r106);
        return;
    }
}
