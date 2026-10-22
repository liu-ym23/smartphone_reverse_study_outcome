package luc;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f510837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<? extends Annotation> f510838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f510839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<String> f510840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<f> f510841e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<List<Annotation>> f510842f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<Boolean> f510843g;

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "serialName");
        this.f510837a = r100;
        this.f510838b = CollectionsKt.emptyList();
        this.f510839c = new ArrayList();
        this.f510840d = new HashSet();
        this.f510841e = new ArrayList();
        this.f510842f = new ArrayList();
        this.f510843g = new ArrayList();
    }

    public static void a(a r100, String r101, f r102) {
        List r103 = CollectionsKt.emptyList();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "elementName");
        Intrinsics.checkNotNullParameter(r102, "descriptor");
        Intrinsics.checkNotNullParameter(r103, "annotations");
        if (((HashSet) r100.f510840d).add(r101) == false) goto L7;
        ((ArrayList) r100.f510839c).add(r101);
        ((ArrayList) r100.f510841e).add(r102);
        ((ArrayList) r100.f510842f).add(r103);
        ((ArrayList) r100.f510843g).add(false);
        return;
    L7:
        throw new IllegalArgumentException(("Element with name '" + r101 + "' is already registered in " + r100.f510837a).toString());
    }
}
