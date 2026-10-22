package com.ss.android.lark.contact.base.contact_list.mvp;

/* JADX INFO: loaded from: classes35.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ExternalContactPresenter2.b f418589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w8b.a f418590b;

    public /* synthetic */ a(ExternalContactPresenter2.b r100, w8b.a r101) {
        this.f418589a = r100;
        this.f418590b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ExternalContactPresenter2.b r100 = this.f418589a;
        w8b.a r101 = this.f418590b;
        r100.f418576a.getView().p4(r101);
    }
}
