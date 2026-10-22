package eo5;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.templates.data.CategoryTab;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f473317a;

    public b(c r100) {
        this.f473317a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        String r101 = (String) r100;
        Intrinsics.checkNotNullParameter(r101, "token");
        c r102 = this.f473317a;
        CategoryTab r103 = r102.f473320n.f239376i;
        if (r103 == null) goto L17;
        Iterator<T> r104 = r103.getCategoryList().iterator();
    L6:
        if (r104.hasNext() == false) goto L26;
        ao5.a r105 = (ao5.a) r104.next();
        Iterator<T> r106 = r105.f15786c.iterator();
    L9:
        if (r106.hasNext() == false) goto L13;
        T r107 = r106.next();
        if (Intrinsics.areEqual(r101, ((TemplateV4) r107).getObjToken()) == false) goto L9;
    L14:
        TemplateV4 r108 = r107;
        if (r108 == null) goto L6;
        r105.f15786c.remove(r108);
        r102.f473320n.w3(r103);
        goto L6
    L13:
        r107 = (T) null;
        goto L14
    L26:
        return;
    }
}
