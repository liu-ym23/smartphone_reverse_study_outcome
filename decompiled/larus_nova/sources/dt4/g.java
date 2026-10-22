package dt4;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.RenderItem;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta.GroupPosition;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public interface g {
    void a(GroupPosition r100);

    Integer b(GroupPosition r100);

    void c(int r100, int r101, boolean r102);

    void d();

    int e();

    void f();

    String getDocumentTraceId();

    RecyclerView getRecyclerView();

    void notifyDataSetChanged();

    void notifyItemRangeInserted(int r100, int r101);

    void notifyItemRangeRemoved(int r100, int r101);

    void setData(List<RenderItem> r100);

    void setFooter(SimpleItemModel r100);
}
