package nbb;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.callback.MemoryCallbackManager;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements MemoryCallbackManager.MemoryCallback {
    public a() {
    }

    @Override // com.ss.android.lark.monitor.callback.MemoryCallbackManager.MemoryCallback
    public final void onJavaMemoryReachTop() {
        Log.i("DOCS_ICON_DocMetaDataManager", "Clean the offline memory cache because the java heap reached the memory top.");
        b.f518597c.evictAll();
    }

    @Override // com.ss.android.lark.monitor.callback.MemoryCallbackManager.MemoryCallback
    public final void onTrimMemory(int r100, int r101, int r102, int r103) {
        Log.i("DOCS_ICON_DocMetaDataManager", "level: " + r100 + "--javaHeapUsed: " + r101 + "--maxJavaHeapMem: " + r103);
    }
}
