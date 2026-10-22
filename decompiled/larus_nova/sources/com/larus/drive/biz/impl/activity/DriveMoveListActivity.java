package com.larus.drive.biz.impl.activity;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.drive.biz.impl.databinding.LarusPageDriveMoveListBinding;
import com.larus.drive.biz.impl.view.DriveMoveListFragment;
import com.larus.drive.biz.impl.viewmodel.DriveMoveViewModel;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.i;
import com.larus.utils.logger.FLogger;
import com.larus.utils.u;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import j79.d;
import j79.e;
import j79.g;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.f;
import v19.h;
import v19.i5;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\b\u0010\u0017\u001a\u00020\u0012H\u0002J\b\u0010\u0018\u001a\u00020\u0012H\u0002J\b\u0010\u0019\u001a\u00020\u0012H\u0002J\b\u0010\u001a\u001a\u00020\u0012H\u0002J\b\u0010\u001b\u001a\u00020\u0012H\u0002J\b\u0010\u001c\u001a\u00020\u0012H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/drive/biz/impl/activity/DriveMoveListActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "binding", "Lcom/larus/drive/biz/impl/databinding/LarusPageDriveMoveListBinding;", "viewModel", "Lcom/larus/drive/biz/impl/viewmodel/DriveMoveViewModel;", "hasPlayedEnterAnimation", "", "fileToken", "", "driveObjType", "", "driveToken", "parentFolderToken", "refreshMark", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "setupViewModel", "setupContainer", "setupFragment", "setupObservers", "setupClickListeners", "setupBackNavigationUI", "syncNavigationBarColor", "playEnterAnimation", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveMoveListActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f341043h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LarusPageDriveMoveListBinding f341044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DriveMoveViewModel f341045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f341046c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f341047d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f341048e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f341049f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f341050g;

    public static final class a {
        public static void a(Context r100, String r101, String r102, int r103, String r104, String r105, String r106) {
            Intrinsics.checkNotNullParameter(r101, "fileToken");
            if (r100 != null) goto L5;
            return;
        L5:
            Intent r107 = new Intent(r100, DriveMoveListActivity.class);
            r107.putExtra("arg_file_token", r101);
            r107.putExtra("arg_drive_token", r102);
            r107.putExtra("arg_drive_obj_type", r103);
            r107.putExtra("arg_parent_folder_token", r104);
            r107.putExtra("arg_parent_folder_drive_token", r105);
            r107.putExtra("refresh_mark", r106);
            r100.startActivity(r107);
        }
    }

    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f341051a;

        public b(g r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f341051a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f341051a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f341051a.invoke(r100);
        }
    }

    static {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(DriveMoveListActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    public DriveMoveListActivity() {
        this.f341048e = -1;
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(DriveMoveListActivity.class.getName()));
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

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        y1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static View y1(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    /* JADX WARN: Type inference failed for: r5v17, types: [j79.g] */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r110) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L7;
        f.a(getTheme());     // Catch: Throwable -> L10
    L7:
        if (f.f(this) == false) goto L11;
        f.c(getTheme());     // Catch: Throwable -> L10
    L11:
        f.a(getTheme());
        super.onCreate(r110);
        WindowInsetsControllerCompat r100 = WindowCompat.getInsetsController(getWindow(), y1(getWindow()));
        boolean r101 = h.f552477a;
        boolean r102 = true;
        boolean r103 = !h.a(null);
        r100.setAppearanceLightStatusBars(r103);
        r100.setAppearanceLightNavigationBars(r103);
        int r104 = 0;
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        View r105 = getLayoutInflater().inflate(com.larus.nova.R.layout.larus_page_drive_move_list, null, false);
        int r106 = com.larus.nova.R.id.larus_drive_move_bottom_area;
        FrameLayout r107 = (FrameLayout) ViewBindings.findChildViewById(r105, com.larus.nova.R.id.larus_drive_move_bottom_area);
        if (r107 == null) goto L106;
        r106 = com.larus.nova.R.id.larus_drive_move_confirm_btn;
        TextView r111 = (TextView) ViewBindings.findChildViewById(r105, com.larus.nova.R.id.larus_drive_move_confirm_btn);
        if (r111 == null) goto L106;
        r106 = com.larus.nova.R.id.larus_drive_move_list_container;
        FrameLayout r112 = (FrameLayout) ViewBindings.findChildViewById(r105, com.larus.nova.R.id.larus_drive_move_list_container);
        if (r112 == null) goto L106;
        r106 = com.larus.nova.R.id.larus_drive_move_list_panel;
        ConstraintLayout r113 = (ConstraintLayout) ViewBindings.findChildViewById(r105, com.larus.nova.R.id.larus_drive_move_list_panel);
        if (r113 == null) goto L106;
        r106 = com.larus.nova.R.id.larus_drive_move_list_panel_back_btn;
        ImageView r114 = (ImageView) ViewBindings.findChildViewById(r105, com.larus.nova.R.id.larus_drive_move_list_panel_back_btn);
        if (r114 == null) goto L106;
        r106 = com.larus.nova.R.id.larus_drive_move_list_panel_close_btn;
        ImageView r115 = (ImageView) ViewBindings.findChildViewById(r105, com.larus.nova.R.id.larus_drive_move_list_panel_close_btn);
        if (r115 == null) goto L106;
        r106 = com.larus.nova.R.id.larus_drive_move_list_panel_title_bar;
        ConstraintLayout r116 = (ConstraintLayout) ViewBindings.findChildViewById(r105, com.larus.nova.R.id.larus_drive_move_list_panel_title_bar);
        if (r116 == null) goto L106;
        r106 = com.larus.nova.R.id.larus_drive_move_list_panel_title_text;
        TextView r117 = (TextView) ViewBindings.findChildViewById(r105, com.larus.nova.R.id.larus_drive_move_list_panel_title_text);
        if (r117 == null) goto L106;
        ConstraintLayout r108 = (ConstraintLayout) r105;
        this.f341044a = new LarusPageDriveMoveListBinding(r108, r107, r111, r112, r113, r114, r115, r116, r117);
        if (r108 == null) goto L30;
        int r109 = u.b(this);
        int r118 = r108.getPaddingStart();
        int r119 = r108.getPaddingTop();
        int r120 = r108.getPaddingEnd();
        FLogger.f375446a.i("updatePaddingRelative", "view:" + r108.getClass().getSimpleName() + ",source:,start:" + r118 + ",top:" + r119 + ",end:" + r120 + ",bottom:" + r109);
        r108.setPaddingRelative(r118, r119, r120, r109);
    L30:
        LarusPageDriveMoveListBinding r121 = this.f341044a;
        if (r121 == null) goto L33;
        ConstraintLayout r122 = r121.f341152a;
    L34:
        setContentView(r122);
        String r123 = getIntent().getStringExtra("arg_file_token");
        if (r123 != null) goto L37;
        finish();
        return;
    L37:
        this.f341047d = r123;
        this.f341048e = getIntent().getIntExtra("arg_drive_obj_type", -1);
        String r124 = getIntent().getStringExtra("arg_drive_token");
        if (r124 != null) goto L40;
        finish();
        return;
    L40:
        this.f341049f = r124;
        getIntent().getStringExtra("arg_parent_folder_token");
        this.f341050g = getIntent().getStringExtra("refresh_mark");
        DriveMoveViewModel r125 = (DriveMoveViewModel) new ViewModelProvider(this).get(DriveMoveViewModel.class);
        this.f341045b = r125;
        if (r125 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r125 = null;
    L43:
        r125.getSelectedFolder().observe(this, new b(new g(this)));
        LarusPageDriveMoveListBinding r126 = this.f341044a;
        if (r126 == null) goto L53;
        FrameLayout r127 = r126.f341155d;
        if (r127 == null) goto L53;
        int r128 = RangesKt.coerceAtLeast((int) (((i.b(this) * 0.9f) - i5.l0()) - i5.h0()), 0);
        ViewGroup.LayoutParams r129 = r127.getLayoutParams();
        if ((r129 instanceof ConstraintLayout.LayoutParams) == false) goto L50;
        ConstraintLayout.LayoutParams r130 = (ConstraintLayout.LayoutParams) r129;
    L51:
        if (r130 == null) goto L53;
        ((ViewGroup.MarginLayoutParams) r130).height = r128;
        r127.setLayoutParams(r130);
        r127.requestLayout();
        goto L53
    L50:
        r130 = null;
    L53:
        LarusPageDriveMoveListBinding r131 = this.f341044a;
        if (r131 == null) goto L76;
        FrameLayout r132 = r131.f341155d;
        if (r132 == null) goto L76;
        int r133 = r132.getId();
        if (getSupportFragmentManager().findFragmentById(r133) != null) goto L76;
        int r134 = DriveMoveListFragment.H;
        DriveMoveListFragment r135 = DriveMoveListFragment.a.a(r133, null, null, null, true, this.f341049f);
        FragmentTransaction r136 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r136, r135, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r133) == true) goto L64;
        r136.replace(r133, r135);
    L64:
        r136.commit();
        getSupportFragmentManager().addOnBackStackChangedListener(new j79.h(this));
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) goto L68;
        r102 = false;
    L68:
        LarusPageDriveMoveListBinding r137 = this.f341044a;
        if (r137 == null) goto L76;
        ImageView r138 = r137.f341157f;
        if (r138 == null) goto L76;
        if (r102 == true) goto L75;
        r104 = 4;
    L75:
        r138.setVisibility(r104);
    L76:
        LarusPageDriveMoveListBinding r139 = this.f341044a;
        if (r139 == null) goto L81;
        ConstraintLayout r140 = r139.f341152a;
        if (r140 == null) goto L81;
        r140.setOnClickListener(new j79.b(this));
    L81:
        LarusPageDriveMoveListBinding r141 = this.f341044a;
        if (r141 == null) goto L86;
        ImageView r142 = r141.f341158g;
        if (r142 == null) goto L86;
        r142.setOnClickListener(new j79.c(this));
    L86:
        LarusPageDriveMoveListBinding r143 = this.f341044a;
        if (r143 == null) goto L91;
        ImageView r144 = r143.f341157f;
        if (r144 == null) goto L91;
        r144.setOnClickListener(new d(this));
    L91:
        LarusPageDriveMoveListBinding r145 = this.f341044a;
        if (r145 == null) goto L96;
        TextView r146 = r145.f341154c;
        if (r146 == null) goto L96;
        r146.setOnClickListener(new e(this));
    L96:
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, v19.c.b(com.larus.nova.R.attr.larus_base_2, this, com.larus.nova.R.color.larus_base_2)));
        if (this.f341046c == true) goto L113;
        LarusPageDriveMoveListBinding r147 = this.f341044a;
        if (r147 == null) goto L111;
        ConstraintLayout r148 = r147.f341152a;
        if (r148 == null) goto L112;
        r148.post(new j79.f(this));
        return;
    L112:
        return;
    L111:
        return;
    L113:
        return;
    L33:
        r122 = null;
    L106:
        throw new NullPointerException("Missing required view with ID: ".concat(r105.getResources().getResourceName(r106)));
    }
}
