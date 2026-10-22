package be5;

import com.bytedance.ee.bear.list.sort.FilterType;
import java.util.ArrayList;
import java.util.List;
import zd5.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends zd5.a {
    @Override // zd5.f
    public final List<q> x7() {
        return null;
    }

    @Override // zd5.a, zd5.f
    public final List<FilterType> G6() {
        ArrayList r0 = new ArrayList();
        r0.add(FilterType.ALL);
        r0.add(FilterType.DOC);
        r0.add(FilterType.SHEET);
        return r0;
    }

    public a(boolean r1) {
        super(r1);
    }
}
