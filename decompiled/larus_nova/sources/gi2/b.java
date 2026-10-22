package gi2;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import sg2.v;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements com.bytedance.android.shopping.ligo.monitor.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f481350a;

    @Override // com.bytedance.android.shopping.ligo.monitor.a
    public final String a() {
        return "good_list";
    }

    public b(a r100) {
        this.f481350a = r100;
    }

    @Override // com.bytedance.android.shopping.ligo.monitor.a
    public final void b(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        v r102 = new v(r100, this.f481350a);
        if (r101 == null) goto L8;
        Iterator<Map.Entry<String, String>> r103 = r101.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        Map.Entry<String, String> r104 = r103.next();
        r102.c(r104.getKey(), r104.getValue());
    L8:
        r102.i(null);
    }
}
