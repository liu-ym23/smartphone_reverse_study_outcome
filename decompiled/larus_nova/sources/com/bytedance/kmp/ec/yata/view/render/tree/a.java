package com.bytedance.kmp.ec.yata.view.render.tree;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import ga6.e;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakHashMap<View, String> f252108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, e> f252109b;

    public a() {
        this.f252108a = new WeakHashMap();
        this.f252109b = new LinkedHashMap();
    }

    @Override // com.bytedance.kmp.ec.yata.view.render.tree.b
    public final e b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "popupCode");
        return (e) ((LinkedHashMap) this.f252109b).get(r100);
    }

    @Override // com.bytedance.kmp.ec.yata.view.render.tree.b
    public final View c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "nodeKey");
        Iterator<Map.Entry<View, String>> r101 = this.f252108a.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L12;
        Map.Entry<View, String> r102 = r101.next();
        if (Intrinsics.areEqual(r102.getValue(), r100) == false) goto L4;
        View r103 = r102.getKey();
        if (r103.isAttachedToWindow() == false) goto L12;
        if (r103.getParent() == null) goto L12;
        return r103;
    L12:
        return null;
    }

    @Override // com.bytedance.kmp.ec.yata.view.render.tree.b
    public final void d(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f252109b.remove(r100);
    }

    @Override // com.bytedance.kmp.ec.yata.view.render.tree.b
    public final void e(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "nodeKey");
        if (r100 != null) goto L5;
        return;
    L5:
        this.f252108a.put(r100, r101);
    }

    @Override // com.bytedance.kmp.ec.yata.view.render.tree.b
    public final void f(String r100, Map<String, ? extends View> r101) {
        Intrinsics.checkNotNullParameter(r101, "viewMap");
        if (r100 != null) goto L5;
        return;
    L5:
        Map<String, e> r102 = this.f252109b;
        View r103 = r101.get("header");
        if ((r103 instanceof LinearLayout) == false) goto L8;
        LinearLayout r104 = (LinearLayout) r103;
    L8:
        View r105 = r101.get(ContainerPosition.FOOTER);
        if ((r105 instanceof LinearLayout) == false) goto L11;
        LinearLayout r106 = (LinearLayout) r105;
    L11:
        View r107 = r101.get(ContainerPosition.BODY);
        if ((r107 instanceof RecyclerView) == false) goto L14;
        RecyclerView r108 = (RecyclerView) r107;
    L15:
        r102.put(r100, new e(r108));
        return;
    L14:
        r108 = null;
        goto L15
    }
}
