package com.bytedance.ee.bear.middleground.comment.input;

import com.bytedance.ee.bear.middleground.comment.export.Action;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g2<T, R> implements Function {
    public final /* synthetic */ b2 a;

    public g2(b2 r1) {
        this.a = r1;
    }

    public final Object apply(Object r4) {
        String r5 = (String) r4;
        Intrinsics.checkNotNullParameter(r5, "it");
        if (this.a.j() == false) goto L5;
        Action r0 = Action.EDIT;
    L6:
        com.bytedance.ee.util.ui.j.c(new f2(this.a, r5, r0));
        return this.a.j;
    L5:
        r0 = Action.PUBLISH;
        goto L6
    }
}
