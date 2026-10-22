package hpa;

import android.content.Context;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.relax.RelaxEnv;
import com.relax.RelaxView;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f486488a;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.relaxdevtool.RelaxDevTool");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.relaxdevtool.RelaxDevTool");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.relaxdevtool.RelaxDevTool");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.relaxdevtool.RelaxDevTool");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.relaxdevtool.RelaxDevTool");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.relaxdevtool.RelaxDevTool");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.relaxdevtool.RelaxDevTool");
    }

    public c(Context r100, RelaxView r101) {
        if (RelaxEnv.inst().isRelaxDebugEnabled() == true) goto L6;
        return;
    L6:
        if (RelaxEnv.inst().isDevToolEnabled() == false) goto L20;
        new WeakReference(r101);
        Object r102 = a().getConstructor(new Class[]{Context.class, c.class}).newInstance(new Object[]{r100, this});     // Catch: Throwable -> L13
        boolean r103 = r102 instanceof a;     // Catch: Throwable -> L13
        if ((r102 instanceof a) == false) goto L18;
        this.f486488a = (a) r102;     // Catch: Throwable -> L13
        return;
    L18:
        return;
    L13:
        th = move-exception;
        th.toString();
        return;
    }
}
