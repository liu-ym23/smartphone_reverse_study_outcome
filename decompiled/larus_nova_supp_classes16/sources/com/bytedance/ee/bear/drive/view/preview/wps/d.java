package com.bytedance.ee.bear.drive.view.preview.wps;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements bu5.a {
    public final /* synthetic */ c a;

    public d(c r1) {
        this.a = r1;
    }

    public final void didReceivePush(String r2) {
        this.a.b.getEditLimitOverLiveData().postValue(r2);
    }
}
