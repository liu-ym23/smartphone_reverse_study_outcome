package com.bytedance.ee.bear.basesdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import com.bytedance.crash.Npth;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes15.dex */
public abstract class AbsLocaleServiceImp implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f206458a;

    public static class LocaleDetector extends LiveData<String> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int f206459b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f206460a;

        public class a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ LocaleDetector f206461a;

            public a(LocaleDetector r100) {
                this.f206461a = r100;
            }

            @Override // com.bytedance.ee.bear.basesdk.AbsLocaleServiceImp.b
            public final void a(String r100) {
                LocaleDetector r101 = this.f206461a;
                int r102 = LocaleDetector.f206459b;
                r101.setValue(r100);
            }
        }

        public LocaleDetector() {
            this.f206460a = new a(this);
        }

        @Override // androidx.lifecycle.LiveData
        public final void onActive() {
            super.onActive();
            tt5.a.b("TimeZoneDetector", "register observer for LocaleDetector in active state.");
            a r100 = this.f206460a;
            int r101 = a.f206463b;
            if (r100 != null) goto L5;
            return;
        L5:
            if (((ArrayList) c.a.f206468a.f206467a).contains(r100) == true) goto L9;
            ((ArrayList) a.C2976a.f206465a.f206464a).add(r100);
            return;
        }

        @Override // androidx.lifecycle.LiveData
        public final void onInactive() {
            super.onInactive();
            tt5.a.b("TimeZoneDetector", "unregister observer for LocaleDetector in inactive state.");
            a r100 = this.f206460a;
            int r101 = a.f206463b;
            if (r100 == null) goto L6;
            ((ArrayList) a.C2976a.f206465a.f206464a).remove(r100);
            return;
        }
    }

    public class TimeZoneDetector extends LiveData<TimeZone> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f206462a;

        @Override // androidx.lifecycle.LiveData
        public final void onActive() {
            super.onActive();
            if (TextUtils.equals(this.f206462a, TimeZone.getDefault().getID()) == true) goto L5;
            TimeZone r100 = TimeZone.getDefault();
            super.setValue(r100);
            this.f206462a = r100.getID();
        L5:
            tt5.a.b("TimeZoneDetector", "register observer in active state.");
            int r101 = c.f206466b;
        }

        @Override // androidx.lifecycle.LiveData
        public final void onInactive() {
            super.onInactive();
            tt5.a.b("TimeZoneDetector", "unregister observer in inactive state.");
            int r100 = c.f206466b;
        }

        @Override // androidx.lifecycle.LiveData
        public final void setValue(TimeZone r100) {
            TimeZone r101 = r100;
            super.setValue(r101);
            this.f206462a = r101.getID();
        }
    }

    public static class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int f206463b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<b> f206464a;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.basesdk.AbsLocaleServiceImp$a$a, reason: collision with other inner class name */
        public static class C2976a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f206465a = null;

            static {
                f206465a = new a();
            }
        }

        public a() {
            this.f206464a = new ArrayList();
        }

        public static void registerReceiver(Context r100) {
            IntentFilter r101 = new IntentFilter();
            r101.addAction("android.intent.action.LOCALE_CHANGED");
            a r102 = C2976a.f206465a;
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L34;
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        L34:
        L28:
            e = move-exception;
            e.toString();
            e.printStackTrace();
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L33;
            ReceiverRegisterCrashOptimizer.registerReceiver(r102, r101);
            return;
        L33:
            throw e;
        L6:
            if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L19;
            if (ReceiverRegisterAnrOptimizer.hasScreenActions(r101) == false) goto L19;
            int r103 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r102, r101, 0, null, null, 2, r100).result;     // Catch: Exception -> L28
            if (r103 != 1) goto L12;
            r100.registerReceiver(r102, r101);     // Catch: Exception -> L28
            return;
        L12:
            if (r103 != 2) goto L14;
            new Intent();     // Catch: Exception -> L28
            return;
        L14:
            if (r103 == 3) goto L35;
            r100.registerReceiver(r102, r101);     // Catch: Exception -> L28
            return;
        L35:
            return;
        L19:
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L22;
            ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L28
            r100.registerReceiver(r102, r101, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L28
            return;
        L22:
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L24;
        L26:
            r100.registerReceiver(r102, r101);     // Catch: Exception -> L28
            return;
        L24:
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r101) == false) goto L26;
            ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L28
            ContextCompat.registerReceiver(r100, r102, r101, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L28
        }

        public static void unregisterReceiver(Context r100) {
            tt5.a.b("TimeZoneChangeReceiver", "unregisterReceiver()... context = " + r100);
            a r101 = C2976a.f206465a;
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

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r100, Intent r101) {
            if (TextUtils.equals(r101.getAction(), "android.intent.action.LOCALE_CHANGED") == false) goto L8;
            Iterator r102 = ((ArrayList) this.f206464a).iterator();
        L6:
            if (r102.hasNext() == false) goto L10;
            ((b) r102.next()).a(r100.getResources().getConfiguration().locale.getLanguage());
            goto L6
        L10:
            return;
        }
    }

    public interface b {
        void a(String r100);
    }

    public static class c extends BroadcastReceiver {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int f206466b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<d> f206467a;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f206468a = null;

            static {
                f206468a = new c();
            }
        }

        public c() {
            this.f206467a = new ArrayList();
        }

        public static void registerReceiver(Context r100) {
            IntentFilter r101 = new IntentFilter();
            r101.addAction("android.intent.action.TIMEZONE_CHANGED");
            a(r100, a.f206468a, r101);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            iu5.d.a("AbsLocaleServiceImp", e);
        }

        public static void unregisterReceiver(Context r100) {
            tt5.a.b("TimeZoneChangeReceiver", "unregisterReceiver()... context = " + r100);
            c r101 = a.f206468a;
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

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r100, Intent r101) {
            Iterator r102 = ((ArrayList) this.f206467a).iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            ((d) r102.next()).a();
            goto L4
        }

        @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
        public static void a(Context r100, c r101, IntentFilter r110) {
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        L39:
        L33:
            e = move-exception;
            e.toString();
            e.printStackTrace();
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
            ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
            return;
        L38:
            throw e;
        L6:
            if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
            if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L22;
            int r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100).result;     // Catch: Exception -> L33
            if (r102 != 1) goto L12;
            r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
            return;
        L12:
            if (r102 != 2) goto L14;
            new Intent();     // Catch: Exception -> L33
            return;
        L14:
            if (r102 == 3) goto L40;
            r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
            return;
        L40:
            return;
        L22:
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
            ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
            r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
            return;
        L26:
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
        L31:
            r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
            return;
        L28:
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L31;
            ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
            ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
        }
    }

    public interface d {
        void a();
    }

    public AbsLocaleServiceImp() {
    }
}
