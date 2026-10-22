package com.bytedance.ee.bear.list.folder.complaint;

import android.content.Context;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f extends BasePresenter<i, j, j.a> implements j.a {
    public final Context a;
    public final a b;
    public final boolean c;
    public final boolean d;
    public final CompositeDisposable e;

    public interface a {
    }

    public final IView.IViewDelegate createViewDelegate() {
        return this;
    }

    @Override // com.bytedance.ee.bear.list.folder.complaint.j.a
    public final void Z4() {
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("ccm.drive.mobile.forbidden", true) == true) goto L5;
    L7:
        ((j) getView()).x4();
        Disposable r0 = ((i) getModel()).q4().subscribe(new d(this), new e(this));
        this.e.add(r0);
        return;
    L5:
        if (this.d == false) goto L7;
        ((j) getView()).x4();
        Disposable r1 = ((i) getModel()).q4().subscribe(new b(this), new c(this));
        this.e.add(r1);
    }

    public final void destroy() {
        super.destroy();
        this.e.clear();
    }

    public f(com.bytedance.ee.bear.list.folder.complaint.a r1, FolderComplaintView r2, a r3, Context r4, boolean r5, boolean r6) {
        super(r1, r2);
        this.e = new CompositeDisposable();
        this.a = r4;
        this.b = r3;
        this.c = r5;
        this.d = r6;
    }
}
