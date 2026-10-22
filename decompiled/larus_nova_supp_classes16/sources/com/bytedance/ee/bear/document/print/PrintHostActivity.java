package com.bytedance.ee.bear.document.print;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.print.PrintManager;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\tH\u0014J\b\u0010\u0011\u001a\u00020\tH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/document/print/PrintHostActivity;", "Landroid/app/Activity;", "<init>", "()V", "activeSession", "Lcom/bytedance/ee/bear/document/print/SystemPrintService$PrintSession;", "printAdapter", "Lcom/bytedance/ee/bear/document/print/PdfPrintDocumentAdapter;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "presentSystemPrint", "session", "failSession", "onAdapterFinished", "onDestroy", "finishHost", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PrintHostActivity extends Activity {
    public static final /* synthetic */ int c = 0;
    public r.a a;
    public com.bytedance.ee.bear.document.print.a b;

    public static final class a {
    }

    static {
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context r1) {
        super.attachBaseContext(r1);
        NewMiraResourcesManager.getInstance().installActivity(this);
    }

    /* JADX INFO: Removed unreachable split cross block B:54:0x0110 */
    @Override // android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof FragmentActivity) == true) goto L6;
        return;
    L6:
        if ((this instanceof ChatWindowActivity) == true) goto L59;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(PrintHostActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L48
        if (r6 != null) goto L13;
    L16:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L48
        monitor-exit(r5);     // Catch: Throwable -> L48
    L45:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L51:
        return;
    L19:
        if (((FragmentActivity) this).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L22;
        r2.i("ActivityLancet", "quit !resume, current state = " + ((FragmentActivity) this).getLifecycle().getCurrentState());     // Catch: Throwable -> L45
        goto L51
    L22:
        if (isFinishing() == true) goto L25;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L45
        goto L51
    L25:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L45
        goto L51
    L28:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L31;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L45
        goto L51
    L31:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L34;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L45
        goto L51
    L34:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L36;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L45
        goto L51
    L36:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L45
        if (r1 == null) goto L51;
        r1.addFlags(268435456);     // Catch: Throwable -> L45
        r1.addFlags(2097152);     // Catch: Throwable -> L45
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L45
        startActivity(r1);     // Catch: Throwable -> L42
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L45
        goto L51
    L13:
        if ((r3 - r6.longValue()) >= 800) goto L16;
        monitor-exit(r5);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        r.a r0 = this.a;
        this.a = null;
        com.bytedance.ee.bear.document.print.a r2 = this.b;
        this.b = null;
        if (r0 == null) goto L5;
        r0.a(false);
    L5:
        if (r2 == null) goto L7;
        r2.a();
    L11:
        super.onDestroy();
        return;
    L7:
        if (r0 == null) goto L11;
        c r1 = r0.a;
        if (r1 == null) goto L11;
        r1.a();
        goto L11
    }

    public final void b() {
        if (isFinishing() == true) goto L6;
        finish();
        overridePendingTransition(0, 0);
        return;
    }

    @Override // android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r0 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    public PrintHostActivity() {
    }

    public final void a(r.a r3) {
        if (this.a == r3) goto L5;
        return;
    L5:
        this.a = null;
        com.bytedance.ee.bear.document.print.a r1 = this.b;
        this.b = null;
        r3.a(false);
        if (r1 == null) goto L8;
        r1.a();
    L9:
        b();
        return;
    L8:
        r3.a.a();
        goto L9
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle r8) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r8);
        Intent r9 = getIntent();
        if (r9 == null) goto L13;
        String r10 = r9.getStringExtra("print_session_id");
    L15:
        if (r10 != null) goto L17;
    L20:
        boolean r2 = true;
    L22:
        if (r2 == false) goto L24;
        tt5.a.k("PrintHostActivity", "print session id is missing");
        b();
        return;
    L24:
        Handler r3 = r.a;
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        final r.a r11 = r.b.remove(r10);
        if (r11 != null) goto L27;
        r11 = null;
    L31:
        if (r11 != null) goto L33;
        tt5.a.k("PrintHostActivity", "print session is missing or expired");
        b();
        return;
    L33:
        this.a = r11;
        Object r4 = getSystemService("print");
        if ((r4 instanceof PrintManager) == false) goto L36;
        PrintManager r5 = (PrintManager) r4;
    L37:
        if (r5 != null) goto L39;
        tt5.a.k("PrintHostActivity", "system print service is unavailable");
        a(r11);
        return;
    L39:
        com.bytedance.ee.bear.document.print.a r6 = new com.bytedance.ee.bear.document.print.a(r11.a, new PrintHostActivity$presentSystemPrint$adapter$1(this, r11));
        this.b = r6;
    L45:
        th = move-exception;
        tt5.a.d("PrintHostActivity", "present system print failed: ".concat(th.getClass().getSimpleName()));
        a(r11);
        return;
    L41:
        if (r5.print(r11.a.b, r6, null) != null) goto L43;
        tt5.a.k("PrintHostActivity", "present system print failed: print job is null");     // Catch: Throwable -> L45
        a(r11);     // Catch: Throwable -> L45
    L48:
        return;
    L43:
        r11.a(true);     // Catch: Throwable -> L45
        goto L48
    L36:
        r5 = null;
        goto L37
    L27:
        Runnable r7 = r11.d;
        if (r7 == null) goto L30;
        r.a.removeCallbacks(r7);
    L30:
        r11.d = null;
        goto L31
    L17:
        if (StringsKt.isBlank(r10) == true) goto L20;
        r2 = false;
        goto L22
    L13:
        r10 = null;
        goto L15
    }
}
