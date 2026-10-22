package q67;

import android.app.Application;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.camera.core.RetryPolicy;
import androidx.collection.SieveCacheKt;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.mira.conig.Constants;
import com.bytedance.push.event.sync.SmpSignalReceiver;
import com.bytedance.push.settings.LocalSettings;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hms.kit.awareness.Awareness;
import com.huawei.hms.kit.awareness.barrier.AwarenessBarrier;
import com.huawei.hms.kit.awareness.barrier.BarrierQueryRequest;
import com.huawei.hms.kit.awareness.barrier.BarrierQueryResponse;
import com.huawei.hms.kit.awareness.barrier.BarrierStatus;
import com.huawei.hms.kit.awareness.barrier.BarrierUpdateRequest;
import com.huawei.hms.kit.awareness.barrier.ScreenBarrier;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.message.AppProvider;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends q67.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f531826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f531827d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f531828e;

    /* JADX INFO: loaded from: classes21.dex */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Intent f531829a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f531830b;

        public final void a() {
            BarrierStatus r100 = BarrierStatus.extract(this.f531829a);
            String r101 = r100.getBarrierLabel();
            String r102 = this.f531829a.getStringExtra("trigger_scene");
            this.f531830b.getClass();
            y77.b r103 = e.s();
            if (r103 != null) goto L6;
            com.bytedance.push.utils.f.i("HwDeviceScreenStatusReporter", "[onReceiveSignal]do nothing because signalReportConfig is null");
            this.f531830b.e();
            return;
        L6:
            Map r104 = r103.extraConfig;
            if (r104 != null) goto L9;
            r104 = new HashMap();
        L9:
            String r105 = (String) r104.get("callback_intent");
            String r106 = (String) r104.get("screen_action");
            if (TextUtils.isEmpty(r106) == true) goto L12;
            r106.split(",");
        L12:
            ToolUtils.parseLong((String) r104.get("delay_report_in_mill"), 0);
            ToolUtils.parseLong((String) r104.get("kill_self_delay_in_mill"), RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS);
            ToolUtils.parseBool((String) r104.get("kill_self_after_signal_report"), true);
            ToolUtils.parseLong((String) r104.get("min_install_time_in_mill"), Constants.DOWNLOAD_TEMP_FILE_PAST_TIME);
            ToolUtils.parseLong((String) r104.get("min_signal_interval_in_mill"), 3600000);
            ToolUtils.parseBool((String) r104.get("filter_debug_device"), true);
            ToolUtils.parseBool((String) r104.get("filter_sim_card"), true);
            ToolUtils.parseBool((String) r104.get("unregister_for_risk_signal"), true);
            boolean r107 = false;
            ToolUtils.parseBool((String) r104.get("unregister_for_un_risk_signal"), false);
            int r108 = ToolUtils.parseInt((String) r104.get("kill_process_mode"), 1);
            com.bytedance.push.utils.f.b("HwDeviceScreenStatusReporter", "[onReceiveSignal]killProcessMode:" + r108);
            if (r108 != 0) goto L16;
        L20:
            com.bytedance.push.utils.f.b("HwDeviceScreenStatusReporter", "[onReceiveSignal]allowKillSmp:" + r107);
            com.bytedance.push.utils.f.b("HwDeviceScreenStatusReporter", "[onReceiveSignal]startProcessComponent:" + PushServiceManager.get().getAliveMonitorService().getProcessStartInfoObject(AppProvider.getApp()).optString("start_component") + " signalReceiverName:" + SmpSignalReceiver.class.getCanonicalName());     // Catch: Throwable -> L23
        L25:
            com.bytedance.push.utils.f.b("HwDeviceScreenStatusReporter", "[onReceiveSignal]triggerScene:" + r102 + " barrierLabel:" + r101 + " presentStatus:" + r100.getPresentStatus() + " allowKillSmp:" + r107);
            if (TextUtils.equals(r101, this.f531830b.f531826c) == false) goto L33;
            if (r100.getPresentStatus() != 1) goto L30;
            com.bytedance.push.utils.f.b("HwDeviceScreenStatusReporter", "[onReceiveSignal]find screen unlock signal");
            com.ss.android.pushmanager.setting.b.b().getClass();
            com.ss.android.pushmanager.setting.b.c().f(System.currentTimeMillis());
            e.f(this.f531830b, "unlock", r102, r107);
            return;
        L30:
            if (r107 == false) goto L50;
            ToolUtils.killSelf();
            return;
        L50:
            return;
        L33:
            if (TextUtils.equals(r101, this.f531830b.f531827d) == false) goto L40;
            if (r100.getPresentStatus() != 1) goto L37;
            com.bytedance.push.utils.f.b("HwDeviceScreenStatusReporter", "[onReceiveSignal]find screen on signal");
            e.f(this.f531830b, "screen_on", r102, r107);
            return;
        L37:
            if (r107 == false) goto L53;
            ToolUtils.killSelf();
            return;
        L53:
            return;
        L40:
            if (TextUtils.equals(r101, this.f531830b.f531828e) == true) goto L42;
            return;
        L42:
            if (r100.getPresentStatus() != 1) goto L44;
            com.bytedance.push.utils.f.b("HwDeviceScreenStatusReporter", "[onReceiveSignal]find screen off signal");
            e.f(this.f531830b, "screen_off", r102, r107);
            return;
        L44:
            if (r107 == false) goto L57;
            ToolUtils.killSelf();
            return;
        L57:
            return;
        L23:
            th = move-exception;
            com.bytedance.push.utils.f.e("HwDeviceScreenStatusReporter", "[onReceiveSignal]allowKillSmp exception:" + th.getLocalizedMessage());
            goto L25
        L16:
            if (r108 != 2) goto L19;
            int r109 = PushServiceManager.get().getIPushNotificationService().getNotificationNum(AppProvider.getApp());
            com.bytedance.push.utils.f.b("HwDeviceScreenStatusReporter", "[onReceiveSignal]curNotificationNum:" + r109);
            if (r109 != 0) goto L20;
        L19:
            r107 = true;
            goto L20
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

        public a(e r100, Intent r101) {
            this.f531830b = r100;
            this.f531829a = r101;
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public class b implements OnFailureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f531831a;

        public b(CountDownLatch r100) {
            this.f531831a = r100;
        }

        @Override // com.huawei.hmf.tasks.OnFailureListener
        public final void onFailure(Exception r100) {
            com.bytedance.push.utils.f.b("HwDeviceScreenStatusReporter", "query barrier failed");
            this.f531831a.countDown();
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public class c implements OnSuccessListener<BarrierQueryResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean[] f531832a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f531833b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e f531834c;

        public final void a(BarrierQueryResponse r100) {
            Set r101 = r100.getBarrierStatusMap().getBarrierLabels();
            boolean[] r102 = this.f531832a;
            if (r101 != null) goto L5;
        L9:
            boolean r103 = false;
        L10:
            r102[0] = r103;
            com.bytedance.push.utils.f.b("HwDeviceScreenStatusReporter", "query barrier success,curHasUnLockBarrier:" + this.f531832a[0]);
            this.f531833b.countDown();
            return;
        L5:
            if (r101.isEmpty() == true) goto L9;
            if (r101.contains(this.f531834c.f531826c) == false) goto L9;
            r103 = true;
            goto L10
        }

        @Override // com.huawei.hmf.tasks.OnSuccessListener
        public final /* bridge */ /* synthetic */ void onSuccess(BarrierQueryResponse r100) {
            a(r100);
        }

        public c(e r100, boolean[] r101, CountDownLatch r102) {
            this.f531834c = r100;
            this.f531832a = r101;
            this.f531833b = r102;
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public class d implements OnFailureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f531835a;

        public d(String r100) {
            this.f531835a = r100;
        }

        @Override // com.huawei.hmf.tasks.OnFailureListener
        public final void onFailure(Exception r100) {
            com.bytedance.push.utils.f.f("HwDeviceScreenStatusReporter", "[addAwarenessBarrier]add barrier failed for " + this.f531835a + " ", r100);
        }
    }

    /* JADX INFO: renamed from: q67.e$e, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes21.dex */
    public class C7288e implements OnSuccessListener<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f531836a;

        public C7288e(String r100) {
            this.f531836a = r100;
        }

        @Override // com.huawei.hmf.tasks.OnSuccessListener
        public final void onSuccess(Void r100) {
            com.bytedance.push.utils.f.b("HwDeviceScreenStatusReporter", "[addAwarenessBarrier]add barrier success for " + this.f531836a);
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public class f implements OnFailureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f531837a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f531838b;

        @Override // com.huawei.hmf.tasks.OnFailureListener
        public final void onFailure(Exception r100) {
            com.bytedance.push.utils.f.f("HwDeviceScreenStatusReporter", "[deleteBarrier]delete barrier failed for " + this.f531837a + " ", r100);
            this.f531838b.countDown();
        }

        public f(String r100, CountDownLatch r101) {
            this.f531837a = r100;
            this.f531838b = r101;
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public class g implements OnSuccessListener<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f531839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f531840b;

        @Override // com.huawei.hmf.tasks.OnSuccessListener
        public final void onSuccess(Void r100) {
            com.bytedance.push.utils.f.b("HwDeviceScreenStatusReporter", "[deleteBarrier]delete barrier success,barrierLabel:" + this.f531839a);
            this.f531840b.countDown();
        }

        public g(String r100, CountDownLatch r101) {
            this.f531839a = r100;
            this.f531840b = r101;
        }
    }

    @Override // q67.a
    public final String b() {
        return "hw_screen_status";
    }

    public e() {
        this.f531826c = "screen.status.signal.screen_unlock";
        this.f531827d = "screen.status.signal.screen_on";
        this.f531828e = "screen.status.signal.screen_off";
    }

    public static y77.b s() {
        com.ss.android.pushmanager.setting.b.b().getClass();
        y77.f r100 = com.ss.android.pushmanager.setting.b.d().c0();
        if (r100 == null) goto L12;
        List<y77.b> r101 = r100.a();
        if (r101 == null) goto L17;
        Iterator<y77.b> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L18;
        y77.b r103 = r102.next();
        if (TextUtils.equals(r103.signalName, "hw_screen_status") == false) goto L8;
        return r103;
    L18:
        return null;
    L17:
        return null;
    L12:
        return null;
    }

    @Override // q67.a
    public final void e() {
        super.e();
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return;
    L5:
        if (com.bytedance.push.utils.j.h() == false) goto L11;
        com.ss.android.pushmanager.setting.b.b().getClass();
        LocalSettings r100 = com.ss.android.pushmanager.setting.b.c();
        boolean r101 = r100.I();
        com.bytedance.push.utils.f.b("HwDeviceScreenStatusReporter", "[unregisterBarrier]hasBarrierHwAwarenessSignal:" + r101);
        if (r101 == false) goto L12;
        n(AppProvider.getApp(), this.f531827d);
        n(AppProvider.getApp(), this.f531828e);
        n(AppProvider.getApp(), this.f531826c);
        r100.J(false);
        return;
    L12:
        return;
    }

    public static boolean h(y67.b r110) {
        com.bytedance.push.utils.f.b("HwDeviceScreenStatusReporter", "[allowAddAwarenessBarrier]");
        Application r100 = AppProvider.getApp();
        com.ss.android.pushmanager.setting.b.b().getClass();     // Catch: Throwable -> L19
        if ((!com.ss.android.pushmanager.setting.b.c().x()) == true) goto L7;
        com.bytedance.push.utils.f.i("HwDeviceScreenStatusReporter", "[allowAddAwarenessBarrier]return false because enableAwarenessBarrier is false");     // Catch: Throwable -> L19
        return false;
    L7:
        long r101 = r100.getApplicationContext().getPackageManager().getPackageInfo(r100.getPackageName(), 0).firstInstallTime;     // Catch: Throwable -> L19
        long r102 = System.currentTimeMillis() - r101;     // Catch: Throwable -> L19
        com.bytedance.push.utils.f.b("HwDeviceScreenStatusReporter", "[allowAddAwarenessBarrier]app install time:" + r101 + " appInstallDuration:" + r102 + " minInstallTimeInMill:" + r110.f566367g);     // Catch: Throwable -> L19
        if (r102 >= r110.f566367g) goto L12;
        com.bytedance.push.utils.f.i("HwDeviceScreenStatusReporter", "[allowAddAwarenessBarrier]return false because appInstallTime<minInstallTimeInMill");     // Catch: Throwable -> L19
        return false;
    L12:
        if (r110.f566366f == true) goto L14;
    L17:
        com.bytedance.push.utils.f.b("HwDeviceScreenStatusReporter", "[allowAddAwarenessBarrier]return true");     // Catch: Throwable -> L19
        return true;
    L14:
        if (PushServiceManager.get().getIAllianceService().isRiskDevice(r100, r110.f566369i) == false) goto L17;
        com.bytedance.push.utils.f.i("HwDeviceScreenStatusReporter", "[allowAddAwarenessBarrier]return false because cur is risk Device");     // Catch: Throwable -> L19
        return false;
    L19:
        th = move-exception;
        com.bytedance.push.utils.f.f("HwDeviceScreenStatusReporter", "[allowAddAwarenessBarrier]exception ", th);
        com.bytedance.push.utils.f.i("HwDeviceScreenStatusReporter", "[allowAddAwarenessBarrier]backup return false");
        return false;
    }

    public static long o(y67.b r100) {
        long r101 = System.currentTimeMillis();
        com.ss.android.pushmanager.setting.b.b().getClass();
        long r102 = com.ss.android.pushmanager.setting.b.c().Q();
        long r103 = r101 - r102;
        com.bytedance.push.utils.f.b("HwDeviceScreenStatusReporter", "[allowAddAwarenessBarrier]lastUnlockAwarenessTime:" + r102 + " actualInterval:" + r103 + " minSignalIntervalInMill:" + r100.f566368h);
        return r100.f566368h - r103;
    }

    @Override // q67.a
    public final void c(Intent r100) {
        super.c(r100);
        PushThreadHandlerManager.inst().postRunnable(new a(this, r100));
    }

    @Override // q67.a
    public final void d(String r110, y77.b r111) {
        super.d(r110, r111);
    L40:
        th = move-exception;
        com.bytedance.push.utils.f.e("HwDeviceScreenStatusReporter", "[startSignalReport]error:" + th.getLocalizedMessage());
        th.printStackTrace();
        return;
    L4:
        if (Build.VERSION.SDK_INT >= 24) goto L6;
        return;
    L6:
        if (com.bytedance.push.utils.j.h() == false) goto L51;
        y67.b r112 = new y67.b(r111.extraConfig);     // Catch: Throwable -> L40
        int r100 = 0;
        if (TextUtils.isEmpty(r112.f566361a) == false) goto L10;
    L12:
        boolean r101 = false;
    L13:
        if (r101 == true) goto L16;
        com.bytedance.push.utils.f.b("HwDeviceScreenStatusReporter", "[startSignalReport]hwScreenStatusSignalExtraConfig is invalid,unregister all");     // Catch: Throwable -> L40
        e();     // Catch: Throwable -> L40
        return;
    L16:
        String r102 = r112.f566361a;     // Catch: Throwable -> L40
        com.bytedance.push.utils.f.b("HwDeviceScreenStatusReporter", "[startSignalReport]callbackIntent:" + r102);     // Catch: Throwable -> L40
        if (h(r112) == true) goto L20;
        com.bytedance.push.utils.f.i("HwDeviceScreenStatusReporter", "[startSignalReport]do nothing because allowAddAwarenessBarrier is false");     // Catch: Throwable -> L40
        e();     // Catch: Throwable -> L40
        return;
    L20:
        long r103 = o(r112);     // Catch: Throwable -> L40
        if (r103 <= 0) goto L28;
        e();     // Catch: Throwable -> L40
        com.bytedance.push.utils.f.b("HwDeviceScreenStatusReporter", "[allowAddAwarenessBarrier]startSignalReportFromSignalCallback because cur hasBeenFrequencyControl,nextRegisterInterval:" + r103);     // Catch: Throwable -> L40
        String r113 = this.f531807b;     // Catch: Throwable -> L40
        com.bytedance.push.utils.f.b("HwDeviceScreenStatusReporter", "[startSignalReportFromSignalCallback]triggerScene:" + r113);     // Catch: Throwable -> L40
        PushThreadHandlerManager.inst().postRunnable(new q67.g(this, r113, r111), r103);     // Catch: Throwable -> L25
    L49:
        return;
    L25:
        th = move-exception;
        com.bytedance.push.utils.f.f("HwDeviceScreenStatusReporter", "[startSignalReportFromSignalCallback]exception ", th);     // Catch: Throwable -> L40
        return;
    L28:
        Application r114 = AppProvider.getApp();     // Catch: Throwable -> L40
        Intent r104 = Intent.parseUri(r102, 0);     // Catch: Throwable -> L40
        r104.setPackage(r114.getPackageName());     // Catch: Throwable -> L40
        r104.setComponent(new ComponentName(r114, SmpSignalReceiver.class));     // Catch: Throwable -> L40
        r104.putExtra("signal_name", "hw_screen_status");     // Catch: Throwable -> L40
        r104.putExtra("trigger_scene", this.f531807b);     // Catch: Throwable -> L40
        String[] r115 = r112.f566362b;     // Catch: Throwable -> L40
        int r105 = r115.length;     // Catch: Throwable -> L40
    L29:
        if (r100 >= r105) goto L52;
        String r106 = r115[r100];     // Catch: Throwable -> L40
        if (TextUtils.equals(r106, "screen_on") == false) goto L34;
        g(r114, this.f531827d, ScreenBarrier.screenOn(), r104);     // Catch: Throwable -> L40
    L34:
        if (TextUtils.equals(r106, "screen_off") == false) goto L37;
        g(r114, this.f531828e, ScreenBarrier.screenOff(), r104);     // Catch: Throwable -> L40
    L37:
        if (TextUtils.equals(r106, "unlock") == false) goto L39;
        g(r114, this.f531826c, ScreenBarrier.screenUnlock(), r104);     // Catch: Throwable -> L40
    L39:
        r100 = r100 + 1;
        goto L29
    L52:
        return;
    L10:
        if (r112.f566362b == null) goto L12;
        r101 = true;
        goto L13
    }

    public final boolean m(Context r100, String r101) {
        CountDownLatch r102 = new CountDownLatch(1);
        boolean[] r103 = {false};     // Catch: Throwable -> L5
        Awareness.getBarrierClient(r100).queryBarriers(BarrierQueryRequest.forBarriers(new String[]{r101})).addOnSuccessListener(new c(this, r103, r102)).addOnFailureListener(new b(r102));     // Catch: Throwable -> L5
        r102.await(5000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L5
        return r103[0];
    L5:
        th = move-exception;
        com.bytedance.push.utils.f.f("HwDeviceScreenStatusReporter", "[curHasBarrier]exception ", th);
        return false;
    }

    public final void n(Context r100, String r101) {
        com.bytedance.push.utils.f.b("HwDeviceScreenStatusReporter", "[deleteBarrier]barrierLabel:" + r101);     // Catch: Throwable -> L5
        BarrierUpdateRequest r102 = new BarrierUpdateRequest.Builder().deleteBarrier(r101).build();     // Catch: Throwable -> L5
        CountDownLatch r103 = new CountDownLatch(1);     // Catch: Throwable -> L5
        Awareness.getBarrierClient(r100).updateBarriers(r102).addOnSuccessListener(new g(r101, r103)).addOnFailureListener(new f(r101, r103));     // Catch: Throwable -> L5
        r103.await(5000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        com.bytedance.push.utils.f.f("HwDeviceScreenStatusReporter", "error when deleteBarrier for " + r101 + " ,reason ", th);
    }

    public static void f(e r110, String r111, String r112, boolean r113) {
        r110.getClass();
        com.bytedance.push.utils.f.b("HwDeviceScreenStatusReporter", "[reportScreenStatusSignal]action:" + r111 + " triggerScene:" + r112);
        y77.b r100 = s();
        if (r100 != null) goto L5;
        com.bytedance.push.utils.f.i("HwDeviceScreenStatusReporter", "[reportScreenStatusSignal]do nothing because signalReportConfig is null");
        r110.e();
        return;
    L5:
        y67.b r114 = new y67.b(r100.extraConfig);
        Application r101 = AppProvider.getApp();
        boolean r102 = p77.b.a().b(r101);
        com.bytedance.push.utils.f.b("HwDeviceScreenStatusReporter", "[reportScreenStatusSignal]unregisterForUnRiskSignal:" + r114.f566370j);
        boolean r103 = false;
        if (r114.f566370j == false) goto L14;
        Boolean r104 = ToolUtils.isMainProcessStart(r101);
        if (r102 == false) goto L13;
        if (r104 != null) goto L11;
    L12:
        r103 = true;
        goto L13
    L11:
        if (r104.booleanValue() == false) goto L12;
    L13:
        com.bytedance.push.utils.f.b("HwDeviceScreenStatusReporter", "[reportScreenStatusSignal]curIsRiskSignal:" + r103 + " unregisterForUnRiskSignal:" + r114.f566371k);
    L14:
        if (r103 == true) goto L16;
        r103 = r114.f566371k;
    L16:
        if (r103 == false) goto L18;
        r110.e();
    L18:
        if (r102 == false) goto L20;
        long r105 = r114.f566363c;
    L21:
        long r115 = r105;
        com.bytedance.push.utils.f.b("HwDeviceScreenStatusReporter", "[reportScreenStatusSignal]report signal after :" + r115 + " killSelfDelayInMill:" + r114.f566364d);
        PushThreadHandlerManager.inst().postRunnable(new q67.f(r110, r111, r100, r112, r113, System.currentTimeMillis(), r114), r115);
        return;
    L20:
        r105 = 0;
        goto L21
    }

    public final void g(Context r100, String r101, AwarenessBarrier r102, Intent r103) {
        if (m(r100, r101) == false) goto L6;
        com.bytedance.push.utils.f.b("HwDeviceScreenStatusReporter", "do nothing because cur has barrier:" + r101);
        return;
    L6:
        Awareness.getBarrierClient(r100).updateBarriers(new BarrierUpdateRequest.Builder().addBarrier(r101, r102, PendingIntent.getBroadcast(r100, (int) (System.currentTimeMillis() % SieveCacheKt.NodeLinkMask), r103, AMapEngineUtils.HALF_MAX_P20_WIDTH)).build()).addOnSuccessListener(new C7288e(r101)).addOnFailureListener(new d(r101));
        com.ss.android.pushmanager.setting.b.b().getClass();
        com.ss.android.pushmanager.setting.b.c().J(true);
    }
}
