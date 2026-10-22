package yx7;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ixigua.lib.list.ListAdapter;
import com.ixigua.lib.list.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes23.dex */
public class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Object> f569423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ListAdapter f569424b;

    @Override // com.ixigua.lib.list.e
    public final int getItemCount() {
        return ((ArrayList) this.f569423a).size();
    }

    @Override // com.ixigua.lib.list.e
    public final List<Object> getItems() {
        return this.f569423a;
    }

    public a(ListAdapter r100) {
        this.f569424b = r100;
        this.f569423a = new ArrayList();
    }

    @Override // com.ixigua.lib.list.e
    public final Object a(int r100) {
        return CollectionsKt.getOrNull(this.f569423a, r100);
    }

    @Override // com.ixigua.lib.list.e
    public final void b(List<? extends Object> r100) {
        ((ArrayList) this.f569423a).clear();
        ArrayList r101 = (ArrayList) this.f569423a;
        r101.addAll(r100);
        this.f569424b.notifyDataSetChanged();
    }

    @Override // com.ixigua.lib.list.e
    public final void c(Object r100) {
        int r101 = getItemCount();
        ((ArrayList) this.f569423a).add(r100);
        this.f569424b.notifyItemInserted(r101);
    }

    @Override // com.ixigua.lib.list.e
    public final void d(int r100, Object r101) {
        if (r100 >= 0) goto L4;
    L6:
        boolean r102 = false;
    L7:
        if (r102 == true) goto L9;
        return;
    L9:
        if (r101 == ListProtector.get(this.f569423a, r100)) goto L11;
        ListProtector.remove(this.f569423a, r100);
        ListProtector.add(this.f569423a, r100, r101);
    L11:
        this.f569424b.notifyItemChanged(r100);
        return;
    L4:
        if (r100 >= ((ArrayList) this.f569423a).size()) goto L6;
        r102 = true;
        goto L7
    }
}
