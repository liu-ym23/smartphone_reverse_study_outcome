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
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\tH\u0014J\b\u0010\u0011\u001a\u00020\tH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/document/print/PrintHostActivity;", "Landroid/app/Activity;", "<init>", "()V", "activeSession", "Lcom/bytedance/ee/bear/document/print/SystemPrintService$PrintSession;", "printAdapter", "Lcom/bytedance/ee/bear/document/print/PdfPrintDocumentAdapter;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "presentSystemPrint", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "failSession", "onAdapterFinished", LiveCommonConstants.REASON_ON_DEDTROY, "finishHost", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PrintHostActivity extends Activity {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f221123c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r.a f221124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.ee.bear.document.print.a f221125b;

    public static final class a {
    }

    static {
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context r100) {
        super.attachBaseContext(r100);
        NewMiraResourcesManager.getInstance().installActivity(this);
    }

    /* JADX INFO: Removed unreachable split cross block B:54:0x0110 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof FragmentActivity) == true) goto L6;
        return;
    L6:
        if ((this instanceof ChatWindowActivity) == true) goto L59;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(PrintHostActivity.class.getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L48
        if (r103 != null) goto L13;
    L16:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L48
        monitor-exit(r102);     // Catch: Throwable -> L48
    L45:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L51:
        return;
    L19:
        if (((FragmentActivity) this).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L22;
        r100.i("ActivityLancet", "quit !resume, current state = " + ((FragmentActivity) this).getLifecycle().getCurrentState());     // Catch: Throwable -> L45
        goto L51
    L22:
        if (isFinishing() == true) goto L25;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L45
        goto L51
    L25:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L45
        goto L51
    L28:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L31;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L45
        goto L51
    L31:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L34;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L45
        goto L51
    L34:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L36;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L45
        goto L51
    L36:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L45
        if (r104 == null) goto L51;
        r104.addFlags(268435456);     // Catch: Throwable -> L45
        r104.addFlags(2097152);     // Catch: Throwable -> L45
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L45
        startActivity(r104);     // Catch: Throwable -> L42
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L45
        goto L51
    L13:
        if ((r101 - r103.longValue()) >= 800) goto L16;
        monitor-exit(r102);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        r.a r100 = this.f221124a;
        this.f221124a = null;
        com.bytedance.ee.bear.document.print.a r101 = this.f221125b;
        this.f221125b = null;
        if (r100 == null) goto L5;
        r100.a(false);
    L5:
        if (r101 == null) goto L7;
        r101.a();
    L11:
        super.onDestroy();
        return;
    L7:
        if (r100 == null) goto L11;
        c r102 = r100.f221216a;
        if (r102 == null) goto L11;
        r102.a();
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
        View r100 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r101 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r101 == com.larus.home.impl.utils.c.f346341a) goto L9;
        com.larus.home.impl.utils.c.a(r101, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r100.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    public PrintHostActivity() {
    }

    public final void a(r.a r100) {
        if (this.f221124a == r100) goto L5;
        return;
    L5:
        this.f221124a = null;
        com.bytedance.ee.bear.document.print.a r101 = this.f221125b;
        this.f221125b = null;
        r100.a(false);
        if (r101 == null) goto L8;
        r101.a();
    L9:
        b();
        return;
    L8:
        r100.f221216a.a();
        goto L9
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r100);
        Intent r101 = getIntent();
        if (r101 == null) goto L13;
        String r102 = r101.getStringExtra("print_session_id");
    L15:
        if (r102 != null) goto L17;
    L20:
        boolean r103 = true;
    L22:
        if (r103 == false) goto L24;
        tt5.a.k("PrintHostActivity", "print session id is missing");
        b();
        return;
    L24:
        Handler r104 = r.f221214a;
        Intrinsics.checkNotNullParameter(r102, "sessionId");
        final r.a r105 = r.f221215b.remove(r102);
        if (r105 != null) goto L27;
        r105 = null;
    L31:
        if (r105 != null) goto L33;
        tt5.a.k("PrintHostActivity", "print session is missing or expired");
        b();
        return;
    L33:
        this.f221124a = r105;
        Object r106 = getSystemService("print");
        if ((r106 instanceof PrintManager) == false) goto L36;
        PrintManager r107 = (PrintManager) r106;
    L37:
        if (r107 != null) goto L39;
        tt5.a.k("PrintHostActivity", "system print service is unavailable");
        a(r105);
        return;
    L39:
        com.bytedance.ee.bear.document.print.a r108 = new com.bytedance.ee.bear.document.print.a(r105.f221216a, new PrintHostActivity$presentSystemPrint$adapter$1(this, r105));
        this.f221125b = r108;
    L45:
        th = move-exception;
        tt5.a.d("PrintHostActivity", "present system print failed: ".concat(th.getClass().getSimpleName()));
        a(r105);
        return;
    L41:
        if (r107.print(r105.f221216a.f221155b, r108, null) != null) goto L43;
        tt5.a.k("PrintHostActivity", "present system print failed: print job is null");     // Catch: Throwable -> L45
        a(r105);     // Catch: Throwable -> L45
    L48:
        return;
    L43:
        r105.a(true);     // Catch: Throwable -> L45
        goto L48
    L36:
        r107 = null;
        goto L37
    L27:
        Runnable r109 = r105.f221219d;
        if (r109 == null) goto L30;
        r.f221214a.removeCallbacks(r109);
    L30:
        r105.f221219d = null;
        goto L31
    L17:
        if (StringsKt.isBlank(r102) == true) goto L20;
        r103 = false;
        goto L22
    L13:
        r102 = null;
        goto L15
    }
}
