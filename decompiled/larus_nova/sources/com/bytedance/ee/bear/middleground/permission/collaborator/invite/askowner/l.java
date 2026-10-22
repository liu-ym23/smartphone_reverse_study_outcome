package com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: classes18.dex */
public final class l extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ InviteMemberAskOwnerView f233234c;

    public l(InviteMemberAskOwnerView r100) {
        this.f233234c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        b.a r101 = this.f233234c.f233202e;
        if (r101 == null) goto L6;
        r101.onBack();
        return;
    }
}
