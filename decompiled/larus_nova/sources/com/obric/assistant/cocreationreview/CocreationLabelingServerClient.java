package com.obric.assistant.cocreationreview;

import com.larus.platform.service.AccountService;
import kotlin.coroutines.Continuation;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class CocreationLabelingServerClient {
    public CocreationLabelingServerClient() {
    }

    public static final String a(CocreationLabelingServerClient r100) {
        r100.getClass();
        String r101 = AccountService.f365697a.getXTTToken();
        if (r101 != null) goto L5;
    L7:
        return null;
    L5:
        if ((!StringsKt.isBlank(r101)) == false) goto L7;
        return r101;
    }

    public final Object b(CocreationUserFeedbackRequest r100, Continuation<? super dm9.a<? extends Object>> r101) {
        CocreationLabelingServerApi.a r102 = CocreationLabelingServerApi.f387036a;
        CocreationLabelingServerClient$submitUserFeedback$2 r103 = new CocreationLabelingServerClient$submitUserFeedback$2(this, r100, null);
        r102.getClass();
        return CocreationLabelingServerApi.a.a(r103, r101);
    }
}
