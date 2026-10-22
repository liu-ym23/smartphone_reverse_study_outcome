package dc5;

import android.graphics.drawable.Drawable;
import com.bytedance.ee.bear.lark.tab.wiki.WikiTabView;
import com.larus.nova.R;
import com.ss.android.lark.widget.tab.MainTabItemView;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements MainTabItemView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiTabView f467882a;

    @Override // com.ss.android.lark.widget.tab.MainTabItemView.b
    public final Drawable getDrawable() {
        return this.f467882a.getResources().getDrawable(R.drawable.ud_icon_tab_wiki_colorful);
    }

    public a(WikiTabView r100) {
        this.f467882a = r100;
    }
}
