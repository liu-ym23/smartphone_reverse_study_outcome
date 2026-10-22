package com.bytedance.android.shopping.commentv3.uitree.list.rvkit.viewholder;

import com.bytedance.android.shopping.commentv3.base.c;
import com.bytedance.android.shopping.commentv3.data.SortType;
import com.bytedance.android.shopping.commentv3.view.CommentSliceView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mc3.d;
import mc3.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/uitree/list/rvkit/viewholder/SortHeadViewHolder;", "Lcom/bytedance/android/shopping/commentv3/uitree/list/rvkit/viewholder/BaseSliceViewHolder;", "Lcom/bytedance/android/shopping/commentv3/view/CommentSliceView;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SortHeadViewHolder extends BaseSliceViewHolder<CommentSliceView> {
    @Override // com.bytedance.android.shopping.commentv3.uitree.list.rvkit.viewholder.BaseSliceViewHolder
    public final Map<String, Object> T3() {
        LinkedHashMap r0 = new LinkedHashMap();
        com.bytedance.android.shopping.commentv3.data.b r1 = this.c;
        if (r1 == null) goto L11;
        d r2 = r1.e;
        if (r2 == null) goto L11;
        e r3 = r2.c;
        if (r3 == null) goto L11;
        SortType r4 = r3.a();
        if (r4 == null) goto L11;
    L12:
        r0.put("sort_type", Integer.valueOf(r4.getType()));
        return r0;
    L11:
        r4 = SortType.DEFAULT;
        goto L12
    }

    public SortHeadViewHolder(CommentSliceView r2, c r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2, r3);
    }
}
