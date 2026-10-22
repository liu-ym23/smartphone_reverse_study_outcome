package com.larus.common_ui.activity;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.EventsUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.Window;
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
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.avatar.impl.scan.ScanCameraActivity;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dbx.theme.DbxTheme;
import com.larus.home.impl.MainActivity;
import com.larus.platform.service.g0;
import com.larus.platform.service.r1;
import com.larus.platform.service.z2;
import com.larus.trace.tracknode.a;
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
import org.xmlpull.v1.XmlPullParser;
import v19.a7;
import v19.f;
import v19.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 A2\u00020\u0001:\u0001AB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0016\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0018\u00010\u0014R\u00020\u0015H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\rH\u0002J\u0012\u0010\u001a\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u000fH\u0014J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\rH\u0002J\b\u0010%\u001a\u00020\u000fH\u0002J\b\u0010&\u001a\u00020\u0005H\u0016J\b\u0010'\u001a\u00020\u0005H\u0016J\b\u0010(\u001a\u00020\u0017H\u0016J\b\u0010)\u001a\u00020\u0005H\u0016J\u0010\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u0005H\u0016J\u0006\u0010,\u001a\u00020\u0005J\u0014\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170.H\u0016J\u0010\u00102\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\u0005H\u0002J\u0010\u00104\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u0005H\u0014J\u0012\u00106\u001a\u00020\u000f2\b\b\u0001\u00107\u001a\u00020\u0017H\u0016J\b\u00108\u001a\u00020\u000fH\u0016J\"\u00109\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020\u00172\u0006\u0010;\u001a\u00020\u00172\b\u0010<\u001a\u0004\u0018\u00010=H\u0014J\u0010\u0010>\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020\u001cH\u0014J\b\u0010@\u001a\u00020\u000fH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0012\u0010/\u001a\u00020\u00178\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "mIsFromFlowPush", XmlPullParser.NO_NAMESPACE, "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "getCurrentPageName", XmlPullParser.NO_NAMESPACE, "attachBaseContext", XmlPullParser.NO_NAMESPACE, "newBase", "Landroid/content/Context;", "setTheme", "theme", "Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", "resId", XmlPullParser.NO_NAMESPACE, "applyTheme", "tag", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "isDecorCaptionViewCrash", "t", XmlPullParser.NO_NAMESPACE, "phoneWindowMethod", "resumeCallActivity", "needAdaptStatusBarPadding", "needAdaptNavigationBarPadding", "getBackgroundResource", "needAdaptNavigationBarPaddingWhenIme", "getNavigationBarPaddingOnWindowInsets", "imeVisible", "isFromFlowPush", "getFloatViewRestriction", "Landroid/util/Pair;", "hookBackGroundColorInt", "lastUiMode", "isBackgroundColorOverridden", "syncNightModeUiState", "force", "applyNavigationBarStyle", "isNightMode", "disableToSetBackgroundColor", "color", "resetBackgroundColor", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onSaveInstanceState", "outState", "onDestroy", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public class FlowCommonAppCompatActivity extends AppCompatActivity {
    public static final /* synthetic */ int f = 0;
    public boolean a;
    public View b;
    public int c;
    public int d;
    public boolean e;

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
        this.e = false;
        int r0 = getResources().getColor(C1());
        this.c = r0;
        View r1 = this.b;
        if (r1 == null) goto L6;
        r1.setBackgroundColor(r0);
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        r1.a.d(this, isChangingConfigurations());
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();     // Catch: Exception -> L5
    L12:
        if (this.b != null) goto L14;
        this.b = findViewById(R.id.content);
    L14:
        M1(false);
        View r0 = this.b;
        if (r0 == null) goto L18;
        r0.post(new c(this));
    L18:
        if (K1() == false) goto L23;
        View r1 = this.b;
        if (r1 == null) goto L23;
        int r2 = u.c(this);
        int r3 = r1.getPaddingStart();
        int r4 = r1.getPaddingEnd();
        int r5 = r1.getPaddingBottom();
        FLogger.a.i("updatePaddingRelative", "view:" + r1.getClass().getSimpleName() + ",source:,start:" + r3 + ",top:" + r2 + ",end:" + r4 + ",bottom:" + r5);
        r1.setPaddingRelative(r3, r2, r4, r5);
    L23:
        if (H1() == false) goto L37;
        View r6 = this.b;
        if (r6 == null) goto L28;
        r6.post(new d(this));
    L28:
        if (I1() == false) goto L38;
        View r7 = this.b;
        if (r7 == null) goto L39;
        ViewCompat.setOnApplyWindowInsetsListener(r7, new e(r7, this));
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    L5:
        e = move-exception;
        Field r8 = Activity.class.getDeclaredField("mCalled");     // Catch: Exception -> L8
        r8.setAccessible(true);     // Catch: Exception -> L8
        r8.set(this, Boolean.TRUE);     // Catch: Exception -> L8
    L10:
        FLogger.a.e("FlowCommonAppCompatActivity", "onResume error=" + e.getMessage());
    L8:
        e = move-exception;
        finish();
        FLogger.a.e("FlowCommonAppCompatActivity", "resumeCallActivity error=" + e.getMessage());
        goto L10
    }

    public int C1() {
        return v19.c.b(2130970529, this, 2131102529);
    }

    public Pair<Integer, Integer> D1() {
        int r0 = u.c(this);
        int r1 = i.c(this) + r0;
        return new Pair(Integer.valueOf(r0), Integer.valueOf(r1));
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0108 */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(getClass().getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L45
        if (r6 != null) goto L10;
    L13:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L45
        monitor-exit(r5);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L50;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    public final String k() {
        int r0 = getSupportFragmentManager().getFragments().size();
        String r1 = XmlPullParser.NO_NAMESPACE;
        if (r0 != 0) goto L5;
        return XmlPullParser.NO_NAMESPACE;
    L5:
        a r2 = (Fragment) ListProtector.get(getSupportFragmentManager().getFragments(), 0);
        ay9.a r3 = null;
        if ((r2 instanceof a) == false) goto L8;
        a r4 = r2;
    L9:
        if (r4 == null) goto L12;
        String r5 = r4.k();
        if (r5 == null) goto L12;
    L14:
        if (StringsKt.isBlank(r5) == true) goto L16;
        return r5;
    L16:
        if ((r2 instanceof ay9.a) == false) goto L18;
        r3 = (ay9.a) r2;
    L18:
        if (r3 == null) goto L24;
        String r6 = r3.LO();
        if (r6 == null) goto L24;
        r1 = r6;
    L24:
        return r1;
    L12:
        r5 = XmlPullParser.NO_NAMESPACE;
        goto L14
    L8:
        r4 = null;
        goto L9
    }

    public FlowCommonAppCompatActivity() {
    }

    public void z1() {
        u.d(this);
    }

    public final void A1(String r9) {
        f.a(getTheme());
        Resources.Theme r1 = getTheme();
        Intrinsics.checkNotNullParameter(r1, "<this>");
        DbxTheme r2 = DbxTheme.a;
        r1.applyStyle(2131952453, false);
        TypedValue r3 = new TypedValue();
        if (r1.resolveAttribute(2130971097, r3, true) != true) goto L7;
        boolean r5 = true;
    L8:
        Boolean r6 = null;
        if (r5 == true) goto L11;
        DbxTheme.Variant r4 = DbxTheme.Variant.NONE;
    L35:
        int r7 = com.larus.common_ui.dbx.theme.a.a.a[r4.ordinal()];
        if (r7 != 1) goto L38;
        r6 = Boolean.FALSE;
    L42:
        com.larus.common_ui.dbx.theme.a.a(r1, r6);
        AppHost.Companion r8 = AppHost.a;
        if (r8.isTestChannel() == false) goto L45;
    L46:
        FLogger r10 = FLogger.a;
        r10.i("FlowCommonAppCompatActivity", r9.concat(", applyTheme"));
        if (r8.isDebug() == false) goto L57;
        Method r11 = ContextThemeWrapper.class.getDeclaredMethod("getThemeResId", new Class[0]);     // Catch: Exception -> L50
        r11.setAccessible(true);     // Catch: Exception -> L50
        Object r12 = r11.invoke(this, new Object[0]);     // Catch: Exception -> L50
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Int");     // Catch: Exception -> L50
        r10.i("FlowCommonAppCompatActivity", "themeName=" + getResources().getResourceName(((Integer) r12).intValue()));     // Catch: Exception -> L50
        return;
    L50:
        FLogger.a.i("FlowCommonAppCompatActivity", "gain Theme fail again");
        return;
    L57:
        return;
    L45:
        if (r8.isDebugChannel() == true) goto L46;
        return;
    L38:
        if (r7 != 2) goto L42;
        r6 = Boolean.TRUE;
        goto L42
    L11:
        CharSequence r13 = r3.string;
        if (r13 == null) goto L14;
        String r14 = r13.toString();
    L15:
        if (r14 == null) goto L34;
        int r15 = r14.hashCode();
        if (r15 == 688284166) goto L31;
        if (r15 == 794816027) goto L28;
        if (r15 != 796663069) goto L34;
        if (r14.equals("dbx_theme_night") == false) goto L34;
        r4 = DbxTheme.Variant.DARK;
        goto L35
    L28:
        if (r14.equals("dbx_theme_light") == false) goto L34;
        r4 = DbxTheme.Variant.LIGHT;
        goto L35
    L31:
        if (r14.equals("dbx_theme_default") == false) goto L34;
        r4 = DbxTheme.Variant.DEFAULT;
    L34:
        r4 = DbxTheme.Variant.NONE;
        goto L35
    L14:
        r14 = null;
    L7:
        r5 = false;
        goto L8
    }

    public void B1(int r2) {
        this.e = true;
        this.c = r2;
        View r0 = this.b;
        if (r0 == null) goto L6;
        r0.setBackgroundColor(r2);
        return;
    }

    public int F1(boolean r1) {
        return u.b(this);
    }

    public final void M1(boolean r4) {
        int r0 = getResources().getConfiguration().uiMode & 48;
        if (r4 == false) goto L5;
    L7:
        this.d = r0;
        if (r0 != 32) goto L10;
        boolean r5 = true;
    L11:
        h.a = r5;
        u.e(this, true, r5);
        z1();
        if (this.e == true) goto L26;
        int r6 = getResources().getColor(C1());
        this.c = r6;
        View r1 = this.b;
        if (r1 == null) goto L26;
        r1.setBackgroundColor(r6);
    L26:
        Window r7 = getWindow();     // Catch: Throwable -> L20
        if (r7 == null) goto L28;
        r7.setBackgroundDrawableResource(v19.c.b(2130970529, this, 2131102529));     // Catch: Throwable -> L20
        return;
    L28:
        return;
    L20:
        th = move-exception;
        if (G1(th, "setBackgroundDrawable") == false) goto L25;
        FLogger.a.e("FlowCommonAppCompatActivity", "setBackgroundDrawable DecorCaptionView crash", th);
        return;
    L25:
        throw th;
    L10:
        r5 = false;
        goto L11
    L5:
        if (r0 != this.d) goto L7;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context r2) {
        r1.a.attachBaseContext(r2);
        super.attachBaseContext(r2);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r4) {
        Intrinsics.checkNotNullParameter(r4, "newConfig");
        y1(this, r4);     // Catch: Throwable -> L5
    L9:
        M1(false);
        return;
    L5:
        th = move-exception;
        if (G1(th, "onConfigurationChanged") == false) goto L11;
        FLogger.a.e("FlowCommonAppCompatActivity", "onConfigurationChanged DecorCaptionView crash", th);
        goto L9
    L11:
        throw th;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r4) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        A1("onCreate");
        r1.a.a(this, r4);
        g0.a.b(this);
        a7.a(this, "FlowCommonAppCompatActivity");
        super.onCreate(r4);
        Bundle r5 = getIntent().getExtras();
        if (r5 == null) goto L13;
        String r6 = r5.getString("is_from_push");
    L14:
        this.a = Intrinsics.areEqual(r6, "true");
        this.c = getResources().getColor(C1());
        ActionBar r7 = getSupportActionBar();     // Catch: Exception -> L19
        if (r7 == null) goto L21;
        r7.hide();     // Catch: Exception -> L19
    L21:
        M1(true);
        return;
    L19:
        e = move-exception;
        FLogger.a.e("FlowCommonAppCompatActivity", "supportActionBar hide e: ", e);
        goto L21
    L13:
        r6 = null;
        goto L14
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "outState");
        r1.a.b(this, r2);
        super.onSaveInstanceState(r2);
    }

    public final void setRootView(View r1) {
        this.b = r1;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int r1) {
        super.setTheme(r1);
        if (AppHost.a.isPlugin() == false) goto L6;
        A1("setTheme resources");
        return;
    }

    @Override // android.view.ContextThemeWrapper
    public final void setTheme(Resources.Theme r1) {
        super.setTheme(r1);
        if (AppHost.a.isPlugin() == false) goto L6;
        A1("setTheme resources");
        return;
    }

    public static boolean G1(Throwable r8, String r9) {
        if ((r8 instanceof NullPointerException) == false) goto L43;
        String r0 = r8.getMessage();
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L44;
        NullPointerException r10 = (NullPointerException) r8;
        StackTraceElement[] r2 = r10.getStackTrace();
        int r3 = r2.length;
        int r4 = 0;
    L12:
        if (r4 >= r3) goto L22;
        StackTraceElement r5 = r2[r4];
        if (Intrinsics.areEqual(r5.getClassName(), "com.android.internal.policy.DecorView") == true) goto L16;
    L18:
        boolean r6 = false;
    L19:
        if (r6 == true) goto L20;
        r4 = r4 + 1;
        goto L12
    L20:
        boolean r7 = true;
    L23:
        if (r7 == false) goto L45;
        StackTraceElement[] r11 = r10.getStackTrace();
        int r12 = r11.length;
        int r13 = 0;
    L25:
        if (r13 >= r12) goto L35;
        StackTraceElement r14 = r11[r13];
        if (Intrinsics.areEqual(r14.getClassName(), "com.android.internal.policy.PhoneWindow") == true) goto L29;
    L31:
        boolean r15 = false;
    L32:
        if (r15 == true) goto L33;
        r13 = r13 + 1;
        goto L25
    L33:
        boolean r16 = true;
    L36:
        if (r16 == false) goto L46;
        return true;
    L46:
        return false;
    L29:
        if (Intrinsics.areEqual(r14.getMethodName(), r9) == false) goto L31;
        r15 = true;
        goto L32
    L35:
        r16 = false;
        goto L36
    L45:
        return false;
    L16:
        if (Intrinsics.areEqual(r5.getMethodName(), "updateColorViews") == false) goto L18;
        r6 = true;
        goto L19
    L22:
        r7 = false;
        goto L23
    L44:
        return false;
    L7:
        if (StringsKt.contains$default(r0, "DecorCaptionView.getCaption", false, 2, null) != true) goto L9;
        r1 = true;
        goto L10
    L43:
        return false;
    }

    public static void y1(AppCompatActivity r3, Configuration r4) {
        super.onConfigurationChanged(r4);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L17
        if (dc9.d.a() == true) goto L22;
        int r2 = r3.getRequestedOrientation();     // Catch: Throwable -> L17
        if (r4 == null) goto L8;
        Integer r5 = Integer.valueOf(r4.orientation);     // Catch: Throwable -> L17
    L9:
        if (r5 != null) goto L12;
    L14:
        if (r2 != 3) goto L24;
        r3.setRequestedOrientation(1);     // Catch: Throwable -> L17
        FLogger.a.i("PadLancet", "onConfigurationChanged, phone reset page:" + r3.getClass().getSimpleName() + " portrait");     // Catch: Throwable -> L17
        return;
    L24:
        return;
    L12:
        if (r5.intValue() != r2) goto L14;
        return;
    L8:
        r5 = null;
        goto L9
    L22:
        return;
    L17:
        th = move-exception;
        FLogger.a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        b19.a r0 = new b19.a(r2, r3, r4);
        b.a.setValue(r0);
    }
}
