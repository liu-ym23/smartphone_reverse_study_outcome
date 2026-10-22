package com.obric.sva.sdk.notification;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import com.obric.sva.sdk.utils.LogUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"Lcom/obric/sva/sdk/notification/SvaNotificationListenerService;", "Landroid/service/notification/NotificationListenerService;", "<init>", "()V", "onNotificationPosted", "", "sbn", "Landroid/service/notification/StatusBarNotification;", "onNotificationRemoved", "onListenerConnected", "onListenerDisconnected", "Companion", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SvaNotificationListenerService extends NotificationListenerService {
    public static final Companion Companion = null;
    private static final String TAG = "SvaNotificationListener";

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J \u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/sva/sdk/notification/SvaNotificationListenerService$Companion;", "", "<init>", "()V", "TAG", "", "requestRebind", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "logNotificationListenerPermission", "componentName", "Landroid/content/ComponentName;", "scene", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static /* synthetic */ void a(Context r100, ComponentName r101) {
            requestRebind$lambda$0(r100, r101);
        }

        @JvmStatic
        public final void requestRebind(final Context r100) {
            if (r100 != null) goto L6;
            LogUtils.w(SvaNotificationListenerService.TAG, "requestRebind failed, context is null", new Object[0]);
            return;
        L6:
            Context r101 = r100.getApplicationContext();
            if (r101 == null) goto L10;
            r100 = r101;
        L10:
            final ComponentName r102 = new ComponentName(r100, SvaNotificationListenerService.class);
            logNotificationListenerPermission(r100, r102, "beforeToggle");     // Catch: Throwable -> L15
            r100.getPackageManager().setComponentEnabledSetting(r102, 2, 1);     // Catch: Throwable -> L15
            r100.getPackageManager().setComponentEnabledSetting(r102, 1, 1);     // Catch: Throwable -> L15
            LogUtils.i(SvaNotificationListenerService.TAG, "requestRebind: toggle done for " + r102, new Object[0]);     // Catch: Throwable -> L15
            logNotificationListenerPermission(r100, r102, "afterToggle");     // Catch: Throwable -> L15
            if (Build.VERSION.SDK_INT < 24) goto L20;
            new Handler(Looper.getMainLooper()).postDelayed(new k(r100, r102), 1000);     // Catch: Throwable -> L15
            return;
        L20:
            return;
        L15:
            th = move-exception;
            LogUtils.w(SvaNotificationListenerService.TAG, "requestRebind failed", new Object[]{th});
        }

        private static String com_obric_sva_sdk_notification_SvaNotificationListenerService$Companion_android_provider_Settings$Secure_getString(ContentResolver r110, String r111) {
            f06.c r100 = new f06.c();
            Object[] r101 = {r110, r111};
            f06.b r112 = new f06.b();
            f06.d r113 = r100.b(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, "java.lang.String", r112);
            if (r113.f474982a == false) goto L6;
            r100.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, null, r112, false);
            return (String) r113.f474983b;
        L6:
            String r114 = Settings.Secure.getString(r110, r111);
            r100.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, r114, r112, true);
            return r114;
        }

        private static final void requestRebind$lambda$0(Context r100, ComponentName r101) {
            int r102 = r100.getPackageManager().getComponentEnabledSetting(r101);     // Catch: Throwable -> L5
            SvaNotificationListenerService.Companion.logNotificationListenerPermission(r100, r101, "beforeSystemRebind");     // Catch: Throwable -> L5
            NotificationListenerService.requestRebind(r101);     // Catch: Throwable -> L5
            LogUtils.i(SvaNotificationListenerService.TAG, "requestRebind: triggered system rebind for " + r101 + ", state: " + r102, new Object[0]);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            LogUtils.w(SvaNotificationListenerService.TAG, "system requestRebind failed", new Object[]{th});
        }

        private final void logNotificationListenerPermission(Context r110, ComponentName r111, String r112) {
            String r100 = com_obric_sva_sdk_notification_SvaNotificationListenerService$Companion_android_provider_Settings$Secure_getString(r110.getContentResolver(), "enabled_notification_listeners");     // Catch: Throwable -> L38
            if (r100 == null) goto L13;
            List r101 = StringsKt.split$default(r100, new String[]{":"}, false, 0, 6, null);     // Catch: Throwable -> L38
            if (r101 == null) goto L13;
            Collection r102 = new ArrayList();     // Catch: Throwable -> L38
            Iterator r103 = r101.iterator();     // Catch: Throwable -> L38
        L9:
            if (r103.hasNext() == false) goto L14;
            ComponentName r104 = ComponentName.unflattenFromString((String) r103.next());     // Catch: Throwable -> L38
            if (r104 == null) goto L9;
            r102.add(r104);     // Catch: Throwable -> L38
        L14:
            Collection r105 = r102;     // Catch: Throwable -> L38
            if ((r105 instanceof Collection) == true) goto L17;
        L19:
            Iterator r106 = r105.iterator();     // Catch: Throwable -> L38
        L21:
            if (r106.hasNext() == false) goto L18;
            if (Intrinsics.areEqual((ComponentName) r106.next(), r111) == false) goto L21;
            boolean r107 = true;
        L25:
            Collection r108 = r102;     // Catch: Throwable -> L38
            if ((r108 instanceof Collection) == true) goto L28;
        L30:
            Iterator r109 = r108.iterator();     // Catch: Throwable -> L38
        L32:
            if (r109.hasNext() == false) goto L29;
            if (Intrinsics.areEqual(((ComponentName) r109.next()).getPackageName(), r111.getPackageName()) == false) goto L32;
            boolean r113 = true;
        L36:
            LogUtils.i(SvaNotificationListenerService.TAG, "notification listener permission status, scene: " + r112 + ", packageGranted: " + r113 + ", componentGranted: " + r107 + ", componentState: " + r110.getPackageManager().getComponentEnabledSetting(r111), new Object[0]);     // Catch: Throwable -> L38
            return;
        L29:
            r113 = false;
            goto L36
        L28:
            if (r108.isEmpty() == false) goto L30;
        L18:
            r107 = false;
            goto L25
        L17:
            if (r105.isEmpty() == false) goto L19;
        L13:
            r102 = CollectionsKt.emptyList();     // Catch: Throwable -> L38
        L38:
            th = move-exception;
            LogUtils.w(SvaNotificationListenerService.TAG, "log notification listener permission failed, scene: " + r112, new Object[]{th});
        }

        public static final /* synthetic */ void access$logNotificationListenerPermission(Companion r100, Context r101, ComponentName r102, String r103) {
            r100.logNotificationListenerPermission(r101, r102, r103);
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final void requestRebind(Context r100) {
        Companion.requestRebind(r100);
    }

    @Override // android.service.notification.NotificationListenerService
    public void onListenerConnected() {
        super.onListenerConnected();
        LogUtils.i(TAG, "onListenerConnected", new Object[0]);
        Companion.access$logNotificationListenerPermission(Companion, this, new ComponentName(this, SvaNotificationListenerService.class), "onListenerConnected");
        SvaNotificationDispatchService.Dispatcher.INSTANCE.dispatchListenerConnected();
    }

    @Override // android.service.notification.NotificationListenerService
    public void onListenerDisconnected() {
        super.onListenerDisconnected();
        LogUtils.i(TAG, "onListenerDisconnected", new Object[0]);
        SvaNotificationDispatchService.Dispatcher.INSTANCE.dispatchListenerDisconnected();
    }

    public SvaNotificationListenerService() {
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationPosted(StatusBarNotification r100) {
        super.onNotificationPosted(r100);
        StringBuilder r101 = new StringBuilder("onNotificationPosted: ");
        Long r102 = null;
        if (r100 == null) goto L5;
        String r103 = r100.getPackageName();
    L6:
        r101.append(r103);
        r101.append(", when: ");
        if (r100 == null) goto L9;
        r102 = Long.valueOf(r100.getPostTime());
    L9:
        r101.append(r102);
        LogUtils.i(TAG, r101.toString(), new Object[0]);
        SvaNotificationDispatchService.Dispatcher.INSTANCE.dispatchNotificationPosted(getApplicationContext(), r100);
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationRemoved(StatusBarNotification r100) {
        super.onNotificationRemoved(r100);
        StringBuilder r101 = new StringBuilder("onNotificationRemoved: ");
        Long r102 = null;
        if (r100 == null) goto L5;
        String r103 = r100.getPackageName();
    L6:
        r101.append(r103);
        r101.append(", when: ");
        if (r100 == null) goto L9;
        r102 = Long.valueOf(r100.getPostTime());
    L9:
        r101.append(r102);
        LogUtils.i(TAG, r101.toString(), new Object[0]);
        SvaNotificationDispatchService.Dispatcher.INSTANCE.dispatchNotificationRemoved(r100);
        return;
    L5:
        r103 = null;
        goto L6
    }
}
