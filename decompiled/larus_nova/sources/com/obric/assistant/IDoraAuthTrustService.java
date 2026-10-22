package com.obric.assistant;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J\b\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/IDoraAuthTrustService;", "", "init", "", "shouldDowngradeAuthForDora", "originAuthType", "Lcom/obric/assistant/DoraAuthTrustType;", "callback", "Lcom/obric/assistant/IDoraAuthTrustCallback;", "getDoraAuthTrustState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/obric/assistant/DoraAuthTrustState;", "isDoraWearOn", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDoraAuthTrustService {
    boolean a();

    void b(DoraAuthTrustType r100, i r101);

    void init();
}
