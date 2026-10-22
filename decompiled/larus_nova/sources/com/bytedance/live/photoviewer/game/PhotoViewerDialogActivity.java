package com.bytedance.live.photoviewer.game;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.live.photoviewer.photoviewer.PhotoViewerAdapter;
import com.bytedance.live.photoviewer.photoviewer.PhotoViewerListener;
import com.bytedance.live.photoviewer.transition.TransitionPagerAdapter;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ttnet.org.chromium.base.BaseSwitches;
import dc9.d;
import java.lang.ref.SoftReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import v19.f;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/bytedance/live/photoviewer/game/PhotoViewerDialogActivity;", "Landroidx/fragment/app/FragmentActivity;", "Landroid/view/View;", BaseSwitches.V, "", "addOverFlyView", "removeOverFlyView", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "photoviewer_release"}, k = 1, mv = {1, 4, 0})
public final class PhotoViewerDialogActivity extends FragmentActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f255636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f255637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f255638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f255639d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f255640e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f255641f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f255642g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f255643h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c f255644i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f255645j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f255646k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PhotoViewerListener f255647l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TransitionPagerAdapter<?> f255648m;

    public final class a extends OrientationEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f255649a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f255650b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PhotoViewerDialogActivity f255651c;

        @Override // android.view.OrientationEventListener
        public final void onOrientationChanged(int r100) {
            if (r100 >= 0) goto L4;
            return;
        L4:
            if (r100 >= 360) goto L36;
            int r101 = this.f255649a;
            if (r100 > (360 - r101)) goto L27;
            if (r100 < r101) goto L27;
            if (r100 <= (90 - r101)) goto L16;
            if (r100 >= (r101 + 90)) goto L16;
            int r102 = 8;
        L26:
            Integer r103 = Integer.valueOf(r102);
        L28:
            int r104 = r103.intValue();
            if (this.f255650b != r104) goto L31;
            return;
        L31:
            if (r104 == (-1)) goto L35;
            this.f255650b = r104;
            this.f255651c.setRequestedOrientation(r104);
            return;
        L35:
            return;
        L16:
            if (r100 <= (180 - r101)) goto L21;
            if (r100 >= (r101 + 180)) goto L21;
            r102 = 9;
        L21:
            if (r100 > (270 - r101)) goto L23;
        L25:
            r102 = -1;
            goto L26
        L23:
            if (r100 >= (r101 + 270)) goto L25;
            r102 = 0;
        L27:
            r103 = 1;
            goto L28
        }

        public a(PhotoViewerDialogActivity r100, Context r101) {
            this.f255651c = r100;
            super(r101);
            this.f255649a = 10;
            this.f255650b = -1;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoViewerDialogActivity f255652a;

        public b(PhotoViewerDialogActivity r100) {
            this.f255652a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f255652a.finish();
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoViewerDialogActivity f255653a;

        public c(PhotoViewerDialogActivity r100) {
            this.f255653a = r100;
        }

        public final void a(int r100) {
            if (r100 == (-1)) goto L26;
            PhotoViewerDialogActivity r101 = this.f255653a;
            if (r100 > (r101.f255646k - 1)) goto L28;
            r101.z1(r100);
            TransitionPagerAdapter<?> r102 = this.f255653a.f255648m;
            if (r102 != null) goto L10;
        L18:
            TextView r103 = this.f255653a.f255641f;
            if (r103 != null) goto L21;
            Intrinsics.throwUninitializedPropertyAccessException("mTvTitle");
        L21:
            r103.setVisibility(8);
            TextView r104 = this.f255653a.f255642g;
            if (r104 != null) goto L24;
            Intrinsics.throwUninitializedPropertyAccessException("mTvPosition");
        L24:
            r104.setVisibility(0);
            return;
        L10:
            if (r102.getItemViewType(r100) != 2) goto L18;
            TextView r105 = this.f255653a.f255641f;
            if (r105 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("mTvTitle");
        L14:
            r105.setVisibility(0);
            TextView r106 = this.f255653a.f255642g;
            if (r106 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("mTvPosition");
        L17:
            r106.setVisibility(8);
            return;
        L28:
            return;
        }
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(PhotoViewerDialogActivity.class.getName()));
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
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
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
    public final void onDestroy() {
        super.onDestroy();
        PhotoViewerListener r100 = this.f255647l;
        if (r100 == null) goto L9;
        TransitionPagerAdapter<?> r101 = this.f255648m;
        if (r101 == null) goto L8;
        PhotoViewerAdapter r102 = (PhotoViewerAdapter) r101;
        r100.onDestroy(0);
        goto L9
    L8:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.live.photoviewer.photoviewer.PhotoViewerAdapter");
    L9:
        TransitionPagerAdapter<?> r103 = this.f255648m;
        if (r103 == null) goto L13;
        r103.onDestroy();
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        a r100 = this.f255643h;
        if (r100 == null) goto L6;
        r100.disable();
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        y1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public PhotoViewerDialogActivity() {
    }

    public static View y1(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public final void addOverFlyView(View r100) {
        ViewGroup r101 = this.f255637b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRootContainer");
    L5:
        r101.addView(r100);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L17
        if (d.a() == true) goto L20;
        int r101 = getRequestedOrientation();     // Catch: Throwable -> L17
        if (r100 == null) goto L8;
        Integer r102 = Integer.valueOf(r100.orientation);     // Catch: Throwable -> L17
    L9:
        if (r102 != null) goto L12;
    L14:
        if (r101 != 3) goto L20;
        setRequestedOrientation(1);     // Catch: Throwable -> L17
        FLogger.f375446a.i("PadLancet", "onConfigurationChanged, phone reset page:PhotoViewerDialogActivity portrait");     // Catch: Throwable -> L17
        goto L20
    L12:
        if (r102.intValue() == r101) goto L20;
    L8:
        r102 = null;
    L20:
        if (r100.orientation != 2) goto L34;
        ImageView r103 = this.f255638c;
        if (r103 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mIvBack");
    L24:
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if (r104 == null) goto L33;
        ConstraintLayout.LayoutParams r105 = (ConstraintLayout.LayoutParams) r104;
        ((ViewGroup.MarginLayoutParams) r105).leftMargin = vj6.b.a(this, 97);
        ImageView r106 = this.f255638c;
        if (r106 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mIvBack");
    L29:
        r106.setLayoutParams(r105);
        TransitionPagerAdapter<?> r107 = this.f255648m;
        if (r107 == null) goto L50;
        r107.y2(r100);
        return;
    L50:
        return;
    L33:
        throw new TypeCastException("null cannot be cast to non-null type android.support.constraint.ConstraintLayout.LayoutParams");
    L34:
        ImageView r108 = this.f255638c;
        if (r108 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mIvBack");
    L37:
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
        if (r109 == null) goto L47;
        ConstraintLayout.LayoutParams r110 = (ConstraintLayout.LayoutParams) r109;
        ((ViewGroup.MarginLayoutParams) r110).leftMargin = vj6.b.a(this, 19);
        ImageView r111 = this.f255638c;
        if (r111 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("mIvBack");
    L42:
        r111.setLayoutParams(r110);
        TransitionPagerAdapter<?> r112 = this.f255648m;
        if (r112 == null) goto L52;
        r112.y2(r100);
        return;
    L52:
        return;
    L47:
        throw new TypeCastException("null cannot be cast to non-null type android.support.constraint.ConstraintLayout.LayoutParams");
    L17:
        th = move-exception;
        FLogger.f375446a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
        goto L20
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
        Window r101 = getWindow();
        if (r101 == null) goto L98;
        Rect r102 = (Rect) getIntent().getParcelableExtra("start_rect");
        Window r103 = getWindow();
        PhotoViewerListener r104 = null;
        if (r103 == null) goto L15;
        View r105 = y1(r103);
    L16:
        if (r105 == null) goto L18;
        r105.setSystemUiVisibility(7942);
    L18:
        int r106 = 0;
        y1(r101).setPadding(0, 0, 0, 0);
        r101.setLayout(-1, -1);
        r101.setBackgroundDrawable(new ColorDrawable(0));
        r101.setDimAmount(1.0f);
        setContentView(com.larus.nova.R.layout.photo_viewer_dialog);
        this.f255637b = (ViewGroup) findViewById(com.larus.nova.R.id.content_view);
        this.f255638c = (ImageView) findViewById(com.larus.nova.R.id.iv_back);
        View r107 = findViewById(com.larus.nova.R.id.back_click_view);
        this.f255639d = r107;
        if (r107 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mBackClickView");
    L21:
        r107.setOnClickListener(new b(this));
        View r108 = findViewById(com.larus.nova.R.id.cl_top);
        this.f255640e = r108;
        if (r108 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mClTopView");
    L24:
        r108.setVisibility(0);
        this.f255641f = (TextView) findViewById(com.larus.nova.R.id.tv_title);
        this.f255642g = (TextView) findViewById(com.larus.nova.R.id.tv_position);
        ViewGroup r109 = this.f255637b;
        if (r109 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mRootContainer");
    L27:
        r109.setBackgroundColor(getResources().getColor(R.color.black));
        if (r102 == null) goto L33;
        ViewGroup r110 = this.f255637b;
        if (r110 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mRootContainer");
    L32:
        r110.getBackground().setAlpha(0);
    L37:
        RecyclerView r111 = new RecyclerView(this);
        r111.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f255636a = r111;
        final LinearLayoutManager r112 = new LinearLayoutManager(this);
        RecyclerView r113 = this.f255636a;
        if (r113 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L40:
        r112.setOrientation(0);
        r113.setLayoutManager(r112);
        PagerSnapHelper r114 = new PagerSnapHelper();
        RecyclerView r115 = this.f255636a;
        if (r115 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L43:
        r114.attachToRecyclerView(r115);
        ViewGroup r116 = this.f255637b;
        if (r116 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("mRootContainer");
    L46:
        RecyclerView r117 = this.f255636a;
        if (r117 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L49:
        r116.addView(r117, 0);
        RecyclerView r118 = this.f255636a;
        if (r118 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L52:
        r118.addOnScrollListener(new AnonymousClass4(this, r112));
        SoftReference<PhotoViewerListener> r119 = vj6.c.f555419a;
        if (r119 == null) goto L55;
        r104 = r119.get();
    L55:
        this.f255647l = r104;
        PhotoViewerAdapter r120 = new PhotoViewerAdapter(this, getIntent().getParcelableArrayListExtra("model_list"), this.f255647l);     // Catch: Exception -> L92
        this.f255648m = r120;     // Catch: Exception -> L92
        RecyclerView r121 = this.f255636a;     // Catch: Exception -> L92
        if (r121 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");     // Catch: Exception -> L92
    L59:
        r121.setAdapter(r120);     // Catch: Exception -> L92
        TransitionPagerAdapter<?> r122 = this.f255648m;     // Catch: Exception -> L92
        if (r122 == null) goto L62;
        r122.f255717d = new vj6.a(this);     // Catch: Exception -> L92
    L62:
        this.f255645j = getIntent().getIntExtra("position", 0);     // Catch: Exception -> L92
        this.f255646k = getIntent().getIntExtra("total", 0);     // Catch: Exception -> L92
        String r123 = getIntent().getStringExtra("title");     // Catch: Exception -> L92
        TextView r124 = this.f255641f;     // Catch: Exception -> L92
        if (r124 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("mTvTitle");     // Catch: Exception -> L92
    L65:
        r124.setText(r123);     // Catch: Exception -> L92
        z1(this.f255645j);     // Catch: Exception -> L92
        boolean r125 = getIntent().getBooleanExtra(AppConstants.BUNDLE_SHOW_BACK, true);     // Catch: Exception -> L92
        ImageView r126 = this.f255638c;     // Catch: Exception -> L92
        if (r126 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("mIvBack");     // Catch: Exception -> L92
    L68:
        if (r125 == true) goto L71;
        r106 = 4;
    L71:
        r126.setVisibility(r106);     // Catch: Exception -> L92
        RecyclerView r127 = this.f255636a;     // Catch: Exception -> L92
        if (r127 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");     // Catch: Exception -> L92
    L74:
        r127.scrollToPosition(this.f255645j);     // Catch: Exception -> L92
        if (r102 == null) goto L82;
        TransitionPagerAdapter<?> r128 = this.f255648m;     // Catch: Exception -> L92
        if (r128 == null) goto L88;
        int r129 = this.f255645j;     // Catch: Exception -> L92
        if (r129 >= r128.getItemCount()) goto L88;
        r128.f255714a = true;     // Catch: Exception -> L92
        r128.f255715b = Integer.valueOf(r129);     // Catch: Exception -> L92
        r128.f255716c = r102;     // Catch: Exception -> L92
    L88:
        a r130 = new a(this, this);     // Catch: Exception -> L92
        this.f255643h = r130;     // Catch: Exception -> L92
        r130.enable();     // Catch: Exception -> L92
        this.f255644i = new c(this);     // Catch: Exception -> L92
        PhotoViewerListener r131 = this.f255647l;
        if (r131 == null) goto L99;
        r131.onShow(this, y1(r101));
        return;
    L99:
        return;
    L82:
        int r132 = this.f255645j;     // Catch: Exception -> L92
        c r133 = this.f255644i;     // Catch: Exception -> L92
        if (r133 == null) goto L85;
        r133.a(r132);     // Catch: Exception -> L92
    L85:
        PhotoViewerListener r134 = this.f255647l;     // Catch: Exception -> L92
        if (r134 == null) goto L88;
        r134.onPageSelected(r132);     // Catch: Exception -> L92
    L92:
        finish();
        return;
    L33:
        ViewGroup r135 = this.f255637b;
        if (r135 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mRootContainer");
    L36:
        r135.getBackground().setAlpha(255);
        goto L37
    L15:
        r105 = null;
        goto L16
    }

    public final void removeOverFlyView(View r100) {
        ViewGroup r101 = this.f255637b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRootContainer");
    L5:
        r101.removeView(r100);
    }

    public final void z1(int r100) {
        TextView r101 = this.f255642g;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTvPosition");
    L5:
        r101.setText((r100 + 1) + " / " + this.f255646k);
    }
}
