package com.larus.drive.sdk.impl.view.chat.fileselect;

import com.baidu.platform.comapi.map.MapController;
import com.larus.drive.sdk.impl.view.chat.fileselect.adapter.ChatFileSelectedAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class o implements ChatFileSelectedAdapter.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChatFileSelectedListDialog f342206a;

    public o(ChatFileSelectedListDialog r100) {
        this.f342206a = r100;
    }

    @Override // com.larus.drive.sdk.impl.view.chat.fileselect.adapter.ChatFileSelectedAdapter.a
    public final void a(x79.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Iterator<T> r101 = this.f342206a.f342106f.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(((com.larus.platform.api.u) r102).f365280a, r100.f562830a) == false) goto L4;
    L9:
        com.larus.platform.api.u r103 = (com.larus.platform.api.u) r102;
        if (r103 != null) goto L12;
        return;
    L12:
        aq9.c r104 = this.f342206a.f342108h;
        if (r104 == null) goto L15;
        r104.a(r103);
    L15:
        ChatFileSelectedListDialog r105 = this.f342206a;
        List<com.larus.platform.api.u> r106 = r105.f342106f;
        ArrayList r107 = new ArrayList();
        Iterator<T> r108 = r106.iterator();
    L17:
        if (r108.hasNext() == false) goto L21;
        Object r109 = r108.next();
        if (Intrinsics.areEqual(((com.larus.platform.api.u) r109).f365280a, r100.f562830a) == true) goto L17;
        r107.add(r109);
        goto L17
    L21:
        r105.f342106f = r107;
        return;
    L8:
        r102 = null;
        goto L9
    }
}
