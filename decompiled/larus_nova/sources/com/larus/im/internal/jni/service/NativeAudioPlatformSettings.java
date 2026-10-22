package com.larus.im.internal.jni.service;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0007H\u0086 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/larus/im/internal/jni/service/NativeAudioPlatformSettings;", "", "omniSdkPtr", "", "<init>", "(J)V", "enableMixAec", "", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NativeAudioPlatformSettings {
    private final long omniSdkPtr;

    public final native boolean enableMixAec();

    private NativeAudioPlatformSettings(long r100) {
        this.omniSdkPtr = r100;
    }
}
