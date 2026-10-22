package com.ss.android.bytedcert.ocr;

import android.R;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.hardware.Camera;
import android.media.ExifInterface;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.bytedcert.base.BytedCertSdkAbsActivity;
import com.ss.android.bytedcert.callback.SDKCallBack;
import com.ss.android.bytedcert.config.ThemeConfig;
import com.ss.android.bytedcert.dialog.CommonDialog;
import com.ss.android.bytedcert.dialog.LoadingDialog;
import com.ss.android.bytedcert.flow.base.ICertFlow;
import com.ss.android.bytedcert.flow.face.FaceDetectFlow;
import com.ss.android.bytedcert.manager.BytedCertManager;
import com.ss.android.bytedcert.net.BDResponse;
import com.ss.android.bytedcert.view.camera.MyPreview;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.ErrorConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.cert.manager.utils.CertLog;
import com.ss.android.cert.manager.utils.SystemInfoTools;
import com.ss.android.cert.manager.utils.event.EventLogUtils;
import com.ss.android.cert.manager.utils.thread.BCThread;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import psa.f;
import qsa.p;
import rsa.i;

/* JADX INFO: loaded from: classes34.dex */
public class OCRManualActivity extends BytedCertSdkAbsActivity implements wsa.b {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f407603m = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MyPreview f407604d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f407605e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f407606f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f407607g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f407608h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final WeakHandler f407609i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LoadingDialog f407610j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public FaceDetectFlow f407611k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f407612l;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OCRManualActivity f407613a;

        @Override // java.lang.Runnable
        public final void run() {
            rsa.b.c(this.f407613a.f407610j);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(OCRManualActivity r100) {
            this.f407613a = r100;
        }
    }

    public class b implements SDKCallBack.CommonRequestCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f407614a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ExifInterface f407615b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ OCRManualActivity f407616c;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f407617a;

