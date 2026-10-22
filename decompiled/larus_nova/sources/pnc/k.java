package pnc;

import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public final class k implements com.suite.lark.component.navroute.api.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f530014a = null;

    static {
        f530014a = new k();
    }

    public k() {
    }

    @Override // com.suite.lark.component.navroute.api.d
    public final String getRoute() {
        return RootDescription.ROOT_ELEMENT;
    }

    @Override // com.suite.lark.component.navroute.api.d
    public final String getStart() {
        return "place_holder_activity";
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
