package com.obric.assistant.state.api.v2;

import bha.a;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated(message = "即将删除或移走，平台化的思路下，不允许豆包模块调用O模块，O模块间的调用API放到O模块下")
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/obric/assistant/state/api/v2/IObricStateApi;", "", "isRealtimeCalling", "", "registerRealtimeCallStateObserver", "", "observer", "Lcom/obric/assistant/state/api/v2/RealtimeCallStateObserver;", "unregisterRealtimeCallStateObserver", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricStateApi {
    boolean a();

    void b(a r100);
}
