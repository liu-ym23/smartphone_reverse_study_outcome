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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class MultiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final Map<Class<?>, a<? extends RecyclerView.ViewHolder, ?>> a;
    public final SparseArray<a<? extends RecyclerView.ViewHolder, ?>> b;
    public final List<MultiBean> c;

    public final int getItemCount() {
        return ((ArrayList) this.c).size();
    }

    public MultiAdapter() {
        this.a = new HashMap();
        this.b = new SparseArray();
        this.c = new ArrayList();
    }

    public final int getItemViewType(int r3) {
        Map<Class<?>, a<? extends RecyclerView.ViewHolder, ?>> r0 = this.a;
        HashMap r1 = (HashMap) r0;
        return ((a) r1.get(((MultiBean) ListProtector.get(this.c, r3)).getAdapterType())).b();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9) {
        a<? extends RecyclerView.ViewHolder, ?> r1 = this.b.get(getItemViewType(r9));     // Catch: Exception -> L10
        if (r1 == null) goto L18;
        MultiBean r5 = (MultiBean) ListProtector.get(this.c, r9);     // Catch: Exception -> L10
        if (r9 != (((ArrayList) this.c).size() - 1)) goto L7;
        boolean r6 = true;
    L8:
        r1.d(this, r8, r9, r5, r6);     // Catch: Exception -> L10
        return;
    L7:
        r6 = false;
        goto L8
    L18:
        return;
    L10:
        e = move-exception;
        SparseArray<a<? extends RecyclerView.ViewHolder, ?>> r10 = this.b;
        if (r10 == null) goto L14;
        tt5.a.d("MultiAdapter", r10.toString());
    L14:
        d.a("MultiAdapter", e);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        a<? extends RecyclerView.ViewHolder, ?> r0 = this.b.get(r4);
        if (r0 == null) goto L7;
        return r0.c(this, r3);
    L7:
        throw new RuntimeException("Can't found viewType = " + r4 + " . Please add this type");
    }

    public final void y2(Class<?> r3, a<? extends RecyclerView.ViewHolder, ?> r4) {
        tt5.a.h("MultiAdapter", "add type:" + r3.getName() + " adapter:" + r4.toString());
        ((HashMap) this.a).put(r3, r4);
        this.b.put(r4.b(), r4);
    }
}
