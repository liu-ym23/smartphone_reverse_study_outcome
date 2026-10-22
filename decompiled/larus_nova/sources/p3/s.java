package p3;

import com.bytedance.ai.bridge.method.calendar.remote.Property;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes43.dex */
public final class s implements com.bytedance.ai.bridge.method.calendar.remote.e {
    public s() {
    }

    @Override // com.bytedance.ai.bridge.method.calendar.remote.e
    public final Property.NodeInfo getNode() {
        return t.f527523c;
    }

    @Override // com.bytedance.ai.bridge.method.calendar.remote.e
    public final Property a(XmlPullParser r100) {
        Intrinsics.checkNotNullParameter(r100, "parser");
        t r101 = new t();
        int r102 = r100.getDepth();
        int r103 = r100.getEventType();
    L4:
        if (r103 != 3) goto L11;
        if (r100.getDepth() != r102) goto L11;
        r100.getDepth();
        return r101;
    L11:
        if (r103 != 2) goto L30;
        if (r100.getDepth() != (r102 + 1)) goto L30;
        Property.NodeInfo r104 = new Property.NodeInfo(r100.getNamespace(), r100.getName());
        Property.NodeInfo r105 = t.f527524d;
        if (Intrinsics.areEqual(r104, r105) == false) goto L17;
    L16:
        r104 = r105;
    L29:
        r101.f527529b.add(r104);
        goto L30
    L17:
        r105 = t.f527525e;
        if (Intrinsics.areEqual(r104, r105) == true) goto L16;
        r105 = t.f527526f;
        if (Intrinsics.areEqual(r104, r105) == true) goto L16;
        r105 = t.f527527g;
        if (Intrinsics.areEqual(r104, r105) == true) goto L16;
        r105 = t.f527528h;
        if (Intrinsics.areEqual(r104, r105) == false) goto L29;
    L30:
        r103 = r100.next();
        goto L4
    }
}
