package pha;

import com.obric.assistant.settings.config.CompressParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes33.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f529310a = null;

    static {
        f529310a = new b();
    }

    public b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(Map<String, List<CompressParam>> r100, List<CompressParam> r101) {
        if (r101 == null) goto L15;
        Iterator<T> r102 = r101.iterator();
    L5:
        if (r102.hasNext() == false) goto L21;
        CompressParam r103 = (CompressParam) r102.next();
        if (r103 == null) goto L5;
        String r104 = r103.getScene();
        if (r104 != null) goto L11;
        r104 = "";
    L11:
        Object r105 = ((LinkedHashMap) r100).get(r104);
        if (r105 != null) goto L14;
        r105 = new ArrayList();
        r100.put(r104, r105);
    L14:
        ((List) r105).add(r103);
        goto L5
    L21:
        return;
    }
}
