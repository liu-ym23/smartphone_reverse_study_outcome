package com.bytedance.flow_audio.api.business.asr.source;

import hw5.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/flow_audio/api/business/asr/source/FlowAsrAudioRecordException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "error", "Lcom/bytedance/flow_audio/api/business/asr/error/FlowAsrError;", "<init>", "(Lcom/bytedance/flow_audio/api/business/asr/error/FlowAsrError;)V", "getError", "()Lcom/bytedance/flow_audio/api/business/asr/error/FlowAsrError;", "flow_audio_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowAsrAudioRecordException extends RuntimeException {
    private final a error;

    public final a getError() {
        return this.error;
    }

    public FlowAsrAudioRecordException(a r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        super(r100.f487418b);
        this.error = r100;
    }
}
