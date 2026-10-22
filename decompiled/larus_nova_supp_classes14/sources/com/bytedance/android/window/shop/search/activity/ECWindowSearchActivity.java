package com.bytedance.android.window.shop.search.activity;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.ec.core.arch.viewmodel.c;
import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.ec.window.base.common.activity.ECWindowBaseActivity;
import com.bytedance.android.ec.window.base.repository.vo.WindowSearchSuggestWord;
import com.bytedance.android.window.shop.search.router.ECWindowSearchParam;
import com.bytedance.android.window.shop.search.viewmodel.WindowSearchViewModel;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.gyf.barlibrary.ImmersionBar;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/window/shop/search/activity/ECWindowSearchActivity;", "Lcom/bytedance/android/ec/window/base/common/activity/ECWindowBaseActivity;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowSearchActivity extends ECWindowBaseActivity implements QViewModelOwner {
    public static final /* synthetic */ int q = 0;
    public final QUIManager l;
    public boolean m;
    public final c n;
    public ImmersionBar o;
    public ViewGroup p;

    public static final class a {
    }

    static {
    }

    public ECWindowSearchActivity() {
        super(0);
        this.l = new QUIManager();
        Function0<ViewModelProvider.Factory> r0 = new ECWindowSearchActivity$viewModel$2(this);
        final Function0<FragmentActivity> r1 = new ECWindowSearchActivity$$special$$inlined$viewModels$1(this);
        this.n = com.bytedance.android.ec.core.arch.viewmodel.a.a(this, Reflection.getOrCreateKotlinClass(WindowSearchViewModel.class), new ECWindowSearchActivity$$special$$inlined$viewModels$2(r1), r0);
    }

    public final WindowSearchViewModel A1() {
        return (WindowSearchViewModel) this.n.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B1() {
        this.m = true;
        WindowSearchViewModel r1 = A1();
        Pair[] r2 = new Pair[7];
        r2[0] = TuplesKt.to("store_type", "window");
        r2[1] = TuplesKt.to("author_id", A1().getSearchParam().getStoreAccountParam().getUserId());
        String r0 = A1().getSearchParam().getShopId();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        r2[2] = TuplesKt.to("shop_id", r0);
        List<WindowSearchSuggestWord> r3 = A1().getSearchParam().getSearchSuggestWords();
        if (r3 == null) goto L10;
        WindowSearchSuggestWord r4 = (WindowSearchSuggestWord) CollectionsKt.firstOrNull(r3);
        if (r4 == null) goto L10;
        String r5 = r4.getWord();
    L11:
        r2[3] = TuplesKt.to("icon_content", r5);
        Integer r6 = A1().getSearchParam().getFollowStatus();
        if (r6 != null) goto L15;
    L17:
        String r7 = CommentScene.COMMENTSCENE_NO_AWEME;
    L18:
        r2[4] = TuplesKt.to("follow_status", r7);
        r2[5] = TuplesKt.to("entrance_info", A1().getSearchParam().getEntranceInfo());
        r2[6] = TuplesKt.to("page_name", A1().getSearchParam().getPageName());
        r1.doEventAction("search_process_page_show", r2);
        QUIManager r8 = this.l;
        ViewGroup r9 = this.p;
        if (r9 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("parentView");
    L21:
        r8.l(new vq3.a(r9), this, false);
        this.l.c(vq3.a.class, null);
        return;
    L15:
        if (r6.intValue() != (-1)) goto L17;
        r7 = "0";
    L10:
        r5 = null;
        goto L11
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(ECWindowSearchActivity.class.getName()));
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

    public final ViewModelProvider.Factory o6() {
        return new ViewModelProvider.NewInstanceFactory();
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ECWindowSearchActivity.class.getName()));
    L5:
        super.onDestroy();
        this.l.r(vq3.a.class);
        ImmersionBar r0 = this.o;
        if (r0 == null) goto L9;
        r0.destroy();
        return;
    }

    public final void onBackPressed() {
        if (Intrinsics.areEqual((Boolean) A1().getHistoryEditing().a(), Boolean.TRUE) == false) goto L6;
        A1().getHistoryEditing().g(Boolean.FALSE);
        return;
    L6:
        A1().setToNewPage(false);
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        finish();
    }

    public final void onPause() {
        super/*com.bytedance.ies.uikit.base.AbsActivity*/.onPause();
        A1().traceTimeEnd();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onResume() {
        super/*com.bytedance.ies.uikit.base.AbsActivity*/.onResume();
        A1().initSearchHistoryData(getApplicationContext());
        A1().traceTimeStart();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*com.bytedance.ies.uikit.base.AbsActivity*/.onStop();
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void y1() {
        super/*com.bytedance.ies.uikit.base.AbsActivity*/.y1();
        ImmersionBar r0 = ImmersionBar.with(this);
        this.o = r0;
        if (r0 == null) goto L8;
        ImmersionBar r1 = r0.statusBarDarkFont(true);
        if (r1 == null) goto L9;
        r1.init();
        return;
    L9:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r5) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L26
    L6:
        if (f.f(this) == false) goto L8;
        f.c(getTheme());     // Catch: Throwable -> L26
    L8:
        BtmSDK.INSTANCE.registerBtmPageOnCreate(this, "a1.b8121", getIntent().getStringExtra("source_btm_token"));
        Map r0 = wo.a.a;
        Intrinsics.checkNotNullParameter("ec_perf_duration_shop_search", "business");
        wo.a.a.put("ec_perf_duration_shop_search", i.a.create("ec_perf_duration_shop_search"));
        wo.a.b.put("ec_perf_duration_shop_search", new LinkedHashMap());
        wo.a.a("ec_perf_duration_shop_search", "initial", System.currentTimeMillis());
        super/*com.bytedance.ies.uikit.base.AbsActivity*/.onCreate(r5);
        WindowSearchViewModel r6 = A1();
        Serializable r1 = getIntent().getSerializableExtra("search_param");
        if (r1 == null) goto L25;
        r6.setSearchParam((ECWindowSearchParam) r1);
        A1().getSearchHint().g(A1().getSearchParam().getSearchHint());
        r r7 = r.a;
        if (r7.isLogin() == false) goto L16;
        A1().setUserId(r7.f());
        WindowSearchViewModel r8 = A1();
        String r2 = A1().getSearchParam().getAuthorId();
        if (r2 != null) goto L15;
        r2 = "";
    L15:
        r8.setMarketId(r2);
    L16:
        View r9 = LayoutInflater.from(this).inflate(2131561069, null, false);
        if (r9 == null) goto L23;
        ViewGroup r10 = (ViewGroup) r9;
        this.p = r10;
        setContentView(r10);
        View r11 = findViewById(2131387282);
        ViewGroup.LayoutParams r3 = r11.getLayoutParams();
        r3.height = j56.a.b(r11.getContext());
        B1();
        if (A1().getSearchParam().getEnableHideFloatLive() == false) goto L29;
        yn.a.a();
        return;
    L29:
        return;
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L25:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.search.router.ECWindowSearchParam");
    }

    public final void onActivityResult(int r3, int r4, Intent r5) {
        super/*com.bytedance.ies.uikit.base.AbsActivity*/.onActivityResult(r3, r4, r5);
        if (r4 == 10) goto L12;
        if (r4 == 11) goto L8;
        return;
    L8:
        if (this.m == true) goto L10;
        B1();
    L10:
        A1().getSearchContent().g("");
        A1().getSugRequestParam().getClass();
        ((ArrayList) A1().getSugRequestParam().a).clear();
        return;
    L12:
        if (this.m == true) goto L14;
        B1();
    L14:
        A1().getSugRequestParam().getClass();
        ((ArrayList) A1().getSugRequestParam().a).clear();
        ip.a r6 = A1().getSugRequestParam();
        if (r5 == null) goto L17;
        r5.getIntExtra("sug_enter_type", 3);
    L17:
        r6.getClass();
        WindowSearchViewModel r7 = A1();
        long r0 = 0;
        if (r5 == null) goto L20;
        r0 = r5.getLongExtra("sug_gap_time", 0);
    L20:
        r7.setPageDuration(r0);
    }
}
