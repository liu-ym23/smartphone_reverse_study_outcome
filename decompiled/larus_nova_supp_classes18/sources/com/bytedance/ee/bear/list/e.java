package com.bytedance.ee.bear.list;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class e<R extends Result<?>> {
    public final CompositeDisposable a;

    public abstract NetService.d<R> m();

    public abstract String n();

    public e() {
        this.a = new CompositeDisposable();
    }

    public static NetService.f j(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "path");
        Intrinsics.checkNotNullParameter(r3, "json");
        NetService.f r0 = new NetService.f(r2);
        boolean r4 = true;
        ((NetService.e) r0).c = 1;
        if (r3.length() > 0) goto L6;
        r4 = false;
    L6:
        if (r4 == false) goto L8;
        ((NetService.e) r0).j = r3;
    L8:
        return r0;
    }

    public static NetService.f k(String r1, Map r2) {
        Intrinsics.checkNotNullParameter(r1, "path");
        NetService.f r0 = new NetService.f(r1);
        ((NetService.e) r0).c = 1;
        if (r2 == null) goto L5;
        r0.d(r2);
    L5:
        return r0;
    }

    public final d l(NetService.f r4, nc5.a r5) {
        Intrinsics.checkNotNullParameter(r4, "request");
        Intrinsics.checkNotNullParameter(r5, "callback");
        tt5.a.h(n(), "execute");
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        Disposable r6 = m().a(r4).doFinally(new a(r0, this)).subscribe(new b(r5), new c(r5));
        r0.element = r6;
        this.a.add(r6);
        return new d(this, r0);
    }
}
