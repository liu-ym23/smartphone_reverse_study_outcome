package com.bytedance.ee.bear.list.share;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.homepage.banner.BannerAdapter;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class p3 extends com.bytedance.ee.bear.list.homepage.banner.c<BannerAdapter, com.bytedance.ee.bear.list.homepage.banner.g.a> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f229519j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList<Document> f229520k;

    @Override // com.bytedance.ee.bear.list.homepage.banner.c
    public final String p() {
        return this.f228286a.getString(R.string.Doc_List_ShareFolders);
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.c
    public final void s() {
        super.s();
        this.f229519j = (TextView) this.f228287b.findViewById(R.id.list_banner_tv_empty);
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.g
    public final void l0(ArrayList<Document> r100) {
        this.f229520k.clear();
        if (CollectionUtils.isEmpty(r100) == false) goto L6;
        this.f228290e.setVisibility(8);
        this.f229519j.setVisibility(0);
        this.f228291f.setNewData(new ArrayList());
        return;
    L6:
        this.f229520k.addAll(r100);
        this.f228290e.setVisibility(0);
        this.f229519j.setVisibility(8);
        int r101 = h();
        List<? extends Document> r102 = new ArrayList(r100.subList(0, Math.min(r100.size(), r101 * 3)));
        DiffUtil.calculateDiff(new ShareFolderItemDiffCallback(this.f228291f.getData(), r102)).dispatchUpdatesTo(this.f228291f);
        this.f228291f.setData(r102);
    }

    public p3(Context r100, View r101) {
        super(r100, r101);
        this.f229520k = new ArrayList();
    }
}
