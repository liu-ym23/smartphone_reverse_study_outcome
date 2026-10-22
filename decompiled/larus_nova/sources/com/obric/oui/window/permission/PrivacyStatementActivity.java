package com.obric.oui.window.permission;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.oui.privacy.j;
import com.obric.oui.sheet.v2.OSheet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/window/permission/PrivacyStatementActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class PrivacyStatementActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Map<String, c> f403762i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Map<String, b> f403763j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Map<String, a.AbstractC4683a> f403764k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Map<String, List<String>> f403765l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Map<String, List<j>> f403766m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f403767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f403768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f403769c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f403770d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.obric.oui.privacy.c f403771e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f403772f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f403773g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f403774h;

    public static final class a {

        /* JADX INFO: renamed from: com.obric.oui.window.permission.PrivacyStatementActivity$a$a, reason: collision with other inner class name */
        public static abstract class AbstractC4683a {
            public AbstractC4683a() {
            }
        }
    }

    public interface b {
        void onLinkClick();
    }

    public interface c {
        @Deprecated(message = "use onAgree(activity: Activity) instead")
        void onAgree();

        /* JADX INFO: renamed from: onAgree, reason: collision with other method in class */
        boolean m8595onAgree();

        @Deprecated(message = "use onCancel(activity: Activity) instead")
        void onCancel();

        /* JADX INFO: renamed from: onCancel, reason: collision with other method in class */
        boolean m8596onCancel();
    }

    static {
        f403762i = new LinkedHashMap();
        f403763j = new LinkedHashMap();
        f403764k = new LinkedHashMap();
        f403765l = new LinkedHashMap();
        f403766m = new LinkedHashMap();
    }

    public final void A1() {
        d r100 = this.f403774h;
        if (r100 != null) goto L5;
        return;
    L5:
        View r101 = this.f403773g;
        if (r101 == null) goto L14;
        ViewTreeObserver r102 = r101.getViewTreeObserver();
        if (r102 == null) goto L14;
        if (r102.isAlive() == false) goto L14;
        r102.removeOnPreDrawListener(r100);
    L14:
        this.f403773g = null;
        this.f403774h = null;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        Map<String, c> r100 = f403762i;
        LinkedHashMap r101 = (LinkedHashMap) r100;
        c r102 = (c) r101.get(getIntent().getStringExtra("PrivacyStatementActivityInstanceId"));
        if (r102 == null) goto L8;
        boolean r103 = true;
        if (r102.m8596onCancel() != true) goto L8;
    L9:
        if (r103 == true) goto L14;
        if (r102 == null) goto L15;
        r102.onCancel();
        return;
    L15:
        return;
    L14:
        return;
    L8:
        r103 = false;
        goto L9
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        wma.b.a("PrivacyStatementActivity", LiveCommonConstants.REASON_ON_DEDTROY);
        A1();
        View r100 = this.f403769c;
        if (r100 != null) goto L37;
    L11:
        View r101 = this.f403770d;
        if (r101 != null) goto L39;
    L17:
        com.obric.oui.privacy.c r102 = this.f403771e;
        if (r102 != null) goto L41;
    L28:
        this.f403769c = null;
        this.f403770d = null;
        this.f403771e = null;
        super.onDestroy();
        String r103 = getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r103 == null) goto L43;
        Map<String, a.AbstractC4683a> r104 = f403764k;
        if (((a.AbstractC4683a) ((LinkedHashMap) r104).get(r103)) == null) goto L35;
        Intrinsics.checkNotNullParameter(this, "activity");
    L35:
        a.AbstractC4683a r105 = r104.remove(r103);
        return;
    L43:
        return;
    L41:
        OSheet r106 = r102.f402471c;     // Catch: Exception -> L27
        if (r106 == null) goto L28;
        r106.f402892s = null;     // Catch: Exception -> L27
        r106.setOnDismissListener(null);     // Catch: Exception -> L27
        if (r106.isShowing() == false) goto L28;
        OSheet.t(r106);     // Catch: Exception -> L27
        goto L28
    L39:
        ViewCompat.setOnApplyWindowInsetsListener(r101, null);     // Catch: Exception -> L16
    L16:
        wma.b.b("PrivacyStatementActivity", "removing contentChild WindowInsets listener failed");
        goto L17
    L37:
        r100.setOnApplyWindowInsetsListener(null);     // Catch: Exception -> L10
    L10:
        wma.b.b("PrivacyStatementActivity", "removing root WindowInsets listener failed");
        goto L11
    }

    public PrivacyStatementActivity() {
        this.f403768b = true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
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

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.Window.Callback
    public final void onContentChanged() {
        super.onContentChanged();
        this.f403770d = ((ViewGroup) findViewById(R.id.content)).getChildAt(0);
        if ((!y1(getWindow()).getFitsSystemWindows()) == false) goto L9;
        View r100 = this.f403770d;
        if (r100 == null) goto L10;
        ViewCompat.setOnApplyWindowInsetsListener(r100, new com.obric.oui.window.permission.a());
        return;
    L10:
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        String r100 = getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r100 != null) goto L6;
        return;
    L6:
        if (((a.AbstractC4683a) ((LinkedHashMap) f403764k).get(r100)) == null) goto L11;
        Intrinsics.checkNotNullParameter(this, "activity");
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        String r100 = getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r100 != null) goto L6;
        return;
    L6:
        if (((a.AbstractC4683a) ((LinkedHashMap) f403764k).get(r100)) == null) goto L11;
        Intrinsics.checkNotNullParameter(this, "activity");
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        String r100 = getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r100 != null) goto L6;
        return;
    L6:
        if (((a.AbstractC4683a) ((LinkedHashMap) f403764k).get(r100)) == null) goto L11;
        Intrinsics.checkNotNullParameter(this, "activity");
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        String r100 = getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r100 == null) goto L10;
        if (((a.AbstractC4683a) ((LinkedHashMap) f403764k).get(r100)) == null) goto L10;
        Intrinsics.checkNotNullParameter(this, "activity");
    L10:
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L16;
        y1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L13
        return;
    L17:
        return;
    }

    public static View y1(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r210) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L7;
        v19.f.a(getTheme());     // Catch: Throwable -> L10
    L7:
        if (v19.f.f(this) == false) goto L11;
        v19.f.c(getTheme());     // Catch: Throwable -> L10
    L11:
        SystemClock.elapsedRealtime();
        boolean r100 = false;
        if (getDelegate().getLocalNightMode() != 2) goto L14;
        boolean r101 = true;
    L16:
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L18;
        boolean r102 = true;
    L19:
        wma.b.a("PrivacyStatementActivity", Intrinsics.stringPlus("onCreate savedInstanceState: ", r210));
        wma.b.a("PrivacyStatementActivity", Intrinsics.stringPlus("onCreate delegate.localNightMode: ", Integer.valueOf(getDelegate().getLocalNightMode())));
        wma.b.a("PrivacyStatementActivity", Intrinsics.stringPlus("onCreate isLocalInNightMode: ", Boolean.valueOf(r101)));
        wma.b.a("PrivacyStatementActivity", Intrinsics.stringPlus("onCreate isConfigNightMode: ", Boolean.valueOf(r102)));
        boolean r103 = getIntent().getBooleanExtra("forceNightMode", false);
        wma.b.a("PrivacyStatementActivity", Intrinsics.stringPlus("onCreate forceNightMode: ", Boolean.valueOf(r103)));
        if (r102 == true) goto L23;
        if (r103 == false) goto L23;
        boolean r104 = true;
    L24:
        if (r210 != null) goto L27;
        if (r103 == false) goto L27;
        getIntent().putExtra("forceNightMode", false);
        getDelegate().setLocalNightMode(2);
    L27:
        super.onCreate(r210);
        if (r210 != null) goto L30;
    L32:
        getWindow().setWindowAnimations(0);
        overridePendingTransition(0, 0);
        String r105 = getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r105 != null) goto L36;
    L39:
        if (r210 == null) goto L44;
        wma.b.h("PrivacyStatementActivity", "onCreate, savedInstanceState is not null");
        if (((c) ((LinkedHashMap) f403762i).get(getIntent().getStringExtra("PrivacyStatementActivityInstanceId"))) != null) goto L43;
        wma.b.h("PrivacyStatementActivity", "privacyConsentCallbacks is null, finish");
        finish();
        return;
    L43:
        wma.b.d("PrivacyStatementActivity", "privacyConsentCallbacks is not null");
    L44:
        Window r106 = getWindow();
        r106.clearFlags(1024);
        r106.setBackgroundDrawableResource(R.color.transparent);
        r106.getAttributes().format = -2;
        this.f403768b = getIntent().getBooleanExtra("showNetworkConfirm", true);
        getIntent().getBooleanExtra("useLinkTextAsTitle", false);
        this.f403769c = y1(r106).getRootView();
        if (r104 == true) goto L88;
        Intent r107 = getIntent();
        Intrinsics.checkNotNullParameter(r107, "intent");
        String r108 = r107.getStringExtra("title");
        if (r108 != null) goto L49;
        r108 = getString(com.larus.nova.R.string.default_title);
    L49:
        final String r211 = r108;
        String r110 = r107.getStringExtra("description");
        String r111 = r107.getStringExtra("cancelText");
        String r112 = r107.getStringExtra("agreeText");
        CharSequence r109 = r107.getCharSequenceExtra("privacyText");
        final String[] r113 = r107.getStringArrayExtra("urls");
        if (r113 != null) goto L52;
        r113 = new String[0];
    L52:
        boolean r114 = r107.getBooleanExtra("enableDim", true);
        boolean r212 = r107.getBooleanExtra("cancelable", true);
        boolean r213 = r107.getBooleanExtra("enableEnterAnim", false);
        final c r115 = (c) ((LinkedHashMap) f403762i).get(r107.getStringExtra("PrivacyStatementActivityInstanceId"));
        List r116 = (List) ((LinkedHashMap) f403766m).get(r107.getStringExtra("PrivacyStatementActivityInstanceId"));
        final List r214 = (List) ((LinkedHashMap) f403765l).get(r107.getStringExtra("PrivacyStatementActivityInstanceId"));
        final b r215 = (b) ((LinkedHashMap) f403763j).get(r107.getStringExtra("PrivacyStatementActivityInstanceId"));
        String r117 = getIntent().getStringExtra("customPackageName");
        if (r117 != null) goto L55;
    L56:
        r100 = true;
    L57:
        if (r100 == false) goto L59;
        String r118 = getPackageName();
    L60:
        if (r116 != null) goto L62;
        List r119 = CollectionsKt.emptyList();
    L63:
        View r216 = null;
        if (r109 != null) goto L66;
        String r120 = null;
    L67:
        if (r214 != null) goto L69;
        List r121 = CollectionsKt.emptyList();
    L70:
        com.obric.oui.privacy.c r122 = new com.obric.oui.privacy.c(this, new com.obric.oui.privacy.h(r118, r211, r110, r119, r120, r121, r112, r111, r114, r212, r213));
        com.obric.oui.privacy.i r123 = new PrivacyStatementActivity$showSheetDialog$1(r115, this, r214, r113, r215, r211);
        Intrinsics.checkNotNullParameter(r123, "listener");
        r122.f402473e = r123;
        r122.d();
        this.f403771e = r122;
        OSheet r124 = r122.f402471c;
        if (r124 == null) goto L75;
        Window r125 = r124.getWindow();
        if (r125 == null) goto L75;
        r216 = y1(r125);
    L75:
        View r126 = r216;
        if (r126 != null) goto L79;
    L82:
        getIntent().putExtra("finishShowSheet", true);
        return;
    L79:
        if (this.f403772f == true) goto L82;
        A1();
        this.f403773g = r126;
        d r127 = new d(this, r126);
        this.f403774h = r127;
        r126.getViewTreeObserver().addOnPreDrawListener(r127);
        goto L82
    L69:
        r121 = r214;
        goto L70
    L66:
        r120 = r109.toString();
        goto L67
    L62:
        r119 = r116;
        goto L63
    L59:
        wma.b.h("PrivacyStatementActivity", Intrinsics.stringPlus("using custom packageName: ", r117));
        r118 = r117;
        goto L60
    L55:
        if (r117.length() != 0) goto L57;
    L88:
        return;
    L36:
        if (((a.AbstractC4683a) ((LinkedHashMap) f403764k).get(r105)) == null) goto L39;
        Intrinsics.checkNotNullParameter(this, "activity");
        goto L39
    L30:
        if (getIntent().getBooleanExtra("finishShowSheet", false) == false) goto L32;
        wma.b.a("PrivacyStatementActivity", "onCreate -> finish when savedInstanceState is not null and finishShowSheet is true");
        finish();
        return;
    L23:
        r104 = false;
        goto L24
    L18:
        r102 = false;
        goto L19
    L14:
        r101 = false;
        goto L16
    }

    public static final void z1(PrivacyStatementActivity r100, String r101, String r102) {
        boolean r103 = r100.getIntent().getBooleanExtra("floatingTransitionEnabled", false);
        Intent r104 = new Intent(r100, WebViewActivity.class);
        r104.putExtra("extra_url", r101);
        r104.putExtra("extra_title", r102);
        r104.putExtra("extra_floating_transition_enabled", r103);
        r100.startActivity(r104);
    }
}
