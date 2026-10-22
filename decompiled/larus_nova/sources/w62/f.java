package w62;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.model.j;
import com.bytedance.android.livesdk.chatroom.model.l;
import com.bytedance.android.livesdk.interactivity.comment.input.view.LiveVideoCommentSearchVideoViewHolder;

/* JADX INFO: loaded from: classes9.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveVideoCommentSearchVideoViewHolder f558410a;

    public f(LiveVideoCommentSearchVideoViewHolder r100) {
        this.f558410a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        l r101 = this.f558410a.f135199k;
        if (r101 == null) goto L10;
        j r102 = r101.f106959a;
        if (r102 == null) goto L11;
        Long r103 = r102.e();
        if (r103 == null) goto L12;
        long r104 = r103.longValue();
        this.f558410a.f135203o.Ip(r104);
        return;
    L12:
        return;
    L11:
        return;
    }
}