            @Override // java.lang.Runnable
            public final void run() {
                rsa.b.b(this.f407617a.f407616c.f407610j);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(b r100) {
                this.f407617a = r100;
            }
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
        @Override // com.ss.android.bytedcert.callback.SDKCallBack.CommonRequestCallback
        public final void onRequestFinish(BDResponse r210) {
            this.f407616c.f407609i.post(new a(this));
            if (r210 != null) goto L5;
        L56:
            BDResponse r100 = r210;
            if (r100 != null) goto L84;
            r100 = new BDResponse(ErrorConstant.Client.ERROR_UNKNOWN);
        L84:
            OCRManualActivity r101 = this.f407616c;     // Catch: Exception -> L61
            r101.H1(r101, r100.errorMsg);     // Catch: Exception -> L61
        L63:
            OCRManualActivity r102 = this.f407616c;
            r102.getClass();
            JSONObject r103 = new JSONObject();     // Catch: JSONException -> L74
            if (r100.success == false) goto L67;
            String r104 = "success";
        L68:
            r103.put("result", r104);     // Catch: JSONException -> L74
            r103.put("error_code", r100.errorCode);     // Catch: JSONException -> L74
            r103.put("submit_type", "camera");     // Catch: JSONException -> L74
            r103.put("fail_info", r100.errorMsg);     // Catch: JSONException -> L74
            FaceDetectFlow r105 = r102.f407611k;     // Catch: JSONException -> L74
            if (r105 != null) goto L72;
            EventLogUtils.onEvent(EventConstant.Event.MANUAL_DETECTION_PHOTO_RESULT, r103);     // Catch: JSONException -> L74
        L81:
        L76:
            CertLog.d("OCRManualActivity ", "onRequestFinish: " + r100);
            return;
        L72:
            r105.onEvent(EventConstant.Event.MANUAL_DETECTION_PHOTO_RESULT, r103);     // Catch: JSONException -> L74
            goto L81
        L67:
            r104 = "fail";
        L74:
            e = move-exception;
            e.printStackTrace();
        L61:
            e = move-exception;
            e.printStackTrace();
            Toast.makeText(this.f407616c, r100.errorMsg, 0).show();
            goto L63
        L5:
            if (r210.success == false) goto L56;
            JSONObject r106 = r210.jsonBody.optJSONObject("data");
            if (r106 == null) goto L54;
            JSONArray r107 = r106.optJSONArray("front_image_card_corners");
            if (r107 == null) goto L54;
            if (r107.length() != 8) goto L54;
            Point r108 = new Point(CastIntegerProtector.parseInt(r107.optString(0)), CastIntegerProtector.parseInt(r107.optString(1)));
            Point r109 = new Point(CastIntegerProtector.parseInt(r107.optString(2)), CastIntegerProtector.parseInt(r107.optString(3)));
            Point r110 = new Point(CastIntegerProtector.parseInt(r107.optString(4)), CastIntegerProtector.parseInt(r107.optString(5)));
            Point r111 = new Point(CastIntegerProtector.parseInt(r107.optString(6)), CastIntegerProtector.parseInt(r107.optString(7)));
            Map<String, osa.c> r112 = gsa.a.f482481a;
            osa.c r113 = (osa.c) ((HashMap) r112).get(NewBroadcastMonitor.CAPTURE.FRONT);
            if (r113 == null) goto L54;
            Bitmap r114 = r113.f526593a;
            if (r114 == null) goto L54;
            int r115 = Math.max(rsa.a.g(r109.x, r109.y, r108.x, r108.y), rsa.a.g(r110.x, r110.y, r111.x, r111.y));
            int r116 = Math.max(rsa.a.g(r109.x, r109.y, r110.x, r110.y), rsa.a.g(r108.x, r108.y, r111.x, r111.y));
            int r117 = r114.getWidth();
            int r118 = r114.getHeight();
            int r119 = r117 / 2;
            int r120 = r118 / 2;
            int r121 = r109.x;
            String r122 = "data";
            int r123 = r108.x;
            if (r121 >= r123) goto L21;
            Map<String, osa.c> r211 = r112;
            if (r109.y <= r108.y) goto L22;
            float r124 = (-((float) Math.toDegrees(Math.atan(Math.abs((r111.x - r110.x) + 0.0f) / Math.abs(r111.y - r110.y))))) - 90.0f;
            Object r125 = NewBroadcastMonitor.CAPTURE.FRONT;
            Bitmap r126 = rsa.a.f(r114, r117, r118, r124, r119, r120, r115, r116, r108);
        L43:
            if (r126 != null) goto L79;
        L55:
            r100 = r210;
            this.f407616c.G1(true, 0, r100.jsonBody.optJSONObject(r122));
            goto L63
        L79:
        L51:
            e = move-exception;
            throw new RuntimeException(e);
        L45:
            if (TextUtils.isEmpty(this.f407614a) == true) goto L47;
            ((HashMap) r211).put(r125, new osa.c(r126, new ExifInterface(this.f407614a)));     // Catch: IOException -> L51
        L78:
            goto L55
        L47:
            ExifInterface r127 = this.f407615b;     // Catch: IOException -> L51
            if (r127 == null) goto L78;
            ((HashMap) r211).put(r125, new osa.c(r126, r127));     // Catch: IOException -> L51
        L22:
            r125 = NewBroadcastMonitor.CAPTURE.FRONT;
            if (r121 > r123) goto L25;
        L27:
            if (r121 < r123) goto L29;
        L31:
            if (r121 > r123) goto L33;
        L35:
            int r128 = r109.y;
            int r129 = r108.y;
            if (r128 != r129) goto L39;
            if (r121 <= r123) goto L39;
            r126 = rsa.a.f(r114, r117, r118, 0.0f, r119, r120, r115, r116, r108);
        L39:
            if (r128 != r129) goto L42;
            if (r121 >= r123) goto L42;
            r126 = rsa.a.f(r114, r117, r118, -180.0f, r119, r120, r115, r116, r108);
        L42:
            r126 = null;
            goto L43
        L33:
            if (r109.y >= r108.y) goto L35;
            r126 = rsa.a.f(r114, r117, r118, (float) Math.toDegrees(Math.atan(Math.abs((r111.x - r123) + 0.0f) / Math.abs(r111.y - r108.y))), r119, r120, r115, r116, r108);
            goto L43
        L29:
            if (r109.y >= r108.y) goto L31;
            r126 = rsa.a.f(r114, r117, r118, ((float) Math.toDegrees(Math.atan(Math.abs((r123 - r121) + 0.0f) / Math.abs(r108.y - r109.y)))) + 90.0f, r119, r120, r115, r116, r108);
            goto L43
        L25:
            if (r109.y <= r108.y) goto L27;
            r126 = rsa.a.f(r114, r117, r118, -((float) Math.toDegrees(Math.atan(Math.abs((r123 - r111.x) + 0.0f) / Math.abs(r108.y - r111.y)))), r119, r120, r115, r116, r108);
            goto L43
        L21:
            r211 = r112;
        L54:
            r122 = "data";
            goto L55
        }

        public b(OCRManualActivity r100, String r101, ExifInterface r102) {
            this.f407616c = r100;
            this.f407614a = r101;
            this.f407615b = r102;
        }
    }

    public class c implements CommonDialog.OnDialogClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OCRManualActivity f407618a;

        public c(OCRManualActivity r100) {
            this.f407618a = r100;
        }

        @Override // com.ss.android.bytedcert.dialog.CommonDialog.OnDialogClickListener
        public final void onCancel(DialogInterface r100) {
            r100.dismiss();
            OCRManualActivity r101 = this.f407618a;
            int r102 = ((Integer) ErrorConstant.Client.ERROR_USER_CANCEL.first).intValue();
            int r103 = OCRManualActivity.f407603m;
            r101.G1(false, r102, null);
        }

