package com.obric.cae.libs.statusreport;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.cae.libs.utils.CaelibUtils;
import com.obric.cae.libs.utils.LogUtil;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes33.dex */
public class CaeStatusReportManager {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static CaeStatusReportManager f395920d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ICaeStatusReportManager f395921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f395922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f395923c;

    public interface LinkLayerQualityChangedListener {
        void onAverLinkLayerLevelChanged(LinkLayerQuality r100);

        void onLinkLayerLevelChanged(LinkLayerQuality r100);

        void onLinkLayerQualityChanged(LinkLayerQuality r100);
    }

    public class LinkLayerQualityChangedListenerProxy extends ILinkLayerQualityListener.Stub {
        private final LinkLayerQualityChangedListener mListener;
        final /* synthetic */ CaeStatusReportManager this$0;

        public LinkLayerQualityChangedListener getListener() {
            return this.mListener;
        }

        @Override // com.obric.cae.libs.statusreport.ILinkLayerQualityListener
        public void onAverLinkLayerLevelChanged(LinkLayerQuality r100) {
            this.mListener.onAverLinkLayerLevelChanged(r100);
        }

        @Override // com.obric.cae.libs.statusreport.ILinkLayerQualityListener
        public void onLinkLayerLevelChanged(LinkLayerQuality r100) {
            this.mListener.onLinkLayerLevelChanged(r100);
        }

        @Override // com.obric.cae.libs.statusreport.ILinkLayerQualityListener
        public void onLinkLayerQualityChanged(LinkLayerQuality r100) {
            this.mListener.onLinkLayerQualityChanged(r100);
        }

        public LinkLayerQualityChangedListenerProxy(CaeStatusReportManager r100, LinkLayerQualityChangedListener r101) {
            this.this$0 = r100;
            this.mListener = r101;
        }
    }

    public class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CaeStatusReportManager f395924a;

