package com.bytedance.bdp.appbase.locate.map;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.bdpbase.util.DevicesUtil;
import com.bytedance.bdp.bdpbase.util.o;
import com.bytedance.bdp.service.plug.map.model.BdpLatLng;
import com.bytedance.bdp.service.plug.map.model.BdpMap;
import com.bytedance.bdp.service.plug.map.model.BdpMarkerOptions;
import com.bytedance.bdp.serviceapi.defaults.map.BdpMapService;
import com.bytedance.bdp.serviceapi.defaults.permission.BdpPermissionService;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import t94.e;
import t94.g;
import t94.h;
import t94.l;
import v19.f;

/* JADX INFO: loaded from: classes11.dex */
public class BdpMapActivity extends AppCompatActivity implements BdpMap.GeocoderSearchedListener, BdpMap.RegeocodeSearchedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f200798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f200799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f200800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f200801d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f200802e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f200803f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f200804g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Dialog f200805h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f200806i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f200807j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Double f200808k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Double f200809l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f200810m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public BdpLatLng f200811n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public BdpLatLng f200812o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public l f200813p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public l f200814q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Location f200815r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f200816s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public BdpMap f200817t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final c f200818u;

    public class a implements BdpMap.OnLocateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BdpMapActivity f200819a;

        public a(BdpMapActivity r100) {
            this.f200819a = r100;
        }

        @Override // com.bytedance.bdp.service.plug.map.model.BdpMap.OnLocateChangeListener
        public final void onLocationChanged(Location r100, String r101) {
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.getLatitude() != AudioStats.AUDIO_AMPLITUDE_NONE) goto L7;
            return;
        L7:
            if (r100.getLongitude() == AudioStats.AUDIO_AMPLITUDE_NONE) goto L25;
            BdpMapActivity r102 = this.f200819a;
            r102.f200815r = r100;
            if (r102.f200811n != null) goto L17;
            r102.f200811n = new BdpLatLng(r100.getLatitude(), r100.getLongitude());
            BdpMapActivity r103 = this.f200819a;
            if (r103.f200810m == false) goto L19;
            r103.f200817t.showLocateBluePoint(r100);
            BdpMapActivity r104 = this.f200819a;
            r104.f200817t.moveCameraToLatLng(r104.f200811n);
            BdpMapActivity r105 = this.f200819a;
            r105.f200817t.setScale(r105.f200816s);
            if (Objects.equals(this.f200819a.f200799b.getDrawable().getCurrent().getConstantState(), ContextCompat.getDrawable(this.f200819a, R.drawable.bdpapp_m_map_sentinel_select).getConstantState()) == true) goto L19;
            this.f200819a.f200799b.setImageResource(R.drawable.bdpapp_m_map_sentinel_select);
        L19:
            BdpMapActivity r106 = this.f200819a;
            if (r106.f200810m == false) goto L22;
            r106.f200810m = false;
        L22:
            r106.f200813p = new l(r101, r106.f200811n);
            return;
        L17:
            if (r102.f200810m == false) goto L19;
            r102.f200811n = new BdpLatLng(r100.getLatitude(), r100.getLongitude());
            this.f200819a.f200817t.showLocateBluePoint(r100);
            goto L19
        }
    }

    public class b implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BdpMapActivity f200820a;

        public b(BdpMapActivity r100) {
            this.f200820a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            BdpMapActivity r102 = this.f200820a;
            r102.getClass();
            if (q94.a.f532096b == false) goto L6;
            g94.b.a("BdpMapActivity", new Object[]{"onTouch ", Integer.valueOf(r101.getAction())});
        L6:
            if (r101.getAction() == 2) goto L9;
        L11:
            return false;
        L9:
            if (Objects.equals(r102.f200799b.getDrawable().getCurrent().getConstantState(), ContextCompat.getDrawable(r102, R.drawable.bdpapp_m_map_sentinel).getConstantState()) == true) goto L11;
            r102.f200799b.setImageResource(R.drawable.bdpapp_m_map_sentinel);
            goto L11
        }
    }

    public class c implements View.OnTouchListener {
        public c() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            int r102 = r101.getAction();
            if (r102 != 0) goto L5;
            r100.setAlpha(0.5f);
            return false;
        L5:
            if (r102 != 1) goto L7;
        L9:
            r100.setAlpha(1.0f);
            return false;
        L7:
            if (r102 == 3) goto L9;
            return false;
        }
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
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
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right);     // Catch: Throwable -> L39
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
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
        this.f200817t.onDestroy();
        this.f200817t.stopLocation();
        this.f200817t = null;
    }

    public final void z1() {
        this.f200812o = new BdpLatLng(this.f200809l.doubleValue(), this.f200808k.doubleValue());
        this.f200817t.moveCameraToLatLng(new BdpLatLng(this.f200809l.doubleValue(), this.f200808k.doubleValue()));
        y1(this.f200812o);
        if (TextUtils.isEmpty(this.f200807j) == false) goto L8;
        if (TextUtils.isEmpty(this.f200806i) == false) goto L8;
        o.d(this.f200801d, 8);
        o.d(this.f200802e, 8);
        o.d(this.f200803f, 8);
    L14:
        this.f200817t.setScale(this.f200816s);
        return;
    L8:
        if (TextUtils.isEmpty(this.f200807j) == true) goto L11;
        this.f200801d.setText(this.f200807j);
        o.d(this.f200801d, 0);
    L11:
        if (TextUtils.isEmpty(this.f200806i) == true) goto L13;
        this.f200802e.setText(this.f200806i);
        o.d(this.f200802e, 0);
    L13:
        o.d(this.f200803f, 8);
        goto L14
    }

    public BdpMapActivity() {
        this.f200810m = false;
        this.f200816s = 18;
        this.f200818u = new c();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        this.f200817t.onPause();
        this.f200817t.stopLocation();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        this.f200817t.onResume();
        this.f200817t.startLocation();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
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

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r100);
        BdpMapService r101 = (BdpMapService) BdpManager.getInst().getService(BdpMapService.class);
        if (r101 != null) goto L13;
        finish();
        return;
    L13:
        BdpMap r102 = r101.createMapInstance();
        this.f200817t = r102;
        if (r102 != null) goto L16;
        finish();
        return;
    L16:
        setContentView(R.layout.bdpapp_m_map_activity);
        ViewGroup r103 = (ViewGroup) findViewById(R.id.bdpapp_m_parent_view_map);
        this.f200817t.setOnLocationChangedListener(new a(this));
        View r104 = this.f200817t.createMapView(this);
        this.f200817t.onActivityCreated(r100);
        r103.addView(r104, 0, new RelativeLayout.LayoutParams(-1, -1));
        r103.setOnTouchListener(new b(this));
        int r105 = ColorProtector.parseColor("#00717171");
        Window r106 = getWindow();
        r106.clearFlags(67108864);
        x94.a.a(r106).setSystemUiVisibility(1280);
        r106.addFlags(Integer.MIN_VALUE);
        r106.setStatusBarColor(0);
        int r107 = DevicesUtil.d(this);
        View r108 = new View(this);
        r108.setLayoutParams(new LinearLayout.LayoutParams(-1, r107));
        r108.setBackgroundColor(r105);
        ((ViewGroup) x94.a.a(getWindow())).addView(r108);
        ViewGroup r109 = (ViewGroup) ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
        int r110 = r109.getPaddingTop();
        if (r109 == null) goto L21;
        r109.setPadding(r109.getPaddingLeft(), r110 + DevicesUtil.d(this), r109.getPaddingRight(), r109.getPaddingBottom());
        r108.setVisibility(0);
    L21:
        if (getIntent() == null) goto L28;
        this.f200807j = getIntent().getStringExtra("name");
        this.f200806i = getIntent().getStringExtra("address");
        this.f200809l = Double.valueOf(getIntent().getDoubleExtra("latitude", AudioStats.AUDIO_AMPLITUDE_NONE));
        this.f200808k = Double.valueOf(getIntent().getDoubleExtra("longitude", AudioStats.AUDIO_AMPLITUDE_NONE));
        int r111 = getIntent().getIntExtra("scale", 18);
        this.f200816s = r111;
        if (r111 < 18) goto L26;
        this.f200816s = 18;
        goto L28
    L26:
        if (r111 > 5) goto L28;
        this.f200816s = 5;
    L28:
        this.f200798a = findViewById(R.id.bdpapp_m_map_close);
        this.f200799b = (ImageView) findViewById(R.id.bdpapp_m_map_location);
        this.f200800c = (ImageView) findViewById(R.id.bdpapp_m_map_nav);
        this.f200801d = (TextView) findViewById(R.id.bdpapp_m_map_name);
        this.f200802e = (TextView) findViewById(R.id.bdpapp_m_map_address);
        this.f200803f = (TextView) findViewById(R.id.bdpapp_m_map_position);
        o.d(this.f200801d, 8);
        o.d(this.f200802e, 8);
        o.d(this.f200803f, 0);
        this.f200803f.setText(getResources().getString(R.string.bdpapp_m_location));
        this.f200798a.setOnClickListener(new t94.f(this));
        this.f200799b.setOnClickListener(new g(this));
        this.f200799b.setOnTouchListener(this.f200818u);
        this.f200800c.setOnClickListener(new h(this));
        LinkedHashSet<String> r112 = new LinkedHashSet();
        r112.add("android.permission.ACCESS_COARSE_LOCATION");
        r112.add("android.permission.ACCESS_FINE_LOCATION");
        ((BdpPermissionService) BdpManager.getInst().getService(BdpPermissionService.class)).requestPermissions(this, r112, new e(this), "bpea-miniapp_BdpMacActivity_permission");
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onSaveInstanceState(Bundle r100) {
        super.onSaveInstanceState(r100);
        this.f200817t.onSaveInstanceState(r100);
    }

    public final void y1(BdpLatLng r100) {
        this.f200817t.moveCameraToLatLng(r100);
        this.f200817t.addMarker(new BdpMarkerOptions().position(r100).icon(BitmapFactory.decodeResource(getResources(), R.drawable.bdpapp_m_map_destinaion)));
    }

    @Override // com.bytedance.bdp.service.plug.map.model.BdpMap.GeocoderSearchedListener
    public final void onGeocoderSearchedListener(boolean r100, BdpLatLng r101) {
        if (r100 == true) goto L4;
        return;
    L4:
        this.f200809l = Double.valueOf(r101.latitude);
        this.f200808k = Double.valueOf(r101.longitude);
        BdpLatLng r102 = new BdpLatLng(this.f200809l.doubleValue(), this.f200808k.doubleValue());
        this.f200812o = r102;
        y1(r102);
    }

    @Override // com.bytedance.bdp.service.plug.map.model.BdpMap.RegeocodeSearchedListener
    public final void onRegeocodeSearchedListener(boolean r100, String r101, String r102) {
        if (r100 == true) goto L4;
        return;
    L4:
        this.f200801d.setText(r101);
        this.f200802e.setText(r102);
        o.d(this.f200801d, 0);
        o.d(this.f200802e, 0);
        o.d(this.f200803f, 8);
    }
}
