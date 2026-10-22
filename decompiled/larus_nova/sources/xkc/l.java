package xkc;

import com.ss.optimizer.live.sdk.dns.NativeConnect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes40.dex */
public final class l implements Callable<List<String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f564429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f564430b;

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public List<String> call2() throws Exception {
        ArrayList r100 = new ArrayList();
        NativeConnect r101 = new NativeConnect();
        Iterator<String> r102 = this.f564429a.iterator();
    L4:
        if (r102.hasNext() == false) goto L18;
        String r103 = r102.next();
        if (this.f564430b.isEmpty() == true) goto L9;
        if (this.f564430b.contains(r103) == true) goto L4;
    L9:
        int r104 = r101.connect(r103, "8080");
        if (r104 == (-1)) goto L12;
        if (r104 != 0) goto L4;
        r100.add(r103);
        if (h.f564418a == false) goto L4;
        h.a();
        goto L4
    L12:
        if (h.f564418a == false) goto L4;
        h.a();
        goto L4
    L18:
        return r100;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ List<String> call() throws Exception {
        return call2();
    }

    public l(List<String> r100, List<String> r101) {
        this.f564429a = r100;
        this.f564430b = r101;
    }
}
