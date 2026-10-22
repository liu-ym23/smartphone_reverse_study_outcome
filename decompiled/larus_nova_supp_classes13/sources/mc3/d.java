package mc3;

import com.bytedance.android.shopping.commentv3.data.MultiPicMode;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public final Map<String, Object> a;
    public final a b;
    public final e c;
    public final c d;
    public final b e;

    public d() {
        LinkedHashMap r0 = new LinkedHashMap();
        this.a = r0;
        this.b = new a(r0);
        this.c = new e(r0);
        this.d = new c(r0);
        this.e = new b(r0);
    }

    public final void a(MultiPicMode r2) {
        Intrinsics.checkNotNullParameter(r2, "mode");
        update(MapsKt.mapOf(TuplesKt.to("multi_pic_mode", Integer.valueOf(r2.getMode()))));
    }

    public final void update(Map<?, ?> r4) {
        Intrinsics.checkNotNullParameter(r4, "incomeData");
        Iterator<Map.Entry<?, ?>> r5 = r4.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L20;
        Map.Entry<?, ?> r0 = r5.next();
        Object r1 = r0.getKey();
        if ((r1 instanceof String) == true) goto L8;
        r1 = null;
    L8:
        String r2 = (String) r1;
        if (r2 != null) goto L11;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == true) goto L4;
        Map<String, Object> r6 = this.a;
        Object r7 = r0.getValue();
        if (r7 != null) goto L19;
        r7 = "";
    L19:
        r6.put(r2, r7);
        goto L4
    L11:
        if (r2.length() == 0) goto L14;
        r3 = false;
        goto L15
    }
}
