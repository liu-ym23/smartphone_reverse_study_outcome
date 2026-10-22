package o33;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import u33.a;
import w33.g;

/* JADX INFO: loaded from: classes12.dex */
public final class a<STATE extends g, PROPS extends u33.a> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f521868c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f521869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f43.b f521870b;

    /* JADX INFO: renamed from: o33.a$a, reason: collision with other inner class name */
    public static final class C7005a {
    }

    static {
    }

    public a(s33.a<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "bizModule");
        ArrayList r101 = new ArrayList();
        this.f521869a = r101;
        this.f521870b = new f43.b();
        List<s33.b<STATE, PROPS>> r102 = r100.f540456b;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        Object r105 = r104.next();
        if ((r105 instanceof b) == false) goto L4;
        r103.add(r105);
        goto L4
    L8:
        r101.addAll(r103);
    }
}
