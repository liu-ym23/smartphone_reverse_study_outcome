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

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, Boolean> f545847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f545848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f545849c;

    public a(f r100) {
        Intrinsics.checkNotNullParameter(r100, "sliceAbility");
        this.f545849c = r100;
        this.f545847a = new HashMap();
        this.f545848b = new LinkedHashSet();
    }

    public final void a(List<? extends g> r110, boolean r111) {
        if (r110 == null) goto L36;
        Iterator<T> r112 = r110.iterator();
    L5:
        if (r112.hasNext() == false) goto L51;
        g r100 = (g) r112.next();
        if ((r100 instanceof d) == true) goto L8;
        if ((r100 instanceof p) == false) goto L5;
        a(((p) r100).a(), r111);
        goto L5
    L8:
        d r101 = (d) r100;
        HashMap<String, IAction> r102 = r101.a();
        if (r102 == null) goto L28;
        IAction r103 = r102.get("async_fetch_data_action");
        if (r103 == null) goto L28;
        String r104 = r100.getSliceId();
        if (r104 == null) goto L28;
        Map<String, Object> r105 = ((d) r100).getConfig();
        if (r105 == null) goto L17;
        Object r106 = r105.get("ban_refresh");
    L18:
        Boolean r107 = Boolean.TRUE;
        if (Intrinsics.areEqual(r106, r107) == true) goto L21;
    L23:
        if (r111 == false) goto L25;
    L27:
        f r108 = this.f545849c;
        c r109 = new c(null, null);
        b.h(r109, r100);
        Unit r113 = Unit.INSTANCE;
        f.a.a(r108, r103, r109, true, 4);
        goto L28
    L25:
        if (this.f545848b.add(r104) == true) goto L27;
        return;
    L21:
        if (Intrinsics.areEqual(this.f545847a.get(r104), r107) == false) goto L23;
        return;
    L17:
        r106 = null;
    L28:
        HashMap<String, IAction> r114 = r101.a();
        if (r114 == null) goto L5;
        IAction r115 = r114.get("takeout_lynx_listener");
        if (r115 == null) goto L5;
        f r116 = this.f545849c;
        c r117 = new c(null, null);
        b.h(r117, r100);
        Unit r118 = Unit.INSTANCE;
        f.a.a(r116, r115, r117, true, 4);
        goto L5
    L51:
        return;
    }
}
