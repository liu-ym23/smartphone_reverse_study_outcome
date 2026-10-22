package com.bytedance.push.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.android.service.manager.push.notification.INotificationMonitorService;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.common.push.BaseJson;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.push.settings.PushOnlineSettings;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.message.AppProvider;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class NotificationShowMonitor extends BaseJson implements INotificationMonitorService {
    private static NotificationShowMonitor mNotificationShowMonitor;
    private final String EVENT_NAME_BD_NOTIFICATION_INTERCEPT_EVENT;
    private final String EVENT_NAME_BD_NOTIFICATION_MONITOR_EVENT;
    private final int MAX_SIZE_TARGET_PKG_MAP;
    private final String TAG;
    private final AtomicBoolean mInit;
    private long mLastMonitorNotificationFromOthersAppTimeStamp;
    private final Map<Object, String> mTargetPkgMap;
    private List<String> reportedHistory;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NotificationShowMonitor f266901a;

        /* JADX INFO: renamed from: com.bytedance.push.notification.NotificationShowMonitor$a$a, reason: collision with other inner class name */
        /* JADX INFO: loaded from: classes21.dex */
        public class C3735a implements Observer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ u77.g f266902a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f266903b;

            /* JADX INFO: renamed from: com.bytedance.push.notification.NotificationShowMonitor$a$a$a, reason: collision with other inner class name */
            public class RunnableC3736a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ C3735a f266904a;

                @Override // java.lang.Runnable
                public final void run() {
                    NotificationShowMonitor.access$000(this.f266904a.f266903b.f266901a);     // Catch: Throwable -> L4
                    return;
                L4:
                    th = move-exception;
                    if (RunnableProtector.intercept(th) == false) goto L8;
                    return;
                L8:
                    throw th;
                }

                public RunnableC3736a(C3735a r100) {
                    this.f266904a = r100;
                }
            }

            public C3735a(a r100, u77.g r101) {
                this.f266903b = r100;
                this.f266902a = r101;
            }

            @Override // java.util.Observer
            public void update(Observable r100, Object r101) {
                boolean r102 = ((Boolean) r101).booleanValue();
                com.bytedance.push.utils.f.b("PushMonitorShowService", "[onAppStatusUpdate]isInBackGround:" + r102);
                if (r102 == true) goto L10;
                long r103 = System.currentTimeMillis() - NotificationShowMonitor.access$100(this.f266903b.f266901a);
                if (r103 >= this.f266902a.f549059o) goto L8;
                com.bytedance.push.utils.f.b("PushMonitorShowService", "[onAppStatusUpdate]not monitorNotificationFromOthersApp because frequency control,monitorInterval:" + r103 + " minMonitorInterval:" + this.f266902a.f549059o);
                return;
            L8:
                PushThreadHandlerManager.inst().postRunnable(new RunnableC3736a(this));
                return;
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L20;
            throw th;
        L20:
            return;
        L3:
            if (ToolUtils.isMainProcess(AppProvider.getApp()) == true) goto L6;
            return;
        L6:
            if (Build.VERSION.SDK_INT < 23) goto L18;
            u77.g r100 = u77.g.a();     // Catch: Throwable -> L11
            if (r100.f549045a == false) goto L19;
            NotificationShowMonitor.access$000(this.f266901a);     // Catch: Throwable -> L11
            ActivityLifecycleObserver.getIns().addObserver(new C3735a(this, r100));     // Catch: Throwable -> L11
            return;
        L19:
            return;
        }

        public a(NotificationShowMonitor r100) {
            this.f266901a = r100;
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f266905a;

        @Override // java.lang.Runnable
        public final void run() {
            JSONObject r100 = this.f266905a.c();     // Catch: Throwable -> L4
            com.bytedance.push.utils.f.b("PushMonitorShowService", "[onNotificationShow]notificationEvent is " + r100);     // Catch: Throwable -> L4
            PushServiceManager.get().getPushExternalService().getMultiProcessEventSenderService().onEventV3("bdpush_notification_event", r100);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(k r100) {
            this.f266905a = r100;
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f266906a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f266907b;

        public final void a() {
            k r100 = this.f266906a;
            r100.f266972e = this.f266907b;
            JSONObject r101 = r100.c();
            com.bytedance.push.utils.f.b("PushMonitorShowService", "[onForeGroundNotificationShow]notificationEvent is " + r101);
            PushServiceManager.get().getPushExternalService().getMultiProcessEventSenderService().onEventV3("bdpush_notification_event", r101);
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

        public c(k r100, boolean r101) {
            this.f266906a = r100;
            this.f266907b = r101;
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f266908a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f266909b;

        public final void a() {
            JSONObject r100 = this.f266908a.c();
            r100.put("reason", this.f266909b);     // Catch: Throwable -> L5
        L7:
            com.bytedance.push.utils.f.b("PushMonitorShowService", "[onNotificationIntercept]bdpush_notification_intercept_event params is " + r100);
            PushServiceManager.get().getPushExternalService().getMultiProcessEventSenderService().onEventV3("bdpush_notification_intercept_event", r100);
            return;
        L5:
            th = move-exception;
            com.bytedance.push.utils.f.f("PushMonitorShowService", "error when put reason to params ", th);
            goto L7
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

        public d(k r100, String r101) {
            this.f266908a = r100;
            this.f266909b = r101;
        }
    }

    private String getStack() {
        StringBuilder r100 = new StringBuilder();
        StackTraceElement[] r101 = new Throwable().getStackTrace();
        int r102 = r101.length;
        int r103 = 0;
        boolean r104 = false;
    L3:
        if (r103 >= r102) goto L19;
        StackTraceElement r105 = r101[r103];
        if (TextUtils.equals(r105.getClassName(), "android.app.Service") == false) goto L11;
        if (TextUtils.equals(r105.getMethodName(), "startForeground") == false) goto L11;
        r100.append("android.app.Service#startForeground");
    L9:
        r104 = true;
    L17:
        r103 = r103 + 1;
    L11:
        if (TextUtils.equals(r105.getClassName(), "android.app.NotificationManager") == true) goto L13;
    L15:
        if (r104 == false) goto L17;
        r100.append(String.format(" <- %s#%s#%s", new Object[]{r105.getClassName(), r105.getMethodName(), Integer.valueOf(r105.getLineNumber())}));
        goto L17
    L13:
        if (TextUtils.equals(r105.getMethodName(), "notifyAsUser") == false) goto L15;
        r100.append("android.app.NotificationManager#notifyAsUser");
        goto L9
    L19:
        return r100.toString();
    }

    public static NotificationShowMonitor inst() {
        if (mNotificationShowMonitor != null) goto L15;
        monitor-enter(NotificationShowMonitor.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mNotificationShowMonitor != null) goto L9;
        mNotificationShowMonitor = new NotificationShowMonitor();     // Catch: Throwable -> L11
    L9:
        monitor-exit(NotificationShowMonitor.class);     // Catch: Throwable -> L11
    L15:
        return mNotificationShowMonitor;
    }

    private synchronized void monitorNotificationFromOthersApp() {
        monitor-enter(this);
        u77.g r100 = u77.g.a();     // Catch: Throwable -> L53
        long r101 = System.currentTimeMillis() - this.mLastMonitorNotificationFromOthersAppTimeStamp;     // Catch: Throwable -> L53
        if (r101 >= r100.f549059o) goto L9;
        com.bytedance.push.utils.f.b("PushMonitorShowService", "[monitorNotificationFromOthersApp]not monitorNotificationFromOthersApp because frequency control,monitorInterval:" + r101 + " minMonitorInterval:" + r100.f549059o);     // Catch: Throwable -> L53
        monitor-exit(this);
        return;
    L9:
        this.mLastMonitorNotificationFromOthersAppTimeStamp = System.currentTimeMillis();     // Catch: Throwable -> L53
        com.bytedance.push.utils.f.b("PushMonitorShowService", "[monitorNotificationFromOthersApp]monitorNotificationFromOthersApp");     // Catch: Throwable -> L53
        NotificationManager r102 = (NotificationManager) AppProvider.getApp().getSystemService("notification");     // Catch: Throwable -> L53
        if (r102 != null) goto L13;
        monitor-exit(this);
        return;
    L13:
        StatusBarNotification[] r103 = r102.getActiveNotifications();     // Catch: Throwable -> L53
        if (r103 != null) goto L17;
        monitor-exit(this);
        return;
    L17:
        ArrayList r104 = new ArrayList();     // Catch: Throwable -> L53
        int r105 = r103.length;     // Catch: Throwable -> L53
        int r106 = 0;
    L18:
        boolean r107 = true;
        if (r106 >= r105) goto L47;
        StatusBarNotification r108 = r103[r106];     // Catch: Throwable -> L53
        com.bytedance.push.utils.f.b("PushMonitorShowService", "[onOthersAppNotification]cur statusBarNotification tag:" + r108.getTag() + " id:" + r108.getId());     // Catch: Throwable -> L53
        String r109 = r108.getTag();     // Catch: Throwable -> L53
        List<String> r110 = r100.f549060p;     // Catch: Throwable -> L53
        if (r110 == null) goto L31;
        Iterator r111 = ((ArrayList) r110).iterator();     // Catch: Throwable -> L53
    L24:
        if (r111.hasNext() == false) goto L28;
        String r112 = (String) r111.next();     // Catch: Throwable -> L53
        if (com.bytedance.push.utils.h.a(r109, r112) == false) goto L24;
        com.bytedance.push.utils.f.b("PushMonitorShowService", "[monitorNotificationFromOthersApp]cur notification is group notification,do nothing curTag:" + r109 + " groupTag:" + r112);     // Catch: Throwable -> L53
        boolean r113 = true;
    L29:
        if (r113 == false) goto L31;
    L46:
        r106 = r106 + 1;     // Catch: Throwable -> L53
        goto L18
    L28:
        r113 = false;
    L31:
        Notification r114 = r108.getNotification();     // Catch: Throwable -> L53
        String r115 = r114.getGroup();     // Catch: Throwable -> L53
        List<String> r116 = r100.f549061q;     // Catch: Throwable -> L53
        if (r116 == null) goto L42;
        Iterator r117 = ((ArrayList) r116).iterator();     // Catch: Throwable -> L53
    L35:
        if (r117.hasNext() == false) goto L39;
        String r118 = (String) r117.next();     // Catch: Throwable -> L53
        if (com.bytedance.push.utils.h.a(r115, r118) == false) goto L35;
        com.bytedance.push.utils.f.b("PushMonitorShowService", "[monitorNotificationFromOthersApp]cur notification is group notification,do nothing,curGroup:" + r115 + " groupName:" + r118);     // Catch: Throwable -> L53
    L40:
        if (r107 == false) goto L42;
    L39:
        r107 = false;
    L42:
        String r119 = getNotificationIdStr(r109, r108.getId(), r114);     // Catch: Throwable -> L53
        r104.add(r119);     // Catch: Throwable -> L53
        if (this.reportedHistory.contains(r119) == false) goto L45;
        com.bytedance.push.utils.f.b("PushMonitorShowService", "[monitorNotificationFromOthersApp]cur notification has reported,do nothing");     // Catch: Throwable -> L53
        goto L46
    L45:
        this.reportedHistory.add(r119);     // Catch: Throwable -> L53
        onOthersAppNotification(r108);     // Catch: Throwable -> L53
        goto L46
    L47:
        int r120 = this.reportedHistory.size();     // Catch: Throwable -> L53
        if (r104.size() != 0) goto L50;
        this.reportedHistory.clear();     // Catch: Throwable -> L53
    L51:
        com.bytedance.push.utils.f.b("PushMonitorShowService", "[monitorNotificationFromOthersApp]retainAllResult:" + r107 + " before retain size:" + r120 + " after retain size:" + this.reportedHistory.size());     // Catch: Throwable -> L53
    L55:
        monitor-exit(this);
        return;
    L50:
        r107 = this.reportedHistory.retainAll(r104);     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        com.bytedance.push.utils.f.f("PushMonitorShowService", "[monitorNotificationFromOthersApp]exception: ", th);     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        throw th;
    }

    public void init() {
        if (this.mInit.getAndSet(true) == false) goto L5;
        return;
    L5:
        ThreadPlus.runOnChildThread(new a(this));
    }

    public NotificationShowMonitor() {
        this.TAG = "PushMonitorShowService";
        this.EVENT_NAME_BD_NOTIFICATION_MONITOR_EVENT = "bdpush_notification_event";
        this.EVENT_NAME_BD_NOTIFICATION_INTERCEPT_EVENT = "bdpush_notification_intercept_event";
        this.MAX_SIZE_TARGET_PKG_MAP = 10;
        this.mTargetPkgMap = new MaxSizeHashMap(10);
        this.mInit = new AtomicBoolean(false);
        this.reportedHistory = new CopyOnWriteArrayList();
    }

    @Override // com.bytedance.android.service.manager.push.notification.INotificationMonitorService
    public boolean enableMonitorNotificationShow() {
        return u77.g.a().f549045a;
    }

    public static /* synthetic */ void access$000(NotificationShowMonitor r100) {
        r100.monitorNotificationFromOthersApp();
    }

    public static /* synthetic */ long access$100(NotificationShowMonitor r100) {
        return r100.mLastMonitorNotificationFromOthersAppTimeStamp;
    }

    private boolean isEmptyNotification(Notification r100) {
        Bundle r101 = r100.extras;
        if (r101 != null) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(r101.getString(NotificationCompat.EXTRA_TITLE)) == false) goto L8;
    L9:
        return true;
    L8:
        if (TextUtils.isEmpty(r100.extras.getString(NotificationCompat.EXTRA_TEXT)) == true) goto L9;
        return false;
    }

    public String getContentIntentFromPendingIntent(PendingIntent r100) {
        Object r101 = com.bytedance.push.utils.b.c(IntentSender.class, "mTarget").get(r100.getIntentSender());     // Catch: Throwable -> L4
        return this.mTargetPkgMap.get(r101);
    L4:
        th = move-exception;
        com.bytedance.push.utils.f.f("PushMonitorShowService", "error when getContentIntentFromPendingIntent ", th);
        return null;
    }

    public void onOthersAppNotification(StatusBarNotification r100) {
        Notification r101 = r100.getNotification();
        u77.g r102 = u77.g.a();
        k r103 = new k(r101, 3, r102.f549057m);
        String r104 = (String) com.bytedance.push.utils.b.c(StatusBarNotification.class, "opPkg").get(r100);     // Catch: Throwable -> L5
        r103.f266977j = r104;     // Catch: Throwable -> L5
        com.bytedance.push.utils.f.b("PushMonitorShowService", "[onOthersAppNotification]opPkg:" + r104);     // Catch: Throwable -> L5
    L7:
        boolean r105 = isValidNotificationStyle(r103, r101);
        r103.f266972e = r105;
        if (r105 == true) goto L10;
    L15:
        JSONObject r106 = r103.c();
        com.bytedance.push.utils.f.b("PushMonitorShowService", "[onOthersAppNotification]notificationEvent is " + r106);
        PushServiceManager.get().getPushExternalService().getMultiProcessEventSenderService().onEventV3("bdpush_notification_event", r106);
    L16:
        if (r105 == true) goto L23;
        NotificationManager r107 = (NotificationManager) AppProvider.getApp().getSystemService("notification");
        if (r107 == null) goto L24;
        com.bytedance.push.utils.f.b("PushMonitorShowService", "[onOthersAppNotification]auto cancel cur invalid notification,tag:" + r100.getTag() + " id:" + r100.getId());
        r107.cancel(r100.getTag(), r100.getId());
        return;
    L24:
        return;
    L23:
        return;
    L10:
        if (r103.f266973f == true) goto L15;
        if (r102.f549046b == true) goto L15;
        com.bytedance.push.utils.f.b("PushMonitorShowService", "[onOthersAppNotification]not report cur notificationEvent because cur notification is valid and mNotificationMonitorSettingsModel.reportValidNotification is false");
    L5:
        th = move-exception;
        com.bytedance.push.utils.f.f("PushMonitorShowService", "[onOthersAppNotification]error when get opPkg ", th);
        goto L7
    }

    public void removeContentIntent(PendingIntent r100) {
        this.mTargetPkgMap.remove(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.bytedance.push.utils.f.f("PushMonitorShowService", "error when removeContentIntent ", th);
    }

    private void onNotificationIntercept(k r100, String r101) {
        PushThreadHandlerManager.inst().postRunnable(new d(r100, r101));
    }

    public boolean isValidNotificationStyle(k r110, Notification r111) {
        if (r111 != null) goto L6;
        com.bytedance.push.utils.f.e("PushMonitorShowService", "[isInvalidNotificationStyle]invalid null notification");
        onNotificationIntercept(r110, "notification is null");
        return false;
    L6:
        u77.g r100 = u77.g.a();
        if (TextUtils.isEmpty(r111.getGroup()) == false) goto L9;
    L16:
        long r101 = System.currentTimeMillis();
        if (r101 < r111.when) goto L19;
    L22:
        int r102 = r111.flags;
        if ((r102 & 2) == 0) goto L29;
        if (r100.f549052h == false) goto L29;
        com.bytedance.push.utils.f.e("PushMonitorShowService", "[isInvalidNotificationStyle]notification is invalid because notification is want on top with on_going flag,flag is " + r111.flags);
        onNotificationIntercept(r110, "notification want on going");
        return false;
    L29:
        if ((r102 & 16) != 0) goto L35;
        if (r100.f549053i == false) goto L35;
        com.bytedance.push.utils.f.e("PushMonitorShowService", "[isInvalidNotificationStyle]notification is invalid because notification is not auto_cancel, flag is " + r111.flags);
        onNotificationIntercept(r110, "notification not auto cancel");
        return false;
    L35:
        if (r100.f549054j == false) goto L45;
        String r103 = getContentIntentFromPendingIntent(r111.contentIntent);     // Catch: Throwable -> L42
        if (TextUtils.isEmpty(r103) == true) goto L45;
        if (TextUtils.equals(r103, AppProvider.getApp().getPackageName()) == true) goto L45;
        onNotificationIntercept(r110, "target pendingIntent is others pkg");     // Catch: Throwable -> L42
        com.bytedance.push.utils.f.e("PushMonitorShowService", "[isInvalidNotificationStyle]notification is invalid because notification#contentIntent is invalid,targetPkg:" + r103);     // Catch: Throwable -> L42
        return false;
    L42:
        th = move-exception;
        com.bytedance.push.utils.f.e("PushMonitorShowService", "[isInvalidNotificationStyle]error when parse target intent " + th);
    L45:
        if (r100.f549056l == null) goto L54;
        Bundle r104 = r111.extras;
        if (r104 == null) goto L54;
        String r105 = r104.getString(NotificationCompat.EXTRA_TEMPLATE);
        if (TextUtils.isEmpty(r105) == true) goto L54;
        if (((ArrayList) r100.f549056l).contains(r105) == false) goto L54;
        com.bytedance.push.utils.f.e("PushMonitorShowService", "[isInvalidNotificationStyle]notification is invalid because cur template is in  needInterceptStyleList, template is " + r105);
        onNotificationIntercept(r110, "invalid notification style");
        return false;
    L54:
        int r106 = 1;
        if (r100.f549055k == null) goto L121;
        StackTraceElement[] r107 = new Throwable().getStackTrace();
        Iterator r108 = ((ArrayList) r100.f549055k).iterator();
    L58:
        if (r108.hasNext() == false) goto L121;
        List r112 = (List) r108.next();
        if (r112.size() <= r106) goto L72;
        int r113 = r107.length;
        int r114 = 0;
        int r115 = 0;
    L62:
        if (r114 >= r113) goto L72;
        StackTraceElement r116 = r107[r114];
        if (r115 == (r112.size() - r106)) goto L73;
        if (TextUtils.equals(r116.getClassName() + "#" + r116.getMethodName() + "#" + r116.getLineNumber(), (CharSequence) ListProtector.get(r112, r115)) == false) goto L69;
        r115 = r115 + 1;
    L71:
        r114 = r114 + 1;
        r106 = 1;
        goto L62
    L69:
        if (r115 <= 0) goto L71;
        r115 = 0;
    L73:
        if (r106 != 0) goto L74;
        r106 = 1;
        goto L58
    L74:
        onNotificationIntercept(r110, "intercept by stack");
        com.bytedance.push.utils.f.e("PushMonitorShowService", "[isInvalidNotificationStyle]notification is invalid because cur stack match the intercept stack");
        return false;
    L72:
        r106 = 0;
    L121:
        u77.j r109 = ((PushOnlineSettings) j77.i.a(AppProvider.getApp(), PushOnlineSettings.class)).k();     // Catch: Throwable -> L118
        if (r109.f549062a == false) goto L107;
        if (Build.VERSION.SDK_INT < 26) goto L107;
        if (com.bytedance.push.utils.j.g() == false) goto L107;
        if (r109.f549063b != 2) goto L107;
        String r117 = r111.getChannelId();     // Catch: Throwable -> L118
        NotificationManager r118 = (NotificationManager) AppProvider.getApp().getSystemService("notification");     // Catch: Throwable -> L118
        if (r118 == null) goto L94;
        NotificationChannel r119 = r118.getNotificationChannel(r117);     // Catch: Throwable -> L118
        if (r119 == null) goto L94;
        if (r119.getImportance() <= 2) goto L94;
        if (r111.extras.getInt("push_sdk_harmony_os4_channel_importance_expectation", 5) >= r119.getImportance()) goto L94;
        boolean r120 = true;
    L96:
        if (TextUtils.isEmpty(r111.category) == false) goto L98;
        r120 = true;
    L98:
        String r121 = r111.extras.getString(NotificationCompat.EXTRA_TEMPLATE, "");     // Catch: Throwable -> L118
        if (r121.toLowerCase().contains("mediastyle") == true) goto L102;
        if (r121.toLowerCase().contains("decoratedmediacustomviewstyle") == true) goto L102;
    L103:
        if (r120 == false) goto L107;
        return false;
    L102:
        r120 = false;
    L94:
        r120 = false;
    L107:
        if (needInterceptNotificationForTargetText(r110, r111) == false) goto L111;
        com.bytedance.push.utils.f.e("PushMonitorShowService", "[isInvalidNotificationStyle]notification is invalid because cur is match target reg");
        onNotificationIntercept(r110, "target reg notification");
        return false;
    L111:
        if (r100.f549047c == true) goto L113;
        return true;
    L113:
        if (isEmptyNotification(r111) == false) goto L129;
        com.bytedance.push.utils.f.e("PushMonitorShowService", "[isInvalidNotificationStyle]notification is invalid because cur is empty notification,intercept it");
        onNotificationIntercept(r110, "empty notification");
        return false;
    L129:
        return true;
    L19:
        if (r100.f549051g == false) goto L22;
        com.bytedance.push.utils.f.e("PushMonitorShowService", "[isInvalidNotificationStyle]notification is invalid because notification#when is in the feature,currentTimeMillis is " + r101 + " notification#when is " + r111.when);
        onNotificationIntercept(r110, "notification want on top");
        return false;
    L9:
        if (r100.f549049e == false) goto L16;
        List<String> r122 = r100.f549050f;
        if (r122 == null) goto L16;
        if (((ArrayList) r122).contains(r111.getGroup()) == true) goto L16;
        com.bytedance.push.utils.f.e("PushMonitorShowService", "[isInvalidNotificationStyle]notification is invalid because group is not null:" + r111.getGroup());
        onNotificationIntercept(r110, "notification has group");
        return false;
    }

    public boolean needInterceptNotificationForTargetText(k r110, Notification r111) {
        if (r111 != null) goto L6;
        com.bytedance.push.utils.f.e("PushMonitorShowService", "[needInterceptNotificationForTargetText]not target notification because cur notification is null");
        return false;
    L6:
        List<u77.n> r100 = u77.g.a().f549058n;
        if (r100 == null) goto L30;
        ArrayList r101 = (ArrayList) r100;
        if (r101.isEmpty() == true) goto L30;
        Bundle r102 = r111.extras;
        if (r102 == null) goto L29;
        String r103 = r102.getString(NotificationCompat.EXTRA_TITLE);
        String r104 = r111.extras.getString(NotificationCompat.EXTRA_TEXT);
        String r105 = r111.extras.getString(NotificationCompat.EXTRA_BIG_TEXT);
        String r112 = r111.extras.getString("android.tickerText");
        if (com.bytedance.push.utils.f.f267065a == false) goto L15;
        com.bytedance.push.utils.f.b("PushMonitorShowService", "[needInterceptNotificationForTargetText]title:" + r103 + " text:" + r104 + " bigText:" + r105 + " tickerText:" + r112);
    L15:
        Iterator r106 = r101.iterator();
    L17:
        if (r106.hasNext() == false) goto L28;
        u77.n r107 = (u77.n) r106.next();
        com.bytedance.push.utils.f.b("PushMonitorShowService", "[needInterceptNotificationForTargetText]try match text with targetTextMonitorModel:" + r107);
        if (com.bytedance.push.utils.h.a(r103, r107.f549064a) == true) goto L26;
        if (com.bytedance.push.utils.h.a(r104, r107.f549064a) == true) goto L26;
        if (com.bytedance.push.utils.h.a(r105, r107.f549064a) == true) goto L26;
        if (com.bytedance.push.utils.h.a(r112, r107.f549064a) == false) goto L17;
    L26:
        com.bytedance.push.utils.f.b("PushMonitorShowService", "[needInterceptNotificationForTargetText]cur notification match the targetTextReg,targetTextReg:" + r107 + " title:" + r103 + " text:" + r104 + " bigText:" + r105 + " tickerText:" + r112);
        r110.f266976i = r107.f549065b;
        r110.f266974g = r107.f549064a;
        r110.f266973f = true;
        return r107.f549066c;
    L28:
        com.bytedance.push.utils.f.i("PushMonitorShowService", "[needInterceptNotificationForTargetText]text not match any targetTextReg");
    L31:
        return false;
    L29:
        com.bytedance.push.utils.f.i("PushMonitorShowService", "[needInterceptNotificationForTargetText]not match target text because notification.extras is null");
    L30:
        com.bytedance.push.utils.f.i("PushMonitorShowService", "[needInterceptNotificationForTargetText]not match target text because  mNotificationMonitorSettingsModel.targetTextRegList is empty");
        goto L31
    }

    @Override // com.bytedance.android.service.manager.push.notification.INotificationMonitorService
    public boolean onForeGroundNotificationShow(ComponentName r100, Notification r101) {
        u77.g r102 = u77.g.a();
        this.reportedHistory.add(getNotificationIdStr("fore_ground", 0, r101));
        k r103 = new k(r101, r100, r102.f549057m);
        boolean r104 = isValidNotificationStyle(r103, r101);
        r103.f266975h = getStack();
        if (r104 == true) goto L5;
    L10:
        ThreadPlus.submitRunnable(new c(r103, r104));
    L12:
        if (r102.f549048d == false) goto L14;
        return r104;
    L14:
        if (r104 == true) goto L18;
        com.bytedance.push.utils.f.i("PushMonitorShowService", "[onForeGroundNotificationShow]cur foreground notification is invalid but  allowInterceptForegroundNotification is false,not intercept");
        return true;
    L18:
        return true;
    L5:
        if (r103.f266973f == true) goto L10;
        if (r102.f549046b == true) goto L10;
        com.bytedance.push.utils.f.b("PushMonitorShowService", "[onForeGroundNotificationShow]not report cur notificationEvent because cur notification is valid and mNotificationMonitorSettingsModel.reportValidNotification is false");
        goto L12
    }

    @Override // com.bytedance.android.service.manager.push.notification.INotificationMonitorService
    public void onPendingIntent(Object r100, Intent r101) {
        if (r101 == null) goto L14;
        if (r100 == null) goto L16;
        String r102 = r101.getPackage();
        if (TextUtils.isEmpty(r102) == false) goto L11;
        ComponentName r103 = r101.getComponent();
        if (r103 == null) goto L11;
        r102 = r103.getPackageName();
    L11:
        if (TextUtils.isEmpty(r102) == true) goto L15;
        this.mTargetPkgMap.put(r100, r102);
        return;
    L15:
        return;
    L16:
        return;
    }

    private String getNotificationIdStr(String r100, int r101, Notification r102) {
        Field r103 = com.bytedance.push.utils.b.c(Notification.class, "creationTime");     // Catch: Throwable -> L7
        if (r103 == null) goto L10;
        return String.format("%s", new Object[]{Long.valueOf(((Long) r103.get(r102)).longValue())});
    L10:
        return String.format("%s-%s", new Object[]{r100, Integer.valueOf(r101)});
    L7:
        th = move-exception;
        com.bytedance.push.utils.f.f("PushMonitorShowService", "[getNotificationIdStr]error when get creationTime ", th);
        goto L10
    }

    public boolean onNotificationShow(String r100, int r101, Notification r102) {
        this.reportedHistory.add(getNotificationIdStr(r100, r101, r102));
        u77.g r103 = u77.g.a();
        k r104 = new k(r102, 1, r103.f549057m);
        boolean r105 = isValidNotificationStyle(r104, r102);
        r104.f266972e = r105;
        r104.f266975h = getStack();
        if (r105 == true) goto L5;
    L10:
        ThreadPlus.submitRunnable(new b(r104));
    L11:
        return r105;
    L5:
        if (r104.f266973f == true) goto L10;
        if (r103.f549046b == true) goto L10;
        com.bytedance.push.utils.f.b("PushMonitorShowService", "[onNotificationShow]not report cur notificationEvent because cur notification is valid and mNotificationMonitorSettingsModel.reportValidNotification is false");
        goto L11
    }
}
