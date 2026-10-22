package com.bytedance.ug.sdk.luckycat.impl.lynx;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements ri7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ri7.a f271238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k f271239b = null;

    public k() {
    }

    static {
        f271239b = new k();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class d() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.ug.sdk.luckycat.lynx.LuckyCatLynxImpl");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.ug.sdk.luckycat.lynx.LuckyCatLynxImpl");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.ug.sdk.luckycat.lynx.LuckyCatLynxImpl");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.ug.sdk.luckycat.lynx.LuckyCatLynxImpl");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.ug.sdk.luckycat.lynx.LuckyCatLynxImpl");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.ug.sdk.luckycat.lynx.LuckyCatLynxImpl");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.ug.sdk.luckycat.lynx.LuckyCatLynxImpl");
    }

    public static ri7.a e() {
        ri7.a r100 = f271238a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        ri7.a r101 = null;
        Class r102 = d();     // Catch: Throwable -> L15
        if (r102 == null) goto L9;
        Object r103 = r102.newInstance();     // Catch: Throwable -> L15
    L11:
        if ((r103 instanceof ri7.a) == true) goto L13;
        r103 = null;
    L13:
        r101 = (ri7.a) r103;     // Catch: Throwable -> L15
    L17:
        f271238a = r101;
        return r101;
    L9:
        r103 = null;
    L15:
        th = move-exception;
        th.getMessage();
        goto L17
    }

    @Override // ri7.a
    public final void initLuckyCatLynxServices() {
        ri7.a r100 = e();
        if (r100 == null) goto L6;
        r100.initLuckyCatLynxServices();
        return;
    }

    @Override // ri7.a
    public final void a(JSONObject r100) {
        ri7.a r101 = e();
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // ri7.a
    public final Map b(FragmentActivity r100) {
        ri7.a r101 = e();
        if (r101 == null) goto L8;
        Map r102 = r101.b(r100);
        if (r102 == null) goto L8;
        return r102;
    L8:
        return new LinkedHashMap();
    }

    @Override // ri7.a
    public final vi7.c c(Activity r100, c r101, l r110, vi7.d r111, ij7.i r112, String r113) {
        ri7.a r102 = e();
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.c(r100, r101, r110, r111, r112, r113);
    }
}
