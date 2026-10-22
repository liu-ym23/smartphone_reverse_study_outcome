package com.ttnet.org.chromium.base.task;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes41.dex */
class TaskRunnerImplJni implements TaskRunnerImpl.Natives {
    public static final JniStaticTestMocker<TaskRunnerImpl.Natives> TEST_HOOKS = null;
    private static TaskRunnerImpl.Natives testInstance;

    public TaskRunnerImplJni() {
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public static TaskRunnerImpl.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        TaskRunnerImpl.Natives r100 = testInstance;
        if (r100 == null) goto L8;
        return r100;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.task.TaskRunnerImpl.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new TaskRunnerImplJni();
    }

    public static /* synthetic */ TaskRunnerImpl.Natives access$002(TaskRunnerImpl.Natives r100) {
        testInstance = r100;
        return r100;
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunnerImpl.Natives
    public boolean belongsToCurrentThread(long r100) {
        return GEN_JNI.com_ttnet_org_chromium_base_task_TaskRunnerImpl_belongsToCurrentThread(r100);
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunnerImpl.Natives
    public void destroy(long r100) {
        GEN_JNI.com_ttnet_org_chromium_base_task_TaskRunnerImpl_destroy(r100);
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunnerImpl.Natives
    public void postDelayedTask(long r100, Runnable r101, long r102, String r103) {
        GEN_JNI.com_ttnet_org_chromium_base_task_TaskRunnerImpl_postDelayedTask(r100, r101, r102, r103);
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunnerImpl.Natives
    public long init(int r100, int r101, boolean r102, boolean r103, byte r104, byte[] r105) {
        return GEN_JNI.com_ttnet_org_chromium_base_task_TaskRunnerImpl_init(r100, r101, r102, r103, r104, r105);
    }
}
