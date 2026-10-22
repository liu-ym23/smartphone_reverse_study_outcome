package x90;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.emoji.widget.EmojiSelectPanel;
import com.bytedance.android.livesdk.widget.pager.GridPagerSnapHelper;

/* JADX INFO: loaded from: classes45.dex */
public final class b extends GridPagerSnapHelper {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ EmojiSelectPanel f562965h;

    public b(EmojiSelectPanel r100) {
        this.f562965h = r100;
    }

    @Override // com.bytedance.android.livesdk.widget.pager.GridPagerSnapHelper, com.bytedance.android.livesdk.widget.pager.SnapHelper
    public final View findSnapView(RecyclerView.LayoutManager r100) {
        View r101 = super.findSnapView(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        EmojiSelectPanel r102 = this.f562965h;
        r102.f68970f = r100.getPosition(r101);
        EmojiSelectPanel r103 = this.f562965h;
        EmojiSelectPanel.R5(r103, r103.f68970f);
        return r101;
    }

    @Override // com.bytedance.android.livesdk.widget.pager.GridPagerSnapHelper, com.bytedance.android.livesdk.widget.pager.SnapHelper
    public final int findTargetSnapPosition(RecyclerView.LayoutManager r100, int r101, int r102) {
        EmojiSelectPanel r103 = this.f562965h;
        r103.f68970f = super.findTargetSnapPosition(r100, r101, r102);
        EmojiSelectPanel r104 = this.f562965h;
        EmojiSelectPanel.R5(r104, r104.f68970f);
        return this.f562965h.f68970f;
    }
}
