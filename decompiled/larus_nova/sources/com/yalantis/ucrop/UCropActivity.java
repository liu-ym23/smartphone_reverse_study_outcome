package com.yalantis.ucrop;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.yalantis.ucrop.model.AspectRatio;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.OverlayView;
import com.yalantis.ucrop.view.TransformImageView;
import com.yalantis.ucrop.view.UCropView;
import com.yalantis.ucrop.view.widget.AspectRatioTextView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import rqc.d;
import rqc.e;
import rqc.g;
import v19.f;
import vqc.h;

/* JADX INFO: loaded from: classes41.dex */
public class UCropActivity extends FlowCommonAppCompatActivity {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final Bitmap.CompressFormat f464372J = null;
    public TextView A;
    public TextView B;
    public View C;
    public AutoTransition D;
    public Bitmap.CompressFormat E;
    public int F;
    public int[] G;
    public final a H;
    public final b I;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f464373g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f464374h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f464375i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f464376j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f464377k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f464378l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f464379m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f464380n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f464381o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f464382p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public UCropView f464383q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public GestureCropImageView f464384r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public OverlayView f464385s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ViewGroup f464386t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ViewGroup f464387u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ViewGroup f464388v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ViewGroup f464389w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ViewGroup f464390x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ViewGroup f464391y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final List<ViewGroup> f464392z;

    @Retention(RetentionPolicy.SOURCE)
    public @interface GestureTypes {
    }

    public class a implements TransformImageView.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UCropActivity f464393a;

        @Override // com.yalantis.ucrop.view.TransformImageView.b
        public final void a() {
            this.f464393a.f464383q.animate().alpha(1.0f).setDuration(300).setInterpolator(new AccelerateInterpolator());
            this.f464393a.C.setClickable(false);
            UCropActivity r100 = this.f464393a;
            r100.f464382p = false;
            r100.supportInvalidateOptionsMenu();
        }

