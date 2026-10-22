package com.ss.android.lark.keyboard.edittext2.widget;

import android.text.Editable;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.log.Log;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes36.dex */
public final class g extends Editable.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f429265a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashSet<Class<?>> f429266b = null;

    static {
        f429265a = new g();
        String[] r100 = {"android.text.DynamicLayout$ChangeWatcher", "android.widget.TextView$ChangeWatcher"};
        f429266b = new HashSet();
        int r101 = r100.length;     // Catch: Throwable -> L9
        int r102 = 0;
    L4:
        if (r102 >= r101) goto L16;
        Class<?> r103 = a(r100[r102], f429265a.getClass().getClassLoader());     // Catch: Throwable -> L9
        if (r103 == null) goto L8;
        f429266b.add(r103);     // Catch: Throwable -> L9
    L8:
        r102 = r102 + 1;
        goto L4
    L16:
        return;
    L9:
        Log.e("RichTextEditableFactory", "RichTextEditableFactory: init failed");
    }

    public g() {
    }

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        HashSet<Class<?>> r101 = f429266b;
        int r102 = p.f429278c;
        Intrinsics.checkNotNullParameter(r101, "classes");
        Intrinsics.checkNotNullParameter(r100, "text");
        return new p(r101, r100, 0, r100.length());
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100, ClassLoader r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r104 = Class.forName(r100, false, r101);     // Catch: Throwable -> L8
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r105 = Class.forName(r100, false, r101);     // Catch: Throwable -> L17
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r105;
    L17:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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
