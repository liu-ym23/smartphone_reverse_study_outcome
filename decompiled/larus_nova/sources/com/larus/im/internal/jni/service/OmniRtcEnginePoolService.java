package com.larus.im.internal.jni.service;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086 J\t\u0010\n\u001a\u00020\u000bH\u0086 J\u0011\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0086 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/im/internal/jni/service/OmniRtcEnginePoolService;", "", "omniSdkPtr", "", "<init>", "(J)V", "setCallback", "", "callback", "Lcom/larus/im/internal/jni/service/IRtcEnginePoolServiceCallback;", "createEngine", "", "destroyEngineIfNeeded", "withBizId", "", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniRtcEnginePoolService {
    private final long omniSdkPtr;

    public final native int createEngine();

    public final native int destroyEngineIfNeeded(String r100);

    public final native void setCallback(IRtcEnginePoolServiceCallback r100);

    private OmniRtcEnginePoolService(long r100) {
        this.omniSdkPtr = r100;
    }
}
