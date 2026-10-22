package com.larus.chat.search.api;

import com.larus.chat.search.api.model.SectionItemData;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H¦@¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/chat/search/api/ISearchSectionExternalService;", "", "injectBottomSections", "", "Lcom/larus/chat/search/api/model/SectionItemData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ISearchSectionExternalService {
    Object a(Continuation<? super List<SectionItemData>> r100);
}
