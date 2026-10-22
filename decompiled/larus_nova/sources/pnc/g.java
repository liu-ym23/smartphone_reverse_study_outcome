package pnc;

import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public final class g implements com.suite.lark.component.navroute.api.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f530010a = null;

    static {
        f530010a = new g();
    }

    public g() {
    }

    @Override // com.suite.lark.component.navroute.api.d
    public final String getRoute() {
        return "login";
    }

    @Override // com.suite.lark.component.navroute.api.d
    public final String getStart() {
        return "place_holder_fragment";
    }

    @Override // com.suite.lark.component.navroute.api.d
    public final List<com.suite.lark.component.navroute.api.b<?>> b() {
        return com.suite.lark.component.navroute.api.d.a.b(this);
    }

    @Override // com.suite.lark.component.navroute.api.d
    public final com.suite.lark.component.navroute.api.b<?> a(String r100) {
        return com.suite.lark.component.navroute.api.d.a.a(this, r100);
    }
}
