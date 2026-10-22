package com.bytedance.ee.bear.middleground.comment.input;

import com.bytedance.ee.bear.middleground.comment.export.Action;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i2<T> implements Consumer {
    public final /* synthetic */ b2 a;
    public final /* synthetic */ Function4<Boolean, String, Throwable, CommentInputRequest, Unit> b;

    /* JADX WARN: Multi-variable type inference failed */
    public i2(b2 r1, Function4<? super Boolean, ? super String, ? super Throwable, ? super CommentInputRequest, Unit> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        Throwable r6 = (Throwable) r5;
        if (this.a.j() == false) goto L5;
        Action r0 = Action.EDIT;
    L6:
        com.bytedance.ee.bear.middleground.comment.control.t r1 = this.a.d;
        String r2 = r6.getMessage();
        if (r2 != null) goto L9;
        r2 = "{}";
    L9:
        r1.w(r2, r0);
        this.b.invoke(Boolean.FALSE, "", r6, this.a.e);
        tt5.a.e("Comment#InputViewModel", "send comment error", r6, false);
        return;
    L5:
        r0 = Action.PUBLISH;
        goto L6
    }
}
