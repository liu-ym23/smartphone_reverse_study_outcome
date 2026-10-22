package tg3;

import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.action.b;
import com.bytedance.android.ecom.arch.slice.action.c;
import com.bytedance.android.ecom.arch.slice.g;
import com.bytedance.android.ecom.arch.slice.p;
import com.bytedance.android.ecom.arch.slice.slices.template.d;
import com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public final HashMap<String, Boolean> a;
    public final Set<String> b;
    public final f c;

    public a(f r2) {
        Intrinsics.checkNotNullParameter(r2, "sliceAbility");
        this.c = r2;
        this.a = new HashMap();
        this.b = new LinkedHashSet();
    }

    public final void a(List<? extends g> r10, boolean r11) {
        if (r10 == null) goto L36;
        Iterator<T> r12 = r10.iterator();
    L5:
        if (r12.hasNext() == false) goto L51;
        p r0 = (g) r12.next();
        if ((r0 instanceof d) == true) goto L8;
        if ((r0 instanceof p) == false) goto L5;
        a(r0.a(), r11);
        goto L5
    L8:
        d r1 = (d) r0;
        HashMap r2 = r1.a();
        if (r2 == null) goto L28;
        IAction r3 = (IAction) r2.get("async_fetch_data_action");
        if (r3 == null) goto L28;
        String r6 = r0.getSliceId();
        if (r6 == null) goto L28;
        Map r7 = ((d) r0).getConfig();
        if (r7 == null) goto L17;
        Object r8 = r7.get("ban_refresh");
    L18:
        Boolean r9 = Boolean.TRUE;
        if (Intrinsics.areEqual(r8, r9) == true) goto L21;
    L23:
        if (r11 == false) goto L25;
    L27:
        f r13 = this.c;
        c r14 = new c(null, null);
        b.h(r14, r0);
        Unit r15 = Unit.INSTANCE;
        f.a.a(r13, r3, r14, true, 4);
        goto L28
    L25:
        if (this.b.add(r6) == true) goto L27;
        return;
    L21:
        if (Intrinsics.areEqual(this.a.get(r6), r9) == false) goto L23;
        return;
    L17:
        r8 = null;
    L28:
        HashMap r4 = r1.a();
        if (r4 == null) goto L5;
        IAction r5 = (IAction) r4.get("takeout_lynx_listener");
        if (r5 == null) goto L5;
        f r16 = this.c;
        c r17 = new c(null, null);
        b.h(r17, r0);
        Unit r18 = Unit.INSTANCE;
        f.a.a(r16, r5, r17, true, 4);
        goto L5
    L51:
        return;
    }
}
