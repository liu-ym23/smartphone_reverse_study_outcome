package jh;

import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.monitor.fps.RealFpsMonitor;
import com.bytedance.android.ec.core.monitor.q;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, RealFpsMonitor> f499062a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, c> f499063b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f499064c = null;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static RealFpsMonitor a(q r100) {
            Intrinsics.checkNotNullParameter(r100, "monitorSceneWrapper");
            HashMap<String, RealFpsMonitor> r101 = b.f499062a;
            RealFpsMonitor r102 = r101.get(r100.f45192a);
            if (r102 == null) goto L5;
            return r102;
        L5:
            RealFpsMonitor r103 = new RealFpsMonitor(r100);
            r101.put(r100.f45192a, r103);
            return r103;
        }

        @JvmStatic
        public static RealFpsMonitor b(MonitorScenes r100) {
            Intrinsics.checkNotNullParameter(r100, DBDefinition.MONITOR_SCENE);
            return a(new q(r100, null, null));
        }

        @JvmStatic
        public static c c(q r100) {
            Intrinsics.checkNotNullParameter(r100, "monitorSceneWrapper");
            HashMap<String, c> r101 = b.f499063b;
            c r102 = r101.get(r100.f45192a);
            if (r102 == null) goto L5;
            return r102;
        L5:
            c r103 = new c(r100);
            r101.put(r100.f45192a, r103);
            return r103;
        }

        @JvmStatic
        public static c d(MonitorScenes r100) {
            Intrinsics.checkNotNullParameter(r100, DBDefinition.MONITOR_SCENE);
            return c(new q(r100, null, null));
        }
    }

    static {
        f499064c = new a();
        f499062a = new HashMap();
        f499063b = new HashMap();
    }
}
