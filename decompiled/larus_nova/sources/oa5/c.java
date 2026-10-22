package oa5;

import android.webkit.ValueCallback;
import tb5.m;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements ValueCallback<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f522545a;

    public c(m r100) {
        this.f522545a = r100;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(String r100) {
        m r101 = this.f522545a;
        r101.onCallBack(r100);
    }
}
