package cc3;

import android.view.View;
import com.bytedance.android.shopping.commentgallery.view.CommentGalleryVideoVHNew;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ CommentGalleryVideoVHNew a;

    public e(CommentGalleryVideoVHNew r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        if (this.a.c.h() == false) goto L5;
        this.a.T3();
        return;
    L5:
        this.a.play();
    }
}
