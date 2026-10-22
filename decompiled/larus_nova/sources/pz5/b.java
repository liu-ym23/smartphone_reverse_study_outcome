package pz5;

import com.bytedance.helios.api.config.ApiStatistics;
import com.bytedance.helios.sdk.appops.AppOpsHandler;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f531113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Throwable f531114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f531115c;

    public b(String r100, Throwable r101, int r102) {
        this.f531113a = r100;
        this.f531114b = r101;
        this.f531115c = r102;
    }

    public final void a() {
        Set<String> r100 = AppOpsHandler.f245487a;
        AppOpsHandler.a(this.f531113a, this.f531114b, this.f531115c, 2);
        ArrayList<ConcurrentHashMap<String, AtomicLong>> r101 = zz5.b.f574088a;
        String r102 = this.f531113a;
        Iterator<ApiStatistics> r103 = zz5.b.f574090c.iterator();
        int r104 = 0;
    L4:
        if (r103.hasNext() == false) goto L22;
        ApiStatistics r105 = r103.next();
        boolean r106 = true;
        if ((!Intrinsics.areEqual(r105.getType(), "appops")) == false) goto L9;
    L18:
        r106 = false;
    L19:
        if (r106 == true) goto L23;
        r104 = r104 + 1;
    L23:
        zz5.b.d(r104, r102);
        return;
    L9:
        if (r105.e() == true) goto L16;
        if (r105.c().isEmpty() == true) goto L19;
        if (r105.c().contains(r102) == false) goto L18;
    L16:
        if (r105.c().contains(r102) == true) goto L18;
    L22:
        r104 = -1;
        goto L23
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
