package com.ss.android.lark.keyboard.edittext2.mdeditor.link;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v7b.n;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements b {
    public a() {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.mdeditor.link.b
    public final List<b.a> a(int r100, int r101, CharSequence r102) {
        Intrinsics.checkNotNullParameter(r102, "text");
        String r103 = r102.subSequence(r100, r101).toString();
        ArrayList r104 = new ArrayList();
        com.ss.android.lark.keyboard.edittext2.utils.b.a(r103, r104);
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator r106 = r104.iterator();
    L4:
        if (r106.hasNext() == false) goto L6;
        com.ss.android.lark.keyboard.edittext2.utils.b.a r107 = (com.ss.android.lark.keyboard.edittext2.utils.b.a) r106.next();
        String r108 = r107.f429250a;
        r105.add(new b.a(new n(r108, r108), r107.f429251b + r100, r107.f429252c + r100));
        goto L4
    L6:
        return r105;
    }
}
