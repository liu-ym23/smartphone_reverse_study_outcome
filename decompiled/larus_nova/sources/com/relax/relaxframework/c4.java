package com.relax.relaxframework;

import com.baidu.platform.comapi.map.MapController;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c4<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, ArrayList<n2<T>>> f405034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f405035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f405036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<? super T, ? super Integer, String> f405037d;

    public final void a(n2<T> r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        T r101 = r100.f405195c;
        int r102 = r100.f405197e;
        if (this.f405037d != null) goto L5;
        String r103 = "__relax@default";
    L6:
        ArrayList r104 = (ArrayList) ((LinkedHashMap) this.f405034a).get(r103);
        if (r104 != null) goto L9;
        r104 = com.bytedance.rts.foundation.j.k(new n2[0]);
        Map<String, ArrayList<n2<T>>> r105 = this.f405034a;
        Intrinsics.checkNotNull(r104);
        com.bytedance.rts.foundation.m.e(r105, r103, r104);
    L9:
        com.bytedance.rts.foundation.j.j(r104, r100);
        this.f405036c++;
        return;
    L5:
        r103 = (String) RelaxFrameworkKt.k0(new RecycleForItemPool$getReuseIdentifierForItem$1(this, r101, r102));
        goto L6
    }

    public c4(int r100, Function2<? super T, ? super Integer, String> r101) {
        this.f405034a = new LinkedHashMap();
        this.f405035b = r100;
        this.f405037d = r101;
    }
}
