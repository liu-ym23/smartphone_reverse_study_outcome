package com.obric.assistant.interaction.impl.window.behaviors;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.window.IBehavior;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0002J$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0003J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0003J\"\u0010\u0015\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0012\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/behaviors/ClearTaskBehavior;", "Lcom/obric/assistant/interaction/api/window/IBehavior;", "<init>", "()V", "zombieTasksCleared", "", "init", "", "onAppBackground", "onAppForeground", "clearHistoricalRecentTasks", "isMainProcessTask", "packageManager", "Landroid/content/pm/PackageManager;", "baseActivity", "Landroid/content/ComponentName;", "topActivity", "getTaskBaseActivity", "taskInfo", "Landroid/app/ActivityManager$RecentTaskInfo;", "getTaskTopActivity", "isMainProcessActivity", "activity", "allowEmpty", "isMainProcessName", "processName", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ClearTaskBehavior implements IBehavior {
    public static final Companion Companion = null;
    public static final String TAG = "ClearTaskBehavior";
    private boolean zombieTasksCleared;

    /* JADX INFO: loaded from: classes4.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/behaviors/ClearTaskBehavior$Companion;", "", "<init>", "()V", "TAG", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ClearTaskBehavior() {
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void init() {
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void onAppBackground() {
    }

    private final void clearHistoricalRecentTasks() {
        AppHost.Companion r100 = AppHost.f326268a;
        Activity r101 = r100.a().getCurrentActivity();
        if (r101 == null) goto L18;
        this.zombieTasksCleared = true;
        Object r102 = r100.getApplication().getSystemService("activity");
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.app.ActivityManager");
        PackageManager r103 = r100.getApplication().getPackageManager();
        List<ActivityManager.AppTask> r104 = ((ActivityManager) r102).getAppTasks();
        if (r104 != null) goto L7;
        return;
    L7:
        FLogger.f375446a.i(TAG, "appTasks.size = " + r104.size());
        int r105 = r101.getTaskId();
        Iterator<ActivityManager.AppTask> r106 = r104.iterator();
    L9:
        if (r106.hasNext() == false) goto L26;
        ActivityManager.AppTask r107 = r106.next();
        ActivityManager.RecentTaskInfo r108 = r107.getTaskInfo();
        if (Build.VERSION.SDK_INT < 29) goto L13;
        int r109 = r108.taskId;
    L14:
        Intrinsics.checkNotNull(r108);
        ComponentName r110 = getTaskBaseActivity(r108);
        ComponentName r111 = getTaskTopActivity(r108);
        Intrinsics.checkNotNull(r103);
        boolean r112 = isMainProcessTask(r103, r110, r111);
        FLogger.f375446a.i(TAG, "taskId = " + r109 + ", currentTaskId = " + r105 + ", baseActivity = " + r110 + ", topActivity = " + r111 + ", isMainProcessTask = " + r112);
        if (r109 == r105) goto L9;
        if (r112 == false) goto L9;
        r107.finishAndRemoveTask();
        goto L9
    L13:
        r109 = r108.id;
        goto L14
    L26:
        return;
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void onAppForeground() {
        if (this.zombieTasksCleared == false) goto L5;
        return;
    L5:
        clearHistoricalRecentTasks();
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void onWindowDismiss() {
        IBehavior.DefaultImpls.onWindowDismiss(this);
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void onWindowHide() {
        IBehavior.DefaultImpls.onWindowHide(this);
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void onWindowPreDismiss() {
        IBehavior.DefaultImpls.onWindowPreDismiss(this);
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void onWindowPreHide() {
        IBehavior.DefaultImpls.onWindowPreHide(this);
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void onWindowPreOpenClear() {
        IBehavior.DefaultImpls.onWindowPreOpenClear(this);
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void onWindowPreShow() {
        IBehavior.DefaultImpls.onWindowPreShow(this);
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void onWindowPreloaded() {
        IBehavior.DefaultImpls.onWindowPreloaded(this);
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void onWindowShow() {
        IBehavior.DefaultImpls.onWindowShow(this);
    }

    private final ComponentName getTaskBaseActivity(ActivityManager.RecentTaskInfo r100) {
        if (Build.VERSION.SDK_INT >= 23) goto L7;
        return null;
    L7:
        return r100.baseActivity;
    }

    private final ComponentName getTaskTopActivity(ActivityManager.RecentTaskInfo r100) {
        if (Build.VERSION.SDK_INT >= 23) goto L7;
        return null;
    L7:
        return r100.topActivity;
    }

    private final boolean isMainProcessName(String r100) {
        AppHost.Companion r101 = AppHost.f326268a;
        ApplicationInfo r102 = r101.getApplication().getApplicationInfo();
        if (r102 == null) goto L6;
        String r103 = r102.processName;
        if (r103 == null) goto L6;
    L8:
        if (r100 != null) goto L10;
    L13:
        boolean r104 = true;
    L14:
        if (r104 == false) goto L17;
        r100 = r103;
    L20:
        return Intrinsics.areEqual(r100, r103);
    L17:
        if (StringsKt.startsWith$default(r100, ":", false, 2, null) == false) goto L20;
        r100 = r101.getApplication().getPackageName() + r100;
        goto L20
    L10:
        if (r100.length() == 0) goto L13;
        r104 = false;
    L6:
        r103 = r101.getApplication().getPackageName();
        goto L8
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void onScreenRotationChanged(int r100, int r101) {
        IBehavior.DefaultImpls.onScreenRotationChanged(this, r100, r101);
    }

    private final boolean isMainProcessActivity(PackageManager r100, ComponentName r101, boolean r102) {
        if (r101 != null) goto L22;
        return r102;
    L22:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L12
        ActivityInfo r104 = r100.getActivityInfo(r101, 0);     // Catch: Throwable -> L12
        String r105 = r104.processName;     // Catch: Throwable -> L12
        if (r105 != null) goto L10;
        ApplicationInfo r106 = r104.applicationInfo;     // Catch: Throwable -> L12
        if (r106 == null) goto L9;
        r105 = r106.processName;     // Catch: Throwable -> L12
        goto L10
    L9:
        r105 = null;
    L10:
        Object r107 = Result.m9449constructorimpl(Boolean.valueOf(isMainProcessName(r105)));     // Catch: Throwable -> L12
    L14:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L17;
        FLogger.f375446a.w(TAG, "resolve activity process failed, activity = " + r101, r108);
    L17:
        Boolean r109 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r107) == false) goto L21;
        r107 = r109;
    L21:
        return ((Boolean) r107).booleanValue();
    L12:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    private final boolean isMainProcessTask(PackageManager r100, ComponentName r101, ComponentName r102) {
        boolean r103 = isMainProcessActivity(r100, r101, false);
        boolean r104 = isMainProcessActivity(r100, r102, false);
        if (r103 == false) goto L7;
        if (r104 == false) goto L8;
        return true;
    L8:
        return false;
    L7:
        return false;
    }
}
