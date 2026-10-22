package com.bytedance.ee.bear.bitable.card.view.cell.attachment.view;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.AttachmentEntity;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements ActionMode.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f207459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f207460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AttachmentEntity f207461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AttachmentAdapter f207462d;

    @Override // android.view.ActionMode.Callback
    public final boolean onPrepareActionMode(ActionMode r100, Menu r101) {
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public final void onDestroyActionMode(ActionMode r100) {
        this.f207460b.setVisibility(8);
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onActionItemClicked(ActionMode r100, MenuItem r101) {
        AttachmentAdapter r102 = this.f207462d;
        ActionMode r103 = r102.f207386f;
        if (r103 == null) goto L5;
        r103.finish();
        r102.f207386f = null;
    L5:
        AttachmentAdapter.a r104 = this.f207462d.f207385e;
        if (r104 == null) goto L10;
        r104.a(AttachmentMenuEnum.valueOf(r101.getItemId()), this.f207461c);
        return true;
    L10:
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onCreateActionMode(ActionMode r100, Menu r101) {
        eu5.h.a(this.f207459a.getContext(), 10, 50);
        this.f207460b.setVisibility(0);
        AttachmentMenuEnum[] r102 = this.f207462d.f207383c;
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        AttachmentMenuEnum r105 = r102[r104];
        r101.add(769711401, r105.getId(), 0, r105.getTitleResId());
        r104 = r104 + 1;
        goto L3
    L5:
        return true;
    }

    public a(AttachmentAdapter r100, AttachmentCoverView r101, View r102, AttachmentEntity r103) {
        this.f207462d = r100;
        this.f207459a = r101;
        this.f207460b = r102;
        this.f207461c = r103;
    }
}
