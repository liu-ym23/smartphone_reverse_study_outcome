package pf3;

import android.content.Context;
import com.bytedance.android.ec.hybrid.card.event.d;
import com.bytedance.android.ec.hybrid.card.event.e;
import com.bytedance.android.shopping.api.mall.common.tools.k;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Context> f528843a;

    public static final class a {
    }

    static {
    }

    public b(WeakReference<Context> r100) {
        this.f528843a = r100;
    }

    @Override // com.bytedance.android.ec.hybrid.card.event.e
    public final void a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "jsEvent");
        Map<String, Object> r101 = r100.f46490b;
        if (r101 == null) goto L5;
        Object r102 = r101.get("skuSchema");
    L7:
        if ((r102 instanceof String) == true) goto L9;
        r102 = null;
    L9:
        String r103 = (String) r102;
        if (r103 != null) goto L12;
        return;
    L12:
        WeakReference<Context> r104 = this.f528843a;
        if (r104 == null) goto L19;
        Context r105 = r104.get();
        if (r105 == null) goto L20;
        k.f170443b.d(r105, r103, null);
        return;
    L20:
        return;
    L19:
        return;
    L5:
        r102 = null;
        goto L7
    }
}
