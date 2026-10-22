package com.bytedance.ee.bear.list.sidebar.homedrive.pinfolder.banner;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.homepage.banner.BannerAdapter;
import com.bytedance.ee.bear.list.homepage.banner.g;
import com.bytedance.ee.bear.list.sidebar.homedrive.pinfolder.PinFolderItemDiffCallback;
import com.larksuite.framework.utils.CollectionUtils;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends com.bytedance.ee.bear.list.homepage.banner.c<BannerAdapter, g.a> {
    public final ArrayList<Document> j;

    @Override // com.bytedance.ee.bear.list.homepage.banner.c
    public final String p() {
        return this.a.getString(2131887955);
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.g
    public final void l0(ArrayList<Document> r4) {
        this.j.clear();
        if (CollectionUtils.isEmpty(r4) == false) goto L6;
        o().setVisibility(8);
        k().setNewData(new ArrayList());
        return;
    L6:
        if (r4 == null) goto L9;
        this.j.addAll(r4);
        o().setVisibility(0);
        int r0 = h();
        ArrayList r2 = new ArrayList(r4.subList(0, RangesKt.coerceAtMost(r4.size(), r0)));
        DiffUtil.calculateDiff(new PinFolderItemDiffCallback(k().getData(), r2)).dispatchUpdatesTo(k());
        k().setData(r2);
        return;
    }

    public c(Context r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "rootView");
        super(r2, r3);
        this.j = new ArrayList();
    }
}
