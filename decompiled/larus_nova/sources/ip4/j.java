package ip4;

import com.bytedance.ee.bear.fileselector.bean.FileBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public final class j implements ew4.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ za5.b f495284a;

    @Override // ew4.m
    public final void a() {
    }

    @Override // ew4.m
    public final void b() {
    }

    @Override // ew4.m
    public final void onCancel() {
        this.f495284a.b();
    }

    public j(za5.b r100) {
        this.f495284a = r100;
    }

    @Override // ew4.m
    public final void onSuccess(List<ew4.l> r110) {
        ArrayList r100 = new ArrayList(r110.size());
        Iterator<ew4.l> r111 = r110.iterator();
    L4:
        if (r111.hasNext() == false) goto L6;
        ew4.l r101 = r111.next();
        FileBean r112 = new FileBean(0, r101.f474574a, r101.f474575b, 0, r101.f474576c, r101.f474577d, r101.f474578e);
        r112.setCompressPath(r101.f474579f);
        r112.setOrigin(r101.f474580g);
        r100.add(r112);
        goto L4
    L6:
        this.f495284a.c(r100);
    }
}
