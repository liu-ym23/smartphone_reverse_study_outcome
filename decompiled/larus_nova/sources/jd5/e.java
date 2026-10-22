package jd5;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.folder.FolderDetailItemDiffCallback;
import com.bytedance.ee.bear.list.homepage.banner.BannerAdapter;
import com.larus.nova.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
public final class e extends com.bytedance.ee.bear.list.homepage.banner.c<BannerAdapter, com.bytedance.ee.bear.list.homepage.banner.g.a> {
    @Override // com.bytedance.ee.bear.list.homepage.banner.c
    public final String p() {
        return this.f228286a.getString(R.string.Doc_List_My_Folder);
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.g
    public final void l0(ArrayList<Document> r100) {
        DiffUtil.calculateDiff(new FolderDetailItemDiffCallback(this.f228291f.getData(), r100)).dispatchUpdatesTo(this.f228291f);
        this.f228291f.setData(r100);
    }

    public e(Context r100, View r101) {
        super(r100, r101);
    }
}
