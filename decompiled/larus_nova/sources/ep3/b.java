package ep3;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c> f473431a;

    /* JADX WARN: Multi-variable type inference failed */
    public b(List<? extends c> r100) {
        Intrinsics.checkNotNullParameter(r100, "paramProviders");
        this.f473431a = r100;
    }

    @Override // ep3.c
    public final Object a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Iterator<c> r101 = this.f473431a.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next().a(r100);
        if (r102 == null) goto L4;
        return r102;
    L8:
        return null;
    }
}
