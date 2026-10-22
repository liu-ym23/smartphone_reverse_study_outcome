package com.bytedance.ee.bear.wikiv2;

import com.bytedance.ee.bear.wikiv2.home.api.GetSpacePuller;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k<T, R> implements Function {
    public final /* synthetic */ l a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ boolean c;

    public k(l r1, boolean r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object apply(Object r3) {
        GetSpacePuller.Result r4 = (GetSpacePuller.Result) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        l r0 = this.a;
        r0.b = r4.last_label;
        r0.a = r4.has_more;
        if (this.b == false) goto L5;
        ArrayList r1 = new ArrayList();
    L11:
        List r5 = r4.spaces;
        if (r5 != null) goto L14;
        r5 = new ArrayList();
    L14:
        r1.addAll(r5);
        this.a.c = r1;
        if (this.c == false) goto L17;
        int r2 = zp5.f.a;
        zp5.f.b(r5, new ce5.a());
    L17:
        return r5;
    L5:
        List<? extends SpaceBean> r6 = r0.c;
        if ((r6 instanceof ArrayList) == false) goto L8;
        r1 = (ArrayList) r6;
    L9:
        if (r1 != null) goto L11;
        r1 = new ArrayList();
        goto L11
    L8:
        r1 = null;
        goto L9
    }
}
