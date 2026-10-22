package com.bytedance.ee.bear.drive.biz.upload.uploadstatuslist.presenter;

import com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes16.dex */
public final class t implements Consumer<z65.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f223909a;

    public t(w r100) {
        this.f223909a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(z65.a r100) throws Exception {
        z65.a r101 = r100;
        if (SwipeMenuLayout.getViewCache() == null) goto L5;
        SwipeMenuLayout.getViewCache().f();
    L5:
        z65.d r102 = this.f223909a.f223914c;
        r102.getClass();
        tt5.a.h("UpdateListTAG", "remove complete status file");
        int r103 = r102.b(r101.f570483b);
        if (r103 != (-1)) goto L8;
    L10:
        z65.d r104 = this.f223909a.f223914c;
        Collections.sort(r104.f570505a, r104.f570506b);
        w r105 = this.f223909a;
        w.a(r105, r105.f223915d);
        this.f223909a.f223913b.sP();
        if (((ArrayList) this.f223909a.f223915d).size() != 0) goto L13;
        this.f223909a.f223913b.eH(false);
        w r106 = this.f223909a;
        r106.f223913b.e50(r106.f223915d);
    L13:
        tt5.a.h("UpdateListTAG", "delete = " + r101.f570483b);
        return;
    L8:
        if (r103 >= ((ArrayList) r102.f570505a).size()) goto L10;
        tt5.a.h("UpdateListTAG", "remove position " + r103);
        ListProtector.remove(r102.f570505a, r103);
        goto L10
    }
}
