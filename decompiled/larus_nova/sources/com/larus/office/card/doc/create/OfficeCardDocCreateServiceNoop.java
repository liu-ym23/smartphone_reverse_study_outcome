package com.larus.office.card.doc.create;

import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J^\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0012H\u0096@¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/larus/office/card/doc/create/OfficeCardDocCreateServiceNoop;", "Lcom/larus/office/card/doc/create/IOfficeCardDocCreateService;", "<init>", "()V", "createDocByMessage", "Lcom/larus/network/bean/HttpDataResult;", "Lcom/larus/office/card/doc/create/OfficeCardCreateDocByMessageResponse;", "conversationId", "", "messageId", "", "resourceType", "", "sourceType", "docRealToken", "useMessageContent", "", "headers", "", "(Ljava/lang/String;JIILjava/lang/String;Ljava/lang/Boolean;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeCardDocCreateServiceNoop implements IOfficeCardDocCreateService {
    public OfficeCardDocCreateServiceNoop() {
    }

    @Override // com.larus.office.card.doc.create.IOfficeCardDocCreateService
    public final Object a(String r100, long r101, int r102, int r103, String r104, Boolean r105, Map<String, String> r106, Continuation<? super dm9.a<b>> r107) {
        return new dm9.a.C5690a(-1, "OfficeCard doc create service not found", null);
    }
}
