package com.bytedance.ee.bear.slide;

import android.R;
import android.app.Activity;
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

/* JADX INFO: loaded from: classes18.dex */
public class OldSlideRouteActivity extends BaseActivity {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f238562h = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LoadingLayout f238563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinearLayout f238564d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f238565e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f238566f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CompositeDisposable f238567g;

    public static class QueryResult extends Result {
        private String pptxToken;

        private QueryResult() {
        }

        public String getPptxToken() {
            return this.pptxToken;
        }

        public /* synthetic */ QueryResult(c r100) {
            this();
        }

        public void setPptxToken(String r100) {
            this.pptxToken = r100;
        }
    }

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<OldSlideRouteActivity> f238568a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f238569b;

        public final void a() {
            tt5.a.h("OldSlideRouteActivity", "DelayLoadingRunnable()...");
            if (this.f238569b == false) goto L7;
            tt5.a.h("OldSlideRouteActivity", "DelayLoadingRunnable()...cancelled");
            return;
        L7:
            if (this.f238568a.get() == null) goto L15;
            OldSlideRouteActivity r100 = this.f238568a.get();
            LinearLayout r101 = r100.f238564d;
            if (r101 == null) goto L11;
            r101.setVisibility(8);
        L11:
            LoadingLayout r102 = r100.f238563c;
            if (r102 == null) goto L16;
            r102.setVisibility(0);
            r100.f238563c.e();
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

        public a(OldSlideRouteActivity r100) {
            this.f238568a = new WeakReference(r100);
        }
    }

    public static class b implements NetService.c<QueryResult> {
        public b() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result parse(String r100) throws NetService.ParseException {
            QueryResult r101 = new QueryResult(null);
            r101.setPptxToken(new JSONObject(r100).optJSONObject("data").optString("pptx_token"));     // Catch: JSONException -> L5
        L7:
            return r101;
        L5:
            e = move-exception;
            tt5.a.d("OldSlideRouteActivity", "parse()...error = " + e);
            goto L7
        }
    }

    public final void C1() {
        tt5.a.h("OldSlideRouteActivity", "fetchPPTXUrl()...");
        LoadingLayout r100 = this.f238563c;
        if (r100 == null) goto L5;
        a r101 = this.f238566f;
        r101.f238569b = false;
        r100.postDelayed(r101, 300);
    L5:
        NetService r102 = (NetService) org.koin.java.a.a(NetService.class);
        NetService.f r103 = new NetService.f("/space/api/slide/query_pptx_token");
        r103.b("slide_token", this.f238565e);
        Disposable r104 = r102.Vc(new b()).a(r103).subscribe(new com.bytedance.ee.bear.slide.a(this), new com.bytedance.ee.bear.slide.b(this));
        this.f238567g.add(r104);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        overridePendingTransition(0, 0);
        if ((this instanceof ChatWindowActivity) == true) goto L56;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(getClass().getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L45
        if (r103 != null) goto L10;
    L13:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L45
        monitor-exit(r102);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L53:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
    L48:
        goto L53
    L19:
        if (isFinishing() == true) goto L22;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r104 == null) goto L48;
        r104.addFlags(268435456);     // Catch: Throwable -> L42
        r104.addFlags(2097152);     // Catch: Throwable -> L42
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r104);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        LoadingLayout r100 = this.f238563c;
        if (r100 == null) goto L8;
        r100.removeCallbacks(this.f238566f);
    L8:
        this.f238567g.clear();
        tt5.a.h("OldSlideRouteActivity", "onDestroy()...");
        super.onDestroy();
    }

    public OldSlideRouteActivity() {
        this.f238566f = new a(this);
        this.f238567g = new CompositeDisposable();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
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

    @Override // com.bytedance.ee.bear.facade.common.BaseActivity
    public final void B1(Bundle r100) {
        setContentView(com.larus.nova.R.layout.doc_slide_route_activity);
        if (r100 == null) goto L6;
        tt5.a.h("OldSlideRouteActivity", "onDoCreate: restore so finish");
        finish();
        return;
    L6:
        Intent r101 = getIntent();
        if (r101 != null) goto L9;
        tt5.a.h("OldSlideRouteActivity", "intent is null");
        finish();
    L12:
        this.f238563c = (LoadingLayout) findViewById(com.larus.nova.R.id.common_loading);
        LinearLayout r102 = (LinearLayout) findViewById(com.larus.nova.R.id.common_error_tip);
        this.f238564d = r102;
        r102.setOnClickListener(new c(this));
        C1();
        return;
    L9:
        String r103 = r101.getStringExtra("type");
        r101.getStringExtra("url");
        this.f238565e = r101.getStringExtra("obj_token");
        tt5.a.h("OldSlideRouteActivity", "type = " + r103);
        if (TextUtils.isEmpty(this.f238565e) == false) goto L12;
        tt5.a.h("OldSlideRouteActivity", "mObjToken is null");
        finish();
        goto L12
    }
}
