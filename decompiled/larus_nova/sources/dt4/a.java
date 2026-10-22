package dt4;

import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BaseViewSetting;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta.RenderNode;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.field.GridFieldHeaderData;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public interface a<T> extends i, c<T>, b<T> {
    GridFieldHeaderData J();

    void S1(BaseViewSetting r100);

    String V0(int r100);

    void X1(int r100, int r101);

    void Y1(HashMap<String, Boolean> r100);

    HashMap<String, Boolean> b1();

    void g1(List<? extends RenderNode> r100, boolean r101);

    int getScrollX();

    void q1(GridFieldHeaderData r100);

    void t1(int r100);
}
