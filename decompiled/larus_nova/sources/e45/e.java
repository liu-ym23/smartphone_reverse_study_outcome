package e45;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes16.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<a> f470980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<a> f470981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<a> f470982c;

    public e() {
        this.f470980a = CollectionsKt.arrayListOf(new a[]{new d()});
        this.f470981b = new ArrayList();
        this.f470982c = CollectionsKt.arrayListOf(new a[]{new d()});
        new ArrayList();
    }

    public static void a(List r100) {
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((a) r101.next()).a();
        goto L4
    }
}
