package me.drakeet.multitype;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes42.dex */
public class MultiTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<?> f513437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f513438b;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f513437a.size();
    }

    public MultiTypeAdapter() {
        this(Collections.emptyList());
    }

    public MultiTypeAdapter(List<?> r100) {
        d r101 = new d();
        this.f513437a = r100;
        this.f513438b = r101;
    }

    public void A2(List<?> r100) {
        this.f513437a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        Object r101 = ListProtector.get(this.f513437a, r100);
        int r102 = getItemViewType(r100);
        return ((b) ListProtector.get(((d) this.f513438b).f513441b, r102)).a(r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        Object r101 = ListProtector.get(this.f513437a, r100);
        e r102 = this.f513438b;
        Class<?> r103 = r101.getClass();
        d r104 = (d) r102;
        int r105 = ((ArrayList) r104.f513440a).indexOf(r103);
        if (r105 != (-1)) goto L13;
        r105 = 0;
    L7:
        if (r105 >= ((ArrayList) r104.f513440a).size()) goto L12;
        if (((Class) ListProtector.get(r104.f513440a, r105)).isAssignableFrom(r103) == true) goto L13;
        r105 = r105 + 1;
        goto L7
    L12:
        r105 = -1;
    L13:
        if (r105 == (-1)) goto L17;
        ((c) ListProtector.get(((d) this.f513438b).f513442c, r105)).index();
        return r105 + 0;
    L17:
        throw new BinderNotFoundException(r101.getClass());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final boolean onFailedToRecycleView(RecyclerView.ViewHolder r100) {
        y2(r100).getClass();
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        y2(r100).e(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        y2(r100).f(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        y2(r100).g(r100);
    }

    public final b y2(RecyclerView.ViewHolder r100) {
        e r101 = this.f513438b;
        int r102 = r100.getItemViewType();
        return (b) ListProtector.get(((d) r101).f513441b, r102);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        throw new IllegalAccessError("You should not call this method. Call RecyclerView.Adapter#onBindViewHolder(holder, position, payloads) instead.");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        LayoutInflater r102 = LayoutInflater.from(r100.getContext());
        b r103 = (b) ListProtector.get(((d) this.f513438b).f513441b, r101);
        r103.f513439a = this;
        return r103.d(r102, r100);
    }

    public final <T> void z2(Class<? extends T> r100, b<T, ?> r101) {
        if (((d) this.f513438b).a(r100) == true) goto L5;
    L5:
        e r102 = this.f513438b;
        a r103 = new a();
        d r104 = (d) r102;
        ((ArrayList) r104.f513440a).add(r100);
        ((ArrayList) r104.f513441b).add(r101);
        ((ArrayList) r104.f513442c).add(r103);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List<Object> r102) {
        Object r103 = ListProtector.get(this.f513437a, r101);
        e r104 = this.f513438b;
        int r105 = r100.getItemViewType();
        ((b) ListProtector.get(((d) r104).f513441b, r105)).c(r100, r103, r102);
    }
}
