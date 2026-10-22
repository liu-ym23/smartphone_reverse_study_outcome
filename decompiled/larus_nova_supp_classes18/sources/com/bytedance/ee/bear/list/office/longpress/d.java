package com.bytedance.ee.bear.list.office.longpress;

import android.content.Context;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ com.bytedance.ee.bear.more.office.c a;
    public final /* synthetic */ Context b;

    public d(com.bytedance.ee.bear.more.office.c r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        ConcurrentHashMap<String, WikNodePerm> r0 = b.d;
        String r1 = this.a.a;
        r0.put(r1, (WikNodePerm) r3);
        Toast.cancelLoading();
        b r4 = b.a;
        String r5 = this.a.a;
        CompositeDisposable r6 = b.c.remove(r5);
        if (r6 == null) goto L5;
        r6.clear();
    L5:
        b.a r7 = b.g(this.a, false, null);
        if (Intrinsics.areEqual(r7, b.a.C0027b.a) == false) goto L9;
        b.f(this.a);
        return;
    L9:
        if (Intrinsics.areEqual(r7, b.a.c.a) == false) goto L12;
        Toast.showFailureText(this.b, com.bytedance.ee.bear.more.office.f.c());
        return;
    L12:
        if (Intrinsics.areEqual(r7, b.a.d.a) == false) goto L15;
        Toast.showFailureText(this.b, com.bytedance.ee.bear.more.office.f.b());
        return;
    L15:
        if ((r7 instanceof b.a.C0026a) == false) goto L19;
        Toast.showFailureText(this.b, ((b.a.C0026a) r7).a);
        return;
    L19:
        throw new NoWhenBranchMatchedException();
    }
}
