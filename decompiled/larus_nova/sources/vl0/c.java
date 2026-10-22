package vl0;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.browser.d0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f555614a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f555615b = null;

    public c() {
    }

    static {
        f555615b = new c();
        Object r100 = a().newInstance();     // Catch: Throwable -> L8
        if ((r100 instanceof a) == true) goto L6;
        r100 = null;
    L6:
        f555614a = (a) r100;     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        ALogger.e("SaaSInstanceUtil", th);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.android.live.utils.SaaSInstanceCallStub");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.android.live.utils.SaaSInstanceCallStub");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.android.live.utils.SaaSInstanceCallStub");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.android.live.utils.SaaSInstanceCallStub");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.android.live.utils.SaaSInstanceCallStub");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.android.live.utils.SaaSInstanceCallStub");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.android.live.utils.SaaSInstanceCallStub");
    }

    @Override // vl0.a
    public final Fragment createLiveLynxFragment(Bundle r100, d0 r101, b r102) {
        Intrinsics.checkNotNullParameter(r102, "serviceHolder");
        a r103 = f555614a;
        if (r103 != null) goto L7;
        return null;
    L7:
        return r103.createLiveLynxFragment(r100, r101, r102);
    }
}
