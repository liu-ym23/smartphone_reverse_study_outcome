package zd5;

import com.bytedance.ee.bear.list.cache.FolderSortStrategy;

/* JADX INFO: loaded from: classes18.dex */
public abstract class b implements g {
    public b() {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public void create() {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public void destroy() {
    }

    @Override // zd5.g
    public final void g0(FolderSortStrategy r100, ce5.a r101) {
        if (r100 == null) goto L5;
        ((mc5.j) r101.a(mc5.j.class)).D3(r100);
        return;
    }
}
