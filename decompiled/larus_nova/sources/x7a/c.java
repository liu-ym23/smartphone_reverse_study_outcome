package x7a;

import com.lynx.tasm.LynxView;

/* JADX INFO: loaded from: classes32.dex */
public final class c implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f562853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f562854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d f562855c;

    @Override // x7a.j
    public final void onFailed() {
        this.f562854b.onFailed();
    }

    @Override // x7a.j
    public final void a(LynxView r100) {
        if (r100 == null) goto L5;
        this.f562855c.f562859d.put(this.f562853a, r100);
        this.f562854b.a(r100);
        return;
    }

    public c(d r100, h r101, j r102) {
        this.f562855c = r100;
        this.f562853a = r101;
        this.f562854b = r102;
    }
}
