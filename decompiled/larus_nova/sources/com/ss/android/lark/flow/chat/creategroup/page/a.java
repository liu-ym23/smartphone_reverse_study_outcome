package com.ss.android.lark.flow.chat.creategroup.page;

import android.view.View;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowGroupCreateActivity f422096a;

    public a(FlowGroupCreateActivity r100) {
        this.f422096a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        FlowGroupCreateActivity.z1(this.f422096a);
        this.f422096a.finish();
    }
}
