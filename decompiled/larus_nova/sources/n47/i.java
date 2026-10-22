package n47;

import android.text.TextUtils;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import com.bytedance.pia.core.bridge.channel.WebViewPort;

/* JADX INFO: loaded from: classes21.dex */
public final class i extends WebMessagePort.WebMessageCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebMessagePort[] f517076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WebViewPort f517077b;

    public i(WebViewPort r100, WebMessagePort[] r101) {
        this.f517077b = r100;
        this.f517076a = r101;
    }

    @Override // android.webkit.WebMessagePort.WebMessageCallback
    public final void onMessage(WebMessagePort r100, WebMessage r101) {
        String r102 = r101.getData();
        if (TextUtils.isEmpty(r102) == false) goto L6;
        return;
    L6:
        if ("__port_init__".equals(r102) == false) goto L10;
        this.f517077b.c(Boolean.FALSE);
        return;
    L10:
        if ("__port_init_next__".equals(r102) == false) goto L14;
        this.f517077b.c(Boolean.TRUE);
        return;
    L14:
        if ("__channel_ack__".equals(r102) == false) goto L17;
        WebViewPort r103 = this.f517077b;
        r103.f266166c = this.f517076a[0];
        return;
    L17:
        this.f517077b.f266165b.a(r102);
    }
}
