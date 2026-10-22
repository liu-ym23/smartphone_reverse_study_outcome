package com.bytedance.ee.bear.list.create;

import android.content.DialogInterface;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h implements DialogInterface.OnClickListener {
    public final /* synthetic */ m a;

    public h(m r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        e.b(this.a, DocFeed$Value$Result.CANCEL);
    }
}
