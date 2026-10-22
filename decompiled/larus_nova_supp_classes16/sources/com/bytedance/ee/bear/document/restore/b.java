package com.bytedance.ee.bear.document.restore;

import androidx.lifecycle.Observer;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ DocDeletedCtrlView a;

    public b(DocDeletedCtrlView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        Boolean r5 = (Boolean) r4;
        DocDeletedView r0 = this.a.c;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r5);
        r0.setRestoreVisible(r5.booleanValue());
    L5:
        int r1 = d.a;
        Intrinsics.checkNotNull(r5);
        boolean r6 = r5.booleanValue();
        HashMap<String, Object> r2 = this.a.e;
        if (r2 == null) goto L10;
        HashMap r3 = new HashMap();
        r3.putAll(r2);
        r3.put("is_recover_button_show", String.valueOf(r6));
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).n("ccm_docs_delete_view", r3);
        return;
    }
}
