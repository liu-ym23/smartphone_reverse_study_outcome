package com.bytedance.ee.bear.middleground.comment.input;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class h2<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function4<Boolean, String, Throwable, CommentInputRequest, Unit> f231953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b2 f231954b;

    /* JADX WARN: Multi-variable type inference failed */
    public h2(Function4<? super Boolean, ? super String, ? super Throwable, ? super CommentInputRequest, Unit> r100, b2 r101) {
        this.f231953a = r100;
        this.f231954b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        Function4<Boolean, String, Throwable, CommentInputRequest, Unit> r102 = this.f231953a;
        Boolean r103 = Boolean.TRUE;
        Intrinsics.checkNotNull(r101);
        r102.invoke(r103, r101, null, this.f231954b.f231906e);
        b2.d(this.f231954b);
    }
}
