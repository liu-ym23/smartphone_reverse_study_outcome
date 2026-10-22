package com.bytedance.ee.bear.quoto;

import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n extends BasePresenter<u, v, v.a> {
    public final String a;
    public final String b;
    public final boolean c;
    public final CompositeDisposable d;
    public final a e;

    public interface a {
    }

    public final /* bridge */ /* synthetic */ IView.IViewDelegate createViewDelegate() {
        return null;
    }

    public final void create() {
        super.create();
        final String r0 = ((com.bytedance.ee.bear.contract.b0) org.koin.java.a.a(com.bytedance.ee.bear.contract.b0.class)).getUid();
        Disposable r1 = ((u) getModel()).e2(this.a, this.b).subscribe(new l(this, r0), new m(this));
        this.d.add(r1);
        tt5.a.h("ExceedQuotaPresenter", "create()...");
    }

    public final void destroy() {
        super.destroy();
        this.d.clear();
        tt5.a.h("ExceedQuotaPresenter", "destroy()...");
    }

    public n(k r1, s r2, String r3, String r4, boolean r5, f r6) {
        super(r1, r2);
        this.d = new CompositeDisposable();
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.e = r6;
    }
}
