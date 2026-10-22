package com.larus.office.card.doc.create;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J^\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0012H\u0096A¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/larus/office/card/doc/create/OfficeCardDocCreateServiceDelegate;", "Lcom/larus/office/card/doc/create/IOfficeCardDocCreateService;", "<init>", "()V", "createDocByMessage", "Lcom/larus/network/bean/HttpDataResult;", "Lcom/larus/office/card/doc/create/OfficeCardCreateDocByMessageResponse;", "conversationId", "", "messageId", "", "resourceType", "", "sourceType", "docRealToken", "useMessageContent", "", "headers", "", "(Ljava/lang/String;JIILjava/lang/String;Ljava/lang/Boolean;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeCardDocCreateServiceDelegate implements IOfficeCardDocCreateService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final OfficeCardDocCreateServiceDelegate f361373b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IOfficeCardDocCreateService f361374a;

    static {
        f361373b = new OfficeCardDocCreateServiceDelegate();
    }

    @Override // com.larus.office.card.doc.create.IOfficeCardDocCreateService
    public final Object a(String r110, long r111, int r112, int r113, String r114, Boolean r115, Map<String, String> r116, Continuation<? super dm9.a<b>> r210) {
        return this.f361374a.a(r110, r111, r112, r113, r114, r115, r116, r210);
    }

    private OfficeCardDocCreateServiceDelegate() {
        IOfficeCardDocCreateService r100 = (IOfficeCardDocCreateService) ServiceManager.get().getService(IOfficeCardDocCreateService.class);
        if (r100 != null) goto L5;
        r100 = new OfficeCardDocCreateServiceNoop();
    L5:
        this.f361374a = r100;
    }
}
