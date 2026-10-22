package com.ss.android.lark.share_group;

import com.ss.android.lark.dto.group.GroupRecallEntity;

/* JADX INFO: loaded from: classes38.dex */
public final class i implements h7b.i.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f440533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RecallGroupChatterView f440534b;

    @Override // h7b.i.b
    public final void onCancel() {
    }

    @Override // h7b.i.b
    public final void onConfirm() {
        GroupRecallEntity r100 = new GroupRecallEntity(this.f440533a.getType(), this.f440533a.f440537b, "");
        this.f440534b.f440517e.I3(r100);
    }

    public i(RecallGroupChatterView r100, j r101) {
        this.f440534b = r100;
        this.f440533a = r101;
    }
}
