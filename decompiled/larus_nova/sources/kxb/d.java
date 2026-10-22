package kxb;

import android.webkit.ValueCallback;
import com.ss.android.lark.officewebview.quality.hang.detect.ResetPingSource;

/* JADX INFO: loaded from: classes37.dex */
public final class d<T> implements ValueCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f506617a;

    public d(b r100) {
        this.f506617a = r100;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object r100) {
        String r101 = (String) r100;
        this.f506617a.c(ResetPingSource.Normal.getValue());
        this.f506617a.f506602c.invoke();
    }
}
