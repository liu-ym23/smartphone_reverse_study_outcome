package zk1;

import com.larus.nova.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public final class k implements sp1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f572602a;

    @Override // sp1.a
    public final void onCancel() {
    }

    public k(h r100) {
        this.f572602a = r100;
    }

    @Override // sp1.a
    public final void a(tp1.a r100) {
        h r101 = this.f572602a;
        r101.getClass();
        r101.a(r100.f547000a);
        h.l(r101, r100);
    }

    @Override // sp1.a
    public final void b(tp1.a r100) {
        h r101 = this.f572602a;
        r101.getClass();
        r101.a(r100.f547000a);
        h.l(r101, r100);
    }

    @Override // sp1.a
    public final void c(tp1.a r100) {
        h r101 = this.f572602a;
        h.a r102 = r101.f572586g.get(r100.f547000a);
        if (r102 == null) goto L7;
        h.c r103 = r102.f572594b;
        if (r103 == null) goto L7;
        r103.f572599a = 0.0f;
    L7:
        h.l(r101, r100);
        h.a r104 = r101.f572586g.get(r100.f547000a);
        if (r104 == null) goto L15;
        ArrayList r105 = (ArrayList) r104.f572597e;
        if (r105.isEmpty() == false) goto L13;
        r105.add(1);
    L13:
        r104.f572598f++;
        return;
    }

    @Override // sp1.a
    public final void d(tp1.a r100) {
        h r101 = this.f572602a;
        r101.getClass();
        r101.a(r100.f547000a);
        h.l(r101, r100);
    }

    @Override // sp1.a
    public final void e(tp1.a r100, int r101) {
        h r102 = this.f572602a;
        r102.getClass();
        int r103 = xk1.c.f564136a;
        if (r101 != 32) goto L5;
        String r104 = rm3.c.f538539a;
        rm3.c.f(r102.f572583d, R.string.ttlive_vs_cache_no_space_error_tips, false, 28);
    L6:
        r102.a(r100.f547000a);
        h.l(r102, r100);
        return;
    L5:
        String r105 = rm3.c.f538539a;
        rm3.c.f(r102.f572583d, R.string.ttlive_vs_cache_error_tips, false, 28);
        goto L6
    }
}
