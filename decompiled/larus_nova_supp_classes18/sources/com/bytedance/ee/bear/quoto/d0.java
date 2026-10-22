package com.bytedance.ee.bear.quoto;

import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d0 extends BasePresenter<w, x, x.a> {
    public final CompositeDisposable a;
    public final Long b;
    public String c;
    public Boolean d;
    public String e;

    public final /* bridge */ /* synthetic */ IView.IViewDelegate createViewDelegate() {
        return null;
    }

    public final void create() {
        super.create();
        tt5.a.h("SingleFileExceedQuotaPr", "create()...");
        Disposable r0 = ((w) getModel()).E1().observeOn(fo5.d.d()).subscribe(new b0(this), new c0(this));
        this.a.add(r0);
    }

    public final void destroy() {
        super.destroy();
        tt5.a.h("SingleFileExceedQuotaPr", "destroy()...");
        this.a.clear();
    }

    public d0(a0 r1, f0 r2, Long r3) {
        super(r1, r2);
        this.a = new CompositeDisposable();
        this.b = r3;
    }
}
