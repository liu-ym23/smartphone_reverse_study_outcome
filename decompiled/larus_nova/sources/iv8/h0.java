package iv8;

import com.larus.browsertakeover.cdp.BrowserCdpClient;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class h0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f496023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BrowserCdpClient f496024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BrowserCdpClient.j f496025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ BrowserCdpClient.l f496026d;

    public /* synthetic */ h0(int r100, BrowserCdpClient r101, BrowserCdpClient.j r102, BrowserCdpClient.l r103) {
        this.f496023a = r100;
        this.f496024b = r101;
        this.f496025c = r102;
        this.f496026d = r103;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r100 = this.f496023a;
        BrowserCdpClient r101 = this.f496024b;
        BrowserCdpClient.j r102 = this.f496025c;
        BrowserCdpClient.l r103 = this.f496026d;
        if (r100 != r101.f319390j.get()) goto L9;
        if (r102 != null) goto L6;
    L7:
        r101.f319382b.ko(r103);
        return;
    L6:
        if (r101.v(r102) == true) goto L7;
        return;
    }
}
