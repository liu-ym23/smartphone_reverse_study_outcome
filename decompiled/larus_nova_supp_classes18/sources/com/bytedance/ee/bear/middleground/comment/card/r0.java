package com.bytedance.ee.bear.middleground.comment.card;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.comment.export.bean.ReviewException;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r0<T> implements Consumer {
    public final /* synthetic */ HalfScreenCardComment a;

    public r0(HalfScreenCardComment r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        tt5.a.e("Comment#CardComment", "send voice data error: ", r5, false);
        if ((r5 instanceof ReviewException) == false) goto L5;
        ((com.bytedance.ee.bear.review.a) org.koin.java.a.c(com.bytedance.ee.bear.review.a.class, null, null, 6)).h(this.a.a.getActivity());
        return;
    L5:
        Toast.showFailureText(this.a.a.getActivity(), this.a.a.getActivity().getString(2131887611), 0);
    }
}
