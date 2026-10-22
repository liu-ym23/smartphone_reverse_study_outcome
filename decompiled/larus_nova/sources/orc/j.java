package orc;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes41.dex */
public final class j extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f525001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, i> f525002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Pair<List<String>, i>> f525003c;

    public j() {
        this.f525001a = null;
        this.f525002b = new LinkedHashMap();
        this.f525003c = new ArrayList();
    }

    public static final i a(j r100, String r101, KClass r102) {
        j r103 = r100.f525001a;
        if (r103 != null) goto L5;
        r103 = r100;
    L5:
        i r104 = (i) ((LinkedHashMap) r103.f525002b).get(r101);
        if (r104 != null) goto L39;
        List r105 = StringsKt.split$default(r101, new String[]{HTTP.URL_DEFAULT}, false, 0, 6, null);
        ArrayList r106 = new ArrayList();
        Iterator r107 = r105.iterator();
    L10:
        if (r107.hasNext() == false) goto L17;
        Object r108 = r107.next();
        if (((String) r108).length() <= 0) goto L14;
        boolean r109 = true;
    L15:
        if (r109 == false) goto L10;
        r106.add(r108);
        goto L10
    L14:
        r109 = false;
        goto L15
    L17:
        Iterator r110 = ((ArrayList) r100.f525003c).iterator();
    L19:
        if (r110.hasNext() == false) goto L25;
        Pair r111 = (Pair) r110.next();
        List r112 = (List) r111.component1();
        i r113 = (i) r111.component2();
        if (n.a(r106, r112) == false) goto L19;
        if (r102.isInstance(r113) == false) goto L19;
        return r113;
    L25:
        return null;
    L39:
        return r104;
    }
}
