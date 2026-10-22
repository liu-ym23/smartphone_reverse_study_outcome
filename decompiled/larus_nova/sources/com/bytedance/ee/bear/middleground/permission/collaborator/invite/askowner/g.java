package com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner;

import android.view.View;
import com.bytedance.ee.bear.share.export.UserInfo;

/* JADX INFO: loaded from: classes18.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InviteMemberAskOwnerView f233225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserInfo f233226b;

    public g(InviteMemberAskOwnerView r100, UserInfo r101) {
        this.f233225a = r100;
        this.f233226b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f233225a.k(this.f233226b);
    }
}
