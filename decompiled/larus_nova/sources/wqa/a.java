package wqa;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public sa7.k f560767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.sdk.account.utils.g f560768b;

    public a() {
    }

    @Override // wqa.f
    public final sa7.k a() {
        sa7.k r100 = this.f560767a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        tb7.a.a("AbsTTAccountConfig", "call getNetwork");
        sa7.k r101 = (sa7.k) g("com.ss.android.account.adapter.NetworkAdapter").newInstance();     // Catch: Exception -> L8
        this.f560767a = r101;     // Catch: Exception -> L8
        return r101;
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // wqa.f
    public final com.bytedance.sdk.account.utils.g getMonitor() {
        com.bytedance.sdk.account.utils.g r100 = this.f560768b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        tb7.a.a("AbsTTAccountConfig", "call getMonitor");
        com.bytedance.sdk.account.utils.g r101 = (com.bytedance.sdk.account.utils.g) g("com.ss.android.account.adapter.MonitorAdapter").newInstance();     // Catch: Exception -> L8
        this.f560768b = r101;     // Catch: Exception -> L8
        return r101;
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class g(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }
}
