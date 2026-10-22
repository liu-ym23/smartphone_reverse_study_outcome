package k25;

import com.ss.android.lark.monitor.callback.MemoryCallbackManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f0 implements MemoryCallbackManager.MemoryCallback {
    public final /* synthetic */ e0 a;

    public final void onJavaMemoryReachTop() {
        tt5.a.h("OfflineDataManager", "Clean the offline memory cache because the java heap reached the memory top.");
        this.a.h();
    }

    public f0(e0 r1) {
        this.a = r1;
    }

    public final void onTrimMemory(int r2, int r3, int r4, int r5) {
        tt5.a.h("OfflineDataManager", "level: " + r2 + "--javaHeapUsed: " + r3 + "--maxJavaHeapMem: " + r5);
    }
}
