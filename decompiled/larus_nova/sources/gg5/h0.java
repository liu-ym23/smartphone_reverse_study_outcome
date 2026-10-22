package gg5;

import com.bytedance.ee.bear.middleground.feed.export.bean.MultiBean;
import com.bytedance.ee.util.ui.RecyclerItemsDiff;

/* JADX INFO: loaded from: classes18.dex */
public final class h0 implements RecyclerItemsDiff.b<MultiBean> {
    public h0() {
    }

    @Override // com.bytedance.ee.util.ui.RecyclerItemsDiff.b
    public final boolean areContentsTheSame(MultiBean r100, MultiBean r101) {
        MultiBean r102 = r100;
        MultiBean r103 = r101;
        if ((r102 instanceof com.bytedance.ee.bear.middleground.feed.export.bean.d) == true) goto L5;
    L11:
        return false;
    L5:
        if ((r103 instanceof com.bytedance.ee.bear.middleground.feed.export.bean.d) == false) goto L11;
        if (r102.getClass() != r103.getClass()) goto L11;
        if (((com.bytedance.ee.bear.middleground.feed.export.bean.d) r102).contentSame(r103) == false) goto L11;
        return true;
    }

    @Override // com.bytedance.ee.util.ui.RecyclerItemsDiff.b
    public final boolean areItemsTheSame(MultiBean r100, MultiBean r101) {
        MultiBean r102 = r100;
        MultiBean r103 = r101;
        if ((r102 instanceof com.bytedance.ee.bear.middleground.feed.export.bean.d) == true) goto L5;
    L11:
        return false;
    L5:
        if ((r103 instanceof com.bytedance.ee.bear.middleground.feed.export.bean.d) == false) goto L11;
        if (r102.getClass() != r103.getClass()) goto L11;
        if (((com.bytedance.ee.bear.middleground.feed.export.bean.d) r102).isSameItem(r103) == false) goto L11;
        return true;
    }
}
