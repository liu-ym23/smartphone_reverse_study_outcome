package com.bytedance.common.wschannel.heartbeat.monitor;

/* JADX INFO: loaded from: classes15.dex */
public class HeartBeatMonitor implements IHeartBeatMonitor {
    private IHeartBeatMonitor heartBeatMonitor;

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.heartbeat.monitor.HeartBeatMonitor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class SingletonHolder {
        private static final HeartBeatMonitor instance = null;

        static {
            instance = new HeartBeatMonitor(null);
        }

        public static /* synthetic */ HeartBeatMonitor access$100() {
            return instance;
        }
    }

    private HeartBeatMonitor() {
    }

    @Override // com.bytedance.common.wschannel.heartbeat.monitor.IHeartBeatMonitor
    public void onPingSuccess() {
        IHeartBeatMonitor r100 = this.heartBeatMonitor;
        if (r100 == null) goto L6;
        r100.onPingSuccess();
        return;
    }

    @Override // com.bytedance.common.wschannel.heartbeat.monitor.IHeartBeatMonitor
    public void onPingTimeout() {
        IHeartBeatMonitor r100 = this.heartBeatMonitor;
        if (r100 == null) goto L6;
        r100.onPingTimeout();
        return;
    }

    public static HeartBeatMonitor getInstance() {
        return SingletonHolder.access$100();
    }

    public /* synthetic */ HeartBeatMonitor(AnonymousClass1 r100) {
        this();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.monitor.IHeartBeatMonitor
    public void onPingFail(Throwable r100) {
        IHeartBeatMonitor r101 = this.heartBeatMonitor;
        if (r101 == null) goto L6;
        r101.onPingFail(r100);
        return;
    }

    public void setHeartBeatMonitor(IHeartBeatMonitor r100) {
        this.heartBeatMonitor = r100;
    }
}
