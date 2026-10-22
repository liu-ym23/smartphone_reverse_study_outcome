package com.obric.assistant.interaction.impl;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import com.bytedance.ai.api.AppletExtService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.common.apphost.AppHost;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.larus.home.api.main.HomeService;
import com.larus.home.api.main.HomeServiceV2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.aiagent.assistant.idl.IPlatformApiIDL;
import com.obric.aiagent.assistant.idl.l4;
import com.obric.assistant.interaction.impl.window.helpers.ActivityManagerLancet;
import com.obric.assistant.spi.app.IObricLaunchService;
import com.obric.assistant.spi.keyguard.KeyguardService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004*\u0001\u001b\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u001a\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\fH\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/obric/assistant/interaction/impl/AppLaunchServiceImpl;", "Lcom/obric/assistant/spi/app/IObricLaunchService;", "<init>", "()V", "initialized", "", "init", "", "resumeOrLaunchNewTask", "doNotResumeWindow", "resumeAssistantTask", "targetActivityName", "", "ignoreWindow", "getAppTaskIds", "", "", "resumeRecentTask", "startLauncherIntent", "getLaunchBridgeIntent", "Landroid/content/Intent;", "getLaunchBridgeActivityName", "getBackgroundAppPkgName", "getPushClickIntent", "launchMainActivity", "monitorUpdateWakeupPkg", "activityLifeCycleCallback", "com/obric/assistant/interaction/impl/AppLaunchServiceImpl$activityLifeCycleCallback$1", "Lcom/obric/assistant/interaction/impl/AppLaunchServiceImpl$activityLifeCycleCallback$1;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppLaunchServiceImpl implements IObricLaunchService {
    public static final Companion Companion = null;
    private static final String KEY_OPEN_METHOD = "open_method";
    private static final Set<String> LAUNCHER_LONG_PRESS_OPEN_METHODS = null;
    private static final String TAG = "AppLaunchServiceImpl";
    private final AppLaunchServiceImpl$activityLifeCycleCallback$1 activityLifeCycleCallback;
    private volatile boolean initialized;

    /* JADX INFO: loaded from: classes4.dex */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/assistant/interaction/impl/AppLaunchServiceImpl$Companion;", "", "<init>", "()V", "TAG", "", "KEY_OPEN_METHOD", "LAUNCHER_LONG_PRESS_OPEN_METHODS", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        LAUNCHER_LONG_PRESS_OPEN_METHODS = SetsKt.setOf(new String[]{"long_press_icon_camera", "long_press_icon_scan", "long_press_icon_call"});
    }

    private final void launchMainActivity() {
        Intent r100 = new Intent();
        AppHost.Companion r101 = AppHost.f326268a;
        r100.setComponent(new ComponentName(r101.getApplication(), HomeServiceV2.f344096a.a()));
        r100.setFlags(335577088);
        r101.getApplication().startActivity(r100);
        FLogger.f375446a.i(TAG, "launch main activity");
    }

    private final void monitorUpdateWakeupPkg() {
        AppHost.f326268a.getApplication().registerActivityLifecycleCallbacks(this.activityLifeCycleCallback);
    }

    @Override // com.obric.assistant.spi.app.IObricLaunchService
    public String getBackgroundAppPkgName() {
        Object r100 = "";
        String r101 = AppHost.f326268a.getApplication().getPackageName();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L18
        KClass r103 = Reflection.getOrCreateKotlinClass(IPlatformApiIDL.class);     // Catch: Throwable -> L18
        int r104 = l4.f384549a;     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r103, "<this>");     // Catch: Throwable -> L18
        com.obric.aiagent.ipc.utils.g.f384740a.getClass();     // Catch: Throwable -> L18
        IPlatformApiIDL r105 = (IPlatformApiIDL) com.obric.aiagent.ipc.utils.g.b(IPlatformApiIDL.class);     // Catch: Throwable -> L18
        Object r106 = null;
        if (r105 == null) goto L14;
        List<String> r107 = r105.getTasksPackages(3, true, false, 0);     // Catch: Throwable -> L18
        if (r107 == null) goto L14;
        Iterator<T> r108 = r107.iterator();     // Catch: Throwable -> L18
    L9:
        if (r108.hasNext() == false) goto L13;
        Object r109 = r108.next();     // Catch: Throwable -> L18
        if ((!Intrinsics.areEqual((String) r109, r101)) == false) goto L9;
        r106 = r109;
    L13:
        r106 = (String) r106;     // Catch: Throwable -> L18
    L14:
        if (r106 != null) goto L16;
        r106 = "";
    L16:
        Object r110 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L18
    L20:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r110);
        if (r111 == null) goto L24;
        FLogger.f375446a.w(TAG, "getBackgroundAppPkgName failed: " + r111.getMessage(), r111);
    L24:
        if (Result.m9455isFailureimpl(r110) == true) goto L28;
        r100 = r110;
    L28:
        return (String) r100;
    L18:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    }

    public String getLaunchBridgeActivityName() {
        return "LaunchBridgeActivity";
    }

    public Intent getLaunchBridgeIntent() {
        return new Intent(AppHost.f326268a.getApplication(), LaunchBridgeActivity.class);
    }

    @Override // com.obric.assistant.spi.app.IObricLaunchService
    public Intent getPushClickIntent() {
        Intent r100 = new Intent();
        r100.setComponent(new ComponentName(AppHost.f326268a.getApplication(), HomeServiceV2.f344096a.a()));
        r100.setFlags(268468224);
        return r100;
    }

    @Override // com.obric.assistant.spi.app.IObricLaunchService
    public void init() {
        if (this.initialized == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (this.initialized == false) goto L11;
        monitor-exit(this);
        return;
    L11:
        this.initialized = true;     // Catch: Throwable -> L15
        Unit r100 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(this);
        FLogger.f375446a.d(TAG, "init");
        monitorUpdateWakeupPkg();
    }

    @Override // com.obric.assistant.spi.app.IObricLaunchService
    public void startLauncherIntent() {
        HomeService r100 = HomeService.f344094a;
        AppHost.Companion r101 = AppHost.f326268a;
        String r102 = r100.A(r101.getApplication());
        FLogger r103 = FLogger.f375446a;
        r103.i(TAG, "enabledActivity = " + r102);
        Activity r104 = r101.a().getCurrentActivity();
        String r105 = null;
        if (r104 == null) goto L5;
        String r106 = r104.getClass().getName();
    L7:
        if (Intrinsics.areEqual(r106, HomeServiceV2.f344096a.a()) == false) goto L16;
        ISecPrivacyService.f326368a.getClass();
        ISecPrivacyService r107 = ISecPrivacyService.a.a();
        if (r107 == null) goto L13;
        boolean r108 = true;
        if (r107.h() != true) goto L13;
    L14:
        if (r108 == true) goto L16;
        return;
    L13:
        r108 = false;
    L16:
        Intent r109 = r101.getApplication().getPackageManager().getLaunchIntentForPackage(r101.getApplication().getPackageName());
        StringBuilder r110 = new StringBuilder("launcher activity = ");
        if (r109 == null) goto L21;
        ComponentName r111 = r109.getComponent();
        if (r111 == null) goto L21;
        String r112 = r111.getClassName();
    L22:
        r110.append(r112);
        r103.i(TAG, r110.toString());
        if (r109 == null) goto L31;
        if (r102 == null) goto L31;
        ComponentName r113 = r109.getComponent();
        if (r113 == null) goto L29;
        r105 = r113.getClassName();
    L29:
        if (Intrinsics.areEqual(r105, r102) == false) goto L31;
        r103.i(TAG, "launch normally");
        r109.addFlags(268435456);
        r101.getApplication().startActivity(r109);
        return;
    L31:
        launchMainActivity();
        return;
    L21:
        r112 = null;
        goto L22
    L5:
        r106 = null;
        goto L7
    }

    public AppLaunchServiceImpl() {
        this.activityLifeCycleCallback = new AppLaunchServiceImpl$activityLifeCycleCallback$1(this);
    }

    public static final /* synthetic */ Set access$getLAUNCHER_LONG_PRESS_OPEN_METHODS$cp() {
        return LAUNCHER_LONG_PRESS_OPEN_METHODS;
    }

    private final List<Integer> getAppTaskIds(boolean r100) {
        List<Activity> r101 = AppHost.f326268a.a().g();
        if (r101.isEmpty() == true) goto L5;
        LinkedHashSet r102 = new LinkedHashSet();
        Iterator r103 = CollectionsKt.reversed(r101).iterator();
    L8:
        if (r103.hasNext() == false) goto L25;
        Activity r104 = (Activity) r103.next();
        if (r104.isFinishing() == true) goto L8;
        if (r104.isDestroyed() == true) goto L8;
        if (Intrinsics.areEqual(r104.getClass().getSimpleName(), KeyguardService.f392886a.getHelperActivityName()) == true) goto L8;
        if (r100 == false) goto L22;
        int r105 = com.obric.assistant.utils.e.f393874a;
        Intrinsics.checkNotNullParameter(r104, "<this>");
        if (r104.getTaskId() != 0) goto L19;
        boolean r106 = true;
    L20:
        if (r106 == true) goto L8;
    L19:
        r106 = false;
    L22:
        if (Intrinsics.areEqual(r104.getClass().getSimpleName(), getLaunchBridgeActivityName()) == true) goto L8;
        FLogger.f375446a.i(TAG, "getAppTaskIds() activity:" + r104 + " add taskId: " + r104.getTaskId());
        r102.add(Integer.valueOf(r104.getTaskId()));
        goto L8
    L25:
        return CollectionsKt.toList(r102);
    L5:
        return CollectionsKt.emptyList();
    }

    private final boolean resumeRecentTask(boolean r100) {
        List<Integer> r101 = getAppTaskIds(r100);
        FLogger r102 = FLogger.f375446a;
        r102.i(TAG, "resumeRecentTask() getTaskIds: " + r101);
        if ((!r101.isEmpty()) == false) goto L6;
        Object r103 = AppHost.f326268a.getApplication().getSystemService("activity");
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.app.ActivityManager");
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_AppLaunchServiceImpl_com_obric_assistant_interaction_impl_window_helpers_ActivityManagerLancet_moveTaskToFront((ActivityManager) r103, ((Number) ListProtector.get(r101, 0)).intValue(), 0);
        r102.i(TAG, "resumeAssistantTask resume recent task success, taskId = " + ((Number) ListProtector.get(r101, 0)).intValue());
        return true;
    L6:
        return false;
    }

    @Override // com.obric.assistant.spi.app.IObricLaunchService
    public void resumeOrLaunchNewTask(boolean r100) {
        if (resumeAssistantTask(null, r100) == true) goto L6;
        startLauncherIntent();
        return;
    }

    @Override // com.obric.assistant.spi.app.IObricLaunchService
    public boolean resumeAssistantTask(String r110, boolean r111) {
        Iterator r100 = CollectionsKt.reversed(AppHost.f326268a.a().g()).iterator();
        boolean r101 = false;
    L4:
        if (r100.hasNext() == false) goto L35;
        Activity r102 = (Activity) r100.next();
        if (r101 == true) goto L34;
        if (r102.isFinishing() == true) goto L34;
        if (r102.isDestroyed() == true) goto L34;
        if (Intrinsics.areEqual(r102.getClass().getSimpleName(), KeyguardService.f392886a.getHelperActivityName()) == true) goto L34;
        if (r111 == false) goto L21;
        int r103 = com.obric.assistant.utils.e.f393874a;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        if (r102.getTaskId() != 0) goto L18;
        boolean r104 = true;
    L19:
        if (r104 == true) goto L34;
    L18:
        r104 = false;
    L21:
        if (Intrinsics.areEqual(r102.getClass().getSimpleName(), getLaunchBridgeActivityName()) == true) goto L34;
        if (r102.isTaskRoot() == false) goto L25;
    L28:
        AppletExtService r105 = (AppletExtService) ServiceManager.get().getService(AppletExtService.class);
        if (r105 == null) goto L31;
        boolean r106 = r105.o(r102);
    L32:
        if (r106 == true) goto L34;
        Object r107 = AppHost.f326268a.getApplication().getSystemService("activity");
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type android.app.ActivityManager");
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_AppLaunchServiceImpl_com_obric_assistant_interaction_impl_window_helpers_ActivityManagerLancet_moveTaskToFront((ActivityManager) r107, r102.getTaskId(), 0);
        FLogger.f375446a.i(TAG, "resumeAssistantTask success, taskId = " + r102.getTaskId() + ", activity = " + r102 + ", className:" + r102.getClass().getName() + " targetActivityName: " + r110);
        r101 = true;
        goto L4
    L31:
        r106 = false;
        goto L32
    L25:
        if (o0.d(r110) == false) goto L34;
        if (Intrinsics.areEqual(r102.getClass().getName(), r110) == true) goto L28;
    L34:
        FLogger.f375446a.i(TAG, "no need to resume assistant taskId = " + r102.getTaskId() + ", activity = " + r102 + ", isFinishing = " + r102.isFinishing() + ", isDestroyed = " + r102.isDestroyed() + ", isTaskRoot = " + r102.isTaskRoot() + ", targetActivityName: " + r110);
        goto L4
    L35:
        if (r101 == true) goto L37;
        r101 = resumeRecentTask(r111);
    L37:
        if (r101 == true) goto L39;
        FLogger.f375446a.i(TAG, "resumeAssistantTask failed");
    L39:
        return r101;
    }

    public static void INVOKEVIRTUAL_com_obric_assistant_interaction_impl_AppLaunchServiceImpl_com_obric_assistant_interaction_impl_window_helpers_ActivityManagerLancet_moveTaskToFront(ActivityManager r100, int r101, int r102) {
        if (r101 == 0) goto L5;
        r100.moveTaskToFront(r101, r102);
        return;
    L5:
        ActivityManagerLancet.handleFakeMoveTaskToFront(r102);
    }
}
