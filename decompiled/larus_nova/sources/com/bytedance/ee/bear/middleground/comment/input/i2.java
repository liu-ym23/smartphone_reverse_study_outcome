package com.bytedance.ee.bear.middleground.comment.input;

import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.ee.bear.middleground.comment.export.Action;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes18.dex */
public final class i2<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b2 f231958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function4<Boolean, String, Throwable, CommentInputRequest, Unit> f231959b;

    /* JADX WARN: Multi-variable type inference failed */
    public i2(b2 r100, Function4<? super Boolean, ? super String, ? super Throwable, ? super CommentInputRequest, Unit> r101) {
        this.f231958a = r100;
        this.f231959b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        if (this.f231958a.j() == false) goto L5;
        Action r102 = Action.EDIT;
    L6:
        com.bytedance.ee.bear.middleground.comment.control.t r103 = this.f231958a.f231905d;
        String r104 = r101.getMessage();
        if (r104 != null) goto L9;
        r104 = SliceInitService.DEFAULT_SWITCH;
    L9:
        r103.w(r104, r102);
        this.f231959b.invoke(Boolean.FALSE, "", r101, this.f231958a.f231906e);
        tt5.a.e("Comment#InputViewModel", "send comment error", r101, false);
        return;
    L5:
        r102 = Action.PUBLISH;
        goto L6
    }
}
