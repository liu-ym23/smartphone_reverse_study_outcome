package com.obric.assistant.interaction.impl.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/interaction/impl/model/IFlowSDKControl;", "", "stopTtsPlay", "", "isTtsStopped", "", "restartTtsPlay", "startTtsPlay", "muteMic", "unMuteMic", "endCall", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IFlowSDKControl {
    void endCall();

    boolean isTtsStopped();

    void muteMic();

    void restartTtsPlay();

    void startTtsPlay();

    void stopTtsPlay();

    void unMuteMic();
}
