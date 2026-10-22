package com.bytedance.bdturing.livedetect;

import android.R;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class TuringLiveDetectGuideActivity extends TuringBaseLiveDetectActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener, TuringBaseLiveDetectActivity.a {
    public CheckBox d;
    public TextView e;
    public boolean f;
    public TextView g;
    public String h;
    public String i;
    public TextView j;
    public View k;
    public View l;
    public View m;
    public g n;
    public boolean o;
    public jc4.a p;
    public final a q;

    public class a extends ClickableSpan {
        public long a;
        public final /* synthetic */ TuringLiveDetectGuideActivity b;

        public a(TuringLiveDetectGuideActivity r3) {
            this.b = r3;
            this.a = 0;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r5) {
            if ((System.currentTimeMillis() - this.a) <= 800) goto L6;
            this.a = System.currentTimeMillis();
            String r6 = this.b.i.replace("《", "").replace("》", "");
            TuringLiveDetectWebActivity.startActivity(this.b, e.a(), r6);
            return;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r2) {
            super.updateDrawState(r2);
            r2.setUnderlineText(false);
            r2.setColor(ColorProtector.parseColor("#1664FF"));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity.a
    public final void f1() {
        EventReport.a(4, this.p);
        EventReport.q(false, this.p);
        String r0 = getString(2131914361);
        String r1 = getString(2131914358);
        sb4.b r2 = new sb4.b();
        r2.a = r0;
        r2.b = r1;
        r2.c = getString(2131914359);
        r2.d = getString(2131914360);
        g r3 = new g(this, r2, new z(this));
        this.n = r3;
        if (DialogLancet.shouldBlockDialogShow(r3) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r3);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r3);
        r3.show();
        DialogLancet.afterDialogShow(r3);
    }

    /* JADX INFO: Removed unreachable split cross block B:76:0x0149 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity
    public final void finish() {
        super.finish();
        g r2 = this.n;
        if (r2 == null) goto L22;
        Handler r3 = DialogLancet.resolveDialogHandler(r2);
        if (r3 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r2);
        r2.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r2);
    L19:
        this.n = null;
        goto L22
    L14:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r4 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r4 == null) goto L18;
        d.d(r4, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r2);
        throw th;
    L7:
        if (Looper.myLooper() == r3.getLooper()) goto L9;
        r3.post(DialogLancet.createDismissRunnable(r2));
    L22:
        overridePendingTransition(0, 0);
        if ((this instanceof ChatWindowActivity) == true) goto L64;
        FLogger r5 = FLogger.a;
        r5.i("ActivityLancet", "finish ".concat(getClass().getName()));
        long r6 = SystemClock.uptimeMillis();
        Map r7 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r7);
        Long r8 = (Long) r7.get(this);     // Catch: Throwable -> L65
        if (r8 != null) goto L30;
    L33:
        r7.put(this, Long.valueOf(r6));     // Catch: Throwable -> L65
        monitor-exit(r7);     // Catch: Throwable -> L65
    L62:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L72:
        return;
    L36:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L39;
        r5.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L62
        goto L72
    L39:
        if (isFinishing() == true) goto L42;
        r5.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L62
        goto L72
    L42:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L45;
        r5.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L62
        goto L72
    L45:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L48;
        r5.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L62
        goto L72
    L48:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L51;
        r5.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L62
        goto L72
    L51:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L53;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L62
        goto L72
    L53:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L62
        if (r1 == null) goto L72;
        r1.addFlags(268435456);     // Catch: Throwable -> L62
        r1.addFlags(2097152);     // Catch: Throwable -> L62
        r5.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L62
        startActivity(r1);     // Catch: Throwable -> L59
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L62
        goto L72
    L30:
        if ((r6 - r8.longValue()) >= 800) goto L33;
        monitor-exit(r7);     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
        EventReport.x(getClass().getName(), !this.f ? 1 : 0, this.p);
        this.p = null;
        if (this.f == true) goto L9;
        LiveDetectService.getInstance().onResult(2, null);
        return;
    }

    public TuringLiveDetectGuideActivity() {
        this.f = false;
        this.q = new a(this);
    }

    public final void onBackPressed() {
        if (e.e() == false) goto L6;
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity.a
    public final void G(int r3) {
        if (r3 != 2) goto L5;
        int r4 = 1;
    L6:
        EventReport.a(r4, this.p);
        EventReport.q(true, this.p);
        if (this.f == true) goto L11;
        this.f = true;
        LiveDetectService.getInstance().turn2DetectPage(this.p, this, this.h);
        finish();
        return;
    L11:
        return;
    L5:
        r4 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity.a
    public final void U0(int r4) {
        if (this.o == false) goto L5;
        return;
    L5:
        int r2 = 2;
        if (r4 != 1) goto L8;
        Toast.makeText(this, getString(2131923581), 0).show();
    L10:
        if (r4 != 2) goto L12;
        r2 = 3;
    L12:
        EventReport.a(r2, this.p);
        finish();
        return;
    L8:
        if (r4 != 2) goto L10;
        Toast.makeText(this, getString(2131923582), 0).show();
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        if (r3.getId() != 2131390886) goto L6;
        z1(this);
        return;
    L6:
        if (r3.getId() != 2131390887) goto L8;
        TuringLiveDetectWebActivity.startActivity(this, e.b(), getString(2131923600));
        return;
    L8:
        r3.getId();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r5) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r5);
        setContentView(2131558523);
        this.l = findViewById(2131384705);
        View r6 = findViewById(2131384669);
        this.m = r6;
        r6.setOnTouchListener(new x());
        View r7 = findViewById(2131372664);
        this.k = r7;
        r7.postDelayed(new y(this), 1000);
        this.b = (ImageView) findViewById(2131378977);
        CheckBox r8 = (CheckBox) findViewById(2131365300);
        this.d = r8;
        r8.setOnCheckedChangeListener(this);
        this.d.setOnClickListener(this);
        this.e = (TextView) findViewById(2131390886);
        this.g = (TextView) findViewById(2131390885);
        this.j = (TextView) findViewById(2131390887);
        com.bytedance.bdturing.setting.e r9 = com.bytedance.bdturing.setting.e.a;
        String r10 = com.bytedance.bdturing.setting.e.f("agreement_title");
        this.i = r10;
        if (TextUtils.isEmpty(r10) == false) goto L13;
        this.i = getString(2131923585);
    L13:
        StringBuilder r11 = new StringBuilder();
        String r0 = getString(2131923583);
        r11.append(r0);
        r11.append(this.i);
        String r12 = r11.toString();
        SpannableString r1 = new SpannableString(r12);
        int r2 = r0.length();
        int r13 = r12.length();
        r1.setSpan(this.q, r2, r13, 33);
        this.g.setText(r1);
        this.g.setHighlightColor(0);
        this.g.setMovementMethod(LinkMovementMethod.getInstance());
        this.e.setEnabled(this.d.isChecked());
        this.e.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.h = getIntent().getStringExtra("detail");
        this.p = LiveDetectService.getInstance().getRequest();
        if (TextUtils.isEmpty(this.h) == false) goto L16;
        finish();
    L16:
        boolean r14 = LiveDetectService.getInstance().preInit(getApplicationContext(), getClass().getName());
        EventReport.y(getClass().getName(), r14, this.p);
        LiveDetectService.getInstance().setOnVerify(true);
    }

    public static void startActivity(Activity r2, String r3) {
        Intent r0 = new Intent(r2, TuringLiveDetectGuideActivity.class);
        r0.putExtra("detail", r3);
        r2.startActivity(r0);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r1, boolean r2) {
        this.e.setEnabled(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onActivityResult(int r1, int r2, Intent r3) {
        super/*androidx.fragment.app.FragmentActivity*/.onActivityResult(r1, r2, r3);
        if (1 == r1) goto L5;
        return;
    L5:
        if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0) goto L7;
        this.o = true;
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 1);
        return;
    L7:
        if (this.f == true) goto L14;
        this.f = true;
        LiveDetectService.getInstance().turn2DetectPage(this.p, this, this.h);
        finish();
        return;
    }
}
