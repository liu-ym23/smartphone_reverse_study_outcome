package com.obric.cae.libs.smartnetwork;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.cae.libs.statusreport.CaeStatusReportManager;
import com.obric.cae.libs.utils.LogUtil;
import com.obric.cae.libs.wifi.ICaeSmartNetworkManager;
import com.obric.cae.libs.wifi.ICaeWifiLinkThroughputListener;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes33.dex */
public class CaeSmartNetworkManager {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static CaeSmartNetworkManager f395915c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ICaeSmartNetworkManager f395916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f395917b;

    public interface CaeWifiLinkThroughputListener {
        void onSecondaryThroughputReported(int r100, int r101);

        void onThroughputReported(int r100, int r101);
    }

    public class CaeWifiLinkThroughputListenerProxy extends ICaeWifiLinkThroughputListener.Stub {
        private final CaeWifiLinkThroughputListener mListener;
        final /* synthetic */ CaeSmartNetworkManager this$0;

        public CaeWifiLinkThroughputListener getListener() {
            return this.mListener;
        }

        public CaeWifiLinkThroughputListenerProxy(CaeSmartNetworkManager r100, CaeWifiLinkThroughputListener r101) {
            this.this$0 = r100;
            this.mListener = r101;
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiLinkThroughputListener
        public void onSecondaryThroughputReported(int r100, int r101) {
            CaeWifiLinkThroughputListener r102 = this.mListener;
            if (r102 == null) goto L6;
            r102.onSecondaryThroughputReported(r100, r101);
            return;
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiLinkThroughputListener
        public void onThroughputReported(int r100, int r101) {
            CaeWifiLinkThroughputListener r102 = this.mListener;
            if (r102 == null) goto L6;
            r102.onThroughputReported(r100, r101);
            return;
        }
    }

    public class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CaeSmartNetworkManager f395918a;

        public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
            return Class.forName(r100);
        }

        public final void com_obric_cae_libs_smartnetwork_CaeSmartNetworkManager$a__run$___twin___() {
            int r100 = 0;
        L4:
            if (r100 >= 50) goto L30;
            SystemClock.sleep(100);
            this.f395918a.f395916a = ICaeSmartNetworkManager.Stub.asInterface((IBinder) INVOKESTATIC_com_obric_cae_libs_smartnetwork_CaeSmartNetworkManager$a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"cae_wifi"}));     // Catch: Exception -> L8
        L10:
            CaeSmartNetworkManager r101 = this.f395918a;
            if (r101.f395916a != null) goto L12;
            r100 = r100 + 1;
            goto L4
        L12:
            r101.a();
            CaeSmartNetworkManager r102 = this.f395918a;
            HashMap r103 = r102.f395917b;
            if (r103 != null) goto L15;
            return;
        L15:
            if (r103.size() <= 0) goto L64;
            Iterator r104 = r102.f395917b.keySet().iterator();
        L18:
            if (r104.hasNext() == false) goto L66;
            CaeWifiLinkThroughputListenerProxy r105 = (CaeWifiLinkThroughputListenerProxy) r102.f395917b.get((Integer) r104.next());
            if (r105 == null) goto L18;
            ICaeSmartNetworkManager r106 = r102.f395916a;
            if (r106 == null) goto L24;
            r106.registerLinkThroughputListener(r105);     // Catch: RemoteException -> L27
        L27:
            LogUtil.e("CaeSmartNetworkManager", "RemoteException !!!");
            goto L18
        L24:
            LogUtil.e("CaeSmartNetworkManager", "autoRegisterListenerOnRetryBindSuccess, mISmartNetworkMgr is null");
            return;
        L66:
            return;
        L64:
            return;
        L8:
            e = move-exception;
            LogUtil.e("CaeSmartNetworkManager", "Get service failed: " + e);
            goto L10
        L30:
            LogUtil.e("CaeSmartNetworkManager", "get smart network service error!!!");
            CaeSmartNetworkManager r107 = this.f395918a;
            HashMap r108 = r107.f395917b;
            if (r108 != null) goto L33;
            return;
        L33:
            if (r108.size() <= 0) goto L67;
            Iterator r109 = r107.f395917b.keySet().iterator();
        L36:
            if (r109.hasNext() == false) goto L68;
            Integer r110 = (Integer) r109.next();
            CaeWifiLinkThroughputListenerProxy r111 = (CaeWifiLinkThroughputListenerProxy) r107.f395917b.get(r110);
            if (r111 == null) goto L36;
            if (r111.getListener() == null) goto L36;
            r111.getListener().onThroughputReported(0, 0);
            r111.getListener().onSecondaryThroughputReported(0, 0);
            r107.f395917b.remove(r110);
            goto L36
        L68:
            return;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            com_obric_cae_libs_smartnetwork_CaeSmartNetworkManager$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public a(CaeSmartNetworkManager r100) {
            this.f395918a = r100;
            super("CaeSmartNetworkManager$a");
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_com_obric_cae_libs_smartnetwork_CaeSmartNetworkManager$a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_obric_cae_libs_smartnetwork_CaeSmartNetworkManager$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_obric_cae_libs_smartnetwork_CaeSmartNetworkManager$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public class b implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CaeSmartNetworkManager f395919a;

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            LogUtil.e("CaeSmartNetworkManager", "statusReport service is dead!");
            CaeSmartNetworkManager r100 = this.f395919a;
            r100.f395916a = null;
            r100.retryGetServiceThread();
        }

