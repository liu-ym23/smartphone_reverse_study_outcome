package e45;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes16.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<b> f470983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<b> f470984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<b> f470985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<b> f470986d;

    public f() {
        this.f470983a = CollectionsKt.arrayListOf(new b[]{new c()});
        this.f470984b = new ArrayList();
        this.f470985c = CollectionsKt.arrayListOf(new b[]{new c()});
        this.f470986d = new ArrayList();
    }

    public static void a(List r100) {
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        b r102 = (b) r101.next();
        if (r102.a() == false) goto L4;
        if (r102.c() == false) goto L4;
        r102.b();
        goto L4
    }

    public static boolean b(List r100) {
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (((b) r101.next()).a() == false) goto L4;
        return true;
    L9:
        return false;
    }
}
