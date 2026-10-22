package com.bytedance.ee.android.file.picker.lib.v2.ui;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.android.file.picker.lib.databinding.FilePickerConfirmActivityBinding;
import com.bytedance.ee.android.file.picker.lib.v2.ui.confirm.ConfirmAdapter;
import com.bytedance.ee.android.file.picker.lib.v2.ui.confirm.ConfirmViewModel;
import com.bytedance.ee.android.file.picker.lib.v2.ui.main.FilePickerViewModel;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.h6ah4i.android.widget.advrecyclerview.animator.RefactoredDefaultItemAnimator;
import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;
import com.larksuite.arch.jack.JackView;
import com.larksuite.arch.jack.JackViewModel;
import com.larksuite.framework.utils.UIUtils;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.ui.CommonTitleBarConstants;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u001aH\u0002J\b\u0010\u001e\u001a\u00020\u001aH\u0002J\b\u0010\u001f\u001a\u00020\u001aH\u0002J\b\u0010 \u001a\u00020\u001aH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/bytedance/ee/android/file/picker/lib/v2/ui/ConfirmActivity;", "Lcom/ss/android/lark/base/fragment/BaseFragmentActivity;", "Lcom/larksuite/arch/jack/JackView;", "<init>", "()V", "mBinding", "Lcom/bytedance/ee/android/file/picker/lib/databinding/FilePickerConfirmActivityBinding;", "mViewModel", "Lcom/bytedance/ee/android/file/picker/lib/v2/ui/confirm/ConfirmViewModel;", "getMViewModel", "()Lcom/bytedance/ee/android/file/picker/lib/v2/ui/confirm/ConfirmViewModel;", "mViewModel$delegate", "Lcom/larksuite/arch/jack/LifecycleAwareLazy;", "mCategoryConfigManager", "Lcom/bytedance/ee/android/file/picker/lib/v2/data/category/FileCategoryConfigManager;", "getMCategoryConfigManager", "()Lcom/bytedance/ee/android/file/picker/lib/v2/data/category/FileCategoryConfigManager;", "setMCategoryConfigManager", "(Lcom/bytedance/ee/android/file/picker/lib/v2/data/category/FileCategoryConfigManager;)V", "mAdapter", "Lcom/bytedance/ee/android/file/picker/lib/v2/ui/confirm/ConfirmAdapter;", "getMAdapter", "()Lcom/bytedance/ee/android/file/picker/lib/v2/ui/confirm/ConfirmAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "initView", "initListeners", "initSubscribers", "onSave", "Companion", "file-picker-lib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@AndroidEntryPoint
public final class ConfirmActivity extends Hilt_ConfirmActivity implements JackView {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f206048h = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FilePickerConfirmActivityBinding f206049d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.larksuite.arch.jack.h f206050e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Inject
    public sm4.b f206051f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f206052g;

    public static final class a {
    }

    static {
    }

    @Override // com.larksuite.arch.jack.i
    public final LifecycleOwner getLifecycleOwner() {
        return this;
    }

    @Override // com.larksuite.arch.jack.f
    public final com.larksuite.arch.jack.i getLifecycleOwnerHolder() {
        return this;
    }

