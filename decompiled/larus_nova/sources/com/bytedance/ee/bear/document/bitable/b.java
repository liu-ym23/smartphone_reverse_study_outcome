package com.bytedance.ee.bear.document.bitable;

import com.bytedance.ee.bear.bitable.o;
import com.bytedance.ee.bear.contract.n;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements o {
    public b() {
    }

    @Override // com.bytedance.ee.bear.bitable.o
    public final String a(String r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return UriProtector.getQueryParameter(UriProtector.parse(r100), "docxToken");
    }

    @Override // com.bytedance.ee.bear.bitable.o
    public final void b(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "urls");
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L3:
        OfflineDoc r103 = null;
        if (r102.hasNext() == false) goto L17;
        String r104 = (String) r102.next();
        String r105 = a(r104);
        if (r105 != null) goto L8;
    L11:
        boolean r106 = true;
    L12:
        if (r106 == true) goto L15;
        r103 = new OfflineDoc(r105, r104, sbb.e.f541304o.f541317b, "base_instruction_docx");
    L15:
        if (r103 == null) goto L3;
        r101.add(r103);
        goto L3
    L8:
        if (r105.length() == 0) goto L11;
        r106 = false;
        goto L12
    L17:
        ((n) org.koin.java.a.c(n.class, null, null, 6)).g(r101);
    }
}
