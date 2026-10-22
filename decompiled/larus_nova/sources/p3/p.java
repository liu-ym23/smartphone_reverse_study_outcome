package p3;

import com.bytedance.ai.bridge.method.calendar.remote.Property;
import java.util.LinkedList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes43.dex */
public abstract class p implements Property {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedList<String> f527521b;

    public static abstract class a implements com.bytedance.ai.bridge.method.calendar.remote.e {
        public a() {
        }

        public static void b(XmlPullParser r100, p r101) {
            Intrinsics.checkNotNullParameter(r100, "parser");
            Intrinsics.checkNotNullParameter(r101, "list");
            XmlPullParserFactory r102 = q3.e.f531483a;
            Property.NodeInfo r103 = com.bytedance.ai.bridge.method.calendar.remote.b.f35401g;
            LinkedList<String> r104 = r101.f527521b;
            Intrinsics.checkNotNullParameter(r100, "parser");
            Intrinsics.checkNotNullParameter(r103, "node");
            Intrinsics.checkNotNullParameter(r104, "list");
            int r105 = r100.getDepth();
            int r106 = r100.getEventType();
        L4:
            if (r106 == 3) goto L8;
            if (r106 == 1) goto L8;
        L10:
            if (r106 != 2) goto L16;
            if (r100.getDepth() != (r105 + 1)) goto L16;
            if (Intrinsics.areEqual(q3.e.c(r100), r103) == false) goto L16;
            r104.add(r100.nextText());
        L16:
            r106 = r100.next();
        L8:
            if (r100.getDepth() != r105) goto L10;
        }
    }

    public final String toString() {
        return "href=[" + CollectionsKt.joinToString$default(this.f527521b, ", ", null, null, 0, null, null, 62, null) + ']';
    }

    public p() {
        this.f527521b = new LinkedList();
    }
}
