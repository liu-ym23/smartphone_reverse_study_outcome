package w62;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.model.l;
import com.bytedance.android.livesdk.interactivity.comment.input.view.LiveVideoCommentSearchVideoViewHolder;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveVideoCommentSearchVideoViewHolder f558406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f558407b;

    public d(LiveVideoCommentSearchVideoViewHolder r100, l r101) {
        this.f558406a = r100;
        this.f558407b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f558406a.f135203o.cm(this.f558407b);
    }
}
