package dt4;

import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta.GroupPosition;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta.PullDataActionPayload;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta.RenderMeta;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta.RenderNode;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.uikit.GroupHeaderData;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public interface c<T> extends ct4.e {
    @Override // ct4.e
    boolean a(GroupPosition r100);

    PullDataActionPayload b(List<? extends GroupPosition> r100, boolean r101);

    void c(HashMap<String, T> r100);

    RenderMeta e();

    void f(GroupPosition r100);

    void g(List<? extends GroupPosition> r100);

    void h(List<? extends RenderNode> r100, HashMap<String, GroupHeaderData> r101, HashMap<String, T> r102);

    T i(GroupPosition r100);

    void j(boolean r100);

    GroupHeaderData k(GroupPosition r100);

    void l(RenderMeta r100, HashMap<String, GroupHeaderData> r101, HashMap<String, T> r102);

    List<GroupPosition> n();

    boolean o(GroupPosition r100);
}
