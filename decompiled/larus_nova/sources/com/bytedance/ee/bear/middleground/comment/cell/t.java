package com.bytedance.ee.bear.middleground.comment.cell;

import com.bytedance.ee.bear.middleground.comment.export.Action;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class t<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.control.t f231087a;

    public t(com.bytedance.ee.bear.middleground.comment.control.t r100) {
        this.f231087a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        com.bytedance.ee.bear.middleground.comment.control.t r102 = this.f231087a;
        Intrinsics.checkNotNull(r101);
        r102.w(r101, Action.PUBLISH);
    }
}
