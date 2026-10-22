package i82;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.android.livesdk.chatroom.msgboard.VSMsgBoardDress;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.adapter.VSMsgBoardBadgeViewHolder;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f488588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f488589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ VSMsgBoardDress f488590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ VSMsgBoardBadgeViewHolder f488591d;

    public c(a r100, boolean r101, VSMsgBoardDress r102, VSMsgBoardBadgeViewHolder r103) {
        this.f488588a = r100;
        this.f488589b = r101;
        this.f488590c = r102;
        this.f488591d = r103;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        int r102 = r101.getAction();
        if (r102 != 0) goto L5;
        r100.setAlpha(0.8f);
    L18:
        return true;
    L5:
        if (r102 != 1) goto L7;
        r100.setAlpha(1.0f);
        if ((r101.getEventTime() - r101.getDownTime()) >= ViewConfiguration.getLongPressTimeout()) goto L18;
        if (this.f488589b == true) goto L15;
        this.f488588a.f488580c = String.valueOf(this.f488590c.getDressId());
    L15:
        this.f488588a.f488582e.i(this.f488590c);
        this.f488588a.f513439a.notifyDataSetChanged();
        a.j(this.f488588a, 300, this.f488591d, this.f488590c);
        return true;
    L7:
        if (r102 != 3) goto L18;
        r100.setAlpha(1.0f);
        goto L18
    }
}
