package p3;

import com.bytedance.ai.bridge.method.calendar.remote.Property;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes43.dex */
public final class w implements com.bytedance.ai.bridge.method.calendar.remote.e {
    public w() {
    }

    @Override // com.bytedance.ai.bridge.method.calendar.remote.e
    public final Property.NodeInfo getNode() {
        return x.f527532c;
    }

    @Override // com.bytedance.ai.bridge.method.calendar.remote.e
    public final Property a(XmlPullParser r100) {
        Intrinsics.checkNotNullParameter(r100, "parser");
        XmlPullParserFactory r101 = q3.e.f531483a;
        return new x(q3.e.d(r100));
    }
}
