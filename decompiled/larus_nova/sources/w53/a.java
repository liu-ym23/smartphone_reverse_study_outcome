package w53;

import android.view.View;
import com.bytedance.android.shopping.anchorv3.comment.viewholder.CommentItemImageVH;
import zb3.e;

/* JADX INFO: loaded from: classes12.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentItemImageVH f558317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.shopping.anchorv3.comment.a f558318b;

    public a(CommentItemImageVH r100, com.bytedance.android.shopping.anchorv3.comment.a r101) {
        this.f558317a = r100;
        this.f558318b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        e r101 = this.f558317a.f164556b;
        if (r101 == null) goto L8;
        com.bytedance.android.shopping.anchorv3.comment.a r102 = this.f558318b;
        if (r102 == null) goto L9;
        r102.a(r101, r101.c(), this.f558317a.itemView, String.valueOf(r101.a()));
        return;
    L9:
        return;
    }
}
