package com.larus.im.internal.jni.service;

import com.larus.im.internal.jni.bean.OMNIAVRTCTokenResponse;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086 J\t\u0010\n\u001a\u00020\u0007H\u0086 J\u0019\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0086 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/im/internal/jni/service/OmniTokenService;", "", "omniSdkPtr", "", "<init>", "(J)V", "prefetchTokens", "", "requestJson", "", "clearTokenCache", "getToken", "callback", "Lcom/larus/im/internal/jni/service/OmniTokenService$Callback;", "Callback", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniTokenService {
    private final long omniSdkPtr;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/larus/im/internal/jni/service/OmniTokenService$Callback;", "", "onSuccess", "", "resp", "Lcom/larus/im/internal/jni/bean/OMNIAVRTCTokenResponse;", "onFailed", "msg", "", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface Callback {
        void onFailed(String r100);

        void onSuccess(OMNIAVRTCTokenResponse r100);
    }

    public final native void clearTokenCache();

    public final native void getToken(String r100, Callback r101);

    public final native void prefetchTokens(String r100);

    private OmniTokenService(long r100) {
        this.omniSdkPtr = r100;
    }
}
