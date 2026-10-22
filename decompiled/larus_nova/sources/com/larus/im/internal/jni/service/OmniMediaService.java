package com.larus.im.internal.jni.service;

import com.larus.im.internal.jni.session.NativeMediaSession;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086 J\u0011\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086 J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086 J\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0010H\u0086 ¢\u0006\u0002\u0010\u0011J\u0011\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0086 J\u0011\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0086 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/im/internal/jni/service/OmniMediaService;", "", "omniSdkPtr", "", "<init>", "(J)V", "preGetMmtAccess", "", "configJson", "", "preloadMmtTransport", "removeSession", "", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "Lcom/larus/im/internal/jni/session/NativeMediaSession;", "mmtABVidList", "", "()[Ljava/lang/String;", "createSession", "createRealtimeSession", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniMediaService {
    private final long omniSdkPtr;

    public final native NativeMediaSession createRealtimeSession(String r100);

    public final native NativeMediaSession createSession(String r100);

    public final native String[] mmtABVidList();

    public final native int preGetMmtAccess(String r100);

    public final native int preloadMmtTransport(String r100);

    public final native void removeSession(NativeMediaSession r100);

    private OmniMediaService(long r100) {
        this.omniSdkPtr = r100;
    }
}
