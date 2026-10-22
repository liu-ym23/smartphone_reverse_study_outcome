package pnc;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public final class a implements com.suite.lark.component.navroute.api.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f530004a = null;

    static {
        f530004a = new a();
    }

    public a() {
    }

    @Override // com.suite.lark.component.navroute.api.d
    public final String getRoute() {
        return DocumentType.BITABLE_NAME;
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
