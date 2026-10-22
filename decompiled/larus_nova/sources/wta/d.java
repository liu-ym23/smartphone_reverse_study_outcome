package wta;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.dypay.utils.k;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class d extends com.ss.android.dypay.webview.c {
    public d() {
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

    public static void c(Activity r100, String r101, com.ss.android.dypay.webview.a.C4736a r102) {
        Intent r103 = new Intent();     // Catch: Exception -> L5
        r103.setData(UriProtector.parse(r101));     // Catch: Exception -> L5
        r103.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);     // Catch: Exception -> L5
        r100.startActivity(r103);     // Catch: Exception -> L5
        qta.a.g(r102, null, 0, null, 7);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        r102.a(Log.getStackTraceString(e), 0);
    }

    @Override // com.ss.android.dypay.webview.c
    public final void a(Activity r100, JSONObject r101, com.ss.android.dypay.webview.a.C4736a r102) {
        boolean r103 = false;
        if (r100 != null) goto L6;
        r102.a("context is null", 0);
        return;
    L6:
        String r104 = r101.optString("url");
        if (k.f408504a == true) goto L15;
        if (b().getName().length() <= 0) goto L11;
        boolean r105 = true;
    L12:
        k.f408505b = r105;     // Catch: Exception -> L26
        goto L13
    L11:
        r105 = false;
    L13:
        k.f408504a = true;
    L15:
        if (k.f408505b == true) goto L17;
    L24:
        c(r100, r104, r102);
        return;
    L17:
        if (StringsKt.startsWith$default(r104, "market://details", false, 2, null) == false) goto L24;
        String r106 = com.ss.android.dypay.utils.b.f408479a;
        if (com.ss.android.dypay.utils.b.f408479a.length() != 0) goto L21;
        r103 = true;
    L21:
        if (r103 == false) goto L23;
        com.ss.android.dypay.utils.b.b(r100, true);
        return;
    L23:
        r104 = com.ss.android.dypay.utils.b.f408479a;
        goto L24
    }
}
