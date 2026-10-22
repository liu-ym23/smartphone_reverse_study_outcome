package com.bytedance.bdturing.livedetect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import com.bytedance.bdturing.EventReport;
import com.bytedance.crash.d;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import sb4.g;
import v19.f;
import vb4.e;
import vb4.x;
import vb4.y;
import vb4.z;

/* JADX INFO: loaded from: classes14.dex */
public class TuringLiveDetectGuideActivity extends TuringBaseLiveDetectActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener, TuringBaseLiveDetectActivity.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CheckBox f201864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f201865e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f201866f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f201867g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f201868h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f201869i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f201870j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f201871k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f201872l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f201873m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public g f201874n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f201875o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public jc4.a f201876p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final a f201877q;

    public class a extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f201878a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TuringLiveDetectGuideActivity f201879b;

        public a(TuringLiveDetectGuideActivity r100) {
            this.f201879b = r100;
            this.f201878a = 0;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            if ((System.currentTimeMillis() - this.f201878a) <= 800) goto L6;
            this.f201878a = System.currentTimeMillis();
            String r101 = this.f201879b.f201869i.replace("《", "").replace("》", "");
            TuringLiveDetectWebActivity.startActivity(this.f201879b, e.a(), r101);
            return;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            super.updateDrawState(r100);
            r100.setUnderlineText(false);
            r100.setColor(ColorProtector.parseColor("#1664FF"));
        }
    }

    @Override // com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity.a
    public final void f1() {
        EventReport.a(4, this.f201876p);
        EventReport.q(false, this.f201876p);
        String r100 = getString(R.string.truing_live_camera_permission_dlg_title);
        String r101 = getString(R.string.truing_live_camera_permission_dlg_content);
        sb4.b r102 = new sb4.b();
        r102.f541211a = r100;
        r102.f541212b = r101;
        r102.f541213c = getString(R.string.truing_live_camera_permission_dlg_left_btn_text);
        r102.f541214d = getString(R.string.truing_live_camera_permission_dlg_right_btn_text);
        g r103 = new g(this, r102, new z(this));
        this.f201874n = r103;
        if (DialogLancet.shouldBlockDialogShow(r103) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r103);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r103);
        r103.show();
        DialogLancet.afterDialogShow(r103);
    }

    /* JADX INFO: Removed unreachable split cross block B:76:0x0149 */
    @Override // com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        g r100 = this.f201874n;
        if (r100 == null) goto L22;
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r100);
    L19:
        this.f201874n = null;
        goto L22
    L14:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r102 == null) goto L18;
        d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L7:
        if (Looper.myLooper() == r101.getLooper()) goto L9;
        r101.post(DialogLancet.createDismissRunnable(r100));
    L22:
        overridePendingTransition(0, 0);
        if ((this instanceof ChatWindowActivity) == true) goto L64;
        FLogger r103 = FLogger.f375446a;
        r103.i("ActivityLancet", "finish ".concat(getClass().getName()));
        long r104 = SystemClock.uptimeMillis();
        Map<Activity, Long> r105 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r105);
        Long r106 = r105.get(this);     // Catch: Throwable -> L65
        if (r106 != null) goto L30;
    L33:
        r105.put(this, Long.valueOf(r104));     // Catch: Throwable -> L65
        monitor-exit(r105);     // Catch: Throwable -> L65
    L62:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L72:
        return;
    L36:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L39;
        r103.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L62
        goto L72
    L39:
        if (isFinishing() == true) goto L42;
        r103.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L62
        goto L72
    L42:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L45;
        r103.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L62
        goto L72
    L45:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L48;
        r103.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L62
        goto L72
    L48:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L51;
        r103.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L62
        goto L72
    L51:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L53;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L62
        goto L72
    L53:
        Intent r107 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L62
        if (r107 == null) goto L72;
        r107.addFlags(268435456);     // Catch: Throwable -> L62
        r107.addFlags(2097152);     // Catch: Throwable -> L62
        r103.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L62
        startActivity(r107);     // Catch: Throwable -> L59
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right);     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L62
        goto L72
    L30:
        if ((r104 - r106.longValue()) >= 800) goto L33;
        monitor-exit(r105);     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
        EventReport.x(getClass().getName(), !this.f201866f ? 1 : 0, this.f201876p);
        this.f201876p = null;
        if (this.f201866f == true) goto L9;
        LiveDetectService.getInstance().onResult(2, null);
        return;
    }

    public TuringLiveDetectGuideActivity() {
        this.f201866f = false;
        this.f201877q = new a(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        if (e.e() == false) goto L6;
        super.onBackPressed();
        return;
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

    @Override // com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity.a
    public final void G(int r100) {
        if (r100 != 2) goto L5;
        int r101 = 1;
    L6:
        EventReport.a(r101, this.f201876p);
        EventReport.q(true, this.f201876p);
        if (this.f201866f == true) goto L11;
        this.f201866f = true;
        LiveDetectService.getInstance().turn2DetectPage(this.f201876p, this, this.f201868h);
        finish();
        return;
    L11:
        return;
    L5:
        r101 = 0;
        goto L6
    }

    @Override // com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity.a
    public final void U0(int r100) {
        if (this.f201875o == false) goto L5;
        return;
    L5:
        int r101 = 2;
        if (r100 != 1) goto L8;
        Toast.makeText(this, getString(R.string.turing_live_camera_permission_tip_1), 0).show();
    L10:
        if (r100 != 2) goto L12;
        r101 = 3;
    L12:
        EventReport.a(r101, this.f201876p);
        finish();
        return;
    L8:
        if (r100 != 2) goto L10;
        Toast.makeText(this, getString(R.string.turing_live_camera_permission_tip_2), 0).show();
        goto L10
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r100) {
        if (r100.getId() != R.id.tv_live_detect_confirm_btn) goto L6;
        z1(this);
        return;
    L6:
        if (r100.getId() != R.id.tv_live_detect_help) goto L8;
        TuringLiveDetectWebActivity.startActivity(this, e.b(), getString(R.string.turing_live_detect_help));
        return;
    L8:
        r100.getId();
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
        setContentView(R.layout.activity_turing_live_detect_guide);
        this.f201872l = findViewById(R.id.rl_root);
        View r101 = findViewById(R.id.rl_agreement_container);
        this.f201873m = r101;
        r101.setOnTouchListener(new x());
        View r102 = findViewById(R.id.fl_agreement_cb_tip);
        this.f201871k = r102;
        r102.postDelayed(new y(this), 1000);
        this.f201824b = (ImageView) findViewById(R.id.loading);
        CheckBox r103 = (CheckBox) findViewById(R.id.cb_live_detect_agreement);
        this.f201864d = r103;
        r103.setOnCheckedChangeListener(this);
        this.f201864d.setOnClickListener(this);
        this.f201865e = (TextView) findViewById(R.id.tv_live_detect_confirm_btn);
        this.f201867g = (TextView) findViewById(R.id.tv_live_detect_agreement);
        this.f201870j = (TextView) findViewById(R.id.tv_live_detect_help);
        com.bytedance.bdturing.setting.e r104 = com.bytedance.bdturing.setting.e.f202077a;
        String r105 = com.bytedance.bdturing.setting.e.f("agreement_title");
        this.f201869i = r105;
        if (TextUtils.isEmpty(r105) == false) goto L13;
        this.f201869i = getString(R.string.turing_live_detect_agreement_title);
    L13:
        StringBuilder r106 = new StringBuilder();
        String r107 = getString(R.string.turing_live_detect_agreement_prefix);
        r106.append(r107);
        r106.append(this.f201869i);
        String r108 = r106.toString();
        SpannableString r109 = new SpannableString(r108);
        int r110 = r107.length();
        int r111 = r108.length();
        r109.setSpan(this.f201877q, r110, r111, 33);
        this.f201867g.setText(r109);
        this.f201867g.setHighlightColor(0);
        this.f201867g.setMovementMethod(LinkMovementMethod.getInstance());
        this.f201865e.setEnabled(this.f201864d.isChecked());
        this.f201865e.setOnClickListener(this);
        this.f201870j.setOnClickListener(this);
        this.f201872l.setOnClickListener(this);
        this.f201868h = getIntent().getStringExtra("detail");
        this.f201876p = LiveDetectService.getInstance().getRequest();
        if (TextUtils.isEmpty(this.f201868h) == false) goto L16;
        finish();
    L16:
        boolean r112 = LiveDetectService.getInstance().preInit(getApplicationContext(), getClass().getName());
        EventReport.y(getClass().getName(), r112, this.f201876p);
        LiveDetectService.getInstance().setOnVerify(true);
    }

    public static void startActivity(Activity r100, String r101) {
        Intent r102 = new Intent(r100, TuringLiveDetectGuideActivity.class);
        r102.putExtra("detail", r101);
        r100.startActivity(r102);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r100, boolean r101) {
        this.f201865e.setEnabled(r101);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        if (1 == r100) goto L5;
        return;
    L5:
        if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0) goto L7;
        this.f201875o = true;
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 1);
        return;
    L7:
        if (this.f201866f == true) goto L14;
        this.f201866f = true;
        LiveDetectService.getInstance().turn2DetectPage(this.f201876p, this, this.f201868h);
        finish();
        return;
    }
}
