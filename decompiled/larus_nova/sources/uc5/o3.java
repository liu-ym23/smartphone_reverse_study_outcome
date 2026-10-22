package uc5;

import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.folder.FolderSort;
import com.bytedance.ee.bear.list.sort.FilterType;

/* JADX INFO: loaded from: classes18.dex */
public final class o3 extends g {
    @Override // mc5.k
    public final FolderSortStrategy getFilter() {
        tt5.a.h("PersonalRootListCache", "getFilter()...");
        FolderSortStrategy r100 = ((mc5.j) this.f512885a.a(mc5.j.class)).m1(RootDescription.ROOT_ELEMENT);
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new FolderSortStrategy(RootDescription.ROOT_ELEMENT, FilterType.ALL.getType(), "", "", FolderSort.NAME.getRank(), true);
    }

    public o3(ce5.a r100) {
        super("", r100);
    }
}
