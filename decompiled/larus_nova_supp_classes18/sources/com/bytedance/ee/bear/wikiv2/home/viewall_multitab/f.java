package com.bytedance.ee.bear.wikiv2.home.viewall_multitab;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ WikiSpaceListView a;

    public f(WikiSpaceListView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        List<? extends SpaceBean> r6 = (List) r5;
        WikiSpaceListView r0 = this.a;
        Intrinsics.checkNotNull(r6);
        int r1 = WikiSpaceListView.i;
        if (r0.getLoadingViewFromXml().getVisibility() != 0) goto L6;
        r0.getLoadingViewFromXml().setVisibility(8);
    L6:
        if (hu5.a.d(r6) == true) goto L8;
        r0.getContentViewFromXml().setVisibility(0);
        r0.getEmptyViewFromXml().setVisibility(8);
        r0.getRecyclerViewFromXml().setData(r6);
    L9:
        this.a.getContentViewFromXml().s();
        this.a.a();
        return;
    L8:
        r0.getContentViewFromXml().setVisibility(8);
        r0.getEmptyViewFromXml().setImageRes(2131232557);
        r0.getEmptyViewFromXml().setDesc(r0.getContext().getString(2131887474));
        r0.getEmptyViewFromXml().setVisibility(0);
        goto L9
    }
}
