package com.bytedance.awemeopen.apps.framework.landscape;

import android.R;
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
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/landscape/VideoLandscapeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class VideoLandscapeActivity extends AppCompatActivity {
    public static final /* synthetic */ int f = 0;
    public String a;
    public String b;
    public boolean c;
    public LandscapeVideoItemView d;
    public long e;

    public static final class a {
    }

    static {
    }

    public VideoLandscapeActivity() {
        new LinkedHashMap();
        this.a = "";
        this.b = "";
    }

    /* JADX INFO: Removed unreachable split cross block B:54:0x0111 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if (this.c == false) goto L6;
        overridePendingTransition(2130772333, 2130772334);
    L6:
        if ((this instanceof ChatWindowActivity) == true) goto L47;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(VideoLandscapeActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L48
        if (r6 != null) goto L13;
    L16:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L48
        monitor-exit(r5);     // Catch: Throwable -> L48
    L45:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L51:
        return;
    L19:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L22;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L45
        goto L51
    L22:
        if (isFinishing() == true) goto L25;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L45
        goto L51
    L25:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L45
        goto L51
    L28:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L31;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L45
        goto L51
    L31:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L34;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L45
        goto L51
    L34:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L36;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L45
        goto L51
    L36:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L45
        if (r1 == null) goto L51;
        r1.addFlags(268435456);     // Catch: Throwable -> L45
        r1.addFlags(2097152);     // Catch: Throwable -> L45
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L45
        startActivity(r1);     // Catch: Throwable -> L42
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L45
        goto L51
    L13:
        if ((r3 - r6.longValue()) >= 800) goto L16;
        monitor-exit(r5);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    }

    public final void onBackPressed() {
        LandscapeVideoItemView r0 = this.d;
        if (r0 == null) goto L5;
        r0.m.getClass();
    L5:
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(VideoLandscapeActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onPause() {
        super/*androidx.fragment.app.FragmentActivity*/.onPause();
        LandscapeVideoItemView r1 = this.d;
        if (r1 == null) goto L57;
        long r10 = System.currentTimeMillis() - this.e;
        r14.c r2 = r1.q;
        if (r2 == null) goto L57;
        AosEventReporter r3 = AosEventReporter.a;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.c r4 = r1.k;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r2, "data");
        if (r10 == 0) goto L57;
        String r7 = r4.c.sceneId();
        String r28 = r4.c.getPageConfig().getHostEnterFrom();
        JSONObject r32 = r4.c.getPageConfig().getHostExtraParams();
        FeedPageConfig r5 = r4.c.getPageConfig();
        String r6 = null;
        if (Intrinsics.areEqual(r7, "others_homepage") == false) goto L18;
        o r8 = r4.c;
        if ((r8 instanceof AosUserProfileFeedFragmentViewModel) == false) goto L15;
        AosUserProfileFeedFragmentViewModel r9 = (AosUserProfileFeedFragmentViewModel) r8;
    L16:
        if (r9 == null) goto L18;
        String r13 = r9.getFromGroupId();
    L19:
        d14.a r11 = b14.a.a;
        t24.a r12 = b14.a.a(t24.a.class);
        String r14 = r2.c();
        String r15 = AosEventReporter.b(r2, r5);
        if (r15 != null) goto L22;
        String r16 = "";
    L23:
        a0 r17 = r2.d;
        if (r17 == null) goto L29;
        String r18 = r17.a();
        if (r18 == null) goto L29;
        String r19 = r18;
    L30:
        String r110 = GsonProtectorUtils.toJson(GsonHolder.a(), r2.d);
        boolean r111 = AosEventReporter.e(r2);
        boolean r20 = r2.t;
        String r112 = r5.getPreviousPage();
        if (r112 != null) goto L33;
        String r25 = "";
    L35:
        if (r2.W() == false) goto L37;
        String r113 = "origin";
    L38:
        String r26 = r113;
        User r114 = r2.f();
        if (r114 == null) goto L44;
        String r115 = r114.u();
        if (r115 == null) goto L44;
        String r27 = r115;
    L45:
        boolean r116 = r5.isCardMode();
        a0 r21 = r2.d;
        if (r21 == null) goto L48;
        r6 = r21.a();
    L48:
        if (r6 != null) goto L50;
        String r29 = "";
    L51:
        String r22 = r2.r().d;
        if (r22 != null) goto L54;
        String r30 = "";
    L55:
        r12.q3(r7, r14, r16, r10, r19, r13, r110, r111, r20, "", false, r116, 0, "", "", null, r25, r26, r27, r28, r29, r30, null, r32);
        goto L57
    L54:
        r30 = r22;
        goto L55
    L50:
        r29 = r6;
    L44:
        r27 = "";
        goto L45
    L37:
        r113 = "sdk";
        goto L38
    L33:
        r25 = r112;
    L29:
        r19 = "";
        goto L30
    L22:
        r16 = r15;
        goto L23
    L15:
        r9 = null;
    L18:
        r13 = "";
    L57:
        if (isFinishing() == false) goto L74;
        LandscapeVideoItemView r23 = this.d;
        if (r23 == null) goto L75;
        boolean r24 = true;
        AoLogger.b("LandscapeVideoItemView", new Object[]{r23.f + " unSelected videoState = " + r23.d + ", pendingSate = " + r23.e});
        com.bytedance.awemeopen.apps.framework.card.video.a r31 = r23.d;
        int r33 = r31.a;
        if (r33 != 2) goto L63;
        boolean r34 = true;
    L64:
        if (r34 == false) goto L66;
        r31.a = r33 - 1;
        r23.m.l();
    L66:
        com.bytedance.awemeopen.apps.framework.card.video.a r35 = r23.e;
        int r36 = r35.a;
        if (r36 == 2) goto L70;
        r24 = false;
    L70:
        if (r24 == false) goto L72;
        r35.a = r36 - 1;
    L72:
        d14.a r37 = b14.a.a;
        b14.a.a(t24.a.class).z0(r23.p);
        b14.a.a(t24.a.class).z0(r23.o);
        return;
    L63:
        r34 = false;
        goto L64
    L75:
        return;
    }

    public final void onResume() {
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        this.e = System.currentTimeMillis();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super.onStop();
        if (isFinishing() == false) goto L18;
        LandscapeVideoItemView r0 = this.d;
        if (r0 == null) goto L13;
        AoLogger.b("LandscapeVideoItemView", new Object[]{"unBind " + r0.f + " videoState = " + r0.d + ", pendingSate = " + r0.e});
        r0.h.removePlayStateListener(r0.n);
        r0.l.c = true;
        if (r0.d.a() == false) goto L10;
        r0.m.k();
        r0.d.a--;
        r0.b.removeView(r0.j);
    L10:
        if (r0.e.a() == false) goto L12;
        r0.e.a--;
    L12:
        d14.a r1 = b14.a.a;
        b14.a.a(t24.a.class).C0(false);
    L13:
        LandscapeVideoItemView r2 = this.d;
        if (r2 == null) goto L16;
        d14.a r3 = b14.a.a;
        b14.a.a(t24.a.class).z0(r2.p);
        b14.a.a(t24.a.class).z0(r2.o);
    L16:
        WeakReference<com.bytedance.awemeopen.infra.base.player.g> r4 = g.a;
        AoLogger.b("land_player_holder", new Object[]{"clear(" + g.c + "): " + g.a.get()});
        g.a.clear();
        g.b.clear();
        g.c = "";
    L18:
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L24;
        y1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L21
        return;
    L25:
        return;
    }

    public static View y1(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r9) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r9);
        getWindow().addFlags(128);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        if (Build.VERSION.SDK_INT < 28) goto L13;
        WindowManager.LayoutParams r0 = getWindow().getAttributes();
        r0.layoutInDisplayCutoutMode = 1;
        getWindow().setAttributes(r0);
    L13:
        y1(getWindow()).setSystemUiVisibility(1798);
        overridePendingTransition(0, 0);
        setContentView(2131558578);
        Bundle r1 = getIntent().getExtras();
        String r2 = null;
        if (r1 == null) goto L16;
        String r3 = r1.getString("aweme_id");
    L17:
        if (r3 != null) goto L19;
        r3 = this.a;
    L19:
        this.a = r3;
        Bundle r4 = getIntent().getExtras();
        if (r4 == null) goto L22;
        r2 = r4.getString("host_enter_from");
    L22:
        if (r2 != null) goto L24;
        r2 = this.b;
    L24:
        this.b = r2;
        WeakReference<com.bytedance.awemeopen.infra.base.player.g> r5 = g.a;
        if (g.a(this.a) == null) goto L27;
        boolean r6 = true;
    L28:
        this.c = r6;
        String r7 = this.a;
        ViewGroup r8 = (ViewGroup) findViewById(2131384840);
        l54.a r10 = new l54.a(this.b);
        r10.g.setLandscapeFullscreen(true);
        Unit r11 = Unit.INSTANCE;
        LandscapeVideoItemView r12 = new LandscapeVideoItemView(r7, this, r8, r10);
        this.d = r12;
        n r13 = new n(this);
        Intrinsics.checkNotNullParameter(r13, "listener");
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.c r14 = r12.k;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r13, "listener");
        r14.j = r13;
        r12.h.e = r13;
        LandscapeVideoItemView r15 = this.d;
        if (r15 == null) goto L37;
        p44.c r16 = new p44.c(r7, CollectionsKt.emptyList());
        Intrinsics.checkNotNullParameter(r16, "videoItemInfo");
        AoLogger.b("LandscapeVideoItemView", new Object[]{"bind " + r16.a + " videoState = " + r15.d + ", pendingSate = " + r15.e});
        r15.d.a = 0;
        r15.e.a = 0;
        d14.a r17 = b14.a.a;
        b14.a.a(t24.a.class).C0(true);
        r15.f = r16.a;
        r15.h.addPlayStateListener(r15.n);
        AosAwemePreloadManager r18 = AosAwemePreloadManager.a;
        r14.c r19 = AosAwemePreloadManager.a(r16.a);
        if (r19 != null) goto L34;
        r15.e.b();
        String r20 = r16.a;
        AoLogger.b("LandscapeVideoItemView", new Object[]{r15.f + " fetchAweme videoState = " + r15.d + ", pendingSate = " + r15.e});
        AosPreloadHelper r21 = AosPreloadHelper.a;
        ArrayList r22 = CollectionsKt.arrayListOf(new String[]{r20});
        i r23 = new i(r15);
        String r24 = r15.c.a;
        Intrinsics.checkNotNullParameter(r22, "awemeIds");
        AosPreloadHelper.d.d(r22, r23, r24);
        goto L37
    L34:
        if (r15.d() == false) goto L36;
        r15.b(r19, 0);
        goto L37
    L36:
        r15.e.b();
        r15.c(r19, 0);
    L37:
        LandscapeVideoItemView r25 = this.d;
        if (r25 == null) goto L40;
        r25.e();
    L40:
        LandscapeVideoItemView r26 = this.d;
        if (r26 == null) goto L44;
        d14.a r27 = b14.a.a;
        b14.a.a(t24.a.class).H1(r26.o);
        b14.a.a(t24.a.class).H1(r26.p);
    L44:
        if (this.c == false) goto L49;
        overridePendingTransition(2130772331, 2130772332);
        return;
    L49:
        return;
    L27:
        r6 = false;
        goto L28
    L16:
        r3 = null;
        goto L17
    }
}
