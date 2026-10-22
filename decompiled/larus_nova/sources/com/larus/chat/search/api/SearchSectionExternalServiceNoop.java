package com.larus.chat.search.api;

import com.larus.chat.search.api.model.SectionItemData;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0096@¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/chat/search/api/SearchSectionExternalServiceNoop;", "Lcom/larus/chat/search/api/ISearchSectionExternalService;", "<init>", "()V", "injectBottomSections", "", "Lcom/larus/chat/search/api/model/SectionItemData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchSectionExternalServiceNoop implements ISearchSectionExternalService {
    public SearchSectionExternalServiceNoop() {
    }

    @Override // com.larus.chat.search.api.ISearchSectionExternalService
    public final Object a(Continuation<? super List<SectionItemData>> r100) {
        return CollectionsKt.emptyList();
    }
}
