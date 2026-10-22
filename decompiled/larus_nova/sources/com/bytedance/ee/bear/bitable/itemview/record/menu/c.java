package com.bytedance.ee.bear.bitable.itemview.record.menu;

import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f214163a;

    public c(b r100) {
        this.f214163a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        if (r101 == null) goto L10;
        b r102 = this.f214163a;
        r102.f214161f = ((t45.c) k.a(LarkContext.getApplication(), t45.c.class)).A9(sbb.e.f541299j.getType(), r101);
        String r103 = r102.a();
        if (r103 == null) goto L11;
        vqb.a r104 = vqb.b.a();
        if (r104 == null) goto L12;
        r104.isExistFavoriteTab(r103, TabAppInfo.BizType.CCM, new Navigation$requestHasAddToNavigation$1$1(r102));
        return;
    L12:
        return;
    L11:
        return;
    }
}
