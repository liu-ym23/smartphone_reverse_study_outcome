package com.bytedance.ee.bear.middleground.feed.multi;

import ag5.a;
import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.middleground.feed.export.bean.MultiBean;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import iu5.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes18.dex */
public class MultiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, a<? extends RecyclerView.ViewHolder, ?>> f232615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray<a<? extends RecyclerView.ViewHolder, ?>> f232616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<MultiBean> f232617c;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f232617c).size();
    }

    public MultiAdapter() {
        this.f232615a = new HashMap();
        this.f232616b = new SparseArray();
        this.f232617c = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        Map<Class<?>, a<? extends RecyclerView.ViewHolder, ?>> r101 = this.f232615a;
        HashMap r102 = (HashMap) r101;
        return ((a) r102.get(((MultiBean) ListProtector.get(this.f232617c, r100)).getAdapterType())).b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        a<? extends RecyclerView.ViewHolder, ?> r102 = this.f232616b.get(getItemViewType(r101));     // Catch: Exception -> L10
        if (r102 == null) goto L18;
        MultiBean r103 = (MultiBean) ListProtector.get(this.f232617c, r101);     // Catch: Exception -> L10
        if (r101 != (((ArrayList) this.f232617c).size() - 1)) goto L7;
        boolean r104 = true;
    L8:
        r102.d(this, r100, r101, r103, r104);     // Catch: Exception -> L10
        return;
    L7:
        r104 = false;
        goto L8
    L18:
        return;
    L10:
        e = move-exception;
        SparseArray<a<? extends RecyclerView.ViewHolder, ?>> r105 = this.f232616b;
        if (r105 == null) goto L14;
        tt5.a.d("MultiAdapter", r105.toString());
    L14:
        d.a("MultiAdapter", e);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        a<? extends RecyclerView.ViewHolder, ?> r102 = this.f232616b.get(r101);
        if (r102 == null) goto L7;
        return r102.c(this, r100);
    L7:
        throw new RuntimeException("Can't found viewType = " + r101 + " . Please add this type");
    }

    public final void y2(Class<?> r100, a<? extends RecyclerView.ViewHolder, ?> r101) {
        tt5.a.h("MultiAdapter", "add type:" + r100.getName() + " adapter:" + r101.toString());
        ((HashMap) this.f232615a).put(r100, r101);
        this.f232616b.put(r101.b(), r101);
    }
}
