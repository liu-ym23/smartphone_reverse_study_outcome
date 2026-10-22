package com.bytedance.ee.bear.document.bitable;

import com.bytedance.ee.bear.bitable.o;
import com.bytedance.ee.bear.contract.n;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements o {
    public b() {
    }

    public final String a(String r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return UriProtector.getQueryParameter(UriProtector.parse(r2), "docxToken");
    }

    public final void b(List<String> r7) {
        Intrinsics.checkNotNullParameter(r7, "urls");
        ArrayList r0 = new ArrayList();
        Iterator<T> r8 = r7.iterator();
    L3:
        OfflineDoc r2 = null;
        if (r8.hasNext() == false) goto L17;
        String r1 = (String) r8.next();
        String r3 = a(r1);
        if (r3 != null) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == true) goto L15;
        r2 = new OfflineDoc(r3, r1, sbb.e.o.b, "base_instruction_docx");
    L15:
        if (r2 == null) goto L3;
        r0.add(r2);
        goto L3
    L8:
        if (r3.length() == 0) goto L11;
        r4 = false;
        goto L12
    L17:
        ((n) org.koin.java.a.c(n.class, null, null, 6)).g(r0);
    }
}
