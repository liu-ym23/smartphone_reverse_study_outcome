package com.bytedance.ee.bear.middleground.comment.cell;

import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.ee.bear.middleground.comment.export.Action;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class s<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.control.t f231086a;

    public s(com.bytedance.ee.bear.middleground.comment.control.t r100) {
        this.f231086a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        tt5.a.f("Comment#RetryCell", r101, false);
        com.bytedance.ee.bear.middleground.comment.control.t r102 = this.f231086a;
        String r103 = r101.getMessage();
        if (r103 != null) goto L5;
        r103 = SliceInitService.DEFAULT_SWITCH;
    L5:
        r102.w(r103, Action.EDIT);
    }
}
