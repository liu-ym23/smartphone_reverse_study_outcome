package p3;

import com.bytedance.ai.bridge.method.calendar.remote.Property;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes43.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Property.NodeInfo f527514a = null;

    public static final class a {
        public static List a(XmlPullParser r100) {
            Intrinsics.checkNotNullParameter(r100, "parser");
            LinkedHashSet r101 = new LinkedHashSet();
            int r102 = r100.getDepth();
            int r103 = r100.getEventType();
        L4:
            if (r103 != 3) goto L14;
            if (r100.getDepth() != r102) goto L14;
            ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
            Iterator r105 = r101.iterator();
        L10:
            if (r105.hasNext() == false) goto L12;
            r104.add(new i((Property.NodeInfo) r105.next()));
            goto L10
        L12:
            return r104;
        L14:
            if (r103 != 2) goto L18;
            if (r100.getDepth() != (r102 + 1)) goto L18;
            r101.add(new Property.NodeInfo(r100.getNamespace(), r100.getName()));
        L18:
            r103 = r100.next();
            goto L4
        }
    }

    static {
        f527514a = new Property.NodeInfo("DAV:", "error");
        new i(new Property.NodeInfo("DAV:", "need-privileges"));
        new i(new Property.NodeInfo("DAV:", "valid-sync-token"));
    }

    public i(Property.NodeInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
    }
}
