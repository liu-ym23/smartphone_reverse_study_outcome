package com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l implements com.bytedance.ee.bear.middleground.permission.escape.g.a {
    public final /* synthetic */ SearchUserResultAdapter a;

    @Override // com.bytedance.ee.bear.middleground.permission.escape.g.a
    public final void onCancel() {
        tt5.a.h("SearchUserResultAdapter", "checkEscapeAndApproval onCancel");
    }

    @Override // com.bytedance.ee.bear.middleground.permission.escape.g.a
    public final void onSuccess() {
        tt5.a.h("SearchUserResultAdapter", "checkEscapeAndApproval onSuccess");
        SearchUserResultAdapter r0 = this.a;
        r0.o = null;
        r0.p = null;
        r0.D2(null);
    }

    public l(SearchUserResultAdapter r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.escape.g.a
    public final void onFailed(Throwable r2) {
        tt5.a.d("SearchUserResultAdapter", "checkEscapeAndApproval onFailed");
    }
}
