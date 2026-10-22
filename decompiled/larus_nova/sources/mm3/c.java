package mm3;

import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements d.InterfaceC6831d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f514430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f514431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f514432c;

    @Override // mm3.d.InterfaceC6831d
    public final void a(int r100) {
        b r101 = this.f514430a;
        nm3.a r102 = r101.f514422b.f514418d;
        if (r102 == null) goto L6;
        r102.a(b.b(r101));
        return;
    }

    public c(int r100, b r101, List r102) {
        this.f514430a = r101;
        this.f514431b = r102;
        this.f514432c = null;
    }
}
