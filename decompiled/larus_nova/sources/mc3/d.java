package mc3;

import com.bytedance.android.shopping.commentv3.data.MultiPicMode;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f512874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f512875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f512876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f512877d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f512878e;

    public d() {
        LinkedHashMap r100 = new LinkedHashMap();
        this.f512874a = r100;
        this.f512875b = new a(r100);
        this.f512876c = new e(r100);
        this.f512877d = new c(r100);
        this.f512878e = new b(r100);
    }

    public final void a(MultiPicMode r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        update(MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MULTI_PIC_MODE, Integer.valueOf(r100.getMode()))));
    }

    public final void update(Map<?, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "incomeData");
        Iterator<Map.Entry<?, ?>> r101 = r100.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L20;
        Map.Entry<?, ?> r102 = r101.next();
        Object r103 = r102.getKey();
        if ((r103 instanceof String) == true) goto L8;
        r103 = null;
    L8:
        String r104 = (String) r103;
        if (r104 != null) goto L11;
    L14:
        boolean r105 = true;
    L15:
        if (r105 == true) goto L4;
        Map<String, Object> r106 = this.f512874a;
        Object r107 = r102.getValue();
        if (r107 != null) goto L19;
        r107 = "";
    L19:
        r106.put(r104, r107);
        goto L4
    L11:
        if (r104.length() == 0) goto L14;
        r105 = false;
        goto L15
    }
}
