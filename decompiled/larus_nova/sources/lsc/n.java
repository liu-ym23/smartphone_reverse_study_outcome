package lsc;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class n extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m.b f510610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f510611b;

    @Override // lsc.o
    public final p a() {
        m.b r100 = this.f510610a;
        h r101 = this.f510611b;
        u r102 = new u();
        p.a r103 = (p.a) r100;
        m.a r104 = r103.f510618b;
        if (r104 != null) goto L5;
        r104 = new b();
    L5:
        y r105 = new y("");
        Map r106 = Collections.unmodifiableMap(r103.f510617a);
        return new p(r101, r102, r105, r106, r104);
    }

    public n(p.a r100, h r101) {
        this.f510610a = r100;
        this.f510611b = r101;
    }
}
