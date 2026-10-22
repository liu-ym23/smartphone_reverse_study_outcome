package com.obric.sva.sdk.ahm;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.sva.sdk.utils.LogUtils;
import el9.a;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/obric/sva/sdk/ahm/FaultTree;", "", "<init>", "()V", "TAG", "", "reportAdspError", "", "code", "", "reportEventInfo", "Ljava/lang/reflect/Method;", "getReportEventInfo", "()Ljava/lang/reflect/Method;", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FaultTree {
    public static final FaultTree INSTANCE = null;
    public static final String TAG = "FaultTree";

    static {
        INSTANCE = new FaultTree();
    }

    private FaultTree() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private final Method getReportEventInfo() {
        Class r100 = INVOKESTATIC_com_obric_sva_sdk_ahm_FaultTree_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.util.EventsUtils");     // Catch: Exception -> L10 Error -> L12
        if (r100 == null) goto L17;
        Method r101 = r100.getMethod("reportEventInfo", new Class[]{Long.TYPE, byte[].class});     // Catch: Exception -> L10 Error -> L12
        if (r101 == null) goto L18;
        r101.setAccessible(true);     // Catch: Exception -> L10 Error -> L12
    L9:
        return r101;
    L18:
        return null;
    L17:
        return null;
    L12:
        e = move-exception;
        LogUtils.e(TAG, "reportEventInfo error " + e, new Object[0]);
    L14:
        return null;
    L10:
        e = move-exception;
        LogUtils.e(TAG, "reportEventInfo exception " + e, new Object[0]);
        goto L14
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_obric_sva_sdk_ahm_FaultTree_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
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

    public final void reportAdspError(int r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        StringBuilder r102 = new StringBuilder("reportAdspError ");     // Catch: Throwable -> L8
        r102.append(r100);     // Catch: Throwable -> L8
        r102.append(" with method ");     // Catch: Throwable -> L8
        FaultTree r103 = INSTANCE;     // Catch: Throwable -> L8
        r102.append(r103.getReportEventInfo());     // Catch: Throwable -> L8
        LogUtils.d(TAG, r102.toString(), new Object[0]);     // Catch: Throwable -> L8
        Method r104 = r103.getReportEventInfo();     // Catch: Throwable -> L8
        Object r105 = null;
        if (r104 == null) goto L6;
        r105 = r104.invoke(null, new Object[]{Integer.valueOf(r100), null});     // Catch: Throwable -> L8
    L6:
        Result.m9449constructorimpl(r105);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
