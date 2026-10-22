package com.ttnet.org.chromium.base.task;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes41.dex */
class PostTaskJni implements PostTask.Natives {
    public static final JniStaticTestMocker<PostTask.Natives> TEST_HOOKS = null;
    private static PostTask.Natives testInstance;

    public PostTaskJni() {
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public static PostTask.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        PostTask.Natives r100 = testInstance;
        if (r100 == null) goto L8;
        return r100;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.task.PostTask.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new PostTaskJni();
    }

    public static /* synthetic */ PostTask.Natives access$002(PostTask.Natives r100) {
        testInstance = r100;
        return r100;
    }

    @Override // com.ttnet.org.chromium.base.task.PostTask.Natives
    public void postDelayedTask(int r100, boolean r101, boolean r102, byte r103, byte[] r104, Runnable r105, long r106, String r107) {
        GEN_JNI.com_ttnet_org_chromium_base_task_PostTask_postDelayedTask(r100, r101, r102, r103, r104, r105, r106, r107);
    }
}
