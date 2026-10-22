package d15;

import com.bytedance.ee.bear.document.editionmanager.EditionViewModel;
import com.bytedance.ee.bear.document.editionmanager.panel.EditionListFragment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public final class h implements EditionViewModel.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EditionListFragment f466383a;

    public h(EditionListFragment r100) {
        this.f466383a = r100;
    }

    public final void a(boolean r100, List<z05.g> r101) {
        this.f466383a.f219659j.setVisibility(8);
        this.f466383a.f219660k.setVisibility(8);
        if (((ArrayList) r101).size() != 0) goto L5;
        this.f466383a.f219661l.setVisibility(0);
        return;
    L5:
        EditionListFragment r102 = this.f466383a;
        if (r102.f219662m == null) goto L8;
        Collections.sort(r101, new c());
        r102.f219662m.f219674d.submitList(r101);
    L8:
        this.f466383a.f219658i.setVisibility(0);
        if (r100 == false) goto L11;
        this.f466383a.f219658i.s();
        return;
    L11:
        this.f466383a.f219658i.t();
    }
}
