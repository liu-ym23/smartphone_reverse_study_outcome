package com.bytedance.ee.bear.search.picker;

import com.ss.android.lark.picker.config.condition.DocType;
import com.ss.android.lark.picker.config.condition.DocTypes;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    static {
    }

    public static DocTypes a() {
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        boolean r1 = r0.h("lark.search.doc_support_miaoda");
        boolean r2 = r0.g("apaas.miaoda.migrate_to_ccm");
        if (r1 == false) goto L7;
        if (r2 == false) goto L7;
        return DocTypes.ALL.INSTANCE;
    L7:
        DocType[] r3 = DocType.values();
        ArrayList r4 = new ArrayList();
        int r5 = r3.length;
        int r6 = 0;
    L8:
        if (r6 >= r5) goto L22;
        DocType r7 = r3[r6];
        if (r7 != DocType.ALL) goto L12;
    L17:
        boolean r8 = true;
    L18:
        if (r8 == true) goto L20;
        r4.add(r7);
    L20:
        r6 = r6 + 1;
        goto L8
    L12:
        if (r7 == DocType.MIAODA) goto L17;
        if (r7 == DocType.MIAODA_APP_DEVELOPMENT) goto L17;
        r8 = false;
        goto L18
    L22:
        return new DocTypes.NEW(CollectionsKt.toSet(r4));
    }
}
