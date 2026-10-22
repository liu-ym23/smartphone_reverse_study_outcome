package com.bytedance.flow_audio.impl.business.asr;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/flow_audio/impl/business/asr/FlowAsrAudioFrameSendException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "nativeCode", "", "frameSize", "<init>", "(II)V", "getNativeCode", "()I", "flow_audio_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowAsrAudioFrameSendException extends RuntimeException {
    private final int nativeCode;

    public final int getNativeCode() {
        return this.nativeCode;
    }

    public FlowAsrAudioFrameSendException(int r100, int r101) {
        super("send ASR audio frame failed ret=" + r100 + " size=" + r101);
        this.nativeCode = r100;
    }
}
