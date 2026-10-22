package com.bytedance.ee.bear.list.recent.subordinate;

import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.bear.list.folder.HomePersonalFragment;
import com.bytedance.ee.bear.list.homepage.title.SubMenuView;
import com.bytedance.ee.bear.list.sort.SortScene;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\b\u0010\u0006\u001a\u00020\u0007H\u0014J\b\u0010\b\u001a\u00020\tH\u0014J\b\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/list/recent/subordinate/SubordinateHomeFragment;", "Lcom/bytedance/ee/bear/list/folder/HomePersonalFragment;", "<init>", "()V", "getContentViewLayoutId", "", "getSortStrategyToken", "", "getSortScene", "Lcom/bytedance/ee/bear/list/sort/SortScene;", "hideUnderIcon", "", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubordinateHomeFragment extends HomePersonalFragment {
    @Override // com.bytedance.ee.bear.list.folder.HomePersonalFragment
    public final String ca0() {
        return "subordinate_recent";
    }

    @Override // com.bytedance.ee.bear.list.folder.HomePersonalFragment
    public final int getContentViewLayoutId() {
        return 2131564908;
    }

    @Override // com.bytedance.ee.bear.list.folder.HomePersonalFragment
    public final SortScene ba0() {
        SubMenuView r0 = this.o;
        if (r0 == null) goto L7;
        AppCompatImageView r1 = r0.d;
        if (r1 == null) goto L7;
        r1.setVisibility(8);
    L7:
        SubMenuView r2 = this.o;
        if (r2 == null) goto L13;
        TextView r3 = r2.a;
        if (r3 == null) goto L13;
        r3.setOnClickListener(null);
    L13:
        return SortScene.SubordinateSort;
    }

    public SubordinateHomeFragment() {
    }
}
