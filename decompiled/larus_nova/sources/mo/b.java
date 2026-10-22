package mo;

import android.view.View;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import so.d;
import to.e;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<no.a<? extends Object>> f514574a;

    public static final class a {
    }

    static {
    }

    public b() {
        this(CollectionsKt.emptyList());
    }

    public b(List<? extends no.a<? extends Object>> r100) {
        Intrinsics.checkNotNullParameter(r100, "extraHandlers");
        List<no.a<? extends Object>> r101 = CollectionsKt.mutableListOf(new no.a[]{no.b.f519881b, no.c.f519882b});
        this.f514574a = r101;
        r101.addAll(r100);
    }

    public static void b(d r100, to.b r101) {
        if (r101 == null) goto L14;
        Map<e, List<mo.a>> r102 = r101.f546883a;
        if (r102 == null) goto L20;
        if (r100 != null) goto L8;
        return;
    L8:
        Iterator<Map.Entry<e, List<mo.a>>> r103 = r102.entrySet().iterator();
    L10:
        if (r103.hasNext() == false) goto L21;
        View r104 = r100.a(r103.next().getKey());
        if (r104 == null) goto L10;
        r104.setOnClickListener(null);
        goto L10
    L21:
        return;
    L20:
        return;
    }

    public final void a(d r100, to.b r101) {
        Intrinsics.checkNotNullParameter(r100, "viewProvider");
        if (r101 == null) goto L27;
        Map<e, List<mo.a>> r102 = r101.f546883a;
        if (r102 == null) goto L35;
        Iterator<Map.Entry<e, List<mo.a>>> r103 = r102.entrySet().iterator();
    L9:
        if (r103.hasNext() == false) goto L36;
        Map.Entry<e, List<mo.a>> r104 = r103.next();
        e r105 = r104.getKey();
        List<mo.a> r106 = r104.getValue();
        List<mo.a> r107 = r106;
        if (r107 != null) goto L13;
    L16:
        boolean r108 = true;
    L17:
        if (r108 == true) goto L9;
        View r109 = r100.a(r105);
        if (r109 == null) goto L22;
    L25:
        if (r109 == null) goto L9;
        r109.setOnClickListener(new c(this, r106));
        goto L9
    L22:
        if (com.bytedance.android.ec.window.base.dynamicview.common.c.f49250a == true) goto L25;
        Objects.toString(r105);
        goto L25
    L13:
        if (r107.isEmpty() == true) goto L16;
        r108 = false;
        goto L17
    L36:
        return;
    L35:
        return;
    }
}
