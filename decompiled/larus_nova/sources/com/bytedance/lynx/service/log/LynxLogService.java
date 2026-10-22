package com.bytedance.lynx.service.log;

import android.content.Context;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.tasm.service.ILynxLogService;
import com.lynx.tasm.service.IServiceProvider;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/bytedance/lynx/service/log/LynxLogService;", "Lcom/lynx/tasm/service/ILynxLogService;", "", "functionName", "", "getALogNativeFunctionAddress", "", "level", "tag", "msg", "", "logByPlatform", "", "isLogOutputByPlatform", "getDefaultWriteFunction", "enableSystemLog", "switchLogToSystem", "getLogToSystemStatus", "Lcom/lynx/tasm/service/ILynxLogService$LogOutputChannelType;", "logOutputChannel", "Lcom/lynx/tasm/service/ILynxLogService$LogOutputChannelType;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "LynxLogService_release"}, k = 1, mv = {1, 6, 0})
public final class LynxLogService implements ILynxLogService {
    public static final a Companion = null;
    private static final Lazy<LynxLogService> INSTANCE$delegate = null;
    private ILynxLogService.LogOutputChannelType logOutputChannel;

    public static final class a {
        public a() {
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Override // com.lynx.tasm.service.ILynxLogService, com.lynx.tasm.service.IServiceProvider
    public final /* synthetic */ Class getServiceClass() {
        return ILynxLogService.CC.$default$getServiceClass(this);
    }

    @Override // com.lynx.tasm.service.ILynxLogService
    public void logByPlatform(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r102, "msg");
    }

    @Override // com.lynx.tasm.service.IServiceProvider
    public final /* synthetic */ void onInitialize(Context r100) {
        IServiceProvider.CC.$default$onInitialize(this, r100);
    }

    static {
        Companion = new a();
        INSTANCE$delegate = LazyKt.lazy(LynxLogService$Companion$INSTANCE$2.INSTANCE);
    }

    @Override // com.lynx.tasm.service.ILynxLogService
    public long getDefaultWriteFunction() {
        return getALogNativeFunctionAddress("getALogSimpleWriteFuncAddr");
    }

    @Override // com.lynx.tasm.service.ILynxLogService
    public boolean getLogToSystemStatus() {
        Class r100 = INVOKESTATIC_com_bytedance_lynx_service_log_LynxLogService_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.ss.android.agilelogger.ALog");     // Catch: NoSuchMethodException -> L4 IllegalAccessException -> L6 ClassNotFoundException -> L8
        Field r101 = r100.getDeclaredField("sDebug");     // Catch: NoSuchMethodException -> L4 IllegalAccessException -> L6 ClassNotFoundException -> L8
        r101.setAccessible(true);     // Catch: NoSuchMethodException -> L4 IllegalAccessException -> L6 ClassNotFoundException -> L8
        return r101.getBoolean(r100);
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    L4:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // com.lynx.tasm.service.ILynxLogService
    public boolean isLogOutputByPlatform() {
        if (this.logOutputChannel != ILynxLogService.LogOutputChannelType.Platform) goto L5;
        return true;
    L5:
        return false;
    }

    public LynxLogService() {
        this.logOutputChannel = ILynxLogService.LogOutputChannelType.Native;
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$delegate$cp() {
        return INSTANCE$delegate;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_lynx_service_log_LynxLogService_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    private final long getALogNativeFunctionAddress(String r100) {
        Method r101 = INVOKESTATIC_com_bytedance_lynx_service_log_LynxLogService_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.ss.android.agilelogger.ALog").getDeclaredMethod(r100, new Class[0]);     // Catch: Exception -> L7
        r101.setAccessible(true);     // Catch: Exception -> L7
        Object r102 = r101.invoke(null, new Object[0]);     // Catch: Exception -> L7
        if (r102 == null) goto L6;
        return ((Long) r102).longValue();
    L6:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");     // Catch: Exception -> L7
    L7:
        e = move-exception;
        StringBuilder r103 = new StringBuilder("The ALog ");
        r103.append(r100);
        r103.append(" function was not successfully retrieved [ ");
        r103.append(e.getMessage());
        return 0;
    }

    @Override // com.lynx.tasm.service.ILynxLogService
    public void switchLogToSystem(boolean r100) {
        INVOKESTATIC_com_bytedance_lynx_service_log_LynxLogService_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.ss.android.agilelogger.ALog").getMethod("setDebug", new Class[]{Boolean.TYPE}).invoke(null, new Object[]{Boolean.valueOf(r100)});     // Catch: InvocationTargetException -> L4 NoSuchMethodException -> L6 IllegalAccessException -> L8 ClassNotFoundException -> L10
    L18:
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