        public a(UCropActivity r100) {
            this.f464393a = r100;
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.b
        public final void b(Exception r100) {
            this.f464393a.O1(r100);
            this.f464393a.finish();
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.b
        public final void c(float r100) {
            TextView r101 = this.f464393a.B;
            if (r101 == null) goto L6;
            r101.setText(String.format(Locale.getDefault(), "%d%%", new Object[]{Integer.valueOf((int) (r100 * 100.0f))}));
            return;
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.b
        public final void d(float r100) {
            TextView r101 = this.f464393a.A;
            if (r101 == null) goto L6;
            r101.setText(String.format(Locale.getDefault(), "%.1f°", new Object[]{Float.valueOf(r100)}));
            return;
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UCropActivity f464394a;

        public b(UCropActivity r100) {
            this.f464394a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (r100.isSelected() == true) goto L6;
            UCropActivity r101 = this.f464394a;
            int r102 = r100.getId();
            Bitmap.CompressFormat r103 = UCropActivity.f464372J;
            r101.P1(r102);
            return;
        }
    }

    static {
        f464372J = Bitmap.CompressFormat.JPEG;
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
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

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
    }

    public UCropActivity() {
        this.f464382p = true;
        this.f464392z = new ArrayList();
        this.E = f464372J;
        this.F = 90;
        this.G = new int[]{1, 2, 3};
        this.H = new a(this);
        this.I = new b(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        GestureCropImageView r100 = this.f464384r;
        if (r100 == null) goto L6;
        r100.s();
    L6:
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L17;
        View r101 = getWindow().getDecorView();     // Catch: Throwable -> L14
        if (c.f346345e == false) goto L12;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L14
        Thread r102 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L14
        if (r102 == c.f346341a) goto L12;
        c.a(r102, "getDecorView");     // Catch: Throwable -> L14
    L12:
        r101.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L14
        return;
    L18:
        return;
    }

    public final void N1(int r100) {
        GestureCropImageView r101 = this.f464384r;
        int r102 = this.G[r100];
        boolean r103 = false;
        if (r102 == 3) goto L7;
        if (r102 == 1) goto L7;
        boolean r104 = false;
    L8:
        r101.setScaleEnabled(r104);
        GestureCropImageView r105 = this.f464384r;
        int r106 = this.G[r100];
        if (r106 != 3) goto L11;
    L12:
        r103 = true;
    L13:
        r105.setRotateEnabled(r103);
        return;
    L11:
        if (r106 != 2) goto L13;
    L7:
        r104 = true;
        goto L8
    }

    public final void O1(Throwable r100) {
        setResult(96, new Intent().putExtra("com.yalantis.ucrop.Error", r100));
    }

    public final void P1(int r100) {
        if (this.f464381o == true) goto L5;
        return;
    L5:
        ViewGroup r101 = this.f464386t;
        if (r100 != com.larus.nova.R.id.state_aspect_ratio) goto L8;
        boolean r102 = true;
    L9:
        r101.setSelected(r102);
        ViewGroup r103 = this.f464387u;
        if (r100 != com.larus.nova.R.id.state_rotate) goto L12;
        boolean r104 = true;
    L13:
        r103.setSelected(r104);
        ViewGroup r105 = this.f464388v;
        if (r100 != com.larus.nova.R.id.state_scale) goto L16;
        boolean r106 = true;
    L17:
        r105.setSelected(r106);
        ViewGroup r107 = this.f464389w;
        int r108 = 8;
        if (r100 != com.larus.nova.R.id.state_aspect_ratio) goto L20;
        int r109 = 0;
    L21:
        r107.setVisibility(r109);
        ViewGroup r110 = this.f464390x;
        if (r100 != com.larus.nova.R.id.state_rotate) goto L24;
        int r111 = 0;
    L25:
        r110.setVisibility(r111);
        ViewGroup r112 = this.f464391y;
        if (r100 != com.larus.nova.R.id.state_scale) goto L28;
        int r113 = 0;
    L29:
        r112.setVisibility(r113);
        TransitionManager.beginDelayedTransition((ViewGroup) findViewById(com.larus.nova.R.id.ucrop_photobox), this.D);
        View r114 = this.f464388v.findViewById(com.larus.nova.R.id.text_view_scale);
        if (r100 != com.larus.nova.R.id.state_scale) goto L32;
        int r115 = 0;
    L33:
        r114.setVisibility(r115);
        View r116 = this.f464386t.findViewById(com.larus.nova.R.id.text_view_crop);
        if (r100 != com.larus.nova.R.id.state_aspect_ratio) goto L36;
        int r117 = 0;
    L37:
        r116.setVisibility(r117);
        View r118 = this.f464387u.findViewById(com.larus.nova.R.id.text_view_rotate);
        if (r100 != com.larus.nova.R.id.state_rotate) goto L40;
        r108 = 0;
    L40:
        r118.setVisibility(r108);
        if (r100 != com.larus.nova.R.id.state_scale) goto L43;
        N1(0);
        return;
    L43:
        if (r100 != com.larus.nova.R.id.state_rotate) goto L45;
        N1(1);
        return;
    L45:
        N1(2);
        return;
    L36:
        r117 = 8;
        goto L37
    L32:
        r115 = 8;
        goto L33
    L28:
        r113 = 8;
        goto L29
    L24:
        r111 = 8;
        goto L25
    L20:
        r109 = 8;
        goto L21
    L16:
        r106 = false;
        goto L17
    L12:
        r104 = false;
        goto L13
    L8:
        r102 = false;
        goto L9
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r110) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L7;
        f.a(getTheme());     // Catch: Throwable -> L10
    L7:
        if (f.f(this) == false) goto L11;
        f.c(getTheme());     // Catch: Throwable -> L10
    L11:
        super.onCreate(r110);
        setContentView(com.larus.nova.R.layout.ucrop_activity_photobox);
        Intent r100 = getIntent();
        this.f464374h = r100.getIntExtra("com.yalantis.ucrop.ToolbarColor", ContextCompat.getColor(this, v19.c.b(com.larus.nova.R.attr.larus_base_1, this, com.larus.nova.R.color.larus_base_1)));
        this.f464375i = r100.getIntExtra("com.yalantis.ucrop.UcropColorControlsWidgetActive", ContextCompat.getColor(this, v19.c.b(com.larus.nova.R.attr.larus_primary_50, this, com.larus.nova.R.color.larus_primary_50)));
        this.f464376j = r100.getIntExtra("com.yalantis.ucrop.UcropToolbarWidgetColor", ContextCompat.getColor(this, v19.c.b(com.larus.nova.R.attr.larus_neutral_100, this, com.larus.nova.R.color.larus_neutral_100)));
        this.f464378l = r100.getIntExtra("com.yalantis.ucrop.UcropToolbarCancelDrawable", com.larus.nova.R.drawable.ucrop_ic_cross);
        this.f464379m = r100.getIntExtra("com.yalantis.ucrop.UcropToolbarCropDrawable", com.larus.nova.R.drawable.ucrop_ic_done);
        String r101 = r100.getStringExtra("com.yalantis.ucrop.UcropToolbarTitleText");
        this.f464373g = r101;
        if (r101 != null) goto L15;
        r101 = getResources().getString(com.larus.nova.R.string.ucrop_label_edit_photo);
    L15:
        this.f464373g = r101;
        this.f464380n = r100.getIntExtra("com.yalantis.ucrop.UcropLogoColor", ContextCompat.getColor(this, com.larus.nova.R.color.ucrop_color_default_logo));
        this.f464381o = !r100.getBooleanExtra("com.yalantis.ucrop.HideBottomControls", false);
        this.f464377k = r100.getIntExtra("com.yalantis.ucrop.UcropRootViewBackgroundColor", ContextCompat.getColor(this, v19.c.b(com.larus.nova.R.attr.larus_neutral_100, this, com.larus.nova.R.color.larus_neutral_100)));
        Toolbar r102 = (Toolbar) findViewById(com.larus.nova.R.id.toolbar);
        r102.setBackgroundColor(this.f464374h);
        r102.setTitleTextColor(this.f464376j);
        TextView r103 = (TextView) r102.findViewById(com.larus.nova.R.id.toolbar_title);
        r103.setTextColor(this.f464376j);
        r103.setText(this.f464373g);
        Drawable r104 = ContextCompat.getDrawable(this, this.f464378l).mutate();
        r104.setColorFilter(this.f464376j, PorterDuff.Mode.SRC_ATOP);
        r102.setNavigationIcon(r104);
        setSupportActionBar(r102);
        ActionBar r105 = getSupportActionBar();
        if (r105 == null) goto L18;
        r105.setDisplayShowTitleEnabled(false);
    L18:
        UCropView r106 = (UCropView) findViewById(com.larus.nova.R.id.ucrop);
        this.f464383q = r106;
        this.f464384r = r106.getCropImageView();
        this.f464385s = this.f464383q.getOverlayView();
        this.f464384r.setTransformImageListener(this.H);
        ((ImageView) findViewById(com.larus.nova.R.id.image_view_logo)).setColorFilter(this.f464380n, PorterDuff.Mode.SRC_ATOP);
        findViewById(com.larus.nova.R.id.ucrop_frame).setBackgroundColor(this.f464377k);
        if (this.f464381o == true) goto L21;
        ((RelativeLayout.LayoutParams) findViewById(com.larus.nova.R.id.ucrop_frame).getLayoutParams()).bottomMargin = 0;
        findViewById(com.larus.nova.R.id.ucrop_frame).requestLayout();
    L21:
        ViewGroup r107 = null;
        float r111 = 0.0f;
        if (this.f464381o == false) goto L43;
        ViewGroup r108 = (ViewGroup) ((ViewGroup) findViewById(com.larus.nova.R.id.ucrop_photobox)).findViewById(com.larus.nova.R.id.controls_wrapper);
        r108.setVisibility(0);
        LayoutInflater.from(this).inflate(com.larus.nova.R.layout.ucrop_controls, r108, true);
        AutoTransition r109 = new AutoTransition();
        this.D = r109;
        r109.setDuration(50);
        ViewGroup r112 = (ViewGroup) findViewById(com.larus.nova.R.id.state_aspect_ratio);
        this.f464386t = r112;
        r112.setOnClickListener(this.I);
        ViewGroup r113 = (ViewGroup) findViewById(com.larus.nova.R.id.state_rotate);
        this.f464387u = r113;
        r113.setOnClickListener(this.I);
        ViewGroup r114 = (ViewGroup) findViewById(com.larus.nova.R.id.state_scale);
        this.f464388v = r114;
        r114.setOnClickListener(this.I);
        this.f464389w = (ViewGroup) findViewById(com.larus.nova.R.id.layout_aspect_ratio);
        this.f464390x = (ViewGroup) findViewById(com.larus.nova.R.id.layout_rotate_wheel);
        this.f464391y = (ViewGroup) findViewById(com.larus.nova.R.id.layout_scale_wheel);
        int r115 = r100.getIntExtra("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
        ArrayList r116 = r100.getParcelableArrayListExtra("com.yalantis.ucrop.AspectRatioOptions");
        if (r116 != null) goto L26;
    L27:
        r116 = new ArrayList();
        r116.add(new AspectRatio(null, 1.0f, 1.0f));
        r116.add(new AspectRatio(null, 3.0f, 4.0f));
        r116.add(new AspectRatio(getString(com.larus.nova.R.string.ucrop_label_original).toUpperCase(), 0.0f, 0.0f));
        r116.add(new AspectRatio(null, 3.0f, 2.0f));
        r116.add(new AspectRatio(null, 16.0f, 9.0f));
        r115 = 2;
    L28:
        LinearLayout r117 = (LinearLayout) findViewById(com.larus.nova.R.id.layout_aspect_ratio);
        LinearLayout.LayoutParams r118 = new LinearLayout.LayoutParams(0, -1);
        r118.weight = 1.0f;
        Iterator r119 = r116.iterator();
    L30:
        if (r119.hasNext() == false) goto L32;
        AspectRatio r120 = (AspectRatio) r119.next();
        FrameLayout r121 = (FrameLayout) getLayoutInflater().inflate(com.larus.nova.R.layout.ucrop_aspect_ratio, r107);
        r121.setLayoutParams(r118);
        AspectRatioTextView r122 = (AspectRatioTextView) r121.getChildAt(0);
        r122.setActiveColor(this.f464375i);
        r122.setAspectRatio(r120);
        r117.addView(r121);
        ((ArrayList) this.f464392z).add(r121);
        r107 = null;
        goto L30
    L32:
        ((ViewGroup) ListProtector.get(this.f464392z, r115)).setSelected(true);
        Iterator r123 = ((ArrayList) this.f464392z).iterator();
    L34:
        if (r123.hasNext() == false) goto L36;
        ((ViewGroup) r123.next()).setOnClickListener(new rqc.b(this));
        goto L34
    L36:
        this.A = (TextView) findViewById(com.larus.nova.R.id.text_view_rotate);
        ((HorizontalProgressWheelView) findViewById(com.larus.nova.R.id.rotate_scroll_wheel)).setScrollingListener(new rqc.c(this));
        ((HorizontalProgressWheelView) findViewById(com.larus.nova.R.id.rotate_scroll_wheel)).setMiddleLineColor(this.f464375i);
        findViewById(com.larus.nova.R.id.wrapper_reset_rotate).setOnClickListener(new d(this));
        findViewById(com.larus.nova.R.id.wrapper_rotate_by_angle).setOnClickListener(new e(this));
        int r124 = this.f464375i;
        TextView r125 = this.A;
        if (r125 == null) goto L39;
        r125.setTextColor(r124);
    L39:
        this.B = (TextView) findViewById(com.larus.nova.R.id.text_view_scale);
        ((HorizontalProgressWheelView) findViewById(com.larus.nova.R.id.scale_scroll_wheel)).setScrollingListener(new rqc.f(this));
        ((HorizontalProgressWheelView) findViewById(com.larus.nova.R.id.scale_scroll_wheel)).setMiddleLineColor(this.f464375i);
        int r126 = this.f464375i;
        TextView r127 = this.B;
        if (r127 == null) goto L42;
        r127.setTextColor(r126);
    L42:
        ImageView r128 = (ImageView) findViewById(com.larus.nova.R.id.image_view_state_scale);
        ImageView r129 = (ImageView) findViewById(com.larus.nova.R.id.image_view_state_rotate);
        ImageView r130 = (ImageView) findViewById(com.larus.nova.R.id.image_view_state_aspect_ratio);
        r128.setImageDrawable(new h(r128.getDrawable(), this.f464375i));
        r129.setImageDrawable(new h(r129.getDrawable(), this.f464375i));
        r130.setImageDrawable(new h(r130.getDrawable(), this.f464375i));
        goto L43
    L26:
        if (r116.isEmpty() == false) goto L28;
    L43:
        Uri r131 = (Uri) r100.getParcelableExtra("com.yalantis.ucrop.InputUri");
        Uri r132 = (Uri) r100.getParcelableExtra("com.yalantis.ucrop.OutputUri");
        String r133 = r100.getStringExtra("com.yalantis.ucrop.CompressionFormatName");
        if (TextUtils.isEmpty(r133) == true) goto L46;
        Bitmap.CompressFormat r134 = Bitmap.CompressFormat.valueOf(r133);
    L47:
        if (r134 != null) goto L49;
        r134 = f464372J;
    L49:
        this.E = r134;
        this.F = r100.getIntExtra("com.yalantis.ucrop.CompressionQuality", 90);
        int[] r135 = r100.getIntArrayExtra("com.yalantis.ucrop.AllowedGestures");
        if (r135 != null) goto L52;
    L54:
        this.f464384r.setMaxBitmapSize(r100.getIntExtra("com.yalantis.ucrop.MaxBitmapSize", 0));
        this.f464384r.setMaxScaleMultiplier(r100.getFloatExtra("com.yalantis.ucrop.MaxScaleMultiplier", 10.0f));
        this.f464384r.setImageToWrapCropBoundsAnimDuration(r100.getIntExtra("com.yalantis.ucrop.ImageToCropBoundsAnimDuration", 500));
        this.f464385s.setFreestyleCropEnabled(r100.getBooleanExtra("com.yalantis.ucrop.FreeStyleCrop", false));
        this.f464385s.setDimmedColor(r100.getIntExtra("com.yalantis.ucrop.DimmedLayerColor", getResources().getColor(com.larus.nova.R.color.ucrop_color_default_dimmed)));
        this.f464385s.setCircleDimmedLayer(r100.getBooleanExtra("com.yalantis.ucrop.CircleDimmedLayer", false));
        this.f464385s.setShowCropFrame(r100.getBooleanExtra("com.yalantis.ucrop.ShowCropFrame", true));
        this.f464385s.setCropFrameColor(r100.getIntExtra("com.yalantis.ucrop.CropFrameColor", getResources().getColor(com.larus.nova.R.color.ucrop_color_default_crop_frame)));
        this.f464385s.setCropFrameStrokeWidth(r100.getIntExtra("com.yalantis.ucrop.CropFrameStrokeWidth", getResources().getDimensionPixelSize(com.larus.nova.R.dimen.ucrop_default_crop_frame_stoke_width)));
        this.f464385s.setShowCropGrid(r100.getBooleanExtra("com.yalantis.ucrop.ShowCropGrid", true));
        this.f464385s.setCropGridRowCount(r100.getIntExtra("com.yalantis.ucrop.CropGridRowCount", 2));
        this.f464385s.setCropGridColumnCount(r100.getIntExtra("com.yalantis.ucrop.CropGridColumnCount", 2));
        this.f464385s.setCropGridColor(r100.getIntExtra("com.yalantis.ucrop.CropGridColor", getResources().getColor(com.larus.nova.R.color.ucrop_color_default_crop_grid)));
        this.f464385s.setCropGridCornerColor(r100.getIntExtra("com.yalantis.ucrop.CropGridCornerColor", getResources().getColor(com.larus.nova.R.color.ucrop_color_default_crop_grid)));
        this.f464385s.setCropGridStrokeWidth(r100.getIntExtra("com.yalantis.ucrop.CropGridStrokeWidth", getResources().getDimensionPixelSize(com.larus.nova.R.dimen.ucrop_default_crop_grid_stoke_width)));
        float r136 = r100.getFloatExtra("com.yalantis.ucrop.AspectRatioX", -1.0f);
        float r137 = r100.getFloatExtra("com.yalantis.ucrop.AspectRatioY", -1.0f);
        int r138 = r100.getIntExtra("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
        ArrayList r139 = r100.getParcelableArrayListExtra("com.yalantis.ucrop.AspectRatioOptions");
        if (r136 >= 0.0f) goto L57;
    L66:
        if (r139 != null) goto L68;
    L74:
        this.f464384r.setTargetAspectRatio(0.0f);
    L75:
        int r140 = r100.getIntExtra("com.yalantis.ucrop.MaxSizeX", 0);
        int r141 = r100.getIntExtra("com.yalantis.ucrop.MaxSizeY", 0);
        if (r140 <= 0) goto L79;
        if (r141 <= 0) goto L79;
        this.f464384r.setMaxResultImageSizeX(r140);
        this.f464384r.setMaxResultImageSizeY(r141);
    L79:
        if (r131 == null) goto L85;
        if (r132 == null) goto L85;
        this.f464384r.q(r131, r132);     // Catch: Exception -> L83
    L87:
        if (this.f464381o == true) goto L89;
        N1(0);
    L94:
        if (this.C != null) goto L96;
        this.C = new View(this);
        RelativeLayout.LayoutParams r142 = new RelativeLayout.LayoutParams(-1, -1);
        r142.addRule(3, com.larus.nova.R.id.toolbar);
        this.C.setLayoutParams(r142);
        this.C.setClickable(true);
    L96:
        ((RelativeLayout) findViewById(com.larus.nova.R.id.ucrop_photobox)).addView(this.C);
        return;
    L89:
        if (this.f464386t.getVisibility() != 0) goto L91;
        P1(com.larus.nova.R.id.state_aspect_ratio);
        goto L94
    L91:
        P1(com.larus.nova.R.id.state_scale);
    L83:
        e = move-exception;
        O1(e);
        finish();
    L85:
        O1(new NullPointerException(getString(com.larus.nova.R.string.ucrop_error_input_data_is_absent)));
        finish();
        goto L87
    L68:
        if (r138 >= r139.size()) goto L74;
        float r143 = ((AspectRatio) ListProtector.get(r139, r138)).f464423b / ((AspectRatio) ListProtector.get(r139, r138)).f464424c;
        GestureCropImageView r144 = this.f464384r;
        if (Float.isNaN(r143) == true) goto L73;
        r111 = r143;
    L73:
        r144.setTargetAspectRatio(r111);
        goto L75
    L57:
        if (r137 < 0.0f) goto L66;
        ViewGroup r145 = this.f464386t;
        if (r145 == null) goto L61;
        r145.setVisibility(8);
    L61:
        float r146 = r136 / r137;
        GestureCropImageView r147 = this.f464384r;
        if (Float.isNaN(r146) == true) goto L65;
        r111 = r146;
    L65:
        r147.setTargetAspectRatio(r111);
        goto L75
    L52:
        if (r135.length != 3) goto L54;
        this.G = r135;
        goto L54
    L46:
        r134 = null;
        goto L47
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu r100) {
        getMenuInflater().inflate(com.larus.nova.R.menu.ucrop_menu_activity, r100);
        MenuItem r101 = r100.findItem(com.larus.nova.R.id.menu_loader);
        Drawable r102 = r101.getIcon();
        if (r102 != null) goto L13;
    L9:
        MenuItem r103 = r100.findItem(com.larus.nova.R.id.menu_crop);
        Drawable r104 = ContextCompat.getDrawable(this, this.f464379m);
        if (r104 == null) goto L12;
        r104.mutate();
        r104.setColorFilter(this.f464376j, PorterDuff.Mode.SRC_ATOP);
        r103.setIcon(r104);
    L12:
        return true;
    L13:
        r102.mutate();     // Catch: IllegalStateException -> L6
        r102.setColorFilter(this.f464376j, PorterDuff.Mode.SRC_ATOP);     // Catch: IllegalStateException -> L6
        r101.setIcon(r102);     // Catch: IllegalStateException -> L6
    L8:
        ((Animatable) r101.getIcon()).start();
    L6:
        e = move-exception;
        String.format("%s - %s", new Object[]{e.getMessage(), getString(com.larus.nova.R.string.ucrop_mutate_exception_hint)});
        goto L8
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem r100) {
        if (r100.getItemId() != com.larus.nova.R.id.menu_crop) goto L7;
        this.C.setClickable(true);
        this.f464382p = true;
        supportInvalidateOptionsMenu();
        this.f464384r.t(this.E, this.F, new g(this));
        return true;
    L7:
        if (r100.getItemId() != 16908332) goto L11;
        onBackPressed();
        return true;
    L11:
        return super.onOptionsItemSelected(r100);
    }

    @Override // android.app.Activity
    public final boolean onPrepareOptionsMenu(Menu r100) {
        r100.findItem(com.larus.nova.R.id.menu_crop).setVisible(!this.f464382p);
        r100.findItem(com.larus.nova.R.id.menu_loader).setVisible(this.f464382p);
        return super.onPrepareOptionsMenu(r100);
    }
}
