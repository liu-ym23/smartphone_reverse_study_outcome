package f20;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

/* JADX INFO: loaded from: classes45.dex */
public interface a<T, V extends RecyclerView.ViewHolder> extends c {
    V a(LayoutInflater r100, ViewGroup r101);

    void d(V r100, T r101);
}
