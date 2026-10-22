package q3;

import com.bytedance.ai.bridge.method.calendar.remote.Property;
import java.io.IOException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final XmlPullParserFactory f531483a = null;

    public e() {
    }

    static {
        XmlPullParserFactory r100 = XmlPullParserFactory.newInstance();     // Catch: XmlPullParserException -> L5
        f531483a = r100;     // Catch: XmlPullParserException -> L5
        r100.setNamespaceAware(true);     // Catch: XmlPullParserException -> L5
        return;
    L5:
        e = move-exception;
        throw new RuntimeException("Couldn't create XmlPullParserFactory", e);
    }

    public static Property.NodeInfo c(XmlPullParser r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = r100.getNamespace();
        String r102 = r100.getName();
        if (r101 == null) goto L8;
        if (r102 == null) goto L8;
        return new Property.NodeInfo(r101, r102);
    L8:
        throw new IllegalStateException("invalid node");
    }

    public static String d(XmlPullParser r100) throws IOException, XmlPullParserException {
        Intrinsics.checkNotNullParameter(r100, "parser");
        int r101 = r100.getDepth();
        int r102 = r100.getEventType();
        String r103 = null;
    L4:
        if (r102 != 3) goto L10;
        if (r100.getDepth() != r101) goto L10;
        return r103;
    L10:
        if (r102 != 4) goto L14;
        if (r100.getDepth() != r101) goto L14;
        r103 = r100.getText();
    L14:
        r102 = r100.next();
        goto L4
    }

    public static /* synthetic */ void b(XmlSerializer r100, Property.NodeInfo r101) {
        a(r100, r101, new d());
    }

    public static void a(XmlSerializer r100, Property.NodeInfo r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "node");
        Intrinsics.checkNotNullParameter(r102, "contentGenerator");
        r100.startTag(r101.getNamespace(), r101.getName());
        r102.invoke(r100);
        r100.endTag(r101.getNamespace(), r101.getName());
    }
}
