package com.bytedance.flow_audio.api.service.common;

import com.ss.ttvideoengine.model.SubInfo;
import kotlin.Metadata;
import pd6.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lcom/bytedance/flow_audio/api/service/common/IKMPLoggerService;", "Lcom/bytedance/kmp/spi/IKmpService;", "logInfo", "", SubInfo.KEY_FORMAT, "", "tag", "logDebug", "logWarn", "logError", "flow_audio_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IKMPLoggerService extends a {
    void logDebug(String r100, String r101);

    void logError(String r100, String r101);

    void logWarn(String r100, String r101);

    void m1(String r100, String r101);
}
