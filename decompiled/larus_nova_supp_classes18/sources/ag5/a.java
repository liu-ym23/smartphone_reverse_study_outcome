package ag5;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.bytedance.ee.bear.middleground.feed.export.bean.MultiBean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface a<MultiViewHolder extends RecyclerView.ViewHolder, Data extends MultiBean> {
    int b();

    MultiViewHolder c(RecyclerView.Adapter r1, ViewGroup r2);

    void d(RecyclerView.Adapter r1, MultiViewHolder r2, int r3, Data r4, boolean r5);
}
