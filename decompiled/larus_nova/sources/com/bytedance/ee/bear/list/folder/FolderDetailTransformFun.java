package com.bytedance.ee.bear.list.folder;

import androidx.arch.core.util.Function;
import com.bytedance.ee.bear.list.dto.Document;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mc5.u1;
import uc5.u0;

/* JADX INFO: loaded from: classes18.dex */
public class FolderDetailTransformFun implements Function<List<u1>, ArrayList<Document>> {
    public FolderDetailTransformFun() {
    }

    public final ArrayList<Document> a(List<u1> r100) {
        ArrayList<Document> r101 = new ArrayList();
        if (hu5.a.d(r100) == false) goto L6;
        tt5.a.h("FolderDetailTransformFun", "TransformFun#apply()...input is empty");
        return r101;
    L6:
        ArrayList r102 = new ArrayList();
        ArrayList r103 = new ArrayList();
        ArrayList r104 = new ArrayList();
        Iterator<u1> r105 = r100.iterator();
    L8:
        if (r105.hasNext() == false) goto L25;
        Document r106 = u1.a(r105.next());
        if (u1.h(r106) == false) goto L8;
        if (r106.getType() == sbb.e.f541295f.f541317b) goto L14;
        if (r106.f227909y2 == true) goto L17;
        r104.add(r106);
        goto L8
    L17:
        r103.add(r106);
        goto L8
    L14:
        r102.add(r106);
        goto L8
    L25:
        Collections.sort(r103, new u0());     // Catch: Exception -> L21
    L23:
        r101.addAll(r102);
        r101.addAll(r103);
        r101.addAll(r104);
        return r101;
    L21:
        e = move-exception;
        tt5.a.f("FolderDetailTransformFun", e, false);
        goto L23
    }

    @Override // androidx.arch.core.util.Function
    public final /* bridge */ /* synthetic */ ArrayList<Document> apply(List<u1> r100) {
        return a(r100);
    }
}
