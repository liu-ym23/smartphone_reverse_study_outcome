package dt4;

import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.RenderForest;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.RenderItem;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.uikit.GroupHeaderData;
import com.bytedance.ee.bear.bitable.uikit.PullAction;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public interface b<T> extends ct4.d {
    PullAction A(int r100);

    List<RenderItem> J1(String r100);

    T W0(String r100);

    int X();

    void Z0(int r100);

    List<RenderItem> d0(RenderForest r100);

    Integer getIndex(String r100);

    void j1(HashMap<String, GroupHeaderData> r100);

    int o2();

    @Override // ct4.d
    boolean q(String r100);

    GroupHeaderData u(String r100);

    void z1(HashMap<String, T> r100);
}
