package com.bytedance.ee.bear.middleground.comment.input;

import com.bytedance.ee.bear.fileselector.bean.FileBean;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r0<T> implements Consumer {
    public final /* synthetic */ InputComment a;
    public final /* synthetic */ List<FileBean> b;

    public r0(InputComment r1, List<? extends FileBean> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        Boolean r3 = (Boolean) r2;
        tt5.a.h("Comment#InputComment", "saveImagesToLocal...");
        InputComment.w(this.a, this.b);
    }
}
