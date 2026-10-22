package com.larus.office.card.doc.content;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096A¢\u0006\u0002\u0010\nJ \u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096A¢\u0006\u0002\u0010\n¨\u0006\f"}, d2 = {"Lcom/larus/office/card/doc/content/OfficeCardDocContentServiceDelegate;", "Lcom/larus/office/card/doc/content/IOfficeCardDocContentService;", "<init>", "()V", "getDocContent", "Lcom/larus/office/card/doc/content/OfficeCardDocContent;", "resourceId", "", "version", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDocumentContent", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeCardDocContentServiceDelegate implements IOfficeCardDocContentService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final OfficeCardDocContentServiceDelegate f361365b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IOfficeCardDocContentService f361366a;

    static {
        f361365b = new OfficeCardDocContentServiceDelegate();
    }

    @Override // com.larus.office.card.doc.content.IOfficeCardDocContentService
    public final Object a(String r100, int r101, Continuation<? super a> r102) {
        return this.f361366a.a(r100, r101, r102);
    }

    @Override // com.larus.office.card.doc.content.IOfficeCardDocContentService
    public final Object b(String r100, int r101, Continuation<? super String> r102) {
        return this.f361366a.b(r100, -1, r102);
    }

    private OfficeCardDocContentServiceDelegate() {
        IOfficeCardDocContentService r100 = (IOfficeCardDocContentService) ServiceManager.get().getService(IOfficeCardDocContentService.class);
        if (r100 != null) goto L5;
        r100 = new OfficeCardDocContentServiceNoop();
    L5:
        this.f361366a = r100;
    }
}
