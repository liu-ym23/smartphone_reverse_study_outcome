package ib1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.soloktv.util.h;
import com.bytedance.android.live.soloktv.util.i;
import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import com.ss.bytedance.ies.audiorecord.api.ILibraryLoader;
import com.ss.bytedance.ies.videoclip.logapi.ILogMonitorService;
import jc1.k;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f488988a = 0;

    public static final class a implements ljc.b {
        public a() {
        }
    }

    public static void a() {
        IHostPlugin r100 = (IHostPlugin) k.f(IHostPlugin.class);
        if (r100 == null) goto L5;
        ILogMonitorService r101 = (ILogMonitorService) r100.getOrNull(ILogMonitorService.class);
    L6:
        if (r101 == null) goto L9;
        r101.injectLogImpl(h.f101605a);
        return;
    L9:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public static void b() {
        IHostPlugin r100 = (IHostPlugin) k.f(IHostPlugin.class);
        if (r100 == null) goto L5;
        ILogMonitorService r101 = (ILogMonitorService) r100.getOrNull(ILogMonitorService.class);
    L6:
        if (r101 == null) goto L9;
        r101.injectMonitorImpl(i.f101606a);
        return;
    L9:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public static void c() {
        IHostPlugin r100 = (IHostPlugin) k.f(IHostPlugin.class);
        if (r100 == null) goto L5;
        ILibraryLoader r101 = (ILibraryLoader) r100.getOrNull(ILibraryLoader.class);
    L6:
        if (r101 == null) goto L8;
        r101.setLoaderProxy(new a());
        return;
    L8:
        ALogger.e("IESVideClipLibPluginManager", "loadLibaray fail : libraryLoader is null");
        return;
    L5:
        r101 = null;
        goto L6
    }

    static {
    }
}
