package qf9;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<d> f532747a;

    /* JADX WARN: Multi-variable type inference failed */
    public a(List<? extends d> r100) {
        Intrinsics.checkNotNullParameter(r100, "runtimes");
        this.f532747a = r100;
    }

    @Override // qf9.d
    public final int a(com.larus.im.service.d r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Iterator<T> r101 = this.f532747a.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        int r102 = ((d) r101.next()).a(r100);
        if (r102 != 0) goto L4;
        return r102;
    L8:
        return -1;
    }

    @Override // qf9.d
    public final void b(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "rtcAppIds");
        Iterator<T> r101 = this.f532747a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((d) r101.next()).b(r100);
        goto L4
    }

    @Override // qf9.d
    public final void c(cf9.a r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Iterator<T> r101 = this.f532747a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((d) r101.next()).c(r100);
        goto L4
    }

    @Override // qf9.d
    public final int d(com.larus.im.service.d r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Iterator<T> r101 = this.f532747a.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        int r102 = ((d) r101.next()).d(r100);
        if (r102 != 0) goto L4;
        return r102;
    L8:
        return -1;
    }
}
