package pj9;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.bigimg.k1;
import java.util.List;

/* JADX INFO: loaded from: classes30.dex */
public final class b implements k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<com.larus.bmhome.bigimg.l> f529511a;

    public b(List<com.larus.bmhome.bigimg.l> r100) {
        this.f529511a = r100;
    }

    @Override // com.larus.bmhome.bigimg.k1
    public final com.larus.bmhome.bigimg.l a(int r100) {
        if (r100 >= 0) goto L4;
        return null;
    L4:
        if (r100 < this.f529511a.size()) goto L7;
        return null;
    L7:
        return (com.larus.bmhome.bigimg.l) ListProtector.get(this.f529511a, r100);
    }
}
