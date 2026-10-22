package com.bytedance.ug.sdk.share.impl.manager;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import jn7.l;
import jn7.m;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, no7.b> f272315a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static jn7.k f272316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f272317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static m f272318d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f272319e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static jn7.f f272320f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f272321g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static l f272322h;

    static {
        f272315a = new ConcurrentHashMap();
        f272317c = true;
        f272319e = true;
        f272321g = true;
    }

    public static l c() {
        if (f272321g == true) goto L6;
        return null;
    L6:
        l r100 = f272322h;
        if (r100 == null) goto L14;
        return r100;
    L14:
        f272322h = (l) a("com.bytedance.ug.sdk.share.keep.impl.UIConfigImpl").newInstance();     // Catch: Throwable -> L11
    L13:
        return f272322h;
    L11:
        f272321g = false;
        goto L13
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
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

    public static no7.b b(ShareChannelType r100) {
        String r101 = fo7.a.f478168a.get(r100);
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return null;
    L6:
        no7.b r102 = f272315a.get(r101);
        if (r102 == null) goto L16;
        return r102;
    L16:
        r102 = (no7.b) a(r101).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{h.g.f272345a.f272326a});     // Catch: Throwable -> L11
    L13:
        if (r102 == null) goto L15;
        f272315a.put(r101, r102);
    L15:
        return r102;
    L11:
        th = move-exception;
        oo7.k.b(th.toString());
        goto L13
    }
}
