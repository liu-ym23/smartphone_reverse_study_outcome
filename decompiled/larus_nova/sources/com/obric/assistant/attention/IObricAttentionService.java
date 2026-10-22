package com.obric.assistant.attention;

import com.obric.assistant.util.m;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/obric/assistant/attention/IObricAttentionService;", "", "init", "", "checkAttention", "Lcom/obric/assistant/attention/AttentionCheckRequest;", "timeoutMillis", "", "callback", "Lcom/obric/assistant/attention/AttentionCheckCallback;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricAttentionService {
    ObricAttentionServiceImpl.b a(m r100);

    void init();
}
