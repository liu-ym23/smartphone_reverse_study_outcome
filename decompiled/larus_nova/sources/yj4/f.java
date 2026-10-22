package yj4;

import com.bytedance.dora.device.DoraDevice;
import com.bytedance.dora.link.IDoraLinkCallback;
import pk4.m;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements h, IDoraLinkCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f568085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f568086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f568087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f568088d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f568089e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f568090f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public yj4.a f568091g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f568092a = null;

        static {
            f568092a = new f();
        }
    }

    @Override // com.bytedance.dora.link.IDoraLinkCallback
    public final /* synthetic */ void onBtConnectStateChanged(DoraDevice r100, int r101, int r102) {
        IDoraLinkCallback.CC.$default$onBtConnectStateChanged(this, r100, r101, r102);
    }

    @Override // com.bytedance.dora.link.IDoraLinkCallback
    public final /* synthetic */ void onBtStateChanged(int r100, int r101) {
        IDoraLinkCallback.CC.$default$onBtStateChanged(this, r100, r101);
    }

    @Override // com.bytedance.dora.link.IDoraLinkCallback
    public final /* synthetic */ void onDeviceFound(DoraDevice r100) {
        IDoraLinkCallback.CC.$default$onDeviceFound(this, r100);
    }

    @Override // com.bytedance.dora.link.IDoraLinkCallback
    public final /* synthetic */ void onScanFailed(int r100) {
        IDoraLinkCallback.CC.$default$onScanFailed(this, r100);
    }

    public f() {
        this.f568085a = -1;
        this.f568086b = -1;
        this.f568087c = -1;
        this.f568088d = -1;
        this.f568089e = -1;
        this.f568090f = -1;
        kj4.a.g().registerDoraLinkCallback(this);
    }

    public final void a(long r100) {
        h.C2.j(1, 4, new byte[]{22, 0}, r100);
    }

    @Override // com.bytedance.dora.link.IDoraLinkCallback
    public final void onDoraLinkStateChanged(DoraDevice r100, int r101, int r102) {
        if (r102 != 2) goto L6;
        m.a(new d(this));
        m.a(new e(this));
        return;
    }
}
