package ui2;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public final class c implements ui2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<List<?>> f550144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f550145b;

    public interface a {
        void d();
    }

    public final int b() {
        int r100 = 0;
        int r101 = 0;
    L4:
        if (r100 >= ((ArrayList) this.f550144a).size()) goto L11;
        List r102 = (List) ListProtector.get(this.f550144a, r100);
        a r103 = (a) ListProtector.get(this.f550145b, r100);
        if (r103 == null) goto L10;
        r103.d();
        if (r102 == null) goto L10;
        r101 = r101 + r102.size();
    L10:
        r100 = r100 + 1;
        goto L4
    L11:
        return r101;
    }

    public c() {
        this.f550144a = new ArrayList();
        this.f550145b = new ArrayList();
    }

    public final Object a(int r100) {
        int r101 = 0;
    L4:
        if (r101 >= ((ArrayList) this.f550144a).size()) goto L15;
        List r102 = (List) ListProtector.get(this.f550144a, r101);
        a r103 = (a) ListProtector.get(this.f550145b, r101);
        if (r103 == null) goto L14;
        r103.d();
        if (r102 == null) goto L14;
        if (r100 < r102.size()) goto L12;
        r100 = r100 - r102.size();
        goto L14
    L12:
        return ListProtector.get(r102, r100);
    L14:
        r101 = r101 + 1;
        goto L4
    L15:
        return null;
    }
}
