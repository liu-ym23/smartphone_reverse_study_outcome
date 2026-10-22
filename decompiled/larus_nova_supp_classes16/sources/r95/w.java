package r95;

import android.view.MotionEvent;
import com.bytedance.ee.bear.drive.view.preview.imageviewer.PhotoViewContainer;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class w implements CommentRectLayout.c {
    public final /* synthetic */ PhotoViewContainer a;

    public final /* synthetic */ void a() {
    }

    public final /* synthetic */ void onTouchEvent(MotionEvent r1) {
    }

    public final void b() {
        this.a.f.liveInnerSetSwipeEnable().postValue(true);
    }

    public final void c() {
        this.a.f.liveInnerForceFullScreen().postValue(Boolean.FALSE);
    }

    public final void e() {
        this.a.f.liveInnerCreateNewComment().postValue(Boolean.TRUE);
    }

    public w(PhotoViewContainer r1) {
        this.a = r1;
    }

    public final void d(boolean r3) {
        this.a.f.liveInnerSetSwipeEnable().postValue(Boolean.valueOf(!r3));
        this.a.f.liveInnerAreaCommentActive().postValue(Boolean.valueOf(r3));
        if (r3 == false) goto L5;
        this.a.i.a(2.0f, true);
    L6:
        this.a.e();
        return;
    L5:
        this.a.i.a(1.0f, true);
        goto L6
    }
}
