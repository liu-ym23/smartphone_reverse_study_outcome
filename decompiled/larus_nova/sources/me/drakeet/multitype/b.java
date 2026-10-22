package me.drakeet.multitype;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

/* JADX INFO: loaded from: classes42.dex */
public abstract class b<T, VH extends RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MultiTypeAdapter f513439a;

    public b() {
    }

    public long a(T r100) {
        return -1;
    }

    public abstract void b(VH r100, T r101);

    public abstract VH d(LayoutInflater r100, ViewGroup r101);

    public void e(VH r100) {
    }

    public void f(VH r100) {
    }

    public void g(VH r100) {
    }

    public void c(VH r100, T r101, List<Object> r102) {
        b(r100, r101);
    }
}
