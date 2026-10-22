package com.bytedance.locallife.dito.core.manager;

import com.bytedance.locallife.dito.Dito;
import com.bytedance.locallife.dito.data.DitoNode;
import com.bytedance.locallife.dito.utils.l;
import com.google.gson.JsonObject;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f257965a;

    public e() {
        Dito r100 = Dito.f257280a;
        this.f257965a = l.k().getDitoMergeDataWhenEmpty();
    }

    @Override // com.bytedance.locallife.dito.core.manager.d
    public final void a(DitoNode r100, DitoNode r101) {
        Intrinsics.checkNotNullParameter(r101, "newNode");
        boolean r102 = true;
        if (r100 == null) goto L11;
        com.bytedance.locallife.dito.data.d r103 = r100.getData();
        if (r103 == null) goto L11;
        JsonObject r104 = r103.f258198a;
        if (r104 == null) goto L11;
        if (r104.size() != 0) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L14;
        return;
    L14:
        com.bytedance.locallife.dito.data.d r106 = r101.getData();
        if (r106 == null) goto L21;
        JsonObject r107 = r106.f258198a;
        if (r107 == null) goto L21;
        if (r107.size() != 0) goto L21;
        boolean r108 = true;
    L22:
        if (r108 == false) goto L33;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        com.bytedance.locallife.dito.data.c r109 = r101.getConfig();
        if (r109 != null) goto L26;
    L28:
        r102 = false;
    L29:
        if (r102 == true) goto L33;
        if (this.f257965a == true) goto L33;
        return;
    L26:
        if (r109.e() != true) goto L28;
    L33:
        if (r100 == null) goto L50;
        com.bytedance.locallife.dito.data.d r110 = r100.getData();
        if (r110 == null) goto L56;
        JsonObject r111 = r110.f258198a;
        if (r111 == null) goto L58;
        com.bytedance.locallife.dito.data.d r112 = r101.getData();
        if (r112 == null) goto L57;
        JsonObject r113 = r112.f258198a;
        if (r113 == null) goto L59;
        Iterator<T> r114 = r111.keySet().iterator();
    L46:
        if (r114.hasNext() == false) goto L60;
        String r115 = (String) r114.next();
        if (r113.has(r115) == true) goto L46;
        r113.add(r115, r111.get(r115));
        goto L46
    L60:
        return;
    L59:
        return;
    L57:
        return;
    L58:
        return;
    L56:
        return;
    L50:
        return;
    L21:
        r108 = false;
    L11:
        r105 = false;
        goto L12
    }
}
