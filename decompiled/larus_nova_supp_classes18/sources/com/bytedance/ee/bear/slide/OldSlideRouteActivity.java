package com.bytedance.ee.bear.slide;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.document.loading.LoadingLayout;
import com.bytedance.ee.bear.facade.common.BaseActivity;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class OldSlideRouteActivity extends BaseActivity {
    public static final /* synthetic */ int h = 0;
    public LoadingLayout c;
    public LinearLayout d;
    public String e;
    public final a f;
    public final CompositeDisposable g;

    public static class QueryResult extends Result {
        private String pptxToken;

        private QueryResult() {
        }

        public String getPptxToken() {
            return this.pptxToken;
        }

        public /* synthetic */ QueryResult(c r1) {
            this();
        }

        public void setPptxToken(String r1) {
            this.pptxToken = r1;
        }
    }

    public static class a implements Runnable {
        public final WeakReference<OldSlideRouteActivity> a;
        public boolean b;

        public final void a() {
            tt5.a.h("OldSlideRouteActivity", "DelayLoadingRunnable()...");
            if (this.b == false) goto L7;
            tt5.a.h("OldSlideRouteActivity", "DelayLoadingRunnable()...cancelled");
            return;
        L7:
            if (this.a.get() == null) goto L15;
            OldSlideRouteActivity r0 = this.a.get();
            LinearLayout r1 = r0.d;
            if (r1 == null) goto L11;
            r1.setVisibility(8);
        L11:
            LoadingLayout r2 = r0.c;
            if (r2 == null) goto L16;
            r2.setVisibility(0);
            r0.c.e();
            return;
        L16:
            return;
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

        public a(OldSlideRouteActivity r2) {
            this.a = new WeakReference(r2);
        }
    }

    public static class b implements NetService.c<QueryResult> {
        public b() {
        }

        public final Result parse(String r4) throws NetService.ParseException {
            QueryResult r0 = new QueryResult(null);
            r0.setPptxToken(new JSONObject(r4).optJSONObject(WikiFolderPushPlugin.DATA).optString("pptx_token"));     // Catch: JSONException -> L5
        L7:
            return r0;
        L5:
            e = move-exception;
            tt5.a.d("OldSlideRouteActivity", "parse()...error = " + e);
            goto L7
        }
    }

    public final void C1() {
        tt5.a.h("OldSlideRouteActivity", "fetchPPTXUrl()...");
        LoadingLayout r0 = this.c;
        if (r0 == null) goto L5;
        a r1 = this.f;
        r1.b = false;
        r0.postDelayed(r1, 300);
    L5:
        NetService r2 = (NetService) org.koin.java.a.a(NetService.class);
        NetService.f r3 = new NetService.f("/space/api/slide/query_pptx_token");
        r3.b("slide_token", this.e);
        Disposable r4 = r2.Vc(new b()).a(r3).subscribe(new com.bytedance.ee.bear.slide.a(this), new com.bytedance.ee.bear.slide.b(this));
        this.g.add(r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        overridePendingTransition(0, 0);
        if ((this instanceof ChatWindowActivity) == true) goto L56;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(getClass().getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L45
        if (r6 != null) goto L10;
    L13:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L45
        monitor-exit(r5);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L53:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
    L48:
        goto L53
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L48;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        LoadingLayout r0 = this.c;
        if (r0 == null) goto L8;
        r0.removeCallbacks(this.f);
    L8:
        this.g.clear();
        tt5.a.h("OldSlideRouteActivity", "onDestroy()...");
        super.onDestroy();
    }

    public OldSlideRouteActivity() {
        this.f = new a(this);
        this.g = new CompositeDisposable();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void B1(Bundle r4) {
        setContentView(2131560098);
        if (r4 == null) goto L6;
        tt5.a.h("OldSlideRouteActivity", "onDoCreate: restore so finish");
        finish();
        return;
    L6:
        Intent r5 = getIntent();
        if (r5 != null) goto L9;
        tt5.a.h("OldSlideRouteActivity", "intent is null");
        finish();
    L12:
        this.c = findViewById(2131367564);
        LinearLayout r6 = (LinearLayout) findViewById(2131367556);
        this.d = r6;
        r6.setOnClickListener(new c(this));
        C1();
        return;
    L9:
        String r1 = r5.getStringExtra(ResourceData.KEY_TYPE);
        r5.getStringExtra(ResourceData.KEY_URL);
        this.e = r5.getStringExtra(ResourceData.KEY_OBJ_TOKEN);
        tt5.a.h("OldSlideRouteActivity", "type = " + r1);
        if (TextUtils.isEmpty(this.e) == false) goto L12;
        tt5.a.h("OldSlideRouteActivity", "mObjToken is null");
        finish();
        goto L12
    }
}
