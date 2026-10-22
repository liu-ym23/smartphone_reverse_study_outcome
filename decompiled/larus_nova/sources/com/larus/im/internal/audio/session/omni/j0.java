package com.larus.im.internal.audio.session.omni;

import com.larus.im.internal.jni.media.OmniAudioEngineConfig;
import com.larus.im.internal.jni.media.OmniAudioEngineProtocol;
import com.larus.im.internal.jni.session.NativeMediaSession;
import com.larus.im.internal.jni.session.observer.OmniAVAudioFrameProcessor;
import com.larus.im.service.audio.AvAudioKitMode;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NativeMediaSession f347310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.im.service.audio.x0 f347311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OmniAudioEngineConfig f347312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AvAudioKitMode f347313d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OmniAVAudioFrameProcessor f347314e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public OmniAudioEngineProtocol f347315f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function1<? super byte[], Unit> f347316g;

    public j0(NativeMediaSession r100, com.larus.im.service.audio.x0 r101, OmniAudioEngineConfig r102, AvAudioKitMode r103) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "sessionConfig");
        Intrinsics.checkNotNullParameter(r102, "mediaConfig");
        Intrinsics.checkNotNullParameter(r103, "audioKitMode");
        this.f347310a = r100;
        this.f347311b = r101;
        this.f347312c = r102;
        this.f347313d = r103;
        this.f347314e = new OmniAVAudioFrameProcessor(null, 1, null);
    }
}
