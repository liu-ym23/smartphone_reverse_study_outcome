package com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult;

/* JADX INFO: loaded from: classes18.dex */
public final class l implements com.bytedance.ee.bear.middleground.permission.escape.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchUserResultAdapter f233563a;

    @Override // com.bytedance.ee.bear.middleground.permission.escape.g.a
    public final void onCancel() {
        tt5.a.h("SearchUserResultAdapter", "checkEscapeAndApproval onCancel");
    }

    @Override // com.bytedance.ee.bear.middleground.permission.escape.g.a
    public final void onSuccess() {
        tt5.a.h("SearchUserResultAdapter", "checkEscapeAndApproval onSuccess");
        SearchUserResultAdapter r100 = this.f233563a;
        r100.f233527o = null;
        r100.f233528p = null;
        r100.D2(null);
    }

    public l(SearchUserResultAdapter r100) {
        this.f233563a = r100;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.escape.g.a
    public final void onFailed(Throwable r100) {
        tt5.a.d("SearchUserResultAdapter", "checkEscapeAndApproval onFailed");
    }
}
