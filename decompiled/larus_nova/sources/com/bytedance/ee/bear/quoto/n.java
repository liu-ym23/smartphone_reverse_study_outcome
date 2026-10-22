package com.bytedance.ee.bear.quoto;

import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes18.dex */
public final class n extends BasePresenter<u, v, v.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f236418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f236419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f236420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f236421d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f236422e;

    public interface a {
    }

    @Override // com.larksuite.framework.mvp.BasePresenter
    public final /* bridge */ /* synthetic */ IView.IViewDelegate createViewDelegate() {
        return null;
    }

    @Override // com.larksuite.framework.mvp.BasePresenter, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        super.create();
        final String r100 = ((com.bytedance.ee.bear.contract.b0) org.koin.java.a.a(com.bytedance.ee.bear.contract.b0.class)).getUid();
        Disposable r101 = getModel().e2(this.f236418a, this.f236419b).subscribe(new l(this, r100), new m(this));
        this.f236421d.add(r101);
        tt5.a.h("ExceedQuotaPresenter", "create()...");
    }

    @Override // com.larksuite.framework.mvp.BasePresenter, com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        super.destroy();
        this.f236421d.clear();
        tt5.a.h("ExceedQuotaPresenter", "destroy()...");
    }

    public n(k r100, s r101, String r102, String r103, boolean r104, f r105) {
        super(r100, r101);
        this.f236421d = new CompositeDisposable();
        this.f236418a = r102;
        this.f236419b = r103;
        this.f236420c = r104;
        this.f236422e = r105;
    }
}
