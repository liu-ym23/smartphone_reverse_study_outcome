package com.bytedance.android.shopping.deepfeed;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.hybrid.service.IMallDeepFeedAnimationService;
import com.bytedance.android.shopping.api.mall.opt.ECDeepFeedDomainPreConnectUtil;
import com.bytedance.android.shopping.api.video.ECVideoPlayerView;
import com.bytedance.android.shopping.deepfeed.data.DeepFeedProductDataCenter;
import com.bytedance.android.shopping.deepfeed.data.DeepFeedQueryParam;
import com.bytedance.android.shopping.deepfeed.fold.DeepFeedFoldHelper;
import com.bytedance.android.shopping.deepfeed.slice.view.video.DeepFeedSliceVideoEarlyWarmCenter;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.bytedance.ies.uikit.base.AbsActivity;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.gyf.barlibrary.ImmersionBar;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/DeepFeedProductActivity;", "Lcom/bytedance/ies/uikit/base/AbsActivity;", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedProductActivity extends AbsActivity {
    public static final Lazy l = null;
    public boolean j;
    public DeepFeedQueryParam k;

    public static final class a {
        public a() {
        }
    }

    static {
        new a();
        l = LazyKt.lazy(DeepFeedProductActivity$Companion$mallDeepFeedAnimationService$2.INSTANCE);
    }

    /* JADX INFO: Removed unreachable split cross block B:69:0x0128 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        if (this.j == true) goto L12;
        this.j = true;
        boolean r2 = ((IMallDeepFeedAnimationService) l.getValue()).a(this);     // Catch: Exception -> L7
    L13:
        if (r2 == true) goto L17;
        super.finish();
    L17:
        if ((this instanceof ChatWindowActivity) == true) goto L58;
        FLogger r3 = FLogger.a;
        r3.i("ActivityLancet", "finish ".concat(DeepFeedProductActivity.class.getName()));
        long r4 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L59
        if (r6 != null) goto L24;
    L27:
        r5.put(this, Long.valueOf(r4));     // Catch: Throwable -> L59
        monitor-exit(r5);     // Catch: Throwable -> L59
    L56:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L66:
        return;
    L30:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L33;
        r3.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L56
        goto L66
    L33:
        if (isFinishing() == true) goto L36;
        r3.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L56
        goto L66
    L36:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L39;
        r3.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L56
        goto L66
    L39:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L42;
        r3.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L56
        goto L66
    L42:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L45;
        r3.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L56
        goto L66
    L45:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L47;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L56
        goto L66
    L47:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L56
        if (r1 == null) goto L66;
        r1.addFlags(268435456);     // Catch: Throwable -> L56
        r1.addFlags(2097152);     // Catch: Throwable -> L56
        r3.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L56
        startActivity(r1);     // Catch: Throwable -> L53
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L56
        goto L66
    L24:
        if ((r4 - r6.longValue()) >= 800) goto L27;
        monitor-exit(r5);     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        throw th;
    L58:
        return;
    L7:
        e = move-exception;
        String r7 = e.getMessage();
        if (r7 != null) goto L11;
        r7 = "";
    L11:
        ECExceptionMonitor.c(r7);
    L12:
        r2 = false;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(DeepFeedProductActivity.class.getName()));
    L5:
        super.onDestroy();
        HashMap<String, com.bytedance.android.shopping.deepfeed.data.repo.l> r0 = DeepFeedProductDataCenter.a;
        int r1 = com.bytedance.android.shopping.deepfeed.data.b.a;
        DeepFeedProductDataCenter.b();
        ImmersionBar.with(this).destroy();
        IMallDeepFeedAnimationService r2 = (IMallDeepFeedAnimationService) l.getValue();
        if (r2 == null) goto L8;
        r2.clear();
    L8:
        Iterator<T> r3 = DeepFeedSliceVideoEarlyWarmCenter.a.values().iterator();
    L10:
        if (r3.hasNext() == false) goto L19;
        WeakReference<ECVideoPlayerView> r4 = ((DeepFeedSliceVideoEarlyWarmCenter.a) r3.next()).b;
        if (r4 == null) goto L10;
        ECVideoPlayerView r5 = r4.get();
        if (r5 == null) goto L10;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L17
        r5.x();     // Catch: Throwable -> L17
        r5.s();     // Catch: Throwable -> L17
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L19:
        DeepFeedSliceVideoEarlyWarmCenter.a.clear();
    }

    @Deprecated(message = "Deprecated in Java")
    public final void onBackPressed() {
        Iterator r0 = getSupportFragmentManager().getFragments().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        com.bytedance.android.shopping.deepfeed.action.g r1 = (Fragment) r0.next();
        if ((r1 instanceof com.bytedance.android.shopping.deepfeed.action.g) == false) goto L4;
        if (r1.mx() == false) goto L4;
        return;
    L10:
        ECDeepFeedDomainPreConnectUtil.a r2 = ECDeepFeedDomainPreConnectUtil.g;
        monitor-enter(r2);
        List r3 = CollectionsKt.toList(ECDeepFeedDomainPreConnectUtil.f);     // Catch: Throwable -> L20
        monitor-exit(r2);
        Iterator r4 = r3.iterator();
    L16:
        if (r4.hasNext() == false) goto L18;
        ECDeepFeedDomainPreConnectUtil r5 = (ECDeepFeedDomainPreConnectUtil) r4.next();
        r5.getClass();
        r5.e = Long.valueOf(System.currentTimeMillis());
        goto L16
    L18:
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        return;
    L20:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onResume() {
        super.onResume();
        ImmersionBar.with(this).transparentNavigationBar().init();
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

    public DeepFeedProductActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r8) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        overridePendingTransition(2130772245, 2130772253);
        if (r8 == null) goto L13;
        Serializable r2 = r8.getSerializable("deep_feed_query_params");
    L15:
        if ((r2 instanceof DeepFeedQueryParam) == true) goto L17;
        r2 = null;
    L17:
        DeepFeedQueryParam r3 = (DeepFeedQueryParam) r2;
        if (r3 != null) goto L33;
        Intent r4 = getIntent();
        if (r4 == null) goto L22;
        String r5 = r4.getStringExtra("deep_feed_param_cache_key");
    L23:
        if (r5 == null) goto L25;
        HashMap<String, com.bytedance.android.shopping.deepfeed.data.repo.l> r6 = DeepFeedProductDataCenter.a;
        Intrinsics.checkNotNullParameter(r5, "key");
        r3 = DeepFeedProductDataCenter.b.get(r5);
        goto L33
    L25:
        Intent r7 = getIntent();
        if (r7 == null) goto L28;
        Serializable r9 = r7.getSerializableExtra("deep_feed_query_params");
    L30:
        if ((r9 instanceof DeepFeedQueryParam) == true) goto L32;
        r9 = null;
    L32:
        r3 = (DeepFeedQueryParam) r9;
        goto L33
    L28:
        r9 = null;
        goto L30
    L22:
        r5 = null;
    L33:
        this.k = r3;
        BtmSDK r10 = BtmSDK.INSTANCE;
        if (r3 == null) goto L36;
        String r11 = r3.getSourceBtmToken();
    L37:
        r10.registerBtmPageOnCreate(this, "a1.b811296.c0.d0", r11);
        super.onCreate(r8);
        DeepFeedQueryParam r12 = this.k;
        if (r12 == null) goto L61;
        ConcurrentHashMap<String, DeepFeedSliceVideoEarlyWarmCenter.a> r13 = DeepFeedSliceVideoEarlyWarmCenter.a;
        Iterator r14 = ((ArrayList) DeepFeedProductDataCenter.a(r12).c).iterator();
    L41:
        if (r14.hasNext() == false) goto L45;
        Object r15 = r14.next();
        if ((!((InFeedProductV2) r15).isSkeletonData()) == false) goto L41;
    L46:
        InFeedProductV2 r16 = (InFeedProductV2) r15;
        Intrinsics.checkNotNullParameter(this, "context");
        tc3.c r17 = tc3.d.a;
        if (r17.a() == true) goto L50;
        r17 = null;
    L50:
        if (r17 == null) goto L61;
        com.bytedance.android.shopping.deepfeed.slice.view.video.c r18 = DeepFeedSliceVideoEarlyWarmCenter.c(r16);
        if (r18 == null) goto L61;
        if (r17.d() == false) goto L59;
        DeepFeedSliceVideoEarlyWarmCenter.e(this, r18, r17.f());
    L59:
        if (r17.e() == false) goto L61;
        DeepFeedSliceVideoEarlyWarmCenter.f(this, r18);
        goto L61
    L45:
        r15 = null;
    L61:
        DeepFeedFoldHelper.a();
        if (DeepFeedProductDataCenter.b() == false) goto L66;
        FrameLayout r19 = new FrameLayout(this);
        r19.setId(2131372737);
        r19.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setContentView(r19);
        DeepFeedQueryParam r20 = this.k;
        if (r20 == null) goto L67;
        ((com.bytedance.android.shopping.deepfeed.data.repo.j) DeepFeedProductDataCenter.a(r20).g()).o = 1;
    L67:
        ImmersionBar.with(this).transparentNavigationBar().init();
        ((IMallDeepFeedAnimationService) l.getValue()).c(this);     // Catch: Exception -> L70
    L75:
        Fragment r21 = getSupportFragmentManager().findFragmentById(2131372737);
        if ((r21 instanceof DeepFeedProductFragment) == true) goto L78;
        r21 = null;
    L78:
        DeepFeedProductFragment r22 = (DeepFeedProductFragment) r21;
        if (r22 != null) goto L91;
        r22 = new DeepFeedProductFragment();
        Intent r23 = getIntent();
        if (r23 == null) goto L84;
        Bundle r24 = r23.getExtras();
        if (r24 == null) goto L84;
    L85:
        Bundle r25 = new Bundle(r24);
        if (r25.containsKey("deep_feed_param_cache_key") == true) goto L90;
        DeepFeedQueryParam r26 = this.k;
        if (r26 == null) goto L90;
        r25.putSerializable("deep_feed_query_params", r26);
    L90:
        r22.setArguments(r25);
    L84:
        r24 = new Bundle();
    L91:
        FragmentTransaction r1 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r22, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131372737) == true) goto L95;
        r1 = r1.replace(2131372737, r22);
    L95:
        r1.commitAllowingStateLoss();
        return;
    L70:
        e = move-exception;
        String r27 = e.getMessage();
        if (r27 != null) goto L74;
        r27 = "";
    L74:
        ECExceptionMonitor.c(r27);
        goto L75
    L66:
        setContentView(2131564640);
        goto L67
    L36:
        r11 = null;
        goto L37
    L13:
        r2 = null;
        goto L15
    }

    public final void onSaveInstanceState(Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "outState");
        super.onSaveInstanceState(r3);
        DeepFeedQueryParam r0 = this.k;
        if (r0 == null) goto L6;
        r3.putSerializable("deep_feed_query_params", r0);
        return;
    }
}
