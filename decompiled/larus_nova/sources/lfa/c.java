package lfa;

import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.google.gson.Gson;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.assistant.os.libs.NetworkStateInfo;
import com.obric.cae.libs.multipath.ICaeMultipathManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes33.dex */
public final class c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile c f509099g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ICaeMultipathManager f509100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PthreadHandlerThreadV2 f509101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f509102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f509103d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f509104e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Gson f509105f;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.os.ServiceManager");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.os.ServiceManager");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.os.ServiceManager");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.os.ServiceManager");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.os.ServiceManager");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.os.ServiceManager");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.os.ServiceManager");
    }

    public static IBinder d() {
        Object r100 = a().getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"cae_multipath"});     // Catch: Exception -> L7
        if ((r100 instanceof IBinder) == false) goto L9;
        return (IBinder) r100;
    L9:
        return null;
    L7:
        e = move-exception;
        ILogDepend.f384986a.e("CaeMultipathClient", "Failed to get service binder using reflection", e);
        goto L9
    }

    public final NetworkStateInfo c() {
        ILogDepend.Companion r100 = ILogDepend.f384986a;
        r100.i("CaeMultipathClient", "getLatestNetworkTruth");
        r100.i("CaeMultipathClient", "getLatestNetworkTruthStr");
        ICaeMultipathManager r101 = this.f509100a;
        if (r101 == null) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == true) goto L24;
        r100.e("CaeMultipathClient", "Service not connected, triggering background reconnect");
        this.f509102c.sendEmptyMessage(1);
    L13:
        String r103 = null;
    L15:
        if (TextUtils.isEmpty(r103) == false) goto L22;
        return null;
    L22:
        return (NetworkStateInfo) this.f509105f.fromJson(r103, NetworkStateInfo.class);
    L19:
        e = move-exception;
        ILogDepend.f384986a.e("CaeMultipathClient", "getLatestNetworkTruth Error", e);
        return null;
    L24:
        r103 = r101.getLatestNetworkTruth();     // Catch: Exception -> L11
    L11:
        e = move-exception;
        ILogDepend.f384986a.e("CaeMultipathClient", "Failed to get latest network truth", e);
        this.f509100a = null;
        this.f509102c.sendEmptyMessage(1);
        goto L13
    L5:
        r102 = false;
        goto L7
    }

    public c() {
        this.f509103d = false;
        this.f509104e = 0;
        this.f509105f = new Gson();
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("CaeMultipathConnectThread");
        this.f509101b = r100;
        ThreadMethodProxy.start(r100);
        a r101 = new a(this, this.f509101b.getLooper());
        this.f509102c = r101;
        r101.sendEmptyMessage(1);
    }

    public static void b(c r100) {
        if (r100.f509103d == false) goto L5;
        ILogDepend.f384986a.d("CaeMultipathClient", "Already connecting, skipping");
        return;
    L5:
        r100.f509103d = true;
        IBinder r101 = d();     // Catch: Throwable -> L9 Exception -> L11
        if (r101 != null) goto L13;
        ILogDepend.f384986a.e("CaeMultipathClient", "Failed to get cae_multipath service binder");     // Catch: Throwable -> L9 Exception -> L11
        r100.f509102c.sendEmptyMessageDelayed(2, 10000);     // Catch: Throwable -> L9 Exception -> L11
    L24:
        r100.f509103d = false;
        return;
    L13:
        ICaeMultipathManager r102 = ICaeMultipathManager.Stub.asInterface(r101);     // Catch: Throwable -> L9 Exception -> L11
        r100.f509100a = r102;     // Catch: Throwable -> L9 Exception -> L11
        if (r102 != null) goto L30;
        ILogDepend.f384986a.e("CaeMultipathClient", "Failed to create service interface");     // Catch: Throwable -> L9 Exception -> L11
        r100.f509102c.sendEmptyMessageDelayed(2, 10000);     // Catch: Throwable -> L9 Exception -> L11
        goto L24
    L30:
        r101.linkToDeath(new b(r100), 0);     // Catch: Throwable -> L9 Exception -> L11 RemoteException -> L19
    L21:
        ILogDepend.f384986a.d("CaeMultipathClient", "Connected to cae_multipath service");     // Catch: Throwable -> L9 Exception -> L11
    L19:
        e = move-exception;
        ILogDepend.f384986a.e("CaeMultipathClient", "Failed to link to death", e);     // Catch: Throwable -> L9 Exception -> L11
    L11:
        e = move-exception;
        ILogDepend.f384986a.e("CaeMultipathClient", "Failed to connect to cae_multipath service", e);     // Catch: Throwable -> L9
        r100.f509102c.sendEmptyMessageDelayed(2, 10000);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        r100.f509103d = false;
        throw th;
    }
}
