package com.ss.android.lark.framework.assembly.logger;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.Gson;
import com.lark.kmp.logger.LarkLogger;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.larksuite.framework.utils.ApkUtil;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.log.f;
import com.ss.android.lark.utils.a0;
import com.ss.android.lark.utils.o0;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.rust.molten.ffi.LogConfig;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import se6.q;

/* JADX INFO: loaded from: classes36.dex */
@Singleton
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u0000 %2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002$%B\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J \u0010!\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020 H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R/\u0010\u0007\u001a\u0013\u0012\u000f\u0012\r\u0012\t\u0012\u00070\n¢\u0006\u0002\b\u000b0\t0\b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006&"}, d2 = {"Lcom/ss/android/lark/framework/assembly/logger/InitLogTask;", "Lcom/larksuite/framework/launch/task/AbstractLaunchTask;", "", "<init>", "()V", "isMoltenLibLoaded", "", "logMufflers", "Ljavax/inject/Provider;", "", "Lcom/ss/android/lark/log/ILogMuffler;", "Lkotlin/jvm/JvmSuppressWildcards;", "getLogMufflers", "()Ljavax/inject/Provider;", "setLogMufflers", "(Ljavax/inject/Provider;)V", "execute", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "initLog", "initKmpLogger", "logConfig", "Lcom/ss/android/lark/log/LogConfig;", "isPrivateKA", "aLogEvent", "Lcom/ss/android/lark/log/alog/IALogEvent;", "getALogEvent", "()Lcom/ss/android/lark/log/alog/IALogEvent;", "isMoltenLogLibEnable", "isNeedLog", "getProcessName", "", "printTrackLog", "tag", "message", "CipherKeyConfiguration", "Companion", "logger-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitLogTask extends AbstractLaunchTask<Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f425656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Inject
    public Provider<Set<com.ss.android.lark.log.b>> f425657d;

    public final class a implements f.b {
        @Override // com.ss.android.lark.log.f.b
        public final Pair<String, String> a() {
            LogCipherConfigHandler.LogCipherConfig r100 = LogCipherConfigHandler.f425659j;
            if (r100 != null) goto L7;
            return null;
        L7:
            return new Pair(r100.getKeyId(), r100.getPublicKey());
        }

        public a() {
        }
    }

    public static final class b {
    }

    static {
    }

    @Inject
    public InitLogTask() {
    }

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(final Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r100 = jac.a.f497974a;
        boolean r101 = false;
        if (r110 == null) goto L10;
        String r102 = z.b(r110);
        if (TextUtils.isEmpty(r102) == true) goto L10;
        if (r102.contains(":sandboxed_process") == false) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == true) goto L22;
        Provider<Set<com.ss.android.lark.log.b>> r104 = this.f425657d;
        if (r104 == null) goto L21;
        Set<com.ss.android.lark.log.b> r105 = r104.get();
        if (r105 == null) goto L21;
        Iterator<T> r106 = r105.iterator();
    L19:
        if (r106.hasNext() == false) goto L21;
        ((com.ss.android.lark.log.b) r106.next()).a(r110);
    L21:
        r101 = true;
    L22:
        if (r101 == false) goto L51;
        LogCipherConfigHandler r107 = LogCipherConfigHandler.f425658i;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        LogCipherConfigHandler r108 = LogCipherConfigHandler.f425658i;
        AbstractBaseSettingHandler.a r109 = r108.f431106e;
        r109.c(new LogCipherConfigHandler$init$1(r110));
        Function0<Unit> r111 = new LogCipherConfigHandler$init$2(r110);
        Intrinsics.checkNotNullParameter(r111, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        r109.a(r109.f431116g, r111);
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
        r108.f431107f = r109;
        String r112 = null;
        com.ss.android.lark.storage.kv.flash.d r113 = com.ss.android.lark.storage.kv.flash.c.f441037b;     // Catch: Throwable -> L26
        LogCipherConfigHandler.f425660k = com.ss.android.lark.storage.kv.flash.c.b.a(r110).getString(null);     // Catch: Throwable -> L26
        LogCipherConfigHandler.LogCipherConfig r114 = (LogCipherConfigHandler.LogCipherConfig) new Gson().fromJson(com.ss.android.lark.storage.kv.flash.c.b.a(r110).getString(null), LogCipherConfigHandler.LogCipherConfig.class);     // Catch: Throwable -> L26
    L28:
        LogCipherConfigHandler.f425659j = r114;
        if (o0.c(r110) == false) goto L31;
        int r115 = 4;
    L32:
        f.a r116 = new f.a();
        r116.f431396a = r110;
        LarkAppContext.Companion.getClass();
        r116.f431406k = LarkAppContext.access$getInstance$cp().appIdInfo().f18218a;
        r116.f431397b = r115;
        if (o0.a(r110) == false) goto L35;
        String r117 = "Main";
    L36:
        r116.f431398c = r117;
        r116.f431399d = DevEnvUtil.isDebugMode(r110);
        r116.f431400e = a0.d(r110);
        r116.f431401f = new PolarisFileWrapper(com.ss.android.lark.diskmanage.storage.d.k(r110), "temp").getAbsolutePath();
        r116.f431402g = new com.ss.android.lark.framework.assembly.logger.b();
        r116.f431407l = true;
        r116.f431405j = new c(this, r110);
        r116.f431404i = new a();
        r116.f431403h = true ^ LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK();
        f r118 = new f(r116);
        Log.init(r118);
        Intrinsics.checkNotNull(r118);
        if (r118.f431386b != 8) goto L50;
        f.b r119 = r118.f431393i;
        if (r119 == null) goto L42;
        Pair<String, String> r120 = r119.a();
    L43:
        LarkLogger r121 = LarkLogger.f278603a;
        String r122 = "Kmp" + r118.f431387c;
        String r123 = new PolarisFileWrapper(r118.f431389e, "molten2").getAbsolutePath();
        long r124 = r118.f431391g;
        if (r120 == null) goto L46;
        String r125 = (String) r120.first;
    L47:
        if (r120 == null) goto L49;
        r112 = (String) r120.second;
    L49:
        LogConfig r126 = new LogConfig(r122, r123, r124, null, 5L, r112, r125);
        InitLogTask$initKmpLogger$1 r127 = new InitLogTask$initKmpLogger$1(q.f541600a);
        Intrinsics.checkNotNullParameter(r126, "config");
        Intrinsics.checkNotNullParameter(r127, "isNativeLoaded");
        LarkLogger.f278605c = r126;
        LarkLogger.f278606d = r127;
        goto L50
    L46:
        r125 = null;
        goto L47
    L42:
        r120 = null;
    L50:
        Log.i("InitLogTask", "init log done, type:" + r115 + "; version:" + ApkUtil.getAppVersionName(r110) + "; process:" + z.c(r110));
        com.suite.component.logger.Log.f460091e = new com.suite.lark.component.logger.dynamic.a(DevEnvUtil.isDebugMode(r110));
        return;
    L35:
        r117 = z.c(r110);
        Intrinsics.checkNotNull(r117);
        goto L36
    L31:
        r115 = 8;
    L26:
        th = move-exception;
        Log.e("LogCipherConfigHandler", "load log cipher config failed, error: " + th.getMessage());
        r114 = null;
        goto L28
    L51:
        Log.initWithNone();
        return;
    L10:
        r103 = false;
        goto L11
    }
}
