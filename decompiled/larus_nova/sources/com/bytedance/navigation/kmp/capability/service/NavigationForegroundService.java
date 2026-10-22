package com.bytedance.navigation.kmp.capability.service;

import android.R;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import d37.i;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0002,-B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016J$\u0010\f\u001a\u00020\b2\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0017J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0017J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016J\u0010\u0010\u0018\u001a\u00020\u00062\b\b\u0001\u0010\u0019\u001a\u00020\u001aJ\u0012\u0010\u001b\u001a\u00020\u00062\b\b\u0001\u0010\u0019\u001a\u00020\u001aH\u0002J\u001c\u0010\u001c\u001a\u00020\u001d2\b\b\u0001\u0010\u001e\u001a\u00020\u001d2\b\b\u0001\u0010\u001f\u001a\u00020\u001dH\u0002J\u001c\u0010 \u001a\u00020\u000e2\b\b\u0001\u0010!\u001a\u00020\u001a2\b\b\u0001\u0010\"\u001a\u00020\u0016H\u0002J\b\u0010#\u001a\u00020\bH\u0002J \u0010$\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\bH\u0002J\b\u0010(\u001a\u00020\u000bH\u0002J\u001a\u0010)\u001a\u00020*2\b\b\u0001\u0010\u0019\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\bH\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/bytedance/navigation/kmp/capability/service/NavigationForegroundService;", "Landroid/app/Service;", "Lcom/bytedance/navigation/kmp/interfaces/IForegroundService;", "<init>", "()V", "started", "", "currentNotificationId", "", "fgsTypeMask", WidgetCostModule.TYPE_ON_CREATE, "", "onStartCommand", "intent", "Landroid/content/Intent;", "flags", "startId", "onBind", "Landroid/os/IBinder;", LiveCommonConstants.REASON_ON_DEDTROY, "startForegroundService", "config", "Lcom/bytedance/navigation/kmp/data/params/ForegroundServiceParams;", "stopForegroundService", "ensureNotificationsAllowed", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "hasNotificationPermission", "ensureChannel", "", "id", "name", "buildStartOrUpdateIntent", "ctx", "c", "getFgsTypeMask", "startForegroundCompat", OfficeSDKRequestTag.KEY_NEW_USER, "Landroid/app/Notification;", "typeMask", "stopForegroundCompatRemove", "bringAppToFront", "Landroid/app/PendingIntent;", "requestCode", "Companion", "PermissionRequester", "bdnavigation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NavigationForegroundService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f265828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f265829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f265830c;

    public static final class a {
    }

    static {
    }

    public final void d() {
        stopForeground(true);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        i r100 = i.f466749a;
        i.e("stopForeground(true) failed.", th);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r100) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        return null;
    }

    @Override // android.app.Service
    public final void onDestroy() {
        i r100 = i.f466749a;
        i.g("NavigationForegroundService.onDestroy()");
        this.f265828a = false;
        super.onDestroy();
    }

    public NavigationForegroundService() {
        this.f265829b = 1001;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        i r100 = i.f466749a;
        i.g("NavigationForegroundService.onCreate()");
        if (b(this) == true) goto L6;
        i.g("NavigationForegroundService: Notifications not allowed (permission/app-level). stopSelf().");
        stopSelf();
        return;
    L6:
        a("navsvc_boot", "Navigation Bootstrap");
        Notification r101 = new NotificationCompat.Builder(this, "navsvc_boot").setSmallIcon(R.drawable.stat_sys_warning).setContentTitle("启动中…").setContentText("准备启动导航服务").setOngoing(true).setCategory("service").build();
        c(this.f265829b, r101, 0);
        this.f265828a = true;
        i.g("Entered foreground with bootstrap notification.");
    }

    public static boolean b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r101 = NotificationManagerCompat.from(r100).areNotificationsEnabled();     // Catch: Throwable -> L5
    L8:
        if (r101 == true) goto L11;
        return false;
    L11:
        if (Build.VERSION.SDK_INT >= 33) goto L14;
        return true;
    L14:
        if (ContextCompat.checkSelfPermission(r100, "android.permission.POST_NOTIFICATIONS") == 0) goto L21;
        return false;
    L21:
        return true;
    L5:
        th = move-exception;
        i r102 = i.f466749a;
        i.e("NavigationForegroundService.areNotificationsEnabled() threw; assume enabled to avoid false negatives.", th);
        r101 = true;
        goto L8
    }

    public final void a(String r100, String r101) {
        Object r102 = getSystemService("notification");
        if ((r102 instanceof NotificationManager) == false) goto L5;
        NotificationManager r103 = (NotificationManager) r102;
    L6:
        if (r103 != null) goto L8;
        return;
    L8:
        if (Build.VERSION.SDK_INT >= 26) goto L10;
        return;
    L10:
        if (r103.getNotificationChannel(r100) != null) goto L15;
        NotificationChannel r104 = new NotificationChannel(r100, r101, 2);
        r104.setLockscreenVisibility(1);
        r103.createNotificationChannel(r104);
        i r105 = i.f466749a;
        i.g("NavigationForegroundService.Notification channel created. id=" + r100 + ", name=" + r101);
        return;
    L15:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final void c(int r100, Notification r101, int r102) {
        i r103 = i.f466749a;     // Catch: Throwable -> L9
        i.g("NavigationForegroundService.startForegroundCompat(): id=" + r100 + ", typeMask=" + r102);     // Catch: Throwable -> L9
        if (Build.VERSION.SDK_INT < 29) goto L7;
        if (r102 == 0) goto L7;
        startForeground(r100, r101, r102);     // Catch: Throwable -> L9
    L12:
        return;
    L7:
        startForeground(r100, r101);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        i r104 = i.f466749a;
        i.e("NavigationForegroundService.startForeground not available", th);
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r210, int r211, int r212) {
        if (r210 != null) goto L6;
        i r100 = i.f466749a;
        i.g("NavigationForegroundService.onStartCommand() with null intent. Stopping to avoid zombie FGS.");
        d();
        stopSelf();
        this.f265828a = false;
        return 2;
    L6:
        String r101 = r210.getAction();
        i r102 = i.f466749a;
        i.g("NavigationForegroundService.onStartCommand() action=" + r101);
        if (Intrinsics.areEqual("navsvc.ACTION_STOP", r101) == false) goto L11;
        i.g("NavigationForegroundService.onStartCommand() Stopping service on ACTION_STOP.");
        d();
        stopSelf();
        this.f265828a = false;
        return 2;
    L11:
        if (Intrinsics.areEqual("navsvc.ACTION_START_OR_UPDATE", r101) == true) goto L13;
        return 2;
    L13:
        if (b(this) == true) goto L16;
        i.g("NavigationForegroundService.onStartCommand() Notifications not allowed at update/start. Stopping self.");
        d();
        stopSelf();
        this.f265828a = false;
        return 2;
    L16:
        Bundle r103 = r210.getBundleExtra("navsvc.EXTRAS");
        Context r104 = BadParcelableCrashOptimizer.getContext();
        if (r103 == null) goto L20;
        if (r104 == null) goto L20;
        r103.setClassLoader(r104.getClassLoader());
    L20:
        if (r103 != null) goto L23;
        i.g("NavigationForegroundService.onStartCommand() Missing extras for ACTION_START_OR_UPDATE. Stopping self.");
        d();
        stopSelf();
        this.f265828a = false;
        return 2;
    L23:
        int r105 = this.f265829b;
        this.f265829b = r103.getInt("id", r105);
        this.f265830c = r103.getInt("fgsTypeMask", 0);
        String r106 = r103.getString(RemoteMessageConst.Notification.CHANNEL_ID, "navsvc_channel");
        String r107 = r103.getString("channelName", "Navigation");
        String r108 = r103.getString("contentTitle");
        String r109 = r103.getString(RXScreenCaptureService.KEY_CONTENT_TEXT);
        int r110 = r103.getInt("smallIcon", R.drawable.stat_sys_warning);
        int r111 = r103.getInt("largeIcon", 0);
        boolean r112 = r103.getBoolean("lockPublic", true);
        boolean r113 = r103.getBoolean("ongoing", true);
        int r114 = Build.VERSION.SDK_INT;
        if (r114 < 33) goto L26;
        PendingIntent r115 = (PendingIntent) r103.getParcelable("contentIntent", PendingIntent.class);
    L28:
        if (r114 < 33) goto L30;
        RemoteViews r116 = (RemoteViews) r103.getParcelable("collapsed", RemoteViews.class);
    L32:
        if (r114 < 33) goto L34;
        RemoteViews r117 = (RemoteViews) r103.getParcelable("expanded", RemoteViews.class);
    L35:
        int[] r118 = r103.getIntArray("clickIds");
        PendingIntent r119 = r115;
        if (r114 < 33) goto L38;
        ArrayList r120 = r103.getParcelableArrayList("clickPendingIntents", PendingIntent.class);
    L39:
        if (r118 == null) goto L51;
        if (r120 == null) goto L51;
        if (r118.length != r120.size()) goto L51;
        if (r116 == null) goto L47;
        int r121 = r118.length;
        int r122 = 0;
    L45:
        if (r122 >= r121) goto L47;
        r116.setOnClickPendingIntent(r118[r122], (PendingIntent) ListProtector.get(r120, r122));
        r122 = r122 + 1;
        r121 = r121;
    L47:
        if (r117 == null) goto L60;
        int r123 = r118.length;
        int r124 = 0;
    L49:
        if (r124 >= r123) goto L60;
        r117.setOnClickPendingIntent(r118[r124], (PendingIntent) ListProtector.get(r120, r124));
        r124 = r124 + 1;
        r123 = r123;
    L60:
        Intrinsics.checkNotNull(r106);
        Intrinsics.checkNotNull(r107);
        a(r106, r107);
        NotificationCompat.Builder r125 = new NotificationCompat.Builder(this, r106).setShowWhen(false).setSmallIcon(r110).setOngoing(r113).setOnlyAlertOnce(true).setCategory("service").setVisibility(r112 ? 1 : 0);
        if (TextUtils.isEmpty(r108) == true) goto L64;
        r125.setContentTitle(r108);
    L64:
        if (TextUtils.isEmpty(r109) == true) goto L66;
        r125.setContentText(r109);
    L66:
        if (r111 <= 0) goto L68;
        r125.setLargeIcon(BitmapFactory.decodeResource(getResources(), r111));
    L68:
        if (r119 == null) goto L70;
        r125.setContentIntent(r119);
    L70:
        if (r116 == null) goto L72;
        r125.setStyle(new NotificationCompat.DecoratedCustomViewStyle());
        r125.setCustomContentView(r116);
    L72:
        if (r117 == null) goto L74;
        r125.setCustomBigContentView(r117);
    L74:
        Notification r126 = r125.build();
        if (this.f265828a == true) goto L77;
        i r127 = i.f466749a;
        i.g("NavigationForegroundService not in foreground yet. Starting with final notification.");
        c(this.f265829b, r126, this.f265830c);
        this.f265828a = true;
    L79:
        if (r105 == this.f265829b) goto L86;
        NotificationManagerCompat.from(this).cancel(r105);
        return 2;
    L86:
        return 2;
    L77:
        i r128 = i.f466749a;
        i.g("NavigationForegroundService.onStartCommand() Updating foreground notification. id=" + this.f265829b);
        NotificationManagerCompat.from(this).notify(this.f265829b, r126);
        c(this.f265829b, r126, this.f265830c);
    L51:
        if (r118 != null) goto L53;
        if (r120 == null) goto L60;
    L53:
        Object r129 = "null";
        if (r118 == null) goto L56;
        Object r130 = Integer.valueOf(r118.length);
    L57:
        if (r120 == null) goto L59;
        r129 = Integer.valueOf(r120.size());
    L59:
        i.c("NavigationForegroundService, Error: clickIds.length != clickPIs.length, clickIds: " + r130 + ", clickPIs.size(): " + r129);
        goto L60
    L56:
        r130 = "null";
        goto L57
    L38:
        r120 = r103.getParcelableArrayList("clickPendingIntents");
        goto L39
    L34:
        r117 = (RemoteViews) r103.getParcelable("expanded");
        goto L35
    L30:
        r116 = (RemoteViews) r103.getParcelable("collapsed");
        goto L32
    L26:
        r115 = (PendingIntent) r103.getParcelable("contentIntent");
        goto L28
    }
}
