package com.bytedance.kmp.gamecp.api;

import android.util.Log;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import el9.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import qa6.b;
import tb2.c;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/kmp/gamecp/api/GameCpInitializer;", "", "()V", "GAME_CP_SDK_INITIALIZER_IMPL", "", "TAG", "mHasInit", "", "init", "", "kmp-gamecp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GameCpInitializer {
    private static final String GAME_CP_SDK_INITIALIZER_IMPL = "com.bytedance.kmp.gamecp.impl.GameCpInitializerImpl";
    public static final GameCpInitializer INSTANCE = null;
    private static final String TAG = "GameCpInitializer";
    private static boolean mHasInit;

    private GameCpInitializer() {
    }

    public static /* synthetic */ Class access$000(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        return Class.forName(r100, r101, r102);
    }

    static {
        INSTANCE = new GameCpInitializer();
    }

    public final void init() {
        monitor-enter(this);
    L26:
        th = move-exception;
        throw th;
    L5:
        if (mHasInit == false) goto L29;
    L23:
        Unit r100 = Unit.INSTANCE;     // Catch: Throwable -> L26
        monitor-exit(this);
        return;
    L29:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L18
        Constructor r102 = INVOKESTATIC_com_bytedance_kmp_gamecp_api_GameCpInitializer_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(GAME_CP_SDK_INITIALIZER_IMPL, true, INSTANCE.getClass().getClassLoader()).getDeclaredConstructor(new Class[0]);     // Catch: Throwable -> L18
        if (r102 == null) goto L10;
        r102.setAccessible(true);     // Catch: Throwable -> L18
    L10:
        if (r102 == null) goto L12;
        Object r103 = r102.newInstance(new Object[0]);     // Catch: Throwable -> L18
    L13:
        Method r104 = INVOKESTATIC_com_bytedance_kmp_gamecp_api_GameCpInitializer_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(GAME_CP_SDK_INITIALIZER_IMPL, true, GameCpInitializer.class.getClassLoader()).getDeclaredMethod("ensureInitialized", new Class[0]);     // Catch: Throwable -> L18
        r104.setAccessible(true);     // Catch: Throwable -> L18
        if (r104.invoke(r103, new Object[0]) == null) goto L16;
        mHasInit = true;     // Catch: Throwable -> L18
    L16:
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L20:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);     // Catch: Throwable -> L26
        if (r106 == null) goto L23;
        int r107 = b.f532260a;     // Catch: Throwable -> L26
        String r108 = "GameCpInitializer onFailure: " + ThreadMethodProxy.currentThread().getName() + c.DEFAULT_TEXT + Log.getStackTraceString(r106);     // Catch: Throwable -> L26
        Intrinsics.checkNotNullParameter("GameCpInitializer", "tag");     // Catch: Throwable -> L26
        Intrinsics.checkNotNullParameter(r108, "msg");     // Catch: Throwable -> L26
        jy0.b.b("GameCpInitializer", r108, null);     // Catch: Throwable -> L26
        goto L23
    L12:
        r103 = null;
    L18:
        th = move-exception;
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L26
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L26
        goto L20
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_kmp_gamecp_api_GameCpInitializer_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
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
}
