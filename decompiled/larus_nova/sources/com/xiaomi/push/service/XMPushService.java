package com.xiaomi.push.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.crash.Npth;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.bk;
import com.xiaomi.push.cf;
import com.xiaomi.push.cm;
import com.xiaomi.push.cs;
import com.xiaomi.push.cw;
import com.xiaomi.push.da;
import com.xiaomi.push.dr;
import com.xiaomi.push.ds;
import com.xiaomi.push.dy;
import com.xiaomi.push.en;
import com.xiaomi.push.eo;
import com.xiaomi.push.eq;
import com.xiaomi.push.ex;
import com.xiaomi.push.ez;
import com.xiaomi.push.fa;
import com.xiaomi.push.fc;
import com.xiaomi.push.fd;
import com.xiaomi.push.fe;
import com.xiaomi.push.ff;
import com.xiaomi.push.fh;
import com.xiaomi.push.fl;
import com.xiaomi.push.fm;
import com.xiaomi.push.fn;
import com.xiaomi.push.fp;
import com.xiaomi.push.fy;
import com.xiaomi.push.fz;
import com.xiaomi.push.gc;
import com.xiaomi.push.ge;
import com.xiaomi.push.gi;
import com.xiaomi.push.gj;
import com.xiaomi.push.ha;
import com.xiaomi.push.he;
import com.xiaomi.push.ho;
import com.xiaomi.push.ht;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public class XMPushService extends Service implements fc {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f464146b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f464147a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private long f989a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ContentObserver f990a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    Messenger f991a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ex f992a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ez f993a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private fa f994a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private fe f995a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private a f996a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private f f997a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private k f998a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private r f999a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private t f1000a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ak f1001a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private as f1002a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.xiaomi.push.service.h f1003a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.xiaomi.push.service.n f1004a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected Class f1005a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Object f1006a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ArrayList<n> f1007a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Collection<aa> f1008a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private boolean f1009a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private int f1010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f464148c;

    public class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ XMPushService f464164a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private final Object f1016a;

        private void a() {
            if (Looper.myLooper() != Looper.getMainLooper()) goto L6;
            com.xiaomi.channel.commonutils.logger.b.d("[Alarm] Cannot perform lock.notifyAll in the UI thread!");
            return;
        L6:
            Object r100 = this.f1016a;
            monitor-enter(r100);
            this.f1016a.notifyAll();     // Catch: Throwable -> L10 Exception -> L12
        L14:
            monitor-exit(r100);     // Catch: Throwable -> L10
            return;
        L12:
            e = move-exception;
            com.xiaomi.channel.commonutils.logger.b.m8718a("[Alarm] notify lock. " + e);     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        private a(XMPushService r100) {
            this.f464164a = r100;
            this.f1016a = new Object();
        }

        private void a(long r100) {
            if (Looper.myLooper() != Looper.getMainLooper()) goto L6;
            com.xiaomi.channel.commonutils.logger.b.d("[Alarm] Cannot perform lock.wait in the UI thread!");
            return;
        L6:
            Object r101 = this.f1016a;
            monitor-enter(r101);
            this.f1016a.wait(r100);     // Catch: Throwable -> L10 InterruptedException -> L12
        L14:
            monitor-exit(r101);     // Catch: Throwable -> L10
            return;
        L12:
            e = move-exception;
            com.xiaomi.channel.commonutils.logger.b.m8718a("[Alarm] interrupt from waiting state. " + e);     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        public static /* synthetic */ void a(a r100) {
            r100.a();
        }

        public /* synthetic */ a(XMPushService r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r100, Intent r101) {
            long r102 = System.currentTimeMillis();
            com.xiaomi.channel.commonutils.logger.b.c("[Alarm] heartbeat alarm has been triggered.");
            if (an.f464252q.equals(r101.getAction()) == true) goto L5;
            com.xiaomi.channel.commonutils.logger.b.m8718a("[Alarm] cancel the old ping timer");
            dy.a();
            return;
        L5:
            if (TextUtils.equals(r100.getPackageName(), r101.getPackage()) == false) goto L14;
            com.xiaomi.channel.commonutils.logger.b.c("[Alarm] Ping XMChannelService on timer");
            Intent r103 = new Intent(r100, XMPushService.class);     // Catch: Throwable -> L11
            r103.putExtra("time_stamp", System.currentTimeMillis());     // Catch: Throwable -> L11
            r103.setAction("com.xiaomi.push.timer");     // Catch: Throwable -> L11
            ServiceClient.getInstance(r100).startServiceSafely(r103);     // Catch: Throwable -> L11
            a(3000);     // Catch: Throwable -> L11
            com.xiaomi.channel.commonutils.logger.b.m8718a("[Alarm] heartbeat alarm finish in " + (System.currentTimeMillis() - r102));     // Catch: Throwable -> L11
            return;
        L16:
            return;
        }
    }

    public class b extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ XMPushService f464165a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        am.b f1017a;

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo9047a() {
        L14:
            e = move-exception;
            com.xiaomi.channel.commonutils.logger.b.d("Meet error when trying to bind. " + e);
            this.f464165a.a(10, e);
            return;
        L4:
            if (this.f464165a.m9336c() == true) goto L6;
            com.xiaomi.channel.commonutils.logger.b.d("trying bind while the connection is not created, quit!");     // Catch: Exception -> L14 Throwable -> L17
        L18:
            return;
            goto L22
        L6:
            am r100 = am.a();     // Catch: Exception -> L14 Throwable -> L17
            am.b r101 = this.f1017a;     // Catch: Exception -> L14 Throwable -> L17
            am.b r102 = r100.a(r101.f464221g, r101.f1057b);     // Catch: Exception -> L14 Throwable -> L17
            if (r102 != null) goto L10;
            com.xiaomi.channel.commonutils.logger.b.m8718a("ignore bind because the channel " + this.f1017a.f464221g + " is removed ");     // Catch: Exception -> L14 Throwable -> L17
            goto L18
        L10:
            if (r102.f1052a != am.c.f464232a) goto L12;
            r102.a(am.c.f464233b, 0, 0, null, null);     // Catch: Exception -> L14 Throwable -> L17
            XMPushService.a(this.f464165a).a(r102);     // Catch: Exception -> L14 Throwable -> L17
            eo.a(this.f464165a, r102);     // Catch: Exception -> L14 Throwable -> L17
            goto L18
        L12:
            com.xiaomi.channel.commonutils.logger.b.m8718a("trying duplicate bind, ingore! " + r102.f1052a);     // Catch: Exception -> L14 Throwable -> L17
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "bind the client. " + this.f1017a.f464221g;
        }

        public b(XMPushService r100, am.b r101) {
            this.f464165a = r100;
            super(9);
            this.f1017a = r101;
        }
    }

    public static class c extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final am.b f464166a;

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "bind time out. chid=" + this.f464166a.f464221g;
        }

        public int hashCode() {
            return this.f464166a.f464221g.hashCode();
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo9047a() {
            this.f464166a.a(am.c.f464232a, 1, 21, null, null);
        }

        public c(am.b r100) {
            super(12);
            this.f464166a = r100;
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof c) == true) goto L7;
            return false;
        L7:
            return TextUtils.equals(((c) r100).f464166a.f464221g, this.f464166a.f464221g);
        }
    }

    public class d extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private eq f464167a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        final /* synthetic */ XMPushService f1018a;

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo9047a() {
            XMPushService.m9315a(this.f1018a).a(this.f464167a);
            if (com.xiaomi.push.service.e.a(this.f464167a) == false) goto L6;
            this.f1018a.a(new at.a(), 15000);
            return;
        }

        public d(XMPushService r100, eq r101) {
            this.f1018a = r100;
            super(8);
            this.f464167a = r101;
        }
    }

    public class e extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ XMPushService f464168a;

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "do reconnect..";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo9047a() {
            if (this.f464168a.m9331a() == false) goto L7;
            XMPushService r100 = this.f464168a;
            if (XMPushService.a(r100, r100.getApplicationContext()) == false) goto L7;
            XMPushService.c(this.f464168a);
            return;
        L7:
            com.xiaomi.channel.commonutils.logger.b.m8718a("should not connect. quit the job.");
        }

        public e(XMPushService r100) {
            this.f464168a = r100;
            super(1);
        }
    }

    public class f extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ XMPushService f464169a;

        public f(XMPushService r100) {
            this.f464169a = r100;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r100, Intent r101) {
            com.xiaomi.push.at.m8818a();
            this.f464169a.onStart(r101, 1);
        }
    }

    public class g extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ XMPushService f464170a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Exception f1019a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f464171b;

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "disconnect the connection.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo9047a() {
            this.f464170a.a(this.f464171b, this.f1019a);
        }

        public g(XMPushService r100, int r101, Exception r102) {
            this.f464170a = r100;
            super(2);
            this.f464171b = r101;
            this.f1019a = r102;
        }
    }

    public class h extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ XMPushService f464172a;

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "Init Job";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo9047a() {
            XMPushService.b(this.f464172a);
        }

        public h(XMPushService r100) {
            this.f464172a = r100;
            super(65535);
        }
    }

    public class i extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Intent f464173a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        final /* synthetic */ XMPushService f1020a;

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "Handle intent action = " + this.f464173a.getAction();
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo9047a() {
            XMPushService.a(this.f1020a, this.f464173a);
        }

        public i(XMPushService r100, Intent r101) {
            this.f1020a = r100;
            super(15);
            this.f464173a = r101;
        }
    }

    public static abstract class j extends com.xiaomi.push.service.n.b {
        public abstract String a();

        /* JADX INFO: renamed from: a */
        public abstract void mo9047a();

        @Override // java.lang.Runnable
        public void run() {
            com_xiaomi_push_service_XMPushService$j_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_xiaomi_push_service_XMPushService$j__run$___twin___() {
            int r100 = this.f464318a;
            if (r100 != 4) goto L5;
        L7:
            mo9047a();
            return;
        L5:
            if (r100 == 8) goto L7;
            com.xiaomi.channel.commonutils.logger.b.m8719a(com.xiaomi.channel.commonutils.logger.a.f463008a, a());
            goto L7
        }

        public j(int r100) {
            super(r100);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_xiaomi_push_service_XMPushService$j_com_larus_apm_impl_protector_RunnableLancet_run(j r100) {
            r100.com_xiaomi_push_service_XMPushService$j__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public class k extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ XMPushService f464174a;

        public k(XMPushService r100) {
            this.f464174a = r100;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r100, Intent r101) {
            com.xiaomi.channel.commonutils.logger.b.m8718a("[HB] hold short heartbeat, " + com.xiaomi.push.j.a(r101));
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.getExtras() == null) goto L9;
            this.f464174a.onStart(r101, 1);
            return;
        }
    }

    public class l extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ XMPushService f464175a;

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "ask the job queue to quit";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo9047a() {
            XMPushService.m9316a(this.f464175a).m9398a();
        }

        public l(XMPushService r100) {
            this.f464175a = r100;
            super(5);
        }
    }

    public class m extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private fn f464176a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        final /* synthetic */ XMPushService f1021a;

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo9047a() {
            XMPushService.m9315a(this.f1021a).a(this.f464176a);
        }

        public m(XMPushService r100, fn r101) {
            this.f1021a = r100;
            super(8);
            this.f464176a = r101;
        }
    }

    public interface n {
        /* JADX INFO: renamed from: a */
        void mo9117a();
    }

    public class o extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ XMPushService f464177a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        boolean f1022a;

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "send ping..";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo9047a() {
            if (this.f464177a.m9336c() == false) goto L14;
        L9:
            e = move-exception;
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f464177a.a(10, e);
            return;
        L5:
            if (this.f1022a == true) goto L7;
            eo.a();     // Catch: fh -> L9
        L7:
            XMPushService.a(this.f464177a).b(this.f1022a);     // Catch: fh -> L9
            return;
        }

        public o(XMPushService r100, boolean r101) {
            this.f464177a = r100;
            super(4);
            this.f1022a = r101;
        }
    }

    public class p extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ XMPushService f464178a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        am.b f1023a;

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo9047a() {
            this.f1023a.a(am.c.f464232a, 1, 16, null, null);     // Catch: fh -> L4
            ez r100 = XMPushService.a(this.f464178a);     // Catch: fh -> L4
            am.b r101 = this.f1023a;     // Catch: fh -> L4
            r100.a(r101.f464221g, r101.f1057b);     // Catch: fh -> L4
            XMPushService r102 = this.f464178a;     // Catch: fh -> L4
            r102.a(new b(r102, this.f1023a), 300);     // Catch: fh -> L4
            return;
        L4:
            e = move-exception;
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f464178a.a(10, e);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "rebind the client. " + this.f1023a.f464221g;
        }

        public p(XMPushService r100, am.b r101) {
            this.f464178a = r100;
            super(4);
            this.f1023a = r101;
        }
    }

    public class q extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ XMPushService f464179a;

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "reset the connection.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo9047a() {
            this.f464179a.a(11, null);
            if (this.f464179a.m9331a() == false) goto L8;
            XMPushService r100 = this.f464179a;
            if (XMPushService.a(r100, r100.getApplicationContext()) == false) goto L9;
            XMPushService.c(this.f464179a);
            return;
        L9:
            return;
        }

        public q(XMPushService r100) {
            this.f464179a = r100;
            super(3);
        }
    }

    public class r extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ XMPushService f464180a;

        public r(XMPushService r100) {
            this.f464180a = r100;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r100, Intent r101) {
            this.f464180a.onStart(r101, 1);
        }
    }

    public class s extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ XMPushService f464181a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        am.b f1024a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        String f1025a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f464182b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        String f1026b;

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo9047a() {
            if (this.f1024a.f1052a != am.c.f464232a) goto L5;
        L10:
            this.f1024a.a(am.c.f464232a, this.f464182b, 0, this.f1026b, this.f1025a);
            return;
        L5:
            if (XMPushService.a(this.f464181a) == null) goto L10;
            ez r100 = XMPushService.a(this.f464181a);     // Catch: fh -> L8
            am.b r101 = this.f1024a;     // Catch: fh -> L8
            r100.a(r101.f464221g, r101.f1057b);     // Catch: fh -> L8
        L8:
            e = move-exception;
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f464181a.a(10, e);
            goto L10
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "unbind the channel. " + this.f1024a.f464221g;
        }

        public s(XMPushService r100, am.b r101, int r102, String r103, String r104) {
            this.f464181a = r100;
            super(9);
            this.f1024a = r101;
            this.f464182b = r102;
            this.f1025a = r103;
            this.f1026b = r104;
        }
    }

    public class t extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ XMPushService f464183a;

        public t(XMPushService r100) {
            this.f464183a = r100;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r100, Intent r101) {
            if (XMPushService.m9321b(this.f464183a) == true) goto L5;
            XMPushService.a(this.f464183a, true);
        L5:
            this.f464183a.onStart(r101, 1);
        }
    }

    private void h() {
    }

    private void f() {
        ez r100 = this.f993a;
        if (r100 != null) goto L5;
    L8:
        ez r101 = this.f993a;
        if (r101 != null) goto L11;
    L14:
        this.f994a.b(com.xiaomi.push.at.m8815a(this));
        g();
        if (this.f993a != null) goto L18;
        am.a().a(this);
        c(false);
        return;
    L18:
        return;
    L11:
        if (r101.m9087c() == false) goto L14;
        com.xiaomi.channel.commonutils.logger.b.d("try to connect while is connected.");
        return;
    L5:
        if (r100.m9086b() == false) goto L8;
        com.xiaomi.channel.commonutils.logger.b.d("try to connect while connecting.");
    }

    private void g() {
        this.f992a.a(this.f995a, new AnonymousClass5(this));     // Catch: fh -> L4
        this.f992a.e();     // Catch: fh -> L4
        this.f993a = this.f992a;     // Catch: fh -> L4
        return;
    L4:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a("fail to create Slim connection", e);
        this.f992a.b(3, e);
    }

    private boolean j() {
        int r100 = CastIntegerProtector.valueOf(String.format("%tH", new Object[]{new Date()})).intValue();
        int r101 = this.f464147a;
        int r102 = this.f1010b;
        if (r101 <= r102) goto L7;
        if (r100 >= r101) goto L13;
        if (r100 < r102) goto L14;
    L11:
        return false;
    L14:
        return true;
    L13:
        return true;
    L7:
        if (r101 >= r102) goto L11;
        if (r100 < r101) goto L11;
        if (r100 >= r102) goto L11;
        return true;
    }

    @Override // android.app.Service
    public void onDestroy() {
        f r100 = this.f997a;
        if (r100 == null) goto L5;
        a(r100);
        this.f997a = null;
    L5:
        Object r101 = this.f1006a;
        if (r101 == null) goto L8;
        com.xiaomi.push.at.a(this, r101);
        this.f1006a = null;
    L8:
        t r102 = this.f1000a;
        if (r102 == null) goto L11;
        a(r102);
        this.f1000a = null;
    L11:
        k r103 = this.f998a;
        if (r103 == null) goto L14;
        a(r103);
        this.f998a = null;
    L14:
        r r104 = this.f999a;
        if (r104 == null) goto L17;
        a(r104);
        this.f999a = null;
    L17:
        a r105 = this.f996a;
        if (r105 == null) goto L21;
        a(r105);
        this.f996a = null;
    L21:
        if ("com.xiaomi.xmsf".equals(getPackageName()) == true) goto L23;
    L28:
        this.f1008a.clear();
        this.f1004a.m9401b();
        final int r106 = 2;
        a(new AnonymousClass4(this, r106));
        a(new l(this));
        am.a().b();
        am.a().a(this, 15);
        am.a().m9363a();
        this.f992a.b(this);
        ax.a().m9378a();
        dy.a();
        i();
        cm.b(this, this.f992a);
        cs.b(this, this.f992a);
        super.onDestroy();
        com.xiaomi.channel.commonutils.logger.b.m8718a("Service destroyed");
        return;
    L23:
        if (this.f990a == null) goto L28;
        getContentResolver().unregisterContentObserver(this.f990a);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        com.xiaomi.channel.commonutils.logger.b.d("unregister super-power-mode err:" + th.getMessage());
        goto L28
    }

    public XMPushService() {
        this.f1009a = false;
        this.f464147a = 0;
        this.f1010b = 0;
        this.f989a = 0;
        this.f1005a = XMJobService.class;
        this.f464148c = -1;
        this.f1001a = null;
        this.f1004a = null;
        this.f991a = null;
        this.f1008a = Collections.synchronizedCollection(new ArrayList());
        this.f1007a = new ArrayList();
        this.f995a = new AnonymousClass1(this);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private int[] m9320a() {
        String r100 = ah.a(getApplicationContext()).a(gj.aN.a(), "");
        if (TextUtils.isEmpty(r100) == true) goto L19;
        String[] r101 = r100.split(",");
        if (r101 == null) goto L19;
        if (r101.length < 2) goto L19;
        int[] r102 = new int[2];
        r102[0] = CastIntegerProtector.valueOf(r101[0]).intValue();     // Catch: NumberFormatException -> L17
        int r103 = CastIntegerProtector.valueOf(r101[1]).intValue();     // Catch: NumberFormatException -> L17
        r102[1] = r103;     // Catch: NumberFormatException -> L17
        int r104 = r102[0];     // Catch: NumberFormatException -> L17
        if (r104 < 0) goto L19;
        if (r104 > 23) goto L19;
        if (r103 < 0) goto L19;
        if (r103 > 23) goto L19;
        if (r104 == r103) goto L19;
        return r102;
    L17:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.d("parse falldown time range failure: " + e);
    L19:
        return null;
    }

    private String b() {
        com.xiaomi.push.af.a();
        long r100 = SystemClock.elapsedRealtime();
        Object r101 = new Object();
        int r102 = 0;
        if ("com.xiaomi.xmsf".equals(getPackageName()) == false) goto L26;
        ap r103 = ap.a(this);
        String r104 = null;
    L6:
        if (TextUtils.isEmpty(r104) == true) goto L12;
        if (r103.a() == 0) goto L12;
        String r105 = a();
    L27:
        com.xiaomi.channel.commonutils.logger.b.m8718a("wait coutrycode :" + r105 + " cost = " + (SystemClock.elapsedRealtime() - r100) + " , count = " + r102);
        return r105;
    L12:
        if (TextUtils.isEmpty(r104) == false) goto L30;
        r104 = a();
    L30:
        monitor-enter(r101);     // Catch: InterruptedException -> L29
        if (r102 < 30) goto L32;
        r101.wait(30000);     // Catch: Throwable -> L22
    L20:
        monitor-exit(r101);     // Catch: Throwable -> L22
        goto L25
    L32:
        r101.wait(1000);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;     // Catch: InterruptedException -> L29
    L25:
        r102 = r102 + 1;
        goto L6
    L26:
        r105 = "CN";
        goto L27
    }

    private void c() {
        cf.a().m8905d();
        com.xiaomi.push.service.m.a(getApplicationContext()).m9392a();
        com.xiaomi.push.service.b r100 = com.xiaomi.push.service.b.a(getApplicationContext());
        String r101 = r100.a();
        com.xiaomi.channel.commonutils.logger.b.m8719a("XMPushService", "region of cache is " + r101);
        String r102 = "";
        if (TextUtils.isEmpty(r101) == false) goto L5;
        String r103 = b();
        String r104 = r103;
        r101 = com.xiaomi.push.j.a(r103).name();
    L6:
        String r105 = "CN";
        if (TextUtils.isEmpty(r101) == true) goto L13;
        if (com.xiaomi.push.m.f464124a.name().equals(r101) == false) goto L13;
        r100.a(r101, true);
        r100.b("CN", true);
    L11:
        r104 = r105;
    L20:
        com.xiaomi.channel.commonutils.logger.b.m8720a("XMPushService", new Object[]{"after check, appRegion is ", r101, ", countryCode=", r104});
        if (com.xiaomi.push.m.f464124a.name().equals(r101) == false) goto L23;
        fa.a("cn.app.chat.xiaomi.net");
    L23:
        a(r101);
        if (m9325h() == false) goto L36;
        com.xiaomi.channel.commonutils.logger.b.m8719a("XMPushService", "-->postOnCreate(): try trigger connect now");
        final int r106 = 11;
        final j r107 = new AnonymousClass13(this, r106);
        a(r107);
        com.xiaomi.push.service.q.a(new AnonymousClass14(this, r107));
    L36:
    L30:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
    L33:
        if ("com.xiaomi.xmsf".equals(getPackageName()) == false) goto L38;
        com.xiaomi.push.g.a(this, getApplicationInfo(), true);
        return;
    L38:
        return;
    L27:
        if (com.xiaomi.push.q.m9306a() == false) goto L33;
        this.f1003a.a(this);     // Catch: Exception -> L30
    L13:
        if (TextUtils.isEmpty(r101) == false) goto L15;
        r101 = com.xiaomi.push.m.f464124a.name();
        goto L20
    L15:
        if ("com.xiaomi.xmsf".equals(getPackageName()) == false) goto L17;
        r105 = "";
    L18:
        r100.a(r102, true);
        r100.b(r105, true);
        r101 = r102;
        goto L11
    L17:
        r102 = com.xiaomi.push.m.f464124a.name();
        goto L18
    L5:
        r104 = "";
        goto L6
    }

    private void d() {
        com.xiaomi.push.au r100 = com.xiaomi.push.at.m8812a();
        com.xiaomi.push.service.m.a(getApplicationContext()).a(r100);
        if (r100 == null) goto L9;
        StringBuilder r101 = new StringBuilder("network changed,");
        r101.append("[type: " + r100.m8822a() + "[" + r100.m8824b() + "], state: " + r100.m8821a() + HTTP.URL_DEFAULT + r100.m8820a());
        com.xiaomi.channel.commonutils.logger.b.m8719a("XMPushService", r101.toString());
        NetworkInfo.State r102 = r100.m8821a();
        if (r102 != NetworkInfo.State.SUSPENDED) goto L7;
        return;
    L7:
        if (r102 != NetworkInfo.State.UNKNOWN) goto L11;
        return;
    L11:
        if (en.a() == null) goto L13;
        en.a().m9049a();
    L13:
        fy.m9115a(this);
        this.f992a.d();
        if (com.xiaomi.push.at.m8819a(this) == true) goto L16;
        a(new g(this, 2, null));
    L27:
        e();
        return;
    L16:
        if (m9336c() == false) goto L21;
        if (m9323f() == false) goto L21;
        b(false);
    L21:
        if (m9336c() == false) goto L23;
    L25:
        da.a(this).a();
        goto L27
    L23:
        if (m9337d() == true) goto L25;
        this.f1004a.a(1);
        a(new e(this));
        goto L25
    L9:
        com.xiaomi.channel.commonutils.logger.b.m8719a("XMPushService", "network changed, no active network");
        goto L11
    }

    private void e() {
        if (m9331a() == true) goto L5;
        dy.a();
        return;
    L5:
        if (dy.m9039a() == true) goto L9;
        dy.a(true);
        return;
    }

    /* JADX INFO: renamed from: h, reason: collision with other method in class */
    private boolean m9325h() {
        String r100 = getPackageName();
        if ("com.xiaomi.xmsf".equals(r100) == false) goto L5;
        com.xiaomi.channel.commonutils.logger.b.m8718a("current sdk expect region is cn");
        boolean r101 = com.xiaomi.push.m.f464124a.name().equals(com.xiaomi.push.service.b.a(getApplicationContext()).a());
    L6:
        if (r101 == true) goto L8;
        com.xiaomi.channel.commonutils.logger.b.m8720a("XMPushService", new Object[]{"-->isPushEnabled(): isEnabled=", Boolean.valueOf(r101), ", package=", r100, ", region=", com.xiaomi.push.service.b.a(getApplicationContext()).a()});
    L8:
        return r101;
    L5:
        r101 = !com.xiaomi.push.service.r.a(this).m9414b(r100);
        goto L6
    }

    /* JADX INFO: renamed from: i, reason: collision with other method in class */
    private boolean m9326i() {
        if (getApplicationContext().getPackageName().equals("com.xiaomi.xmsf") == true) goto L5;
    L11:
        return false;
    L5:
        if (j() == false) goto L11;
        if (com.xiaomi.push.i.m9288b(this) == true) goto L11;
        if (com.xiaomi.push.i.m9285a(getApplicationContext()) == true) goto L11;
        return true;
    }

    private boolean k() {
        if (TextUtils.equals(getPackageName(), "com.xiaomi.xmsf") == false) goto L6;
        return false;
    L6:
        return ah.a(this).a(gj.H.a(), false);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.xiaomi.channel.commonutils.logger.b.a(getApplicationContext());
        com.xiaomi.push.q.a(this);
        com.xiaomi.push.service.p r100 = com.xiaomi.push.service.q.m9409a(this);
        if (r100 == null) goto L5;
        com.xiaomi.push.w.a(r100.f464330a);
    L5:
        AnonymousClass1 r101 = null;
        if (com.xiaomi.push.j.m9295a(getApplicationContext()) == false) goto L8;
        PthreadHandlerThreadV2 r102 = new PthreadHandlerThreadV2("hb-alarm");
        ThreadMethodProxy.start(r102);
        Handler r110 = new Handler(r102.getLooper());
        this.f996a = new a(this, r101);
        com.xiaomi.push.l.a(this, this.f996a, new IntentFilter(an.f464252q), "com.xiaomi.xmsf.permission.MIPUSH_RECEIVE", r110, 4);
        f464146b = true;
        r110.post(new AnonymousClass7(this));
    L8:
        this.f991a = new Messenger(new AnonymousClass8(this));
        ao.a(this);
        final Map r103 = null;
        final int r104 = 5222;
        final String r105 = "xiaomi.com";
        final fd r106 = null;
        fa r107 = new AnonymousClass9(this, r103, r104, r105, r106);
        this.f994a = r107;
        r107.a(true);
        this.f992a = new ex(this, this.f994a);
        this.f1003a = m9329a();
        dy.a(this);
        this.f992a.a(this);
        this.f1001a = new ak(this);
        this.f1002a = new as(this);
        new com.xiaomi.push.service.i().a();
        en.m9050a().a(this);
        this.f1004a = new com.xiaomi.push.service.n("Connection Controller Thread");
        am r108 = am.a();
        r108.b();
        r108.a(new AnonymousClass10(this));
        if (k() == false) goto L11;
        h();
    L11:
        gc.a(this).a(new com.xiaomi.push.service.o(this), "UPLOADER_PUSH_CHANNEL");
        a(new fz(this));
        a(new bd(this));
        if (com.xiaomi.push.j.m9295a(this) == false) goto L16;
        a(new al());
        if (com.xiaomi.push.i.m9284a() == false) goto L16;
        a(new AnonymousClass11(this));
    L16:
        a(new h(this));
        this.f1008a.add(ay.a(this));
        if (m9325h() == false) goto L20;
        this.f997a = new f(this);
        com.xiaomi.push.l.a(this, this.f997a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), null, null);
        this.f1006a = com.xiaomi.push.at.m8814a(this);
    L20:
        if (com.xiaomi.push.j.m9295a(getApplicationContext()) == false) goto L23;
        this.f1000a = new t(this);
        com.xiaomi.push.l.a(this, this.f1000a, new IntentFilter("miui.net.wifi.DIGEST_INFORMATION_CHANGED"), "miui.net.wifi.permission.ACCESS_WIFI_DIGEST_INFO", null, 2);
        k r109 = new k(this);
        this.f998a = r109;
        com.xiaomi.push.l.a(this, r109, new IntentFilter("com.xiaomi.xmsf.USE_INTELLIGENT_HB"), "com.xiaomi.xmsf.permission.INTELLIGENT_HB", null, 2);
    L23:
        if ("com.xiaomi.xmsf".equals(getPackageName()) == false) goto L34;
        Uri r111 = Settings.System.getUriFor("power_supersave_mode_open");
        if (r111 == null) goto L31;
        final Handler r112 = new Handler(Looper.getMainLooper());
        this.f990a = new AnonymousClass12(this, r112);
        getContentResolver().registerContentObserver(r111, false, this.f990a);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        com.xiaomi.channel.commonutils.logger.b.d("register super-power-mode observer err:" + th.getMessage());
    L31:
        int[] r113 = m9320a();
        if (r113 == null) goto L34;
        this.f999a = new r(this);
        IntentFilter r114 = new IntentFilter();
        r114.addAction("android.intent.action.SCREEN_ON");
        r114.addAction("android.intent.action.SCREEN_OFF");
        com.xiaomi.push.l.a(this, this.f999a, r114, null, null);
        this.f464147a = r113[0];
        this.f1010b = r113[1];
        com.xiaomi.channel.commonutils.logger.b.m8718a("falldown initialized: " + this.f464147a + "," + this.f1010b);
    L34:
        cm.a(this, this.f992a);
        cs.a(this, this.f992a);
        String r115 = "";
        if (r100 != null) goto L46;
    L43:
        cw.a(this);
        com.xiaomi.channel.commonutils.logger.b.e("XMPushService created. pid=" + Process.myPid() + ", uid=" + Process.myUid() + ", vc=" + com.xiaomi.push.g.a(getApplicationContext(), getPackageName()) + ", uuid=" + r115);
        return;
    L46:
        if (TextUtils.isEmpty(r100.f1123a) == true) goto L43;
        String[] r116 = r100.f1123a.split("@");     // Catch: Exception -> L45
        if (r116 == null) goto L43;
        if (r116.length <= 0) goto L43;
        r115 = r116[0];     // Catch: Exception -> L45
        goto L43
    }

    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    public static boolean m9322e() {
        return f464146b;
    }

    /* JADX INFO: renamed from: f, reason: collision with other method in class */
    private boolean m9323f() {
        if ((SystemClock.elapsedRealtime() - this.f989a) >= 30000) goto L7;
        return false;
    L7:
        return com.xiaomi.push.at.c(this);
    }

    /* JADX INFO: renamed from: g, reason: collision with other method in class */
    private boolean m9324g() {
        if ("com.xiaomi.xmsf".equals(getPackageName()) == true) goto L5;
        return false;
    L5:
        if (Settings.System.getInt(getContentResolver(), "power_supersave_mode_open", 0) != 1) goto L9;
        return true;
    L9:
        return false;
    }

    private void i() {
        ArrayList<n> r100 = this.f1007a;
        monitor-enter(r100);
        this.f1007a.clear();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9331a() {
        boolean r100 = com.xiaomi.push.at.m8819a(this);
        if (am.a().m9359a() <= 0) goto L5;
        boolean r101 = true;
    L6:
        boolean r102 = !m9335b();
        boolean r103 = m9325h();
        boolean r104 = !m9324g();
        if (r100 == false) goto L13;
        if (r101 == false) goto L13;
        if (r102 == false) goto L13;
        if (r103 == false) goto L13;
        if (r104 == false) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == true) goto L16;
        com.xiaomi.channel.commonutils.logger.b.e(String.format("not conn, net=%s;cnt=%s;!dis=%s;enb=%s;!spm=%s;", new Object[]{Boolean.valueOf(r100), Boolean.valueOf(r101), Boolean.valueOf(r102), Boolean.valueOf(r103), Boolean.valueOf(r104)}));
    L16:
        return r105;
    L13:
        r105 = false;
        goto L14
    L5:
        r101 = false;
        goto L6
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m9335b() {
        Class<?> r100 = com.xiaomi.push.q.a(this, "miui.os.Build");     // Catch: Throwable -> L11
        Field r101 = r100.getField("IS_CM_CUSTOMIZATION_TEST");     // Catch: Throwable -> L11
        Field r102 = r100.getField("IS_CU_CUSTOMIZATION_TEST");     // Catch: Throwable -> L11
        Field r103 = r100.getField("IS_CT_CUSTOMIZATION_TEST");     // Catch: Throwable -> L11
        if (r101.getBoolean(null) == false) goto L6;
    L9:
        return true;
    L6:
        if (r102.getBoolean(null) == true) goto L9;
        if (r103.getBoolean(null) == true) goto L9;
        return false;
    L15:
        return false;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m9336c() {
        ez r100 = this.f993a;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.m9087c() == false) goto L7;
        return true;
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public boolean m9337d() {
        ez r100 = this.f993a;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.m9086b() == false) goto L7;
        return true;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m9330a() {
        if ((SystemClock.elapsedRealtime() - this.f989a) >= ff.a()) goto L6;
        return;
    L6:
        if (com.xiaomi.push.at.c(this) == false) goto L9;
        b(true);
        return;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m9334b() {
        com.xiaomi.push.service.m.a(getApplicationContext()).m9397d();
        Iterator r100 = new ArrayList(this.f1007a).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((n) r100.next()).mo9117a();
        goto L4
    }

    private String a() {
        String r100 = com.xiaomi.push.j.m9292a("ro.miui.region");
        if (TextUtils.isEmpty(r100) == true) goto L5;
        return r100;
    L5:
        return com.xiaomi.push.j.m9292a("ro.product.locale.region");
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public com.xiaomi.push.service.h m9333b() {
        return this.f1003a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public int m9327a() {
        if (this.f464148c >= 0) goto L6;
        this.f464148c = com.xiaomi.push.g.a(this, "com.xiaomi.xmsf");
    L6:
        return this.f464148c;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public com.xiaomi.push.service.h m9329a() {
        return new com.xiaomi.push.service.h();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public ez m9328a() {
        return this.f993a;
    }

    private static void a(String r100) {
        if (com.xiaomi.push.m.f464124a.name().equals(r100) == false) goto L6;
        cf.a("cn.app.chat.xiaomi.net", "cn.app.chat.xiaomi.net");
        cf.a("cn.app.chat.xiaomi.net", "111.13.141.211:443");
        cf.a("cn.app.chat.xiaomi.net", "39.156.81.172:443");
        cf.a("cn.app.chat.xiaomi.net", "111.202.1.250:443");
        cf.a("cn.app.chat.xiaomi.net", "123.125.102.213:443");
        cf.a("resolver.msg.xiaomi.net", "111.13.142.153:443");
        cf.a("resolver.msg.xiaomi.net", "111.202.1.252:443");
        return;
    }

    private void b(Intent r110) {
        String r100 = r110.getStringExtra(an.F);
        String r101 = r110.getStringExtra(an.f464235J);
        Bundle r102 = INVOKEVIRTUAL_com_xiaomi_push_service_XMPushService_com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(r110, "ext_packet");
        am r103 = am.a();
        if (r102 == null) goto L8;
        fm r111 = (fm) a(new fm(r102), r100, r101);
        if (r111 != null) goto L7;
        return;
    L7:
        eq r112 = eq.a(r111, r103.a(r111.k(), r111.m()).f464222h);
    L24:
        if (r112 == null) goto L31;
        c(new aw(this, r112));
        return;
    L31:
        return;
    L8:
        byte[] r104 = r110.getByteArrayExtra("ext_raw_packet");
        if (r104 != null) goto L27;
    L23:
        r112 = null;
        goto L24
    L27:
        long r105 = CastLongProtector.parseLong(r110.getStringExtra(an.f464254s));     // Catch: NumberFormatException -> L12
    L13:
        String r106 = r110.getStringExtra(an.f464255t);
        String r107 = r110.getStringExtra(an.f464256u);
        String r108 = r110.getStringExtra("ext_chid");
        am.b r109 = r103.a(r108, String.valueOf(r105));
        if (r109 == null) goto L23;
        eq r113 = new eq();
        r113.a(CastIntegerProtector.parseInt(r108));     // Catch: NumberFormatException -> L18
    L19:
        r113.a("SECMSG", null);
        if (TextUtils.isEmpty(r106) == false) goto L22;
        r106 = "xiaomi.com";
    L22:
        r113.a(r105, r106, r107);
        r113.a(r110.getStringExtra("ext_pkt_id"));
        r113.a(r104, r109.f464222h);
        com.xiaomi.channel.commonutils.logger.b.m8718a("send a message: chid=" + r108 + ", packetId=" + r110.getStringExtra("ext_pkt_id"));
        r112 = r113;
    L12:
        r105 = 0;
        goto L13
    }

    private void c(Intent r100) {
        String r101 = r100.getStringExtra(an.F);
        String r102 = r100.getStringExtra(an.f464235J);
        Parcelable[] r103 = r100.getParcelableArrayExtra("ext_packets");
        int r104 = r103.length;
        fm[] r105 = new fm[r104];
        r100.getBooleanExtra("ext_encrypt", true);
        int r106 = 0;
        int r107 = 0;
    L4:
        if (r107 >= r103.length) goto L9;
        fm r108 = new fm((Bundle) r103[r107]);
        r105[r107] = r108;
        fm r109 = (fm) a(r108, r101, r102);
        r105[r107] = r109;
        if (r109 == null) goto L7;
        r107 = r107 + 1;
        goto L4
    L7:
        return;
    L9:
        am r110 = am.a();
        eq[] r111 = new eq[r104];
    L10:
        if (r106 >= r104) goto L12;
        fm r112 = r105[r106];
        r111[r106] = eq.a(r112, r110.a(r112.k(), r112.m()).f464222h);
        r106 = r106 + 1;
        goto L10
    L12:
        c(new com.xiaomi.push.service.c(this, r111));
    }

    private void d(Intent r110) {
        am r100 = am.a();
        boolean r101 = true;
        int r102 = 0;
        if (an.f464239d.equalsIgnoreCase(r110.getAction()) == false) goto L5;
    L303:
        String r103 = r110.getStringExtra(an.f464257v);
        if (TextUtils.isEmpty(r110.getStringExtra(an.B)) == false) goto L307;
        com.xiaomi.channel.commonutils.logger.b.m8718a("security is empty. ignore.");
        return;
    L307:
        if (TextUtils.isEmpty(r103) == true) goto L325;
        boolean r104 = m9319a(r103, r110);
        am.b r105 = a(r103, r110);
        if (com.xiaomi.push.at.b(this) == true) goto L312;
        this.f1003a.a(this, r105, false, 2, null);
        return;
    L312:
        if (m9336c() == false) goto L324;
        am.c r106 = r105.f1052a;
        if (r106 != am.c.f464232a) goto L316;
        c(new b(this, r105));
        return;
    L316:
        if (r104 == false) goto L319;
        c(new p(this, r105));
        return;
    L319:
        if (r106 != am.c.f464233b) goto L322;
        com.xiaomi.channel.commonutils.logger.b.m8718a(String.format("the client is binding. %1$s %2$s.", new Object[]{r105.f464221g, am.b.a(r105.f1057b)}));
        return;
    L322:
        if (r106 != am.c.f464234c) goto L415;
        this.f1003a.a(this, r105, true, 0, null);
        return;
    L415:
        return;
    L324:
        a(true);
        return;
    L325:
        com.xiaomi.channel.commonutils.logger.b.d("channel id is empty, do nothing!");
        return;
    L5:
        if (an.f464245j.equalsIgnoreCase(r110.getAction()) == true) goto L303;
        if (an.f464244i.equalsIgnoreCase(r110.getAction()) == false) goto L20;
        String r107 = r110.getStringExtra(an.F);
        String r108 = r110.getStringExtra(an.f464257v);
        String r109 = r110.getStringExtra(an.f464254s);
        com.xiaomi.channel.commonutils.logger.b.m8718a("Service called close channel chid = " + r108 + " res = " + am.b.a(r109));
        if (TextUtils.isEmpty(r108) == false) goto L16;
        Iterator<String> r111 = r100.m9362a(r107).iterator();
    L13:
        if (r111.hasNext() == false) goto L420;
        a(r111.next(), 2);
        goto L13
    L420:
        return;
    L16:
        if (TextUtils.isEmpty(r109) == false) goto L18;
        a(r108, 2);
        return;
    L18:
        a(r108, r109, 2, null, null);
        return;
    L20:
        if (an.f464240e.equalsIgnoreCase(r110.getAction()) == false) goto L23;
        b(r110);
        return;
    L23:
        if (an.f464242g.equalsIgnoreCase(r110.getAction()) == false) goto L26;
        c(r110);
        return;
    L26:
        if (an.f464241f.equalsIgnoreCase(r110.getAction()) == false) goto L31;
        fn r112 = a(new fl(INVOKEVIRTUAL_com_xiaomi_push_service_XMPushService_com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(r110, "ext_packet")), r110.getStringExtra(an.F), r110.getStringExtra(an.f464235J));
        if (r112 == null) goto L343;
        c(new aw(this, eq.a(r112, r100.a(r112.k(), r112.m()).f464222h)));
        return;
    L343:
        return;
    L31:
        if (an.f464243h.equalsIgnoreCase(r110.getAction()) == false) goto L36;
        fn r113 = a(new fp(INVOKEVIRTUAL_com_xiaomi_push_service_XMPushService_com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(r110, "ext_packet")), r110.getStringExtra(an.F), r110.getStringExtra(an.f464235J));
        if (r113 == null) goto L345;
        c(new aw(this, eq.a(r113, r100.a(r113.k(), r113.m()).f464222h)));
        return;
    L345:
        return;
    L36:
        if (an.f464246k.equals(r110.getAction()) == false) goto L50;
        String r114 = r110.getStringExtra(an.f464257v);
        String r115 = r110.getStringExtra(an.f464254s);
        if (r114 == null) goto L347;
        com.xiaomi.channel.commonutils.logger.b.m8718a("request reset connection from chid = ".concat(r114));
        am.b r116 = am.a().a(r114, r115);
        if (r116 != null) goto L42;
        return;
    L42:
        if (r116.f464222h.equals(r110.getStringExtra(an.B)) == true) goto L44;
        return;
    L44:
        if (r116.f1052a != am.c.f464234c) goto L350;
        ez r117 = m9328a();
        if (r117 != null) goto L48;
    L49:
        c(new q(this));
        return;
    L48:
        if (r117.a(SystemClock.elapsedRealtime() - 15000) == false) goto L49;
        return;
    L350:
        return;
    L347:
        return;
    L50:
        String r118 = null;
        am.b r119 = null;
        r119 = null;
        r118 = null;
        if (an.f464247l.equals(r110.getAction()) == false) goto L75;
        String r120 = r110.getStringExtra(an.F);
        List<String> r121 = r100.m9362a(r120);
        if (r121.isEmpty() == false) goto L56;
        com.xiaomi.channel.commonutils.logger.b.m8718a("open channel should be called first before update info, pkg=" + r120);
        return;
    L56:
        String r122 = r110.getStringExtra(an.f464257v);
        String r123 = r110.getStringExtra(an.f464254s);
        if (TextUtils.isEmpty(r122) == false) goto L60;
        r122 = (String) ListProtector.get(r121, 0);
    L60:
        if (TextUtils.isEmpty(r123) == false) goto L66;
        Collection<am.b> r124 = r100.m9361a(r122);
        if (r124 != null) goto L64;
    L67:
        if (r119 != null) goto L69;
        return;
    L69:
        if (r110.hasExtra(an.D) == false) goto L72;
        r119.f464219e = r110.getStringExtra(an.D);
    L72:
        if (r110.hasExtra(an.E) == false) goto L354;
        r119.f464220f = r110.getStringExtra(an.E);
        return;
    L354:
        return;
    L64:
        if (r124.isEmpty() == true) goto L67;
        r119 = r124.iterator().next();
        goto L67
    L66:
        r119 = r100.a(r122, r123);
        goto L67
    L75:
        if ("android.intent.action.SCREEN_ON".equals(r110.getAction()) == true) goto L288;
        if ("android.intent.action.SCREEN_OFF".equals(r110.getAction()) == true) goto L288;
        if ("com.xiaomi.mipush.REGISTER_APP".equals(r110.getAction()) == false) goto L94;
        if (ap.a(getApplicationContext()).m9369a() == true) goto L84;
    L87:
        final byte[] r125 = r110.getByteArrayExtra("mipush_payload");
        final String r126 = r110.getStringExtra("mipush_app_package");
        boolean r127 = r110.getBooleanExtra("mipush_env_chanage", false);
        final int r128 = r110.getIntExtra("mipush_env_type", 1);
        com.xiaomi.push.service.r.a(this).d(r126);
        if (r127 == true) goto L90;
    L92:
        a(r125, r126);
        return;
    L90:
        if ("com.xiaomi.xmsf".equals(getPackageName()) == true) goto L92;
        final int r129 = 14;
        c(new AnonymousClass2(this, r129, r128, r126, r125));
        return;
    L84:
        if (ap.a(getApplicationContext()).a() != 0) goto L87;
        com.xiaomi.channel.commonutils.logger.b.m8718a("register without being provisioned. " + r110.getStringExtra("mipush_app_package"));
        return;
    L94:
        if ("com.xiaomi.mipush.SEND_MESSAGE".equals(r110.getAction()) == false) goto L96;
    L278:
        String r130 = r110.getStringExtra("mipush_app_package");
        byte[] r131 = r110.getByteArrayExtra("mipush_payload");
        boolean r132 = r110.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
        if (com.xiaomi.push.service.k.a(r131, r130) == false) goto L282;
        com.xiaomi.channel.commonutils.logger.b.m8718a("duplicate msg from: ".concat(String.valueOf(r130)));
        return;
    L282:
        if ("com.xiaomi.mipush.UNREGISTER_APP".equals(r110.getAction()) == false) goto L286;
        com.xiaomi.push.service.r.a(this).a(r130);
        if (com.xiaomi.push.j.m9295a(getApplicationContext()) == false) goto L286;
        v.a(r130);
    L286:
        a(r130, r131, r132);
        return;
    L96:
        if ("com.xiaomi.mipush.UNREGISTER_APP".equals(r110.getAction()) == true) goto L278;
        if (aq.f464264a.equals(r110.getAction()) == false) goto L137;
        String r133 = r110.getStringExtra("uninstall_pkg_name");
        if (r133 != null) goto L103;
        return;
    L103:
        if (TextUtils.isEmpty(r133.trim()) == true) goto L338;
        PackageInfo r134 = getPackageManager().getPackageInfo(r133, 0);     // Catch: PackageManager.NameNotFoundException -> L114
        if (r134 != null) goto L108;
    L113:
        r101 = false;
        goto L116
    L108:
        if (r134.applicationInfo == null) goto L113;
        if (com.xiaomi.push.i.m9286a(this, r134.packageName) == false) goto L113;
        com.xiaomi.channel.commonutils.logger.b.m8718a("dual space's app uninstalled ".concat(r133));     // Catch: PackageManager.NameNotFoundException -> L114
    L116:
        if ("com.xiaomi.channel".equals(r133) == true) goto L118;
    L122:
        SharedPreferences r135 = getSharedPreferences("pref_registered_pkg_names", 0);
        String r136 = r135.getString(r133, null);
        if (TextUtils.isEmpty(r136) == true) goto L358;
        if (r101 == false) goto L359;
        SharedPreferences.Editor r137 = r135.edit();
        r137.remove(r133);
        r137.commit();
        if (x.m9428b(this, r133) == false) goto L128;
        x.c(this, r133);
    L128:
        x.m9422a(this, r133);
        ac.a(getApplicationContext(), r133);
        if (m9336c() == false) goto L360;
        if (r136 == null) goto L361;
        w.a(this, w.a(r133, r136));     // Catch: fh -> L133
        com.xiaomi.channel.commonutils.logger.b.m8718a("uninstall " + r133 + " msg sent");     // Catch: fh -> L133
        return;
    L133:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.d("Fail to send Message: " + e.getMessage());
        a(10, e);
        return;
    L361:
        return;
    L360:
        return;
    L359:
        return;
    L358:
        return;
    L118:
        if (am.a().m9361a("1").isEmpty() == true) goto L122;
        if (r101 == false) goto L122;
        a("1", 0);
        com.xiaomi.channel.commonutils.logger.b.m8718a("close the miliao channel as the app is uninstalled.");
        return;
    L338:
        return;
    L137:
        if (aq.f464265b.equals(r110.getAction()) == false) goto L160;
        String r138 = r110.getStringExtra("data_cleared_pkg_name");
        if (TextUtils.isEmpty(r138) == false) goto L327;
        return;
    L327:
        SharedPreferences r139 = getSharedPreferences("pref_registered_pkg_names", 0);     // Catch: Throwable -> L147
        if (r139 == null) goto L151;
        r118 = r139.getString(r138, null);     // Catch: Throwable -> L145
    L145:
        th = th;
    L149:
        com.xiaomi.channel.commonutils.logger.b.m8718a("Fail to get sp or appId : " + th);
    L151:
        if (TextUtils.isEmpty(r118) == true) goto L156;
        SharedPreferences.Editor r140 = r139.edit();
        r140.remove(r138);
        r140.commit();
        if (x.m9428b(this, r138) == false) goto L155;
        x.c(this, r138);
    L155:
        x.m9422a(this, r138);
        a(r138, ho.a(w.b(r138, r118)), true);
    L156:
        ac.a(this, r138);
        if (com.xiaomi.push.j.m9295a(getApplicationContext()) == false) goto L363;
        v.a(r138);
        return;
    L363:
        return;
    L147:
        th = th;
        r139 = null;
        goto L149
    L160:
        if ("com.xiaomi.mipush.CLEAR_NOTIFICATION".equals(r110.getAction()) == false) goto L168;
        String r141 = r110.getStringExtra(an.F);
        int r142 = r110.getIntExtra(an.G, -2);
        if (TextUtils.isEmpty(r141) == false) goto L164;
        return;
    L164:
        if (r142 < (-1)) goto L166;
        x.a(this, r141, r142, r110.getIntExtra(an.H, -1));
        return;
    L166:
        x.a(this, r141, r110.getStringExtra(an.L), r110.getStringExtra(an.M));
        return;
    L168:
        if ("com.xiaomi.mipush.CLEAR_HEADSUPNOTIFICATION".equals(r110.getAction()) == false) goto L173;
        String r143 = r110.getStringExtra(an.F);
        if (TextUtils.isEmpty(r143) == true) goto L368;
        x.m9427b(this, r143);
        return;
    L368:
        return;
    L173:
        if ("com.xiaomi.mipush.SET_NOTIFICATION_TYPE".equals(r110.getAction()) == false) goto L188;
        String r144 = r110.getStringExtra(an.F);
        String r145 = r110.getStringExtra(an.K);
        if (r110.hasExtra(an.I) == false) goto L177;
        int r146 = r110.getIntExtra(an.I, 0);
        String r147 = com.xiaomi.push.az.b(r144 + r146);
        r102 = r146;
        r101 = false;
    L179:
        if (TextUtils.isEmpty(r144) == false) goto L181;
    L186:
        com.xiaomi.channel.commonutils.logger.b.d("invalid notification for " + r144);
        return;
    L181:
        if (TextUtils.equals(r145, r147) == false) goto L186;
        if (r101 == false) goto L185;
        x.c(this, r144);
        return;
    L185:
        x.b(this, r144, r102);
        return;
    L177:
        r147 = com.xiaomi.push.az.b(r144);
        goto L179
    L188:
        if ("com.xiaomi.mipush.DISABLE_PUSH".equals(r110.getAction()) == false) goto L196;
        String r148 = r110.getStringExtra("mipush_app_package");
        if (TextUtils.isEmpty(r148) == true) goto L193;
        com.xiaomi.push.service.r.a(this).b(r148);
    L193:
        if ("com.xiaomi.xmsf".equals(getPackageName()) == true) goto L373;
        a(19, null);
        e();
        stopSelf();
        return;
    L373:
        return;
    L196:
        if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(r110.getAction()) == false) goto L198;
    L262:
        String r149 = r110.getStringExtra("mipush_app_package");
        byte[] r150 = r110.getByteArrayExtra("mipush_payload");
        String r151 = r110.getStringExtra("mipush_app_id");
        String r152 = r110.getStringExtra("mipush_app_token");
        if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(r110.getAction()) == false) goto L266;
        com.xiaomi.push.service.r.a(this).c(r149);
    L266:
        if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(r110.getAction()) == false) goto L268;
        com.xiaomi.push.service.r.a(this).e(r149);
        com.xiaomi.push.service.r.a(this).f(r149);
    L268:
        if (r150 != null) goto L270;
        com.xiaomi.push.service.t.a(this, r149, r150, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
        return;
    L270:
        com.xiaomi.push.service.t.b(r149, r150);
        a(new com.xiaomi.push.service.s(this, r149, r151, r152, r150));
        if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(r110.getAction()) == true) goto L273;
        return;
    L273:
        if (this.f997a != null) goto L276;
        this.f997a = new f(this);
        com.xiaomi.push.l.a(this, this.f997a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), null, null);
    L276:
        if (this.f1006a != null) goto L398;
        this.f1006a = com.xiaomi.push.at.m8814a(this);
        return;
    L398:
        return;
    L198:
        if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(r110.getAction()) == true) goto L262;
        if ("com.xiaomi.mipush.SEND_TINYDATA".equals(r110.getAction()) == false) goto L208;
        String r153 = r110.getStringExtra("mipush_app_package");
        byte[] r154 = r110.getByteArrayExtra("mipush_payload");
        gi r155 = new gi();
        ho.a(r155, r154);     // Catch: ht -> L205
        gc.a(this).a(r155, r153);     // Catch: ht -> L205
        return;
    L205:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
        return;
    L208:
        if ("com.xiaomi.push.timer".equalsIgnoreCase(r110.getAction()) == false) goto L221;
        com.xiaomi.channel.commonutils.logger.b.m8718a("[Alarm] Service called on timer");
        if (m9326i() == true) goto L212;
        dy.a(false);
        if (m9323f() == false) goto L217;
        b(false);
    L217:
        a r156 = this.f996a;
        if (r156 == null) goto L376;
        a.a(r156);
        return;
    L376:
        return;
    L212:
        if (dy.m9039a() == false) goto L217;
        com.xiaomi.channel.commonutils.logger.b.m8718a("enter falldown mode, stop alarm");
        dy.a();
        goto L217
    L221:
        if ("com.xiaomi.push.check_alive".equalsIgnoreCase(r110.getAction()) == false) goto L226;
        com.xiaomi.channel.commonutils.logger.b.m8718a("Service called on check alive.");
        if (m9323f() == false) goto L378;
        b(false);
        return;
    L378:
        return;
    L226:
        if ("com.xiaomi.mipush.thirdparty".equals(r110.getAction()) == false) goto L229;
        com.xiaomi.channel.commonutils.logger.b.m8718a("on thirdpart push :" + r110.getStringExtra("com.xiaomi.mipush.thirdparty_DESC"));
        dy.a(this, r110.getIntExtra("com.xiaomi.mipush.thirdparty_LEVEL", 0));
        return;
    L229:
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r110.getAction()) == false) goto L232;
        d();
        return;
    L232:
        if ("miui.net.wifi.DIGEST_INFORMATION_CHANGED".equals(r110.getAction()) == false) goto L235;
        a(r110);
        return;
    L235:
        if ("com.xiaomi.xmsf.USE_INTELLIGENT_HB".equals(r110.getAction()) == false) goto L244;
        if (r110.getExtras() == null) goto L383;
        int r157 = r110.getExtras().getInt("effectivePeriod", 0);
        if (r157 > 0) goto L241;
        return;
    L241:
        if (r157 > 604800) goto L385;
        com.xiaomi.push.service.m.a(getApplicationContext()).a(r157);
        return;
    L385:
        return;
    L383:
        return;
    L244:
        if ("action_cr_config".equals(r110.getAction()) == false) goto L255;
        boolean r158 = r110.getBooleanExtra("action_cr_event_switch", false);
        long r159 = r110.getLongExtra("action_cr_event_frequency", 86400);
        boolean r160 = r110.getBooleanExtra("action_cr_perf_switch", false);
        long r161 = r110.getLongExtra("action_cr_perf_frequency", 86400);
        boolean r162 = r110.getBooleanExtra("action_cr_event_en", true);
        long r163 = r110.getLongExtra("action_cr_max_file_size", 1048576);
        Config r164 = Config.getBuilder().setEventUploadSwitchOpen(r158).setEventUploadFrequency(r159).setPerfUploadSwitchOpen(r160).setPerfUploadFrequency(r161).setAESKey(bk.a(getApplicationContext())).setEventEncrypted(r162).setMaxFileLength(r163).build(getApplicationContext());
        if ("com.xiaomi.xmsf".equals(getPackageName()) == false) goto L248;
        return;
    L248:
        if (r159 > 0) goto L250;
        return;
    L250:
        if (r161 > 0) goto L252;
        return;
    L252:
        if (r163 <= 0) goto L390;
        dr.a(getApplicationContext(), r164);
        return;
    L390:
        return;
    L255:
        if (an.f464249n.equals(r110.getAction()) == false) goto L258;
        com.xiaomi.push.service.l.a(getApplicationContext(), r110);
        return;
    L258:
        if (an.f464250o.equals(r110.getAction()) == false) goto L393;
        String r165 = r110.getStringExtra("ext_downward_pkt_id");
        if (TextUtils.isEmpty(r165) == true) goto L394;
        at.a().b(r165, r110.getLongExtra("ext_app_receive_time", 0));
        return;
    L394:
        return;
    L393:
        return;
    L288:
        if ("android.intent.action.SCREEN_ON".equals(r110.getAction()) == false) goto L297;
        if (m9326i() == true) goto L402;
        com.xiaomi.channel.commonutils.logger.b.m8718a("exit falldown mode, activate alarm.");
        e();
        if (m9336c() == false) goto L294;
        return;
    L294:
        if (m9337d() == true) goto L404;
        a(true);
        return;
    L404:
        return;
    L402:
        return;
    L297:
        if ("android.intent.action.SCREEN_OFF".equals(r110.getAction()) == true) goto L299;
        return;
    L299:
        if (m9326i() == true) goto L301;
        return;
    L301:
        if (dy.m9039a() == false) goto L408;
        com.xiaomi.channel.commonutils.logger.b.m8718a("enter falldown mode, stop alarm.");
        dy.a();
        return;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r100) {
        return this.f991a.getBinder();
    }

    private void c(boolean r100) {
    L16:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
        return;
    L3:
        if (com.xiaomi.push.q.m9306a() == true) goto L5;
        return;
    L5:
        if (r100 == false) goto L13;
        if (com.xiaomi.push.j.m9295a(this) == false) goto L9;
        Intent r101 = new Intent("miui.intent.action.NETWORK_CONNECTED");     // Catch: Exception -> L16
        r101.addFlags(1073741824);     // Catch: Exception -> L16
        sendBroadcast(r101);     // Catch: Exception -> L16
    L9:
        int r102 = 0;
        aa[] r103 = (aa[]) this.f1008a.toArray(new aa[0]);     // Catch: Exception -> L16
        int r104 = r103.length;     // Catch: Exception -> L16
    L10:
        if (r102 >= r104) goto L24;
        r103[r102].mo9380a();     // Catch: Exception -> L16
        r102 = r102 + 1;     // Catch: Exception -> L16
        goto L10
    L24:
        return;
    L13:
        if (com.xiaomi.push.j.m9295a(this) == false) goto L22;
        Intent r105 = new Intent("miui.intent.action.NETWORK_BLOCKED");     // Catch: Exception -> L16
        r105.addFlags(1073741824);     // Catch: Exception -> L16
        sendBroadcast(r105);     // Catch: Exception -> L16
        return;
    }

    public void a(am.b r100) {
        if (r100 == null) goto L5;
        long r101 = r100.a();
        com.xiaomi.channel.commonutils.logger.b.m8718a("schedule rebind job in " + (r101 / 1000));
        a(new b(this, r100), r101);
        return;
    }

    @Override // com.xiaomi.push.fc
    public void b(ez r100) {
        en.a().b(r100);
        c(true);
        this.f1002a.m9371a();
        if (dy.m9039a() == false) goto L5;
    L7:
        Iterator<am.b> r101 = am.a().m9360a().iterator();
    L9:
        if (r101.hasNext() == false) goto L12;
        a(new b(this, r101.next()));
        goto L9
    L12:
        if (this.f1009a == false) goto L14;
        return;
    L14:
        if (com.xiaomi.push.j.m9295a(getApplicationContext()) == false) goto L19;
        com.xiaomi.push.ad.a(getApplicationContext()).a(new AnonymousClass6(this));
        return;
    L19:
        return;
    L5:
        if (m9326i() == true) goto L7;
        com.xiaomi.channel.commonutils.logger.b.m8718a("reconnection successful, reactivate alarm.");
        dy.a(true);
        goto L7
    }

    private void a(Intent r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Bundle r101 = r100.getExtras();
        if (r101 == null) goto L8;
        String r102 = r101.getString("digest");
        com.xiaomi.push.service.m.a(getApplicationContext()).m9393a(r102);
        cm.a(this, r102);
        return;
    }

    private void b(boolean r100) {
        this.f989a = SystemClock.elapsedRealtime();
        if (m9336c() == true) goto L6;
        a(true);
        return;
    L6:
        if (com.xiaomi.push.at.m8819a(this) == false) goto L8;
        c(new o(this, r100));
        return;
    L8:
        c(new g(this, 17, null));
        a(true);
    }

    private void c(j r100) {
        this.f1004a.a(r100);
    }

    private boolean a(Context r100) {
        com.xiaomi.push.af.a();     // Catch: Exception -> L15
        int r101 = 100;
    L5:
        if (r101 <= 0) goto L12;
        if (com.xiaomi.push.at.b(r100) == true) goto L8;
        Thread.sleep(100);     // Catch: Exception -> L14
    L11:
        r101 = r101 - 1;
        goto L5
    L8:
        com.xiaomi.channel.commonutils.logger.b.m8718a("network connectivity ok.");
        return true;
    L12:
        return false;
    L24:
        return true;
    }

    public static /* synthetic */ void c(XMPushService r100) {
        r100.f();
    }

    public void b(j r100) {
        this.f1004a.a(r100.f464318a, r100);
    }

    public static /* synthetic */ void b(XMPushService r100) {
        r100.c();
    }

    public void a(eq r100) {
        ez r101 = this.f993a;
        if (r101 == null) goto L7;
        r101.b(r100);
        return;
    L7:
        throw new fh("try send msg while connection is null.");
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static /* synthetic */ boolean m9321b(XMPushService r100) {
        return r100.f1009a;
    }

    public void a(eq[] r100) {
        ez r101 = this.f993a;
        if (r101 == null) goto L7;
        r101.a(r100);
        return;
    L7:
        throw new fh("try send msg while connection is null.");
    }

    @Override // com.xiaomi.push.fc
    public void a(ez r100) {
        com.xiaomi.channel.commonutils.logger.b.c("begin to connect...");
        en.a().a(r100);
    }

    public void a(n r100) {
        ArrayList<n> r101 = this.f1007a;
        monitor-enter(r101);
        this.f1007a.add(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void a(BroadcastReceiver r100) {
        if (r100 == null) goto L10;
        INVOKEVIRTUAL_com_xiaomi_push_service_XMPushService_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(this, r100);     // Catch: IllegalArgumentException -> L5
        return;
    L5:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
        return;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9332a(int r100) {
        return this.f1004a.m9400a(r100);
    }

    public void a(int r100) {
        this.f1004a.a(r100);
    }

    public void a(j r100) {
        a(r100, 0);
    }

    public void a(boolean r100) {
        this.f1002a.a(r100);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static /* synthetic */ boolean m9318a(XMPushService r100) {
        return r100.m9324g();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static /* synthetic */ void m9317a(XMPushService r100) {
        r100.e();
    }

    public static /* synthetic */ ez a(XMPushService r100) {
        return r100.f993a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static /* synthetic */ fa m9314a(XMPushService r100) {
        return r100.f994a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static /* synthetic */ ak m9315a(XMPushService r100) {
        return r100.f1001a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static /* synthetic */ com.xiaomi.push.service.n m9316a(XMPushService r100) {
        return r100.f1004a;
    }

    public static Bundle INVOKEVIRTUAL_com_xiaomi_push_service_XMPushService_com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(Intent r100, String r101) {
        Bundle r102 = r100.getBundleExtra(r101);
        Context r103 = BadParcelableCrashOptimizer.getContext();
        if (r102 == null) goto L6;
        if (r103 == null) goto L6;
        r102.setClassLoader(r103.getClassLoader());
    L6:
        return r102;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void INVOKEVIRTUAL_com_xiaomi_push_service_XMPushService_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(XMPushService r100, BroadcastReceiver r101) {
        ReceiverRegisterLancet.loge(r101, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L14;
        r100.unregisterReceiver(r101);
        return;
    L14:
    L8:
        e = move-exception;
        if (r101 == null) goto L11;
        Npth.addTag("unregisterReceiver", r101.toString());
    L11:
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r101, r100) == false) goto L16;
        r100.unregisterReceiver(r101);     // Catch: Exception -> L8
        return;
    }

    public void a(byte[] r110, String r111) {
        if (r110 != null) goto L5;
        com.xiaomi.push.service.t.a(this, r111, r110, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
        com.xiaomi.channel.commonutils.logger.b.m8718a("register request without payload");
        return;
    L5:
        ha r100 = new ha();
        ho.a(r100, r110);     // Catch: ht -> L15
        if (r100.f770a != ge.f463646a) goto L13;
        he r101 = new he();     // Catch: ht -> L15
        ho.a(r101, r100.m9203a());     // Catch: ht -> L11
        a(new com.xiaomi.push.service.s(this, r100.b(), r101.b(), r101.c(), r110));     // Catch: ht -> L11
        ds.a(getApplicationContext()).a(r100.b(), "E100003", r101.a(), 6002, null);     // Catch: ht -> L11
    L20:
        return;
    L11:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.d("app register error. " + e);     // Catch: ht -> L15
        com.xiaomi.push.service.t.a(this, r111, r110, ErrorCode.ERROR_INVALID_PAYLOAD, " data action error.");     // Catch: ht -> L15
        goto L20
    L13:
        com.xiaomi.push.service.t.a(this, r111, r110, ErrorCode.ERROR_INVALID_PAYLOAD, " registration action required.");     // Catch: ht -> L15
        com.xiaomi.channel.commonutils.logger.b.m8718a("register request with invalid payload");     // Catch: ht -> L15
    L15:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.d("app register fail. " + e);
        com.xiaomi.push.service.t.a(this, r111, r110, ErrorCode.ERROR_INVALID_PAYLOAD, " data container error.");
    }

    @Override // android.app.Service
    public void onStart(Intent r110, int r111) {
        long r100 = System.currentTimeMillis();
        if (r110 != null) goto L37;
        com.xiaomi.channel.commonutils.logger.b.d("onStart() with intent NULL");
    L13:
        if (r110 != null) goto L15;
    L29:
        long r112 = System.currentTimeMillis() - r100;
        if (r112 <= 50) goto L39;
        com.xiaomi.channel.commonutils.logger.b.c("[Prefs] spend " + r112 + " ms, too more times.");
        return;
    L39:
        return;
    L15:
        if (r110.getAction() == null) goto L29;
        if ("com.xiaomi.push.timer".equalsIgnoreCase(r110.getAction()) == true) goto L26;
        if ("com.xiaomi.push.check_alive".equalsIgnoreCase(r110.getAction()) == true) goto L26;
        if ("com.xiaomi.push.network_status_changed".equalsIgnoreCase(r110.getAction()) == true) goto L29;
        a(new i(this, r110));
    L26:
        if (this.f1004a.m9399a() == false) goto L28;
        com.xiaomi.channel.commonutils.logger.b.d("ERROR, the job controller is blocked.");
        am.a().a(this, 14);
        stopSelf();
        goto L29
    L28:
        a(new i(this, r110));
        goto L29
    L37:
        String r113 = r110.getStringExtra(an.f464257v);     // Catch: Throwable -> L33
        String r101 = r110.getStringExtra(an.F);     // Catch: Throwable -> L33
        String r102 = r110.getStringExtra("mipush_app_package");     // Catch: Throwable -> L33
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r110.getAction()) == false) goto L9;
    L12:
        com.xiaomi.channel.commonutils.logger.b.m8719a("XMPushService", String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s, intent = %s", new Object[]{r110.getAction(), r113, r101, r102, com.xiaomi.push.j.a(r110)}));     // Catch: Throwable -> L33
    L36:
        goto L13
    L9:
        if ("miui.net.wifi.DIGEST_INFORMATION_CHANGED".equals(r110.getAction()) == true) goto L12;
        com.xiaomi.channel.commonutils.logger.b.m8719a("XMPushService", String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s", new Object[]{r110.getAction(), r113, r101, r102}));     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        com.xiaomi.channel.commonutils.logger.b.d("onStart() cause error: " + th.getMessage());
    }

    private am.b a(String r100, Intent r101) {
        String r102 = r101.getStringExtra(an.f464254s);
        am.b r103 = am.a().a(r100, r102);
        if (r103 != null) goto L5;
        r103 = new am.b(this);
    L5:
        r103.f464221g = r101.getStringExtra(an.f464257v);
        r103.f1057b = r101.getStringExtra(an.f464254s);
        r103.f464217c = r101.getStringExtra(an.f464261z);
        r103.f1054a = r101.getStringExtra(an.F);
        r103.f464219e = r101.getStringExtra(an.D);
        r103.f464220f = r101.getStringExtra(an.E);
        r103.f1056a = r101.getBooleanExtra(an.C, false);
        r103.f464222h = r101.getStringExtra(an.B);
        r103.f464223i = r101.getStringExtra(an.f464235J);
        r103.f464218d = r101.getStringExtra(an.A);
        r103.f1053a = this.f1003a;
        r103.a((Messenger) r101.getParcelableExtra(an.N));
        r103.f1046a = getApplicationContext();
        am.a().a(r103);
        return r103;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private boolean m9319a(String r100, Intent r101) {
        am.b r102 = am.a().a(r100, r101.getStringExtra(an.f464254s));
        boolean r103 = false;
        if (r102 == null) goto L14;
        if (r100 == null) goto L15;
        String r104 = r101.getStringExtra(an.f464235J);
        String r105 = r101.getStringExtra(an.B);
        if (TextUtils.isEmpty(r102.f464223i) == true) goto L11;
        if (TextUtils.equals(r104, r102.f464223i) == true) goto L11;
        com.xiaomi.channel.commonutils.logger.b.m8718a("session changed. old session=" + r102.f464223i + ", new session=" + r104 + " chid = " + r100);
        r103 = true;
    L11:
        if (r105.equals(r102.f464222h) == true) goto L16;
        com.xiaomi.channel.commonutils.logger.b.m8718a("security changed. chid = " + r100 + " sechash = " + com.xiaomi.push.az.a(r105));
        return true;
    L16:
        return r103;
    L15:
        return false;
    L14:
        return false;
    }

    public void a(int r100, Exception r101) {
        StringBuilder r102 = new StringBuilder("disconnect ");
        r102.append(hashCode());
        r102.append(", ");
        ez r103 = this.f993a;
        if (r103 != null) goto L5;
        Integer r104 = null;
    L6:
        r102.append(r104);
        com.xiaomi.channel.commonutils.logger.b.m8718a(r102.toString());
        ez r105 = this.f993a;
        if (r105 == null) goto L9;
        r105.b(r100, r101);
        this.f993a = null;
    L9:
        a(7);
        a(4);
        am.a().a(this, r100);
        return;
    L5:
        r104 = Integer.valueOf(r103.hashCode());
        goto L6
    }

    private void a(String r100, int r110) {
        Collection<am.b> r101 = am.a().m9361a(r100);
        if (r101 == null) goto L10;
        Iterator<am.b> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        am.b r103 = r102.next();
        if (r103 == null) goto L6;
        a(new s(this, r103, r110, null, null));
    L10:
        am.a().m9364a(r100);
    }

    public void a(j r100, long r101) {
        this.f1004a.a(r100, r101);     // Catch: IllegalStateException -> L4
        return;
    L4:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.m8718a("can't execute job err = " + e.getMessage());
    }

    @Override // com.xiaomi.push.fc
    public void a(ez r100, Exception r101) {
        en.a().a(r100, r101);
        c(false);
        if (m9326i() == true) goto L6;
        a(false);
        return;
    }

    public static /* synthetic */ boolean a(XMPushService r100, Context r101) {
        return r100.a(r101);
    }

    public static /* synthetic */ void a(XMPushService r100, Intent r101) {
        r100.d(r101);
    }

    public static /* synthetic */ ez a(XMPushService r100, ez r101) {
        r100.f993a = r101;
        return r101;
    }

    public static /* synthetic */ boolean a(XMPushService r100, boolean r101) {
        r100.f1009a = r101;
        return r101;
    }

    private fn a(fn r100, String r101, String r102) {
        am r103 = am.a();
        List<String> r104 = r103.m9362a(r101);
        if (r104.isEmpty() == false) goto L5;
        com.xiaomi.channel.commonutils.logger.b.m8718a("open channel should be called first before sending a packet, pkg=" + r101);
        return null;
    L5:
        r100.o(r101);
        String r105 = r100.k();
        if (TextUtils.isEmpty(r105) == false) goto L8;
        r105 = (String) ListProtector.get(r104, 0);
        r100.l(r105);
    L8:
        am.b r106 = r103.a(r105, r100.m());
        if (m9336c() == true) goto L11;
        com.xiaomi.channel.commonutils.logger.b.m8718a("drop a packet as the channel is not connected, chid=" + r105);
        return null;
    L11:
        if (r106 != null) goto L13;
    L19:
        com.xiaomi.channel.commonutils.logger.b.m8718a("drop a packet as the channel is not opened, chid=" + r105);
        return null;
    L13:
        if (r106.f1052a != am.c.f464234c) goto L19;
        if (TextUtils.equals(r102, r106.f464223i) == true) goto L18;
        com.xiaomi.channel.commonutils.logger.b.m8718a("invalid session. " + r102);
        return null;
    L18:
        return r100;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r100, int r101, int r102) {
        onStart(r100, r102);
        if (com.xiaomi.push.j.m9295a(this) == false) goto L5;
        return 1;
    L5:
        return 2;
    }

    public void a(final String r100, final byte[] r101, boolean r102) {
        Collection<am.b> r103 = am.a().m9361a("5");
        if (r103.isEmpty() == false) goto L7;
        if (r102 == false) goto L12;
        com.xiaomi.push.service.t.b(r100, r101);
        return;
    L12:
        return;
    L7:
        if (r103.iterator().next().f1052a == am.c.f464234c) goto L10;
        if (r102 == false) goto L14;
        com.xiaomi.push.service.t.b(r100, r101);
        return;
    L14:
        return;
    L10:
        final int r104 = 4;
        a(new AnonymousClass3(this, r104, r100, r101));
    }

    @Override // com.xiaomi.push.fc
    public void a(ez r100, int r101, Exception r102) {
        en.a().a(r100, r101, r102);
        if (m9326i() == true) goto L6;
        a(false);
        return;
    }

    public void a(String r100, String r101, int r110, String r111, String r112) {
        am.b r102 = am.a().a(r100, r101);
        if (r102 == null) goto L5;
        a(new s(this, r102, r110, r112, r111));
    L5:
        am.a().m9365a(r100, r101);
    }
}
