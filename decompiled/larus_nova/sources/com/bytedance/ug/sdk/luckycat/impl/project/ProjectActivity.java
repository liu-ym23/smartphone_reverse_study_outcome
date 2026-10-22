package com.bytedance.ug.sdk.luckycat.impl.project;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.lifecycle.Lifecycle;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.ug.sdk.luckycat.impl.manager.LuckyCatSettingsManger;
import com.bytedance.ug.sdk.luckycat.impl.manager.m;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import uj7.a;
import uj7.b;
import uj7.d;
import uj7.e;
import uj7.g;
import uj7.h;
import uj7.i;
import uj7.j;
import uj7.k;
import uj7.l;
import uj7.n;
import uj7.o;
import uj7.p;
import uj7.q;
import uj7.r;
import uj7.s;
import uj7.t;
import uj7.u;
import uj7.v;
import uj7.w;
import uj7.x;
import v19.f;

/* JADX INFO: loaded from: classes22.dex */
public class ProjectActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f271429b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f271430a;

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0108 */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
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
        if (c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r101 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r101 == c.f346341a) goto L9;
        c.a(r101, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r100.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    public ProjectActivity() {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r100);
        setContentView(com.larus.nova.R.layout.luckycat_activity_project);
        ((Button) findViewById(com.larus.nova.R.id.project_loin_button)).setOnClickListener(new t(this));
        ((Button) findViewById(com.larus.nova.R.id.project_loin_state_button)).setOnClickListener(new u(this));
        ((Button) findViewById(com.larus.nova.R.id.project_exciting_video_ad_button)).setOnClickListener(new v(this));
        ((Button) findViewById(com.larus.nova.R.id.project_show_big_red_packet)).setOnClickListener(new w(this));
        Button r101 = (Button) findViewById(com.larus.nova.R.id.project_get_walk_step);
        r101.setOnClickListener(new x(this, r101));
        ((EditText) findViewById(com.larus.nova.R.id.js_bridge_test_edit)).addTextChangedListener(new a(this));
        ((TextView) findViewById(com.larus.nova.R.id.js_bridge_test_ok)).setOnClickListener(new b(this));
        EditText r102 = (EditText) findViewById(com.larus.nova.R.id.et_ab_key);
        r102.setText(com.bytedance.ug.sdk.luckycat.impl.utils.u.a().c(BaseHttpRequestInfo.KEY_ABTEST, ""));
        findViewById(com.larus.nova.R.id.tv_save_ab_key).setOnClickListener(new uj7.c(this, r102));
        SwitchCompat r103 = (SwitchCompat) findViewById(com.larus.nova.R.id.boe_switch);
        r103.setChecked(m.a.f271349a.f271345m);
        r103.setOnCheckedChangeListener(new s());
        ((Button) findViewById(com.larus.nova.R.id.project_open_invite_friend)).setOnClickListener(new d(this));
        ((Button) findViewById(com.larus.nova.R.id.project_show_profit_dialog)).setOnClickListener(new e());
        ((Button) findViewById(com.larus.nova.R.id.project_show_pop_dialog)).setOnClickListener(new uj7.f());
        ((Button) findViewById(com.larus.nova.R.id.project_check_invite_code)).setOnClickListener(new g());
        ((Button) findViewById(com.larus.nova.R.id.project_test_remote_url_config)).setOnClickListener(new h());
        Button r104 = (Button) findViewById(com.larus.nova.R.id.btn_disaster_test);
        TextView r105 = (TextView) findViewById(com.larus.nova.R.id.tv_origin_url);
        TextView r106 = (TextView) findViewById(com.larus.nova.R.id.tv_target_url);
        String r107 = (String) LuckyCatSettingsManger.b.f271283a.c(new String[]{"disaster_config", "assets_origin_domain"});
        if (bd7.a.a(r107) == false) goto L13;
        String r108 = "https://lf3-sourcecdn-tos.pstatp.com";
    L14:
        r105.setText(r108);
        r104.setOnClickListener(new i(r105, r106));
        Button r109 = (Button) findViewById(com.larus.nova.R.id.btn_proxy_schema_test);
        EditText r110 = (EditText) findViewById(com.larus.nova.R.id.et_proxy_schema);
        TextView r111 = (TextView) findViewById(com.larus.nova.R.id.tv_proxy_schema_result);
        Button r112 = (Button) findViewById(com.larus.nova.R.id.btn_proxy_schema_open);
        r109.setOnClickListener(new j(this, r110, r111));
        r112.setOnClickListener(new l(this, r110));
        ((Button) findViewById(com.larus.nova.R.id.btn_calendar_add)).setOnClickListener(new uj7.m(this));
        ((Button) findViewById(com.larus.nova.R.id.btn_calendar_delete)).setOnClickListener(new n(this));
        ((Button) findViewById(com.larus.nova.R.id.btn_calendar_check)).setOnClickListener(new o(this));
        ((Button) findViewById(com.larus.nova.R.id.tv_lynx_popup_confirm)).setOnClickListener(new p(this, (EditText) findViewById(com.larus.nova.R.id.et_lynx_popup_data)));
        findViewById(com.larus.nova.R.id.btn_open_floating_bar).setOnClickListener(new q(this));
        findViewById(com.larus.nova.R.id.btn_close_floating_bar).setOnClickListener(new r(this));
        EditText r113 = (EditText) findViewById(com.larus.nova.R.id.et_add_params);
        String r114 = com.bytedance.ug.sdk.luckycat.impl.utils.u.a().c("add_schema_params", "");
        if (TextUtils.isEmpty(r114) == true) goto L17;
        r113.setText(r114);
    L17:
        r113.addTextChangedListener(new k());
        return;
    L13:
        r108 = "https://" + r107;
        goto L14
    }
}
