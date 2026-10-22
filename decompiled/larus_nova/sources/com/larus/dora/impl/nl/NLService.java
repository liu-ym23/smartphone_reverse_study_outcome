package com.larus.dora.impl.nl;

import android.app.KeyguardManager;
import android.app.Notification;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.dora.device.DoraDevice;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.DoraConfig;
import com.larus.dora.api.INLService;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.obric.assistant.spi.notification.IObricInteractorNotificationCallback;
import com.obric.assistant.spi.notification.IObricInteractorNotificationService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class NLService extends NotificationListenerService {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final NLServiceImpl f336226g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AudioManager f336227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IObricInteractorNotificationService f336228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f336229c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f336230d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IObricInteractorNotificationCallback f336231e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f336232f;

    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NLService f336233a;

        public a(NLService r100) {
            this.f336233a = r100;
        }

        @Override // android.content.ServiceConnection
        public final void onBindingDied(ComponentName r100) {
            g49.d.d("NLService", "SvaNtfctionService connection: onBindingDied: " + r100);
            NLService r101 = this.f336233a;
            r101.f336230d = false;
            r101.f336228b = null;
        }

        @Override // android.content.ServiceConnection
        public final void onNullBinding(ComponentName r100) {
            g49.d.d("NLService", "SvaNtfctionService connection: onNullBinding: " + r100);
            NLService r101 = this.f336233a;
            r101.f336230d = false;
            r101.f336228b = null;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r100) {
            g49.d.d("NLService", "SvaNtfctionService connection: onServiceDisconnected: " + r100);
            NLService r101 = this.f336233a;
            r101.f336230d = false;
            r101.f336228b = null;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r100, IBinder r101) {
            g49.d.d("NLService", "SvaNtfctionService connection: onServiceConnected: " + r100);
            this.f336233a.f336228b = IObricInteractorNotificationService.Stub.asInterface(r101);
            NLService r102 = this.f336233a;
            IObricInteractorNotificationService r103 = r102.f336228b;
            if (r103 != null) goto L5;
            return;
        L5:
            if (r102.f336230d == true) goto L15;
            r103.registerCallback(r102.f336231e);     // Catch: RemoteException -> L9
            r102.f336230d = true;     // Catch: RemoteException -> L9
            g49.d.d("NLService", "register interactor notification callback");     // Catch: RemoteException -> L9
            return;
        L9:
            e = move-exception;
            g49.d.c("NLService", "registerInteractorNotificationCallback", e);
            return;
        }
    }

    @Override // android.service.notification.NotificationListenerService, android.app.Service
    public final void onDestroy() {
        IObricInteractorNotificationService r100 = this.f336228b;
        if (r100 != null) goto L5;
    L10:
        this.f336230d = false;
        this.f336228b = null;
        if (this.f336229c == true) goto L22;
    L20:
        super.onDestroy();
        return;
    L22:
        unbindService(this.f336232f);     // Catch: Throwable -> L14
        g49.d.d("NLService", "unbind interactor notification service");     // Catch: Throwable -> L14
    L16:
        this.f336229c = false;
    L14:
        th = move-exception;
        g49.d.c("NLService", "unbindInteractorNotificationServiceIfNeeded", th);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        this.f336229c = false;
        throw th;
    L5:
        if (this.f336230d == false) goto L10;
        r100.unregisterCallback(this.f336231e);     // Catch: RemoteException -> L8
        g49.d.d("NLService", "unregister interactor notification callback");     // Catch: RemoteException -> L8
    L8:
        e = move-exception;
        g49.d.c("NLService", "unbindInteractorNotificationServiceIfNeeded", e);
        goto L10
    }

    static {
        f336226g = (NLServiceImpl) ServiceManager.get().getService(INLService.class);
    }

    public NLService() {
        this.f336227a = null;
        this.f336228b = null;
        this.f336229c = false;
        this.f336230d = false;
        this.f336231e = new AnonymousClass1(this);
        this.f336232f = new a(this);
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        IObricDoraService r100 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r100 != null) goto L5;
    L11:
        g49.d.d("NLService", "skip bind sva notification service");
        return;
    L5:
        if (r100.m() == false) goto L11;
        Intent r101 = new Intent();     // Catch: Throwable -> L9
        r101.setComponent(new ComponentName(getPackageName(), "com.obric.sva.sdk.notification.SvaNotificationDispatchService"));     // Catch: Throwable -> L9
        boolean r102 = bindService(r101, this.f336232f, 1);     // Catch: Throwable -> L9
        this.f336229c = r102;     // Catch: Throwable -> L9
        g49.d.d("NLService", "bind sva notification service: " + r102);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        g49.d.c("NLService", "bindSvaNotificationServiceIfNeeded error: ", th);
    }

    @Override // android.service.notification.NotificationListenerService
    public final void onListenerConnected() {
        super.onListenerConnected();
        g49.d.d("NLService", "onListenerConnected");
        NLServiceImpl r100 = f336226g;
        if (r100 == null) goto L6;
        r100.e(1);
        return;
    }

    @Override // android.service.notification.NotificationListenerService
    public final void onListenerDisconnected() {
        super.onListenerDisconnected();
        g49.d.d("NLService", "onListenerDisconnected");
        NLServiceImpl r100 = f336226g;
        if (r100 == null) goto L6;
        r100.e(2);
        return;
    }

    public static c49.a b(StatusBarNotification r110) {
        int r100 = r110.getId();
        String r101 = r110.getPackageName();
        AtomicBoolean r102 = n.f336286a;
        if (r101 != null) goto L5;
    L12:
        String r103 = r101;
    L13:
        long r104 = r110.getPostTime();
        Notification r105 = r110.getNotification();
        String r106 = null;
        if (r105 != null) goto L16;
        String r107 = null;
        String r108 = null;
        String r109 = null;
        String r111 = null;
        int r112 = 0;
    L25:
        return new c49.a(r100, r104, r101, r103, r107, r106, r108, r109, r111, r112, r110);
    L16:
        if (Build.VERSION.SDK_INT < 26) goto L18;
        String r113 = r105.getChannelId();
    L19:
        String r114 = r105.category;
        int r115 = r105.flags;
        Bundle r116 = r105.extras;
        if (r116 == null) goto L22;
        String r117 = r116.getCharSequence(NotificationCompat.EXTRA_TITLE, "").toString();
        String r118 = r116.getCharSequence(NotificationCompat.EXTRA_SUB_TEXT, "").toString();
        r111 = r114;
        r108 = r116.getCharSequence(NotificationCompat.EXTRA_TEXT, "").toString();
        r107 = r117;
        r106 = r118;
        r112 = r115;
        r109 = r113;
        goto L25
    L22:
        r107 = null;
        r111 = r114;
        r112 = r115;
        r109 = r113;
        r108 = null;
        goto L25
    L18:
        r113 = null;
        goto L19
    L5:
        if (r101.isEmpty() == true) goto L12;
        PackageManager r119 = pk4.n.f529659c.getPackageManager();
        r103 = r119.getApplicationLabel(r119.getApplicationInfo(r101, 0)).toString();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        g49.d.b("NLUtils", "getAppName" + Log.getStackTraceString(th));
        goto L12
    }

    public final void c(final StatusBarNotification r100) {
        if (r100 != null) goto L6;
        g49.d.d("NLService", "onNotificationPosted: sbn is null");
        return;
    L6:
        IDoraAVLinkService r101 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r101 != null) goto L9;
    L11:
        boolean r102 = false;
    L12:
        if (r102 == false) goto L14;
        g49.d.d("NLService", "Abandon this push isDoraNotifyDegrade is true, onNotificationPosted " + r100.getPackageName() + "  when: " + r100.getPostTime());
        return;
    L14:
        c49.a r103 = b(r100);
        int r104 = a(r100, 0);
        com.larus.dora.impl.util.u0.f338159a.execute(new l(this, r100));
        g49.d.d("NLService", "[NotificationTracer] onNotificationPosted: " + r100.getPackageName() + ",id:" + r100.getId() + ", when: " + r100.getPostTime() + ", ret = " + r104 + ", title=" + r103.f22418e + ", subTitle=" + r103.f22419f + ", content=" + r103.f22420g + ", category=" + r103.f22422i);
        return;
    L9:
        if (r101.p1() == false) goto L11;
        r102 = true;
        goto L12
    }

    public final void d(StatusBarNotification r100) {
        int r101 = a(r100, 1);
        if (r100 == null) goto L6;
        g49.d.d("NLService", "onNotificationRemoved: " + r100.getPackageName() + ", when: " + r100.getPostTime() + ", ret = " + r101);
        return;
    }

    @Override // android.service.notification.NotificationListenerService
    public final void onNotificationPosted(StatusBarNotification r100) {
        super.onNotificationPosted(r100);
        c(r100);
    }

    @Override // android.service.notification.NotificationListenerService
    public final void onNotificationRemoved(StatusBarNotification r100) {
        super.onNotificationRemoved(r100);
        d(r100);
    }

    public final int a(StatusBarNotification r100, int r110) {
        NLServiceImpl r101 = f336226g;
        if (r101 == null) goto L70;
        IObricDoraService r102 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r102 != null) goto L7;
    L9:
        boolean r103 = false;
    L11:
        if (r103 == false) goto L14;
    L16:
        int r104 = 2;
    L17:
        if (r104 != 1) goto L70;
        if (kj4.a.g().getDoraState() == 2) goto L22;
        return -2;
    L22:
        DoraDevice r105 = kj4.a.g().c();
        if (this.f336227a != null) goto L26;
        this.f336227a = (AudioManager) pk4.n.f529659c.getSystemService("audio");
    L26:
        if (r105 != null) goto L28;
    L34:
        boolean r106 = true;
    L35:
        if (r106 == true) goto L37;
        return -2;
    L37:
        KeyguardManager r107 = (KeyguardManager) pk4.n.f529659c.getSystemService("keyguard");
        if (AppHost.f326268a.isTestChannel() == true) goto L40;
    L42:
        boolean r108 = false;
    L43:
        if (r108 == true) goto L50;
        if (r107 != null) goto L46;
        return -3;
    L46:
        if (r107.isKeyguardLocked() == true) goto L50;
        return -3;
    L50:
        if (r100 == null) goto L68;
        c49.a r109 = b(r100);
        g49.d.d("NLService", "[NotificationTracer] doNotify parsed msg, type=" + r110 + ", nlMsg=" + r109.f22414a + ", title:" + r109.f22418e);
        if (Objects.equals(r109.f22416c, pk4.n.f529659c.getPackageName()) == false) goto L56;
        return -6;
    L56:
        if (TextUtils.isEmpty(r109.f22420g) == false) goto L59;
        return -5;
    L59:
        String r111 = r109.f22416c;
        if (r111 == null) goto L67;
        Type r112 = k.f336275e;
        if ((!((CopyOnWriteArrayList) k.b.f336280a.f336277b).contains(r111)) == false) goto L67;
        if (r110 != 0) goto L65;
        r101.d(r109);
    L66:
        return 0;
    L65:
        r101.b(r109);
    L67:
        return -1;
    L68:
        return -4;
    L40:
        if (DoraConfig.f331707a.getBoolean("key_dora_nl_lock", false) == false) goto L42;
        r108 = true;
        goto L43
    L28:
        if (r105.vendorId != 4096) goto L34;
        AudioManager r113 = this.f336227a;
        if (r113 != null) goto L32;
    L33:
        g49.d.e("NLService", "isSendNotify: false: a2dp is disconnected.");
        r106 = false;
        goto L35
    L32:
        if (r113.isBluetoothA2dpOn() == true) goto L34;
    L14:
        if (r101.f() == null) goto L16;
        r104 = r101.f().getInt("nl_state", 2);
        goto L17
    L7:
        if (r102.n() == false) goto L9;
        r103 = true;
    L70:
        return -1;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r100, int r101, int r102) {
        int r103 = super.onStartCommand(r100, r101, r102);
        if (ObricFeatureServiceDelegate.f387839b.f().equals("LowLevel") == false) goto L6;
        return 2;
    L6:
        return r103;
    }
}
