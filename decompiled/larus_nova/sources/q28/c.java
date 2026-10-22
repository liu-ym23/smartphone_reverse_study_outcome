package q28;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

/* JADX INFO: loaded from: classes24.dex */
public interface c<VH extends RecyclerView.ViewHolder> {
    long getHeaderId(int r100);

    int getItemCount();

    void onBindHeaderViewHolder(VH r100, int r101);

    VH onCreateHeaderViewHolder(ViewGroup r100);
}
