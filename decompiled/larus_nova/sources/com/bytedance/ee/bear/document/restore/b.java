package com.bytedance.ee.bear.document.restore;

import androidx.lifecycle.Observer;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DocDeletedCtrlView f221464a;

    public b(DocDeletedCtrlView r100) {
        this.f221464a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        DocDeletedView r102 = this.f221464a.f221413c;
        if (r102 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        r102.setRestoreVisible(r101.booleanValue());
    L5:
        int r103 = d.f221466a;
        Intrinsics.checkNotNull(r101);
        boolean r104 = r101.booleanValue();
        HashMap<String, Object> r105 = this.f221464a.f221415e;
        if (r105 == null) goto L10;
        HashMap r106 = new HashMap();
        r106.putAll(r105);
        r106.put("is_recover_button_show", String.valueOf(r104));
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).n("ccm_docs_delete_view", r106);
        return;
    }
}
