package ny3;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements p24.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f521193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f521194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f521195c;

    @Override // r34.a
    public final void b() {
    }

    @Override // r34.d
    public final void a() {
        com.bytedance.awemeopen.apps.framework.comment.view.c r100 = (com.bytedance.awemeopen.apps.framework.comment.view.c) this.f521193a.f547816b;
        if (r100 == null) goto L6;
        r100.h(this.f521194b, this.f521195c);
        return;
    }

    @Override // r34.g
    public final void onSuccess() {
        com.bytedance.awemeopen.apps.framework.comment.view.c r100 = (com.bytedance.awemeopen.apps.framework.comment.view.c) this.f521193a.f547816b;
        if (r100 == null) goto L6;
        r100.b(this.f521194b, this.f521195c);
        return;
    }

    @Override // r34.g
    public final void onFail(Exception r100) {
        com.bytedance.awemeopen.apps.framework.comment.view.c r101 = (com.bytedance.awemeopen.apps.framework.comment.view.c) this.f521193a.f547816b;
        if (r101 == null) goto L6;
        r101.h(this.f521194b, this.f521195c);
        return;
    }

    public b(c r100, String r101, int r102) {
        this.f521193a = r100;
        this.f521194b = r101;
        this.f521195c = r102;
    }
}
