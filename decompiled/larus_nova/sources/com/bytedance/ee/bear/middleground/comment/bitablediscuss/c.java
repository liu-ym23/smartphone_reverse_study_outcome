package com.bytedance.ee.bear.middleground.comment.bitablediscuss;

import android.view.View;
import ef5.a0;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableDiscussListAdapter f230714a;

    public c(BitableDiscussListAdapter r100) {
        this.f230714a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        BitableDiscussListAdapter.access$getConfig(this.f230714a).N.a(new a0(false));
    }
}
