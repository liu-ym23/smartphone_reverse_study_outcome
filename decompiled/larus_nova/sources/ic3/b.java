package ic3;

import com.bytedance.android.bst.api.g;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f489158a;

    public b(Map r100) {
        this.f489158a = r100;
    }

    @Override // com.bytedance.android.bst.api.g
    public final void a(String r100, Map<Object, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        Iterator r102 = ((LinkedHashMap) r101).entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry r103 = (Map.Entry) r102.next();
        this.f489158a.put(r103.getKey().toString(), String.valueOf(r103.getValue()));
        goto L4
    L6:
        new a(r100, this.f489158a).post(null, null);
    }
}
