package com.bytedance.common.wschannel.heartbeat.normal;

import com.bytedance.common.wschannel.heartbeat.model.IHeartBeatMeta;

/* JADX INFO: loaded from: classes15.dex */
public class NormalHeartBeatMeta implements IHeartBeatMeta<NormalHeartBeatMeta> {
    private long pingInterval;
    private long timeout;

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.heartbeat.normal.NormalHeartBeatMeta$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class DefaultNormalHeartBeatMeta extends NormalHeartBeatMeta {
        private DefaultNormalHeartBeatMeta() {
            super(-1, 5000);
        }

        public /* synthetic */ DefaultNormalHeartBeatMeta(AnonymousClass1 r100) {
            this();
        }
    }

    public NormalHeartBeatMeta provideDefaultMeta() {
        return new DefaultNormalHeartBeatMeta(null);
    }

    public NormalHeartBeatMeta() {
    }

    public long getPingInterval() {
        return this.pingInterval;
    }

    public long getTimeout() {
        return this.timeout;
    }

    public void setPingInterval(long r100) {
        this.pingInterval = r100;
    }

    public NormalHeartBeatMeta(long r100, long r101) {
        this.pingInterval = r100;
        this.timeout = r101;
    }
}
