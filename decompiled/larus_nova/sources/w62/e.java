package w62;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.model.l;
import com.bytedance.android.livesdk.interactivity.comment.input.view.LiveVideoCommentSearchVideoViewHolder;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveVideoCommentSearchVideoViewHolder f558408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f558409b;

    public e(LiveVideoCommentSearchVideoViewHolder r100, l r101) {
        this.f558408a = r100;
        this.f558409b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f558408a.f135203o.O80(this.f558409b);
    }
}
