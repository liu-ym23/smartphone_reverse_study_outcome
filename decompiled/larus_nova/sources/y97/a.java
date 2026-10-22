package y97;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.ruler.d;
import com.bytedance.ruler.utils.g;
import com.bytedance.ruler.utils.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, List<Long>> f566985a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f566986b = null;

    static {
        f566985a = new ConcurrentHashMap();
        g r100 = d.f267686j;
        if (r100 == null) goto L5;
        fh7.d r101 = r100.b("freq_records_v416");
    L6:
        f566986b = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    public static List a(String r100) {
        List r101 = (List) ((ConcurrentHashMap) f566985a).get(r100);
        if (r101 != null) goto L24;
        com.bytedance.ruler.a r102 = d.f267678b;
        if (r102 == null) goto L7;
        boolean r103 = r102.f267625k;
    L8:
        if (r103 == false) goto L25;
        h r104 = f566986b;
        if (r104 == null) goto L12;
        String r105 = r104.get(r100);
    L13:
        String r106 = r105;
        if (r106 != null) goto L16;
        return r101;
    L16:
        if (r106.equals("") == true) goto L27;
        List r107 = StringsKt.split$default(r106, new String[]{","}, false, 0, 6, null);
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator r109 = r107.iterator();
    L19:
        if (r109.hasNext() == false) goto L22;
        r108.add(Long.valueOf(CastLongProtector.parseLong((String) r109.next())));
        goto L19
    L22:
        return CollectionsKt.toMutableList(r108);
    L27:
        return r101;
    L12:
        r105 = null;
        goto L13
    L25:
        return r101;
    L7:
        r103 = true;
        goto L8
    L24:
        return r101;
    }
}
