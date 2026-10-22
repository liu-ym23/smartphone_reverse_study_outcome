package yj6;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.live.photoviewer.photoviewer.video.VideoVH;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoVH f568094a;

    public a(VideoVH r100) {
        this.f568094a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        this.f568094a.f255675e.getParent().requestDisallowInterceptTouchEvent(true);
        return false;
    }
}