    @Override // com.bytedance.ee.android.file.picker.lib.v2.ui.Hilt_ConfirmActivity, com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ConfirmActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    public ConfirmActivity() {
        Function0<ViewModelProvider.Factory> r100 = new ConfirmActivity$mViewModel$2(this);
        final KClass r101 = Reflection.getOrCreateKotlinClass(ConfirmViewModel.class);
        Function0<String> r102 = new ConfirmActivity$special$$inlined$viewModel$default$1(r101);
        ConfirmActivity$special$$inlined$viewModel$default$2 r103 = ConfirmActivity$special$$inlined$viewModel$default$2.INSTANCE;
        this.f206050e = new com.larksuite.arch.jack.h(r101, r102, new ConfirmActivity$special$$inlined$viewModel$default$3(this), r100, r103);
        this.f206052g = LazyKt.lazy(new ConfirmActivity$mAdapter$2(this));
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    @Override // com.bytedance.ee.android.file.picker.lib.v2.ui.Hilt_ConfirmActivity, com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(ConfirmActivity.class.getName()));
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

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
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

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r100);
        FilePickerConfirmActivityBinding r101 = null;
        View r102 = getLayoutInflater().inflate(com.larus.nova.R.layout.file_picker_confirm_activity, null, false);
        int r103 = com.larus.nova.R.id.recycler_view;
        RecyclerView r104 = (RecyclerView) ViewBindings.findChildViewById(r102, com.larus.nova.R.id.recycler_view);
        if (r104 == null) goto L39;
        r103 = com.larus.nova.R.id.title_bar;
        CommonTitleBar r105 = (CommonTitleBar) ViewBindings.findChildViewById(r102, com.larus.nova.R.id.title_bar);
        if (r105 == null) goto L39;
        ConstraintLayout r106 = (ConstraintLayout) r102;
        this.f206049d = new FilePickerConfirmActivityBinding(r106, r104, r105);
        setContentView(r106);
        FilePickerConfirmActivityBinding r107 = this.f206049d;
        if (r107 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        r107 = null;
    L17:
        r107.f205978c.setLeftImageResource(CommonTitleBarConstants.ICON_CLOSE);
        FilePickerConfirmActivityBinding r108 = this.f206049d;
        if (r108 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        r108 = null;
    L20:
        r108.f205977b.setLayoutManager(new LinearLayoutManager(this, 1, false));
        RecyclerViewExpandableItemManager r109 = new RecyclerViewExpandableItemManager();
        FilePickerConfirmActivityBinding r110 = this.f206049d;
        if (r110 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        r110 = null;
    L23:
        r110.f205977b.setAdapter(r109.b((ConfirmAdapter) this.f206052g.getValue()));
        FilePickerConfirmActivityBinding r111 = this.f206049d;
        if (r111 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        r111 = null;
    L26:
        r109.a(r111.f205977b);
        RefactoredDefaultItemAnimator r112 = new RefactoredDefaultItemAnimator();
        r112.setSupportsChangeAnimations(false);
        FilePickerConfirmActivityBinding r113 = this.f206049d;
        if (r113 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        r113 = null;
    L29:
        r113.f205977b.setItemAnimator(r112);
        FilePickerConfirmActivityBinding r114 = this.f206049d;
        if (r114 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        r114 = null;
    L32:
        r114.f205978c.setLeftClickListener(new com.bytedance.ee.android.file.picker.lib.v2.ui.a(this));
        String r115 = UIUtils.getString(this, com.larus.nova.R.string.Lark_Legacy_Save);
        FilePickerConfirmActivityBinding r116 = this.f206049d;
        if (r116 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
    L36:
        r101.f205978c.addAction(new b(r115, this));
        ((ConfirmAdapter) this.f206052g.getValue()).f206093d = new ConfirmActivity$initListeners$3((ConfirmViewModel) this.f206050e.getValue());
        com.larksuite.arch.jack.f.a.e(this, (ConfirmViewModel) this.f206050e.getValue(), ConfirmActivity$initSubscribers$1.INSTANCE, new ConfirmActivity$initSubscribers$2(this));
        com.larksuite.arch.jack.f.a.e(this, (ConfirmViewModel) this.f206050e.getValue(), ConfirmActivity$initSubscribers$3.INSTANCE, new ConfirmActivity$initSubscribers$4(this));
        return;
    L35:
        r101 = r116;
    L39:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }

    @Override // com.larksuite.arch.jack.f
    public final <S extends com.larksuite.arch.jack.j> com.larksuite.arch.jack.c nH(JackViewModel<S> r100, com.larksuite.arch.jack.l<S> r101, Function1<? super S, Unit> r102) {
        return JackView.a.d(this, r100, r101, r102);
    }

    @Override // com.larksuite.arch.jack.f
    public final com.larksuite.arch.jack.c Ik(JackViewModel r100, PropertyReference1Impl r101, com.larksuite.arch.jack.l r102, Function1 r103) {
        return JackView.a.a(this, r100, r101, r102, r103);
    }

    @Override // com.larksuite.arch.jack.f
    public final com.larksuite.arch.jack.c Ki(JackViewModel r100, PropertyReference1Impl r101, PropertyReference1Impl r102, com.larksuite.arch.jack.l r103, Function1 r104) {
        return JackView.a.b(this, r100, r101, r102, r103, r104);
    }

    @Override // com.larksuite.arch.jack.f
    public final com.larksuite.arch.jack.c O60(FilePickerViewModel r100, PropertyReference1Impl r101, PropertyReference1Impl r102, PropertyReference1Impl r103, com.larksuite.arch.jack.l r104, Function1 r105) {
        return JackView.a.c(this, r100, r101, r102, r103, r104, r105);
    }
}
