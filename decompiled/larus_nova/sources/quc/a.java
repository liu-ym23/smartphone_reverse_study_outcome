package quc;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import com.bytedance.android.livehostapi.foundation.depend.pluginstrategy.SaaSLiveResourceStrategy;
import com.lynx.canvas.KryptonPluginLoaderService;
import com.monitor.cloudmessage.consts.CloudControlInf;
import jc1.k;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class a extends KryptonPluginLoaderService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f534859a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f534860b = null;

    static {
        f534860b = new a();
        f534859a = "LynxSoLibLoader";
    }

    public a() {
    }

    public static String a(String r100) {
        IHostPlugin r101 = (IHostPlugin) k.f(IHostPlugin.class);
        if (r101 == null) goto L6;
        String r102 = r101.getHostPackageName();
        if (r102 == null) goto L6;
    L8:
        if (ArraysKt.contains(SaaSLiveResourceStrategy.getLoadHostLibraryList(), r100) == true) goto L12;
        return null;
    L12:
        return r102;
    L6:
        r102 = "";
        goto L8
    }

    @Override // com.lynx.canvas.KryptonPluginLoaderService
    public final ClassLoader getClassLoader(String r100) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.PLUGIN);
        return a.class.getClassLoader();
    }

    @Override // com.lynx.canvas.KryptonPluginLoaderService
    public final String getPluginPath(String r100) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.PLUGIN);
        String r101 = a(r100);
        String r102 = "";
        if (r101 != null) goto L5;
        return "";
    L5:
        IHostPlugin r103 = (IHostPlugin) k.f(IHostPlugin.class);
        if (r103 == null) goto L11;
        String r104 = r103.getNativeLibraryDir(r101);
        if (r104 == null) goto L11;
        r102 = r104;
    L11:
        ALogger.e(f534859a, "getPluginPath plugin " + r100 + " nativeLibraryDir:" + r102);
        return r102;
    }

    @Override // com.lynx.canvas.KryptonPluginLoaderService
    public final boolean loadPluginSync(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        ALogger.e(f534859a, "loadPluginSync name " + r100);
        if (a(r100) != null) goto L7;
        return true;
    L7:
        return ((Boolean) SaaSLiveResourceStrategy.loadHostLibrary(s1.getContext(), r100, getClassLoader(r100)).first).booleanValue();
    }

    @Override // com.lynx.canvas.KryptonPluginLoaderService
    public final void loadPluginAsync(String r100, KryptonPluginLoaderService.Callback r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        ALogger.e(f534859a, "loadPluginAsync name " + r100);
        if (r101 == null) goto L6;
        r101.onFinish(loadPluginSync(r100), "loadPluginSync");
        return;
    }
}
