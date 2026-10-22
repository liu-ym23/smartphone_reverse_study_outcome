package com.bytedance.ee.bear.middleground.comment.input;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import io.reactivex.functions.Action;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes18.dex */
public final class j2 implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function4<Boolean, String, Throwable, CommentInputRequest, Unit> f231968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b2 f231969b;

    /* JADX WARN: Multi-variable type inference failed */
    public j2(Function4<? super Boolean, ? super String, ? super Throwable, ? super CommentInputRequest, Unit> r100, b2 r101) {
        this.f231968a = r100;
        this.f231969b = r101;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f231968a.invoke(Boolean.TRUE, "", null, this.f231969b.f231906e);
        b2.d(this.f231969b);
    }
}
