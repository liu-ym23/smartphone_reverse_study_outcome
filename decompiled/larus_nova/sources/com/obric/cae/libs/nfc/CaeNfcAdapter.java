package com.obric.cae.libs.nfc;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.cae.libs.utils.LogUtil;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes33.dex */
public class CaeNfcAdapter {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f395899d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Method f395900e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static CaeNfcAdapter f395901f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile ICaeNfcAdapter f395902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile CaeNfcOmapiExecutor f395903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile CaeNfcEventManager f395904c;

    public class a implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CaeNfcAdapter f395905a;

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            LogUtil.e("NFC:CaeNfcAdapter", "cae_nfc service is dead!");
            this.f395905a.f395902a = null;
            this.f395905a.f395903b = null;
            this.f395905a.f395904c = null;
            this.f395905a.c();
        }

        public a(CaeNfcAdapter r100) {
            this.f395905a = r100;
        }
    }

    public static /* synthetic */ void a(CaeNfcAdapter r100) {
        r100.b();
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private /* synthetic */ void b() {
        int r100 = 0;
    L4:
        if (r100 >= 10) goto L12;
        this.f395902a = ICaeNfcAdapter.Stub.asInterface(a());     // Catch: Exception -> L9
        if (this.f395902a == null) goto L11;
        d();     // Catch: Exception -> L9
        LogUtil.d("NFC:CaeNfcAdapter", "Get service success after retry");     // Catch: Exception -> L9
        return;
    L11:
        r100 = r100 + 1;
        SystemClock.sleep(300);
    L9:
        e = move-exception;
        LogUtil.e("NFC:CaeNfcAdapter", "Retry get service failed: " + e);
        goto L11
    L12:
        LogUtil.e("NFC:CaeNfcAdapter", "Retry get service failed after 10 times");
    }

    static {
        f395899d = new Object();
    }

    public static IBinder a() throws Exception {
        Object r100 = f395899d;
        monitor-enter(r100);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (f395900e != null) goto L7;
        f395900e = INVOKESTATIC_com_obric_cae_libs_nfc_CaeNfcAdapter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class});     // Catch: Throwable -> L15
    L7:
        Method r101 = f395900e;     // Catch: Throwable -> L15
        monitor-exit(r100);     // Catch: Throwable -> L15
        return (IBinder) r101.invoke(null, new Object[]{CaeNfcConstants.SERVICE_NAME_NFC});
    L12:
        e = move-exception;
        LogUtil.e("NFC:CaeNfcAdapter", "getService denied: " + e);
        return null;
    }

    public final void c() {
        ThreadMethodProxy.start(new PthreadThreadV2(new com.obric.cae.libs.nfc.a(this), "CaeNfcAdapter"));
    }

    public final void d() {
        this.f395902a.asBinder().linkToDeath(new a(this), 0);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("linkToDeath failed: ", e, "NFC:CaeNfcAdapter");
    }

    public CaeNfcEventManager getEventManager() {
        if (this.f395904c == null) goto L7;
        return this.f395904c;
    L7:
        if (this.f395902a == null) goto L28;
    L27:
        ICaeNfcEventManager r100 = this.f395902a.getEventManager();     // Catch: RemoteException -> L24
        if (r100 != null) goto L22;
        LogUtil.e("NFC:CaeNfcAdapter", "getEventManager: service is null");     // Catch: RemoteException -> L24
        return null;
    L22:
        this.f395904c = new CaeNfcEventManager(r100);     // Catch: RemoteException -> L24
        return this.f395904c;
    L24:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcAdapter");
        return null;
    L28:
        this.f395902a = ICaeNfcAdapter.Stub.asInterface(a());     // Catch: Exception -> L12
        if (this.f395902a == null) goto L14;
        d();     // Catch: Exception -> L12
        boolean r101 = true;
    L15:
        if (r101 == true) goto L27;
        LogUtil.e("NFC:CaeNfcAdapter", "getEventManager: mICaeNfcAdapter is null");
        return null;
    L14:
        c();
        r101 = false;
    L12:
        e = move-exception;
        LogUtil.e("NFC:CaeNfcAdapter", "ensureService failed: " + e);
        goto L14
    }

    public CaeNfcOmapiExecutor getOmapiExecutor() {
        if (this.f395903b == null) goto L7;
        return this.f395903b;
    L7:
        if (this.f395902a == null) goto L28;
    L27:
        ICaeNfcOmapiExecutor r100 = this.f395902a.getOmapiExecutor();     // Catch: RemoteException -> L24
        if (r100 != null) goto L22;
        LogUtil.e("NFC:CaeNfcAdapter", "getOmapiExecutor: service is null");     // Catch: RemoteException -> L24
        return null;
    L22:
        this.f395903b = new CaeNfcOmapiExecutor(r100);     // Catch: RemoteException -> L24
        return this.f395903b;
    L24:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcAdapter");
        return null;
    L28:
        this.f395902a = ICaeNfcAdapter.Stub.asInterface(a());     // Catch: Exception -> L12
        if (this.f395902a == null) goto L14;
        d();     // Catch: Exception -> L12
        boolean r101 = true;
    L15:
        if (r101 == true) goto L27;
        LogUtil.e("NFC:CaeNfcAdapter", "getOmapiExecutor: mICaeNfcAdapter is null");
        return null;
    L14:
        c();
        r101 = false;
    L12:
        e = move-exception;
        LogUtil.e("NFC:CaeNfcAdapter", "ensureService failed: " + e);
        goto L14
    }

    public CaeNfcAdapter(Context r100) {
        r100.getApplicationContext();
        this.f395902a = ICaeNfcAdapter.Stub.asInterface(a());     // Catch: Exception -> L5
    L8:
        if (this.f395902a == null) goto L10;
        d();
        return;
    L10:
        c();
        return;
    L5:
        e = move-exception;
        LogUtil.e("NFC:CaeNfcAdapter", "Get service failed: " + e);
        goto L8
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_obric_cae_libs_nfc_CaeNfcAdapter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static CaeNfcAdapter getDefaultAdapter(Context r100) {
        if (r100 == null) goto L15;
        monitor-enter(CaeNfcAdapter.class);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (f395901f != null) goto L8;
        f395901f = new CaeNfcAdapter(r100);     // Catch: Throwable -> L11
    L8:
        monitor-exit(CaeNfcAdapter.class);     // Catch: Throwable -> L11
        return f395901f;
    L15:
        throw new IllegalArgumentException("context cannot be null");
    }
}
