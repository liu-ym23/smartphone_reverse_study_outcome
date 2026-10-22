package com.obric.assistant.guide.ui;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.impl.databinding.ObricActivityRecordAudioRuleWebviewBinding;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/guide/ui/ObricRecordAudioRuleWebViewActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "binding", "Lcom/obric/assistant/impl/databinding/ObricActivityRecordAudioRuleWebviewBinding;", "webView", "Landroid/webkit/WebView;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "setupWebView", "currentBinding", RuleConditionBean.OPEN_URL_KEY, "", "onBackPressed", LiveCommonConstants.REASON_ON_DEDTROY, "needAdaptStatusBarPadding", "", "needAdaptNavigationBarPadding", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricRecordAudioRuleWebViewActivity extends FlowCommonAppCompatActivity {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f389334h = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WebView f389335g;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity
    public final boolean H1() {
        return false;
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity
    public final boolean K1() {
        return false;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        WebView r100 = this.f389335g;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == false) goto L11;
        WebView r102 = this.f389335g;
        if (r102 == null) goto L13;
        r102.goBack();
        return;
    L13:
        return;
    L11:
        finish();
        return;
    L5:
        if (r100.canGoBack() != true) goto L7;
        r101 = true;
        goto L7
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ObricRecordAudioRuleWebViewActivity.class.getName()));
    L5:
        WebView r100 = this.f389335g;
        if (r100 == null) goto L8;
        r100.destroy();
    L8:
        this.f389335g = null;
        super.onDestroy();
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(ObricRecordAudioRuleWebViewActivity.class.getName()));
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

    public ObricRecordAudioRuleWebViewActivity() {
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r110) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        com.obric.assistant.settings.c0.a(this);
        super.onCreate(r110);
        boolean r111 = true;
        com.larus.utils.u.e(this, true, false);
        com.larus.utils.u.d(this);
        Window r100 = getWindow();
        if (r100 == null) goto L13;
        r100.setBackgroundDrawableResource(com.larus.nova.R.color.oui_bg_base_1);
    L13:
        String r101 = null;
        View r102 = getLayoutInflater().inflate(com.larus.nova.R.layout.obric_activity_record_audio_rule_webview, null, false);
        int r103 = com.larus.nova.R.id.btn_close;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(r102, com.larus.nova.R.id.btn_close);
        if (r104 == null) goto L51;
        r103 = com.larus.nova.R.id.divider;
        View r105 = ViewBindings.findChildViewById(r102, com.larus.nova.R.id.divider);
        if (r105 == null) goto L51;
        r103 = com.larus.nova.R.id.progress_bar;
        ProgressBar r106 = (ProgressBar) ViewBindings.findChildViewById(r102, com.larus.nova.R.id.progress_bar);
        if (r106 == null) goto L51;
        r103 = com.larus.nova.R.id.title_bar;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r102, com.larus.nova.R.id.title_bar)) == null) goto L51;
        r103 = com.larus.nova.R.id.tv_title;
        TextView r112 = (TextView) ViewBindings.findChildViewById(r102, com.larus.nova.R.id.tv_title);
        if (r112 == null) goto L51;
        r103 = com.larus.nova.R.id.webview_record_audio_rule;
        WebView r113 = (WebView) ViewBindings.findChildViewById(r102, com.larus.nova.R.id.webview_record_audio_rule);
        if (r113 == null) goto L51;
        LinearLayout r107 = (LinearLayout) r102;
        ObricActivityRecordAudioRuleWebviewBinding r108 = new ObricActivityRecordAudioRuleWebviewBinding(r107, r104, r105, r106, r112, r113);
        setContentView(r107);
        r104.setOnClickListener(new x(this));
        String r109 = getIntent().getStringExtra("open_link");
        if (r109 != null) goto L28;
    L30:
        r109 = null;
    L31:
        if (r109 != null) goto L33;
    L36:
        boolean r114 = true;
    L37:
        if (r114 == false) goto L39;
        FLogger.f375446a.w("ObricRecordAudioRuleWebViewActivity", "finish because open url is invalid");
        finish();
        return;
    L39:
        this.f389335g = r113;
        r113.setWebViewClient(new y(this, r108));
        r113.setWebChromeClient(new z(r108));
        WebSettings r115 = r113.getSettings();
        r115.setMixedContentMode(2);
        r115.setAllowFileAccess(false);
        r115.setAllowContentAccess(false);
        String r116 = UriProtector.parse(r109).getScheme();
        if (r116 == null) goto L43;
        r101 = r116.toLowerCase(Locale.getDefault());
    L43:
        if (Intrinsics.areEqual(r101, "file") == false) goto L45;
    L47:
        r111 = false;
    L48:
        r115.setJavaScriptEnabled(r111);
        r115.setDomStorageEnabled(false);
        r115.setTextZoom(100);
        r113.loadUrl(r109);
        return;
    L45:
        if (Intrinsics.areEqual(r101, "content") == true) goto L47;
    L33:
        if (r109.length() == 0) goto L36;
        r114 = false;
        goto L37
    L28:
        if (Intrinsics.areEqual(r109, "https://os.obriccloud.com/agreement/AudioRecordingUsageRules") == false) goto L30;
    L51:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
