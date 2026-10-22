package com.larus.im.internal.jni.service;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/larus/im/internal/jni/service/IRtcEnginePoolServiceCallback;", "", "willOmniObtainEngine", "", "businessId", "", "didOmniObtainEngine", "", "willOmniDestroyEngine", "withBizId", "didOmniDestroyEngine", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IRtcEnginePoolServiceCallback {
    void didOmniDestroyEngine(String r100);

    void didOmniObtainEngine();

    void willOmniDestroyEngine(String r100);

    int willOmniObtainEngine(String r100);
}
