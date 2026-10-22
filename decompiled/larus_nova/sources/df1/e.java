package df1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import androidx.core.app.NotificationManagerCompat;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;
import com.bytedance.android.livesdk.bgService.LiveMediaSessionService;
import com.bytedance.android.livesdk.chatroom.resolution.AudienceVideoResolutionManager;
import com.bytedance.android.livesdk.floatview.VideoFloatWindowManager;
import com.bytedance.android.livesdk.floatview.p;
import com.bytedance.android.livesdk.floatview.q;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import zg1.h1;

/* JADX INFO: loaded from: classes7.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f468200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Context f468201b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f468202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Disposable f468203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Disposable f468204e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f468205f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final e f468206g = null;

    public static final class a extends IHostAppMonitorListener.Stub {
        public a() {
        }

        @Override // com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener.Stub, com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener
        public final void appEnterBackground(boolean r100, boolean r110) {
            ALogger.i("LiveMediaSession", "MediaSessionHelper### onAppEnterBackground start background: " + r100 + ", isRegister: " + r110);
            if (b.f468196a == true) goto L6;
            ALogger.i("LiveMediaSession", "MediaSessionHelper### onAppEnterBackground, return because switch not open, background: " + r100 + ", isRegister: " + r110);
            return;
        L6:
            e r101 = e.f468206g;
            r101.getClass();
            Room r102 = ((IRoomService) k.n(IRoomService.class)).getCurrentRoom();
            if (r102 == null) goto L10;
            String r103 = r102.getOwnerUserIdString();
            if (r103 == null) goto L10;
        L11:
            String r104 = ((IUserService) k.n(IUserService.class)).user().n();
            o0.f58946a.getClass();
            if (o0.a.a(r103, r104) == false) goto L15;
            ALogger.i("LiveMediaSession", "MediaSessionHelper### onAppEnterBackground, return because is anchor, background: " + r100 + ", isRegister: " + r110);
            return;
        L15:
            e.f468200a = r100;
            if (r110 == false) goto L20;
            if (r100 == true) goto L20;
            ALogger.i("LiveMediaSession", "MediaSessionHelper### onAppEnterBackground, return because first register, background: " + r100 + ", isRegister: " + r110);
            return;
        L20:
            boolean r111 = e.c(e.f468201b);
            boolean r105 = NotificationManagerCompat.from(jc1.a.b()).areNotificationsEnabled();
            IRoomService r106 = (IRoomService) k.f(IRoomService.class);
            if (r106 == null) goto L23;
            Room r107 = r106.getCurrentRoom();
        L24:
            if (r107 != null) goto L30;
            if (r100 == true) goto L28;
            if (r111 == true) goto L28;
            ALogger.i("LiveMediaSession", "MediaSessionHelper###stop service since room doesn't exist.");
            e.d(r105, "live_end");
            r101.stopService();
        L28:
            ALogger.i("LiveMediaSession", "MediaSessionHelper### onAppEnterBackground, return because room is null");
            return;
        L30:
            boolean r108 = true;
            if (r100 == false) goto L50;
            if (r111 == false) goto L50;
            e.f468202c = SystemClock.elapsedRealtime();
            AudienceVideoResolutionManager.b(true);
            com.bytedance.android.livesdk.notification.a.d(r105);
            ALogger.i("LiveMediaSession", "MediaSessionHelper###onBackgroundObStart");
            Disposable r109 = e.f468203d;
            if (r109 != null) goto L36;
        L41:
            e.f468203d = du2.a.d(30, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(r105));
            Disposable r112 = e.f468204e;
            if (r112 != null) goto L44;
        L49:
            e.f468204e = xs2.b.a().b(h1.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(r105));
        L53:
            if (r100 == false) goto L56;
            if (r111 == false) goto L56;
        L57:
            ILinkServiceExternal r113 = (ILinkServiceExternal) k.f(ILinkServiceExternal.class);
            if (r113 == null) goto L62;
            lc0.a r114 = r113.getControlServiceExternal();
            if (r114 == null) goto L62;
            r114.f(r108);
        L62:
            if (r105 == true) goto L66;
            ALogger.i("LiveMediaSession", "MediaSessionHelper### onAppEnterBackground, return because notification not enable");
            return;
        L66:
            if (e.f468200a == false) goto L68;
            ALogger.i("LiveMediaSession", "MediaSessionHelper### onAppEnterBackground, startServiceAndNotify");
            r101.e(e.f468200a, false, false);
            c.a();
            return;
        L68:
            c.b();
            ALogger.i("LiveMediaSession", "MediaSessionHelper### onAppEnterBackground, tryStopService, isServiceStart: " + LiveMediaSessionService.f104291k + ", keepService: " + e.f468205f);
            if (LiveMediaSessionService.f104291k == true) goto L71;
            return;
        L71:
            if (e.f468205f == true) goto L76;
            r101.stopService();
            return;
        L76:
            return;
        L56:
            r108 = false;
            goto L57
        L44:
            if (r112.isDisposed() == true) goto L49;
            Disposable r115 = e.f468204e;
            if (r115 == null) goto L48;
            r115.dispose();
        L48:
            e.f468204e = null;
            goto L49
        L36:
            if (r109.isDisposed() == true) goto L41;
            Disposable r116 = e.f468203d;
            if (r116 == null) goto L40;
            r116.dispose();
        L40:
            e.f468203d = null;
        L50:
            if (r100 == true) goto L53;
            e.d(r105, "back_app");
            goto L53
        L23:
            r107 = null;
        L10:
            r103 = "0";
            goto L11
        }
    }

    public e() {
    }

    public static boolean b() {
        if (Build.VERSION.SDK_INT < 34) goto L6;
        boolean r100 = true;
    L7:
        if (r100 == true) goto L9;
        return false;
    L9:
        if (((IInteractService) k.n(IInteractService.class)).isLinkerUser(((IUserService) k.n(IUserService.class)).user().b()) == false) goto L18;
        if (((IInteractService) k.n(IInteractService.class)).isLinkerUserUnSilence(((IUserService) k.n(IUserService.class)).user().b()) == false) goto L19;
        return true;
    L19:
        return false;
    L18:
        return false;
    L6:
        r100 = false;
    L20:
        return false;
    }

    static {
        f468206g = new e();
        f468201b = jc1.a.b();
        a r100 = new a();
        ALogger.i("LiveMediaSession", "MediaSessionHelper### register appEnterBackground");
        IHostApp r101 = (IHostApp) k.f(IHostApp.class);
        if (r101 == null) goto L6;
        r101.registerLiveLifeCycleListener(r100);
        return;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static void a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class.forName("com.bytedance.android.livesdk.notification.AudioLiveService");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L36;
        FastClassNotFoundHandler.a("com.bytedance.android.livesdk.notification.AudioLiveService");     // Catch: Throwable -> L8
        return;
    L36:
        return;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.android.livesdk.notification.AudioLiveService");
    L12:
        throw th;
    L34:
        Class.forName("com.bytedance.android.livesdk.notification.AudioLiveService");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L37;
        FastClassNotFoundHandler.a("com.bytedance.android.livesdk.notification.AudioLiveService");     // Catch: Throwable -> L17
        return;
    L37:
        return;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.android.livesdk.notification.AudioLiveService");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == false) goto L26;
    L29:
        MiraPluginFix.forName("com.bytedance.android.livesdk.notification.AudioLiveService");
        return;
    L26:
        if ((th instanceof NoClassDefFoundError) == true) goto L29;
        throw th;
    }

    public final void stopService() {
        if (b.f468196a == true) goto L7;
        ALogger.i("LiveMediaSession", "MediaSessionHelper###stopService, return LiveMediaSessionConfig.enable = false");
        return;
    L7:
        if (LiveMediaSessionService.f104291k == true) goto L9;
        return;
    L9:
        Context r100 = f468201b;
        if (r100 == null) goto L23;
        ALogger.i("LiveMediaSession", "MediaSessionHelper###stopService, send intent");
        boolean r101 = Boolean.valueOf(r100.stopService(new Intent(r100, LiveMediaSessionService.class))).booleanValue();     // Catch: Exception -> L14
    L16:
        ALogger.i("LiveMediaSession", "MediaSessionHelper###stopService result = " + r101);
        if (r101 == true) goto L27;
        ALogger.i("LiveMediaSession", "MediaSessionHelper###stopService default call hideNotification");
        e r102 = f468206g;
        Context r103 = f468201b;
        r102.getClass();
        if (NotificationManagerCompat.from(jc1.a.b()).areNotificationsEnabled() == false) goto L28;
        if (r103 == null) goto L30;
        Intent r104 = new Intent(r103, LiveMediaSessionService.class);
        r104.setAction("com.bytedance.livesdk.action.media_session.hide_notification");
        f(r103, r104, false);
        return;
    L30:
        return;
    L28:
        return;
    L27:
        return;
    L14:
        e = move-exception;
        ALogger.e("LiveMediaSession", "MediaSessionHelper###stopService error : " + e.getMessage());
        r101 = false;
        goto L16
    L23:
        ALogger.e("LiveMediaSession", "MediaSessionHelper###stopService error context is null");
    }

    public static boolean c(Context r100) {
        IHostApp r101 = (IHostApp) k.f(IHostApp.class);
        if (r101 == null) goto L5;
        List<Class> r102 = r101.getAllLiveActivity();
    L6:
        List<Class> r103 = r102;
        if (r103 != null) goto L9;
    L12:
        boolean r104 = true;
    L13:
        if (r104 == false) goto L16;
        return false;
    L16:
        if ((r100 instanceof Activity) == true) goto L18;
        r100 = null;
    L18:
        Activity r105 = (Activity) r100;
        if (r105 != null) goto L24;
        IHostApp r106 = (IHostApp) k.f(IHostApp.class);
        if (r106 == null) goto L23;
        r105 = r106.getTopActivity();
        goto L24
    L23:
        r105 = null;
    L24:
        Iterator<T> r107 = r102.iterator();
    L26:
        if (r107.hasNext() == false) goto L34;
        Class r108 = (Class) r107.next();
        if (r105 == null) goto L30;
        Class<?> r109 = r105.getClass();
    L32:
        if (Intrinsics.areEqual(r109, r108) == false) goto L26;
        return true;
    L30:
        r109 = null;
        goto L32
    L34:
        return false;
    L9:
        if (r103.isEmpty() == true) goto L12;
        r104 = false;
        goto L13
    L5:
        r102 = null;
        goto L6
    }

    public static void d(boolean r100, String r101) {
        ALogger.i("LiveMediaSession", "MediaSessionHelper###onAppForeground, endType: ".concat(r101));
        if (f468202c <= 0) goto L5;
        long r102 = SystemClock.elapsedRealtime() - f468202c;
        AudienceVideoResolutionManager.b(false);
        com.bytedance.android.livesdk.notification.a.c(r102, r100, r101);
        f468202c = 0;
    L5:
        ALogger.i("LiveMediaSession", "MediaSessionHelper###onBackgroundObEnd");
        Disposable r103 = f468203d;
        if (r103 != null) goto L8;
    L13:
        Disposable r104 = f468204e;
        if (r104 != null) goto L16;
        return;
    L16:
        if (r104.isDisposed() == true) goto L23;
        Disposable r105 = f468204e;
        if (r105 == null) goto L20;
        r105.dispose();
    L20:
        f468204e = null;
        return;
    L23:
        return;
    L8:
        if (r103.isDisposed() == true) goto L13;
        Disposable r106 = f468203d;
        if (r106 == null) goto L12;
        r106.dispose();
    L12:
        f468203d = null;
        goto L13
    }

    public static void f(Context r100, Intent r101, boolean r102) {
        if (r100 != null) goto L5;
        ALogger.i("LiveMediaSession", "MediaSessionHelper###startServiceSafely, return context  null");
    L5:
        if (r102 == false) goto L9;
        c.f468197a = true;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        ALogger.e("LiveMediaSession", "MediaSessionHelper###startServiceSafely, error: " + th.getMessage());
        return;
    L9:
        if (Build.VERSION.SDK_INT < 26) goto L13;
        ALogger.i("LiveMediaSession", "MediaSessionHelper###startServiceSafely, startForegroundService");     // Catch: Throwable -> L17
        if (r100 == null) goto L21;
        r100.startForegroundService(r101);     // Catch: Throwable -> L17
        return;
    L21:
        return;
    L13:
        ALogger.i("LiveMediaSession", "MediaSessionHelper###startServiceSafely, startService");     // Catch: Throwable -> L17
        if (r100 == null) goto L23;
        r100.startService(r101);     // Catch: Throwable -> L17
        return;
    }

    public final void e(boolean r100, boolean r101, boolean r110) {
        boolean r102 = b.f468196a;
        if (r102 == true) goto L6;
        ALogger.i("LiveMediaSession", "MediaSessionHelper###startServiceAndNofity, return because switch not open");
        return;
    L6:
        Context r103 = f468201b;
        if (r102 == true) goto L10;
        ALogger.i("LiveMediaSession", "MediaSessionHelper###startServiceAndNofity, checkCanStartService fail, switch not enable");
    L41:
        boolean r104 = false;
    L43:
        if (r104 == true) goto L50;
        if (LiveMediaSessionService.f104291k == false) goto L47;
        ALogger.i("LiveMediaSession", "MediaSessionHelper###startServiceAndNofity, stopService because checkCanStartService fail");
        stopService();
    L47:
        ALogger.i("LiveMediaSession", "MediaSessionHelper###startServiceAndNofity, return because checkCanStartService fail");
        return;
    L50:
        if (LiveMediaSessionService.f104291k == false) goto L67;
        ALogger.i("LiveMediaSession", "MediaSessionHelper###startServiceAndNofity, return because LiveMediaSessionService is start");
        return;
    L67:
        a();     // Catch: Exception -> L64
        ALogger.i("LiveMediaSession", "MediaSessionHelper###startServiceAndNofity, startService, isBackground" + r100 + ". isAndroid14LinkMicrophoneBgLimit: " + b() + ", forceStart:" + r101);
        if (r100 == true) goto L57;
    L58:
        if (r101 == false) goto L69;
    L59:
        ALogger.i("LiveMediaSession", "MediaSessionHelper###startServiceAndNofity, startService, send intent");
        f468205f = r110;
        if (r103 == null) goto L62;
        Intent r105 = new Intent(r103, LiveMediaSessionService.class);
        r105.setAction("com.bytedance.livesdk.action.media_session.show_notification");
        f(r103, r105, true);
        return;
    L62:
        ALogger.i("LiveMediaSession", "MediaSessionHelper###startServiceAndNofity, return context  null");
        return;
    L69:
        return;
    L57:
        if (b() == false) goto L59;
    L64:
        e = move-exception;
        ALogger.e("LiveMediaSession", "MediaSessionHelper###startServiceAndNofity, return because Class.forName fail, " + e.getMessage());
        u.l().sendLog("livesdk_not_find_AudioLiveService", MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, e.toString())), new Object[0]);
        return;
    L10:
        if (NotificationManagerCompat.from(jc1.a.b()).areNotificationsEnabled() == true) goto L12;
        ALogger.i("LiveMediaSession", "MediaSessionHelper###startServiceAndNofity, checkCanStartService fail, notification not enable");
        goto L41
    L12:
        if (r103 != null) goto L14;
        ALogger.i("LiveMediaSession", "MediaSessionHelper###startServiceAndNofity, checkCanStartService fail, context is null");
        goto L41
    L14:
        IRoomService r106 = (IRoomService) k.f(IRoomService.class);
        if (r106 == null) goto L17;
        Room r107 = r106.getCurrentRoom();
    L18:
        if (r107 != null) goto L21;
        ALogger.i("LiveMediaSession", "MediaSessionHelper###startServiceAndNofity, checkCanStartService fail, room is null");
        goto L41
    L21:
        if (com.bytedance.android.livesdk.vscore_api.paidlive.c.a.b(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.c(r107), PaidSceneEnum.PAID_ROOM, 2) == true) goto L23;
        ALogger.i("LiveMediaSession", "MediaSessionHelper###startServiceAndNofity, checkCanStartService fail, paidManagerService returned");
        goto L41
    L23:
        ILiveService r108 = TTLiveService.getLiveService();
        if (r108 == null) goto L29;
        if (r108.isLiveTalkRoomFloatWindowShowing() != true) goto L29;
        ALogger.i("LiveMediaSession", "MediaSessionHelper###startServiceAndNofity, checkCanStartService fail, isLiveTalkRoomFloatWindowShowing");
    L29:
        if (df1.a.b() == false) goto L31;
        q r109 = VideoFloatWindowManager.f125075f;
        rx1.g r111 = VideoFloatWindowManager.b.a().c();
        if (r111 != null) goto L36;
    L39:
        if (c(r103) == true) goto L42;
        ALogger.i("LiveMediaSession", "MediaSessionHelper###startServiceAndNofity, checkCanStartService fail, isTopLiveActivity false");
        goto L41
    L42:
        r104 = true;
        goto L43
    L36:
        if (r111.f539762l != true) goto L39;
        ALogger.i("LiveMediaSession", "MediaSessionHelper###startServiceAndNofity, checkCanStartService fail, getVideoWindow()?.isShowing");
        goto L41
    L31:
        if (p.d(r103) == false) goto L39;
        ALogger.i("LiveMediaSession", "MediaSessionHelper###startServiceAndNofity, checkCanStartService fail, VideoFloatWindowHelper.isFloatWindowOpen");
        goto L41
    L17:
        r107 = null;
        goto L18
    }
}
