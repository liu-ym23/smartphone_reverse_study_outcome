package com.bytedance.ee.bear.list.folder;

import androidx.arch.core.util.Function;
import com.bytedance.ee.bear.list.dto.Document;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mc5.u1;
import uc5.u0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class FolderDetailTransformFun implements Function<List<u1>, ArrayList<Document>> {
    public FolderDetailTransformFun() {
    }

    public final ArrayList<Document> a(List<u1> r9) {
        ArrayList<Document> r0 = new ArrayList();
        if (hu5.a.d(r9) == false) goto L6;
        tt5.a.h("FolderDetailTransformFun", "TransformFun#apply()...input is empty");
        return r0;
    L6:
        ArrayList r1 = new ArrayList();
        ArrayList r3 = new ArrayList();
        ArrayList r4 = new ArrayList();
        Iterator<u1> r10 = r9.iterator();
    L8:
        if (r10.hasNext() == false) goto L25;
        Document r5 = u1.a(r10.next());
        if (u1.h(r5) == false) goto L8;
        if (r5.getType() == sbb.e.f.b) goto L14;
        if (r5.y2 == true) goto L17;
        r4.add(r5);
        goto L8
    L17:
        r3.add(r5);
        goto L8
    L14:
        r1.add(r5);
        goto L8
    L25:
        Collections.sort(r3, new u0());     // Catch: Exception -> L21
    L23:
        r0.addAll(r1);
        r0.addAll(r3);
        r0.addAll(r4);
        return r0;
    L21:
        e = move-exception;
        tt5.a.f("FolderDetailTransformFun", e, false);
        goto L23
    }

    public final /* bridge */ /* synthetic */ Object apply(Object r1) {
        return a((List) r1);
    }
}
