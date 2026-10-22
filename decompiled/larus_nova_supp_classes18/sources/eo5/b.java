package eo5;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.templates.data.CategoryTab;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ c a;

    public b(c r1) {
        this.a = r1;
    }

    public final void onChanged(Object r8) {
        String r9 = (String) r8;
        Intrinsics.checkNotNullParameter(r9, ResourceData.KEY_TOKEN);
        c r0 = this.a;
        CategoryTab r1 = r0.n.i;
        if (r1 == null) goto L17;
        Iterator<T> r2 = r1.getCategoryList().iterator();
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
        r0.n.w3(r1);
        goto L6
    L13:
        r5 = (T) null;
        goto L14
    L26:
        return;
    }
}
