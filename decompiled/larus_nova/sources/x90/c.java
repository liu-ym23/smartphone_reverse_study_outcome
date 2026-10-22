package x90;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.emoji.widget.EmojiSelectPanel;

/* JADX INFO: loaded from: classes45.dex */
public final class c extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EmojiSelectPanel f562966a;

    public c(EmojiSelectPanel r100) {
        this.f562966a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r100, int r101) {
        if (r101 != 0) goto L4;
        return;
    L4:
        EmojiSelectPanel r102 = this.f562966a;
        EmojiSelectPanel.R5(r102, r102.f68970f);
        super.onScrollStateChanged(r100, r101);
    }
}
