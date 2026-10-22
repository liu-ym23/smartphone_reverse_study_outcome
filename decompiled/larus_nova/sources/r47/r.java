package r47;

import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import com.bytedance.pia.core.plugins.StreamingPlugin;

/* JADX INFO: loaded from: classes21.dex */
public final class r extends WebMessagePort.WebMessageCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebMessagePort[] f536094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ StreamingPlugin f536095b;

    public r(StreamingPlugin r100, WebMessagePort[] r101) {
        this.f536095b = r100;
        this.f536094a = r101;
    }

    @Override // android.webkit.WebMessagePort.WebMessageCallback
    public final void onMessage(WebMessagePort r100, WebMessage r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if ("streaming_ack".equals(r101.getData()) == false) goto L8;
        this.f536095b.f266276h.set(this.f536094a[0]);
        return;
    }
}
