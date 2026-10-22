package com.bytedance.bdturing.comonui;

import ac4.f;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.TuringVerifyWebView;
import com.bytedance.bdturing.livedetect.LiveDetectService;
import com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity;
import com.bytedance.bdturing.setting.DefaultSettings;
import com.bytedance.crash.d;
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
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.Map;
import jc4.i;
import jc4.m;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import qb4.e;
import qb4.n;
import sb4.g;
import sb4.o;
import vb4.j;

/* JADX INFO: loaded from: classes12.dex */
public class VerifyConfirmDialogActivity extends TuringBaseLiveDetectActivity implements TuringBaseLiveDetectActivity.a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static int f201778p = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g f201779d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f201780e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public m f201781f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ac4.b f201782g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TuringVerifyWebView f201783h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CardView f201784i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f201785j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f201786k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f201787l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f201788m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f201789n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final b f201790o;

    public class a extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VerifyConfirmDialogActivity f201791a;

        @Override // ac4.f
        public final void d() {
            this.f201791a.finish();
        }

        @Override // ac4.f
        public final void i() {
            TuringVerifyWebView r100 = this.f201791a.f201783h;
            if (r100 == null) goto L6;
            r100.e();
            return;
        }

        public a(VerifyConfirmDialogActivity r100) {
            this.f201791a = r100;
        }

        @Override // ac4.f
        public final void o(String r100, String r101) {
            if (TextUtils.isEmpty(r101) == true) goto L6;
            CommonWebActivity.startActivityForResult(this.f201791a, 9999, r100, r101);
            return;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // ac4.f
        public final void q(int r100, String r101) {
            VerifyConfirmDialogActivity r102 = this.f201791a;
            r102.f201787l = r101;
            if (r100 == 0) goto L5;
        L7:
            VerifyConfirmDialogActivity.f201778p = r100;
            r102.finish();
            return;
        L5:
            if (r102.C1() == false) goto L7;
            r102.z1(r102);
        }

        @Override // ac4.f
        public final void j(int r100, int r101, boolean r102) {
            VerifyConfirmDialogActivity r103 = this.f201791a;
            if (r103.f201785j == true) goto L18;
            if (r102 == false) goto L7;
            Point r104 = hc4.f.f(r103);
            int r105 = r104.x;
            int r106 = r104.y;
            int r107 = r105;
        L8:
            ViewGroup.LayoutParams r108 = r103.f201783h.getLayoutParams();
            if (r103.f201786k == false) goto L15;
            int r109 = r108.width;
            if (r109 <= 0) goto L15;
            int r110 = r108.height;
            if (r110 <= 0) goto L15;
            r103.f201783h.f(r107, r106, r109, r110);
            r103.f201786k = false;
            return;
        L15:
            r103.f201783h.post(new sb4.m(r103, r102, r108, r107, r106));
            return;
        L7:
            r107 = r100;
            r106 = r101;
            goto L8
        }
    }

    public class b implements ComponentCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VerifyConfirmDialogActivity f201792a;

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
        }

        public b(VerifyConfirmDialogActivity r100) {
            this.f201792a = r100;
        }

        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration r100) {
            int r101 = r100.orientation;
            int r102 = 2;
            if (r101 == 1) goto L8;
            if (r101 == 2) goto L8;
            if (r101 == this.f201792a.f201789n) goto L8;
            return;
        L8:
            this.f201792a.f201789n = r101;
            if (r101 == 1) goto L12;
            r102 = 1;
        L12:
            JSONObject r103 = new JSONObject();
            r103.put("orientation", r102);     // Catch: JSONException -> L15
        L17:
            String r104 = ac4.c.b("bytedcert.orientation_changing", r103, "bytedcert.orientation_changing");
            VerifyConfirmDialogActivity r105 = this.f201792a;
            r105.f201786k = true;
            ac4.b r106 = r105.f201782g;
            if (r106 != null) goto L20;
            int r107 = n.f532367a;
        L21:
            EventReport.L(r102, this.f201792a.f201781f);
            return;
        L20:
            r106.a(r104);
        L15:
            e = move-exception;
            e.printStackTrace();
            goto L17
        }
    }

    public interface c {
    }

    @Override // com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity.a
    public final void f1() {
        EventReport.a(4, this.f201781f);
        EventReport.q(false, this.f201781f);
        String r100 = getString(R.string.truing_live_camera_permission_dlg_title);
        String r101 = getString(R.string.truing_live_camera_permission_dlg_content);
        sb4.b r102 = new sb4.b();
        r102.f541211a = r100;
        r102.f541212b = r101;
        r102.f541213c = getString(R.string.truing_live_camera_permission_dlg_left_btn_text);
        r102.f541214d = getString(R.string.truing_live_camera_permission_dlg_right_btn_text);
        g r103 = new g(this, r102, new o(this));
        this.f201779d = r103;
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

    public final boolean C1() {
        m r100 = this.f201781f;
        if (r100 == null) goto L9;
        jc4.a r101 = r100.f498122o;
        if (r101 == null) goto L9;
        if ((r101 instanceof i) == false) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        return true;
    L12:
        if (D1() == true) goto L17;
        return false;
    L17:
        return true;
    L9:
        r102 = false;
        goto L10
    }

    public final boolean D1() {
        m r100 = this.f201781f;
        if (r100 != null) goto L5;
    L9:
        return false;
    L5:
        if (r100.f498100k != 10000) goto L9;
        if ("live_h5".equals(r100.f498101l) == false) goto L9;
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        if (this.f201781f != null) goto L5;
    L7:
        boolean r100 = true;
    L8:
        if (r100 == false) goto L11;
        f201778p = 3;
        super.onBackPressed();
        return;
    L11:
        return;
    L5:
        if (C1() == false) goto L7;
        r100 = this.f201781f.b();
        goto L8
    }

    @Override // com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
        int r100 = f201778p;
        m r101 = this.f201781f;
        String r102 = this.f201787l;
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L8
        r103.put("key", "confirm_dialog_close");     // Catch: Exception -> L8
        r103.put("result", r100);     // Catch: Exception -> L8
        r103.put("custom", "url=" + r102);     // Catch: Exception -> L8
        EventReport.w("turing_verify_sdk", r103, r101);     // Catch: Exception -> L8
    L10:
        this.f201785j = true;
        int r104 = f201778p;
        String r105 = this.f201787l;
        m r106 = this.f201781f;
        JSONObject r107 = new JSONObject();     // Catch: Exception -> L13
        r107.put("key", "confirm_result");     // Catch: Exception -> L13
        r107.put("result", r104);     // Catch: Exception -> L13
        r107.put("custom", r105);     // Catch: Exception -> L13
        EventReport.w("turing_verify_sdk", r107, r106);     // Catch: Exception -> L13
    L15:
        c r108 = qb4.b.c.f532315a.f532307f;
        if (r108 != null) goto L18;
        return;
    L18:
        if (r104 == 0) goto L20;
        if (r104 == 2) goto L35;
        e r109 = (e) r108;
        qb4.f r110 = r109.f532338b;
        if (r110 == null) goto L44;
        r110.onFail(2, null);
    L44:
        r109.f532339c.f532307f = null;
        return;
    L35:
        if (D1() == false) goto L40;
        e r111 = (e) r108;
        qb4.f r112 = r111.f532338b;
        if (r112 == null) goto L39;
        r112.onFail(2, null);
    L39:
        r111.f532339c.f532307f = null;
        return;
    L40:
        e r113 = (e) r108;
        r113.f532339c.e(r113.f532337a, r113.f532338b);
        r113.f532339c.f532307f = null;
        return;
    L20:
        if (D1() == true) goto L22;
    L27:
        e r114 = (e) r108;
        jc4.a r115 = r114.f532337a;
        r115.f498096g = true;
        r115.f498102m = r105;
        qb4.b r116 = r114.f532339c;
        m r117 = r116.f532308g;
        if (r117 == null) goto L32;
        jc4.a r118 = r117.f498122o;
        if (r118 == null) goto L32;
        r118.f498096g = true;
    L32:
        r116.e(r115, r114.f532338b);
        r114.f532339c.f532307f = null;
        return;
    L22:
        if (TextUtils.isEmpty(r105) == false) goto L27;
        e r119 = (e) r108;
        qb4.f r120 = r119.f532338b;
        if (r120 == null) goto L26;
        r120.onFail(2, null);
    L26:
        r119.f532339c.f532307f = null;
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public VerifyConfirmDialogActivity() {
        this.f201786k = false;
        this.f201788m = new a(this);
        this.f201789n = -1;
        this.f201790o = new b(this);
    }

    /* JADX INFO: Removed unreachable split cross block B:73:0x0150 */
    @Override // com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        g r100 = this.f201779d;
        if (r100 == null) goto L22;
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r100);
    L19:
        this.f201779d = null;
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
    L68:
        return;
    L36:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L39;
        r103.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L62
        goto L68
    L39:
        if (isFinishing() == true) goto L42;
        r103.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L62
        goto L68
    L42:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L45;
        r103.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L62
        goto L68
    L45:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L48;
        r103.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L62
        goto L68
    L48:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L51;
        r103.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L62
        goto L68
    L51:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L53;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L62
        goto L68
    L53:
        Intent r107 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L62
        if (r107 == null) goto L68;
        r107.addFlags(268435456);     // Catch: Throwable -> L62
        r107.addFlags(2097152);     // Catch: Throwable -> L62
        r103.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L62
        startActivity(r107);     // Catch: Throwable -> L59
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right);     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L62
        goto L68
    L30:
        if ((r104 - r106.longValue()) >= 800) goto L33;
        monitor-exit(r105);     // Catch: Throwable -> L65
    L65:
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

    public static void startActivity(Activity r100) {
        r100.startActivity(new Intent(r100, VerifyConfirmDialogActivity.class));
    }

    @Override // com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity.a
    public final void G(int r100) {
        if (r100 != 2) goto L5;
        int r101 = 1;
    L6:
        EventReport.a(r101, this.f201781f);
        EventReport.q(true, this.f201781f);
        f201778p = 0;
        finish();
        return;
    L5:
        r101 = 0;
        goto L6
    }

    @Override // com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity.a
    public final void U0(int r100) {
        if (this.f201780e == false) goto L5;
        return;
    L5:
        int r101 = 2;
        if (r100 != 1) goto L8;
        Toast.makeText(this, getString(R.string.turing_live_camera_permission_tip_1), 0).show();
    L10:
        if (r100 != 2) goto L12;
        r101 = 3;
    L12:
        EventReport.a(r101, this.f201781f);
        f201778p = 5;
        finish();
        return;
    L8:
        if (r100 != 2) goto L10;
        Toast.makeText(this, getString(R.string.turing_live_camera_permission_tip_2), 0).show();
        goto L10
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r110) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r110);
        setContentView(R.layout.bdturing_confirm_dialog_activity);
        qb4.b r111 = qb4.b.c.f532315a;
        this.f201781f = r111.f532308g;
        if (C1() == false) goto L13;
        EventReport.g(LiveDetectService.getInstance().preInit(this, getClass().getName()), this.f201781f);
    L14:
        this.f201783h = (TuringVerifyWebView) findViewById(R.id.verify_webview);
        this.f201784i = (CardView) findViewById(R.id.web_container);
        this.f201824b = (ImageView) findViewById(R.id.loading);
        this.f201783h.d(new sb4.n(this, System.currentTimeMillis()), true, this.f201781f);
        this.f201782g = new ac4.b(this.f201788m, this.f201783h);
        BdTuringConfig r112 = r111.f532302a;
        String r100 = "";
        if (r112 == null) goto L17;
        String r113 = r112.getRegionType().getName();
    L18:
        StringBuilder r101 = new StringBuilder();
        com.bytedance.bdturing.setting.e r102 = com.bytedance.bdturing.setting.e.f202077a;
        Intrinsics.checkNotNullParameter(r113, EffectConfiguration.KEY_REGION);
        JSONObject r103 = com.bytedance.bdturing.setting.e.e("common").optJSONObject("popup_url");
        String r104 = null;
        if (r103 == null) goto L21;
        String r105 = r103.optString(r113);
    L23:
        if (TextUtils.isEmpty(r105) == false) goto L31;
        JSONObject r106 = DefaultSettings.f202074b.optJSONObject("common");
        if (r106 == null) goto L30;
        JSONObject r107 = r106.optJSONObject("popup_url");
        if (r107 == null) goto L30;
        r104 = r107.optString(r113);
    L30:
        r105 = r104;
    L31:
        m r108 = this.f201781f;
        JSONObject r109 = new JSONObject();     // Catch: Exception -> L34
        r109.put("key", "pop_h5_url");     // Catch: Exception -> L34
        r109.put("custom", "popupUrl:" + r105 + ";region:" + r113);     // Catch: Exception -> L34
        EventReport.w("turing_verify_sdk", r109, r108);     // Catch: Exception -> L34
    L37:
        if (TextUtils.isEmpty(r105) == false) goto L39;
        String r114 = r101.toString();
    L44:
        if (TextUtils.isEmpty(r114) == false) goto L46;
        finish();
    L47:
        registerComponentCallbacks(this.f201790o);
        return;
    L46:
        this.f201783h.loadUrl(r114);
        runOnUiThread(new j(this));
        goto L47
    L39:
        com.bytedance.bdturing.setting.e r115 = com.bytedance.bdturing.setting.e.f202077a;
        String r116 = com.bytedance.bdturing.setting.e.d("verify");
        r101.append(r105 + "?");
        hc4.f.a(r101, r116);
        tb4.b.a(this, r101);
        hc4.f.b(r101, "use_dialog_size_v2", 1);
        m r117 = this.f201781f;
        if (r117 == null) goto L42;
        r100 = r117.f498121n;
    L42:
        hc4.f.c(r101, "verify_data", r100);
        r114 = r101.toString();
    L34:
        e = move-exception;
        e.printStackTrace();
        goto L37
    L21:
        r105 = null;
        goto L23
    L17:
        r113 = "";
        goto L18
    L13:
        EventReport.g(true, this.f201781f);
        goto L14
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        if (1 != r100) goto L9;
        if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") != 0) goto L7;
        f201778p = 0;
        finish();
        return;
    L7:
        this.f201780e = true;
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 1);
        return;
    L9:
        if (r100 != 9999) goto L28;
        if (r102 == null) goto L29;
        String r103 = r102.getStringExtra("web_result");
        if (TextUtils.isEmpty(r103) == true) goto L30;
        String r104 = ac4.c.b("bytedcert.new_web_result", new JSONObject(r103), "bytedcert.new_web_result");     // Catch: Exception -> L19
        ac4.b r105 = this.f201782g;     // Catch: Exception -> L19
        if (r105 != null) goto L17;
        int r106 = n.f532367a;     // Catch: Exception -> L19
    L22:
        return;
    L17:
        r105.a(r104);     // Catch: Exception -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
        return;
    L30:
        return;
    L29:
        return;
    }
}
