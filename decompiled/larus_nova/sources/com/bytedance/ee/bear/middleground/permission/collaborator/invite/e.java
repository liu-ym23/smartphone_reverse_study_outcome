package com.bytedance.ee.bear.middleground.permission.collaborator.invite;

import android.view.View;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.widgets.t;
import com.chad.library.adapter.base.BaseViewHolder;

/* JADX INFO: loaded from: classes18.dex */
public final class e extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ UserInfo f233294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ BaseViewHolder f233295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ FolderInviteCollaboratorManageAdapter f233296e;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        BaseInviteCollaboratorManageAdapter.a r101 = this.f233296e.f233164c;
        if (r101 == null) goto L6;
        r101.a(this.f233294c, this.f233295d.getLayoutPosition());
        return;
    }

    public e(FolderInviteCollaboratorManageAdapter r100, UserInfo r101, BaseViewHolder r102) {
        this.f233296e = r100;
        this.f233294c = r101;
        this.f233295d = r102;
    }
}
