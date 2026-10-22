package x7a;

import com.lynx.tasm.LynxView;

/* JADX INFO: loaded from: classes32.dex */
public final class b implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f562851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f562852b;

    @Override // x7a.j
    public final void onFailed() {
    }

    @Override // x7a.j
    public final void a(LynxView r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f562852b.f562857b.isEmpty() == true) goto L6;
        h r101 = this.f562852b.f562857b.pop();
        LynxView r102 = this.f562852b.f562859d.remove(r101);
        this.f562852b.c(r102);
    L7:
        this.f562852b.f562857b.push(this.f562851a);
        f r103 = this.f562852b.b();
        if (r103 == null) goto L12;
        r103.a(r100);
        return;
    L12:
        return;
    L6:
        this.f562852b.getClass();
        goto L7
    }

    public b(d r100, h r101, String r102) {
        this.f562852b = r100;
        this.f562851a = r101;
    }
}
