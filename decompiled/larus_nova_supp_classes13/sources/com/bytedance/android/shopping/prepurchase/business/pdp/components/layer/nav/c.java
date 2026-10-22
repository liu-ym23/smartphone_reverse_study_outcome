package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav;

import com.bytedance.android.ec.core.utils.p0;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.p;
import com.bytedance.android.shopping.anchorv4.bottom.AddCartMeta;
import com.bytedance.android.shopping.anchorv4.bottom.BottomButtonMeta;
import com.bytedance.android.shopping.anchorv4.bottom.BottomButtonVO;
import com.bytedance.android.shopping.anchorv4.bottomnav.BottomNavVO;
import com.bytedance.android.shopping.anchorv4.helper.z;
import com.bytedance.android.shopping.prepurchase.arch.container.component.ViewModel;
import com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.LynxAbilityImpl;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import vg3.e0;
import vg3.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends ViewModel<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> {
    public f e;
    public Function1<? super SlcCommonAction, Unit> f;
    public Function1<? super a, Unit> g;
    public Function2<? super String, ? super Map<String, ? extends Object>, Unit> h;
    public BottomButtonVO i;
    public final IdentityHashMap<com.bytedance.android.ecom.arch.slice.g, com.bytedance.android.ecom.arch.slice.h> j;
    public boolean k;
    public final Map<String, Object> l;

    public static final class a {
        public final Map<String, Object> a;
        public final List<com.bytedance.android.ecom.arch.slice.g> b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            Map<String, Object> r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            List<com.bytedance.android.ecom.arch.slice.g> r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Param(extraParam=" + this.a + ", data=" + this.b + ")";
        }

        public a(Map<String, Object> r2, List<? extends com.bytedance.android.ecom.arch.slice.g> r3) {
            Intrinsics.checkNotNullParameter(r2, "extraParam");
            Intrinsics.checkNotNullParameter(r3, "data");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r2) {
            BottomButtonVO r3 = (BottomButtonVO) r2;
            if (r3 == null) goto L7;
            this.a.i = r3;
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.c$c, reason: collision with other inner class name */
    public static final class C0159c<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ c a;

        public C0159c(c r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r6) {
            BottomNavVO r7 = (BottomNavVO) r6;
            if (r7 == null) goto L26;
            c r0 = this.a;
            r0.getClass();
            y r1 = (y) ViewModel.a(r0, y.class);
            if (r1 == null) goto L8;
            com.bytedance.android.shopping.anchorv4.perf.monitor.c r2 = r1.V();
        L9:
            if (r2 == null) goto L11;
            r2.c();
        L11:
            this.a.getClass();
            this.a.l.put("cart_num", null);
            final List r8 = r7.getSlices();
            if (r8 == null) goto L21;
            c r3 = this.a;
            Function1<? super a, Unit> r4 = r3.g;
            if (r4 == null) goto L16;
            Unit r5 = (Unit) r4.invoke(new a(r3.l, r8));
        L16:
            c r9 = this.a;
            r9.h();
            Iterator<T> r10 = r8.iterator();
        L18:
            if (r10.hasNext() == false) goto L20;
            com.bytedance.android.ecom.arch.slice.g r11 = (com.bytedance.android.ecom.arch.slice.g) r10.next();
            r9.k(r11, r11.getSliceId());
            goto L18
        L20:
            r9.getContext().e().r().p("bottom_nav_v2", new BottomViewModel$addExtraSlices$1(r8));
        L21:
            if (r2 == null) goto L25;
            r2.d();
            return;
        L25:
            return;
        L8:
            r2 = null;
            goto L9
        }
    }

    public static final class d implements com.bytedance.android.ecom.arch.slice.h {
        public final /* synthetic */ c a;
        public final /* synthetic */ String b;

        public final void f1(boolean r3) {
            c r4 = this.a;
            Function2<? super String, ? super Map<String, ? extends Object>, Unit> r0 = r4.h;
            if (r0 == null) goto L6;
            Unit r5 = (Unit) r0.invoke(this.b, r4.l);
            return;
        }

        public d(c r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.ViewModel
    public final void b() {
        this.k = false;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.ViewModel
    public final void e() {
        this.k = true;
    }

    public final void h() {
        Iterator<T> r0 = this.j.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.ecom.arch.slice.g) r0.next()).setSliceRebindTarget(null);
        goto L4
    L6:
        this.j.clear();
    }

    public final AddCartMeta i() {
        BottomButtonVO r0 = this.i;
        if (r0 == null) goto L7;
        BottomButtonMeta r1 = r0.getBottomButtonMeta();
        if (r1 == null) goto L7;
        return r1.getAddCartMeta();
    L7:
        return null;
    }

    public final void l() {
        this.l.put("cart_animating", Boolean.TRUE);
        Function2<? super String, ? super Map<String, ? extends Object>, Unit> r0 = this.h;
        if (r0 == null) goto L5;
        Unit r1 = (Unit) r0.invoke("std_deal_button", this.l);
    L5:
        this.l.put("cart_animating", Boolean.FALSE);
    }

    public c() {
        this.j = new IdentityHashMap();
        Boolean r1 = Boolean.FALSE;
        this.l = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("cart_animating", r1), TuplesKt.to("instant_cart_visible", r1), TuplesKt.to("is_android", Boolean.TRUE)});
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.ViewModel
    public final void c() {
        PdpDataStore r0 = getContext().d().getData();
        com.bytedance.android.shopping.prepurchase.arch.container.state.e r1 = (com.bytedance.android.shopping.prepurchase.arch.container.state.e) r0.l.getValue();
        com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e r2 = this.b;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycle");
    L5:
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(r1, r2, new b(this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e r3 = (com.bytedance.android.shopping.prepurchase.arch.container.state.e) r0.k.getValue();
        com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e r4 = this.b;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycle");
    L8:
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(r3, r4, new C0159c(this));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.ViewModel
    public final void d() {
        h();
    }

    public final void g(String r3) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        e0 r1 = (e0) ViewModel.a(this, e0.class);
        if (r1 == null) goto L13;
        Integer r2 = Integer.valueOf(r1.G0());
    L14:
        if (r2 == null) goto L25;
        int r4 = r2.intValue();
        if (r4 == 0) goto L21;
        if (r4 < 0) goto L21;
        int r5 = p0.a;
        String r6 = p0.b(r3, MapsKt.mapOf(TuplesKt.to("height_percent", String.valueOf(r2.intValue()))));
        if (r6 == null) goto L21;
    L22:
        if (r6 == null) goto L25;
        r3 = r6;
    L21:
        r6 = r3;
    L25:
        SlcCommonAction r7 = z.a(r3);
        Function1<? super SlcCommonAction, Unit> r8 = this.f;
        if (r8 == null) goto L29;
        Unit r9 = (Unit) r8.invoke(r7);
        return;
    L29:
        return;
    L13:
        r2 = null;
        goto L14
    L4:
        if (r3.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public final void m(int r3) {
        this.l.put("cart_num", Integer.valueOf(r3));
        Function2<? super String, ? super Map<String, ? extends Object>, Unit> r4 = this.h;
        if (r4 == null) goto L6;
        Unit r5 = (Unit) r4.invoke("std_deal_button", this.l);
        return;
    }

    public final void j(String r5, JSONObject r6) {
        if (r5 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L15;
        return;
    L15:
        LynxAbilityImpl r1 = getContext().e().D0();     // Catch: JSONException -> L12
        JSONObject r2 = new JSONObject();     // Catch: JSONException -> L12
        r2.put("cart_id", r5);     // Catch: JSONException -> L12
        r2.put("pdp_event_transparent_id", String.valueOf(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(getContext())).a.getNativeParams().getPdpEventTransparentId()));     // Catch: JSONException -> L12
        r2.put("toast_bar", r6);     // Catch: JSONException -> L12
        Unit r7 = Unit.INSTANCE;     // Catch: JSONException -> L12
        r1.B("ecom.pdp.add_cart", r2);     // Catch: JSONException -> L12
        return;
    L12:
        e = move-exception;
        getContext().c().ensureNotReachHere(e);
        return;
    L4:
        if (r5.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public final void k(com.bytedance.android.ecom.arch.slice.g r3, String r4) {
        d r0 = new d(this, r4);
        r3.setSliceRebindTarget(r0);
        this.j.put(r3, r0);
        if ((r3 instanceof p) == false) goto L10;
        List r5 = ((p) r3).a();
        if (r5 == null) goto L12;
        Iterator r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L13;
        k((com.bytedance.android.ecom.arch.slice.g) r6.next(), r4);
        goto L8
    L13:
        return;
    L12:
        return;
    }
}
