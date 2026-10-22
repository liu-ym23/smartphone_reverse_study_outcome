package com.bytedance.awemeopen.apps.framework.feed.mix;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment;
import com.bytedance.awemeopen.apps.framework.framework.AosSimpleBaseActivity;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/mix/MixAwemeFeedActivity;", "Lcom/bytedance/awemeopen/apps/framework/framework/AosSimpleBaseActivity;", "Lcom/bytedance/awemeopen/apps/framework/feed/ui/seekbar/c;", "Lo54/a;", "<init>", "()V", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class MixAwemeFeedActivity extends AosSimpleBaseActivity implements com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.c, o54.a {
    public static r14.c j;
    public MixAwemeFeedFragment a;
    public String b;
    public String c;
    public Integer d;
    public String e;
    public final long f;
    public final Lazy g;
    public boolean h;
    public Handler i;

    public static final class a {
    }

    static {
    }

    public final void a1() {
        this.h = true;
        Handler r0 = this.i;
        if (r0 == null) goto L5;
        r0.removeCallbacksAndMessages(null);
    L5:
        Handler r1 = this.i;
        if (r1 == null) goto L9;
        r1.postDelayed(new b(this), this.f);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseActivity
    public final boolean y1() {
        return false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosSimpleBaseActivity, com.bytedance.awemeopen.apps.framework.framework.AosBaseActivity
    public final int z1() {
        return 2131558579;
    }

    public MixAwemeFeedActivity() {
        new LinkedHashMap();
        this.f = 600;
        this.g = LazyKt.lazy(new MixAwemeFeedActivity$bottomBar$2(this));
    }

    /* JADX INFO: Removed unreachable split cross block B:54:0x010f */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.AosSimpleBaseActivity, com.bytedance.awemeopen.apps.framework.framework.AosBaseActivity
    public final void finish() {
        super.finish();
        MixAwemeFeedFragment r2 = this.a;
        if (r2 == null) goto L6;
        r2.H.getValue();
        Unit r3 = Unit.INSTANCE;
    L6:
        if ((this instanceof ChatWindowActivity) == true) goto L47;
        FLogger r4 = FLogger.a;
        r4.i("ActivityLancet", "finish ".concat(MixAwemeFeedActivity.class.getName()));
        long r5 = SystemClock.uptimeMillis();
        Map r6 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r6);
        Long r7 = (Long) r6.get(this);     // Catch: Throwable -> L48
        if (r7 != null) goto L13;
    L16:
        r6.put(this, Long.valueOf(r5));     // Catch: Throwable -> L48
        monitor-exit(r6);     // Catch: Throwable -> L48
    L45:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L51:
        return;
    L19:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L22;
        r4.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L45
        goto L51
    L22:
        if (isFinishing() == true) goto L25;
        r4.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L45
        goto L51
    L25:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L28;
        r4.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L45
        goto L51
    L28:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L31;
        r4.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L45
        goto L51
    L31:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L34;
        r4.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L45
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
        r4.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L45
        startActivity(r1);     // Catch: Throwable -> L42
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L45
        goto L51
    L13:
        if ((r5 - r7.longValue()) >= 800) goto L16;
        monitor-exit(r6);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosSimpleBaseActivity, com.bytedance.awemeopen.apps.framework.framework.AosBaseActivity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(MixAwemeFeedActivity.class.getName()));
    L5:
        super.onDestroy();
        j = null;
        Handler r1 = this.i;
        if (r1 == null) goto L8;
        r1.removeCallbacksAndMessages(null);
    L8:
        this.i = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.AosSimpleBaseActivity, com.bytedance.awemeopen.apps.framework.framework.AosBaseActivity
    public final void B1() {
        this.b = getIntent().getStringExtra("mixId");
        this.c = getIntent().getStringExtra("mixName");
        this.d = Integer.valueOf(getIntent().getIntExtra("updateEpisode", 0));
        this.e = getIntent().getStringExtra("scene_id_enter_from");
        TextView r0 = (TextView) findViewById(2131380172);
        if (r0 == null) goto L6;
        r0.setText(this.c);
    L6:
        TextView r1 = (TextView) findViewById(2131380176);
        if (r1 == null) goto L10;
        r1.setText(getResources().getString(2131894235, new Object[]{this.d}));
    L10:
        MixAwemeFeedViewModel.a r2 = MixAwemeFeedViewModel.Companion;
        r14.c r3 = j;
        r2.getClass();
        MixAwemeFeedViewModel.access$setTempMixAweme$cp(r3);
        int r4 = com.bytedance.awemeopen.apps.framework.utils.d.a;
        n44.a r5 = getSupportFragmentManager().findFragmentByTag("tag_MixAwemeFeedFragment");
        if ((r5 instanceof MixAwemeFeedFragment) == true) goto L17;
        Object r6 = MixAwemeFeedFragment.class.newInstance();
        if (r6 == null) goto L16;
        r5 = (MixAwemeFeedFragment) r6;
    L18:
        AosBaseFragment r7 = (AosBaseFragment) r5;
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.bytedance.awemeopen.apps.framework.feed.mix.MixAwemeFeedFragment");
        MixAwemeFeedFragment r8 = (MixAwemeFeedFragment) r7;
        this.a = r8;
        Intrinsics.checkNotNull(r8);
        Bundle r9 = new Bundle();
        r9.putString("mixId", this.b);
        r9.putString("scene_id_enter_from", this.e);
        r9.putInt("currentEpisode", getIntent().getIntExtra("currentEpisode", -1));
        r9.putLong("currentPosition", getIntent().getLongExtra("currentPosition", -1));
        r8.setArguments(r9);
        FragmentManager r10 = getSupportFragmentManager();
        MixAwemeFeedFragment r11 = this.a;
        Intrinsics.checkNotNull(r11);
        com.bytedance.awemeopen.apps.framework.utils.d.a.c(r10, 2131372710, r11, "tag_MixAwemeFeedFragment");
        View r12 = findViewById(2131380168);
        if (r12 == null) goto L21;
        r12.setOnClickListener(new com.bytedance.awemeopen.apps.framework.feed.mix.a(this));
    L21:
        this.i = new Handler(Looper.getMainLooper());
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.awemeopen.apps.framework.feed.mix.MixAwemeFeedFragment");
    L17:
        AosBaseFragment r13 = (AosBaseFragment) r5;
        goto L18
    }

    public final void W() {
        View r0 = findViewById(2131380169);
        if (r0 == null) goto L7;
        r0.setVisibility(8);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.c
    public final int getBottomMargin() {
        return getResources().getDimensionPixelOffset(2131165332);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r0 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.c
    public final ViewGroup w0() {
        return (ViewGroup) findViewById(2131384828);
    }
}
