package com.bytedance.android.shopping.deepfeed.ui.view;

import android.view.View;
import com.bytedance.android.shopping.deepfeed.action.DeepFeedCommentClickArea;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ CommentItemView a;

    public c(CommentItemView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        Function1<? super DeepFeedCommentClickArea, Unit> r3 = this.a.i;
        if (r3 == null) goto L6;
        Unit r4 = (Unit) r3.invoke(DeepFeedCommentClickArea.Avatar);
        return;
    }
}
