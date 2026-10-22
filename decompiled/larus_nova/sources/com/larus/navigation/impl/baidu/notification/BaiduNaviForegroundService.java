package com.larus.navigation.impl.baidu.notification;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import androidx.core.content.ContextCompat;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/larus/navigation/impl/baidu/notification/BaiduNaviForegroundService;", "Landroid/app/Service;", "<init>", "()V", "updateNotification", "", "notification", "Landroid/app/Notification;", WidgetCostModule.TYPE_ON_CREATE, LiveCommonConstants.REASON_ON_DEDTROY, "onBind", "Landroid/os/IBinder;", "p0", "Landroid/content/Intent;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BaiduNaviForegroundService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f359784a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f359785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static BaiduNaviForegroundService f359786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Function1<? super Boolean, Unit> f359787d;

    public static final class a {
        public final synchronized void stopService() {
            monitor-enter(this);
            BaiduNaviForegroundService.f359785b = false;     // Catch: Throwable -> L25
            BaiduNaviForegroundService r100 = BaiduNaviForegroundService.f359786c;     // Catch: Throwable -> L25
            if (r100 != null) goto L10;
            monitor-exit(this);
            return;
        L10:
            if (Build.VERSION.SDK_INT < 24) goto L12;
            r100.stopForeground(1);     // Catch: Throwable -> L25
        L13:
            r100.stopSelf();     // Catch: Throwable -> L25
            FLogger.f375446a.i("BaiduNaviForegroundService", "stopService " + r100);     // Catch: Throwable -> L25
            Object r101 = AppHost.f326268a.getApplication().getSystemService("notification");     // Catch: Throwable -> L21
            if ((r101 instanceof NotificationManager) == false) goto L17;
            NotificationManager r102 = (NotificationManager) r101;     // Catch: Throwable -> L21
        L18:
            if (r102 == null) goto L23;
            r102.cancel(106);     // Catch: Throwable -> L21
        L23:
            monitor-exit(this);
            return;
        L17:
            r102 = null;
        L21:
            th = move-exception;
            FLogger.f375446a.e("BaiduNaviForegroundService", "cancel notification additionally fails", th);     // Catch: Throwable -> L25
            goto L23
        L12:
            r100.stopForeground(true);     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            throw th;
        }

        public a() {
        }

        public final synchronized void startService(Function1<? super Boolean, Unit> r100) {
            monitor-enter(this);
            Intrinsics.checkNotNullParameter(r100, "callback");     // Catch: Throwable -> L22
            if (BaiduNaviForegroundService.f359785b == true) goto L6;
            BaiduNaviForegroundService.f359787d = r100;     // Catch: Throwable -> L22
        L18:
            e = move-exception;
            r100.invoke(Boolean.FALSE);     // Catch: Throwable -> L22
            FLogger.f375446a.e("BaiduNaviForegroundService", "startService fails", e);     // Catch: Throwable -> L22
        L20:
            monitor-exit(this);
            return;
        L13:
            if (Build.VERSION.SDK_INT < 26) goto L15;
            AppHost.Companion r101 = AppHost.f326268a;     // Catch: Exception -> L18 Throwable -> L22
            r101.getApplication().startForegroundService(new Intent(r101.getApplication(), BaiduNaviForegroundService.class));     // Catch: Exception -> L18 Throwable -> L22
        L16:
            BaiduNaviForegroundService.f359785b = true;     // Catch: Exception -> L18 Throwable -> L22
            FLogger.f375446a.i("BaiduNaviForegroundService", "startService succeeds");     // Catch: Exception -> L18 Throwable -> L22
        L15:
            AppHost.Companion r102 = AppHost.f326268a;     // Catch: Exception -> L18 Throwable -> L22
            r102.getApplication().startService(new Intent(r102.getApplication(), BaiduNaviForegroundService.class));     // Catch: Exception -> L18 Throwable -> L22
            goto L16
        L6:
            if (BaiduNaviForegroundService.f359786c == null) goto L8;
            r100.invoke(Boolean.TRUE);     // Catch: Throwable -> L22
        L9:
            monitor-exit(this);
            return;
        L8:
            BaiduNaviForegroundService.f359787d = r100;     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            throw th;
        }
    }

    static {
        f359784a = new a();
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        FLogger.f375446a.i("BaiduNaviForegroundService", "service onCreate " + this);
        BaiduNaviForegroundService r100 = f359786c;
        if (r100 == null) goto L5;
        r100.stopSelf();
    L5:
        f359786c = this;
        BaiduNaviNotificationManager r101 = BaiduNaviNotificationManager.f359788a;
        r101.getClass();
        BaiduNaviNotificationManager.b();
        BaiduNaviNotificationManager.i(r101, getString(R.string.larus_navigation_topBar_banner_going_cn), null, null, null, 12);
        if (d.b() == false) goto L8;
        int r102 = R.drawable.larus_plain_dark;
    L9:
        Drawable r103 = ContextCompat.getDrawable(AppHost.f326268a.getApplication(), r102);
        if (r103 != null) goto L20;
        Bitmap r104 = null;
    L16:
        BaiduNaviNotificationManager.i(BaiduNaviNotificationManager.f359788a, getString(R.string.larus_navigation_topBar_banner_going_cn), null, null, r104, 4);
        Function1<? super Boolean, Unit> r105 = f359787d;
        if (r105 == null) goto L22;
        r105.invoke(Boolean.TRUE);
        f359787d = null;
        return;
    L22:
        return;
    L20:
        Bitmap r106 = Bitmap.createBitmap(r103.getIntrinsicWidth(), r103.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);     // Catch: Exception -> L14
        Canvas r107 = new Canvas(r106);     // Catch: Exception -> L14
        r103.setBounds(0, 0, r107.getWidth(), r107.getHeight());     // Catch: Exception -> L14
        r103.draw(r107);     // Catch: Exception -> L14
    L15:
        r104 = r106;
    L14:
        r106 = null;
        goto L15
    L8:
        r102 = R.drawable.larus_plain_light;
        goto L9
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        FLogger.f375446a.i("BaiduNaviForegroundService", "service Destroyed " + this);
        if (Intrinsics.areEqual(f359786c, this) == false) goto L6;
        f359786c = null;
        f359785b = false;
        return;
    }

    public BaiduNaviForegroundService() {
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r100) {
        return new Binder();
    }
}
