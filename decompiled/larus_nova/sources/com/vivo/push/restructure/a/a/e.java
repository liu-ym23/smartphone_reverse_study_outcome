package com.vivo.push.restructure.a.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.t;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
final class e extends a<com.vivo.push.restructure.a.a> {
    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_vivo_push_restructure_a_a_e_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
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
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
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

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    private int a2(com.vivo.push.restructure.a.a r100) {
        PushMessageCallback r101 = b(r100);
        if (r101 != null) goto L6;
        return 2804;
    L6:
        int r102 = 0;
        if (r100 != null) goto L9;
    L12:
        if (r100 == null) goto L32;
        int r103 = r100.l();
        String r104 = r100.m();
        if (r103 != 3) goto L21;
        String r105 = com.vivo.push.m.a().i();
        if (TextUtils.isEmpty(r105) == false) goto L18;
    L19:
        r102 = 2810;
    L25:
        if (r102 == 0) goto L32;
        com.vivo.push.util.g.a().execute(new f(this, r103, r104));
        return r102;
    L18:
        if (TextUtils.equals(r105, r104) == true) goto L25;
    L21:
        if (r103 != 4) goto L25;
        com.vivo.push.m.a();
        if (com.vivo.push.m.c().contains(r104) == true) goto L25;
        r102 = 2811;
    L32:
        return com.vivo.push.m.a().a(r100.b(), r101);
    L30:
        return 2808;
    L9:
        if (r100.g() == false) goto L12;
        com.vivo.push.restructure.request.d.a().a(r100);
        return 0;
    }

    private static PushMessageCallback b(com.vivo.push.restructure.a.a r100) {
        Context r101 = com.vivo.push.restructure.a.a().b();     // Catch: Exception -> L4
        Intent r102 = r100.b();     // Catch: Exception -> L4
        return (PushMessageCallback) INVOKESTATIC_com_vivo_push_restructure_a_a_e_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(com.vivo.push.restructure.a.a().e().a(r101, r102.getAction())).getConstructor(new Class[0]).newInstance(new Object[0]);
    L4:
        e = move-exception;
        t.b("DispatchNode", "reflect e: ", e);
        return null;
    }

    @Override // com.vivo.push.restructure.a.a.a
    public final /* bridge */ /* synthetic */ int a(com.vivo.push.restructure.a.a r100) {
        return a2(r100);
    }

    public e(com.vivo.push.restructure.a.a r100, j r101) {
        super("ClientDispatchNode", r100, r101);
    }
}
