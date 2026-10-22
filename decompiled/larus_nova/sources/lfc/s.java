package lfc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.newmedia.redbadge.RedBadgerException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
public final class s implements kfc.a {
    public s() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class c() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.app.MiuiNotification");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.app.MiuiNotification");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.app.MiuiNotification");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.app.MiuiNotification");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.app.MiuiNotification");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.app.MiuiNotification");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.app.MiuiNotification");
    }

    @Override // kfc.a
    public final List<String> b() {
        return Arrays.asList(new String[]{"com.miui.miuilite", "com.miui.home", "com.miui.miuihome", "com.miui.miuihome2", "com.miui.mihome", "com.miui.mihome2", "com.i.miui.launcher"});
    }

    @Override // kfc.a
    public final void a(Context r100, ComponentName r101, int r102) throws RedBadgerException {
        Object r103 = "";
        if (r100 == null) goto L30;
        if (r101 == null) goto L39;
        if (r102 >= 0) goto L33;
        r102 = 0;
    L33:
        Object r104 = c().newInstance();     // Catch: Throwable -> L16
        Field r105 = r104.getClass().getDeclaredField("messageCount");     // Catch: Throwable -> L16
        r105.setAccessible(true);     // Catch: Throwable -> L16
        if (r102 != 0) goto L31;
        Object r106 = "";
    L12:
        r105.set(r104, String.valueOf(r106));     // Catch: Throwable -> L14
    L14:
        r105.set(r104, Integer.valueOf(r102));     // Catch: Throwable -> L16
        return;
    L37:
        return;
    L31:
        r106 = Integer.valueOf(r102);     // Catch: Throwable -> L14
    L16:
        th = move-exception;
        Intent r107 = new Intent("android.intent.action.APPLICATION_MESSAGE_UPDATE");
        r107.putExtra("android.intent.extra.update_application_component_name", r101.getPackageName() + HTTP.URL_DEFAULT + r101.getClassName());
        if (r102 == 0) goto L21;
        r103 = Integer.valueOf(r102);
    L21:
        r107.putExtra("android.intent.extra.update_application_message_text", String.valueOf(r103));
        if (nfc.a.a(r100, r107) == false) goto L29;
        r100.sendBroadcast(r107);     // Catch: Throwable -> L25
        return;
    L25:
        th = move-exception;
        th.printStackTrace();
        throw new RedBadgerException(th.getMessage());
    L29:
        throw new RedBadgerException("unable to resolve intent: " + r107.toString());
    L39:
        return;
    }
}
