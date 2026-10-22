package com.bytedance.sdk.account.ticketguard;

import android.content.Context;
import android.util.Log;
import com.bytedance.android.sdk.bdticketguard.TicketGuardEventHelper;
import com.bytedance.android.sdk.bdticketguard.a1;
import com.bytedance.android.sdk.bdticketguard.b1;
import com.bytedance.android.sdk.bdticketguard.init.TicketGuardBootFinishManager;
import com.bytedance.android.sdk.bdticketguard.init.TicketGuardExtraConfig;
import com.bytedance.android.sdk.bdticketguard.s;
import com.ss.android.account.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public class AccountTicketGuardHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static TicketGuardInitParamImpl f269425a;

    public static class TicketGuardInitParamImpl implements b1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f269426a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f269427b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final b f269428c;

        public class a {
            public a() {
            }
        }

        public class b implements s {
            public b() {
            }

            @Override // com.bytedance.android.sdk.bdticketguard.s
            public final void log(int r100, String r101, String r102, Throwable r103) {
                String r104 = "";
                if (r100 != 4) goto L5;
                StringBuilder r105 = new StringBuilder();
                r105.append(r102);
                if (r103 == null) goto L19;
                r104 = "\n" + Log.getStackTraceString(r103);
            L19:
                r105.append(r104);
                tb7.a.d(r101, r105.toString());
                return;
            L5:
                if (r100 != 5) goto L7;
                tb7.a.f(r101, r102, r103);
                return;
            L7:
                if (r100 == 6) goto L13;
                StringBuilder r106 = new StringBuilder();
                r106.append(r102);
                if (r103 == null) goto L12;
                r104 = "\n" + Log.getStackTraceString(r103);
            L12:
                r106.append(r104);
                tb7.a.a(r101, r106.toString());
                return;
            L13:
                tb7.a.c(r101, r102, r103);
            }
        }

        public TicketGuardInitParamImpl() {
            this.f269426a = new e();
            this.f269427b = new a();
            this.f269428c = new b();
        }

        @Override // com.bytedance.android.sdk.bdticketguard.b1
        public final Context getApplicationContext() {
            return k.d().getApplicationContext();
        }

        @Override // com.bytedance.android.sdk.bdticketguard.b1
        public final e a() {
            return this.f269426a;
        }

        @Override // com.bytedance.android.sdk.bdticketguard.b1
        public final b getLogger() {
            return this.f269428c;
        }

        @Override // com.bytedance.android.sdk.bdticketguard.b1
        public final a getMonitor() {
            return this.f269427b;
        }
    }

    public static class a implements Function0<Boolean> {
        public a() {
        }

        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.valueOf(com.bytedance.sdk.account.utils.d.d());
        }
    }

    public static class b implements Function0<String> {
        public b() {
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            wqa.f r100 = k.f406318b;
            if (r100 == null) goto L5;
            com.bytedance.sdk.account.utils.g r101 = r100.getMonitor();
        L6:
            if (r101 != null) goto L10;
            return "";
        L10:
            return r101.getDeviceId();
        L5:
            r101 = null;
            goto L6
        }
    }

    public static class c implements com.bytedance.android.sdk.bdticketguard.init.b {
        public c() {
        }
    }

    public AccountTicketGuardHelper() {
    }

    public static void initTicketInstance() {
        TicketGuardSettingsInit r100 = TicketGuardSettingsInit.f269440b;
        if (TicketGuardSettingsInit.f269439a == false) goto L5;
        r100.getClass();
    L12:
        TicketGuardInitParamImpl r101 = f269425a;
        if (r101 != null) goto L16;
        r101 = new TicketGuardInitParamImpl();
        f269425a = r101;
    L16:
        a1.a(r101);
        return;
    L5:
        monitor-enter(r100);
    L18:
        th = move-exception;
        throw th;
    L7:
        if (TicketGuardSettingsInit.f269439a == false) goto L10;
        monitor-exit(r100);
        goto L12
    L10:
        r100.a();     // Catch: Throwable -> L18
        TicketGuardSettingsInit.f269439a = true;     // Catch: Throwable -> L18
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r100);
        goto L12
    }

    public static void initTicketGuard(Context r100, Function1<Boolean, Unit> r101) {
        TicketGuardSettingsInit r102 = TicketGuardSettingsInit.f269440b;
        if (TicketGuardSettingsInit.f269439a == false) goto L5;
        r102.getClass();
    L12:
        Function0<String> r103 = TicketGuardExtraConfig.f163757a;
        TicketGuardExtraConfig.f163757a = new b();
        TicketGuardExtraConfig.f163758b = new c();
        TicketGuardExtraConfig.f163759c = new com.bytedance.sdk.account.ticketguard.a();
        com.bytedance.sdk.account.ticketguard.b r104 = new com.bytedance.sdk.account.ticketguard.b();
        TicketGuardBootFinishManager.f163756e.getClass();
        TicketGuardBootFinishManager.f163753b = r104;
        TicketGuardBootFinishManager.e();
        TicketGuardInitParamImpl r105 = f269425a;
        if (r105 != null) goto L16;
        r105 = new TicketGuardInitParamImpl();
        f269425a = r105;
    L16:
        a1.b(r105, r101);
        TicketGuardEventHelper r106 = TicketGuardEventHelper.f163517g;
        f.a();
        boolean r107 = f.f269463j;
        r106.getClass();
        TicketGuardEventHelper.f163513c = r107;
        TicketGuardEventHelper.f163512b = new a();
        return;
    L5:
        monitor-enter(r102);
    L18:
        th = move-exception;
        throw th;
    L7:
        if (TicketGuardSettingsInit.f269439a == false) goto L10;
        monitor-exit(r102);
        goto L12
    L10:
        r102.a();     // Catch: Throwable -> L18
        TicketGuardSettingsInit.f269439a = true;     // Catch: Throwable -> L18
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r102);
        goto L12
    }
}
