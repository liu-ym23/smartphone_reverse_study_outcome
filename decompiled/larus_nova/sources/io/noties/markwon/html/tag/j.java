package io.noties.markwon.html.tag;

import android.text.style.StrikethroughSpan;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import lsc.x;
import lsc.y;
import me.ele.lancet.base.annotations.Skip;
import org.commonmark.ext.gfm.strikethrough.Strikethrough;
import tsc.a0;
import tsc.v;

/* JADX INFO: loaded from: classes5.dex */
public final class j extends a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f492631a = false;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static void e() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class.forName("org.commonmark.ext.gfm.strikethrough.Strikethrough");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L36;
        FastClassNotFoundHandler.a("org.commonmark.ext.gfm.strikethrough.Strikethrough");     // Catch: Throwable -> L8
        return;
    L36:
        return;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("org.commonmark.ext.gfm.strikethrough.Strikethrough");
    L12:
        throw th;
    L34:
        Class.forName("org.commonmark.ext.gfm.strikethrough.Strikethrough");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L37;
        FastClassNotFoundHandler.a("org.commonmark.ext.gfm.strikethrough.Strikethrough");     // Catch: Throwable -> L17
        return;
    L37:
        return;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("org.commonmark.ext.gfm.strikethrough.Strikethrough");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == false) goto L26;
    L29:
        MiraPluginFix.forName("org.commonmark.ext.gfm.strikethrough.Strikethrough");
        return;
    L26:
        if ((th instanceof NoClassDefFoundError) == true) goto L29;
        throw th;
    }

    @Override // tsc.a0
    public final Collection<String> c() {
        return Arrays.asList(new String[]{"s", "del"});
    }

    static {
        e();     // Catch: Throwable -> L4
        boolean r100 = true;
    L5:
        f492631a = r100;
        return;
    L4:
        r100 = false;
        goto L5
    }

    public j() {
    }

    @Override // tsc.a0
    public final void a(lsc.m r100, v r101, tsc.l r102) {
        if (r102.isBlock() == false) goto L5;
        a0.d(r100, r101, r102.a());
    L5:
        y r103 = r100.builder();
        if (f492631a == false) goto L11;
        lsc.h r104 = r100.B();
        x r105 = ((lsc.l) r104.f510595e).a(Strikethrough.class);
        if (r105 != null) goto L10;
        Object r106 = null;
    L12:
        y.f(r103, r106, r102.start(), r102.end());
        return;
    L10:
        r106 = r105.a(r104, r100.r());
        goto L12
    L11:
        r106 = new StrikethroughSpan();
        goto L12
    }
}
