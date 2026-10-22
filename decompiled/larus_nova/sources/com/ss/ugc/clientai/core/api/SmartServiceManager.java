package com.ss.ugc.clientai.core.api;

import alc.d;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 \u001f2\u00020\u0001:\u0002 !B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ$\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u001a\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R&\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u00168\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR6\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00060\u00168\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001a¨\u0006\""}, d2 = {"Lcom/ss/ugc/clientai/core/api/SmartServiceManager;", "", "", "type", "Ljava/util/ArrayList;", "Lalc/b;", "Lkotlin/collections/ArrayList;", "getEventTypeListener", "serviceName", "Lcom/ss/ugc/clientai/core/api/SmartService;", "getService", "getCommonService", "service", "", "addSmartService", "removeSmartService", "listener", "addCommonEventListener", "removeCommonEventListener", "Lalc/d;", "params", "onNotifyCommonEvent", "Ljava/util/concurrent/ConcurrentHashMap;", PromotionProductPrivilegesStruct.SERVICES, "Ljava/util/concurrent/ConcurrentHashMap;", "getServices", "()Ljava/util/concurrent/ConcurrentHashMap;", "commonEventListeners", "getCommonEventListeners", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "core-api_release"}, k = 1, mv = {1, 4, 1})
public class SmartServiceManager {
    public static final a Companion = null;
    private final ConcurrentHashMap<String, ArrayList<alc.b>> commonEventListeners;
    private final ConcurrentHashMap<String, SmartService> services;

    public static final class a {

        /* JADX INFO: renamed from: com.ss.ugc.clientai.core.api.SmartServiceManager$a$a, reason: collision with other inner class name */
        public static final class C5467a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final SmartServiceManager f457147a = null;

            static {
                f457147a = new SmartServiceManager();
            }
        }

        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f457148a = 0;

        static {
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f457149a;

        public c(ArrayList r100, String r101, d r102) {
            this.f457149a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator r100 = this.f457149a.iterator();     // Catch: Throwable -> L7
        L4:
            if (r100.hasNext() == false) goto L16;
            ((alc.b) r100.next()).a();     // Catch: Throwable -> L7
            goto L4
        L16:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    static {
        Companion = new a();
    }

    @JvmStatic
    public static final SmartServiceManager instance() {
        Companion.getClass();
        int r100 = b.f457148a;
        return a.C5467a.f457147a;
    }

    public SmartServiceManager() {
        this.services = new ConcurrentHashMap();
        this.commonEventListeners = new ConcurrentHashMap();
    }

    public final ConcurrentHashMap<String, ArrayList<alc.b>> getCommonEventListeners() {
        return this.commonEventListeners;
    }

    public final ConcurrentHashMap<String, SmartService> getServices() {
        return this.services;
    }

    private final ArrayList<alc.b> getEventTypeListener(String r100) {
        ArrayList<alc.b> r101 = this.commonEventListeners.get(r100);
        if (r101 != null) goto L5;
        return null;
    L5:
        if ((!r101.isEmpty()) == false) goto L18;
        ArrayList<alc.b> r102 = new ArrayList();
        monitor-enter(r101);
        r102.addAll(r101);     // Catch: Throwable -> L11
        monitor-exit(r101);
        return r102;
    L11:
        th = move-exception;
        throw th;
    L18:
        return null;
    }

    public SmartService getCommonService(String r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        return null;
    }

    public SmartService getService(String r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        return this.services.get(r100);
    }

    public void removeSmartService(String r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        this.services.remove(r100);
    }

    public void addCommonEventListener(String r100, alc.b r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "listener");
        Objects.toString(r101);
        if (this.commonEventListeners.get(r100) != null) goto L5;
        this.commonEventListeners.put(r100, new ArrayList());
    L5:
        ArrayList<alc.b> r102 = this.commonEventListeners.get(r100);
        if (r102 == null) goto L17;
        monitor-enter(r102);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (r102.contains(r101) == true) goto L11;
        r102.add(r101);     // Catch: Throwable -> L14
    L11:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r102);
        return;
    }

    public void addSmartService(String r100, SmartService r101) {
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        Intrinsics.checkNotNullParameter(r101, "service");
        Objects.toString(r101);
        this.services.put(r100, r101);
    }

    public void onNotifyCommonEvent(String r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        ArrayList<alc.b> r102 = getEventTypeListener(r100);
        if (r102 == null) goto L6;
        c r103 = new c(r102, r100, r101);
        int r104 = alc.a.f4218a;
        Intrinsics.checkNotNullParameter(r103, "runnable");
        int r105 = alc.a.C0084a.f4219a;
        int r106 = alc.a.C0084a.C0085a.b.f4221a;
        alc.a.C0084a.C0085a.C0086a.f4220a.getClass();
        return;
    }

    public void removeCommonEventListener(String r100, alc.b r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "listener");
        Objects.toString(r101);
        ArrayList<alc.b> r102 = this.commonEventListeners.get(r100);
        if (r102 == null) goto L11;
        monitor-enter(r102);
        r102.remove(r101);     // Catch: Throwable -> L8
        monitor-exit(r102);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
