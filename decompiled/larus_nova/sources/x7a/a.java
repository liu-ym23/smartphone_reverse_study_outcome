package x7a;

import com.lynx.tasm.LynxView;

/* JADX INFO: loaded from: classes32.dex */
public final class a implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f562849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f562850b;

    @Override // x7a.j
    public final void onFailed() {
    }

    @Override // x7a.j
    public final void a(LynxView r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f562850b.f562857b.isEmpty() == true) goto L6;
        h r101 = this.f562850b.f562857b.peek();
        LynxView r102 = this.f562850b.f562859d.get(r101);
        d.a(this.f562850b, r102);
    L7:
        this.f562850b.f562857b.push(this.f562849a);
        f r103 = this.f562850b.b();
        if (r103 == null) goto L12;
        r103.a(r100);
        return;
    L12:
        return;
    L6:
        d r104 = this.f562850b;
        r104.getClass();
        d.a(r104, null);
        goto L7
    }

    public a(d r100, h r101, String r102) {
        this.f562850b = r100;
        this.f562849a = r101;
    }
}
