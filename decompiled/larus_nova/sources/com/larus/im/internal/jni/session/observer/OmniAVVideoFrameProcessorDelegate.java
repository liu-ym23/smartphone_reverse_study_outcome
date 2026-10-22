package com.larus.im.internal.jni.session.observer;

import com.larus.im.depend.CallByNative;
import com.larus.im.internal.jni.model.OmniAVVideoFrameData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0017¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/session/observer/OmniAVVideoFrameProcessorDelegate;", "", "onProcessCaptureFrame", "Lcom/larus/im/internal/jni/model/OmniAVVideoFrameData;", "sourceType", "", "frame", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface OmniAVVideoFrameProcessorDelegate {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        @CallByNative
        public static OmniAVVideoFrameData onProcessCaptureFrame(OmniAVVideoFrameProcessorDelegate r100, int r101, OmniAVVideoFrameData r102) {
            Intrinsics.checkNotNullParameter(r102, "frame");
            return r102;
        }
    }

    @CallByNative
    OmniAVVideoFrameData onProcessCaptureFrame(int r100, OmniAVVideoFrameData r101);
}
