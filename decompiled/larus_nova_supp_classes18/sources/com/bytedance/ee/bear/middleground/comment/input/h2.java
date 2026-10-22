package com.bytedance.ee.bear.middleground.comment.input;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h2<T> implements Consumer {
    public final /* synthetic */ Function4<Boolean, String, Throwable, CommentInputRequest, Unit> a;
    public final /* synthetic */ b2 b;

    /* JADX WARN: Multi-variable type inference failed */
    public h2(Function4<? super Boolean, ? super String, ? super Throwable, ? super CommentInputRequest, Unit> r1, b2 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        String r6 = (String) r5;
        Function4<Boolean, String, Throwable, CommentInputRequest, Unit> r0 = this.a;
        Boolean r1 = Boolean.TRUE;
        Intrinsics.checkNotNull(r6);
        r0.invoke(r1, r6, null, this.b.e);
        b2.d(this.b);
    }
}
