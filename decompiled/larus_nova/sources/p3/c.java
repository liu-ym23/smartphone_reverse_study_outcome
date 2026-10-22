package p3;

import com.bytedance.ai.bridge.method.calendar.remote.Property;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes43.dex */
public final class c extends p.a {
    public c() {
    }

    @Override // com.bytedance.ai.bridge.method.calendar.remote.e
    public final Property.NodeInfo getNode() {
        return d.f527509c;
    }

    @Override // com.bytedance.ai.bridge.method.calendar.remote.e
    public final Property a(XmlPullParser r100) {
        Intrinsics.checkNotNullParameter(r100, "parser");
        d r101 = new d();
        p.a.b(r100, r101);
        return r101;
    }
}
