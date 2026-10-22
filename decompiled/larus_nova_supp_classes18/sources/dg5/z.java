package dg5;

import com.bytedance.ee.bear.middleground.feed.export.bean.MultiBean;
import com.bytedance.ee.util.ui.RecyclerItemsDiff;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class z implements RecyclerItemsDiff.b<MultiBean> {
    public z() {
    }

    public final boolean areContentsTheSame(Object r3, Object r4) {
        MultiBean r5 = (MultiBean) r3;
        MultiBean r6 = (MultiBean) r4;
        if ((r5 instanceof com.bytedance.ee.bear.middleground.feed.export.bean.d) == true) goto L5;
    L11:
        return false;
    L5:
        if ((r6 instanceof com.bytedance.ee.bear.middleground.feed.export.bean.d) == false) goto L11;
        if (r5.getClass() != r6.getClass()) goto L11;
        if (((com.bytedance.ee.bear.middleground.feed.export.bean.d) r5).contentSame(r6) == false) goto L11;
        return true;
    }

    public final boolean areItemsTheSame(Object r3, Object r4) {
        MultiBean r5 = (MultiBean) r3;
        MultiBean r6 = (MultiBean) r4;
        if ((r5 instanceof com.bytedance.ee.bear.middleground.feed.export.bean.d) == true) goto L5;
    L11:
        return false;
    L5:
        if ((r6 instanceof com.bytedance.ee.bear.middleground.feed.export.bean.d) == false) goto L11;
        if (r5.getClass() != r6.getClass()) goto L11;
        if (((com.bytedance.ee.bear.middleground.feed.export.bean.d) r5).isSameItem(r6) == false) goto L11;
        return true;
    }
}
