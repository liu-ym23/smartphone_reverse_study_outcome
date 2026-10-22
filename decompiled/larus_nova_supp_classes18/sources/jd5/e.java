package jd5;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.folder.FolderDetailItemDiffCallback;
import com.bytedance.ee.bear.list.homepage.banner.BannerAdapter;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e extends com.bytedance.ee.bear.list.homepage.banner.c<BannerAdapter, com.bytedance.ee.bear.list.homepage.banner.g.a> {
    @Override // com.bytedance.ee.bear.list.homepage.banner.c
    public final String p() {
        return this.a.getString(2131887934);
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.g
    public final void l0(ArrayList<Document> r3) {
        DiffUtil.calculateDiff(new FolderDetailItemDiffCallback(this.f.getData(), r3)).dispatchUpdatesTo(this.f);
        this.f.setData(r3);
    }

    public e(Context r1, View r2) {
        super(r1, r2);
    }
}
