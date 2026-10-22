package com.larus.im.trace;

import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.s;
import com.larus.im.network.f;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.o;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.m1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes4.dex */
public final class FrontierStatusMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FrontierStatusMonitor f350898a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f350899b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f350900c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Job f350901d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final m1 f350902e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Boolean f350903f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f350904g;

    public static final class a implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f350905a = null;

        static {
            f350905a = new a();
        }

        public a() {
        }

        @Override // com.larus.platform.api.o
        public final void a(int r100) {
        }

        @Override // com.larus.platform.api.o
        public final void onStateChange(int r100) {
            if (r100 != 1) goto L5;
            FrontierStatusMonitor.f350904g = 1;
            if (AppHost.f326268a.a().isAppBackground() == false) goto L15;
            FrontierStatusMonitor r101 = FrontierStatusMonitor.f350898a;
            if (FrontierStatusMonitor.a(r101) == false) goto L16;
            FLogger.f375446a.i("FrontierStatusMonitor", "tryDisconnect in wakeOff listener");
            FrontierStatusMonitor.b(r101, "doraWakeOff");
            return;
        L16:
            return;
        L15:
            return;
        L5:
            if (r100 != 2) goto L17;
            FrontierStatusMonitor.f350904g = 2;
            FrontierStatusMonitor.c(FrontierStatusMonitor.f350898a, "doraWakeup");
            return;
        }
    }

    public FrontierStatusMonitor() {
    }

    static {
        f350898a = new FrontierStatusMonitor();
        CoroutineScope r100 = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        f350899b = r100;
        f350900c = new f(0);
        f350902e = z2.f365865a.getFrontierOptConfig();
        f350904g = 1;
        BuildersKt.launch$default(r100, null, null, new FrontierStatusMonitor$loop$1(null), 3, null);
        IFlowSdkDepend r101 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r101 == null) goto L7;
        s r102 = r101.s0();
        if (r102 == null) goto L7;
        r102.f(a.f350905a);
    L7:
        AppHost.f326268a.a().j(new AnonymousClass2());
    }

    public static final boolean a(FrontierStatusMonitor r100) {
        r100.getClass();
        Boolean r101 = f350903f;
        if (r101 == null) goto L5;
        boolean r102 = r101.booleanValue();
        FLogger.f375446a.i("FrontierStatusMonitor", "current disableOnBackground value is " + r102);
        return r101.booleanValue();
    L5:
        IFlowSdkDepend r103 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        boolean r104 = false;
        if (r103 == null) goto L10;
        s r105 = r103.s0();
        if (r105 == null) goto L10;
        boolean r106 = Intrinsics.areEqual(r105.D(), Boolean.TRUE);
    L11:
        if (r106 == false) goto L14;
        r104 = f350902e.f486669c;
    L16:
        FLogger.f375446a.i("FrontierStatusMonitor", "current disableOnBackground value is " + r104 + ", dora connect status is " + r106);
        return r104;
    L14:
        if (f350902e.f486670d != 1) goto L16;
        r104 = true;
    L10:
        r106 = false;
        goto L11
    }

    public static final void b(FrontierStatusMonitor r100, String r110) {
        r100.getClass();
        Job r101 = f350901d;
        if (r101 == null) goto L5;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L5:
        f350901d = null;
        FLogger.f375446a.d("FrontierStatusMonitor", "tryDisconnect, " + r110 + ", " + (f350902e.f486671e * ((long) 1000)));
        f350901d = BuildersKt.launch$default(f350899b, null, null, new FrontierStatusMonitor$tryDisconnect$1(r110, null), 3, null);
    }

    public static final void c(FrontierStatusMonitor r100, String r101) {
        r100.getClass();
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("frontier status = ");
        f r104 = f350900c;
        r103.append(r104.c());
        r103.append(' ');
        r102.i("FrontierStatusMonitor", r103.toString());
        if (r104.c() == 0) goto L5;
        return;
    L5:
        if (f.f350605b.f350593i.a() == false) goto L9;
        r102.i("FrontierStatusMonitor", "tryReconnect");
        r104.l(null, r101);
        return;
    }
}
