package com.larus.canvas.feature;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.canvas.feature.redirect.DirectJump2ImageRemoveHelper;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.u;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.spi.chat.ObricChatUIDelegate;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0017\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\rH\u0014J\"\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0012H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\b\u0010\u001f\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u001a\u001a\u00020\u0012X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u0012X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001c¨\u0006!"}, d2 = {"Lcom/larus/canvas/feature/CreationCanvasActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", AppConstants.APP_FG, "Lcom/larus/canvas/feature/CreationCanvasFragment;", "useAlbumExitFlow", "", "getUseAlbumExitFlow", "()Z", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "getBackgroundResource", "needAdaptStatusBarPadding", "needAdaptNavigationBarPadding", "onBackPressed", "finishEnterAnimRes", "getFinishEnterAnimRes", "()I", "finishExitAnimRes", "getFinishExitAnimRes", VideoEventOneOutSync.END_TYPE_FINISH, "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CreationCanvasActivity extends FlowCommonAppCompatActivity {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CreationCanvasFragment f323012g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f323013h;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.canvas.feature.CreationCanvasActivity$onCreate$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.canvas.feature.CreationCanvasActivity$onCreate$2", f = "CreationCanvasActivity.kt", i = {}, l = {38}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CreationCanvasActivity this$0;

        public AnonymousClass2(CreationCanvasActivity r100, Continuation<? super AnonymousClass2> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L11:
            INVOKEVIRTUAL_com_larus_canvas_feature_CreationCanvasActivity$onCreate$2_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(this.this$0.getSupportFragmentManager().beginTransaction(), R.id.fragment_container, this.this$0.f323012g).commitNowAllowingStateLoss();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            DirectJump2ImageRemoveHelper r103 = DirectJump2ImageRemoveHelper.f323747a;
            CreationCanvasActivity r104 = this.this$0;
            Intent r105 = r104.getIntent();
            this.label = 1;
            if (r103.b(r104, r105, this) != r101) goto L11;
            return r101;
        }

        public static FragmentTransaction INVOKEVIRTUAL_com_larus_canvas_feature_CreationCanvasActivity$onCreate$2_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(FragmentTransaction r100, int r101, Fragment r102) {
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r100, r102, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r101) == false) goto L6;
            return r100;
        L6:
            return r100.replace(r101, r102);
        }
    }

    static {
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity
    public final boolean K1() {
        return false;
    }

    public boolean P1() {
        return false;
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity
    public final boolean H1() {
        return !ObricChatUIDelegate.f392858b.m();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        CreationCanvasFragment r100 = this.f323012g;
        r100.getClass();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r100), null, null, new CreationCanvasFragment$onBackPressed$1(r100, null), 3, null);
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
    }

    public CreationCanvasActivity() {
        this.f323012g = new CreationCanvasFragment();
        this.f323013h = R.anim.larus_router_slide_out_bottom;
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity
    public final int C1() {
        return v19.c.b(R.attr.larus_base_1_overlay, this, R.color.larus_base_1_overlay);
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0110 */
    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, O1());
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
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
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

    public int O1() {
        return this.f323013h;
    }

    public static View N1(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r110) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r110);
        setContentView(R.layout.larus_activity_fragment_container);
        Window r111 = getWindow();
        if (r111 == null) goto L13;
        View r112 = N1(r111);
    L14:
        setRootView(r112);
        L1();
        CreationCanvasFragment r113 = this.f323012g;
        Bundle r100 = new Bundle();
        Bundle r101 = getIntent().getExtras();
        if (r101 == null) goto L17;
        r100.putAll(r101);
    L17:
        r100.putBoolean("use_album_exit_flow", P1());
        r113.setArguments(r100);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain().getImmediate(), null, new AnonymousClass2(this, null), 2, null);
        if (ObricChatUIDelegate.f392858b.m() == true) goto L27;
        Window r114 = getWindow();
        if (r114 == null) goto L28;
        View r115 = N1(r114);
        if (r115 == null) goto L29;
        int r102 = u.b(this);
        int r103 = r115.getPaddingStart();
        int r104 = r115.getPaddingTop();
        int r105 = r115.getPaddingEnd();
        FLogger.f375446a.i("updatePaddingRelative", "view:" + r115.getClass().getSimpleName() + ",source:CreationCanvasActivity,start:" + r103 + ",top:" + r104 + ",end:" + r105 + ",bottom:" + r102);
        r115.setPaddingRelative(r103, r104, r105, r102);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L13:
        r112 = null;
        goto L14
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onSaveInstanceState(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "outState");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        super.onSaveInstanceState(r100);     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L14;
        FLogger.f375446a.e("CreationCanvasActivity", " onSaveInstanceState error", r103);
        finish();
        return;
    L14:
        return;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r110, int r111, Intent r112) {
        super.onActivityResult(r110, r111, r112);
        CreationCanvasFragment r100 = this.f323012g;
        r100.getClass();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r100), null, null, new CreationCanvasFragment$onResult$1(r100, r110, r111, r112, null), 3, null);
    }
}
