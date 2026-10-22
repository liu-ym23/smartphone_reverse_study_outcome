package com.bytedance.android.shopping.commentv3.uitree.title;

import android.view.View;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.shopping.commentv3.data.interfaces.SubTitle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ CommentTitleUI a;
    public final /* synthetic */ SubTitle b;

    public e(CommentTitleUI r1, SubTitle r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        p r4 = p.a;
        CommentTitleUI r0 = this.a;
        int r1 = CommentTitleUI.v;
        r4.openSchema(r0.getContext(), this.b.getSchema());
    }
}
