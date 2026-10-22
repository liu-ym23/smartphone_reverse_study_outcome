package com.bytedance.common.wschannel.heartbeat;

import android.os.Handler;
import com.bytedance.common.wschannel.heartbeat.model.IHeartBeatMeta;

/* JADX INFO: loaded from: classes15.dex */
public abstract class BaseHeartBeatPolicy<T extends IHeartBeatMeta> implements IHeartBeatPolicy {
    protected T mMeta;

    public abstract void init(HeartBeatReactListener r100, Handler r101);

    public BaseHeartBeatPolicy(T r100) {
        this.mMeta = r100;
    }
}
