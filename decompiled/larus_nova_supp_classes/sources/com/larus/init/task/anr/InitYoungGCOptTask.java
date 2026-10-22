package com.larus.init.task.anr;

import android.app.Application;
import android.os.Build;
import android.os.Process;
import android.util.EventsUtils;
import bf6.d;
import bg9.i;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common.apphost.AppHost;
import com.larus.init.task.firstframe.jato.a;
import com.larus.jato.api.IJato;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import qt9.c5;
import qt9.e0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/larus/init/task/anr/InitYoungGCOptTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "TAG", XmlPullParser.NO_NAMESPACE, "scene", "getScene", "()Ljava/lang/String;", "runInternal", XmlPullParser.NO_NAMESPACE, "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class InitYoungGCOptTask extends d implements i {
    public final String a;
    public final String b;

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        FLogger r0 = FLogger.a;
        r0.i(this.a, "InitYoungGCOptTask start --->");
        a.e.a();
        if (Build.VERSION.SDK_INT < 29) goto L15;
        ht9.a r1 = ht9.a.a;
        Application r5 = AppHost.a.getApplication();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "context");
        ht9.a.a(r5);
        c5 r2 = new c5(ht9.a.h);
        r0.i("JatoOptHelper", "youngGCOptConfig: " + r2);
        if (r2.a() != 0.0f) goto L8;
        boolean r6 = true;
    L9:
        if (r6 == false) goto L48;
        r0.e("JatoOptHelper", "youngGCOpt DISABLED!");
        goto L15
    L48:
        r0.i("JatoOptHelper", "youngGCOpt start");     // Catch: Throwable -> L13
        IJato.a.e(r2.a());     // Catch: Throwable -> L13
        r0.i("JatoOptHelper", "youngGCOpt finish");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        a.g("youngGCOpt");
        FLogger.a.e("JatoOptHelper", "youngGCOpt had an error !!! ", th);
        goto L15
    L8:
        r6 = false;
    L15:
        FLogger r3 = FLogger.a;
        r3.i(this.a, "InitYoungGCOptTask finish <---");
        r3.i(this.a, "InitClassVisibleInitTask start --->");
        a.e.a();
        int r4 = Build.VERSION.SDK_INT;
        if (r4 >= 30) goto L18;
    L30:
        FLogger r7 = FLogger.a;
        r7.i(this.a, "InitClassVisibleInitTask finish <---");
        r7.i(this.a, "InitRemoveGCWaitingTask start --->");
        a.e.a();
        int r8 = Build.VERSION.SDK_INT;
        if (r8 >= 29) goto L33;
    L42:
        FLogger.a.i(this.a, "InitRemoveGCWaitingTask finish <---");
        return;
    L33:
        if (r8 > 34) goto L42;
        ht9.a r9 = ht9.a.a;
        Application r10 = AppHost.a.getApplication();
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "context");
        ht9.a.a(r10);
        boolean r11 = ht9.a.d;
        r7.i("JatoOptHelper", "enableRemoveGCWaitingBlockOpt: " + r11);
        if (r11 == true) goto L46;
        r7.e("JatoOptHelper", "removeGCWaitingBlock DISABLED!");
        goto L42
    L46:
        r7.i("JatoOptHelper", "removeGCWaitingBlock start");     // Catch: Throwable -> L40
        IJato.a.i();     // Catch: Throwable -> L40
        r7.i("JatoOptHelper", "removeGCWaitingBlock finish");     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        a.g("removeGCWaitingBlock");
        FLogger.a.e("JatoOptHelper", "removeGCWaitingBlock had an error !!! ", th);
        goto L42
    L18:
        if (r4 > 33) goto L30;
        if (Process.is64Bit() == false) goto L30;
        ht9.a r12 = ht9.a.a;
        Application r13 = AppHost.a.getApplication();
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "context");
        ht9.a.a(r13);
        e0 r14 = new e0(ht9.a.e, ht9.a.f, ht9.a.g);
        r3.i("JatoOptHelper", "classVisiblyInitializedOptConfig: " + r14);
        if (r14.a() == true) goto L44;
        r3.e("JatoOptHelper", "classVisibleInitializedOpt DISABLED!");
        goto L30
    L44:
        r3.i("JatoOptHelper", "classVisibleInitializedOpt start");     // Catch: Throwable -> L28
        IJato.a.a(r14.b(), r14.c());     // Catch: Throwable -> L28
        r3.i("JatoOptHelper", "classVisibleInitializedOpt finish");     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        a.g("classVisibleInitializedOpt");
        FLogger.a.e("JatoOptHelper", "classVisibleInitializedOpt had an error !!! ", th);
        goto L30
    }

    public InitYoungGCOptTask() {
        this.a = "YoungGCTask";
        this.b = "Infra";
    }

    @Override // java.lang.Runnable, bg9.i
    public final void run() {
        i.a.a(this);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Override // bg9.i
    public final String getScene() {
        return this.b;
    }
}
