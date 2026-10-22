package com.bytedance.ee.bear.more.protocol3;

import android.view.View;
import com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem;
import java.util.List;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes18.dex */
public interface l {
    @Deprecated(message = "call build() instead. ")
    k a(IBaseMoreItem r100, a r101, m r102);

    k b(f r100, e r101, List<? extends m> r102, List<? extends a> r103, View.OnClickListener r104);

    g buildHeader();
}