        public b(CaeSmartNetworkManager r100) {
            this.f395919a = r100;
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public final void a() {
        this.f395916a.asBinder().linkToDeath(new b(this), 0);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("CaeStatusReportManager linkToDeath! :", e, "CaeSmartNetworkManager");
    }

    public int getLinkThroughput() {
        ICaeSmartNetworkManager r100 = this.f395916a;
        if (r100 != null) goto L11;
        LogUtil.e("CaeSmartNetworkManager", "getLinkThroughput, mISmartNetworkMgr is null");
        return 0;
    L11:
        return r100.getLinkThroughput();
    L8:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("getLinkThroughput failed: ", e, "CaeSmartNetworkManager");
        return 0;
    }

    public void retryGetServiceThread() {
        ThreadMethodProxy.start(new a(this));
    }

    public CaeSmartNetworkManager(Context r100) {
        this.f395917b = new HashMap();
        this.f395916a = ICaeSmartNetworkManager.Stub.asInterface((IBinder) INVOKESTATIC_com_obric_cae_libs_smartnetwork_CaeSmartNetworkManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"cae_wifi"}));     // Catch: Exception -> L5
    L8:
        if (this.f395916a == null) goto L10;
        a();
        return;
    L10:
        retryGetServiceThread();
        return;
    L5:
        e = move-exception;
        LogUtil.e("CaeSmartNetworkManager", "Get service failed: " + e);
        goto L8
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_obric_cae_libs_smartnetwork_CaeSmartNetworkManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static CaeSmartNetworkManager getInstance(Context r100) {
        if (r100 == null) goto L15;
        monitor-enter(CaeStatusReportManager.class);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (f395915c != null) goto L8;
        f395915c = new CaeSmartNetworkManager(r100);     // Catch: Throwable -> L11
    L8:
        monitor-exit(CaeStatusReportManager.class);     // Catch: Throwable -> L11
        return f395915c;
    L15:
        throw new IllegalArgumentException("context cannot be null");
    }

    public void registerLinkThroughputListener(CaeWifiLinkThroughputListener r100) {
        if (this.f395916a != null) goto L6;
        LogUtil.e("CaeSmartNetworkManager", "registerLinkThroughputListener, mISmartNetworkMgr is null");
        return;
    L6:
        CaeWifiLinkThroughputListenerProxy r101 = new CaeWifiLinkThroughputListenerProxy(this, r100);
        this.f395917b.put(Integer.valueOf(r101.hashCode()), r101);
        this.f395916a.registerLinkThroughputListener(r101);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("registerLinkThroughputListener failed: ", e, "CaeSmartNetworkManager");
    }

    public void unregisterLinkThroughputListener(CaeWifiLinkThroughputListener r100) {
        if (this.f395916a != null) goto L6;
        LogUtil.e("CaeSmartNetworkManager", "unregisterLinkThroughputListener, mISmartNetworkMgr is null");
        return;
    L6:
        CaeWifiLinkThroughputListenerProxy r101 = (CaeWifiLinkThroughputListenerProxy) this.f395917b.get(Integer.valueOf(r100.hashCode()));
        if (r101 != null) goto L15;
        LogUtil.e("CaeSmartNetworkManager", "unregisterLinkThroughputListener failed: proxy is null");
        return;
    L15:
        this.f395916a.unregisterLinkThroughputListener(r101);     // Catch: RemoteException -> L12
        return;
    L12:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("unregisterLinkThroughputListener failed: ", e, "CaeSmartNetworkManager");
    }
}
