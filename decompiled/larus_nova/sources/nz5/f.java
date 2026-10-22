package nz5;

import com.bytedance.helios.api.config.AnchorInfoModel;
import com.bytedance.helios.api.consumer.AnchorExtra;
import com.bytedance.helios.api.consumer.PrivacyEvent;
import com.bytedance.helios.sdk.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends a {
    @Override // nz5.a
    public final String b() {
        return "floating_view";
    }

    @Override // nz5.a
    public final boolean e() {
        return false;
    }

    public f() {
    }

    @Override // nz5.a
    public final boolean c(AnchorInfoModel r100, Object r101) {
        String r102 = p.f245593n.f245597d;
        if (r100.j().contains(r102) == false) goto L5;
        return true;
    L5:
        if (r101 == null) goto L7;
        boolean r103 = r101 instanceof g;
    L8:
        if (r103 == false) goto L28;
        if (r101 == null) goto L39;
        Iterator<Map.Entry<String, m>> r104 = b.f521419a.entrySet().iterator();
    L12:
        if (r104.hasNext() == false) goto L40;
        Iterator<T> r105 = r104.next().getValue().b().iterator();
    L15:
        if (r105.hasNext() == false) goto L12;
        AnchorExtra r106 = ((PrivacyEvent) r105.next()).B;
        if (r106 == null) goto L15;
        Set<Object> r107 = r106.getFloatingViewEvents();
        if (r107 == null) goto L15;
        Iterator<T> r108 = r107.iterator();
        if (r108.hasNext() == false) goto L15;
        Object r109 = r108.next();
        if (r109 == null) goto L27;
        g r110 = (g) r109;
        g r111 = (g) r101;
        return true;
    L27:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.helios.sdk.anchor.FloatingViewEvent");
    L40:
        return false;
    L39:
        return false;
    L28:
        return false;
    L7:
        r103 = true;
        goto L8
    }

    public final String i(String r100, Object r101) {
        if (r101 == null) goto L4;
        boolean r102 = r101 instanceof g;
    L5:
        if (r102 == false) goto L9;
        if (r101 == null) goto L10;
        g r103 = (g) r101;
        return "key=" + r100 + ",viewId=0,hashCode=0";
    L10:
        return r100;
    L9:
        return r100;
    L4:
        r102 = true;
        goto L5
    }

    @Override // nz5.a
    public final void a(String r100, AnchorInfoModel r101, Object r102) {
        super.a(i(r100, r102), r101, r102);
    }

    @Override // nz5.a
    public final List<PrivacyEvent> d(List<PrivacyEvent> r100, AnchorInfoModel r101, Object r102) {
        if (r102 == null) goto L5;
        boolean r103 = r102 instanceof g;
    L6:
        if (r103 == false) goto L42;
        if (r102 == null) goto L42;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r100.iterator();
    L10:
        if (r105.hasNext() == false) goto L49;
        Object r106 = r105.next();
        PrivacyEvent r107 = (PrivacyEvent) r106;
        AnchorExtra r108 = r107.B;
        if (r108 == null) goto L14;
        Set<Object> r109 = r108.getFloatingViewEvents();
    L15:
        Set<Object> r110 = r109;
        boolean r111 = false;
        if (r110 != null) goto L18;
    L21:
        boolean r112 = true;
    L22:
        if (r112 == false) goto L39;
        AnchorExtra r113 = r107.B;
        if (r113 == null) goto L39;
        Set<Object> r114 = r113.getHistoryFloatingViewEvents();
        if (r114 == null) goto L39;
        Set<Object> r115 = r114;
        if ((r115 instanceof Collection) == true) goto L30;
    L32:
        Iterator<T> r116 = r115.iterator();
        if (r116.hasNext() == false) goto L39;
        Object r117 = r116.next();
        if (r117 == null) goto L38;
        g r118 = (g) r117;
        g r119 = (g) r102;
        r111 = true;
        goto L39
    L38:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.helios.sdk.anchor.FloatingViewEvent");
    L30:
        if (r115.isEmpty() == false) goto L32;
    L39:
        if (r111 == false) goto L10;
        r104.add(r106);
        goto L10
    L18:
        if (r110.isEmpty() == true) goto L21;
        r112 = false;
        goto L22
    L14:
        r109 = null;
        goto L15
    L49:
        return r104;
    L42:
        return CollectionsKt.emptyList();
    L5:
        r103 = true;
        goto L6
    }

    @Override // nz5.a
    public final void g(String r100, Object r101, String r102) {
        super.g(i(r100, r101), r101, r102);
    }
}
