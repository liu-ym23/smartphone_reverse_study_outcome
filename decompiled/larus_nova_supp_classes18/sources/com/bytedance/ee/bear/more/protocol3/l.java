package com.bytedance.ee.bear.more.protocol3;

import android.view.View;
import com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem;
import java.util.List;
import kotlin.Deprecated;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface l {
    @Deprecated(message = "call build() instead. ")
    k a(IBaseMoreItem r1, a r2, m r3);

    k b(f r1, e r2, List<? extends m> r3, List<? extends a> r4, View.OnClickListener r5);

    g buildHeader();
}
