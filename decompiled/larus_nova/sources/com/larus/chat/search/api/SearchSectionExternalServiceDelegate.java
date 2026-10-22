package com.larus.chat.search.api;

import com.larus.chat.search.api.model.SectionItemData;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0096A¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/chat/search/api/SearchSectionExternalServiceDelegate;", "Lcom/larus/chat/search/api/ISearchSectionExternalService;", "<init>", "()V", "injectBottomSections", "", "Lcom/larus/chat/search/api/model/SectionItemData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchSectionExternalServiceDelegate implements ISearchSectionExternalService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SearchSectionExternalServiceDelegate f325443b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ISearchSectionExternalService f325444a;

    static {
        f325443b = new SearchSectionExternalServiceDelegate();
    }

    @Override // com.larus.chat.search.api.ISearchSectionExternalService
    public final Object a(Continuation<? super List<SectionItemData>> r100) {
        return this.f325444a.a(r100);
    }

    private SearchSectionExternalServiceDelegate() {
        ISearchSectionExternalService r100 = (ISearchSectionExternalService) ServiceManager.get().getService(ISearchSectionExternalService.class);
        if (r100 != null) goto L5;
        r100 = new SearchSectionExternalServiceNoop();
    L5:
        this.f325444a = r100;
    }
}
