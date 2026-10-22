package com.bytedance.ee.bear.templates.center.list.base;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.templates.data.CategoryTab;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g<T> implements Observer {
    public final /* synthetic */ BaseTemplateListPresenter a;

    public g(BaseTemplateListPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r8) {
        String r9 = (String) r8;
        Intrinsics.checkNotNullParameter(r9, "hasDeletedToken");
        CategoryTab r0 = this.a.P8().s0();
        if (r0 == null) goto L17;
        BaseTemplateListPresenter r1 = this.a;
        Iterator<T> r2 = r0.getCategoryList().iterator();
    L6:
        if (r2.hasNext() == false) goto L26;
        ao5.a r3 = (ao5.a) r2.next();
        Iterator<T> r4 = r3.c.iterator();
    L9:
        if (r4.hasNext() == false) goto L13;
        T r5 = r4.next();
        if (Intrinsics.areEqual(r9, ((TemplateV4) r5).getObjToken()) == false) goto L9;
    L14:
        TemplateV4 r6 = r5;
        if (r6 == null) goto L6;
        r3.c.remove(r6);
        r1.P8().w3(r0);
        goto L6
    L13:
        r5 = (T) null;
        goto L14
    L26:
        return;
    }
}
