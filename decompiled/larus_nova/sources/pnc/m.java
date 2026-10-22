package pnc;

import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public final class m implements com.suite.lark.component.navroute.api.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f530016a = null;

    static {
        f530016a = new m();
    }

    public m() {
    }

    @Override // com.suite.lark.component.navroute.api.d
    public final String getRoute() {
        return "vc_tab";
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
