package com.larus.office.card.doc.create;

import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001Jd\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0010H¦@¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/larus/office/card/doc/create/IOfficeCardDocCreateService;", "", "createDocByMessage", "Lcom/larus/network/bean/HttpDataResult;", "Lcom/larus/office/card/doc/create/OfficeCardCreateDocByMessageResponse;", "conversationId", "", "messageId", "", "resourceType", "", "sourceType", "docRealToken", "useMessageContent", "", "headers", "", "(Ljava/lang/String;JIILjava/lang/String;Ljava/lang/Boolean;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IOfficeCardDocCreateService {
    Object a(String r100, long r101, int r102, int r103, String r104, Boolean r105, Map<String, String> r106, Continuation<? super dm9.a<b>> r107);
}
