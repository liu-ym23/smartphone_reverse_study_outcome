package dc8;

import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.larus.bmhome.chat.adapter.t;
import com.larus.bmhome.chat.list.cell.text.BaseCompositeTextCell;
import dc8.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a<Component, ComponentContext extends b<Component>> implements c<Component, ComponentContext> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<ComponentContext> f467885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, ComponentContext> f467886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, C5655a> f467887c;

    /* JADX INFO: renamed from: dc8.a$a, reason: collision with other inner class name */
    public static final class C5655a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f467888a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f467889b;

        public C5655a() {
            boolean r100 = false;
            this(r100, 3);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5655a) == true) goto L8;
            return false;
        L8:
            C5655a r101 = (C5655a) r100;
            if (this.f467888a == r101.f467888a) goto L12;
            return false;
        L12:
            if (this.f467889b == r101.f467889b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f467888a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f467889b == true) goto L11;
            r100 = 1237;
        L11:
            return r102 + r100;
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "StatusInfo(bound=" + this.f467888a + ", attached=" + this.f467889b + ')';
        }

        public /* synthetic */ C5655a(boolean r100, int r101) {
            if ((r101 & 1) == 0) goto L5;
            r100 = false;
        L5:
            this(r100, false);
        }

        public C5655a(boolean r100, boolean r101) {
            this.f467888a = r100;
            this.f467889b = r101;
        }
    }

    public a(t r100) {
        Intrinsics.checkNotNullParameter(r100, "componentContextFactory");
        this.f467885a = r100;
        this.f467886b = new LinkedHashMap();
        this.f467887c = new LinkedHashMap();
    }

    @Override // dc8.c
    public final ComponentContext X0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        ComponentContext r101 = (ComponentContext) ((LinkedHashMap) this.f467886b).get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return (ComponentContext) a(r100);
    }

    public final ComponentContext a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        ComponentContext r101 = (ComponentContext) ((LinkedHashMap) this.f467886b).get(r100);
        if (r101 != null) goto L6;
        ComponentContext r102 = this.f467885a.invoke();
        this.f467886b.put(r100, r102);
        return r102;
    L6:
        return r101;
    }

    @Override // dc8.c
    public final void N1(String r100, BaseCompositeTextCell<? extends xc8.b> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        b r102 = (b) ((LinkedHashMap) this.f467886b).get(r100);
        if (r102 == null) goto L7;
        r102.s(r101);
        if (r102.isEmpty() == false) goto L7;
        this.f467886b.remove(r100);
    L7:
        C5655a r103 = (C5655a) ((LinkedHashMap) this.f467887c).get(r100);
        C5655a r104 = (C5655a) ((LinkedHashMap) this.f467887c).get(r100);
        if (r104 == null) goto L11;
        r104.f467888a = false;
        return;
    }

    @Override // dc8.c
    public final void S(String r100, BaseCompositeTextCell<? extends xc8.b> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        C5655a r102 = (C5655a) ((LinkedHashMap) this.f467887c).get(r100);
        C5655a r103 = (C5655a) ((LinkedHashMap) this.f467887c).get(r100);
        if (r103 == null) goto L6;
        r103.f467889b = false;
        return;
    }

    @Override // dc8.c
    public final void u1(String r100, BaseCompositeTextCell<? extends xc8.b> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        C5655a r102 = (C5655a) ((LinkedHashMap) this.f467887c).get(r100);
        C5655a r103 = (C5655a) ((LinkedHashMap) this.f467887c).get(r100);
        if (r103 == null) goto L6;
        r103.f467889b = true;
        return;
    }

    @Override // dc8.c
    public final ComponentContext I1(String r100, BaseCompositeTextCell<? extends xc8.b> r101, xc8.b r102, List<? extends Component> r110) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r102, "state");
        Intrinsics.checkNotNullParameter(r110, "components");
        ArrayList r103 = new ArrayList();
        Map<String, ComponentContext> r104 = this.f467886b;
        LinkedHashMap r105 = new LinkedHashMap();
        Iterator r106 = ((LinkedHashMap) r104).entrySet().iterator();
    L3:
        boolean r107 = true;
        if (r106.hasNext() == false) goto L13;
        Map.Entry r108 = (Map.Entry) r106.next();
        if (Intrinsics.areEqual(r108.getKey(), r100) == false) goto L8;
    L10:
        r107 = false;
    L11:
        if (r107 == false) goto L3;
        r105.put(r108.getKey(), r108.getValue());
        goto L3
    L8:
        if (((b) r108.getValue()).t(r101) == false) goto L10;
    L13:
        Iterator r109 = r105.entrySet().iterator();
    L15:
        if (r109.hasNext() == false) goto L19;
        Map.Entry r111 = (Map.Entry) r109.next();
        ((b) r111.getValue()).s(r101);
        if (((b) r111.getValue()).isEmpty() == false) goto L15;
        r103.add(r111.getKey());
        goto L15
    L19:
        Iterator r112 = r103.iterator();
    L21:
        if (r112.hasNext() == false) goto L23;
        String r113 = (String) r112.next();
        this.f467886b.remove(r113);
        goto L21
    L23:
        ComponentContext r114 = (ComponentContext) a(r100);
        r114.r(r101, r102, r110);
        C5655a r115 = (C5655a) ((LinkedHashMap) this.f467887c).get(r100);
        Map<String, C5655a> r116 = this.f467887c;
        C5655a r117 = (C5655a) ((LinkedHashMap) r116).get(r100);
        if (r117 == null) goto L26;
        C5655a r118 = new C5655a(true, r117.f467889b);
    L27:
        r116.put(r100, r118);
        return r114;
    L26:
        r118 = new C5655a(r107, 2);
        goto L27
    }
}
