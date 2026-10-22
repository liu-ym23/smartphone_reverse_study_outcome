package com.bytedance.ee.bear.middleground.comment.bitablediscuss;

import android.view.View;
import ef5.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ BitableDiscussListAdapter a;

    public c(BitableDiscussListAdapter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        BitableDiscussListAdapter.access$getConfig(this.a).N.a(new a0(false));
    }
}
