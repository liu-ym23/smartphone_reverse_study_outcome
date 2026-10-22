package r95;

import android.view.MotionEvent;
import com.bytedance.ee.bear.drive.view.preview.imageviewer.PhotoViewContainer;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout;

/* JADX INFO: loaded from: classes16.dex */
public final class w implements CommentRectLayout.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PhotoViewContainer f536735a;

    @Override // com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout.c
    public final /* synthetic */ void a() {
    }

    @Override // com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout.c
    public final /* synthetic */ void onTouchEvent(MotionEvent r100) {
    }

    @Override // com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout.c
    public final void b() {
        this.f536735a.f225009f.liveInnerSetSwipeEnable().postValue(true);
    }

    @Override // com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout.c
    public final void c() {
        this.f536735a.f225009f.liveInnerForceFullScreen().postValue(Boolean.FALSE);
    }

    @Override // com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout.c
    public final void e() {
        this.f536735a.f225009f.liveInnerCreateNewComment().postValue(Boolean.TRUE);
    }

    public w(PhotoViewContainer r100) {
        this.f536735a = r100;
    }

    @Override // com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout.c
    public final void d(boolean r100) {
        this.f536735a.f225009f.liveInnerSetSwipeEnable().postValue(Boolean.valueOf(!r100));
        this.f536735a.f225009f.liveInnerAreaCommentActive().postValue(Boolean.valueOf(r100));
        if (r100 == false) goto L5;
        this.f536735a.f225012i.a(2.0f, true);
    L6:
        this.f536735a.e();
        return;
    L5:
        this.f536735a.f225012i.a(1.0f, true);
        goto L6
    }
}
