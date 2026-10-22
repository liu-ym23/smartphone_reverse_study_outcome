package nt5;

import android.webkit.ValueCallback;
import com.bytedance.ee.larkwebview.quality.hang.detect.ResetPingSource;

/* JADX INFO: loaded from: classes19.dex */
public final class d<T> implements ValueCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f520516a;

    public d(b r100) {
        this.f520516a = r100;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object r100) {
        String r101 = (String) r100;
        this.f520516a.c(ResetPingSource.Normal.getValue());
        this.f520516a.f520501c.invoke();
    }
}
