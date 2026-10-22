package wta;

import android.app.Activity;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.dypay.utils.k;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class c extends com.ss.android.dypay.webview.c {
    public c() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class b() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("miui.os.Build");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("miui.os.Build");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("miui.os.Build");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("miui.os.Build");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("miui.os.Build");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("miui.os.Build");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("miui.os.Build");
    }

    @Override // com.ss.android.dypay.webview.c
    public final void a(Activity r100, JSONObject r101, com.ss.android.dypay.webview.a.C4736a r102) {
        if (r100 != null) goto L6;
        r102.a("context is null", 0);
        return;
    L6:
        String r103 = com.ss.android.dypay.utils.b.f408479a;
        if (k.f408504a == true) goto L15;
        if (b().getName().length() <= 0) goto L11;
        boolean r104 = true;
    L12:
        k.f408505b = r104;     // Catch: Exception -> L28
        goto L13
    L11:
        r104 = false;
    L13:
        k.f408504a = true;
    L15:
        if (k.f408505b == false) goto L22;
        String r105 = com.ss.android.dypay.utils.b.f408479a;
        if (r105.length() != 0) goto L19;
        boolean r106 = true;
    L20:
        if (r106 == false) goto L23;
        com.ss.android.dypay.utils.b.b(r100, true);
        boolean r107 = false;
    L24:
        if (r107 == false) goto L26;
        qta.a.g(r102, null, 0, null, 7);
        return;
    L26:
        r102.a("open app market failed", 0);
        return;
    L23:
        r107 = com.ss.android.dypay.utils.b.c(r100, r105);
        goto L24
    L19:
        r106 = false;
        goto L20
    L22:
        r105 = "market://details?id=com.ss.android.ugc.aweme";
        goto L23
    }
}
