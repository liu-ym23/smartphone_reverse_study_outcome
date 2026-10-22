package com.bytedance.ee.bear.lark.announcement;

/* JADX INFO: loaded from: classes16.dex */
public final /* synthetic */ class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnnouncementPresenter f227267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f227268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AnnouncementPresenter.AnnounceSendCallback f227269c;

    public /* synthetic */ n(AnnouncementPresenter r100, String r101, AnnouncementPresenter.AnnounceSendCallback r102) {
        this.f227267a = r100;
        this.f227268b = r101;
        this.f227269c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AnnouncementPresenter r100 = this.f227267a;
        String r101 = this.f227268b;
        AnnouncementPresenter.AnnounceSendCallback r102 = this.f227269c;
        r100.i(r100.f227225e.a(), r101, r102);
    }
}
