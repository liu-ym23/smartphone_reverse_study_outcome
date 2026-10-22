package com.bytedance.ee.bear.middleground.comment.input;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import io.reactivex.functions.Action;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j2 implements Action {
    public final /* synthetic */ Function4<Boolean, String, Throwable, CommentInputRequest, Unit> a;
    public final /* synthetic */ b2 b;

    /* JADX WARN: Multi-variable type inference failed */
    public j2(Function4<? super Boolean, ? super String, ? super Throwable, ? super CommentInputRequest, Unit> r1, b2 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void run() {
        this.a.invoke(Boolean.TRUE, "", null, this.b.e);
        b2.d(this.b);
    }
}
