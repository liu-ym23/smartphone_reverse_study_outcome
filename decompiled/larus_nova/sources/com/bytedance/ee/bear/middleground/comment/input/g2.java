package com.bytedance.ee.bear.middleground.comment.input;

import com.bytedance.ee.bear.middleground.comment.export.Action;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g2<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b2 f231948a;

    public g2(b2 r100) {
        this.f231948a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        String r101 = (String) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        if (this.f231948a.j() == false) goto L5;
        Action r102 = Action.EDIT;
    L6:
        com.bytedance.ee.util.ui.j.c(new f2(this.f231948a, r101, r102));
        return this.f231948a.f231911j;
    L5:
        r102 = Action.PUBLISH;
        goto L6
    }
}
