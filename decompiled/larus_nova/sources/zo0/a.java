package zo0;

import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, b> f573079a = null;

    static {
        f573079a = new HashMap();
    }

    @JvmStatic
    public static final b a(PerformanceScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        HashMap<String, b> r101 = f573079a;
        b r102 = r101.get(r100.getValue());
        if (r102 == null) goto L5;
        return r102;
    L5:
        b r103 = new b(r100);
        r101.put(r100.getValue(), r103);
        return r103;
    }
}
