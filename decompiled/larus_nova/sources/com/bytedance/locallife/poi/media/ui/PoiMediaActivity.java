package com.bytedance.locallife.poi.media.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.locallife.poi.media.base.AbsPlayerActivity;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.google.gson.JsonObject;
import com.gyf.barlibrary.ImmersionBar;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import iy6.g;
import iy6.h;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/locallife/poi/media/ui/PoiMediaActivity;", "Lcom/bytedance/locallife/poi/media/base/AbsPlayerActivity;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiMediaActivity extends AbsPlayerActivity {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public iy6.b f262803j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f262804k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Set<Integer> f262805l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f262806m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f262807n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Map<String, String> f262808o;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.locallife.poi.media.base.AbsPlayerActivity, com.bytedance.ies.uikit.base.AbsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(PoiMediaActivity.class.getName()));
    L5:
        ImmersionBar.with(this).destroy();
        super.onDestroy();
        long r100 = System.currentTimeMillis() - this.f262804k;
        int r101 = com.bytedance.locallife.biz.mob.a.f256703c;
        Pair[] r102 = new Pair[3];
        int r103 = 0;
        r102[0] = TuplesKt.to("stay_duration", String.valueOf(r100));
        r102[1] = TuplesKt.to("watch_cnt", String.valueOf(this.f262805l.size()));
        iy6.b r104 = this.f262803j;
        if (r104 == null) goto L12;
        h r105 = r104.d();
        if (r105 == null) goto L12;
        List<iy6.c> r106 = r105.d();
        if (r106 == null) goto L12;
        r103 = r106.size();
    L12:
        r102[2] = TuplesKt.to("total_cnt", String.valueOf(r103));
        Map r107 = MapsKt.mutableMapOf(r102);
        r107.putAll(this.f262808o);
        Unit r108 = Unit.INSTANCE;
        com.bytedance.locallife.biz.mob.a.C3646a.c("poi_player_exit", r107);
        this.f262805l.clear();
    }

    public PoiMediaActivity() {
        this.f262805l = new LinkedHashSet();
        this.f262808o = new LinkedHashMap();
    }

    @Override // com.bytedance.locallife.poi.media.base.AbsPlayerActivity, com.bytedance.ies.uikit.base.AbsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.slide_out_left_saas);
        if ((this instanceof ChatWindowActivity) == true) goto L56;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(PoiMediaActivity.class.getName()));
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

    @Override // com.bytedance.ies.uikit.base.AbsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
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

    public final void A1(long r100) {
        if (this.f262807n == true) goto L6;
        this.f262807n = true;
        int r101 = com.bytedance.locallife.biz.mob.a.f256703c;
        Map r102 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("duration", String.valueOf(r100 - this.f262804k))});
        r102.putAll(this.f262808o);
        Unit r103 = Unit.INSTANCE;
        com.bytedance.locallife.biz.mob.a.C3646a.c("poi_player_fmp", r102);
        return;
    }

    @Override // com.bytedance.ies.uikit.base.AbsActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r100);
        setContentView(R.layout.life_poi_media_activity);
        this.f262804k = System.currentTimeMillis();
        int r101 = 0;
        ImmersionBar.with(this).autoNavigationBarDarkModeEnable(false).navigationBarColor(R.color.black).fitsSystemWindows(true).statusBarColor(R.color.Transparent).statusBarDarkFont(false).init();
        Serializable r102 = getIntent().getSerializableExtra("extra_poi_detail_player_data");
        g r103 = null;
        if ((r102 instanceof String) == false) goto L13;
        String r104 = (String) r102;
    L14:
        if (r104 != null) goto L60;
    L28:
        int r105 = com.bytedance.locallife.biz.mob.a.f256703c;
        LinkedHashMap r106 = new LinkedHashMap();
        r106.putAll(this.f262808o);
        iy6.b r107 = this.f262803j;
        if (r107 == null) goto L31;
        int r108 = r107.b();
    L32:
        iy6.b r109 = this.f262803j;
        if (r109 == null) goto L39;
        h r110 = r109.d();
        if (r110 == null) goto L39;
        List<iy6.c> r111 = r110.d();
        if (r111 == null) goto L39;
        r101 = r111.size();
    L39:
        if (r108 >= r101) goto L65;
        iy6.b r112 = this.f262803j;
        if (r112 == null) goto L50;
        h r113 = r112.d();
        if (r113 == null) goto L50;
        List<iy6.c> r114 = r113.d();
        if (r114 == null) goto L50;
        iy6.c r115 = (iy6.c) ListProtector.get(r114, r108);
        if (r115 == null) goto L50;
        r103 = r115.d();
    L50:
        if (r103 == null) goto L54;
        String r116 = r103.c();
        if (r116 == null) goto L54;
        String r117 = (String) r106.put("create_source", r116);
    L54:
        if (r103 == null) goto L58;
        String r118 = r103.f();
        if (r118 == null) goto L58;
        r106.put("update_source", r118);
    L58:
        Unit r119 = Unit.INSTANCE;
        com.bytedance.locallife.biz.mob.a.C3646a.c("enter_inner_detail_page", r106);
        return;
    L65:
        return;
    L31:
        r108 = 0;
        goto L32
    L60:
        iy6.b r120 = (iy6.b) com.bytedance.locallife.common.utils.d.a(r104, iy6.b.class);     // Catch: Exception -> L26
        if (r120 == null) goto L21;
        ((LinkedHashMap) this.f262808o).clear();     // Catch: Exception -> L26
        JsonObject r121 = r120.h();     // Catch: Exception -> L26
        if (r121 == null) goto L20;
        com.bytedance.locallife.poi.media.a r122 = com.bytedance.locallife.poi.media.a.f262661a;     // Catch: Exception -> L26
        Map<String, String> r123 = this.f262808o;     // Catch: Exception -> L26
        PoiMediaActivity$onCreate$1$1 r124 = PoiMediaActivity$onCreate$1$1.INSTANCE;     // Catch: Exception -> L26
        r122.getClass();     // Catch: Exception -> L26
        com.bytedance.locallife.poi.media.a.a(r121, r123, r124);     // Catch: Exception -> L26
    L20:
        z1(r120);     // Catch: Exception -> L26
    L22:
        this.f262803j = r120;     // Catch: Exception -> L26
        if (r120 != null) goto L28;
        finish();     // Catch: Exception -> L26
        return;
    L21:
        r120 = null;
    L26:
        e = move-exception;
        com.bytedance.locallife.poi.media.a.f262661a.getClass();
        com.bytedance.locallife.poi.media.a.d(e);
        goto L28
    L13:
        r104 = null;
        goto L14
    }

    public final void z1(iy6.b r100) {
        if (getSupportFragmentManager().findFragmentByTag("media_fragment_tag") != null) goto L10;
        int r101 = PoiMediaFragment.D;
        Intrinsics.checkNotNullParameter(r100, "openMediaData");
        PoiMediaFragment r102 = new PoiMediaFragment();
        r102.f262811f = r100;
        FragmentTransaction r103 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r103, r102, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "media_fragment_tag", R.id.poi_player_detail_container) == true) goto L8;
        r103 = r103.add(R.id.poi_player_detail_container, r102, "media_fragment_tag");
    L8:
        r103.commitAllowingStateLoss();
        return;
    }
}
