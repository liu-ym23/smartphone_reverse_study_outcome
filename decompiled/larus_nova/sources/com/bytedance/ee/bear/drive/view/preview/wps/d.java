package com.bytedance.ee.bear.drive.view.preview.wps;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements bu5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f225675a;

    public d(c r100) {
        this.f225675a = r100;
    }

    @Override // bu5.a
    public final void didReceivePush(String r100) {
        this.f225675a.f225672b.getEditLimitOverLiveData().postValue(r100);
    }
}
