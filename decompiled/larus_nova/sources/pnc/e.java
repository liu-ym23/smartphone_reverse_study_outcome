package pnc;

import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public final class e implements com.suite.lark.component.navroute.api.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f530008a = null;

    static {
        f530008a = new e();
    }

    public e() {
    }

    @Override // com.suite.lark.component.navroute.api.d
    public final String getRoute() {
        return "forseti_bridge";
    }

    @Override // com.suite.lark.component.navroute.api.d
    public final String getStart() {
        return "place_holder_fragment_bridge";
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
