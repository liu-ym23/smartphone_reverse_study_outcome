package ue8;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<String, j> f549834a;

    public final List<j> a() {
        Iterator<Map.Entry<String, j>> r100 = this.f549834a.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        if (r100.next().getValue().f549827b.get() != null) goto L4;
        r100.remove();
        goto L4
    L9:
        return CollectionsKt.toList(this.f549834a.values());
    }

    public m() {
        this.f549834a = new LinkedHashMap();
    }
}
