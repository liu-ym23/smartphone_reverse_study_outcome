package com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult;

import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteMemberParams;
import com.bytedance.ee.bear.share.export.UserInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ UserInfo c;
    public final /* synthetic */ SearchUserResultAdapter.SearchUserViewHolder d;
    public final /* synthetic */ SearchUserResultAdapter e;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r4) {
        SearchUserResultAdapter r5 = this.e;
        InviteMemberParams r0 = r5.h;
        if (r0.o == true) goto L6;
        Toast.showFailureText(r5.a, com.bytedance.ee.bear.middleground.permission.collaborator.invite.b.b(r0.getType(), 2131888874, 2131889096));
        return;
    L6:
        if (r0.q == true) goto L9;
        Toast.showFailureText(r5.a, 2131888200);
        return;
    L9:
        if (r0.p == false) goto L11;
        return;
    L11:
        if (SearchUserResultAdapter.z2(r5, this.c) == false) goto L13;
        SearchUserResultAdapter.A2(this.e, this.d, this.c);
        return;
    L13:
        SearchUserResultAdapter r6 = this.e;
        Toast.showFailureText(r6.a, com.bytedance.ee.bear.middleground.permission.collaborator.invite.b.b(r6.h.getType(), 2131888870, 2131887262));
    }

    public k(SearchUserResultAdapter r1, UserInfo r2, SearchUserResultAdapter.SearchUserViewHolder r3) {
        this.e = r1;
        this.c = r2;
        this.d = r3;
    }
}
