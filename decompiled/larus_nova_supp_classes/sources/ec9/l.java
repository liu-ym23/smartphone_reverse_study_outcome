package ec9;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.bytedance.lego.init.InitScheduler;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mga.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class l {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new a());
        if (b.a().isEnabled() == false) goto L6;
        b.a().doAfterExecuteSucceed(new c());
        return;
    }

    public static List d() {
        return (List) a.getValue();
    }

    public static void a(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        ISecPrivacyService.a.getClass();
        ISecPrivacyService r0 = ISecPrivacyService.a.a();
        if (r0 == null) goto L5;
        boolean r2 = r0.j();
    L6:
        if (r2 == false) goto L8;
        return;
    L8:
        f(new d(r1));
        return;
    L5:
        r2 = false;
        goto L6
    }

    public static void b(Application r1) {
        Intrinsics.checkNotNullParameter(r1, "application");
        ISecPrivacyService.a.getClass();
        ISecPrivacyService r0 = ISecPrivacyService.a.a();
        if (r0 == null) goto L5;
        boolean r2 = r0.j();
    L6:
        if (r2 == false) goto L8;
        return;
    L8:
        f(new g(r1));
        return;
    L5:
        r2 = false;
        goto L6
    }

    public static void c(Activity r1) {
        Intrinsics.checkNotNullParameter(r1, "activity");
        InitScheduler.registerMainActivity(r1);
        ISecPrivacyService.a.getClass();
        ISecPrivacyService r2 = ISecPrivacyService.a.a();
        if (r2 == null) goto L5;
        boolean r3 = r2.j();
    L6:
        if (r3 == false) goto L8;
        return;
    L8:
        f(new e());
        return;
    L5:
        r3 = false;
        goto L6
    }

    public static void e(Activity r4) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        FLogger.a.d("InitPeriodWrapper", "InitPeriodWrapper - notifyAllPeriod = " + System.currentTimeMillis());
        a(r4.getApplication().getBaseContext());
        ISecPrivacyService.a r0 = ISecPrivacyService.a;
        r0.getClass();
        ISecPrivacyService r1 = ISecPrivacyService.a.a();
        boolean r2 = false;
        if (r1 == null) goto L5;
        boolean r3 = r1.j();
    L6:
        if (r3 == true) goto L9;
        f(new h());
    L9:
        b(r4.getApplication());
        r0.getClass();
        ISecPrivacyService r5 = ISecPrivacyService.a.a();
        if (r5 == null) goto L12;
        boolean r6 = r5.j();
    L13:
        if (r6 == true) goto L16;
        f(new i());
    L16:
        c(r4);
        r0.getClass();
        ISecPrivacyService r7 = ISecPrivacyService.a.a();
        if (r7 == null) goto L19;
        boolean r8 = r7.j();
    L20:
        if (r8 == true) goto L23;
        f(new f());
    L23:
        r0.getClass();
        ISecPrivacyService r9 = ISecPrivacyService.a.a();
        if (r9 == null) goto L26;
        boolean r10 = r9.j();
    L27:
        if (r10 == true) goto L30;
        f(new j());
    L30:
        r0.getClass();
        ISecPrivacyService r11 = ISecPrivacyService.a.a();
        if (r11 == null) goto L33;
        boolean r12 = r11.j();
    L34:
        if (r12 == true) goto L37;
        f(new b());
    L37:
        r0.getClass();
        ISecPrivacyService r13 = ISecPrivacyService.a.a();
        if (r13 == null) goto L40;
        r2 = r13.j();
    L40:
        if (r2 == true) goto L44;
        f(new k());
        return;
    L44:
        return;
    L33:
        r12 = false;
        goto L34
    L26:
        r10 = false;
        goto L27
    L19:
        r8 = false;
        goto L20
    L12:
        r6 = false;
        goto L13
    L5:
        r3 = false;
        goto L6
    }

    public static void f(Runnable r4) {
        if (b.a().isEnabled() == true) goto L5;
        r4.run();
        return;
    L5:
        List r0 = d();
        monitor-enter(r0);
    L20:
        th = move-exception;
        throw th;
    L8:
        if (b.a().isExecuteSucceed() == true) goto L10;
        d().add(r4);     // Catch: Throwable -> L20
    L18:
        monitor-exit(r0);
        return;
    L10:
        if ((!d().isEmpty()) == false) goto L16;
        FLogger.a.i("InitPeriodWrapper", "execute pending tasks");     // Catch: Throwable -> L20
        Iterator r1 = d().iterator();     // Catch: Throwable -> L20
    L13:
        if (r1.hasNext() == false) goto L15;
        ((Runnable) r1.next()).run();     // Catch: Throwable -> L20
        goto L13
    L15:
        d().clear();     // Catch: Throwable -> L20
    L16:
        r4.run();     // Catch: Throwable -> L20
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L20
        goto L18
    }
}
