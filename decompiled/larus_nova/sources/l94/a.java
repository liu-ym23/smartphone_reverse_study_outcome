package l94;

import com.bytedance.bdp.appbase.context.service.base.AbsContextServiceFetcher;
import com.bytedance.bdp.appbase.exit.ExitReasonService;
import com.bytedance.bdp.appbase.request.contextservice.CpDownloadService;
import com.bytedance.bdp.appbase.request.contextservice.CpUploadService;
import com.bytedance.bdp.appbase.service.protocol.host.HostInfoService;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes11.dex */
public final class a extends AbsContextServiceFetcher {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f508109c = 0;

    @Override // com.bytedance.bdp.appbase.context.service.base.AbsContextServiceFetcher
    public final HashMap b() {
        HashMap r100 = new HashMap();
        r100.put(ExitReasonService.class, ExitReasonService.class);
        r100.put(CpDownloadService.class, CpDownloadService.class);
        r100.put(CpUploadService.class, CpUploadService.class);
        r100.put(HostInfoService.class, HostInfoService.class);
        return r100;
    }

    public a() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static void c(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L36;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
        return;
    L36:
        return;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L37;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
        return;
    L37:
        return;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == false) goto L26;
    L29:
        MiraPluginFix.forName(r100);
        return;
    L26:
        if ((th instanceof NoClassDefFoundError) == true) goto L29;
        throw th;
    }
}
