package com.larus.im.internal.jni.session.observer;

import com.larus.im.depend.CallByNative;
import com.larus.im.internal.jni.model.OmniAVAudioFrameData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0017J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0017¨\u0006\u0006"}, d2 = {"Lcom/larus/im/internal/jni/session/observer/OmniAVAudioFrameProcessorDelegate;", "", "onProcessRecordFrame", "Lcom/larus/im/internal/jni/model/OmniAVAudioFrameData;", "audioFrame", "onProcessPlayFrame", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface OmniAVAudioFrameProcessorDelegate {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        @CallByNative
        public static OmniAVAudioFrameData onProcessPlayFrame(OmniAVAudioFrameProcessorDelegate r100, OmniAVAudioFrameData r101) {
            Intrinsics.checkNotNullParameter(r101, "audioFrame");
            return r101;
        }

        @CallByNative
        public static OmniAVAudioFrameData onProcessRecordFrame(OmniAVAudioFrameProcessorDelegate r100, OmniAVAudioFrameData r101) {
            Intrinsics.checkNotNullParameter(r101, "audioFrame");
            return r101;
        }
    }

    @CallByNative
    OmniAVAudioFrameData onProcessPlayFrame(OmniAVAudioFrameData r100);

    @CallByNative
    OmniAVAudioFrameData onProcessRecordFrame(OmniAVAudioFrameData r100);
}
