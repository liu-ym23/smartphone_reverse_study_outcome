package com.bytedance.badger.collect.impl.model;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.interfaces.ILogger;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import el9.a;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultLogger implements ILogger {
    private static final Object ALOG_LOCK = null;
    private static volatile boolean alogAvailable;
    private static volatile boolean alogChecked;
    private static volatile Method alogD;
    private static volatile Method alogE;
    private static volatile Method alogI;
    private static volatile Method alogW;

    public DefaultLogger() {
    }

    public static /* synthetic */ Class access$000(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        return Class.forName(r100, r101, r102);
    }

    static {
        ALOG_LOCK = new Object();
        alogChecked = false;
        alogAvailable = false;
    }

    private static boolean ensureALogAvailable() {
        if (alogAvailable == false) goto L5;
        return true;
    L5:
        Object r100 = ALOG_LOCK;
        monitor-enter(r100);
    L22:
        th = move-exception;
        throw th;
    L8:
        if (alogAvailable == false) goto L12;
        monitor-exit(r100);     // Catch: Throwable -> L22
        return true;
    L12:
        if (alogChecked == false) goto L15;
        monitor-exit(r100);     // Catch: Throwable -> L22
        return false;
    L15:
        alogChecked = true;     // Catch: Throwable -> L22
        Class r101 = INVOKESTATIC_com_bytedance_badger_collect_impl_model_DefaultLogger_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.ss.android.agilelogger.ALog", false, DefaultLogger.class.getClassLoader());     // Catch: Throwable -> L18
        alogD = r101.getMethod("d", new Class[]{String.class, String.class});     // Catch: Throwable -> L18
        alogI = r101.getMethod(RXScreenCaptureService.KEY_INDEX, new Class[]{String.class, String.class});     // Catch: Throwable -> L18
        alogW = r101.getMethod("w", new Class[]{String.class, String.class});     // Catch: Throwable -> L18
        alogE = r101.getMethod("e", new Class[]{String.class, String.class, Throwable.class});     // Catch: Throwable -> L18
        alogAvailable = true;     // Catch: Throwable -> L18
    L19:
        boolean r102 = alogAvailable;     // Catch: Throwable -> L22
        monitor-exit(r100);     // Catch: Throwable -> L22
        return r102;
    L18:
        alogAvailable = false;     // Catch: Throwable -> L22
        goto L19
    }

    @Override // com.bytedance.badger.collect.impl.interfaces.ILogger
    public void debug(String r100, String r101) {
        if (ensureALogAvailable() == true) goto L8;
        return;
    L8:
        alogD.invoke(null, new Object[]{Constants.TAGS.KITE, r101});     // Catch: Throwable -> L7
        return;
    }

    @Override // com.bytedance.badger.collect.impl.interfaces.ILogger
    public void info(String r100, String r101) {
        if (ensureALogAvailable() == true) goto L8;
        return;
    L8:
        alogI.invoke(null, new Object[]{Constants.TAGS.KITE, r101});     // Catch: Throwable -> L7
        return;
    }

    @Override // com.bytedance.badger.collect.impl.interfaces.ILogger
    public void warn(String r100, String r101) {
        if (ensureALogAvailable() == true) goto L8;
        return;
    L8:
        alogW.invoke(null, new Object[]{Constants.TAGS.KITE, r101});     // Catch: Throwable -> L7
        return;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_badger_collect_impl_model_DefaultLogger_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r105 = access$000(r100, r101, r102);     // Catch: Throwable -> L8
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r105;
    L8:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r106 = access$000(r100, r101, r102);     // Catch: Throwable -> L17
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r106;
    L17:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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

    @Override // com.bytedance.badger.collect.impl.interfaces.ILogger
    public void error(String r100, String r101, Throwable r102) {
        if (ensureALogAvailable() == true) goto L8;
        return;
    L8:
        alogE.invoke(null, new Object[]{Constants.TAGS.KITE, r101, r102});     // Catch: Throwable -> L7
        return;
    }
}