        @Override // com.ss.android.bytedcert.dialog.CommonDialog.OnDialogClickListener
        public final void onConfirm(DialogInterface r100) {
            OCRManualActivity r101 = this.f407618a;
            int r102 = OCRManualActivity.f407603m;
            if (r101.B1() == false) goto L5;
            return;
        L5:
            OCRManualActivity r103 = this.f407618a;
            r103.f407607g = 0;
            wsa.a r104 = r103.f407604d.f407807b;
            r104.getClass();
            Camera r105 = r104.f561110a;     // Catch: Exception -> L10
            if (r105 == null) goto L15;
            r105.startPreview();     // Catch: Exception -> L10
            return;
        L15:
            return;
        L10:
            e = move-exception;
            e.printStackTrace();
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ byte[] f407619a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f407620b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ OCRManualActivity f407621c;

        public final void a() {
            byte[] r100 = this.f407619a;
            Bitmap r101 = BitmapFactory.decodeByteArray(r100, 0, r100.length);
            if (this.f407621c.f407612l == false) goto L5;
            int r102 = this.f407620b;
            Matrix r103 = new Matrix();
            r103.postRotate(r102);
            r101 = Bitmap.createBitmap(r101, 0, 0, r101.getWidth(), r101.getHeight(), r103, true);
        L5:
            String r104 = rsa.d.n(this.f407621c, this.f407619a, "img_old.jpg");
        L14:
            e = e;
            ExifInterface r105 = null;
        L16:
            e.printStackTrace();
        L17:
            BytedCertManager.getInstance().mImgTimeDelta = SystemInfoTools.getCurrentTime() - this.f407621c.f407608h;
            CertLog.e("image time:", BytedCertManager.getInstance().mImgTimeDelta + "ms");
            if (r101 == null) goto L20;
            osa.c r106 = new osa.c(r101, r105);
            ((HashMap) gsa.a.f482481a).put(this.f407621c.f407606f, r106);
        L20:
            this.f407621c.F1(null, r105);
            return;
        L7:
            if (TextUtils.isEmpty(r104) == true) goto L13;
            r105 = new ExifInterface(r104);     // Catch: Exception -> L14
            rsa.d.g(r104);     // Catch: Exception -> L11
        L11:
            e = e;
            goto L16
        L13:
            r105 = null;
            goto L17
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

        public d(OCRManualActivity r100, byte[] r101, int r102) {
            this.f407621c = r100;
            this.f407619a = r101;
            this.f407620b = r102;
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        G1(false, ((Integer) ErrorConstant.Client.ERROR_FACE_LIVE_RETURN.first).intValue(), null);
        super.onBackPressed();
    }

    @Override // com.ss.android.bytedcert.base.BytedCertSdkAbsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
    }

    public OCRManualActivity() {
        this.f407604d = null;
        this.f407605e = null;
        this.f407606f = null;
        this.f407607g = 0;
        this.f407608h = 0;
        this.f407609i = new WeakHandler(Looper.getMainLooper(), null);
        this.f407610j = null;
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

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        this.f407607g = 0;
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

    @Override // com.ss.android.bytedcert.base.BytedCertSdkAbsActivity
    public final void A1(ICertFlow r100, ThemeConfig r101) {
        setContentView(com.larus.nova.R.layout.byted_activity_manual_ocr);
        if ((r100 instanceof FaceDetectFlow) == false) goto L5;
        this.f407611k = (FaceDetectFlow) r100;
    L5:
        this.f407608h = SystemInfoTools.getCurrentTime();
        this.f407606f = getIntent().getStringExtra("type");
        this.f407612l = TextUtils.equals(getIntent().getStringExtra("orientation"), "portrait");
        this.f407604d = (MyPreview) findViewById(com.larus.nova.R.id.ocr_take_photo_surface);
        ImageView r102 = (ImageView) findViewById(com.larus.nova.R.id.ocr_take_photo_return_back);
        TextView r103 = (TextView) findViewById(com.larus.nova.R.id.ocr_from_ablum_txt);
        Button r104 = (Button) findViewById(com.larus.nova.R.id.ocr_take_photo_take);
        FaceDetectFlow r105 = this.f407611k;
        if (r105 != null) goto L8;
        EventLogUtils.onEvent(EventConstant.Event.MANUAL_DETECTION_CAMERA_SHOW);
    L10:
        if (this.f407606f != null) goto L13;
        this.f407606f = "";
    L13:
        if (TextUtils.equals(NewBroadcastMonitor.CAPTURE.FRONT, this.f407606f) == false) goto L15;
        this.f407605e = getString(com.larus.nova.R.string.byted_ocr_take_front);
    L15:
        ImageView r106 = (ImageView) findViewById(com.larus.nova.R.id.byted_front_new);
        if (this.f407612l == false) goto L22;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        int r108 = (i.f(this) * 4) / 5;
        int r109 = (r108 * 5) / 8;
        if (r107 != null) goto L20;
        r107 = new ViewGroup.LayoutParams(r108, r109);
    L21:
        r106.setLayoutParams(r107);
        findViewById(com.larus.nova.R.id.clip_hole_view).setLayoutParams(r107);
    L23:
        r104.setOnClickListener(new qsa.b(this));
        i.h(r103, r103.getText().toString(), getString(com.larus.nova.R.string.byted_take_front_photo_album_upgrade), new qsa.c(this));
        r102.setOnClickListener(new qsa.d(this));
        TextView r110 = (TextView) findViewById(com.larus.nova.R.id.ocr_take_photo_prompt_text);
        int r111 = i.f(this);
        if (this.f407612l == false) goto L26;
        r110.setRotation(0.0f);
        r110.setTranslationY(-((int) (((((double) r111) * 1.0d) / 4.0d) - ((double) i.b(this, 20.0f)))));
    L27:
        String r112 = this.f407605e;
        if (r112 == null) goto L30;
        r110.setText(r112);
        return;
    L30:
        r110.setText("");
        return;
    L26:
        r110.setTranslationX(-((int) (((((double) r111) / 18.0d) * 3.0d) + ((double) i.b(this, 20.0f)))));
        goto L27
    L20:
        r107.width = r108;
        r107.height = r109;
        goto L21
    L22:
        r106.setRotation(90.0f);
        goto L23
    L8:
        r105.onEvent(EventConstant.Event.MANUAL_DETECTION_CAMERA_SHOW, null);
        goto L10
    }

    public final void F1(String r100, ExifInterface r101) {
        this.f407610j = LoadingDialog.create(this);     // Catch: Exception -> L4
    L5:
        this.f407609i.post(new a(this));
        FaceDetectFlow r102 = this.f407611k;
        Map<String, String> r103 = null;
        if (r102 != null) goto L8;
        psa.a r104 = new psa.a(null);
    L9:
        b r105 = new b(this, r100, r101);
        FaceDetectFlow r106 = this.f407611k;
        if (r106 == null) goto L13;
        r103 = r106.appendCommonRequestParams(null);
    L13:
        r104.getClass();
        new f(r104, r103, this, r105).start();
        return;
    L8:
        r104 = r102.getRequestUtils();
        goto L9
    }

    public final void H1(Activity r100, String r101) {
        CommonDialog r102 = new CommonDialog(r100);
        r102.setTitle(getString(com.larus.nova.R.string.byted_dialog_upgrade_identity));
        r102.setMessage(r101);
        r102.setCancelText(getString(com.larus.nova.R.string.byted_dialog_exit_process));
        r102.setConfirmText(getString(com.larus.nova.R.string.byted_dialog_reshoot));
        r102.setCancelable(false);
        r102.setListener(new c(this));
        if (DialogLancet.shouldBlockDialogShow(r102) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r102);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r102);
        r102.show();
        DialogLancet.afterDialogShow(r102);
    }

    @Override // wsa.b
    public final void l1(byte[] r100, int r101) {
        new BCThread(new d(this, r100, r101)).start();
    }

    public final void G1(boolean r100, int r101, JSONObject r102) {
        Intent r103 = new Intent();
        if (r100 == false) goto L7;
        if (r102 == null) goto L6;
        r103.putExtra(BytedCertConstant.CertKey.IDENTITY_CODE, r102.optString(BytedCertConstant.CertKey.IDENTITY_CODE));
        r103.putExtra(BytedCertConstant.CertKey.IDENTITY_NAME, r102.optString(BytedCertConstant.CertKey.IDENTITY_NAME));
    L6:
        r103.putExtra("status", r101);
        setResult(-1, r103);
    L8:
        finish();
        return;
    L7:
        r103.putExtra("status", r101);
        setResult(0, r103);
        goto L8
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r100, int r101, Intent r102) {
        if (r100 != 3) goto L13;
        if (r102 != null) goto L6;
    L11:
        H1(this, (String) ErrorConstant.Client.ERROR_PICK_PHOTO_ERROR.second);
        return;
    L6:
        if (r102.getData() == null) goto L11;
        String r103 = rsa.d.d(this, r102.getData());
        if (TextUtils.isEmpty(r103) == true) goto L10;
        p.c(this.f407606f, r103);
        F1(r103, null);
        return;
    L10:
        H1(this, (String) ErrorConstant.Client.ERROR_PICK_PHOTO_ERROR.second);
        return;
    }
}
