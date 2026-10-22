package hm9;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.intercept.IInterceptorProperty;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.larus.common.apphost.AppHost;
import com.larus.network.interceptor.http.DoraTaskStatus;
import com.larus.network.util.ScreenStateManager;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.network.IObricBackgroundNetworkBlockService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final class j implements Interceptor, IInterceptorProperty {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f485959a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f485960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f485961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CopyOnWriteArrayList<v> f485962d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f485963e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f485964f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final CopyOnWriteArrayList<w> f485965g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final s f485966h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static x f485967i;

    public j() {
    }

    public final synchronized void d() {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (f485964f == true) goto L9;
        FLogger.f375446a.i("BackgroundNetworkInterceptor", "config not inited, ignore notifyBlockStateChange");     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L9:
        f485963e = false;     // Catch: Throwable -> L20
        FLogger.f375446a.i("BackgroundNetworkInterceptor", "set block State: false");     // Catch: Throwable -> L20
        Iterator<v> r100 = f485962d.iterator();     // Catch: Throwable -> L20
    L11:
        if (r100.hasNext() == false) goto L18;
        r100.next().X0(false);     // Catch: Exception -> L15 Throwable -> L20
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L20
        goto L11
    L18:
        monitor-exit(this);
    }

    static {
        f485959a = new j();
        f485962d = new CopyOnWriteArrayList();
        f485965g = new CopyOnWriteArrayList();
        s r100 = new s(ScreenStateManager.ScreenState.SCREEN_ON);
        f485966h = r100;
        f485967i = new u(new t(new l(new m(new y(new k(new z(new b0())))))));
        r100.A = new b();
    }

    public static boolean a() {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("calculateGlobalBlockState listener:");
        r101.append(f485962d.size());
        r101.append(" , needOpenNetworkControl:");
        s r102 = f485966h;
        r101.append(r102.f485974d);
        r101.append(" forceBackgroundNetworkControl:false userDidInWhiteList:");
        r101.append(r102.f485976f);
        r101.append(" needOnlyBlockWhenNotUseDora:");
        r101.append(r102.f485977g);
        r101.append(" doraUser:");
        r101.append(r102.f485975e);
        r101.append(" onlyBlockSenior:");
        r101.append(r102.f485973c);
        r101.append(") appScreenState:");
        r101.append(r102.f485971a);
        r101.append(" doraTaskStatus:");
        r101.append(r102.f485992v);
        r101.append(" audioPlayState:");
        r101.append(r102.f485993w);
        r100.i("BackgroundNetworkInterceptor", r101.toString());
        AppHost.Companion r103 = AppHost.f326268a;
        if (r103.isDebug() == false) goto L6;
        r100.d("BackgroundNetworkInterceptor", "isSeniorUser:" + r102.f485972b);
    L6:
        if (r102.f485974d == true) goto L9;
        return false;
    L9:
        if (r102.f485976f == false) goto L11;
        return false;
    L11:
        IObricBackgroundNetworkBlockService r110 = (IObricBackgroundNetworkBlockService) ServiceManager.get().getService(IObricBackgroundNetworkBlockService.class);
        if (r110 == null) goto L16;
        Boolean r111 = r110.e();
        if (r111 == null) goto L16;
        boolean r112 = r111.booleanValue();
    L18:
        if (r102.f485977g == false) goto L24;
        if (r102.f485975e == true) goto L24;
        if (r112 == true) goto L24;
        return false;
    L24:
        if (r102.f485973c == false) goto L29;
        if (r102.f485972b == true) goto L29;
        return false;
    L29:
        if (r102.f485993w == false) goto L34;
        if (r102.f485978h == false) goto L34;
        return false;
    L34:
        if (r103.a().isAppBackground() == true) goto L36;
        return false;
    L36:
        IObricBackgroundNetworkBlockService r113 = (IObricBackgroundNetworkBlockService) ServiceManager.get().getService(IObricBackgroundNetworkBlockService.class);
        if (r113 != null) goto L39;
    L41:
        boolean r114 = false;
    L42:
        if (r114 == false) goto L45;
        return false;
    L45:
        if (r102.f485971a == ScreenStateManager.ScreenState.SCREEN_OFF) goto L50;
        if (r102.f485995y == 2) goto L50;
        return false;
    L50:
        if (r102.f485975e == true) goto L52;
    L54:
        r100.i("BackgroundNetworkInterceptor", "[need block!!!] userDidInWhiteList:" + r102.f485976f + " needOnlyBlockWhenNotUseDora:" + r102.f485977g + " doraUser:" + r102.f485975e + " onlyBlockSenior:" + r102.f485973c + ") appScreenState:" + r102.f485971a + " doraTaskStatus:" + r102.f485992v + " audioPlayState:" + r102.f485993w);
        if (r103.isDebug() == false) goto L57;
        r100.d("BackgroundNetworkInterceptor", "isSeniorUser:" + r102.f485972b);
    L57:
        return true;
    L52:
        if (r102.f485992v != DoraTaskStatus.WAKE_UP) goto L54;
        return false;
    L39:
        if (r113.d() != true) goto L41;
        r114 = true;
    L16:
        r112 = false;
        goto L18
    }

    public static boolean c() {
        return AppHost.f326268a.a().isAppBackground();
    }

    public final synchronized void b() {
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (f485964f == true) goto L9;
        FLogger.f375446a.i("BackgroundNetworkInterceptor", "config not inited, ignore checkAndNotifyStateChange");     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L9:
        boolean r100 = a();     // Catch: Throwable -> L22
        if (r100 == f485963e) goto L20;
        f485963e = r100;     // Catch: Throwable -> L22
        FLogger.f375446a.i("BackgroundNetworkInterceptor", "Block State Changed: " + r100);     // Catch: Throwable -> L22
        Iterator<v> r101 = f485962d.iterator();     // Catch: Throwable -> L22
    L13:
        if (r101.hasNext() == false) goto L20;
        r101.next().X0(r100);     // Catch: Exception -> L17 Throwable -> L22
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L22
    L20:
        monitor-exit(this);
    }

    @Override // com.bytedance.retrofit2.intercept.IInterceptorProperty
    public final boolean shouldRunInMergeMode() {
        return f485961c;
    }

    @Override // com.bytedance.retrofit2.intercept.IInterceptorProperty
    public final boolean shouldRunInPureMode() {
        return f485960b;
    }

    public static void e(String r100) {
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder();
        r102.append(r100);
        r102.append(", context.currentIsIntercepting: ");
        s r103 = f485966h;
        r102.append(r103.B);
        r102.append(" appScreenState :");
        r102.append(r103.f485971a);
        r102.append(" needOpenNetworkControl :");
        r102.append(r103.f485974d);
        r102.append(" forceBackgroundNetworkControl :false notBlockWhenPlayingMusic :");
        r102.append(r103.f485978h);
        r102.append(" context.isAudioPlaying :");
        r102.append(r103.f485993w);
        r102.append(" needOnlyBlockWhenNotUseDora :");
        r102.append(r103.f485977g);
        r102.append(" doraTaskStatus :");
        r102.append(r103.f485992v);
        r101.i("BackgroundNetworkInterceptor", r102.toString());
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse<?> intercept(Interceptor.Chain r100) {
        s r101 = f485966h;
        r101.getClass();
        return f485967i.a(r100, r101);
    }
}
