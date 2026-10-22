package com.ss.android.bytedcert.ocr;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.media.ExifInterface;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.bytedcert.base.BytedCertSdkAbsActivity;
import com.ss.android.bytedcert.config.ThemeConfig;
import com.ss.android.bytedcert.flow.base.ICertFlow;
import com.ss.android.bytedcert.manager.BytedCertManager;
import com.ss.android.bytedcert.view.camera.MyPreview;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.cert.manager.utils.CertLog;
import com.ss.android.cert.manager.utils.SystemInfoTools;
import com.ss.android.cert.manager.utils.event.EventLogUtils;
import com.ss.android.cert.manager.utils.thread.BCThread;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import osa.c;
import qsa.f;
import qsa.h;
import qsa.j;
import qsa.k;
import qsa.l;
import qsa.m;
import rsa.d;
import rsa.i;

/* JADX INFO: loaded from: classes34.dex */
public class OCRTakePhotoActivity extends BytedCertSdkAbsActivity implements wsa.b {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f407622r = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Resources f407623d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MyPreview f407624e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f407625f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageView f407626g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f407627h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f407628i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f407629j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f407630k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f407631l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f407632m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f407633n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f407634o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f407635p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ICertFlow f407636q;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OCRTakePhotoActivity f407637a;

        public final void a() {
            OCRTakePhotoActivity r100 = this.f407637a;
            r100.f407633n = 0;
            Drawable r101 = r100.f407623d.getDrawable(R.mipmap.byted_poweroff);
            ImageView r102 = this.f407637a.f407626g;
            if (r102 == null) goto L5;
            r102.setImageDrawable(r101);
        L5:
            MyPreview r103 = this.f407637a.f407624e;
            if (r103 == null) goto L18;
            wsa.a r104 = r103.f407807b;
            r104.getClass();
            Camera r105 = r104.f561110a;     // Catch: Exception -> L13
            if (r105 == null) goto L19;
            Camera.Parameters r106 = r105.getParameters();     // Catch: Exception -> L13
            r106.setFlashMode("off");     // Catch: Exception -> L13
            r104.f561110a.setParameters(r106);     // Catch: Exception -> L13
            return;
        L19:
            return;
        L13:
            e = move-exception;
            e.printStackTrace();
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

        public a(OCRTakePhotoActivity r100) {
            this.f407637a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ byte[] f407638a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f407639b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ OCRTakePhotoActivity f407640c;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f407641a;

            @Override // java.lang.Runnable
            public final void run() {
                OCRTakePhotoActivity r100 = this.f407641a.f407640c;     // Catch: Throwable -> L4
                int r101 = OCRTakePhotoActivity.f407622r;     // Catch: Throwable -> L4
                r100.H1(true);     // Catch: Throwable -> L4
                this.f407641a.f407640c.finish();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(b r100) {
                this.f407641a = r100;
            }
        }

        /* JADX INFO: renamed from: com.ss.android.bytedcert.ocr.OCRTakePhotoActivity$b$b, reason: collision with other inner class name */
        public class RunnableC4718b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f407642a;

            @Override // java.lang.Runnable
            public final void run() {
                OCRTakePhotoActivity r100 = this.f407642a.f407640c;     // Catch: Throwable -> L4
                int r101 = OCRTakePhotoActivity.f407622r;     // Catch: Throwable -> L4
                r100.H1(false);     // Catch: Throwable -> L4
                this.f407642a.f407640c.finish();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC4718b(b r100) {
                this.f407642a = r100;
            }
        }

        public final void a() {
            byte[] r100 = this.f407638a;
            int r101 = 0;
            Bitmap r102 = BitmapFactory.decodeByteArray(r100, 0, r100.length);
            if (this.f407640c.f407630k == false) goto L5;
            int r103 = this.f407639b;
            Matrix r104 = new Matrix();
            r104.postRotate(r103);
            r102 = Bitmap.createBitmap(r102, 0, 0, r102.getWidth(), r102.getHeight(), r104, true);
        L5:
            String r105 = d.n(this.f407640c, this.f407638a, "img_old.jpg");
            ExifInterface r106 = null;
        L13:
            e = e;
        L14:
            e.printStackTrace();
        L15:
            BytedCertManager.getInstance().mImgTimeDelta = SystemInfoTools.getCurrentTime() - this.f407640c.f407635p;
            CertLog.e("image time:", BytedCertManager.getInstance().mImgTimeDelta + "ms");
            if (r102 == null) goto L39;
            OCRTakePhotoActivity r107 = this.f407640c;
            if (r107.f407631l == false) goto L21;
            Bitmap r108 = rsa.a.d(r102, 1.0f, 1.0f);
        L38:
            c r109 = new c(r108, r106);
            ((HashMap) gsa.a.f482481a).put(this.f407640c.f407627h, r109);
            this.f407640c.runOnUiThread(new a(this));
            return;
        L21:
            if (r107.f407630k == false) goto L37;
            int r110 = r102.getWidth();
            float r111 = r110;
            int r112 = (int) (0.05f * r111);
            int r113 = (int) ((r111 * 0.45f) * 2.0f);
            if (r112 > 0) goto L26;
            r112 = 0;
        L26:
            if ((r112 + r113) <= r110) goto L28;
            r112 = 0;
        L29:
            int r114 = r102.getHeight();
            float r115 = r114;
            int r116 = (int) (0.22f * r115);
            int r117 = (int) ((r115 * 0.18f) * 2.0f);
            if (r116 > 0) goto L33;
            r116 = 0;
        L33:
            if ((r116 + r117) > r114) goto L36;
            r114 = r117;
            r101 = r116;
        L36:
            r108 = Bitmap.createBitmap(r102, r112, r101, r110, r114);
            goto L38
        L28:
            r110 = r113;
            goto L29
        L37:
            r108 = rsa.a.d(r102, 0.7f, 0.8f);
            goto L38
        L39:
            this.f407640c.runOnUiThread(new RunnableC4718b(this));
            return;
        L7:
            if (TextUtils.isEmpty(r105) == true) goto L15;
            ExifInterface r118 = new ExifInterface(r105);     // Catch: Exception -> L13
            d.g(r105);     // Catch: Exception -> L11
            r106 = r118;
        L11:
            e = e;
            r106 = r118;
            goto L14
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

        public b(OCRTakePhotoActivity r100, byte[] r101, int r102) {
            this.f407640c = r100;
            this.f407638a = r101;
            this.f407639b = r102;
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        H1(false);
        G1("upload_cancel");
        super.onBackPressed();
    }

    public final void F1() {
        runOnUiThread(new a(this));
    }

    @Override // com.ss.android.bytedcert.base.BytedCertSdkAbsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
    }

    public OCRTakePhotoActivity() {
        this.f407633n = -1;
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

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        if (this.f407633n != 1) goto L6;
        F1();
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        TextView r100 = (TextView) findViewById(R.id.ocr_take_photo_title);
        int r101 = i.f(this);
        if (this.f407630k == false) goto L11;
        r100.setRotation(0.0f);
        if (this.f407632m == false) goto L7;
        double r102 = (((double) r101) * 1.0d) / 3.0d;
        float r103 = i.b(this, 160.0f);
    L8:
        r100.setTranslationY(-((int) (r102 + ((double) r103))));
        TextView r104 = (TextView) findViewById(R.id.ocr_take_photo_description);
        if (TextUtils.isEmpty(this.f407629j) == true) goto L12;
        r104.setText(this.f407629j);
    L12:
        String r105 = this.f407628i;
        if (r105 == null) goto L15;
        r100.setText(r105);
    L16:
        this.f407634o = 0;
        if (this.f407633n != 1) goto L19;
        runOnUiThread(new l(this));
        return;
    L19:
        F1();
        return;
    L15:
        r100.setText("");
        goto L16
    L7:
        r102 = (((double) r101) * 1.0d) / 4.0d;
        r103 = i.b(this, 140.0f);
        goto L8
    L11:
        r100.setTranslationX(-((int) (((((double) r101) / 10.0d) * 3.0d) + ((double) i.b(this, 20.0f)))));
        r100.setTextSize(2, 15.0f);
        goto L12
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

    public final void G1(String r100) {
        JSONObject r101 = new JSONObject();
        r101.put("button", r100);     // Catch: JSONException -> L5
        r101.put(ILiveRoomPlayFragmentConstant.EXTRA_CARD_POSITION, this.f407627h);     // Catch: JSONException -> L5
    L6:
        ICertFlow r102 = this.f407636q;
        if (r102 != null) goto L9;
        EventLogUtils.onEvent(EventConstant.Event.OCR_TAKE_PHOTO_CLICK, r101);
        return;
    L9:
        r102.onEvent(EventConstant.Event.OCR_TAKE_PHOTO_CLICK, r101);
    }

    public final void H1(boolean r100) {
        Intent r101 = new Intent();
        if (r100 == false) goto L5;
        r101.putExtra("status", 0);
        r101.putExtra("type", this.f407627h);
        setResult(-1, r101);
        return;
    L5:
        r101.putExtra("status", 1);
        setResult(0, r101);
    }

    @Override // com.ss.android.bytedcert.base.BytedCertSdkAbsActivity
    public final void A1(ICertFlow r100, ThemeConfig r101) {
        this.f407636q = r100;
        setContentView(R.layout.byted_activity_ocr_take_photo);
        this.f407635p = SystemInfoTools.getCurrentTime();
        this.f407625f = (ImageView) findViewById(R.id.ocr_take_photo_mask);
        this.f407626g = (ImageView) findViewById(R.id.ocr_take_photo_led);
        this.f407623d = getResources();
        this.f407624e = (MyPreview) findViewById(R.id.ocr_take_photo_surface);
        ((ImageView) findViewById(R.id.ocr_take_photo_take)).setOnClickListener(new f(this));
        F1();
        Intent r102 = getIntent();
        this.f407630k = TextUtils.equals(r102.getStringExtra("orientation"), "portrait");
        this.f407628i = r102.getStringExtra("title");
        this.f407629j = r102.getStringExtra(SocialConstants.PARAM_APP_DESC);
        if (TextUtils.equals(r102.getStringExtra("camera_position"), NewBroadcastMonitor.CAPTURE.FRONT) == false) goto L5;
        wsa.a.f561109e = 1;
    L7:
        if (r102.getBooleanExtra("show_album_entry", false) == false) goto L12;
        View r103 = findViewById(R.id.ocr_take_photo_choose_photo);
        if (r103 == null) goto L12;
        r103.setVisibility(0);
        r103.setOnClickListener(new h(this));
    L12:
        if (r102.getBooleanExtra("show_camera_switcher", false) == false) goto L16;
        View r104 = findViewById(R.id.ocr_take_photo_switch_camera);
        if (r104 == null) goto L16;
        r104.setVisibility(0);
        r104.setOnClickListener(new qsa.i(this));
    L16:
        String r105 = r102.getStringExtra("type");
        this.f407627h = r105;
        if (r105 != null) goto L19;
        this.f407627h = "";
    L19:
        JSONObject r106 = new JSONObject();
        r106.put(ILiveRoomPlayFragmentConstant.EXTRA_CARD_POSITION, this.f407627h);     // Catch: JSONException -> L22
    L23:
        ICertFlow r107 = this.f407636q;
        if (r107 != null) goto L26;
        EventLogUtils.onEvent(EventConstant.Event.OCR_TAKE_PHOTO_SHOW, r106);
    L27:
        String r108 = this.f407627h;
        r108.getClass();
        switch(r108.hashCode()) {
            case -906020504: goto L47;
            case 3015911: goto L43;
            case 3208383: goto L39;
            case 97705513: goto L35;
            case 1216777234: goto L31;
            default: goto L50;
        };
    L50:
        byte r109 = -1;
    L51:
        if (r109 != 0) goto L53;
        this.f407630k = true;
        this.f407632m = true;
        Drawable r110 = this.f407623d.getDrawable(R.mipmap.byted_selfie_mask);
    L75:
        this.f407631l = r102.getBooleanExtra("hide_mask", false);
        View r111 = findViewById(R.id.mask_container);
        if (this.f407631l == false) goto L78;
        r111.setVisibility(8);
        ((TextView) findViewById(R.id.ocr_take_photo_description)).setVisibility(8);
    L91:
        this.f407626g.setOnClickListener(new j(this));
        findViewById(R.id.iv_back).setOnClickListener(new k(this));
        return;
    L78:
        if (r110 == null) goto L81;
        this.f407625f.setImageDrawable(r110);
    L81:
        if (this.f407630k == false) goto L90;
        ViewGroup.LayoutParams r112 = this.f407625f.getLayoutParams();
        int r113 = (i.f(this) * 4) / 5;
        if (this.f407632m == false) goto L85;
        int r114 = r113;
    L86:
        if (r112 != null) goto L88;
        r112 = new ViewGroup.LayoutParams(r113, r114);
    L89:
        int r115 = (int) i.b(this, 80.0f);
        this.f407625f.setLayoutParams(r112);
        float r116 = -r115;
        this.f407625f.setTranslationY(r116);
        View r117 = findViewById(R.id.clip_hole_view);
        r117.setLayoutParams(r112);
        r117.setTranslationY(r116);
        r111.setBackgroundColor(this.f407623d.getColor(R.color.byted_transparent_gray_72));
        goto L91
    L88:
        r112.width = r113;
        r112.height = r114;
        goto L89
    L85:
        r114 = (r113 * 5) / 8;
        goto L86
    L90:
        this.f407625f.setRotation(90.0f);
        goto L91
    L53:
        if (r109 == 1) goto L68;
        if (r109 == 2) goto L65;
        if (r109 == 3) goto L59;
        if (r109 == 4) goto L58;
        r110 = null;
        goto L75
    L58:
        r110 = this.f407623d.getDrawable(R.mipmap.byted_passport_info_mask);
        goto L75
    L59:
        r110 = this.f407623d.getDrawable(R.mipmap.byted_id_card_front_mask);
        if (TextUtils.isEmpty(this.f407628i) == false) goto L63;
        this.f407628i = getString(R.string.byted_ocr_take_front);
    L63:
        if (TextUtils.isEmpty(this.f407629j) == false) goto L75;
        this.f407629j = getString(R.string.byted_ocr_take_photo_sub_title_subfix, new Object[]{getString(R.string.byted_ocr_front_prefix)});
        goto L75
    L65:
        r110 = this.f407623d.getDrawable(R.mipmap.byted_id_card_hold_mask);
        if (TextUtils.isEmpty(this.f407628i) == false) goto L75;
        this.f407628i = getString(R.string.byted_ocr_handheld);
        goto L75
    L68:
        r110 = this.f407623d.getDrawable(R.mipmap.byted_id_card_back_mask);
        if (TextUtils.isEmpty(this.f407628i) == false) goto L72;
        this.f407628i = getString(R.string.byted_ocr_take_back);
    L72:
        if (TextUtils.isEmpty(this.f407629j) == false) goto L75;
        this.f407629j = getString(R.string.byted_ocr_take_photo_sub_title_subfix, new Object[]{getString(R.string.byted_ocr_back_prefix)});
        goto L75
    L31:
        if (r108.equals("passport") == false) goto L50;
        r109 = 4;
        goto L51
    L35:
        if (r108.equals(NewBroadcastMonitor.CAPTURE.FRONT) == false) goto L50;
        r109 = 3;
        goto L51
    L39:
        if (r108.equals("hold") == false) goto L50;
        r109 = 2;
        goto L51
    L43:
        if (r108.equals("back") == false) goto L50;
        r109 = 1;
        goto L51
    L47:
        if (r108.equals("selfie") == false) goto L50;
        r109 = 0;
        goto L51
    L26:
        r107.onEvent(EventConstant.Event.OCR_TAKE_PHOTO_SHOW, r106);
        goto L27
    L5:
        wsa.a.f561109e = 0;
        goto L7
    }

    @Override // wsa.b
    public final void l1(byte[] r100, int r101) {
        new BCThread(new b(this, r100, r101)).start();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r100, int r101, Intent r102) {
        if (r100 != 2) goto L11;
        if (r102 != null) goto L6;
        return;
    L6:
        if (r102.getData() == null) goto L13;
        String r103 = d.d(this, r102.getData());
        if (TextUtils.isEmpty(r103) == true) goto L14;
        new BCThread(new m(this, r103)).start();
        return;
    L14:
        return;
    L13:
        return;
    }
}
