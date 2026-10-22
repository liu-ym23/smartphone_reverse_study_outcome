package com.bytedance.ee.bear.bitable.homepage.chart.playground;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.bear.bitable.core.usercomponent.compat.BitableSdkSenderCompat;
import com.bytedance.ee.bear.bitable.homepage.BitableHomepageBaseActivity;
import com.bytedance.ee.bear.bitable.homepage.chart.container.JSContextTag;
import com.bytedance.ee.bear.bitable.homepage.chart.widget.chart.ChartItemView;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SendHttpRequest;
import com.bytedance.lark.pb.basic.v1.SendHttpResponse;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\u0018\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/chart/playground/BitableChartPlaygroundActivity;", "Lcom/bytedance/ee/bear/bitable/homepage/BitableHomepageBaseActivity;", "<init>", "()V", "chartDataFetcher", "Lcom/bytedance/ee/bear/bitable/homepage/chart/datasource/IChartDataFetcher;", "getChartDataFetcher", "()Lcom/bytedance/ee/bear/bitable/homepage/chart/datasource/IChartDataFetcher;", "chartDataFetcher$delegate", "Lkotlin/Lazy;", "chartItemView", "Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/chart/ChartItemView;", "getChartItemView", "()Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/chart/ChartItemView;", "chartItemView$delegate", "chartToken", "", "onDoCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "observe", "fetchTemplate", "url", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableChartPlaygroundActivity extends BitableHomepageBaseActivity {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f212609k = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f212610h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f212611i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f212612j;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatEditText f212613a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BitableChartPlaygroundActivity f212614b;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f212615a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ BitableChartPlaygroundActivity f212616b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f212617c;

            public a(String r100, BitableChartPlaygroundActivity r101, String r102) {
                this.f212615a = r100;
                this.f212616b = r101;
                this.f212617c = r102;
            }

            public final void a() {
                ay4.b.d(DocumentType.BITABLE_NAME, 6).putString("bitable_chart_input_url", this.f212615a);
                final BitableChartPlaygroundActivity r100 = this.f212616b;
                String r101 = this.f212615a;
                final String r102 = this.f212617c;
                int r103 = BitableChartPlaygroundActivity.f212609k;
                r100.getClass();
                BitableSdkSenderCompat.a(Command.SEND_HTTP, new SendHttpRequest.Builder().url(r101).method(SendHttpRequest.Method.GET), new BitableChartPlaygroundActivity$fetchTemplate$1(r100, r102), SendHttpResponse.ADAPTER);
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
        }

        public b(AppCompatEditText r100, BitableChartPlaygroundActivity r101) {
            this.f212613a = r100;
            this.f212614b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            String r101 = String.valueOf(this.f212613a.getText());
            String r102 = UriProtector.getQueryParameter(UriProtector.parse(r101), "chartToken");
            if (r102 != null) goto L5;
        L8:
            boolean r103 = true;
        L10:
            if (r103 == false) goto L13;
            UDToast.a r104 = UDToast.build(this.f212614b);
            r104.g("make sure chartToken argument exists in url");
            r104.f285429b.f417630d = 1000;
            r104.a().show();
            return;
        L13:
            BitableChartPlaygroundActivity r105 = this.f212614b;
            r105.f212612j = r102;
            View r106 = r105.getCurrentFocus();
            if (r106 == null) goto L21;
            Object r107 = this.f212614b.getSystemService("input_method");
            if ((r107 instanceof InputMethodManager) == false) goto L18;
            InputMethodManager r108 = (InputMethodManager) r107;
        L19:
            if (r108 == null) goto L21;
            r108.hideSoftInputFromWindow(r106.getWindowToken(), 0);
            goto L21
        L18:
            r108 = null;
        L21:
            UDToast.a r109 = UDToast.build(this.f212614b);
            r109.g("start loading");
            r109.f285429b.f417630d = 1000;
            r109.a().show();
            CoreThreadPool.getDefault().getCachedThreadPool().execute(new a(r101, this.f212614b, r102));
            return;
        L5:
            if (r102.length() == 0) goto L8;
            r103 = false;
            goto L10
        }
    }

    static {
    }

    public final ChartItemView G1() {
        return (ChartItemView) this.f212611i.getValue();
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.BitableHomepageBaseActivity, com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(BitableChartPlaygroundActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    public BitableChartPlaygroundActivity() {
        this.f212610h = LazyKt.lazy(new BitableChartPlaygroundActivity$chartDataFetcher$2(this));
        this.f212611i = LazyKt.lazy(new BitableChartPlaygroundActivity$chartItemView$2(this));
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    @Override // com.bytedance.ee.bear.bitable.homepage.BitableHomepageBaseActivity, com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(BitableChartPlaygroundActivity.class.getName()));
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
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r104 == null) goto L50;
        r104.addFlags(268435456);     // Catch: Throwable -> L42
        r104.addFlags(2097152);     // Catch: Throwable -> L42
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r104);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        F1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static View F1(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseActivity
    public final void B1(Bundle r100) {
        F1(getWindow()).setBackgroundColor(getResources().getColor(com.larus.nova.R.color.bg_body));
        setContentView(com.larus.nova.R.layout.activity_bitable_chart_playground);
        G1().setTagForJsContext(JSContextTag.TAG_FOR_JS_CONTEXT_PLAYGROUND);
        G1().f(this);
        AppCompatEditText r101 = (AppCompatEditText) findViewById(com.larus.nova.R.id.template_url_input);
        r101.setHint("Input template url, click load template");
        String r102 = ay4.b.d(DocumentType.BITABLE_NAME, 6).getString("bitable_chart_input_url", null);
        boolean r103 = false;
        if (r102 != null) goto L5;
    L10:
        if (r103 == false) goto L12;
        r101.setText(r102);
    L12:
        ((FrameLayout) findViewById(com.larus.nova.R.id.container)).addView(G1(), new FrameLayout.LayoutParams(-1, -1));
        ChartItemView r104 = G1();
        ChartItemView.MeasureHeightStrategy r105 = ChartItemView.MeasureHeightStrategy.BY_SYSTEM;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        if (r104.f212659i == r105) goto L16;
        r104.f212659i = r105;
        r104.requestLayout();
    L16:
        Button r106 = (Button) findViewById(com.larus.nova.R.id.load_button);
        r106.setText("Load template");
        r106.setOnClickListener(new b(r101, this));
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new BitableChartPlaygroundActivity$observe$1(this, null));
        return;
    L5:
        if (r102.length() <= 0) goto L7;
        boolean r107 = true;
    L8:
        if (r107 != true) goto L10;
        r103 = true;
        goto L10
    L7:
        r107 = false;
        goto L8
    }
}
