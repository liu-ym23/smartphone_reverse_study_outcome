package com.bytedance.android.shopping.commentfeed.viewholder;

import android.widget.SeekBar;
import com.bytedance.android.ec.model.response.anchorv3.PromotionVideoInfo;
import com.bytedance.android.shopping.extensions.b;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/commentfeed/viewholder/CommentVideoVH;", "Lcom/bytedance/android/shopping/commentfeed/viewholder/CommentBaseViewHolder;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentVideoVH extends CommentBaseViewHolder implements SeekBar.OnSeekBarChangeListener {
    public static final int d = 0;
    public PromotionVideoInfo b;
    public boolean c;

    public static final class a {
    }

    static {
        d = b.b(78);
    }

    @Override // com.bytedance.android.shopping.commentfeed.viewholder.CommentBaseViewHolder
    public final void T3() {
        throw null;
    }

    @Override // com.bytedance.android.shopping.commentfeed.viewholder.CommentBaseViewHolder
    public final void U3() {
        throw null;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar r1) {
        if (this.c == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar r1) {
        throw null;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar r1, int r2, boolean r3) {
        PromotionVideoInfo r4 = this.b;
        if (r4 == null) goto L10;
        r4.getDuration();
        if (r3 == true) goto L7;
        return;
    L7:
        if (this.c == true) goto L9;
        throw null;
    L9:
        throw null;
    }
}
