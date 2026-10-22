package com.bytedance.ee.bear.search.picker;

import com.ss.android.lark.picker.config.condition.DocType;
import com.ss.android.lark.picker.config.condition.DocTypes;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class b {
    static {
    }

    public static DocTypes a() {
        com.bytedance.ee.bear.appsetting.c r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        boolean r101 = r100.h("lark.search.doc_support_miaoda");
        boolean r102 = r100.g("apaas.miaoda.migrate_to_ccm");
        if (r101 == false) goto L7;
        if (r102 == false) goto L7;
        return DocTypes.ALL.INSTANCE;
    L7:
        DocType[] r103 = DocType.values();
        ArrayList r104 = new ArrayList();
        int r105 = r103.length;
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L22;
        DocType r107 = r103[r106];
        if (r107 != DocType.ALL) goto L12;
    L17:
        boolean r108 = true;
    L18:
        if (r108 == true) goto L20;
        r104.add(r107);
    L20:
        r106 = r106 + 1;
        goto L8
    L12:
        if (r107 == DocType.MIAODA) goto L17;
        if (r107 == DocType.MIAODA_APP_DEVELOPMENT) goto L17;
        r108 = false;
        goto L18
    L22:
        return new DocTypes.NEW(CollectionsKt.toSet(r104));
    }
}
