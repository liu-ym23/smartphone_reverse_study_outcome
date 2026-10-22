package com.larus.agents.api;

import k48.a;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nH¦@¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/larus/agents/api/IWebPageFetchService;", "", "fetchWebPageHtml", "Lcom/larus/agents/api/WebPageFetchResult;", "url", "", "commandId", "sendCookie", "", "maxRedirect", "", "maxBytes", "(Ljava/lang/String;Ljava/lang/String;ZIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IWebPageFetchService {
    Object a(String r100, String r101, boolean r102, int r103, int r104, Continuation<? super a> r105);
}
