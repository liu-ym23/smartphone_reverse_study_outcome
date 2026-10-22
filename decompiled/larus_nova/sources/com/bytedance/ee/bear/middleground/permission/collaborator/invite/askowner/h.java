package com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner;

import android.view.View;
import com.bytedance.ee.bear.share.export.UserInfo;

/* JADX INFO: loaded from: classes18.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InviteMemberAskOwnerView f233227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserInfo f233228b;

    public h(InviteMemberAskOwnerView r100, UserInfo r101) {
        this.f233227a = r100;
        this.f233228b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f233227a.o(this.f233228b);
    }
}
