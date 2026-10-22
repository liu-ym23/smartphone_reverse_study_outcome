package yy5;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends dz5.a<Void> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f569476b;

    @Override // dz5.a
    public final int b() {
        return 5;
    }

    @Override // dz5.a
    public final void a() {
        Iterator r100 = this.f569476b.keySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        c.e((String) r100.next());
        goto L4
    }

    public a(Map r100) {
        this.f569476b = r100;
    }
}
