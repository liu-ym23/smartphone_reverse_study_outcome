package dd5;

import com.bytedance.ee.bear.list.dto.Document;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes18.dex */
public final class t1 implements Function<Set<String>, Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Document> f468006a;

    public t1(List<Document> r100) {
        this.f468006a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Boolean apply(Set<String> r100) throws Exception {
        Set<String> r101 = r100;
        boolean r102 = false;
        if (hu5.a.d(this.f468006a) == true) goto L26;
        Iterator<Document> r103 = this.f468006a.iterator();
        boolean r104 = false;
    L6:
        if (r103.hasNext() == false) goto L24;
        Document r105 = r103.next();
        if (r105.getType() == sbb.e.f541303n.f541317b) goto L9;
        if (r101.contains(r105.f227873d) == false) goto L6;
        r105.f227903w = true;
    L23:
        r104 = true;
        goto L6
    L9:
        int r106 = r105.f227908y1;
        if (r106 != sbb.e.f541298i.f541317b) goto L12;
    L18:
        boolean r107 = false;
    L19:
        r105.f227906x2 = r107;
        goto L23
    L12:
        if (r106 == sbb.e.f541302m.f541317b) goto L18;
        if (r101.contains(r105.f227873d) == false) goto L18;
        if (r101.contains(r105.G1) == false) goto L18;
        r107 = true;
        goto L19
    L24:
        r102 = r104;
    L26:
        return Boolean.valueOf(r102);
    }
}
