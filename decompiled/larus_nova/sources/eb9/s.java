package eb9;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* JADX INFO: loaded from: classes29.dex */
public interface s {
    List<fb9.a> getAbilities();

    RecyclerView.Adapter<? extends RecyclerView.ViewHolder> getAdapter();

    String getId();

    void release();
}
