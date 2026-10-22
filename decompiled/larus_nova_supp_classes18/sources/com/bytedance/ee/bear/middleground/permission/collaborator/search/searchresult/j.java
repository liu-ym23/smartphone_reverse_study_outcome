package com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult;

import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteMemberParams;
import com.bytedance.ee.bear.share.export.UserInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ UserInfo c;
    public final /* synthetic */ SearchUserResultAdapter.SearchUserViewHolder d;
    public final /* synthetic */ SearchUserResultAdapter e;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r4) {
        if (this.e.h.r == false) goto L15;
        UserInfo r5 = this.c;
        boolean r1 = true;
        if (r5.getOwnerType() != 0) goto L7;
    L10:
        if (r1 == true) goto L15;
        if (this.e.h.getType() != sbb.e.f.b) goto L14;
        Toast.showText(this.e.a, 2131887295);
        return;
    L14:
        SearchUserResultAdapter r6 = this.e;
        Toast.showText(r6.a, com.bytedance.ee.bear.middleground.permission.collaborator.invite.b.b(r6.h.getType(), 2131888884, 2131887292));
        return;
    L7:
        if (r5.getOwnerType() == 1) goto L10;
        r1 = false;
    L15:
        SearchUserResultAdapter r7 = this.e;
        InviteMemberParams r0 = r7.h;
        if (r0.i == false) goto L21;
        if (r0.t == false) goto L21;
        Toast.showText(r7.a, 2131887509);
        return;
    L21:
        if (r0.l == true) goto L23;
        Toast.showText(r7.a, 2131887271);
        return;
    L23:
        if (r0.getType() != sbb.e.f.b) goto L31;
        SearchUserResultAdapter r8 = this.e;
        InviteMemberParams r2 = r8.h;
        if (r2.s == true) goto L27;
    L29:
        Toast.showText(r8.a, 2131887261);
        return;
    L27:
        if (r2.r == true) goto L29;
        Toast.showText(r8.a, 2131887259);
        return;
    L31:
        if (SearchUserResultAdapter.z2(this.e, this.c) == false) goto L33;
        SearchUserResultAdapter.A2(this.e, this.d, this.c);
        return;
    L33:
        SearchUserResultAdapter r9 = this.e;
        InviteMemberParams r3 = r9.h;
        if (r3.s == true) goto L36;
    L38:
        Toast.showText(r9.a, com.bytedance.ee.bear.middleground.permission.collaborator.invite.b.b(r3.getType(), 2131888870, 2131887262));
        return;
    L36:
        if (r3.r == true) goto L38;
        Toast.showText(r9.a, com.bytedance.ee.bear.middleground.permission.collaborator.invite.b.b(r3.getType(), 2131888871, 2131887260));
    }

    public j(SearchUserResultAdapter r1, UserInfo r2, SearchUserResultAdapter.SearchUserViewHolder r3) {
        this.e = r1;
        this.c = r2;
        this.d = r3;
    }
}
