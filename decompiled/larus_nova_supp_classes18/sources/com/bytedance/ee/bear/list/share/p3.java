package com.bytedance.ee.bear.list.share;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.homepage.banner.BannerAdapter;
import com.larksuite.framework.utils.CollectionUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p3 extends com.bytedance.ee.bear.list.homepage.banner.c<BannerAdapter, com.bytedance.ee.bear.list.homepage.banner.g.a> {
    public TextView j;
    public final ArrayList<Document> k;

    @Override // com.bytedance.ee.bear.list.homepage.banner.c
    public final String p() {
        return this.a.getString(2131887978);
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.c
    public final void s() {
        super.s();
        this.j = (TextView) this.b.findViewById(2131378072);
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.g
    public final void l0(ArrayList<Document> r4) {
        this.k.clear();
        if (CollectionUtils.isEmpty(r4) == false) goto L6;
        this.e.setVisibility(8);
        this.j.setVisibility(0);
        this.f.setNewData(new ArrayList());
        return;
    L6:
        this.k.addAll(r4);
        this.e.setVisibility(0);
        this.j.setVisibility(8);
        int r0 = h();
        List<? extends Document> r1 = new ArrayList(r4.subList(0, Math.min(r4.size(), r0 * 3)));
        DiffUtil.calculateDiff(new ShareFolderItemDiffCallback(this.f.getData(), r1)).dispatchUpdatesTo(this.f);
        this.f.setData(r1);
    }

    public p3(Context r1, View r2) {
        super(r1, r2);
        this.k = new ArrayList();
    }
}
