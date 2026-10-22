package com.bytedance.awemeopen.apps.framework.landscape;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.feed.profile.AosUserProfileFeedFragmentViewModel;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import com.bytedance.awemeopen.apps.framework.utils.AosPreloadHelper;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.domain.base.repo.GsonHolder;
import com.bytedance.awemeopen.domain.feed.preload.aweme.AosAwemePreloadManager;
import com.bytedance.awemeopen.export.api.pageconfig.recfeed.FeedPageConfig;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import r14.a0;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/landscape/VideoLandscapeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class VideoLandscapeActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f197107f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f197108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f197109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f197110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LandscapeVideoItemView f197111d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f197112e;

    public static final class a {
    }

    static {
    }

    public VideoLandscapeActivity() {
        new LinkedHashMap();
        this.f197108a = "";
        this.f197109b = "";
    }

    /* JADX INFO: Removed unreachable split cross block B:54:0x0111 */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if (this.f197110c == false) goto L6;
        overridePendingTransition(R.anim.landscape_reenter, R.anim.landscape_return);
    L6:
        if ((this instanceof ChatWindowActivity) == true) goto L47;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(VideoLandscapeActivity.class.getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L48
        if (r103 != null) goto L13;
    L16:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L48
        monitor-exit(r102);     // Catch: Throwable -> L48
    L45:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L51:
        return;
    L19:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L22;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L45
        goto L51
    L22:
        if (isFinishing() == true) goto L25;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L45
        goto L51
    L25:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L45
        goto L51
    L28:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L31;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L45
        goto L51
    L31:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L34;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L45
        goto L51
    L34:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L36;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L45
        goto L51
    L36:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L45
        if (r104 == null) goto L51;
        r104.addFlags(268435456);     // Catch: Throwable -> L45
        r104.addFlags(2097152);     // Catch: Throwable -> L45
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L45
        startActivity(r104);     // Catch: Throwable -> L42
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L45
        goto L51
    L13:
        if ((r101 - r103.longValue()) >= 800) goto L16;
        monitor-exit(r102);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        LandscapeVideoItemView r100 = this.f197111d;
        if (r100 == null) goto L5;
        r100.f197097m.getClass();
    L5:
        super.onBackPressed();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(VideoLandscapeActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        LandscapeVideoItemView r100 = this.f197111d;
        if (r100 == null) goto L57;
        long r110 = System.currentTimeMillis() - this.f197112e;
        r14.c r101 = r100.f197101q;
        if (r101 == null) goto L57;
        AosEventReporter r102 = AosEventReporter.f194596a;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.c r103 = r100.f197095k;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r101, "data");
        if (r110 == 0) goto L57;
        String r104 = r103.f195163c.sceneId();
        String r210 = r103.f195163c.getPageConfig().getHostEnterFrom();
        JSONObject r310 = r103.f195163c.getPageConfig().getHostExtraParams();
        FeedPageConfig r105 = r103.f195163c.getPageConfig();
        String r106 = null;
        if (Intrinsics.areEqual(r104, "others_homepage") == false) goto L18;
        o r107 = r103.f195163c;
        if ((r107 instanceof AosUserProfileFeedFragmentViewModel) == false) goto L15;
        AosUserProfileFeedFragmentViewModel r108 = (AosUserProfileFeedFragmentViewModel) r107;
    L16:
        if (r108 == null) goto L18;
        String r111 = r108.getFromGroupId();
    L19:
        d14.a r109 = b14.a.f16924a;
        t24.a r112 = (t24.a) b14.a.a(t24.a.class);
        String r113 = r101.c();
        String r114 = AosEventReporter.b(r101, r105);
        if (r114 != null) goto L22;
        String r115 = "";
    L23:
        a0 r116 = r101.f535622d;
        if (r116 == null) goto L29;
        String r117 = r116.a();
        if (r117 == null) goto L29;
        String r118 = r117;
    L30:
        String r119 = GsonProtectorUtils.toJson(GsonHolder.a(), r101.f535622d);
        boolean r120 = AosEventReporter.e(r101);
        boolean r121 = r101.f535638t;
        String r122 = r105.getPreviousPage();
        if (r122 != null) goto L33;
        String r211 = "";
    L35:
        if (r101.W() == false) goto L37;
        String r123 = PlayerResolution.SDKKEY.ORIGIN;
    L38:
        String r212 = r123;
        User r124 = r101.f();
        if (r124 == null) goto L44;
        String r125 = r124.u();
        if (r125 == null) goto L44;
        String r213 = r125;
    L45:
        boolean r126 = r105.isCardMode();
        a0 r127 = r101.f535622d;
        if (r127 == null) goto L48;
        r106 = r127.a();
    L48:
        if (r106 != null) goto L50;
        String r214 = "";
    L51:
        String r128 = r101.r().f535652d;
        if (r128 != null) goto L54;
        String r311 = "";
    L55:
        r112.q3(r104, r113, r115, r110, r118, r111, r119, r120, r121, "", false, r126, 0, "", "", null, r211, r212, r213, r210, r214, r311, null, r310);
        goto L57
    L54:
        r311 = r128;
        goto L55
    L50:
        r214 = r106;
    L44:
        r213 = "";
        goto L45
    L37:
        r123 = "sdk";
        goto L38
    L33:
        r211 = r122;
    L29:
        r118 = "";
        goto L30
    L22:
        r115 = r114;
        goto L23
    L15:
        r108 = null;
    L18:
        r111 = "";
    L57:
        if (isFinishing() == false) goto L74;
        LandscapeVideoItemView r129 = this.f197111d;
        if (r129 == null) goto L75;
        boolean r130 = true;
        AoLogger.b("LandscapeVideoItemView", new Object[]{r129.f197090f + " unSelected videoState = " + r129.f197088d + ", pendingSate = " + r129.f197089e});
        com.bytedance.awemeopen.apps.framework.card.video.a r131 = r129.f197088d;
        int r132 = r131.f193860a;
        if (r132 != 2) goto L63;
        boolean r133 = true;
    L64:
        if (r133 == false) goto L66;
        r131.f193860a = r132 - 1;
        r129.f197097m.l();
    L66:
        com.bytedance.awemeopen.apps.framework.card.video.a r134 = r129.f197089e;
        int r135 = r134.f193860a;
        if (r135 == 2) goto L70;
        r130 = false;
    L70:
        if (r130 == false) goto L72;
        r134.f193860a = r135 - 1;
    L72:
        d14.a r136 = b14.a.f16924a;
        ((t24.a) b14.a.a(t24.a.class)).z0(r129.f197100p);
        ((t24.a) b14.a.a(t24.a.class)).z0(r129.f197099o);
        return;
    L63:
        r133 = false;
        goto L64
    L75:
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        this.f197112e = System.currentTimeMillis();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (isFinishing() == false) goto L18;
        LandscapeVideoItemView r100 = this.f197111d;
        if (r100 == null) goto L13;
        AoLogger.b("LandscapeVideoItemView", new Object[]{"unBind " + r100.f197090f + " videoState = " + r100.f197088d + ", pendingSate = " + r100.f197089e});
        r100.f197092h.removePlayStateListener(r100.f197098n);
        r100.f197096l.f193859c = true;
        if (r100.f197088d.a() == false) goto L10;
        r100.f197097m.k();
        r100.f197088d.f193860a--;
        r100.f197086b.removeView(r100.f197094j);
    L10:
        if (r100.f197089e.a() == false) goto L12;
        r100.f197089e.f193860a--;
    L12:
        d14.a r101 = b14.a.f16924a;
        ((t24.a) b14.a.a(t24.a.class)).C0(false);
    L13:
        LandscapeVideoItemView r102 = this.f197111d;
        if (r102 == null) goto L16;
        d14.a r103 = b14.a.f16924a;
        ((t24.a) b14.a.a(t24.a.class)).z0(r102.f197100p);
        ((t24.a) b14.a.a(t24.a.class)).z0(r102.f197099o);
    L16:
        WeakReference<com.bytedance.awemeopen.infra.base.player.g> r104 = g.f197135a;
        AoLogger.b("land_player_holder", new Object[]{"clear(" + g.f197137c + "): " + g.f197135a.get()});
        g.f197135a.clear();
        g.f197136b.clear();
        g.f197137c = "";
    L18:
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L24;
        y1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L21
        return;
    L25:
        return;
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

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r100);
        getWindow().addFlags(128);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        if (Build.VERSION.SDK_INT < 28) goto L13;
        WindowManager.LayoutParams r101 = getWindow().getAttributes();
        r101.layoutInDisplayCutoutMode = 1;
        getWindow().setAttributes(r101);
    L13:
        y1(getWindow()).setSystemUiVisibility(1798);
        overridePendingTransition(0, 0);
        setContentView(R.layout.aos_activity_landscape_video);
        Bundle r102 = getIntent().getExtras();
        String r103 = null;
        if (r102 == null) goto L16;
        String r104 = r102.getString(SimilarProductParam.AWEME_ID);
    L17:
        if (r104 != null) goto L19;
        r104 = this.f197108a;
    L19:
        this.f197108a = r104;
        Bundle r105 = getIntent().getExtras();
        if (r105 == null) goto L22;
        r103 = r105.getString("host_enter_from");
    L22:
        if (r103 != null) goto L24;
        r103 = this.f197109b;
    L24:
        this.f197109b = r103;
        WeakReference<com.bytedance.awemeopen.infra.base.player.g> r106 = g.f197135a;
        if (g.a(this.f197108a) == null) goto L27;
        boolean r107 = true;
    L28:
        this.f197110c = r107;
        String r108 = this.f197108a;
        ViewGroup r109 = (ViewGroup) findViewById(R.id.root_view);
        l54.a r110 = new l54.a(this.f197109b);
        r110.f507507g.setLandscapeFullscreen(true);
        Unit r111 = Unit.INSTANCE;
        LandscapeVideoItemView r112 = new LandscapeVideoItemView(r108, this, r109, r110);
        this.f197111d = r112;
        n r113 = new n(this);
        Intrinsics.checkNotNullParameter(r113, "listener");
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.c r114 = r112.f197095k;
        r114.getClass();
        Intrinsics.checkNotNullParameter(r113, "listener");
        r114.f195178j = r113;
        r112.f197092h.f193879e = r113;
        LandscapeVideoItemView r115 = this.f197111d;
        if (r115 == null) goto L37;
        p44.c r116 = new p44.c(r108, CollectionsKt.emptyList());
        Intrinsics.checkNotNullParameter(r116, "videoItemInfo");
        AoLogger.b("LandscapeVideoItemView", new Object[]{"bind " + r116.f527664a + " videoState = " + r115.f197088d + ", pendingSate = " + r115.f197089e});
        r115.f197088d.f193860a = 0;
        r115.f197089e.f193860a = 0;
        d14.a r117 = b14.a.f16924a;
        ((t24.a) b14.a.a(t24.a.class)).C0(true);
        r115.f197090f = r116.f527664a;
        r115.f197092h.addPlayStateListener(r115.f197098n);
        AosAwemePreloadManager r118 = AosAwemePreloadManager.f198326a;
        r14.c r119 = AosAwemePreloadManager.a(r116.f527664a);
        if (r119 != null) goto L34;
        r115.f197089e.b();
        String r120 = r116.f527664a;
        AoLogger.b("LandscapeVideoItemView", new Object[]{r115.f197090f + " fetchAweme videoState = " + r115.f197088d + ", pendingSate = " + r115.f197089e});
        AosPreloadHelper r121 = AosPreloadHelper.f197655a;
        ArrayList r122 = CollectionsKt.arrayListOf(new String[]{r120});
        i r123 = new i(r115);
        String r124 = r115.f197087c.f507501a;
        Intrinsics.checkNotNullParameter(r122, "awemeIds");
        AosPreloadHelper.f197658d.d(r122, r123, r124);
        goto L37
    L34:
        if (r115.d() == false) goto L36;
        r115.b(r119, 0);
        goto L37
    L36:
        r115.f197089e.b();
        r115.c(r119, 0);
    L37:
        LandscapeVideoItemView r125 = this.f197111d;
        if (r125 == null) goto L40;
        r125.e();
    L40:
        LandscapeVideoItemView r126 = this.f197111d;
        if (r126 == null) goto L44;
        d14.a r127 = b14.a.f16924a;
        ((t24.a) b14.a.a(t24.a.class)).H1(r126.f197099o);
        ((t24.a) b14.a.a(t24.a.class)).H1(r126.f197100p);
    L44:
        if (this.f197110c == false) goto L49;
        overridePendingTransition(R.anim.landscape_enter, R.anim.landscape_exit);
        return;
    L49:
        return;
    L27:
        r107 = false;
        goto L28
    L16:
        r104 = null;
        goto L17
    }
}
