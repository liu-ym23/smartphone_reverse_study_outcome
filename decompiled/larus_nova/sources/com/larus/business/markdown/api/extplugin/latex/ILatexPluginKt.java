package com.larus.business.markdown.api.extplugin.latex;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public final class ILatexPluginKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f320475a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReference<a> f320476b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f320477c;

    public static final a c() {
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        Object r102 = a().newInstance();     // Catch: Throwable -> L9
        if ((r102 instanceof a) == false) goto L6;
        a r103 = (a) r102;     // Catch: Throwable -> L9
    L7:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r104) == true) goto L16;
        r100 = r104;
    L16:
        return (a) r100;
    L6:
        r103 = null;
    L9:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    static {
        f320475a = LazyKt.lazy(ILatexPluginKt$defaultLatexPluginDelegate$2.INSTANCE);
        f320476b = new AtomicReference();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.larus.bussiness.markdown.latex.LatexPluginImpl");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.larus.bussiness.markdown.latex.LatexPluginImpl");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.larus.bussiness.markdown.latex.LatexPluginImpl");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.larus.bussiness.markdown.latex.LatexPluginImpl");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.larus.bussiness.markdown.latex.LatexPluginImpl");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.larus.bussiness.markdown.latex.LatexPluginImpl");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.larus.bussiness.markdown.latex.LatexPluginImpl");
    }

    public static final a b() {
        if (f320477c == false) goto L5;
        AtomicReference<a> r100 = f320476b;
        a r101 = r100.get();
        if (r101 == null) goto L9;
        return r101;
    L9:
        a r102 = c();
        if (r102 != null) goto L13;
        return null;
    L13:
        if (r100.compareAndSet(null, r102) == true) goto L14;
        if (r100.get() == null) goto L13;
        boolean r103 = false;
    L18:
        if (r103 == false) goto L21;
        return r102;
    L21:
        return f320476b.get();
    L14:
        r103 = true;
        goto L18
    L5:
        return (a) f320475a.getValue();
    }
}
