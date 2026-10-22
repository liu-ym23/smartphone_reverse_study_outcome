package com.obric.memorydata.sdk.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class MemoryDataServiceProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MemoryDataServiceProxy f397297a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile IMemoryDataService f397298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Context f397299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Handler f397300d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f397301e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile int f397302f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final com.obric.memorydata.sdk.service.a f397303g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, a> f397304h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final c f397305i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final b f397306j = null;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/sdk/service/MemoryDataServiceProxy$ServiceProxy;", "Lcom/obric/memorydata/sdk/service/IMemoryDataService;", "service", "<init>", "(Lcom/obric/memorydata/sdk/service/IMemoryDataService;)V", "getService", "()Lcom/obric/memorydata/sdk/service/IMemoryDataService;", "asBinder", "Landroid/os/IBinder;", "queryBinder", "binderCode", "", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ServiceProxy implements IMemoryDataService {
        private final IMemoryDataService service;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.service.asBinder();
        L4:
            return null;
        }

        public final IMemoryDataService getService() {
            return this.service;
        }

        public ServiceProxy(IMemoryDataService r100) {
            Intrinsics.checkNotNullParameter(r100, "service");
            this.service = r100;
        }

        @Override // com.obric.memorydata.sdk.service.IMemoryDataService
        public IBinder queryBinder(int r100) {
            return this.service.queryBinder(r100);
        L4:
            return null;
        }
    }

    public interface a {
        void binderDied();
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final class b implements ServiceConnection {
        public b() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r100) {
            Intrinsics.checkNotNullParameter(r100, "name");
            MemoryDataServiceProxy.f397300d.removeCallbacks(MemoryDataServiceProxy.f397303g);
            MemoryDataServiceProxy.f397298b = null;
            MemoryDataServiceProxy.f397301e = false;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r100, IBinder r101) {
            if (r101 != null) goto L17;
        L5:
            MemoryDataServiceProxy r102 = MemoryDataServiceProxy.f397297a;     // Catch: Throwable -> L11 Exception -> L16
            if (r101 == null) goto L8;
            ServiceProxy r103 = new ServiceProxy(IMemoryDataService.Stub.asInterface(r101));     // Catch: Throwable -> L11 Exception -> L16
        L9:
            MemoryDataServiceProxy.f397298b = r103;     // Catch: Throwable -> L11 Exception -> L16
        L14:
            MemoryDataServiceProxy.f397300d.removeCallbacks(MemoryDataServiceProxy.f397303g);
            MemoryDataServiceProxy.f397301e = false;
            return;
        L11:
            th = move-exception;
            MemoryDataServiceProxy.f397300d.removeCallbacks(MemoryDataServiceProxy.f397303g);
            MemoryDataServiceProxy.f397301e = false;
            throw th;
        L8:
            r103 = null;
            goto L9
        L17:
            r101.linkToDeath(MemoryDataServiceProxy.f397305i, 0);     // Catch: Throwable -> L11 Exception -> L16
            goto L5
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final class c implements IBinder.DeathRecipient {
        public c() {
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            IMemoryDataService r100 = MemoryDataServiceProxy.f397298b;     // Catch: Exception -> L13
            if (r100 == null) goto L7;
            IBinder r101 = r100.asBinder();     // Catch: Exception -> L13
            if (r101 == null) goto L7;
            r101.unlinkToDeath(this, 0);     // Catch: Exception -> L13
        L7:
            pka.b.a(new e());     // Catch: Exception -> L13
            MemoryDataServiceProxy r102 = MemoryDataServiceProxy.f397297a;     // Catch: Exception -> L13
            MemoryDataServiceProxy.f397298b = null;     // Catch: Exception -> L13
            MemoryDataServiceProxy.f397300d.removeCallbacks(MemoryDataServiceProxy.f397303g);     // Catch: Exception -> L13
            MemoryDataServiceProxy.f397301e = false;     // Catch: Exception -> L13
            Iterator r103 = CollectionsKt.toList(MemoryDataServiceProxy.f397304h.values()).iterator();     // Catch: Exception -> L13
        L9:
            if (r103.hasNext() == false) goto L11;
            ((a) r103.next()).binderDied();     // Catch: Exception -> L13
            goto L9
        L11:
            MemoryDataServiceProxy.f397300d.postDelayed(new f(), 5000);     // Catch: Exception -> L13
            return;
        }
    }

    public MemoryDataServiceProxy() {
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.obric.memorydata.sdk.service.a] */
    static {
        f397297a = new MemoryDataServiceProxy();
        f397300d = new Handler(Looper.getMainLooper());
        f397302f = 64;
        f397303g = new com.obric.memorydata.sdk.service.a();
        f397304h = new ConcurrentHashMap();
        f397305i = new c();
        f397306j = new b();
    }

    public final void unbindService() {
        pka.b.a(new com.obric.memorydata.sdk.service.c());
    }

    public final boolean bindService(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return bindService(r100, 64);
    }

    public static boolean a(Context r100, int r101) {
        Context r102 = r100.getApplicationContext();
        f397299c = r102;
        f397302f = r101;
        f397301e = true;
        Handler r103 = f397300d;
        com.obric.memorydata.sdk.service.a r104 = f397303g;
        r103.removeCallbacks(r104);
        r103.postDelayed(r104, 12000);
        Intent r105 = new Intent();
        r105.setAction("com.obric.memorydata.sdk");
        r105.setPackage("com.larus.nova");
        int r106 = r101 | 1;
        boolean r107 = r102.bindService(r105, f397306j, r106);     // Catch: Exception -> L5
    L7:
        if (r107 == true) goto L9;
        f397300d.removeCallbacks(f397303g);
        f397301e = false;
    L9:
        return r107;
    L5:
        r107 = false;
        goto L7
    }

    public final boolean bindService(final Context r100, final int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Boolean r102 = (Boolean) pka.b.a(new com.obric.memorydata.sdk.service.b(r100, r101));
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.booleanValue();
    }
}
