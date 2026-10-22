package itc;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public final class d implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Object> f495769a;

    public final b a() {
        int r100 = 0;
        if (((ArrayList) this.f495769a).size() == 2) goto L5;
    L8:
        Object[] r101 = ((ArrayList) this.f495769a).toArray();
        Comparator<f<?>> r102 = b.f495766c;
    L10:
        if (r100 >= r101.length) goto L18;
        f r103 = (f) r101[r100];
        if (r103 == null) goto L16;
        if (r103.getKey().isEmpty() == false) goto L16;
        r101[r100] = null;
    L16:
        r100 = r100 + 2;
        goto L10
    L18:
        return new b(r101, b.f495766c);
    L5:
        if (ListProtector.get(this.f495769a, 0) == null) goto L8;
        return new b(((ArrayList) this.f495769a).toArray());
    }

    public d() {
        this.f495769a = new ArrayList();
    }

    public final d b(f r100, Object r101) {
        if (r100 != null) goto L4;
    L8:
        return this;
    L4:
        if (r100.getKey().isEmpty() == true) goto L8;
        if (r101 == null) goto L8;
        ((ArrayList) this.f495769a).add(r100);
        ((ArrayList) this.f495769a).add(r101);
        goto L8
    }
}
