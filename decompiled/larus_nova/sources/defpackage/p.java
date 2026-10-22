package defpackage;

import com.bytedance.livesdk.ktvcommon.download.d;
import com.bytedance.livesdk.ktvcommon.download.model.b;
import com.bytedance.livesdk.ktvcommon.download.model.e;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import yk6.g;

/* JADX INFO: loaded from: classes42.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, b> f527242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f527243b;

    public p(d r100) {
        Intrinsics.checkNotNullParameter(r100, "taskManager");
        this.f527243b = r100;
        this.f527242a = new LinkedHashMap();
    }

    public final b a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "batchId");
        return (b) ((LinkedHashMap) this.f527242a).get(r100);
    }

    public final List<String> b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "batchId");
        d r101 = this.f527243b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "batchId");
        Map<String, e> r102 = r101.f255935a;
        LinkedHashMap r103 = new LinkedHashMap();
        Iterator r104 = ((LinkedHashMap) r102).entrySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L9;
        Map.Entry r105 = (Map.Entry) r104.next();
        if (((e) r105.getValue()).f255971i.contains(r100) == false) goto L4;
        r103.put(r105.getKey(), r105.getValue());
        goto L4
    L9:
        return CollectionsKt.toList(r103.keySet());
    }

    public final boolean c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "batchId");
        b r101 = a(r100);
        boolean r102 = true;
        if (r101 != null) goto L5;
        return true;
    L5:
        int r103 = r101.f255948e.size();
        int r104 = r101.f255950g.size() + r101.f255951h.size();
        if (r104 >= r103) goto L9;
        r102 = false;
    L9:
        if (r102 == false) goto L11;
        int r105 = g.f568232a;
        g.a("KTV-Download-Batch", "isBatchCompleted: batchId=" + r100 + ", total=" + r103 + ", completed=" + r104);
    L11:
        return r102;
    }
}
