package com.ss.android.bytedcert.video;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.bytedcert.base.BytedCertSdkAbsActivity;
import com.ss.android.bytedcert.config.ThemeConfig;
import com.ss.android.bytedcert.dialog.CommonDialog;
import com.ss.android.bytedcert.dialog.controller.video.VideoRecordController;
import com.ss.android.bytedcert.flow.base.ICertFlow;
import com.ss.android.bytedcert.flow.cert.BytedCertFlow;
import com.ss.android.bytedcert.net.BDResponse;
import com.ss.android.bytedcert.video.fragment.VideoPlayFragment;
import com.ss.android.bytedcert.video.fragment.VideoRecordFragment;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.ErrorConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.cert.manager.utils.CertLog;
import com.ss.android.cert.manager.utils.net.CertResponse;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class VideoUploadActivity extends BytedCertSdkAbsActivity implements ssa.a, WeakHandler.IHandler {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f407648j = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CommonDialog f407649d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f407650e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f407651f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f407652g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final WeakHandler f407653h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public VideoRecordController f407654i;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoUploadActivity f407655a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f407655a.finish();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(VideoUploadActivity r100) {
            this.f407655a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f407656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f407657b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f407658c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f407659d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ CommonDialog.OnDialogClickListener f407660e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f407661f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ VideoUploadActivity f407662g;

        public class a implements CommonDialog.OnDialogClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f407663a;

            public a(b r100) {
                this.f407663a = r100;
            }

            public final void a(String r100) {
                JSONObject r101 = new JSONObject();     // Catch: Exception -> L10
                if (TextUtils.isEmpty(this.f407663a.f407656a) == true) goto L6;
                r101.put("title", this.f407663a.f407656a);     // Catch: Exception -> L10
            L6:
                if (TextUtils.isEmpty(this.f407663a.f407657b) == false) goto L8;
                r101.put(EventConstant.Key.RETAIN_PROMPT, this.f407663a.f407657b);     // Catch: Exception -> L10
            L8:
                r101.put("button_name", r100);     // Catch: Exception -> L10
                this.f407663a.f407662g.f407654i.onEvent(EventConstant.Event.EVENT_AUTH_NOTIFY_DIALOG_CLICK, r101);     // Catch: Exception -> L10
                return;
            }

            @Override // com.ss.android.bytedcert.dialog.CommonDialog.OnDialogClickListener
            public final void onCancel(DialogInterface r100) {
                CommonDialog.OnDialogClickListener r101 = this.f407663a.f407660e;
                if (r101 == null) goto L5;
                r101.onCancel(r100);
            L5:
                a(this.f407663a.f407658c);
            }

            @Override // com.ss.android.bytedcert.dialog.CommonDialog.OnDialogClickListener
            public final void onConfirm(DialogInterface r100) {
                CommonDialog.OnDialogClickListener r101 = this.f407663a.f407660e;
                if (r101 == null) goto L5;
                r101.onConfirm(r100);
            L5:
                a(this.f407663a.f407659d);
            }
        }

        public final void a() {
            VideoUploadActivity r100 = this.f407662g;
            if (r100.f407649d != null) goto L6;
            r100.f407649d = new CommonDialog(this.f407662g);
        L6:
            if (this.f407662g.f407649d.isShowing() == false) goto L8;
            return;
        L8:
            CertLog.e("videoShowDialog", "fragment, " + (this.f407662g.getSupportFragmentManager().findFragmentByTag("video_fragment_tag") instanceof VideoRecordFragment));
            this.f407662g.f407649d.setCancelable(false);
            CommonDialog r101 = this.f407662g.f407649d.setTitle(this.f407656a).setMessage(this.f407657b).setCancelText(this.f407658c).setConfirmText(this.f407659d).setListener(new a(this));
            if (DialogLancet.shouldBlockDialogShow(r101) == false) goto L33;
            DialogLancet.handleBlockedDialogShow(r101);
        L35:
            JSONObject r102 = new JSONObject();     // Catch: Exception -> L31
            if (TextUtils.isEmpty(this.f407656a) == true) goto L17;
            r102.put("title", this.f407656a);     // Catch: Exception -> L31
        L17:
            if (TextUtils.isEmpty(this.f407657b) == false) goto L19;
            r102.put(EventConstant.Key.RETAIN_PROMPT, this.f407657b);     // Catch: Exception -> L31
        L19:
            StringBuilder r103 = new StringBuilder();     // Catch: Exception -> L31
            if (TextUtils.isEmpty(this.f407658c) == true) goto L24;
            r103.append(this.f407658c);     // Catch: Exception -> L31
            r103.append(",");     // Catch: Exception -> L31
        L24:
            if (TextUtils.isEmpty(this.f407659d) == true) goto L26;
            r103.append(this.f407659d);     // Catch: Exception -> L31
            r103.append(",");     // Catch: Exception -> L31
        L26:
            r102.put("button_list", r103.toString());     // Catch: Exception -> L31
            int r104 = this.f407661f;     // Catch: Exception -> L31
            if (r104 < 0) goto L29;
            r102.put("error_code", r104);     // Catch: Exception -> L31
        L29:
            this.f407662g.f407654i.onEvent(EventConstant.Event.EVENT_AUTH_NOTIFY_DIALOG, r102);     // Catch: Exception -> L31
            return;
        L37:
            return;
        L33:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L32
        L12:
            DialogLancet.beforeDialogShow(r101);
            r101.show();
            DialogLancet.afterDialogShow(r101);
            goto L35
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

        public b(VideoUploadActivity r100, String r101, String r102, String r103, String r104, CommonDialog.OnDialogClickListener r105, int r106) {
            this.f407662g = r100;
            this.f407656a = r101;
            this.f407657b = r102;
            this.f407658c = r103;
            this.f407659d = r104;
            this.f407660e = r105;
            this.f407661f = r106;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f407664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f407665b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ VideoUploadActivity f407666c;

        public final void a() {
            Fragment r100 = this.f407666c.getSupportFragmentManager().findFragmentByTag("video_fragment_tag");
            if ((r100 instanceof VideoRecordFragment) == false) goto L16;
            VideoRecordFragment r101 = (VideoRecordFragment) r100;
            String r102 = this.f407664a;
            int r103 = this.f407665b;
            if (r101.f407686k != null) goto L8;
            return;
        L8:
            if (TextUtils.isEmpty(r102) == false) goto L10;
            r101.f407686k.setText(r101.getString(R.string.byted_video_record_default_prompt));
            return;
        L10:
            if (r102 != null) goto L12;
            return;
        L12:
            if (r102.equals(r101.f407686k.getText().toString()) == true) goto L20;
            r101.f407686k.setText(r102);
            r101.f407689n = r103;
            return;
        L20:
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

        public c(VideoUploadActivity r100, String r101, int r102) {
            this.f407666c = r100;
            this.f407664a = r101;
            this.f407665b = r102;
        }
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
    }

    @Override // ssa.a
    public final void F0() {
        this.f407650e++;
    }

    @Override // ssa.a
    public final void j0() {
        this.f407651f++;
    }

    @Override // com.ss.android.bytedcert.base.BytedCertSdkAbsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
    }

    @Override // ssa.a
    public final void showLoading() {
        Handler r100 = this.f407261a;
        asa.a r101 = new asa.a(this, null);
        if (r100 == null) goto L13;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L7;
        r101.run();     // Catch: Exception -> L9
    L10:
        return;
    L7:
        r100.post(r101);     // Catch: Exception -> L9
    L14:
        return;
    }

    public VideoUploadActivity() {
        this.f407650e = -1;
        this.f407651f = -1;
        this.f407653h = new WeakHandler(Looper.getMainLooper(), this);
    }

    @Override // com.ss.android.bytedcert.base.BytedCertSdkAbsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
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
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right);     // Catch: Throwable -> L39
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

    @Override // ssa.a
    public final void k0() {
        Fragment r100 = getSupportFragmentManager().findFragmentByTag("video_fragment_tag");
        if ((r100 instanceof VideoRecordFragment) == false) goto L11;
        VideoRecordFragment r101 = (VideoRecordFragment) r100;
        r101.f407690o.b();
        TextView r102 = r101.f407686k;
        if (r102 == null) goto L7;
        r102.setVisibility(0);
    L7:
        TextView r103 = r101.f407688m;
        if (r103 == null) goto L12;
        r103.setVisibility(8);
        return;
    L12:
        return;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        Fragment r100 = getSupportFragmentManager().findFragmentById(R.id.fragment_video);
        if ((r100 instanceof VideoPlayFragment) == true) goto L5;
        O(new BDResponse(ErrorConstant.Client.ERROR_FACE_LIVE_RETURN));
        return;
    L5:
        if (((VideoPlayFragment) r100).f407674l == false) goto L7;
        O(new BDResponse(new CertResponse(true)));
        return;
    L7:
        n0("record");
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

    @Override // ssa.a
    public final void startRecord() {
        Fragment r100 = getSupportFragmentManager().findFragmentByTag("video_fragment_tag");
        if ((r100 instanceof VideoRecordFragment) == false) goto L6;
        ((VideoRecordFragment) r100).T90();
        return;
    }

    @Override // com.ss.android.bytedcert.base.BytedCertSdkAbsActivity, isa.b
    public final void hideLoading() {
        super.hideLoading();
    }

    @Override // ssa.a
    public final void O(BDResponse r100) {
        this.f407654i.onVideoRecordFinish(r100);
        JSONObject r101 = new JSONObject();
        if (r100.success == false) goto L6;
        String r102 = "success";
    L7:
        r101.put("result", r102);     // Catch: Exception -> L10
        r101.put("error_code", r100.errorCode);     // Catch: Exception -> L10
        r101.put("fail_reason", r100.errorMsg);     // Catch: Exception -> L10
        r101.put("total_duration", String.valueOf((System.currentTimeMillis() - this.f407652g) / 1000));     // Catch: Exception -> L10
        r101.put(EventConstant.Key.UPLOAD_RETRY_TIMES, Math.max(this.f407651f, 0));     // Catch: Exception -> L10
        r101.put(EventConstant.Key.VIDEO_RETRY_TIMES, Math.max(this.f407650e, 0));     // Catch: Exception -> L10
        goto L8
    L6:
        r102 = "fail";
    L8:
        this.f407654i.onEvent(EventConstant.Event.AUTH_VIDEO_CHECKING_RESULT, r101);
        this.f407653h.postDelayed(new a(this), 200);
    }

    @Override // ssa.a
    public final void n0(String r100) {
        Fragment r101 = getSupportFragmentManager().findFragmentByTag("video_fragment_tag");
        if ("record".equals(r100) == false) goto L19;
        FragmentTransaction r102 = getSupportFragmentManager().beginTransaction();
        VideoRecordFragment r103 = new VideoRecordFragment();
        Bundle r104 = getIntent().getExtras();
        if (r104 != null) goto L7;
        r104 = new Bundle();
    L7:
        r103.setArguments(r104);
        r102.setCustomAnimations(R.anim.byted_slide_right_in, R.anim.byted_slide_left_out);
        if (r101 == null) goto L14;
        r102.setCustomAnimations(R.anim.byted_slide_left_in, R.anim.byted_slide_left_out);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r102, r103, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "video_fragment_tag", R.id.fragment_video) == true) goto L17;
        r102.replace(R.id.fragment_video, r103, "video_fragment_tag");
    L17:
        r102.commit();
        return;
    L14:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r102, r103, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "video_fragment_tag", R.id.fragment_video) == true) goto L17;
        r102.add(R.id.fragment_video, r103, "video_fragment_tag");
        goto L17
    L19:
        if ("preview".equals(r100) == false) goto L39;
        FragmentTransaction r105 = getSupportFragmentManager().beginTransaction();
        VideoPlayFragment r106 = new VideoPlayFragment();
        Bundle r107 = getIntent().getExtras();
        if (r107 != null) goto L24;
        r107 = new Bundle();
    L24:
        if ((r101 instanceof VideoRecordFragment) == false) goto L26;
        r107.remove(BytedCertConstant.IntentKey.VIEW_TYPE);
    L26:
        r106.setArguments(r107);
        r105.setCustomAnimations(R.anim.byted_slide_right_in, R.anim.byted_slide_left_out);
        if (r101 == null) goto L33;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r105, r106, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "video_fragment_tag", R.id.fragment_video) == true) goto L36;
        r105.replace(R.id.fragment_video, r106, "video_fragment_tag");
    L36:
        r105.commit();
        return;
    L33:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r105, r106, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "video_fragment_tag", R.id.fragment_video) == true) goto L36;
        r105.add(R.id.fragment_video, r106, "video_fragment_tag");
        goto L36
    }

    @Override // com.ss.android.bytedcert.base.BytedCertSdkAbsActivity
    public final void A1(ICertFlow r100, ThemeConfig r101) {
        if ((r100 instanceof BytedCertFlow) == true) goto L6;
        finish();
        return;
    L6:
        this.f407654i = ((BytedCertFlow) r100).getRecordController();
        setContentView(R.layout.byted_activity_video_record);
        String r102 = getIntent().getStringExtra(BytedCertConstant.IntentKey.VIEW_TYPE);
        if (TextUtils.isEmpty(r102) == false) goto L10;
        r102 = "record";
    L10:
        if (TextUtils.equals("preview", r102) == true) goto L12;
    L14:
        this.f407652g = System.currentTimeMillis();
        getIntent().removeExtra(BytedCertConstant.IntentKey.VIEW_TYPE);
        n0("record");
        return;
    L12:
        if (TextUtils.isEmpty(this.f407654i.getVideoPath()) == true) goto L14;
        n0("preview");
    }

    @Override // ssa.a
    public final void w(String r100, int r101) {
        runOnUiThread(new c(this, r100, r101));
    }

    @Override // ssa.a
    public final void r1(String r110, String r111, String r112, String r113, CommonDialog.OnDialogClickListener r114, int r115) {
        runOnUiThread(new b(this, r110, r111, r112, r113, r114, r115));
    }
}
