package com.ss.android.lark.compose.groupinfo;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.activity.compose.ComponentActivityKt;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.im.sdk.ImSdk;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import f0c.h;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes35.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0007\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0012B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013²\u0006\n\u0010\u0014\u001a\u00020\u0015X\u008a\u0084\u0002"}, d2 = {"Lcom/ss/android/lark/compose/groupinfo/FlowGroupInfoActivity;", "Lcom/ss/android/lark/base/fragment/BaseFragmentActivity;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "photoPicker", "Lcom/ss/android/lark/biz/officesdk/im/photopicker/IOfficeSDKPhotoPicker;", "getPhotoPicker", "()Lcom/ss/android/lark/biz/officesdk/im/photopicker/IOfficeSDKPhotoPicker;", "photoPicker$delegate", "Lkotlin/Lazy;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", VideoEventOneOutSync.END_TYPE_FINISH, "Companion", "flow-chat_productionChinaRelease", "viewModel", "Lcom/ss/android/lark/compose/groupinfo/GroupInfoViewModel;"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowGroupInfoActivity extends Hilt_FlowGroupInfoActivity implements d0c.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f417688c = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f417689b;

    public static final class a {
    }

    public static final class b<O> implements ActivityResultCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<O> f417690a = null;

        static {
            f417690a = new b();
        }

        public b() {
        }

        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object r100) {
            int r101 = com.ss.android.lark.compose.groupinfo.c.f417711a;
            com.ss.android.lark.compose.groupinfo.c.b("FlowGroupInfoActivity pickLauncher " + ((Uri) r100));
        }
    }

    public static final class c<O> implements ActivityResultCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Lazy<GroupInfoViewModel> f417691a;

        public c(ViewModelLazy r100) {
            this.f417691a = r100;
        }

        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object r100) {
            ActivityResult r101 = (ActivityResult) r100;
            if (r101.getResultCode() != (-1)) goto L19;
            Intent r102 = r101.getData();
            if (r102 == null) goto L9;
            Bundle r103 = r102.getExtras();
            if (r103 == null) goto L9;
            String r104 = r103.getString("key_pic_uri");
        L10:
            if (r104 != null) goto L12;
            r104 = "";
        L12:
            int r105 = com.ss.android.lark.compose.groupinfo.c.f417711a;
            com.ss.android.lark.compose.groupinfo.c.b("FlowGroupInfoActivity pickSDKLauncher uri = ".concat(r104));
            if (r104.length() <= 0) goto L15;
            boolean r106 = true;
        L16:
            if (r106 == false) goto L20;
            Lazy<GroupInfoViewModel> r107 = this.f417691a;
            int r108 = FlowGroupInfoActivity.f417688c;
            r107.getValue().changeSelectedImageUri(r104);
            return;
        L20:
            return;
        L15:
            r106 = false;
        L9:
            r104 = null;
            goto L10
        }
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider, dagger.hilt.internal.GeneratedComponentManager
    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.CC.$default$generatedComponent(this);
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // d0c.c, dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0107 */
    @Override // com.ss.android.lark.compose.groupinfo.Hilt_FlowGroupInfoActivity, com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        KeyboardUtils.hideKeyboard(this);
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(FlowGroupInfoActivity.class.getName()));
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

    @Override // com.ss.android.lark.compose.groupinfo.Hilt_FlowGroupInfoActivity, com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(FlowGroupInfoActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    public FlowGroupInfoActivity() {
        this.f417689b = LazyKt.lazy(FlowGroupInfoActivity$photoPicker$2.INSTANCE);
    }

    @Override // d0c.c
    public final UserSession e9() {
        return PassportcConvention.c(this);
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

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r110) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r110);
        ImSdk r111 = ImSdk.f425890a;
        boolean r112 = ImSdk.f425892c;
        boolean r100 = OfficeSDKManager.isAvailable();
        if (r100 == false) goto L43;
        if (r112 == false) goto L43;
        String r113 = getIntent().getStringExtra("chat_id");
        if (r113 != null) goto L17;
        final String r101 = "";
    L18:
        String r114 = getIntent().getStringExtra("avatar_key");
        if (r114 != null) goto L21;
        final String r102 = "";
    L22:
        String r115 = getIntent().getStringExtra("chat_name");
        if (r115 != null) goto L25;
        final String r103 = "";
    L26:
        boolean r104 = false;
        final boolean r105 = getIntent().getBooleanExtra("can_edit", false);
        if (r101.length() != 0) goto L29;
        boolean r116 = true;
    L30:
        if (r116 == false) goto L32;
    L42:
        finish();
        return;
    L32:
        if (r102.length() != 0) goto L34;
        boolean r117 = true;
    L35:
        if (r117 == true) goto L42;
        if (r103.length() != 0) goto L39;
        r104 = true;
    L39:
        if (r104 == true) goto L42;
        final com.lark.kmp.rustclient.api.d r118 = com.ss.android.lark.compose.chatsetting.common.repository.b.a(PassportcConvention.c(this));
        final AndroidGroupInfoPlatformService r106 = new AndroidGroupInfoPlatformService(getApplicationContext());
        Function0<ViewModelProvider.Factory> r119 = new FlowGroupInfoActivity$onCreate$viewModel$2(r101, r102, r103, r105, r118, r106);
        final Function0 r107 = null;
        final ViewModelLazy r108 = new ViewModelLazy(Reflection.getOrCreateKotlinClass(GroupInfoViewModel.class), new FlowGroupInfoActivity$onCreate$$inlined$viewModels$default$2(this), r119, new FlowGroupInfoActivity$onCreate$$inlined$viewModels$default$3(r107, this));
        final ActivityResultLauncher r109 = registerForActivityResult(new ActivityResultContracts.GetContent(), b.f417690a);
        final ActivityResultLauncher r120 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new c(r108));
        com.ss.android.lark.compose.util.f.a(this, com.larus.nova.R.color.flow_ud_bg_base_5);
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(1352932637, true, new AnonymousClass2(r108, this, r109, r120, r118)), 1, null);
        return;
    L34:
        r117 = false;
        goto L35
    L29:
        r116 = false;
        goto L30
    L25:
        r103 = r115;
        goto L26
    L21:
        r102 = r114;
        goto L22
    L17:
        r101 = r113;
    L43:
        Log.w("OfficeSDKInitGuard", "office sdk available: " + r100 + ", im sdk ready: " + r112 + ", finish. " + FlowGroupInfoActivity.class.getName());
        finish();
    }
}
