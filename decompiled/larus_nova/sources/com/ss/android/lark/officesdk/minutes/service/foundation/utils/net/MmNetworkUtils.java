package com.ss.android.lark.officesdk.minutes.service.foundation.utils.net;

import android.app.Application;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import com.ss.android.lark.rustinfrabridge.netstate.api.NetworkLevelListener;
import com.ss.android.lark.rustinfrabridge.netstate.impl.LarkNetworkLevelManager;
import com.ss.android.lark.utils.LarkContext;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes37.dex */
public final class MmNetworkUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f434041a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedHashMap<Integer, Function2<Boolean, String, Unit>> f434042b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f434043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static b f434044d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static ConnectivityManager f434045e;

    public static final class a implements NetworkLevelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<Boolean> f434046a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<Job> f434047b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CoroutineScope f434048c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f434049d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Function1<Boolean, Unit> f434050e;

        public a(Ref.ObjectRef r100, Ref.ObjectRef r101, CoroutineScope r102, long r103, Function1 r104) {
            this.f434046a = r100;
            this.f434047b = r101;
            this.f434048c = r102;
            this.f434049d = r103;
            this.f434050e = r104;
        }

        @Override // com.ss.android.lark.rustinfrabridge.netstate.api.NetworkLevelListener
        public final void a(NetworkLevelListener.NetworkLevel r110) {
            MmNetworkUtils.d(this.f434046a, this.f434047b, this.f434048c, this.f434049d, "MmNetworkUtils", this.f434050e, !c.b(r110), "rust_net_state");
        }
    }

    public MmNetworkUtils() {
    }

    static {
        f434041a = new Object();
        f434042b = new LinkedHashMap();
        f434043c = 1;
    }

    public static final void b(Integer r100) {
        if (r100 == null) goto L35;
        Object r101 = f434041a;
        monitor-enter(r101);
        LinkedHashMap<Integer, Function2<Boolean, String, Unit>> r102 = f434042b;     // Catch: Throwable -> L28
        r102.remove(r100);     // Catch: Throwable -> L28
        if ((!r102.isEmpty()) == false) goto L11;
        monitor-exit(r101);
        return;
    L11:
        b r103 = f434044d;     // Catch: Throwable -> L28
        if (r103 != null) goto L32;
        monitor-exit(r101);
        return;
    L32:
        ConnectivityManager r104 = f434045e;     // Catch: Throwable -> L20 Exception -> L22
        if (r104 == null) goto L23;
        r104.unregisterNetworkCallback(r103);     // Catch: Throwable -> L20 Exception -> L22
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L20 Exception -> L22
    L23:
        f434044d = null;     // Catch: Throwable -> L28
        f434045e = null;     // Catch: Throwable -> L28
        monitor-exit(r101);
        return;
    L20:
        th = move-exception;
        f434044d = null;     // Catch: Throwable -> L28
        f434045e = null;     // Catch: Throwable -> L28
        throw th;     // Catch: Throwable -> L28
    L22:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L20
    L28:
        th = move-exception;
        throw th;
    }

    public static final void a(boolean r100, String r101) {
        Object r102 = f434041a;
        monitor-enter(r102);
        List r103 = CollectionsKt.toList(f434042b.values());     // Catch: Throwable -> L11
        monitor-exit(r102);
        Iterator r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        ((Function2) r104.next()).invoke(Boolean.valueOf(r100), r101);
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static Job c(final String r110, final CoroutineScope r111, final long r112, final Function1 r210) {
        Intrinsics.checkNotNullParameter(r110, "scene");
        Intrinsics.checkNotNullParameter(r111, "scope");
        Intrinsics.checkNotNullParameter(r210, "onNetworkAvailable");
        final String r113 = "MmNetworkUtils";
        Application r100 = LarkContext.getApplication();
        if (r100 != null) goto L6;
        lvb.a.h("MmNetworkUtils", "[launchNetworkChangeJob] app null, skip register");
        return null;
    L6:
        final Ref.ObjectRef r114 = new Ref.ObjectRef();
        final Ref.ObjectRef r115 = new Ref.ObjectRef();
        final a r116 = new a(r115, r114, r111, r112, r210);
        Object r101 = LarkNetworkLevelManager.f439693d;
        LarkNetworkLevelManager.a.a().w0(r116);
        Function2<Boolean, String, Unit> r117 = new MmNetworkUtils$launchNetworkChangeJob$systemListenerId$1(r115, r114, r111, r112, r113, r210);
        Object r102 = f434041a;
        monitor-enter(r102);
        int r103 = f434043c;     // Catch: Throwable -> L30
        f434043c = r103 + 1;     // Catch: Throwable -> L30
        f434042b.put(Integer.valueOf(r103), r117);     // Catch: Throwable -> L30
        if (f434044d == null) goto L13;
        Integer r104 = Integer.valueOf(r103);     // Catch: Throwable -> L30
        monitor-exit(r102);
    L28:
        Object r105 = LarkNetworkLevelManager.f439693d;
        NetworkLevelListener.NetworkLevel r106 = LarkNetworkLevelManager.a.a().getCurNetWorkLevel();
        Intrinsics.checkNotNull(r106);
        d(r115, r114, r111, r112, "MmNetworkUtils", r210, !c.b(r106), "init, scene:".concat(r110));
        Job r107 = BuildersKt.launch$default(r111, null, null, new MmNetworkUtils$launchNetworkChangeJob$job$1(null), 3, null);
        final Integer r108 = r104;
        r107.invokeOnCompletion(new MmNetworkUtils$launchNetworkChangeJob$1(r113, r110, r116, r108, r114));
        return r107;
    L13:
        Object r109 = r100.getSystemService("connectivity");     // Catch: Throwable -> L30
        if ((r109 instanceof ConnectivityManager) == false) goto L16;
        ConnectivityManager r118 = (ConnectivityManager) r109;     // Catch: Throwable -> L30
    L17:
        if (r118 != null) goto L21;
        lvb.a.h("MmNetworkUtils", "[network] connectivity manager null, skip register");     // Catch: Throwable -> L30
        r104 = Integer.valueOf(r103);     // Catch: Throwable -> L30
        monitor-exit(r102);
        goto L28
    L21:
        b r119 = new b();     // Catch: Throwable -> L30
        r118.registerNetworkCallback(new NetworkRequest.Builder().build(), r119);     // Catch: Exception -> L24 Throwable -> L30
        f434045e = r118;     // Catch: Exception -> L24 Throwable -> L30
        f434044d = r119;     // Catch: Exception -> L24 Throwable -> L30
        r104 = Integer.valueOf(r103);     // Catch: Exception -> L24 Throwable -> L30
    L27:
        monitor-exit(r102);
        goto L28
    L24:
        e = move-exception;
        lvb.a.b("MmNetworkUtils", "[network] registerNetworkCallback failed: " + e);     // Catch: Throwable -> L30
        f434042b.remove(Integer.valueOf(r103));     // Catch: Throwable -> L30
        r104 = null;
        goto L27
    L16:
        r118 = null;
    L30:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, kotlinx.coroutines.Job] */
    /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.Boolean] */
    public static final void d(Ref.ObjectRef<Boolean> r110, Ref.ObjectRef<Job> r111, CoroutineScope r112, long r113, String r114, Function1<? super Boolean, Unit> r115, boolean r116, String r210) {
        if (Intrinsics.areEqual(r110.element, Boolean.valueOf(r116)) == false) goto L5;
        return;
    L5:
        r110.element = Boolean.valueOf(r116);
        Job r100 = r111.element;
        if (r100 == null) goto L8;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L8:
        r111.element = BuildersKt.launch$default(r112, null, null, new MmNetworkUtils$launchNetworkChangeJob$dispatch$1(r113, r114, r210, r116, r115, null), 3, null);
    }
}
