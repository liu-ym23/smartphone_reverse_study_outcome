package zd5;

import com.bytedance.ee.bear.document.a4;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.sort.FilterType;
import com.bytedance.ee.bear.list.w4;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class a implements f {
    public final a4 a;
    public final boolean b;

    public final void create() {
    }

    public final void destroy() {
    }

    @Override // zd5.f
    public List<FilterType> G6() {
        ArrayList r0 = new ArrayList();
        r0.add(FilterType.ALL);
        r0.add(FilterType.DOC);
        r0.add(FilterType.SHEET);
        int r1 = qc5.a.a;
        ce5.a r2 = new ce5.a();
        Intrinsics.checkNotNullParameter(r2, "userComponentAbility");
        boolean r3 = r2.d.isCurrentEnable("ccm.mobile.slides_enabled");
        tt5.a.h("SpaceFeatureGatingV2", "isEnableSlides:" + r3);
        if (r3 == false) goto L5;
        r0.add(FilterType.SLIDES);
    L5:
        w4 r4 = w4.a();
        int r5 = sbb.e.i.b;
        if (((HashSet) r4.a).contains(Integer.valueOf(r5)) == false) goto L9;
        r0.add(FilterType.BITABLE);
    L9:
        if (this.a.a(sbb.e.k.b) == true) goto L11;
        r0.add(FilterType.MINDNOTE);
    L11:
        r0.add(FilterType.FILE);
        if (this.b == false) goto L14;
        r0.add(FilterType.FOLDER);
    L14:
        return r0;
    }

    public a(boolean r2) {
        this.a = (a4) org.koin.java.a.a(a4.class);
        this.b = r2;
    }

    @Override // zd5.f
    public final void g0(FolderSortStrategy r2, ce5.a r3) {
        if (r2 == null) goto L5;
        ((mc5.j) r3.a(mc5.j.class)).D3(r2);
        return;
    }
}
