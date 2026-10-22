package or1;

import com.bytedance.android.livesdk.utils.z0;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class j implements com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.j, com.bytedance.android.scope.o {
    public j() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.j
    public final float a() {
        return z0.b(false);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.j
    public final void onEnterPlay() {
        IPerformanceManager r100 = (IPerformanceManager) jc1.k.f(IPerformanceManager.class);
        if (r100 == null) goto L6;
        r100.onEnterPlay();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.j
    public final void onEnterRoom() {
        IPerformanceManager r100 = (IPerformanceManager) jc1.k.f(IPerformanceManager.class);
        if (r100 == null) goto L6;
        r100.onEnterRoom(null);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.j
    public final void onExitRoom() {
        IPerformanceManager r100 = (IPerformanceManager) jc1.k.f(IPerformanceManager.class);
        if (r100 == null) goto L6;
        r100.onExitRoom();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.j
    public final void onModuleStop(String r100) {
        IPerformanceManager r101 = (IPerformanceManager) jc1.k.f(IPerformanceManager.class);
        if (r101 == null) goto L6;
        r101.onModuleStop(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.j
    public final void release(int r100) {
        IPerformanceManager r101 = (IPerformanceManager) jc1.k.f(IPerformanceManager.class);
        if (r101 == null) goto L6;
        r101.release(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.j
    public final void setStreamType(int r100) {
        IPerformanceManager r101 = (IPerformanceManager) jc1.k.f(IPerformanceManager.class);
        if (r101 == null) goto L6;
        r101.setStreamType(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.j
    public final void startLoadStallMonitor(long r100) {
        IPerformanceManager r101 = (IPerformanceManager) jc1.k.f(IPerformanceManager.class);
        if (r101 == null) goto L6;
        r101.startLoadStallMonitor(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.j
    public final void startTimerMonitor(int r100) {
        IPerformanceManager r101 = (IPerformanceManager) jc1.k.f(IPerformanceManager.class);
        if (r101 == null) goto L6;
        r101.startTimerMonitor(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.j
    public final void stopTimerMonitor(int r100) {
        IPerformanceManager r101 = (IPerformanceManager) jc1.k.f(IPerformanceManager.class);
        if (r101 == null) goto L6;
        r101.stopTimerMonitor(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.j
    public final void forceStopLoadStallMonitor(long r100, boolean r101) {
        IPerformanceManager r102 = (IPerformanceManager) jc1.k.f(IPerformanceManager.class);
        if (r102 == null) goto L6;
        r102.forceStopLoadStallMonitor(r100, true);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.j
    public final void onModuleStart(String r100, Map<String, String> r101) {
        IPerformanceManager r102 = (IPerformanceManager) jc1.k.f(IPerformanceManager.class);
        if (r102 == null) goto L6;
        r102.onModuleStart(r100, null);
        return;
    }
}
