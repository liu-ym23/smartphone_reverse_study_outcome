package be5;

import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.list.sort.FilterType;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import java.util.ArrayList;
import java.util.List;
import zd5.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends zd5.a {
    public final boolean c;
    public final boolean d;

    @Override // zd5.f
    public final List<q> x7() {
        return null;
    }

    @Override // zd5.a, zd5.f
    public final List<FilterType> G6() {
        ArrayList r0 = new ArrayList();
        if (this.c == false) goto L5;
        r0.add(FilterType.ALL);
        r0.add(FilterType.DOC);
        r0.add(FilterType.SHEET);
        r0.add(FilterType.MINDNOTE);
    L5:
        boolean r3 = true;
        if (c.a.a.i("ccm.spacekit.template.bitable.enable", true) == true) goto L8;
    L10:
        r3 = false;
    L11:
        tt5.a.h("TemplateFilterModelFactory", "filterBitableEnable = " + r3);
        if (r3 == false) goto L14;
        r0.add(FilterType.BITABLE);
    L14:
        return r0;
    L8:
        if (this.d == false) goto L10;
        goto L10
    }

    public b(boolean r1, BenefitStore r2) {
        super(r1);
        this.c = true;
        this.d = true;
        this.c = r2.hasBenefit("ccm_create_doc");
        this.d = r2.hasBenefit("ccm_create_base");
    }
}
