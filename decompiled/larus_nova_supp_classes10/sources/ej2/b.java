package ej2;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.livesdk.livecommerce.playback.widget.VideoPlaybackSeekBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements View.OnTouchListener {
    public final /* synthetic */ VideoPlaybackSeekBar a;

    public b(VideoPlaybackSeekBar r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r12, MotionEvent r13) {
        Rect r14 = new Rect();
        this.a.getHitRect(r14);
        if (r13.getAction() == 0) goto L5;
    L9:
        float r9 = r14.top + (r14.height() / 2);
        float r0 = r13.getX() - r14.left;
        if (r0 >= 0) goto L13;
        float r8 = 0.0f;
    L17:
        return this.a.onTouchEvent(MotionEvent.obtain(r13.getDownTime(), r13.getEventTime(), r13.getAction(), r8, r9, r13.getMetaState()));
    L13:
        if (r0 <= r14.width()) goto L15;
        r8 = r14.width();
        goto L17
    L15:
        r8 = r0;
        goto L17
    L5:
        if (r13.getX() >= r14.left) goto L7;
    L8:
        return false;
    L7:
        if (r13.getX() <= r14.right) goto L9;
        goto L8
    }
}
