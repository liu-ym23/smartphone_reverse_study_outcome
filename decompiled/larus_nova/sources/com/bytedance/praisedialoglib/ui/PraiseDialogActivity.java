package com.bytedance.praisedialoglib.ui;

import a67.b;
import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import b67.a;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import v19.f;

/* JADX INFO: loaded from: classes21.dex */
public class PraiseDialogActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f266671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f266672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f266673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f266674d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f266675e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f266676f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RelativeLayout f266677g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f266678h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f266679i;

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context r100) {
        super.attachBaseContext(r100);
        NewMiraResourcesManager.getInstance().installActivity(this);
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        if (this.f266679i == false) goto L5;
        a.a("evaluate_pop_force_close", this.f266678h);
    L6:
        super.onDestroy();
        return;
    L5:
        a.a("evaluate_pop_close", this.f266678h);
        goto L6
    }

    public PraiseDialogActivity() {
        this.f266678h = "";
        this.f266679i = false;
    }

    /* JADX INFO: Removed unreachable split cross block B:54:0x0114 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof FragmentActivity) == true) goto L6;
        return;
    L6:
        if ((this instanceof ChatWindowActivity) == true) goto L59;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(getClass().getName()));
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
    public final void onResume() {
        super.onResume();
        a.a("evaluate_pop_show", this.f266678h);
    }

    @Override // android.app.Activity
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

    @Override // android.app.Activity
    public final void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    public final void onStart() {
        super.onStart();
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r100);
        setContentView(com.larus.nova.R.layout.praise_dialog);
        this.f266677g = (RelativeLayout) findViewById(com.larus.nova.R.id.dialog_container);
        this.f266674d = (TextView) findViewById(com.larus.nova.R.id.market_feedback_dialog_title);
        this.f266675e = (TextView) findViewById(com.larus.nova.R.id.market_feedback_dialog_tips);
        this.f266672b = (TextView) findViewById(com.larus.nova.R.id.tv_market_feedback_dialog_complaint);
        this.f266673c = (TextView) findViewById(com.larus.nova.R.id.tv_market_feedback_dialog_praise);
        this.f266671a = (ImageView) findViewById(com.larus.nova.R.id.market_feedback_dialog_close);
        this.f266676f = (ImageView) findViewById(com.larus.nova.R.id.market_feedback_dialog_center);
        this.f266671a.setOnClickListener(new a67.a(this));
        this.f266673c.setOnClickListener(new b(this));
        this.f266672b.setOnClickListener(new a67.c(this));
        Intent r101 = getIntent();
        this.f266678h = r101.getStringExtra("from");
        if (r101.getIntExtra("back_ground_res", -1) == (-1)) goto L14;
        this.f266677g.setBackgroundResource(r101.getIntExtra("back_ground_res", -1));
    L14:
        if (r101.getIntExtra("middle_image_res", -1) == (-1)) goto L17;
        this.f266676f.setBackgroundResource(r101.getIntExtra("middle_image_res", -1));
    L17:
        if (TextUtils.isEmpty(r101.getStringExtra("main_title_text")) == true) goto L20;
        this.f266674d.setText(r101.getStringExtra("main_title_text"));
    L20:
        if (TextUtils.isEmpty(r101.getStringExtra("main_title_text_color")) == true) goto L23;
        this.f266674d.setTextColor(ColorProtector.parseColor(r101.getStringExtra("main_title_text_color")));
    L23:
        if (r101.getIntExtra("main_title_text_size", -1) == (-1)) goto L26;
        this.f266674d.setTextSize(r101.getIntExtra("main_title_text_size", -1));
    L26:
        if (TextUtils.isEmpty(r101.getStringExtra("second_title_text")) == true) goto L29;
        this.f266675e.setText(r101.getStringExtra("second_title_text"));
    L29:
        if (TextUtils.isEmpty(r101.getStringExtra("second_title_text_color")) == true) goto L32;
        this.f266675e.setTextColor(ColorProtector.parseColor(r101.getStringExtra("second_title_text_color")));
    L32:
        if (r101.getIntExtra("second_tile_text_size", -1) == (-1)) goto L35;
        this.f266675e.setTextSize(r101.getIntExtra("second_tile_text_size", -1));
    L35:
        if (TextUtils.isEmpty(r101.getStringExtra("negative_btn_text")) == true) goto L38;
        this.f266672b.setText(r101.getStringExtra("negative_btn_text"));
    L38:
        if (r101.getIntExtra("negative_btn_text_size", -1) == (-1)) goto L41;
        this.f266672b.setTextSize(r101.getIntExtra("negative_btn_text_size", -1));
    L41:
        if (TextUtils.isEmpty(r101.getStringExtra("negative_btn_text_color")) == true) goto L44;
        this.f266672b.setTextColor(ColorProtector.parseColor(r101.getStringExtra("negative_btn_text_color")));
    L44:
        if (r101.getIntExtra("negative_btn_text_bg", -1) == (-1)) goto L47;
        this.f266672b.setBackgroundResource(r101.getIntExtra("negative_btn_text_bg", -1));
    L47:
        if (TextUtils.isEmpty(r101.getStringExtra("positive_btn_text")) == true) goto L50;
        this.f266673c.setText(r101.getStringExtra("positive_btn_text"));
    L50:
        if (r101.getIntExtra("positive_btn_text_size", -1) == (-1)) goto L53;
        this.f266673c.setTextSize(r101.getIntExtra("positive_btn_text_size", -1));
    L53:
        if (TextUtils.isEmpty(r101.getStringExtra("positive_btn_text_color")) == true) goto L56;
        this.f266673c.setTextColor(ColorProtector.parseColor(r101.getStringExtra("positive_btn_text_color")));
    L56:
        if (r101.getIntExtra("positive_btn_text_bg", -1) == (-1)) goto L61;
        this.f266673c.setBackgroundResource(r101.getIntExtra("positive_btn_text_bg", -1));
        return;
    }
}
