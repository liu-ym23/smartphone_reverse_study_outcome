package to;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f546882b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<e, List<mo.a>> f546883a;

    public static final class a {
        public static b a(Map r100) {
            if (r100 != null) goto L4;
        L7:
            boolean r101 = true;
        L8:
            if (r101 == false) goto L11;
            return null;
        L11:
            LinkedHashMap r102 = new LinkedHashMap();
            Iterator r103 = r100.entrySet().iterator();
        L13:
            if (r103.hasNext() == false) goto L16;
            Map.Entry r104 = (Map.Entry) r103.next();
            String r105 = (String) r104.getKey();
            List r106 = (List) r104.getValue();
            int r107 = e.f546890a;
            r102.put(e.b.a(r105), r106);
            goto L13
        L16:
            return new b(r102);
        L4:
            if (r100.isEmpty() == true) goto L7;
            r101 = false;
            goto L8
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Map<e, ? extends List<mo.a>> r100) {
        Intrinsics.checkNotNullParameter(r100, "events");
        this.f546883a = r100;
    }
}
