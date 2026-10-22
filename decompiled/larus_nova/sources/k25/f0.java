package k25;

import com.ss.android.lark.monitor.callback.MemoryCallbackManager;

/* JADX INFO: loaded from: classes16.dex */
public final class f0 implements MemoryCallbackManager.MemoryCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e0 f501524a;

    @Override // com.ss.android.lark.monitor.callback.MemoryCallbackManager.MemoryCallback
    public final void onJavaMemoryReachTop() {
        tt5.a.h("OfflineDataManager", "Clean the offline memory cache because the java heap reached the memory top.");
        this.f501524a.h();
    }

    public f0(e0 r100) {
        this.f501524a = r100;
    }

    @Override // com.ss.android.lark.monitor.callback.MemoryCallbackManager.MemoryCallback
    public final void onTrimMemory(int r100, int r101, int r102, int r103) {
        tt5.a.h("OfflineDataManager", "level: " + r100 + "--javaHeapUsed: " + r101 + "--maxJavaHeapMem: " + r103);
    }
}
