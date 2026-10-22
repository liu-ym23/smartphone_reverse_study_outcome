package oa5;

import android.webkit.ValueCallback;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements ValueCallback<String> {
    public final /* synthetic */ m a;

    public c(m r1) {
        this.a = r1;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(String r2) {
        m r0 = this.a;
        r0.onCallBack(r2);
    }
}
