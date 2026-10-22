package d15;

import com.bytedance.ee.bear.document.editionmanager.EditionViewModel;
import com.bytedance.ee.bear.document.editionmanager.panel.EditionListFragment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h implements EditionViewModel.d {
    public final /* synthetic */ EditionListFragment a;

    public h(EditionListFragment r1) {
        this.a = r1;
    }

    public final void a(boolean r4, List<z05.g> r5) {
        this.a.j.setVisibility(8);
        this.a.k.setVisibility(8);
        if (((ArrayList) r5).size() != 0) goto L5;
        this.a.l.setVisibility(0);
        return;
    L5:
        EditionListFragment r0 = this.a;
        if (r0.m == null) goto L8;
        Collections.sort(r5, new c());
        r0.m.d.submitList(r5);
    L8:
        this.a.i.setVisibility(0);
        if (r4 == false) goto L11;
        this.a.i.s();
        return;
    L11:
        this.a.i.t();
    }
}
