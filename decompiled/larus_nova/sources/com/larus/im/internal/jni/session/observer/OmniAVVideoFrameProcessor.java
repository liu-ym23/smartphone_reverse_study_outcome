package com.larus.im.internal.jni.session.observer;

import com.larus.im.depend.CallByNative;
import com.larus.im.internal.jni.model.OmniAVVideoFrameData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@CallByNative
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0017R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/im/internal/jni/session/observer/OmniAVVideoFrameProcessor;", "Lcom/larus/im/internal/jni/session/observer/OmniAVVideoFrameProcessorDelegate;", "delegate", "<init>", "(Lcom/larus/im/internal/jni/session/observer/OmniAVVideoFrameProcessorDelegate;)V", "sourceType", "", "getSourceType", "()I", "setSourceType", "(I)V", "frameProcessorDelegate", "nativeHandle", "", "setDelegate", "", "onProcessCaptureFrame", "Lcom/larus/im/internal/jni/model/OmniAVVideoFrameData;", "frame", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniAVVideoFrameProcessor implements OmniAVVideoFrameProcessorDelegate {
    private OmniAVVideoFrameProcessorDelegate frameProcessorDelegate;
    private long nativeHandle;
    private int sourceType;

    /* JADX WARN: Multi-variable type inference failed */
    public OmniAVVideoFrameProcessor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final int getSourceType() {
        return this.sourceType;
    }

    public OmniAVVideoFrameProcessor(OmniAVVideoFrameProcessorDelegate r100) {
        this.frameProcessorDelegate = r100;
        this.nativeHandle = -1;
    }

    public final void setDelegate(OmniAVVideoFrameProcessorDelegate r100) {
        this.frameProcessorDelegate = r100;
    }

    public final void setSourceType(int r100) {
        this.sourceType = r100;
    }

    @Override // com.larus.im.internal.jni.session.observer.OmniAVVideoFrameProcessorDelegate
    @CallByNative
    public OmniAVVideoFrameData onProcessCaptureFrame(int r100, OmniAVVideoFrameData r101) {
        Intrinsics.checkNotNullParameter(r101, "frame");
        OmniAVVideoFrameProcessorDelegate r102 = this.frameProcessorDelegate;
        if (r102 == null) goto L9;
        OmniAVVideoFrameData r103 = r102.onProcessCaptureFrame(r100, r101);
        if (r103 != null) goto L8;
        return r101;
    L8:
        return r103;
    L9:
        return r101;
    }

    public /* synthetic */ OmniAVVideoFrameProcessor(OmniAVVideoFrameProcessorDelegate r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
