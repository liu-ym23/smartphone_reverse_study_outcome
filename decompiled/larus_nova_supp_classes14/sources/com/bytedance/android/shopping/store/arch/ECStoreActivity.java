package com.bytedance.android.shopping.store.arch;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.j2;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.store.lifecycle.ECStorePerfMonitor;
import com.bytedance.android.shopping.store.lifecycle.g;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.tabkit.TabKitFragment;
import com.bytedance.android.shopping.store.utils.o;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/store/arch/ECStoreActivity;", "Landroidx/fragment/app/FragmentActivity;", "Luk3/a;", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreActivity extends FragmentActivity implements uk3.a {
    public static final /* synthetic */ int e = 0;
    public TabKitFragment a;
    public final Lazy b;
    public final boolean c;
    public final float d;

    public static final class a {
    }

    static {
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(ECStoreActivity.class.getName()));
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
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L48;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    public ECStoreActivity() {
        this.b = LazyKt.lazy(LazyThreadSafetyMode.NONE, new ECStoreActivity$perfMonitor$2(this));
        this.c = true;
        this.d = 375.0f;
    }

    public final void onPause() {
        super.onPause();
        ECStorePerfMonitor r0 = (ECStorePerfMonitor) this.b.getValue();
        if (r0 == null) goto L8;
        g r1 = r0.k;
        if (r1 == null) goto L9;
        r1.b();
        return;
    L9:
        return;
    }

    public final void onResume() {
        super.onResume();
        ECStorePerfMonitor r0 = (ECStorePerfMonitor) this.b.getValue();
        if (r0 == null) goto L14;
        g r1 = r0.k;
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.b != true) goto L16;
        ECStorePerfMonitor r2 = (ECStorePerfMonitor) this.b.getValue();
        if (r2 == null) goto L17;
        g r3 = r2.k;
        if (r3 == null) goto L18;
        r3.c(6, null);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r0 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == c.a) goto L9;
        c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    @Override // uk3.a
    public final float b() {
        return this.d;
    }

    @Override // uk3.a
    public final boolean g() {
        return this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void attachBaseContext(Context r4) {
        super/*androidx.core.app.ComponentActivity*/.attachBaseContext(r4);
        if (Intrinsics.areEqual(ECAppInfoService.e.getAppId(), "482431") == true) goto L39;
        if (r4 == null) goto L43;
        Intent r0 = getIntent();
        Unit r1 = null;
        if (r0 == null) goto L14;
        Bundle r2 = r0.getBundleExtra("biz_arguments");
        Context r3 = BadParcelableCrashOptimizer.getContext();
        if (r2 == null) goto L12;
        if (r3 == null) goto L12;
        r2.setClassLoader(r3.getClassLoader());
    L12:
        if (r2 == null) goto L14;
        Boolean r5 = Boolean.valueOf(r2.getBoolean("is_store"));
    L16:
        if (Intrinsics.areEqual(r5, Boolean.TRUE) == true) goto L18;
        return;
    L18:
        if (ECShopABSettings.d() != 1) goto L41;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L26
        Resources r7 = r4.getResources();     // Catch: Throwable -> L26
        if (r7 == null) goto L24;
        Configuration r8 = r7.getConfiguration();     // Catch: Throwable -> L26
        if (r8 == null) goto L24;
        Configuration r9 = new Configuration(r8);     // Catch: Throwable -> L26
        r9.fontScale = o.a;     // Catch: Throwable -> L26
        applyOverrideConfiguration(r9);     // Catch: Throwable -> L26
        r1 = Unit.INSTANCE;     // Catch: Throwable -> L26
    L24:
        Object r10 = Result.constructor-impl(r1);     // Catch: Throwable -> L26
    L28:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L42;
        ECExceptionMonitor.d("ECStoreActivity", r11, "overrideFontScale exception been caught");     // Catch: Throwable -> L32
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L32
        return;
    L32:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L42:
        return;
    L26:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    L41:
        return;
    L14:
        r5 = null;
        goto L16
    L43:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r15) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        j2 r0 = j2.g;
        ECSettingKeys.j.getClass();
        int r1 = ECSettingKeys.b0();
        TabKitFragment r3 = null;
        if (r1 > 0) goto L14;
        j2.d("call tryFix debug_info=" + r0.b(this));
    L60:
        long r2 = System.currentTimeMillis();
        super.onCreate(r15);
        ECStorePerfMonitor r16 = (ECStorePerfMonitor) this.b.getValue();
        if (r16 == null) goto L65;
        g r17 = r16.k;
        if (r17 == null) goto L65;
        r17.c(3, Long.valueOf(r2));
    L65:
        setContentView(2131560975);
        Fragment r18 = getSupportFragmentManager().findFragmentByTag("tabkit_fragment");
        if ((r18 instanceof TabKitFragment) == true) goto L68;
        r18 = null;
    L68:
        TabKitFragment r19 = (TabKitFragment) r18;
        this.a = r19;
        if (r19 != null) goto L97;
        Serializable r110 = getIntent().getSerializableExtra("tabkit_fragment_clazz");
        if ((r110 instanceof Class) == true) goto L73;
        r110 = null;
    L73:
        Class r111 = (Class) r110;
        if (r111 == null) goto L78;
        Constructor r112 = r111.getDeclaredConstructor(new Class[0]);
        if (r112 == null) goto L78;
        r3 = (TabKitFragment) r112.newInstance(new Object[0]);
    L78:
        this.a = r3;
        if (r3 == null) goto L90;
        Bundle r113 = new Bundle();
        Bundle r4 = getIntent().getBundleExtra("biz_arguments");
        Context r5 = BadParcelableCrashOptimizer.getContext();
        if (r4 == null) goto L84;
        if (r5 == null) goto L84;
        r4.setClassLoader(r5.getClassLoader());
    L84:
        r113.putAll(r4);
        String r6 = getIntent().getStringExtra("ec_store_instance_id");
        if (r6 != null) goto L87;
        r6 = r113.getString("ec_store_instance_id");
    L87:
        if (r6 != null) goto L89;
        r6 = UUID.randomUUID().toString();
    L89:
        r113.putString("ec_store_instance_id", r6);
        Unit r7 = Unit.INSTANCE;
        r3.setArguments(r113);
    L90:
        TabKitFragment r114 = this.a;
        if (r114 == null) goto L97;
        FragmentTransaction r8 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r8, r114, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "tabkit_fragment", 2131388065) == true) goto L96;
        r8.add(2131388065, r114, "tabkit_fragment");
    L96:
        r8.commitNowAllowingStateLoss();
    L97:
        TabKitFragment r115 = this.a;
        if (r115 == null) goto L100;
        r115.e = getWindow();
    L100:
        Lazy r116 = ECAppInfoService.a;
        if (we.a.a == true) goto L103;
        return;
    L103:
        if (Build.VERSION.SDK_INT < 35) goto L121;
        View r117 = findViewById(getResources().getIdentifier("action_bar_container", "id", "android"));     // Catch: Throwable -> L109
        if (r117 == null) goto L120;
        r117.setVisibility(8);     // Catch: Throwable -> L109
        return;
    L120:
        return;
    L109:
        th = move-exception;
        ECExceptionMonitor.d("ECStoreActivity", th, "muteSystemActionBarForSass exception been caught");
        return;
    L121:
        return;
    L14:
        if (j2.e == true) goto L60;
        j2.e = true;
        r0.a();
        SparseArray r9 = j2.a;
        if (r9 == null) goto L59;
        if (r1 <= 0) goto L59;
        Field r10 = j2.b;     // Catch: Throwable -> L57
        if (r10 == null) goto L59;
        Field r11 = j2.c;     // Catch: Throwable -> L57
        if (r11 == null) goto L59;
        Field r12 = j2.d;     // Catch: Throwable -> L57
        if (r12 == null) goto L59;
        Object r13 = r12.get(null);     // Catch: Throwable -> L57
        if (r13 == null) goto L59;
        Object r14 = r10.get(r9);     // Catch: Throwable -> L57
        if (r14 == null) goto L56;
        int[] r20 = (int[]) r14;     // Catch: Throwable -> L57
        Object r118 = r11.get(r9);     // Catch: Throwable -> L57
        if (r118 == null) goto L54;
        Object[] r119 = (Object[]) r118;     // Catch: Throwable -> L57
        if (r20.length >= r1) goto L59;
        int[] r120 = new int[r1];     // Catch: Throwable -> L57
        Object[] r121 = new Object[r1];     // Catch: Throwable -> L57
        System.arraycopy(r20, 0, r120, 0, r20.length);     // Catch: Throwable -> L57
        System.arraycopy(r119, 0, r121, 0, r119.length);     // Catch: Throwable -> L57
        int r21 = 0;
    L40:
        if (r21 >= r1) goto L48;
        if (r120[r21] != 0) goto L44;
        boolean r122 = true;
    L45:
        if (r122 == true) goto L49;
        r21 = r21 + 1;     // Catch: Throwable -> L57
    L49:
        if (r21 == (-1)) goto L52;
        if (r21 >= r1) goto L52;
        Arrays.fill(r120, r21, r1, Integer.MAX_VALUE);     // Catch: Throwable -> L57
        Arrays.fill(r121, r21, r1, r13);     // Catch: Throwable -> L57
    L52:
        r10.set(r9, r120);     // Catch: Throwable -> L57
        r11.set(r9, r121);     // Catch: Throwable -> L57
        goto L59
    L44:
        r122 = false;
        goto L45
    L48:
        r21 = -1;
        goto L49
    L54:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");     // Catch: Throwable -> L57
    L56:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.IntArray");     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        th.printStackTrace();
    L59:
        j2.d("call tryFix after debug_info=" + r0.b(this));
        goto L60
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onKeyDown(int r2, KeyEvent r3) {
        if (r2 != 4) goto L10;
        TabKitFragment r4 = this.a;
        if (r4 == null) goto L11;
        r4.S90();
        return true;
    L11:
        return true;
    L10:
        return super/*android.app.Activity*/.onKeyDown(r2, r3);
    }
}
