package com.larus.im.internal.jni.session.observer;

import com.larus.im.depend.CallByNative;
import com.larus.im.internal.jni.model.OmniAVAudioFrameData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@CallByNative
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0017J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0017R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/larus/im/internal/jni/session/observer/OmniAVAudioFrameProcessor;", "Lcom/larus/im/internal/jni/session/observer/OmniAVAudioFrameProcessorDelegate;", "delegate", "<init>", "(Lcom/larus/im/internal/jni/session/observer/OmniAVAudioFrameProcessorDelegate;)V", "frameProcessorDelegate", "nativeHandle", "", "setDelegate", "", "onProcessRecordFrame", "Lcom/larus/im/internal/jni/model/OmniAVAudioFrameData;", "audioFrame", "onProcessPlayFrame", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniAVAudioFrameProcessor implements OmniAVAudioFrameProcessorDelegate {
    private volatile OmniAVAudioFrameProcessorDelegate frameProcessorDelegate;
    private long nativeHandle;

    /* JADX WARN: Multi-variable type inference failed */
    public OmniAVAudioFrameProcessor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public OmniAVAudioFrameProcessor(OmniAVAudioFrameProcessorDelegate r100) {
        this.frameProcessorDelegate = r100;
        this.nativeHandle = -1;
    }

    @Override // com.larus.im.internal.jni.session.observer.OmniAVAudioFrameProcessorDelegate
    @CallByNative
    public OmniAVAudioFrameData onProcessPlayFrame(OmniAVAudioFrameData r100) {
        Intrinsics.checkNotNullParameter(r100, "audioFrame");
        OmniAVAudioFrameProcessorDelegate r101 = this.frameProcessorDelegate;
        if (r101 == null) goto L9;
        OmniAVAudioFrameData r102 = r101.onProcessPlayFrame(r100);
        if (r102 != null) goto L8;
        return r100;
    L8:
        return r102;
    L9:
        return r100;
    }

    @Override // com.larus.im.internal.jni.session.observer.OmniAVAudioFrameProcessorDelegate
    @CallByNative
    public OmniAVAudioFrameData onProcessRecordFrame(OmniAVAudioFrameData r100) {
        Intrinsics.checkNotNullParameter(r100, "audioFrame");
        OmniAVAudioFrameProcessorDelegate r101 = this.frameProcessorDelegate;
        if (r101 == null) goto L9;
        OmniAVAudioFrameData r102 = r101.onProcessRecordFrame(r100);
        if (r102 != null) goto L8;
        return r100;
    L8:
        return r102;
    L9:
        return r100;
    }

    public final void setDelegate(OmniAVAudioFrameProcessorDelegate r100) {
        this.frameProcessorDelegate = r100;
    }

    public /* synthetic */ OmniAVAudioFrameProcessor(OmniAVAudioFrameProcessorDelegate r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
