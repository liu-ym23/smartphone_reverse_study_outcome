package dxb;

import java.util.Map;

/* JADX INFO: loaded from: classes37.dex */
public final class g extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final cxb.a f470472b;

    @Override // dxb.a
    public final Map<String, Object> c() {
        cxb.a r100 = this.f470472b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getCommonParams();
    }

    public g(String r100, ntb.o.b r101, cxb.a r102) {
        super(r100, r101);
        this.f470472b = r102;
    }
}