        public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
            return Class.forName(r100);
        }

        public final void com_obric_cae_libs_statusreport_CaeStatusReportManager$a__run$___twin___() {
            int r100 = 0;
        L4:
            if (r100 >= 50) goto L30;
            SystemClock.sleep(100);
            this.f395924a.f395921a = ICaeStatusReportManager.Stub.asInterface((IBinder) INVOKESTATIC_com_obric_cae_libs_statusreport_CaeStatusReportManager$a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"cae_status_report"}));     // Catch: Exception -> L8
        L10:
            CaeStatusReportManager r101 = this.f395924a;
            if (r101.f395921a != null) goto L12;
            r100 = r100 + 1;
            goto L4
        L12:
            r101.a();
            CaeStatusReportManager r102 = this.f395924a;
            HashMap r103 = r102.f395923c;
            if (r103 != null) goto L15;
            return;
        L15:
            if (r103.size() <= 0) goto L64;
            Iterator r104 = r102.f395923c.keySet().iterator();
        L18:
            if (r104.hasNext() == false) goto L66;
            LinkLayerQualityChangedListenerProxy r105 = (LinkLayerQualityChangedListenerProxy) r102.f395923c.get((Integer) r104.next());
            if (r105 == null) goto L18;
            ICaeStatusReportManager r106 = r102.f395921a;
            if (r106 == null) goto L24;
            r106.registerLinkLayerQualityChangedListener(CaelibUtils.getCallingPackageName(r102.f395922b), r105);     // Catch: RemoteException -> L27
        L27:
            LogUtil.e("CaeStatusReportManager", "RemoteException !!!");
            goto L18
        L24:
            LogUtil.e("CaeStatusReportManager", "autoRegisterListenerOnRetryBindSuccess, mIStatusReportMgr is null");
            return;
        L66:
            return;
        L64:
            return;
        L8:
            e = move-exception;
            LogUtil.e("CaeStatusReportManager", "Get service failed: " + e);
            goto L10
        L30:
            LogUtil.e("CaeStatusReportManager", "get status report service error!!!");
            CaeStatusReportManager r107 = this.f395924a;
            HashMap r108 = r107.f395923c;
            if (r108 != null) goto L33;
            return;
        L33:
            if (r108.size() <= 0) goto L67;
            Iterator r109 = r107.f395923c.keySet().iterator();
        L36:
            if (r109.hasNext() == false) goto L68;
            Integer r110 = (Integer) r109.next();
            LinkLayerQualityChangedListenerProxy r111 = (LinkLayerQualityChangedListenerProxy) r107.f395923c.get(r110);
            if (r111 == null) goto L36;
            if (r111.getListener() == null) goto L36;
            r111.getListener().onLinkLayerQualityChanged(null);
            r111.getListener().onLinkLayerLevelChanged(null);
            r111.getListener().onAverLinkLayerLevelChanged(null);
            r107.f395923c.remove(r110);
            goto L36
        L68:
            return;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            com_obric_cae_libs_statusreport_CaeStatusReportManager$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public a(CaeStatusReportManager r100) {
            this.f395924a = r100;
            super("CaeStatusReportManager$a");
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_com_obric_cae_libs_statusreport_CaeStatusReportManager$a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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
        public static void com_obric_cae_libs_statusreport_CaeStatusReportManager$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_obric_cae_libs_statusreport_CaeStatusReportManager$a__run$___twin___();     // Catch: Throwable -> L4
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
        public final /* synthetic */ CaeStatusReportManager f395925a;

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            LogUtil.e("CaeStatusReportManager", "statusReport service is dead!");
            CaeStatusReportManager r100 = this.f395925a;
            r100.f395921a = null;
            r100.retryGetServiceThread();
        }

        public b(CaeStatusReportManager r100) {
            this.f395925a = r100;
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public final void a() {
        this.f395921a.asBinder().linkToDeath(new b(this), 0);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("CaeStatusReportManager linkToDeath! :", e, "CaeStatusReportManager");
    }

    public String getCaeVersion() {
        ICaeStatusReportManager r100 = this.f395921a;
        if (r100 != null) goto L11;
        LogUtil.e("CaeStatusReportManager", "getCaeVersion, mIStatusReportMgr is null");
        return null;
    L11:
        return r100.getCaeVersion();
    L8:
        e = move-exception;
        LogUtil.e("CaeStatusReportManager", "getCaeVersion fail, e=" + e);
        return null;
    }

    public LinkLayerQuality getLinkLayerQuality() {
        ICaeStatusReportManager r100 = this.f395921a;
        if (r100 != null) goto L11;
        LogUtil.e("CaeStatusReportManager", "getLinkLayerQuality, mIStatusReportMgr is null");
        return null;
    L11:
        return r100.getLinkLayerQuality(CaelibUtils.getCallingPackageName(this.f395922b));
    L8:
        e = move-exception;
        LogUtil.e("CaeStatusReportManager", "getLinkLayerQuality fail, e=" + e);
        return null;
    }

    public void retryGetServiceThread() {
        ThreadMethodProxy.start(new a(this));
    }

    public CaeStatusReportManager(Context r100) {
        this.f395923c = new HashMap();
        this.f395922b = r100;
        this.f395921a = ICaeStatusReportManager.Stub.asInterface((IBinder) INVOKESTATIC_com_obric_cae_libs_statusreport_CaeStatusReportManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"cae_status_report"}));     // Catch: Exception -> L5
    L8:
        if (this.f395921a == null) goto L10;
        a();
        return;
    L10:
        retryGetServiceThread();
        return;
    L5:
        e = move-exception;
        LogUtil.e("CaeStatusReportManager", "Get service failed: " + e);
        goto L8
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_obric_cae_libs_statusreport_CaeStatusReportManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static CaeStatusReportManager getInstance(Context r100) {
        if (r100 == null) goto L15;
        monitor-enter(CaeStatusReportManager.class);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (f395920d != null) goto L8;
        f395920d = new CaeStatusReportManager(r100);     // Catch: Throwable -> L11
    L8:
        monitor-exit(CaeStatusReportManager.class);     // Catch: Throwable -> L11
        return f395920d;
    L15:
        throw new IllegalArgumentException("context cannot be null");
    }

    public boolean registerLinkLayerQualityChangedListener(LinkLayerQualityChangedListener r100) {
        if (this.f395921a != null) goto L6;
        LogUtil.e("CaeStatusReportManager", "registerLinkLayerQualityChangedListener, mIStatusReportMgr is null");
        return false;
    L6:
        if (r100 == null) goto L18;
        if (this.f395923c.containsKey(Integer.valueOf(r100.hashCode())) == false) goto L19;
        return false;
    L19:
        LinkLayerQualityChangedListenerProxy r101 = new LinkLayerQualityChangedListenerProxy(this, r100);     // Catch: RemoteException -> L15
        if (this.f395921a.registerLinkLayerQualityChangedListener(CaelibUtils.getCallingPackageName(this.f395922b), r101) == false) goto L21;
        this.f395923c.put(Integer.valueOf(r100.hashCode()), r101);     // Catch: RemoteException -> L15
        return true;
    L21:
        return true;
    L15:
        LogUtil.e("CaeStatusReportManager", "RemoteException !!!");
        return false;
    L18:
        throw new IllegalArgumentException("callback cannot be null");
    }

    public boolean unregisterLinkLayerQualityChangedListener(LinkLayerQualityChangedListener r100) {
        if (r100 != null) goto L5;
    L17:
        LogUtil.e("CaeStatusReportManager", "unregisterLinkLayerQualityChangedListener, listener:" + r100 + ", mStatusReportManager:" + this.f395921a + ", mLinkLayerListenerMap:" + this.f395923c);
        return false;
    L5:
        if (this.f395921a == null) goto L17;
        if (this.f395923c == null) goto L17;
        int r101 = r100.hashCode();     // Catch: RemoteException -> L14
        if (this.f395923c.containsKey(Integer.valueOf(r101)) == true) goto L12;
        return false;
    L12:
        return this.f395921a.unregisterLinkLayerQualityChangedListener(CaelibUtils.getCallingPackageName(this.f395922b), (LinkLayerQualityChangedListenerProxy) this.f395923c.remove(Integer.valueOf(r101)));
    L14:
        e = move-exception;
        LogUtil.e("CaeStatusReportManager", "RemoteException, ", e);
        return false;
    }
}
