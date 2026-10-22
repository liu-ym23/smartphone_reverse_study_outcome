package w7b;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import v7b.x;

/* JADX INFO: loaded from: classes35.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<f> f558608a;

    public final String a() {
        StringBuilder r100 = new StringBuilder();
        int r101 = 0;
    L4:
        if (r101 >= ((ArrayList) this.f558608a).size()) goto L9;
        if (r101 == 0) goto L7;
        r100.append('\n');
    L7:
        r100.append(((f) ListProtector.get(this.f558608a, r101)).f558606a);
        r101 = r101 + 1;
        goto L4
    L9:
        return r100.toString();
    }

    public final List<x> b() {
        ArrayList r100 = new ArrayList();
        Iterator r101 = ((ArrayList) this.f558608a).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        x r102 = ((f) r101.next()).f558607b;
        if (r102 == null) goto L4;
        r100.add(r102);
        goto L4
    L8:
        return r100;
    }

    public g() {
        this.f558608a = new ArrayList();
    }
}
