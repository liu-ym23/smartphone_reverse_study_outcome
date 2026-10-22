package com.larus.common_ui.activity;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Pair;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.Window;
import androidx.activity.result.ActivityResultCaller;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import b19.b;
import b19.c;
import b19.d;
import b19.e;
import com.bytedance.android.anniex.container.AnnieXHostActivity;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.avatar.impl.scan.ScanCameraActivity;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dbx.theme.DbxTheme;
import com.larus.home.impl.MainActivity;
import com.larus.platform.service.g0;
import com.larus.platform.service.r1;
import com.larus.platform.service.z2;
import com.larus.utils.i;
import com.larus.utils.logger.FLogger;
import com.larus.utils.u;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.a7;
import v19.f;
import v19.h;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 A2\u00020\u0001:\u0001AB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0016\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0018\u00010\u0014R\u00020\u0015H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\rH\u0002J\u0012\u0010\u001a\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u000fH\u0014J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\rH\u0002J\b\u0010%\u001a\u00020\u000fH\u0002J\b\u0010&\u001a\u00020\u0005H\u0016J\b\u0010'\u001a\u00020\u0005H\u0016J\b\u0010(\u001a\u00020\u0017H\u0016J\b\u0010)\u001a\u00020\u0005H\u0016J\u0010\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u0005H\u0016J\u0006\u0010,\u001a\u00020\u0005J\u0014\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170.H\u0016J\u0010\u00102\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\u0005H\u0002J\u0010\u00104\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u0005H\u0014J\u0012\u00106\u001a\u00020\u000f2\b\b\u0001\u00107\u001a\u00020\u0017H\u0016J\b\u00108\u001a\u00020\u000fH\u0016J\"\u00109\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020\u00172\u0006\u0010;\u001a\u00020\u00172\b\u0010<\u001a\u0004\u0018\u00010=H\u0014J\u0010\u0010>\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020\u001cH\u0014J\b\u0010@\u001a\u00020\u000fH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0012\u0010/\u001a\u00020\u00178\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "mIsFromFlowPush", "", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "getCurrentPageName", "", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "setTheme", "theme", "Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", "resId", "", "applyTheme", "tag", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "isDecorCaptionViewCrash", "t", "", "phoneWindowMethod", "resumeCallActivity", "needAdaptStatusBarPadding", "needAdaptNavigationBarPadding", "getBackgroundResource", "needAdaptNavigationBarPaddingWhenIme", "getNavigationBarPaddingOnWindowInsets", "imeVisible", "isFromFlowPush", "getFloatViewRestriction", "Landroid/util/Pair;", "hookBackGroundColorInt", "lastUiMode", "isBackgroundColorOverridden", "syncNightModeUiState", "force", "applyNavigationBarStyle", "isNightMode", "disableToSetBackgroundColor", "color", "resetBackgroundColor", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onSaveInstanceState", "outState", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class FlowCommonAppCompatActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f326854f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f326855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f326856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f326857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f326858d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f326859e;

    /* JADX INFO: loaded from: classes27.dex */
    public static final class a {
    }

    static {
    }

    public boolean H1() {
        return !(this instanceof AnnieXHostActivity);
    }

    public boolean I1() {
        return !(this instanceof MainActivity);
    }

    public boolean K1() {
        return !(this instanceof ScanCameraActivity);
    }

    public final void L1() {
        this.f326859e = false;
        int r100 = getResources().getColor(C1());
        this.f326857c = r100;
        View r101 = this.f326856b;
        if (r101 == null) goto L6;
        r101.setBackgroundColor(r100);
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        r1.f365797a.d(this, isChangingConfigurations());
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();     // Catch: Exception -> L5
    L12:
        if (this.f326856b != null) goto L14;
        this.f326856b = findViewById(R.id.content);
    L14:
        M1(false);
        View r100 = this.f326856b;
        if (r100 == null) goto L18;
        r100.post(new c(this));
    L18:
        if (K1() == false) goto L23;
        View r101 = this.f326856b;
        if (r101 == null) goto L23;
        int r102 = u.c(this);
        int r103 = r101.getPaddingStart();
        int r104 = r101.getPaddingEnd();
        int r105 = r101.getPaddingBottom();
        FLogger.f375446a.i("updatePaddingRelative", "view:" + r101.getClass().getSimpleName() + ",source:,start:" + r103 + ",top:" + r102 + ",end:" + r104 + ",bottom:" + r105);
        r101.setPaddingRelative(r103, r102, r104, r105);
    L23:
        if (H1() == false) goto L37;
        View r106 = this.f326856b;
        if (r106 == null) goto L28;
        r106.post(new d(this));
    L28:
        if (I1() == false) goto L38;
        final View r107 = this.f326856b;
        if (r107 == null) goto L39;
        ViewCompat.setOnApplyWindowInsetsListener(r107, new e(r107, this));
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    L5:
        e = move-exception;
        Field r108 = Activity.class.getDeclaredField("mCalled");     // Catch: Exception -> L8
        r108.setAccessible(true);     // Catch: Exception -> L8
        r108.set(this, Boolean.TRUE);     // Catch: Exception -> L8
    L10:
        FLogger.f375446a.e("FlowCommonAppCompatActivity", "onResume error=" + e.getMessage());
    L8:
        e = move-exception;
        finish();
        FLogger.f375446a.e("FlowCommonAppCompatActivity", "resumeCallActivity error=" + e.getMessage());
        goto L10
    }

    public int C1() {
        return v19.c.b(com.larus.nova.R.attr.larus_base_1, this, com.larus.nova.R.color.larus_base_1);
    }

    public Pair<Integer, Integer> D1() {
        int r100 = u.c(this);
        int r101 = i.c(this) + r100;
        return new Pair(Integer.valueOf(r100), Integer.valueOf(r101));
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0108 */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void finish() {
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

    public final String k() {
        String r100 = "";
        if (getSupportFragmentManager().getFragments().size() != 0) goto L5;
        return "";
    L5:
        ActivityResultCaller r101 = (Fragment) ListProtector.get(getSupportFragmentManager().getFragments(), 0);
        ay9.a r102 = null;
        if ((r101 instanceof com.larus.trace.tracknode.a) == false) goto L8;
        com.larus.trace.tracknode.a r103 = (com.larus.trace.tracknode.a) r101;
    L9:
        if (r103 == null) goto L12;
        String r104 = r103.k();
        if (r104 == null) goto L12;
    L14:
        if (StringsKt.isBlank(r104) == true) goto L16;
        return r104;
    L16:
        if ((r101 instanceof ay9.a) == false) goto L18;
        r102 = (ay9.a) r101;
    L18:
        if (r102 == null) goto L24;
        String r105 = r102.LO();
        if (r105 == null) goto L24;
        r100 = r105;
    L24:
        return r100;
    L12:
        r104 = "";
        goto L14
    L8:
        r103 = null;
        goto L9
    }

    public FlowCommonAppCompatActivity() {
    }

    public void z1() {
        u.d(this);
    }

    public final void A1(String r100) {
        f.a(getTheme());
        Resources.Theme r101 = getTheme();
        Intrinsics.checkNotNullParameter(r101, "<this>");
        DbxTheme r102 = DbxTheme.f327081a;
        r101.applyStyle(com.larus.nova.R.style.Larus_DbxTheme_BaseAttr, false);
        TypedValue r103 = new TypedValue();
        if (r101.resolveAttribute(com.larus.nova.R.attr.larus_dbx_theme_variant, r103, true) != true) goto L7;
        boolean r104 = true;
    L8:
        Boolean r105 = null;
        if (r104 == true) goto L11;
        DbxTheme.Variant r106 = DbxTheme.Variant.NONE;
    L35:
        int r107 = com.larus.common_ui.dbx.theme.a.C4184a.f327086a[r106.ordinal()];
        if (r107 != 1) goto L38;
        r105 = Boolean.FALSE;
    L42:
        com.larus.common_ui.dbx.theme.a.a(r101, r105);
        AppHost.Companion r108 = AppHost.f326268a;
        if (r108.isTestChannel() == false) goto L45;
    L46:
        FLogger r109 = FLogger.f375446a;
        r109.i("FlowCommonAppCompatActivity", r100.concat(", applyTheme"));
        if (r108.isDebug() == false) goto L57;
        Method r110 = ContextThemeWrapper.class.getDeclaredMethod("getThemeResId", new Class[0]);     // Catch: Exception -> L50
        r110.setAccessible(true);     // Catch: Exception -> L50
        Object r111 = r110.invoke(this, new Object[0]);     // Catch: Exception -> L50
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type kotlin.Int");     // Catch: Exception -> L50
        r109.i("FlowCommonAppCompatActivity", "themeName=" + getResources().getResourceName(((Integer) r111).intValue()));     // Catch: Exception -> L50
        return;
    L50:
        FLogger.f375446a.i("FlowCommonAppCompatActivity", "gain Theme fail again");
        return;
    L57:
        return;
    L45:
        if (r108.isDebugChannel() == true) goto L46;
        return;
    L38:
        if (r107 != 2) goto L42;
        r105 = Boolean.TRUE;
        goto L42
    L11:
        CharSequence r112 = r103.string;
        if (r112 == null) goto L14;
        String r113 = r112.toString();
    L15:
        if (r113 == null) goto L34;
        int r114 = r113.hashCode();
        if (r114 == 688284166) goto L31;
        if (r114 == 794816027) goto L28;
        if (r114 != 796663069) goto L34;
        if (r113.equals("dbx_theme_night") == false) goto L34;
        r106 = DbxTheme.Variant.DARK;
        goto L35
    L28:
        if (r113.equals("dbx_theme_light") == false) goto L34;
        r106 = DbxTheme.Variant.LIGHT;
        goto L35
    L31:
        if (r113.equals("dbx_theme_default") == false) goto L34;
        r106 = DbxTheme.Variant.DEFAULT;
    L34:
        r106 = DbxTheme.Variant.NONE;
        goto L35
    L14:
        r113 = null;
    L7:
        r104 = false;
        goto L8
    }

    public void B1(int r100) {
        this.f326859e = true;
        this.f326857c = r100;
        View r101 = this.f326856b;
        if (r101 == null) goto L6;
        r101.setBackgroundColor(r100);
        return;
    }

    public int F1(boolean r100) {
        return u.b(this);
    }

    public final void M1(boolean r100) {
        int r101 = getResources().getConfiguration().uiMode & 48;
        if (r100 == false) goto L5;
    L7:
        this.f326858d = r101;
        if (r101 != 32) goto L10;
        boolean r102 = true;
    L11:
        h.f552477a = r102;
        u.e(this, true, r102);
        z1();
        if (this.f326859e == true) goto L26;
        int r103 = getResources().getColor(C1());
        this.f326857c = r103;
        View r104 = this.f326856b;
        if (r104 == null) goto L26;
        r104.setBackgroundColor(r103);
    L26:
        Window r105 = getWindow();     // Catch: Throwable -> L20
        if (r105 == null) goto L28;
        r105.setBackgroundDrawableResource(v19.c.b(com.larus.nova.R.attr.larus_base_1, this, com.larus.nova.R.color.larus_base_1));     // Catch: Throwable -> L20
        return;
    L28:
        return;
    L20:
        th = move-exception;
        if (G1(th, "setBackgroundDrawable") == false) goto L25;
        FLogger.f375446a.e("FlowCommonAppCompatActivity", "setBackgroundDrawable DecorCaptionView crash", th);
        return;
    L25:
        throw th;
    L10:
        r102 = false;
        goto L11
    L5:
        if (r101 != this.f326858d) goto L7;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context r100) {
        r1.f365797a.attachBaseContext(r100);
        super.attachBaseContext(r100);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        y1(this, r100);     // Catch: Throwable -> L5
    L9:
        M1(false);
        return;
    L5:
        th = move-exception;
        if (G1(th, "onConfigurationChanged") == false) goto L11;
        FLogger.f375446a.e("FlowCommonAppCompatActivity", "onConfigurationChanged DecorCaptionView crash", th);
        goto L9
    L11:
        throw th;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        A1(WidgetCostModule.TYPE_ON_CREATE);
        r1.f365797a.a(this, r100);
        g0.f365740a.b(this);
        a7.a(this, "FlowCommonAppCompatActivity");
        super.onCreate(r100);
        Bundle r101 = getIntent().getExtras();
        if (r101 == null) goto L13;
        String r102 = r101.getString("is_from_push");
    L14:
        this.f326855a = Intrinsics.areEqual(r102, "true");
        this.f326857c = getResources().getColor(C1());
        ActionBar r103 = getSupportActionBar();     // Catch: Exception -> L19
        if (r103 == null) goto L21;
        r103.hide();     // Catch: Exception -> L19
    L21:
        M1(true);
        return;
    L19:
        e = move-exception;
        FLogger.f375446a.e("FlowCommonAppCompatActivity", "supportActionBar hide e: ", e);
        goto L21
    L13:
        r102 = null;
        goto L14
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "outState");
        r1.f365797a.b(this, r100);
        super.onSaveInstanceState(r100);
    }

    public final void setRootView(View r100) {
        this.f326856b = r100;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int r100) {
        super.setTheme(r100);
        if (AppHost.f326268a.isPlugin() == false) goto L6;
        A1("setTheme resources");
        return;
    }

    @Override // android.view.ContextThemeWrapper
    public final void setTheme(Resources.Theme r100) {
        super.setTheme(r100);
        if (AppHost.f326268a.isPlugin() == false) goto L6;
        A1("setTheme resources");
        return;
    }

    public static boolean G1(Throwable r100, String r101) {
        if ((r100 instanceof NullPointerException) == false) goto L43;
        String r102 = r100.getMessage();
        if (r102 != null) goto L7;
    L9:
        boolean r103 = false;
    L10:
        if (r103 == false) goto L44;
        NullPointerException r104 = (NullPointerException) r100;
        StackTraceElement[] r105 = r104.getStackTrace();
        int r106 = r105.length;
        int r107 = 0;
    L12:
        if (r107 >= r106) goto L22;
        StackTraceElement r108 = r105[r107];
        if (Intrinsics.areEqual(r108.getClassName(), "com.android.internal.policy.DecorView") == true) goto L16;
    L18:
        boolean r109 = false;
    L19:
        if (r109 == true) goto L20;
        r107 = r107 + 1;
        goto L12
    L20:
        boolean r110 = true;
    L23:
        if (r110 == false) goto L45;
        StackTraceElement[] r111 = r104.getStackTrace();
        int r112 = r111.length;
        int r113 = 0;
    L25:
        if (r113 >= r112) goto L35;
        StackTraceElement r114 = r111[r113];
        if (Intrinsics.areEqual(r114.getClassName(), "com.android.internal.policy.PhoneWindow") == true) goto L29;
    L31:
        boolean r115 = false;
    L32:
        if (r115 == true) goto L33;
        r113 = r113 + 1;
        goto L25
    L33:
        boolean r116 = true;
    L36:
        if (r116 == false) goto L46;
        return true;
    L46:
        return false;
    L29:
        if (Intrinsics.areEqual(r114.getMethodName(), r101) == false) goto L31;
        r115 = true;
        goto L32
    L35:
        r116 = false;
        goto L36
    L45:
        return false;
    L16:
        if (Intrinsics.areEqual(r108.getMethodName(), "updateColorViews") == false) goto L18;
        r109 = true;
        goto L19
    L22:
        r110 = false;
        goto L23
    L44:
        return false;
    L7:
        if (StringsKt.contains$default(r102, "DecorCaptionView.getCaption", false, 2, null) != true) goto L9;
        r103 = true;
        goto L10
    L43:
        return false;
    }

    public static void y1(AppCompatActivity r100, Configuration r101) {
        super.onConfigurationChanged(r101);
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L17
        if (dc9.d.a() == true) goto L22;
        int r102 = r100.getRequestedOrientation();     // Catch: Throwable -> L17
        if (r101 == null) goto L8;
        Integer r103 = Integer.valueOf(r101.orientation);     // Catch: Throwable -> L17
    L9:
        if (r103 != null) goto L12;
    L14:
        if (r102 != 3) goto L24;
        r100.setRequestedOrientation(1);     // Catch: Throwable -> L17
        FLogger.f375446a.i("PadLancet", "onConfigurationChanged, phone reset page:" + r100.getClass().getSimpleName() + " portrait");     // Catch: Throwable -> L17
        return;
    L24:
        return;
    L12:
        if (r103.intValue() != r102) goto L14;
        return;
    L8:
        r103 = null;
        goto L9
    L22:
        return;
    L17:
        th = move-exception;
        FLogger.f375446a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        b19.a r103 = new b19.a(r100, r101, r102);
        b.f16952a.setValue(r103);
    }
}
