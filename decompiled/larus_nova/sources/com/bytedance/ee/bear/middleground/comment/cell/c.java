package com.bytedance.ee.bear.middleground.comment.cell;

import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.ee.bear.middleground.comment.export.Action;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.control.t f231046a;

    public c(com.bytedance.ee.bear.middleground.comment.control.t r100) {
        this.f231046a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        tt5.a.e("Comment#DeleteCell", "Error deleting comment", r101, false);
        com.bytedance.ee.bear.middleground.comment.control.t r102 = this.f231046a;
        String r103 = r101.getMessage();
        if (r103 != null) goto L5;
        r103 = SliceInitService.DEFAULT_SWITCH;
    L5:
        r102.w(r103, Action.DELETE);
    }
}
